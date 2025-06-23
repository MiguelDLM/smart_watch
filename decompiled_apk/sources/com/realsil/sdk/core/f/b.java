package com.realsil.sdk.core.f;

import XXO0.oIX0oI;
import android.bluetooth.le.ScanRecord;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes11.dex */
public final class b {
    public static String a(ScanRecord scanRecord) {
        List serviceSolicitationUuids;
        StringBuilder sb = new StringBuilder();
        sb.append("scanRecord{");
        int i = Build.VERSION.SDK_INT;
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\tmAdvertiseFlags=0x%04X", Integer.valueOf(scanRecord.getAdvertiseFlags())));
        sb.append(String.format(locale, "\n\tmManufacturerSpecificData=%s", a(scanRecord.getManufacturerSpecificData())));
        sb.append(String.format(locale, "\n\tserviceData=%s", a(scanRecord.getServiceData())));
        sb.append(String.format(locale, "\n\tserviceUuids=%s", a(scanRecord.getServiceUuids())));
        sb.append(String.format(locale, "\n\tmDeviceName=%s", scanRecord.getDeviceName()));
        if (i >= 29) {
            serviceSolicitationUuids = scanRecord.getServiceSolicitationUuids();
            sb.append(String.format(locale, "\n\tserviceSolicitationUuids=%s", a((List<ParcelUuid>) serviceSolicitationUuids)));
        }
        sb.append("\n}");
        return sb.toString();
    }

    public static String a(List<ParcelUuid> list) {
        if (list != null && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("supported features (UUIDs)");
            for (ParcelUuid parcelUuid : list) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("\n\t");
                a2.append(parcelUuid.toString());
                sb.append(a2.toString());
            }
            return sb.toString();
        }
        return "";
    }

    public static String a(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < sparseArray.size(); i++) {
            byte[] valueAt = sparseArray.valueAt(i);
            int length = valueAt != null ? valueAt.length : 0;
            sb.append(sparseArray.keyAt(i));
            sb.append("=(");
            sb.append(length);
            sb.append(oIX0oI.I0Io.f4095I0Io);
            sb.append(DataConverter.bytes2HexWithSeparate(valueAt));
        }
        sb.append('}');
        return sb.toString();
    }

    public static <T> String a(Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            T key = it.next().getKey();
            byte[] bArr = map.get(key);
            int length = bArr != null ? bArr.length : 0;
            sb.append(key);
            sb.append("=(");
            sb.append(length);
            sb.append(oIX0oI.I0Io.f4095I0Io);
            sb.append(DataConverter.bytes2HexWithSeparate(bArr));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
