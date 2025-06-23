package com.baidu.navisdk.asr;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.navisdk.asr.i.c;
import com.baidu.navisdk.asr.i.g;
import com.baidu.navisdk.asr.i.h;
import com.baidu.navisdk.asr.i.i;
import com.baidu.navisdk.framework.interfaces.asr.a;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.e;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class d implements com.baidu.navisdk.asr.i.e {
    private static final String[] s = {"前方堵不堵", "不走南京路", "走京藏高速", "顺路加个油", "附近的取款机", "顺路加个油", "导航去百度大厦", "今日限号是多少", "下个路口怎么走", "还要多久到", "查看全览", "播报大点声"};
    private static d t;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.asr.i.d f6542a;
    private h b;
    private c.b c;
    private com.baidu.navisdk.asr.i.f d;
    private g e;
    private i f;
    private boolean g;
    private boolean h;
    private com.baidu.navisdk.framework.interfaces.asr.a j;
    private com.baidu.navisdk.asr.i.a k;
    private com.baidu.navisdk.asr.i.b l;
    private boolean m;
    private String n;
    private String o;
    private final com.baidu.navisdk.asr.b q;
    private final a.InterfaceC0201a r;
    private HashMap<String, com.baidu.navisdk.asr.a> i = new HashMap<>();
    private boolean p = false;

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0201a {
        public a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof com.baidu.navisdk.framework.message.bean.e) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
                if (gVar.d()) {
                    gVar.e("XDVoice", "onEvent(), event = " + ((com.baidu.navisdk.framework.message.bean.e) obj).b);
                }
                e.a aVar = ((com.baidu.navisdk.framework.message.bean.e) obj).b;
                if (aVar == e.a.START) {
                    d.this.h = true;
                } else if (aVar == e.a.FINISH || aVar == e.a.CANCEL) {
                    d.this.h = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.framework.interfaces.asr.a f6544a;

        public b(com.baidu.navisdk.framework.interfaces.asr.a aVar) {
            this.f6544a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c(this.f6544a);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.framework.interfaces.asr.a f6545a;

        public c(com.baidu.navisdk.framework.interfaces.asr.a aVar) {
            this.f6545a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f6542a != null) {
                d.this.f6542a.a(this.f6545a);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.asr.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0168d implements Runnable {
        public RunnableC0168d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.b != null) {
                d.this.b.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6547a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, String str3) {
            super(str, str2);
            this.f6547a = str3;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.this.a(true, this.f6547a);
            return null;
        }
    }

    public d() {
        a aVar = new a();
        this.r = aVar;
        com.baidu.navisdk.asr.b bVar = new com.baidu.navisdk.asr.b();
        this.q = bVar;
        bVar.a();
        com.baidu.navisdk.framework.message.a.a().a(aVar, com.baidu.navisdk.framework.message.bean.e.class, new Class[0]);
    }

    public static d B() {
        if (t == null) {
            synchronized (d.class) {
                try {
                    if (t == null) {
                        t = new d();
                    }
                } finally {
                }
            }
        }
        return t;
    }

    private String C() {
        Random random = new Random();
        String[] strArr = s;
        int nextInt = random.nextInt(strArr.length);
        if (nextInt >= 0 && nextInt < strArr.length) {
            return strArr[nextInt];
        }
        return strArr[0];
    }

    public void A() {
        com.baidu.navisdk.util.common.g.ASR.g("XDVoice", "wakeUpByClick()");
        this.m = true;
        com.baidu.navisdk.asr.c.c();
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.d(false);
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.a();
        }
        z();
    }

    public void c(boolean z) {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    @Override // com.baidu.navisdk.asr.i.e
    public boolean d() {
        return this.m;
    }

    public void e() {
        this.n = null;
        this.o = null;
    }

    public void f() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.b();
        }
    }

    public String g() {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public com.baidu.navisdk.asr.i.a h() {
        return this.k;
    }

    public com.baidu.navisdk.asr.i.b i() {
        return this.l;
    }

    public HashMap<String, com.baidu.navisdk.asr.a> j() {
        return this.i;
    }

    public com.baidu.navisdk.framework.interfaces.asr.a k() {
        return this.j;
    }

    public String l() {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public c.b m() {
        return this.c;
    }

    public boolean n() {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            return dVar.b();
        }
        return false;
    }

    public boolean o() {
        return this.d.a();
    }

    public boolean p() {
        return this.p;
    }

    public boolean q() {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            return dVar.a();
        }
        return false;
    }

    public boolean r() {
        return this.g;
    }

    public boolean s() {
        return this.h;
    }

    public boolean t() {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            return dVar.f();
        }
        return false;
    }

    public void u() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.d()) {
            gVar.g("XDVoice", "onStop");
        }
        if (!this.g) {
            return;
        }
        this.g = false;
        this.m = false;
        this.j = null;
        g gVar2 = this.e;
        if (gVar2 != null) {
            gVar2.onStop();
        }
        com.baidu.navisdk.asr.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        com.baidu.navisdk.asr.i.b bVar = this.l;
        if (bVar != null) {
            bVar.c();
        }
        this.k = null;
        this.l = null;
        com.baidu.navisdk.asr.i.f fVar = this.d;
        if (fVar != null) {
            fVar.onStop();
        }
    }

    public void v() {
        this.k = null;
        this.l = null;
    }

    public void w() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.e();
        }
    }

    public void x() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void y() {
        h hVar = this.b;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void z() {
        String str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        gVar.g("XDVoice", "wakeUp()");
        if (this.f6542a == null) {
            return;
        }
        com.baidu.navisdk.asr.i.f fVar = this.d;
        if (fVar != null) {
            fVar.a(this.m ? 1 : 0);
        }
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            str = dVar.e();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            gVar.e("XDVoice", "getTipsString is null, use previous tips");
            str = C();
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            a(true, str);
            return;
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new e("wakeUp" + d.class.getSimpleName(), null, str), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    private void d(com.baidu.navisdk.asr.model.a aVar) {
        com.baidu.navisdk.asr.sceneguide.a a2 = com.baidu.navisdk.asr.sceneguide.c.a().a(aVar.z0);
        if (a2 != null) {
            com.baidu.navisdk.asr.model.a b2 = a2.b();
            com.baidu.navisdk.asr.a aVar2 = this.i.get(b2.D);
            if (aVar2 != null) {
                if (TextUtils.equals(aVar.T, "yes")) {
                    String str = a2.i;
                    com.baidu.navisdk.framework.interfaces.asr.a a3 = aVar2.a(b2);
                    if (a3 != null && !a3.g) {
                        a(com.baidu.navisdk.asr.e.a(str, true));
                        return;
                    } else {
                        this.n = a2.i;
                        this.o = a2.g;
                        return;
                    }
                }
                if (TextUtils.equals(aVar.T, "no")) {
                    a(com.baidu.navisdk.asr.e.a(a2.k, true));
                    return;
                }
                return;
            }
            b();
            return;
        }
        b();
    }

    public void b(boolean z) {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    private void c(String str) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(str);
        }
    }

    public void b(com.baidu.navisdk.framework.interfaces.asr.a aVar) {
        f.a(new c(aVar));
    }

    public void a(String str, com.baidu.navisdk.asr.a aVar) {
        this.i.put(str, aVar);
    }

    @Override // com.baidu.navisdk.asr.i.e
    public void b() {
        c();
        u();
    }

    @Override // com.baidu.navisdk.asr.i.e
    public void c() {
        f.d();
        f.a(new RunnableC0168d());
    }

    public void a() {
        this.i.clear();
    }

    private void c(com.baidu.navisdk.asr.model.a aVar) {
        int i;
        if (TextUtils.equals("yes", aVar.T)) {
            com.baidu.navisdk.asr.i.a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.a(aVar.k0, true);
                return;
            }
            com.baidu.navisdk.asr.i.b bVar = this.l;
            if (bVar != null && (i = aVar.E0) != -1) {
                bVar.a(aVar.k0, i);
                return;
            } else {
                a(f.a("小度没明白，下次说前方堵不堵"));
                return;
            }
        }
        if (TextUtils.equals("no", aVar.T)) {
            com.baidu.navisdk.asr.i.a aVar3 = this.k;
            if (aVar3 != null) {
                aVar3.a(aVar.k0, false);
                return;
            }
            com.baidu.navisdk.asr.i.b bVar2 = this.l;
            if (bVar2 != null) {
                bVar2.a();
                return;
            } else {
                a(f.a("小度没明白，下次说前方怎么走"));
                return;
            }
        }
        b();
    }

    public void a(com.baidu.navisdk.asr.i.f fVar) {
        this.d = fVar;
    }

    public void b(String str) {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void a(g gVar) {
        this.e = gVar;
    }

    public void a(i iVar) {
        this.f = iVar;
    }

    public void b(com.baidu.navisdk.asr.model.a aVar) {
        if (aVar == null) {
            return;
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(aVar);
        }
        com.baidu.navisdk.asr.i.f fVar = this.d;
        if (fVar != null) {
            fVar.a(aVar.C0.a());
        }
    }

    @Override // com.baidu.navisdk.asr.i.e
    public void a(com.baidu.navisdk.framework.interfaces.asr.a aVar) {
        com.baidu.navisdk.asr.i.f fVar;
        if (aVar != null && aVar.h && (fVar = this.d) != null) {
            fVar.c();
        }
        com.baidu.navisdk.asr.i.f fVar2 = this.d;
        if (fVar2 != null) {
            fVar2.a(aVar);
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(aVar);
        }
        e();
        com.baidu.navisdk.asr.c.c();
        f.a(new b(aVar));
    }

    public void a(String str) {
        com.baidu.navisdk.framework.interfaces.asr.a a2 = f.a(str);
        if (a2 != null) {
            a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.navisdk.framework.interfaces.asr.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        gVar.g("XDVoice", "BNAsrResponse = " + aVar);
        com.baidu.navisdk.asr.i.f fVar = this.d;
        if (fVar != null && !fVar.a()) {
            gVar.g("XDVoice", " xd can not work");
            com.baidu.navisdk.asr.c.a(aVar.d);
            return;
        }
        this.j = aVar;
        if (this.f6542a != null) {
            a(false, (String) null);
            b(this.j);
        }
    }

    public void a(com.baidu.navisdk.asr.i.c cVar) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(cVar);
        }
    }

    @Override // com.baidu.navisdk.asr.i.e
    public void a(String str, String str2, com.baidu.navisdk.asr.i.a aVar) {
        a(str, str2, aVar, true);
    }

    @Override // com.baidu.navisdk.asr.i.e
    public void a(String str, String str2, com.baidu.navisdk.asr.i.b bVar) {
        a(str, str2, bVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        com.baidu.navisdk.asr.i.f fVar;
        com.baidu.navisdk.util.common.g.ASR.g("XDVoice", "onStart() , isFirstRound is " + z);
        if (this.g) {
            if (z) {
                c(str);
                return;
            }
            return;
        }
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.c(true);
        }
        com.baidu.navisdk.asr.i.f fVar2 = this.d;
        if (fVar2 != null) {
            fVar2.d();
        }
        this.g = true;
        com.baidu.navisdk.asr.i.f fVar3 = this.d;
        boolean a2 = fVar3 != null ? fVar3.a() : true;
        com.baidu.navisdk.asr.i.f fVar4 = this.d;
        if (fVar4 != null) {
            fVar4.a(z, a2);
        }
        if (z || (fVar = this.d) == null || fVar.b()) {
            c(str);
        }
    }

    public void a(com.baidu.navisdk.asr.model.a aVar) {
        if (aVar == null) {
            return;
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(aVar);
        }
        String str = aVar.D;
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(aVar.z0) && !TextUtils.isEmpty(aVar.T)) {
                d(aVar);
                return;
            } else {
                if (TextUtils.isEmpty(aVar.T)) {
                    return;
                }
                c(aVar);
                return;
            }
        }
        if (a(str, aVar)) {
            return;
        }
        com.baidu.navisdk.asr.a aVar2 = this.i.get(str);
        if (aVar2 != null) {
            com.baidu.navisdk.asr.i.f fVar = this.d;
            if (fVar != null) {
                fVar.b(str);
            }
            com.baidu.navisdk.framework.interfaces.asr.a a2 = aVar2.a(aVar);
            if (a2 == null || a2.g) {
                return;
            }
            a(a2);
            return;
        }
        a(f.a("小度暂不支持该指令"));
    }

    public String a(boolean z) {
        return z ? this.n : this.o;
    }

    private boolean a(String str, com.baidu.navisdk.asr.model.a aVar) {
        if (TextUtils.equals(str, "sel_via_node")) {
            com.baidu.navisdk.asr.i.b bVar = this.l;
            if (bVar != null) {
                bVar.a(aVar.k0, aVar.W);
            } else {
                b();
            }
            return true;
        }
        if (!TextUtils.equals(str, "list_search") && !TextUtils.equals(str, "lbs_search")) {
            if (!TextUtils.equals(str, "list_search_general")) {
                return false;
            }
            com.baidu.navisdk.asr.i.b bVar2 = this.l;
            if (bVar2 != null) {
                bVar2.a(aVar.k0, aVar.W);
            } else {
                b();
            }
            return true;
        }
        com.baidu.navisdk.asr.i.b bVar3 = this.l;
        if (bVar3 != null) {
            bVar3.a(aVar.k0, aVar.f6553o0 - 1);
        } else {
            b();
        }
        return true;
    }

    public void a(String str, String str2, com.baidu.navisdk.asr.i.a aVar, boolean z) {
        if (!z && com.baidu.navisdk.asr.c.a()) {
            Log.d("XDVoice", "confirm || voice mode is quite, and return");
            return;
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(str, str2, aVar, z);
        }
        i iVar = this.f;
        a(new a.C0199a().c(true).e(true).a(str).b(iVar != null ? iVar.a(str2) : null).a());
        this.k = aVar;
    }

    public void a(String str, JSONArray jSONArray, String str2, com.baidu.navisdk.asr.i.b bVar, boolean z) {
        i iVar = this.f;
        a(str, iVar != null ? iVar.a(str2, jSONArray) : null, bVar, z);
    }

    public void a(String str, String str2, com.baidu.navisdk.asr.i.b bVar, boolean z) {
        if (!z && com.baidu.navisdk.asr.c.a()) {
            Log.d("XDVoice", "select || voice mode is quite, and return");
            return;
        }
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(str, str2, bVar, z);
        }
        a(new a.C0199a().c(true).e(true).a(str).b(str2).a());
        this.l = bVar;
    }

    public void a(HashMap<String, String> hashMap) {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.a(hashMap);
        }
    }

    public void a(String str, Bundle bundle) {
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.a(str, bundle);
        }
    }

    public void a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.e()) {
            gVar.g("XDVoice", "closeVoiceAudioPanel(), status = " + i);
        }
        com.baidu.navisdk.asr.i.d dVar = this.f6542a;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    public void a(com.baidu.navisdk.asr.i.a aVar) {
        this.k = aVar;
    }
}
