package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMVitalityLSDLesson {
    private final int lowerBoundHR;
    private final int minutes;
    private final float target;
    private final int upperBoundHR;

    public GMVitalityLSDLesson() {
        this(0, 0, 0, 0.0f, 15, null);
    }

    public static /* synthetic */ GMVitalityLSDLesson copy$default(GMVitalityLSDLesson gMVitalityLSDLesson, int i, int i2, int i3, float f, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = gMVitalityLSDLesson.minutes;
        }
        if ((i4 & 2) != 0) {
            i2 = gMVitalityLSDLesson.upperBoundHR;
        }
        if ((i4 & 4) != 0) {
            i3 = gMVitalityLSDLesson.lowerBoundHR;
        }
        if ((i4 & 8) != 0) {
            f = gMVitalityLSDLesson.target;
        }
        return gMVitalityLSDLesson.copy(i, i2, i3, f);
    }

    public final int component1() {
        return this.minutes;
    }

    public final int component2() {
        return this.upperBoundHR;
    }

    public final int component3() {
        return this.lowerBoundHR;
    }

    public final float component4() {
        return this.target;
    }

    @OOXIXo
    public final GMVitalityLSDLesson copy(int i, int i2, int i3, float f) {
        return new GMVitalityLSDLesson(i, i2, i3, f);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMVitalityLSDLesson)) {
            return false;
        }
        GMVitalityLSDLesson gMVitalityLSDLesson = (GMVitalityLSDLesson) obj;
        return this.minutes == gMVitalityLSDLesson.minutes && this.upperBoundHR == gMVitalityLSDLesson.upperBoundHR && this.lowerBoundHR == gMVitalityLSDLesson.lowerBoundHR && Float.compare(this.target, gMVitalityLSDLesson.target) == 0;
    }

    public final int getLowerBoundHR() {
        return this.lowerBoundHR;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final float getTarget() {
        return this.target;
    }

    public final int getUpperBoundHR() {
        return this.upperBoundHR;
    }

    public int hashCode() {
        return (((((this.minutes * 31) + this.upperBoundHR) * 31) + this.lowerBoundHR) * 31) + Float.floatToIntBits(this.target);
    }

    @OOXIXo
    public String toString() {
        return "GMVitalityLSDLesson(minutes=" + this.minutes + ", upperBoundHR=" + this.upperBoundHR + ", lowerBoundHR=" + this.lowerBoundHR + ", target=" + this.target + oIX0oI.I0Io.f4095I0Io;
    }

    public GMVitalityLSDLesson(int i, int i2, int i3, float f) {
        this.minutes = i;
        this.upperBoundHR = i2;
        this.lowerBoundHR = i3;
        this.target = f;
    }

    public /* synthetic */ GMVitalityLSDLesson(int i, int i2, int i3, float f, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? -9999 : i, (i4 & 2) != 0 ? -9999 : i2, (i4 & 4) != 0 ? -9999 : i3, (i4 & 8) != 0 ? -9999.0f : f);
    }
}
