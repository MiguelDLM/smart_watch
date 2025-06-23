package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes11.dex */
public final class am {
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent a(Context context, int i, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(context, i, intent, 201326592);
        }
        return PendingIntent.getBroadcast(context, i, intent, C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    private static PendingIntent b(Context context, int i, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, i, intent, 201326592);
        }
        return PendingIntent.getActivity(context, i, intent, C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    private static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }

    @Nullable
    public static PendingIntent d(Context context, String str, int i) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i, launchIntentForPackage);
    }

    private static Intent h(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra("pendingIntent", intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static PendingIntent a(Context context, File file, int i, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri c = c(context, file);
        intent.setDataAndType(c, "application/vnd.android.package-archive");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, c, 3);
        }
        if (z) {
            com.kwad.sdk.c.yq();
            if (com.kwad.sdk.c.yt()) {
                intent = h(intent);
            }
        }
        return b(context, i, intent);
    }
}
