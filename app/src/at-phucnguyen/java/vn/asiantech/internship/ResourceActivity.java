package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ResourceActivity extends AppCompatActivity implements ResourceHomeFragment.OnFragmentResoureHome {
    FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        fm = getSupportFragmentManager();
        fragMentStore(new ResourceHomeFragment());
    }

    public void fragMentStore(Fragment fragment) {
        FragmentTransaction ft_add = fm.beginTransaction();
        ft_add.replace(R.id.fragmentLayoutResource, fragment);
        ft_add.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);//Hieu ung khi chuyen tiep cac fragment
        ft_add.addToBackStack(null);
        ft_add.commit();
    }


    @Override
    public void onSendEvent(String data) {
        //fragMentStore(new ChatViewFragment());
        Log.e("Message",data);
    }

    @Override
    public void onSendEventBtnClick() {
        fragMentStore(new ChatViewFragment());
    }
}
