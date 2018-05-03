package vn.asiantech.internship.database;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.R;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.Viewholder> {
    private List<Person> mListPerson;
    private IEventViewholderClick mEventPerson;

    TableAdapter(List<Person> data, IEventViewholderClick eventViewholderClick) {
        mListPerson = data;
        mEventPerson = eventViewholderClick;
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_database_person, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Person person = mListPerson.get(position);
        holder.updateInfo(person);
    }

    @Override
    public int getItemCount() {
        return mListPerson.size();
    }


    /*
        class viewholder in adapter
     */

    class Viewholder extends RecyclerView.ViewHolder {
        private final ImageView mImgBackground;
        private final TextView mTvAge;
        private final TextView mTvName;
        private static final String NAME = "Name";
        private static final String AGE = "Age";

        Viewholder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvNamePerson);
            mTvAge = itemView.findViewById(R.id.tvAgePerson);
            mImgBackground = itemView.findViewById(R.id.imgBackGroundPerson);
            mImgBackground.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Person person = mListPerson.get(position);
                    mEventPerson.onViewholderClick(person);
                }
            });
        }

        void updateInfo(Person person) {
            mTvAge.setText(String.format("%s: %s", AGE, String.valueOf(person.getAge())));
            mTvName.setText(String.format("%s: %s", NAME, person.getName()));
        }

    }


}
