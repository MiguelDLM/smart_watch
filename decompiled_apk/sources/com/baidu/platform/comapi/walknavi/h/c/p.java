package com.baidu.platform.comapi.walknavi.h.c;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.baidu.mapapi.PermissionUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class p extends com.baidu.platform.comapi.wnplatform.p.q {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9788a;

    public p(c cVar) {
        this.f9788a = cVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.p.q
    public void a(View view) {
        Context context;
        Context context2;
        if (!PermissionUtils.getInstance().isWalkARNaviAuthorized()) {
            context = this.f9788a.l;
            if (context != null) {
                context2 = this.f9788a.l;
                Toast.makeText(context2, "没有AR步行导航权限", 0).show();
                return;
            }
        }
        this.f9788a.o();
    }
}
