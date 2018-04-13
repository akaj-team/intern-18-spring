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

import vn.asiantech.internship.model.Friends;

public class FriendsListFragments extends Fragment{
    FriendsAdapter mAdapter;
    List<Friends> mListFriend=new ArrayList<>();
    RecyclerView mRvListFriend;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter=new FriendsAdapter(mListFriend);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_friend_list,container,false);
        Log.e("FriendsListFragments",getArguments().getString("key"));

        mappingView(view);
        setRecycleView();
        setListFriend();
        mAdapter.notifyDataSetChanged();
        return view;
    }

    private void setListFriend() {
        for(int i=0;i<500;i++){
            mListFriend.add(new Friends("Phuc"+i,10+i,R.drawable.ic_people_black_48dp));
        }
    }

    public void mappingView(View view){
        mRvListFriend=view.findViewById(R.id.recylerViewFrag);
    }

    public void setRecycleView(){
        mLayoutManager=new LinearLayoutManager(getActivity());
        mRvListFriend.setLayoutManager(mLayoutManager);
        mRvListFriend.setAdapter(mAdapter);
        mRvListFriend.setItemAnimator(new DefaultItemAnimator());
    }
}
