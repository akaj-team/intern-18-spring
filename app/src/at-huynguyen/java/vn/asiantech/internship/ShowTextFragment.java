package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowTextFragment extends Fragment {
    private TextView mTvName;
    private TextView mTvSex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_text, container, false);

        mTvName = view.findViewById(R.id.tvNameText);
        mTvSex = view.findViewById(R.id.tvSexText);

        return view;
    }


    public void showText(String nameText, String sexText) {
        mTvName.setText(nameText);
        mTvSex.setText(sexText);
    }
}

