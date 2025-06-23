package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.g;
import com.baidu.navisdk.pronavi.data.model.d;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.z;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.a f;
    private boolean g;

    /* loaded from: classes7.dex */
    public class a implements z.i {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.z.i
        public void a(int i, z.h hVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("IntervalSpeedPanel", "setIntervalCameraVisibility->animationEnd callback,animType=" + hVar);
            }
            if (hVar == z.h.EXIT) {
                b.this.v();
            }
        }
    }

    public b(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
        this.g = false;
    }

    private void b(Bundle bundle) {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.a aVar = this.f;
        if (aVar != null) {
            aVar.a(bundle);
            return;
        }
        if (bundle != null && bundle.getInt("KEY_TYPE", 0) == 4383) {
            g.o().f().c(bundle.getInt("KEY_INTERVAL_CAMERA_SPEED_LIMIT", 0));
            g.o().f().a(bundle.getInt("KEY_INTERVAL_CAMERA_LENGTH", -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
        if (com.baidu.navisdk.ui.routeguide.ace.a.m().g() != null && com.baidu.navisdk.ui.routeguide.ace.a.m().g().getValue() != null) {
            com.baidu.navisdk.ui.routeguide.ace.g value = com.baidu.navisdk.ui.routeguide.ace.a.m().g().getValue();
            if (value.c()) {
                this.f7853a.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 2).a();
                return;
            } else if (value.b()) {
                this.f7853a.j().e("RGBucketGroupComponent").a(2017).a(Boolean.TRUE).b((Object) 1).a();
                return;
            } else {
                this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
                return;
            }
        }
        this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (j() || !BNSettingManager.isMeasurementEnable() || !com.baidu.navisdk.ui.routeguide.b.V().x()) {
            return 8;
        }
        if (!g.o().g()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IntervalSpeedPanel", "visibility: not hasIntervalCamera");
            }
            return 8;
        }
        if (a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("IntervalSpeedPanel", "visibility: isYawing");
            }
            return 8;
        }
        if (((com.baidu.navisdk.pronavi.data.model.d) this.f7853a.b(com.baidu.navisdk.pronavi.data.model.d.class)).a().getValue() == d.a.ENTER) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("IntervalSpeedPanel", "visibility: is in highSpped");
            }
            return 8;
        }
        if (!b(RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap)) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public boolean isInterceptSetVisible(int i) {
        return i == 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean m() {
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean n() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.a aVar = this.f;
        if (aVar != null) {
            aVar.b();
            this.f = null;
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onInterceptSetVisible(@Nullable View view, int i) {
        super.onInterceptSetVisible(view, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IntervalSpeedPanel", "onInterceptSetVisible: " + i);
        }
        if (this.g) {
            this.f.a(new a());
        } else {
            v();
        }
        this.g = false;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.a aVar = this.f;
            if (aVar != null) {
                aVar.c();
                this.f.d();
            }
            this.f7853a.j().e("RGBucketGroupComponent").a(1017).a((Object) 2).a();
            this.f7853a.j().e("RGBucketGroupComponent").a(2017).a(Boolean.FALSE).a();
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.19.1", "0");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.19.1", "1");
        }
        this.g = false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        int i2;
        if (i == 2) {
            i = 1;
        }
        if (i != 2) {
            i2 = R.layout.bnav_interval_camera_layout;
        } else {
            i2 = R.layout.bnav_interval_camera_layout_land;
        }
        View inflate = JarUtils.inflate(context, i2, viewGroup, false);
        this.f = new com.baidu.navisdk.pronavi.ui.bucket.item.concrete.intervalspeed.a(context, inflate, i);
        return inflate;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i != 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_4dp);
        }
        return 0;
    }

    public void a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("IntervalSpeedPanel", "updatePanel: " + bundle + "mIntervalSpeedHolder = " + this.f);
        }
        int i = bundle.getInt("KEY_TYPE");
        if (i == 4383) {
            refreshVisible();
        } else if (i == 4385) {
            this.g = true;
            refreshVisible();
        }
        b(bundle);
    }
}
