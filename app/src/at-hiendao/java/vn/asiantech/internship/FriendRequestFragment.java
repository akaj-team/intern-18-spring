package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FriendRequestFragment extends Fragment {
    private  ListFriendAdapter mAdapter;
    private IEventClick mEventClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpage, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvListFriend);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter = new ListFriendAdapter(mEventClick, getActivity(), false);
        recyclerView.setAdapter(mAdapter);
        return view;
    }


    void settingEventClickButtonFriend(IEventClick eventClick) {
        mEventClick = eventClick;
    }

    void changeRecycleView(Friend friend, boolean isfriend, int position) {
        if (!isfriend) {
            friend.setIsFriend(false);
            mAdapter.addFriend(friend);
        } else {
            mAdapter.removeFriend(position);
        }
    }
}
