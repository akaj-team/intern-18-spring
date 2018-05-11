package vn.asiantech.internship.unittest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.asiantech.internship.R;

public class UnitTestActvity extends AppCompatActivity {
    private EditText mEdtUsernameUnitTest;
    private EditText mEdtPasswordUnitTest;
    private Button mBtnLoginUnitTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test);
        initViews();
        initEventView();
    }

    private void initViews() {
        mEdtUsernameUnitTest = findViewById(R.id.edtUsernameUnitTest);
        mEdtPasswordUnitTest = findViewById(R.id.edtPasswordUnitTest);
        mBtnLoginUnitTest = findViewById(R.id.btnLoginUnitTest);
    }

    private void initEventView() {
        mBtnLoginUnitTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
