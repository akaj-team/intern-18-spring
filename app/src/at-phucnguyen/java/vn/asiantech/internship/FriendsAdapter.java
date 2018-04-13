package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        View itemsFriendView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrecycler_friend, parent, false);

        return new FriendsViewHolder(itemsFriendView);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder friends, int position) {
        Log.e("FriendsAdapter: ","onBindViewHolder is "+position);
        Friends friendTemp = mFriendsList.get(position);
        String nameTemp=friendTemp.getmNameFriend().toString();
        String countFriendsTemp=friendTemp.getmCountFriend() + " Friends";
        friends.mTvNameFriends.setText(nameTemp);
        friends.mTvCountFriends.setText(countFriendsTemp);
        friends.mImgFriend.setImageResource(friendTemp.getmUrlImage());
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

        FriendsViewHolder(View mView){
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
