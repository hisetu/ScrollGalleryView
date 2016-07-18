package com.veinhorn.scrollgalleryview.loader;

public abstract class YoutubeLoader implements MediaLoader {

    public String getVideoId() {
        return videoId;
    }

    private String videoId;

    public YoutubeLoader(String videoId) {
        this.videoId = videoId;
    }

}
