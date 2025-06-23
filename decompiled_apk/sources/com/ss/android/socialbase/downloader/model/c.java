package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes13.dex */
public class c implements Parcelable, Comparable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.ss.android.socialbase.downloader.model.c.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final String f26398a;
    private final String b;

    public c(String str, String str2) {
        this.f26398a = str;
        this.b = str2;
    }

    public String a() {
        return this.f26398a;
    }

    public String b() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof c)) {
            return 1;
        }
        c cVar = (c) obj;
        if (TextUtils.equals(this.f26398a, cVar.a())) {
            return 0;
        }
        String str = this.f26398a;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(cVar.a());
        if (compareTo > 0) {
            return 1;
        }
        if (compareTo >= 0) {
            return 0;
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (TextUtils.equals(this.f26398a, cVar.f26398a) && TextUtils.equals(this.b, cVar.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f26398a;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i2 = hashCode * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "HttpHeader{name='" + this.f26398a + "', value='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f26398a);
        parcel.writeString(this.b);
    }

    public c(Parcel parcel) {
        this.f26398a = parcel.readString();
        this.b = parcel.readString();
    }
}
