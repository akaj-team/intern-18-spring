package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vn.asiantech.internship.Model.Friends;

public class RecyclerViewExampleActivity extends AppCompatActivity {
    private List<Friends> mFriendsList = new ArrayList<>();
    private FriendsAdapter mApdapter;
    private List<Integer> mUrlImage = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_example);

        RecyclerView mRecyclerView;
        mApdapter = new FriendsAdapter(mFriendsList);
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mApdapter);
        setUrlImage();
        setList();
    }

    public void setUrlImage() {
        mUrlImage.add(R.drawable.img_phucnguyen);
        mUrlImage.add(R.drawable.img_iphone3);
        mUrlImage.add(R.drawable.img_iphone6);
        mUrlImage.add(R.drawable.img_iphone7);
        mUrlImage.add(R.drawable.img_booklief);
    }

    public void setList() {
        for (int i = 0; i < 100; i++) {
            mFriendsList.add(new Friends("Nguyen Van phuc " + i, i * 4,
                    mUrlImage.get(new Random().nextInt(4))));
            mApdapter.notifyDataSetChanged();
        }
    }
}
