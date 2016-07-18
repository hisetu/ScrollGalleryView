package com.veinhorn.scrollgalleryview.loader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class YoutubeThumbnailLoader extends YoutubeLoader {
    private View.OnClickListener onClickListener;

    public YoutubeThumbnailLoader(String videoId) {
        super(videoId);
    }

    public YoutubeThumbnailLoader(String videoId, View.OnClickListener onClickListener) {
        super(videoId);
        this.onClickListener = onClickListener;
    }

    @Override
    public boolean isImage() {
        return false;
    }

    @Override
    public void loadMedia(Context context, ImageView imageView, SuccessCallback callback) {

    }

    @Override
    public void loadThumbnail(Context context, ImageView thumbnailView, SuccessCallback callback) {

    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }
}
