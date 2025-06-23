package com.baidu.mapapi.bikenavi.model;

import android.app.Activity;
import android.view.View;
import com.baidu.mapapi.bikenavi.BikeNavigateHelper;
import com.baidu.platform.comapi.walknavi.b;

/* loaded from: classes7.dex */
public class BikeLightNaviManager {

    /* renamed from: a, reason: collision with root package name */
    Activity f5770a;
    private com.baidu.mapapi.bikenavi.controllers.a.a b;

    public BikeLightNaviManager(com.baidu.mapapi.bikenavi.controllers.a.a aVar) {
        this.b = aVar;
    }

    public void exitLightNavi(boolean z) {
        if (z) {
            return;
        }
        if (b.a().Y() != null) {
            b.a().Y().t();
        }
        b.a().n();
        b.a().C();
        b.a().k();
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
            this.b = null;
        }
        this.f5770a = null;
    }

    public View onCreate(Activity activity) {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            this.f5770a = activity;
            return aVar.a(activity);
        }
        return null;
    }

    public void pause() {
        b.a().j();
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void resume() {
        Activity activity = this.f5770a;
        if (activity != null && !activity.isFinishing()) {
            b.a().i();
            com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.b;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void switchLightToNormalBikeNavi() {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(true);
        }
        BikeNavigateHelper.getInstance().setIsSwitchNavi(true);
    }
}
