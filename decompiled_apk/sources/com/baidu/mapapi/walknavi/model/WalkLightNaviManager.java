package com.baidu.mapapi.walknavi.model;

import android.app.Activity;
import android.view.View;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.platform.comapi.walknavi.b;

/* loaded from: classes7.dex */
public class WalkLightNaviManager {

    /* renamed from: a, reason: collision with root package name */
    Activity f6038a;
    private com.baidu.mapapi.walknavi.controllers.a.a b;

    public WalkLightNaviManager(com.baidu.mapapi.walknavi.controllers.a.a aVar) {
        this.b = aVar;
    }

    public void exitLightNavi(boolean z) {
        if (z) {
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
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            aVar.f();
            this.b = null;
        }
        this.f6038a = null;
    }

    public View onCreate(Activity activity) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            this.f6038a = activity;
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
        Activity activity = this.f6038a;
        if (activity != null && !activity.isFinishing()) {
            b.a().i();
            com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    public void switchLightToNormalWalkNavi() {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(true);
        }
        WalkNavigateHelper.getInstance().setIsSwitchNavi(true);
    }
}
