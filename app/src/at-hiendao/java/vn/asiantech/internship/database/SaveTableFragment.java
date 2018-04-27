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

public class SaveTableFragment extends Fragment implements IEventChangeData, IEventTable {
    private EditText mEdtName;
    private EditText mEdtAge;
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
        mAdapter = new TableAdapter(mData);
        recyclerViewTable.setAdapter(mAdapter);
        initButton(view);
        return view;
    }


    private void initButton(View view) {
        mEdtAge = view.findViewById(R.id.edtAgeDB);
        mEdtName = view.findViewById(R.id.edtNameDB);
        Button btnDelete = view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEdtName.getText().toString().isEmpty()) {
                    String name = mEdtName.getText().toString();
                    Person person = new Person(name, 0);
                    mEventTable.onDeleteTable(person);
                }
            }
        });
        Button btnInsert = view.findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEdtName.getText().toString().isEmpty() && !mEdtAge.getText().toString().isEmpty()) {
                    String name = mEdtName.getText().toString();
                    int age = Integer.parseInt(mEdtAge.getText().toString());
                    Person person = new Person(name, age);
                    mEventTable.onAddTabale(person);
                }
            }
        });
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
}
