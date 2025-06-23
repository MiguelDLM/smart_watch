package com.baidu.navisdk.ugc.eventdetails.control;

import android.os.Handler;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.p0;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.http.center.i;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes8.dex */
public class f implements p0.b {

    /* renamed from: a, reason: collision with root package name */
    private Handler f8065a;
    private String b;
    private String c;
    private String d;
    private p0 e;
    private boolean f = false;
    private boolean g;

    /* loaded from: classes8.dex */
    public class a extends c {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.c
        public void a() throws UnsupportedEncodingException {
            this.b.add(new i("event_id", f.this.c));
            this.f8061a.append("event_id=");
            this.f8061a.append(URLEncoder.encode(f.this.c, "utf-8"));
            this.b.add(new i("comment_id", f.this.d));
            this.f8061a.append("comment_id=");
            this.f8061a.append(URLEncoder.encode(f.this.d, "utf-8"));
            this.b.add(new i("detail_id", f.this.b));
            this.f8061a.append("&detail_id=");
            this.f8061a.append(URLEncoder.encode(f.this.b, "utf-8"));
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("getNewCommentNum");
        }
    }

    public f(Handler handler, long j, long j2, String str) {
        this.g = false;
        this.f8065a = handler;
        this.b = "" + j;
        this.c = "" + j2;
        this.d = str;
        this.g = false;
    }

    private void d() {
        if (this.f8065a == null) {
            return;
        }
        if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcNewCommentNumControl", "asyncGetNewCommentNum network not work ");
                return;
            }
            return;
        }
        new a().a(this.f8065a, 6);
    }

    @Override // com.baidu.navisdk.util.common.p0.b
    public void onTick(int i) {
        if (!this.g) {
            d();
        }
    }

    public void a(String str) {
        this.d = str;
    }

    public void b() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.e == null) {
            p0 p0Var = new p0();
            this.e = p0Var;
            p0Var.a(5000L);
            this.e.a(this);
        }
        this.e.a(Integer.MAX_VALUE);
    }

    public void c() {
        if (this.f) {
            p0 p0Var = this.e;
            if (p0Var != null) {
                p0Var.a();
            }
            this.f = false;
        }
    }

    public void a() {
        this.g = true;
        this.f = false;
        Handler handler = this.f8065a;
        if (handler != null) {
            handler.removeMessages(6);
        }
        this.f8065a = null;
        p0 p0Var = this.e;
        if (p0Var != null) {
            p0Var.b();
            this.e.a();
        }
        this.e = null;
    }
}
