package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes9.dex */
public interface ICameraUpdateFactoryDelegate extends IInterface {
    @NonNull
    IObjectWrapper newCameraPosition(@NonNull CameraPosition cameraPosition) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLng(@NonNull LatLng latLng) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLngBounds(@NonNull LatLngBounds latLngBounds, int i) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLngBoundsWithSize(@NonNull LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException;

    @NonNull
    IObjectWrapper newLatLngZoom(@NonNull LatLng latLng, float f) throws RemoteException;

    @NonNull
    IObjectWrapper scrollBy(float f, float f2) throws RemoteException;

    @NonNull
    IObjectWrapper zoomBy(float f) throws RemoteException;

    @NonNull
    IObjectWrapper zoomByWithFocus(float f, int i, int i2) throws RemoteException;

    @NonNull
    IObjectWrapper zoomIn() throws RemoteException;

    @NonNull
    IObjectWrapper zoomOut() throws RemoteException;

    @NonNull
    IObjectWrapper zoomTo(float f) throws RemoteException;
}
