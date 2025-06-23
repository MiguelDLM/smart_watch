package com.baidu.ar;

import com.baidu.ar.slam.TrackModel;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class kz {
    private lm DF;
    private ll DG;
    private lf DH;
    private volatile boolean DJ;
    private volatile boolean DI = false;
    private volatile boolean DK = false;

    public kz(lm lmVar, lb lbVar, lc lcVar, lf lfVar) {
        this.DJ = true;
        this.DF = lmVar;
        this.DH = lfVar;
        if (lbVar != null) {
            this.DJ = lbVar.hL();
        }
        this.DG = a(lbVar, lcVar);
    }

    private ll a(lb lbVar, lc lcVar) {
        if (lbVar == null) {
            lm lmVar = this.DF;
            lf lfVar = this.DH;
            return new lj(lmVar, lfVar.DY, lfVar.DZ);
        }
        if (lbVar.hH() == 1) {
            lm lmVar2 = this.DF;
            lf lfVar2 = this.DH;
            lo loVar = new lo(lmVar2, lbVar, lfVar2.DY, lfVar2.DZ);
            loVar.a(lcVar);
            return loVar;
        }
        if (lbVar.hH() != 0) {
            return null;
        }
        lm lmVar3 = this.DF;
        lf lfVar3 = this.DH;
        return new ln(lmVar3, lbVar, lfVar3.DY, lfVar3.DZ);
    }

    public void af(boolean z) {
        this.DK = z;
    }

    public void c(float f, float f2, float f3) {
        lk lkVar = new lk();
        lkVar.x = f;
        lkVar.y = f2;
        lkVar.Eh = f3;
        lkVar.type = 2;
        a(lkVar);
    }

    public void release() {
        lm lmVar = this.DF;
        if (lmVar != null) {
            lmVar.release();
            this.DF = null;
        }
        this.DG = null;
    }

    public void start() {
        this.DJ = true;
    }

    public void a(lh lhVar, float[] fArr) {
        float[] a2;
        if (!this.DJ || this.DK) {
            return;
        }
        li hN = lhVar.hN();
        if (this.DI) {
            if (hN == null || (a2 = a(hN)) == null || a2.length <= 0) {
                return;
            }
            this.DF.j(a2);
            return;
        }
        ll llVar = this.DG;
        if (llVar != null) {
            this.DI = llVar.i(fArr);
            if (this.DI) {
                this.DF.hS();
                StatisticApi.onEvent(StatisticConstants.SLAM_TRACK_ON);
            }
        }
    }

    public void a(lk lkVar) {
        this.DF.a(lkVar);
    }

    private float[] a(li liVar) {
        ArrayList<TrackModel> hO = liVar.hO();
        return (hO == null || hO.isEmpty()) ? new float[0] : hO.get(0).getPose();
    }
}
