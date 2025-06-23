package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CustomConfigInfo extends JsonFieldContainer {

    @OOXIXo
    private String aiModelService;

    @oOoXoXO
    private String supCourse;

    @OOXIXo
    private String supDirectAI;

    @OOXIXo
    private String supFallDetection;

    @OOXIXo
    private String supHardwareAliPay;

    @OOXIXo
    private String supOpenScreenAds;

    @OOXIXo
    private String supOtherAds;

    @OOXIXo
    private String supRideCode;

    @OOXIXo
    private String transModel;

    public CustomConfigInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @OOXIXo
    public final String component1() {
        return this.supHardwareAliPay;
    }

    @OOXIXo
    public final String component2() {
        return this.supFallDetection;
    }

    @OOXIXo
    public final String component3() {
        return this.supDirectAI;
    }

    @OOXIXo
    public final String component4() {
        return this.aiModelService;
    }

    @OOXIXo
    public final String component5() {
        return this.supOtherAds;
    }

    @OOXIXo
    public final String component6() {
        return this.supOpenScreenAds;
    }

    @OOXIXo
    public final String component7() {
        return this.supRideCode;
    }

    @OOXIXo
    public final String component8() {
        return this.transModel;
    }

    @oOoXoXO
    public final String component9() {
        return this.supCourse;
    }

    @OOXIXo
    public final CustomConfigInfo copy(@OOXIXo String supHardwareAliPay, @OOXIXo String supFallDetection, @OOXIXo String supDirectAI, @OOXIXo String aiModelService, @OOXIXo String supOtherAds, @OOXIXo String supOpenScreenAds, @OOXIXo String supRideCode, @OOXIXo String transModel, @oOoXoXO String str) {
        IIX0o.x0xO0oo(supHardwareAliPay, "supHardwareAliPay");
        IIX0o.x0xO0oo(supFallDetection, "supFallDetection");
        IIX0o.x0xO0oo(supDirectAI, "supDirectAI");
        IIX0o.x0xO0oo(aiModelService, "aiModelService");
        IIX0o.x0xO0oo(supOtherAds, "supOtherAds");
        IIX0o.x0xO0oo(supOpenScreenAds, "supOpenScreenAds");
        IIX0o.x0xO0oo(supRideCode, "supRideCode");
        IIX0o.x0xO0oo(transModel, "transModel");
        return new CustomConfigInfo(supHardwareAliPay, supFallDetection, supDirectAI, aiModelService, supOtherAds, supOpenScreenAds, supRideCode, transModel, str);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomConfigInfo)) {
            return false;
        }
        CustomConfigInfo customConfigInfo = (CustomConfigInfo) obj;
        return IIX0o.Oxx0IOOO(this.supHardwareAliPay, customConfigInfo.supHardwareAliPay) && IIX0o.Oxx0IOOO(this.supFallDetection, customConfigInfo.supFallDetection) && IIX0o.Oxx0IOOO(this.supDirectAI, customConfigInfo.supDirectAI) && IIX0o.Oxx0IOOO(this.aiModelService, customConfigInfo.aiModelService) && IIX0o.Oxx0IOOO(this.supOtherAds, customConfigInfo.supOtherAds) && IIX0o.Oxx0IOOO(this.supOpenScreenAds, customConfigInfo.supOpenScreenAds) && IIX0o.Oxx0IOOO(this.supRideCode, customConfigInfo.supRideCode) && IIX0o.Oxx0IOOO(this.transModel, customConfigInfo.transModel) && IIX0o.Oxx0IOOO(this.supCourse, customConfigInfo.supCourse);
    }

    @OOXIXo
    public final String getAiModelService() {
        return this.aiModelService;
    }

    @oOoXoXO
    public final String getSupCourse() {
        return this.supCourse;
    }

    @OOXIXo
    public final String getSupDirectAI() {
        return this.supDirectAI;
    }

    @OOXIXo
    public final String getSupFallDetection() {
        return this.supFallDetection;
    }

    @OOXIXo
    public final String getSupHardwareAliPay() {
        return this.supHardwareAliPay;
    }

    @OOXIXo
    public final String getSupOpenScreenAds() {
        return this.supOpenScreenAds;
    }

    @OOXIXo
    public final String getSupOtherAds() {
        return this.supOtherAds;
    }

    @OOXIXo
    public final String getSupRideCode() {
        return this.supRideCode;
    }

    @OOXIXo
    public final String getTransModel() {
        return this.transModel;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.supHardwareAliPay.hashCode() * 31) + this.supFallDetection.hashCode()) * 31) + this.supDirectAI.hashCode()) * 31) + this.aiModelService.hashCode()) * 31) + this.supOtherAds.hashCode()) * 31) + this.supOpenScreenAds.hashCode()) * 31) + this.supRideCode.hashCode()) * 31) + this.transModel.hashCode()) * 31;
        String str = this.supCourse;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setAiModelService(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.aiModelService = str;
    }

    public final void setSupCourse(@oOoXoXO String str) {
        this.supCourse = str;
    }

    public final void setSupDirectAI(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supDirectAI = str;
    }

    public final void setSupFallDetection(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supFallDetection = str;
    }

    public final void setSupHardwareAliPay(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supHardwareAliPay = str;
    }

    public final void setSupOpenScreenAds(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supOpenScreenAds = str;
    }

    public final void setSupOtherAds(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supOtherAds = str;
    }

    public final void setSupRideCode(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supRideCode = str;
    }

    public final void setTransModel(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.transModel = str;
    }

    @OOXIXo
    public String toString() {
        return "CustomConfigInfo(supHardwareAliPay=" + this.supHardwareAliPay + ", supFallDetection=" + this.supFallDetection + ", supDirectAI=" + this.supDirectAI + ", aiModelService=" + this.aiModelService + ", supOtherAds=" + this.supOtherAds + ", supOpenScreenAds=" + this.supOpenScreenAds + ", supRideCode=" + this.supRideCode + ", transModel=" + this.transModel + ", supCourse=" + this.supCourse + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ CustomConfigInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "0" : str, (i & 2) != 0 ? "0" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) == 0 ? str8 : "", (i & 256) == 0 ? str9 : "0");
    }

    public CustomConfigInfo(@OOXIXo String supHardwareAliPay, @OOXIXo String supFallDetection, @OOXIXo String supDirectAI, @OOXIXo String aiModelService, @OOXIXo String supOtherAds, @OOXIXo String supOpenScreenAds, @OOXIXo String supRideCode, @OOXIXo String transModel, @oOoXoXO String str) {
        IIX0o.x0xO0oo(supHardwareAliPay, "supHardwareAliPay");
        IIX0o.x0xO0oo(supFallDetection, "supFallDetection");
        IIX0o.x0xO0oo(supDirectAI, "supDirectAI");
        IIX0o.x0xO0oo(aiModelService, "aiModelService");
        IIX0o.x0xO0oo(supOtherAds, "supOtherAds");
        IIX0o.x0xO0oo(supOpenScreenAds, "supOpenScreenAds");
        IIX0o.x0xO0oo(supRideCode, "supRideCode");
        IIX0o.x0xO0oo(transModel, "transModel");
        this.supHardwareAliPay = supHardwareAliPay;
        this.supFallDetection = supFallDetection;
        this.supDirectAI = supDirectAI;
        this.aiModelService = aiModelService;
        this.supOtherAds = supOtherAds;
        this.supOpenScreenAds = supOpenScreenAds;
        this.supRideCode = supRideCode;
        this.transModel = transModel;
        this.supCourse = str;
    }
}
