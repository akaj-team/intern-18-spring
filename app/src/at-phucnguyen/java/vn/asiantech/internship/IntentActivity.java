package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //Anh xa
        TextView mTvData = findViewById(R.id.tvExtraData);
        TextView mTvDataI = findViewById(R.id.tvExtraDataI);

        //Lấy dữ liệu được gửi về bằng bundle đã tạo ở nơi gửi
        Bundle mExtrasBundle = this.getIntent().getExtras();
        String mDataExtras = null;
        if (mExtrasBundle != null) {
            mDataExtras = mExtrasBundle.getString("keyTitle") +
                    mExtrasBundle.getString("keyMessege");
        }
        mTvData.setText(mDataExtras);

        //Lấy dữ liệu được gửi về bằng Intent đã tạo ở nơi gửi
        Intent mExtrasIntent = this.getIntent();
        String mDataExtrasIntent = mExtrasIntent.getStringExtra("keyTitleI") +
                mExtrasIntent.getStringExtra("keyMessegeI");
        mTvDataI.setText(mDataExtrasIntent);
    }
}
