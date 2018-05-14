package vn.asiantech.internship;

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
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ItemSaveTextFragment extends Fragment implements View.OnClickListener {
    private final static String TAG = "ItemSaveTextFragment";
    private final static String FILE_PATH = "HuyNguyen";
    private final static String FILE_NAME = "savetext.txt";
    public static final String CHARSET = "UTF-8";
    private Context mContext;
    private File mMyInternalFile;
    private EditText mEdtText;
    private Button mBtnSaveText;
    private TextView mTvShowText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        initFile();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_save_text, container, false);
        initView(view);
        initEventView();
        return view;
    }

    private void initView(View view) {
        mEdtText = view.findViewById(R.id.edtText);
        mBtnSaveText = view.findViewById(R.id.btnSaveText);
        mTvShowText = view.findViewById(R.id.tvShowText);
    }

    private void initEventView() {
        mBtnSaveText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSaveText: {
                if (mEdtText.getText().toString().equals("")) {
                    return;
                }
                writeFile(mEdtText.getText().toString());
                mTvShowText.setText(readFile());
                clearEditText();
                break;
            }
        }
    }

    private void clearEditText() {
        mEdtText.setText("");
    }

    private void initFile() {
        File directory = mContext.getDir(FILE_PATH, Context.MODE_PRIVATE);
        mMyInternalFile = new File(directory, FILE_NAME);
    }

    private void writeFile(String data) {
        FileOutputStream fOS;
        try {
            fOS = new FileOutputStream(mMyInternalFile);
            fOS.write(data.getBytes(Charset.forName(CHARSET)));
            fOS.close();
        } catch (IOException iOE) {
            Log.e(TAG, "writeFile: " + iOE.toString());
        }
    }

    private String readFile() {
        StringBuilder dataRead = new StringBuilder();
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        BufferedReader bufferedReader;
        try {
            fileInputStream = new FileInputStream(mMyInternalFile);
            dataInputStream = new DataInputStream(fileInputStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream, Charset.forName(CHARSET)));

            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                dataRead.append(strLine);
            }
            dataInputStream.close();
        } catch (IOException iOE) {
            Log.e(TAG, "writeFile: " + iOE.toString());
        }
        return dataRead.toString();
    }
}
