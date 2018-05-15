package vn.asiantech.internship;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

public class ItemSaveStatusFragment extends Fragment {
    private final static String SHARED_PREFERENCES_NAME = "SaveStatusSharedPreferences";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_save_status, container, false);
        Switch swSaveStatus = view.findViewById(R.id.swSaveStatus);
        final SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        swSaveStatus.setChecked(sharedPreferences.getBoolean(SHARED_PREFERENCES_NAME, false));
        swSaveStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(SHARED_PREFERENCES_NAME, b);
                editor.apply();
            }
        });
        return view;
    }
}
