package com.baidu.platform.comapi.walknavi.f;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f9755a = new Bundle();

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void a(int i, int i2, int i3) {
        this.f9755a.putInt("start_x", i);
        this.f9755a.putInt("start_y", i2);
        this.f9755a.putInt("start_cityid", i3);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void b(int i) {
        this.f9755a.putInt("wnavi_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void c(int i) {
        this.f9755a.putInt("wnavi_extra_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void d(int i) {
        this.f9755a.putInt("route_data_mode", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public int[] b(String str) {
        return this.f9755a.getIntArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public String[] c(String str) {
        return this.f9755a.getStringArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void a(int i, int i2, int i3, String str, String str2) {
        this.f9755a.putInt("start_x", i);
        this.f9755a.putInt("start_y", i2);
        this.f9755a.putInt("start_cityid", i3);
        this.f9755a.putString("start_floor", str);
        this.f9755a.putString("start_building", str2);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void a(int[] iArr, int[] iArr2, int[] iArr3) {
        this.f9755a.putIntArray("end_x", iArr);
        this.f9755a.putIntArray("end_y", iArr2);
        this.f9755a.putIntArray("end_cityid", iArr3);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void a(int[] iArr, int[] iArr2, int[] iArr3, String[] strArr, String[] strArr2) {
        this.f9755a.putIntArray("end_x", iArr);
        this.f9755a.putIntArray("end_y", iArr2);
        this.f9755a.putIntArray("end_cityid", iArr3);
        this.f9755a.putStringArray("end_floor", strArr);
        this.f9755a.putStringArray("end_building", strArr2);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void a(int i) {
        this.f9755a.putInt("launched_from", i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public void a(byte[] bArr) {
        this.f9755a.putByteArray("route_buff", bArr);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public byte[] a(String str) {
        return this.f9755a.getByteArray(str);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public int a(String str, int i) {
        return this.f9755a.getInt(str, i);
    }

    @Override // com.baidu.platform.comapi.walknavi.f.c
    public String a(String str, String str2) {
        return this.f9755a.getString(str, str2);
    }
}
