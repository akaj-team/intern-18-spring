package vn.asiantech.internship;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SendFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send, container, false);
        final EditText edtName = view.findViewById(R.id.edtName);
        final EditText edtAge = view.findViewById(R.id.edtAge);
        final EditText edtEmail = view.findViewById(R.id.edtEmailSend);
        Button btnSend = view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString(getResources().getString(R.string.activity_fragment_name), edtName.getText().toString());
                data.putString(getResources().getString(R.string.activity_fragment_age), edtAge.getText().toString());
                data.putString(getResources().getString(R.string.activity_fragment_email), edtEmail.getText().toString());
                ReceiveFragment receiveFragment = new ReceiveFragment();
                receiveFragment.setArguments(data);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().remove(SendFragment.this).commit();
                fragmentManager.beginTransaction().replace(R.id.rlParent, receiveFragment).commit();
            }
        });
        return view;
    }
}
