package com.baidu.navisdk.module.newguide.settings.customguideui;

import android.widget.CompoundButton;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f7239a;
    private String b;
    private boolean c;
    private CompoundButton.OnCheckedChangeListener d;
    private a e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, boolean z);
    }

    public b(int i, String str, a aVar, boolean z) {
        this.f7239a = i;
        this.b = str;
        this.c = z;
        this.e = aVar;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public int b() {
        return this.f7239a;
    }

    public String c() {
        return this.b;
    }

    public a d() {
        return this.e;
    }

    public String toString() {
        return "ImageRecyclerViewItem{imageId=" + this.f7239a + ", imageText='" + this.b + "', isChecked=" + this.c + ", checkedLogic=" + this.d + '}';
    }

    public boolean a() {
        return this.c;
    }
}
