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

public class ItemDatabaseFragment extends Fragment implements IEventChangeData, View.OnClickListener, IEventAdapterListener {

    private EditText mEdtNameDatabase;
    private EditText mEdtAgeDatabase;
    private Button mBtnInsertDatabase;
    private Button mBtnDeleteDatabase;
    private RecyclerView mRecycleView;
    private DatabaseAdapter mDatabaseAdapter;
    private List<ItemDatabase> mListItemDatabase = new ArrayList<>();
    private DatabaseManager mDatabaseManager;
    private int mItemChecked = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabaseManager = new DatabaseManager(getActivity());
        mDatabaseManager.setListenerChangeItem(this);
        mDatabaseManager.updateItemDatabase(mListItemDatabase);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_database, container, false);
        initItem(view);
        initEventView();
        initRecycleView();
        return view;
    }

    private void initItem(View view) {
        mEdtNameDatabase = view.findViewById(R.id.edtNameDatabase);
        mEdtAgeDatabase = view.findViewById(R.id.edtAgeDatabse);
        mBtnInsertDatabase = view.findViewById(R.id.btnInsertDatabase);
        mBtnDeleteDatabase = view.findViewById(R.id.btnDeleteDatabase);
        mRecycleView = view.findViewById(R.id.recycleViewDatabase);
    }

    private void initEventView() {
        mBtnInsertDatabase.setOnClickListener(this);
        mBtnDeleteDatabase.setOnClickListener(this);
    }

    private void initRecycleView() {
        getDataAdapter();
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDatabaseAdapter = new DatabaseAdapter(mListItemDatabase, this);
        mRecycleView.setAdapter(mDatabaseAdapter);
    }

    public void getDataAdapter() {
        mDatabaseManager.updateItemDatabase(mListItemDatabase);
    }

    @Override
    public void onChangeData() {
        mDatabaseManager.updateItemDatabase(mListItemDatabase);
        mDatabaseAdapter.notifyDataSetChanged();
    }

    public void viewItemByPosition(int position) {
        ItemDatabase itemDatabase = mListItemDatabase.get(position);
        mEdtNameDatabase.setText(itemDatabase.getNameDatabase());
        mEdtAgeDatabase.setText(String.valueOf(itemDatabase.getAgeDatabase()));

    }

    public void insertTable() {
        String name = mEdtNameDatabase.getText().toString();
        String age = mEdtAgeDatabase.getText().toString();
        if (!name.equals("") && !age.equals("")) {
            mDatabaseManager.addItemDatabase(new ItemDatabase(name, Integer.valueOf(age)));
            onChangeData();
        }
    }

    public void deleteTable(int position) {
        int id = mListItemDatabase.get(position).getId();
        mDatabaseManager.deleteItemDatabase(id);
        onChangeData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInsertDatabase: {
                insertTable();
                break;
            }
            case R.id.btnDeleteDatabase: {
                if (mItemChecked != -1) {
                    deleteTable(mItemChecked);
                    mItemChecked = -1;
                }
                break;
            }
        }
    }

    @Override
    public void onItemDatabaseSelect(int position) {
        mItemChecked = position;
        viewItemByPosition(position);
    }
}
