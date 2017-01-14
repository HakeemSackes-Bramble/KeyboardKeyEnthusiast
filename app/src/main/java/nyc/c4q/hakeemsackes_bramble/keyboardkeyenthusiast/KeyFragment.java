package nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

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

    View root;
    RecyclerView recyclerView;
    FrameLayout fragLayout;
    List<Keys> keyslist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        getBoardData();
        root = inflater.inflate(R.layout.main_fragment, parent, false);
        fragLayout = (FrameLayout) root.findViewById(R.id.main_fragment);
        recyclerView = (RecyclerView) root.findViewById(R.id.key_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new KeysAdapter(keyslist));
        return root;
    }

    private void getBoardData() {
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
                keyslist = data.getAvailable_keys();
                System.out.println("it worked");
                Log.d("", "onResponse: post data " + data.isSuccess());
            }

            @Override
            public void onFailure(Call<KeyBoardData> call, Throwable t) {
                Log.d("error", t.getMessage());
                System.out.println("fail");
            }
        });
    }
}
