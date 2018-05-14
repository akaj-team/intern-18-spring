package vn.asiantech.internship.unittest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.asiantech.internship.R;

public class UnitTestActivity extends AppCompatActivity {
    private EditText mEdtUsernameUnitTest;
    private EditText mEdtPasswordUnitTest;
    private Button mBtnLoginUnitTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test);
        initViews();
        setListeners();
    }

    private void initViews() {
        mEdtUsernameUnitTest = findViewById(R.id.edtUsernameUnitTest);
        mEdtPasswordUnitTest = findViewById(R.id.edtPasswordUnitTest);
        mBtnLoginUnitTest = findViewById(R.id.btnLoginUnitTest);
    }

    private void setListeners() {
        mBtnLoginUnitTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
    }

    private void validation() {
        if (!UsernameValidation.isLengthUserName(mEdtUsernameUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.length_user_name, Toast.LENGTH_LONG).show();
        } else if (!UsernameValidation.isTwoUppercaseLetterUsername(mEdtUsernameUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.two_uppercase_letter, Toast.LENGTH_LONG).show();
        } else if (!UsernameValidation.isSpecialCharacterSpaceUsername(mEdtUsernameUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.special_character_space, Toast.LENGTH_LONG).show();
        } else if (!UsernameValidation.isTwoDigitUsername(mEdtUsernameUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.two_digit, Toast.LENGTH_LONG).show();
        } else if (PasswordValidation.isPasswordDifferentUserName(mEdtUsernameUnitTest.getText().toString(), mEdtPasswordUnitTest.getText().toString())) {
            Toast.makeText(this, R.string.password_different_username, Toast.LENGTH_LONG).show();
        } else if (!PasswordValidation.isSpecialCharacterNumberPassword(mEdtPasswordUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.special_character_number, Toast.LENGTH_LONG).show();
        } else if (!PasswordValidation.isLengthPassword(mEdtPasswordUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.length_password, Toast.LENGTH_LONG).show();
        } else if (!PasswordValidation.isDontRepeatCharacterTwicePassword(mEdtPasswordUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.dont_repeat_character_twice, Toast.LENGTH_LONG).show();
        } else if (!PasswordValidation.isSpacePassword(mEdtPasswordUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.space_password, Toast.LENGTH_LONG).show();
        } else if (!PasswordValidation.isThreeUppercaseLetterPassword(mEdtPasswordUnitTest.getText().toString().trim())) {
            Toast.makeText(this, R.string.three_uppercase_letter, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show();
        }
    }
}
