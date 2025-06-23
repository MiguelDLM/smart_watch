package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.gson.Gson;
import com.sma.smartv3.db.entity.BloodGlucose2;
import com.sma.smartv3.util.xoIox;
import java.text.SimpleDateFormat;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import oOXoIIIo.I0Io;

/* loaded from: classes12.dex */
public final class BGEMRangeAnalysisResult extends JsonFieldContainer {

    @oOoXoXO
    private BGEMMeasurementData measurementData;

    @oOoXoXO
    private BGEMRiskData riskData;

    /* JADX WARN: Multi-variable type inference failed */
    public BGEMRangeAnalysisResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BGEMRangeAnalysisResult copy$default(BGEMRangeAnalysisResult bGEMRangeAnalysisResult, BGEMRiskData bGEMRiskData, BGEMMeasurementData bGEMMeasurementData, int i, Object obj) {
        if ((i & 1) != 0) {
            bGEMRiskData = bGEMRangeAnalysisResult.riskData;
        }
        if ((i & 2) != 0) {
            bGEMMeasurementData = bGEMRangeAnalysisResult.measurementData;
        }
        return bGEMRangeAnalysisResult.copy(bGEMRiskData, bGEMMeasurementData);
    }

    @oOoXoXO
    public final BGEMRiskData component1() {
        return this.riskData;
    }

    @oOoXoXO
    public final BGEMMeasurementData component2() {
        return this.measurementData;
    }

    @OOXIXo
    public final BGEMRangeAnalysisResult copy(@oOoXoXO BGEMRiskData bGEMRiskData, @oOoXoXO BGEMMeasurementData bGEMMeasurementData) {
        return new BGEMRangeAnalysisResult(bGEMRiskData, bGEMMeasurementData);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BGEMRangeAnalysisResult)) {
            return false;
        }
        BGEMRangeAnalysisResult bGEMRangeAnalysisResult = (BGEMRangeAnalysisResult) obj;
        return IIX0o.Oxx0IOOO(this.riskData, bGEMRangeAnalysisResult.riskData) && IIX0o.Oxx0IOOO(this.measurementData, bGEMRangeAnalysisResult.measurementData);
    }

    @oOoXoXO
    public final BGEMMeasurementData getMeasurementData() {
        return this.measurementData;
    }

    @oOoXoXO
    public final BGEMRiskData getRiskData() {
        return this.riskData;
    }

    public int hashCode() {
        BGEMRiskData bGEMRiskData = this.riskData;
        int hashCode = (bGEMRiskData == null ? 0 : bGEMRiskData.hashCode()) * 31;
        BGEMMeasurementData bGEMMeasurementData = this.measurementData;
        return hashCode + (bGEMMeasurementData != null ? bGEMMeasurementData.hashCode() : 0);
    }

    public final void setMeasurementData(@oOoXoXO BGEMMeasurementData bGEMMeasurementData) {
        this.measurementData = bGEMMeasurementData;
    }

    public final void setRiskData(@oOoXoXO BGEMRiskData bGEMRiskData) {
        this.riskData = bGEMRiskData;
    }

    @oOoXoXO
    public final BloodGlucose2 toBloodGlucose2() {
        if (this.measurementData != null && this.riskData != null) {
            try {
                SimpleDateFormat OO0x0xX2 = xoIox.OO0x0xX();
                BGEMMeasurementData bGEMMeasurementData = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData);
                long time = OO0x0xX2.parse(bGEMMeasurementData.getEnd_time()).getTime();
                BGEMMeasurementData bGEMMeasurementData2 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData2);
                String measurement_id = bGEMMeasurementData2.getMeasurement_id();
                BGEMMeasurementData bGEMMeasurementData3 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData3);
                String user_id = bGEMMeasurementData3.getUser_id();
                BGEMMeasurementData bGEMMeasurementData4 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData4);
                String start_time = bGEMMeasurementData4.getStart_time();
                BGEMMeasurementData bGEMMeasurementData5 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData5);
                String end_time = bGEMMeasurementData5.getEnd_time();
                BGEMMeasurementData bGEMMeasurementData6 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData6);
                String model_no = bGEMMeasurementData6.getModel_no();
                BGEMMeasurementData bGEMMeasurementData7 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData7);
                double lower_bound = bGEMMeasurementData7.getLower_bound();
                BGEMMeasurementData bGEMMeasurementData8 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData8);
                double upper_bound = bGEMMeasurementData8.getUpper_bound();
                BGEMMeasurementData bGEMMeasurementData9 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData9);
                int I0Io2 = I0Io.I0Io(bGEMMeasurementData9.getFasting());
                BGEMMeasurementData bGEMMeasurementData10 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData10);
                int I0Io3 = I0Io.I0Io(bGEMMeasurementData10.getWithin_2hrs_meal());
                BGEMMeasurementData bGEMMeasurementData11 = this.measurementData;
                IIX0o.ooOOo0oXI(bGEMMeasurementData11);
                int I0Io4 = I0Io.I0Io(bGEMMeasurementData11.getCompleted_progress());
                BGEMRiskData bGEMRiskData = this.riskData;
                IIX0o.ooOOo0oXI(bGEMRiskData);
                String risk_code = bGEMRiskData.getRisk_code();
                BGEMRiskData bGEMRiskData2 = this.riskData;
                IIX0o.ooOOo0oXI(bGEMRiskData2);
                String insights = bGEMRiskData2.getInsights();
                Gson gson = new Gson();
                BGEMRiskData bGEMRiskData3 = this.riskData;
                IIX0o.ooOOo0oXI(bGEMRiskData3);
                String json = gson.toJson(bGEMRiskData3.getTips());
                Gson gson2 = new Gson();
                BGEMRiskData bGEMRiskData4 = this.riskData;
                IIX0o.ooOOo0oXI(bGEMRiskData4);
                String json2 = gson2.toJson(bGEMRiskData4.getLocale_insights());
                Gson gson3 = new Gson();
                BGEMRiskData bGEMRiskData5 = this.riskData;
                IIX0o.ooOOo0oXI(bGEMRiskData5);
                String json3 = gson3.toJson(bGEMRiskData5.getLocale_tips());
                BGEMRiskData bGEMRiskData6 = this.riskData;
                IIX0o.ooOOo0oXI(bGEMRiskData6);
                int current_level = bGEMRiskData6.getCurrent_level();
                IIX0o.ooOOo0oXI(json);
                IIX0o.ooOOo0oXI(json2);
                IIX0o.ooOOo0oXI(json3);
                return new BloodGlucose2(0, time, measurement_id, user_id, start_time, end_time, model_no, lower_bound, upper_bound, I0Io2, I0Io3, I0Io4, current_level, risk_code, insights, json, json2, json3, 0, 0, 786433, null);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @OOXIXo
    public String toString() {
        return "BGEMRangeAnalysisResult(riskData=" + this.riskData + ", measurementData=" + this.measurementData + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BGEMRangeAnalysisResult(BGEMRiskData bGEMRiskData, BGEMMeasurementData bGEMMeasurementData, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : bGEMRiskData, (i & 2) != 0 ? null : bGEMMeasurementData);
    }

    public BGEMRangeAnalysisResult(@oOoXoXO BGEMRiskData bGEMRiskData, @oOoXoXO BGEMMeasurementData bGEMMeasurementData) {
        this.riskData = bGEMRiskData;
        this.measurementData = bGEMMeasurementData;
    }
}
