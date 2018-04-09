package vn.asiantech.internship;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ResourceHomeFragment extends Fragment {
    OnFragmentResoureHome onFmListenesHome;
    Button btnComment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_resource, container, false);
        btnComment = view.findViewById(R.id.btnCommentResrouce);
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatView();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentResoureHome) {
            onFmListenesHome = (OnFragmentResoureHome) context;
        } else {
            throw new RuntimeException(context.toString() + ":Fragment home chua hoat dong");
        }
    }

    public interface OnFragmentResoureHome {
        void onSendEvent(String data);
        void onSendEventBtnClick();
    }

    public void openChatView() {
        onFmListenesHome.onSendEventBtnClick();
        onFmListenesHome.onSendEvent("Message on Resource Home");
    }
}
