package com.realsil.sdk.dfu.model;

import com.realsil.sdk.dfu.image.wrapper.SocImageWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class DeviceInfoParser {
    public static List<SocImageWrapper> getExistInactiveSocImageWrappers(DeviceInfo deviceInfo, List<ImageVersionInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : list) {
                if (imageVersionInfo.getIndication() != 0) {
                    arrayList.add(new SocImageWrapper.Builder().setDeviceInfo(deviceInfo).imageVersionInfo(imageVersionInfo).build());
                }
            }
        }
        return arrayList;
    }
}
