package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.Friends;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {
    private List<Friends> mFriendsList;

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemsFriendView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrecycler_friend, parent, false);

        return new FriendsViewHolder(mItemsFriendView);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder friends, int position) {
        Friends mFriends = mFriendsList.get(position);
        String mNameTemp=mFriends.getmNameFriend().toString();
        String mCountFriendsTemp=mFriends.getmCountFriend() + " Friends";
        friends.mTvNameFriends.setText(mNameTemp);
        friends.mTvCountFriends.setText(mCountFriendsTemp);
        friends.mImgFriend.setImageResource(mFriends.getmUrlImage());
    }

    @Override
    public int getItemCount() {
        return mFriendsList.size();
    }

    /**
     * Class is used to set ViewHolder to each row
     */
    public class FriendsViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvNameFriends;
        private TextView mTvCountFriends;
        private ImageView mImgFriend;
        private Button mBtnUnFriend;
        private String mStatus="Friends";

        FriendsViewHolder(View mView) {
            super(mView);
            mTvNameFriends = mView.findViewById(R.id.tvNameFriends);
            mTvCountFriends = mView.findViewById(R.id.tvCountFriends);
            mImgFriend = mView.findViewById(R.id.imgFriends);
            mBtnUnFriend = mView.findViewById(R.id.btnUnFriends);
            mBtnUnFriend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mBtnUnFriend.getText().equals("Friends")) {
                        mStatus="UnFriends";
                    } else {
                        mStatus="Friends";
                    }
                    mBtnUnFriend.setText(mStatus);
                }
            });
        }
    }

    public FriendsAdapter(List<Friends> friendsList) {
        this.mFriendsList = friendsList;
    }
}
