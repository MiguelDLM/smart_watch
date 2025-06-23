package com.baidu.navisdk.cmdrequest.commandparser;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.cmdrequest.HttpGetBase;
import com.baidu.navisdk.cmdrequest.f;
import com.baidu.navisdk.cmdrequest.h;
import com.baidu.navisdk.cmdrequest.i;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.c;
import com.baidu.navisdk.util.http.center.e;
import com.baidu.navisdk.util.http.center.l;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class CmdGeneralHttpRequestFunc extends HttpGetBase {
    public static final String f = "CmdGeneralHttpRequestFunc";
    private static final HashMap<i, b> g = new HashMap<>();
    private b d = null;
    byte[] e = null;

    /* loaded from: classes7.dex */
    public interface b {
        void a(byte[] bArr);

        List<l> getRequestParams();

        int getRequestType();

        String getUrl();

        boolean parseResponseJSON(JSONObject jSONObject);
    }

    private f g() {
        b bVar;
        if (!y.d(com.baidu.navisdk.framework.a.c().a())) {
            this.f6680a.a(h.b(1));
            return this.f6680a;
        }
        LogUtil.e(f, "exec() url=" + e());
        e eVar = new e();
        eVar.f9300a = false;
        com.baidu.navisdk.util.http.center.b.a().a(e(), c.a(d()), new a(), eVar);
        if (!this.f6680a.a()) {
            return this.f6680a;
        }
        byte[] bArr = this.e;
        if (bArr != null && (bVar = this.d) != null) {
            bVar.a(bArr);
        }
        if (this.f6680a.a()) {
            c();
        } else {
            b();
        }
        return this.f6680a;
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpGetBase
    public List<l> d() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.getRequestParams();
        }
        return null;
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpGetBase
    public String e() {
        b bVar = this.d;
        if (bVar != null) {
            return bVar.getUrl();
        }
        return null;
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpGetBase
    public void f() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.parseResponseJSON(this.c);
        }
    }

    public static void a(i iVar, b bVar) {
        g.put(iVar, bVar);
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void b(i iVar) {
        this.d = g.remove(iVar);
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpGetBase, com.baidu.navisdk.cmdrequest.a
    public void c() {
        if (this.b.f) {
            return;
        }
        String str = f;
        LogUtil.e(str, "exec() handleSuccess");
        i iVar = this.b;
        Handler handler = iVar.e;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(iVar.g);
            obtainMessage.arg1 = 0;
            obtainMessage.obj = new j(this.b, this.c);
            obtainMessage.sendToTarget();
            this.b.f = true;
            return;
        }
        LogUtil.e(str, "exec() handleSuccess -> mReqData.mHandler = null");
    }

    @Override // com.baidu.navisdk.cmdrequest.HttpGetBase, com.baidu.navisdk.cmdrequest.a
    public f a() {
        b bVar = this.d;
        if (bVar != null && bVar.getRequestType() != 1) {
            if (2 == this.d.getRequestType()) {
                return g();
            }
            return null;
        }
        return super.a();
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void b() {
        i iVar = this.b;
        if (iVar.f) {
            return;
        }
        Message obtainMessage = iVar.e.obtainMessage(iVar.g);
        obtainMessage.arg1 = this.f6680a.f6693a;
        obtainMessage.obj = new j(this.b, this.c);
        obtainMessage.sendToTarget();
        this.b.f = true;
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.a {
        public a() {
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr) {
            LogUtil.e(CmdGeneralHttpRequestFunc.f, "exec.ok statusCode=" + i);
            if (bArr == null) {
                ((com.baidu.navisdk.cmdrequest.a) CmdGeneralHttpRequestFunc.this).f6680a.a(h.a(4));
                return;
            }
            CmdGeneralHttpRequestFunc cmdGeneralHttpRequestFunc = CmdGeneralHttpRequestFunc.this;
            cmdGeneralHttpRequestFunc.e = bArr;
            ((com.baidu.navisdk.cmdrequest.a) cmdGeneralHttpRequestFunc).f6680a.c();
        }

        @Override // com.baidu.navisdk.util.http.center.a
        public void a(int i, byte[] bArr, Throwable th) {
            LogUtil.e(CmdGeneralHttpRequestFunc.f, "exec.err statusCode=" + i);
            ((com.baidu.navisdk.cmdrequest.a) CmdGeneralHttpRequestFunc.this).f6680a.a(h.a(5));
        }
    }
}
