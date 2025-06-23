package com.realsil.sdk.dfu.image;

import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.util.List;

/* loaded from: classes11.dex */
public class BinFactory extends FirmwareLoaderX {
    public static List<BaseBinInputStream> loadImageBinFile(String str, int i, OtaDeviceInfo otaDeviceInfo, boolean z) throws DfuException {
        return FirmwareLoaderX.loadImageFile(new LoadParams.Builder().setFilePath(str).setFileIndicator(i).setOtaDeviceInfo(otaDeviceInfo).versionCheckEnabled(z).build());
    }

    public static BinInfo loadImageBinInfo(String str, OtaDeviceInfo otaDeviceInfo, boolean z) throws DfuException {
        return FirmwareLoaderX.loadImageBinInfo(new LoadParams.Builder().setFilePath(str).setOtaDeviceInfo(otaDeviceInfo).versionCheckEnabled(z).build());
    }
}
