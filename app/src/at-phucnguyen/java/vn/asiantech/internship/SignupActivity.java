package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity{
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fragmentManager=getSupportFragmentManager();//anh xa 

        storeFragment(new SignupFragment());
    }
    public void storeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.singupFragmentLayout,fragment);
        fragmentTransaction.commit();
    }
}
