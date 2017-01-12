package nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_recycler_view.KeysAdapter;
import nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_retrofit_call.KeyBoardData;
import nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_retrofit_call.KeyBoardService;
import nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_retrofit_call.Keys;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hakeemsackes-bramble on 1/11/17.
 */

public class KeyFragment extends android.support.v4.app.Fragment {

    //keyslist;
    View root;
    RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        getBoardData(inflater, parent);
        return root;
    }

    private void getBoardData(final LayoutInflater inflater, final ViewGroup parent) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/cgi-bin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        KeyBoardService service = retrofit.create(KeyBoardService.class);
        Call<KeyBoardData> call = service.getKeyBoardData();
        call.enqueue(new Callback<KeyBoardData>() {
            @Override
            public void onResponse(Call<KeyBoardData> call, Response<KeyBoardData> response) {
                KeyBoardData data = response.body();

                List<Keys> keyslist = data.getAvailable_keys();

                root = inflater.inflate(R.layout.main_fragment, parent, false);
                recyclerView = (RecyclerView) root.findViewById(R.id.key_recyclerview);
                recyclerView.setAdapter(new KeysAdapter(keyslist));
                System.out.println("it worked");
                Log.d("", "onResponse: post data " + data.isSucess());

            }

            @Override
            public void onFailure(Call<KeyBoardData> call, Throwable t) {
                Log.d("error", t.getMessage());
                System.out.println("fail");
            }
        });
    }
}
