package vn.asiantech.internship;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import vn.asiantech.internship.model.Person;

public class SqliteFragment extends Fragment implements View.OnClickListener, OnRowTableUserClick {
    private EditText mEdtName;
    private EditText mEdtAge;
    private UserHelper mUserHelper;
    private List<Person> mListUser;
    private TableUserAdapter mAdapter;
    private Person mChoosedUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sqlite, container, false);

        mEdtName = view.findViewById(R.id.edtName);
        mEdtAge = view.findViewById(R.id.edtAge);

        mUserHelper = new UserHelper(getActivity());
        mListUser = mUserHelper.getAllUser();

        Button btnInsert = view.findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);

        Button btnDelete = view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        Button btnResetDatabase = view.findViewById(R.id.btnResetDatabase);
        btnResetDatabase.setOnClickListener(this);

        mAdapter = new TableUserAdapter(mListUser, this);
        RecyclerView recyclerViewTableUser = view.findViewById(R.id.recyclerViewTableUser);
        recyclerViewTableUser.setAdapter(mAdapter);
        recyclerViewTableUser.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInsert: {
                String name = mEdtName.getText().toString();
                String ageS = mEdtAge.getText().toString();
                if (!name.isEmpty() && !ageS.isEmpty()) {
                    Person user = new Person();
                    int ageI = Integer.parseInt(ageS);
                    user.setName(name);
                    user.setAge(ageI);
                    mEdtName.setText(null);
                    mEdtAge.setText(null);
                    mUserHelper.insertUser(user);
                    mListUser.add(mUserHelper.getNewUser());
                    mAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), R.string.warning_empty_name_or_age, Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.btnResetDatabase: {
                mUserHelper.resetDatabase();
                mListUser.clear();
                mAdapter.notifyDataSetChanged();
                break;
            }
            case R.id.btnDelete: {
                if (mChoosedUser != null) {
                    mUserHelper.deleteUser(mChoosedUser);
                    mListUser.remove(mChoosedUser);
                    mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    public void onChooseUser(Person user) {
        mChoosedUser = user;
    }
}
