package com.baidu.navisdk.apicenter;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.d0;
import java.util.concurrent.ConcurrentHashMap;
import o0oIxXOx.IXxxXO;

/* loaded from: classes7.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f6533a;
    private d b;

    /* loaded from: classes7.dex */
    public class a extends e {
        final /* synthetic */ c b;
        final /* synthetic */ com.baidu.navisdk.apicenter.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, String str, c cVar, com.baidu.navisdk.apicenter.a aVar) {
            super(str);
            this.b = cVar;
            this.c = aVar;
        }

        @Override // com.baidu.navisdk.apicenter.e
        public h a() {
            h a2 = this.b.a(this.c);
            this.c.b();
            return a2;
        }
    }

    public b() {
        this(null);
    }

    private String b(com.baidu.navisdk.apicenter.a aVar) {
        Object c;
        if (aVar == null) {
            return "ApiCenter";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ApiCenter::");
        if (aVar.c() == null) {
            c = Integer.valueOf(aVar.d());
        } else {
            c = aVar.c();
        }
        sb.append(c);
        sb.append(IXxxXO.f31153oxoX);
        sb.append(aVar.d());
        return sb.toString();
    }

    private c c(com.baidu.navisdk.apicenter.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.f6533a.isEmpty()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("ApiCenter", "getApiExecutor --> mApiExecutorMap is empty!");
            }
            return null;
        }
        if (aVar.c() == null) {
            if (LogUtil.LOGGABLE) {
                d0.a(aVar.c(), "target could not be null, api = " + aVar);
            }
            return null;
        }
        return this.f6533a.get(aVar.c());
    }

    @Override // com.baidu.navisdk.apicenter.g
    public void a(String str, c cVar) {
        if (str == null || cVar == null) {
            return;
        }
        this.f6533a.put(str, cVar);
    }

    @Override // com.baidu.navisdk.apicenter.g
    public void clear() {
        this.f6533a.clear();
    }

    public b(d dVar) {
        this.f6533a = new ConcurrentHashMap<>();
        this.b = dVar;
        if (dVar == null) {
            this.b = new f();
        }
    }

    @Override // com.baidu.navisdk.apicenter.g
    public void a(String str) {
        if (str == null) {
            return;
        }
        this.f6533a.remove(str);
    }

    @Override // com.baidu.navisdk.apicenter.g
    public h a(com.baidu.navisdk.apicenter.a aVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ApiCenter", "call --> api = " + aVar);
        }
        if (aVar != null) {
            aVar.i = this;
        }
        c c = c(aVar);
        if (aVar != null && c != null) {
            return this.b.a(new a(this, b(aVar), c, aVar));
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("call --> mApiExecutorMap is not contains this module ");
            sb.append(aVar == null ? "null" : aVar.c());
            LogUtil.e("ApiCenter", sb.toString());
        }
        if (aVar == null) {
            return null;
        }
        aVar.b();
        return null;
    }
}
