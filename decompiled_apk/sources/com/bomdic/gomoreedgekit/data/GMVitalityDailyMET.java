package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMVitalityDailyMET {

    @OOXIXo
    private final int[] dailyTargets;
    private final int errorCode;

    @OOXIXo
    private final String parameter;

    public GMVitalityDailyMET() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ GMVitalityDailyMET copy$default(GMVitalityDailyMET gMVitalityDailyMET, int i, int[] iArr, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gMVitalityDailyMET.errorCode;
        }
        if ((i2 & 2) != 0) {
            iArr = gMVitalityDailyMET.dailyTargets;
        }
        if ((i2 & 4) != 0) {
            str = gMVitalityDailyMET.parameter;
        }
        return gMVitalityDailyMET.copy(i, iArr, str);
    }

    public final int component1() {
        return this.errorCode;
    }

    @OOXIXo
    public final int[] component2() {
        return this.dailyTargets;
    }

    @OOXIXo
    public final String component3() {
        return this.parameter;
    }

    @OOXIXo
    public final GMVitalityDailyMET copy(int i, @OOXIXo int[] dailyTargets, @OOXIXo String parameter) {
        IIX0o.x0xO0oo(dailyTargets, "dailyTargets");
        IIX0o.x0xO0oo(parameter, "parameter");
        return new GMVitalityDailyMET(i, dailyTargets, parameter);
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
        if (!IIX0o.Oxx0IOOO(GMVitalityDailyMET.class, cls)) {
            return false;
        }
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type com.bomdic.gomoreedgekit.data.GMVitalityDailyMET");
        GMVitalityDailyMET gMVitalityDailyMET = (GMVitalityDailyMET) obj;
        if (this.errorCode == gMVitalityDailyMET.errorCode && Arrays.equals(this.dailyTargets, gMVitalityDailyMET.dailyTargets) && IIX0o.Oxx0IOOO(this.parameter, gMVitalityDailyMET.parameter)) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final int[] getDailyTargets() {
        return this.dailyTargets;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @OOXIXo
    public final String getParameter() {
        return this.parameter;
    }

    public final boolean hasError() {
        int i = this.errorCode;
        if (i < 0 && i != -2000) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.errorCode * 31) + Arrays.hashCode(this.dailyTargets)) * 31) + this.parameter.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "GMVitalityDailyMET(errorCode=" + this.errorCode + ", dailyTargets=" + Arrays.toString(this.dailyTargets) + ", parameter=" + this.parameter + oIX0oI.I0Io.f4095I0Io;
    }

    public GMVitalityDailyMET(int i, @OOXIXo int[] dailyTargets, @OOXIXo String parameter) {
        IIX0o.x0xO0oo(dailyTargets, "dailyTargets");
        IIX0o.x0xO0oo(parameter, "parameter");
        this.errorCode = i;
        this.dailyTargets = dailyTargets;
        this.parameter = parameter;
    }

    public /* synthetic */ GMVitalityDailyMET(int i, int[] iArr, String str, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new int[0] : iArr, (i2 & 4) != 0 ? "" : str);
    }
}
