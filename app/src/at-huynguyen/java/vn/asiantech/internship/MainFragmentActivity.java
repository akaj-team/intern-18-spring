package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }

    public void showText(String nameText, String sexText) {
        ShowTextFragment showTextFragment
                = (ShowTextFragment) this.getSupportFragmentManager()
                .findFragmentById(R.id.fragmentShowText);
        showTextFragment.showText(nameText, sexText);
    }
}
