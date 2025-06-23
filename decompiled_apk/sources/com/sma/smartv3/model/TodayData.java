package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class TodayData {

    @OOXIXo
    private final String dataType;

    @OOXIXo
    private String mExtraInfo;
    private final int onClickID;

    @OOXIXo
    private final String state;
    private final int stateColor;
    private final long time;

    @OOXIXo
    private final String title;

    @OOXIXo
    private final String value;
    private final float value1;
    private final float value2;

    public TodayData() {
        this(0L, null, null, null, 0, null, 0, null, 0.0f, 0.0f, 1023, null);
    }

    public final long component1() {
        return this.time;
    }

    public final float component10() {
        return this.value2;
    }

    @OOXIXo
    public final String component2() {
        return this.title;
    }

    @OOXIXo
    public final String component3() {
        return this.value;
    }

    @OOXIXo
    public final String component4() {
        return this.state;
    }

    public final int component5() {
        return this.stateColor;
    }

    @OOXIXo
    public final String component6() {
        return this.dataType;
    }

    public final int component7() {
        return this.onClickID;
    }

    @OOXIXo
    public final String component8() {
        return this.mExtraInfo;
    }

    public final float component9() {
        return this.value1;
    }

    @OOXIXo
    public final TodayData copy(long j, @OOXIXo String title, @OOXIXo String value, @OOXIXo String state, int i, @OOXIXo String dataType, int i2, @OOXIXo String mExtraInfo, float f, float f2) {
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(value, "value");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(dataType, "dataType");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        return new TodayData(j, title, value, state, i, dataType, i2, mExtraInfo, f, f2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TodayData)) {
            return false;
        }
        TodayData todayData = (TodayData) obj;
        return this.time == todayData.time && IIX0o.Oxx0IOOO(this.title, todayData.title) && IIX0o.Oxx0IOOO(this.value, todayData.value) && IIX0o.Oxx0IOOO(this.state, todayData.state) && this.stateColor == todayData.stateColor && IIX0o.Oxx0IOOO(this.dataType, todayData.dataType) && this.onClickID == todayData.onClickID && IIX0o.Oxx0IOOO(this.mExtraInfo, todayData.mExtraInfo) && Float.compare(this.value1, todayData.value1) == 0 && Float.compare(this.value2, todayData.value2) == 0;
    }

    @OOXIXo
    public final String getDataType() {
        return this.dataType;
    }

    @OOXIXo
    public final String getMExtraInfo() {
        return this.mExtraInfo;
    }

    public final int getOnClickID() {
        return this.onClickID;
    }

    @OOXIXo
    public final String getState() {
        return this.state;
    }

    public final int getStateColor() {
        return this.stateColor;
    }

    public final long getTime() {
        return this.time;
    }

    @OOXIXo
    public final String getTitle() {
        return this.title;
    }

    @OOXIXo
    public final String getValue() {
        return this.value;
    }

    public final float getValue1() {
        return this.value1;
    }

    public final float getValue2() {
        return this.value2;
    }

    public int hashCode() {
        return (((((((((((((((((androidx.collection.oIX0oI.oIX0oI(this.time) * 31) + this.title.hashCode()) * 31) + this.value.hashCode()) * 31) + this.state.hashCode()) * 31) + this.stateColor) * 31) + this.dataType.hashCode()) * 31) + this.onClickID) * 31) + this.mExtraInfo.hashCode()) * 31) + Float.floatToIntBits(this.value1)) * 31) + Float.floatToIntBits(this.value2);
    }

    public final void setMExtraInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mExtraInfo = str;
    }

    @OOXIXo
    public String toString() {
        return "TodayData(time=" + this.time + ", title=" + this.title + ", value=" + this.value + ", state=" + this.state + ", stateColor=" + this.stateColor + ", dataType=" + this.dataType + ", onClickID=" + this.onClickID + ", mExtraInfo=" + this.mExtraInfo + ", value1=" + this.value1 + ", value2=" + this.value2 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public TodayData(long j, @OOXIXo String title, @OOXIXo String value, @OOXIXo String state, int i, @OOXIXo String dataType, int i2, @OOXIXo String mExtraInfo, float f, float f2) {
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(value, "value");
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(dataType, "dataType");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        this.time = j;
        this.title = title;
        this.value = value;
        this.state = state;
        this.stateColor = i;
        this.dataType = dataType;
        this.onClickID = i2;
        this.mExtraInfo = mExtraInfo;
        this.value1 = f;
        this.value2 = f2;
    }

    public /* synthetic */ TodayData(long j, String str, String str2, String str3, int i, String str4, int i2, String str5, float f, float f2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? "" : str4, (i3 & 64) == 0 ? i2 : 0, (i3 & 128) == 0 ? str5 : "", (i3 & 256) != 0 ? 0.0f : f, (i3 & 512) == 0 ? f2 : 0.0f);
    }
}
