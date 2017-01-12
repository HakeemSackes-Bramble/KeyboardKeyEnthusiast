package nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_retrofit_call;

import java.util.List;

/**
 * Created by hakeemsackes-bramble on 1/11/17.
 */
public class KeyBoardData {
    boolean sucess;
    List<Keys> available_keys;

    public List<Keys> getAvailable_keys() {
        return available_keys;
    }

    public void setAvailable_keys(List<Keys> available_keys) {
        this.available_keys = available_keys;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
