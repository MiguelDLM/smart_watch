package com.baidu.navisdk.imageloader.config;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.imageloader.interfaces.ImageLoaderRequestListener;
import com.baidu.navisdk.imageloader.target.ImageLoaderBitmapTarget;
import com.baidu.navisdk.imageloader.target.ImageLoaderCustomTarget;
import com.baidu.navisdk.imageloader.target.ImageLoaderCustomViewTarget;
import com.baidu.navisdk.imageloader.target.ImageLoaderDrawableTarget;
import com.baidu.navisdk.imageloader.target.ImageLoaderGifTarget;

/* loaded from: classes7.dex */
public class ImageConfig {
    private boolean asBitmap;
    private int borderColor;
    private int borderWidth;
    private Context context;
    private ImageDiskCacheStrategy diskCacheStrategy;
    private Drawable errorDrawable;
    private int errorResId;
    private int errorScaleType;
    private int height;
    private ImageLoaderBitmapTarget imageLoaderBitmapTarget;
    private ImageLoaderCustomTarget imageLoaderCustomTarget;
    private ImageLoaderCustomViewTarget imageLoaderCustomViewTarget;
    private ImageLoaderDrawableTarget imageLoaderDrawableTarget;
    private ImageLoaderGifTarget imageLoaderGifTarget;
    private ImageLoaderRequestListener imageLoaderRequestListener;
    private boolean isCrossFade;
    private boolean isDontAnimate;
    private boolean isFile;
    private boolean isGif;
    private boolean isMemoryCache;
    private boolean isPreload;
    private boolean isToBytes;
    private boolean isdontTransform;
    private Drawable placeHolderDrawable;
    private int placeHolderResId;
    private int placeHolderScaleType;
    private ImagePriority priority;
    private int rectRoundRadius;
    private int scaleMode;
    private int shapeMode;
    private Object source;
    private ImageView targetView;
    private int width;

    /* loaded from: classes7.dex */
    public static class ConfigBuilder {
        private boolean asBitmap;
        private int borderColor;
        private int borderWidth;
        private Context context;
        private ImageDiskCacheStrategy diskCacheStrategy;
        private Drawable errorDrawable;
        private int errorResId;
        private int errorScaleType;
        private int height;
        private ImageLoaderBitmapTarget imageLoaderBitmapTarget;
        private ImageLoaderCustomTarget imageLoaderCustomTarget;
        private ImageLoaderCustomViewTarget imageLoaderCustomViewTarget;
        private ImageLoaderDrawableTarget imageLoaderDrawableTarget;
        private ImageLoaderGifTarget imageLoaderGifTarget;
        private ImageLoaderRequestListener imageLoaderRequestListener;
        private boolean isToBytes;
        private Drawable placeHolderDrawable;
        private int placeHolderResId;
        private int placeHolderScaleType;
        private ImagePriority priority;
        private int rectRoundRadius;
        private int shapeMode;
        private Object source;
        private ImageView targetView;
        private int width;
        private boolean isMemoryCache = true;
        private boolean isPreload = false;
        private boolean isGif = false;
        private boolean isFile = false;
        private boolean isDontAnimate = false;
        private boolean isCrossFade = false;
        private boolean isdontTransform = false;
        private int scaleMode = 0;

        public ConfigBuilder(Context context) {
            this.context = context;
        }

        public ConfigBuilder asBitmap() {
            this.asBitmap = true;
            return this;
        }

        public ConfigBuilder asCircle() {
            this.shapeMode = 2;
            return this;
        }

        public ConfigBuilder asFile() {
            this.isFile = true;
            return this;
        }

        public ConfigBuilder asGif() {
            this.isGif = true;
            return this;
        }

        public ConfigBuilder border(int i, int i2) {
            this.borderWidth = i;
            this.borderColor = i2;
            return this;
        }

        public ConfigBuilder centerCrop() {
            this.scaleMode = 1;
            return this;
        }

        public ConfigBuilder centerInside() {
            this.scaleMode = 4;
            return this;
        }

        public ConfigBuilder crossFade() {
            this.isCrossFade = true;
            return this;
        }

        public ConfigBuilder diskCacheStrategy(ImageDiskCacheStrategy imageDiskCacheStrategy) {
            this.diskCacheStrategy = imageDiskCacheStrategy;
            return this;
        }

