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

import vn.asiantech.internship.model.Friend;

public class ListFriendFragment extends Fragment implements OnFriendClickListener {
    private ListFriendRequestAdapter mListFriendRequestAdapter;
    private ListFriendRequestAdapter mOtherAdapter;
    private static List<Friend> mListFriends;

    OnFriendClickListener mListener;

    public void setOnFriendClickListener(OnFriendClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListFriends = Friend.createListFriend(10, true);
        mListFriendRequestAdapter = new ListFriendRequestAdapter(mListFriends);
        mListener.onFriendClick(mListFriendRequestAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_friend, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewListFriend);
        recyclerView.setAdapter(mListFriendRequestAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }
    @Override
    public void onResume() {
        mListFriendRequestAdapter.setOtherAdapter(mOtherAdapter);
        super.onResume();
    }

    public static void addFriend(Friend friend) {
        mListFriends.add(friend);
    }

    @Override
    public void onFriendClick(ListFriendRequestAdapter friendAdapter) {
        mOtherAdapter = friendAdapter;
    }
}
