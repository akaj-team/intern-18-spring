package vn.asiantech.internship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Message2Fragment extends Fragment {
    TextView tvData;
    OnFragment2Manager listenerFragment2;
    Button btnSendDataFragment2;
    EditText edtData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_2, container, false);
        String mPareDataFragmentA = getArguments().getString("keyDataFragment1");//Day la du lieu tu Fragment A
        tvData = view.findViewById(R.id.tvPareDataFragment2);
        tvData.setText(mPareDataFragmentA);
        btnSendDataFragment2 = view.findViewById(R.id.btnSendDataFrangment2);
        edtData = view.findViewById(R.id.edtDataFragment2);
        btnSendDataFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToFragment1();
            }
        });
        return view;
    }

    /**
     * Interface used is send data to activity
     */
    public interface OnFragment2Manager {
        void onSendToData(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2Manager) {
            listenerFragment2 = (OnFragment2Manager) context;
        } else {
            throw new RuntimeException(context.toString() + "Fragment 2 is null");
        }
    }

    public void sendDataToFragment1() {
        listenerFragment2.onSendToData(edtData.getText().toString());
    }
}
