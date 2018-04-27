package vn.asiantech.internship.database;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.asiantech.internship.R;

public class SaveTextFragment extends Fragment {
    private TextView mTvTextSave;
    private EditText mEdtText;
    private SharedPreferences mSharedPreferences;

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
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEdtText.getText().toString().isEmpty()) {
                    saveStringData(mEdtText.getText().toString());
                }
            }
        });
    }

    private void saveStringData(String data) {
        String key = getActivity().getString(R.string.database_text_save);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, data);
        editor.apply();
        refreshTextSave(data);
    }

    private void refreshTextSave(String text) {
        mTvTextSave.setText(text);
    }

    private void loadStringData() {
        mSharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String key = getActivity().getString(R.string.database_text_save);
        if (!mSharedPreferences.contains(key)) {
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putString(key, "");
            editor.apply();
        }
        mTvTextSave.setText(mSharedPreferences.getString(key, ""));
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
