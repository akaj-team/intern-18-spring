package vn.asiantech.internship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class UseSharedPreferencesFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private Switch mSwClickMe;
    private final static String TAG = "USPreferencesFragment";
    OnUSPreferencesFragment mLitences;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUSPreferencesFragment) {
            mLitences = (OnUSPreferencesFragment) context;
        } else {
            throw new RuntimeException(context.toString() + "UseSharedPreferencesFragment is null");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_use_sharedpreferences, container, false);

        initView(view);
        initEventView();

        return view;
    }

    private void initEventView() {
        mSwClickMe.setOnCheckedChangeListener(this);
    }

    private void initView(View view) {
        mSwClickMe = view.findViewById(R.id.swSharedPreferences);
        if (this.getArguments() != null) {
            boolean b = getArguments().getBoolean("SwitchStatus");
            Toast.makeText(getActivity(), "In Database Switch is " + (b ? "Checked" : "Not Checked")
                    , Toast.LENGTH_SHORT).show();
            mSwClickMe.setChecked(b);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.swSharedPreferences) {
            Log.e(TAG, "onCheckedChanged: " + isChecked);
            mLitences.onSwitchCheckChanged(isChecked);
        }
    }

    /**
     * Interface is used listenes event on UseSharedPreferencesFragment
     */

    public interface OnUSPreferencesFragment {
        void onSwitchCheckChanged(boolean isCheked);
    }
}
