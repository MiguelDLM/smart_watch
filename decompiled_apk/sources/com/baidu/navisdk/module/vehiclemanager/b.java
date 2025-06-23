package com.baidu.navisdk.module.vehiclemanager;

import com.baidu.navisdk.framework.interfaces.t;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    private int f7606a;
    private int b;

    /* renamed from: com.baidu.navisdk.module.vehiclemanager.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0301b {

        /* renamed from: a, reason: collision with root package name */
        private static final t f7607a = new b();
    }

    public static t i() {
        return C0301b.f7607a;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public void a(int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNVehicleManager", "updateVehicle(), current mVehicle = " + this.f7606a + ", set vehicle = " + i + ",mSubVehicle = " + this.b + ", set subVehicle = " + i2 + ",source:" + com.baidu.navisdk.module.vehiclemanager.a.a(i3));
            if (i != 1 && i != 2 && i != 3) {
                throw new IllegalArgumentException(String.format("BNVehicleManager updateVehicle vehicle value(%d) exception", Integer.valueOf(i)));
            }
        }
        this.f7606a = i;
        this.b = i2;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public int b() {
        return this.f7606a;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public String c() {
        int i = this.f7606a;
        if (i == 2) {
            return "motor";
        }
        if (i == 3) {
            return "truck";
        }
        return "car";
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public boolean d() {
        if (this.f7606a == 2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public boolean e() {
        if (this.f7606a == 1 && this.b == 0) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public boolean f() {
        if (this.f7606a == 1) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public boolean g() {
        if (this.f7606a == 1 && this.b == 1) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public boolean h() {
        if (this.f7606a == 3) {
            return true;
        }
        return false;
    }

    private b() {
        this.f7606a = 1;
        this.b = 0;
    }

    @Override // com.baidu.navisdk.framework.interfaces.t
    public int a() {
        return this.b;
    }
}
