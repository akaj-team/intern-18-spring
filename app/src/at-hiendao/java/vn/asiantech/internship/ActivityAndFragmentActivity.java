package vn.asiantech.internship;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class ActivityAndFragmentActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_and_fragment);
        SendFragment sendFragment = new SendFragment();
        ReceiveFragment receiveFragment = new ReceiveFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.rlParent, sendFragment).add(R.id.rlParent, receiveFragment)
                .commit();
        sendFragment.setListener(receiveFragment);

    }

}
