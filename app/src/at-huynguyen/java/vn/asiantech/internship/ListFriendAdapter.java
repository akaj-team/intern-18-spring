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
    private List<Friend> mListFriends;

    ListFriendAdapter(List<Friend> listFriend) {
        this.mListFriends = listFriend;
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

    public class FriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mTvName;
        private final TextView mTvNumberOfFriend;
        private final Button mBtnFriend;
        private final ImageView mImgAvatar;

        private FriendViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvName);
            mTvNumberOfFriend = itemView.findViewById(R.id.tvNumOfFriend);
            mBtnFriend = itemView.findViewById(R.id.btnFriend);
            mImgAvatar = itemView.findViewById(R.id.imgAvatar);
            mBtnFriend.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnFriend: {
                    Friend friend = mListFriends.get(getAdapterPosition());
                    mListFriends.remove(getAdapterPosition());
                    if (friend.isFriend()){
                        ListFriendFragment.unFavoriteFriend(friend);
                        FavoriteFragment.favoriteFriend(friend);
                    } else {
                        FavoriteFragment.removeFriend(friend);
                        ListFriendFragment.favoriteFriend(friend);
                    }
                }
            }
        }
    }
}
