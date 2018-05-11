package vn.asiantech.internship;

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
import vn.asiantech.internship.model.SingerInfo;
import vn.asiantech.internship.api.ApiClient;

public class UseApiActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String APP_ID = "1111";

    private EditText mEdtNameSinger;
    private Button mBtnSendRequest;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_api);
        initViews();
        initProgressDialog();
        initEventView();
    }

    private void initProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Send request");
        mProgressDialog.setMessage("Waitting...");
    }

    private void initEventView() {
        mBtnSendRequest.setOnClickListener(this);
    }

    private void initViews() {
        mEdtNameSinger = findViewById(R.id.edtDataSendRequest);
        mBtnSendRequest = findViewById(R.id.btnSendRequest);
    }

    private void getJson(String name) {
        mProgressDialog.show();
        ApiClient.getsApiClient().getApiInterface().getSingerInfo(name, APP_ID)
                .enqueue(new Callback<SingerInfo>() {
                    @Override
                    public void onResponse(@NonNull Call<SingerInfo> call, @NonNull Response<SingerInfo> response) {
                        //call api success
                        mProgressDialog.dismiss();
                        if (response.body() != null) {
                            showSingerInfo(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SingerInfo> call, @NonNull Throwable t) {
                        //call api fail
                        mProgressDialog.dismiss();
                    }
                });
    }

    private void showSingerInfo(SingerInfo singerInfo) {
        Intent intent = new Intent(this, InfoSingerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(InfoSingerActivity.KEY_SINGER_NAME, singerInfo.getName());
        bundle.putInt(InfoSingerActivity.KEY_SINGER_TRACK, singerInfo.getTrackerCount());
        bundle.putString(InfoSingerActivity.KEY_SINGER_IMGURL, singerInfo.getImageUrl());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSendRequest) {
            String keySearch = mEdtNameSinger.getText().toString().trim();
            if (!TextUtils.isEmpty(keySearch)) {
                getJson(keySearch);
            }
        }
    }
}
