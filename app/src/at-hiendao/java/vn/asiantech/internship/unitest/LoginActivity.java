package vn.asiantech.internship.unitest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.asiantech.internship.R;

public class LoginActivity extends Activity {
    private EditText mEdtUserName;
    private EditText mEdtPassWord;
    private TextView mTvStatus;
    private UserValidation mValidation;
    private String mStatus;
    private Button mBtnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test);
        initViews();
        setListeners();
    }

    void initViews() {
        mEdtPassWord = findViewById(R.id.edtPasswordUnitTest);
        mEdtUserName = findViewById(R.id.edtUserNameUnitTest);
        mTvStatus = findViewById(R.id.tvStatus);
        mBtnLogin = findViewById(R.id.btnLogin);
    }

    void setListeners() {
        mBtnLogin.setOnClickListener((view) ->
        {
            mValidation = new UserValidation(mEdtUserName.getText().toString(), mEdtPassWord.getText().toString());
            mStatus = mValidation.valid();
            mTvStatus.setText(String.format("%s\n\n%s", getString(R.string.status), mStatus.toUpperCase()));
        });
    }
}
