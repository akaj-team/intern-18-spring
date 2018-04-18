package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button mBtnPracticResrouce;
    private Button mBtnPracticRecylerView;
    private Button mBtnPracticEventAndListenes;
    private Button mBtnPracticW2Fragment;
    private Button mBtnPracticW1View;
    private Button mBtnPracticW1Intent;
    private Button mBtnPracticViewPage;
    private Button mBtnPracticMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mappingView();
        setEventView();
    }

    private void setEventView() {
        mBtnPracticW1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(HomeActivity.this, ViewActivity.class);
                startActivity(mIntent);
            }
        });

        mBtnPracticW1Intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, IntentActivity.class);

                //Sử dụng mBundle để gửi dữ liệu
                Bundle mBundle = new Bundle();
                mBundle.putString("keyTitle", "Bundle: ");
                mBundle.putString("keyMessege", "This is data to ActivityHome from by Bundle!");
                intent.putExtras(mBundle);

                //Sử dụng intent để gửi dữ liệu
                intent.putExtra("keyTitleI", "Intent: ");
                intent.putExtra("keyMessegeI", "This is data to ActivityHome from by Intent!");

                //khởi động Intent
                startActivity(intent);
            }
        });

        mBtnPracticW2Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MessageHomeActivity.class);
                startActivity(intent);
            }
        });

        mBtnPracticResrouce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoResrouce();
            }
        });
        mBtnPracticViewPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoViewPage();
            }
        });
        mBtnPracticEventAndListenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoEventAndListenes();
            }
        });
        mBtnPracticMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practicMenuToolBar();
            }
        });
        mBtnPracticRecylerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRecyclerView();
            }
        });
    }

    private void mappingView() {
        mBtnPracticW2Fragment = findViewById(R.id.btnFragment);
        mBtnPracticW1View = findViewById(R.id.btnW1View);
        mBtnPracticRecylerView = findViewById(R.id.btnRecyclerView);
        mBtnPracticW1Intent = findViewById(R.id.btnW1Intent);
        mBtnPracticResrouce = findViewById(R.id.btnResource);
        mBtnPracticEventAndListenes = findViewById(R.id.btnEventAndListenes);
        mBtnPracticViewPage = findViewById(R.id.btnViewPage);
        mBtnPracticMenu = findViewById(R.id.btnMenuToolBar);
    }

    public void gotoViewPage() {
        Intent intent = new Intent(HomeActivity.this, PracticViewPageActivity.class);
        startActivity(intent);
    }

    public void gotoRecyclerView() {
        Intent intent = new Intent(HomeActivity.this, RecyclerViewExampleActivity.class);
        startActivity(intent);
    }

    public void gotoResrouce() {
        Intent intent = new Intent(HomeActivity.this, ResourceActivity.class);
        startActivity(intent);
    }

    public void gotoEventAndListenes() {
        Intent intent = new Intent(HomeActivity.this, SignupActivity.class);
        startActivity(intent);
    }

    public void practicMenuToolBar() {
        Intent intent = new Intent(HomeActivity.this, UserMenuActivity.class);
        startActivity(intent);
    }
}
