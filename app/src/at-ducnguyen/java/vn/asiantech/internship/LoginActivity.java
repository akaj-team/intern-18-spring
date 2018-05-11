package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.asiantech.internship.model.User;

public class LoginActivity extends AppCompatActivity {
    private EditText mEdtUserName;
    private EditText mEdtPassword;
    private TextView mTvValidate;
    private Button mBtnLogin;

    private boolean mValidate;
    private String mValidateMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        initListener();
    }

    private void initViews() {
        mEdtUserName = findViewById(R.id.edtUserName);
        mEdtPassword = findViewById(R.id.edtPassword);

        mTvValidate = findViewById(R.id.tvValidate);

        mBtnLogin = findViewById(R.id.btnLogin);
    }

    private void initListener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUserName(mEdtUserName.getText().toString().trim());
                user.setPassword(mEdtPassword.getText().toString().trim());
                checkValidate(user.getUserName(), user.getPassword());
                if (!mValidate) {
                    mTvValidate.setText(mValidateMessage);
                }
            }
        });
    }

    private void checkValidate(String userName, String password) {
        mValidateMessage = "";
        mValidate = true;
        if (UserValidation.userNameLengthValidate(userName)) {
            mValidateMessage += getString(R.string.error_length_user_name) + "\n";
            mValidate = false;
        }

        if (UserValidation.userNameCapitalValidate(userName)) {
            mValidateMessage += getString(R.string.error_capital_user_name) + "\n";
            mValidate = false;
        }

        if (UserValidation.userNameSpecialCharAndSpaceValidate(userName)) {
            mValidateMessage += getString(R.string.error_special_char_and_space_user_name) + "\n";
            mValidate = false;
        }

        if (UserValidation.userNameDigitNumberValidate(userName)) {
            mValidateMessage += getString(R.string.error_digit_number_user_name) + "\n";
            mValidate = false;
        }

        if (UserValidation.passwordDifferenceUserNameValidate(password, userName)) {
            mValidateMessage += getString(R.string.error_difference_username_pass) + "\n";
            mValidate = false;
        }

        if (!UserValidation.passwordSpecialCharOrNumberValidate(password)) {
            mValidateMessage += getString(R.string.error_special_char_or_number_pass) + "\n";
            mValidate = false;
        }

        if (UserValidation.passwordLengthValidate(password)) {
            mValidateMessage += getString(R.string.error_length_pass) + "\n";
            mValidate = false;
        }

        if (UserValidation.passwordRepeatCharValidate(password)) {
            mValidateMessage += getString(R.string.error_repeat_char_pass) + "\n";
            mValidate = false;
        }

        if (UserValidation.passwordSpaceValidate(password)) {
            mValidateMessage += getString(R.string.error_space_pass) + "\n";
            mValidate = false;
        }

        if (UserValidation.passwordCapitalValidate(password)) {
            mValidateMessage += getString(R.string.error_capital_pass) + "\n";
            mValidate = false;
        }
    }
}
