package vn.asiantech.internship;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditTextFragment extends Fragment {
    private EditText mEdtName;
    private EditText mEdtSex;
    private MainFragment mainFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_text, container, false);

        mEdtName = view.findViewById(R.id.edtName);
        mEdtSex = view.findViewById(R.id.edtSex);

        Button mBtnShowText = view.findViewById(R.id.btnShowText);

        mBtnShowText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                applyText();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainFragment) {
            this.mainFragment = (MainFragment) context;
        }
    }


    private void applyText() {
        String topText = this.mEdtName.getText().toString();
        String bottomText = this.mEdtSex.getText().toString();

        this.mainFragment.showText(topText, bottomText);
    }
}
