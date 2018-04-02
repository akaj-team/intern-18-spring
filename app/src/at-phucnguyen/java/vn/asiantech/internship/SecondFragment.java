package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment{
    TextView edData;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second, container, false);
        String dataFragmentA=getArguments().getString("keyData");//Day la du lieu tu Fragment A
        edData=view.findViewById(R.id.tvPareData);
        edData.setText(dataFragmentA);
        return view;
    }
}

