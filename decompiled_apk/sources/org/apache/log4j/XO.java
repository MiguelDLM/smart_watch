package org.apache.log4j;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static /* synthetic */ Class f33213I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33214II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f33215oIX0oI;

    public XO(String str) {
        this.f33215oIX0oI = str;
        this.f33214II0xO0 = str.hashCode();
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = f33213I0Io;
            if (cls == null) {
                cls = oIX0oI("org.apache.log4j.CategoryKey");
                f33213I0Io = cls;
            }
            if (cls == obj.getClass()) {
                return this.f33215oIX0oI.equals(((XO) obj).f33215oIX0oI);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f33214II0xO0;
    }
}
