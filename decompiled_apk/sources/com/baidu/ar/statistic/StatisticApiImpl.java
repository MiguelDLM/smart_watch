package com.baidu.ar.statistic;

import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import com.baidu.ar.ij;
import com.baidu.ar.ik;
import com.baidu.ar.il;
import com.baidu.ar.im;
import com.baidu.ar.ip;
import com.baidu.ar.iq;
import com.baidu.ar.ir;
import com.baidu.ar.is;
import com.baidu.ar.it;
import com.baidu.ar.iu;
import com.baidu.ar.iv;
import com.baidu.ar.iw;
import com.baidu.ar.iz;
import com.baidu.ar.ja;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class StatisticApiImpl implements ip, iu.a {
    private im yO;
    private HandlerThread zv;
    private il zw;
    private Thread zx;
    private iq zy;
    private volatile it zz;

    public StatisticApiImpl(Context context, HandlerThread handlerThread) {
        this.yO = new im(context, "ar_stats_local.json", 100, 40);
        im imVar = new im(context, "ar_stats_pfm_local.json", 200, 0);
        this.zz = new it(imVar, 20, 200);
        a(handlerThread, new ik(context, this.yO, iz.zA, ja.gd(), this.zz));
        a(context, imVar);
        this.zw.b(1, null);
        k(context);
    }

    private void a(Context context, im imVar) {
        im imVar2 = this.yO;
        this.zy = new iq(context, imVar2, new ir[]{new ir(imVar2, 1, new is(), true), new iv(imVar, 20, new iw(), false)});
        Thread thread = new Thread(this.zy, "StatsLogSendThd");
        this.zx = thread;
        thread.start();
    }

    private void k(Context context) {
        new iu(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
    }

    public void doRelease() {
        synchronized (this) {
            try {
                HandlerThread handlerThread = this.zv;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                }
                iq iqVar = this.zy;
                if (iqVar != null) {
                    iqVar.shutdown();
                }
                if (this.zx != null) {
                    synchronized (this.yO) {
                        try {
                            if (this.yO.isEmpty()) {
                                this.zx.interrupt();
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ij.release();
    }

    @Override // com.baidu.ar.ip
    public boolean isAllowPerformanceEvent(String str) {
        return this.zz.bJ(str);
    }

    @Override // com.baidu.ar.ip
    public void onEvent(String str, String str2) {
        ij bz = ij.bz(str);
        bz.a("event_param", str2);
        this.zw.b(2, bz);
    }

    @Override // com.baidu.ar.ip
    public void onEventDebounce(String str, long j, String str2) {
        ij bz = ij.bz(str);
        bz.a("_db_period", Long.valueOf(j));
        bz.a("event_param", str2);
        this.zw.b(6, bz);
    }

    @Override // com.baidu.ar.ip
    public void onEventEnd(String str) {
        this.zw.b(5, ij.bz(str));
    }

    @Override // com.baidu.ar.ip
    public void onEventStart(String str) {
        this.zw.b(4, ij.bz(str));
    }

    @Override // com.baidu.ar.ip
    public void onEventStatus(String str, String str2, boolean z) {
        ij bz = ij.bz(str);
        bz.a("__stt", z ? "1" : "0");
        bz.a("__falseev", str2);
        this.zw.b(3, bz);
    }

    @Override // com.baidu.ar.ip
    public void onPerformance(String str, Map<String, String> map) {
        synchronized (this.zz) {
            try {
                if (this.zz.bJ(str)) {
                    ij bz = ij.bz(str);
                    bz.c(map);
                    this.zw.b(20, bz);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.baidu.ar.iu.a
    public void onPerformanceRequestFinished(List<String> list) {
        this.zw.b(21, list);
    }

    @Override // com.baidu.ar.ip
    public void pause() {
        this.zw.b(97, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.ip
    public void release() {
        this.zw.b(99, this);
    }

    @Override // com.baidu.ar.ip
    public void resume() {
        this.zw.b(98, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.ip
    public void setPubParam(String str, String str2) {
        this.zw.setPubParam(str, str2);
    }

    @Override // com.baidu.ar.ip
    public void setPubParams(Map<String, String> map) {
        this.zw.setPubParams(map);
    }

    private void a(HandlerThread handlerThread, ik ikVar) {
        HandlerThread handlerThread2;
        if (handlerThread != null) {
            this.zv = handlerThread;
            if (handlerThread.getState() == Thread.State.NEW) {
                handlerThread2 = this.zv;
            }
            this.zw = new il(this.zv.getLooper(), ikVar);
        }
        handlerThread2 = new HandlerThread("StatsEventThd", 10);
        this.zv = handlerThread2;
        handlerThread2.start();
        this.zw = new il(this.zv.getLooper(), ikVar);
    }

    @Override // com.baidu.ar.ip
    public void onEvent(String str, Map<String, String> map) {
        ij bz = ij.bz(str);
        bz.c(map);
        this.zw.b(2, bz);
    }

    @Override // com.baidu.ar.ip
    public void onEventDebounce(String str, long j, Map<String, String> map) {
        ij bz = ij.bz(str);
        bz.c(map);
        bz.a("_db_period", Long.valueOf(j));
        this.zw.b(6, bz);
    }

    @Override // com.baidu.ar.ip
    public void onPerformance(String str, JSONObject jSONObject) {
        synchronized (this.zz) {
            try {
                if (this.zz.bJ(str)) {
                    ij bz = ij.bz(str);
                    bz.a("data", jSONObject);
                    this.zw.b(20, bz);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
