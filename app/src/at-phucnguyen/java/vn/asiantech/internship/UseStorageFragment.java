package vn.asiantech.internship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class UseStorageFragment extends Fragment implements View.OnClickListener {
    private Context mContext;
    private final static String FILE_PATH = "NguyenVanPhuc";
    private final static String FILE_NAME = "internalStorage.txt";
    private File mMyInternalFile;
    private final static String TAG = "UseStorageFragment";
    private EditText mEdtInputData;
    private Button mBtnSaveData;
    private TextView mTvStorageData;
    public static final String CHARSET = "UTF-8";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        initFile();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_use_storage, container, false);
        initView(view);
        initEventView();
        return view;
    }

    private void initView(View view) {
        mTvStorageData = view.findViewById(R.id.tvStorageData);
        mEdtInputData = view.findViewById(R.id.edtInputData);
        mBtnSaveData = view.findViewById(R.id.btnSaveData);

        mTvStorageData.setText(readFile());
    }

    private void initEventView() {
        mBtnSaveData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSaveData: {
                if (mEdtInputData.getText().toString().equals("")) {
                    return;
                }
                writeFile(mEdtInputData.getText().toString());
                Log.e(TAG, "onClick: Du lieu da duoc luu");
                mTvStorageData.setText(readFile());
                clearEditText();
                break;
            }
        }
    }

    private void clearEditText() {
        mEdtInputData.setText("");
    }

    private void initFile() {
        //Tao or mo file da ton tai trong thu muc co duong dan FILE_PATH
        File directory = mContext.getDir(FILE_PATH, Context.MODE_PRIVATE);
        mMyInternalFile = new File(directory, FILE_NAME);
    }

    private void writeFile(String data) {
        //Khai bao 1 bien de mo fille
        FileOutputStream fOS;
        try {
            //Mo File
            fOS = new FileOutputStream(mMyInternalFile);
            //Ghi du lieu vao file
            fOS.write(data.getBytes(Charset.forName(CHARSET)));
            //Dong file sau khi mo va ghi
            fOS.close();
        } catch (IOException iOE) {
            Log.e(TAG, "writeFile: " + iOE.toString());
        }
    }

    private String readFile() {
        //Khai bao 3 bien de doc file
        StringBuilder dataRead = new StringBuilder();
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        BufferedReader bufferedReader;
        try {
            //Doc File
            fileInputStream = new FileInputStream(mMyInternalFile);
            dataInputStream = new DataInputStream(fileInputStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream, Charset.forName(CHARSET)));

            //Doc tung dong
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                dataRead.append(strLine);
            }

            //Dong file sau khi doc
            dataInputStream.close();
        } catch (IOException iOE) {
            Log.e(TAG, "writeFile: " + iOE.toString());
        }
        return dataRead.toString();
    }
}
