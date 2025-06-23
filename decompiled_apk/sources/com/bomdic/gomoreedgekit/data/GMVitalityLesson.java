package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMVitalityLesson {
    private final int errorCode;

    @OOXIXo
    private final List<GMVitalityIntervalLesson> intervalLessons;

    @OOXIXo
    private final GMVitalityLSDLesson lsdLesson;

    public GMVitalityLesson() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GMVitalityLesson copy$default(GMVitalityLesson gMVitalityLesson, int i, GMVitalityLSDLesson gMVitalityLSDLesson, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gMVitalityLesson.errorCode;
        }
        if ((i2 & 2) != 0) {
            gMVitalityLSDLesson = gMVitalityLesson.lsdLesson;
        }
        if ((i2 & 4) != 0) {
            list = gMVitalityLesson.intervalLessons;
        }
        return gMVitalityLesson.copy(i, gMVitalityLSDLesson, list);
    }

    public final int component1() {
        return this.errorCode;
    }

    @OOXIXo
    public final GMVitalityLSDLesson component2() {
        return this.lsdLesson;
    }

    @OOXIXo
    public final List<GMVitalityIntervalLesson> component3() {
        return this.intervalLessons;
    }

    @OOXIXo
    public final GMVitalityLesson copy(int i, @OOXIXo GMVitalityLSDLesson lsdLesson, @OOXIXo List<GMVitalityIntervalLesson> intervalLessons) {
        IIX0o.x0xO0oo(lsdLesson, "lsdLesson");
        IIX0o.x0xO0oo(intervalLessons, "intervalLessons");
        return new GMVitalityLesson(i, lsdLesson, intervalLessons);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMVitalityLesson)) {
            return false;
        }
        GMVitalityLesson gMVitalityLesson = (GMVitalityLesson) obj;
        return this.errorCode == gMVitalityLesson.errorCode && IIX0o.Oxx0IOOO(this.lsdLesson, gMVitalityLesson.lsdLesson) && IIX0o.Oxx0IOOO(this.intervalLessons, gMVitalityLesson.intervalLessons);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @OOXIXo
    public final List<GMVitalityIntervalLesson> getIntervalLessons() {
        return this.intervalLessons;
    }

    @OOXIXo
    public final GMVitalityLSDLesson getLsdLesson() {
        return this.lsdLesson;
    }

    public final boolean hasError() {
        int i = this.errorCode;
        if (i < 0 && i != -2008) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.errorCode * 31) + this.lsdLesson.hashCode()) * 31) + this.intervalLessons.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMVitalityLesson(errorCode=" + this.errorCode + ", lsdLesson=" + this.lsdLesson + ", intervalLessons=" + this.intervalLessons + oIX0oI.I0Io.f4095I0Io;
    }

    public GMVitalityLesson(int i, @OOXIXo GMVitalityLSDLesson lsdLesson, @OOXIXo List<GMVitalityIntervalLesson> intervalLessons) {
        IIX0o.x0xO0oo(lsdLesson, "lsdLesson");
        IIX0o.x0xO0oo(intervalLessons, "intervalLessons");
        this.errorCode = i;
        this.lsdLesson = lsdLesson;
        this.intervalLessons = intervalLessons;
    }

    public /* synthetic */ GMVitalityLesson(int i, GMVitalityLSDLesson gMVitalityLSDLesson, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new GMVitalityLSDLesson(0, 0, 0, 0.0f, 15, null) : gMVitalityLSDLesson, (i2 & 4) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list);
    }
}
