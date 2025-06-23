package com.baidu.platform.comapi.walknavi.f;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f9754a = new Bundle();

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public void a(int i, int i2, int i3) {
        this.f9754a.putInt("start_x", i);
        this.f9754a.putInt("start_y", i2);
        this.f9754a.putInt("start_cityid", i3);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public void b(int i) {
        this.f9754a.putInt("wnavi_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public void c(int i) {
        this.f9754a.putInt("route_data_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public int[] b(String str) {
        return this.f9754a.getIntArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public void a(int[] iArr, int[] iArr2, int[] iArr3) {
        this.f9754a.putIntArray("end_x", iArr);
        this.f9754a.putIntArray("end_y", iArr2);
        this.f9754a.putIntArray("end_cityid", iArr3);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public void a(int i) {
        this.f9754a.putInt("vehicle", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public byte[] a(String str) {
        return this.f9754a.getByteArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.a
    public int a(String str, int i) {
        return this.f9754a.getInt(str, i);
    }
}
