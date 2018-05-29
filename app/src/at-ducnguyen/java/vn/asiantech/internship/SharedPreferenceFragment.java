package vn.asiantech.internship;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

public class SharedPreferenceFragment extends Fragment {
    private static final String SWITCH_STATE_KEY = "SWITCH SHARED PREFERENCE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shared_preference, container, false);
        final SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        Switch swSharedPreference = view.findViewById(R.id.swSharedPreference);
        swSharedPreference.setChecked(sharedPreferences.getBoolean(SWITCH_STATE_KEY, false));
        swSharedPreference.setOnCheckedChangeListener((compoundButton, b) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(SWITCH_STATE_KEY, b);
            editor.apply();
        });
        return view;
    }
}
