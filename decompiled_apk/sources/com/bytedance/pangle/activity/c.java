package com.bytedance.pangle.activity;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(b bVar, Bundle bundle) {
        String str;
        List<String> list;
        if (!Zeus.hasInit()) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        Intent intent = bVar.getIntent();
        String pluginPkgName = bVar.getPluginPkgName();
        Plugin plugin = bVar.getPlugin();
        if (plugin == null) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            bVar.zeusSuperOnCreate(null);
            bVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.a(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(bVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (plugin.isLoaded() && !TextUtils.isEmpty(stringExtra)) {
            ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
            if (activityInfo == null) {
                ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
                bVar.zeusSuperOnCreate(null);
                bVar.finish();
            }
            int i = -1;
            try {
                IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
                FieldUtils.writeField(iPluginActivity, "mApplication", bVar.getApplication());
                bVar.setTargetActivity(iPluginActivity);
                iPluginActivity.setPluginProxyActivity(bVar, plugin);
                i = activityInfo.theme;
                bVar.zeusSuperSetTheme(i);
                TypedArray obtainStyledAttributes = ((Activity) bVar).getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
                if (obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(0), false)) {
                    a((Activity) bVar);
                }
                obtainStyledAttributes.recycle();
                iPluginActivity.attachBaseContext(bVar.getBaseContext());
                try {
                    int requestedOrientation = ((Activity) bVar).getRequestedOrientation();
                    int i2 = activityInfo.screenOrientation;
                    if (requestedOrientation != i2) {
                        ((Activity) bVar).setRequestedOrientation(i2);
                    }
                } catch (IllegalStateException unused) {
                }
                iPluginActivity.onCreate(bundle);
                return;
            } catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    str = "activityTheme:".concat(String.valueOf(i));
                } else {
                    str = "";
                }
                throw new RuntimeException(str, e);
            }
        }
        try {
            bVar.zeusSuperOnCreate(null);
            ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
            bVar.finish();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void a(b bVar, Context context) {
        if (!Zeus.hasInit()) {
            Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            bVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = bVar.getPluginPkgName();
        boolean loadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            bVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (loadPlugin) {
                bVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(bVar, "mResources", (Object) null);
            } else {
                bVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void a(Activity activity, View view) {
        Object readField;
        if (view == null) {
            return;
        }
        try {
            Object readField2 = FieldUtils.readField(view, "mListenerInfo");
            if (readField2 != null && (readField = FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                String name = readField.getClass().getName();
                if (!name.startsWith(AppCompatViewInflater.class.getName())) {
                    if (name.startsWith(View.class.getName())) {
                    }
                }
                view.setOnClickListener(new a(activity, view.getId(), (String) FieldUtils.readField(readField, "mMethodName")));
            }
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            e.printStackTrace();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    private static Class a() {
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void a(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", a(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, null));
        } catch (Throwable unused) {
        }
    }
}
