package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FavoriteFragment extends Fragment implements OnFriendClickListener {
    private ListFriendAdapter mListFriendAdapter;
    private static List<Friend> mListFavoriteFriends;
    private ListFriendAdapter mSecondListFriendAdapter;
    OnFriendClickListener mOnFriendClickListener;

    public void setOnFriendCLickListener(OnFriendClickListener onFriendCLickListener) {
        mOnFriendClickListener = onFriendCLickListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListFavoriteFriends = Friend.createListFriend(10, false);
        mListFriendAdapter = new ListFriendAdapter(mListFavoriteFriends);
        mOnFriendClickListener.onFriendClick(mListFriendAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite,container,false);
        RecyclerView recycleView = view.findViewById(R.id.recyclerView1);
        recycleView.setAdapter(mListFriendAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    @Override
    public void onResume() {
        mListFriendAdapter.setSecondListFriendAdapter(mSecondListFriendAdapter);
        super.onResume();
    }

    public static void addFriend(Friend friend) {
        mListFavoriteFriends.add(friend);
    }

    @Override
    public void onFriendClick(ListFriendAdapter friendAdapter) {
        mSecondListFriendAdapter = friendAdapter;
    }
}
