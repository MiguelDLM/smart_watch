package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMCoachBoundFloat {
    private final float lower;
    private final float upper;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GMCoachBoundFloat() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bomdic.gomoreedgekit.data.GMCoachBoundFloat.<init>():void");
    }

    public static /* synthetic */ GMCoachBoundFloat copy$default(GMCoachBoundFloat gMCoachBoundFloat, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = gMCoachBoundFloat.upper;
        }
        if ((i & 2) != 0) {
            f2 = gMCoachBoundFloat.lower;
        }
        return gMCoachBoundFloat.copy(f, f2);
    }

    public final float component1() {
        return this.upper;
    }

    public final float component2() {
        return this.lower;
    }

    @OOXIXo
    public final GMCoachBoundFloat copy(float f, float f2) {
        return new GMCoachBoundFloat(f, f2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMCoachBoundFloat)) {
            return false;
        }
        GMCoachBoundFloat gMCoachBoundFloat = (GMCoachBoundFloat) obj;
        return Float.compare(this.upper, gMCoachBoundFloat.upper) == 0 && Float.compare(this.lower, gMCoachBoundFloat.lower) == 0;
    }

    public final float getLower() {
        return this.lower;
    }

    public final float getUpper() {
        return this.upper;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.upper) * 31) + Float.floatToIntBits(this.lower);
    }

    @OOXIXo
    public String toString() {
        return "GMCoachBoundFloat(upper=" + this.upper + ", lower=" + this.lower + oIX0oI.I0Io.f4095I0Io;
    }

    public GMCoachBoundFloat(float f, float f2) {
        this.upper = f;
        this.lower = f2;
    }

    public /* synthetic */ GMCoachBoundFloat(float f, float f2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? -9999.0f : f, (i & 2) != 0 ? -9999.0f : f2);
    }
}
