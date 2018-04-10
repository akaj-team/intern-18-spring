package vn.asiantech.internship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

public class SignupFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {

    OnListenesEventSignUpFragment mListenes;
    EditText mEdtUseName, mEdtPasswork, mEdtEmail;
    RadioGroup mRadioGroup;
    Switch mSwEmail, mSwEmailSub;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        mapIdForView(view);
        setEvent();

        return view;
    }

    /**
     * method is used to mapping view by id
     */
    public void mapIdForView(View mView) {
        mEdtUseName = mView.findViewById(R.id.edtUsername);
        mEdtPasswork = mView.findViewById(R.id.edtPasswork);
        mEdtEmail = mView.findViewById(R.id.edtEmail);
        mRadioGroup = mView.findViewById(R.id.rgGroup);
        mSwEmail = mView.findViewById(R.id.swEmail);
        mSwEmailSub = mView.findViewById(R.id.swEmailSub);
    }

    /**
     * method is used to set event for view
     */
    public void setEvent() {
        mEdtUseName.setOnClickListener(this);
        mEdtPasswork.setOnClickListener(this);
        mEdtEmail.setOnClickListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        mSwEmail.setOnCheckedChangeListener(this);
        mSwEmailSub.setOnCheckedChangeListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListenesEventSignUpFragment) {
            mListenes = (OnListenesEventSignUpFragment) context;
        } else {
            throw new RuntimeException(context.toString() + "Fragment is null");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtUsername: {
                mListenes.onInputEditText("You input your UseName");
                break;
            }
            case R.id.edtPasswork: {
                mListenes.onInputEditText("You input your Passwork");
                break;
            }
            case R.id.edtEmail: {
                mListenes.onInputEditText("You input your Email");
                break;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbFemale: {
                mListenes.onViewChecked("You is checked Female");
                break;
            }
            case R.id.rbMale: {
                mListenes.onViewChecked("You is checked Male");
                break;
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.swEmail: {
                if (isChecked) {
                    mListenes.onViewChecked(buttonView.getText() + " is On");
                } else {
                    mListenes.onViewChecked(buttonView.getText() + " is Off");
                }
                break;
            }
            case R.id.swEmailSub: {
                if (isChecked) {
                    mListenes.onViewChecked(buttonView.getText() + " is On");
                } else {
                    mListenes.onViewChecked(buttonView.getText() + " is Off");
                }
                break;
            }
        }
    }

    /**
     * Interface is used to listenes to event SignupFragment
     */
    interface OnListenesEventSignUpFragment {
        void onViewChecked(String mMessage);

        void onInputEditText(String mMessage);
    }
}
