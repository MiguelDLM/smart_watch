package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;

/* loaded from: classes9.dex */
public interface zzv extends IInterface {
    @Deprecated
    void zzA(Location location) throws RemoteException;

    void zzB(Location location, IStatusCallback iStatusCallback) throws RemoteException;

    void zzC(zzr zzrVar) throws RemoteException;

    void zzD(LocationSettingsRequest locationSettingsRequest, zzab zzabVar, String str) throws RemoteException;

    void zzE(zzo zzoVar) throws RemoteException;

    void zzF(zzj zzjVar) throws RemoteException;

    @Deprecated
    void zzd(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzt zztVar) throws RemoteException;

    void zze(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    @Deprecated
    void zzf(zzem zzemVar, zzt zztVar) throws RemoteException;

    void zzg(zzem zzemVar, IStatusCallback iStatusCallback) throws RemoteException;

    void zzh(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zzi(com.google.android.gms.location.zzb zzbVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzj(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzk(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzl(PendingIntent pendingIntent) throws RemoteException;

    void zzm(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback) throws RemoteException;

    void zzn(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zzo(com.google.android.gms.location.zzad zzadVar, zzee zzeeVar) throws RemoteException;

    @Deprecated
    LocationAvailability zzp(String str) throws RemoteException;

    void zzq(LastLocationRequest lastLocationRequest, zzee zzeeVar) throws RemoteException;

    @Deprecated
    void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar) throws RemoteException;

    @Deprecated
    Location zzs() throws RemoteException;

    ICancelToken zzt(CurrentLocationRequest currentLocationRequest, zzee zzeeVar) throws RemoteException;

    @Deprecated
    ICancelToken zzu(CurrentLocationRequest currentLocationRequest, zzz zzzVar) throws RemoteException;

    @Deprecated
    void zzv(zzei zzeiVar) throws RemoteException;

    void zzw(zzee zzeeVar, LocationRequest locationRequest, IStatusCallback iStatusCallback) throws RemoteException;

    void zzx(zzee zzeeVar, IStatusCallback iStatusCallback) throws RemoteException;

    @Deprecated
    void zzy(boolean z) throws RemoteException;

    void zzz(boolean z, IStatusCallback iStatusCallback) throws RemoteException;
}
