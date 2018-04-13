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
        ImageView imgUser = findViewById(R.id.imgUser);
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        EditText edtEmail = findViewById(R.id.edtEmail);
        RadioGroup rgMaleFemale = findViewById(R.id.rgMaleFemale);
        RadioButton rbMale = findViewById(R.id.rbMale);
        RadioButton rbFemale = findViewById(R.id.rbFemale);
        Switch swMailSubs = findViewById(R.id.swEmail);
        Switch swAllowEmail = findViewById(R.id.swAllowEmail);

        imgUser.setOnClickListener(this);
        edtUsername.setOnClickListener(this);
        edtPassword.setOnClickListener(this);
        edtEmail.setOnClickListener(this);
        rgMaleFemale.setOnClickListener(this);
        rbMale.setOnClickListener(this);
        rbFemale.setOnClickListener(this);
        swMailSubs.setOnClickListener(this);
        swAllowEmail.setOnClickListener(this);

        edtUsername.setOnFocusChangeListener(this);
        edtPassword.setOnFocusChangeListener(this);
        edtEmail.setOnFocusChangeListener(this);
        rgMaleFemale.setOnFocusChangeListener(this);
        rbMale.setOnFocusChangeListener(this);
        rbFemale.setOnFocusChangeListener(this);

        edtUsername.setOnKeyListener(this);
        edtPassword.setOnKeyListener(this);
        edtEmail.setOnKeyListener(this);

        rgMaleFemale.setOnCheckedChangeListener(this);
        rbMale.setOnCheckedChangeListener(this);
        rbFemale.setOnCheckedChangeListener(this);
        swMailSubs.setOnCheckedChangeListener(this);
        swAllowEmail.setOnCheckedChangeListener(this);
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
