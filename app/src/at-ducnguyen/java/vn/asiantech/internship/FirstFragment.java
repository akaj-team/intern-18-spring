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

/**
 * Created by nmduc on 03/04/2018.
 */

public class FirstFragment extends Fragment {
    private EditText edtInput;
    private Button btnPass;
    private SendStringFragment data;

    public interface SendStringFragment {
        public void sendString(String str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            data = (SendStringFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement SendStringFragment");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        btnPass = (Button) view.findViewById(R.id.btnPass);
        edtInput = (EditText) view.findViewById(R.id.edtInput);
        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.sendString(edtInput.getText().toString());
            }
        });
        return view;
    }
}
