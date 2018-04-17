package vn.asiantech.internship;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SendDataActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        SendFragment sendFragment = new SendFragment();
        ReceiveFragment receiveFragment = new ReceiveFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.llParent, sendFragment).add(R.id.llParent, receiveFragment)
                .commit();
        sendFragment.setListener(receiveFragment);

    }

}
