package com.baidu.navisdk.ui.chargelist.data.beans;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final String f8375a;
    private final int b;
    private boolean c;

    @OOXIXo
    public final String a() {
        return this.f8375a;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return IIX0o.Oxx0IOOO(this.f8375a, cVar.f8375a) && this.b == cVar.b && this.c == cVar.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f8375a;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @OOXIXo
    public String toString() {
        return "ElectricityData(electricityName=" + this.f8375a + ", electricityType=" + this.b + ", isCheck=" + this.c + oIX0oI.I0Io.f4095I0Io;
    }

    public final void a(boolean z) {
        this.c = z;
    }
}
