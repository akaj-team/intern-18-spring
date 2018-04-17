package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ResourceActivity extends AppCompatActivity implements ResourceHomeFragment.OnFragmentResoureHome {
    private FragmentManager mFmManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        mFmManager = getSupportFragmentManager();
        fragMentStore(new ResourceHomeFragment());
    }

    public void fragMentStore(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFmManager.beginTransaction();
        fragmentTransaction.replace(R.id.flResource, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);//Hieu ung khi chuyen tiep cac fragment
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onSendEvent(String data) {
        Log.e("Message", data);
    }

    @Override
    public void onSendEventBtnClick() {
        fragMentStore(new ChatViewFragment());
    }
}
