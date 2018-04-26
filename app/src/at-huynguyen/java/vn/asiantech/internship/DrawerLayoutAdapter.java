package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import vn.asiantech.internship.model.HeaderMenu;
import vn.asiantech.internship.model.LeftMenu;

public class DrawerLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER = 0;
    private static final int ITEM = 1;
    private List<HeaderMenu> mListHeaderMenu;
    private List<LeftMenu> mListLeftMenu;
    private OnChangeAvatarClickListener mOnChangeAvatarClickListener;

    DrawerLayoutAdapter(List<HeaderMenu> listHeaderItem, List<LeftMenu> listLeftMenu) {
        mListHeaderMenu = listHeaderItem;
        mListLeftMenu = listLeftMenu;
    }

    public void setOnChangeAvatarClickListener(OnChangeAvatarClickListener listener) {
        mOnChangeAvatarClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_menu, parent, false);
                return new HeaderMenuViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left_menu, parent, false);
                return new LeftMenuViewHolder(view);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEADER:
                if (holder instanceof HeaderMenuViewHolder) {
                    HeaderMenu headerMenu = mListHeaderMenu.get(position);
                    if (headerMenu.getAvatar() != null) {
                        ((HeaderMenuViewHolder) holder).mImgBtnAvatar.setImageURI(headerMenu.getAvatar());
                    } else {
                        ((HeaderMenuViewHolder) holder).mImgBtnAvatar.setImageResource(R.drawable.custom_circle);

                    }
                    ((HeaderMenuViewHolder) holder).mTvName.setText(headerMenu.getNameHeader());
                    ((HeaderMenuViewHolder) holder).mTvEmail.setText(headerMenu.getEmailHeader());
                }
                break;
            case ITEM:
                LeftMenu leftMenu = mListLeftMenu.get(position - 1);
                ((LeftMenuViewHolder) holder).mImgItem.setImageResource(leftMenu.getItem());
                ((LeftMenuViewHolder) holder).mTvItem.setText(leftMenu.getNameItem());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mListHeaderMenu.size() + mListLeftMenu.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public class HeaderMenuViewHolder extends RecyclerView.ViewHolder {

        private ImageButton mImgBtnAvatar;
        private TextView mTvName;
        private TextView mTvEmail;

        HeaderMenuViewHolder(View itemView) {
            super(itemView);
            mImgBtnAvatar = itemView.findViewById(R.id.imgBtnAvatar);
            mTvName = itemView.findViewById(R.id.tvName);
            mTvEmail = itemView.findViewById(R.id.tvEmail);
            mImgBtnAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.imgBtnAvatar: {
                            if (mOnChangeAvatarClickListener != null) {
                                mOnChangeAvatarClickListener.onChangeAvatarClick();
                            }
                            break;
                        }
                    }
                }
            });
        }
    }

    public class LeftMenuViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImgItem;
        private final TextView mTvItem;

        LeftMenuViewHolder(View itemView) {
            super(itemView);
            mImgItem = itemView.findViewById(R.id.imgItem);
            mTvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
