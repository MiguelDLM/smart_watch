package com.realsil.sdk.core.bluetooth.scanner;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.exoplayer2.C;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class ScannerParams implements Parcelable {
    public static final Parcelable.Creator<ScannerParams> CREATOR = new a();
    public static final int SCAN_MECHANISM_ALL = 0;
    public static final int SCAN_MECHANISM_FILTER_ONE = 1;
    public static final int SCAN_MODE_DUAL = 0;
    public static final int SCAN_MODE_GATT = 17;
    public static final int SCAN_MODE_GATT_STRICT = 18;
    public static final int SCAN_MODE_SPP = 32;
    public static final int SCAN_MODE_SPP_STRICT = 33;

    /* renamed from: a, reason: collision with root package name */
    public int f19502a;
    public int b;
    public String c;
    public boolean d;
    public boolean e;
    public String f;
    public int g;
    public long h;
    public boolean i;
    public long j;
    public boolean k;
    public int l;
    public boolean m;
    public int n;
    public ParcelUuid[] o;
    public List<CompatScanFilter> p;

    /* loaded from: classes11.dex */
    public class a implements Parcelable.Creator<ScannerParams> {
        @Override // android.os.Parcelable.Creator
        public final ScannerParams createFromParcel(Parcel parcel) {
            return new ScannerParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ScannerParams[] newArray(int i) {
            return new ScannerParams[i];
        }
    }

    public ScannerParams() {
        this(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddressFilter() {
        return this.f;
    }

    public long getAutoScanDelay() {
        return this.j;
    }

    public int getFilterProfile() {
        return this.n;
    }

    public ParcelUuid[] getFilterUuids() {
        return this.o;
    }

    public String getNameFilter() {
        return this.c;
    }

    public int getPhy() {
        return this.l;
    }

    public int getRssiFilter() {
        return this.g;
    }

    public List<CompatScanFilter> getScanFilters() {
        return this.p;
    }

    public int getScanMechanism() {
        return this.b;
    }

    public int getScanMode() {
        return this.f19502a;
    }

    public long getScanPeriod() {
        return this.h;
    }

    public boolean isAutoDiscovery() {
        return this.i;
    }

    public boolean isConnectable() {
        return this.m;
    }

    public boolean isNameFuzzyMatchEnable() {
        return this.d;
    }

    public boolean isNameNullable() {
        return this.e;
    }

    public boolean isReusePairedDeviceEnabled() {
        return this.k;
    }

    public void setAddressFilter(String str) {
        this.f = str;
    }

    public void setAutoDiscovery(boolean z) {
        this.i = z;
    }

    public void setAutoScanDelay(long j) {
        this.j = j;
    }

    public void setConnectable(boolean z) {
        this.m = z;
    }

    public void setFilterProfile(int i) {
        this.n = i;
    }

    public void setFilterUuids(ParcelUuid[] parcelUuidArr) {
        this.o = parcelUuidArr;
    }

    public void setNameFilter(String str) {
        this.c = str;
    }

    public void setNameFuzzyMatchEnable(boolean z) {
        this.d = z;
    }

    public void setNameNullable(boolean z) {
        this.e = z;
    }

    public void setPhy(int i) {
        this.l = i;
    }

    public void setReusePairedDeviceEnabled(boolean z) {
        this.k = z;
    }

    public void setRssiFilter(int i) {
        this.g = i;
    }

    public void setScanFilters(List<CompatScanFilter> list) {
        this.p = list;
    }

    public void setScanMechanism(int i) {
        this.b = i;
    }

    public void setScanMode(int i) {
        this.f19502a = i;
    }

    public void setScanPeriod(long j) {
        this.h = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScannerParams{");
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\tscanMode:%d,scanMechanism:%d,scanPeriod=%d", Integer.valueOf(this.f19502a), Integer.valueOf(this.b), Long.valueOf(this.h)));
        sb.append(String.format(locale, "\n\tfilterProfile=%d", Integer.valueOf(this.n)));
        sb.append(String.format(locale, "\n\tnameFilter:%s,nameFuzzyMatchEnable=%b,nameNullable=%b", this.c, Boolean.valueOf(this.d), Boolean.valueOf(this.e)));
        sb.append(String.format(locale, "\n\tautoDiscovery:%b,autoScanDelay=%d", Boolean.valueOf(this.i), Long.valueOf(this.j)));
        sb.append("\n}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19502a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeLong(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.j);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.l);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.n);
        parcel.writeTypedArray(this.o, i);
        parcel.writeTypedList(this.p);
    }

    public ScannerParams(int i) {
        this.f19502a = 0;
        this.b = 0;
        this.d = false;
        this.e = true;
        this.g = -1000;
        this.h = 10000L;
        this.j = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        this.k = true;
        this.l = 255;
        this.m = true;
        this.p = new ArrayList();
        this.f19502a = i;
        if (i != 17 && i != 18) {
            this.h = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        } else {
            this.h = 60000L;
        }
        this.i = false;
        this.b = 0;
    }

    public ScannerParams(Parcel parcel) {
        this.f19502a = 0;
        this.b = 0;
        this.d = false;
        this.e = true;
        this.g = -1000;
        this.h = 10000L;
        this.j = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        this.k = true;
        this.l = 255;
        this.m = true;
        this.p = new ArrayList();
        this.f19502a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readLong();
        this.i = parcel.readByte() != 0;
        this.j = parcel.readLong();
        this.k = parcel.readByte() != 0;
        this.l = parcel.readInt();
        this.m = parcel.readByte() != 0;
        this.n = parcel.readInt();
        this.o = (ParcelUuid[]) parcel.createTypedArray(ParcelUuid.CREATOR);
        this.p = parcel.createTypedArrayList(CompatScanFilter.CREATOR);
    }
}
