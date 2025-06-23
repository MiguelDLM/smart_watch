package com.kwad.components.ad.splashscreen.presenter;

import XIXIX.OOXIXo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.presenter.playcard.SplashPlayDefaultInfoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes11.dex */
public final class h extends e {
    private ImageView Dk;
    private ImageView Dl;
    private View Do;
    private ViewGroup Dp;
    private SplashPlayDefaultInfoView Dq;
    private AdInfo mAdInfo;
    private boolean Dm = false;
    private boolean Dn = false;
    Runnable Dr = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.5
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.af(h.this.Di.mAdTemplate);
            h.this.li();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements ImageLoadingListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            h.this.lj();
            h.this.Dl.setVisibility(0);
            GlobalThreadPools.Gm().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap stackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.Dl.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            h.this.Dl.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            h.this.li();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    private void l(String str, int i) {
        if (i == 0) {
            this.Dk.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Dk.setVisibility(0);
            KSImageLoader.loadImage(this.Dk, str, this.Di.mAdTemplate, new AnonymousClass1());
        } else {
            this.Dl.setVisibility(0);
            if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CR)) {
                a(this.Dl, this.mAdInfo);
            } else {
                a(this.Dl);
            }
            KSImageLoader.loadImage(this.Dl, str, this.Di.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.h.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    h.this.lj();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    h.this.li();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }
            });
        }
    }

    private void lh() {
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CS)) {
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.ad(this.Di.mAdTemplate);
            bo.runOnUiThreadDelay(this.Dr, com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CU));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.Dm) {
            return;
        }
        this.Dm = true;
        this.Do.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.6
            @Override // java.lang.Runnable
            public final void run() {
                h.this.Dp.setVisibility(0);
                h.this.Dq.a(h.this.Di.mAdTemplate, com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.Do.getHeight()) / 414.0f);
            }
        });
        this.Dk.setVisibility(8);
        this.Dl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj() {
        if (this.Dn) {
            return;
        }
        this.Dn = true;
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CS)) {
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.ae(this.Di.mAdTemplate);
            bo.c(this.Dr);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Do = findViewById(R.id.ksad_splash_root_container);
        this.Dl = (ImageView) findViewById(R.id.ksad_splash_background);
        this.Dk = (ImageView) findViewById(R.id.ksad_splash_foreground);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate);
        this.Dp = (ViewGroup) findViewById(R.id.ksad_splash_default_image_view_container);
        this.Dq = (SplashPlayDefaultInfoView) findViewById(R.id.ksad_splash_default_image_view);
        String str = com.kwad.sdk.core.response.b.a.aT(this.mAdInfo).materialUrl;
        this.Dl.setVisibility(0);
        int i = com.kwad.sdk.core.response.b.a.aT(this.mAdInfo).source;
        lh();
        if (getContext() != null) {
            SplashPreloadManager.kz();
            File U = SplashPreloadManager.U(this.mAdInfo.adPreloadInfo.preloadId);
            if (U != null && U.exists() && U.length() > 0) {
                str = Uri.fromFile(U).toString();
            }
            l(str, i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        lj();
    }

    private void a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.Di.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        final AdInfo.CutRuleInfo cl = com.kwad.sdk.core.response.b.a.cl(adInfo);
        imageView.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.h.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d = com.kwad.sdk.core.response.b.a.aT(adInfo).width;
                AdInfo.CutRuleInfo cutRuleInfo = cl;
                double d2 = cutRuleInfo.picHeight;
                double d3 = cutRuleInfo.viewTopMargin;
                double d4 = cutRuleInfo.safeAreaHeight;
                if (d2 > OOXIXo.f3760XO && d4 > OOXIXo.f3760XO) {
                    double d5 = width / d;
                    double d6 = d3 / (d2 - d4);
                    double d7 = d3 * d5;
                    double d8 = (d2 * d5) - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    marginLayoutParams.topMargin = (int) (((d8 / 2.0d) - (d7 - (d7 - (d6 * d8)))) * 2.0d);
                    imageView.setLayoutParams(marginLayoutParams);
                }
            }
        });
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.Di.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.h.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                float width = imageView.getWidth() / 1080.0f;
                float f = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f2 = width * 2340.0f;
                float height = imageView.getHeight();
                float f3 = (f2 - height) / 2.0f;
                float f4 = f2 - f;
                float f5 = (0.44107744f * f4) - f3;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((((f4 * 0.5589225f) - f3) - f5) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }
}
