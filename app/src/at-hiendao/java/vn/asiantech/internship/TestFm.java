package vn.asiantech.internship;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestFm extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("123", "Fragment Created");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Attach", "Fragment Attach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("CreateView", "Fragment CreateView");

        return inflater.inflate(R.layout.fragment2,container,false);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("Created", "Fragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("Start", "Fragment Start");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Resume", "Fragment Resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Pause", "Fragment Pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("Stop", "Fragment Stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("DestroyView", "Fragment DestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("CreateView", "Fragment Detach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("CreateView", "Fragment Destroy");
    }

}
