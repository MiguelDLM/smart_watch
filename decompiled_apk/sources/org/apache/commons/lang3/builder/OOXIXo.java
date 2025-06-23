package org.apache.commons.lang3.builder;

/* loaded from: classes6.dex */
public final class OOXIXo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f32648II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Object f32649oIX0oI;

    public OOXIXo(Object obj) {
        this.f32648II0xO0 = System.identityHashCode(obj);
        this.f32649oIX0oI = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OOXIXo)) {
            return false;
        }
        OOXIXo oOXIXo = (OOXIXo) obj;
        if (this.f32648II0xO0 != oOXIXo.f32648II0xO0 || this.f32649oIX0oI != oOXIXo.f32649oIX0oI) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f32648II0xO0;
    }
}
