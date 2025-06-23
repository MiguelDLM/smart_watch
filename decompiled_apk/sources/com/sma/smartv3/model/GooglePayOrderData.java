package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class GooglePayOrderData extends JsonFieldContainer implements Serializable {
    private int acknowledgementState;
    private int consumptionState;

    @OOXIXo
    private String developerPayload;

    @OOXIXo
    private String kind;

    @OOXIXo
    private String orderId;

    @OOXIXo
    private String purchaseState;
    private long purchaseTimeMillis;
    private int purchaseType;

    @OOXIXo
    private String regionCode;

    public GooglePayOrderData() {
        this(0, null, null, null, null, 0L, 0, 0, null, 511, null);
    }

    public final int component1() {
        return this.consumptionState;
    }

    @OOXIXo
    public final String component2() {
        return this.developerPayload;
    }

    @OOXIXo
    public final String component3() {
        return this.kind;
    }

    @OOXIXo
    public final String component4() {
        return this.orderId;
    }

    @OOXIXo
    public final String component5() {
        return this.purchaseState;
    }

    public final long component6() {
        return this.purchaseTimeMillis;
    }

    public final int component7() {
        return this.purchaseType;
    }

    public final int component8() {
        return this.acknowledgementState;
    }

    @OOXIXo
    public final String component9() {
        return this.regionCode;
    }

    @OOXIXo
    public final GooglePayOrderData copy(int i, @OOXIXo String developerPayload, @OOXIXo String kind, @OOXIXo String orderId, @OOXIXo String purchaseState, long j, int i2, int i3, @OOXIXo String regionCode) {
        IIX0o.x0xO0oo(developerPayload, "developerPayload");
        IIX0o.x0xO0oo(kind, "kind");
        IIX0o.x0xO0oo(orderId, "orderId");
        IIX0o.x0xO0oo(purchaseState, "purchaseState");
        IIX0o.x0xO0oo(regionCode, "regionCode");
        return new GooglePayOrderData(i, developerPayload, kind, orderId, purchaseState, j, i2, i3, regionCode);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GooglePayOrderData)) {
            return false;
        }
        GooglePayOrderData googlePayOrderData = (GooglePayOrderData) obj;
        return this.consumptionState == googlePayOrderData.consumptionState && IIX0o.Oxx0IOOO(this.developerPayload, googlePayOrderData.developerPayload) && IIX0o.Oxx0IOOO(this.kind, googlePayOrderData.kind) && IIX0o.Oxx0IOOO(this.orderId, googlePayOrderData.orderId) && IIX0o.Oxx0IOOO(this.purchaseState, googlePayOrderData.purchaseState) && this.purchaseTimeMillis == googlePayOrderData.purchaseTimeMillis && this.purchaseType == googlePayOrderData.purchaseType && this.acknowledgementState == googlePayOrderData.acknowledgementState && IIX0o.Oxx0IOOO(this.regionCode, googlePayOrderData.regionCode);
    }

    public final int getAcknowledgementState() {
        return this.acknowledgementState;
    }

    public final int getConsumptionState() {
        return this.consumptionState;
    }

    @OOXIXo
    public final String getDeveloperPayload() {
        return this.developerPayload;
    }

    @OOXIXo
    public final String getKind() {
        return this.kind;
    }

    @OOXIXo
    public final String getOrderId() {
        return this.orderId;
    }

    @OOXIXo
    public final String getPurchaseState() {
        return this.purchaseState;
    }

    public final long getPurchaseTimeMillis() {
        return this.purchaseTimeMillis;
    }

    public final int getPurchaseType() {
        return this.purchaseType;
    }

    @OOXIXo
    public final String getRegionCode() {
        return this.regionCode;
    }

    public int hashCode() {
        return (((((((((((((((this.consumptionState * 31) + this.developerPayload.hashCode()) * 31) + this.kind.hashCode()) * 31) + this.orderId.hashCode()) * 31) + this.purchaseState.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.purchaseTimeMillis)) * 31) + this.purchaseType) * 31) + this.acknowledgementState) * 31) + this.regionCode.hashCode();
    }

    public final void setAcknowledgementState(int i) {
        this.acknowledgementState = i;
    }

    public final void setConsumptionState(int i) {
        this.consumptionState = i;
    }

    public final void setDeveloperPayload(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.developerPayload = str;
    }

    public final void setKind(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.kind = str;
    }

    public final void setOrderId(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.orderId = str;
    }

    public final void setPurchaseState(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.purchaseState = str;
    }

    public final void setPurchaseTimeMillis(long j) {
        this.purchaseTimeMillis = j;
    }

    public final void setPurchaseType(int i) {
        this.purchaseType = i;
    }

    public final void setRegionCode(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.regionCode = str;
    }

    @OOXIXo
    public String toString() {
        return "GooglePayOrderData(consumptionState=" + this.consumptionState + ", developerPayload=" + this.developerPayload + ", kind=" + this.kind + ", orderId=" + this.orderId + ", purchaseState=" + this.purchaseState + ", purchaseTimeMillis=" + this.purchaseTimeMillis + ", purchaseType=" + this.purchaseType + ", acknowledgementState=" + this.acknowledgementState + ", regionCode=" + this.regionCode + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ GooglePayOrderData(int i, String str, String str2, String str3, String str4, long j, int i2, int i3, String str5, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? 0L : j, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) == 0 ? i3 : 0, (i4 & 256) == 0 ? str5 : "");
    }

    public GooglePayOrderData(int i, @OOXIXo String developerPayload, @OOXIXo String kind, @OOXIXo String orderId, @OOXIXo String purchaseState, long j, int i2, int i3, @OOXIXo String regionCode) {
        IIX0o.x0xO0oo(developerPayload, "developerPayload");
        IIX0o.x0xO0oo(kind, "kind");
        IIX0o.x0xO0oo(orderId, "orderId");
        IIX0o.x0xO0oo(purchaseState, "purchaseState");
        IIX0o.x0xO0oo(regionCode, "regionCode");
        this.consumptionState = i;
        this.developerPayload = developerPayload;
        this.kind = kind;
        this.orderId = orderId;
        this.purchaseState = purchaseState;
        this.purchaseTimeMillis = j;
        this.purchaseType = i2;
        this.acknowledgementState = i3;
        this.regionCode = regionCode;
    }
}
