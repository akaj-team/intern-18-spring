package vn.asiantech.internship;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class ViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fmResources = new ResourcesFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fmTransaction = fragmentManager.beginTransaction();
                fmTransaction.replace(R.id.llViewAndViewGroup, fmResources);
                fmTransaction.commit();
            }
        });
    }

}
