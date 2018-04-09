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

public class SecondFragment extends Fragment {
    private EditText mEdtInput;
    private SendStringOfSecondFragment mData;

    public interface SendStringOfSecondFragment {
        void sendMessageBack(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mData = (SendStringOfSecondFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must Implement SendStringOfSecondFragment ");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        String result = getArguments().getString(SendDataActivity.KEY_MESSAGE);
        tvMessage.setText(result);
        Button btnSend = view.findViewById(R.id.btnSend);
        mEdtInput = view.findViewById(R.id.edtInput);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mData.sendMessageBack(mEdtInput.getText().toString());
            }
        });
        return view;
    }
}
