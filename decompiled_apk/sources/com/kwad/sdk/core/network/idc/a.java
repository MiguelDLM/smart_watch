package com.kwad.sdk.core.network.idc;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class a {
    private static final int axR;
    private final Map<String, String> axM;
    private final com.kwad.sdk.core.network.idc.a.b axN;
    private final Random axO;
    private final Map<String, AtomicBoolean> axP;
    private final Map<String, com.kwad.sdk.core.network.idc.a.a> axQ;
    private volatile int axS;
    private volatile boolean axT;
    private Context mContext;

    /* renamed from: com.kwad.sdk.core.network.idc.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0857a {
        private static final a axW = new a(0);
    }

    static {
        int i;
        if (com.kwad.framework.a.a.md.booleanValue()) {
            i = 0;
        } else {
            i = 60000;
        }
        axR = i;
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a EE() {
        return C0857a.axW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void EF() {
        com.kwad.sdk.core.network.idc.a.b bn = b.bn(this.mContext);
        if (bn.isEmpty()) {
            bn = b.bm(this.mContext);
        }
        this.axN.a(bn);
    }

    @WorkerThread
    private void V(@NonNull String str, String str2) {
        String host;
        boolean z;
        StringBuilder sb;
        List<String> ef = this.axN.ef(str2);
        if (!ef.isEmpty() && (host = Uri.parse(str).getHost()) != null && !host.isEmpty()) {
            c.d("IdcManager", ">>> switchHost start, try get lock, type = " + str2 + ", old host = " + host);
            AtomicBoolean atomicBoolean = this.axP.get(str2);
            if (atomicBoolean.compareAndSet(false, true)) {
                try {
                    String ed = ed(str2);
                    if (!TextUtils.isEmpty(ed) && !host.equals(ed)) {
                        atomicBoolean.set(false);
                        sb = new StringBuilder("<<< switchHost end, type = ");
                    } else {
                        int size = ef.size();
                        int indexOf = ef.indexOf(host);
                        if (indexOf >= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            size--;
                        }
                        if (size <= 0) {
                            atomicBoolean.set(false);
                            sb = new StringBuilder("<<< switchHost end, type = ");
                        } else {
                            int nextInt = this.axO.nextInt(size) + 1;
                            if (z) {
                                nextInt += indexOf;
                            }
                            int size2 = nextInt % ef.size();
                            String str3 = ef.get(size2);
                            c.d("IdcManager", "switchHost success, type = " + str2 + ", old host = " + host + ",new host = " + str3 + ",hostList = " + ef + ", key = " + size2);
                            X(str2, str3);
                            if (p(str2, size2)) {
                                ea(str2);
                            }
                            atomicBoolean.set(false);
                            sb = new StringBuilder("<<< switchHost end, type = ");
                        }
                    }
                    sb.append(str2);
                    sb.append(", old host = ");
                    sb.append(host);
                    c.d("IdcManager", sb.toString());
                } catch (Throwable th) {
                    atomicBoolean.set(false);
                    c.d("IdcManager", "<<< switchHost end, type = " + str2 + ", old host = " + host);
                    throw th;
                }
            }
        }
    }

    private void X(String str, String str2) {
        c.d("IdcManager", "updateCurrentIdc: hostType = " + str + ",new host = " + str2);
        this.axM.put(str, str2);
        g.execute(new az() { // from class: com.kwad.sdk.core.network.idc.a.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.a(a.this.mContext, (Map<String, String>) a.this.axM);
            }
        });
    }

    private void ea(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        c.d("IdcManager", "save switched host, type = " + str);
        this.axQ.put(str, new com.kwad.sdk.core.network.idc.a.a(elapsedRealtime, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public boolean ec(String str) {
        boolean gN;
        String str2;
        String ed = ed(str);
        List<String> ef = this.axN.ef(str);
        if (ef.isEmpty()) {
            return false;
        }
        String str3 = ef.get(0);
        if (TextUtils.equals(str3, ed)) {
            return true;
        }
        if ("api".equals(str)) {
            if (com.kwad.framework.a.a.md.booleanValue()) {
                str2 = "beta2-ad-open-api.test.gifshow.com";
            } else {
                str2 = str3;
            }
            gN = c(str2, this.mContext);
        } else {
            gN = ah.gN(str3);
        }
        c.d("IdcManager", "perform ping action for " + str + ",mainHost = " + str3 + ",isSuccess = " + gN);
        if (gN) {
            X(str, str3);
        }
        return gN;
    }

    private String ed(String str) {
        return this.axM.get(str);
    }

    private boolean p(String str, int i) {
        if ("api".equals(str) && i > 0 && !this.axQ.containsKey(str) && this.axS > 0) {
            return true;
        }
        return false;
    }

    public final boolean EG() {
        if (!this.axQ.isEmpty()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String W(String str, String str2) {
        String str3 = this.axM.get(str);
        if (TextUtils.isEmpty(str3)) {
            return str2;
        }
        return str3;
    }

    public final String Y(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String ed = ed(str2);
        if (ed != null && !ed.isEmpty()) {
            Uri parse = Uri.parse(str);
            if (TextUtils.isEmpty(parse.getPath())) {
                return str;
            }
            if (ed.equals(parse.getHost())) {
                return str;
            }
            Uri.Builder builder = new Uri.Builder();
            builder.authority(ed);
            if (TextUtils.isEmpty(parse.getScheme())) {
                builder.scheme("https");
            } else {
                builder.scheme(parse.getScheme());
            }
            builder.path(parse.getPath());
            if (!TextUtils.isEmpty(parse.getQuery())) {
                builder.query(parse.getQuery());
            }
            return URLDecoder.decode(builder.build().toString());
        }
        return str;
    }

    public final void eb(String str) {
        boolean z;
        int i = this.axS;
        if (!this.axT && i > 0) {
            com.kwad.sdk.core.network.idc.a.a aVar = this.axQ.get(str);
            if (aVar != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - aVar.EJ();
                if (elapsedRealtime > Math.max(i, axR)) {
                    z = true;
                } else {
                    z = false;
                }
                c.d("IdcManager", "handleHostRollback: isAvailable = " + z + ",interval = " + elapsedRealtime + ",rollbackInterval = " + i + ",hostType = hostType");
                if (z) {
                    AtomicBoolean atomicBoolean = this.axP.get(str);
                    try {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            try {
                                boolean EI = aVar.EI();
                                c.d("IdcManager", "handleHostRollback: isInRollback = " + EI);
                                if (!EI) {
                                    aVar.bm(true);
                                    if (ec(str)) {
                                        this.axQ.remove(str);
                                        c.d("IdcManager", "handleHostRollback success,remove switched host, type = " + str);
                                    } else {
                                        c.d("IdcManager", "rollbackToMainHost failed, reset attempt time.");
                                        ea(str);
                                    }
                                }
                                atomicBoolean.set(false);
                                c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                                return;
                            } catch (Exception e) {
                                c.e("IdcManager", "handleHostRollback failed by " + e.getMessage());
                                atomicBoolean.set(false);
                                c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        atomicBoolean.set(false);
                        c.d("IdcManager", "handleHostRollback end, release lock.host = " + str);
                        throw th;
                    }
                }
                return;
            }
            return;
        }
        c.d("IdcManager", "performHostRollback is invalid, by in prepare = " + this.axT + ",rollbackInterval = " + i);
    }

    public final String ee(String str) {
        return Y(str, "cdn");
    }

    public final void g(String str, Throwable th) {
        a(str, "cdn", new DomainException(th));
    }

    public final void init(final Context context) {
        this.mContext = context.getApplicationContext();
        this.axT = true;
        g.execute(new az() { // from class: com.kwad.sdk.core.network.idc.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.this.axM.putAll(b.bo(context));
                a.this.EF();
                if (!a.this.axN.isEmpty()) {
                    Iterator<String> it = a.this.axN.EL().iterator();
                    while (it.hasNext()) {
                        a.this.ec(it.next());
                    }
                }
                c.d("IdcManager", "idc prepare done.");
                a.a(a.this, false);
            }
        });
    }

    private a() {
        this.axM = new ConcurrentHashMap(8);
        this.axN = new com.kwad.sdk.core.network.idc.a.b();
        this.axO = new Random(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        this.axP = hashMap;
        this.axQ = new ConcurrentHashMap(4);
        this.axS = 0;
        this.axT = false;
        hashMap.put("api", new AtomicBoolean(false));
        hashMap.put("ulog", new AtomicBoolean(false));
        hashMap.put("zt", new AtomicBoolean(false));
        hashMap.put("cdn", new AtomicBoolean(false));
    }

    @WorkerThread
    private static boolean c(final String str, Context context) {
        boolean isNetworkConnected = ah.isNetworkConnected(context);
        c.d("IdcManager", "connect host = " + str + ",isNetworkConnected = " + isNetworkConnected);
        if (isNetworkConnected && str != null) {
            AdHttpProxy yy = com.kwad.sdk.g.yy();
            d dVar = new d() { // from class: com.kwad.sdk.core.network.idc.a.4
                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseBody() {
                }

                @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
                public final void buildBaseHeader() {
                }

                @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return h.bY(BNWebViewClient.URL_HTTPS_PREFIX + str);
                }
            };
            com.kwad.sdk.core.network.c doGet = yy.doGet(dVar.getUrl(), Collections.emptyMap());
            c.d("IdcManager", "perform connect host:" + dVar.getUrl());
            if (doGet != null) {
                c.d("IdcManager", "connect host response, rawCode = " + doGet.awC + ",body = " + doGet.awE);
                if (doGet.awC == 200) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.axT = false;
        return false;
    }

    public final void a(com.kwad.sdk.core.network.idc.a.b bVar, int i) {
        this.axS = i * 1000;
        c.d("IdcManager", "updateIdcData,rollback interval = " + i);
        if (i == 0) {
            this.axQ.clear();
        }
        this.axN.a(bVar);
        g.execute(new az() { // from class: com.kwad.sdk.core.network.idc.a.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.a(a.this.mContext, a.this.axN);
            }
        });
    }

    public final void a(String str, int i, Throwable th) {
        a(str, "ulog", new DomainException(i, th));
    }

    public final void a(String str, String str2, DomainException domainException) {
        if (str != null && a(domainException)) {
            V(str, str2);
        }
    }

    private static boolean a(DomainException domainException) {
        if (domainException.getHttpCode() >= 500) {
            return true;
        }
        return domainException.isConnectException();
    }
}
