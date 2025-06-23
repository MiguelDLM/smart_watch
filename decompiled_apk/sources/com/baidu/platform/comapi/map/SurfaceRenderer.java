package com.baidu.platform.comapi.map;

import android.view.SurfaceHolder;

/* loaded from: classes8.dex */
public interface SurfaceRenderer {
    void onDrawFrame(Object obj);

    void onSurfaceChanged(int i, int i2);

    void onSurfaceCreated(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    void onSurfaceDestroyed(SurfaceHolder surfaceHolder);
}
