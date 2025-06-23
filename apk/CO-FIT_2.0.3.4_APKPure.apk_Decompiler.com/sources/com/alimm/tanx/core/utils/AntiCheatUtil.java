package com.alimm.tanx.core.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.reflect.Field;

public class AntiCheatUtil implements NotConfused {
    private static volatile AntiCheatUtil instance;

    private boolean canDrawOverlays(Context context) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            return true;
        }
        if (i2 >= 27) {
            return Settings.canDrawOverlays(context);
        }
        if (Settings.canDrawOverlays(context)) {
            return true;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            View view = new View(context);
            if (i2 >= 26) {
                i = 2038;
            } else {
                i = 2003;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, i, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkFloatPermission(Context context) {
        Class<String> cls = String.class;
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context);
        }
        try {
            Class<?> cls2 = Class.forName("android.content.Context");
            Field declaredField = cls2.getDeclaredField("APP_OPS_SERVICE");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls2);
            if (!(obj instanceof String)) {
                return false;
            }
            Object invoke = cls2.getMethod("getSystemService", new Class[]{cls}).invoke(context, new Object[]{(String) obj});
            Class<?> cls3 = Class.forName("android.app.AppOpsManager");
            Field declaredField2 = cls3.getDeclaredField("MODE_ALLOWED");
            declaredField2.setAccessible(true);
            Class cls4 = Integer.TYPE;
            if (((Integer) cls3.getMethod("checkOp", new Class[]{cls4, cls4, cls}).invoke(invoke, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == declaredField2.getInt(cls3)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static AntiCheatUtil getInstance() {
        if (instance == null) {
            synchronized (AntiCheatUtil.class) {
                try {
                    if (instance == null) {
                        instance = new AntiCheatUtil();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public boolean accessibilityEnabled(Context context) {
        AccessibilityManager accessibilityManager;
        if (context == null || (accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility")) == null) {
            return false;
        }
        return accessibilityManager.isEnabled();
    }

    public float getBatteryPercentage(Context context) {
        Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1))) * 100.0f;
    }

    public int getCurrentVolume(Context context) {
        AudioManager audioManager;
        if (context == null || (audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) == null) {
            return -1;
        }
        return audioManager.getStreamVolume(3);
    }

    public boolean isCharging(Context context) {
        Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    public boolean isSystemAlertPermissions(Context context) {
        if (context == null) {
            return false;
        }
        return checkFloatPermission(context);
    }
}
