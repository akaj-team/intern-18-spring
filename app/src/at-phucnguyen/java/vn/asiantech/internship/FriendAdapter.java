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

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendsViewHolder> {
    private final List<Friend> mFriendList;

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrecycler_friend, parent, false);

        return new FriendsViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder friends, int position) {
        Friend friend = mFriendList.get(position);
        String nameFriend = friend.getNameFriend();
        String countfriendstemp = friend.getCountFriend() + " Friend";
        friends.mTvNameFriends.setText(nameFriend);
        friends.mTvCountFriends.setText(countfriendstemp);
        friends.mImgFriend.setImageResource(friend.getUrlImage());
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

    /**
     * Class is used to set ViewHolder to each row
     */
    class FriendsViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvNameFriends;
        private final TextView mTvCountFriends;
        private final ImageView mImgFriend;
        private final Button mBtnUnFriend;
        private String mStatus = "Friend";

        FriendsViewHolder(View mView) {
            super(mView);
            mTvNameFriends = mView.findViewById(R.id.tvNameFriends);
            mTvCountFriends = mView.findViewById(R.id.tvCountFriends);
            mImgFriend = mView.findViewById(R.id.imgFriends);
            mBtnUnFriend = mView.findViewById(R.id.btnUnFriends);
            mBtnUnFriend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mBtnUnFriend.getText().equals("Friend")) {
                        mStatus = "UnFriends";
                    } else {
                        mStatus = "Friend";
                    }
                    mBtnUnFriend.setText(mStatus);
                }
            });
        }
    }

    FriendAdapter(List<Friend> friendList) {
        this.mFriendList = friendList;
    }
}
