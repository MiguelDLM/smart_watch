package com.baidu.navisdk.util.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.dialog.BNDialog;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class c {

    /* loaded from: classes8.dex */
    public class a implements BNDialog.OnNaviClickListener {
        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.h.a("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BNDialog.OnNaviClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f9221a;

        public b(Activity activity) {
            this.f9221a = activity;
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            l.a(this.f9221a, 4101);
        }
    }

    public static void a() {
        Intent intent;
        Activity b2 = com.baidu.navisdk.framework.a.c().b();
        if (Build.VERSION.SDK_INT >= 22) {
            intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        } else {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$NotificationAccessSettingsActivity"));
            intent.putExtra(":settings:show_fragment", "NotificationAccessSettings");
        }
        b2.startActivity(intent);
    }

    public static boolean b() {
        String packageName = com.baidu.navisdk.framework.a.c().a().getPackageName();
        String string = Settings.Secure.getString(com.baidu.navisdk.framework.a.c().a().getContentResolver(), "enabled_notification_listeners");
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split(":")) {
                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                if (unflattenFromString != null && TextUtils.equals(packageName, unflattenFromString.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c() {
        return true;
    }

    public static BNDialog c(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        Resources resources = JarUtils.getResources();
        BNDialog bNDialog = new BNDialog(activity);
        bNDialog.setContentMessage(resources.getString(R.string.nsdk_string_power_save_mode_dialog_content));
        bNDialog.setFirstBtnText(resources.getString(R.string.nsdk_string_power_save_mode_dialog_cancel));
        bNDialog.setSecondBtnTextColorHighLight();
        bNDialog.setSecondBtnText(resources.getString(R.string.nsdk_string_power_save_mode_dialog_ok));
        bNDialog.setOnSecondBtnClickListener(new b(activity));
        try {
            if (!activity.isFinishing()) {
                bNDialog.show();
            }
        } catch (Exception unused) {
            LogUtil.e("showReq", "showRequestWriteSettingDialog dialog show failed because activity is NOT running!");
        }
        return bNDialog;
    }

    public static boolean a(Activity activity) {
        if (BNCommSettingManager.getInstance().getFloatMode() == 0) {
            if (BNSettingManager.hasPipPermission()) {
                return true;
            }
            try {
                Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                activity.startActivityForResult(intent, 3006);
                return false;
            } catch (Exception e) {
                g gVar = g.COMMON_UI;
                if (!gVar.c()) {
                    return true;
                }
                gVar.c("TAG", "checkBackgroundNaviPermission: " + e);
                return true;
            }
        }
        if (com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            return true;
        }
        b(activity);
        return false;
    }

    public static BNDialog b(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        Resources resources = JarUtils.getResources();
        BNDialog bNDialog = new BNDialog(activity);
        bNDialog.setContentMessage(resources.getString(R.string.nsdk_string_rg_float_dialog_description));
        bNDialog.setFirstBtnText(resources.getString(R.string.nsdk_string_rg_float_dialog_cancle));
        bNDialog.setSecondBtnTextColorHighLight();
        bNDialog.setSecondBtnText(resources.getString(R.string.nsdk_string_rg_float_dialog_ok));
        bNDialog.setOnSecondBtnClickListener(new a());
        try {
            if (!activity.isFinishing()) {
                bNDialog.show();
            }
        } catch (Exception unused) {
            LogUtil.e("OpenOverly", "showOpenOverlyPermissonDialog dialog show failed because activity is NOT running!");
        }
        return bNDialog;
    }
}
