package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public final class a {
    private static c aJA = null;
    private static HandlerThread aJB = null;
    private static Handler aJC = null;
    private static int aJr = -1;
    private static volatile boolean aJs;
    private static List<HttpDnsInfo.IpInfo> aJt = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aJu = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> aJv = new CopyOnWriteArrayList();
    private static List<c> aJw = new CopyOnWriteArrayList();
    private static List<c> aJx = new CopyOnWriteArrayList();
    private static PriorityBlockingQueue<c> aJy = new PriorityBlockingQueue<>();
    private static AtomicInteger aJz = new AtomicInteger(0);
    private static volatile boolean aJD = false;
    private static float aJE = -1.0f;
    private static float aJF = -1.0f;
    private static float aJG = -1.0f;
    private static int aJH = 0;
    private static volatile boolean aJI = false;
    private static volatile boolean aJJ = false;
    private static NetworkMonitor.a aJK = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (a.aJJ) {
                a.access$102(true);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            } else {
                a.access$002(true);
            }
        }
    };
    private static Runnable aJL = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.Jl();
        }
    };

    private static void G(List<HttpDnsInfo.IpInfo> list) {
        b(list, aJw);
        if (!aJw.isEmpty()) {
            Iterator<c> it = aJw.iterator();
            float f = 0.0f;
            while (it.hasNext()) {
                f += it.next().JC();
            }
            aJE = f / aJw.size();
        }
    }

    private static void H(List<HttpDnsInfo.IpInfo> list) {
        b(list, aJx);
        if (aJx.isEmpty()) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        for (c cVar : aJx) {
            if (cVar != null) {
                i += cVar.getWeight();
                f += cVar.getWeight() * cVar.JC();
            }
        }
        if (i != 0) {
            aJF = f / i;
        }
    }

    private static void Jg() {
        Handler handler;
        if (!aJD && (handler = aJC) != null) {
            handler.obtainMessage(1).sendToTarget();
        }
    }

    public static String Jh() {
        c cVar = aJA;
        if (cVar != null) {
            return cVar.getIp();
        }
        return "";
    }

    public static float Ji() {
        return aJE;
    }

    public static float Jj() {
        return aJF;
    }

    public static float Jk() {
        return aJG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Jl() {
        Jq();
        List<HttpDnsInfo.IpInfo> list = aJt;
        List<HttpDnsInfo.IpInfo> list2 = aJu;
        clear();
        if (aJD) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "start pick");
        aJD = true;
        G(list);
        H(list2);
        if (aJw.isEmpty() && aJx.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                aJD = false;
                return;
            } else {
                if (!hVar.zr()) {
                    com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                    aJD = false;
                    return;
                }
                Jo();
            }
        }
        aJD = false;
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Jm() {
        if (!Jn()) {
            Jp();
        }
    }

    private static boolean Jn() {
        List<c> list = aJw;
        List<c> list2 = aJx;
        if (!list.isEmpty()) {
            aJA = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from recommend:" + aJA);
            aJH = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int i2 = 0;
        for (c cVar : list2) {
            if (cVar != null) {
                i2 += cVar.getWeight();
            }
        }
        if (i2 <= 0) {
            return false;
        }
        int nextInt = random.nextInt(i2);
        int i3 = 0;
        while (true) {
            if (i3 >= list2.size()) {
                break;
            }
            if (list2.get(i3) != null) {
                nextInt -= list2.get(i3).getWeight();
            }
            if (nextInt < 0) {
                i = i3;
                break;
            }
            i3++;
        }
        aJA = list2.get(i);
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from backUp:" + aJA);
        aJH = 2;
        return true;
    }

    private static void Jo() {
        List<HttpDnsInfo.IpInfo> list = aJv;
        if (!list.isEmpty()) {
            for (HttpDnsInfo.IpInfo ipInfo : list) {
                if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                    c f = b.f(ipInfo.ip, aJr);
                    if (f.isSuccess()) {
                        aJy.offer(f);
                    }
                }
            }
            c peek = aJy.peek();
            if (peek != null) {
                aJG = peek.JC();
            }
        }
    }

    private static void Jp() {
        if (aJy.isEmpty()) {
            return;
        }
        c peek = aJy.peek();
        if (peek.JC() < aJr) {
            aJA = peek;
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from Other:" + aJA);
            aJH = 3;
        }
    }

    private static void Jq() {
        if (aJr == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                aJr = hVar.zs();
            } else {
                aJr = 200;
            }
        }
    }

    private static boolean Jr() {
        if (aJI) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = aJz.get();
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "value:" + i);
        if (i > 3) {
            return false;
        }
        return true;
    }

    private static void Js() {
        aJz.getAndIncrement();
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "addFailedTimes:" + aJz.intValue());
    }

    public static void Jt() {
        c cVar;
        Handler handler;
        if (aJs && (cVar = aJA) != null && !TextUtils.isEmpty(cVar.getIp()) && (handler = aJC) != null) {
            handler.obtainMessage(2).sendToTarget();
        }
    }

    public static void Ju() {
        Js();
        Jv();
        Jw();
        aJH = 0;
        Jm();
        Jl();
    }

    private static void Jv() {
        String ip;
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = aJA;
        if (cVar == null) {
            ip = "";
        } else {
            ip = cVar.getIp();
        }
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aJt.iterator();
        while (true) {
            ipInfo = null;
            if (it.hasNext()) {
                ipInfo2 = it.next();
                if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.ip)) {
                    break;
                }
            } else {
                ipInfo2 = null;
                break;
            }
        }
        if (ipInfo2 != null) {
            aJt.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aJu.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next = it2.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                ipInfo2 = next;
                break;
            }
        }
        if (ipInfo2 != null) {
            aJu.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aJv.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it3.next();
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                ipInfo = next2;
                break;
            }
        }
        if (ipInfo != null) {
            aJv.remove(ipInfo);
        }
    }

    private static void Jw() {
        c cVar;
        if (aJA == null) {
            return;
        }
        List<c> list = aJw;
        if (list != null && !list.isEmpty() && aJw.contains(aJA)) {
            aJw.remove(aJA);
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + aJA);
        }
        List<c> list2 = aJx;
        if (list2 != null && !list2.isEmpty()) {
            if (aJx.contains(aJA)) {
                aJx.remove(aJA);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aJA);
            }
            Iterator<c> it = aJx.iterator();
            while (true) {
                if (it.hasNext()) {
                    cVar = it.next();
                    if (cVar != null && TextUtils.equals(cVar.getIp(), aJA.getIp())) {
                        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set removeEntity:" + cVar.getIp());
                        break;
                    }
                } else {
                    cVar = null;
                    break;
                }
            }
            if (cVar != null) {
                aJx.remove(cVar);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = aJy.peek();
        if (peek != null && peek == aJA) {
            aJy.poll();
        }
        aJA = null;
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean zq = hVar.zq();
        aJs = zq;
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isEnable:" + zq);
        if (!zq) {
            return;
        }
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", httpDnsInfo.toString());
        List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
        aJt = list;
        aJu = httpDnsInfo.backUpList;
        aJv = httpDnsInfo.otherList;
        if (list.isEmpty() && aJu.isEmpty() && aJv.isEmpty()) {
            com.kwad.sdk.core.e.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
        } else {
            init();
            Jg();
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        aJJ = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        aJI = true;
        return true;
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", ipInfo.toString());
                c f = b.f(ipInfo.ip, aJr);
                f.dB(ipInfo.weight);
                if (f.isSuccess() && f.JC() < aJr) {
                    list2.add(f);
                }
            }
        }
    }

    private static void clear() {
        aJw.clear();
        aJx.clear();
        aJy.clear();
    }

    @Nullable
    public static String fX(String str) {
        if (!aJs) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        }
        if (fY(str)) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        }
        if (!Jr()) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        }
        String Jh = Jh();
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "getIpByHost ip:" + Jh);
        return Jh;
    }

    private static boolean fY(String str) {
        boolean equals = TextUtils.equals(BNWebViewClient.URL_HTTPS_PREFIX + str, com.kwad.sdk.h.yA());
        boolean z = equals ^ true;
        if (!equals) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "非核心域名 current host:" + com.kwad.sdk.h.yA() + "try direct host:https://" + str);
        }
        return z;
    }

    public static int getType() {
        return aJH;
    }

    private static void init() {
        if (aJB != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aJB = handlerThread;
        handlerThread.start();
        aJC = new Handler(aJB.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i == 1) {
                    a.Jl();
                    a.Jm();
                } else if (i == 2) {
                    a.Ju();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), aJK);
        }
    }
}
