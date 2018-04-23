package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.MyMenu;
import vn.asiantech.internship.model.MyMenuHeader;
import vn.asiantech.internship.model.IOnEventListenes;

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int HEADER = 0;
    private final String TAG = "MenuAdapter";
    private List<MyMenu> mMenuList;
    private List<MyMenuHeader> mMenuHeaderList;
    private IOnEventListenes mListener;

    MenuAdapter(List<MyMenu> myMenuList, List<MyMenuHeader> myMenuHeaderList, IOnEventListenes listenes) {
        this.mMenuList = myMenuList;
        this.mMenuHeaderList = myMenuHeaderList;
        this.mListener = listenes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder: " + viewType);
        if (viewType == HEADER) {
            View headerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_headermenu_viewholder, parent, false);
            return new MenuHeaderViewHolder(headerView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_menu_viewholder, parent, false);
            return new MenuItemViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " + position);
        if (holder instanceof MenuHeaderViewHolder) {
            MenuHeaderViewHolder menuHeaderViewHolder = (MenuHeaderViewHolder) holder;
            MyMenuHeader myMenuHeader = mMenuHeaderList.get(position);
            menuHeaderViewHolder.mTvHeaderMenu.setText(myMenuHeader.getEmailHeader());
            Log.e(TAG, "onBindViewHolder: " + myMenuHeader.getUri());
            if (myMenuHeader.getUri() != null) {
                menuHeaderViewHolder.mImgHeaderManu.setImageURI(myMenuHeader.getUri());
            } else if (myMenuHeader.getBitmapHeader() != null) {
                menuHeaderViewHolder.mImgHeaderManu.setImageBitmap(myMenuHeader.getBitmapHeader());
            } else {
                menuHeaderViewHolder.mImgHeaderManu.setImageResource(myMenuHeader.getUrlImgResource());
            }
        } else {
            final MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) holder;
            MyMenu menu = mMenuList.get(position - 1);
            menuItemViewHolder.mTvTitle.setText(menu.getTitleMenu());
        }
    }

    @Override
    public int getItemCount() {
        return mMenuList.size() + mMenuHeaderList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.e(TAG, "getItemViewType: " + position);
        final int ITEMS = 1;
        return position == 0 ? HEADER : ITEMS;
    }

    /**
     * This is class is item row of MyMenu
     */
    class MenuItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvTitle;

        MenuItemViewHolder(View view) {
            super(view);

            initView(view);
        }

        private void initView(View view) {
            mTvTitle = view.findViewById(R.id.tvItemMenu);
        }
    }

    /**
     * This is class is item Header row of MyMenu
     */
    class MenuHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTvHeaderMenu;
        private ImageView mImgHeaderManu;

        MenuHeaderViewHolder(View view) {
            super(view);
            initView(view);
            initEventView();
        }

        private void initEventView() {
            mImgHeaderManu.setOnClickListener(this);
        }

        private void initView(View view) {
            mTvHeaderMenu = view.findViewById(R.id.tvHeaderMenu);
            mImgHeaderManu = view.findViewById(R.id.imgHeaderMenu);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgHeaderMenu: {
                    if (mListener != null) {
                        mListener.onImgHeaderMenuClick();
                    }
                    break;
                }
            }
        }
    }
}
