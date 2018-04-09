package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ResourceActivity extends AppCompatActivity implements ResourceHomeFragment.OnFragmentResoureHome {
    FragmentManager mFmManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        mFmManager = getSupportFragmentManager();
        fragMentStore(new ResourceHomeFragment());
    }

    public void fragMentStore(Fragment fragment) {
        FragmentTransaction mFmTransaction = mFmManager.beginTransaction();
        mFmTransaction.replace(R.id.flResource, fragment);
        mFmTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);//Hieu ung khi chuyen tiep cac fragment
        mFmTransaction.addToBackStack(null);
        mFmTransaction.commit();
    }

    @Override
    public void onSendEvent(String mData) {
        Log.e("Message",mData);
    }

    @Override
    public void onSendEventBtnClick() {
        fragMentStore(new ChatViewFragment());
    }
}
