package vn.asiantech.internship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import vn.asiantech.internship.model.Friend;

public class ListFriendActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);
        Friend friend = new Friend();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ListFriendAdapter(friend.createListFriend(100)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
