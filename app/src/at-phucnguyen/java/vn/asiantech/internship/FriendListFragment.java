package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.Friend;

public class FriendListFragment extends Fragment {
    FriendAdapter mAdapter;
    List<Friend> mListFriend = new ArrayList<>();
    RecyclerView mRvListFriend;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new FriendAdapter(mListFriend);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        Log.d("FriendListFragment", getArguments().getString(MyPageViewAdapter.KEY_PAGE_POSITION));

        mappingView(view);
        setRecycleView();
        setListFriend();
        mAdapter.notifyDataSetChanged();
        return view;
    }

    private void setListFriend() {
        for (int i = 0; i < 10; i++) {
            mListFriend.add(new Friend("Nguyen Van Phuc " + i, 10 + i, R.drawable.ic_people_black_48dp));
        }
    }

    public void mappingView(View view) {
        mRvListFriend = view.findViewById(R.id.recylerViewFrag);
    }

    public void setRecycleView() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRvListFriend.setLayoutManager(mLayoutManager);
        mRvListFriend.setAdapter(mAdapter);
        mRvListFriend.setItemAnimator(new DefaultItemAnimator());
    }
}
