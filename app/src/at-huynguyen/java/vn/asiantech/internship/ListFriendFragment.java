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

public class ListFriendFragment extends Fragment {
    private static ListFriendAdapter mListFriendAdapter;
    private static List<Friend> mListFriends;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mListFriends = Friend.createListFriend(100, true);
            mListFriendAdapter = new ListFriendAdapter(mListFriends);
        }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listfriend,container,false);
        RecyclerView recycleView = view.findViewById(R.id.recyclerView);
        new ListFriendAdapter(mListFriends);
        recycleView.setAdapter(mListFriendAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    public static void favoriteFriend(Friend friend){
        friend.setFriend(true);
        mListFriends.add(friend);
    }

    public static void unFavoriteFriend(Friend friend){
        mListFriends.remove(friend);
        mListFriendAdapter.notifyDataSetChanged();
    }
}
