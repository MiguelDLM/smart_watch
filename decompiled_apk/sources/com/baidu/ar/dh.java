package com.baidu.ar;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class dh {
    private bb G;

    /* renamed from: oO, reason: collision with root package name */
    private dg f5568oO;
    private df oP;
    private OnNeedCacheFrameListener oT;
    private boolean oU;
    private ConcurrentHashMap<String, df> oQ = new ConcurrentHashMap<>();
    private List<dj> oR = Collections.synchronizedList(new ArrayList());
    private ConcurrentHashMap<String, df> oS = new ConcurrentHashMap<>();
    private long oH = 0;

    public dh(bb bbVar, Looper looper) {
        this.G = bbVar;
        OnNeedCacheFrameListener onNeedCacheFrameListener = new OnNeedCacheFrameListener() { // from class: com.baidu.ar.dh.1
            @Override // com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener
            public boolean isNeedCacheFrame(long j) {
                if (dh.this.f5568oO == null) {
                    return false;
                }
                if (dh.this.oH != j) {
                    dh dhVar = dh.this;
                    dhVar.oU = dhVar.f5568oO.cR();
                }
                dh.this.oH = j;
                return dh.this.oU;
            }
        };
        this.oT = onNeedCacheFrameListener;
        this.G.setCacheFrameListener(onNeedCacheFrameListener);
        this.f5568oO = new dg(looper);
        df dfVar = new df() { // from class: com.baidu.ar.dh.2
            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                dh.this.i(dcVar);
                if (dh.this.G != null) {
                    dh.this.G.setSyncFrameTimestamp(dcVar.getTimestamp());
                }
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
                kf.c("DetectorManager", "mSyncDetectorGroup onRelease result = " + dkVar.isSuccess());
                dh.this.h(dkVar);
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
                kf.c("DetectorManager", "mSyncDetectorGroup onSetup result = " + dkVar.isSuccess());
                dh.this.g(dkVar);
            }
        };
        this.oP = dfVar;
        this.f5568oO.a(dfVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(dk dkVar) {
        if (dkVar != null) {
            if (dkVar.cN() != "DetectorGroup") {
                ConcurrentHashMap<String, df> concurrentHashMap = this.oQ;
                if (concurrentHashMap != null && concurrentHashMap.get(dkVar.cN()) != null) {
                    this.oQ.get(dkVar.cN()).a(dkVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(dk dkVar) {
        if (dkVar != null) {
            if (dkVar.cN() != "DetectorGroup") {
                ConcurrentHashMap<String, df> concurrentHashMap = this.oQ;
                if (concurrentHashMap != null && concurrentHashMap.get(dkVar.cN()) != null) {
                    this.oQ.get(dkVar.cN()).b(dkVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(dc dcVar) {
        ConcurrentHashMap<String, df> concurrentHashMap;
        if (dcVar != null) {
            if (dcVar instanceof dd) {
                Iterator<dc> it = ((dd) dcVar).cP().iterator();
                while (it.hasNext()) {
                    dc next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.cN()) && (concurrentHashMap = this.oQ) != null && concurrentHashMap.get(next.cN()) != null) {
                        this.oQ.get(next.cN()).a(next);
                    }
                }
            }
        }
    }

    public synchronized void cS() {
        try {
            List<dj> list = this.oR;
            if (list != null) {
                Iterator<dj> it = list.iterator();
                while (it.hasNext()) {
                    it.next().release();
                }
                this.oR.clear();
                this.oR = null;
            }
            dg dgVar = this.f5568oO;
            if (dgVar != null) {
                dgVar.release();
                bb bbVar = this.G;
                if (bbVar != null) {
                    bbVar.enableSyncRender(false);
                }
                this.f5568oO = null;
            }
            ConcurrentHashMap<String, df> concurrentHashMap = this.oQ;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
                this.oQ = null;
            }
            ConcurrentHashMap<String, df> concurrentHashMap2 = this.oS;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
                this.oS = null;
            }
            this.oP = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void release() {
        cS();
        this.G = null;
        this.oT = null;
    }

    public synchronized void a(di diVar) {
        if (diVar != null) {
            try {
                if (!TextUtils.isEmpty(diVar.getName())) {
                    if (diVar.cU() && this.oR.contains(diVar)) {
                        if (this.f5568oO.isEmpty()) {
                            this.G.enableSyncRender(true);
                        }
                        this.oR.remove(diVar);
                        this.f5568oO.b(diVar, this.oS.get(diVar.getName()));
                        df remove = this.oS.remove(diVar.getName());
                        if (remove != null) {
                            this.oQ.put(diVar.getName(), remove);
                        }
                    } else if (!diVar.cU() && this.f5568oO.b(diVar)) {
                        this.f5568oO.c(diVar);
                        this.oR.add(diVar);
                        diVar.d(this.oQ.get(diVar.getName()));
                        df remove2 = this.oQ.remove(diVar.getName());
                        if (remove2 != null) {
                            this.oS.put(diVar.getName(), remove2);
                        }
                        if (this.f5568oO.isEmpty()) {
                            this.G.enableSyncRender(false);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public synchronized void a(dj djVar) {
        if (djVar == null) {
            kf.b("DetectorManager", "handleRemoveDetector detector is NULLLLL!!!");
            return;
        }
        List<dj> list = this.oR;
        if (list == null || !list.contains(djVar)) {
            dg dgVar = this.f5568oO;
            if (dgVar != null && dgVar.b(djVar)) {
                this.f5568oO.a(djVar);
                if (this.f5568oO.isEmpty()) {
                    this.G.enableSyncRender(false);
                }
            }
        } else {
            djVar.release();
            this.oR.remove(djVar);
        }
    }

    public synchronized void a(dj djVar, df dfVar) {
        ConcurrentHashMap<String, df> concurrentHashMap;
        String name;
        if (djVar == null) {
            return;
        }
        try {
            if ((djVar instanceof di) && ((di) djVar).cU()) {
                if (this.f5568oO.isEmpty()) {
                    this.G.enableSyncRender(true);
                }
                if (!this.f5568oO.b(djVar)) {
                    this.f5568oO.a(djVar, dfVar);
                    concurrentHashMap = this.oQ;
                    name = djVar.getName();
                    concurrentHashMap.put(name, dfVar);
                }
                return;
            }
            List<dj> list = this.oR;
            if (list != null && !list.contains(djVar)) {
                djVar.a(dfVar);
                this.oR.add(djVar);
                concurrentHashMap = this.oS;
                name = djVar.getName();
                concurrentHashMap.put(name, dfVar);
            }
            return;
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }
}
