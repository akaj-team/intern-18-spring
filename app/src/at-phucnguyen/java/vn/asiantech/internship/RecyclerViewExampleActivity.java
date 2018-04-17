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

import vn.asiantech.internship.model.Friend;

public class RecyclerViewExampleActivity extends AppCompatActivity {
    private final List<Friend> mFriendList = new ArrayList<>();
    private FriendAdapter mApdapter;
    private final List<Integer> mUrlImage = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_example);

        RecyclerView recyclerView;
        mApdapter = new FriendAdapter(mFriendList);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mApdapter);
        setUrlImage();
        setList();
        mApdapter.notifyDataSetChanged();
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
            mFriendList.add(new Friend("Nguyen Van phuc " + i, i * 4,
                    mUrlImage.get(new Random().nextInt(4))));
            mApdapter.notifyDataSetChanged();
        }
    }
}
