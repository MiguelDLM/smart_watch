package com.sma.smartv3.util.permission;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.util.permission.PermissionFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f24544II0xO0 = 201;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oxoX f24545oIX0oI = new oxoX();

    @x0XOIxOo
    public static final void I0Io(@OOXIXo Activity activity, @OOXIXo X0o0xo onPermissionResult) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(onPermissionResult, "onPermissionResult");
        PermissionFragment.f24520XO.II0xO0(activity, PermissionFragment.PermissionType.BATTERY_OPTIMIZATIONS, onPermissionResult);
    }

    @x0XOIxOo
    public static final boolean II0xO0(@OOXIXo Context context) {
        boolean isIgnoringBatteryOptimizations;
        IIX0o.x0xO0oo(context, "context");
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
            isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
            return isIgnoringBatteryOptimizations;
        }
        return false;
    }

    public final void oIX0oI(@OOXIXo Fragment fragment) {
        Context context;
        IIX0o.x0xO0oo(fragment, "fragment");
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                StringBuilder sb = new StringBuilder();
                sb.append("package:");
                context = fragment.getContext();
                sb.append(context.getPackageName());
                intent.setData(Uri.parse(sb.toString()));
                fragment.startActivityForResult(intent, 201);
            } else {
                ToastUtils.showLong("VERSION.SDK_INT < M", new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void oxoX(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        oIX0oI(fragment);
    }
}
