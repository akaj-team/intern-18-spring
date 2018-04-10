package vn.asiantech.internship;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.Friend;

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.ListFriendViewHolder> {
    List<Friend> mListFriends = new ArrayList();

    public ListFriendAdapter(List<Friend> listFriend) {
        this.mListFriends = listFriend;
    }

    @Override
    public ListFriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemFriend = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_friend, parent, false);
        return new ListFriendViewHolder(itemFriend);
    }

    @Override
    public void onBindViewHolder(ListFriendViewHolder holder, int position) {
        Friend friend = mListFriends.get(position);
        holder.mImgAvatar.setImageResource(friend.getAvatar());
        holder.mTvName.setText(friend.getName());
        holder.mTvNumberOfFriends.setText(friend.getNumberOfFriend() + "Friends");
        if (friend.isFriend()) {
            holder.mBtnFriends.setText("Unfriends");
        } else {
            holder.mBtnFriends.setText("Add Friends");
        }
    }

    @Override
    public int getItemCount() {
        return mListFriends.size();
    }

    class ListFriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImgAvatar;
        private TextView mTvNumberOfFriends;
        private TextView mTvName;
        private Button mBtnFriends;

        public ListFriendViewHolder(View itemView) {
            super(itemView);
            mImgAvatar = itemView.findViewById(R.id.imgAvatar);
            mTvNumberOfFriends = itemView.findViewById(R.id.tvNumOfFriends);
            mTvName = itemView.findViewById(R.id.tvName);
            mBtnFriends = itemView.findViewById(R.id.btnFriends);
            mBtnFriends.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnFriends: {
                    Friend friend = mListFriends.get(getAdapterPosition());
                    friend.setFriend(!friend.isFriend());
                    break;
                }
            }
        }
    }
}
