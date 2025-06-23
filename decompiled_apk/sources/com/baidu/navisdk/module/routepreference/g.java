package com.baidu.navisdk.module.routepreference;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.navisdk.adapter.struct.VehicleConstant;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.huawei.openalliance.ad.constant.x;

/* loaded from: classes7.dex */
public class g extends b implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public String f7483a = "";
    public int b = 0;
    public int c = 0;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    private h q = new h();

    public void a(Bundle bundle, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("CarPlateModel", "updateCarPlate :" + bundle.toString());
        }
        String string = bundle.getString(VehicleConstant.PlateBundleKey.PLATE, null);
        int i2 = bundle.getInt("etcClass", -1);
        int i3 = bundle.getInt("etcColor", -1);
        int i4 = bundle.getInt("isEtc", -1);
        int i5 = bundle.getInt("ext_tag", 0);
        int i6 = bundle.getInt("carType", 0);
        this.f7483a = bundle.getString("pass_ids", "");
        this.b = i6;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.k = bundle.getString(x.cD, "");
        this.l = bundle.getString("brand", "");
        this.m = bundle.getString("brandModel", "");
        this.n = bundle.getString("brandName", "");
        this.o = bundle.getString("carIcon", "");
        this.i = bundle.getInt("brandId", 0);
        this.h = bundle.getInt("brandModelId", 0);
        this.j = bundle.getInt("newEnergyTag", 0);
        String string2 = bundle.getString("newEnergyExt", "");
        this.p = string2;
        this.q = h.a(this.l, string2);
        this.c = i;
        setPlateInfo(string, i);
        parseBaseParam(bundle);
    }

    public int b() {
        return BNSettingManager.getNewEnergyRemainMileage();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f != gVar.f || this.g != gVar.g || this.e != gVar.e || this.d != gVar.d || this.b != gVar.b || this.j != gVar.j || !this.n.equals(gVar.n) || this.i != gVar.i || !this.l.equals(gVar.l) || !this.m.equals(gVar.m) || !this.k.equals(gVar.k) || !this.p.equals(gVar.p) || this.j != gVar.j || !this.q.equals(gVar.q) || !TextUtils.equals(this.areaPlate, gVar.areaPlate)) {
            return false;
        }
        return !isPassportChanged(this.f7483a, gVar.f7483a);
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public int getExtTag() {
        return this.g;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public Bundle[] getPassportIds() {
        return parsePassportIds(this.f7483a);
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public String toString() {
        return "CarPlateModel{plateModel='" + super.toString() + ", mPassportIds='" + this.f7483a + "', mCarType=" + this.b + ", mCutCarType=" + this.c + ", mEtcClass=" + this.d + ", mEtcColor=" + this.e + ", isEtc=" + this.f + ", isPickUp=" + this.g + ", brandId=" + this.i + ", brandModelId=" + this.h + ", newEnergyTag=" + this.j + ", icon='" + this.k + "', brand='" + this.l + "', brandModel='" + this.m + "', brandName='" + this.n + "', carIcon='" + this.o + "', newEnergyExt='" + this.p + "', chargingPrefer=" + this.q + "', remainMile=" + b() + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.i);
        parcel.writeInt(this.h);
        parcel.writeInt(this.j);
        parcel.writeString(this.areaPlate);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public g m94clone() {
        g gVar = new g();
        gVar.f7483a = this.f7483a;
        gVar.f = this.f;
        gVar.g = this.g;
        gVar.b = this.b;
        gVar.d = this.d;
        gVar.e = this.e;
        gVar.k = this.k;
        gVar.l = this.l;
        gVar.m = this.m;
        gVar.n = this.n;
        gVar.o = this.o;
        gVar.j = this.j;
        gVar.i = this.i;
        gVar.h = this.h;
        gVar.p = this.p;
        h hVar = this.q;
        gVar.q = hVar == null ? new h() : hVar.m95clone();
        gVar.setPlateInfo(getPlate(this.c), this.c);
        clone(gVar);
        return gVar;
    }

    @NonNull
    public h a() {
        return this.q;
    }

    public void a(@NonNull h hVar) {
        this.q = hVar;
    }
}
