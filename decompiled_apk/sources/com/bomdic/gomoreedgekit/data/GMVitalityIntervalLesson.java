package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMVitalityIntervalLesson {
    private final int intenseMinutes;
    private final int lowerBoundHR;
    private final int repeatTimes;
    private final int restHR;
    private final int restMinutes;
    private final float target;
    private final int upperBoundHR;

    public GMVitalityIntervalLesson() {
        this(0, 0, 0, 0, 0, 0, 0.0f, 127, null);
    }

    public static /* synthetic */ GMVitalityIntervalLesson copy$default(GMVitalityIntervalLesson gMVitalityIntervalLesson, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = gMVitalityIntervalLesson.intenseMinutes;
        }
        if ((i7 & 2) != 0) {
            i2 = gMVitalityIntervalLesson.restMinutes;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = gMVitalityIntervalLesson.upperBoundHR;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = gMVitalityIntervalLesson.lowerBoundHR;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = gMVitalityIntervalLesson.restHR;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = gMVitalityIntervalLesson.repeatTimes;
        }
        int i12 = i6;
        if ((i7 & 64) != 0) {
            f = gMVitalityIntervalLesson.target;
        }
        return gMVitalityIntervalLesson.copy(i, i8, i9, i10, i11, i12, f);
    }

    public final int component1() {
        return this.intenseMinutes;
    }

    public final int component2() {
        return this.restMinutes;
    }

    public final int component3() {
        return this.upperBoundHR;
    }

    public final int component4() {
        return this.lowerBoundHR;
    }

    public final int component5() {
        return this.restHR;
    }

    public final int component6() {
        return this.repeatTimes;
    }

    public final float component7() {
        return this.target;
    }

    @OOXIXo
    public final GMVitalityIntervalLesson copy(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        return new GMVitalityIntervalLesson(i, i2, i3, i4, i5, i6, f);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMVitalityIntervalLesson)) {
            return false;
        }
        GMVitalityIntervalLesson gMVitalityIntervalLesson = (GMVitalityIntervalLesson) obj;
        return this.intenseMinutes == gMVitalityIntervalLesson.intenseMinutes && this.restMinutes == gMVitalityIntervalLesson.restMinutes && this.upperBoundHR == gMVitalityIntervalLesson.upperBoundHR && this.lowerBoundHR == gMVitalityIntervalLesson.lowerBoundHR && this.restHR == gMVitalityIntervalLesson.restHR && this.repeatTimes == gMVitalityIntervalLesson.repeatTimes && Float.compare(this.target, gMVitalityIntervalLesson.target) == 0;
    }

    public final int getIntenseMinutes() {
        return this.intenseMinutes;
    }

    public final int getLowerBoundHR() {
        return this.lowerBoundHR;
    }

    public final int getRepeatTimes() {
        return this.repeatTimes;
    }

    public final int getRestHR() {
        return this.restHR;
    }

    public final int getRestMinutes() {
        return this.restMinutes;
    }

    public final float getTarget() {
        return this.target;
    }

    public final int getUpperBoundHR() {
        return this.upperBoundHR;
    }

    public int hashCode() {
        return (((((((((((this.intenseMinutes * 31) + this.restMinutes) * 31) + this.upperBoundHR) * 31) + this.lowerBoundHR) * 31) + this.restHR) * 31) + this.repeatTimes) * 31) + Float.floatToIntBits(this.target);
    }

    @OOXIXo
    public String toString() {
        return "GMVitalityIntervalLesson(intenseMinutes=" + this.intenseMinutes + ", restMinutes=" + this.restMinutes + ", upperBoundHR=" + this.upperBoundHR + ", lowerBoundHR=" + this.lowerBoundHR + ", restHR=" + this.restHR + ", repeatTimes=" + this.repeatTimes + ", target=" + this.target + oIX0oI.I0Io.f4095I0Io;
    }

    public GMVitalityIntervalLesson(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        this.intenseMinutes = i;
        this.restMinutes = i2;
        this.upperBoundHR = i3;
        this.lowerBoundHR = i4;
        this.restHR = i5;
        this.repeatTimes = i6;
        this.target = f;
    }

    public /* synthetic */ GMVitalityIntervalLesson(int i, int i2, int i3, int i4, int i5, int i6, float f, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? -9999 : i, (i7 & 2) != 0 ? -9999 : i2, (i7 & 4) != 0 ? -9999 : i3, (i7 & 8) != 0 ? -9999 : i4, (i7 & 16) != 0 ? -9999 : i5, (i7 & 32) == 0 ? i6 : -9999, (i7 & 64) != 0 ? -9999.0f : f);
    }
}
