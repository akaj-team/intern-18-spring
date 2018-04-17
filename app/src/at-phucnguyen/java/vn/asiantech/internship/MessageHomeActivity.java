package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MessageHomeActivity extends AppCompatActivity implements Message1Fragment.OnFragmentManager, Message2Fragment.OnFragment2Manager {
    private FragmentManager mFmManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_home);

        mFmManager = getSupportFragmentManager();//Khai bao quan li Fragment
        fragmentStore(new Message1Fragment());
    }

    public void fragmentStore(Fragment mFragmentClass) {
        FragmentTransaction mFmTransaction = mFmManager.beginTransaction();
        mFmTransaction.replace(R.id.flFirst, mFragmentClass);
        mFmTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);//Hieu ung khi chuyen tiep cac fragment
        //mFmTransaction.addToBackStack(null);//Cho fragment vao stack
        mFmTransaction.commit();
    }

    @Override
    public void onDataSelected(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("keyDataFragment1", data);
        Message2Fragment fragment = new Message2Fragment();
        fragmentStore(fragment);
        fragment.setArguments(bundle);//Truyen du lieu qua fragment Second
    }

    @Override
    public void onSendToData(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("keyDataFragment2", data);
        Message1Fragment message1Fragment = new Message1Fragment();
        fragmentStore(message1Fragment);
        message1Fragment.setArguments(bundle);
    }
}
