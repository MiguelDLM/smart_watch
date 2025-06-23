package com.baidu.navisdk.yellowtipdata.model.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f9461a;

    @OOXIXo
    private final String b;

    @OOXIXo
    private final String c;

    public a(int i, @OOXIXo String value, @OOXIXo String text) {
        IIX0o.x0xO0oo(value, "value");
        IIX0o.x0xO0oo(text, "text");
        this.f9461a = i;
        this.b = value;
        this.c = text;
    }

    public final int a() {
        return this.f9461a;
    }

    @OOXIXo
    public final String b() {
        return this.c;
    }

    @OOXIXo
    public final String c() {
        return this.b;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9461a == aVar.f9461a && IIX0o.Oxx0IOOO(this.b, aVar.b) && IIX0o.Oxx0IOOO(this.c, aVar.c);
    }

    public int hashCode() {
        int i = this.f9461a * 31;
        String str = this.b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @OOXIXo
    public String toString() {
        return "ClickAction(key=" + this.f9461a + ", value=" + this.b + ", text=" + this.c + oIX0oI.I0Io.f4095I0Io;
    }
}
