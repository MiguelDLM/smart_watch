package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: classes11.dex */
public class ImageVersionInfo implements Parcelable {
    public static final Parcelable.Creator<ImageVersionInfo> CREATOR = new Parcelable.Creator<ImageVersionInfo>() { // from class: com.realsil.sdk.dfu.model.ImageVersionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageVersionInfo createFromParcel(Parcel parcel) {
            return new ImageVersionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageVersionInfo[] newArray(int i) {
            return new ImageVersionInfo[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f19582a;
    public int b;
    public int c;
    public int d;
    public int e;

    public ImageVersionInfo(int i, int i2, int i3, int i4) {
        this.f19582a = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitNumber() {
        return this.f19582a;
    }

    public int getImageId() {
        return this.b;
    }

    public int getIndication() {
        return this.c;
    }

    public int getSectionSize() {
        return this.e;
    }

    public int getVersion() {
        return this.d;
    }

    public void setBitNumber(int i) {
        this.f19582a = i;
    }

    public void setImageId(int i) {
        this.b = i;
    }

    public void setIndication(int i) {
        this.c = i;
    }

    public void setSectionSize(int i) {
        this.e = i;
    }

    public void setVersion(int i) {
        this.d = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        sb.append(String.format(locale, "bitNumber=%d, imageId=0x%04X", Integer.valueOf(this.f19582a), Integer.valueOf(this.b)));
        sb.append(String.format(",indication=0x%02X", Integer.valueOf(this.c)));
        sb.append(String.format(locale, ", version=0x%08X(%d), sectionSize=0x%08X(%d)", Integer.valueOf(this.d), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.e)));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19582a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

    public ImageVersionInfo(int i, int i2, int i3, int i4, int i5) {
        this.f19582a = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.b = i5;
    }

    public ImageVersionInfo(Parcel parcel) {
        this.d = -1;
        this.e = 0;
        this.f19582a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }
}
