package nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_recycler_view;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.R;
import nyc.c4q.hakeemsackes_bramble.keyboardkeyenthusiast.key_retrofit_call.Keys;

/**
 * Created by hakeemsackes-bramble on 1/11/17.
 */

public class KeysAdapter extends  RecyclerView.Adapter<KeysViewHolder> {
    List<Keys> keys;

    public KeysAdapter(List<Keys> keys) {
        this.keys= keys;
    }

    @Override
    public KeysViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        inflater.inflate(R.layout.key_layout, parent, false);
        return new KeysViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(KeysViewHolder holder, int position) {
        Keys key = keys.get(position);
        holder.keyName.setText(key.getKeyName());
        holder.keyName.setTextColor(Color.parseColor(key.getTextColor()));
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (keys != null) {
            count = keys.size();
        }
        return count;

    }
}
