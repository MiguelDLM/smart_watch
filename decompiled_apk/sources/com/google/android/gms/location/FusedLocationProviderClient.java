package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.kuaishou.weapon.p0.g;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public interface FusedLocationProviderClient extends HasApiKey<Api.ApiOptions.NoOptions> {

    @NonNull
    @Deprecated
    public static final String KEY_MOCK_LOCATION = "mockLocation";

    @NonNull
    @Deprecated
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    @NonNull
    Task<Void> flushLocations();

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Location> getCurrentLocation(int i, @Nullable CancellationToken cancellationToken);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Location> getCurrentLocation(@NonNull CurrentLocationRequest currentLocationRequest, @Nullable CancellationToken cancellationToken);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Location> getLastLocation();

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Location> getLastLocation(@NonNull LastLocationRequest lastLocationRequest);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<LocationAvailability> getLocationAvailability();

    @NonNull
    @Deprecated
    Task<Void> removeDeviceOrientationUpdates(@NonNull DeviceOrientationListener deviceOrientationListener);

    @NonNull
    Task<Void> removeLocationUpdates(@NonNull PendingIntent pendingIntent);

    @NonNull
    Task<Void> removeLocationUpdates(@NonNull LocationCallback locationCallback);

    @NonNull
    Task<Void> removeLocationUpdates(@NonNull LocationListener locationListener);

    @NonNull
    @Deprecated
    Task<Void> requestDeviceOrientationUpdates(@NonNull DeviceOrientationRequest deviceOrientationRequest, @NonNull DeviceOrientationListener deviceOrientationListener, @Nullable Looper looper);

    @NonNull
    @Deprecated
    Task<Void> requestDeviceOrientationUpdates(@NonNull DeviceOrientationRequest deviceOrientationRequest, @NonNull Executor executor, @NonNull DeviceOrientationListener deviceOrientationListener);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull PendingIntent pendingIntent);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull LocationCallback locationCallback, @Nullable Looper looper);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull LocationListener locationListener, @Nullable Looper looper);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationCallback locationCallback);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Void> requestLocationUpdates(@NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Void> setMockLocation(@NonNull Location location);

    @NonNull
    @RequiresPermission(anyOf = {g.h, g.g})
    Task<Void> setMockMode(boolean z);
}
