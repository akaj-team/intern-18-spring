package vn.asiantech.drawerlayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.provider.MediaStore;
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
    private List<ItemMail> mListItemMail;
    private final int mNumOfItem = 5;
    private final Context mContext;
    private static final String TAG = ItemMailAdapter.class.getSimpleName();
    private static final int TYPE_ITEM_MAIL = 1;
    public static final int TYPE_USER_INFO = 0;

    ItemMailAdapter(Context context, List<ItemMail> itemMails) {
        mContext = context;
        mListItemMail = itemMails;
    }

    private void resetColorAllItem() {
        for (int i = 0; i < mNumOfItem; i++) {
            mListItemMail.get(i).setIsSelected(false);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_MAIL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_mail, parent, false);
            return new Viewholder(view, this);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_background_top_drawerlayout, parent, false);
            return new UserInfo(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindView(holder, position);
    }

    private void onBindView(RecyclerView.ViewHolder holder, int position) {
        if (position == TYPE_USER_INFO) {
            UserInfo userInfo = (UserInfo) holder;
            ItemMail item = mListItemMail.get(position);
            if (item.getUri() == null) {
                Log.e(TAG, "onBindViewHolder: ");
                userInfo.mImgAvatar.setImageResource(R.drawable.custom_icon_person);
            } else {
                Log.e(TAG, "onBindViewHolder: " + mListItemMail.get(position).getUri());
                userInfo.mImgAvatar.setImageURI(mListItemMail.get(position).getUri());
            }
        } else {
            Viewholder viewholder = (Viewholder) holder;
            ItemMail itemMail = mListItemMail.get(position);
            viewholder.initViewHolder(itemMail, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_USER_INFO;
        } else {
            return TYPE_ITEM_MAIL;
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
            mImgBackground.setOnClickListener(v -> {
                mListItemMail.get(getAdapterPosition()).setIsSelected(true);
                mEventItemMail.onItemMailClick(getAdapterPosition());
            });
            initListImage();
        }

        private void initListImage() {
            for (int i = 0; i < mNumOfItem; i++) {
                if (i == ItemMail.ItemMailType.Inbox.ordinal()) {
                    mListImage.add(R.drawable.custom_icon_inbox);
                } else if (i == ItemMail.ItemMailType.Outbox.ordinal()) {
                    mListImage.add(R.drawable.custom_icon_outbox);
                } else if (i == ItemMail.ItemMailType.Trash.ordinal()) {
                    mListImage.add(R.drawable.custom_icon_trash);
                } else {
                    mListImage.add(R.drawable.custom_icon_spam);
                }
            }
        }

        void initViewHolder(ItemMail itemMail, int position) {
            if (position > 0) {
                mImgIcon.setImageResource(mListImage.get(position));
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

    /*
        class viewholder for userinfo
     */
    class UserInfo extends RecyclerView.ViewHolder {
        private final ImageView mImgAvatar;
        private final String DIALOG = "Dialog";


        UserInfo(View itemView) {
            super(itemView);
            mImgAvatar = itemView.findViewById(R.id.imgAvatarUser);
            mImgAvatar.setOnClickListener(v -> onAvatarClick());
        }

        private void onAvatarClick() {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setMessage(mContext.getResources().getString(R.string.title_dialog_drawer)).setTitle(DIALOG);

            builder.setNeutralButton(mContext.getResources().getString(R.string.text_dialog_select_image), (dialog, which) -> {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                if (mContext instanceof DrawerLayoutActivity) {
                    ((DrawerLayoutActivity) mContext).startActivityForResult(intent, DrawerLayoutActivity.REQUEST_OPEN_GALLERY);
                }
            });
            builder.setPositiveButton(mContext.getResources().getString(R.string.text_dialog_use_camera), (dialog, which) -> {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (mContext instanceof DrawerLayoutActivity) {
                    ((DrawerLayoutActivity) mContext).startActivityForResult(intent, DrawerLayoutActivity.REQUEST_CAPTURE_PICTURE);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

}
