package com.realsil.sdk.dfu.r;

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
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public class e extends com.realsil.sdk.dfu.j.a {
    public static boolean a(int i) {
        return i == 4 || i == 6 || i == 7 || i == 8;
    }

    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        boolean z;
        BaseBinInputStream baseBinInputStream;
        int i = 2;
        int b = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        int i2 = loadParams.i();
        BinInfo a2 = com.realsil.sdk.dfu.j.a.a(loadParams);
        a2.icType = i2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        com.realsil.sdk.dfu.e.a b2 = com.realsil.sdk.dfu.d.b.b(loadParams);
        if (b2 != null) {
            a2.isPackFile = true;
            a2.icType = b2.a();
            a2.subFileInfos = b2.c(0);
            a2.subFileInfos1 = b2.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(a2.icType, i2)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(a2.icType)));
                a2.updateEnabled = false;
                a2.status = 4101;
                return a2;
            }
            int i3 = 0;
            z = false;
            while (i3 < 16) {
                int wrapperBitNumber = com.realsil.sdk.dfu.j.a.wrapperBitNumber(i3, g.imageVersionIndicator, g.updateBankIndicator);
                if (wrapperBitNumber < 16) {
                    a2.bankIndicator |= 1;
                } else {
                    a2.bankIndicator |= i;
                }
                if (!BinIndicator.isIndicatorEnabled(b, wrapperBitNumber)) {
                    ZLogger.v("image file disable: bitNumber=" + wrapperBitNumber);
                } else {
                    SubFileInfo b3 = b2.b(wrapperBitNumber);
                    if (b3 != null) {
                        baseBinInputStream = b3.getAssetsBinInputStream(loadParams.a(), a2.icType, loadParams.f());
                    } else {
                        baseBinInputStream = null;
                    }
                    if (baseBinInputStream != null) {
                        arrayList2.add(baseBinInputStream);
                        if (y) {
                            if (1 == com.realsil.sdk.dfu.j.a.checkPackImageVersion(wrapperBitNumber, baseBinInputStream, g)) {
                                arrayList3.add(baseBinInputStream);
                                arrayList.add(b3);
                            } else {
                                z = true;
                            }
                        } else {
                            arrayList3.add(baseBinInputStream);
                            arrayList.add(b3);
                        }
                    }
                }
                i3++;
                i = 2;
            }
            try {
                b2.close();
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

    public static BinInfo d(LoadParams loadParams) throws LoadFileException {
        BinInfo binInfo;
        boolean z;
        BinIndicator byBitNumber;
        Iterator<SubFileInfo> it;
        int i;
        BinInfo binInfo2;
        int activeCompareVersionFlag;
        int activeCompareVersionFlag2;
        int i2 = 1;
        int i3 = loadParams.i();
        int b = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean s = loadParams.s();
        int l = loadParams.l();
        boolean y = loadParams.y();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        BinInfo b2 = com.realsil.sdk.dfu.j.a.b(loadParams);
        try {
            com.realsil.sdk.dfu.e.a c = com.realsil.sdk.dfu.d.b.c(loadParams);
            b2.isPackFile = true;
            b2.icType = c.a();
            b2.subFileInfos = c.c(0);
            b2.subFileInfos1 = c.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(b2.icType, i3)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i3), Integer.valueOf(b2.icType)));
                b2.updateEnabled = false;
                b2.status = 4101;
                return b2;
            }
            List<SubFileInfo> c2 = c.c(l);
            if (!c.a(2, b2.updateBank)) {
                ZLogger.w("OtaHeader Miss");
                if (loadParams.w() && c2.size() == 1 && c.a(520) != null) {
                    y = false;
                } else {
                    b2.updateEnabled = false;
                    b2.status = 4115;
                    return b2;
                }
            }
            Iterator<SubFileInfo> it2 = c2.iterator();
            int i4 = 0;
            int i5 = 0;
            while (it2.hasNext()) {
                SubFileInfo next = it2.next();
                int wrapperBitNumber = next.wrapperBitNumber();
                if (b2.icType == 11) {
                    byBitNumber = com.realsil.sdk.dfu.b.a.a(next.binId);
                } else if (!BinIndicator.isIndicatorEnabled(b, wrapperBitNumber)) {
                    ZLogger.v("prohibit upgrade image_id=" + next.imageId);
                } else {
                    byBitNumber = BinIndicator.getByBitNumber(BinIndicator.BBPRO, wrapperBitNumber);
                }
                if (byBitNumber == null) {
                    ZLogger.v("undefined image, bitNumber=" + wrapperBitNumber);
                } else {
                    ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, byBitNumber.toString());
                    BaseBinInputStream binInputStream = next.getBinInputStream(b2.icType, loadParams.f());
                    if (binInputStream == null) {
                        ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "invalid stream: " + next.toString());
                    } else {
                        binInputStream.versionCheckOrder = com.realsil.sdk.dfu.c.b.a(binInputStream.getImageId());
                        if (g != null) {
                            ImageVersionInfo activeImageVersionInfoByImageId = g.getActiveImageVersionInfoByImageId(binInputStream.getImageId());
                            if (activeImageVersionInfoByImageId != null) {
                                it = it2;
                                if (activeImageVersionInfoByImageId.getVersion() == -1) {
                                    ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(activeImageVersionInfoByImageId.getVersion())));
                                    binInputStream.setActiveCompareVersionFlag(1);
                                    i = b;
                                    binInfo2 = b2;
                                } else {
                                    i = b;
                                    binInfo2 = b2;
                                    int compareVersion = com.realsil.sdk.dfu.j.a.compareVersion(b2.icType, binInputStream.getBinId(), binInputStream.getImageId(), binInputStream.imageVersion, binInputStream.otaVersion, g.protocolType, activeImageVersionInfoByImageId.getVersion(), g.specVersion, byBitNumber.versionFormat, loadParams.r());
                                    ZLogger.v(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.bitNumber), Integer.valueOf(compareVersion)));
                                    binInputStream.setActiveCompareVersionFlag(compareVersion);
                                }
                            } else {
                                it = it2;
                                i = b;
                                binInfo2 = b2;
                                boolean z2 = com.realsil.sdk.dfu.j.a.f19549a;
                                Object[] objArr = new Object[i2];
                                objArr[0] = Integer.valueOf(binInputStream.getImageId());
                                ZLogger.v(z2, String.format("not find active image, imageId=0x%04X", objArr));
                                binInputStream.setActiveCompareVersionFlag(i2);
                            }
                            if (com.realsil.sdk.dfu.c.a.a(next.wrapperBitNumber())) {
                                if (i4 > 0) {
                                    if (binInputStream.getActiveCompareVersionFlag() < 0) {
                                        activeCompareVersionFlag2 = binInputStream.getActiveCompareVersionFlag();
                                        i4 = activeCompareVersionFlag2;
                                    }
                                } else if (i4 == 0) {
                                    activeCompareVersionFlag2 = binInputStream.getActiveCompareVersionFlag();
                                    i4 = activeCompareVersionFlag2;
                                }
                            } else if (i5 > 0) {
                                if (binInputStream.getActiveCompareVersionFlag() < 0) {
                                    activeCompareVersionFlag = binInputStream.getActiveCompareVersionFlag();
                                    i5 = activeCompareVersionFlag;
                                }
                            } else if (i5 == 0) {
                                activeCompareVersionFlag = binInputStream.getActiveCompareVersionFlag();
                                i5 = activeCompareVersionFlag;
                            }
                        } else {
                            it = it2;
                            i = b;
                            binInfo2 = b2;
                        }
                        arrayList2.add(binInputStream);
                        arrayList3.add(binInputStream);
                        arrayList.add(next);
                        it2 = it;
                        b = i;
                        b2 = binInfo2;
                        i2 = 1;
                    }
                }
            }
            BinInfo binInfo3 = b2;
            try {
                c.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            if (y && loadParams.m() == 0) {
                z = false;
                ZLogger.v(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i4), Integer.valueOf(i5)));
                if (i4 <= 0) {
                    if (i4 == 0) {
                        if (i5 <= 0) {
                            ZLogger.d("there must be at least one data image version> active image version");
                            binInfo3.updateEnabled = false;
                            binInfo3.status = 4113;
                            return binInfo3;
                        }
                    } else {
                        ZLogger.w("all code image version must >= active image version");
                        binInfo3.updateEnabled = false;
                        binInfo3.status = 4114;
                        return binInfo3;
                    }
                }
                binInfo = binInfo3;
            } else {
                binInfo = binInfo3;
                z = false;
            }
            binInfo.lowVersionExist = z;
            binInfo.subBinInputStreams = arrayList2;
            binInfo.supportBinInputStreams = arrayList3;
            binInfo.supportSubFileInfos = arrayList;
            return binInfo;
        } catch (LoadFileException e2) {
            b2.updateEnabled = false;
            b2.status = e2.getErrCode();
            return b2;
        }
    }

    public static BinInfo loadImageBinInfo(LoadParams loadParams) throws LoadFileException {
        ArrayList arrayList;
        boolean z;
        boolean z2;
        boolean z3;
        BinIndicator byBitNumber;
        Iterator<SubFileInfo> it;
        int i;
        int i2;
        SubFileInfo b;
        int i3 = loadParams.i();
        String d = loadParams.d();
        int b2 = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        boolean u = loadParams.u();
        int l = loadParams.l();
        BinInfo b3 = com.realsil.sdk.dfu.j.a.b(loadParams);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        b3.icType = i3;
        com.realsil.sdk.dfu.e.a c = com.realsil.sdk.dfu.d.b.c(loadParams);
        if (c != null) {
            b3.isPackFile = true;
            b3.icType = c.a();
            b3.subFileInfos = c.c(0);
            b3.subFileInfos1 = c.c(1);
            b3.bankIndicator = 0;
            if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i3)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i3), Integer.valueOf(b3.icType)));
                b3.updateEnabled = false;
                b3.status = 4101;
                return b3;
            }
            if (u && a(b3.icType) && (b = c.b()) != null) {
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
                Iterator<SubFileInfo> it2 = c.c(l).iterator();
                z = false;
                while (it2.hasNext()) {
                    SubFileInfo next = it2.next();
                    int wrapperBitNumber = next.wrapperBitNumber();
                    if (b3.icType == 11) {
                        byBitNumber = com.realsil.sdk.dfu.b.a.a(next.binId);
                    } else if (!BinIndicator.isIndicatorEnabled(b2, wrapperBitNumber)) {
                        ZLogger.v("prohibit upgrade image_id=" + next.imageId);
                        it = it2;
                        i = b2;
                        it2 = it;
                        b2 = i;
                    } else {
                        byBitNumber = BinIndicator.getByBitNumber(BinIndicator.BBPRO, wrapperBitNumber);
                    }
                    it = it2;
                    BaseBinInputStream binInputStream2 = next.getBinInputStream(b3.icType, loadParams.f());
                    if (binInputStream2 == null) {
                        ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "invalid stream: " + next.toString());
                        i = b2;
                        it2 = it;
                        b2 = i;
                    } else {
                        arrayList3.add(binInputStream2);
                        if (y) {
                            if (byBitNumber != null) {
                                i2 = byBitNumber.versionFormat;
                            } else {
                                i2 = 1;
                            }
                            i = b2;
                            if (loadParams.k() < 5 ? 1 != com.realsil.sdk.dfu.j.a.checkPackImageVersion(wrapperBitNumber, binInputStream2, g) : 1 != com.realsil.sdk.dfu.j.a.a(binInputStream2, g, i2)) {
                                it2 = it;
                                b2 = i;
                                z = true;
                            }
                        } else {
                            i = b2;
                        }
                        if (u && a(b3.icType)) {
                            if (z3) {
                                ZLogger.d("preVerify OTA_HEADER_FILE ok, need to check section size");
                            } else if (1 != com.realsil.sdk.dfu.j.a.a(binInputStream2, next.imageId, g)) {
                                b3.updateEnabled = false;
                                b3.status = 4109;
                                return b3;
                            }
                        }
                        arrayList4.add(binInputStream2);
                        arrayList2.add(next);
                        it2 = it;
                        b2 = i;
                    }
                }
            } else {
                ZLogger.w("pre verify failed");
                z = false;
            }
            try {
                c.close();
            } catch (IOException e) {
                ZLogger.w(e.toString());
            }
            arrayList = arrayList4;
        } else {
            try {
                arrayList = arrayList4;
                BaseBinInputStream openFileInputStream = com.realsil.sdk.dfu.j.a.openFileInputStream(b3.icType, d, 0L, loadParams.f());
                if (openFileInputStream != null) {
                    arrayList3.add(openFileInputStream);
                    b3.icType = openFileInputStream.getIcType();
                    b3.version = openFileInputStream.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i3)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i3), Integer.valueOf(b3.icType)));
                        b3.updateEnabled = false;
                        b3.status = 4101;
                        return b3;
                    }
                    if (y && 1 != com.realsil.sdk.dfu.j.a.checkSingleImageVersion2(openFileInputStream, g)) {
                        z = true;
                    } else if (u && a(b3.icType)) {
                        if (1 == com.realsil.sdk.dfu.j.a.a(openFileInputStream, g)) {
                            arrayList.add(openFileInputStream);
                        } else {
                            b3.updateEnabled = false;
                            b3.status = 4109;
                            return b3;
                        }
                    } else {
                        arrayList.add(openFileInputStream);
                    }
                }
                z = false;
            } catch (IOException e2) {
                ZLogger.w(e2.toString());
                throw new LoadFileException(e2.getMessage(), 4097);
            }
        }
        b3.lowVersionExist = z;
        b3.subBinInputStreams = arrayList3;
        b3.supportBinInputStreams = arrayList;
        b3.supportSubFileInfos = arrayList2;
        if (y && z && arrayList.size() < 1) {
            b3.updateEnabled = false;
            b3.status = 4104;
        }
        return b3;
    }
}
