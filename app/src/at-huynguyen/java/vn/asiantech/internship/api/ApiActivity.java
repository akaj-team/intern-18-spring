package vn.asiantech.internship.api;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.asiantech.internship.R;

public class ApiActivity extends AppCompatActivity {
    private static final String APP_ID = "10";
    private EditText mEdtEnterNameSinger;
    private Button mBtnInfoSinger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        initViews();
        setListeners();
    }

    private void initViews() {
        mEdtEnterNameSinger = findViewById(R.id.edtEnterNameSinger);
        mBtnInfoSinger = findViewById(R.id.btnInfoSinger);
    }

    private void setListeners() {
        mBtnInfoSinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnInfoSinger) {
                    String searchSinger = mEdtEnterNameSinger.getText().toString().trim();
                    if (!TextUtils.isEmpty(searchSinger)) {
                        loadInformationSinger(searchSinger);
                    }
                }
            }
        });
    }

    private void loadInformationSinger(String name) {
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(ApiActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        ApiServices.getApiServices().getIEventApi().getInformationSinger(name, APP_ID).enqueue(new Callback<InformationSinger>() {
            @Override
            public void onResponse(@NonNull Call<InformationSinger> call, @NonNull Response<InformationSinger> response) {
                progressDialog.dismiss();
                if (response.body() != null) {
                    showInformationSinger(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<InformationSinger> call, @NonNull Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    public void showInformationSinger(InformationSinger informationSinger) {
        Intent intent = new Intent(this, InformationSingerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(InformationSingerActivity.IMAGE_SINGER, informationSinger.getImageUrl());
        bundle.putString(InformationSingerActivity.SINGER_NAME, informationSinger.getName());
        bundle.putInt(InformationSingerActivity.NUMBER_TRACKER, informationSinger.getTrackerCount());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
