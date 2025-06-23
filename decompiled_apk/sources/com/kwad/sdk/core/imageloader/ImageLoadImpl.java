package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.cache.disc.naming.Md5FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.display.CircleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes11.dex */
public class ImageLoadImpl implements IImageLoader {
    private int cacheSize = -1;

    private DisplayImageOptions adapter(DisplayImageOptionsCompat displayImageOptionsCompat) {
        Context context = ((f) ServiceProvider.get(f.class)).getContext();
        Resources resources = context.getResources();
        DisplayImageOptions.Builder bitmapConfig = new DisplayImageOptions.Builder().showImageOnLoading(displayImageOptionsCompat.getImageOnLoading(resources)).showImageForEmptyUri(displayImageOptionsCompat.getImageForEmptyUri(resources)).showImageOnFail(displayImageOptionsCompat.getImageOnFail(resources)).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565);
        if (displayImageOptionsCompat.getStrokeWidth() > 0.0f) {
            bitmapConfig.displayer(new CircleBitmapDisplayer(Integer.valueOf(displayImageOptionsCompat.getStrokeColor()), a.a(context, displayImageOptionsCompat.getStrokeWidth())));
        } else if (displayImageOptionsCompat.isCircle()) {
            bitmapConfig.displayer(new CircleBitmapDisplayer());
        } else if (displayImageOptionsCompat.getCornerRound() > 0) {
            bitmapConfig.displayer(new RoundedBitmapDisplayer(a.a(context, displayImageOptionsCompat.getCornerRound())));
        }
        return bitmapConfig.build();
    }

    private String parseModel(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new IllegalArgumentException("unsupport object except String!");
    }

    public void checkInit() {
        if (ImageLoader.getInstance().isInited()) {
            return;
        }
        Context context = ((f) ServiceProvider.get(f.class)).getContext();
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context.getApplicationContext());
        builder.taskExecutor(GlobalThreadPools.Gm());
        builder.taskExecutorForCachedImages(GlobalThreadPools.Gn());
        builder.setTaskDistributor(GlobalThreadPools.Go());
        builder.denyCacheImageMultipleSizesInMemory();
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        builder.diskCacheSize(20971520);
        builder.tasksProcessingOrder(QueueProcessingType.LIFO);
        builder.cacheParentDir(ax.cY(context).getPath());
        int i = this.cacheSize;
        if (i > 0) {
            builder.memoryCacheSize(i * 1048576);
        }
        builder.imageDownloader(new BaseImageDownloader(context) { // from class: com.kwad.sdk.core.imageloader.ImageLoadImpl.1
            @Override // com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader
            public HttpURLConnection createConnection(String str, Object obj) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
                r.wrapHttpURLConnection(httpURLConnection);
                p.b(httpURLConnection);
                httpURLConnection.setConnectTimeout(this.connectTimeout);
                httpURLConnection.setReadTimeout(this.readTimeout);
                return httpURLConnection;
            }
        });
        ImageLoader.getInstance().init(builder.build());
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void clearMemory(Context context) {
        checkInit();
        ImageLoader.getInstance().clearMemoryCache();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public File isImageExistOnDisk(String str) {
        checkInit();
        return ImageLoader.getInstance().getDiskCache().get(str);
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(ImageView imageView, Object obj) {
        checkInit();
        ImageLoader.getInstance().displayImage(parseModel(obj), imageView);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public Bitmap loadImageSync(String str) {
        checkInit();
        return ImageLoader.getInstance().loadImageSync(str, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build());
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void pause() {
        checkInit();
        ImageLoader.getInstance().pause();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void resume() {
        checkInit();
        ImageLoader.getInstance().resume();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void setCacheSize(int i) {
        this.cacheSize = i;
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(ImageView imageView, Object obj, AdTemplate adTemplate) {
        checkInit();
        ImageLoader.getInstance().displayImage(parseModel(obj), imageView, new KSImageLoader.InnerImageLoadingListener(adTemplate, null));
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(@NonNull Context context, ImageView imageView, Object obj, int i, int i2) {
        checkInit();
        ImageLoader.getInstance().displayImage(parseModel(obj), imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(i2).showImageForEmptyUri(i).showImageOnFail(i).build());
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2) {
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(drawable).showImageOnFail(drawable2).build());
    }

    @Override // com.kwad.sdk.service.a.i
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f) {
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(drawable).showImageOnFail(drawable2).displayer(new RoundedBitmapDisplayer(a.a(imageView.getContext(), f))).build());
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        checkInit();
        ImageLoader.getInstance().displayImage(str, imageView, adapter(displayImageOptionsCompat), imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        checkInit();
        ImageLoader.getInstance().loadImage(str, adapter(displayImageOptionsCompat), imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(KsFragment ksFragment, @NonNull Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        checkInit();
        ImageLoader.getInstance().loadImage(str, adapter(displayImageOptionsCompat), imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(ImageView imageView, Object obj, ImageLoadingListener imageLoadingListener) {
        checkInit();
        ImageLoader.getInstance().displayImage(parseModel(obj), imageView, imageLoadingListener);
    }
}
