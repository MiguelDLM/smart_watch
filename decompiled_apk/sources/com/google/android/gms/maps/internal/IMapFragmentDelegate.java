package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface IMapFragmentDelegate extends IInterface {
    @NonNull
    IGoogleMapDelegate getMap() throws RemoteException;

    void getMapAsync(zzat zzatVar) throws RemoteException;

    boolean isReady() throws RemoteException;

    void onCreate(@NonNull Bundle bundle) throws RemoteException;

    @NonNull
    IObjectWrapper onCreateView(@NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onDestroyView() throws RemoteException;

    void onEnterAmbient(@NonNull Bundle bundle) throws RemoteException;

    void onExitAmbient() throws RemoteException;

    void onInflate(@NonNull IObjectWrapper iObjectWrapper, @Nullable GoogleMapOptions googleMapOptions, @NonNull Bundle bundle) throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(@NonNull Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;
}
