package nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_retrofit_call;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hakeemsackes-bramble on 1/11/17.
 */
public class KeyBoardData {
    boolean success;
    @SerializedName("available keys")
     List<Keys> available_keys;

    public List<Keys> getAvailable_keys() {
        return available_keys;
    }

    public void setAvailable_keys(List<Keys> available_keys) {
        this.available_keys = available_keys;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean sucess) {
        this.success = success;
    }
}
