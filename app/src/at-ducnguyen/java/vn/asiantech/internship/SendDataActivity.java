package vn.asiantech.internship;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SendDataActivity extends AppCompatActivity implements FirstFragment.SendStringOfFirstFragment, SecondFragment.SendStringOfSecondFragment {
    public static final String KEY_MESSAGE = "201706387";
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Android Example");
        setContentView(R.layout.activity_send_data);
        firstFragment = new FirstFragment();
        Log.e("TAG", "onCreate: " + firstFragment.toString());
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.flFragment, firstFragment);
        transaction.commit();
    }

    @Override
//      first fragment
    public void sendMessage(String message) {
        secondFragment = new SecondFragment();
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
        firstFragment.setMessage(message);
        fragmentManager.popBackStack();
    }
}
