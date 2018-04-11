package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.Model.Friends;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {
    private List<Friends> mFriendsList;

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemsFriendView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrecycler_friend,parent,false);

        return new FriendsViewHolder(mItemsFriendView);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder friends, int position) {
        Friends mFriends=mFriendsList.get(position);
        friends.mTvNameFriends.setText(mFriends.getmNameFriend());
        friends.mTvCountFriends.setText(mFriends.getmCountFriend());
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * Class is used to set ViewHolder to each row
     */
    public class FriendsViewHolder extends RecyclerView.ViewHolder {
        TextView mTvNameFriends, mTvCountFriends;
        ImageView mImgFriend;

        FriendsViewHolder(View mView) {
            super(mView);
            mTvNameFriends = mView.findViewById(R.id.tvNameFriends);
            mTvCountFriends = mView.findViewById(R.id.tvCountFriends);
            mImgFriend = mView.findViewById(R.id.imgFriends);
        }
    }

    public FriendsAdapter(List<Friends> friendsList) {
        this.mFriendsList=friendsList;
    }
}
