package com.baidu.navisdk.util.common;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/* loaded from: classes8.dex */
public class l {
    public static boolean a(Context context, int i) {
        try {
            Settings.System.putInt(context.getContentResolver(), "screen_brightness", i);
            context.getContentResolver().notifyChange(Settings.System.getUriFor("screen_brightness"), null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int b(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode");
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static boolean c(Context context) {
        boolean canWrite;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context != null) {
            try {
                canWrite = Settings.System.canWrite(context);
            } catch (Exception unused) {
            }
            if (canWrite) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean b(Context context, int i) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Settings.System.putInt(contentResolver, "screen_brightness_mode", i);
            contentResolver.notifyChange(Settings.System.getUriFor("screen_brightness_mode"), null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean a(Activity activity, int i) {
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
