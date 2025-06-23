package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.gy;
import com.iab.omid.library.huawei.adsession.AdEvents;
import com.iab.omid.library.huawei.adsession.AdSession;
import com.iab.omid.library.huawei.adsession.media.InteractionType;
import com.iab.omid.library.huawei.adsession.media.MediaEvents;
import com.iab.omid.library.huawei.adsession.media.PlayerState;
import com.iab.omid.library.huawei.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class gu extends gt implements gr {
    public static final int Code = 200;
    private static boolean I = false;
    private static final String V = "VideoEventAgent";
    private gy C;
    private final List<MediaEvents> Z = new ArrayList();
    private final List<AdEvents> B = new ArrayList();
    private boolean S = false;
    private int F = 0;
    private float D = 0.0f;
    private boolean L = false;

    static {
        I = gw.Code("com.iab.omid.library.huawei.adsession.media.MediaEvents") && gw.Code(gw.e);
    }

    public static boolean C() {
        return I;
    }

    private String D() {
        return V + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (fb.Code()) {
            fb.Code(D(), "volumeChangeInner %s", Boolean.valueOf(this.S));
        }
        V(this.S ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.gt
    public void B() {
        if (this.B.isEmpty()) {
            fb.I(D(), "impressionOccurred, mAdEventList isEmpty");
            return;
        }
        try {
            Iterator<AdEvents> it = this.B.iterator();
            while (it.hasNext()) {
                it.next().impressionOccurred();
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "impressionOccurred, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt
    public void Code() {
        if (this.Z.isEmpty()) {
            fb.I(D(), "firstQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    fb.V(D(), com.huawei.openalliance.ad.constant.cu.V);
                    mediaEvents.firstQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "firstQuartile, fail");
        }
    }

    public gy S() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.gt
    public void Z() {
        if (this.Z.isEmpty()) {
            fb.I(D(), "thirdQuartile, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    fb.V(D(), "thirdQuartile ");
                    mediaEvents.thirdQuartile();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "thirdQuartile, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void a() {
        this.D = 0.0f;
        this.F = 0;
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "complete ");
                    }
                    mediaEvents.complete();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "complete, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void b() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "bufferStart ");
                    }
                    mediaEvents.bufferStart();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "bufferStart, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void c() {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "bufferFinish ");
                    }
                    mediaEvents.bufferFinish();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "bufferFinish, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void d() {
        if (!this.L) {
            this.F = 0;
        }
        if (this.Z.isEmpty()) {
            fb.I(D(), "skipped, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "skipped ");
                    }
                    mediaEvents.skipped();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "skipped, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void e() {
        if (this.Z.isEmpty() || 1 != this.F) {
            return;
        }
        try {
            this.F = 2;
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "pause ");
                    }
                    mediaEvents.pause();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "pause, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void f() {
        this.F = 1;
        if (this.Z.isEmpty()) {
            fb.I(D(), "resume, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "resume ");
                    }
                    mediaEvents.resume();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "resume, fail");
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(float f) {
        int Code2 = gx.Code(this.D, f);
        if (fb.Code()) {
            fb.Code(D(), "onProgress %s", Integer.valueOf(Code2));
        }
        if (Code2 == 25) {
            this.D = Code2;
            Code();
        } else if (Code2 == 50) {
            this.D = Code2;
            I();
        } else {
            if (Code2 != 75) {
                return;
            }
            this.D = Code2;
            Z();
        }
    }

    @Override // com.huawei.hms.ads.gt
    public void I() {
        if (this.Z.isEmpty()) {
            fb.I(D(), "midpoint, mVideoEventsList isEmpty");
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    fb.V(D(), "midpoint ");
                    mediaEvents.midpoint();
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "midpoint, fail");
        }
    }

    @Override // com.huawei.hms.ads.gr
    public void V() {
        if (fb.Code()) {
            fb.Code(D(), "release ");
        }
        this.F = 0;
        gy gyVar = this.C;
        if (gyVar != null) {
            gyVar.V();
        }
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.gu.2
            @Override // java.lang.Runnable
            public void run() {
                gu.this.Z.clear();
                gu.this.B.clear();
            }
        }, 200L);
    }

    @Override // com.huawei.hms.ads.gt
    public void Code(float f, float f2) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "start，duration %s", Float.valueOf(f));
                    }
                    mediaEvents.start(f, f2);
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "start, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void V(float f) {
        gy gyVar;
        fb.V(D(), "volumeChange %s", Float.valueOf(f));
        this.S = Math.abs(f - 0.0f) < 1.0E-8f;
        if (this.Z.isEmpty() || this.F != 1) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null && (gyVar = this.C) != null) {
                    if (f == -1.0f) {
                        mediaEvents.volumeChange(gyVar.Code(this.S));
                    } else {
                        mediaEvents.volumeChange(f);
                    }
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "volumeChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(float f, boolean z) {
        this.F = 1;
        this.S = z;
        Code(f, z ? 0.0f : 1.0f);
    }

    @Override // com.huawei.hms.ads.hq
    public void V(boolean z) {
        this.L = z;
    }

    @Override // com.huawei.hms.ads.gr
    public void Code(hg hgVar) {
        String D;
        String str;
        if (I) {
            if ((hgVar instanceof gk) && C()) {
                gk gkVar = (gk) hgVar;
                Context I2 = gkVar.I();
                if (I2 != null) {
                    fb.V(D(), "Set VolumeChange observer");
                    gy gyVar = new gy(I2);
                    this.C = gyVar;
                    gyVar.Code(new gy.b() { // from class: com.huawei.hms.ads.gu.1
                        @Override // com.huawei.hms.ads.gy.b
                        public void Code() {
                            gu.this.F();
                        }
                    });
                }
                List<AdSession> V2 = gkVar.V();
                if (!V2.isEmpty()) {
                    for (AdSession adSession : V2) {
                        if (adSession != null) {
                            if (fb.Code()) {
                                fb.Code(D(), "setAdSessionAgent, add mVideoEventsList ");
                            }
                            this.Z.add(MediaEvents.createMediaEvents(adSession));
                            this.B.add(AdEvents.createAdEvents(adSession));
                        }
                    }
                    return;
                }
                D = D();
                str = "adSessionList is empty";
            } else {
                D = D();
                str = "adsessionAgent is null";
            }
            fb.V(D, str);
        }
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void Code(hr hrVar) {
        InteractionType Code2;
        if (!hr.Code() || (Code2 = hr.Code(hrVar)) == null) {
            return;
        }
        Code(Code2);
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(hs hsVar) {
        PlayerState Code2;
        if (!hs.Code() || (Code2 = hs.Code(hsVar)) == null) {
            return;
        }
        if (fb.Code()) {
            fb.Code(D(), "playerStateChange %s", hsVar.toString());
        }
        Code(Code2);
    }

    @Override // com.huawei.hms.ads.gt, com.huawei.hms.ads.hq
    public void Code(hu huVar) {
        VastProperties V2;
        if (huVar == null || !hu.Code() || (V2 = huVar.V()) == null) {
            return;
        }
        Code(V2);
    }

    @Override // com.huawei.hms.ads.gt
    public void Code(InteractionType interactionType) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "adUserInteraction ");
                    }
                    mediaEvents.adUserInteraction(interactionType);
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "adUserInteraction, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt
    public void Code(PlayerState playerState) {
        if (this.Z.isEmpty()) {
            return;
        }
        try {
            for (MediaEvents mediaEvents : this.Z) {
                if (mediaEvents != null) {
                    mediaEvents.playerStateChange(PlayerState.COLLAPSED);
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "playerStateChange, fail");
        }
    }

    @Override // com.huawei.hms.ads.gt
    public void Code(VastProperties vastProperties) {
        if (this.B.isEmpty()) {
            return;
        }
        try {
            for (AdEvents adEvents : this.B) {
                if (adEvents != null) {
                    if (fb.Code()) {
                        fb.Code(D(), "loaded ");
                    }
                    adEvents.loaded(vastProperties);
                }
            }
        } catch (IllegalStateException unused) {
            fb.V(D(), "loaded, fail");
        }
    }
}
