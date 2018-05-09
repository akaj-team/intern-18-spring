package vn.asiantech.internship;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.Song;

public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.SongHolder> {
    private List<Song> mListSong;
    private OnChooseSongListener mListener;

    ListMusicAdapter(List<Song> listSong, OnChooseSongListener listener) {
        this.mListSong = listSong;
        mListener = listener;
    }

    @Override
    public SongHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_play_list, parent, false);
        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(SongHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (mListSong == null) {
            return 0;
        }
        return mListSong.size();
    }

    class SongHolder extends RecyclerView.ViewHolder {
        private final TextView mTvPosition;
        private final TextView mTvTitle;
        private final TextView mTvArtist;
        private final TextView mTvDuration;

        SongHolder(View itemView) {
            super(itemView);
            mTvPosition = itemView.findViewById(R.id.tvPosition);
            mTvTitle = itemView.findViewById(R.id.tvTitle);
            mTvArtist = itemView.findViewById(R.id.tvArtist);
            mTvDuration = itemView.findViewById(R.id.tvDuration);
            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        mListener.onChooseSong(mListSong.get(getAdapterPosition()));
                    }
                }
            });
        }

        void bind(int position) {
            String number = position + 1 + "";
            mTvPosition.setText(number);
            mTvTitle.setText(mListSong.get(position).getTitle());
            mTvArtist.setText(mListSong.get(position).getArtist());
            mTvDuration.setText(mListSong.get(position).getDurationMS());
        }
    }
}
