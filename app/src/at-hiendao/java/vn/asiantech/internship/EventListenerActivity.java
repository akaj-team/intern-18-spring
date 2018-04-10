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
        setContentView(R.layout.event_listener_activity);
        initViewListener();
    }

    private void initViewListener() {
        ImageView ImgUser = findViewById(R.id.imgUser);
        EditText EdtUser = findViewById(R.id.edtUserName);
        EditText EdtPassword = findViewById(R.id.edtPassword);
        EditText EdtEmail = findViewById(R.id.edtEmail);
        RadioGroup RgSex = findViewById(R.id.rgSex);
        Switch SwMailSub = findViewById(R.id.swEmailSub);
        Switch SwMailAlow = findViewById(R.id.swEmailAlow);
        ImgUser.setOnClickListener(this);
        ImgUser.setOnLongClickListener(this);
        EdtUser.setOnClickListener(this);
        EdtUser.setOnLongClickListener(this);
        EdtPassword.setOnClickListener(this);
        EdtPassword.setOnLongClickListener(this);
        EdtEmail.setOnClickListener(this);
        EdtEmail.setOnLongClickListener(this);
        RgSex.setOnClickListener(this);
        RgSex.setOnLongClickListener(this);
        RgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(EventListenerActivity.this, "RadioGroup Checked Change",
                        Toast.LENGTH_SHORT).show();
            }
        });
        RgSex.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
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
        SwMailAlow.setOnClickListener(this);
        SwMailAlow.setOnLongClickListener(this);
        SwMailSub.setOnClickListener(this);
        SwMailSub.setOnLongClickListener(this);
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
                Log.e("Error", "id click error");
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
                Log.e("Error", "id longclick error");
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
                Log.e("Error", "id FocusChange error");
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
                Log.e("Error", "id onKey error");
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
                Log.e("Error", "id touch error");
                break;
        }
        return false;
    }
}
