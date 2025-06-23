package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import com.garmin.fit.OxXXx0X;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public final class zzbi extends GoogleApi implements FusedLocationProviderClient {
    static final Api.ClientKey zza;
    public static final Api zzb;
    private static final Object zzc;

    @GuardedBy("mockModeMarkerLock")
    private static Object zzd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzb = new Api("LocationServices.API", new zzbf(), clientKey);
        zzc = new Object();
    }

    public zzbi(Activity activity) {
        super(activity, (Api<Api.ApiOptions.NoOptions>) zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    private final Task zza(final LocationRequest locationRequest, ListenerHolder listenerHolder) {
        final zzbh zzbhVar = new zzbh(this, listenerHolder, zzcd.zza);
        return doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbt
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzs(zzbh.this, locationRequest, (TaskCompletionSource) obj2);
            }
        }).unregister(zzbhVar).withHolder(listenerHolder).setMethodKey(2435).build());
    }

    private final Task zzb(final LocationRequest locationRequest, ListenerHolder listenerHolder) {
        final zzbh zzbhVar = new zzbh(this, listenerHolder, zzbz.zza);
        return doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzt(zzbh.this, locationRequest, (TaskCompletionSource) obj2);
            }
        }).unregister(zzbhVar).withHolder(listenerHolder).setMethodKey(2436).build());
    }

    private final Task zzc(final DeviceOrientationRequest deviceOrientationRequest, final ListenerHolder listenerHolder) {
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbm
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzC(ListenerHolder.this, deviceOrientationRequest, (TaskCompletionSource) obj2);
            }
        };
        return doRegisterEventListener(RegistrationMethods.builder().register(remoteCall).unregister(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbn
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzdz zzdzVar = (zzdz) obj;
                Api api = zzbi.zzb;
                ListenerHolder.ListenerKey listenerKey = ListenerHolder.this.getListenerKey();
                if (listenerKey != null) {
                    zzdzVar.zzD(listenerKey, taskCompletionSource);
                }
            }
        }).withHolder(listenerHolder).setMethodKey(2434).build());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> flushLocations() {
        return doWrite(TaskApiCall.builder().run(zzca.zza).setMethodKey(2422).build());
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Location> getCurrentLocation(int i, CancellationToken cancellationToken) {
        CurrentLocationRequest.Builder builder = new CurrentLocationRequest.Builder();
        builder.setPriority(i);
        CurrentLocationRequest build = builder.build();
        if (cancellationToken != null) {
            Preconditions.checkArgument(!cancellationToken.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task<Location> doRead = doRead(TaskApiCall.builder().run(new zzbp(build, cancellationToken)).setMethodKey(2415).build());
        if (cancellationToken == null) {
            return doRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        doRead.continueWith(new zzbq(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Location> getLastLocation() {
        return doRead(TaskApiCall.builder().run(zzby.zza).setMethodKey(2414).build());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<LocationAvailability> getLocationAvailability() {
        return doRead(TaskApiCall.builder().run(zzbr.zza).setMethodKey(2416).build());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> removeDeviceOrientationUpdates(DeviceOrientationListener deviceOrientationListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(deviceOrientationListener, DeviceOrientationListener.class.getSimpleName()), 2440).continueWith(zzcg.zza, zzbo.zza);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> removeLocationUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzx(pendingIntent, (TaskCompletionSource) obj2, null);
            }
        }).setMethodKey(2418).build());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest, DeviceOrientationListener deviceOrientationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.checkNotNull(looper, "invalid null looper");
        }
        return zzc(deviceOrientationRequest, ListenerHolders.createListenerHolder(deviceOrientationListener, looper, DeviceOrientationListener.class.getSimpleName()));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestLocationUpdates(final LocationRequest locationRequest, final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbs
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzu(pendingIntent, locationRequest, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(OxXXx0X.f13186oXO0oOx0).build());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> setMockLocation(final Location location) {
        boolean z;
        if (location != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbl
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzA(location, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(2421).build());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> setMockMode(boolean z) {
        synchronized (zzc) {
            try {
                if (z) {
                    if (zzd == null) {
                        Object obj = new Object();
                        zzd = obj;
                        return doRegisterEventListener(RegistrationMethods.builder().register(zzcb.zza).unregister(zzcc.zza).withHolder(ListenerHolders.createListenerHolder(obj, Looper.getMainLooper(), Object.class.getSimpleName())).setMethodKey(2420).build());
                    }
                } else {
                    Object obj2 = zzd;
                    if (obj2 != null) {
                        zzd = null;
                        return doUnregisterEventListener(ListenerHolders.createListenerKey(obj2, Object.class.getSimpleName()), 2420).continueWith(zzcf.zza, zzbk.zza);
                    }
                }
                return Tasks.forResult(null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzbi(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Location> getLastLocation(final LastLocationRequest lastLocationRequest) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzq(LastLocationRequest.this, (TaskCompletionSource) obj2);
            }
        }).setMethodKey(2414).setFeatures(com.google.android.gms.location.zzo.zzf).build());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback, LocationCallback.class.getSimpleName()), 2418).continueWith(zzce.zza, zzbw.zza);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest, Executor executor, DeviceOrientationListener deviceOrientationListener) {
        return zzc(deviceOrientationRequest, ListenerHolders.createListenerHolder(deviceOrientationListener, executor, DeviceOrientationListener.class.getSimpleName()));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.checkNotNull(looper, "invalid null looper");
        }
        return zzb(locationRequest, ListenerHolders.createListenerHolder(locationCallback, looper, LocationCallback.class.getSimpleName()));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> removeLocationUpdates(LocationListener locationListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(locationListener, LocationListener.class.getSimpleName()), 2418).continueWith(zzch.zza, zzbv.zza);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.checkNotNull(looper, "invalid null looper");
        }
        return zza(locationRequest, ListenerHolders.createListenerHolder(locationListener, looper, LocationListener.class.getSimpleName()));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Location> getCurrentLocation(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken) {
        if (cancellationToken != null) {
            Preconditions.checkArgument(!cancellationToken.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task<Location> doRead = doRead(TaskApiCall.builder().run(new zzbp(currentLocationRequest, cancellationToken)).setMethodKey(2415).build());
        if (cancellationToken == null) {
            return doRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        doRead.continueWith(new zzbq(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, Executor executor, LocationCallback locationCallback) {
        return zzb(locationRequest, ListenerHolders.createListenerHolder(locationCallback, executor, LocationCallback.class.getSimpleName()));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
        return zza(locationRequest, ListenerHolders.createListenerHolder(locationListener, executor, LocationListener.class.getSimpleName()));
    }
}
