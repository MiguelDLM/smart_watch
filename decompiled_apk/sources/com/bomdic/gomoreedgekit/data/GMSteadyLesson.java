package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMSteadyLesson {
    private final int coolDownSeconds;

    @OOXIXo
    private final GMCoachBound hrBound;

    @OOXIXo
    private final GMCoachBound rpeBound;
    private final int seconds;

    @OOXIXo
    private final GMCoachBound speedBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownHRBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownRPEBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownSpeedBound;
    private final int warmUpSeconds;

    public GMSteadyLesson() {
        this(0, null, null, null, 0, 0, null, null, null, 511, null);
    }

    public final int component1() {
        return this.seconds;
    }

    @OOXIXo
    public final GMCoachBound component2() {
        return this.speedBound;
    }

    @OOXIXo
    public final GMCoachBound component3() {
        return this.hrBound;
    }

    @OOXIXo
    public final GMCoachBound component4() {
        return this.rpeBound;
    }

    public final int component5() {
        return this.warmUpSeconds;
    }

    public final int component6() {
        return this.coolDownSeconds;
    }

    @OOXIXo
    public final GMCoachBound component7() {
        return this.warmUpCoolDownSpeedBound;
    }

    @OOXIXo
    public final GMCoachBound component8() {
        return this.warmUpCoolDownHRBound;
    }

    @OOXIXo
    public final GMCoachBound component9() {
        return this.warmUpCoolDownRPEBound;
    }

    @OOXIXo
    public final GMSteadyLesson copy(int i, @OOXIXo GMCoachBound speedBound, @OOXIXo GMCoachBound hrBound, @OOXIXo GMCoachBound rpeBound, int i2, int i3, @OOXIXo GMCoachBound warmUpCoolDownSpeedBound, @OOXIXo GMCoachBound warmUpCoolDownHRBound, @OOXIXo GMCoachBound warmUpCoolDownRPEBound) {
        IIX0o.x0xO0oo(speedBound, "speedBound");
        IIX0o.x0xO0oo(hrBound, "hrBound");
        IIX0o.x0xO0oo(rpeBound, "rpeBound");
        IIX0o.x0xO0oo(warmUpCoolDownSpeedBound, "warmUpCoolDownSpeedBound");
        IIX0o.x0xO0oo(warmUpCoolDownHRBound, "warmUpCoolDownHRBound");
        IIX0o.x0xO0oo(warmUpCoolDownRPEBound, "warmUpCoolDownRPEBound");
        return new GMSteadyLesson(i, speedBound, hrBound, rpeBound, i2, i3, warmUpCoolDownSpeedBound, warmUpCoolDownHRBound, warmUpCoolDownRPEBound);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMSteadyLesson)) {
            return false;
        }
        GMSteadyLesson gMSteadyLesson = (GMSteadyLesson) obj;
        return this.seconds == gMSteadyLesson.seconds && IIX0o.Oxx0IOOO(this.speedBound, gMSteadyLesson.speedBound) && IIX0o.Oxx0IOOO(this.hrBound, gMSteadyLesson.hrBound) && IIX0o.Oxx0IOOO(this.rpeBound, gMSteadyLesson.rpeBound) && this.warmUpSeconds == gMSteadyLesson.warmUpSeconds && this.coolDownSeconds == gMSteadyLesson.coolDownSeconds && IIX0o.Oxx0IOOO(this.warmUpCoolDownSpeedBound, gMSteadyLesson.warmUpCoolDownSpeedBound) && IIX0o.Oxx0IOOO(this.warmUpCoolDownHRBound, gMSteadyLesson.warmUpCoolDownHRBound) && IIX0o.Oxx0IOOO(this.warmUpCoolDownRPEBound, gMSteadyLesson.warmUpCoolDownRPEBound);
    }

    public final int getCoolDownSeconds() {
        return this.coolDownSeconds;
    }

    @OOXIXo
    public final GMCoachBound getHrBound() {
        return this.hrBound;
    }

    @OOXIXo
    public final GMCoachBound getRpeBound() {
        return this.rpeBound;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    @OOXIXo
    public final GMCoachBound getSpeedBound() {
        return this.speedBound;
    }

    @OOXIXo
    public final GMCoachBound getWarmUpCoolDownHRBound() {
        return this.warmUpCoolDownHRBound;
    }

    @OOXIXo
    public final GMCoachBound getWarmUpCoolDownRPEBound() {
        return this.warmUpCoolDownRPEBound;
    }

    @OOXIXo
    public final GMCoachBound getWarmUpCoolDownSpeedBound() {
        return this.warmUpCoolDownSpeedBound;
    }

    public final int getWarmUpSeconds() {
        return this.warmUpSeconds;
    }

    public int hashCode() {
        return (((((((((((((((this.seconds * 31) + this.speedBound.hashCode()) * 31) + this.hrBound.hashCode()) * 31) + this.rpeBound.hashCode()) * 31) + this.warmUpSeconds) * 31) + this.coolDownSeconds) * 31) + this.warmUpCoolDownSpeedBound.hashCode()) * 31) + this.warmUpCoolDownHRBound.hashCode()) * 31) + this.warmUpCoolDownRPEBound.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMSteadyLesson(seconds=" + this.seconds + ", speedBound=" + this.speedBound + ", hrBound=" + this.hrBound + ", rpeBound=" + this.rpeBound + ", warmUpSeconds=" + this.warmUpSeconds + ", coolDownSeconds=" + this.coolDownSeconds + ", warmUpCoolDownSpeedBound=" + this.warmUpCoolDownSpeedBound + ", warmUpCoolDownHRBound=" + this.warmUpCoolDownHRBound + ", warmUpCoolDownRPEBound=" + this.warmUpCoolDownRPEBound + oIX0oI.I0Io.f4095I0Io;
    }

    public GMSteadyLesson(int i, @OOXIXo GMCoachBound speedBound, @OOXIXo GMCoachBound hrBound, @OOXIXo GMCoachBound rpeBound, int i2, int i3, @OOXIXo GMCoachBound warmUpCoolDownSpeedBound, @OOXIXo GMCoachBound warmUpCoolDownHRBound, @OOXIXo GMCoachBound warmUpCoolDownRPEBound) {
        IIX0o.x0xO0oo(speedBound, "speedBound");
        IIX0o.x0xO0oo(hrBound, "hrBound");
        IIX0o.x0xO0oo(rpeBound, "rpeBound");
        IIX0o.x0xO0oo(warmUpCoolDownSpeedBound, "warmUpCoolDownSpeedBound");
        IIX0o.x0xO0oo(warmUpCoolDownHRBound, "warmUpCoolDownHRBound");
        IIX0o.x0xO0oo(warmUpCoolDownRPEBound, "warmUpCoolDownRPEBound");
        this.seconds = i;
        this.speedBound = speedBound;
        this.hrBound = hrBound;
        this.rpeBound = rpeBound;
        this.warmUpSeconds = i2;
        this.coolDownSeconds = i3;
        this.warmUpCoolDownSpeedBound = warmUpCoolDownSpeedBound;
        this.warmUpCoolDownHRBound = warmUpCoolDownHRBound;
        this.warmUpCoolDownRPEBound = warmUpCoolDownRPEBound;
    }

    public /* synthetic */ GMSteadyLesson(int i, GMCoachBound gMCoachBound, GMCoachBound gMCoachBound2, GMCoachBound gMCoachBound3, int i2, int i3, GMCoachBound gMCoachBound4, GMCoachBound gMCoachBound5, GMCoachBound gMCoachBound6, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? -9999 : i, (i4 & 2) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound, (i4 & 4) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound2, (i4 & 8) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound3, (i4 & 16) != 0 ? -9999 : i2, (i4 & 32) == 0 ? i3 : -9999, (i4 & 64) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound4, (i4 & 128) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound5, (i4 & 256) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound6);
    }
}
