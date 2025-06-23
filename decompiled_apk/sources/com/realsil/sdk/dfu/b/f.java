package com.realsil.sdk.dfu.b;

import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class f {
    public static int a(OtaDeviceInfo otaDeviceInfo, BinInfo binInfo) {
        int i;
        if (otaDeviceInfo == null || binInfo == null || ((i = otaDeviceInfo.icType) != 5 && i != 9 && i != 12)) {
            return 4096;
        }
        if (otaDeviceInfo.isBankEnabled()) {
            if (binInfo.isPackFile) {
                List<SubFileInfo> subFileInfos = binInfo.getSubFileInfos(otaDeviceInfo.getInactiveBank());
                if (subFileInfos == null || subFileInfos.size() <= 0) {
                    return 4110;
                }
                Iterator<SubFileInfo> it = subFileInfos.iterator();
                while (it.hasNext()) {
                    if (it.next().binId == 2048) {
                        return 4096;
                    }
                }
                return 4111;
            }
            return 4108;
        }
        if (binInfo.isPackFile) {
            List<SubFileInfo> subFileInfos2 = binInfo.getSubFileInfos(otaDeviceInfo.getInactiveBank());
            if (subFileInfos2 == null || subFileInfos2.size() <= 0) {
                return 4110;
            }
            Iterator<SubFileInfo> it2 = subFileInfos2.iterator();
            while (it2.hasNext()) {
                if (it2.next().binId == 2048) {
                    return 4112;
                }
            }
            return 4096;
        }
        if (binInfo.getBinInputStreamByBinId(2048) == null) {
            return 4096;
        }
        return 4112;
    }
}
