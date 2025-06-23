package com.alimm.tanx.core.image.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.alimm.tanx.core.utils.NotConfused;

public class ImageConfig implements NotConfused {
    private final Context context;
    private int errorId;
    private Drawable errorPlaceholder;
    private tanxc_do imageConfig;
    private Drawable placeHolderDrawable;
    private int placeholderId;
    private final int resId;
    private String url;

    public static class Builder implements NotConfused {
        /* access modifiers changed from: private */
        public final Context context;
        /* access modifiers changed from: private */
        public int errorId;
        /* access modifiers changed from: private */
        public Drawable errorPlaceholder;
        /* access modifiers changed from: private */
        public Drawable placeHolderDrawable;
        /* access modifiers changed from: private */
        public int placeHolderResId;
        /* access modifiers changed from: private */
        public int radius;
        /* access modifiers changed from: private */
        public int resId;
        /* access modifiers changed from: private */
        public ScaleMode scaleMode = ScaleMode.FIT_CENTER;
        /* access modifiers changed from: private */
        public ShapeMode shapeMode = ShapeMode.RECT;
        /* access modifiers changed from: private */
        public String url;

        public Builder(Context context2) {
            this.context = context2;
        }

        public ImageConfig build() {
            return new ImageConfig(this);
        }

        public Builder error(int i) {
            this.errorId = i;
            return this;
        }

        public Builder placeHolder(int i) {
            this.placeHolderResId = i;
            return this;
        }

        public Builder placeHolderDrawable(Drawable drawable) {
            this.placeHolderDrawable = drawable;
            return this;
        }

        public Builder radius(int i) {
            this.radius = i;
            return this;
        }

        public Builder res(int i) {
            this.resId = i;
            return this;
        }

        public Builder scaleMode(ScaleMode scaleMode2) {
            this.scaleMode = scaleMode2;
            return this;
        }

        public Builder shapeMode(ShapeMode shapeMode2) {
            this.shapeMode = shapeMode2;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder error(Drawable drawable) {
            this.errorPlaceholder = drawable;
            return this;
        }
    }

    public interface GifCallback {
        void onFailure(String str);

        void onSuccess();
    }

    public interface ImageBitmapCallback {
        void onFailure(String str);

        void onSuccess(Bitmap bitmap);
    }

    public ImageConfig(Builder builder) {
        this.context = builder.context;
        this.url = builder.url;
        this.resId = builder.resId;
        this.placeholderId = builder.placeHolderResId;
        this.placeHolderDrawable = builder.placeHolderDrawable;
        this.errorId = builder.errorId;
        this.errorPlaceholder = builder.errorPlaceholder;
        this.imageConfig = new tanxc_do(builder.scaleMode, builder.shapeMode, builder.radius);
    }

    public void error(int i) {
        this.errorId = i;
    }

    public Context getContext() {
        return this.context;
    }

    public int getErrorId() {
        return this.errorId;
    }

    public Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public tanxc_do getImageConfig() {
        return this.imageConfig;
    }

    public Drawable getPlaceHolderDrawable() {
        return this.placeHolderDrawable;
    }

    public int getPlaceHolderId() {
        return this.placeholderId;
    }

    public int getResId() {
        return this.resId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setImageConfig(tanxc_do tanxc_do) {
        this.imageConfig = tanxc_do;
    }

    public void setPlaceHolder(int i) {
        this.placeholderId = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void error(Drawable drawable) {
        this.errorPlaceholder = drawable;
    }

    public void setPlaceHolder(Drawable drawable) {
        this.placeHolderDrawable = drawable;
    }
}
