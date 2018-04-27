package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.DataHolder> {
    private List<String> mListInternal;
    private List<String> mListExternal;
    private static final int TITLE_INTERNAL = 0;
    private int mTitleExternal;

    StorageAdapter(List<String> listInternal, List<String> listExternal) {
        mListInternal = listInternal;
        mListExternal = listExternal;
    }

    @Override
    public StorageAdapter.DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_data_body_storage, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(StorageAdapter.DataHolder holder, int position) {
        mTitleExternal = mListInternal.size();
        holder.bindData(position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        return mListInternal.size() + mListExternal.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {
        private final TextView tvData;

        DataHolder(View itemView) {
            super(itemView);
            tvData = itemView.findViewById(R.id.tvData);
        }

        private void bindData(int position) {
            if (position == TITLE_INTERNAL || position == mTitleExternal) {
                tvData.setTextSize(20);
            }
            if (position < mListInternal.size()) {
                tvData.setText(mListInternal.get(position));
            } else {
                tvData.setText(mListExternal.get(position - mListInternal.size()));
            }
        }
    }
}
