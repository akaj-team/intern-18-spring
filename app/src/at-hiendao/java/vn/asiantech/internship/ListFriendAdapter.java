package vn.asiantech.internship;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.ViewHolder> {

    private final List<Friend> mListFriend = new ArrayList<>();
    private final Context mContext;
    private IEventClick mEventClick;

    void removeFriend(int position) {

        if (mListFriend.size() > 0) {
            mListFriend.remove(position);
            notifyDataSetChanged();
        }
    }

    void addFriend(Friend friend) {
        mListFriend.add(friend);
        notifyDataSetChanged();
    }

    /*
        class viewholder of listview in recycleview
     */

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvName;
        private final TextView mTvMutualFriends;
        private static final String MUTUAL_FRIENDS = "mutual friends";
        private final ImageView mImgAvatar;
        private final Button mBtnFriend;
        private IEventClick mEventButtonFriendClick;
        private int mNumOfMutualFriends;

        ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvFriendName);
            mTvMutualFriends = itemView.findViewById(R.id.tvMutualFriends);
            mImgAvatar = itemView.findViewById(R.id.imgAvatar);
            mBtnFriend = itemView.findViewById(R.id.btnFriend);
            mBtnFriend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String btnFriendText = mBtnFriend.getText().toString();
                    if (btnFriendText.equals(mContext.getResources().getString(R.string.button_friend_text))) {
                        Friend friend = new Friend(mTvName.getText().toString(), mNumOfMutualFriends, false);
                        mEventButtonFriendClick.onButtonFriendClick(friend, true, getAdapterPosition());
                    } else {
                        Friend friend = new Friend(mTvName.getText().toString(), mNumOfMutualFriends, true);
                        mEventButtonFriendClick.onButtonFriendClick(friend, false, getAdapterPosition());
                    }


                }
            });
        }

        void setMutualFriends(int numbermutual) {
            mNumOfMutualFriends = numbermutual;
            mTvMutualFriends.setText(String.format(Locale.US, "%s %d", MUTUAL_FRIENDS, numbermutual));
        }

        void setEventButtonFriendClick(IEventClick eventClick) {
            mEventButtonFriendClick = eventClick;
        }

    }

    ListFriendAdapter(IEventClick eventClick, Context context) {
        createNewListFriends(true);
        mContext = context;
        mEventClick = eventClick;
    }

    ListFriendAdapter(IEventClick eventClick, Context context, boolean isfriend) {
        createNewListFriends(isfriend);
        mContext = context;
        mEventClick = eventClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_friend,
                parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Friend friend = mListFriend.get(position);
        holder.mTvName.setText(friend.getName());
        holder.setMutualFriends(friend.getNumOfMutualFriends());
        holder.mImgAvatar.setBackgroundColor(friend.getAvatar());
        boolean isFriend = friend.isFriend();
        if (!isFriend) {
            holder.mBtnFriend.setText(mContext.getResources().getString(R.string.button_friend));
        } else {
            holder.mBtnFriend.setText(mContext.getResources().getString(R.string.button_unfriend_text));
        }
        holder.setEventButtonFriendClick(mEventClick);

    }

    @Override
    public int getItemCount() {
        return mListFriend.size();
    }

    private void createNewListFriends(boolean isfriend) {
        int size;
        if (isfriend) {
            size = 0;
        } else {
            size = 15;
        }
        for (int i = 0; i < size; i++) {
            String name = "Friend" + i;
            int minRandom = 15;
            int maxRandom = 1000;
            Friend friend = new Friend(name, randomNumber(minRandom, maxRandom), false);
            mListFriend.add(friend);
        }
    }

    private int randomNumber(int min, int max) {
        int range = max - min + 1;
        return ((int) (Math.random() * range)) + min;
    }


}
