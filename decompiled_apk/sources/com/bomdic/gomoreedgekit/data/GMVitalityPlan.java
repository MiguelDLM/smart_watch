package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMVitalityPlan {
    private final int errorCode;
    private final int level;

    @OOXIXo
    private final String parameter;
    private final int planStatus;
    private final float planTarget;
    private final int vitalityIndex;
    private final int weekStatus;

    @OOXIXo
    private final int[] weeklyTargets;

    public GMVitalityPlan() {
        this(0, null, 0.0f, 0, 0, 0, null, 0, 255, null);
    }

    public final int component1() {
        return this.errorCode;
    }

    @OOXIXo
    public final int[] component2() {
        return this.weeklyTargets;
    }

    public final float component3() {
        return this.planTarget;
    }

    public final int component4() {
        return this.level;
    }

    public final int component5() {
        return this.weekStatus;
    }

    public final int component6() {
        return this.planStatus;
    }

    @OOXIXo
    public final String component7() {
        return this.parameter;
    }

    public final int component8() {
        return this.vitalityIndex;
    }

    @OOXIXo
    public final GMVitalityPlan copy(int i, @OOXIXo int[] weeklyTargets, float f, int i2, int i3, int i4, @OOXIXo String parameter, int i5) {
        IIX0o.x0xO0oo(weeklyTargets, "weeklyTargets");
        IIX0o.x0xO0oo(parameter, "parameter");
        return new GMVitalityPlan(i, weeklyTargets, f, i2, i3, i4, parameter, i5);
    }

    public boolean equals(@oOoXoXO Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!IIX0o.Oxx0IOOO(GMVitalityPlan.class, cls)) {
            return false;
        }
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type com.bomdic.gomoreedgekit.data.GMVitalityPlan");
        GMVitalityPlan gMVitalityPlan = (GMVitalityPlan) obj;
        if (this.errorCode == gMVitalityPlan.errorCode && Arrays.equals(this.weeklyTargets, gMVitalityPlan.weeklyTargets) && this.planTarget == gMVitalityPlan.planTarget && this.level == gMVitalityPlan.level && this.weekStatus == gMVitalityPlan.weekStatus && this.planStatus == gMVitalityPlan.planStatus && IIX0o.Oxx0IOOO(this.parameter, gMVitalityPlan.parameter) && this.vitalityIndex == gMVitalityPlan.vitalityIndex) {
            return true;
        }
        return false;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getLevel() {
        return this.level;
    }

    @OOXIXo
    public final String getParameter() {
        return this.parameter;
    }

    public final int getPlanStatus() {
        return this.planStatus;
    }

    public final float getPlanTarget() {
        return this.planTarget;
    }

    public final int getVitalityIndex() {
        return this.vitalityIndex;
    }

    public final int getWeekStatus() {
        return this.weekStatus;
    }

    @OOXIXo
    public final int[] getWeeklyTargets() {
        return this.weeklyTargets;
    }

    public int hashCode() {
        return (((((((((((((this.errorCode * 31) + Arrays.hashCode(this.weeklyTargets)) * 31) + Float.floatToIntBits(this.planTarget)) * 31) + this.level) * 31) + this.weekStatus) * 31) + this.planStatus) * 31) + this.parameter.hashCode()) * 31) + this.vitalityIndex;
    }

    @OOXIXo
    public String toString() {
        return "GMVitalityPlan(errorCode=" + this.errorCode + ", weeklyTargets=" + Arrays.toString(this.weeklyTargets) + ", planTarget=" + this.planTarget + ", level=" + this.level + ", weekStatus=" + this.weekStatus + ", planStatus=" + this.planStatus + ", parameter=" + this.parameter + ", vitalityIndex=" + this.vitalityIndex + oIX0oI.I0Io.f4095I0Io;
    }

    public GMVitalityPlan(int i, @OOXIXo int[] weeklyTargets, float f, int i2, int i3, int i4, @OOXIXo String parameter, int i5) {
        IIX0o.x0xO0oo(weeklyTargets, "weeklyTargets");
        IIX0o.x0xO0oo(parameter, "parameter");
        this.errorCode = i;
        this.weeklyTargets = weeklyTargets;
        this.planTarget = f;
        this.level = i2;
        this.weekStatus = i3;
        this.planStatus = i4;
        this.parameter = parameter;
        this.vitalityIndex = i5;
    }

    public /* synthetic */ GMVitalityPlan(int i, int[] iArr, float f, int i2, int i3, int i4, String str, int i5, int i6, IIXOooo iIXOooo) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? new int[0] : iArr, (i6 & 4) != 0 ? -9999.0f : f, (i6 & 8) != 0 ? -9999 : i2, (i6 & 16) != 0 ? -9999 : i3, (i6 & 32) != 0 ? -9999 : i4, (i6 & 64) != 0 ? "" : str, (i6 & 128) == 0 ? i5 : -9999);
    }
}
