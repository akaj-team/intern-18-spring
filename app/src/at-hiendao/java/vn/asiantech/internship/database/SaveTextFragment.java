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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

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
            outputStream.write(data.getBytes());
            outputStream.close();
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
        File file = new File(myActivity.getFilesDir(), FILE_NAME);
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
            bufferedReader.close();
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
