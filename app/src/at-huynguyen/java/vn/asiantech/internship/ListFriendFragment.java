package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFriendFragment extends Fragment {
//    static final String KEY_POSITION = "position";
//    private int mPosition;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mPosition = getArguments().getInt(KEY_POSITION);
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_listfriend,container,false);
//        TextView tvListFriend = view.findViewById(R.id.tvListFriend);
//        tvListFriend.setText("Page " + mPosition);
        return view;
    }
}
