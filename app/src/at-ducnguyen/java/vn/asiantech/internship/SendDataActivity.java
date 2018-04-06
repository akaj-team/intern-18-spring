package vn.asiantech.internship;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SendDataActivity extends AppCompatActivity implements FirstFragment.SendStringOfFirstFragment, SecondFragment.SendStringOfSecondFragment {
    public static final String KEY_MESSAGE = "201706387";
    private FirstFragment mFirstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Android Example");
        setContentView(R.layout.activity_send_data);
        mFirstFragment = new FirstFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.flFragment, mFirstFragment);
        transaction.commit();
    }

    @Override
//      first fragment
    public void sendMessage(String message) {
        SecondFragment secondFragment = new SecondFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.flFragment, secondFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, message);
        secondFragment.setArguments(bundle);
    }

    //      second fragment
    @Override
    public void sendMessageBack(String message) {
        FragmentManager fragmentManager = getFragmentManager();
        mFirstFragment.setMessage(message);
        fragmentManager.popBackStack();
    }
}
