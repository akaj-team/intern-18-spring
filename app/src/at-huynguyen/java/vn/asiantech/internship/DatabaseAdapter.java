package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.ItemDatabase;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.ViewHolder> {
    private List<ItemDatabase> mListItemDatabase;

    DatabaseAdapter(List<ItemDatabase> listItemDatabase) {
        this.mListItemDatabase = listItemDatabase;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItemDatabase = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_database, parent, false);
        return new ViewHolder(listItemDatabase);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemDatabase itemDatabase = mListItemDatabase.get(position);
        holder.mTvNameDatabase.setText(itemDatabase.getNameDatabase());
        holder.mTvAgeDatabase.setText(String.valueOf(itemDatabase.getAgeDatabase()));

    }

    @Override
    public int getItemCount() {
        return mListItemDatabase.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvNameDatabase;
        private final TextView mTvAgeDatabase;

        ViewHolder(View itemView) {
            super(itemView);
            mTvNameDatabase = itemView.findViewById(R.id.tvNameDatabase);
            mTvAgeDatabase = itemView.findViewById(R.id.tvAgeDatabase);
        }
    }
}
