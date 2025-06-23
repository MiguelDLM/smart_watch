package com.sma.smartv3.ui.timezonepicker;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes12.dex */
public class TimeZoneResult implements Parcelable {
    public static final Parcelable.Creator<TimeZoneResult> CREATOR = new oIX0oI();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f24169IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f24170IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f24171Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f24172Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f24173OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public int f24174XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String f24175oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f24176xoXoI;

    /* loaded from: classes12.dex */
    public class oIX0oI implements Parcelable.Creator<TimeZoneResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public TimeZoneResult[] newArray(int size) {
            return new TimeZoneResult[size];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public TimeZoneResult createFromParcel(Parcel in) {
            return new TimeZoneResult(in);
        }
    }

    public TimeZoneResult(TimeZoneInfo timeZoneInfo) {
        this.f24171Oo = timeZoneInfo.getTimeZoneId();
        this.f24170IXxxXO = timeZoneInfo.getCountry();
        this.f24172Oxx0xo = timeZoneInfo.getDisplayName();
        this.f24175oI0IIXIo = timeZoneInfo.getCityName();
        this.f24176xoXoI = timeZoneInfo.getRawoffset();
        this.f24173OxxIIOOXO = timeZoneInfo.getEnCityName();
    }

    public String I0Io() {
        return this.f24172Oxx0xo;
    }

    public boolean II0XooXoX() {
        return this.f24169IIXOooo;
    }

    public String II0xO0() {
        return this.f24170IXxxXO;
    }

    public void OOXIXo(String mDisplayName) {
        this.f24172Oxx0xo = mDisplayName;
    }

    public String Oxx0IOOO() {
        return this.f24171Oo;
    }

    public int X0o0xo() {
        return this.f24174XO;
    }

    public int XO() {
        return this.f24176xoXoI;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String oIX0oI() {
        return this.f24175oI0IIXIo;
    }

    public void oO(int mRawoffset) {
        this.f24176xoXoI = mRawoffset;
    }

    public void oOoXoXO(String mEnCityName) {
        this.f24173OxxIIOOXO = mEnCityName;
    }

    public void ooOOo0oXI(int id) {
        this.f24174XO = id;
    }

    public String oxoX() {
        return this.f24173OxxIIOOXO;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f24170IXxxXO);
        dest.writeString(this.f24172Oxx0xo);
        dest.writeString(this.f24171Oo);
        dest.writeString(this.f24175oI0IIXIo);
        dest.writeInt(this.f24176xoXoI);
    }

    public void x0XOIxOo(boolean local) {
        this.f24169IIXOooo = local;
    }

    public void x0xO0oo(String mTimeZoneId) {
        this.f24171Oo = mTimeZoneId;
    }

    public void xoIox(String mCountry) {
        this.f24170IXxxXO = mCountry;
    }

    public void xxIXOIIO(String mCityName) {
        this.f24175oI0IIXIo = mCityName;
    }

    public TimeZoneResult(Parcel in) {
        this.f24170IXxxXO = in.readString();
        this.f24172Oxx0xo = in.readString();
        this.f24171Oo = in.readString();
        this.f24175oI0IIXIo = in.readString();
        this.f24176xoXoI = in.readInt();
    }
}
