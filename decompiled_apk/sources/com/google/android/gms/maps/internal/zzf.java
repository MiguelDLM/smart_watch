package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface zzf extends IInterface {
    int zzd() throws RemoteException;

    ICameraUpdateFactoryDelegate zze() throws RemoteException;

    IMapFragmentDelegate zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    IMapViewDelegate zzg(IObjectWrapper iObjectWrapper, @Nullable GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate zzh(IObjectWrapper iObjectWrapper) throws RemoteException;

    IStreetViewPanoramaViewDelegate zzi(IObjectWrapper iObjectWrapper, @Nullable StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    com.google.android.gms.internal.maps.zzi zzj() throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    void zzl(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;
}
