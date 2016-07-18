package com.veinhorn.scrollgalleryview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.veinhorn.scrollgalleryview.loader.YoutubeThumbnailLoader;

public class YouTubeThumbnailFragment extends Fragment implements YouTubeThumbnailView.OnInitializedListener {
    public static String key;
    private YouTubeThumbnailLoader thumbnailLoader;
    private MediaInfo mediaInfo;

    public static void initialize(String key) {
        YouTubeThumbnailFragment.key = key;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        YouTubeThumbnailView thumbnailView = new YouTubeThumbnailView(getActivity());
        thumbnailView.initialize(key, this);
        return thumbnailView;
    }

    @Override
    public void onDestroy() {
        if (thumbnailLoader != null)
            thumbnailLoader.release();
        super.onDestroy();
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
        thumbnailLoader = youTubeThumbnailLoader;
        YoutubeThumbnailLoader loader = (YoutubeThumbnailLoader) mediaInfo.getLoader();
        thumbnailLoader.setVideo(loader.getVideoId());
        youTubeThumbnailView.setOnClickListener(loader.getOnClickListener());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
        youTubeInitializationResult.getErrorDialog(getActivity(), 0).show();
    }
}
