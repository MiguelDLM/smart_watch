package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;

@KeepName
/* loaded from: classes9.dex */
public class UserRecoverableAuthException extends GoogleAuthException {

    @Nullable
    private final Intent zza;

    @Nullable
    private final PendingIntent zzb;
    private final zzn zzc;

    public UserRecoverableAuthException(@Nullable String str, @Nullable Intent intent) {
        this(str, intent, null, zzn.LEGACY);
    }

    @NonNull
    public static UserRecoverableAuthException zza(@Nullable String str, @NonNull Intent intent, @NonNull PendingIntent pendingIntent) {
        Preconditions.checkNotNull(intent);
        Preconditions.checkNotNull(pendingIntent);
        return new UserRecoverableAuthException(str, intent, pendingIntent, zzn.AUTH_INSTANTIATION);
    }

    @Nullable
    public Intent getIntent() {
        Intent intent = this.zza;
        if (intent == null) {
            int ordinal = this.zzc.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        Log.e("Auth", "this instantiation of UserRecoverableAuthException doesn't support an Intent.");
                        return null;
                    }
                    return null;
                }
                Log.e("Auth", "This shouldn't happen. Gms API throwing this exception should support the recovery Intent.");
                return null;
            }
            Log.w("Auth", "Make sure that an intent was provided to class instantiation.");
            return null;
        }
        return new Intent(intent);
    }

    private UserRecoverableAuthException(@Nullable String str, @Nullable Intent intent, @Nullable PendingIntent pendingIntent, zzn zznVar) {
        super(str);
        this.zzb = pendingIntent;
        this.zza = intent;
        this.zzc = (zzn) Preconditions.checkNotNull(zznVar);
    }
}
