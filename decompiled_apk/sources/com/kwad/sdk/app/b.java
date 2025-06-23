package com.kwad.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.components.n;
import com.kwad.sdk.core.c.c;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.o;
import com.szabh.smable3.entity.BleNotification;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class b {
    private static final Map<String, String> aor = new HashMap();
    private final AtomicBoolean aos;
    private final AtomicBoolean aot;
    private final AtomicBoolean aou;
    private final List<String> aov;
    private final List<String> aow;
    private final BroadcastReceiver aox;
    private Context mContext;
    private final List<com.kwad.sdk.app.a> mListeners;

    /* loaded from: classes11.dex */
    public static class a {
        private static final b aoz = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private void A(Context context, String str) {
        com.kwad.sdk.core.c.b.En();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            B(context, str);
            return;
        }
        this.aov.add(str);
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.3
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.aov.size() > 0) {
                    for (int i = 0; i < b.this.aov.size(); i++) {
                        b.B(b.this.mContext, (String) b.this.aov.get(i));
                    }
                    b.this.aov.clear();
                }
                com.kwad.sdk.core.c.b.En();
                com.kwad.sdk.core.c.b.b((c) this);
            }
        });
    }

    public static b AW() {
        return a.aoz;
    }

    private void AX() {
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.AZ();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.AY();
                    b.this.Ba();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY() {
        Context Lw = ServiceProvider.Lw();
        aU(Lw);
        Iterator<AdTemplate> it = ((f) ServiceProvider.get(f.class)).zb().iterator();
        while (it.hasNext()) {
            AdInfo dS = e.dS(it.next());
            int bz = com.kwad.sdk.core.response.b.a.bz(dS);
            String ax = com.kwad.sdk.core.response.b.a.ax(dS);
            if (bz != 12) {
                if (al.an(Lw, ax)) {
                    z(Lw, ax);
                }
            } else if (!al.an(Lw, ax)) {
                cp(ax);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ() {
        if (!this.aou.get()) {
            return;
        }
        ServiceProvider.Lw().unregisterReceiver(this.aox);
        this.aou.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B(Context context, @NonNull String str) {
        try {
            n nVar = (n) com.kwad.sdk.components.c.f(n.class);
            if (nVar != null && o.LU()) {
                ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(nVar.e(context, str), 1);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        if (this.aou.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.Lw().registerReceiver(this.aox, intentFilter);
        this.aou.set(true);
    }

    private static void C(Context context, String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -973170826:
                if (str.equals("com.tencent.mm")) {
                    c = 0;
                    break;
                }
                break;
            case 473713875:
                if (str.equals("com.kuaishou.nebula")) {
                    c = 1;
                    break;
                }
                break;
            case 1659293491:
                if (str.equals(BleNotification.GIF_MAKER)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                aor.put("com.tencent.mm", k.N(context, "com.tencent.mm"));
                return;
            case 1:
                aor.put("com.kuaishou.nebula", k.N(context, "com.kuaishou.nebula"));
                return;
            case 2:
                aor.put(BleNotification.GIF_MAKER, k.N(context, BleNotification.GIF_MAKER));
                return;
            default:
                return;
        }
    }

    private synchronized void aT(Context context) {
        if (this.aos.get()) {
            return;
        }
        C(context, BleNotification.GIF_MAKER);
        C(context, "com.kuaishou.nebula");
        C(context, "com.tencent.mm");
        this.aos.set(true);
    }

    private void aU(Context context) {
        if (this.aos.get()) {
            for (String str : aor.keySet()) {
                String str2 = aor.get(str);
                String N = k.N(context, str);
                if (!TextUtils.isEmpty(N) && !Objects.equals(str2, N)) {
                    z(context, str);
                } else if (TextUtils.isEmpty(N) && !TextUtils.isEmpty(str2)) {
                    cp(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(@NonNull String str) {
        com.kwad.sdk.core.e.c.d("AppInstallManager", "unInstallApp packageName: " + str);
        cu(str);
        ct(str);
        cq(str);
    }

    private void cq(String str) {
        com.kwad.sdk.core.c.b.En();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            cr(str);
            return;
        }
        this.aow.add(str);
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.aow.size() > 0) {
                    for (int i = 0; i < b.this.aow.size(); i++) {
                        b.cr((String) b.this.aow.get(i));
                    }
                    b.this.aow.clear();
                }
                com.kwad.sdk.core.c.b.En();
                com.kwad.sdk.core.c.b.b((c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cr(@NonNull String str) {
        try {
            n nVar = (n) com.kwad.sdk.components.c.f(n.class);
            if (nVar != null && o.LU()) {
                ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(nVar.x(str), 2);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    private void cs(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().O(str);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    private void ct(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().P(str);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    private static void cu(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -973170826:
                if (str.equals("com.tencent.mm")) {
                    c = 0;
                    break;
                }
                break;
            case 473713875:
                if (str.equals("com.kuaishou.nebula")) {
                    c = 1;
                    break;
                }
                break;
            case 1659293491:
                if (str.equals(BleNotification.GIF_MAKER)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                aor.put("com.tencent.mm", "");
                return;
            case 1:
                aor.put("com.kuaishou.nebula", "");
                return;
            case 2:
                aor.put(BleNotification.GIF_MAKER, "");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, @NonNull String str) {
        com.kwad.sdk.core.e.c.d("AppInstallManager", "installApp packageName: " + str);
        C(context, str);
        cs(str);
        A(context, str);
    }

    public final synchronized void checkInit() {
        try {
            if (this.aot.get()) {
                return;
            }
            if (((h) ServiceProvider.get(h.class)).zD()) {
                com.kwad.sdk.core.c.b.En();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    Ba();
                }
                AX();
            } else {
                Ba();
            }
            this.aot.set(true);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        aT(context);
        return aor.get(str);
    }

    private b() {
        this.aos = new AtomicBoolean();
        this.aot = new AtomicBoolean();
        this.aou = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.aov = new CopyOnWriteArrayList();
        this.aow = new CopyOnWriteArrayList();
        this.aox = new BroadcastReceiver() { // from class: com.kwad.sdk.app.b.2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart)) {
                        b.this.mContext = context;
                        if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                            b.this.z(context, schemeSpecificPart);
                        } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                            b.this.cp(schemeSpecificPart);
                        }
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        };
    }

    public final void b(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.remove(aVar);
    }

    public final void a(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.add(aVar);
    }
}
