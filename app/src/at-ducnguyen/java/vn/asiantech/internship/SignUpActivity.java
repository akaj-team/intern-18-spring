package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity
        implements View.OnClickListener, View.OnLongClickListener, View.OnKeyListener,
        View.OnFocusChangeListener, TextView.OnEditorActionListener, RadioGroup.OnCheckedChangeListener,
        CompoundButton.OnCheckedChangeListener {

    private final String TAG = "LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initWidget();
    }

    private void initWidget() {
        EditText edtUserName = findViewById(R.id.edtUserName);
        EditText edtPassword = findViewById(R.id.edtPassword);
        EditText edtEmail = findViewById(R.id.edtEmail);
        RadioGroup rgSex = findViewById(R.id.rgSex);
        RadioButton rbMale = findViewById(R.id.rbMale);
        RadioButton rbFemale = findViewById(R.id.rbFemale);
        Switch swEmailSub = findViewById(R.id.swEmailSub);
        Switch swEmailOther = findViewById(R.id.swEmailOther);

        edtUserName.setOnClickListener(this);
        edtPassword.setOnClickListener(this);
        edtEmail.setOnClickListener(this);
        rgSex.setOnClickListener(this);
        rbMale.setOnClickListener(this);
        rbFemale.setOnClickListener(this);

        edtUserName.setOnFocusChangeListener(this);
        edtPassword.setOnFocusChangeListener(this);
        edtEmail.setOnFocusChangeListener(this);
        rgSex.setOnFocusChangeListener(this);
        rbMale.setOnFocusChangeListener(this);
        rbFemale.setOnFocusChangeListener(this);

        edtUserName.setOnLongClickListener(this);
        edtPassword.setOnLongClickListener(this);
        edtEmail.setOnLongClickListener(this);
        rgSex.setOnLongClickListener(this);
        rbMale.setOnLongClickListener(this);
        rbFemale.setOnLongClickListener(this);

        edtUserName.setOnKeyListener(this);
        edtPassword.setOnKeyListener(this);
        edtEmail.setOnKeyListener(this);
        rgSex.setOnKeyListener(this);
        rbMale.setOnKeyListener(this);
        rbFemale.setOnKeyListener(this);

        edtUserName.setOnEditorActionListener(this);
        edtPassword.setOnEditorActionListener(this);
        edtEmail.setOnEditorActionListener(this);

        rgSex.setOnCheckedChangeListener(this);
        rbMale.setOnCheckedChangeListener(this);
        rbFemale.setOnCheckedChangeListener(this);

        swEmailOther.setOnCheckedChangeListener(this);
        swEmailSub.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edtUserName: {
                Log.d(TAG, "onClick: UserName");
                break;
            }
            case R.id.edtPassword: {
                Log.d(TAG, "onClick: Password");
                break;
            }
            case R.id.edtEmail: {
                Log.d(TAG, "onClick: Email");
                break;
            }
        }
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.edtUserName: {
                Log.d(TAG, "onLongClick: UserName");
                break;
            }
            case R.id.edtPassword: {
                Log.d(TAG, "onLongClick: Password");
                break;
            }
            case R.id.edtEmail: {
                Log.d(TAG, "onLongClick: Email");
                break;
            }
        }
        return false;
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (view.getId()) {
            case R.id.edtUserName: {
                Log.d(TAG, "onKey: UserName" + keyEvent);
                break;
            }
            case R.id.edtPassword: {
                Log.d(TAG, "onKey: Password" + keyEvent);
                break;
            }
            case R.id.edtEmail: {
                Log.d(TAG, "onKey: Email" + keyEvent);
                break;
            }
        }
        return false;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.edtUserName: {
                Log.d(TAG, "onFocusChange: UserName " + b);
                break;
            }
            case R.id.edtPassword: {
                Log.d(TAG, "onFocusChange: Password " + b);
                break;
            }
            case R.id.edtEmail: {
                Log.d(TAG, "onFocusChange: Email " + b);
                break;
            }
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        switch (textView.getId()) {
            case R.id.edtUserName: {
                Log.d(TAG, "onEditorAction: UserName ");
                break;
            }
            case R.id.edtPassword: {
                Log.d(TAG, "onEditorAction: Password " + i);
                break;
            }
            case R.id.edtEmail: {
                Log.d(TAG, "onEditorAction: Email " + i);
                break;
            }
        }
        return false;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbMale: {
                Log.d(TAG, "onCheckedChanged: rbMale " + i);
                break;
            }
            case R.id.rbFemale: {
                Log.d(TAG, "onCheckedChanged: rbFemale " + i);
                break;
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.rbMale: {
                Log.d(TAG, "onCheckedChanged: rbMale " + b);
                break;
            }
            case R.id.rbFemale: {
                Log.d(TAG, "onCheckedChanged: rbFemale " + b);
                break;
            }
            case R.id.swEmailSub: {
                Log.d(TAG, "onCheckedChanged: swEmailSub " + b);
                break;
            }
            case R.id.swEmailOther: {
                Log.d(TAG, "onCheckedChanged: swEmailOther " + b);
                break;
            }
        }
    }
}
