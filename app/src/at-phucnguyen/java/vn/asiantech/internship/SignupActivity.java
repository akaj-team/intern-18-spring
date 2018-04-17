package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements SignupFragment.OnListenesEventSignUpFragment {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFragmentManager = getSupportFragmentManager();//anh xa

        storeFragment(new SignupFragment());
    }

    public void storeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frSignUpFragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onViewChecked(String mMessage) {
        Toast.makeText(SignupActivity.this, mMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInputEditText(int idString) {
        Toast.makeText(SignupActivity.this, idString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewChecked(int idString) {
        Toast.makeText(SignupActivity.this, idString, Toast.LENGTH_SHORT).show();
    }
}
