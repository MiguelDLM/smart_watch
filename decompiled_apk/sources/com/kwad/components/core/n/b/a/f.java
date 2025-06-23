package com.kwad.components.core.n.b.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bo;
import java.io.InputStream;

/* loaded from: classes11.dex */
final class f implements IImageLoader {

    /* renamed from: com.kwad.components.core.n.b.a.f$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass2 implements ImageLoadingListener {
        final /* synthetic */ ImageView Dw;
        final /* synthetic */ IImageLoader.ImageLoadingListener Nc;
        final /* synthetic */ IImageLoader.DisplayImageOptionsCompat Ne;

        public AnonymousClass2(IImageLoader.ImageLoadingListener imageLoadingListener, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, ImageView imageView) {
            this.Nc = imageLoadingListener;
            this.Ne = displayImageOptionsCompat;
            this.Dw = imageView;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            Bitmap bitmap;
            IImageLoader.ImageLoadingListener imageLoadingListener = this.Nc;
            if (decodedResult == null) {
                bitmap = null;
            } else {
                bitmap = decodedResult.mBitmap;
            }
            return imageLoadingListener.onDecode(str, inputStream, bitmap);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
            this.Nc.onLoadingCancelled(str, view);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(final String str, final View view, final DecodedResult decodedResult) {
            Bitmap bitmap;
            IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat = this.Ne;
            if (displayImageOptionsCompat != null && displayImageOptionsCompat.getBlurRadius() > 0 && decodedResult != null && decodedResult.mBitmap != null) {
                GlobalThreadPools.Gm().submit(new Runnable() { // from class: com.kwad.components.core.n.b.a.f.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final Bitmap stackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, AnonymousClass2.this.Ne.getBlurRadius(), false);
                        bo.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                Bitmap bitmap2;
                                AnonymousClass2.this.Dw.setImageBitmap(stackBlur);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.Nc;
                                String str2 = str;
                                View view2 = view;
                                DecodedResult decodedResult2 = decodedResult;
                                if (decodedResult2 == null) {
                                    bitmap2 = null;
                                } else {
                                    Bitmap bitmap3 = stackBlur;
                                    if (bitmap3 == null) {
                                        bitmap2 = decodedResult2.mBitmap;
                                    } else {
                                        bitmap2 = bitmap3;
                                    }
                                }
                                imageLoadingListener.onLoadingComplete(str2, view2, bitmap2);
                            }
                        });
                    }
                });
                return;
            }
            IImageLoader.ImageLoadingListener imageLoadingListener = this.Nc;
            if (decodedResult == null) {
                bitmap = null;
            } else {
                bitmap = decodedResult.mBitmap;
            }
            imageLoadingListener.onLoadingComplete(str, view, bitmap);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            this.Nc.onLoadingFailed(str, view, failReason.getType().toString(), failReason.getCause());
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
            this.Nc.onLoadingStarted(str, view);
        }
    }

    private static DisplayImageOptionsCompat a(IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (displayImageOptionsCompat == null) {
            return null;
        }
        return new DisplayImageOptionsCompat.Builder().showImageOnLoading(displayImageOptionsCompat.getImageOnLoading()).showImageForEmptyUri(displayImageOptionsCompat.getImageForEmptyUri()).showImageOnFail(displayImageOptionsCompat.getImageOnFail()).cacheInMemory(displayImageOptionsCompat.isCacheInMemory()).cacheOnDisk(displayImageOptionsCompat.isCacheOnDisk()).bitmapConfig(displayImageOptionsCompat.getDecodingOptions().inPreferredConfig).considerExifParams(displayImageOptionsCompat.isConsiderExifParams()).setBlurRadius(displayImageOptionsCompat.getBlurRadius()).setFrameSequence(displayImageOptionsCompat.isFrameSequence()).setCornerRound(displayImageOptionsCompat.getCornerRound()).setCircle(displayImageOptionsCompat.isCircle()).setStrokeColor(displayImageOptionsCompat.getStrokeColor()).setStrokeWidth(displayImageOptionsCompat.getStrokeWidth()).build();
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str) {
        KSImageLoader.loadImage(imageView, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat) {
        KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(displayImageOptionsCompat));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(imageLoadingListener, null, imageView));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(imageView, str, null, a(displayImageOptionsCompat), a(imageLoadingListener, displayImageOptionsCompat, imageView));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(@Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(str, (AdTemplate) null, a(displayImageOptionsCompat), a(imageLoadingListener));
    }

    private ImageLoadingListener a(final IImageLoader.ImageLoadingListener imageLoadingListener) {
        if (imageLoadingListener == null) {
            return null;
        }
        return new ImageLoadingListener() { // from class: com.kwad.components.core.n.b.a.f.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                Bitmap bitmap;
                IImageLoader.ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
                if (decodedResult == null) {
                    bitmap = null;
                } else {
                    bitmap = decodedResult.mBitmap;
                }
                return imageLoadingListener2.onDecode(str, inputStream, bitmap);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingCancelled(String str, View view) {
                imageLoadingListener.onLoadingCancelled(str, view);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                Bitmap bitmap;
                IImageLoader.ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
                if (decodedResult == null) {
                    bitmap = null;
                } else {
                    bitmap = decodedResult.mBitmap;
                }
                imageLoadingListener2.onLoadingComplete(str, view, bitmap);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                imageLoadingListener.onLoadingFailed(str, view, failReason.getType().toString(), failReason.getCause());
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingStarted(String str, View view) {
                imageLoadingListener.onLoadingStarted(str, view);
            }
        };
    }

    private ImageLoadingListener a(IImageLoader.ImageLoadingListener imageLoadingListener, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, ImageView imageView) {
        if (imageLoadingListener == null) {
            return null;
        }
        return new AnonymousClass2(imageLoadingListener, displayImageOptionsCompat, imageView);
    }
}
