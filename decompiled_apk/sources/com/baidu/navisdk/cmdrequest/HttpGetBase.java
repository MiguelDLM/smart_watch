package com.baidu.navisdk.cmdrequest;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.framework.message.bean.n;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.l;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes7.dex */
public abstract class HttpGetBase extends com.baidu.navisdk.cmdrequest.a {
    protected JSONObject c;

    public HttpGetBase() {
        new ArrayList();
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public f a() {
        if (!y.d(com.baidu.navisdk.framework.a.c().a())) {
            this.f6680a.a(h.b(1));
            return this.f6680a;
        }
        LogUtil.e("HttpGetBase", "exec() url=" + e());
        n nVar = new n();
        try {
            nVar.b = System.currentTimeMillis();
            nVar.e = e();
            nVar.c = r0.getBytes(StandardCharsets.UTF_8).length * 8;
        } catch (Exception unused) {
        }
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = false;
        com.baidu.navisdk.util.http.center.b.a().a(e(), com.baidu.navisdk.util.http.center.c.a(d()), new a(nVar), eVar);
        if (!this.f6680a.a()) {
            return this.f6680a;
        }
        com.baidu.navisdk.framework.message.a.a().d(nVar);
        f();
        if (this.f6680a.a()) {
            c();
        } else {
            b();
        }
        return this.f6680a;
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void c() {
        i iVar = this.b;
        if (!iVar.f && iVar.i == 1) {
            Message obtainMessage = iVar.e.obtainMessage(iVar.g);
            obtainMessage.arg1 = 0;
            obtainMessage.obj = new j(this.b, this.c);
            obtainMessage.sendToTarget();
            this.b.f = true;
        }
    }

    public abstract List<l> d();

    public abstract String e();

    public void f() {
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f6677a;

        public a(n nVar) {
            this.f6677a = nVar;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            LogUtil.e("HttpGetBase", "exec.ok statusCode=" + i + ", s=" + str);
            if (TextUtils.isEmpty(str)) {
                HttpGetBase.this.f6680a.a(h.a(4));
                return;
            }
            try {
                this.f6677a.d = str.getBytes(StandardCharsets.UTF_8).length * 8;
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                HttpGetBase httpGetBase = HttpGetBase.this;
                httpGetBase.c = jSONObject;
                httpGetBase.f6680a.c();
            } catch (JSONException unused2) {
                HttpGetBase.this.f6680a.a(h.a(3));
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("HttpGetBase", "exec.err statusCode=" + i + ", s=" + str);
            HttpGetBase.this.f6680a.a(h.a(5));
        }
    }
}
