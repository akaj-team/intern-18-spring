package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnPracticResrouce;
    private Button mBtnPracticRecylerView;
    private Button mBtnPracticEventAndListenes;
    private Button mBtnPracticW2Fragment;
    private Button mBtnPracticW1View;
    private Button mBtnPracticW1Intent;
    private Button mBtnPracticViewPage;
    private Button mBtnPracticMenu;
    private Button mBtnPracticDatabase;
    private Button mBtnPracticServices;
    private Button mBtnUseApi;
    private Button mBtnPracticUnitTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mappingView();
        setEventView();
    }

    private void setEventView() {
        mBtnPracticW1View.setOnClickListener(this);
        mBtnPracticW1Intent.setOnClickListener(this);
        mBtnPracticW2Fragment.setOnClickListener(this);
        mBtnPracticResrouce.setOnClickListener(this);
        mBtnPracticViewPage.setOnClickListener(this);
        mBtnPracticEventAndListenes.setOnClickListener(this);
        mBtnPracticMenu.setOnClickListener(this);
        mBtnPracticRecylerView.setOnClickListener(this);
        mBtnPracticDatabase.setOnClickListener(this);
        mBtnPracticServices.setOnClickListener(this);
        mBtnUseApi.setOnClickListener(this);
        mBtnPracticUnitTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnW1View: {
                gotoView();
                break;
            }
            case R.id.btnW1Intent: {
                gotoIntent();
                break;
            }
            case R.id.btnFragment: {
                gotoFragment();
                break;
            }
            case R.id.btnResource: {
                gotoResrouce();
                break;
            }
            case R.id.btnViewPage: {
                gotoViewPage();
                break;
            }
            case R.id.btnEventAndListenes: {
                gotoEventAndListenes();
                break;
            }
            case R.id.btnMenuToolBar: {
                gotoMenuToolBar();
                break;
            }
            case R.id.btnRecyclerView: {
                gotoRecyclerView();
                break;
            }
            case R.id.btnDatabase: {
                gotoDatabase();
                break;
            }
            case R.id.btnServices: {
                gotoServices();
                break;
            }
            case R.id.btnUnitTest: {
                gotoUnitTest();
                break;
            }
            case R.id.btnUseApi: {
                gotoUseApi();
            }
        }
    }

    private void mappingView() {
        mBtnPracticW2Fragment = findViewById(R.id.btnFragment);
        mBtnPracticW1View = findViewById(R.id.btnW1View);
        mBtnPracticRecylerView = findViewById(R.id.btnRecyclerView);
        mBtnPracticW1Intent = findViewById(R.id.btnW1Intent);
        mBtnPracticResrouce = findViewById(R.id.btnResource);
        mBtnPracticEventAndListenes = findViewById(R.id.btnEventAndListenes);
        mBtnPracticViewPage = findViewById(R.id.btnViewPage);
        mBtnUseApi = findViewById(R.id.btnUseApi);
        mBtnPracticMenu = findViewById(R.id.btnMenuToolBar);
        mBtnPracticDatabase = findViewById(R.id.btnDatabase);
        mBtnPracticServices = findViewById(R.id.btnServices);
        mBtnPracticUnitTest = findViewById(R.id.btnUnitTest);
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

    public void gotoUseApi() {
        Intent intent = new Intent(HomeActivity.this, UseApiActivity.class);
        startActivity(intent);
    }

    public void gotoMenuToolBar() {
        Intent intent = new Intent(HomeActivity.this, UserMenuActivity.class);
        startActivity(intent);
    }

    public void gotoFragment() {
        Intent intent = new Intent(HomeActivity.this, MessageHomeActivity.class);
        startActivity(intent);
    }

    public void gotoView() {
        Intent mIntent = new Intent(HomeActivity.this, ViewActivity.class);
        startActivity(mIntent);
    }

    public void gotoIntent() {
        Intent intent = new Intent(HomeActivity.this, IntentActivity.class);

        //Sử dụng mBundle để gửi dữ liệu
        Bundle mBundle = new Bundle();
        mBundle.putString("keyTitle", "Bundle: ");
        mBundle.putString("keyMessege", "This is data to ActivityHome from by Bundle!");
        intent.putExtras(mBundle);

        //Sử dụng mIntent để gửi dữ liệu
        intent.putExtra("keyTitleI", "Intent: ");
        intent.putExtra("keyMessegeI", "This is data to ActivityHome from by Intent!");

        //khởi động Intent
        startActivity(intent);
    }

    public void gotoDatabase() {
        Intent intent = new Intent(HomeActivity.this, MyDatabaseActivity.class);
        startActivity(intent);
    }

    public void gotoServices() {
        Intent intent = new Intent(HomeActivity.this, PlayMusicActivity.class);
        startActivity(intent);
    }

    public void gotoUnitTest() {
        Intent intent = new Intent(HomeActivity.this, LoginUnitTestActivity.class);
        startActivity(intent);
    }
}
