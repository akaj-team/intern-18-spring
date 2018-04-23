package vn.asiantech.internship;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    DrawerLayoutAdapter(Context context) {
        mContext = context;
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
        Drawable image;
        switch (position) {
            case 0: {
                HeaderHolder headerHolder = (HeaderHolder) holder;
                headerHolder.mTvEmail.setText(R.string.dummy_email);
                headerHolder.mImgAvatar.setImageResource(R.drawable.ducnguyen);
                headerHolder.mImgCover.setImageResource(R.drawable.default_cover_img);
                break;
            }
            case 1: {
                BodyHolder bodyHolder = (BodyHolder) holder;
                image = mContext.getResources().getDrawable(R.drawable.ic_move_to_inbox_black_24dp);
                image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
                bodyHolder.mTvAction.setCompoundDrawables(image, null, null, null);
                bodyHolder.mTvAction.setText(R.string.inbox);
                break;
            }
            case 2: {
                BodyHolder bodyHolder = (BodyHolder) holder;
                image = mContext.getResources().getDrawable(R.drawable.ic_send_black_24dp);
                image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
                bodyHolder.mTvAction.setCompoundDrawables(image, null, null, null);
                bodyHolder.mTvAction.setText(R.string.outbox);
                break;
            }
            case 3: {
                BodyHolder bodyHolder = (BodyHolder) holder;
                image = mContext.getResources().getDrawable(R.drawable.ic_delete_black_24dp);
                image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
                bodyHolder.mTvAction.setCompoundDrawables(image, null, null, null);
                bodyHolder.mTvAction.setText(R.string.trash);
                break;
            }
            case 4: {
                BodyHolder bodyHolder = (BodyHolder) holder;
                image = mContext.getResources().getDrawable(R.drawable.ic_report_black_24dp);
                image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
                bodyHolder.mTvAction.setCompoundDrawables(image, null, null, null);
                bodyHolder.mTvAction.setText(R.string.spam);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {
        private final ImageView mImgCover;
        private final ImageView mImgAvatar;
        private final TextView mTvEmail;

        private HeaderHolder(View itemView) {
            super(itemView);
            mImgCover = itemView.findViewById(R.id.imgCover);
            mImgAvatar = itemView.findViewById(R.id.imgAvatar);
            mTvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }

    private class BodyHolder extends RecyclerView.ViewHolder {
        private final TextView mTvAction;

        private BodyHolder(View itemView) {
            super(itemView);
            mTvAction = itemView.findViewById(R.id.tvAction);
        }
    }
}
