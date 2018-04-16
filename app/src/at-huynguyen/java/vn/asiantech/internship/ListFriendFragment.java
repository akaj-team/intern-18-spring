package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFriendFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listfriend,container,false);
        RecyclerView recycleView = view.findViewById(R.id.recyclerView);
        recycleView.setAdapter(new ListFriendAdapter(Friend.createListFriend()));
        recycleView.setLayoutManager(layoutManager);
    }
}
