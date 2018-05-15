package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.MySQLiteHelper;
import vn.asiantech.internship.model.Person;

public class UseSQLiteFragment extends Fragment implements View.OnClickListener, PersonAdapter.OnAdapterListenes {
    private static final String TAG = "UseSQLiteFragment";
    private Button mBtnInsertPerson;
    private Button mBtnDeletePerson;
    private EditText mEdtNamePerson;
    private EditText mEdtAgePerson;
    private RecyclerView mRvListOfPerson;
    private PersonAdapter mPersonAdapter;
    private List<Person> mPersonList;
    private MySQLiteHelper mMySQLiteHelper;
    private int mPersonItemChecked = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_use_sqlite, container, false);

        initView(view);
        initRecycleViewPerson();
        initEventView();

        return view;
    }

    private void initRecycleViewPerson() {
        mPersonList = new ArrayList<>();
        getDataAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRvListOfPerson.setLayoutManager(layoutManager);
        mPersonAdapter = new PersonAdapter(mPersonList, this);

        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        mRvListOfPerson.addItemDecoration(dividerHorizontal);
        mRvListOfPerson.setAdapter(mPersonAdapter);
    }

    public void getDataAdapter() {
        mMySQLiteHelper.updateChangedList(mPersonList);
    }

    public void initView(View view) {
        mBtnInsertPerson = view.findViewById(R.id.btnInsertPerson);
        mBtnDeletePerson = view.findViewById(R.id.btnDeletePerson);
        mEdtNamePerson = view.findViewById(R.id.edtNamePerson);
        mEdtAgePerson = view.findViewById(R.id.edtAgePerson);
        mRvListOfPerson = view.findViewById(R.id.rvListOfPerson);

        mMySQLiteHelper = new MySQLiteHelper(getActivity());
    }

    public void addPersonByDataInput() {
        String name = mEdtNamePerson.getText().toString();
        String sAge = mEdtAgePerson.getText().toString();
        if (!name.equals("") && !sAge.equals("")) {
            int age = Integer.parseInt(sAge);
            mMySQLiteHelper.addNewPerson(new Person(name, age));
            refeshData();
        }
    }

    public void refeshData() {
        mMySQLiteHelper.updateChangedList(mPersonList);
        mPersonAdapter.notifyDataSetChanged();
        clearEdt();
    }

    public void viewPersonByPositon(int position) {
        Person person = mPersonList.get(position);
        mEdtAgePerson.setText(String.valueOf(person.getAge()));
        mEdtNamePerson.setText(person.getName());
    }

    public void clearEdt() {
        mEdtAgePerson.setText("");
        mEdtNamePerson.setText("");
    }

    public void initEventView() {
        mBtnInsertPerson.setOnClickListener(this);
        mBtnDeletePerson.setOnClickListener(this);
    }

    public void deletePersonByPosition(int position) {
        int id = mPersonList.get(position).getId();
        Log.e(TAG, "deletePersonById: " + id);
        mMySQLiteHelper.deletePersonById(id);
        refeshData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInsertPerson: {
                addPersonByDataInput();
                break;
            }
            case R.id.btnDeletePerson: {
                if (mPersonItemChecked != -1) {
                    Log.e(TAG, "deletePersonByPosition: " + mPersonItemChecked);
                    deletePersonByPosition(mPersonItemChecked);
                    mPersonItemChecked = -1;
                }
                break;
            }
        }
    }

    @Override
    public void onPorsonItemSelect(int position) {
        mPersonItemChecked = position;
        viewPersonByPositon(position);
    }
}
