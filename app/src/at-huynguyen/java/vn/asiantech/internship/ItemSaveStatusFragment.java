package vn.asiantech.internship;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class ItemSaveStatusFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    private Switch mSwSaveStatus;
    private IEventSaveStatus mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IEventSaveStatus) {
            mListener = (IEventSaveStatus) context;
        } else {
            throw new RuntimeException(context.toString() + "ItemSaveStatusFragment is null");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_save_status, container, false);
        initView(view);
        initEventView();
        return view;
    }

    private void initView(View view) {
        mSwSaveStatus = view.findViewById(R.id.swSaveStatus);
        if (this.getArguments() != null) {
            boolean b = getArguments().getBoolean("SaveStatus");
            mSwSaveStatus.setChecked(b);
        }
    }

    private void initEventView() {
        mSwSaveStatus.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.getId() == R.id.swSaveStatus) {
            mListener.onSwitchCheckChanged(isChecked);
        }
    }
}
