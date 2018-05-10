package vn.asiantech.internship;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {
    private static final String APP_ID = "10";
    private EditText mEdtEnterNameSinger;
    private Button mBtnInfoSinger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        initView();
        mBtnInfoSinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnInfoSinger: {
                        String searchSinger = mEdtEnterNameSinger.getText().toString();
                        if (!searchSinger.equals("")) {
                            loadInformationSinger(searchSinger);
                        }
                        break;
                    }
                }
            }
        });
    }

    public void initView() {
        mEdtEnterNameSinger = findViewById(R.id.edtEnterNameSinger);
        mBtnInfoSinger = findViewById(R.id.btnInfoSinger);
    }

    public void loadInformationSinger(String name) {
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(ApiActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ApiServices.getApiServices().getIEventApi().getInformationSinger(name, APP_ID).enqueue(new Callback<InformationSinger>() {
            @Override
            public void onResponse(@NonNull Call<InformationSinger> call, @NonNull Response<InformationSinger> response) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    showInformationSinger(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<InformationSinger> call, @NonNull Throwable t) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });
    }

    public void showInformationSinger(InformationSinger informationSinger) {
        Intent intent = new Intent(this, InformationSingerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(String.valueOf(R.string.imagesinger), informationSinger.getImageUrl());
        bundle.putString(String.valueOf(R.string.singername), informationSinger.getName());
        bundle.putInt(String.valueOf(R.string.numbertracker), informationSinger.getTrackerCount());
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
