package com.baidu.nplatform.comapi.map;

import OXOo.OOXIXo;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.nplatform.comapi.map.v2.enlarge.EnlargeMapGLTextureViewV2;
import com.baidu.nplatform.comapi.map.v2.mapswitch.MapSwitchGLTextureViewV2;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final b f9495a = new b();

    private b() {
    }

    private final boolean c() {
        return com.baidu.navisdk.module.cloudconfig.f.c().q.f;
    }

    private final boolean d() {
        f.c0 c0Var = com.baidu.navisdk.module.cloudconfig.f.c().q;
        if ((!c0Var.f7107a || TextUtils.isEmpty(c0Var.b) || !StringsKt__StringsKt.o00xOoIO(c0Var.b, String.valueOf(Build.VERSION.SDK_INT), false, 2, null)) && !BNSettingManager.isUseTextureViewDebugEnabled()) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public final h a(@OOXIXo Context context) {
        h qVar;
        if (c()) {
            qVar = new MapSwitchGLTextureViewV2(context);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("BNWindowContainerFactory", "mNavSurfaceAndTextConfig: minimap use Base GLTextureView");
                TipTool.onCreateDebugToast(context, "全览小窗使用 基线Texture");
            }
        } else if (d()) {
            qVar = new r(context);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.c()) {
                gVar2.c("BNWindowContainerFactory", "mNavSurfaceAndTextConfig: minimap use GLTextureView");
                TipTool.onCreateDebugToast(context, "全览小窗使用 Texture");
            }
        } else {
            qVar = new q(context);
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.c()) {
                gVar3.c("BNWindowContainerFactory", "mNavSurfaceAndTextConfig: minimap use GLSurfaceView");
            }
        }
        return qVar;
    }

    public final boolean b() {
        f.c0 c0Var = com.baidu.navisdk.module.cloudconfig.f.c().q;
        if ((!c0Var.c || TextUtils.isEmpty(c0Var.d) || !StringsKt__StringsKt.o00xOoIO(c0Var.d, String.valueOf(Build.VERSION.SDK_INT), false, 2, null)) && !BNSettingManager.isUseTextureViewDebugEnabled()) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public final g a(@OOXIXo Context context, int i, int i2, float f) {
        g eVar;
        if (a()) {
            eVar = new EnlargeMapGLTextureViewV2(context);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNWindowContainerFactory", "mNavSurfaceAndTextConfig:  enlarge use Base GLTextureView");
                TipTool.onCreateDebugToast(context, "放大图使用 基线容器");
            }
        } else if (b()) {
            eVar = new c(context);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNWindowContainerFactory", "mNavSurfaceAndTextConfig: enlarge use GLTextureView");
                TipTool.onCreateDebugToast(context, "放大图使用 Texture");
            }
        } else {
            eVar = new e(context);
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("BNWindowContainerFactory", "mNavSurfaceAndTextConfig: enlarge use GLSurfaceView");
            }
        }
        return eVar;
    }

    public final boolean a() {
        return com.baidu.navisdk.module.cloudconfig.f.c().q.e;
    }
}
