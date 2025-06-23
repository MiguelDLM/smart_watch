package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f19443a;
    final /* synthetic */ a b;

    public b(a aVar, boolean z) {
        this.b = aVar;
        this.f19443a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.d.getPOFactory(this.f19443a, true);
            this.b.b = true;
        } catch (e e) {
            GDTLogger.e(e.getMessage(), e);
        }
    }
}
