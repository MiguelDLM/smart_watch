package com.realsil.sdk.dfu.p;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes11.dex */
public class b extends com.realsil.sdk.dfu.j.a {
    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        OtaDeviceInfo otaDeviceInfo;
        boolean z;
        OtaDeviceInfo otaDeviceInfo2;
        Iterator<SubFileInfo> it;
        int i;
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        int i2 = loadParams.i();
        BinInfo a2 = com.realsil.sdk.dfu.j.a.a(loadParams);
        a2.icType = i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        com.realsil.sdk.dfu.e.a b = com.realsil.sdk.dfu.d.b.b(loadParams);
        int i3 = 1;
        if (b != null) {
            a2.isPackFile = true;
            a2.icType = b.a();
            a2.subFileInfos = b.c(0);
            a2.subFileInfos1 = b.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(a2.icType, i2)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(a2.icType)));
                a2.updateEnabled = false;
                a2.status = 4101;
                return a2;
            }
            Iterator<SubFileInfo> it2 = b.c(loadParams.l()).iterator();
            while (it2.hasNext()) {
                SubFileInfo next = it2.next();
                BaseBinInputStream assetsBinInputStream = next.getAssetsBinInputStream(loadParams.a(), a2.icType, loadParams.f());
                if (assetsBinInputStream != null) {
                    arrayList2.add(assetsBinInputStream);
                    if (y && g != null) {
                        BinIndicator indByImageId = BinIndicator.getIndByImageId(a2.icType, next.imageId);
                        if (indByImageId != null) {
                            i = indByImageId.versionFormat;
                        } else {
                            i = 1;
                        }
                        ImageVersionInfo activeImageVersionInfoByImageId = g.getActiveImageVersionInfoByImageId(assetsBinInputStream.getImageId());
                        if (activeImageVersionInfoByImageId != null) {
                            if (activeImageVersionInfoByImageId.getVersion() == -1) {
                                boolean z2 = com.realsil.sdk.dfu.j.a.f19549a;
                                Object[] objArr = new Object[i3];
                                objArr[0] = Integer.valueOf(activeImageVersionInfoByImageId.getVersion());
                                ZLogger.v(z2, String.format("invalid active version:0x%04X, no need to check", objArr));
                                assetsBinInputStream.setActiveCompareVersionFlag(i3);
                                it = it2;
                            } else {
                                int compareVersion = com.realsil.sdk.dfu.j.a.compareVersion(assetsBinInputStream.imageVersion, activeImageVersionInfoByImageId.getVersion(), i);
                                it = it2;
                                i3 = 1;
                                ZLogger.v(String.format(Locale.US, "compare active image(%04X), compare=%d ", Integer.valueOf(assetsBinInputStream.getImageId()), Integer.valueOf(compareVersion)));
                                assetsBinInputStream.setActiveCompareVersionFlag(compareVersion);
                            }
                        } else {
                            it = it2;
                            boolean z3 = com.realsil.sdk.dfu.j.a.f19549a;
                            Object[] objArr2 = new Object[i3];
                            objArr2[0] = Integer.valueOf(assetsBinInputStream.getImageId());
                            ZLogger.v(z3, String.format("not find active image, imageId=0x%04X", objArr2));
                            assetsBinInputStream.setActiveCompareVersionFlag(i3);
                        }
                        ImageVersionInfo inActiveImageVersionInfoByImageId = g.getInActiveImageVersionInfoByImageId(assetsBinInputStream.getImageId());
                        if (inActiveImageVersionInfoByImageId != null) {
                            if (inActiveImageVersionInfoByImageId.getVersion() == -1) {
                                boolean z4 = com.realsil.sdk.dfu.j.a.f19549a;
                                Object[] objArr3 = new Object[i3];
                                objArr3[0] = Integer.valueOf(inActiveImageVersionInfoByImageId.getVersion());
                                ZLogger.v(z4, String.format("invalid inactive version:0x%04X, no need to check", objArr3));
                                assetsBinInputStream.setInactiveVersionCompFlag(i3);
                                otaDeviceInfo2 = g;
                            } else {
                                int compareVersion2 = com.realsil.sdk.dfu.j.a.compareVersion(assetsBinInputStream.imageVersion, inActiveImageVersionInfoByImageId.getVersion(), i);
                                Locale locale = Locale.US;
                                Integer valueOf = Integer.valueOf(assetsBinInputStream.getImageId());
                                Integer valueOf2 = Integer.valueOf(compareVersion2);
                                otaDeviceInfo2 = g;
                                Object[] objArr4 = new Object[2];
                                objArr4[0] = valueOf;
                                objArr4[i3] = valueOf2;
                                ZLogger.v(String.format(locale, "compare inactive image(%04X), compare=%d ", objArr4));
                                assetsBinInputStream.setInactiveVersionCompFlag(compareVersion2);
                            }
                        } else {
                            otaDeviceInfo2 = g;
                            boolean z5 = com.realsil.sdk.dfu.j.a.f19549a;
                            Object[] objArr5 = new Object[i3];
                            objArr5[0] = Integer.valueOf(assetsBinInputStream.getImageId());
                            ZLogger.v(z5, String.format("not find inactive image, imageId=0x%04X", objArr5));
                            assetsBinInputStream.setInactiveVersionCompFlag(i3);
                        }
                    } else {
                        otaDeviceInfo2 = g;
                        it = it2;
                    }
                    if (y) {
                        if (assetsBinInputStream.getActiveCompareVersionFlag() == i3) {
                            arrayList3.add(assetsBinInputStream);
                            arrayList.add(next);
                        } else {
                            g = otaDeviceInfo2;
                            it2 = it;
                        }
                    } else {
                        arrayList3.add(assetsBinInputStream);
                        arrayList.add(next);
                    }
                    g = otaDeviceInfo2;
                    it2 = it;
                    i3 = 1;
                }
            }
            try {
                b.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
        } else {
            try {
                BaseBinInputStream openAssetsInputStream = com.realsil.sdk.dfu.j.a.openAssetsInputStream(loadParams.a(), a2.icType, loadParams.d(), 0L, loadParams.f());
                if (openAssetsInputStream != null) {
                    arrayList2.add(openAssetsInputStream);
                    a2.icType = openAssetsInputStream.getIcType();
                    a2.version = openAssetsInputStream.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(a2.icType, i2)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(a2.icType)));
                        a2.updateEnabled = false;
                        a2.status = 4101;
                        return a2;
                    }
                    BinIndicator binIndicatorByImageId = BinIndicator.getBinIndicatorByImageId(a2.icType, openAssetsInputStream.getImageId(), 0);
                    if (y) {
                        otaDeviceInfo = g;
                        if (1 != com.realsil.sdk.dfu.j.a.checkSingleImageVersion(binIndicatorByImageId, openAssetsInputStream, otaDeviceInfo)) {
                            z = true;
                            a2.lowVersionExist = z;
                            a2.subBinInputStreams = arrayList2;
                            a2.supportBinInputStreams = arrayList3;
                            a2.supportSubFileInfos = arrayList;
                            if (y && z && arrayList3.size() < 1) {
                                a2.updateEnabled = false;
                                a2.status = 4104;
                            }
                            return a2;
                        }
                    } else {
                        otaDeviceInfo = g;
                    }
                    if (!loadParams.u()) {
                        arrayList3.add(openAssetsInputStream);
                    } else if (1 == com.realsil.sdk.dfu.j.a.a(openAssetsInputStream, otaDeviceInfo)) {
                        arrayList3.add(openAssetsInputStream);
                    }
                }
            } catch (IOException e2) {
                ZLogger.w(e2.toString());
                throw new LoadFileException(e2.getMessage(), 4097);
            }
        }
        z = false;
        a2.lowVersionExist = z;
        a2.subBinInputStreams = arrayList2;
        a2.supportBinInputStreams = arrayList3;
        a2.supportSubFileInfos = arrayList;
        if (y) {
            a2.updateEnabled = false;
            a2.status = 4104;
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x022c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.realsil.sdk.dfu.model.BinInfo loadImageBinInfo(com.realsil.sdk.dfu.image.LoadParams r20) throws com.realsil.sdk.dfu.exception.LoadFileException {
        /*
            Method dump skipped, instructions count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.p.b.loadImageBinInfo(com.realsil.sdk.dfu.image.LoadParams):com.realsil.sdk.dfu.model.BinInfo");
    }
}
