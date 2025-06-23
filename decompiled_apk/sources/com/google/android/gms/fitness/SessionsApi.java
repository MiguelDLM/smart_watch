package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

@Deprecated
/* loaded from: classes9.dex */
public interface SessionsApi {

    /* loaded from: classes9.dex */
    public static class ViewIntentBuilder {
        private final Context zza;
        private Session zzb;

        @Nullable
        private String zzc;
        private boolean zzd = false;

        public ViewIntentBuilder(@NonNull Context context) {
            this.zza = context;
        }

        @NonNull
        public Intent build() {
            boolean z;
            Intent intent;
            ResolveInfo resolveActivity;
            if (this.zzb != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Session must be set");
            Intent intent2 = new Intent(Fitness.ACTION_VIEW);
            intent2.setType(Session.getMimeType(this.zzb.getActivity()));
            SafeParcelableSerializer.serializeToIntentExtra(this.zzb, intent2, Session.EXTRA_SESSION);
            if (!this.zzd) {
                this.zzc = this.zzb.getAppPackageName();
            }
            String str = this.zzc;
            if (str != null && (resolveActivity = this.zza.getPackageManager().resolveActivity((intent = new Intent(intent2).setPackage(str)), 0)) != null) {
                intent.setComponent(new ComponentName(str, resolveActivity.activityInfo.name));
                return intent;
            }
            return intent2;
        }

        @NonNull
        public ViewIntentBuilder setPreferredApplication(@Nullable String str) {
            this.zzc = str;
            this.zzd = true;
            return this;
        }

        @NonNull
        public ViewIntentBuilder setSession(@NonNull Session session) {
            this.zzb = session;
            return this;
        }
    }

    @NonNull
    PendingResult<Status> insertSession(@NonNull GoogleApiClient googleApiClient, @NonNull SessionInsertRequest sessionInsertRequest);

    @NonNull
    PendingResult<SessionReadResult> readSession(@NonNull GoogleApiClient googleApiClient, @NonNull SessionReadRequest sessionReadRequest);

    @NonNull
    PendingResult<Status> registerForSessions(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    @NonNull
    PendingResult<Status> startSession(@NonNull GoogleApiClient googleApiClient, @NonNull Session session);

    @NonNull
    PendingResult<SessionStopResult> stopSession(@NonNull GoogleApiClient googleApiClient, @Nullable String str);

    @NonNull
    PendingResult<Status> unregisterForSessions(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);
}
