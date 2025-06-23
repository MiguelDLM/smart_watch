package com.baidu.mapapi.walknavi;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f6028a;
    final /* synthetic */ WalkNavigateHelper b;

    public b(WalkNavigateHelper walkNavigateHelper, Activity activity) {
        this.b = walkNavigateHelper;
        this.f6028a = activity;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a() {
        this.b.b = com.baidu.platform.comapi.walknavi.b.a().a(this.f6028a, (Bundle) null);
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void b() {
    }
}
