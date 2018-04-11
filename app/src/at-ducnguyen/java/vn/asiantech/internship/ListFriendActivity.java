package vn.asiantech.internship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import vn.asiantech.internship.model.Friend;

public class ListFriendActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ListFriendAdapter(Friend.createListFriend()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
