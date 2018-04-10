package vn.asiantech.internship;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class UserActivity extends Activity implements View.OnClickListener,View.OnLongClickListener, View.OnTouchListener, View.OnFocusChangeListener, View.OnKeyListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initSetIdAndEvent();
    }
    private void initSetIdAndEvent(){
        ImageView mImgUser = findViewById(R.id.imgUser);
        EditText mEdtUsername = findViewById(R.id.edtUsername);
        EditText mEdtPassword = findViewById(R.id.edtPassword);
        EditText mEdtEmail = findViewById(R.id.edtEmail);
        RadioGroup mRgMaleFemale = findViewById(R.id.rgMaleFemale);
        RadioButton mRbMale = findViewById(R.id.rbMale);
        RadioButton mRbFemale = findViewById(R.id.rbFemale);
        Switch mSwMailSubs = findViewById(R.id.swEmail);
        Switch mSwAllowEmail = findViewById(R.id.swAllowEmail);

        mImgUser.setOnClickListener(this);
        mEdtUsername.setOnClickListener(this);
        mEdtPassword.setOnClickListener(this);
        mEdtEmail.setOnClickListener(this);
        mRgMaleFemale.setOnClickListener(this);
        mRbMale.setOnClickListener(this);
        mRbFemale.setOnClickListener(this);
        mSwMailSubs.setOnClickListener(this);
        mSwAllowEmail.setOnClickListener(this);

        mEdtUsername.setOnFocusChangeListener(this);
        mEdtPassword.setOnFocusChangeListener(this);
        mEdtEmail.setOnFocusChangeListener(this);
        mRgMaleFemale.setOnFocusChangeListener(this);
        mRbMale.setOnFocusChangeListener(this);
        mRbFemale.setOnFocusChangeListener(this);

        mEdtUsername.setOnKeyListener(this);
        mEdtPassword.setOnKeyListener(this);
        mEdtEmail.setOnKeyListener(this);

        mRgMaleFemale.setOnCheckedChangeListener(this);
        mRbMale.setOnCheckedChangeListener(this);
        mRbFemale.setOnCheckedChangeListener(this);
        mSwMailSubs.setOnCheckedChangeListener(this);
        mSwAllowEmail.setOnCheckedChangeListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgUser: {
                Log.d("ImgUser Click", "Image User");
                break;
            }
            case R.id.edtUsername: {
                Log.d("EdtUsername Click", "Please input your Username");
                break;
            }
            case R.id.edtPassword: {
                Log.d("EdtPassword Click", "Please input your Password");
                break;
            }
            case R.id.edtEmail:{
                Log.d("EdtEMail Click","Please input your Email");
            }
            case R.id.rgMaleFemale:{
                Log.d("RgMaleFemale","Please choose Male or Female");
            }
            case R.id.swEmail: {
                Log.d("SwEmail Click", "Please input your Password");
                break;
            }
            case R.id.swAllowEmail:{
                Log.d("SwAllowEmail","Please choose Male or Female");
            }
        }
    }
    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.imgUser: {
                Log.d("ImgUser LongClick","Image User");
                break;
            }
            case R.id.edtUsername: {
                Log.d("EdtUsername LongClick", "Please input your Username");
                break;
            }
            case R.id.edtPassword: {
                Log.d("EdtPassword LongClick", "Please input your Password");
                break;
            }
            case R.id.edtEmail:{
                Log.d("EdtEMail LongClick","Please input your Email");
            }
            case R.id.rgMaleFemale:{
                Log.d("RgMaleFemale LongClick","Please choose Male or Female");
            }
            case R.id.swEmail:{
                Log.d("SwEMail LongClick","Please choose On or OFF");
            }
            case R.id.swAllowEmail:{
                Log.d("SwMaleFemale LongClick","Please choose ON or OFF");
            }
        }
        return false;
    }
    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.imgUser:
                break;

            case R.id.edtUsername:
                break;

            case R.id.edtPassword:
                break;

            case R.id.edtEmail:
                break;

            case R.id.rgMaleFemale:
                break;

            case R.id.swEmail:
                break;

            case R.id.swAllowEmail:
                break;
        }

    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (view.getId()) {
            case R.id.edtUsername: {
                Log.d("EdtUsername onKey", "UserName onKey" + keyEvent);
                break;
            }
            case R.id.edtPassword: {
                Log.d("EdtPassword onKey", "Password onKey" + keyEvent);
                break;
            }
            case R.id.edtEmail: {
                Log.d("EdtEmail onKey", "Email onKey" + keyEvent);
                break;
            }
        }
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.performClick();
        switch (view.getId()) {
            case R.id.imgUser:
                break;

            case R.id.edtUsername:
                break;

            case R.id.edtPassword:
                break;

            case R.id.edtEmail:
                break;

            case R.id.rgMaleFemale:
                break;

            case R.id.swEmail:
                break;

            case R.id.swAllowEmail:
                break;
        }
        return false;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbMale:
                break;

            case R.id.rbFemale:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.rbMale: {
                Log.d("RbMale","Male onCheckchanged");
                break;
            }
            case R.id.rbFemale: {
                Log.d("RbFemale","Female onCheckchanged");
                break;
            }
            case R.id.swEmail: {
                Log.d("SwEmail","SwitchEmail onCheckchanged");
                break;
            }
            case R.id.swAllowEmail: {
                Log.d("SwAllowEmail","SwitchAllowEmail onCheckchanged");
                break;
            }
        }
    }
}
