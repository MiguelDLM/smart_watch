package com.baidu.mapapi.bikenavi.model;

import android.app.Activity;
import android.view.View;
import com.baidu.mapapi.bikenavi.BikeNavigateHelper;
import com.baidu.platform.comapi.walknavi.b;

/* loaded from: classes7.dex */
public class BikeNormalNaviManager {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.mapapi.bikenavi.controllers.a.a f5771a;
    private Activity b;

    public BikeNormalNaviManager(com.baidu.mapapi.bikenavi.controllers.a.a aVar) {
        this.f5771a = aVar;
    }

    public void exitNormalNavi(boolean z) {
        if (z) {
            com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f5771a;
            if (aVar != null) {
                aVar.a(false);
            }
            BikeNavigateHelper.getInstance().setIsSwitchNavi(true);
            return;
        }
        if (b.a().Y() != null) {
            b.a().Y().t();
        }
        b.a().n();
        b.a().C();
        b.a().k();
        com.baidu.mapapi.bikenavi.controllers.a.a aVar2 = this.f5771a;
        if (aVar2 != null) {
            aVar2.d();
            this.f5771a = null;
        }
        this.b = null;
    }

    public View onCreate(Activity activity) {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f5771a;
        if (aVar != null) {
            this.b = activity;
            return aVar.a(activity);
        }
        return null;
    }

    public void pause() {
        b.a().j();
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f5771a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void resume() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            b.a().i();
            com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f5771a;
            if (aVar != null) {
                aVar.c();
            }
        }
    }
}
