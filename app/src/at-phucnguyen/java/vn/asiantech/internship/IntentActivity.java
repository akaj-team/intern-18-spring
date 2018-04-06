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
        TextView tvData = findViewById(R.id.tvExtraData);
        TextView tvDataI = findViewById(R.id.tvExtraDataI);

        //Lấy dữ liệu được gửi về bằng bundle đã tạo ở nơi gửi
        Bundle extrasBundle = this.getIntent().getExtras();
        String dataExtras = null;
        if (extrasBundle != null) {
            dataExtras = extrasBundle.getString("keyTitle") +
                    extrasBundle.getString("keyMessege");
        }
        tvData.setText(dataExtras);

        //Lấy dữ liệu được gửi về bằng Intent đã tạo ở nơi gửi
        Intent extrasIntent = this.getIntent();
        String dataExtrasIntent = extrasIntent.getStringExtra("keyTitleI") +
                extrasIntent.getStringExtra("keyMessegeI");
        tvDataI.setText(dataExtrasIntent);
    }
}
