package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: classes9.dex */
public interface IStreetViewPanoramaDelegate extends IInterface {
    void animateTo(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException;

    void enablePanning(boolean z) throws RemoteException;

    void enableStreetNames(boolean z) throws RemoteException;

    void enableUserNavigation(boolean z) throws RemoteException;

    void enableZoom(boolean z) throws RemoteException;

    @NonNull
    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    @NonNull
    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    @Nullable
    IObjectWrapper orientationToPoint(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    @NonNull
    StreetViewPanoramaOrientation pointToOrientation(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(@javax.annotation.Nullable zzbl zzblVar) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(@javax.annotation.Nullable zzbn zzbnVar) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(@javax.annotation.Nullable zzbp zzbpVar) throws RemoteException;

    void setOnStreetViewPanoramaLongClickListener(@javax.annotation.Nullable zzbr zzbrVar) throws RemoteException;

    void setPosition(@NonNull LatLng latLng) throws RemoteException;

    void setPositionWithID(@NonNull String str) throws RemoteException;

    void setPositionWithRadius(@NonNull LatLng latLng, int i) throws RemoteException;

    void setPositionWithRadiusAndSource(@NonNull LatLng latLng, int i, @javax.annotation.Nullable StreetViewSource streetViewSource) throws RemoteException;

    void setPositionWithSource(@NonNull LatLng latLng, @javax.annotation.Nullable StreetViewSource streetViewSource) throws RemoteException;
}
