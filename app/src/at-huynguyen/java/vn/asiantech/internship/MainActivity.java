package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button btn_comment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_comment = (Button) findViewById(R.id.btn_comment);
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
//    @Nullable
//    @Override
//    public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        View view = inflater.inflate(R.layout.activity_main,container,false);
//        return view;
//    }
