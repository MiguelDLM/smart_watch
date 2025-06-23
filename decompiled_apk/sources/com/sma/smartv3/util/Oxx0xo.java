package com.sma.smartv3.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class Oxx0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f24317II0xO0 = 1001;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oxx0xo f24318oIX0oI = new Oxx0xo();

    public final boolean I0Io(@OXOo.oOoXoXO Object obj) {
        return obj == null;
    }

    public final boolean II0xO0(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        try {
            Object invoke = Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
            kotlin.jvm.internal.IIX0o.x0XOIxOo(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            Log.e("ServiceUtils", Log.getStackTraceString(e));
            return true;
        }
    }

    public final void oIX0oI(@OXOo.OOXIXo Activity context, @OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> block) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(block, "block");
        if (II0xO0(context)) {
            block.invoke();
            return;
        }
        Toast.makeText(context, "请开启悬浮窗权限", 0).show();
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivityForResult(intent, 1001);
    }

    public final boolean oxoX(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String ServiceName) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ServiceName, "ServiceName");
        if (TextUtils.isEmpty(ServiceName)) {
            return false;
        }
        Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(1000);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(runningServices, "null cannot be cast to non-null type java.util.ArrayList<android.app.ActivityManager.RunningServiceInfo>");
        ArrayList arrayList = (ArrayList) runningServices;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((ActivityManager.RunningServiceInfo) arrayList.get(i)).service.getClassName(), ServiceName)) {
                return true;
            }
        }
        return false;
    }
}
