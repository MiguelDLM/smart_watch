package com.realsil.sdk.dfu.j;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.FileUtils;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.b.g;
import com.realsil.sdk.dfu.b.h;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.image.wrapper.SocImageWrapper;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.utils.DfuUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* loaded from: classes11.dex */
public class a {
    public static final int ERR_EQUAL_VERSION = 0;
    public static final int ERR_IMAGE_NOT_DEFINED = 3;
    public static final int ERR_LOW_VERSION = -1;
    public static final int ERR_SECTION_SIZE_EXCEED_LIMIT = 2;
    public static final int ERR_SUCCESS = 1;
    public static final String FILE_SUFFIX = "BIN";

    /* renamed from: a, reason: collision with root package name */
    public static boolean f19549a = RtkDfu.DEBUG_ENABLE;
    public static boolean b = RtkDfu.VDBG;

    public static boolean a(int i, int i2) {
        return i2 <= 3 ? i <= 3 : (i2 == 4 || i2 == 8 || i2 == 6) ? i == 4 || i == 8 || i == 6 : i2 == i;
    }

    public static BinInfo b(LoadParams loadParams) throws LoadFileException {
        String d = loadParams.d();
        if (!TextUtils.isEmpty(d)) {
            String e = loadParams.e();
            String suffix = FileUtils.getSuffix(d);
            if (suffix != null && suffix.equalsIgnoreCase(e)) {
                File file = new File(d);
                if (file.exists()) {
                    BinInfo binInfo = new BinInfo();
                    binInfo.path = file.getPath();
                    binInfo.fileName = file.getName();
                    binInfo.fileSize = file.length();
                    binInfo.updateBank = loadParams.l();
                    return binInfo;
                }
                throw new LoadFileException("image file not exist", 4100);
            }
            ZLogger.w("invalid suffix: " + suffix);
            throw new LoadFileException("invalid suffix", 4099);
        }
        throw new LoadFileException("invalid path: ", 4098);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r11 != 21) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0197, code lost:
    
        if (r11 != 21) goto L115;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int checkPackImageVersion(int r11, com.realsil.sdk.dfu.image.stream.BaseBinInputStream r12, com.realsil.sdk.dfu.model.OtaDeviceInfo r13) {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.j.a.checkPackImageVersion(int, com.realsil.sdk.dfu.image.stream.BaseBinInputStream, com.realsil.sdk.dfu.model.OtaDeviceInfo):int");
    }

    public static int checkSingleImageVersion(BaseBinInputStream baseBinInputStream, OtaDeviceInfo otaDeviceInfo) {
        if (otaDeviceInfo == null) {
            return 1;
        }
        int binId = baseBinInputStream.getBinId();
        int i = baseBinInputStream.imageVersion;
        if (otaDeviceInfo.specVersion == 0) {
            int i2 = otaDeviceInfo.icType;
            if (i2 <= 3) {
                ZLogger.v("not support version check for bee1 when otaVersion=0");
                return 1;
            }
            if (i2 == 4 || i2 == 6 || i2 == 7 || i2 == 8) {
                if (binId != 512) {
                    if (binId == 768 && i < otaDeviceInfo.getAppVersion()) {
                        ZLogger.w(String.format(Locale.US, "app iamge: file(%08X)<device(%08X)", Integer.valueOf(i), Integer.valueOf(otaDeviceInfo.getAppVersion())));
                        return -1;
                    }
                } else if (i < otaDeviceInfo.getPatchVersion()) {
                    ZLogger.w(String.format(Locale.US, "patch iamge : file(%08X)<device(%08X)", Integer.valueOf(i), Integer.valueOf(otaDeviceInfo.getPatchVersion())));
                    return -1;
                }
            } else if (i2 == 5 || i2 == 9 || i2 == 12) {
                if (binId != 512) {
                    if (binId == 768 && i < otaDeviceInfo.getAppVersion()) {
                        ZLogger.w(String.format(Locale.US, "app iamge : file(%08X)<device(%08X)", Integer.valueOf(i), Integer.valueOf(otaDeviceInfo.getAppVersion())));
                        return -1;
                    }
                } else if (i < otaDeviceInfo.getPatchVersion()) {
                    ZLogger.w(String.format(Locale.US, "patch iamge: file(%08X)<device(%08X)", Integer.valueOf(i), Integer.valueOf(otaDeviceInfo.getPatchVersion())));
                    return -1;
                }
            }
            return 1;
        }
        return checkSingleImageVersion2(baseBinInputStream, otaDeviceInfo);
    }

