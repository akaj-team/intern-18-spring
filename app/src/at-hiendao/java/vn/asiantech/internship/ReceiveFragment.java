package vn.asiantech.internship;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ReceiveFragment extends Fragment implements SendFragment.IEventClick {
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mEmail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_received, container, false);
        mTvName = view.findViewById(R.id.tvName);
        mTvAge = view.findViewById(R.id.tvAge);
        mEmail = view.findViewById(R.id.tvEmail);
        return view;
    }


    @Override
    public void onButtonSendCLick(Bundle data) {
        mTvName.setText(data.getString(getResources().getString(R.string.activity_fragment_name)));
        mTvAge.setText(data.getString(getResources().getString(R.string.activity_fragment_age)));
        mEmail.setText(data.getString(getResources().getString(R.string.activity_fragment_email)));
    }
}

