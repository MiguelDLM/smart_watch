package com.kwad.components.ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import java.io.InputStream;

/* loaded from: classes11.dex */
public class c extends b {
    private ImageView sd;
    private AdInfo se;

    public c(AdInfo adInfo) {
        this.se = adInfo;
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.c.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.qp.mAdTemplate;
        if (!hr() && adTemplate.adInfoList.size() > 0) {
            String W = com.kwad.sdk.core.response.b.a.W(adTemplate.adInfoList.get(0));
            this.sd.setVisibility(ht());
            try {
                a(this.sd, W, adTemplate);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    public int hs() {
        return R.id.ksad_blur_video_cover;
    }

    public int ht() {
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qp.mAdTemplate) && !aj.ML()) {
            return 0;
        }
        if (com.kwad.components.ad.reward.g.E(this.qp.mAdTemplate) && !aj.ML()) {
            return 0;
        }
        if ((com.kwad.sdk.core.response.b.e.ee(this.qp.mAdTemplate) && !aj.ML()) || com.kwad.components.ad.reward.g.g(this.se)) {
            return 0;
        }
        if (com.kwad.sdk.core.response.b.a.cE(this.se) && com.kwad.components.ad.reward.a.b.gD() && !aj.ML()) {
            return 0;
        }
        return 8;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sd = (ImageView) findViewById(hs());
    }
}