    public static int checkSingleImageVersion2(BaseBinInputStream baseBinInputStream, OtaDeviceInfo otaDeviceInfo) {
        if (otaDeviceInfo == null) {
            return 1;
        }
        int binId = baseBinInputStream.getBinId();
        int i = otaDeviceInfo.icType;
        if (i <= 3) {
            ZLogger.d("not support version check for bee1 when otaVersion=1");
            return 1;
        }
        return checkSingleImageVersion2(BinIndicator.getBinIndicatorByBinId(i, binId, 0), baseBinInputStream, otaDeviceInfo);
    }

    public static int compareVersion(int i, int i2, int i3) {
        g a2 = g.a(i3, i);
        g a3 = g.a(i3, i2);
        ZLogger.v(a2.toString());
        ZLogger.v(a3.toString());
        return a2.a(a3);
    }

    public static g getBinImageVersion(int i, int i2, int i3, int i4) {
        if (i3 == 2 && i == 1040) {
            i4 = 516;
        }
        if (i3 <= 0) {
            i4 = 7;
        }
        return g.a(i4, i2);
    }

    public static g getSocImageVersion(int i, int i2, int i3, int i4, int i5, boolean z) {
        return g.a(SocImageWrapper.getImageVersionFormatWithImageId(i, i2, i3, i4, z), i5);
    }

    public static BaseBinInputStream openAssetsInputStream(Context context, int i, String str, long j, int i2) throws IOException {
        ZLogger.v(b, String.format(Locale.US, "fileName=%s, icType=%d", str, Integer.valueOf(i)));
        AssetManager assets = context.getAssets();
        if (assets != null) {
            InputStream open = assets.open(str);
            if (open == null) {
                ZLogger.d("open asset file failed");
                return null;
            }
            return a(i, open, j, i2);
        }
        ZLogger.w("assetManager is null");
        return null;
    }

    public static BaseBinInputStream openFileInputStream(int i, String str, long j, int i2) throws IOException {
        return a(i, new FileInputStream(str), j, i2);
    }

    public static int wrapperBitNumber(int i, int i2, int i3) {
        int i4 = (i2 >> (i * 2)) & 3;
        if (i4 == 0) {
            if (i3 != 2) {
                return i;
            }
        } else if (i4 != 1) {
            return i;
        }
        return i + 16;
    }

    public static BinInfo a(LoadParams loadParams) throws LoadFileException {
        if (loadParams.a() != null) {
            String d = loadParams.d();
            if (!TextUtils.isEmpty(d)) {
                String e = loadParams.e();
                String suffix = FileUtils.getSuffix(d);
                if (suffix != null && suffix.equalsIgnoreCase(e)) {
                    BinInfo binInfo = new BinInfo();
                    binInfo.path = d;
                    binInfo.fileName = DfuUtils.getAssetsFileName(d);
                    binInfo.updateBank = loadParams.l();
                    return binInfo;
                }
                ZLogger.w("invalid suffix: " + suffix);
                throw new LoadFileException("invalid suffix", 4099);
            }
            throw new LoadFileException("invalid path: ", 4098);
        }
        throw new LoadFileException("invalid context", 4097);
    }

    public static int wrapperBitNumber(int i, int i2) {
        return i2 == 0 ? i : i % i2;
    }

    public static int checkSingleImageVersion2(BinIndicator binIndicator, BaseBinInputStream baseBinInputStream, OtaDeviceInfo otaDeviceInfo) {
        if (binIndicator == null || otaDeviceInfo == null) {
            return 1;
        }
        ZLogger.d(binIndicator.toString());
        ImageVersionInfo activeImageVersionInfo = otaDeviceInfo.getActiveImageVersionInfo(binIndicator.bitNumber);
        if (activeImageVersionInfo == null) {
            return 1;
        }
        if (compareVersion(baseBinInputStream.imageVersion, binIndicator.versionFormat, activeImageVersionInfo.getVersion(), otaDeviceInfo.specVersion, binIndicator.versionFormat) <= 0) {
            ZLogger.w(String.format(Locale.US, "image: bitNumber=%d, file(%08X)<device(%08X)", Integer.valueOf(binIndicator.bitNumber), Integer.valueOf(baseBinInputStream.imageVersion), Integer.valueOf(activeImageVersionInfo.getVersion())));
            return -1;
        }
        ZLogger.v("version validate ok: " + baseBinInputStream.imageVersion);
        return 1;
    }

