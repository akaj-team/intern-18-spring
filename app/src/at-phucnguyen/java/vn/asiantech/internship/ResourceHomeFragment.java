package vn.asiantech.internship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ResourceHomeFragment extends Fragment implements View.OnClickListener {
    private OnFragmentResoureHome mOnFmListenesHome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_resource, container, false);
        Button mBtnComment = view.findViewById(R.id.btnCommentResrouce);
        mBtnComment.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentResoureHome) {
            mOnFmListenesHome = (OnFragmentResoureHome) context;
        } else {
            throw new RuntimeException(context.toString() + ":Fragment home chua hoat dong");
        }
    }

    public interface OnFragmentResoureHome {
        void onSendEvent(String mData);

        void onSendEventBtnClick();
    }

    public void openChatView() {
        mOnFmListenesHome.onSendEventBtnClick();
        mOnFmListenesHome.onSendEvent("Message on Resource Home");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCommentResrouce) {
            openChatView();
        }
    }
}
