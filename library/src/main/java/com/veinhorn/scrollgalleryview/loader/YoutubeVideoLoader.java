package com.veinhorn.scrollgalleryview.loader;

import android.content.Context;
import android.widget.ImageView;

public class YoutubeVideoLoader extends YoutubeLoader {
    public YoutubeVideoLoader(String videoId) {
        super(videoId);
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
}
