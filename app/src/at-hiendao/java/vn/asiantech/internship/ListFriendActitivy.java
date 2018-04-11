package vn.asiantech.internship;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class ListFriendActitivy extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        RecyclerView listFriends = findViewById(R.id.recycleViewListFriend);
        listFriends.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listFriends.setLayoutManager(layoutManager);
        ListFriendAdapter adapter = new ListFriendAdapter();
        listFriends.setAdapter(adapter);
        
    }
}
