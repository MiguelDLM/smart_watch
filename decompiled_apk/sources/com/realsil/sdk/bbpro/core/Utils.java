package com.realsil.sdk.bbpro.core;

import android.os.ParcelUuid;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* loaded from: classes11.dex */
public class Utils {
    public static ParcelUuid byteArrayToUuid(byte[] bArr) {
        if (bArr != null && bArr.length >= 16) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.BIG_ENDIAN);
            return new ParcelUuid(new UUID(wrap.getLong(0), wrap.getLong(8)));
        }
        return null;
    }

    public static ParcelUuid[] byteArrayToUuids(byte[] bArr) {
        int length = bArr.length / 16;
        ParcelUuid[] parcelUuidArr = new ParcelUuid[length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            parcelUuidArr[i2] = new ParcelUuid(new UUID(wrap.getLong(i), wrap.getLong(i + 8)));
            i += 16;
        }
        return parcelUuidArr;
    }

    public static boolean checkUuid(ParcelUuid[] parcelUuidArr, UUID uuid, boolean z) {
        ParcelUuid byteArrayToUuid;
        if (uuid != null && parcelUuidArr != null && parcelUuidArr.length > 0) {
            for (ParcelUuid parcelUuid : parcelUuidArr) {
                if (parcelUuid != null) {
                    if (uuid.equals(parcelUuid.getUuid())) {
                        return true;
                    }
                    if (!BluetoothUuid.is16BitUuid(parcelUuid) && !BluetoothUuid.is32BitUuid(parcelUuid) && z && (byteArrayToUuid = byteArrayToUuid(DataConverter.reverse(uuidToByteArray(parcelUuid)))) != null && uuid.equals(byteArrayToUuid.getUuid())) {
                        ZLogger.v("match reverse uuid:" + parcelUuid.toString());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ParcelUuid getUuid(ParcelUuid[] parcelUuidArr, UUID uuid, boolean z) {
        ParcelUuid byteArrayToUuid;
        if (uuid != null && parcelUuidArr != null && parcelUuidArr.length > 0) {
            for (ParcelUuid parcelUuid : parcelUuidArr) {
                if (parcelUuid != null) {
                    if (uuid.equals(parcelUuid.getUuid())) {
                        return parcelUuid;
                    }
                    if (!BluetoothUuid.is16BitUuid(parcelUuid) && !BluetoothUuid.is32BitUuid(parcelUuid) && z && (byteArrayToUuid = byteArrayToUuid(DataConverter.reverse(uuidToByteArray(parcelUuid)))) != null && uuid.equals(byteArrayToUuid.getUuid())) {
                        ZLogger.v("match reverse uuid:" + byteArrayToUuid.toString());
                        return byteArrayToUuid;
                    }
                }
            }
        }
        return null;
    }

    public static byte[] uuidToByteArray(ParcelUuid parcelUuid) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.order(ByteOrder.BIG_ENDIAN);
        UUID uuid = parcelUuid.getUuid();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        allocate.putLong(mostSignificantBits);
        allocate.putLong(8, leastSignificantBits);
        return allocate.array();
    }
}
