package vn.asiantech.internship;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by nmduc on 03/04/2018.
 */

public class SecondFragment extends Fragment {
    private TextView mTvMessage;
    private Button mBtnSend;
    private EditText mEdtInput;
    private SendStringOfSecondFragment data;

    public interface SendStringOfSecondFragment {
        public void sendMessageBack(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            data = (SendStringOfSecondFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must Implement SendStringOfSecondFragment ");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mTvMessage = (TextView) view.findViewById(R.id.tvMessage);
        String result = getArguments().getString(SendDataActivity.KEY_MESSAGE);
        mTvMessage.setText(result);
        mBtnSend = (Button) view.findViewById(R.id.btnSend);
        mEdtInput = (EditText) view.findViewById(R.id.edtInput);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.sendMessageBack(mEdtInput.getText().toString());
            }
        });
        return view;
    }
}
