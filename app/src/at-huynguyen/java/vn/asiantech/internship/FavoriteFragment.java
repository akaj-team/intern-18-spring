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

public class FavoriteFragment extends Fragment {
    private ListFriendAdapter mListFriendAdapter;
    private List<Friend> mListFriends;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListFriends = Friend.createListFriend(10, false);
        mListFriendAdapter = new ListFriendAdapter(mListFriends);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite,container,false);
        RecyclerView recycleView = view.findViewById(R.id.recyclerView1);
        recycleView.setAdapter(mListFriendAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }
    public void favoriteFriend(Friend friend){
        friend.setFriend(false);
        mListFriends.add(friend);
        mListFriendAdapter.notifyDataSetChanged();
    }

    public void removeFriend(int position){
        mListFriends.remove(position);
        mListFriendAdapter.notifyDataSetChanged();
    }
}
