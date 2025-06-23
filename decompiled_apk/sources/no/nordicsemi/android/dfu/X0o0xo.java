package no.nordicsemi.android.dfu;

import android.bluetooth.le.ScanFilter;
import android.os.ParcelUuid;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final /* synthetic */ class X0o0xo {
    @RequiresApi(21)
    public static List oIX0oI(DfuDeviceSelector dfuDeviceSelector, @NonNull ParcelUuid parcelUuid) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().setServiceUuid(parcelUuid).build());
        arrayList.add(new ScanFilter.Builder().build());
        return arrayList;
    }
}
