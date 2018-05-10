package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static String TAG = "PersonAdapter";
    private List<Person> mPersonList;
    private OnAdapterListenes mListenes;

    PersonAdapter(List<Person> mPersonList, OnAdapterListenes listenes) {
        this.mPersonList = mPersonList;
        this.mListenes = listenes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person_viewholder, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " + position);
        PersonViewHolder personViewHolder = (PersonViewHolder) holder;
        personViewHolder.binViewHolder(position);
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: " + mPersonList.size());
        return mPersonList.size();
    }

    /**
     * View Holder Item Person
     */
    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final static String TAG = "PersonViewHolder";
        private TextView mTvPersonName;
        private TextView mTvPersonAge;

        PersonViewHolder(View itemView) {
            super(itemView);

            initView(itemView);
            initEventView(itemView);
        }

        private void initEventView(View itemView) {
            itemView.setOnClickListener(this);
        }

        void initView(View itemView) {
            mTvPersonName = itemView.findViewById(R.id.tvPersonNameItem);
            mTvPersonAge = itemView.findViewById(R.id.tvPersonAgeItem);
        }

        void onClick() {

        }

        void binViewHolder(int position) {
            Person itemPerson = mPersonList.get(position);
            Log.e(TAG, "binViewHolder: " + position);
            Log.e(TAG, "idPerson: " + itemPerson.getId());
            mTvPersonAge.setText(String.valueOf(itemPerson.getAge()));
            mTvPersonName.setText(itemPerson.getName());
        }

        @Override
        public void onClick(View v) {
            int mSelectSinglePerson = getAdapterPosition();
            mListenes.onPorsonItemSelect(getAdapterPosition());
            Log.e(TAG, "onClick: " + mSelectSinglePerson);
        }
    }

    /**
     * Listenes Event Adapter
     */
    interface OnAdapterListenes {
        void onPorsonItemSelect(int position);
    }
}
