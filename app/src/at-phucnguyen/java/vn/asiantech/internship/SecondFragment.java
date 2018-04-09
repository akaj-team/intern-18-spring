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

public class SecondFragment extends Fragment {
    TextView edData;
    OnFragment2Manager listenerFragment2;
    Button btnSendDataFragment2;
    EditText edDataFragment2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        String pareDataFragmentA = getArguments().getString("keyDataFragment1");//Day la du lieu tu Fragment A
        edData = view.findViewById(R.id.tvPareDataFragment2);
        edData.setText(pareDataFragmentA);
        btnSendDataFragment2 = view.findViewById(R.id.btnSendDataFrangment2);
        edDataFragment2 = view.findViewById(R.id.edDataFragment2);
        btnSendDataFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToFragment1();
            }
        });
        return view;
    }

    public interface OnFragment2Manager {
        void onSendToData(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2Manager) {
            listenerFragment2 = (OnFragment2Manager) context;
        } else {
            throw new RuntimeException(context.toString() + "Fragment 2 chua khoi tao");
        }
    }

    public void sendDataToFragment1() {
        listenerFragment2.onSendToData(edDataFragment2.getText().toString());
    }
}
