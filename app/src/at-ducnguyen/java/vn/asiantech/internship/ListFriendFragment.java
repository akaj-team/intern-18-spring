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

public class ListFriendFragment extends Fragment {
    private static ListFriendRequestAdapter mListFriendRequestAdapter;
    private static List<Friend> mListFriends;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListFriends = Friend.createListFriend(10, true);
        mListFriendRequestAdapter = new ListFriendRequestAdapter(mListFriends);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_friend, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewListFriend);
        new ListFriendRequestAdapter(mListFriends);
        recyclerView.setAdapter(mListFriendRequestAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    public static void addFriend(Friend friend) {
        friend.setFriend(true);
        mListFriends.add(friend);
        mListFriendRequestAdapter.notifyDataSetChanged();
    }

    public static void unFriend(Friend friend) {
        mListFriends.remove(friend);
        mListFriendRequestAdapter.notifyDataSetChanged();
    }
}
