package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginUnitTestActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = LoginUnitTestActivity.class.getSimpleName();
    private static final String CHECKVALIDATIONPASS = "Pass";
    private EditText mEdtUserName;
    private EditText mEdtPasswork;
    private Button mBtnClickCheck;
    private UserValidation mUserValidation;
    private List<String> mListErrorUserName;
    private List<String> mListErrorPassWork;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_unittest);
        mUserValidation = new UserValidation();
        mListErrorUserName = new ArrayList<>();
        mListErrorPassWork = new ArrayList<>();
        initListErrorString();
        initViews();
        initEventView();
        Log.e(TAG, "onCreate: " + "đ".codePointAt(0));
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
        mEdtPasswork = findViewById(R.id.edtPasswordUnitTest);
        mBtnClickCheck = findViewById(R.id.btnCheckLogin);
    }

    private void userValudation() {
        try {
            String userName = mEdtUserName.getText().toString().trim();
            String passWork = mEdtPasswork.getText().toString().trim();
            if (!userName.equals("") && !passWork.equals("")) {
                switch (mUserValidation.checkUserName(userName)) {
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
                        break;
                    }
                    case UserValidation.CHECKPASS: {
                        Toast.makeText(this, "UserName :" + CHECKVALIDATIONPASS, Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                switch (mUserValidation.checkPassword(userName, passWork)) {
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
                        break;
                    }
                    case UserValidation.CHECKPASS: {
                        Toast.makeText(this, "Passwork: " + CHECKVALIDATIONPASS, Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Log.e(TAG, "userValudation: " + ex.toString());
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCheckLogin) {
            userValudation();
        }
    }
}
