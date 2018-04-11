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
import android.widget.Toast;

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
                Toast.makeText(EventListenerActivity.this, "RadioGroup Checked Change",
                        Toast.LENGTH_SHORT).show();
            }
        });
        rgSex.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                Toast.makeText(EventListenerActivity.this, "RadioGroup Hierarchy Change",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {
                Toast.makeText(EventListenerActivity.this, "RadioGroup ChildView Removed",
                        Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "imgUser Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.edtUserName:
                Toast.makeText(this, "Username Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.edtPassword:
                Toast.makeText(this, "Password Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.edtEmail:
                Toast.makeText(this, "Email Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rgSex:
                Toast.makeText(this, "Sex Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.swEmailSub:
                Toast.makeText(this, "Switch Email Sub Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.swEmailAlow:
                Toast.makeText(this, "Switch Email Alow Click", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.imgUser:
                Toast.makeText(this, "imgUser LongClick", Toast.LENGTH_SHORT).show();
                break;

            case R.id.edtUserName:
                Toast.makeText(this, "Username LongClick", Toast.LENGTH_SHORT).show();
                break;

            case R.id.edtPassword:
                Toast.makeText(this, "Password LongClick", Toast.LENGTH_SHORT).show();
                break;

            case R.id.edtEmail:
                Toast.makeText(this, "Email LongClick", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rgSex:
                Toast.makeText(this, "Sex LongClick", Toast.LENGTH_SHORT).show();
                break;

            case R.id.swEmailSub:
                Toast.makeText(this, "Switch Email Sub LongClick", Toast.LENGTH_SHORT).show();
                break;

            case R.id.swEmailAlow:
                Toast.makeText(this, "Switch Email Alow LongClick", Toast.LENGTH_SHORT).show();
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
