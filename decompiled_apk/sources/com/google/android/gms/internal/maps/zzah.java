package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface zzah extends IInterface {
    void zzA(@Nullable String str) throws RemoteException;

    void zzB(boolean z) throws RemoteException;

    void zzC(float f) throws RemoteException;

    void zzD() throws RemoteException;

    boolean zzE(zzah zzahVar) throws RemoteException;

    boolean zzF() throws RemoteException;

    boolean zzG() throws RemoteException;

    boolean zzH() throws RemoteException;

    boolean zzI() throws RemoteException;

    float zzd() throws RemoteException;

    float zze() throws RemoteException;

    float zzf() throws RemoteException;

    int zzg() throws RemoteException;

    IObjectWrapper zzh() throws RemoteException;

    IObjectWrapper zzi() throws RemoteException;

    LatLng zzj() throws RemoteException;

    String zzk() throws RemoteException;

    String zzl() throws RemoteException;

    String zzm() throws RemoteException;

    void zzn() throws RemoteException;

    void zzo() throws RemoteException;

    void zzp(float f) throws RemoteException;

    void zzq(float f, float f2) throws RemoteException;

    void zzr(boolean z) throws RemoteException;

    void zzs(boolean z) throws RemoteException;

    void zzt(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzu(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzv(float f, float f2) throws RemoteException;

    void zzw(LatLng latLng) throws RemoteException;

    void zzx(float f) throws RemoteException;

    void zzy(@Nullable String str) throws RemoteException;

    void zzz(IObjectWrapper iObjectWrapper) throws RemoteException;
}
