package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class BuildingInfo implements Parcelable {
    public static final Parcelable.Creator<BuildingInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f5934a;
    private int b;
    private float c;
    private int d;
    private String e;
    private String f;

    public BuildingInfo() {
    }

    public void a(String str) {
        this.f5934a = str;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(String str) {
        this.f = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccuracy() {
        return this.d;
    }

    public String getCenter() {
        return this.f;
    }

    public String getGeom() {
        return this.e;
    }

    public float getHeight() {
        return this.c;
    }

    public int getLabel() {
        return this.b;
    }

    public String getStructID() {
        return this.f5934a;
    }

    public void setHeight(float f) {
        this.c = f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BuidingInfo: \n");
        stringBuffer.append("; height = ");
        stringBuffer.append(this.c);
        stringBuffer.append("; accuracy = ");
        stringBuffer.append(this.d);
        stringBuffer.append("; geom = ");
        stringBuffer.append(this.e);
        stringBuffer.append("; center = ");
        stringBuffer.append(this.f);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }

    public BuildingInfo(Parcel parcel) {
        this.c = parcel.readFloat();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.e = str;
    }
}
