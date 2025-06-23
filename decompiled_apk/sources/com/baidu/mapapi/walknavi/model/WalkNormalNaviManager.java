package com.baidu.mapapi.walknavi.model;

import android.app.Activity;
import android.view.View;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.platform.comapi.walknavi.b;

/* loaded from: classes7.dex */
public class WalkNormalNaviManager {

    /* renamed from: a, reason: collision with root package name */
    Activity f6040a;
    private com.baidu.mapapi.walknavi.controllers.a.a b;

    public WalkNormalNaviManager(com.baidu.mapapi.walknavi.controllers.a.a aVar) {
        this.b = aVar;
    }

    public void exitNormalNavi(boolean z) {
        if (z) {
            com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
            if (aVar != null) {
                aVar.a(false);
            }
            WalkNavigateHelper.getInstance().setIsSwitchNavi(true);
            return;
        }
        if (b.a().Y() != null) {
            b.a().Y().t();
        }
        if (this.b != null && WalkNavigateHelper.getInstance().isInit()) {
            this.b.g();
            this.b.h();
        }
        b.a().n();
        b.a().C();
        b.a().k();
        com.baidu.mapapi.walknavi.controllers.a.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.f();
            this.b = null;
        }
        this.f6040a = null;
    }

    public View onCreate(Activity activity) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            this.f6040a = activity;
            return aVar.a(activity);
        }
        return null;
    }

    public void pause() {
        b.a().j();
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void resume() {
        Activity activity = this.f6040a;
        if (activity != null && !activity.isFinishing()) {
            b.a().i();
            com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
            if (aVar != null) {
                aVar.e();
            }
        }
    }
}
