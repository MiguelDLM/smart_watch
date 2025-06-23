package com.realsil.sdk.dfu.image.pack;

import android.content.Context;
import androidx.core.view.ViewCompat;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.j.a;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.Locale;

/* loaded from: classes11.dex */
public class SubFileInfo {
    public static final int HEADER_SIZE = 12;
    public int bankBlockSize;
    public int binId;
    public int bitNumber;
    public int downloadAddr;
    public int fileLocation;
    public String filePath;
    public int icType;
    public int imageId;
    public int reserved;
    public byte[] sha256;
    public int size;
    public long startAddr;
    public int version = -1;
    public String imageFeature = "";
    public int customizeId = -1;

    public SubFileInfo(int i, int i2, String str, int i3, int i4, long j, int i5, int i6, int i7) {
        this.icType = i;
        this.fileLocation = i2;
        this.filePath = str;
        this.bitNumber = i3;
        this.bankBlockSize = i4;
        this.startAddr = j;
        this.downloadAddr = i5;
        this.size = i6;
        this.reserved = i7;
    }

    public static SubFileInfo builder(int i, String str, int i2, int i3, long j, byte[] bArr) {
        SubFileInfo subFileInfo = new SubFileInfo(i, 0, str, i2, i3, j, ((bArr[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[2] << 16) & 16711680) | ((bArr[1] << 8) & 65280) | (bArr[0] & 255), ((bArr[7] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[6] << 16) & 16711680) | ((bArr[5] << 8) & 65280) | (bArr[4] & 255), 0);
        subFileInfo.a();
        return subFileInfo;
    }

    public static SubFileInfo builderFromAssets(Context context, int i, String str, int i2, int i3, long j, byte[] bArr) {
        SubFileInfo subFileInfo = new SubFileInfo(i, 1, str, i2, i3, j, ((bArr[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[2] << 16) & 16711680) | ((bArr[1] << 8) & 65280) | (bArr[0] & 255), ((bArr[7] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[6] << 16) & 16711680) | ((bArr[5] << 8) & 65280) | (bArr[4] & 255), 0);
        subFileInfo.a(context);
        ZLogger.v(subFileInfo.toString());
        return subFileInfo;
    }

    public final void a() {
        BaseBinInputStream binInputStream = getBinInputStream(this.icType);
        if (binInputStream != null) {
            binInputStream.parseImageHeaderEx();
            this.version = binInputStream.getImageVersion();
            this.binId = binInputStream.getBinId();
            this.imageId = binInputStream.getImageId();
            this.sha256 = binInputStream.getSha256();
            this.customizeId = binInputStream.getCustomizeId();
            this.imageFeature = binInputStream.getImageFeature();
            try {
                binInputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public BaseBinInputStream getAssetsBinInputStream(Context context, int i) {
        try {
            BaseBinInputStream openAssetsInputStream = a.openAssetsInputStream(context, i, this.filePath, this.startAddr, 0);
            if (openAssetsInputStream != null) {
                openAssetsInputStream.setSha256(this.sha256);
                openAssetsInputStream.setCustomizeId(this.customizeId);
            }
            return openAssetsInputStream;
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return null;
        }
    }

    public BaseBinInputStream getBinInputStream(Context context, int i) {
        BaseBinInputStream openFileInputStream;
        try {
            if (this.fileLocation == 1) {
                openFileInputStream = a.openAssetsInputStream(context, i, this.filePath, this.startAddr, 0);
            } else {
                openFileInputStream = a.openFileInputStream(i, this.filePath, this.startAddr, 0);
            }
            if (openFileInputStream != null) {
                openFileInputStream.setSha256(this.sha256);
                openFileInputStream.setCustomizeId(this.customizeId);
            }
            return openFileInputStream;
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return null;
        }
    }

    public String toString() {
        return String.format(Locale.US, "icType=0x%02X, bitNumber=%d(%d）, binId=0x%04X, imageId=0x%04X, startAddr=%d, downloadAddr=0x%08x, size(include mp header+data)=0x%08x(%d), reserved=%d", Integer.valueOf(this.icType), Integer.valueOf(this.bitNumber), Integer.valueOf(this.bankBlockSize), Integer.valueOf(this.binId), Integer.valueOf(this.imageId), Long.valueOf(this.startAddr), Integer.valueOf(this.downloadAddr), Integer.valueOf(this.size), Integer.valueOf(this.size), Integer.valueOf(this.reserved));
    }

    public int wrapperBitNumber() {
        int i = this.bankBlockSize;
        if (i == 0) {
            return this.bitNumber;
        }
        return this.bitNumber % i;
    }

    public BaseBinInputStream getAssetsBinInputStream(Context context, int i, int i2) {
        try {
            BaseBinInputStream openAssetsInputStream = a.openAssetsInputStream(context, i, this.filePath, this.startAddr, i2);
            if (openAssetsInputStream != null) {
                openAssetsInputStream.setSha256(this.sha256);
                openAssetsInputStream.setCustomizeId(this.customizeId);
            }
            return openAssetsInputStream;
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return null;
        }
    }

    public BaseBinInputStream getBinInputStream(int i) {
        try {
            BaseBinInputStream openFileInputStream = a.openFileInputStream(i, this.filePath, this.startAddr, 0);
            if (openFileInputStream != null) {
                openFileInputStream.setSha256(this.sha256);
                openFileInputStream.setCustomizeId(this.customizeId);
            }
            return openFileInputStream;
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return null;
        }
    }

    public final void a(Context context) {
        try {
            BaseBinInputStream assetsBinInputStream = getAssetsBinInputStream(context, this.icType);
            if (assetsBinInputStream != null) {
                assetsBinInputStream.parseImageHeaderEx();
                this.version = assetsBinInputStream.getImageVersion();
                this.binId = assetsBinInputStream.getBinId();
                this.imageId = assetsBinInputStream.getImageId();
                this.sha256 = assetsBinInputStream.getSha256();
                this.customizeId = assetsBinInputStream.getCustomizeId();
                this.imageFeature = assetsBinInputStream.getImageFeature();
                assetsBinInputStream.close();
            }
        } catch (IOException | BufferUnderflowException e) {
            ZLogger.w(e.toString());
        }
    }

    public BaseBinInputStream getBinInputStream(int i, int i2) {
        try {
            BaseBinInputStream openFileInputStream = a.openFileInputStream(i, this.filePath, this.startAddr, i2);
            if (openFileInputStream != null) {
                openFileInputStream.setSha256(this.sha256);
                openFileInputStream.setCustomizeId(this.customizeId);
            }
            return openFileInputStream;
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return null;
        }
    }
}
