package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class c {
    public static final String TAG = "c";
    private static int aBZ;
    private static int aCa;
    private static int aCb;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aCc = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aCd = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    public static /* synthetic */ int GC() {
        int i = aBZ;
        aBZ = i + 1;
        return i;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aCc.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aCd.put(threadPoolExecutor, str);
    }

    public static void cM(final String str) {
        g.execute(new az() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                d eE;
                int i;
                if (!TextUtils.isEmpty(str) && (eE = c.eE(str)) != null && (i = eE.aCa) != 0) {
                    int unused = c.aCa = i;
                    if (Math.random() * c.aCa < 1.0d) {
                        c.a(eE);
                    }
                }
            }
        });
    }

    public static d eE(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.aBP = str;
        bVar.aBQ = threadPoolExecutor.getCorePoolSize();
        bVar.aBR = threadPoolExecutor.getMaximumPoolSize();
        bVar.aBS = threadPoolExecutor.getPoolSize();
        bVar.aBT = threadPoolExecutor.getActiveCount();
        bVar.aBW = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aCc;
        long longValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.aBV = completedTaskCount - longValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.aBU = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).GG();
        } else {
            bVar.aBU = 0L;
        }
        bVar.aBX = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.aBY = aCa;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.aCh = true;
        com.kwad.sdk.core.threads.a.a.aCh = true;
        interval = dVar.interval;
        aCb = dVar.aCg;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new az() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                ExecutorService eD;
                for (String str : GlobalThreadPools.Gw()) {
                    if (str != null && !c.aCd.containsValue(str) && (eD = GlobalThreadPools.eD(str)) != null && (eD instanceof ThreadPoolExecutor) && !c.aCc.containsKey(eD)) {
                        c.a((ThreadPoolExecutor) eD, str);
                    }
                }
                int i = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.aCd.keySet()) {
                    String str2 = (String) c.aCd.get(threadPoolExecutor);
                    i += threadPoolExecutor.getPoolSize();
                    b b = c.b(threadPoolExecutor, str2);
                    if (b != null) {
                        com.kwad.sdk.commercial.b.q(b);
                    }
                }
                b bVar = new b();
                bVar.aBP = "total";
                bVar.aBS = i;
                com.kwad.sdk.commercial.b.q(bVar);
                c.GC();
                if (c.aBZ < c.aCb) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }
}
