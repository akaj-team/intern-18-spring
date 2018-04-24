package vn.asiantech.drawerlayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;

import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.R;

public class ItemMailAdapter extends RecyclerView.Adapter implements IEventItemMail {
    private final List<ItemMail> mListItemMail = new ArrayList<>();
    private final int mNumOfItem = 5;
    private final Context mContext;
    private UserInfo mUserInfo;
    private static final String TAG = "test";


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_mail, parent, false);
            return new Viewholder(view, this);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_background_top_drawerlayout, parent, false);
            mUserInfo = new UserInfo(view);
            return mUserInfo;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position > 0) {
            Viewholder viewholder = (Viewholder) holder;
            viewholder.initViewHolder(mListItemMail.get(position), position);
        } else {
            UserInfo userInfo = (UserInfo) holder;
            ItemMail item = mListItemMail.get(position);
            if (item.getUri() == null) {
                Log.e(TAG, "onBindViewHolder: ");
                userInfo.mImgAvatar.setImageResource(R.drawable.custom_icon_person);
            } else {
                Uri uriAvatar = Uri.fromFile(mUserInfo.getAvatarFilePath());
                Log.e(TAG, "onBindViewHolder: " + uriAvatar.getPath());
                userInfo.mImgAvatar.setImageURI(uriAvatar);
            }
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

    public void resetDrawerLayout() {
        resetColorAllItem();
        notifyDataSetChanged();
    }

    public void changeAvatar(Intent data, boolean isCaturePicture) {
        saveAvatar(data, isCaturePicture);
        mListItemMail.get(0).setUri(Uri.fromFile(mUserInfo.getAvatarFilePath()));
        notifyItemChanged(0);
    }

    private void saveAvatar(Intent data, boolean isCapturePicture) {

        Bitmap bitmap = null;
        if (isCapturePicture) {
            if (data.getExtras() != null) {
                bitmap = (Bitmap) data.getExtras().get("data");
            }
        } else {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File path = mUserInfo.getAvatarFilePath();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            }
        } catch (Exception e) {
            Log.e(TAG, "saveAvatar: " + e.toString());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
            if (i == 0) {
                File avatar = new File(mContext.getFilesDir() + File.separator + UserInfo.AVATAR_USER + ".jpg");
                ItemMail itemMail = new ItemMail(i, Uri.fromFile(avatar));
                mListItemMail.add(itemMail);
            } else {
                ItemMail itemMail = new ItemMail(i, null);
                mListItemMail.add(itemMail);
            }
        }
    }

    /*
        class viewholder for userinfo
     */
    class UserInfo extends RecyclerView.ViewHolder {
        private final ImageView mImgAvatar;
        private final String DIALOG = "Dialog";
        static final String AVATAR_USER = "Avatar_user";

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
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    if (mContext instanceof DrawerLayoutActivity) {
                        ((DrawerLayoutActivity) mContext).startActivityForResult(intent, DrawerLayoutActivity.REQUEST_OPEN_GALLERY);
                    }
                }
            });
            builder.setPositiveButton(mContext.getResources().getString(R.string.text_dialog_use_camera), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (mContext instanceof DrawerLayoutActivity) {
                        ((DrawerLayoutActivity) mContext).startActivityForResult(intent, DrawerLayoutActivity.REQUEST_CAPTURE_PICTURE);
                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        File getAvatarFilePath() {
            String path = mContext.getFilesDir() + File.separator + AVATAR_USER + ".jpg";
            File imgFilePath = new File(path);
            boolean isCreateFile = false;
            if (!imgFilePath.exists()) {
                try {
                    isCreateFile = imgFilePath.createNewFile();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (!isCreateFile) {
                return imgFilePath;
            } else {
                return null;
            }

        }
    }


}
