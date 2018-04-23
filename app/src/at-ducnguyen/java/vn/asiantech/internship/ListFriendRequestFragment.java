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

public class ListFriendRequestFragment extends Fragment implements OnFriendClickListener {
    private ListFriendRequestAdapter mListFriendRequestAdapter;
    private ListFriendRequestAdapter mOtherAdapter;
    private static List<Friend> mListRequests;

    OnFriendClickListener mListener;

    public void setOnFriendClickListener(OnFriendClickListener listener){
        mListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListRequests = Friend.createListFriend(10, false);
        mListFriendRequestAdapter = new ListFriendRequestAdapter(mListRequests);
        mListener.onFriendClick(mListFriendRequestAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_friend_request, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewListRequest);
        recyclerView.setAdapter(mListFriendRequestAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    @Override
    public void onResume() {
        mListFriendRequestAdapter.setOtherAdapter(mOtherAdapter);
        super.onResume();
    }

    public static void addFriend(Friend friend){
        mListRequests.add(friend);
    }

    @Override
    public void onFriendClick(ListFriendRequestAdapter friendAdapter) {
        mOtherAdapter = friendAdapter;
    }
}
