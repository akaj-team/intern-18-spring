package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MessageHomeActivity extends AppCompatActivity implements Message1Fragment.OnFragmentManager, Message2Fragment.OnFragment2Manager {
    FragmentManager fm_Manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_home);

        fm_Manager = getSupportFragmentManager();//Khai bao quan li Fragment
        fragmentStore(new Message1Fragment());
    }

    public void fragmentStore(Fragment fragmentClass) {
        FragmentTransaction fm_Transaction = fm_Manager.beginTransaction();
        fm_Transaction.replace(R.id.flFirst, fragmentClass);
        fm_Transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);//Hieu ung khi chuyen tiep cac fragment
        //fm_Transaction.addToBackStack(null);//Cho fragment vao stack
        fm_Transaction.commit();
    }

    @Override
    public void onDataSelected(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("keyDataFragment1", data);
        Message2Fragment fm_Message2 = new Message2Fragment();
        fragmentStore(fm_Message2);
        fm_Message2.setArguments(bundle);//Truyen du lieu qua fragment Second
    }

    @Override
    public void onSendToData(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("keyDataFragment2", data);
        Message1Fragment fm_Message2 = new Message1Fragment();
        fragmentStore(fm_Message2);
        fm_Message2.setArguments(bundle);
    }
}
