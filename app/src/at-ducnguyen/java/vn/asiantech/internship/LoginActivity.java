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
                if (!isValidate(user.getUserName(), user.getPassword())) {
                    mTvValidate.setText(mValidateMessage);
                }
            }
        });
    }

    private boolean isValidate(String userName, String password) {
        mValidateMessage = "";
        boolean validate = true;
        if (UserValidation.isUserNameLengthValidate(userName)) {
            mValidateMessage += getString(R.string.error_length_user_name) + "\n";
            validate = false;
        }

        if (UserValidation.isUserNameCapitalValidate(userName)) {
            mValidateMessage += getString(R.string.error_capital_user_name) + "\n";
            validate = false;
        }

        if (UserValidation.isUserNameSpecialCharAndSpaceValidate(userName)) {
            mValidateMessage += getString(R.string.error_special_char_and_space_user_name) + "\n";
            validate = false;
        }

        if (UserValidation.isUserNameDigitNumberValidate(userName)) {
            mValidateMessage += getString(R.string.error_digit_number_user_name) + "\n";
            validate = false;
        }

        if (UserValidation.isPasswordSameUserNameValidate(password, userName)) {
            mValidateMessage += getString(R.string.error_difference_username_pass) + "\n";
            validate = false;
        }

        if (!UserValidation.isPasswordSpecialCharOrNumberValidate(password)) {
            mValidateMessage += getString(R.string.error_special_char_or_number_pass) + "\n";
            validate = false;
        }

        if (UserValidation.isPasswordLengthValidate(password)) {
            mValidateMessage += getString(R.string.error_length_pass) + "\n";
            validate = false;
        }

        if (UserValidation.isPasswordRepeatCharValidate(password)) {
            mValidateMessage += getString(R.string.error_repeat_char_pass) + "\n";
            validate = false;
        }

        if (UserValidation.isPasswordSpaceValidate(password)) {
            mValidateMessage += getString(R.string.error_space_pass) + "\n";
            validate = false;
        }

        if (UserValidation.isPasswordCapitalValidate(password)) {
            mValidateMessage += getString(R.string.error_capital_pass) + "\n";
            validate = false;
        }
        return validate;
    }
}
