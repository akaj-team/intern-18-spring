package vn.asiantech.internship;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class StorageFragment extends Fragment implements View.OnClickListener {
    public static final String FILE_NAME = "nmduc.txt";
    public static final String CHARSET = "UTF-8";
    public static final String TAG = "EXCEPTION";
    public static final String MSG = "OPS! FOUND EXCEPTION";
    private List<String> mListInternal;
    private List<String> mListExternal;
    private StorageAdapter mStorageAdapter;
    private EditText mEdtInput;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storage, container, false);

        mEdtInput = view.findViewById(R.id.edtInput);
        Button btnInternal = view.findViewById(R.id.btnSaveInternal);
        btnInternal.setOnClickListener(this);

        Button btnExternal = view.findViewById(R.id.btnSaveExternal);
        btnExternal.setOnClickListener(this);

        Button btnClearInternal = view.findViewById(R.id.btnClearInternal);
        btnClearInternal.setOnClickListener(this);

        Button btnClearExternal = view.findViewById(R.id.btnClearExternal);
        btnClearExternal.setOnClickListener(this);

        getDataFromInternal();
        getDataFromExternal();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        mStorageAdapter = new StorageAdapter(mListInternal, mListExternal);
        recyclerView.setAdapter(mStorageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    private void getDataFromInternal() {
        try {
            mListInternal = new ArrayList<>();
            mListInternal.add(getString(R.string.internal));
            FileInputStream inputStream = getActivity().openFileInput(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(CHARSET)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                mListInternal.add(line);
            }
            inputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            Log.e(TAG, MSG, e );
        }
    }

    private void getDataFromExternal() {
        File extStore = Environment.getExternalStorageDirectory();
        String path = extStore.getPath() + "/" + FILE_NAME;
        File file = new File(path);
        try {
            mListExternal = new ArrayList<>();
            mListExternal.add(getString(R.string.external));
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, Charset.forName(CHARSET)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                mListExternal.add(line);
            }
            fileInputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            Log.e(TAG, MSG, e );
        }
    }

    public void onInternalSave(String data) {
        FileOutputStream outputStream;
        try {
            outputStream = getActivity().openFileOutput(FILE_NAME, Context.MODE_APPEND);
            outputStream.write((data + "\n").getBytes(Charset.forName(CHARSET)));
            outputStream.close();
            mListInternal.add(data);
            mStorageAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.e(TAG, MSG, e );
        }

    }

    public void onInternalClear() {
        File directory = getActivity().getFilesDir();
        File file = new File(directory, FILE_NAME);
        if (file.delete()) {
            mListInternal.clear();
            mListInternal.add(getString(R.string.internal));
            mStorageAdapter.notifyDataSetChanged();
            Toast.makeText(getActivity(), R.string.clear_success, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), R.string.clear_cancel, Toast.LENGTH_SHORT).show();
        }
    }

    public void onExternalSave(String data) {
        File extStore = Environment.getExternalStorageDirectory();
        String path = extStore.getPath() + "/" + FILE_NAME;

        File file = new File(path);

        try {
            if (file.createNewFile()) {
                Toast.makeText(getActivity(), R.string.make_new_file, Toast.LENGTH_SHORT).show();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(data.getBytes(Charset.forName(CHARSET)));
            fileOutputStream.close();
            mListExternal.add(data);
            mStorageAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.e(TAG, MSG, e );
        }
    }

    public void onExternalClear() {
        File extStore = Environment.getExternalStorageDirectory();
        String path = extStore.getPath() + "/" + FILE_NAME;
        File file = new File(path);
        if (file.delete()) {
            mListExternal.clear();
            mListExternal.add(getString(R.string.external));
            mStorageAdapter.notifyDataSetChanged();
            Toast.makeText(getActivity(), R.string.clear_success, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), R.string.clear_cancel, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSaveInternal: {
                onInternalSave(mEdtInput.getText().toString());
                mEdtInput.setText(null);
                break;
            }
            case R.id.btnSaveExternal: {
                onExternalSave(mEdtInput.getText().toString());
                mEdtInput.setText(null);
                break;
            }
            case R.id.btnClearInternal: {
                onInternalClear();
                break;
            }
            case R.id.btnClearExternal: {
                onExternalClear();
                break;
            }
        }
    }
}