    public static int compareVersion(int i, int i2, int i3, int i4, int i5) {
        ZLogger.v(String.format(Locale.US, "checkVersion: bin=%08X(%d) %s, soc=%08X(%d) %s", Integer.valueOf(i), Integer.valueOf(i), DfuUtils.convertVersion2Str(i2, i, i5), Integer.valueOf(i3), Integer.valueOf(i3), DfuUtils.convertVersion2Str(i4, i3, i5)));
        if (i3 == -1) {
            return 1;
        }
        if (i2 <= 0) {
            return com.realsil.sdk.dfu.c.b.a(i, h.a(i3, i4, i5));
        }
        if (i4 <= 0) {
            return com.realsil.sdk.dfu.c.b.a(h.a(i, i2, i5), i3);
        }
        return g.a(i5, i).a(g.a(i5, i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(com.realsil.sdk.dfu.image.stream.BaseBinInputStream r19, com.realsil.sdk.dfu.model.OtaDeviceInfo r20, int r21) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.j.a.a(com.realsil.sdk.dfu.image.stream.BaseBinInputStream, com.realsil.sdk.dfu.model.OtaDeviceInfo, int):int");
    }

    public static int compareVersion(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        return getBinImageVersion(i2, i4, i5, i9).a(getSocImageVersion(i, i6, i8, i3, i7, z));
    }

    public static int checkSingleImageVersion(BinIndicator binIndicator, BaseBinInputStream baseBinInputStream, OtaDeviceInfo otaDeviceInfo) {
        if (binIndicator == null || otaDeviceInfo == null) {
            return 1;
        }
        ZLogger.d(binIndicator.toString());
        ImageVersionInfo activeImageVersionInfoByImageId = otaDeviceInfo.getActiveImageVersionInfoByImageId(baseBinInputStream.getImageId());
        if (activeImageVersionInfoByImageId == null) {
            return 1;
        }
        if (compareVersion(baseBinInputStream.imageVersion, binIndicator.versionFormat, activeImageVersionInfoByImageId.getVersion(), otaDeviceInfo.specVersion, binIndicator.versionFormat) <= 0) {
            ZLogger.w(String.format(Locale.US, "image: bitNumber=%d, file(%08X)<device(%08X)", Integer.valueOf(binIndicator.bitNumber), Integer.valueOf(baseBinInputStream.imageVersion), Integer.valueOf(activeImageVersionInfoByImageId.getVersion())));
            return -1;
        }
        ZLogger.v("version validate ok: " + baseBinInputStream.imageVersion);
        return 1;
    }

    public static BaseBinInputStream a(int i, InputStream inputStream, long j, int i2) throws IOException {
        if (b) {
            ZLogger.v(String.format(Locale.US, "icType=0x%02X, skipOffset=%d,imageHeadsetOffset=%d", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)));
        }
        inputStream.skip(j);
        if (i <= 3) {
            return new com.realsil.sdk.dfu.g.c(inputStream, i2, 20);
        }
        if (i == 4 || i == 6 || i == 7 || i == 8) {
            return new com.realsil.sdk.dfu.g.b(inputStream, i2, 20);
        }
        if (i == 11 || i == 10 || i == 13) {
            return new com.realsil.sdk.dfu.g.a(inputStream, 304, 20);
        }
        if (i == 5 || i == 9 || i == 12) {
            return new com.realsil.sdk.dfu.g.d(inputStream, i2, 20);
        }
        if (i == 14) {
            return new com.realsil.sdk.dfu.g.d(inputStream, i2, 20);
        }
        ZLogger.v(String.format("not support icType=0x%02X", Integer.valueOf(i)));
        return null;
    }

    public static int a(BaseBinInputStream baseBinInputStream, int i, OtaDeviceInfo otaDeviceInfo) {
        return (otaDeviceInfo == null || a(baseBinInputStream, otaDeviceInfo.getActiveImageVersionInfoByImageId(i))) ? 1 : 2;
    }

    public static int a(BaseBinInputStream baseBinInputStream, OtaDeviceInfo otaDeviceInfo) {
        BinIndicator a2;
        if (otaDeviceInfo == null || (a2 = com.realsil.sdk.dfu.b.b.a(baseBinInputStream.getBinId())) == null) {
            return 1;
        }
        ZLogger.v(a2.toString());
        if (a2.versionCheckEnabled) {
            return !a(baseBinInputStream, otaDeviceInfo.getActiveImageVersionInfo(a2.bitNumber)) ? 2 : 1;
        }
        ZLogger.d(f19549a, "not support version check , ignore section size");
        return 1;
    }

    public static boolean a(BaseBinInputStream baseBinInputStream, ImageVersionInfo imageVersionInfo) {
        if (imageVersionInfo == null) {
            return true;
        }
        int imageSize = baseBinInputStream.getImageSize();
        if (imageVersionInfo.getSectionSize() > 0 && imageSize > imageVersionInfo.getSectionSize()) {
            ZLogger.w(String.format(Locale.US, "image size(%d) is exceed the limit of section size(%d)", Integer.valueOf(imageSize), Integer.valueOf(imageVersionInfo.getSectionSize())));
            return false;
        }
        ZLogger.v(b, "section size validate ok: " + imageSize);
        return true;
    }
}
