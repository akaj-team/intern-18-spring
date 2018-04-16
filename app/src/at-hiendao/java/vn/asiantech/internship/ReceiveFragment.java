package vn.asiantech.internship;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ReceiveFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_received, container, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvAge = view.findViewById(R.id.tvAge);
        TextView tvEmail = view.findViewById(R.id.tvEmail);
        Bundle data = getArguments();
        tvName.setText(data.getString(getResources().getString(R.string.activity_fragment_name)));
        tvAge.setText(data.getString(getResources().getString(R.string.activity_fragment_age)));
        tvEmail.setText(data.getString(getResources().getString(R.string.activity_fragment_email)));
        return view;
    }
}

