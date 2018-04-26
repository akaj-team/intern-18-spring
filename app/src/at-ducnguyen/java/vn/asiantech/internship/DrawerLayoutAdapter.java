package vn.asiantech.internship;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.BodyDrawer;
import vn.asiantech.internship.model.HeaderDrawer;

public class DrawerLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_TYPE = 0;
    private Context mContext;
    private OnChangeAvatarListener mListener;
    private HeaderDrawer mHeaderDrawer;
    private List<BodyDrawer> mListItemBody;

    DrawerLayoutAdapter(Context context, List<BodyDrawer> listItemBody, HeaderDrawer headerDrawer) {
        mContext = context;
        mHeaderDrawer = headerDrawer;
        mListItemBody = listItemBody;
    }

    public void setOnChangeAvatarListener(OnChangeAvatarListener listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case HEADER_TYPE: {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_header_drawer_layout, parent, false);
                return new HeaderHolder(view);
            }
            default: {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_body_drawer_layout, parent, false);
                return new BodyHolder(view);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case HEADER_TYPE: {
                HeaderHolder headerHolder = (HeaderHolder) holder;
                if (mHeaderDrawer.getAvatar() == null) {
                    headerHolder.mImgAvatar.setImageResource(R.drawable.ducnguyen);
                } else {
                    headerHolder.mImgAvatar.setImageURI(mHeaderDrawer.getAvatar());
                }
                break;
            }
            default: {
                BodyHolder bodyHolder = (BodyHolder) holder;
                bodyHolder.bindHolder(position - 1);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 1 + mListItemBody.size();
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {
        private final ImageView mImgAvatar;

        private HeaderHolder(final View itemView) {
            super(itemView);
            mImgAvatar = itemView.findViewById(R.id.imgAvatar);
            mImgAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog();
                }
            });
        }
    }

    private class BodyHolder extends RecyclerView.ViewHolder {
        private final TextView mTvAction;

        private BodyHolder(View itemView) {
            super(itemView);
            mTvAction = itemView.findViewById(R.id.tvAction);
        }

        private void bindHolder(int position) {
            BodyDrawer item = mListItemBody.get(position);
            Drawable image;
            image = mContext.getResources().getDrawable(item.getIcon());
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
            mTvAction.setCompoundDrawables(image, null, null, null);
            mTvAction.setText(item.getText());
        }
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(mContext);
        dialog.setTitle(R.string.choose_image);
        dialog.setContentView(R.layout.fragment_dialog_change_avatar);
        dialog.show();

        Button btnChooseFromGalery = dialog.findViewById(R.id.btnChooseFromGalery);
        Button btnTakeAPhoto = dialog.findViewById(R.id.btnTakeAPhoto);

        btnChooseFromGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onChooseFromGalery();
                dialog.cancel();
            }
        });
        btnTakeAPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onTakeANewPhoto();
                dialog.cancel();
            }
        });
    }
}
