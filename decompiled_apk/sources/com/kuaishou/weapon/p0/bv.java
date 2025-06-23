package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.appevents.integrity.IntegrityManager;

/* loaded from: classes11.dex */
public class bv {
    public static String a(Context context) {
        int i;
        try {
            if (d(context) != null) {
                i = (int) ((r3.getIntExtra("level", -1) / r3.getIntExtra("scale", -1)) * 100.0f);
            } else {
                i = 0;
            }
            return i + "%";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            int intExtra = d(context).getIntExtra("plugged", -1);
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra != 4) {
                        return "";
                    }
                    return "Wireless charger";
                }
                return "USB charger";
            }
            return "AC charger";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int c(Context context) {
        int i = -1;
        try {
            int intExtra = d(context).getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, -1);
            i = 3;
            if (intExtra != 2) {
                if (intExtra == 3) {
                    return 4;
                }
                if (intExtra == 4) {
                    return 2;
                }
                if (intExtra == 5) {
                    return 5;
                }
                if (intExtra != 7) {
                    return 6;
                }
                return 1;
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    private static Intent d(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
