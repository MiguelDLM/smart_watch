package com.baidu.navisdk;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class l {
    private static l c;

    /* renamed from: a, reason: collision with root package name */
    private Map<m, List<p>> f6862a = new HashMap();
    private com.baidu.navisdk.util.worker.loop.d b = new a();

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.d {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4497);
        }

        @Override // com.baidu.navisdk.util.worker.loop.d
        public void onMessage(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.DYNA_DATA;
            if (gVar.d()) {
                gVar.e("DynamicData", "onMessage(), msg = " + message + "arg1 =" + message.arg1);
            }
            if (message.what == 4497) {
                m a2 = m.a(message.arg1);
                List<p> list = (List) l.this.f6862a.get(a2);
                if (list != null) {
                    for (p pVar : list) {
                        if (pVar != null) {
                            pVar.a();
                        }
                    }
                }
                l.this.f6862a.put(a2, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f6864a;
        final /* synthetic */ m b;

        /* loaded from: classes7.dex */
        public class a implements p {
            public a() {
            }

            @Override // com.baidu.navisdk.p
            public void a() {
                b bVar = b.this;
                l.this.a(bVar.b, bVar.f6864a);
            }
        }

        public b(n nVar, m mVar) {
            this.f6864a = nVar;
            this.b = mVar;
        }

        @Override // com.baidu.navisdk.n
        public void a(boolean z, String str) {
            if (z) {
                this.f6864a.a(z, str);
                l.this.a(this.b);
            } else {
                l.this.a(this.b, new a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f6866a;
        final /* synthetic */ n b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, m mVar, n nVar) {
            super(str);
            this.f6866a = mVar;
            this.b = nVar;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            l.this.c(this.f6866a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f6867a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l lVar, String str, n nVar, boolean z, String str2) {
            super(str);
            this.f6867a = nVar;
            this.b = z;
            this.c = str2;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            n nVar = this.f6867a;
            if (nVar != null) {
                nVar.a(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements com.baidu.navisdk.framework.interfaces.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f6868a;
        final /* synthetic */ p b;

        public e(m mVar, p pVar) {
            this.f6868a = mVar;
            this.b = pVar;
        }

        @Override // com.baidu.navisdk.framework.interfaces.b
        public void initFailed(int i) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.b
        public void initStart() {
        }

        @Override // com.baidu.navisdk.framework.interfaces.b
        public void initSuccess(boolean z) {
            l.this.b(this.f6868a, this.b);
        }
    }

    private l() {
        b();
    }

    private void b() {
        com.baidu.navisdk.vi.b.a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar, n nVar) {
        String b2 = b(mVar);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.DYNA_DATA;
        if (gVar.d()) {
            gVar.e("DynamicData", "readInner(), id = " + mVar + " callback = " + nVar + " path = " + b2);
        }
        if (!TextUtils.isEmpty(b2) && new File(b2).exists()) {
            a(nVar, true, com.baidu.navisdk.util.common.s.e(b2));
        } else {
            a(nVar, false, (String) null);
        }
    }

    public void b(m mVar, n nVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.DYNA_DATA;
        if (gVar.d()) {
            gVar.e("DynamicData", "readAndUpdate(), id = " + mVar + " callback = " + nVar);
        }
        a(mVar, new b(nVar, mVar));
    }

    public static l a() {
        if (c == null) {
            synchronized (l.class) {
                c = new l();
            }
        }
        return c;
    }

    private String b(m mVar) {
        if (com.baidu.navisdk.module.init.a.a()) {
            String cloudFilePath = JNINaviManager.sInstance.getCloudDataInterface().getCloudFilePath(mVar.a());
            o.a(mVar, cloudFilePath);
            return cloudFilePath;
        }
        return o.a(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar, p pVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.DYNA_DATA;
        if (gVar.d()) {
            gVar.e("DynamicData", "updateInner(), id = " + mVar + " callback = " + pVar);
        }
        JNINaviManager.sInstance.getCloudDataInterface().updateCloudConfig(mVar.a());
        if (pVar != null) {
            if (this.f6862a.get(mVar) != null) {
                this.f6862a.get(mVar).add(pVar);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(pVar);
            this.f6862a.put(mVar, arrayList);
        }
    }

    public void a(m mVar, n nVar) {
        com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new c("DDataread", mVar, nVar), 10001);
    }

    private void a(n nVar, boolean z, String str) {
        com.baidu.navisdk.util.worker.lite.a.c(new d(this, "DDatareadInner", nVar, z, str));
    }

    public void a(m mVar) {
        a(mVar, (p) null);
    }

    public void a(m mVar, p pVar) {
        if (com.baidu.navisdk.module.init.a.a()) {
            b(mVar, pVar);
        } else {
            com.baidu.navisdk.framework.b.a(com.baidu.navisdk.framework.a.c().a(), new e(mVar, pVar));
        }
    }
}
