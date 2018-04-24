package vn.asiantech.internship;

import vn.asiantech.internship.model.HeaderDrawer;

public interface OnChangeAvatarListener {
    void onChooseFromGalery(HeaderDrawer headerDrawer);
    void onTakeANewPhoto(HeaderDrawer headerDrawer);
}
