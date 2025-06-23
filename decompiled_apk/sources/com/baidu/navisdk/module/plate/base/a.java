package com.baidu.navisdk.module.plate.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0274a();

    /* renamed from: a, reason: collision with root package name */
    public String f7385a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;
    public c n;
    private List<a> o;

    /* renamed from: com.baidu.navisdk.module.plate.base.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0274a implements Parcelable.Creator<a> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f7386a;
        private String b;

        public b() {
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.f7386a;
        }

        public String c() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start", this.f7386a);
                jSONObject.put("end", this.b);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }

        public String toString() {
            return "charge{start:\"" + this.f7386a + "\", end:\"" + this.b + "\"}";
        }

        public b(String str, String str2) {
            this.f7386a = str;
            this.b = str2;
        }

        public void a(String str) {
            this.b = str;
        }

        public void b(String str) {
            this.f7386a = str;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f7387a;
        private ArrayList<Integer> b;
        private String c;
        private b d;

        public void a(int i) {
            this.f7387a = i;
        }

        public b b() {
            return this.d;
        }

        public int c() {
            return this.f7387a;
        }

        public ArrayList<Integer> d() {
            return this.b;
        }

        public String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mileage", this.f7387a);
                jSONObject.put("pile", this.b);
                jSONObject.put("brand_pile", this.c);
                jSONObject.put("charge", this.d.c());
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }

        public String toString() {
            return "NewEnergyPlateBean{mileage='" + this.f7387a + "', pile='" + this.b + "', brandPile=" + this.c + ", charge=" + this.d + '}';
        }

        public void a(ArrayList<Integer> arrayList) {
            this.b = arrayList;
        }

        public String a() {
            return this.c;
        }

        public void a(String str) {
            this.c = str;
        }

        public void a(b bVar) {
            this.d = bVar;
        }
    }

    public a() {
        this.e = "";
        this.f = "";
        this.o = new ArrayList();
    }

    public String a() {
        return this.e;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.d;
    }

    public c f() {
        return this.n;
    }

    public String g() {
        return this.f7385a;
    }

    public String toString() {
        return "BasePlateBean{plate='" + this.f7385a + "', brandName='" + this.b + "', brandId='" + this.c + "', icon='" + this.d + "', brand='" + this.e + "', brandModel='" + this.f + "', carDefault=" + this.g + ", isLimit=" + this.h + ", tag=" + this.i + ", vehicle=" + this.j + ", extTag=" + this.k + ", newEnergyTag=" + this.l + ", newEnergyExt=" + this.n + ", carData=" + this.o + ", multiFlag=" + this.m + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.f7385a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.m);
        parcel.writeValue(this.n);
    }

    public a(Parcel parcel) {
        this.e = "";
        this.f = "";
        this.o = new ArrayList();
        this.f7385a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.o = parcel.createTypedArrayList(CREATOR);
    }
}
