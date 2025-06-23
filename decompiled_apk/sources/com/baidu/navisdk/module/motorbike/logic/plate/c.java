package com.baidu.navisdk.module.motorbike.logic.plate;

import android.os.Bundle;
import com.baidu.navisdk.adapter.struct.VehicleConstant;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.module.routepreference.b {

    /* renamed from: a, reason: collision with root package name */
    public String f7198a;
    public int b;
    public int c;
    public int d;

    public c() {
        this.d = -1;
    }

    public boolean a() {
        return this.c == 2;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.c != cVar.c || this.b != cVar.b || this.d != cVar.d) {
            return false;
        }
        if (getPlate() == null ? cVar.getPlate() != null : !getPlate().equals(cVar.getPlate())) {
            return false;
        }
        return Objects.equals(this.f7198a, cVar.f7198a);
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public int hashCode() {
        int i;
        int i2 = 0;
        if (getPlate() != null) {
            i = getPlate().hashCode();
        } else {
            i = 0;
        }
        int i3 = ((i * 31) + this.c) * 31;
        String str = this.f7198a;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((i3 + i2) * 31) + this.b;
    }

    @Override // com.baidu.navisdk.module.routepreference.b
    public String toString() {
        return "MotorPlateModel{plate='" + getPlate() + "', plateType=" + this.c + ", carCC=" + this.f7198a + ", truckType=" + this.b + ", isEtc=" + this.d + '}';
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        setPlateInfo(cVar.getPlate());
        this.c = cVar.c;
        this.f7198a = cVar.f7198a;
        this.b = cVar.b;
        this.d = cVar.d;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorPlateModel", "copy: " + toString());
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c m93clone() {
        c cVar = new c();
        cVar.setPlateInfo(getPlate());
        cVar.c = this.c;
        cVar.f7198a = this.f7198a;
        cVar.b = this.b;
        cVar.d = this.d;
        return cVar;
    }

    public c(Bundle bundle) {
        this.d = -1;
        a(bundle);
    }

    public c(c cVar) {
        this.d = -1;
        if (cVar == null) {
            return;
        }
        setPlateInfo(cVar.getPlate());
        this.c = cVar.c;
        this.f7198a = cVar.f7198a;
        this.b = cVar.b;
        this.d = cVar.d;
    }

    public void a(Bundle bundle) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorPlateModel", "parseBundle: " + bundle);
        }
        if (bundle == null || !bundle.containsKey(VehicleConstant.PlateBundleKey.PLATE)) {
            return;
        }
        String string = bundle.getString(VehicleConstant.PlateBundleKey.PLATE, "");
        int i = bundle.getInt("plateType", 0);
        setPlateInfo(string);
        this.c = i;
        this.b = bundle.getInt("motorType", 0);
        this.f7198a = bundle.getString("displacement", "");
        this.d = bundle.getInt("isEtc", -1);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorPlateModel", "parseBundle: " + toString());
        }
    }
}
