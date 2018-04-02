package vn.asiantech.internship;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {
    OnFragmentManager listener;
    EditText edData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_first,container,false);
        Button btnSendData =view.findViewById(R.id.btnSendData);
        edData=view.findViewById(R.id.edData);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragmentSecond();
            }
        });

        return view;
    }

    public interface OnFragmentManager{
        void onDataSelected(String data); // ở đây các bạn truyền dữ liệu cần chuyển qua Fragment kia nhé
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentManager){
            listener =(OnFragmentManager) context;
        }else{
            throw new RuntimeException(context.toString()+ "Error");
        }
    }

    public void startFragmentSecond(){
        listener.onDataSelected(edData.getText().toString());

    }


}