        public ConfigBuilder dontAnimate() {
            this.isDontAnimate = true;
            return this;
        }

        public ConfigBuilder dontTransform() {
            this.isdontTransform = true;
            return this;
        }

        public ConfigBuilder error(int i) {
            this.errorResId = i;
            return this;
        }

        public ConfigBuilder fitCenter() {
            this.scaleMode = 5;
            return this;
        }

        public Object get() {
            return new ImageConfig(this).get();
        }

        public void into(ImageView imageView) {
            this.targetView = imageView;
            new ImageConfig(this).show();
        }

        public ConfigBuilder load(Object obj) {
            this.source = obj;
            return this;
        }

        public ConfigBuilder override(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        public ConfigBuilder placeHolder(int i) {
            this.placeHolderResId = i;
            return this;
        }

        public void preload() {
            this.isPreload = true;
            new ImageConfig(this).show();
        }

        public ConfigBuilder priority(ImagePriority imagePriority) {
            this.priority = imagePriority;
            return this;
        }

        public ConfigBuilder rectRoundCorner(int i) {
            this.rectRoundRadius = i;
            this.shapeMode = 1;
            return this;
        }

        public ConfigBuilder scale(int i) {
            this.scaleMode = i;
            return this;
        }

        public ConfigBuilder setImageLoaderRequestListener(ImageLoaderRequestListener imageLoaderRequestListener) {
            this.imageLoaderRequestListener = imageLoaderRequestListener;
            return this;
        }

        public ConfigBuilder setMemoryCache(boolean z) {
            this.isMemoryCache = z;
            return this;
        }

        public ConfigBuilder toBytes() {
            this.isToBytes = true;
            return this;
        }

        public ConfigBuilder widthHeight(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        public ConfigBuilder error(int i, int i2) {
            this.errorResId = i;
            this.errorScaleType = i2;
            return this;
        }

        public ConfigBuilder placeHolder(Drawable drawable) {
            this.placeHolderDrawable = drawable;
            return this;
        }

        public void into(ImageLoaderCustomTarget imageLoaderCustomTarget) {
            this.imageLoaderCustomTarget = imageLoaderCustomTarget;
            new ImageConfig(this).show();
        }

        public ConfigBuilder placeHolder(int i, int i2) {
            this.placeHolderResId = i;
            this.placeHolderScaleType = i2;
            return this;
        }

        public ConfigBuilder rectRoundCorner(int i, int i2, int i3, int i4) {
            this.shapeMode = 1;
            return this;
        }

        public ConfigBuilder error(Drawable drawable) {
            this.errorDrawable = drawable;
            return this;
        }

        public void into(ImageLoaderCustomViewTarget imageLoaderCustomViewTarget) {
            this.imageLoaderCustomViewTarget = imageLoaderCustomViewTarget;
            new ImageConfig(this).show();
        }

        public void into(ImageLoaderBitmapTarget imageLoaderBitmapTarget) {
            this.imageLoaderBitmapTarget = imageLoaderBitmapTarget;
            new ImageConfig(this).show();
        }

        public void into(ImageLoaderGifTarget imageLoaderGifTarget) {
            this.imageLoaderGifTarget = imageLoaderGifTarget;
            new ImageConfig(this).show();
        }

        public void into(ImageLoaderDrawableTarget imageLoaderDrawableTarget) {
            this.imageLoaderDrawableTarget = imageLoaderDrawableTarget;
            new ImageConfig(this).show();
        }
    }

    public ImageConfig(ConfigBuilder configBuilder) {
        this.context = configBuilder.context;
        this.source = configBuilder.source;
        this.isDontAnimate = configBuilder.isDontAnimate;
        this.isCrossFade = configBuilder.isDontAnimate;
        this.isdontTransform = configBuilder.isdontTransform;
        this.isToBytes = configBuilder.isToBytes;
        this.priority = configBuilder.priority;
        this.isCrossFade = configBuilder.isCrossFade;
        this.isPreload = configBuilder.isPreload;
        this.isMemoryCache = configBuilder.isMemoryCache;
        this.diskCacheStrategy = configBuilder.diskCacheStrategy;
        this.targetView = configBuilder.targetView;
        this.imageLoaderCustomTarget = configBuilder.imageLoaderCustomTarget;
        this.imageLoaderCustomViewTarget = configBuilder.imageLoaderCustomViewTarget;
        this.imageLoaderGifTarget = configBuilder.imageLoaderGifTarget;
        this.imageLoaderDrawableTarget = configBuilder.imageLoaderDrawableTarget;
        this.imageLoaderBitmapTarget = configBuilder.imageLoaderBitmapTarget;
        this.width = configBuilder.width;
        this.height = configBuilder.height;
        int i = configBuilder.shapeMode;
        this.shapeMode = i;
        if (i == 1) {
            this.rectRoundRadius = configBuilder.rectRoundRadius;
        }
        this.scaleMode = configBuilder.scaleMode;
        this.placeHolderResId = configBuilder.placeHolderResId;
        this.placeHolderDrawable = configBuilder.placeHolderDrawable;
        int i2 = configBuilder.borderWidth;
        this.borderWidth = i2;
        if (i2 > 0) {
            this.borderColor = configBuilder.borderColor;
        }
        this.asBitmap = configBuilder.asBitmap;
        this.isGif = configBuilder.isGif;
        this.isFile = configBuilder.isFile;
        this.errorResId = configBuilder.errorResId;
        this.errorDrawable = configBuilder.errorDrawable;
        this.errorScaleType = configBuilder.errorScaleType;
        this.placeHolderScaleType = configBuilder.placeHolderScaleType;
        this.imageLoaderRequestListener = configBuilder.imageLoaderRequestListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object get() {
        if (ContextChecker.check(this.context)) {
            return ImageLoader.getLoader().getObject(this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (ContextChecker.check(this.context)) {
            ImageLoader.getLoader().requestData(this);
        }
    }

    public boolean asFile() {
        return this.isFile;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }

    public Context getContext() {
        return this.context;
    }

    public ImageDiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public Drawable getErrorDrawable() {
        return this.errorDrawable;
    }

    public int getErrorResId() {
        return this.errorResId;
    }

    public int getErrorScaleType() {
        return this.errorScaleType;
    }

    public int getHeight() {
        return this.height;
    }

    public ImageLoaderBitmapTarget getImageLoaderBitmapTarget() {
        return this.imageLoaderBitmapTarget;
    }

    public ImageLoaderCustomTarget getImageLoaderCustomTarget() {
        return this.imageLoaderCustomTarget;
    }

    public ImageLoaderDrawableTarget getImageLoaderDrawableTarget() {
        return this.imageLoaderDrawableTarget;
    }

    public ImageLoaderGifTarget getImageLoaderGifTarget() {
        return this.imageLoaderGifTarget;
    }

    public ImageLoaderRequestListener getImageLoaderRequestListener() {
        return this.imageLoaderRequestListener;
    }

    public ImageLoaderCustomViewTarget getImageLoaderViewTarget() {
        return this.imageLoaderCustomViewTarget;
    }

    public Drawable getPlaceHolderDrawable() {
        return this.placeHolderDrawable;
    }

    public int getPlaceHolderResId() {
        return this.placeHolderResId;
    }

    public int getPlaceHolderScaleType() {
        return this.placeHolderScaleType;
    }

    public ImagePriority getPriority() {
        return this.priority;
    }

    public int getRectRoundRadius() {
        return this.rectRoundRadius;
    }

    public int getScaleMode() {
        return this.scaleMode;
    }

    public int getShapeMode() {
        return this.shapeMode;
    }

    public Object getSource() {
        return this.source;
    }

    public ImageView getTargetView() {
        return this.targetView;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAsBitmap() {
        return this.asBitmap;
    }

    public boolean isCrossFade() {
        return this.isCrossFade;
    }

    public boolean isDontAnimate() {
        return this.isDontAnimate;
    }

    public boolean isGif() {
        return this.isGif;
    }

    public boolean isMemoryCache() {
        return this.isMemoryCache;
    }

    public boolean isPreload() {
        return this.isPreload;
    }

    public boolean isToBytes() {
        return this.isToBytes;
    }

    public boolean isdontTransform() {
        return this.isdontTransform;
    }

    public void setAsBitmap(boolean z) {
        this.asBitmap = z;
    }

    public void setDontAnimate(boolean z) {
        this.isDontAnimate = z;
    }

    public void setScaleMode(int i) {
        this.scaleMode = i;
    }
}
