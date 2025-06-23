package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BGEMRangeAnalysis extends JsonFieldContainer {

    @OOXIXo
    private String end;
    private boolean fasting;
    private int nBit;

    @OOXIXo
    private BGEMPpg[] ppgData;

    @OOXIXo
    private String start;
    private boolean within2HrsMeal;

    public BGEMRangeAnalysis() {
        this(false, false, null, null, 0, null, 63, null);
    }

    public static /* synthetic */ BGEMRangeAnalysis copy$default(BGEMRangeAnalysis bGEMRangeAnalysis, boolean z, boolean z2, String str, String str2, int i, BGEMPpg[] bGEMPpgArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = bGEMRangeAnalysis.fasting;
        }
        if ((i2 & 2) != 0) {
            z2 = bGEMRangeAnalysis.within2HrsMeal;
        }
        boolean z3 = z2;
        if ((i2 & 4) != 0) {
            str = bGEMRangeAnalysis.start;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = bGEMRangeAnalysis.end;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            i = bGEMRangeAnalysis.nBit;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            bGEMPpgArr = bGEMRangeAnalysis.ppgData;
        }
        return bGEMRangeAnalysis.copy(z, z3, str3, str4, i3, bGEMPpgArr);
    }

    public final boolean component1() {
        return this.fasting;
    }

    public final boolean component2() {
        return this.within2HrsMeal;
    }

    @OOXIXo
    public final String component3() {
        return this.start;
    }

    @OOXIXo
    public final String component4() {
        return this.end;
    }

    public final int component5() {
        return this.nBit;
    }

    @OOXIXo
    public final BGEMPpg[] component6() {
        return this.ppgData;
    }

    @OOXIXo
    public final BGEMRangeAnalysis copy(boolean z, boolean z2, @OOXIXo String start, @OOXIXo String end, int i, @OOXIXo BGEMPpg[] ppgData) {
        IIX0o.x0xO0oo(start, "start");
        IIX0o.x0xO0oo(end, "end");
        IIX0o.x0xO0oo(ppgData, "ppgData");
        return new BGEMRangeAnalysis(z, z2, start, end, i, ppgData);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMRangeAnalysis)) {
            return false;
        }
        BGEMRangeAnalysis bGEMRangeAnalysis = (BGEMRangeAnalysis) obj;
        return this.fasting == bGEMRangeAnalysis.fasting && this.within2HrsMeal == bGEMRangeAnalysis.within2HrsMeal && IIX0o.Oxx0IOOO(this.start, bGEMRangeAnalysis.start) && IIX0o.Oxx0IOOO(this.end, bGEMRangeAnalysis.end) && this.nBit == bGEMRangeAnalysis.nBit && IIX0o.Oxx0IOOO(this.ppgData, bGEMRangeAnalysis.ppgData);
    }

    @OOXIXo
    public final String getEnd() {
        return this.end;
    }

    public final boolean getFasting() {
        return this.fasting;
    }

    public final int getNBit() {
        return this.nBit;
    }

    @OOXIXo
    public final BGEMPpg[] getPpgData() {
        return this.ppgData;
    }

    @OOXIXo
    public final String getStart() {
        return this.start;
    }

    public final boolean getWithin2HrsMeal() {
        return this.within2HrsMeal;
    }

    public int hashCode() {
        return (((((((((androidx.work.oIX0oI.oIX0oI(this.fasting) * 31) + androidx.work.oIX0oI.oIX0oI(this.within2HrsMeal)) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.nBit) * 31) + Arrays.hashCode(this.ppgData);
    }

    public final void setEnd(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.end = str;
    }

    public final void setFasting(boolean z) {
        this.fasting = z;
    }

    public final void setNBit(int i) {
        this.nBit = i;
    }

    public final void setPpgData(@OOXIXo BGEMPpg[] bGEMPpgArr) {
        IIX0o.x0xO0oo(bGEMPpgArr, "<set-?>");
        this.ppgData = bGEMPpgArr;
    }

    public final void setStart(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.start = str;
    }

    public final void setWithin2HrsMeal(boolean z) {
        this.within2HrsMeal = z;
    }

    @OOXIXo
    public String toString() {
        return "BGEMRangeAnalysis(fasting=" + this.fasting + ", within2HrsMeal=" + this.within2HrsMeal + ", start=" + this.start + ", end=" + this.end + ", nBit=" + this.nBit + ", ppgData=" + Arrays.toString(this.ppgData) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BGEMRangeAnalysis(boolean z, boolean z2, String str, String str2, int i, BGEMPpg[] bGEMPpgArr, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? new BGEMPpg[0] : bGEMPpgArr);
    }

    public BGEMRangeAnalysis(boolean z, boolean z2, @OOXIXo String start, @OOXIXo String end, int i, @OOXIXo BGEMPpg[] ppgData) {
        IIX0o.x0xO0oo(start, "start");
        IIX0o.x0xO0oo(end, "end");
        IIX0o.x0xO0oo(ppgData, "ppgData");
        this.fasting = z;
        this.within2HrsMeal = z2;
        this.start = start;
        this.end = end;
        this.nBit = i;
        this.ppgData = ppgData;
    }
}
