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
import android.widget.Switch;

import vn.asiantech.internship.R;

public class StateButtonFragment extends Fragment {
    private Switch mSwState;
    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_database_savestate_button, container, false);
        mSwState = view.findViewById(R.id.swSwitchDatabase);
        loadData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Activity mainActivity = getActivity();
        if (mainActivity instanceof DatabaseActivity) {
            ((DatabaseActivity) mainActivity).showDatabaseLayout(true);
        }
        saveData();
    }

    private void loadData() {
        mSharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        if (!mSharedPreferences.contains(getActivity().getString(R.string.database_state_switch))) {
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putBoolean(getActivity().getString(R.string.database_state_switch), false);
            editor.apply();
        }
        boolean state = mSharedPreferences.getBoolean(getActivity().getString(R.string.database_state_switch), false);
        mSwState.setChecked(state);
    }

    private void saveData() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(getActivity().getString(R.string.database_state_switch), mSwState.isChecked());
        editor.apply();
    }

}
