package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
public interface zzat extends IInterface {
    void zzb(byte[] bArr) throws RemoteException;

    void zzc(DeviceMetaData deviceMetaData) throws RemoteException;

    void zzd(Status status) throws RemoteException;

    void zze() throws RemoteException;

    void zzf(Status status, com.google.android.gms.auth.api.accounttransfer.zzw zzwVar) throws RemoteException;

    void zzg(Status status, com.google.android.gms.auth.api.accounttransfer.zzo zzoVar) throws RemoteException;

    void zzh(Status status) throws RemoteException;
}
