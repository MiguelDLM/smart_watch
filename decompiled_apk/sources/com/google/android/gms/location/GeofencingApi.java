package com.google.android.gms.location;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.kuaishou.weapon.p0.g;
import java.util.List;

@Deprecated
/* loaded from: classes9.dex */
public interface GeofencingApi {
    @NonNull
    @RequiresPermission(g.g)
    PendingResult<Status> addGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull GeofencingRequest geofencingRequest, @NonNull PendingIntent pendingIntent);

    @NonNull
    @RequiresPermission(g.g)
    @Deprecated
    PendingResult<Status> addGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull List<Geofence> list, @NonNull PendingIntent pendingIntent);

    @NonNull
    PendingResult<Status> removeGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull PendingIntent pendingIntent);

    @NonNull
    PendingResult<Status> removeGeofences(@NonNull GoogleApiClient googleApiClient, @NonNull List<String> list);
}
