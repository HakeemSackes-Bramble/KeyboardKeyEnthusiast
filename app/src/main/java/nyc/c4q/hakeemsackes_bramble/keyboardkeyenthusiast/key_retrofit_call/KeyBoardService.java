package nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_retrofit_call;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hakeemsackes-bramble on 1/11/17.
 */
public interface KeyBoardService {
    @GET("1_11_2017_exam.pl")
     Call<KeyBoardData> getKeyBoardData();
}
