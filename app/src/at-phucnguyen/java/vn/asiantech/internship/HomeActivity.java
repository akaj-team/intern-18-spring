package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button mBtnResrouce;
    private Button mBtnW2Fragment;
    private Button mBtnW1View;
    private Button mBtnW1Intent;
    private Button mBtnViewPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mappingView();
        setEvent();
    }

    public void practicResrouce() {
        Intent mIntent = new Intent(HomeActivity.this, ResourceActivity.class);
        startActivity(mIntent);
    }

    public void mappingView() {
        mBtnW2Fragment = findViewById(R.id.btnFragment);
        mBtnW1View = findViewById(R.id.btnW1View);
        mBtnW1Intent = findViewById(R.id.btnW1Intent);
        mBtnResrouce = findViewById(R.id.btnResource);
        mBtnViewPage = findViewById(R.id.btnViewPage);
    }

    public void setEvent() {
        mBtnW1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(HomeActivity.this, ViewActivity.class);
                startActivity(mIntent);
            }
        });

        mBtnW1Intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(HomeActivity.this, IntentActivity.class);

                //Sử dụng mBundle để gửi dữ liệu
                Bundle mBundle = new Bundle();
                mBundle.putString("keyTitle", "Bundle: ");
                mBundle.putString("keyMessege", "This is data to ActivityHome from by Bundle!");
                mIntent.putExtras(mBundle);

                //Sử dụng intent để gửi dữ liệu
                mIntent.putExtra("keyTitleI", "Intent: ");
                mIntent.putExtra("keyMessegeI", "This is data to ActivityHome from by Intent!");

                //khởi động Intent
                startActivity(mIntent);
            }
        });

        mBtnW2Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(HomeActivity.this, MessageHomeActivity.class);
                startActivity(mIntent);
            }
        });

        mBtnResrouce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practicResrouce();
            }
        });
        mBtnViewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practicViewPage();
            }
        });
    }

    public void practicViewPage() {
        Intent intent = new Intent(HomeActivity.this, PracticViewPageActivity.class);
        startActivity(intent);
    }
}
