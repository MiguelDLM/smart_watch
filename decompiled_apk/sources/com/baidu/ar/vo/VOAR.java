package com.baidu.ar.vo;

import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
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
import com.baidu.ar.kv;
import com.baidu.ar.ky;
import com.baidu.ar.kz;
import com.baidu.ar.la;
import com.baidu.ar.lb;
import com.baidu.ar.le;
import com.baidu.ar.lf;
import com.baidu.ar.lg;
import com.baidu.ar.lh;
import com.baidu.ar.lk;
import com.baidu.ar.lp;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class VOAR extends d {
    private static final String TAG = "VOAR";
    private le DA;
    private kz DB;
    private fh DC;
    private lb Dy;
    private lg Dz;
    private ft sB;
    private fi sW;
    private df vE;

    private void gi() {
        a(this.Dz);
        ft ftVar = this.sB;
        if (ftVar != null) {
            b(ftVar);
            this.sB = null;
        }
        fi fiVar = this.sW;
        if (fiVar != null) {
            a(fiVar);
            this.sW = null;
        }
        this.Dz = null;
        this.vE = null;
        kz kzVar = this.DB;
        if (kzVar != null) {
            kzVar.release();
            this.DB = null;
        }
        le leVar = this.DA;
        if (leVar != null) {
            leVar.release();
            this.DA = null;
        }
    }

    private ft gm() {
        return new ft() { // from class: com.baidu.ar.vo.VOAR.5
            @Override // com.baidu.ar.ft
            public void a(final int i, final int i2, final HashMap<String, Object> hashMap) {
                kv.runOnUiThread(new Runnable() { // from class: com.baidu.ar.vo.VOAR.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VOAR.this.c(i, i2, hashMap);
                    }
                });
            }

            @Override // com.baidu.ar.ft
            public List<Integer> q() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(401);
                arrayList.add(4100);
                arrayList.add(1901);
                return arrayList;
            }
        };
    }

    private lf hD() {
        lf lfVar = new lf();
        lfVar.DY = 1280;
        lfVar.DZ = CameraManager.DEFAULTHEIGHT;
        lfVar.Ea = new lf.a() { // from class: com.baidu.ar.vo.VOAR.2
            @Override // com.baidu.ar.lf.a
            public float getAngle() {
                return VOAR.this.hG();
            }

            @Override // com.baidu.ar.lf.a
            public float[] hF() {
                return VOAR.this.hF();
            }
        };
        return lfVar;
    }

    private void hE() {
        fk fkVar = new fk();
        fkVar.a(fd.WORLD);
        fkVar.C(0);
        fkVar.y(false);
        fkVar.z(true);
        fi fiVar = new fi() { // from class: com.baidu.ar.vo.VOAR.6
            @Override // com.baidu.ar.fi
            public void onImuUpdate(fh fhVar) {
                VOAR.this.DC = fhVar;
            }
        };
        this.sW = fiVar;
        a(fkVar, fiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] hF() {
        fh fhVar = this.DC;
        if (fhVar == null) {
            return null;
        }
        return fhVar.getMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float hG() {
        fh fhVar = this.DC;
        return (fhVar == null ? null : Float.valueOf(fhVar.getAngle())).floatValue();
    }

    private lk t(HashMap<String, Object> hashMap) {
        lk lkVar = new lk();
        lkVar.x = ((Float) hashMap.get("x")).floatValue();
        lkVar.y = ((Float) hashMap.get("y")).floatValue();
        lkVar.type = ((Integer) hashMap.get("type")).intValue();
        lkVar.Eh = ((Float) hashMap.get(xOxOoo.f15470o00)).floatValue();
        lkVar.Ei = true;
        return lkVar;
    }

    @Override // com.baidu.ar.d
    public void onCaseCreate(String str) {
        hE();
        t().set3DModelVisible(true);
        t().setTouchEnable(true);
        t().setFieldOfView(56.144978f);
        t().initWorldAxis();
        t().setInteractionCallback(new ARPDataInteraction.b() { // from class: com.baidu.ar.vo.VOAR.4
            @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.b
            public void a(float f, float f2, float f3) {
                if (VOAR.this.DB != null) {
                    VOAR.this.DB.c(f, f2, f3);
                }
            }
        });
        a(this.Dz, this.vE);
    }

    @Override // com.baidu.ar.d
    public void onCaseDestroy() {
    }

    @Override // com.baidu.ar.d
    public void release() {
        gi();
        super.release();
    }

    @Override // com.baidu.ar.d
    public void setup(HashMap<String, Object> hashMap) {
        super.setup(hashMap);
        this.Dy = la.cs(t().getCurrentCasePath());
        lf hD = hD();
        this.DA = new le(hD);
        this.Dz = new lg(this.Dy, this.DA);
        this.vE = new df() { // from class: com.baidu.ar.vo.VOAR.1
            private int vG = 0;

            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                if (VOAR.this.DB == null || dcVar == null || !(dcVar instanceof lh)) {
                    return;
                }
                int i = this.vG;
                if (i < 3) {
                    this.vG = i + 1;
                } else {
                    VOAR.this.DB.a((lh) dcVar, VOAR.this.hF());
                }
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
                this.vG = 0;
            }
        };
        this.DB = new kz(a(hD), this.Dy, this.DA, hD);
        ft gm = gm();
        this.sB = gm;
        a(gm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2, HashMap<String, Object> hashMap) {
        lk t;
        boolean z;
        kz kzVar = this.DB;
        if (kzVar == null) {
            return;
        }
        if (i == 401) {
            if (kzVar == null || hashMap == null || !(hashMap.get("app_type") instanceof String)) {
                return;
            }
            this.DB.af("None".equals((String) hashMap.get("app_type")));
            return;
        }
        if (i != 1901) {
            if (i != 4100) {
                return;
            }
            t = t(hashMap);
            z = false;
        } else {
            if (hashMap == null) {
                return;
            }
            int a2 = as.a(hashMap.get("id"), -1);
            if (4100 != a2) {
                if (4200 == a2) {
                    this.DB.start();
                    return;
                }
                return;
            }
            t = t(hashMap);
            z = true;
        }
        t.Ei = z;
        this.DB.a(t);
    }

    private lp a(lf lfVar) {
        lp lpVar = new lp(t(), this.Dy, this.DA, new ky() { // from class: com.baidu.ar.vo.VOAR.3
            @Override // com.baidu.ar.ky
            public void b(int i, HashMap<String, Object> hashMap) {
                VOAR.this.b(i, hashMap);
            }

            @Override // com.baidu.ar.ky
            public void d(HashMap<String, Object> hashMap) {
                VOAR.this.d(hashMap);
            }
        });
        lpVar.setPreviewSize(lfVar.DY, lfVar.DZ);
        return lpVar;
    }
}
