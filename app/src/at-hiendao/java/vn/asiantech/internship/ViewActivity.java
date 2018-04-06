package vn.asiantech.internship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

public class ViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        getIntentData();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        EditText editText = findViewById(R.id.etCommentText);
        editText.setText(bundle != null ? bundle.getString("123") : null);
        TextView comment = findViewById(R.id.tvComment);
        comment.setText(intent.getStringExtra("345"));

    }

}
