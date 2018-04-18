package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.ViewHolder> {

    private final List<Friend> mListFriend = new ArrayList<>();

    /*
        class viewholder of listview in recycleview
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvName;
        private final TextView mTvMutualFriends;
        private static final String MUTUAL_FRIENDS = "mutual friends";
        private final ImageView mImgAvatar;

        ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvFriendName);
            mTvMutualFriends = itemView.findViewById(R.id.tvMutualFriends);
            mImgAvatar = itemView.findViewById(R.id.imgAvatar);
        }

        void setMutualFriends(int numbermutual) {
            mTvMutualFriends.setText(String.format(Locale.US, "%s %d", MUTUAL_FRIENDS, numbermutual));
        }
    }

    ListFriendAdapter() {
        createNewListFriends();
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
    }

    @Override
    public int getItemCount() {
        return mListFriend.size();
    }

    private void createNewListFriends() {
        int numberOfFriends = 100;
        for (int i = 0; i < numberOfFriends; i++) {
            String name = "Friend" + i;
            int minRandom = 15;
            int maxRandom = 1000;
            Friend friend = new Friend(name, randomNumber(minRandom, maxRandom));
            mListFriend.add(friend);
        }
    }

    private int randomNumber(int min, int max) {
        int range = max - min + 1;
        return ((int) (Math.random() * range)) + min;
    }

}
