package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.FriendViewHolder> {
    private final List<Friend> mListFriends;
    private ListFriendAdapter mSecondListFriendAdapter;


    ListFriendAdapter(List<Friend> listFriend) {
        mListFriends = listFriend;
    }

    public void setSecondListFriendAdapter(ListFriendAdapter secondAdapter) {
        mSecondListFriendAdapter = secondAdapter;
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemListFriend = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_friend_viewpage, parent, false);
        return new FriendViewHolder(itemListFriend);
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position) {
        Friend friend = mListFriends.get(position);
        holder.mTvName.setText(friend.getName());
        String NumOfFriend = friend.getNumberOfFriend() + "Friends";
        holder.mTvNumberOfFriend.setText(NumOfFriend);
        holder.mImgAvatar.setImageResource(friend.getAvatar());
    }

    @Override
    public int getItemCount() {
        return mListFriends.size();
    }

    class FriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mTvName;
        private final TextView mTvNumberOfFriend;
        private final Button mBtnFriend;
        private final ImageView mImgAvatar;

        private FriendViewHolder(View itemView) {
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
                    mSecondListFriendAdapter.notifyDataSetChanged();
                    if (friend.isFriend()) {
                        friend.setFriend(false);
                        FavoriteFragment.addFriend(friend);
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
