package com.realsil.sdk.dfu.utils;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.j.a;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.io.IOException;

/* loaded from: classes11.dex */
public class DfuHelper {
    public static int compareOtaHeaderVersion(BinInfo binInfo, OtaDeviceInfo otaDeviceInfo) {
        BaseBinInputStream otaHeaderImage;
        if (binInfo == null || otaDeviceInfo == null || (otaHeaderImage = binInfo.getOtaHeaderImage(otaDeviceInfo.getInactiveBank())) == null) {
            return 0;
        }
        int compareVersion = a.compareVersion(otaDeviceInfo.getOtaHeaderImageVersion(), otaDeviceInfo.specVersion, otaHeaderImage.getImageVersion(), otaHeaderImage.getOtaVersion(), 1);
        try {
            otaHeaderImage.close();
        } catch (IOException e) {
            ZLogger.w(e.toString());
        }
        return compareVersion;
    }

    public static int compareVersion(BinInfo binInfo, OtaDeviceInfo otaDeviceInfo) {
        return 0;
    }

    public int getAppVersion(OtaDeviceInfo otaDeviceInfo) {
        int i = otaDeviceInfo.specVersion;
        if (i == 0) {
            return otaDeviceInfo.getAppVersion();
        }
        if (i == 1) {
            for (ImageVersionInfo imageVersionInfo : otaDeviceInfo.getExistImageVersionInfos()) {
                int i2 = otaDeviceInfo.icType;
                if (i2 <= 3) {
                    if (imageVersionInfo.getBitNumber() == 1 || imageVersionInfo.getBitNumber() == 2) {
                        return imageVersionInfo.getVersion();
                    }
                } else if (i2 == 5) {
                    if (imageVersionInfo.getBitNumber() == 5 || imageVersionInfo.getBitNumber() == 21) {
                        return imageVersionInfo.getVersion();
                    }
                } else if (i2 == 4 && (imageVersionInfo.getBitNumber() == 5 || imageVersionInfo.getBitNumber() == 21)) {
                    return imageVersionInfo.getVersion();
                }
            }
            return 0;
        }
        return 0;
    }
}
