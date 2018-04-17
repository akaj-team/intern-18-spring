package vn.asiantech.internship;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class ListFriendActitivy extends Activity implements IEventClick{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        RecyclerView recyclerViewFriend = findViewById(R.id.recycleViewListFriend);
        recyclerViewFriend.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewFriend.setLayoutManager(layoutManager);
        ListFriendAdapter listFriendAdapter = new ListFriendAdapter(this, this);
        recyclerViewFriend.setAdapter(listFriendAdapter);

    }

    @Override
    public void onButtonFriendClick(Friend friend, boolean isfriend, int position) {

    }
}
