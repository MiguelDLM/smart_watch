package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes13.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new oIX0oI();

    /* renamed from: a, reason: collision with root package name */
    public final String f26511a;
    public final String b;
    public final String c;

    /* loaded from: classes13.dex */
    public static class oIX0oI implements Parcelable.Creator<PlugInBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f26511a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f26511a + " plV:" + this.b + " plUUID:" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26511a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public PlugInBean(Parcel parcel) {
        this.f26511a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
