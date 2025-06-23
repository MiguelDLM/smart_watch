package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
@Deprecated
/* loaded from: classes9.dex */
public class WakeLockTracker {
    private static final WakeLockTracker zza = new WakeLockTracker();

    @NonNull
    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zza;
    }

    @KeepForSdk
    public void registerAcquireEvent(@NonNull Context context, @NonNull Intent intent, @NonNull String str, @NonNull String str2, @NonNull String str3, int i, @NonNull String str4) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, int i, @NonNull List<String> list, boolean z, long j) {
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i2, @NonNull List<String> list) {
    }

    @KeepForSdk
    public void registerReleaseEvent(@NonNull Context context, @NonNull Intent intent) {
    }

    @KeepForSdk
    public void registerEvent(@NonNull Context context, @NonNull String str, int i, @NonNull String str2, @NonNull String str3, @NonNull String str4, int i2, @NonNull List<String> list, long j) {
    }
}
