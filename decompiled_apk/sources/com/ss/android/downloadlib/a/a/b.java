package com.ss.android.downloadlib.a.a;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes11.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.downloadlib.a.a.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f25945a;
    public int b;
    public String c;
    public int d;
    public String e;
    public String f;

    public b() {
        this.c = "";
        this.e = "";
        this.f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f25945a == bVar.f25945a && this.b == bVar.b) {
                String str = this.c;
                if (str != null) {
                    return str.equals(bVar.c);
                }
                if (bVar.c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = ((this.f25945a * 31) + this.b) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f25945a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.d);
    }

    public b(Parcel parcel) {
        this.c = "";
        this.e = "";
        this.f = "";
        this.f25945a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.d = parcel.readInt();
    }
}
