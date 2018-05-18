package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginUnitTestActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEdtUserName;
    private EditText mEdtPassword;
    private Button mBtnClickCheck;
    private List<String> mListErrorUserName = new ArrayList<>();
    private List<String> mListErrorPassWork = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_unittest);
        initListErrorString();
        initViews();
        initEventView();
    }

    private void initListErrorString() {
        mListErrorUserName.add("UserName: Length is greater than 7 and less than 24 characters");
        mListErrorUserName.add("UserName:At least 2 characters in uppercase");
        mListErrorUserName.add("UserName:Does not contain special characters and spaces");
        mListErrorUserName.add("UserName:At most 2 digits");

        mListErrorPassWork.add("Passwork: Other username, which distinguishes uppercase characters");
        mListErrorPassWork.add("Passwork:There is at least one special character or number");
        mListErrorPassWork.add("Passwork:The minimum length is 8 characters and can not be repeated 1 " +
                "character more than 2 times");
        mListErrorPassWork.add("Passwork:Does not contain space");
        mListErrorPassWork.add("Passwork:There are at least 3 uppercase letters");
    }

    private void initEventView() {
        mBtnClickCheck.setOnClickListener(this);
    }

    private void initViews() {
        mEdtUserName = findViewById(R.id.edtUseNameUnitTest);
        mEdtPassword = findViewById(R.id.edtPasswordUnitTest);
        mBtnClickCheck = findViewById(R.id.btnCheckLogin);
    }

    private void userValidation() {
        String userName = mEdtUserName.getText().toString().trim();
        String password = mEdtPassword.getText().toString().trim();
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
            switch (UserValidation.checkUserName(userName)) {
                case UserValidation.ERROR_1: {
                    Toast.makeText(this, mListErrorUserName.get(0), Toast.LENGTH_SHORT).show();
                    break;
                }
                case UserValidation.ERROR_2: {
                    Toast.makeText(this, mListErrorUserName.get(1), Toast.LENGTH_SHORT).show();
                    break;
                }
                case UserValidation.ERROR_3: {
                    Toast.makeText(this, mListErrorUserName.get(2), Toast.LENGTH_SHORT).show();
                    break;
                }
                case UserValidation.ERROR_4: {
                    Toast.makeText(this, mListErrorUserName.get(3), Toast.LENGTH_SHORT).show();
                }
            }

            switch (UserValidation.checkPassword(userName, password)) {
                case UserValidation.ERROR_1: {
                    Toast.makeText(this, mListErrorPassWork.get(0), Toast.LENGTH_SHORT).show();
                    break;
                }
                case UserValidation.ERROR_2: {
                    Toast.makeText(this, mListErrorPassWork.get(1), Toast.LENGTH_SHORT).show();
                    break;
                }
                case UserValidation.ERROR_3: {
                    Toast.makeText(this, mListErrorPassWork.get(2), Toast.LENGTH_SHORT).show();
                    break;
                }
                case UserValidation.ERROR_4: {
                    Toast.makeText(this, mListErrorPassWork.get(3), Toast.LENGTH_SHORT).show();
                    break;
                }
                case UserValidation.ERROR_5: {
                    Toast.makeText(this, mListErrorPassWork.get(4), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCheckLogin) {
            userValidation();
        }
    }
}
