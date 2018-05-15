package vn.asiantech.internship.database;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.R;

public class SaveTableFragment extends Fragment implements IEventChangeData, IEventTable, IEventViewholderClick {
    private EditText mEdtName;
    private EditText mEdtAge;
    private Button mBtnDelete;
    private Button mBtnInsert;
    private IEventTable mEventTable;
    private TableAdapter mAdapter;
    private ReaderDbHelper mDatabase;
    private List<Person> mData = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = new ReaderDbHelper(getActivity());
        mDatabase.setListenerChangeData(this);
        mDatabase.updateListPerson(mData);
        mEventTable = this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save_table, container, false);
        RecyclerView recyclerViewTable = view.findViewById(R.id.recycleViewTable);
        recyclerViewTable.setHasFixedSize(true);
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TableAdapter(mData, this);
        recyclerViewTable.setAdapter(mAdapter);
        initViews(view);
        setListeners(view);
        return view;
    }

    private void setListeners(View view) {
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEdtName.getText().toString();
                if (!name.isEmpty()) {
                    Person person = new Person(name, 0);
                    mEventTable.onDeleteTable(person);
                }
            }
        });
        mBtnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEdtName.getText().toString();
                String age = mEdtAge.getText().toString();
                if (!name.isEmpty() && !age.isEmpty()) {
                    Person person = new Person(name, Integer.valueOf(age));
                    mEventTable.onAddTabale(person);
                }
            }
        });
    }

    void initViews(View view) {
        mEdtAge = view.findViewById(R.id.edtAgeDB);
        mEdtName = view.findViewById(R.id.edtNameDB);
        mBtnDelete = view.findViewById(R.id.btnDelete);
        mBtnInsert = view.findViewById(R.id.btnInsert);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Activity mainActivity = getActivity();
        if (mainActivity instanceof DatabaseActivity) {
            ((DatabaseActivity) mainActivity).showDatabaseLayout(true);
        }
    }

    @Override
    public void onAddTabale(Person person) {
        mDatabase.addPerson(person);
    }

    @Override
    public void onDeleteTable(Person person) {
        mDatabase.deletePerson(person);
    }

    @Override
    public void onChangeData() {
        mDatabase.updateListPerson(mData);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onViewholderClick(Person person) {
        mEdtAge.setText(String.valueOf(person.getAge()));
        mEdtName.setText(person.getName());
    }
}
