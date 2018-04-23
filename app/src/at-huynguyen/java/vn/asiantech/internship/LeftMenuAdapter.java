package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class LeftMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER = 0;
    private static final int ITEM = 1;
    private final List<MenuItem> mListMenuItem;

    LeftMenuAdapter(List<MenuItem> ListMenuItem) {
        mListMenuItem = ListMenuItem;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_menu, parent, false);
                return new HeaderViewHolder(view);
            case ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left_menu, parent, false);
                return new ItemLeftMenuHolder(view);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuItem menuItem = mListMenuItem.get(position);
        switch (getItemViewType(position)) {
            case HEADER:
                ((HeaderViewHolder) holder).mImgBtnAvatar.setImageResource(menuItem.getAvatar());
                ((HeaderViewHolder) holder).mTvName.setText(menuItem.getName());
                ((HeaderViewHolder) holder).mTvEmail.setText(menuItem.getEmail());
                break;
            case ITEM:
                ((ItemLeftMenuHolder) holder).mImgItem.setImageResource(menuItem.getItem());
                ((ItemLeftMenuHolder) holder).mTvItem.setText(menuItem.getNameItem());
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mListMenuItem == null) {
            return 0;
        } else {
            return mListMenuItem.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final ImageButton mImgBtnAvatar;
        private final TextView mTvName;
        private final TextView mTvEmail;

        HeaderViewHolder(View itemView) {
            super(itemView);
            mImgBtnAvatar = itemView.findViewById(R.id.imgBtnAvatar);
            mTvName = itemView.findViewById(R.id.tvName);
            mTvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }

    public class ItemLeftMenuHolder extends RecyclerView.ViewHolder {
        private final ImageView mImgItem;
        private final TextView mTvItem;

        ItemLeftMenuHolder(View itemView) {
            super(itemView);
            mImgItem = itemView.findViewById(R.id.imgItem);
            mTvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
