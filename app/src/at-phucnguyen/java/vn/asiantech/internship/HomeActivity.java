package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnW2Fragment = findViewById(R.id.btnFragment);
        Button btnW1View = findViewById(R.id.btnW1View);
        Button btnW1Intent = findViewById(R.id.btnW1Intent);

        btnW1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

        btnW1Intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, IntentActivity.class);

                //Sử dụng bundle để gửi dữ liệu
                Bundle bundle = new Bundle();
                bundle.putString("keyTitle", "Bundle: ");
                bundle.putString("keyMessege", "Đây là dữ liệu từ ActivityHome được gửi bằng Bundle!");
                intent.putExtras(bundle);

                //Sử dụng intent để gửi dữ liệu
                intent.putExtra("keyTitleI", "Intent: ");
                intent.putExtra("keyMessegeI", "Đây là dữ liệu từ ActivityHome được gửi bằng Intent!");

                //khởi động Intent
                startActivity(intent);
            }
        });

        btnW2Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FragmentActivity.class);
                startActivity(intent);
            }
        });
    }
}
