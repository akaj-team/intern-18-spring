package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.Friend;

public class ListFriendRequestAdapter extends RecyclerView.Adapter<ListFriendRequestAdapter.ListFriendViewHolder> {

    private final List<Friend> mListFriends;
    private ListFriendRequestAdapter mOtherAdapter;

    ListFriendRequestAdapter(List<Friend> listFriend) {
        mListFriends = listFriend;
    }

    public void setOtherAdapter(ListFriendRequestAdapter otherAdapter){
        mOtherAdapter = otherAdapter;
    }

    @Override
    public ListFriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_friend_fragment, parent, false);
        return new ListFriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListFriendRequestAdapter.ListFriendViewHolder holder, int position) {
        Friend friend = mListFriends.get(position);
        holder.mImgAvatar.setImageResource(friend.getAvatar());
        holder.mTvName.setText(friend.getName());
        String numOfFriend = friend.getNumberOfFriend() + "Friends";
        holder.mTvNumberOfFriend.setText(numOfFriend);
        if (friend.isFriend()) {
            holder.mBtnFriend.setText(R.string.unfriends);
        } else {
            holder.mBtnFriend.setText(R.string.add_friends);
        }
    }

    @Override
    public int getItemCount() {
        return mListFriends.size();
    }

    class ListFriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView mImgAvatar;
        private final TextView mTvNumberOfFriend;
        private final TextView mTvName;
        private final Button mBtnFriend;

        private ListFriendViewHolder(View itemView) {
            super(itemView);
            mImgAvatar = itemView.findViewById(R.id.imgAvatar);
            mTvNumberOfFriend = itemView.findViewById(R.id.tvNumOfFriend);
            mTvName = itemView.findViewById(R.id.tvName);
            mBtnFriend = itemView.findViewById(R.id.btnFriend);
            mBtnFriend.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnFriend: {
                    Friend friend = mListFriends.get(getAdapterPosition());
                    mListFriends.remove(getAdapterPosition());
                    mOtherAdapter.notifyDataSetChanged();
                    if (friend.isFriend()) {
                        friend.setFriend(false);
                        ListFriendRequestFragment.addFriend(friend);
                        notifyDataSetChanged();
                    } else {
                        friend.setFriend(true);
                        ListFriendFragment.addFriend(friend);
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
