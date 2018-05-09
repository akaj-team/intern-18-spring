package vn.asiantech.internship;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.asiantech.internship.model.SingerInfo;
import vn.asiantech.internship.rest.ApiClient;

public class UseApiActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "UseApiActivity";
    private static final String APP_ID = "1111";

    private EditText mEdtNameSinger;
    private Button mBtnSendRequest;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_api);

        initView();
        initProgressDialog();
        initEventView();
    }

    public void initProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Send request");
        mProgressDialog.setMessage("Waitting...");
    }

    public void initEventView() {
        mBtnSendRequest.setOnClickListener(this);
    }

    public void initView() {
        mEdtNameSinger = findViewById(R.id.edtDataSendRequest);
        mBtnSendRequest = findViewById(R.id.btnSendRequest);
    }

    public void getJson(String name) {
        Log.e(TAG, "getJson: ");
        mProgressDialog.show();

        ApiClient.getsApiClient().getmApiInterface().getSingerInfo(name, APP_ID)
                .enqueue(new Callback<SingerInfo>() {
                    @Override
                    public void onResponse(@NonNull Call<SingerInfo> call, @NonNull Response<SingerInfo> response) {
                        //call api success
                        Log.e(TAG, "onResponse: " + response.body());
                        if (mProgressDialog.isShowing()) {
                            mProgressDialog.dismiss();
                            showSingerInfo(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SingerInfo> call, @NonNull Throwable t) {
                        //call api fail
                        Log.e(TAG, "onFailure: " + t);
                        if (mProgressDialog.isShowing()) {
                            mProgressDialog.dismiss();
                        }
                    }

                });
    }

    public void showSingerInfo(SingerInfo singerInfo) {
        Intent intent = new Intent(this, InfoSingerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(String.valueOf(R.string.key_singername), singerInfo.getName());
        bundle.putInt(String.valueOf(R.string.key_singertrack), singerInfo.getTracker_count());
        bundle.putString(String.valueOf(R.string.key_singer_url_img), singerInfo.getImage_url());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendRequest: {
                String keySearch = mEdtNameSinger.getText().toString();
                if (!keySearch.equals("")) {
                    getJson(keySearch);
                }
                break;
            }
        }
    }
}
