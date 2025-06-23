package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* loaded from: classes13.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new oIX0oI();

    /* renamed from: a, reason: collision with root package name */
    public static String f26512a = "https://android.bugly.qq.com/rqd/async";
    public static String b = "https://android.bugly.qq.com/rqd/async";
    public static String c;
    public long d;
    public long e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public long p;
    public String q;
    public String r;
    public String s;
    public Map<String, String> t;
    public int u;
    public long v;
    public long w;

    /* loaded from: classes13.dex */
    public static class oIX0oI implements Parcelable.Creator<StrategyBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i) {
            return new StrategyBean[i];
        }
    }

    public StrategyBean() {
        this.d = -1L;
        this.e = -1L;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = 30000L;
        this.q = f26512a;
        this.r = b;
        this.u = 10;
        this.v = 300000L;
        this.w = -1L;
        this.e = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L@)");
        c = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K@!");
        this.s = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.e);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        ap.b(parcel, this.t);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeInt(this.u);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
    }

    public StrategyBean(Parcel parcel) {
        this.d = -1L;
        this.e = -1L;
        boolean z = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = 30000L;
        this.q = f26512a;
        this.r = b;
        this.u = 10;
        this.v = 300000L;
        this.w = -1L;
        try {
            c = "S(@L@L@)";
            this.e = parcel.readLong();
            this.f = parcel.readByte() == 1;
            this.g = parcel.readByte() == 1;
            this.h = parcel.readByte() == 1;
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.t = ap.b(parcel);
            this.i = parcel.readByte() == 1;
            this.j = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.p = parcel.readLong();
            this.k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.l = z;
            this.o = parcel.readLong();
            this.u = parcel.readInt();
            this.v = parcel.readLong();
            this.w = parcel.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
