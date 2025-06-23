package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMTempoLesson {
    private final int coolDownSeconds;

    @OOXIXo
    private final GMCoachBound hrBound;

    @OOXIXo
    private final GMCoachBound rpeBound;
    private final int seconds;

    @OOXIXo
    private final GMCoachBound speedBound;

    @OOXIXo
    private final GMCoachBound warmUp2HRBound;

    @OOXIXo
    private final GMCoachBound warmUp2RPEBound;
    private final int warmUp2Seconds;

    @OOXIXo
    private final GMCoachBound warmUp2SpeedBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownHRBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownRPEBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownSpeedBound;
    private final int warmUpSeconds;

    public GMTempoLesson() {
        this(0, null, null, null, 0, null, null, null, 0, 0, null, null, null, 8191, null);
    }

    public final int component1() {
        return this.warmUp2Seconds;
    }

    public final int component10() {
        return this.coolDownSeconds;
    }

    @OOXIXo
    public final GMCoachBound component11() {
        return this.warmUpCoolDownSpeedBound;
    }

    @OOXIXo
    public final GMCoachBound component12() {
        return this.warmUpCoolDownHRBound;
    }

    @OOXIXo
    public final GMCoachBound component13() {
        return this.warmUpCoolDownRPEBound;
    }

    @OOXIXo
    public final GMCoachBound component2() {
        return this.warmUp2SpeedBound;
    }

    @OOXIXo
    public final GMCoachBound component3() {
        return this.warmUp2HRBound;
    }

    @OOXIXo
    public final GMCoachBound component4() {
        return this.warmUp2RPEBound;
    }

    public final int component5() {
        return this.seconds;
    }

    @OOXIXo
    public final GMCoachBound component6() {
        return this.speedBound;
    }

    @OOXIXo
    public final GMCoachBound component7() {
        return this.hrBound;
    }

    @OOXIXo
    public final GMCoachBound component8() {
        return this.rpeBound;
    }

    public final int component9() {
        return this.warmUpSeconds;
    }

    @OOXIXo
    public final GMTempoLesson copy(int i, @OOXIXo GMCoachBound warmUp2SpeedBound, @OOXIXo GMCoachBound warmUp2HRBound, @OOXIXo GMCoachBound warmUp2RPEBound, int i2, @OOXIXo GMCoachBound speedBound, @OOXIXo GMCoachBound hrBound, @OOXIXo GMCoachBound rpeBound, int i3, int i4, @OOXIXo GMCoachBound warmUpCoolDownSpeedBound, @OOXIXo GMCoachBound warmUpCoolDownHRBound, @OOXIXo GMCoachBound warmUpCoolDownRPEBound) {
        IIX0o.x0xO0oo(warmUp2SpeedBound, "warmUp2SpeedBound");
        IIX0o.x0xO0oo(warmUp2HRBound, "warmUp2HRBound");
        IIX0o.x0xO0oo(warmUp2RPEBound, "warmUp2RPEBound");
        IIX0o.x0xO0oo(speedBound, "speedBound");
        IIX0o.x0xO0oo(hrBound, "hrBound");
        IIX0o.x0xO0oo(rpeBound, "rpeBound");
        IIX0o.x0xO0oo(warmUpCoolDownSpeedBound, "warmUpCoolDownSpeedBound");
        IIX0o.x0xO0oo(warmUpCoolDownHRBound, "warmUpCoolDownHRBound");
        IIX0o.x0xO0oo(warmUpCoolDownRPEBound, "warmUpCoolDownRPEBound");
        return new GMTempoLesson(i, warmUp2SpeedBound, warmUp2HRBound, warmUp2RPEBound, i2, speedBound, hrBound, rpeBound, i3, i4, warmUpCoolDownSpeedBound, warmUpCoolDownHRBound, warmUpCoolDownRPEBound);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMTempoLesson)) {
            return false;
        }
        GMTempoLesson gMTempoLesson = (GMTempoLesson) obj;
        return this.warmUp2Seconds == gMTempoLesson.warmUp2Seconds && IIX0o.Oxx0IOOO(this.warmUp2SpeedBound, gMTempoLesson.warmUp2SpeedBound) && IIX0o.Oxx0IOOO(this.warmUp2HRBound, gMTempoLesson.warmUp2HRBound) && IIX0o.Oxx0IOOO(this.warmUp2RPEBound, gMTempoLesson.warmUp2RPEBound) && this.seconds == gMTempoLesson.seconds && IIX0o.Oxx0IOOO(this.speedBound, gMTempoLesson.speedBound) && IIX0o.Oxx0IOOO(this.hrBound, gMTempoLesson.hrBound) && IIX0o.Oxx0IOOO(this.rpeBound, gMTempoLesson.rpeBound) && this.warmUpSeconds == gMTempoLesson.warmUpSeconds && this.coolDownSeconds == gMTempoLesson.coolDownSeconds && IIX0o.Oxx0IOOO(this.warmUpCoolDownSpeedBound, gMTempoLesson.warmUpCoolDownSpeedBound) && IIX0o.Oxx0IOOO(this.warmUpCoolDownHRBound, gMTempoLesson.warmUpCoolDownHRBound) && IIX0o.Oxx0IOOO(this.warmUpCoolDownRPEBound, gMTempoLesson.warmUpCoolDownRPEBound);
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
    public final GMCoachBound getWarmUp2HRBound() {
        return this.warmUp2HRBound;
    }

    @OOXIXo
    public final GMCoachBound getWarmUp2RPEBound() {
        return this.warmUp2RPEBound;
    }

    public final int getWarmUp2Seconds() {
        return this.warmUp2Seconds;
    }

    @OOXIXo
    public final GMCoachBound getWarmUp2SpeedBound() {
        return this.warmUp2SpeedBound;
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
        return (((((((((((((((((((((((this.warmUp2Seconds * 31) + this.warmUp2SpeedBound.hashCode()) * 31) + this.warmUp2HRBound.hashCode()) * 31) + this.warmUp2RPEBound.hashCode()) * 31) + this.seconds) * 31) + this.speedBound.hashCode()) * 31) + this.hrBound.hashCode()) * 31) + this.rpeBound.hashCode()) * 31) + this.warmUpSeconds) * 31) + this.coolDownSeconds) * 31) + this.warmUpCoolDownSpeedBound.hashCode()) * 31) + this.warmUpCoolDownHRBound.hashCode()) * 31) + this.warmUpCoolDownRPEBound.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMTempoLesson(warmUp2Seconds=" + this.warmUp2Seconds + ", warmUp2SpeedBound=" + this.warmUp2SpeedBound + ", warmUp2HRBound=" + this.warmUp2HRBound + ", warmUp2RPEBound=" + this.warmUp2RPEBound + ", seconds=" + this.seconds + ", speedBound=" + this.speedBound + ", hrBound=" + this.hrBound + ", rpeBound=" + this.rpeBound + ", warmUpSeconds=" + this.warmUpSeconds + ", coolDownSeconds=" + this.coolDownSeconds + ", warmUpCoolDownSpeedBound=" + this.warmUpCoolDownSpeedBound + ", warmUpCoolDownHRBound=" + this.warmUpCoolDownHRBound + ", warmUpCoolDownRPEBound=" + this.warmUpCoolDownRPEBound + oIX0oI.I0Io.f4095I0Io;
    }

    public GMTempoLesson(int i, @OOXIXo GMCoachBound warmUp2SpeedBound, @OOXIXo GMCoachBound warmUp2HRBound, @OOXIXo GMCoachBound warmUp2RPEBound, int i2, @OOXIXo GMCoachBound speedBound, @OOXIXo GMCoachBound hrBound, @OOXIXo GMCoachBound rpeBound, int i3, int i4, @OOXIXo GMCoachBound warmUpCoolDownSpeedBound, @OOXIXo GMCoachBound warmUpCoolDownHRBound, @OOXIXo GMCoachBound warmUpCoolDownRPEBound) {
        IIX0o.x0xO0oo(warmUp2SpeedBound, "warmUp2SpeedBound");
        IIX0o.x0xO0oo(warmUp2HRBound, "warmUp2HRBound");
        IIX0o.x0xO0oo(warmUp2RPEBound, "warmUp2RPEBound");
        IIX0o.x0xO0oo(speedBound, "speedBound");
        IIX0o.x0xO0oo(hrBound, "hrBound");
        IIX0o.x0xO0oo(rpeBound, "rpeBound");
        IIX0o.x0xO0oo(warmUpCoolDownSpeedBound, "warmUpCoolDownSpeedBound");
        IIX0o.x0xO0oo(warmUpCoolDownHRBound, "warmUpCoolDownHRBound");
        IIX0o.x0xO0oo(warmUpCoolDownRPEBound, "warmUpCoolDownRPEBound");
        this.warmUp2Seconds = i;
        this.warmUp2SpeedBound = warmUp2SpeedBound;
        this.warmUp2HRBound = warmUp2HRBound;
        this.warmUp2RPEBound = warmUp2RPEBound;
        this.seconds = i2;
        this.speedBound = speedBound;
        this.hrBound = hrBound;
        this.rpeBound = rpeBound;
        this.warmUpSeconds = i3;
        this.coolDownSeconds = i4;
        this.warmUpCoolDownSpeedBound = warmUpCoolDownSpeedBound;
        this.warmUpCoolDownHRBound = warmUpCoolDownHRBound;
        this.warmUpCoolDownRPEBound = warmUpCoolDownRPEBound;
    }

    public /* synthetic */ GMTempoLesson(int i, GMCoachBound gMCoachBound, GMCoachBound gMCoachBound2, GMCoachBound gMCoachBound3, int i2, GMCoachBound gMCoachBound4, GMCoachBound gMCoachBound5, GMCoachBound gMCoachBound6, int i3, int i4, GMCoachBound gMCoachBound7, GMCoachBound gMCoachBound8, GMCoachBound gMCoachBound9, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? -9999 : i, (i5 & 2) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound, (i5 & 4) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound2, (i5 & 8) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound3, (i5 & 16) != 0 ? -9999 : i2, (i5 & 32) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound4, (i5 & 64) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound5, (i5 & 128) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound6, (i5 & 256) != 0 ? -9999 : i3, (i5 & 512) == 0 ? i4 : -9999, (i5 & 1024) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound7, (i5 & 2048) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound8, (i5 & 4096) != 0 ? new GMCoachBound(0, 0, 3, null) : gMCoachBound9);
    }
}
