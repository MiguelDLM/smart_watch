package com.bluetrum.fota.manager;

import androidx.annotation.NonNull;
import com.bluetrum.fota.log.Logger;
import com.bluetrum.fota.utils.CryptoUtils;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes8.dex */
final class OtaDataReader implements DataReader {
    private static final String TAG = "OtaDataReader";
    private final byte[] otaData;

    public OtaDataReader(@NonNull byte[] bArr) {
        this.otaData = bArr;
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public void close() throws IOException {
        Logger.d(TAG, "close");
    }

    @Override // com.bluetrum.fota.manager.DataReader
    @NonNull
    public byte[] getHash() throws IOException {
        Logger.d(TAG, "getHash");
        return getHash(this.otaData);
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public int getSize() throws IOException {
        Logger.d(TAG, "getSize: " + this.otaData.length);
        return this.otaData.length;
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public void open() throws IOException {
        Logger.d(TAG, "open");
    }

    @Override // com.bluetrum.fota.manager.DataReader
    public int read(int i, byte[] bArr, int i2, int i3) throws IOException {
        Logger.d(TAG, String.format(Locale.US, "read: srcPos=%d, dstPos=%d, length=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        System.arraycopy(this.otaData, i, bArr, i2, i3);
        return i3;
    }

    @NonNull
    private byte[] getHash(byte[] bArr) {
        byte[] md5 = CryptoUtils.getMD5(bArr);
        if (md5 != null) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(md5, 0, bArr2, 0, 4);
            return bArr2;
        }
        return new byte[]{-1, -1, -1, -1};
    }
}
