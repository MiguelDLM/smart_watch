package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMProgressionLesson {

    @OOXIXo
    private final GMCoachBound coolDownHRBound;

    @OOXIXo
    private final GMCoachBound coolDownRPEBound;
    private final int coolDownSeconds;

    @OOXIXo
    private final GMCoachBound coolDownSpeedBound;

    @OOXIXo
    private final List<GMCoachBound> hrBounds;

    @OOXIXo
    private final List<GMCoachBound> rpeBounds;
    private final int seconds;
    private final int sets;

    @OOXIXo
    private final List<GMCoachBound> speedBounds;

    public GMProgressionLesson() {
        this(0, 0, null, null, null, 0, null, null, null, 511, null);
    }

    public final int component1() {
        return this.sets;
    }

    public final int component2() {
        return this.seconds;
    }

    @OOXIXo
    public final List<GMCoachBound> component3() {
        return this.speedBounds;
    }

    @OOXIXo
    public final List<GMCoachBound> component4() {
        return this.hrBounds;
    }

    @OOXIXo
    public final List<GMCoachBound> component5() {
        return this.rpeBounds;
    }

    public final int component6() {
        return this.coolDownSeconds;
    }

    @OOXIXo
    public final GMCoachBound component7() {
        return this.coolDownSpeedBound;
    }

    @OOXIXo
    public final GMCoachBound component8() {
        return this.coolDownHRBound;
    }

    @OOXIXo
    public final GMCoachBound component9() {
        return this.coolDownRPEBound;
    }

    @OOXIXo
    public final GMProgressionLesson copy(int i, int i2, @OOXIXo List<GMCoachBound> speedBounds, @OOXIXo List<GMCoachBound> hrBounds, @OOXIXo List<GMCoachBound> rpeBounds, int i3, @OOXIXo GMCoachBound coolDownSpeedBound, @OOXIXo GMCoachBound coolDownHRBound, @OOXIXo GMCoachBound coolDownRPEBound) {
        IIX0o.x0xO0oo(speedBounds, "speedBounds");
        IIX0o.x0xO0oo(hrBounds, "hrBounds");
        IIX0o.x0xO0oo(rpeBounds, "rpeBounds");
        IIX0o.x0xO0oo(coolDownSpeedBound, "coolDownSpeedBound");
        IIX0o.x0xO0oo(coolDownHRBound, "coolDownHRBound");
        IIX0o.x0xO0oo(coolDownRPEBound, "coolDownRPEBound");
        return new GMProgressionLesson(i, i2, speedBounds, hrBounds, rpeBounds, i3, coolDownSpeedBound, coolDownHRBound, coolDownRPEBound);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMProgressionLesson)) {
            return false;
        }
        GMProgressionLesson gMProgressionLesson = (GMProgressionLesson) obj;
        return this.sets == gMProgressionLesson.sets && this.seconds == gMProgressionLesson.seconds && IIX0o.Oxx0IOOO(this.speedBounds, gMProgressionLesson.speedBounds) && IIX0o.Oxx0IOOO(this.hrBounds, gMProgressionLesson.hrBounds) && IIX0o.Oxx0IOOO(this.rpeBounds, gMProgressionLesson.rpeBounds) && this.coolDownSeconds == gMProgressionLesson.coolDownSeconds && IIX0o.Oxx0IOOO(this.coolDownSpeedBound, gMProgressionLesson.coolDownSpeedBound) && IIX0o.Oxx0IOOO(this.coolDownHRBound, gMProgressionLesson.coolDownHRBound) && IIX0o.Oxx0IOOO(this.coolDownRPEBound, gMProgressionLesson.coolDownRPEBound);
    }

    @OOXIXo
    public final GMCoachBound getCoolDownHRBound() {
        return this.coolDownHRBound;
    }

    @OOXIXo
    public final GMCoachBound getCoolDownRPEBound() {
        return this.coolDownRPEBound;
    }

    public final int getCoolDownSeconds() {
        return this.coolDownSeconds;
    }

    @OOXIXo
    public final GMCoachBound getCoolDownSpeedBound() {
        return this.coolDownSpeedBound;
    }

    @OOXIXo
    public final List<GMCoachBound> getHrBounds() {
        return this.hrBounds;
    }

    @OOXIXo
    public final List<GMCoachBound> getRpeBounds() {
        return this.rpeBounds;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final int getSets() {
        return this.sets;
    }

    @OOXIXo
    public final List<GMCoachBound> getSpeedBounds() {
        return this.speedBounds;
    }

    public int hashCode() {
        return (((((((((((((((this.sets * 31) + this.seconds) * 31) + this.speedBounds.hashCode()) * 31) + this.hrBounds.hashCode()) * 31) + this.rpeBounds.hashCode()) * 31) + this.coolDownSeconds) * 31) + this.coolDownSpeedBound.hashCode()) * 31) + this.coolDownHRBound.hashCode()) * 31) + this.coolDownRPEBound.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMProgressionLesson(sets=" + this.sets + ", seconds=" + this.seconds + ", speedBounds=" + this.speedBounds + ", hrBounds=" + this.hrBounds + ", rpeBounds=" + this.rpeBounds + ", coolDownSeconds=" + this.coolDownSeconds + ", coolDownSpeedBound=" + this.coolDownSpeedBound + ", coolDownHRBound=" + this.coolDownHRBound + ", coolDownRPEBound=" + this.coolDownRPEBound + oIX0oI.I0Io.f4095I0Io;
    }

    public GMProgressionLesson(int i, int i2, @OOXIXo List<GMCoachBound> speedBounds, @OOXIXo List<GMCoachBound> hrBounds, @OOXIXo List<GMCoachBound> rpeBounds, int i3, @OOXIXo GMCoachBound coolDownSpeedBound, @OOXIXo GMCoachBound coolDownHRBound, @OOXIXo GMCoachBound coolDownRPEBound) {
        IIX0o.x0xO0oo(speedBounds, "speedBounds");
        IIX0o.x0xO0oo(hrBounds, "hrBounds");
        IIX0o.x0xO0oo(rpeBounds, "rpeBounds");
        IIX0o.x0xO0oo(coolDownSpeedBound, "coolDownSpeedBound");
        IIX0o.x0xO0oo(coolDownHRBound, "coolDownHRBound");
        IIX0o.x0xO0oo(coolDownRPEBound, "coolDownRPEBound");
        this.sets = i;
        this.seconds = i2;
        this.speedBounds = speedBounds;
        this.hrBounds = hrBounds;
        this.rpeBounds = rpeBounds;
        this.coolDownSeconds = i3;
        this.coolDownSpeedBound = coolDownSpeedBound;
        this.coolDownHRBound = coolDownHRBound;
        this.coolDownRPEBound = coolDownRPEBound;
    }

    public /* synthetic */ GMProgressionLesson(int i, int i2, List list, List list2, List list3, int i3, GMCoachBound gMCoachBound, GMCoachBound gMCoachBound2, GMCoachBound gMCoachBound3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? -9999 : i, (i4 & 2) != 0 ? -9999 : i2, (i4 & 4) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list, (i4 & 8) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list2, (i4 & 16) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list3, (i4 & 32) == 0 ? i3 : -9999, (i4 & 64) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound, (i4 & 128) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound2, (i4 & 256) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound3);
    }
}
