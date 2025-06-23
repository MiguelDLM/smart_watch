package com.realsil.sdk.dfu.v;

import android.content.Context;
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

/* loaded from: classes11.dex */
public class g extends com.realsil.sdk.dfu.j.a {
    public static boolean a(int i) {
        if (i == 4 || i == 6 || i == 7 || i == 8 || i == 10) {
            return true;
        }
        ZLogger.v(com.realsil.sdk.dfu.j.a.b, String.format("not support section size check for ic:0x%02X", Integer.valueOf(i)));
        return false;
    }

    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        int i;
        boolean z;
        BaseBinInputStream baseBinInputStream;
        int i2 = 2;
        Context a2 = loadParams.a();
        int i3 = loadParams.i();
        String d = loadParams.d();
        int b = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        BinInfo a3 = com.realsil.sdk.dfu.j.a.a(loadParams);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        com.realsil.sdk.dfu.e.a b2 = com.realsil.sdk.dfu.d.b.b(loadParams);
        if (b2 != null) {
            if (loadParams.k() > 1) {
                a3.isPackFile = true;
                a3.icType = b2.a();
                a3.subFileInfos = b2.c(0);
                a3.subFileInfos1 = b2.c(1);
                if (s && !com.realsil.sdk.dfu.j.a.a(a3.icType, i3)) {
                    ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i3), Integer.valueOf(a3.icType)));
                    a3.updateEnabled = false;
                    a3.status = 4101;
                    return a3;
                }
                int i4 = 0;
                boolean z2 = false;
                while (i4 < 16) {
                    int wrapperBitNumber = com.realsil.sdk.dfu.j.a.wrapperBitNumber(i4, g.imageVersionIndicator, g.updateBankIndicator);
                    if (wrapperBitNumber < 16) {
                        a3.bankIndicator |= 1;
                    } else {
                        a3.bankIndicator |= i2;
                    }
                    if (!BinIndicator.isIndicatorEnabled(b, wrapperBitNumber)) {
                        ZLogger.v("image file disable: bitNumber=" + wrapperBitNumber);
                    } else {
                        SubFileInfo b3 = b2.b(wrapperBitNumber);
                        if (b3 != null) {
                            baseBinInputStream = b3.getAssetsBinInputStream(a2, a3.icType, loadParams.f());
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
                                    z2 = true;
                                }
                            } else {
                                arrayList3.add(baseBinInputStream);
                                arrayList.add(b3);
                            }
                        }
                    }
                    i4++;
                    i2 = 2;
                }
                try {
                    b2.close();
                } catch (IOException e) {
                    ZLogger.e(e.toString());
                }
                z = z2;
                i = 1;
            } else {
                throw new LoadFileException("not support pack file", 4107);
            }
        } else {
            try {
                i = 1;
                BaseBinInputStream openAssetsInputStream = com.realsil.sdk.dfu.j.a.openAssetsInputStream(a2, i3, d, 0L, loadParams.f());
                if (openAssetsInputStream != null) {
                    arrayList2.add(openAssetsInputStream);
                    a3.icType = openAssetsInputStream.getIcType();
                    a3.version = openAssetsInputStream.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(a3.icType, i3)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i3), Integer.valueOf(a3.icType)));
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

    public static BinInfo loadImageBinInfo(LoadParams loadParams) throws LoadFileException {
        byte[] bArr;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        BaseBinInputStream baseBinInputStream;
        SubFileInfo b;
        int i = loadParams.i();
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
        int i2 = 1;
        if (c != null) {
            ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, c.toString());
            b3.isPackFile = true;
            b3.icType = c.a();
            b3.subFileInfos = c.c(0);
            b3.subFileInfos1 = c.c(1);
            if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i)) {
                ZLogger.d(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i), Integer.valueOf(b3.icType)));
                b3.updateEnabled = false;
                b3.status = 4101;
                return b3;
            }
            if (u && a(b3.icType) && (b = c.b(com.realsil.sdk.dfu.j.a.wrapperBitNumber(2, g.imageVersionIndicator, g.updateBankIndicator))) != null) {
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
                int i3 = 0;
                z4 = false;
                while (i3 < 16) {
                    int wrapperBitNumber = com.realsil.sdk.dfu.j.a.wrapperBitNumber(i3, g.imageVersionIndicator, g.updateBankIndicator);
                    if (wrapperBitNumber < 16) {
                        b3.bankIndicator |= i2;
                    } else {
                        b3.bankIndicator |= 2;
                    }
                    SubFileInfo b4 = c.b(wrapperBitNumber);
                    if (b4 != null) {
                        baseBinInputStream = b4.getBinInputStream(b3.icType, loadParams.f());
                    } else {
                        baseBinInputStream = null;
                    }
                    if (baseBinInputStream != null) {
                        arrayList2.add(baseBinInputStream);
                        if (!BinIndicator.isIndicatorEnabled(b2, wrapperBitNumber)) {
                            ZLogger.v("image file disable: bitNumber=" + wrapperBitNumber);
                        } else if (y && 1 != com.realsil.sdk.dfu.j.a.checkPackImageVersion(i3, baseBinInputStream, g)) {
                            z4 = true;
                        } else {
                            if (u && a(b3.icType)) {
                                if (z3) {
                                    ZLogger.d("preVerify OTA_HEADER_FILE ok, no need to check section size");
                                } else if (1 != com.realsil.sdk.dfu.j.a.a(baseBinInputStream, b4.imageId, g)) {
                                    b3.updateEnabled = false;
                                    b3.status = 4109;
                                    return b3;
                                }
                            }
                            arrayList3.add(baseBinInputStream);
                            arrayList.add(b4);
                        }
                    }
                    i3++;
                    i2 = 1;
                }
            } else {
                ZLogger.w("pre verify failed");
                z4 = false;
            }
            try {
                c.close();
            } catch (IOException e) {
                ZLogger.e(e.toString());
            }
            z = z4;
        } else {
            try {
                BaseBinInputStream openFileInputStream = com.realsil.sdk.dfu.j.a.openFileInputStream(i, d, 0L, loadParams.f());
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
                BaseBinInputStream openFileInputStream2 = com.realsil.sdk.dfu.j.a.openFileInputStream(i, d, 0L, loadParams.f());
                if (openFileInputStream2 != null) {
                    openFileInputStream2.setSha256(bArr);
                    arrayList2.add(openFileInputStream2);
                    b3.icType = openFileInputStream2.getIcType();
                    b3.version = openFileInputStream2.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(b3.icType, i)) {
                        ZLogger.d(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i), Integer.valueOf(b3.icType)));
                        b3.updateEnabled = false;
                        b3.status = 4101;
                        return b3;
                    }
                    if (y && 1 != com.realsil.sdk.dfu.j.a.checkSingleImageVersion2(openFileInputStream2, g)) {
                        z = true;
                    } else if (u && a(b3.icType)) {
                        if (1 == com.realsil.sdk.dfu.j.a.a(openFileInputStream2, g)) {
                            arrayList3.add(openFileInputStream2);
                        }
                    } else {
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
}
