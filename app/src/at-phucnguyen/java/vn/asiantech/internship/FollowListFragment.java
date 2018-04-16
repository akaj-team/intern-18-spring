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

import vn.asiantech.internship.model.Friends;

public class FollowListFragment extends Fragment {
    RecyclerView mRecyclerView;
    FriendsAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<Friends> mFollowList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow_list, container, false);

        mappingView(view);
        setRecyclerView();
        setFollowList();
        mAdapter.notifyDataSetChanged();
        return view;
    }

    private void setFollowList() {
        for (int i = 0; i < 100; i++) {
            mFollowList.add(new Friends("Phuc Phuc Phuc " + i, 10 + i * 10,
                    R.drawable.ic_people_outline_black_24dp,"Follow"));
        }
    }

    private void setRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter=new FriendsAdapter(mFollowList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void mappingView(View view) {
        mRecyclerView = view.findViewById(R.id.rvFollowList);
    }
}
