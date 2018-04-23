package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.Friend;

public class FollowListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FriendAdapter mAdapter;
    private List<Friend> mFollowList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow_list, container, false);

        initView(view);
        setRecyclerView();
        setFollowList();
        mAdapter.notifyDataSetChanged();
        return view;
    }

    private void setFollowList() {
        for (int i = 0; i < 100; i++) {
            mFollowList.add(new Friend("Phuc Phuc Phuc " + i, 10 + i * 10,
                    R.drawable.ic_people_outline_black_24dp));
        }
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new FriendAdapter(mFollowList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.rvFollowList);
    }
}
