package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.FriendViewHolder> {
    private List<Friend> mListFriends = new ArrayList<>();

    ListFriendAdapter(List<Friend> listFriend) {
        this.mListFriends = listFriend;
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemListFriend = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_friend,parent,false);
        return new FriendViewHolder(itemListFriend);
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position) {
        Friend friend = mListFriends.get(position);
        holder.mTvName.setText(friend.getmName());

        //holder.mTvNumberOfFriend.setText(friend.getmNumberOfFriend() + "Friends");
        holder.mImgAvatar.setImageResource(friend.getmAvatar());
    }

    @Override
    public int getItemCount() {
        return mListFriends.size();
    }

    public class FriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView mImgAvatar;
        private final TextView mTvNumberOfFriend;
        private final TextView mTvName;
        private final Button mBtnFriend;

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

        }
    }
}

