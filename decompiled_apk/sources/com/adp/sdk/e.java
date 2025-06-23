package com.adp.sdk;

import android.content.Context;
import com.adp.sdk.dto.SourceVO;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f4708a = false;
    protected boolean b = false;
    protected boolean c = false;
    protected boolean d = false;
    protected boolean e = false;
    protected boolean f = true;

    public void a() {
        this.f4708a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
    }

    public void b(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        String str4;
        if (!this.f) {
            return;
        }
        if (sourceVO != null) {
            str4 = sourceVO.getId();
        } else {
            str4 = null;
        }
        if (!this.b) {
            this.b = true;
            c.a().b(context, str, str2, str3, str4);
        }
        c.a().d(context, str, str2, str3, str4);
    }

    public void c(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        String str4;
        if (!this.f) {
            return;
        }
        if (sourceVO != null) {
            str4 = sourceVO.getId();
        } else {
            str4 = null;
        }
        if (!this.f4708a) {
            this.f4708a = true;
            c.a().h(context, str, str2, str3, str4);
        }
        c.a().e(context, str, str2, str3, str4);
    }

    public void d(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        String str4;
        if (!this.f) {
            return;
        }
        if (sourceVO != null) {
            str4 = sourceVO.getId();
        } else {
            str4 = null;
        }
        if (!this.e) {
            this.e = true;
            c.a().i(context, str, str2, str3, str4);
        }
        c.a().f(context, str, str2, str3, str4);
    }

    public void e(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        String str4;
        if (!this.f) {
            return;
        }
        if (sourceVO != null) {
            str4 = sourceVO.getId();
        } else {
            str4 = null;
        }
        if (!this.c) {
            this.c = true;
            c.a().j(context, str, str2, str3, str4);
        }
        c.a().g(context, str, str2, str3, str4);
    }

    public void a(Context context, String str, String str2, String str3, SourceVO sourceVO, String str4) {
        if (this.f) {
            String id = sourceVO != null ? sourceVO.getId() : null;
            if (!this.b) {
                this.b = true;
                c.a().b(context, str, str2, str3, id);
            }
            c.a().a(context, str, str2, str3, id, str4);
        }
    }

    public void a(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        if (this.f) {
            String id = sourceVO != null ? sourceVO.getId() : null;
            if (!this.d) {
                this.d = true;
                c.a().a(context, str, str2, str3, id);
            }
            c.a().c(context, str, str2, str3, id);
        }
    }
}
