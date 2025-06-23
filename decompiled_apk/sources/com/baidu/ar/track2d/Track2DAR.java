package com.baidu.ar.track2d;

import android.graphics.Bitmap;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.as;
import com.baidu.ar.camera.CameraManager;
import com.baidu.ar.d;
import com.baidu.ar.dc;
import com.baidu.ar.df;
import com.baidu.ar.dk;
import com.baidu.ar.fd;
import com.baidu.ar.fh;
import com.baidu.ar.fi;
import com.baidu.ar.fk;
import com.baidu.ar.ft;
import com.baidu.ar.ji;
import com.baidu.ar.jk;
import com.baidu.ar.jm;
import com.baidu.ar.jn;
import com.baidu.ar.jp;
import com.baidu.ar.jt;
import com.baidu.ar.ju;
import com.baidu.ar.jv;
import com.baidu.ar.kf;
import com.baidu.ar.kv;
import com.facebook.internal.AnalyticsEvents;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class Track2DAR extends d implements fi, ITrack2D {
    public static final int MST_TYPE_CLOSE_ALGO_TRACK = 10102;
    public static final int MST_TYPE_OPEN_ALGO_TRACK = 10101;
    private static final String TAG = "Track2DAR";
    private jp Al;
    private jv Am;
    private jk An;
    private ITrack2DStateChangedListener Ap;
    private String mCasePath;
    private ft sB;
    private df vE;
    private boolean Ao = true;
    private boolean sL = false;
    private boolean Aq = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, HashMap<String, Object> hashMap) {
        String str = TAG;
        kf.c(str, "handleMessage aMessageType = " + i);
        jk jkVar = this.An;
        if (jkVar == null) {
            return;
        }
        if (i == 8) {
            jkVar.s(hashMap);
            return;
        }
        if (i == 301) {
            r(hashMap);
            return;
        }
        if (i == 303) {
            gn();
            return;
        }
        if (i == 1901) {
            if (hashMap != null) {
                int a2 = as.a(hashMap.get("id"), -1);
                kf.c(str, "handleMessage aMessageType = " + i + " && aMessageID = " + a2);
                if (10101 == a2) {
                    gk();
                    return;
                } else {
                    if (10102 == a2) {
                        gl();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i != 305) {
            if (i == 306 && (hashMap.get("is_mirrored") instanceof Integer) && this.An != null) {
                this.An.R(((Integer) hashMap.get("is_mirrored")).intValue() == 1);
                return;
            }
            return;
        }
        if (jkVar != null) {
            if (hashMap != null && hashMap.containsKey("with_interaction") && ((Integer) hashMap.get("with_interaction")).intValue() != 0) {
                r1 = true;
            }
            this.An.S(true);
            if (r1 || t() == null) {
                return;
            }
            t().sceneRelocate();
        }
    }

    private void gi() {
        if (this.Aq) {
            gn();
        }
        this.Ao = false;
        jv jvVar = this.Am;
        if (jvVar != null) {
            a(jvVar);
            this.Am = null;
        }
        ft ftVar = this.sB;
        if (ftVar != null) {
            b(ftVar);
            this.sB = null;
        }
        this.vE = null;
        this.Ap = null;
        jk jkVar = this.An;
        if (jkVar != null) {
            jkVar.release();
            this.An = null;
        }
    }

    private void gj() {
        jp jpVar = this.Al;
        if (jpVar == null) {
            return;
        }
        if (jpVar.gt() == null || this.Al.gt().isEmpty()) {
            throw new IllegalStateException("track target info is empty");
        }
        jt jtVar = new jt();
        jtVar.H(1280);
        jtVar.I(CameraManager.DEFAULTHEIGHT);
        jn jnVar = this.Al.gt().get(0);
        jtVar.bT(jnVar.getPath() + File.separator + jnVar.gp());
        this.Am = new jv(jtVar);
        df dfVar = new df() { // from class: com.baidu.ar.track2d.Track2DAR.2
            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                if (Track2DAR.this.An == null || dcVar == null || !(dcVar instanceof ju)) {
                    return;
                }
                Track2DAR.this.An.a((ju) dcVar);
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
            }
        };
        this.vE = dfVar;
        a(this.Am, dfVar);
    }

    private void gk() {
        if (this.Ao) {
            return;
        }
        this.Ao = true;
        gj();
    }

    private void gl() {
        if (this.Ao) {
            this.Ao = false;
            jv jvVar = this.Am;
            if (jvVar != null) {
                a(jvVar);
                this.Am = null;
            }
        }
    }

    private ft gm() {
        return new ft() { // from class: com.baidu.ar.track2d.Track2DAR.3
            @Override // com.baidu.ar.ft
            public void a(final int i, final int i2, final HashMap<String, Object> hashMap) {
                if (i == 303) {
                    Track2DAR.this.c(i, i2, hashMap);
                } else {
                    kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.track2d.Track2DAR.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Track2DAR.this.c(i, i2, hashMap);
                        }
                    });
                }
            }

            @Override // com.baidu.ar.ft
            public List<Integer> q() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(8);
                arrayList.add(1901);
                arrayList.add(301);
                arrayList.add(303);
                arrayList.add(306);
                arrayList.add(305);
                return arrayList;
            }
        };
    }

    private void gn() {
        this.Aq = false;
        a((fi) this);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, 1);
        b(304, hashMap);
    }

    private void r(HashMap<String, Object> hashMap) {
        if (hashMap == null || this.An == null) {
            return;
        }
        fd fdVar = fd.RELATIVE;
        fd A = hashMap.containsKey("type") ? fd.A(((Integer) hashMap.get("type")).intValue()) : fdVar;
        boolean z = false;
        int intValue = hashMap.get("init_pos") instanceof Integer ? ((Integer) hashMap.get("init_pos")).intValue() : 0;
        fk fkVar = new fk();
        fkVar.a(A);
        fkVar.C(intValue);
        if (A == fdVar && hashMap.containsKey("resume_original_position") && ((Integer) hashMap.get("resume_original_position")).intValue() == 1) {
            z = true;
        }
        fkVar.y(z);
        fkVar.z(true);
        this.An.a(fkVar);
        a(fkVar, this);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, 1);
        b(302, hashMap2);
        this.Aq = true;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public Bitmap getTargetBitmap() {
        jp jpVar = this.Al;
        if (jpVar != null) {
            return jm.a(jpVar, this.mCasePath);
        }
        return null;
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void haltTrack() {
        jv jvVar = this.Am;
        if (jvVar != null) {
            jvVar.W(true);
        }
    }

    @Override // com.baidu.ar.d
    public void onCaseCreate(String str) {
        t().setTouchEnable(true);
        t().setFieldOfView(56.144978f);
        if (this.Ao) {
            gj();
        }
    }

    @Override // com.baidu.ar.d
    public void onCaseDestroy() {
    }

    @Override // com.baidu.ar.fi
    public void onImuUpdate(fh fhVar) {
        jk jkVar = this.An;
        if (jkVar == null || jkVar.isTracked()) {
            return;
        }
        if (!this.sL) {
            this.sL = true;
            b(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, (HashMap<String, Object>) null);
        }
        this.An.a(fhVar);
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void pause() {
        super.pause();
    }

    @Override // com.baidu.ar.d
    public void release() {
        gi();
        super.release();
    }

    @Override // com.baidu.ar.d, com.baidu.ar.cloud.ICloudIR
    public void resume() {
        super.resume();
        jk jkVar = this.An;
        if (jkVar != null) {
            jkVar.resume();
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void resumeTrack() {
        jv jvVar = this.Am;
        if (jvVar != null) {
            jvVar.W(false);
        }
    }

    @Override // com.baidu.ar.track2d.ITrack2D
    public void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener) {
        jk jkVar;
        this.Ap = iTrack2DStateChangedListener;
        if (iTrack2DStateChangedListener == null || (jkVar = this.An) == null) {
            return;
        }
        jkVar.setStateChangedListener(iTrack2DStateChangedListener);
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        String currentCasePath = t().getCurrentCasePath();
        this.mCasePath = currentCasePath;
        jp bP = jm.bP(currentCasePath);
        this.Al = bP;
        if (bP != null && bP.gv() != null) {
            this.Ao = this.Al.gv().gw() == 1;
        }
        jk jkVar = new jk(t(), this.Al, new ji() { // from class: com.baidu.ar.track2d.Track2DAR.1
            @Override // com.baidu.ar.ji
            public void b(int i, HashMap<String, Object> hashMap2) {
                Track2DAR.this.b(i, hashMap2);
            }
        });
        this.An = jkVar;
        ITrack2DStateChangedListener iTrack2DStateChangedListener = this.Ap;
        if (iTrack2DStateChangedListener != null) {
            jkVar.setStateChangedListener(iTrack2DStateChangedListener);
        }
        ft gm = gm();
        this.sB = gm;
        a(gm);
    }
}
