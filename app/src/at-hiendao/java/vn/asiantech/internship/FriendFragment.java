package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FriendFragment extends Fragment {
    private ListFriendAdapter mAdapter;
    private IEventClick mEventClick;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ListFriendAdapter(mEventClick, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpage, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvListFriend);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    void setIEventClick(IEventClick eventClick) {
        mEventClick = eventClick;
    }

    void changeRecycleView(Friend friend, boolean isfriend, int position) {
        if (isfriend) {
            friend.setIsFriend(true);
            mAdapter.addFriend(friend);
        } else {
            mAdapter.removeFriend(position);
        }
    }

}
