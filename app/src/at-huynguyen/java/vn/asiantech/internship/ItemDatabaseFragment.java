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

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.ItemDatabase;

public class ItemDatabaseFragment extends Fragment implements IEventChangeData, IEventTable {

    private EditText mEdtNameDatabase;
    private EditText mEdtAgeDatabase;
    private DatabaseAdapter mDatabaseAdapter;
    private List<ItemDatabase> mListItemDatabase = new ArrayList<>();
    private DatabaseManager mDatabaseManager;
    private IEventTable mIEventTable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabaseManager = new DatabaseManager(getActivity());
        mDatabaseManager.setListenerChangeItem(this);
        mDatabaseManager.updateItemDatabase(mListItemDatabase);
        mIEventTable = this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_database, container, false);

        initItem(view);
        initRecycleView(view);
        return view;
    }

    private void initItem(View view) {
        mEdtNameDatabase = view.findViewById(R.id.edtNameDatabase);
        mEdtAgeDatabase = view.findViewById(R.id.edtAgeDatabse);
        Button btnInsertDatabase = view.findViewById(R.id.btnInsertDatabase);
        Button btnDeleteDatabase = view.findViewById(R.id.btnDeleteDatabase);
        btnInsertDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mEdtNameDatabase.getText().toString().isEmpty() && !mEdtAgeDatabase.getText().toString().isEmpty()) {
                    String name = mEdtNameDatabase.getText().toString();
                    int age = Integer.parseInt(mEdtAgeDatabase.getText().toString());
                    ItemDatabase itemDatabase = new ItemDatabase(name, age);
                    mIEventTable.onInsertTable(itemDatabase);
                }
            }
        });

        btnDeleteDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mEdtNameDatabase.getText().toString().isEmpty()) {
                    String name = mEdtNameDatabase.getText().toString();
                    ItemDatabase itemDatabase = new ItemDatabase(name, 0);
                    mIEventTable.onDeleteTable(itemDatabase);
                }
            }
        });
    }

    private void initRecycleView(View view) {
        RecyclerView recycleViewDatabase = view.findViewById(R.id.recycleViewDatabase);
        recycleViewDatabase.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDatabaseAdapter = new DatabaseAdapter(mListItemDatabase);
        recycleViewDatabase.setAdapter(mDatabaseAdapter);
    }

    @Override
    public void onInsertTable(ItemDatabase itemDatabase) {
        mDatabaseManager.addItemDatabase(itemDatabase);
    }

    @Override
    public void onDeleteTable(ItemDatabase itemDatabase) {
        mDatabaseManager.deleteItemDatabase(itemDatabase);
    }


    @Override
    public void onChangeData() {
        mDatabaseManager.updateItemDatabase(mListItemDatabase);
        mDatabaseAdapter.notifyDataSetChanged();
    }
}
