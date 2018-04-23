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

public class ListFriendFragment extends Fragment implements OnFriendClickListener {

    private ListFriendAdapter mListFriendAdapter;
    private static List<Friend> mListFriends;
    private ListFriendAdapter mSecondListFriendAdapter;

    OnFriendClickListener mOnFriendClickListener;

    public void setOnFriendClickListener(OnFriendClickListener onFriendClickListener) {
        mOnFriendClickListener = onFriendClickListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListFriends = Friend.createListFriend(100, true);
        mListFriendAdapter = new ListFriendAdapter(mListFriends);
        mOnFriendClickListener.onFriendClick(mListFriendAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listfriend,container,false);
        RecyclerView recycleView = view.findViewById(R.id.recyclerView);
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
        mListFriends.add(friend);
    }

    @Override
    public void onFriendClick(ListFriendAdapter friendAdapter) {
        mSecondListFriendAdapter = friendAdapter;
    }
}
