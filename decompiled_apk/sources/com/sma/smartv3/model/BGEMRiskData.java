package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BGEMRiskData extends JsonFieldContainer {
    private int current_level;

    @OOXIXo
    private String end_time;

    @OOXIXo
    private String insights;

    @OOXIXo
    private Object locale_insights;

    @OOXIXo
    private Object locale_tips;

    @OOXIXo
    private String measurement_id;

    @OOXIXo
    private String risk_code;

    @OOXIXo
    private String start_time;

    @OOXIXo
    private String[] tips;

    public BGEMRiskData() {
        this(0, null, null, null, null, null, null, null, null, 511, null);
    }

    public final int component1() {
        return this.current_level;
    }

    @OOXIXo
    public final String component2() {
        return this.risk_code;
    }

    @OOXIXo
    public final String component3() {
        return this.insights;
    }

    @OOXIXo
    public final String[] component4() {
        return this.tips;
    }

    @OOXIXo
    public final Object component5() {
        return this.locale_insights;
    }

    @OOXIXo
    public final Object component6() {
        return this.locale_tips;
    }

    @OOXIXo
    public final String component7() {
        return this.measurement_id;
    }

    @OOXIXo
    public final String component8() {
        return this.start_time;
    }

    @OOXIXo
    public final String component9() {
        return this.end_time;
    }

    @OOXIXo
    public final BGEMRiskData copy(int i, @OOXIXo String risk_code, @OOXIXo String insights, @OOXIXo String[] tips, @OOXIXo Object locale_insights, @OOXIXo Object locale_tips, @OOXIXo String measurement_id, @OOXIXo String start_time, @OOXIXo String end_time) {
        IIX0o.x0xO0oo(risk_code, "risk_code");
        IIX0o.x0xO0oo(insights, "insights");
        IIX0o.x0xO0oo(tips, "tips");
        IIX0o.x0xO0oo(locale_insights, "locale_insights");
        IIX0o.x0xO0oo(locale_tips, "locale_tips");
        IIX0o.x0xO0oo(measurement_id, "measurement_id");
        IIX0o.x0xO0oo(start_time, "start_time");
        IIX0o.x0xO0oo(end_time, "end_time");
        return new BGEMRiskData(i, risk_code, insights, tips, locale_insights, locale_tips, measurement_id, start_time, end_time);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMRiskData)) {
            return false;
        }
        BGEMRiskData bGEMRiskData = (BGEMRiskData) obj;
        return this.current_level == bGEMRiskData.current_level && IIX0o.Oxx0IOOO(this.risk_code, bGEMRiskData.risk_code) && IIX0o.Oxx0IOOO(this.insights, bGEMRiskData.insights) && IIX0o.Oxx0IOOO(this.tips, bGEMRiskData.tips) && IIX0o.Oxx0IOOO(this.locale_insights, bGEMRiskData.locale_insights) && IIX0o.Oxx0IOOO(this.locale_tips, bGEMRiskData.locale_tips) && IIX0o.Oxx0IOOO(this.measurement_id, bGEMRiskData.measurement_id) && IIX0o.Oxx0IOOO(this.start_time, bGEMRiskData.start_time) && IIX0o.Oxx0IOOO(this.end_time, bGEMRiskData.end_time);
    }

    public final int getCurrent_level() {
        return this.current_level;
    }

    @OOXIXo
    public final String getEnd_time() {
        return this.end_time;
    }

    @OOXIXo
    public final String getInsights() {
        return this.insights;
    }

    @OOXIXo
    public final Object getLocale_insights() {
        return this.locale_insights;
    }

    @OOXIXo
    public final Object getLocale_tips() {
        return this.locale_tips;
    }

    @OOXIXo
    public final String getMeasurement_id() {
        return this.measurement_id;
    }

    @OOXIXo
    public final String getRisk_code() {
        return this.risk_code;
    }

    @OOXIXo
    public final String getStart_time() {
        return this.start_time;
    }

    @OOXIXo
    public final String[] getTips() {
        return this.tips;
    }

    public int hashCode() {
        return (((((((((((((((this.current_level * 31) + this.risk_code.hashCode()) * 31) + this.insights.hashCode()) * 31) + Arrays.hashCode(this.tips)) * 31) + this.locale_insights.hashCode()) * 31) + this.locale_tips.hashCode()) * 31) + this.measurement_id.hashCode()) * 31) + this.start_time.hashCode()) * 31) + this.end_time.hashCode();
    }

    public final void setCurrent_level(int i) {
        this.current_level = i;
    }

    public final void setEnd_time(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.end_time = str;
    }

    public final void setInsights(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.insights = str;
    }

    public final void setLocale_insights(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<set-?>");
        this.locale_insights = obj;
    }

    public final void setLocale_tips(@OOXIXo Object obj) {
        IIX0o.x0xO0oo(obj, "<set-?>");
        this.locale_tips = obj;
    }

    public final void setMeasurement_id(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.measurement_id = str;
    }

    public final void setRisk_code(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.risk_code = str;
    }

    public final void setStart_time(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.start_time = str;
    }

    public final void setTips(@OOXIXo String[] strArr) {
        IIX0o.x0xO0oo(strArr, "<set-?>");
        this.tips = strArr;
    }

    @OOXIXo
    public String toString() {
        return "BGEMRiskData(current_level=" + this.current_level + ", risk_code=" + this.risk_code + ", insights=" + this.insights + ", tips=" + Arrays.toString(this.tips) + ", locale_insights=" + this.locale_insights + ", locale_tips=" + this.locale_tips + ", measurement_id=" + this.measurement_id + ", start_time=" + this.start_time + ", end_time=" + this.end_time + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BGEMRiskData(int i, String str, String str2, String[] strArr, Object obj, Object obj2, String str3, String str4, String str5, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? new String[0] : strArr, (i2 & 16) != 0 ? new Object() : obj, (i2 & 32) != 0 ? new Object() : obj2, (i2 & 64) != 0 ? "" : str3, (i2 & 128) != 0 ? "" : str4, (i2 & 256) == 0 ? str5 : "");
    }

    public BGEMRiskData(int i, @OOXIXo String risk_code, @OOXIXo String insights, @OOXIXo String[] tips, @OOXIXo Object locale_insights, @OOXIXo Object locale_tips, @OOXIXo String measurement_id, @OOXIXo String start_time, @OOXIXo String end_time) {
        IIX0o.x0xO0oo(risk_code, "risk_code");
        IIX0o.x0xO0oo(insights, "insights");
        IIX0o.x0xO0oo(tips, "tips");
        IIX0o.x0xO0oo(locale_insights, "locale_insights");
        IIX0o.x0xO0oo(locale_tips, "locale_tips");
        IIX0o.x0xO0oo(measurement_id, "measurement_id");
        IIX0o.x0xO0oo(start_time, "start_time");
        IIX0o.x0xO0oo(end_time, "end_time");
        this.current_level = i;
        this.risk_code = risk_code;
        this.insights = insights;
        this.tips = tips;
        this.locale_insights = locale_insights;
        this.locale_tips = locale_tips;
        this.measurement_id = measurement_id;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
