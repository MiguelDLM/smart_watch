package com.baidu.platform.comapi.walknavi.widget.a;

import android.widget.CompoundButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class s implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9875a;

    public s(a aVar) {
        this.f9875a = aVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            com.baidu.platform.comapi.walknavi.b.a().O().b("six_dof_ar_auto", true);
            this.f9875a.j = true;
        } else {
            com.baidu.platform.comapi.walknavi.b.a().O().b("six_dof_ar_auto", false);
            this.f9875a.j = false;
        }
    }
}
