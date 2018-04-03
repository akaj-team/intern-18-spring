package vn.asiantech.internship;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SendDataActivity extends AppCompatActivity implements FirstFragment.SendStringFragment {
    public static final String KEY_INPUT = "201706387";
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        firstFragment = new FirstFragment();
        showFragment(firstFragment);
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void sendString(String str) {
        secondFragment = new SecondFragment();
        showFragment(secondFragment);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_INPUT, str);
        secondFragment.setArguments(bundle);
    }
}
