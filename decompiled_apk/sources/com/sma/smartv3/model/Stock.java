package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class Stock extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private String code;

    @OOXIXo
    private String country;

    @OOXIXo
    private String currency;

    @OOXIXo
    private String exchange;

    @OOXIXo
    private String exchangeInfo;
    private int id;

    @OOXIXo
    private String isin;

    @OOXIXo
    private String name;
    private float previousClose;

    @OOXIXo
    private String previousCloseDate;
    private float realTimeChange;
    private float realTimeChangePercentage;
    private float realTimeClose;
    private int realTimeGmtOffset;
    private float realTimeHigh;
    private float realTimeLow;
    private float realTimeOpen;
    private float realTimePreviousClose;
    private long realTimeStamp;

    @OOXIXo
    private String realTimeStampRead;
    private long realTimeVolume;

    @OOXIXo
    private String type;
    private long updateTime;

    public Stock() {
        this(0, 0.0f, null, 0L, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 0.0f, 0.0f, 0.0f, 0L, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public final int component1() {
        return this.id;
    }

    public final float component10() {
        return this.realTimeClose;
    }

    public final long component11() {
        return this.realTimeVolume;
    }

    public final float component12() {
        return this.realTimeChange;
    }

    public final float component13() {
        return this.realTimeChangePercentage;
    }

    public final float component14() {
        return this.realTimePreviousClose;
    }

    public final long component15() {
        return this.updateTime;
    }

    @OOXIXo
    public final String component16() {
        return this.country;
    }

    @OOXIXo
    public final String component17() {
        return this.currency;
    }

    @OOXIXo
    public final String component18() {
        return this.name;
    }

    @OOXIXo
    public final String component19() {
        return this.type;
    }

    public final float component2() {
        return this.previousClose;
    }

    @OOXIXo
    public final String component20() {
        return this.code;
    }

    @OOXIXo
    public final String component21() {
        return this.exchange;
    }

    @OOXIXo
    public final String component22() {
        return this.exchangeInfo;
    }

    @OOXIXo
    public final String component23() {
        return this.isin;
    }

    @OOXIXo
    public final String component3() {
        return this.previousCloseDate;
    }

    public final long component4() {
        return this.realTimeStamp;
    }

    @OOXIXo
    public final String component5() {
        return this.realTimeStampRead;
    }

    public final int component6() {
        return this.realTimeGmtOffset;
    }

    public final float component7() {
        return this.realTimeOpen;
    }

    public final float component8() {
        return this.realTimeHigh;
    }

    public final float component9() {
        return this.realTimeLow;
    }

    @OOXIXo
    public final Stock copy(int i, float f, @OOXIXo String previousCloseDate, long j, @OOXIXo String realTimeStampRead, int i2, float f2, float f3, float f4, float f5, long j2, float f6, float f7, float f8, long j3, @OOXIXo String country, @OOXIXo String currency, @OOXIXo String name, @OOXIXo String type, @OOXIXo String code, @OOXIXo String exchange, @OOXIXo String exchangeInfo, @OOXIXo String isin) {
        IIX0o.x0xO0oo(previousCloseDate, "previousCloseDate");
        IIX0o.x0xO0oo(realTimeStampRead, "realTimeStampRead");
        IIX0o.x0xO0oo(country, "country");
        IIX0o.x0xO0oo(currency, "currency");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(exchange, "exchange");
        IIX0o.x0xO0oo(exchangeInfo, "exchangeInfo");
        IIX0o.x0xO0oo(isin, "isin");
        return new Stock(i, f, previousCloseDate, j, realTimeStampRead, i2, f2, f3, f4, f5, j2, f6, f7, f8, j3, country, currency, name, type, code, exchange, exchangeInfo, isin);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stock)) {
            return false;
        }
        Stock stock = (Stock) obj;
        return this.id == stock.id && Float.compare(this.previousClose, stock.previousClose) == 0 && IIX0o.Oxx0IOOO(this.previousCloseDate, stock.previousCloseDate) && this.realTimeStamp == stock.realTimeStamp && IIX0o.Oxx0IOOO(this.realTimeStampRead, stock.realTimeStampRead) && this.realTimeGmtOffset == stock.realTimeGmtOffset && Float.compare(this.realTimeOpen, stock.realTimeOpen) == 0 && Float.compare(this.realTimeHigh, stock.realTimeHigh) == 0 && Float.compare(this.realTimeLow, stock.realTimeLow) == 0 && Float.compare(this.realTimeClose, stock.realTimeClose) == 0 && this.realTimeVolume == stock.realTimeVolume && Float.compare(this.realTimeChange, stock.realTimeChange) == 0 && Float.compare(this.realTimeChangePercentage, stock.realTimeChangePercentage) == 0 && Float.compare(this.realTimePreviousClose, stock.realTimePreviousClose) == 0 && this.updateTime == stock.updateTime && IIX0o.Oxx0IOOO(this.country, stock.country) && IIX0o.Oxx0IOOO(this.currency, stock.currency) && IIX0o.Oxx0IOOO(this.name, stock.name) && IIX0o.Oxx0IOOO(this.type, stock.type) && IIX0o.Oxx0IOOO(this.code, stock.code) && IIX0o.Oxx0IOOO(this.exchange, stock.exchange) && IIX0o.Oxx0IOOO(this.exchangeInfo, stock.exchangeInfo) && IIX0o.Oxx0IOOO(this.isin, stock.isin);
    }

    @OOXIXo
    public final String getCode() {
        return this.code;
    }

    @OOXIXo
    public final String getCountry() {
        return this.country;
    }

    @OOXIXo
    public final String getCurrency() {
        return this.currency;
    }

    @OOXIXo
    public final String getExchange() {
        return this.exchange;
    }

    @OOXIXo
    public final String getExchangeInfo() {
        return this.exchangeInfo;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getIsin() {
        return this.isin;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    public final float getPreviousClose() {
        return this.previousClose;
    }

    @OOXIXo
    public final String getPreviousCloseDate() {
        return this.previousCloseDate;
    }

    public final float getRealTimeChange() {
        return this.realTimeChange;
    }

    public final float getRealTimeChangePercentage() {
        return this.realTimeChangePercentage;
    }

    public final float getRealTimeClose() {
        return this.realTimeClose;
    }

    public final int getRealTimeGmtOffset() {
        return this.realTimeGmtOffset;
    }

    public final float getRealTimeHigh() {
        return this.realTimeHigh;
    }

    public final float getRealTimeLow() {
        return this.realTimeLow;
    }

    public final float getRealTimeOpen() {
        return this.realTimeOpen;
    }

    public final float getRealTimePreviousClose() {
        return this.realTimePreviousClose;
    }

    public final long getRealTimeStamp() {
        return this.realTimeStamp;
    }

    @OOXIXo
    public final String getRealTimeStampRead() {
        return this.realTimeStampRead;
    }

    public final long getRealTimeVolume() {
        return this.realTimeVolume;
    }

    @OOXIXo
    public final String getType() {
        return this.type;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.id * 31) + Float.floatToIntBits(this.previousClose)) * 31) + this.previousCloseDate.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.realTimeStamp)) * 31) + this.realTimeStampRead.hashCode()) * 31) + this.realTimeGmtOffset) * 31) + Float.floatToIntBits(this.realTimeOpen)) * 31) + Float.floatToIntBits(this.realTimeHigh)) * 31) + Float.floatToIntBits(this.realTimeLow)) * 31) + Float.floatToIntBits(this.realTimeClose)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.realTimeVolume)) * 31) + Float.floatToIntBits(this.realTimeChange)) * 31) + Float.floatToIntBits(this.realTimeChangePercentage)) * 31) + Float.floatToIntBits(this.realTimePreviousClose)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.updateTime)) * 31) + this.country.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.code.hashCode()) * 31) + this.exchange.hashCode()) * 31) + this.exchangeInfo.hashCode()) * 31) + this.isin.hashCode();
    }

    public final void setCode(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.code = str;
    }

    public final void setCountry(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.country = str;
    }

    public final void setCurrency(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.currency = str;
    }

    public final void setExchange(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.exchange = str;
    }

    public final void setExchangeInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.exchangeInfo = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIsin(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.isin = str;
    }

    public final void setName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.name = str;
    }

    public final void setPreviousClose(float f) {
        this.previousClose = f;
    }

    public final void setPreviousCloseDate(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.previousCloseDate = str;
    }

    public final void setRealTimeChange(float f) {
        this.realTimeChange = f;
    }

    public final void setRealTimeChangePercentage(float f) {
        this.realTimeChangePercentage = f;
    }

    public final void setRealTimeClose(float f) {
        this.realTimeClose = f;
    }

    public final void setRealTimeGmtOffset(int i) {
        this.realTimeGmtOffset = i;
    }

    public final void setRealTimeHigh(float f) {
        this.realTimeHigh = f;
    }

    public final void setRealTimeLow(float f) {
        this.realTimeLow = f;
    }

    public final void setRealTimeOpen(float f) {
        this.realTimeOpen = f;
    }

    public final void setRealTimePreviousClose(float f) {
        this.realTimePreviousClose = f;
    }

    public final void setRealTimeStamp(long j) {
        this.realTimeStamp = j;
    }

    public final void setRealTimeStampRead(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.realTimeStampRead = str;
    }

    public final void setRealTimeVolume(long j) {
        this.realTimeVolume = j;
    }

    public final void setType(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.type = str;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    @OOXIXo
    public String toString() {
        return "Stock(id=" + this.id + ", previousClose=" + this.previousClose + ", previousCloseDate=" + this.previousCloseDate + ", realTimeStamp=" + this.realTimeStamp + ", realTimeStampRead=" + this.realTimeStampRead + ", realTimeGmtOffset=" + this.realTimeGmtOffset + ", realTimeOpen=" + this.realTimeOpen + ", realTimeHigh=" + this.realTimeHigh + ", realTimeLow=" + this.realTimeLow + ", realTimeClose=" + this.realTimeClose + ", realTimeVolume=" + this.realTimeVolume + ", realTimeChange=" + this.realTimeChange + ", realTimeChangePercentage=" + this.realTimeChangePercentage + ", realTimePreviousClose=" + this.realTimePreviousClose + ", updateTime=" + this.updateTime + ", country=" + this.country + ", currency=" + this.currency + ", name=" + this.name + ", type=" + this.type + ", code=" + this.code + ", exchange=" + this.exchange + ", exchangeInfo=" + this.exchangeInfo + ", isin=" + this.isin + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ Stock(int i, float f, String str, long j, String str2, int i2, float f2, float f3, float f4, float f5, long j2, float f6, float f7, float f8, long j3, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0.0f : f, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? 0L : j, (i3 & 16) != 0 ? "" : str2, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? 0.0f : f2, (i3 & 128) != 0 ? 0.0f : f3, (i3 & 256) != 0 ? 0.0f : f4, (i3 & 512) != 0 ? 0.0f : f5, (i3 & 1024) != 0 ? 0L : j2, (i3 & 2048) != 0 ? 0.0f : f6, (i3 & 4096) != 0 ? 0.0f : f7, (i3 & 8192) != 0 ? 0.0f : f8, (i3 & 16384) != 0 ? 0L : j3, (32768 & i3) != 0 ? "" : str3, (i3 & 65536) != 0 ? "" : str4, (i3 & 131072) != 0 ? "" : str5, (i3 & 262144) != 0 ? "" : str6, (i3 & 524288) != 0 ? "" : str7, (i3 & 1048576) != 0 ? "" : str8, (i3 & 2097152) != 0 ? "" : str9, (i3 & 4194304) != 0 ? "" : str10);
    }

    public Stock(int i, float f, @OOXIXo String previousCloseDate, long j, @OOXIXo String realTimeStampRead, int i2, float f2, float f3, float f4, float f5, long j2, float f6, float f7, float f8, long j3, @OOXIXo String country, @OOXIXo String currency, @OOXIXo String name, @OOXIXo String type, @OOXIXo String code, @OOXIXo String exchange, @OOXIXo String exchangeInfo, @OOXIXo String isin) {
        IIX0o.x0xO0oo(previousCloseDate, "previousCloseDate");
        IIX0o.x0xO0oo(realTimeStampRead, "realTimeStampRead");
        IIX0o.x0xO0oo(country, "country");
        IIX0o.x0xO0oo(currency, "currency");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(exchange, "exchange");
        IIX0o.x0xO0oo(exchangeInfo, "exchangeInfo");
        IIX0o.x0xO0oo(isin, "isin");
        this.id = i;
        this.previousClose = f;
        this.previousCloseDate = previousCloseDate;
        this.realTimeStamp = j;
        this.realTimeStampRead = realTimeStampRead;
        this.realTimeGmtOffset = i2;
        this.realTimeOpen = f2;
        this.realTimeHigh = f3;
        this.realTimeLow = f4;
        this.realTimeClose = f5;
        this.realTimeVolume = j2;
        this.realTimeChange = f6;
        this.realTimeChangePercentage = f7;
        this.realTimePreviousClose = f8;
        this.updateTime = j3;
        this.country = country;
        this.currency = currency;
        this.name = name;
        this.type = type;
        this.code = code;
        this.exchange = exchange;
        this.exchangeInfo = exchangeInfo;
        this.isin = isin;
    }
}
