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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestFm extends Fragment implements FragmentAndActivity.SubmitChat{
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
        View view =  inflater.inflate(R.layout.fragment1,container,false);
        Button btnClick = (Button)view.findViewById(R.id.btnSubmit1);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("a","Clickkkkkkkkkkkkk");
                EditText etText = (EditText)getView().findViewById(R.id.etFragment1);
                SendData(etText.getText().toString(), true);
            }
        });
        return view;

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

    @Override
    public  void ReceviedData(String data)
    {
        TextView tvText = (TextView)getView().findViewById(R.id.tvFragment1);
        tvText.setText(data);
    }

    @Override
    public void SendData(String data, boolean isFm1) {
        FragmentAndActivity.Instance.OnChatFragment(data,isFm1);
    }


}
