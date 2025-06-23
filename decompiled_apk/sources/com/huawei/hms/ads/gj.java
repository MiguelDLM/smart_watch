package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.facebook.login.LoginLogger;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public class gj implements gv {
    private static final String Code = "OmPresent";
    private hg I;
    private gr V;
    private boolean Z;
    private boolean B = true;
    private boolean C = false;
    private boolean S = false;
    private boolean F = false;
    private boolean D = false;

    @Override // com.huawei.hms.ads.hg
    public void B() {
        hg hgVar = this.I;
        if (hgVar == null) {
            return;
        }
        hgVar.B();
    }

    @Override // com.huawei.hms.ads.hg
    public void C() {
        hg hgVar = this.I;
        if (hgVar == null) {
            return;
        }
        hgVar.C();
    }

    public gr Code() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.hl
    public void D() {
        fb.V(Code, "impressionOccurred");
        if (this.S) {
            return;
        }
        gr grVar = this.V;
        if (grVar instanceof gm) {
            ((gm) grVar).D();
            this.S = true;
        }
        gr grVar2 = this.V;
        if (grVar2 instanceof gu) {
            ((gu) grVar2).B();
            this.S = true;
        }
    }

    @Override // com.huawei.hms.ads.hg
    public String F() {
        hg hgVar = this.I;
        if (hgVar == null) {
            return null;
        }
        return hgVar.F();
    }

    @Override // com.huawei.hms.ads.gv
    public void I() {
        fb.V(Code, "release");
        if (this.F) {
            this.B = true;
            this.C = false;
            this.S = false;
            gr grVar = this.V;
            if (grVar != null) {
                grVar.V();
            }
            hg hgVar = this.I;
            if (hgVar != null) {
                hgVar.B();
            }
            this.F = false;
        }
    }

    @Override // com.huawei.hms.ads.hl
    public void L() {
        fb.V(Code, "load");
        if (this.B || !this.S) {
            gr grVar = this.V;
            if (grVar instanceof gm) {
                ((gm) grVar).L();
            }
        }
    }

    @Override // com.huawei.hms.ads.hg
    public hc S() {
        hg hgVar = this.I;
        if (hgVar == null) {
            return null;
        }
        return hgVar.S();
    }

    @Override // com.huawei.hms.ads.gv
    public hg V() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.hg
    public void Z() {
        hg hgVar = this.I;
        if (hgVar == null) {
            fb.V(Code, "AdSessionAgent is null");
        } else {
            hgVar.Z();
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void a() {
        fb.V(Code, "complete");
        if (this.B || !this.C) {
            gr grVar = this.V;
            if (grVar instanceof gu) {
                ((gu) grVar).a();
                this.C = true;
            }
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void b() {
        if (this.B || !this.C) {
            gr grVar = this.V;
            if (grVar instanceof gu) {
                ((gu) grVar).b();
            }
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void c() {
        if (this.B || !this.C) {
            gr grVar = this.V;
            if (grVar instanceof gu) {
                ((gu) grVar).c();
            }
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void d() {
        fb.V(Code, LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).d();
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void e() {
        fb.V(Code, "pause");
        if (!this.B && this.C) {
            fb.I(Code, "pause: Video completed");
            return;
        }
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).e();
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void f() {
        fb.V(Code, com.huawei.openalliance.ad.constant.aw.ag);
        if (!this.B && this.C) {
            fb.I(Code, "resume: Video completed");
            return;
        }
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).f();
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(float f) {
        if (fb.Code()) {
            fb.Code(Code, "onProgress, isAllowRepeat= %s, isVideoComplete= %s", Boolean.valueOf(this.B), Boolean.valueOf(this.C));
        }
        if (this.B || !this.C) {
            gr grVar = this.V;
            if (grVar instanceof gu) {
                ((gu) grVar).Code(f);
            }
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void I(View view) {
        hg hgVar = this.I;
        if (hgVar == null) {
            return;
        }
        hgVar.I(view);
    }

    @Override // com.huawei.hms.ads.hq
    public void V(float f) {
        if (!this.B && this.C) {
            fb.I(Code, "volumeChange: Video completed");
            return;
        }
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).V(f);
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(float f, boolean z) {
        fb.V(Code, "start");
        if (!this.B && this.C) {
            fb.I(Code, "start: Video completed");
            return;
        }
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).Code(f, z);
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void V(View view) {
        hg hgVar = this.I;
        if (hgVar == null) {
            return;
        }
        hgVar.V(view);
    }

    @Override // com.huawei.hms.ads.gv
    public void Code(Context context, AdContentData adContentData, gf gfVar, boolean z) {
        if ((adContentData != null ? adContentData.aj() : null) == null) {
            fb.V(Code, "om is null, no initialization is required");
            return;
        }
        if (this.F) {
            return;
        }
        fb.V(Code, "init omPresent");
        this.I = gl.Code(context, adContentData, gfVar, z);
        gr Code2 = gq.Code(adContentData);
        this.V = Code2;
        Code2.Code(this.I);
        this.Z = z;
        this.F = true;
        this.D = false;
        this.S = false;
    }

    @Override // com.huawei.hms.ads.hq
    public void V(boolean z) {
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).V(z);
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(View view) {
        if (this.Z) {
            return;
        }
        hg hgVar = this.I;
        if (hgVar == null) {
            fb.V(Code, "AdSessionAgent is null");
        } else {
            hgVar.Code(view);
        }
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(View view, hf hfVar, String str) {
        hg hgVar = this.I;
        if (hgVar == null) {
            return;
        }
        hgVar.Code(view, hfVar, str);
    }

    @Override // com.huawei.hms.ads.hg
    public void Code(he heVar, String str) {
        hg hgVar = this.I;
        if (hgVar == null) {
            return;
        }
        hgVar.Code(heVar, str);
    }

    @Override // com.huawei.hms.ads.hl
    public void Code(hp hpVar) {
        fb.V(Code, "load vastPropertiesWrapper");
        if (this.B || !this.S) {
            gr grVar = this.V;
            if (grVar instanceof gm) {
                ((gm) grVar).Code(hpVar);
            }
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(hr hrVar) {
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).Code(hrVar);
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(hs hsVar) {
        gr grVar = this.V;
        if (grVar instanceof gu) {
            ((gu) grVar).Code(hsVar);
        }
    }

    @Override // com.huawei.hms.ads.hq
    public void Code(hu huVar) {
        if (!this.B && this.C) {
            fb.I(Code, "loaded: Video completed");
            return;
        }
        if (this.D) {
            if (fb.Code()) {
                fb.Code(Code, "Already loaded");
            }
        } else {
            gr grVar = this.V;
            if (grVar instanceof gu) {
                ((gu) grVar).Code(huVar);
            }
            this.D = true;
        }
    }

    @Override // com.huawei.hms.ads.gv
    public void Code(boolean z) {
        this.B = z;
    }
}
