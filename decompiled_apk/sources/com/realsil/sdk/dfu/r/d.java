package com.realsil.sdk.dfu.r;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.image.LoadParams;
import com.realsil.sdk.dfu.image.pack.SubFileInfo;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.model.BinInfo;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes11.dex */
public class d extends com.realsil.sdk.dfu.j.a {
    public static boolean a(int i) {
        if (i == 4 || i == 6 || i == 7 || i == 8 || i == 10) {
            return true;
        }
        ZLogger.v(com.realsil.sdk.dfu.j.a.b, String.format("not support section size check for ic:0x%02X", Integer.valueOf(i)));
        return false;
    }

    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        boolean z;
        BaseBinInputStream baseBinInputStream;
        int b = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        int i = loadParams.i();
        BinInfo a2 = com.realsil.sdk.dfu.j.a.a(loadParams);
        a2.icType = i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i2 = 2;
        ZLogger.v(String.format(Locale.US, "fileIndicator=0x%08X, versionCheckEnabled=%b", Integer.valueOf(b), Boolean.valueOf(y)));
        com.realsil.sdk.dfu.e.a b2 = com.realsil.sdk.dfu.d.b.b(loadParams);
        if (b2 != null) {
            a2.isPackFile = true;
            a2.icType = b2.a();
            a2.subFileInfos = b2.c(0);
            a2.subFileInfos1 = b2.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(a2.icType, i)) {
                ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i), Integer.valueOf(a2.icType)));
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
                    a2.bankIndicator |= i2;
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
                i2 = 2;
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
                    if (s && !com.realsil.sdk.dfu.j.a.a(a2.icType, i)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i), Integer.valueOf(a2.icType)));
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

    public static BinInfo loadImageBinInfo(LoadParams loadParams) throws LoadFileException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
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
        ZLogger.v(String.format(Locale.US, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b, sectionSizeCheckEnabled=%b", Integer.valueOf(b2), d, Boolean.valueOf(y), Boolean.valueOf(u)));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
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
                z4 = false;
                while (it2.hasNext()) {
                    SubFileInfo next = it2.next();
                    int wrapperBitNumber = next.wrapperBitNumber();
                    if (!BinIndicator.isIndicatorEnabled(b2, wrapperBitNumber)) {
                        ZLogger.v("prohibit upgrade image_id=" + next.imageId);
                        it = it2;
                    } else {
                        if (b3.icType == 11) {
                            byBitNumber = com.realsil.sdk.dfu.b.a.a(next.binId);
                        } else {
                            byBitNumber = BinIndicator.getByBitNumber(BinIndicator.BBPRO, wrapperBitNumber);
                        }
                        it = it2;
                        BaseBinInputStream binInputStream2 = next.getBinInputStream(b3.icType, loadParams.f());
                        if (binInputStream2 == null) {
                            ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, "invalid stream: " + next.toString());
                        } else {
                            arrayList2.add(binInputStream2);
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
                                    z4 = true;
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
                            arrayList3.add(binInputStream2);
                            arrayList.add(next);
                            it2 = it;
                            b2 = i;
                        }
                    }
                    i = b2;
                    it2 = it;
                    b2 = i;
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
                    arrayList2.add(openFileInputStream);
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
                            arrayList3.add(openFileInputStream);
                        }
                    } else {
                        arrayList3.add(openFileInputStream);
                    }
                }
                z = false;
            } catch (IOException e2) {
                ZLogger.w(e2.toString());
                throw new LoadFileException(e2.getMessage(), 4097);
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
}
