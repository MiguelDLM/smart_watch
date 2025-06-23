package com.baidu.navisdk.filedownload;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.s;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6792a;

    @oOoXoXO
    private WeakReference<c> b;
    private int c;

    @oOoXoXO
    private String d;

    @oOoXoXO
    private String e;
    private String f;
    private String g;

    @OOXIXo
    private final String h;

    public a(@OOXIXo String url) {
        IIX0o.x0xO0oo(url, "url");
        this.h = url;
        this.f6792a = true;
    }

    @OOXIXo
    public final a a(boolean z) {
        this.f6792a = z;
        return this;
    }

    @oOoXoXO
    public final String b() {
        return this.e;
    }

    @oOoXoXO
    public final String c() {
        return this.d;
    }

    @OOXIXo
    public final String d() {
        return this.h;
    }

    public final boolean e() {
        return this.f6792a;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !IIX0o.Oxx0IOOO(a.class, obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        if (!IIX0o.Oxx0IOOO(this.b, aVar.b)) {
            return false;
        }
        return IIX0o.Oxx0IOOO(this.h, aVar.h);
    }

    public final boolean f() {
        return !TextUtils.isEmpty(this.h);
    }

    public int hashCode() {
        int i;
        WeakReference<c> weakReference = this.b;
        if (weakReference != null) {
            i = weakReference.hashCode();
        } else {
            i = 0;
        }
        return (i * 31) + this.h.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "ThreeDDownloadRequest{isNeedProgress=" + this.f6792a + ", downloadZipFileListener=" + this.b + ", currentProgress=" + this.c + ", url='" + this.h + "'}";
    }

    @OOXIXo
    public final a a(@oOoXoXO c cVar) {
        if (cVar == null) {
            this.b = null;
        } else {
            this.b = new WeakReference<>(cVar);
        }
        return this;
    }

    public final boolean b(@oOoXoXO String str) {
        String str2 = this.g;
        if (str2 == null || str2.length() == 0) {
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        return OxI.x00IOx(this.g, s.c(str), false, 2, null);
    }

    @OOXIXo
    public final a c(@oOoXoXO String str) {
        this.e = str;
        return this;
    }

    @OOXIXo
    public final a d(@oOoXoXO String str) {
        this.g = str;
        return this;
    }

    @OOXIXo
    public final a e(@oOoXoXO String str) {
        this.d = str;
        return this;
    }

    @oOoXoXO
    public final c a() {
        WeakReference<c> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean a(@oOoXoXO String str) {
        String str2 = this.f;
        if (str2 == null || str2.length() == 0) {
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        return OxI.x00IOx(this.f, s.c(str), false, 2, null);
    }
}
