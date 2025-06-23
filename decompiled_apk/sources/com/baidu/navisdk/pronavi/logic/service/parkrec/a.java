package com.baidu.navisdk.pronavi.logic.service.parkrec;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import com.baidu.navisdk.model.datastruct.destrec.c;
import com.baidu.navisdk.model.datastruct.destrec.e;
import com.baidu.navisdk.model.datastruct.destrec.f;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f7789a;
    private final boolean b;
    private final boolean c;

    @oOoXoXO
    private final c d;

    public a(boolean z, boolean z2, boolean z3, @oOoXoXO c cVar) {
        this.f7789a = z;
        this.b = z2;
        this.c = z3;
        this.d = cVar;
    }

    @oOoXoXO
    public final c a() {
        return this.d;
    }

    @oOoXoXO
    public final e b() {
        ArrayList<f> b;
        c cVar = this.d;
        if (cVar != null && (b = cVar.b()) != null && !b.isEmpty()) {
            f fVar = b.get(0);
            IIX0o.oO(fVar, "list[0]");
            return fVar.h();
        }
        return null;
    }

    public final boolean c() {
        return this.f7789a;
    }

    public final boolean d() {
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
        return this.f7789a == aVar.f7789a && this.b == aVar.b && this.c == aVar.c && IIX0o.Oxx0IOOO(this.d, aVar.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.f7789a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.b;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.c;
        int i4 = (i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        c cVar = this.d;
        return i4 + (cVar != null ? cVar.hashCode() : 0);
    }

    @OOXIXo
    public String toString() {
        return "DestRecDrivingDataWrapper(startParkRec=" + this.f7789a + ", startParkSpaceRecOrNav=" + this.b + ", startParkSpaceNav=" + this.c + ", destRecDrivingData=" + this.d + oIX0oI.I0Io.f4095I0Io;
    }
}
