package com.alimm.tanx.ui.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.alimm.tanx.core.image.IImageLoader;
import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.ui.image.glide.DrawableTypeRequest;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.SimpleTarget;

public class GlideSourceCodeImageLoader implements IImageLoader {
    private static final String TAG = "GlideSourceCodeImageLoader";

    private DrawableTypeRequest getDrawableTypeRequest(ImageConfig imageConfig, RequestManager requestManager) {
        if (!TextUtils.isEmpty(imageConfig.getUrl())) {
            return requestManager.load(imageConfig.getUrl());
        }
        if (imageConfig.getResId() > 0) {
            return requestManager.load(Integer.valueOf(imageConfig.getResId()));
        }
        return null;
    }

    private SimpleTarget<GlideDrawable> getGifSimpleTarget(final ImageView imageView, final ImageConfig.GifCallback gifCallback) {
        return new SimpleTarget<GlideDrawable>() {
            public void onLoadFailed(Exception exc, Drawable drawable) {
                ImageConfig.GifCallback gifCallback = gifCallback;
                if (gifCallback != null) {
                    gifCallback.onFailure(LogUtils.getStackTraceMessage(exc));
                    TanxMonitorUt.sendImageMonitor(2, -1, "gif", false);
                }
            }

            public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
                if (gifCallback != null) {
                    if (glideDrawable.isAnimated()) {
                        glideDrawable.setLoopCount(-1);
                        glideDrawable.start();
                    }
                    imageView.setBackground(glideDrawable);
                    gifCallback.onSuccess();
                    TanxMonitorUt.sendImageMonitor(2, 1, "gif", false);
                }
            }
        };
    }

    private static boolean isParentContextDestroyed(View view) {
        if (view != null) {
            return isParentContextDestroyed(view.getContext());
        }
        return true;
    }

    public void load(ImageConfig imageConfig, final ImageConfig.ImageBitmapCallback imageBitmapCallback) {
        try {
            LogUtils.d(TAG, "load()");
            TanxMonitorUt.sendImageMonitor(2, 1, "image", true);
            if (isParentContextDestroyed(imageConfig.getContext())) {
                LogUtils.e(TAG, "load error isParentContextNotDestroyed 对应view或activity已经销毁");
                return;
            }
            DrawableTypeRequest drawableTypeRequest = getDrawableTypeRequest(imageConfig, Glide.with(imageConfig.getContext()));
            if (drawableTypeRequest != null) {
                drawableTypeRequest.asBitmap().into(new SimpleTarget<Bitmap>() {
                    public void onLoadFailed(Exception exc, Drawable drawable) {
                        if (imageBitmapCallback != null) {
                            TanxMonitorUt.sendImageMonitor(2, -1, "image", false);
                            imageBitmapCallback.onFailure(LogUtils.getStackTraceMessage(exc));
                        }
                    }

                    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                        if (imageBitmapCallback != null) {
                            TanxMonitorUt.sendImageMonitor(2, 1, "image", false);
                            imageBitmapCallback.onSuccess(bitmap);
                        }
                    }
                });
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public void loadGif(GifConfig gifConfig, ImageConfig.GifCallback gifCallback) {
        String str;
        try {
            LogUtils.d(TAG, "loadGif()");
            TanxMonitorUt.sendImageMonitor(2, 1, "gif", true);
            if (isParentContextDestroyed((View) gifConfig.getGifView())) {
                LogUtils.e(TAG, "load error isParentContextNotDestroyed 对应view或activity已经销毁");
                return;
            }
            if (gifConfig.getGifView() == null) {
                str = "imageView对象为空";
            } else if (!TextUtils.isEmpty(gifConfig.getGifUrl())) {
                Glide.with(gifConfig.getGifView().getContext()).load(gifConfig.getGifUrl()).diskCacheStrategy(DiskCacheStrategy.RESULT).into(getGifSimpleTarget(gifConfig.getGifView(), gifCallback));
                return;
            } else if (gifConfig.getGifRes() != -1) {
                Glide.with(gifConfig.getGifView().getContext()).load(Integer.valueOf(gifConfig.getGifRes())).diskCacheStrategy(DiskCacheStrategy.RESULT).into(getGifSimpleTarget(gifConfig.getGifView(), gifCallback));
                return;
            } else {
                str = "";
            }
            if (gifCallback != null) {
                gifCallback.onFailure(str);
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    private static boolean isParentContextDestroyed(Context context) {
        if (context == null) {
            return true;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return true;
            }
        }
        if (!(context instanceof FragmentActivity)) {
            return false;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (fragmentActivity.isDestroyed() || fragmentActivity.isFinishing()) {
            return true;
        }
        return false;
    }
}
