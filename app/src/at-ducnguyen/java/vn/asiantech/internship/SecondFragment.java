package vn.asiantech.internship;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nmduc on 03/04/2018.
 */

public class SecondFragment extends Fragment {
    private TextView tvOutput;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tvOutput = (TextView) view.findViewById(R.id.tvOutput);
        String result = getArguments().getString(SendDataActivity.KEY_INPUT);
        tvOutput.setText(result);
        return view;
    }
}
