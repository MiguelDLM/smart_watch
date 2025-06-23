package com.bytedance.pangle.service;

import android.app.Service;
import android.content.ComponentName;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Keep
/* loaded from: classes8.dex */
public abstract class PluginService extends Service implements a {
    private static final String TAG = "PluginService";

    @Override // com.bytedance.pangle.service.a
    public void attach(Plugin plugin) {
        boolean z;
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            if (getApplicationInfo().targetSdkVersion < 5) {
                z = true;
            } else {
                z = false;
            }
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(z));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
        }
    }

    public Object createActivityManagerProxy() {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginService.1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                String name = method.getName();
                name.hashCode();
                if (!name.equals("getForegroundServiceType")) {
                    if (!name.equals("stopServiceToken")) {
                        return null;
                    }
                    com.bytedance.pangle.service.a.a b = com.bytedance.pangle.service.a.a.b();
                    PluginService pluginService = PluginService.this;
                    return Boolean.valueOf(b.a(new ComponentName(pluginService, pluginService.getClass().getName())));
                }
                return 0;
            }
        });
    }
}
