package vn.asiantech.internship.unitest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.asiantech.internship.R;

public class LoginActivity extends Activity {
    private EditText mEdtUserName;
    private EditText mEdtPassWord;
    private TextView mTvStatus;
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
        mBtnLogin.setOnClickListener((view) -> {
            String userName = mEdtUserName.getText().toString().trim();
            String password = mEdtPassWord.getText().toString().trim();
            if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
                User user = new User(userName, password);
                mStatus = UserValidation.valid(user);
                mTvStatus.setText(mStatus);
            }
        });
    }
}
