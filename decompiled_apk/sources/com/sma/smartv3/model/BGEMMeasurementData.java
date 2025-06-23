package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BGEMMeasurementData extends JsonFieldContainer {
    private boolean completed_progress;

    @OOXIXo
    private String created_at;

    @OOXIXo
    private String end_time;
    private boolean fasting;
    private double lower_bound;

    @OOXIXo
    private String measurement_id;

    @OOXIXo
    private String model_no;

    @OOXIXo
    private String start_time;
    private double upper_bound;

    @OOXIXo
    private String user_id;
    private boolean within_2hrs_meal;

    public BGEMMeasurementData() {
        this(null, null, null, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, false, false, false, null, 2047, null);
    }

    @OOXIXo
    public final String component1() {
        return this.measurement_id;
    }

    public final boolean component10() {
        return this.completed_progress;
    }

    @OOXIXo
    public final String component11() {
        return this.created_at;
    }

    @OOXIXo
    public final String component2() {
        return this.user_id;
    }

    @OOXIXo
    public final String component3() {
        return this.start_time;
    }

    @OOXIXo
    public final String component4() {
        return this.end_time;
    }

    @OOXIXo
    public final String component5() {
        return this.model_no;
    }

    public final double component6() {
        return this.lower_bound;
    }

    public final double component7() {
        return this.upper_bound;
    }

    public final boolean component8() {
        return this.fasting;
    }

    public final boolean component9() {
        return this.within_2hrs_meal;
    }

    @OOXIXo
    public final BGEMMeasurementData copy(@OOXIXo String measurement_id, @OOXIXo String user_id, @OOXIXo String start_time, @OOXIXo String end_time, @OOXIXo String model_no, double d, double d2, boolean z, boolean z2, boolean z3, @OOXIXo String created_at) {
        IIX0o.x0xO0oo(measurement_id, "measurement_id");
        IIX0o.x0xO0oo(user_id, "user_id");
        IIX0o.x0xO0oo(start_time, "start_time");
        IIX0o.x0xO0oo(end_time, "end_time");
        IIX0o.x0xO0oo(model_no, "model_no");
        IIX0o.x0xO0oo(created_at, "created_at");
        return new BGEMMeasurementData(measurement_id, user_id, start_time, end_time, model_no, d, d2, z, z2, z3, created_at);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMMeasurementData)) {
            return false;
        }
        BGEMMeasurementData bGEMMeasurementData = (BGEMMeasurementData) obj;
        return IIX0o.Oxx0IOOO(this.measurement_id, bGEMMeasurementData.measurement_id) && IIX0o.Oxx0IOOO(this.user_id, bGEMMeasurementData.user_id) && IIX0o.Oxx0IOOO(this.start_time, bGEMMeasurementData.start_time) && IIX0o.Oxx0IOOO(this.end_time, bGEMMeasurementData.end_time) && IIX0o.Oxx0IOOO(this.model_no, bGEMMeasurementData.model_no) && Double.compare(this.lower_bound, bGEMMeasurementData.lower_bound) == 0 && Double.compare(this.upper_bound, bGEMMeasurementData.upper_bound) == 0 && this.fasting == bGEMMeasurementData.fasting && this.within_2hrs_meal == bGEMMeasurementData.within_2hrs_meal && this.completed_progress == bGEMMeasurementData.completed_progress && IIX0o.Oxx0IOOO(this.created_at, bGEMMeasurementData.created_at);
    }

    public final boolean getCompleted_progress() {
        return this.completed_progress;
    }

    @OOXIXo
    public final String getCreated_at() {
        return this.created_at;
    }

    @OOXIXo
    public final String getEnd_time() {
        return this.end_time;
    }

    public final boolean getFasting() {
        return this.fasting;
    }

    public final double getLower_bound() {
        return this.lower_bound;
    }

    @OOXIXo
    public final String getMeasurement_id() {
        return this.measurement_id;
    }

    @OOXIXo
    public final String getModel_no() {
        return this.model_no;
    }

    @OOXIXo
    public final String getStart_time() {
        return this.start_time;
    }

    public final double getUpper_bound() {
        return this.upper_bound;
    }

    @OOXIXo
    public final String getUser_id() {
        return this.user_id;
    }

    public final boolean getWithin_2hrs_meal() {
        return this.within_2hrs_meal;
    }

    public int hashCode() {
        return (((((((((((((((((((this.measurement_id.hashCode() * 31) + this.user_id.hashCode()) * 31) + this.start_time.hashCode()) * 31) + this.end_time.hashCode()) * 31) + this.model_no.hashCode()) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.lower_bound)) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.upper_bound)) * 31) + androidx.work.oIX0oI.oIX0oI(this.fasting)) * 31) + androidx.work.oIX0oI.oIX0oI(this.within_2hrs_meal)) * 31) + androidx.work.oIX0oI.oIX0oI(this.completed_progress)) * 31) + this.created_at.hashCode();
    }

    public final void setCompleted_progress(boolean z) {
        this.completed_progress = z;
    }

    public final void setCreated_at(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.created_at = str;
    }

    public final void setEnd_time(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.end_time = str;
    }

    public final void setFasting(boolean z) {
        this.fasting = z;
    }

    public final void setLower_bound(double d) {
        this.lower_bound = d;
    }

    public final void setMeasurement_id(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.measurement_id = str;
    }

    public final void setModel_no(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.model_no = str;
    }

    public final void setStart_time(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.start_time = str;
    }

    public final void setUpper_bound(double d) {
        this.upper_bound = d;
    }

    public final void setUser_id(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.user_id = str;
    }

    public final void setWithin_2hrs_meal(boolean z) {
        this.within_2hrs_meal = z;
    }

    @OOXIXo
    public String toString() {
        return "BGEMMeasurementData(measurement_id=" + this.measurement_id + ", user_id=" + this.user_id + ", start_time=" + this.start_time + ", end_time=" + this.end_time + ", model_no=" + this.model_no + ", lower_bound=" + this.lower_bound + ", upper_bound=" + this.upper_bound + ", fasting=" + this.fasting + ", within_2hrs_meal=" + this.within_2hrs_meal + ", completed_progress=" + this.completed_progress + ", created_at=" + this.created_at + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BGEMMeasurementData(String str, String str2, String str3, String str4, String str5, double d, double d2, boolean z, boolean z2, boolean z3, String str6, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? 0.0d : d, (i & 64) == 0 ? d2 : XIXIX.OOXIXo.f3760XO, (i & 128) != 0 ? false : z, (i & 256) != 0 ? false : z2, (i & 512) == 0 ? z3 : false, (i & 1024) == 0 ? str6 : "");
    }

    public BGEMMeasurementData(@OOXIXo String measurement_id, @OOXIXo String user_id, @OOXIXo String start_time, @OOXIXo String end_time, @OOXIXo String model_no, double d, double d2, boolean z, boolean z2, boolean z3, @OOXIXo String created_at) {
        IIX0o.x0xO0oo(measurement_id, "measurement_id");
        IIX0o.x0xO0oo(user_id, "user_id");
        IIX0o.x0xO0oo(start_time, "start_time");
        IIX0o.x0xO0oo(end_time, "end_time");
        IIX0o.x0xO0oo(model_no, "model_no");
        IIX0o.x0xO0oo(created_at, "created_at");
        this.measurement_id = measurement_id;
        this.user_id = user_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.model_no = model_no;
        this.lower_bound = d;
        this.upper_bound = d2;
        this.fasting = z;
        this.within_2hrs_meal = z2;
        this.completed_progress = z3;
        this.created_at = created_at;
    }
}
