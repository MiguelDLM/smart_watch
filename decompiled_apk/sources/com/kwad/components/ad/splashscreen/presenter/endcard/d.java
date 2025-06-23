package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.e implements com.kwad.sdk.core.h.c {
    private ViewGroup EN;
    private ImageView EO;
    private SplashEndLandView EP;

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        SplashEndLandView splashEndLandView = this.EP;
        if (splashEndLandView != null && str != null) {
            splashEndLandView.W(str);
        }
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        if (viewStub != null) {
            this.EN = (ViewGroup) viewStub.inflate();
        } else {
            this.EN = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_root);
        }
        boolean dg = com.kwad.sdk.core.response.b.a.dg(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate));
        if (dg) {
            this.EN.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.EN.getWidth();
                    d.this.EP.a(d.this.Di.mAdTemplate, d.this.Di.mApkDownloadHelper, com.kwad.sdk.c.a.a.px2dip(d.this.getContext(), d.this.EN.getHeight()) / 414.0f);
                }
            });
        }
        this.EO = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
        this.EP = splashEndLandView;
        splashEndLandView.s(dg);
        SplashEndLandView splashEndLandView2 = this.EP;
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        splashEndLandView2.a(hVar.mAdTemplate, hVar.mApkDownloadHelper, 1.0f);
    }

    private void lD() {
        if (!com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            return;
        }
        com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Di.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.1
            {
                super(r3);
            }

            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void k(int i, String str) {
                d.this.W(str);
            }
        };
        com.kwad.components.core.e.d.c cVar = this.Di.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(aVar);
        }
    }

    private void lE() {
        this.EN.setVisibility(0);
        a(this.EO, com.kwad.sdk.core.response.b.a.aT(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate)).materialUrl, this.Di.mAdTemplate);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        SplashEndLandView splashEndLandView = this.EP;
        if (splashEndLandView != null) {
            splashEndLandView.aM();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        SplashEndLandView splashEndLandView = this.EP;
        if (splashEndLandView != null) {
            splashEndLandView.aN();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        initView();
        this.Di.Ct.a(this);
        com.kwad.sdk.core.adlog.c.d(this.Di.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(87).cT(6));
        lD();
        lE();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        SplashEndLandView splashEndLandView = this.EP;
        if (splashEndLandView != null) {
            splashEndLandView.lF();
        }
        this.Di.Ct.b(this);
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.3
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }
}
