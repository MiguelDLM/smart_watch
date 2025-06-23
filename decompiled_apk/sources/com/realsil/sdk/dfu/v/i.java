package com.realsil.sdk.dfu.v;

import android.content.Context;
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
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public class i extends com.realsil.sdk.dfu.j.a {

    /* loaded from: classes11.dex */
    public class a implements Comparator<BaseBinInputStream> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BaseBinInputStream baseBinInputStream, BaseBinInputStream baseBinInputStream2) {
            return baseBinInputStream.versionCheckOrder - baseBinInputStream2.versionCheckOrder;
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Comparator<BaseBinInputStream> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BaseBinInputStream baseBinInputStream, BaseBinInputStream baseBinInputStream2) {
            return baseBinInputStream.versionCheckOrder - baseBinInputStream2.versionCheckOrder;
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Comparator<BaseBinInputStream> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BaseBinInputStream baseBinInputStream, BaseBinInputStream baseBinInputStream2) {
            return baseBinInputStream.versionCheckOrder - baseBinInputStream2.versionCheckOrder;
        }
    }

    public static int b(BaseBinInputStream baseBinInputStream, OtaDeviceInfo otaDeviceInfo) {
        if (otaDeviceInfo == null) {
            return 1;
        }
        BinIndicator indByBinId = BinIndicator.getIndByBinId(otaDeviceInfo.icType, baseBinInputStream.getBinId());
        if (indByBinId != null && indByBinId.versionCheckEnabled) {
            ZLogger.v(indByBinId.toString());
            if (!com.realsil.sdk.dfu.j.a.a(baseBinInputStream, otaDeviceInfo.getActiveImageVersionInfoByImageId(indByBinId.imageId))) {
                return 2;
            }
        }
        return 1;
    }

    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        int i;
        boolean z;
        BaseBinInputStream baseBinInputStream;
        Context a2 = loadParams.a();
        int i2 = loadParams.i();
        String d = loadParams.d();
        int b2 = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        BinInfo a3 = com.realsil.sdk.dfu.j.a.a(loadParams);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ZLogger.v(String.format(Locale.US, "fileIndicator=0x%08X, versionCheckEnabled=%b", Integer.valueOf(b2), Boolean.valueOf(y)));
        com.realsil.sdk.dfu.e.a b3 = com.realsil.sdk.dfu.d.b.b(loadParams);
        if (b3 != null) {
            a3.isPackFile = true;
            a3.icType = b3.a();
            a3.subFileInfos = b3.c(0);
            a3.subFileInfos1 = b3.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(a3.icType, i2)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(a3.icType)));
                a3.updateEnabled = false;
                a3.status = 4101;
                return a3;
            }
            boolean z2 = false;
            for (int i3 = 0; i3 < 16; i3++) {
                int wrapperBitNumber = com.realsil.sdk.dfu.j.a.wrapperBitNumber(i3, g.imageVersionIndicator, g.updateBankIndicator);
                if (wrapperBitNumber < 16) {
                    a3.bankIndicator |= 1;
                } else {
                    a3.bankIndicator |= 2;
                }
                if (!BinIndicator.isIndicatorEnabled(b2, wrapperBitNumber)) {
                    ZLogger.v("image file disable: bitNumber=" + wrapperBitNumber);
                } else {
                    SubFileInfo b4 = b3.b(wrapperBitNumber);
                    if (b4 != null) {
                        baseBinInputStream = b4.getAssetsBinInputStream(a2, a3.icType, loadParams.f());
                    } else {
                        baseBinInputStream = null;
                    }
                    if (baseBinInputStream != null) {
                        arrayList2.add(baseBinInputStream);
                        if (y) {
                            if (1 == com.realsil.sdk.dfu.j.a.checkPackImageVersion(wrapperBitNumber, baseBinInputStream, g)) {
                                arrayList3.add(baseBinInputStream);
                                arrayList.add(b4);
                            } else {
                                z2 = true;
                            }
                        } else {
                            arrayList3.add(baseBinInputStream);
                            arrayList.add(b4);
                        }
                    }
                }
            }
            try {
                b3.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            z = z2;
            i = 1;
        } else {
            try {
                i = 1;
                BaseBinInputStream openAssetsInputStream = com.realsil.sdk.dfu.j.a.openAssetsInputStream(a2, i2, d, 0L, loadParams.f());
                if (openAssetsInputStream != null) {
                    arrayList2.add(openAssetsInputStream);
                    a3.icType = openAssetsInputStream.getIcType();
                    a3.version = openAssetsInputStream.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(a3.icType, i2)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(a3.icType)));
                        a3.updateEnabled = false;
                        a3.status = 4101;
                        return a3;
                    }
                    if (y) {
                        if (1 == com.realsil.sdk.dfu.j.a.checkSingleImageVersion2(openAssetsInputStream, g)) {
                            arrayList3.add(openAssetsInputStream);
                        } else {
                            z = true;
                        }
                    } else {
                        arrayList3.add(openAssetsInputStream);
                    }
                }
                z = false;
            } catch (IOException e2) {
                ZLogger.w(e2.toString());
                throw new LoadFileException(e2.getMessage(), 4097);
            }
        }
        a3.lowVersionExist = z;
        a3.subBinInputStreams = arrayList2;
        a3.supportBinInputStreams = arrayList3;
        a3.supportSubFileInfos = arrayList;
        if (y && z && arrayList3.size() < i) {
            a3.updateEnabled = false;
            a3.status = 4104;
        }
        return a3;
    }

    public static BinInfo d(LoadParams loadParams) throws LoadFileException {
        boolean z;
        int i;
        Iterator<SubFileInfo> it;
        Context context;
        int i2;
        boolean z2;
        com.realsil.sdk.dfu.e.a aVar;
        int i3;
        int activeCompareVersionFlag;
        int activeCompareVersionFlag2;
        Context a2 = loadParams.a();
        int i4 = loadParams.i();
        int b2 = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean s = loadParams.s();
        boolean y = loadParams.y();
        loadParams.l();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        BinInfo a3 = com.realsil.sdk.dfu.j.a.a(loadParams);
        try {
            com.realsil.sdk.dfu.e.a b3 = com.realsil.sdk.dfu.d.b.b(loadParams);
            ZLogger.v(b3.toString());
            a3.isPackFile = true;
            a3.icType = b3.a();
            a3.subFileInfos = b3.c(0);
            a3.subFileInfos1 = b3.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(a3.icType, i4)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i4), Integer.valueOf(a3.icType)));
                a3.updateEnabled = false;
                a3.status = 4101;
                return a3;
            }
            List<SubFileInfo> c2 = b3.c(a3.updateBank);
            if (!b3.a(2, a3.updateBank)) {
                ZLogger.w("OtaHeader Miss");
                if (loadParams.w() && c2.size() == 1 && b3.a(520) != null) {
                    y = false;
                } else {
                    a3.updateEnabled = false;
                    a3.status = 4115;
                    return a3;
                }
            }
            Iterator<SubFileInfo> it2 = c2.iterator();
            int i5 = 0;
            int i6 = 0;
            while (it2.hasNext()) {
                SubFileInfo next = it2.next();
                if (!BinIndicator.isIndicatorEnabled(b2, next.wrapperBitNumber())) {
                    ZLogger.v("prohibit upgrade image_id=" + next.imageId);
                    it = it2;
                } else {
                    BinIndicator indByBinId = BinIndicator.getIndByBinId(a3.icType, next.binId);
                    if (indByBinId != null) {
                        ZLogger.v(com.realsil.sdk.dfu.j.a.b, indByBinId.toString());
                        i = indByBinId.versionFormat;
                    } else {
                        i = 1;
                    }
                    it = it2;
                    BaseBinInputStream assetsBinInputStream = next.getAssetsBinInputStream(a2, a3.icType, loadParams.f());
                    if (assetsBinInputStream == null) {
                        ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "not find image: " + indByBinId.imageId);
                    } else {
                        if (g != null) {
                            ImageVersionInfo activeImageVersionInfoByImageId = g.getActiveImageVersionInfoByImageId(assetsBinInputStream.getImageId());
                            if (activeImageVersionInfoByImageId != null) {
                                context = a2;
                                if (activeImageVersionInfoByImageId.getVersion() == -1) {
                                    i2 = b2;
                                    i3 = 1;
                                    ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(activeImageVersionInfoByImageId.getVersion())));
                                    assetsBinInputStream.setActiveCompareVersionFlag(1);
                                    z2 = y;
                                    aVar = b3;
                                } else {
                                    i2 = b2;
                                    z2 = y;
                                    int compareVersion = com.realsil.sdk.dfu.j.a.compareVersion(a3.icType, assetsBinInputStream.getBinId(), assetsBinInputStream.getImageId(), assetsBinInputStream.imageVersion, assetsBinInputStream.otaVersion, g.protocolType, activeImageVersionInfoByImageId.getVersion(), g.specVersion, i, loadParams.r());
                                    aVar = b3;
                                    i3 = 1;
                                    ZLogger.v(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.bitNumber), Integer.valueOf(compareVersion)));
                                    assetsBinInputStream.setActiveCompareVersionFlag(compareVersion);
                                }
                            } else {
                                context = a2;
                                i2 = b2;
                                z2 = y;
                                aVar = b3;
                                i3 = 1;
                                ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(assetsBinInputStream.getImageId())));
                                assetsBinInputStream.setActiveCompareVersionFlag(1);
                            }
                            ImageVersionInfo inActiveImageVersionInfoByImageId = g.getInActiveImageVersionInfoByImageId(assetsBinInputStream.getImageId());
                            if (inActiveImageVersionInfoByImageId != null) {
                                if (inActiveImageVersionInfoByImageId.getVersion() == -1) {
                                    boolean z3 = com.realsil.sdk.dfu.j.a.f19549a;
                                    Object[] objArr = new Object[i3];
                                    objArr[0] = Integer.valueOf(inActiveImageVersionInfoByImageId.getVersion());
                                    ZLogger.v(z3, String.format("invalid inactive version:0x%04X, no need to check", objArr));
                                    assetsBinInputStream.setInactiveVersionCompFlag(i3);
                                } else {
                                    int compareVersion2 = com.realsil.sdk.dfu.j.a.compareVersion(a3.icType, assetsBinInputStream.getBinId(), assetsBinInputStream.getImageId(), assetsBinInputStream.imageVersion, assetsBinInputStream.otaVersion, g.protocolType, inActiveImageVersionInfoByImageId.getVersion(), g.specVersion, i, g.isBankEnabled());
                                    ZLogger.v(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.bitNumber), Integer.valueOf(compareVersion2)));
                                    assetsBinInputStream.setInactiveVersionCompFlag(compareVersion2);
                                }
                            } else {
                                ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("not find inactive image, imageId=0x%04X", Integer.valueOf(assetsBinInputStream.getImageId())));
                                assetsBinInputStream.setInactiveVersionCompFlag(1);
                            }
                            if (com.realsil.sdk.dfu.c.a.a(next.wrapperBitNumber())) {
                                if (i5 > 0) {
                                    if (assetsBinInputStream.getActiveCompareVersionFlag() < 0) {
                                        activeCompareVersionFlag2 = assetsBinInputStream.getActiveCompareVersionFlag();
                                        i5 = activeCompareVersionFlag2;
                                    }
                                } else if (i5 == 0) {
                                    activeCompareVersionFlag2 = assetsBinInputStream.getActiveCompareVersionFlag();
                                    i5 = activeCompareVersionFlag2;
                                }
                            } else if (i6 > 0) {
                                if (assetsBinInputStream.getActiveCompareVersionFlag() < 0) {
                                    activeCompareVersionFlag = assetsBinInputStream.getActiveCompareVersionFlag();
                                    i6 = activeCompareVersionFlag;
                                }
                            } else if (i6 == 0) {
                                activeCompareVersionFlag = assetsBinInputStream.getActiveCompareVersionFlag();
                                i6 = activeCompareVersionFlag;
                            }
                        } else {
                            context = a2;
                            i2 = b2;
                            z2 = y;
                            aVar = b3;
                        }
                        arrayList2.add(assetsBinInputStream);
                        arrayList3.add(assetsBinInputStream);
                        arrayList.add(next);
                        it2 = it;
                        a2 = context;
                        b2 = i2;
                        y = z2;
                        b3 = aVar;
                    }
                }
                it2 = it;
            }
            boolean z4 = y;
            try {
                b3.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            if (z4) {
                z = false;
                ZLogger.v(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i5), Integer.valueOf(i6)));
                if (i5 <= 0) {
                    if (i5 == 0) {
                        if (i6 <= 0) {
                            ZLogger.d("there must be at least one data image version> active image version");
                            a3.updateEnabled = false;
                            a3.status = 4113;
                            return a3;
                        }
                    } else {
                        ZLogger.w("all code image version must >= active image version");
                        a3.updateEnabled = false;
                        a3.status = 4114;
                        return a3;
                    }
                }
            } else {
                z = false;
            }
            a3.lowVersionExist = z;
            a3.subBinInputStreams = arrayList2;
            a3.supportBinInputStreams = arrayList3;
            a3.supportSubFileInfos = arrayList;
            return a3;
        } catch (LoadFileException e2) {
            a3.updateEnabled = false;
            a3.status = e2.getErrCode();
            return a3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0351, code lost:
    
        r8.updateEnabled = r4;
        r8.status = 4114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0355, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.realsil.sdk.dfu.model.BinInfo e(com.realsil.sdk.dfu.image.LoadParams r33) throws com.realsil.sdk.dfu.exception.LoadFileException {
        /*
            Method dump skipped, instructions count: 875
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.i.e(com.realsil.sdk.dfu.image.LoadParams):com.realsil.sdk.dfu.model.BinInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0350, code lost:
    
        r11.updateEnabled = r4;
        r11.status = 4114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0354, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.realsil.sdk.dfu.model.BinInfo f(com.realsil.sdk.dfu.image.LoadParams r31) throws com.realsil.sdk.dfu.exception.LoadFileException {
        /*
            Method dump skipped, instructions count: 874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.i.f(com.realsil.sdk.dfu.image.LoadParams):com.realsil.sdk.dfu.model.BinInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x03be, code lost:
    
        r3 = 65535;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.realsil.sdk.dfu.model.BinInfo g(com.realsil.sdk.dfu.image.LoadParams r33) throws com.realsil.sdk.dfu.exception.LoadFileException {
        /*
            Method dump skipped, instructions count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.v.i.g(com.realsil.sdk.dfu.image.LoadParams):com.realsil.sdk.dfu.model.BinInfo");
    }

    public static BinInfo h(LoadParams loadParams) throws LoadFileException {
        boolean z;
        int i;
        Iterator<SubFileInfo> it;
        int i2;
        boolean z2;
        SparseIntArray sparseIntArray;
        com.realsil.sdk.dfu.e.a aVar;
        int i3;
        int activeCompareVersionFlag;
        int activeCompareVersionFlag2;
        int i4 = loadParams.i();
        int b2 = loadParams.b();
        boolean s = loadParams.s();
        boolean y = loadParams.y();
        int l = loadParams.l();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        BinInfo b3 = com.realsil.sdk.dfu.j.a.b(loadParams);
        try {
            com.realsil.sdk.dfu.e.a c2 = com.realsil.sdk.dfu.d.b.c(loadParams);
            b3.isPackFile = true;
            b3.icType = c2.a();
            b3.subFileInfos = c2.c(0);
            b3.subFileInfos1 = c2.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i4)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i4), Integer.valueOf(b3.icType)));
                b3.updateEnabled = false;
                b3.status = 4101;
                return b3;
            }
            if (!c2.a(2, b3.updateBank)) {
                ZLogger.w("OtaHeader Miss");
                b3.updateEnabled = false;
                b3.status = 4115;
                return b3;
            }
            Iterator<SubFileInfo> it2 = c2.c(l).iterator();
            int i5 = 0;
            int i6 = 0;
            while (it2.hasNext()) {
                SubFileInfo next = it2.next();
                if (!BinIndicator.isIndicatorEnabled(b2, next.wrapperBitNumber())) {
                    ZLogger.v("prohibit upgrade image_id=" + next.imageId);
                } else {
                    BinIndicator indByBinId = BinIndicator.getIndByBinId(b3.icType, next.binId);
                    if (indByBinId != null) {
                        ZLogger.v(com.realsil.sdk.dfu.j.a.b, indByBinId.toString());
                        i = indByBinId.versionFormat;
                    } else {
                        i = 1;
                    }
                    BaseBinInputStream binInputStream = next.getBinInputStream(b3.icType, loadParams.f());
                    if (binInputStream == null) {
                        ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "not find image: " + next.imageId);
                        if (loadParams.q() && com.realsil.sdk.dfu.c.a.b(next.wrapperBitNumber())) {
                            sparseIntArray2.append(next.imageId, next.wrapperBitNumber());
                        }
                    } else {
                        OtaDeviceInfo g = loadParams.g();
                        if (g != null) {
                            ImageVersionInfo activeImageVersionInfoByImageId = g.getActiveImageVersionInfoByImageId(binInputStream.getImageId());
                            it = it2;
                            if (activeImageVersionInfoByImageId != null) {
                                i2 = b2;
                                if (activeImageVersionInfoByImageId.getVersion() == -1) {
                                    sparseIntArray = sparseIntArray2;
                                    ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(activeImageVersionInfoByImageId.getVersion())));
                                    binInputStream.setActiveCompareVersionFlag(1);
                                    z2 = y;
                                    aVar = c2;
                                    i3 = 1;
                                } else {
                                    sparseIntArray = sparseIntArray2;
                                    z2 = y;
                                    int compareVersion = com.realsil.sdk.dfu.j.a.compareVersion(b3.icType, binInputStream.getBinId(), binInputStream.getImageId(), binInputStream.imageVersion, binInputStream.otaVersion, g.protocolType, activeImageVersionInfoByImageId.getVersion(), g.specVersion, i, loadParams.r());
                                    aVar = c2;
                                    i3 = 1;
                                    ZLogger.v(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.bitNumber), Integer.valueOf(compareVersion)));
                                    binInputStream.setActiveCompareVersionFlag(compareVersion);
                                }
                            } else {
                                i2 = b2;
                                z2 = y;
                                sparseIntArray = sparseIntArray2;
                                aVar = c2;
                                i3 = 1;
                                ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(binInputStream.getImageId())));
                                binInputStream.setActiveCompareVersionFlag(1);
                            }
                            ImageVersionInfo inActiveImageVersionInfoByImageId = g.getInActiveImageVersionInfoByImageId(binInputStream.getImageId());
                            if (inActiveImageVersionInfoByImageId != null) {
                                if (inActiveImageVersionInfoByImageId.getVersion() == -1) {
                                    boolean z3 = com.realsil.sdk.dfu.j.a.f19549a;
                                    Object[] objArr = new Object[i3];
                                    objArr[0] = Integer.valueOf(inActiveImageVersionInfoByImageId.getVersion());
                                    ZLogger.v(z3, String.format("invalid inactive version:0x%04X, no need to check", objArr));
                                    binInputStream.setInactiveVersionCompFlag(i3);
                                } else {
                                    int compareVersion2 = com.realsil.sdk.dfu.j.a.compareVersion(b3.icType, binInputStream.getBinId(), binInputStream.getImageId(), binInputStream.imageVersion, binInputStream.otaVersion, g.protocolType, inActiveImageVersionInfoByImageId.getVersion(), g.specVersion, i, loadParams.r());
                                    ZLogger.v(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.bitNumber), Integer.valueOf(compareVersion2)));
                                    binInputStream.setInactiveVersionCompFlag(compareVersion2);
                                }
                            } else {
                                ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("not find inactive image, imageId=0x%04X", Integer.valueOf(binInputStream.getImageId())));
                                binInputStream.setInactiveVersionCompFlag(1);
                            }
                            if (com.realsil.sdk.dfu.c.a.a(next.wrapperBitNumber())) {
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
                            it = it2;
                            i2 = b2;
                            z2 = y;
                            sparseIntArray = sparseIntArray2;
                            aVar = c2;
                        }
                        arrayList2.add(binInputStream);
                        arrayList3.add(binInputStream);
                        arrayList.add(next);
                        it2 = it;
                        b2 = i2;
                        sparseIntArray2 = sparseIntArray;
                        y = z2;
                        c2 = aVar;
                    }
                }
            }
            boolean z4 = y;
            SparseIntArray sparseIntArray3 = sparseIntArray2;
            try {
                c2.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            if (z4) {
                z = false;
                ZLogger.v(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i5), Integer.valueOf(i6)));
                if (i5 <= 0) {
                    if (i5 == 0) {
                        if (i6 <= 0) {
                            ZLogger.d("there must be at least one data image version> active image version");
                            b3.updateEnabled = false;
                            b3.status = 4113;
                            return b3;
                        }
                    } else {
                        ZLogger.w("all code image version must >= active image version");
                        b3.updateEnabled = false;
                        b3.status = 4114;
                        return b3;
                    }
                }
            } else {
                z = false;
            }
            b3.forceCopyImages = sparseIntArray3;
            b3.lowVersionExist = z;
            b3.subBinInputStreams = arrayList2;
            b3.supportBinInputStreams = arrayList3;
            b3.supportSubFileInfos = arrayList;
            return b3;
        } catch (LoadFileException e2) {
            b3.updateEnabled = false;
            b3.status = e2.getErrCode();
            return b3;
        }
    }

    public static BinInfo i(LoadParams loadParams) throws LoadFileException {
        BaseBinInputStream openFileInputStream;
        boolean z;
        int i;
        Iterator<SubFileInfo> it;
        int i2;
        boolean z2;
        com.realsil.sdk.dfu.e.a aVar;
        int i3;
        int activeCompareVersionFlag;
        int activeCompareVersionFlag2;
        int i4 = loadParams.i();
        String d = loadParams.d();
        int b2 = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        int l = loadParams.l();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        BinInfo b3 = com.realsil.sdk.dfu.j.a.b(loadParams);
        try {
            com.realsil.sdk.dfu.e.a c2 = com.realsil.sdk.dfu.d.b.c(loadParams);
            if (c2 == null) {
                try {
                    openFileInputStream = com.realsil.sdk.dfu.j.a.openFileInputStream(i4, d, 0L, loadParams.f());
                } catch (IOException e) {
                    ZLogger.v(e.toString());
                }
                if (openFileInputStream != null) {
                    arrayList2.add(openFileInputStream);
                    b3.icType = openFileInputStream.getIcType();
                    b3.version = openFileInputStream.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i4)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i4), Integer.valueOf(b3.icType)));
                        b3.updateEnabled = false;
                        b3.status = 4101;
                        return b3;
                    }
                    if (y && 1 != com.realsil.sdk.dfu.j.a.checkSingleImageVersion2(openFileInputStream, g)) {
                        z = true;
                        b3.lowVersionExist = z;
                        b3.subBinInputStreams = arrayList2;
                        b3.supportBinInputStreams = arrayList3;
                        b3.supportSubFileInfos = arrayList;
                        return b3;
                    }
                    arrayList3.add(openFileInputStream);
                }
            } else {
                ZLogger.v(c2.toString());
                b3.isPackFile = true;
                b3.icType = c2.a();
                b3.subFileInfos = c2.c(0);
                b3.subFileInfos1 = c2.c(1);
                if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i4)) {
                    ZLogger.d(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i4), Integer.valueOf(b3.icType)));
                    b3.updateEnabled = false;
                    b3.status = 4101;
                    return b3;
                }
                Iterator<SubFileInfo> it2 = c2.c(l).iterator();
                int i5 = 0;
                int i6 = 0;
                while (it2.hasNext()) {
                    SubFileInfo next = it2.next();
                    if (!BinIndicator.isIndicatorEnabled(b2, next.wrapperBitNumber())) {
                        ZLogger.v("prohibit upgrade image_id=" + next.imageId);
                    } else {
                        BinIndicator indByBinId = BinIndicator.getIndByBinId(b3.icType, next.binId);
                        if (indByBinId != null) {
                            ZLogger.v(com.realsil.sdk.dfu.j.a.b, indByBinId.toString());
                            i = indByBinId.versionFormat;
                        } else {
                            i = 1;
                        }
                        BaseBinInputStream binInputStream = next.getBinInputStream(b3.icType, loadParams.f());
                        if (binInputStream == null) {
                            ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "not find image: " + indByBinId.imageId);
                        } else {
                            if (g != null) {
                                ImageVersionInfo activeImageVersionInfoByImageId = g.getActiveImageVersionInfoByImageId(binInputStream.getImageId());
                                if (activeImageVersionInfoByImageId != null) {
                                    it = it2;
                                    if (activeImageVersionInfoByImageId.getVersion() == -1) {
                                        i2 = b2;
                                        ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(activeImageVersionInfoByImageId.getVersion())));
                                        binInputStream.setActiveCompareVersionFlag(1);
                                        z2 = y;
                                        aVar = c2;
                                        i3 = 1;
                                    } else {
                                        i2 = b2;
                                        z2 = y;
                                        int compareVersion = com.realsil.sdk.dfu.j.a.compareVersion(b3.icType, binInputStream.getBinId(), binInputStream.getImageId(), binInputStream.imageVersion, binInputStream.otaVersion, g.protocolType, activeImageVersionInfoByImageId.getVersion(), g.specVersion, i, loadParams.r());
                                        aVar = c2;
                                        i3 = 1;
                                        ZLogger.v(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.bitNumber), Integer.valueOf(compareVersion)));
                                        binInputStream.setActiveCompareVersionFlag(compareVersion);
                                    }
                                } else {
                                    it = it2;
                                    i2 = b2;
                                    z2 = y;
                                    aVar = c2;
                                    i3 = 1;
                                    ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(binInputStream.getImageId())));
                                    binInputStream.setActiveCompareVersionFlag(1);
                                }
                                ImageVersionInfo inActiveImageVersionInfoByImageId = g.getInActiveImageVersionInfoByImageId(binInputStream.getImageId());
                                if (inActiveImageVersionInfoByImageId != null) {
                                    if (inActiveImageVersionInfoByImageId.getVersion() == -1) {
                                        boolean z3 = com.realsil.sdk.dfu.j.a.f19549a;
                                        Object[] objArr = new Object[i3];
                                        objArr[0] = Integer.valueOf(inActiveImageVersionInfoByImageId.getVersion());
                                        ZLogger.v(z3, String.format("invalid inactive version:0x%04X, no need to check", objArr));
                                        binInputStream.setInactiveVersionCompFlag(i3);
                                    } else {
                                        int compareVersion2 = com.realsil.sdk.dfu.j.a.compareVersion(b3.icType, binInputStream.getBinId(), binInputStream.getImageId(), binInputStream.imageVersion, binInputStream.otaVersion, g.protocolType, inActiveImageVersionInfoByImageId.getVersion(), g.specVersion, i, loadParams.r());
                                        ZLogger.v(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.bitNumber), Integer.valueOf(compareVersion2)));
                                        binInputStream.setInactiveVersionCompFlag(compareVersion2);
                                    }
                                } else {
                                    boolean z4 = com.realsil.sdk.dfu.j.a.f19549a;
                                    Object[] objArr2 = new Object[i3];
                                    objArr2[0] = Integer.valueOf(binInputStream.getImageId());
                                    ZLogger.v(z4, String.format("not find inactive image, imageId=0x%04X", objArr2));
                                    binInputStream.setInactiveVersionCompFlag(i3);
                                }
                                if (com.realsil.sdk.dfu.c.a.a(next.wrapperBitNumber())) {
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
                                it = it2;
                                i2 = b2;
                                z2 = y;
                                aVar = c2;
                            }
                            arrayList2.add(binInputStream);
                            if (next.wrapperBitNumber() == 2) {
                                ZLogger.v("ignore OTA_HEADER_FILE");
                            } else if (next.wrapperBitNumber() == 1) {
                                ZLogger.v("ignore SYSTEM_CONFIG_FILE");
                            } else {
                                arrayList3.add(binInputStream);
                                arrayList.add(next);
                            }
                            it2 = it;
                            b2 = i2;
                            y = z2;
                            c2 = aVar;
                        }
                    }
                }
                boolean z5 = y;
                try {
                    c2.close();
                } catch (IOException e2) {
                    ZLogger.w(e2.toString());
                }
                if (z5) {
                    ZLogger.v(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i5), Integer.valueOf(i6)));
                    if (i5 <= 0) {
                        if (i5 == 0) {
                            if (i6 <= 0) {
                                ZLogger.d("there must be at least one data image version> active image version");
                                b3.updateEnabled = false;
                                b3.status = 4113;
                                return b3;
                            }
                        } else {
                            ZLogger.w("all code image version must >= active image version");
                            b3.updateEnabled = false;
                            b3.status = 4114;
                            return b3;
                        }
                    }
                }
            }
            z = false;
            b3.lowVersionExist = z;
            b3.subBinInputStreams = arrayList2;
            b3.supportBinInputStreams = arrayList3;
            b3.supportSubFileInfos = arrayList;
            return b3;
        } catch (LoadFileException e3) {
            b3.updateEnabled = false;
            b3.status = e3.getErrCode();
            return b3;
        }
    }

    public static BinInfo loadImageBinInfo(LoadParams loadParams) throws LoadFileException {
        byte[] bArr;
        boolean z;
        int i;
        int i2 = loadParams.i();
        String d = loadParams.d();
        int b2 = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        boolean u = loadParams.u();
        int l = loadParams.l();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        BinInfo b3 = com.realsil.sdk.dfu.j.a.b(loadParams);
        try {
            com.realsil.sdk.dfu.e.a c2 = com.realsil.sdk.dfu.d.b.c(loadParams);
            if (c2 != null) {
                b3.isPackFile = true;
                b3.icType = c2.a();
                b3.subFileInfos = c2.c(0);
                b3.subFileInfos1 = c2.c(1);
                if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i2)) {
                    ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(b3.icType)));
                    b3.updateEnabled = false;
                    b3.status = 4101;
                    return b3;
                }
                SubFileInfo b4 = c2.b();
                if (b4 != null) {
                    BaseBinInputStream binInputStream = b4.getBinInputStream(b3.icType, loadParams.f());
                    if (u && binInputStream != null) {
                        if (1 != com.realsil.sdk.dfu.j.a.a(binInputStream, binInputStream.getImageId(), g)) {
                            ZLogger.w("ota header section size check failed: ");
                            b3.updateEnabled = false;
                            b3.status = 4109;
                            return b3;
                        }
                        ZLogger.d("preVerify OTA_HEADER_FILE ok, no need to check section size");
                        u = false;
                    }
                }
                z = false;
                for (SubFileInfo subFileInfo : c2.c(l)) {
                    if (!BinIndicator.isIndicatorEnabled(b2, subFileInfo.wrapperBitNumber())) {
                        ZLogger.v("prohibit upgrade image_id=" + subFileInfo.imageId);
                    } else {
                        BinIndicator indByBinId = BinIndicator.getIndByBinId(b3.icType, subFileInfo.binId);
                        if (indByBinId != null) {
                            ZLogger.v(com.realsil.sdk.dfu.j.a.b, indByBinId.toString());
                            i = indByBinId.versionFormat;
                        } else {
                            i = 1;
                        }
                        BaseBinInputStream binInputStream2 = subFileInfo.getBinInputStream(b3.icType, loadParams.f());
                        if (binInputStream2 == null) {
                            ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "not find image: " + subFileInfo.imageId);
                        } else if (y && 1 != com.realsil.sdk.dfu.j.a.a(binInputStream2, g, i)) {
                            z = true;
                        } else if (!u || 1 == com.realsil.sdk.dfu.j.a.a(binInputStream2, binInputStream2.getImageId(), g)) {
                            arrayList2.add(binInputStream2);
                            arrayList3.add(binInputStream2);
                            arrayList.add(subFileInfo);
                        }
                    }
                }
                try {
                    c2.close();
                } catch (IOException e) {
                    ZLogger.w(e.toString());
                }
            } else {
                b3.icType = i2;
                try {
                    BaseBinInputStream openFileInputStream = com.realsil.sdk.dfu.j.a.openFileInputStream(i2, d, 0L, loadParams.f());
                    if (openFileInputStream != null) {
                        openFileInputStream.parseImageHeaderEx();
                        bArr = openFileInputStream.getSha256();
                        try {
                            openFileInputStream.close();
                        } catch (Exception e2) {
                            ZLogger.w(e2.toString());
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
                            ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(b3.icType)));
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
                        } else {
                            b3.updateEnabled = false;
                            b3.status = 4109;
                            return b3;
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
        } catch (LoadFileException e4) {
            b3.updateEnabled = false;
            b3.status = e4.getErrCode();
            return b3;
        }
    }
}
