package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* loaded from: classes9.dex */
public final class zzdz extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final SimpleArrayMap zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;
    private final SimpleArrayMap zzi;

    public zzdz(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new SimpleArrayMap();
        this.zzg = new SimpleArrayMap();
        this.zzh = new SimpleArrayMap();
        this.zzi = new SimpleArrayMap();
    }

    private final boolean zzG(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures != null) {
            int i = 0;
            while (true) {
                if (i < availableFeatures.length) {
                    feature2 = availableFeatures[i];
                    if (feature.getName().equals(feature2.getName())) {
                        break;
                    }
                    i++;
                } else {
                    feature2 = null;
                    break;
                }
            }
            if (feature2 != null && feature2.getVersion() >= feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (queryLocalInterface instanceof zzv) {
            return (zzv) queryLocalInterface;
        }
        return new zzu(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.location.zzo.zzp;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        super.onConnectionSuspended(i);
        synchronized (this.zzf) {
            this.zzf.clear();
        }
        synchronized (this.zzg) {
            this.zzg.clear();
        }
        synchronized (this.zzh) {
            this.zzh.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(Location location, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzh)) {
            ((zzv) getService()).zzB(location, new zzdj(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzA(location);
            taskCompletionSource.setResult(null);
        }
    }

    public final void zzB(TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzv) getService()).zzC(new zzdn(null, taskCompletionSource));
    }

    public final void zzC(ListenerHolder listenerHolder, DeviceOrientationRequest deviceOrientationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = listenerHolder.getListenerKey();
        Objects.requireNonNull(listenerKey);
        synchronized (this.zzh) {
            try {
                zzdq zzdqVar = (zzdq) this.zzh.get(listenerKey);
                if (zzdqVar == null) {
                    zzdqVar = new zzdq(listenerHolder);
                    this.zzh.put(listenerKey, zzdqVar);
                } else {
                    zzdqVar.zzc(listenerHolder);
                }
                ((zzv) getService()).zzF(new zzj(1, new zzh(deviceOrientationRequest, zzh.zza, null), zzdqVar, new zzdn(null, taskCompletionSource)));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzD(ListenerHolder.ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzh) {
            try {
                zzdq zzdqVar = (zzdq) this.zzh.remove(listenerKey);
                if (zzdqVar == null) {
                    taskCompletionSource.setResult(Boolean.FALSE);
                } else {
                    zzdqVar.zze();
                    ((zzv) getService()).zzF(new zzj(2, null, zzdqVar, new zzdn(Boolean.TRUE, taskCompletionSource)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzE(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzn)) {
            ((zzv) getService()).zze(geofencingRequest, pendingIntent, new zzdj(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzd(geofencingRequest, pendingIntent, new zzdg(taskCompletionSource));
        }
    }

    public final void zzF(zzem zzemVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzn)) {
            ((zzv) getService()).zzg(zzemVar, new zzdj(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzf(zzemVar, new zzdg(taskCompletionSource));
        }
    }

    public final void zzp(com.google.android.gms.location.zzad zzadVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzj)) {
            ((zzv) getService()).zzo(zzadVar, new zzee(5, null, new zzdl(taskCompletionSource), null, null));
        } else {
            taskCompletionSource.setResult(((zzv) getService()).zzp(getContext().getPackageName()));
        }
    }

    public final void zzq(LastLocationRequest lastLocationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzj)) {
            ((zzv) getService()).zzq(lastLocationRequest, zzee.zzd(new zzdk(taskCompletionSource)));
        } else if (zzG(com.google.android.gms.location.zzo.zzf)) {
            ((zzv) getService()).zzr(lastLocationRequest, new zzdk(taskCompletionSource));
        } else {
            taskCompletionSource.setResult(((zzv) getService()).zzs());
        }
    }

    public final void zzr(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzj)) {
            final ICancelToken zzt = ((zzv) getService()).zzt(currentLocationRequest, zzee.zzd(new zzdk(taskCompletionSource)));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzed
                    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                    public final /* synthetic */ void onCanceled() {
                        int i = zzdz.zze;
                        try {
                            ICancelToken.this.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                });
                return;
            }
            return;
        }
        if (zzG(com.google.android.gms.location.zzo.zze)) {
            final ICancelToken zzu = ((zzv) getService()).zzu(currentLocationRequest, new zzdk(taskCompletionSource));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzeb
                    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                    public final /* synthetic */ void onCanceled() {
                        int i = zzdz.zze;
                        try {
                            ICancelToken.this.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                });
                return;
            }
            return;
        }
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(new zzdh(this, taskCompletionSource), zzfc.zza(), "GetCurrentLocation");
        final ListenerHolder.ListenerKey listenerKey = createListenerHolder.getListenerKey();
        Objects.requireNonNull(listenerKey);
        zzdi zzdiVar = new zzdi(this, createListenerHolder, taskCompletionSource);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        LocationRequest.Builder builder = new LocationRequest.Builder(currentLocationRequest.getPriority(), 0L);
        builder.setMinUpdateIntervalMillis(0L);
        builder.setDurationMillis(currentLocationRequest.getDurationMillis());
        builder.setGranularity(currentLocationRequest.getGranularity());
        builder.setMaxUpdateAgeMillis(currentLocationRequest.getMaxUpdateAgeMillis());
        builder.zzb(currentLocationRequest.zza());
        builder.zza(currentLocationRequest.zzb());
        builder.setWaitForAccurateLocation(true);
        builder.zzc(currentLocationRequest.zzc());
        zzt(zzdiVar, builder.build(), taskCompletionSource2);
        taskCompletionSource2.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzea
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                int i = zzdz.zze;
                if (!task.isSuccessful()) {
                    TaskCompletionSource taskCompletionSource3 = TaskCompletionSource.this;
                    Exception exception = task.getException();
                    Objects.requireNonNull(exception);
                    taskCompletionSource3.trySetException(exception);
                }
            }
        });
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzec
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    try {
                        zzdz.this.zzw(listenerKey, true, new TaskCompletionSource());
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x001a, B:8:0x0028, B:10:0x003f, B:11:0x0075, B:15:0x0056, B:16:0x0030), top: B:3:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x001a, B:8:0x0028, B:10:0x003f, B:11:0x0075, B:15:0x0056, B:16:0x0030), top: B:3:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzs(com.google.android.gms.internal.location.zzdr r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.ListenerHolder r3 = r18.zza()
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = r3.getListenerKey()
            java.util.Objects.requireNonNull(r4)
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.zzo.zzj
            boolean r5 = r1.zzG(r5)
            androidx.collection.SimpleArrayMap r6 = r1.zzf
            monitor-enter(r6)
            androidx.collection.SimpleArrayMap r7 = r1.zzf     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzdy r7 = (com.google.android.gms.internal.location.zzdy) r7     // Catch: java.lang.Throwable -> L2e
            r8 = 0
            if (r7 == 0) goto L30
            if (r5 == 0) goto L28
            goto L30
        L28:
            r7.zzc(r3)     // Catch: java.lang.Throwable -> L2e
            r12 = r7
            r7 = r8
            goto L3d
        L2e:
            r0 = move-exception
            goto L77
        L30:
            com.google.android.gms.internal.location.zzdy r3 = new com.google.android.gms.internal.location.zzdy     // Catch: java.lang.Throwable -> L2e
            r9 = r18
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L2e
            androidx.collection.SimpleArrayMap r9 = r1.zzf     // Catch: java.lang.Throwable -> L2e
            r9.put(r4, r3)     // Catch: java.lang.Throwable -> L2e
            r12 = r3
        L3d:
            if (r5 == 0) goto L56
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r4.toIdString()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzee r4 = com.google.android.gms.internal.location.zzee.zza(r7, r12, r4)     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzdj r5 = new com.google.android.gms.internal.location.zzdj     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r8, r2)     // Catch: java.lang.Throwable -> L2e
            r3.zzw(r4, r0, r5)     // Catch: java.lang.Throwable -> L2e
            goto L75
        L56:
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzeg r11 = com.google.android.gms.internal.location.zzeg.zza(r8, r0)     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzdo r15 = new com.google.android.gms.internal.location.zzdo     // Catch: java.lang.Throwable -> L2e
            r15.<init>(r2, r12)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r16 = r4.toIdString()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzei r0 = new com.google.android.gms.internal.location.zzei     // Catch: java.lang.Throwable -> L2e
            r13 = 0
            r14 = 0
            r10 = 1
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L2e
            r3.zzv(r0)     // Catch: java.lang.Throwable -> L2e
        L75:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2e
            return
        L77:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdz.zzs(com.google.android.gms.internal.location.zzdr, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x001a, B:8:0x0028, B:10:0x003f, B:11:0x0075, B:15:0x0056, B:16:0x0030), top: B:3:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x001a, B:8:0x0028, B:10:0x003f, B:11:0x0075, B:15:0x0056, B:16:0x0030), top: B:3:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzt(com.google.android.gms.internal.location.zzdr r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.ListenerHolder r3 = r18.zza()
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = r3.getListenerKey()
            java.util.Objects.requireNonNull(r4)
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.zzo.zzj
            boolean r5 = r1.zzG(r5)
            androidx.collection.SimpleArrayMap r6 = r1.zzg
            monitor-enter(r6)
            androidx.collection.SimpleArrayMap r7 = r1.zzg     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzdv r7 = (com.google.android.gms.internal.location.zzdv) r7     // Catch: java.lang.Throwable -> L2e
            r8 = 0
            if (r7 == 0) goto L30
            if (r5 == 0) goto L28
            goto L30
        L28:
            r7.zzc(r3)     // Catch: java.lang.Throwable -> L2e
            r13 = r7
            r7 = r8
            goto L3d
        L2e:
            r0 = move-exception
            goto L77
        L30:
            com.google.android.gms.internal.location.zzdv r3 = new com.google.android.gms.internal.location.zzdv     // Catch: java.lang.Throwable -> L2e
            r9 = r18
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L2e
            androidx.collection.SimpleArrayMap r9 = r1.zzg     // Catch: java.lang.Throwable -> L2e
            r9.put(r4, r3)     // Catch: java.lang.Throwable -> L2e
            r13 = r3
        L3d:
            if (r5 == 0) goto L56
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = r4.toIdString()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzee r4 = com.google.android.gms.internal.location.zzee.zzb(r7, r13, r4)     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzdj r5 = new com.google.android.gms.internal.location.zzdj     // Catch: java.lang.Throwable -> L2e
            r5.<init>(r8, r2)     // Catch: java.lang.Throwable -> L2e
            r3.zzw(r4, r0, r5)     // Catch: java.lang.Throwable -> L2e
            goto L75
        L56:
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.location.zzv) r3     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzeg r11 = com.google.android.gms.internal.location.zzeg.zza(r8, r0)     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzdd r15 = new com.google.android.gms.internal.location.zzdd     // Catch: java.lang.Throwable -> L2e
            r15.<init>(r2, r13)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r16 = r4.toIdString()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.internal.location.zzei r0 = new com.google.android.gms.internal.location.zzei     // Catch: java.lang.Throwable -> L2e
            r12 = 0
            r14 = 0
            r10 = 1
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L2e
            r3.zzv(r0)     // Catch: java.lang.Throwable -> L2e
        L75:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2e
            return
        L77:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzdz.zzt(com.google.android.gms.internal.location.zzdr, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    public final void zzu(PendingIntent pendingIntent, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzj)) {
            ((zzv) getService()).zzw(zzee.zzc(pendingIntent), locationRequest, new zzdj(null, taskCompletionSource));
            return;
        }
        zzv zzvVar = (zzv) getService();
        zzeg zza = zzeg.zza(null, locationRequest);
        zzdn zzdnVar = new zzdn(null, taskCompletionSource);
        int hashCode = pendingIntent.hashCode();
        StringBuilder sb = new StringBuilder(String.valueOf(hashCode).length() + 14);
        sb.append("PendingIntent@");
        sb.append(hashCode);
        zzvVar.zzv(new zzei(1, zza, null, null, pendingIntent, zzdnVar, sb.toString()));
    }

    public final void zzv(ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzf) {
            try {
                zzdy zzdyVar = (zzdy) this.zzf.remove(listenerKey);
                if (zzdyVar == null) {
                    taskCompletionSource.setResult(Boolean.FALSE);
                    return;
                }
                zzdyVar.zzf();
                if (z) {
                    if (zzG(com.google.android.gms.location.zzo.zzj)) {
                        zzv zzvVar = (zzv) getService();
                        int identityHashCode = System.identityHashCode(zzdyVar);
                        StringBuilder sb = new StringBuilder(String.valueOf(identityHashCode).length() + 18);
                        sb.append("ILocationListener@");
                        sb.append(identityHashCode);
                        zzvVar.zzx(zzee.zza(null, zzdyVar, sb.toString()), new zzdj(Boolean.TRUE, taskCompletionSource));
                    } else {
                        ((zzv) getService()).zzv(new zzei(2, null, zzdyVar, null, null, new zzdn(Boolean.TRUE, taskCompletionSource), null));
                    }
                } else {
                    taskCompletionSource.setResult(Boolean.TRUE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzw(ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzg) {
            try {
                zzdv zzdvVar = (zzdv) this.zzg.remove(listenerKey);
                if (zzdvVar == null) {
                    taskCompletionSource.setResult(Boolean.FALSE);
                    return;
                }
                zzdvVar.zzg();
                if (z) {
                    if (zzG(com.google.android.gms.location.zzo.zzj)) {
                        zzv zzvVar = (zzv) getService();
                        int identityHashCode = System.identityHashCode(zzdvVar);
                        StringBuilder sb = new StringBuilder(String.valueOf(identityHashCode).length() + 18);
                        sb.append("ILocationCallback@");
                        sb.append(identityHashCode);
                        zzvVar.zzx(zzee.zzb(null, zzdvVar, sb.toString()), new zzdj(Boolean.TRUE, taskCompletionSource));
                    } else {
                        ((zzv) getService()).zzv(new zzei(2, null, null, zzdvVar, null, new zzdn(Boolean.TRUE, taskCompletionSource), null));
                    }
                } else {
                    taskCompletionSource.setResult(Boolean.TRUE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzx(PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource, Object obj) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzj)) {
            ((zzv) getService()).zzx(zzee.zzc(pendingIntent), new zzdj(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzv(new zzei(2, null, null, null, pendingIntent, new zzdn(null, taskCompletionSource), null));
        }
    }

    public final void zzy(TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzg)) {
            ((zzv) getService()).zzz(true, new zzdj(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzy(true);
            taskCompletionSource.setResult(null);
        }
    }

    public final void zzz(TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(com.google.android.gms.location.zzo.zzg)) {
            ((zzv) getService()).zzz(false, new zzdj(Boolean.TRUE, taskCompletionSource));
        } else {
            ((zzv) getService()).zzy(false);
            taskCompletionSource.setResult(Boolean.TRUE);
        }
    }
}
