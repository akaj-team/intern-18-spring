package vn.asiantech.internship;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class FragmentAndActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmen_and_activity);
        Fragment test = new TestFm();
        FragmentManager fmManager = getFragmentManager();
        FragmentTransaction ftTransaction = fmManager.beginTransaction();
        ftTransaction.replace(R.id.ll, test);
        //ftTransaction.addToBackStack(null);
        ftTransaction.commit();
        Log.d("Fragment Activity", "Fragment Activity Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start Activity", "Fragment Activity Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop", "Fragment Activity Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause","Fragment Activity Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy", "Fragment Activity Destroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume" , "Fragment Activity Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Restart","Fragment Activity Restart");
    }

    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }
}
