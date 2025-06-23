package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Parcel;
import android.os.Parcelable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CustomLatLng implements Parcelable {

    @OOXIXo
    public static final CREATOR CREATOR = new CREATOR(null);
    private int altitude;
    private int color;
    private double latitude;
    private double longitude;
    private long time;

    /* loaded from: classes12.dex */
    public static final class CREATOR implements Parcelable.Creator<CustomLatLng> {
        public /* synthetic */ CREATOR(IIXOooo iIXOooo) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public CustomLatLng createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new CustomLatLng(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public CustomLatLng[] newArray(int i) {
            return new CustomLatLng[i];
        }
    }

    public CustomLatLng(double d, double d2, long j, int i, int i2) {
        this.latitude = d;
        this.longitude = d2;
        this.time = j;
        this.altitude = i;
        this.color = i2;
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    public final long component3() {
        return this.time;
    }

    public final int component4() {
        return this.altitude;
    }

    public final int component5() {
        return this.color;
    }

    @OOXIXo
    public final CustomLatLng copy(double d, double d2, long j, int i, int i2) {
        return new CustomLatLng(d, d2, j, i, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomLatLng)) {
            return false;
        }
        CustomLatLng customLatLng = (CustomLatLng) obj;
        return Double.compare(this.latitude, customLatLng.latitude) == 0 && Double.compare(this.longitude, customLatLng.longitude) == 0 && this.time == customLatLng.time && this.altitude == customLatLng.altitude && this.color == customLatLng.color;
    }

    public final int getAltitude() {
        return this.altitude;
    }

    public final int getColor() {
        return this.color;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((((ooXIXxIX.oIX0oI.oIX0oI(this.latitude) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.longitude)) * 31) + androidx.collection.oIX0oI.oIX0oI(this.time)) * 31) + this.altitude) * 31) + this.color;
    }

    public final void setAltitude(int i) {
        this.altitude = i;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final void setLongitude(double d) {
        this.longitude = d;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    @OOXIXo
    public String toString() {
        return "CustomLatLng(latitude=" + this.latitude + ", longitude=" + this.longitude + ", time=" + this.time + ", altitude=" + this.altitude + ", color=" + this.color + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel parcel, int i) {
        IIX0o.x0xO0oo(parcel, "parcel");
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeLong(this.time);
        parcel.writeInt(this.altitude);
        parcel.writeInt(this.color);
    }

    public /* synthetic */ CustomLatLng(double d, double d2, long j, int i, int i2, int i3, IIXOooo iIXOooo) {
        this(d, d2, (i3 & 4) != 0 ? 0L : j, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomLatLng(@OOXIXo Parcel parcel) {
        this(parcel.readDouble(), parcel.readDouble(), parcel.readLong(), parcel.readInt(), parcel.readInt());
        IIX0o.x0xO0oo(parcel, "parcel");
    }
}
