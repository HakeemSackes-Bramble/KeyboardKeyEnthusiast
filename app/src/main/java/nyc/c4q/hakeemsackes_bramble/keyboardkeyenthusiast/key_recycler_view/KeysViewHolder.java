package nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.R;

/**
 * Created by hakeemsackes-bramble on 1/11/17.
 */
public class KeysViewHolder extends RecyclerView.ViewHolder {
    public TextView keyName;

    public KeysViewHolder(ViewGroup parent) {
        super(parent);
        keyName = (TextView) itemView.findViewById(R.id.key_name);
    }


}
