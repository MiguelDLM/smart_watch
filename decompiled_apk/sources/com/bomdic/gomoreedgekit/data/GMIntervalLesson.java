package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import com.garmin.fit.OOxOOxIO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GMIntervalLesson {
    private final int coolDownSeconds;

    @OOXIXo
    private final GMCoachBound intenseHRBound;

    @OOXIXo
    private final GMCoachBound intenseRPEBound;
    private final int intenseSeconds;

    @OOXIXo
    private final GMCoachBound intenseSpeedBound;

    @OOXIXo
    private final GMCoachBound restHRBound;

    @OOXIXo
    private final GMCoachBound restRPEBound;
    private final int restSeconds;

    @OOXIXo
    private final GMCoachBound restSpeedBound;
    private final int sets;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownHRBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownRPEBound;

    @OOXIXo
    private final GMCoachBound warmUpCoolDownSpeedBound;
    private final int warmUpSeconds;

    public GMIntervalLesson() {
        this(0, 0, null, null, null, 0, null, null, null, 0, 0, null, null, null, OOxOOxIO.f12624oIX0oI, null);
    }

    public final int component1() {
        return this.sets;
    }

    public final int component10() {
        return this.warmUpSeconds;
    }

    public final int component11() {
        return this.coolDownSeconds;
    }

    @OOXIXo
    public final GMCoachBound component12() {
        return this.warmUpCoolDownSpeedBound;
    }

    @OOXIXo
    public final GMCoachBound component13() {
        return this.warmUpCoolDownHRBound;
    }

    @OOXIXo
    public final GMCoachBound component14() {
        return this.warmUpCoolDownRPEBound;
    }

    public final int component2() {
        return this.intenseSeconds;
    }

    @OOXIXo
    public final GMCoachBound component3() {
        return this.intenseSpeedBound;
    }

    @OOXIXo
    public final GMCoachBound component4() {
        return this.intenseHRBound;
    }

    @OOXIXo
    public final GMCoachBound component5() {
        return this.intenseRPEBound;
    }

    public final int component6() {
        return this.restSeconds;
    }

    @OOXIXo
    public final GMCoachBound component7() {
        return this.restSpeedBound;
    }

    @OOXIXo
    public final GMCoachBound component8() {
        return this.restHRBound;
    }

    @OOXIXo
    public final GMCoachBound component9() {
        return this.restRPEBound;
    }

    @OOXIXo
    public final GMIntervalLesson copy(int i, int i2, @OOXIXo GMCoachBound intenseSpeedBound, @OOXIXo GMCoachBound intenseHRBound, @OOXIXo GMCoachBound intenseRPEBound, int i3, @OOXIXo GMCoachBound restSpeedBound, @OOXIXo GMCoachBound restHRBound, @OOXIXo GMCoachBound restRPEBound, int i4, int i5, @OOXIXo GMCoachBound warmUpCoolDownSpeedBound, @OOXIXo GMCoachBound warmUpCoolDownHRBound, @OOXIXo GMCoachBound warmUpCoolDownRPEBound) {
        IIX0o.x0xO0oo(intenseSpeedBound, "intenseSpeedBound");
        IIX0o.x0xO0oo(intenseHRBound, "intenseHRBound");
        IIX0o.x0xO0oo(intenseRPEBound, "intenseRPEBound");
        IIX0o.x0xO0oo(restSpeedBound, "restSpeedBound");
        IIX0o.x0xO0oo(restHRBound, "restHRBound");
        IIX0o.x0xO0oo(restRPEBound, "restRPEBound");
        IIX0o.x0xO0oo(warmUpCoolDownSpeedBound, "warmUpCoolDownSpeedBound");
        IIX0o.x0xO0oo(warmUpCoolDownHRBound, "warmUpCoolDownHRBound");
        IIX0o.x0xO0oo(warmUpCoolDownRPEBound, "warmUpCoolDownRPEBound");
        return new GMIntervalLesson(i, i2, intenseSpeedBound, intenseHRBound, intenseRPEBound, i3, restSpeedBound, restHRBound, restRPEBound, i4, i5, warmUpCoolDownSpeedBound, warmUpCoolDownHRBound, warmUpCoolDownRPEBound);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMIntervalLesson)) {
            return false;
        }
        GMIntervalLesson gMIntervalLesson = (GMIntervalLesson) obj;
        return this.sets == gMIntervalLesson.sets && this.intenseSeconds == gMIntervalLesson.intenseSeconds && IIX0o.Oxx0IOOO(this.intenseSpeedBound, gMIntervalLesson.intenseSpeedBound) && IIX0o.Oxx0IOOO(this.intenseHRBound, gMIntervalLesson.intenseHRBound) && IIX0o.Oxx0IOOO(this.intenseRPEBound, gMIntervalLesson.intenseRPEBound) && this.restSeconds == gMIntervalLesson.restSeconds && IIX0o.Oxx0IOOO(this.restSpeedBound, gMIntervalLesson.restSpeedBound) && IIX0o.Oxx0IOOO(this.restHRBound, gMIntervalLesson.restHRBound) && IIX0o.Oxx0IOOO(this.restRPEBound, gMIntervalLesson.restRPEBound) && this.warmUpSeconds == gMIntervalLesson.warmUpSeconds && this.coolDownSeconds == gMIntervalLesson.coolDownSeconds && IIX0o.Oxx0IOOO(this.warmUpCoolDownSpeedBound, gMIntervalLesson.warmUpCoolDownSpeedBound) && IIX0o.Oxx0IOOO(this.warmUpCoolDownHRBound, gMIntervalLesson.warmUpCoolDownHRBound) && IIX0o.Oxx0IOOO(this.warmUpCoolDownRPEBound, gMIntervalLesson.warmUpCoolDownRPEBound);
    }

    public final int getCoolDownSeconds() {
        return this.coolDownSeconds;
    }

    @OOXIXo
    public final GMCoachBound getIntenseHRBound() {
        return this.intenseHRBound;
    }

    @OOXIXo
    public final GMCoachBound getIntenseRPEBound() {
        return this.intenseRPEBound;
    }

    public final int getIntenseSeconds() {
        return this.intenseSeconds;
    }

    @OOXIXo
    public final GMCoachBound getIntenseSpeedBound() {
        return this.intenseSpeedBound;
    }

    @OOXIXo
    public final GMCoachBound getRestHRBound() {
        return this.restHRBound;
    }

    @OOXIXo
    public final GMCoachBound getRestRPEBound() {
        return this.restRPEBound;
    }

    public final int getRestSeconds() {
        return this.restSeconds;
    }

    @OOXIXo
    public final GMCoachBound getRestSpeedBound() {
        return this.restSpeedBound;
    }

    public final int getSets() {
        return this.sets;
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
        return (((((((((((((((((((((((((this.sets * 31) + this.intenseSeconds) * 31) + this.intenseSpeedBound.hashCode()) * 31) + this.intenseHRBound.hashCode()) * 31) + this.intenseRPEBound.hashCode()) * 31) + this.restSeconds) * 31) + this.restSpeedBound.hashCode()) * 31) + this.restHRBound.hashCode()) * 31) + this.restRPEBound.hashCode()) * 31) + this.warmUpSeconds) * 31) + this.coolDownSeconds) * 31) + this.warmUpCoolDownSpeedBound.hashCode()) * 31) + this.warmUpCoolDownHRBound.hashCode()) * 31) + this.warmUpCoolDownRPEBound.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMIntervalLesson(sets=" + this.sets + ", intenseSeconds=" + this.intenseSeconds + ", intenseSpeedBound=" + this.intenseSpeedBound + ", intenseHRBound=" + this.intenseHRBound + ", intenseRPEBound=" + this.intenseRPEBound + ", restSeconds=" + this.restSeconds + ", restSpeedBound=" + this.restSpeedBound + ", restHRBound=" + this.restHRBound + ", restRPEBound=" + this.restRPEBound + ", warmUpSeconds=" + this.warmUpSeconds + ", coolDownSeconds=" + this.coolDownSeconds + ", warmUpCoolDownSpeedBound=" + this.warmUpCoolDownSpeedBound + ", warmUpCoolDownHRBound=" + this.warmUpCoolDownHRBound + ", warmUpCoolDownRPEBound=" + this.warmUpCoolDownRPEBound + oIX0oI.I0Io.f4095I0Io;
    }

    public GMIntervalLesson(int i, int i2, @OOXIXo GMCoachBound intenseSpeedBound, @OOXIXo GMCoachBound intenseHRBound, @OOXIXo GMCoachBound intenseRPEBound, int i3, @OOXIXo GMCoachBound restSpeedBound, @OOXIXo GMCoachBound restHRBound, @OOXIXo GMCoachBound restRPEBound, int i4, int i5, @OOXIXo GMCoachBound warmUpCoolDownSpeedBound, @OOXIXo GMCoachBound warmUpCoolDownHRBound, @OOXIXo GMCoachBound warmUpCoolDownRPEBound) {
        IIX0o.x0xO0oo(intenseSpeedBound, "intenseSpeedBound");
        IIX0o.x0xO0oo(intenseHRBound, "intenseHRBound");
        IIX0o.x0xO0oo(intenseRPEBound, "intenseRPEBound");
        IIX0o.x0xO0oo(restSpeedBound, "restSpeedBound");
        IIX0o.x0xO0oo(restHRBound, "restHRBound");
        IIX0o.x0xO0oo(restRPEBound, "restRPEBound");
        IIX0o.x0xO0oo(warmUpCoolDownSpeedBound, "warmUpCoolDownSpeedBound");
        IIX0o.x0xO0oo(warmUpCoolDownHRBound, "warmUpCoolDownHRBound");
        IIX0o.x0xO0oo(warmUpCoolDownRPEBound, "warmUpCoolDownRPEBound");
        this.sets = i;
        this.intenseSeconds = i2;
        this.intenseSpeedBound = intenseSpeedBound;
        this.intenseHRBound = intenseHRBound;
        this.intenseRPEBound = intenseRPEBound;
        this.restSeconds = i3;
        this.restSpeedBound = restSpeedBound;
        this.restHRBound = restHRBound;
        this.restRPEBound = restRPEBound;
        this.warmUpSeconds = i4;
        this.coolDownSeconds = i5;
        this.warmUpCoolDownSpeedBound = warmUpCoolDownSpeedBound;
        this.warmUpCoolDownHRBound = warmUpCoolDownHRBound;
        this.warmUpCoolDownRPEBound = warmUpCoolDownRPEBound;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ GMIntervalLesson(int r17, int r18, com.bomdic.gomoreedgekit.data.GMCoachBound r19, com.bomdic.gomoreedgekit.data.GMCoachBound r20, com.bomdic.gomoreedgekit.data.GMCoachBound r21, int r22, com.bomdic.gomoreedgekit.data.GMCoachBound r23, com.bomdic.gomoreedgekit.data.GMCoachBound r24, com.bomdic.gomoreedgekit.data.GMCoachBound r25, int r26, int r27, com.bomdic.gomoreedgekit.data.GMCoachBound r28, com.bomdic.gomoreedgekit.data.GMCoachBound r29, com.bomdic.gomoreedgekit.data.GMCoachBound r30, int r31, kotlin.jvm.internal.IIXOooo r32) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bomdic.gomoreedgekit.data.GMIntervalLesson.<init>(int, int, com.bomdic.gomoreedgekit.data.GMCoachBound, com.bomdic.gomoreedgekit.data.GMCoachBound, com.bomdic.gomoreedgekit.data.GMCoachBound, int, com.bomdic.gomoreedgekit.data.GMCoachBound, com.bomdic.gomoreedgekit.data.GMCoachBound, com.bomdic.gomoreedgekit.data.GMCoachBound, int, int, com.bomdic.gomoreedgekit.data.GMCoachBound, com.bomdic.gomoreedgekit.data.GMCoachBound, com.bomdic.gomoreedgekit.data.GMCoachBound, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
