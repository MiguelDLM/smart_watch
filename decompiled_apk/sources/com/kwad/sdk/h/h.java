package com.kwad.sdk.h;

import XIXIX.OOXIXo;
import android.text.TextUtils;
import com.kwad.sdk.h.e;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class h {
    private static final float aoT = new Random().nextFloat();
    private final AtomicBoolean Kc;
    private final AtomicBoolean aKu;
    private d aKv;
    private g aKw;
    private List<i> aKx;
    private f aKy;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final h aKB = new h(0);
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h JN() {
        return a.aKB;
    }

    private void JU() {
        List<i> list = this.aKx;
        if (list == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.aKx.clear();
        this.aKx = null;
    }

    private void b(final i iVar) {
        d dVar = this.aKv;
        if (dVar == null || j.I(dVar.aKh) || this.aKw == null || this.aKy == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.h.h.1
            @Override // com.kwad.sdk.h.n
            public final void doTask() {
                boolean z;
                h hVar = h.this;
                e a2 = hVar.a(hVar.aKv, iVar);
                if (a2 == null) {
                    return;
                }
                iVar.n(a2.apu);
                i iVar2 = iVar;
                if (a2.aKi == 2) {
                    z = true;
                } else {
                    z = false;
                }
                m.a(iVar2, z);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.aGn;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aKw.getSdkVersion(), it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(e.b bVar) {
        String androidId = this.aKw.getAndroidId();
        String deviceId = this.aKw.getDeviceId();
        String imei = this.aKw.getImei();
        String oaid = this.aKw.getOaid();
        List<String> list = bVar.aKq;
        if (j.I(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(str, androidId) || TextUtils.equals(str, deviceId) || TextUtils.equals(str, imei) || TextUtils.equals(str, oaid)) {
                return true;
            }
        }
        return false;
    }

    private static d gh(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                d dVar = new d();
                dVar.parseJson(jSONObject);
                return dVar;
            }
            return null;
        } catch (Throwable unused) {
            j.JX();
            return null;
        }
    }

    public final void JO() {
        if (this.Kc.get() && this.aKv != null) {
            j.JY();
            m.Ka();
        }
    }

    public final synchronized void JP() {
        this.aKu.set(true);
    }

    public final synchronized void JQ() {
        this.aKu.set(false);
    }

    public final g JR() {
        return this.aKw;
    }

    public final f JS() {
        return this.aKy;
    }

    public final long JT() {
        return this.aKv.JG();
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aKu.get()) {
                    j.JY();
                    return;
                }
                i gk = i.JW().gi(str).gj(str2).gk(str3);
                if (this.Kc.get()) {
                    b(gk);
                } else {
                    j.JY();
                    a(gk);
                }
            }
        } catch (Throwable unused) {
            j.JX();
        }
    }

    private h() {
        this.Kc = new AtomicBoolean(false);
        this.aKu = new AtomicBoolean(false);
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.aGm;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.aKw.getAppId(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.Kc.get()) {
            return;
        }
        try {
            j.JY();
            this.aKw = gVar;
            this.aKy = fVar;
            this.aKv = gh(str);
            this.Kc.set(true);
            JU();
        } catch (Throwable unused) {
            j.JX();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.aKn;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.aKm;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private void a(i iVar) {
        if (this.aKx == null) {
            this.aKx = new CopyOnWriteArrayList();
        }
        this.aKx.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.aKh;
        if (j.I(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.aKj) && a(eVar.aKk, iVar)) {
                double d = eVar.apu;
                if (d > OOXIXo.f3760XO && aoT <= d) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.aKr != e.b.aKo) {
            return bVar.JH();
        }
        bVar.bD(b(bVar) && c(bVar) && d(bVar));
        return bVar.JH();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.aKC) && b(aVar, iVar.aKD) && c(aVar, iVar.aKE);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.aKl;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }
}
