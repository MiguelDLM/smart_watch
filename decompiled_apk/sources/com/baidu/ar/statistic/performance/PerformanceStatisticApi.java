package com.baidu.ar.statistic.performance;

import android.os.SystemClock;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.io;
import com.baidu.ar.jb;
import com.baidu.ar.kj;
import com.baidu.ar.statistic.StatisticApi;
import java.util.Random;

/* loaded from: classes7.dex */
public class PerformanceStatisticApi implements io {
    private jb.a zE;
    private int zB = 0;
    private boolean zC = false;
    private jb zD = new jb();
    private kj.a zF = new kj.a();

    private void ge() {
        if (this.zE == null) {
            jb.a aVar = new jb.a();
            this.zE = aVar;
            int i = this.zB + 1;
            this.zB = i;
            aVar.zM = i;
            this.zD.zL.add(aVar);
        }
    }

    @Override // com.baidu.ar.io
    public void onFrameIn() {
        try {
            if (this.zC) {
                ge();
                this.zE.zN = SystemClock.elapsedRealtime();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.io
    public void onFrameOut() {
        try {
            if (this.zC) {
                ge();
                this.zE.zO = SystemClock.elapsedRealtime();
                if (this.zB >= 3) {
                    jb jbVar = this.zD;
                    kj.a aVar = this.zF;
                    jbVar.zI = aVar.zI;
                    jbVar.zH = aVar.zH;
                    jbVar.zJ = aVar.zJ;
                    jbVar.zK = aVar.zK;
                    jbVar.zG = ARConfig.getARKey();
                    StatisticApi.onPerformance("performance_summary", this.zD.gf());
                    this.zD.gg();
                    this.zB = 0;
                    this.zC = false;
                }
                this.zE = null;
            }
            if (!this.zC && StatisticApi.isAllowPerformanceEvent("performance_summary") && new Random().nextInt(20) == 1) {
                this.zC = true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void recordAlgoTimeCost(String str, String str2, long j, int i) {
        try {
            if (this.zC) {
                ge();
                jb.a.C0121a c0121a = new jb.a.C0121a();
                c0121a.name = str;
                c0121a.zQ = str2;
                c0121a.zR = j;
                c0121a.count = i;
                this.zE.zP.add(c0121a);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void switchCase(String str) {
        try {
            this.zD.zG = str;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
