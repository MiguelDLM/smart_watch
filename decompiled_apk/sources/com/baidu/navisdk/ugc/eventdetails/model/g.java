package com.baidu.navisdk.ugc.eventdetails.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final String f8078a;

    @OOXIXo
    private final String b;
    private final int c;
    private final long d;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public g(@OOXIXo String thumbnailUrl, @OOXIXo String actualUrl, int i, long j) {
        IIX0o.x0xO0oo(thumbnailUrl, "thumbnailUrl");
        IIX0o.x0xO0oo(actualUrl, "actualUrl");
        this.f8078a = thumbnailUrl;
        this.b = actualUrl;
        this.c = i;
        this.d = j;
    }

    @OOXIXo
    public final String a() {
        return this.b;
    }

    @OOXIXo
    public final String b() {
        return this.f8078a;
    }

    public final long c() {
        return this.d;
    }

    public final int d() {
        return this.c;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return IIX0o.Oxx0IOOO(this.f8078a, gVar.f8078a) && IIX0o.Oxx0IOOO(this.b, gVar.b) && this.c == gVar.c && this.d == gVar.d;
    }

    public int hashCode() {
        String str = this.f8078a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c) * 31;
        long j = this.d;
        return hashCode2 + ((int) (j ^ (j >>> 32)));
    }

    @OOXIXo
    public String toString() {
        return "UgcImageAndVideoItemDataModel(thumbnailUrl=" + this.f8078a + ", actualUrl=" + this.b + ", type=" + this.c + ", timeStamp=" + this.d + oIX0oI.I0Io.f4095I0Io;
    }
}
