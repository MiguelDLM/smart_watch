package com.huawei.hms.ads.nativead;

import android.view.View;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.by;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;

/* loaded from: classes10.dex */
public class b {
    private VideoInfo B;
    private g C;
    private NativeVideoView Code;
    private NativeAdConfiguration I;
    private NativeAd S;
    private NativeWindowImageView V;
    private VideoConfiguration Z;

    public b(NativeVideoView nativeVideoView, NativeWindowImageView nativeWindowImageView) {
        this.Code = nativeVideoView;
        this.V = nativeWindowImageView;
    }

    private boolean S() {
        return this.C.c() == 13 || this.C.c() == 113;
    }

    public View B() {
        if (this.C == null) {
            return null;
        }
        return S() ? this.V : this.Code;
    }

    public void Code(final VideoOperator.VideoLifecycleListener videoLifecycleListener) {
        this.Code.setVideoEventListener(new NativeVideoView.a() { // from class: com.huawei.hms.ads.nativead.b.1
            boolean Code = true;

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code() {
                if (this.Code) {
                    videoLifecycleListener.onVideoStart();
                    this.Code = false;
                }
                videoLifecycleListener.onVideoPlay();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void I() {
                this.Code = true;
                videoLifecycleListener.onVideoEnd();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V() {
                videoLifecycleListener.onVideoPause();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Z() {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z) {
                videoLifecycleListener.onVideoMute(z);
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V(boolean z, int i) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z, int i) {
            }
        });
    }

    public NativeVideoView I() {
        return this.Code;
    }

    public void Code(NativeAd nativeAd) {
        this.S = nativeAd;
        if (nativeAd instanceof by) {
            Code(((by) nativeAd).Code());
        }
    }

    private void Code(g gVar) {
        View view;
        if (gVar == null) {
            return;
        }
        this.C = gVar;
        this.B = gVar.C();
        g gVar2 = this.C;
        if (gVar2 instanceof l) {
            NativeAdConfiguration aq = ((l) gVar2).aq();
            this.I = aq;
            if (aq != null) {
                this.Z = aq.getVideoConfiguration();
            }
        }
        if (S()) {
            this.Code.setVisibility(8);
            view = this.V;
        } else {
            this.V.setVisibility(8);
            view = this.Code;
        }
        view.setVisibility(0);
    }
}
