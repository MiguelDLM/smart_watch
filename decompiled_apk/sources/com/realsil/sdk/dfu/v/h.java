package com.realsil.sdk.dfu.v;

import android.util.SparseIntArray;
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
public class h extends com.realsil.sdk.dfu.j.a {
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r22, com.realsil.sdk.dfu.image.stream.BaseBinInputStream r23, com.realsil.sdk.dfu.model.OtaDeviceInfo r24) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.h.a(int, com.realsil.sdk.dfu.image.stream.BaseBinInputStream, com.realsil.sdk.dfu.model.OtaDeviceInfo):int");
    }

    public static int b(BaseBinInputStream baseBinInputStream, OtaDeviceInfo otaDeviceInfo) {
        if (otaDeviceInfo == null) {
            return 1;
        }
        BinIndicator indByBinId = BinIndicator.getIndByBinId(otaDeviceInfo.icType, baseBinInputStream.getBinId());
        if (indByBinId != null && indByBinId.versionCheckEnabled) {
            ZLogger.v(indByBinId.toString());
            if (!com.realsil.sdk.dfu.j.a.a(baseBinInputStream, otaDeviceInfo.getActiveImageVersionInfo(indByBinId.bitNumber))) {
                return 2;
            }
        }
        return 1;
    }

    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        byte[] bArr;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        SubFileInfo b;
        int i2 = loadParams.i();
        String d = loadParams.d();
        int b2 = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        boolean u = loadParams.u();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        BinInfo b3 = com.realsil.sdk.dfu.j.a.b(loadParams);
        com.realsil.sdk.dfu.e.a c = com.realsil.sdk.dfu.d.b.c(loadParams);
        if (c != null) {
            b3.isPackFile = true;
            b3.icType = c.a();
            b3.subFileInfos = c.c(0);
            b3.subFileInfos1 = c.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i2)) {
                ZLogger.d(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(b3.icType)));
                b3.updateEnabled = false;
                b3.status = 4101;
                return b3;
            }
            if (u && (b = c.b()) != null) {
                BaseBinInputStream binInputStream = b.getBinInputStream(b3.icType, loadParams.f());
                if (binInputStream != null && 1 != com.realsil.sdk.dfu.j.a.a(binInputStream, b.imageId, g)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z3 = true;
            } else {
                z2 = true;
                z3 = false;
            }
            if (z2) {
                z4 = false;
                for (SubFileInfo subFileInfo : c.c(loadParams.l())) {
                    int wrapperBitNumber = subFileInfo.wrapperBitNumber();
                    if (!BinIndicator.isIndicatorEnabled(b2, wrapperBitNumber)) {
                        ZLogger.v("prohibit upgrade image_id=" + subFileInfo.imageId);
                    } else {
                        BaseBinInputStream binInputStream2 = subFileInfo.getBinInputStream(b3.icType, loadParams.f());
                        if (binInputStream2 == null) {
                            ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "invalid stream: " + subFileInfo.toString());
                        } else {
                            if (y) {
                                i = 1;
                                if (1 != a(wrapperBitNumber, binInputStream2, g)) {
                                    z4 = true;
                                }
                            } else {
                                i = 1;
                            }
                            if (u) {
                                if (z3) {
                                    ZLogger.d("preVerify OTA_HEADER_FILE ok, no need to check section size");
                                } else if (i != com.realsil.sdk.dfu.j.a.a(binInputStream2, subFileInfo.imageId, g)) {
                                    b3.updateEnabled = false;
                                    b3.status = 4109;
                                    return b3;
                                }
                            }
                            arrayList3.add(binInputStream2);
                            arrayList.add(subFileInfo);
                        }
                    }
                }
            } else {
                ZLogger.w("pre verify failed");
                z4 = false;
            }
            try {
                c.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            z = z4;
        } else {
            try {
                BaseBinInputStream openFileInputStream = com.realsil.sdk.dfu.j.a.openFileInputStream(b3.icType, d, 0L, loadParams.f());
                if (openFileInputStream != null) {
                    openFileInputStream.parseImageHeaderEx();
                    bArr = openFileInputStream.getSha256();
                    try {
                        openFileInputStream.close();
                    } catch (Exception e2) {
                        ZLogger.e(e2.toString());
                    }
                } else {
                    bArr = null;
                }
                BaseBinInputStream openFileInputStream2 = com.realsil.sdk.dfu.j.a.openFileInputStream(i2, d, 0L, loadParams.f());
                if (openFileInputStream2 != null) {
                    openFileInputStream2.setSha256(bArr);
                    arrayList2.add(openFileInputStream2);
                    b3.icType = openFileInputStream2.getIcType();
                    b3.version = openFileInputStream2.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i2)) {
                        ZLogger.d(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(b3.icType)));
                        b3.updateEnabled = false;
                        b3.status = 4101;
                        return b3;
                    }
                    if (y && 1 != com.realsil.sdk.dfu.j.a.checkSingleImageVersion2(openFileInputStream2, g)) {
                        z = true;
                    } else if (!u) {
                        arrayList3.add(openFileInputStream2);
                    } else if (1 == b(openFileInputStream2, g)) {
                        arrayList3.add(openFileInputStream2);
                    }
                }
                z = false;
            } catch (IOException e3) {
                ZLogger.w(e3.toString());
                throw new LoadFileException(e3.getMessage(), 4097);
            }
        }
        b3.lowVersionExist = z;
        b3.subBinInputStreams = arrayList2;
        b3.supportBinInputStreams = arrayList3;
        b3.supportSubFileInfos = arrayList;
        if (y && z && arrayList3.size() < 1) {
            b3.updateEnabled = false;
            b3.status = 4104;
        }
        return b3;
    }

    public static BinInfo d(LoadParams loadParams) throws LoadFileException {
        boolean z;
        SparseIntArray sparseIntArray;
        BinIndicator byBitNumber;
        Iterator<SubFileInfo> it;
        int i;
        int i2;
        boolean z2;
        ArrayList arrayList;
        SparseIntArray sparseIntArray2;
        com.realsil.sdk.dfu.e.a aVar;
        int i3;
        int activeCompareVersionFlag;
        int activeCompareVersionFlag2;
        int i4 = loadParams.i();
        loadParams.d();
        loadParams.e();
        int b = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean s = loadParams.s();
        boolean y = loadParams.y();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        BinInfo b2 = com.realsil.sdk.dfu.j.a.b(loadParams);
        b2.icType = i4;
        try {
            com.realsil.sdk.dfu.e.a c = com.realsil.sdk.dfu.d.b.c(loadParams);
            ZLogger.v(c.toString());
            b2.isPackFile = true;
            b2.icType = c.a();
            b2.subFileInfos = c.c(0);
            b2.subFileInfos1 = c.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(b2.icType, i4)) {
                ZLogger.d(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i4), Integer.valueOf(b2.icType)));
                b2.updateEnabled = false;
                b2.status = 4101;
                return b2;
            }
            if (!c.a(2, b2.updateBank)) {
                ZLogger.w("OtaHeader Miss");
                b2.updateEnabled = false;
                b2.status = 4115;
                return b2;
            }
            Iterator<SubFileInfo> it2 = c.c(loadParams.l()).iterator();
            int i5 = 0;
            int i6 = 0;
            while (it2.hasNext()) {
                SubFileInfo next = it2.next();
                int wrapperBitNumber = next.wrapperBitNumber();
                if (!BinIndicator.isIndicatorEnabled(b, wrapperBitNumber)) {
                    ZLogger.v("prohibit upgrade image_id=" + next.imageId);
                    it = it2;
                } else {
                    if (b2.icType == 11) {
                        byBitNumber = com.realsil.sdk.dfu.b.a.a(next.binId);
                    } else {
                        byBitNumber = BinIndicator.getByBitNumber(BinIndicator.BBPRO, wrapperBitNumber);
                    }
                    if (byBitNumber != null) {
                        it = it2;
                        ZLogger.v(com.realsil.sdk.dfu.j.a.b, byBitNumber.toString());
                        i = byBitNumber.versionFormat;
                    } else {
                        it = it2;
                        i = 1;
                    }
                    BaseBinInputStream binInputStream = next.getBinInputStream(b2.icType, loadParams.f());
                    if (binInputStream == null) {
                        ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "not find image: " + next.toString());
                        if (loadParams.q() && com.realsil.sdk.dfu.c.a.b(wrapperBitNumber)) {
                            sparseIntArray3.append(next.imageId, wrapperBitNumber);
                        }
                    } else {
                        if (g != null) {
                            ImageVersionInfo activeImageVersionInfoByImageId = g.getActiveImageVersionInfoByImageId(binInputStream.getImageId());
                            i2 = b;
                            if (activeImageVersionInfoByImageId != null) {
                                sparseIntArray2 = sparseIntArray3;
                                if (activeImageVersionInfoByImageId.getVersion() == -1) {
                                    ZLogger.v(String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(activeImageVersionInfoByImageId.getVersion())));
                                    binInputStream.setActiveCompareVersionFlag(1);
                                    z2 = y;
                                    arrayList = arrayList2;
                                    aVar = c;
                                } else {
                                    z2 = y;
                                    aVar = c;
                                    int compareVersion = com.realsil.sdk.dfu.j.a.compareVersion(b2.icType, binInputStream.getBinId(), binInputStream.getImageId(), binInputStream.imageVersion, binInputStream.otaVersion, g.protocolType, activeImageVersionInfoByImageId.getVersion(), g.specVersion, i, loadParams.r());
                                    arrayList = arrayList2;
                                    ZLogger.v(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(wrapperBitNumber), Integer.valueOf(compareVersion)));
                                    binInputStream.setActiveCompareVersionFlag(compareVersion);
                                }
                                i3 = 1;
                            } else {
                                z2 = y;
                                arrayList = arrayList2;
                                sparseIntArray2 = sparseIntArray3;
                                aVar = c;
                                ZLogger.d("not find active image, bitNumber=" + wrapperBitNumber);
                                i3 = 1;
                                binInputStream.setActiveCompareVersionFlag(1);
                            }
                            ImageVersionInfo inActiveImageVersionInfoByImageId = g.getInActiveImageVersionInfoByImageId(binInputStream.getImageId());
                            if (inActiveImageVersionInfoByImageId != null) {
                                if (inActiveImageVersionInfoByImageId.getVersion() == -1) {
                                    Integer valueOf = Integer.valueOf(inActiveImageVersionInfoByImageId.getVersion());
                                    Object[] objArr = new Object[i3];
                                    objArr[0] = valueOf;
                                    ZLogger.v(String.format("invalid inactive version:0x%04X, no need to check", objArr));
                                    binInputStream.setInactiveVersionCompFlag(i3);
                                } else {
                                    int compareVersion2 = com.realsil.sdk.dfu.j.a.compareVersion(b2.icType, binInputStream.getBinId(), binInputStream.getImageId(), binInputStream.imageVersion, binInputStream.otaVersion, g.protocolType, inActiveImageVersionInfoByImageId.getVersion(), g.specVersion, i, loadParams.r());
                                    ZLogger.v(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(wrapperBitNumber), Integer.valueOf(compareVersion2)));
                                    binInputStream.setInactiveVersionCompFlag(compareVersion2);
                                }
                            } else {
                                ZLogger.d("not find inactive image, bitNumber=" + wrapperBitNumber);
                                binInputStream.setInactiveVersionCompFlag(1);
                            }
                            if (com.realsil.sdk.dfu.c.a.a(wrapperBitNumber)) {
                                if (i5 > 0) {
                                    if (binInputStream.getActiveCompareVersionFlag() < 0) {
                                        activeCompareVersionFlag2 = binInputStream.getActiveCompareVersionFlag();
                                        i5 = activeCompareVersionFlag2;
                                    }
                                } else if (i5 == 0) {
                                    activeCompareVersionFlag2 = binInputStream.getActiveCompareVersionFlag();
                                    i5 = activeCompareVersionFlag2;
                                }
                            } else if (i6 > 0) {
                                if (binInputStream.getActiveCompareVersionFlag() < 0) {
                                    activeCompareVersionFlag = binInputStream.getActiveCompareVersionFlag();
                                    i6 = activeCompareVersionFlag;
                                }
                            } else if (i6 == 0) {
                                activeCompareVersionFlag = binInputStream.getActiveCompareVersionFlag();
                                i6 = activeCompareVersionFlag;
                            }
                        } else {
                            i2 = b;
                            z2 = y;
                            arrayList = arrayList2;
                            sparseIntArray2 = sparseIntArray3;
                            aVar = c;
                        }
                        arrayList3.add(binInputStream);
                        arrayList4.add(binInputStream);
                        ArrayList arrayList5 = arrayList;
                        arrayList5.add(next);
                        arrayList2 = arrayList5;
                        it2 = it;
                        b = i2;
                        sparseIntArray3 = sparseIntArray2;
                        y = z2;
                        c = aVar;
                    }
                }
                it2 = it;
            }
            boolean z3 = y;
            ArrayList arrayList6 = arrayList2;
            SparseIntArray sparseIntArray4 = sparseIntArray3;
            try {
                c.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            if (z3) {
                if (i5 > 0) {
                    sparseIntArray = sparseIntArray4;
                    z = false;
                    b2.forceCopyImages = sparseIntArray;
                    b2.lowVersionExist = z;
                    b2.subBinInputStreams = arrayList3;
                    b2.supportBinInputStreams = arrayList4;
                    b2.supportSubFileInfos = arrayList6;
                    return b2;
                }
                if (i5 == 0) {
                    if (i6 <= 0) {
                        ZLogger.d("there must be at least one data image version> active image version");
                        b2.updateEnabled = false;
                        b2.status = 4113;
                        return b2;
                    }
                } else {
                    ZLogger.d("all code image version must >= active image version");
                    b2.updateEnabled = false;
                    b2.status = 4114;
                    return b2;
                }
            }
            z = false;
            sparseIntArray = sparseIntArray4;
            b2.forceCopyImages = sparseIntArray;
            b2.lowVersionExist = z;
            b2.subBinInputStreams = arrayList3;
            b2.supportBinInputStreams = arrayList4;
            b2.supportSubFileInfos = arrayList6;
            return b2;
        } catch (LoadFileException e2) {
            b2.updateEnabled = false;
            b2.status = e2.getErrCode();
            return b2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.realsil.sdk.dfu.model.BinInfo e(com.realsil.sdk.dfu.image.LoadParams r33) throws com.realsil.sdk.dfu.exception.LoadFileException {
        /*
            Method dump skipped, instructions count: 862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.h.e(com.realsil.sdk.dfu.image.LoadParams):com.realsil.sdk.dfu.model.BinInfo");
    }
}
