package com.baidu.navisdk.cmdrequest;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.l;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes7.dex */
public abstract class HttpPostBase extends com.baidu.navisdk.cmdrequest.a {
    protected JSONObject c;

    @Override // com.baidu.navisdk.cmdrequest.a
    public f a() {
        if (!y.d(com.baidu.navisdk.framework.a.c().a())) {
            this.f6680a.a(h.b(1));
            return this.f6680a;
        }
        LogUtil.e("HttpCommandBase", "exec() url=" + e());
        com.baidu.navisdk.util.http.center.e eVar = new com.baidu.navisdk.util.http.center.e();
        eVar.f9300a = false;
        com.baidu.navisdk.util.http.center.b.a().b(e(), com.baidu.navisdk.util.http.center.c.a(d()), new a(), eVar);
        if (!this.f6680a.a()) {
            return this.f6680a;
        }
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
        public a() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            LogUtil.e("HttpCommandBase", "exec.ok statusCode=" + i + ", s=" + str);
            if (TextUtils.isEmpty(str)) {
                HttpPostBase.this.f6680a.a(h.a(4));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                HttpPostBase httpPostBase = HttpPostBase.this;
                httpPostBase.c = jSONObject;
                httpPostBase.f6680a.c();
            } catch (JSONException unused) {
                HttpPostBase.this.f6680a.a(h.a(3));
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            LogUtil.e("HttpCommandBase", "exec.err statusCode=" + i + ", s=" + str);
            HttpPostBase.this.f6680a.a(h.a(5));
        }
    }
}
