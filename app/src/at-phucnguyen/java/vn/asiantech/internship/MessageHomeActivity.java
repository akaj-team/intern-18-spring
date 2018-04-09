package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MessageHomeActivity extends AppCompatActivity implements Message1Fragment.OnFragmentManager, Message2Fragment.OnFragment2Manager {
    FragmentManager fmfirst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_home);

        fmfirst = getSupportFragmentManager();//Khai bao quan li Fragment
        fragmentStore(new Message1Fragment());
    }

    public void fragmentStore(Fragment fragmentClass) {
        FragmentTransaction ft_add = fmfirst.beginTransaction();
        ft_add.replace(R.id.fragmentLayoutFirst, fragmentClass);
        ft_add.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);//Hieu ung khi chuyen tiep cac fragment
        //ft_add.addToBackStack(null);//Cho fragment vao stack
        ft_add.commit();
    }

    @Override
    public void onDataSelected(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("keyDataFragment1", data);
        Message2Fragment fragmentB = new Message2Fragment();
        fragmentStore(fragmentB);
        fragmentB.setArguments(bundle);//Truyen du lieu qua fragment Second
    }

    @Override
    public void onSendToData(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("keyDataFragment2", data);
        Message1Fragment fragmentA = new Message1Fragment();
        fragmentStore(fragmentA);
        fragmentA.setArguments(bundle);
    }
}
