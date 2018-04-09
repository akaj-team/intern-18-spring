package vn.asiantech.internship;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ResourcesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resources_fragment, container, false);
        TextView mTimeLeft = view.findViewById(R.id.tvTimeLeft);
        TextView mTimeRigh = view.findViewById(R.id.tvTimeRight);
        SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss a", Locale.ENGLISH);
        String currentTime = fm.format(Calendar.getInstance().getTime());
        mTimeLeft.setText(currentTime);
        mTimeRigh.setText(currentTime);
        return view;
    }

}
