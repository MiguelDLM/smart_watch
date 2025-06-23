package com.goodix.ble.gr.libdfu.util;

import com.goodix.ble.gr.libdfu.dfu.entity.ImgInfo;
import com.goodix.ble.libcomx.util.HexReader;
import com.goodix.ble.libcomx.util.IntUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public class ImgInfoUtil {
    public static boolean checkCollision(ImgInfo imgInfo, List<ImgInfo> list) {
        return overwriteImgInfo(imgInfo, list, true);
    }

    public static void clearImgInfo(ImgInfo imgInfo) {
        if (imgInfo == null) {
            return;
        }
        int serializeSize = imgInfo.getSerializeSize();
        byte[] bArr = new byte[serializeSize];
        for (int i = 0; i < serializeSize; i++) {
            bArr[i] = -1;
        }
        imgInfo.deserialize(new HexReader(bArr));
    }

    public static List<ImgInfo> getAvalid(List<ImgInfo> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ImgInfo imgInfo : list) {
            if (imgInfo.getPatern() == 18244) {
                arrayList.add(imgInfo);
            }
        }
        return arrayList;
    }

    public static boolean overwriteImgInfo(ImgInfo imgInfo, List<ImgInfo> list) {
        return overwriteImgInfo(imgInfo, list, false);
    }

    public static void sortImgList(List<ImgInfo> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                ImgInfo imgInfo = list.get(i);
                ImgInfo imgInfo2 = list.get(i3);
                if (imgInfo2.getPatern() == 18244 && (imgInfo.getPatern() != 18244 || imgInfo2.getBootInfo().getLoadAddr() < imgInfo.getBootInfo().getLoadAddr())) {
                    list.set(i, imgInfo2);
                    list.set(i3, imgInfo);
                }
            }
            i = i2;
        }
    }

    public static boolean overwriteImgInfo(ImgInfo imgInfo, List<ImgInfo> list, boolean z) {
        boolean z2 = false;
        if (list != null) {
            int loadAddr = imgInfo.getBootInfo().getLoadAddr();
            int appSize = imgInfo.getBootInfo().getAppSize();
            for (ImgInfo imgInfo2 : list) {
                if (imgInfo2.getPatern() == 18244 && IntUtil.memoryOverlap(loadAddr, appSize, imgInfo2.getBootInfo().getLoadAddr(), imgInfo2.getBootInfo().getAppSize())) {
                    z2 = true;
                    if (z) {
                        break;
                    }
                    clearImgInfo(imgInfo2);
                }
            }
        }
        return z2;
    }
}
