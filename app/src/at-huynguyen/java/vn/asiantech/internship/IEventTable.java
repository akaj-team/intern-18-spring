package vn.asiantech.internship;

import vn.asiantech.internship.model.ItemDatabase;

public interface IEventTable {
    void onInsertTable(ItemDatabase itemDatabase);
    void onDeleteTable(ItemDatabase itemDatabase);
}
