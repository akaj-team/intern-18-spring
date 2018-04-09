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

public class FirstFragment extends Fragment {
    private EditText mEdtInput;
    private SendStringOfFirstFragment mData;
    private String mMessage;

    public interface SendStringOfFirstFragment {
        void sendMessage(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mData = (SendStringOfFirstFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement SendStringFragment");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        mEdtInput = view.findViewById(R.id.edtInput);
        if (null != mMessage) {
            tvMessage.setText(mMessage);
            mEdtInput.setText("");
        }
        Button btnSend = view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.sendMessage(mEdtInput.getText().toString());
            }
        });
        return view;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }
}
