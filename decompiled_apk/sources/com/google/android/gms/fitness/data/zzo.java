package com.google.android.gms.fitness.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;

/* loaded from: classes9.dex */
public final class zzo {

    @Nullable
    private static String zza = null;
    private static int zzb = -1;

    public static int zza(Context context) {
        int i;
        int i2;
        int i3 = zzb;
        if (i3 == -1) {
            if (DeviceProperties.isWearable(context)) {
                i = 3;
            } else {
                if (!DeviceProperties.isTv(context) && !DeviceProperties.isAuto(context)) {
                    if (DeviceProperties.isTablet(context.getResources()) && !zzc(context)) {
                        zzb = 2;
                        return 2;
                    }
                    String str = Build.PRODUCT;
                    if (!TextUtils.isEmpty(str) && str.startsWith("glass_")) {
                        i2 = 6;
                    } else {
                        i2 = 1;
                    }
                    zzb = i2;
                    return i2;
                }
                i = 0;
            }
            zzb = i;
            return i;
        }
        return i3;
    }

    @SuppressLint({"HardwareIds"})
    public static String zzb(Context context) {
        String str = zza;
        if (str != null) {
            return str;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        zza = string;
        return string;
    }

    private static boolean zzc(Context context) {
        try {
            if (((TelephonyManager) Preconditions.checkNotNull((TelephonyManager) context.getSystemService("phone"))).getPhoneType() != 0) {
                return true;
            }
            return false;
        } catch (Resources.NotFoundException e) {
            Log.e("Fitness", "Unable to determine type of device, assuming phone.", e);
            return true;
        }
    }
}
