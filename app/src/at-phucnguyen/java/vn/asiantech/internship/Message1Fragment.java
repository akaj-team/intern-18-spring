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

public class Message1Fragment extends Fragment implements View.OnClickListener {
    private OnFragmentManager mOnFmListener;
    private EditText mEdtData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_message_1, container, false);
        Button mBtnSendData = view.findViewById(R.id.btnSendDataFragment1);
        mEdtData = view.findViewById(R.id.edtData);
        TextView mTvDataFragment1 = view.findViewById(R.id.tvExtraDataFragment1);

        if (this.getArguments() != null) {
            String pareDataFragment2 = getArguments().getString("keyDataFragment2");
            mTvDataFragment1.setText(pareDataFragment2);
        }
        mBtnSendData.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSendDataFragment1) {
            startFragmentSecond();
        }
    }

    /**
     * Interface used is send data to activity
     */
    public interface OnFragmentManager {
        void onDataSelected(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentManager) {
            mOnFmListener = (OnFragmentManager) context;
        } else {
            throw new RuntimeException(context.toString() + "Fragment 1 is null");
        }
    }

    public void startFragmentSecond() {
        mOnFmListener.onDataSelected(mEdtData.getText().toString());
    }
}
