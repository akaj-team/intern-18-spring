package vn.asiantech.internship.database;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import vn.asiantech.internship.R;

public class SaveTextFragment extends Fragment {
    private TextView mTvTextSave;
    private EditText mEdtText;
    private static final String FILE_NAME = "saveTest.txt";
    private static final String TAG = SaveTextFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_database_save_text, container, false);
        initView(view);
        loadStringData();
        return view;
    }

    private void initView(View view) {
        mTvTextSave = view.findViewById(R.id.tvSaveText);
        mEdtText = view.findViewById(R.id.edtSaveText);
        Button btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            if (!mEdtText.getText().toString().isEmpty()) {
                saveStringData(mEdtText.getText().toString());
            }
        });
    }

    private void saveStringData(String data) {
        FileOutputStream outputStream;
        Activity myActivity = getActivity();
        try {
            outputStream = myActivity.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            BufferedWriter bufferedWriter;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                bufferedWriter.write(data);
                bufferedWriter.close();
            }

        } catch (IOException e) {
            Log.e(TAG, "saveStringData: " + e.toString());
        }
        refreshTextSave(data);
    }

    private void refreshTextSave(String text) {
        mTvTextSave.setText(text);
    }

    private void loadStringData() {
        Activity myActivity = getActivity();
        StringBuilder text = new StringBuilder();
        InputStream inputStream;
        try {
            inputStream = myActivity.openFileInput(FILE_NAME);
            BufferedReader bufferedReader;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    text.append(line);
                    text.append("\n");
                }
                bufferedReader.close();
            }
        } catch (IOException e) {
            Log.e(TAG, "loadStringData: " + e.toString());
        }
        mTvTextSave.setText(text);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Activity mainActivity = getActivity();
        if (mainActivity instanceof DatabaseActivity) {
            ((DatabaseActivity) mainActivity).showDatabaseLayout(true);
        }
    }
}
