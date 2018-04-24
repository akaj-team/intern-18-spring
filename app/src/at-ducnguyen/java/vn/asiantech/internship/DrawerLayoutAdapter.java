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

import vn.asiantech.internship.model.HeaderDrawer;

public class DrawerLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnChangeAvatarListener mListener;
    private HeaderDrawer mHeaderDrawer;

    DrawerLayoutAdapter(Context context) {
        mContext = context;
        mHeaderDrawer = new HeaderDrawer();
    }

    public void setOnChangeAvatarListener(OnChangeAvatarListener listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0: {
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
            case 0: {
                HeaderHolder headerHolder = (HeaderHolder) holder;
                if (mHeaderDrawer.getAvatar() == null) {
                    headerHolder.mImgAvatar.setImageResource(R.drawable.ducnguyen);
                } else {
                    headerHolder.mImgAvatar.setImageURI(mHeaderDrawer.getAvatar());
                }
                break;
            }
            case 1: {
                setView(holder, R.drawable.ic_move_to_inbox_black_24dp, R.string.inbox);
                break;
            }
            case 2: {
                setView(holder, R.drawable.ic_send_black_24dp, R.string.outbox);
                break;
            }
            case 3: {
                setView(holder, R.drawable.ic_delete_black_24dp, R.string.trash);
                break;
            }
            case 4: {
                setView(holder, R.drawable.ic_report_black_24dp, R.string.spam);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 5;
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
    }

    private void setView(RecyclerView.ViewHolder holder, int drawable, int text) {
        Drawable image;
        BodyHolder bodyHolder = (BodyHolder) holder;
        image = mContext.getResources().getDrawable(drawable);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        bodyHolder.mTvAction.setCompoundDrawables(image, null, null, null);
        bodyHolder.mTvAction.setText(text);
    }

    private void showDialog() {
        Dialog dialog = new Dialog(mContext);
        dialog.setTitle(R.string.choose_image);
        dialog.setContentView(R.layout.fragment_dialog_change_avatar);
        dialog.show();

        Button btnChooseFromGalery = dialog.findViewById(R.id.btnChooseFromGalery);
        Button btnTakeAPhoto = dialog.findViewById(R.id.btnTakeAPhoto);

        btnChooseFromGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onChooseFromGalery(mHeaderDrawer);
            }
        });
        btnTakeAPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onTakeANewPhoto(mHeaderDrawer);
            }
        });
    }
}
