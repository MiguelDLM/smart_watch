package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class HeathItemReports {

    @OOXIXo
    private String aiExtraInfo;

    @OOXIXo
    private final String dataType;
    private int number;
    private long time;

    public HeathItemReports() {
        this(0L, null, 0, null, 15, null);
    }

    public static /* synthetic */ HeathItemReports copy$default(HeathItemReports heathItemReports, long j, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = heathItemReports.time;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = heathItemReports.dataType;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            i = heathItemReports.number;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = heathItemReports.aiExtraInfo;
        }
        return heathItemReports.copy(j2, str3, i3, str2);
    }

    public final long component1() {
        return this.time;
    }

    @OOXIXo
    public final String component2() {
        return this.dataType;
    }

    public final int component3() {
        return this.number;
    }

    @OOXIXo
    public final String component4() {
        return this.aiExtraInfo;
    }

    @OOXIXo
    public final HeathItemReports copy(long j, @OOXIXo String dataType, int i, @OOXIXo String aiExtraInfo) {
        IIX0o.x0xO0oo(dataType, "dataType");
        IIX0o.x0xO0oo(aiExtraInfo, "aiExtraInfo");
        return new HeathItemReports(j, dataType, i, aiExtraInfo);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeathItemReports)) {
            return false;
        }
        HeathItemReports heathItemReports = (HeathItemReports) obj;
        return this.time == heathItemReports.time && IIX0o.Oxx0IOOO(this.dataType, heathItemReports.dataType) && this.number == heathItemReports.number && IIX0o.Oxx0IOOO(this.aiExtraInfo, heathItemReports.aiExtraInfo);
    }

    @OOXIXo
    public final String getAiExtraInfo() {
        return this.aiExtraInfo;
    }

    @OOXIXo
    public final String getDataType() {
        return this.dataType;
    }

    public final int getNumber() {
        return this.number;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((androidx.collection.oIX0oI.oIX0oI(this.time) * 31) + this.dataType.hashCode()) * 31) + this.number) * 31) + this.aiExtraInfo.hashCode();
    }

    public final void setAiExtraInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.aiExtraInfo = str;
    }

    public final void setNumber(int i) {
        this.number = i;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    @OOXIXo
    public String toString() {
        return "HeathItemReports(time=" + this.time + ", dataType=" + this.dataType + ", number=" + this.number + ", aiExtraInfo=" + this.aiExtraInfo + HexStringBuilder.COMMENT_END_CHAR;
    }

    public HeathItemReports(long j, @OOXIXo String dataType, int i, @OOXIXo String aiExtraInfo) {
        IIX0o.x0xO0oo(dataType, "dataType");
        IIX0o.x0xO0oo(aiExtraInfo, "aiExtraInfo");
        this.time = j;
        this.dataType = dataType;
        this.number = i;
        this.aiExtraInfo = aiExtraInfo;
    }

    public /* synthetic */ HeathItemReports(long j, String str, int i, String str2, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str2);
    }
}
