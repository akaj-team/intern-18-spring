package vn.asiantech.internship;

import android.app.Fragment;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestFm2 extends Fragment implements FragmentAndActivity.SubmitChat{
    private  SubmitText mListener;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //btnSubmitClick();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment2,container,false);
        Button btnClick = (Button)view.findViewById(R.id.btnSubmit2);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("a","Clickkkkkkkkkkkkk");
                EditText etText = (EditText)getView().findViewById(R.id.etFragment2);
                SendData(etText.getText().toString(),false);

            }
        });
        return view;
    }

    public SubmitText getmListener() {
        return mListener;
    }

    public void SetSubmitListenter(SubmitText listener)
    {
        mListener = listener;
    }


    public interface SubmitText
    {
        public void OnButtonSubmitClick(String text);
    }

    private void btnSubmitClick()
    {

    }

    @Override
    public  void ReceviedData(String data)
    {
        TextView tvText = (TextView)getView().findViewById(R.id.tvFragment2);
        tvText.setText(data);
    }

    @Override
    public void SendData(String data, boolean isFm1) {
        FragmentAndActivity.Instance.OnChatFragment(data,isFm1);
    }


}
