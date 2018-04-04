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
import android.widget.FrameLayout;

public class FragmentAndActivity extends Activity {
    public static FragmentAndActivity Instance;
    private TestFm mFragment1;
    private TestFm2 mFragment2;

    public interface SubmitChat
    {
        public void ReceviedData(String data);
        public void SendData(String data, boolean isFm1);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmen_and_activity);
        mFragment1 = new TestFm();
        AddFragmment(mFragment1);
        mFragment2  = new TestFm2();
        AddFragmment(mFragment2);
        Log.d("Fragment Activity", "Fragment Activity Create");
        if(Instance == null)
            Instance = this;
    }

    void AddFragmment(Fragment fm)
    {
        FragmentManager fmManager = getFragmentManager();
        FragmentTransaction ftTransaction = fmManager.beginTransaction();
        ftTransaction.add(R.id.ll, fm);
        ftTransaction.addToBackStack(null);
        ftTransaction.commit();
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


    public  void OnChatFragment(String text, boolean isFm1)
    {
        if(isFm1)
        {
            mFragment2.ReceviedData(text);
        }
        else
        {
            mFragment1.ReceviedData(text);
        }
    }

}
