package vn.asiantech.internship;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;


public class EventListenerActivity extends Activity implements View.OnClickListener,
        View.OnLongClickListener, View.OnFocusChangeListener, View.OnKeyListener,
        View.OnTouchListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_listener);
        initViewListener();
    }

    private void initViewListener() {
        ImageView imgUser = findViewById(R.id.imgUser);
        EditText edtUser = findViewById(R.id.edtUserName);
        EditText edtPassword = findViewById(R.id.edtPassword);
        EditText edtEmail = findViewById(R.id.edtEmail);
        RadioGroup rgSex = findViewById(R.id.rgSex);
        Switch swMailSub = findViewById(R.id.swEmailSub);
        Switch swMailAlow = findViewById(R.id.swEmailAlow);
        imgUser.setOnClickListener(this);
        imgUser.setOnLongClickListener(this);
        edtUser.setOnClickListener(this);
        edtUser.setOnLongClickListener(this);
        edtPassword.setOnClickListener(this);
        edtPassword.setOnLongClickListener(this);
        edtEmail.setOnClickListener(this);
        edtEmail.setOnLongClickListener(this);
        rgSex.setOnClickListener(this);
        rgSex.setOnLongClickListener(this);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.e("CheckedChange", "RadioGroup Checked Change: ");
            }
        });
        rgSex.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                Log.e("ChildViewAdded", "RadioGroup Hierarchy Change ");
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {
                Log.e("ChildViewRemoved", "RadioGroup ChildView Removed ");
            }
        });
        swMailAlow.setOnClickListener(this);
        swMailAlow.setOnLongClickListener(this);
        swMailSub.setOnClickListener(this);
        swMailSub.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgUser:
                Log.e("imgUser Click", "imgUser Click");
                break;

            case R.id.edtUserName:
                Log.e("Username Click", "Username Click");
                break;

            case R.id.edtPassword:
                Log.e("Password Click", "Password Click");
                break;

            case R.id.edtEmail:
                Log.e("Email Click", "Email Click");
                break;

            case R.id.rgSex:
                Log.e("Sex Click", "Sex Click");
                break;

            case R.id.swEmailSub:
                Log.e("Switch Email Sub Click", "Switch Email Sub Click");
                break;

            case R.id.swEmailAlow:
                Log.e("Switch Email Alow Click", "Switch Email Alow Click");
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.imgUser:
                Log.e("imgUser LongClick", "imgUser LongClick");
                break;

            case R.id.edtUserName:
                Log.e("Username LongClick", "Username LongClick");
                break;

            case R.id.edtPassword:
                Log.e("Password LongClick", "Password LongClick");
                break;

            case R.id.edtEmail:
                Log.e("Email LongClick", "Email LongClick");
                break;

            case R.id.rgSex:
                Log.e("Sex LongClick", "Sex LongClick");
                break;

            case R.id.swEmailSub:
                Log.e("Email Sub LongClick", "Switch Email Sub LongClick");
                break;

            case R.id.swEmailAlow:
                Log.e("Email Alow LongClick", "Switch Email Alow LongClick");
                break;

            default:
                break;
        }
        return false;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.imgUser:
                break;

            case R.id.edtUserName:
                break;

            case R.id.edtPassword:
                break;

            case R.id.edtEmail:
                break;

            case R.id.rgSex:
                break;

            case R.id.swEmailSub:
                break;

            case R.id.swEmailAlow:
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (v.getId()) {
            case R.id.imgUser:
                break;

            case R.id.edtUserName:
                break;

            case R.id.edtPassword:
                break;

            case R.id.edtEmail:
                break;

            case R.id.rgSex:
                break;

            case R.id.swEmailSub:
                break;

            case R.id.swEmailAlow:
                break;

            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        v.performClick();
        switch (v.getId()) {
            case R.id.imgUser:
                break;

            case R.id.edtUserName:
                break;

            case R.id.edtPassword:
                break;

            case R.id.edtEmail:
                break;

            case R.id.rgSex:
                break;

            case R.id.swEmailSub:
                break;

            case R.id.swEmailAlow:
                break;

            default:
                Log.e("Touch Error", "id touch error");
                break;
        }
        return false;
    }
}
