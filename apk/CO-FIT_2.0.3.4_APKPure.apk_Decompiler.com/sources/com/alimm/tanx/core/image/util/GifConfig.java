package com.alimm.tanx.core.image.util;

import android.widget.ImageView;
import com.alimm.tanx.core.ad.bean.BaseBean;

public class GifConfig extends BaseBean {
    private int gifRes;
    private String gifUrl;
    private ImageView gifView;

    public GifConfig(ImageView imageView, int i) {
        this.gifView = imageView;
        this.gifRes = i;
    }

    public int getGifRes() {
        return this.gifRes;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public ImageView getGifView() {
        return this.gifView;
    }

    public void setGifRes(int i) {
        this.gifRes = i;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public void setGifView(ImageView imageView) {
        this.gifView = imageView;
    }

    public GifConfig(ImageView imageView, String str) {
        this.gifRes = -1;
        this.gifView = imageView;
        this.gifUrl = str;
    }
}
