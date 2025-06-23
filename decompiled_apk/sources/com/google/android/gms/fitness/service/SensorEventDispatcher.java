package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.fitness.data.DataPoint;
import java.util.List;

/* loaded from: classes9.dex */
public interface SensorEventDispatcher {
    void publish(@NonNull DataPoint dataPoint) throws RemoteException;

    void publish(@NonNull List<DataPoint> list) throws RemoteException;
}
