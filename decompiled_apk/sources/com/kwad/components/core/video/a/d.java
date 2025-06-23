package com.kwad.components.core.video.a;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.core.video.a.a {
    private long VK;
    private long VL;
    private long VM;
    private String VN;
    private boolean VO;
    private boolean VP;
    private boolean VQ;
    private long VR;
    private long VS;
    private long VT;
    private long VU;
    private i tW;
    private String xM;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.commercial.c.a {
        public long SK;
        public String Wa;
        public int code;
        public long creativeId;
        public long llsid;
        public String msg;
        public String videoUrl;
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class b extends com.kwad.sdk.commercial.c.a implements Cloneable {
        public long SK;
        public int VI;
        public String Wa;
        public long Wb;
        public long Wc;
        public long Wd;
        public long creativeId;
        public long llsid;
        public long videoDuration;
        public String videoUrl;

        /* renamed from: sD, reason: merged with bridge method [inline-methods] */
        public final b clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException unused) {
                return new b();
            }
        }
    }

    private d(@NonNull AdTemplate adTemplate) {
        this.VO = false;
        this.VP = false;
        this.VQ = false;
        try {
            AdInfo dS = e.dS(adTemplate);
            this.xM = com.kwad.sdk.core.response.b.a.K(dS);
            this.VK = e.dP(adTemplate);
            this.VL = e.ec(adTemplate);
            this.VM = com.kwad.sdk.core.response.b.a.ch(dS);
            this.VN = com.kwad.sdk.core.response.b.a.cd(dS);
            this.tW = new i();
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    public static com.kwad.components.core.video.a.a az(@NonNull AdTemplate adTemplate) {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atX)) {
            return new d(adTemplate);
        }
        return new com.kwad.components.core.video.a.b();
    }

    private void b(boolean z, int i, int i2) {
        if (this.VQ) {
            this.tW.sw();
            this.VU = SystemClock.elapsedRealtime();
            a(z, i, i2);
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a o(int i, int i2) {
        a aVar = new a();
        aVar.code = i;
        aVar.msg = String.valueOf(i2);
        aVar.videoUrl = this.xM;
        aVar.llsid = this.VK;
        aVar.creativeId = this.VL;
        aVar.SK = this.VM;
        aVar.Wa = this.VN;
        return aVar;
    }

    private void reset() {
        this.tW.reset();
        this.VR = 0L;
        this.VS = 0L;
        this.VU = 0L;
        this.VT = 0L;
        this.VO = false;
        this.VP = false;
        this.VQ = false;
    }

    private b sC() {
        b bVar = new b();
        long j = this.VS;
        long j2 = this.VR;
        bVar.Wb = j - j2;
        bVar.Wc = this.VT - j2;
        bVar.Wd = this.tW.sy().sB();
        bVar.videoDuration = this.VU - this.VR;
        bVar.VI = this.tW.sy().sA();
        bVar.videoUrl = this.xM;
        bVar.llsid = this.VK;
        bVar.creativeId = this.VL;
        bVar.SK = this.VM;
        bVar.Wa = this.VN;
        return bVar;
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayError(int i, int i2) {
        super.onMediaPlayError(i, i2);
        this.tW.sw();
        b(false, i, i2);
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayPaused() {
        super.onMediaPlayPaused();
        this.tW.sw();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlayStart() {
        super.onMediaPlayStart();
        if (!this.VP) {
            this.VS = SystemClock.elapsedRealtime();
            this.VP = true;
        }
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
    public final void onMediaPlaying() {
        super.onMediaPlaying();
        pc();
        this.tW.sw();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onRelease() {
        b(true, 0, 0);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onReset() {
        b(false, 0, 0);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onStart() {
        if (!this.VO) {
            this.VR = SystemClock.elapsedRealtime();
            this.VO = true;
        }
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPaused() {
        super.onVideoPlayBufferingPaused();
        this.tW.sv();
    }

    @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
    public final void onVideoPlayBufferingPlaying() {
        super.onVideoPlayBufferingPlaying();
        this.tW.sv();
    }

    @Override // com.kwad.components.core.video.a.a
    public final void pc() {
        if (!this.VQ) {
            this.VT = SystemClock.elapsedRealtime();
            this.VQ = true;
        }
    }

    private void a(final boolean z, final int i, final int i2) {
        final b clone = sC().clone();
        g.execute(new az() { // from class: com.kwad.components.core.video.a.d.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (z) {
                    com.kwad.sdk.commercial.b.r(clone);
                } else {
                    com.kwad.sdk.commercial.b.s(d.this.o(i, i2));
                }
            }
        });
    }

    public static com.kwad.components.core.video.a.a a(AdTemplate adTemplate, AdTemplate adTemplate2, String str) {
        if (!com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atX)) {
            return new com.kwad.components.core.video.a.b();
        }
        if (adTemplate != null) {
            return new d(adTemplate);
        }
        return adTemplate2 == null ? new d(str) : new d(adTemplate2);
    }

    private d(String str) {
        this.VO = false;
        this.VP = false;
        this.VQ = false;
        this.xM = str;
        this.tW = new i();
    }
}
