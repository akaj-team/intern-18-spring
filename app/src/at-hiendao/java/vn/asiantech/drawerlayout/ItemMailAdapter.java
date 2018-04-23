package vn.asiantech.drawerlayout;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.R;

public class ItemMailAdapter extends RecyclerView.Adapter implements IEventItemMail {
    private final List<ItemMail> mListItemMail = new ArrayList<>();
    private final int mNumOfItem = 5;
    private final Context mContext;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_mail, parent, false);
            return new Viewholder(view, this);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_background_top_drawerlayout, parent, false);
            return new UserInfo(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position > 0) {
            Viewholder viewholder = (Viewholder) holder;
            viewholder.initViewHolder(mListItemMail.get(position), position);
        }
    }


    ItemMailAdapter(Context context) {
        mContext = context;
        createListItemMail();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mListItemMail.size();
    }


    @Override
    public void onItemMailClick(int position) {
        resetColorAllItem();
        mListItemMail.get(position).setIsSelected(true);
        notifyDataSetChanged();
    }

    private void resetColorAllItem() {
        for (int i = 0; i < mNumOfItem; i++) {
            mListItemMail.get(i).setIsSelected(false);
        }
    }

    public void resetDrawerLayout()
    {
        resetColorAllItem();
        notifyDataSetChanged();
    }

    /*
        class viewholder in adapter recycleview
     */
    class Viewholder extends RecyclerView.ViewHolder {
        private final ImageView mImgIcon;
        private final TextView mTvName;
        private final ImageView mImgBackground;
        private final List<Integer> mListImage = new ArrayList<>();
        private final IEventItemMail mEventItemMail;

        Viewholder(View itemView, IEventItemMail eventItemMail) {

            super(itemView);
            mEventItemMail = eventItemMail;
            mImgIcon = itemView.findViewById(R.id.imgIconItem);
            mTvName = itemView.findViewById(R.id.tvItemMail);
            mImgBackground = itemView.findViewById(R.id.imgBackGroundItem);
            mImgBackground.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListItemMail.get(getAdapterPosition()).setIsSelected(true);
                    mEventItemMail.onItemMailClick(getAdapterPosition());
                }
            });
            initListImage();
        }

        private void initListImage() {
            for (int i = 0; i < mNumOfItem; i++) {
                if (i == 0) {
                    mListImage.add(R.drawable.custom_icon_inbox);
                } else if (i == 1) {
                    mListImage.add(R.drawable.custom_icon_outbox);
                } else if (i == 2) {
                    mListImage.add(R.drawable.custom_icon_trash);
                } else {
                    mListImage.add(R.drawable.custom_icon_spam);
                }
            }
        }

        void initViewHolder(ItemMail itemMail, int position) {
            if (position > 0) {
                mImgIcon.setImageResource(mListImage.get(position - 1));
                mTvName.setText(itemMail.getName());
                if (itemMail.isSelected()) {
                    mTvName.setTextColor(Color.BLUE);
                    mImgIcon.setColorFilter(Color.BLUE);
                } else {
                    mTvName.setTextColor(Color.BLACK);
                    mImgIcon.setColorFilter(Color.BLACK);
                }
            }
        }

    }

    private void createListItemMail() {
        for (int i = 0; i < mNumOfItem; i++) {
            ItemMail itemMail = new ItemMail(i);
            mListItemMail.add(itemMail);
        }
    }

    /*
        class viewholder for userinfo
     */
    class UserInfo extends RecyclerView.ViewHolder {
        private final ImageView mImgAvatar;
        private final String DIALOG = "Dialog";
        UserInfo(View itemView) {
            super(itemView);
            mImgAvatar = itemView.findViewById(R.id.imgAvatarUser);
            mImgAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAvatarClick();
                }
            });
        }

        private void onAvatarClick() {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setMessage(mContext.getResources().getString(R.string.title_dialog_drawer)).setTitle(DIALOG);

            builder.setNeutralButton(mContext.getResources().getString(R.string.text_dialog_select_image), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.e("xxx", "onClick: " );
                }
            });
            builder.setPositiveButton(mContext.getResources().getString(R.string.text_dialog_use_camera), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.e("xxx", "onClick: " );
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }


}
