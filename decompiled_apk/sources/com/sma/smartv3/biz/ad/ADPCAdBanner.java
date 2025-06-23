package com.sma.smartv3.biz.ad;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.ViewGroup;
import com.adp.sdk.ADPBannerAdLoader;
import com.adp.sdk.dto.AdpError;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ADPCAdBanner {

    @OOXIXo
    private final ADPBannerAdLoader adpBannerAdLoader;

    public ADPCAdBanner(@OOXIXo Activity context, @OOXIXo String adId, @OOXIXo ViewGroup bannerContainer, @OOXIXo final ADPCAdListener listener) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(adId, "adId");
        IIX0o.x0xO0oo(bannerContainer, "bannerContainer");
        IIX0o.x0xO0oo(listener, "listener");
        this.adpBannerAdLoader = new ADPBannerAdLoader(context, adId, bannerContainer, new ADPBannerAdLoader.ADPBannerADListener() { // from class: com.sma.smartv3.biz.ad.ADPCAdBanner$adpBannerAdLoader$1
            @Override // com.adp.sdk.ADPBannerAdLoader.ADPBannerADListener
            public void onADClicked() {
                ADPCAdListener.this.onADClicked();
            }

            @Override // com.adp.sdk.ADPBannerAdLoader.ADPBannerADListener
            public void onADClosed() {
                ADPCAdListener.this.onADClosed();
            }

            @Override // com.adp.sdk.ADPBannerAdLoader.ADPBannerADListener
            public void onADError(@OOXIXo AdpError p0) {
                IIX0o.x0xO0oo(p0, "p0");
                ADPCAdListener.this.onADError(new ADPCAdError(p0));
            }

            @Override // com.adp.sdk.ADPBannerAdLoader.ADPBannerADListener
            public void onADPresent() {
                ADPCAdListener.this.onADPresent();
            }

            @Override // com.adp.sdk.ADPBannerAdLoader.ADPBannerADListener
            public void onADReceive() {
                ADPCAdListener.this.onADReceive();
            }
        });
    }

    public final void destroy() {
        this.adpBannerAdLoader.destroy();
    }

    public final void load() {
        this.adpBannerAdLoader.load();
    }

    public final void setAdWidth(int i) {
        this.adpBannerAdLoader.setAdWidth(i);
    }

    public final void setRefreshTime(int i) {
        this.adpBannerAdLoader.setRefreshTime(i);
    }
}
