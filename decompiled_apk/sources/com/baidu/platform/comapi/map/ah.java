package com.baidu.platform.comapi.map;

import android.content.Context;
import android.view.SurfaceView;
import com.baidu.platform.comapi.util.EglConfigUtils;

/* loaded from: classes8.dex */
public class ah {

    /* loaded from: classes8.dex */
    public enum a {
        OPENGL_ES,
        VULKAN,
        AUTO
    }

    public static ag a(SurfaceView surfaceView, a aVar, boolean z, Context context) {
        int i;
        int i2;
        f fVar = new f(surfaceView);
        fVar.c(3);
        if (!z) {
            i = 0;
            i2 = 0;
        } else {
            i = 1;
            i2 = 4;
        }
        try {
            if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 8)) {
                fVar.a(8, 8, 8, 8, 24, 8, i, i2);
            } else {
                fVar.b(true);
            }
        } catch (IllegalArgumentException unused) {
            fVar.b(true);
        }
        fVar.a(true);
        return fVar;
    }
}
