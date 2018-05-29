package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.Person;

public class TableUserAdapter extends RecyclerView.Adapter<TableUserAdapter.RowDataHolder> {
    private List<Person> mListUser;
    private OnRowTableUserClick mListener;

    TableUserAdapter(List<Person> listUser, OnRowTableUserClick listener) {
        mListUser = listUser;
        mListener = listener;
    }

    @Override
    public RowDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_data_user_sqlite, parent, false);
        return new RowDataHolder(view);
    }

    @Override
    public void onBindViewHolder(RowDataHolder holder, int position) {
        Person user = mListUser.get(position);
        String id = user.getId() + "";
        String age = user.getAge() + "";
        holder.mTvColumn1.setText(id);
        holder.mTvColumn2.setText(user.getName());
        holder.mTvColumn3.setText(age);
    }

    @Override
    public int getItemCount() {
        return mListUser.size();
    }

    class RowDataHolder extends RecyclerView.ViewHolder {
        private final TextView mTvColumn1;
        private final TextView mTvColumn2;
        private final TextView mTvColumn3;

        RowDataHolder(View itemView) {
            super(itemView);
            mTvColumn1 = itemView.findViewById(R.id.tvColumn1);
            mTvColumn2 = itemView.findViewById(R.id.tvColumn2);
            mTvColumn3 = itemView.findViewById(R.id.tvColumn3);
            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        mListener.onChooseUser(mListUser.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
}
