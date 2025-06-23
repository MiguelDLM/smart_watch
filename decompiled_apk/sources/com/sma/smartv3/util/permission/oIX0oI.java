package com.sma.smartv3.util.permission;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.blankj.utilcode.util.RomUtils;
import com.sma.smartv3.util.permission.PermissionFragment;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f24541I0Io = 101;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final String f24542II0xO0 = "AUTO_RUN";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f24543oIX0oI = new oIX0oI();

    @x0XOIxOo
    public static final boolean Oxx0IOOO(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return false;
    }

    @x0XOIxOo
    public static final void xxIXOIIO(@OOXIXo Activity activity, @OOXIXo X0o0xo onPermissionResult) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(onPermissionResult, "onPermissionResult");
        PermissionFragment.f24520XO.II0xO0(activity, PermissionFragment.PermissionType.AUTO_RUN, onPermissionResult);
    }

    public final void I0Io(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        Intent intent = new Intent();
        try {
            try {
                intent.setClassName("com.oppo.safe", "com.oppo.safe.SecureSafeMainActivity");
                fragment.startActivityForResult(intent, 101);
            } catch (Throwable unused) {
                intent.setComponent(ComponentName.unflattenFromString("com.coloros.safecenter/.startupapp.StartupAppListActivity"));
                fragment.startActivityForResult(intent, 101);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.SecureSafeMainActivity"));
                fragment.startActivityForResult(intent2, 101);
            } catch (Exception unused2) {
                II0XooXoX(fragment);
            }
        }
    }

    public final void II0XooXoX(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Uri fromParts = Uri.fromParts("package", fragment.getActivity().getPackageName(), null);
        IIX0o.oO(fromParts, "fromParts(...)");
        intent.setData(fromParts);
        fragment.startActivityForResult(intent, 101);
    }

    public final void II0xO0(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        Intent intent = new Intent();
        try {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.meizu.safe/.permission.SmartBGActivity"));
                fragment.startActivityForResult(intent, 101);
            } catch (Exception unused) {
                intent.setComponent(ComponentName.unflattenFromString("com.meizu.safe/.permission.PermissionMainActivity"));
                fragment.startActivityForResult(intent, 101);
            }
        } catch (Exception unused2) {
            II0XooXoX(fragment);
        }
    }

    public final void X0o0xo(@OOXIXo Fragment fragment) {
        ComponentName unflattenFromString;
        IIX0o.x0xO0oo(fragment, "fragment");
        Intent intent = new Intent();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                unflattenFromString = ComponentName.unflattenFromString("com.vivo.permissionmanager/.activity.PurviewTabActivity");
            } else {
                unflattenFromString = ComponentName.unflattenFromString("com.iqoo.secure/.ui.phoneoptimize.SoftwareManagerActivity");
            }
            intent.setComponent(unflattenFromString);
            fragment.startActivityForResult(intent, 101);
        } catch (Exception e) {
            e.printStackTrace();
            II0XooXoX(fragment);
        }
    }

    public final void XO(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        try {
            II0XooXoX(fragment);
        } catch (Exception unused) {
            Intent intent = new Intent();
            try {
                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                fragment.startActivityForResult(intent, 101);
            } catch (Exception unused2) {
            }
        }
    }

    public final void oIX0oI(@OOXIXo Fragment fragment) {
        ComponentName unflattenFromString;
        IIX0o.x0xO0oo(fragment, "fragment");
        int i = Build.VERSION.SDK_INT;
        try {
            Intent intent = new Intent();
            if (i >= 28) {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
            } else if (i >= 26) {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity");
            } else if (i >= 23) {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
            } else {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity");
            }
            intent.setComponent(unflattenFromString);
            fragment.startActivityForResult(intent, 101);
        } catch (Exception unused) {
            II0XooXoX(fragment);
        }
    }

    public final void oxoX(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        Intent intent = new Intent();
        try {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.samsung.android.sm/.app.dashboard.SmartManagerDashBoardActivity"));
                fragment.startActivityForResult(intent, 101);
            } catch (Exception unused) {
                intent.setComponent(ComponentName.unflattenFromString("com.samsung.android.sm_cn/com.samsung.android.sm.ui.cstyleboard.SmartManagerDashBoardActivity"));
                fragment.startActivityForResult(intent, 101);
            }
        } catch (Exception unused2) {
            II0XooXoX(fragment);
        }
    }

    public final void xoIox(@OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        if (RomUtils.isHuawei()) {
            oIX0oI(fragment);
            return;
        }
        if (RomUtils.isXiaomi()) {
            XO(fragment);
            return;
        }
        if (RomUtils.isSamsung()) {
            oxoX(fragment);
            return;
        }
        if (RomUtils.isMeizu()) {
            II0xO0(fragment);
            return;
        }
        if (RomUtils.isVivo()) {
            X0o0xo(fragment);
        } else if (RomUtils.isOppo()) {
            I0Io(fragment);
        } else {
            II0XooXoX(fragment);
        }
    }
}
