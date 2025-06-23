package com.baidu.navisdk.model.datastruct;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f6924a;

    @OOXIXo
    private final String b;

    @OOXIXo
    private final String c;

    @OOXIXo
    private final String d;

    @OOXIXo
    private final String e;

    public e(int i, @OOXIXo String name, @OOXIXo String abbrName, @OOXIXo String iconSelected, @OOXIXo String iconUnselected) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(abbrName, "abbrName");
        IIX0o.x0xO0oo(iconSelected, "iconSelected");
        IIX0o.x0xO0oo(iconUnselected, "iconUnselected");
        this.f6924a = i;
        this.b = name;
        this.c = abbrName;
        this.d = iconSelected;
        this.e = iconUnselected;
    }

    public final int a() {
        return this.f6924a;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6924a == eVar.f6924a && IIX0o.Oxx0IOOO(this.b, eVar.b) && IIX0o.Oxx0IOOO(this.c, eVar.c) && IIX0o.Oxx0IOOO(this.d, eVar.d) && IIX0o.Oxx0IOOO(this.e, eVar.e);
    }

    public int hashCode() {
        int i = this.f6924a * 31;
        String str = this.b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @OOXIXo
    public String toString() {
        return "ChargeRoutePrefer(prefer=" + this.f6924a + ", name=" + this.b + ", abbrName=" + this.c + ", iconSelected=" + this.d + ", iconUnselected=" + this.e + oIX0oI.I0Io.f4095I0Io;
    }
}
