package com.bytedance.android.openliveplugin.process.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformServerManager;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;

/* loaded from: classes8.dex */
public class LiveServerManager extends ZeusPlatformServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        TTLogger.d("LiveServerManager onCreate");
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            TTLogger.d("LiveServerManager initZeus");
            ZeusPlatformUtils.initZeus((Application) applicationContext, true, "com.byted.live.lite");
        }
        return super.onCreate();
    }
}
