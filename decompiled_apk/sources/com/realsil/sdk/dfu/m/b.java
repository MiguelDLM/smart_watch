package com.realsil.sdk.dfu.m;

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
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public class b extends com.realsil.sdk.dfu.j.a {
    public static BinInfo c(LoadParams loadParams) throws LoadFileException {
        ArrayList arrayList;
        boolean z;
        BaseBinInputStream baseBinInputStream;
        Context a2 = loadParams.a();
        int i = loadParams.i();
        String d = loadParams.d();
        loadParams.e();
        int b = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        try {
            InputStream open = a2.getAssets().open(d);
            BinInfo a3 = com.realsil.sdk.dfu.j.a.a(loadParams);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            a3.icType = i;
            com.realsil.sdk.dfu.e.a a4 = com.realsil.sdk.dfu.e.a.a(a2, d, open, 0L);
            if (a4 != null) {
                if (a4.d()) {
                    a3.isPackFile = true;
                    a3.icType = a4.a();
                    a3.subFileInfos = a4.c(0);
                    a3.subFileInfos1 = a4.c(1);
                    a3.bankIndicator = 0;
                    if (s && !com.realsil.sdk.dfu.j.a.a(a3.icType, i)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i), Integer.valueOf(a3.icType)));
                        a3.updateEnabled = false;
                        a3.status = 4101;
                        return a3;
                    }
                    z = false;
                    for (int i2 = 0; i2 < 16; i2++) {
                        int wrapperBitNumber = com.realsil.sdk.dfu.j.a.wrapperBitNumber(i2, g.imageVersionIndicator, g.updateBankIndicator);
                        if (wrapperBitNumber < 16) {
                            a3.bankIndicator |= 1;
                        } else {
                            a3.bankIndicator |= 2;
                        }
                        if (!BinIndicator.isIndicatorEnabled(b, wrapperBitNumber)) {
                            ZLogger.v("image file disable: bitNumber=" + wrapperBitNumber);
                        } else {
                            SubFileInfo b2 = a4.b(wrapperBitNumber);
                            if (b2 != null) {
                                baseBinInputStream = b2.getAssetsBinInputStream(a2, a3.icType, loadParams.f());
                            } else {
                                baseBinInputStream = null;
                            }
                            if (baseBinInputStream != null) {
                                arrayList3.add(baseBinInputStream);
                                if (y) {
                                    if (1 == com.realsil.sdk.dfu.j.a.checkPackImageVersion(wrapperBitNumber, baseBinInputStream, g)) {
                                        arrayList4.add(baseBinInputStream);
                                        arrayList2.add(b2);
                                    } else {
                                        z = true;
                                    }
                                } else {
                                    arrayList4.add(baseBinInputStream);
                                    arrayList2.add(b2);
                                }
                            }
                        }
                    }
                    try {
                        a4.close();
                    } catch (IOException e) {
                        ZLogger.w(e.toString());
                    }
                    arrayList = arrayList4;
                } else {
                    ZLogger.w("pack for MP can not be OTA");
                    throw new LoadFileException("not support pack file.", 4116);
                }
            } else {
                try {
                    BaseBinInputStream openAssetsInputStream = com.realsil.sdk.dfu.j.a.openAssetsInputStream(a2, a3.icType, d, 0L, loadParams.f());
                    if (openAssetsInputStream != null) {
                        arrayList3.add(openAssetsInputStream);
                        a3.icType = openAssetsInputStream.getIcType();
                        a3.version = openAssetsInputStream.getImageVersion();
                        if (s && !com.realsil.sdk.dfu.j.a.a(a3.icType, i)) {
                            ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i), Integer.valueOf(a3.icType)));
                            a3.updateEnabled = false;
                            a3.status = 4101;
                            return a3;
                        }
                        if (y) {
                            if (1 == com.realsil.sdk.dfu.j.a.checkSingleImageVersion2(openAssetsInputStream, g)) {
                                arrayList = arrayList4;
                                arrayList.add(openAssetsInputStream);
                            } else {
                                arrayList = arrayList4;
                                z = true;
                            }
                        } else {
                            arrayList = arrayList4;
                            arrayList.add(openAssetsInputStream);
                        }
                    } else {
                        arrayList = arrayList4;
                    }
                    z = false;
                } catch (IOException e2) {
                    ZLogger.w(e2.toString());
                    throw new LoadFileException(e2.getMessage(), 4097);
                }
            }
            a3.lowVersionExist = z;
            a3.subBinInputStreams = arrayList3;
            a3.supportBinInputStreams = arrayList;
            a3.supportSubFileInfos = arrayList2;
            if (y && z && arrayList.size() < 1) {
                a3.updateEnabled = false;
                a3.status = 4104;
            }
            return a3;
        } catch (IOException e3) {
            ZLogger.w(e3.toString());
            return null;
        }
    }

    public static BinInfo loadImageBinInfo(LoadParams loadParams) throws LoadFileException {
        boolean z;
        BaseBinInputStream baseBinInputStream;
        int i = 2;
        loadParams.a();
        int i2 = loadParams.i();
        String d = loadParams.d();
        loadParams.e();
        int b = loadParams.b();
        OtaDeviceInfo g = loadParams.g();
        boolean y = loadParams.y();
        boolean s = loadParams.s();
        BinInfo b2 = com.realsil.sdk.dfu.j.a.b(loadParams);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b2.icType = i2;
        if (com.realsil.sdk.dfu.d.b.a(loadParams) != null) {
            ZLogger.w("not support multi pack file");
            b2.updateEnabled = false;
            b2.fileType = 4;
            b2.status = 4103;
            return b2;
        }
        com.realsil.sdk.dfu.e.a a2 = com.realsil.sdk.dfu.e.a.a(d);
        if (a2 != null) {
            if (a2.d()) {
                ZLogger.v(com.realsil.sdk.dfu.j.a.f19549a, a2.toString());
                b2.fileType = 2;
                b2.isPackFile = true;
                b2.icType = a2.a();
                b2.subFileInfos = a2.c(0);
                b2.subFileInfos1 = a2.c(1);
                b2.bankIndicator = 0;
                if (s && !com.realsil.sdk.dfu.j.a.a(b2.icType, i2)) {
                    ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(b2.icType)));
                    b2.updateEnabled = false;
                    b2.status = 4101;
                    return b2;
                }
                int i3 = 0;
                z = false;
                while (i3 < 16) {
                    int wrapperBitNumber = com.realsil.sdk.dfu.j.a.wrapperBitNumber(i3, g.imageVersionIndicator, g.updateBankIndicator);
                    if (wrapperBitNumber < 16) {
                        b2.bankIndicator |= 1;
                    } else {
                        b2.bankIndicator |= i;
                    }
                    if (!BinIndicator.isIndicatorEnabled(b, wrapperBitNumber)) {
                        ZLogger.v("image file disable: bitNumber=" + wrapperBitNumber);
                    } else {
                        SubFileInfo b3 = a2.b(wrapperBitNumber);
                        if (b3 != null) {
                            baseBinInputStream = b3.getBinInputStream(b2.icType, loadParams.f());
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
                    a2.close();
                } catch (IOException e) {
                    ZLogger.w(e.toString());
                }
            } else {
                ZLogger.w("pack for MP can not be OTA");
                throw new LoadFileException("not support pack file.", 4116);
            }
        } else {
            b2.fileType = 1;
            b2.bankIndicator = 0;
            try {
                BaseBinInputStream openFileInputStream = com.realsil.sdk.dfu.j.a.openFileInputStream(i2, d, 0L, loadParams.f());
                if (openFileInputStream != null) {
                    arrayList2.add(openFileInputStream);
                    b2.icType = openFileInputStream.getIcType();
                    b2.version = openFileInputStream.getImageVersion();
                    if (s && !com.realsil.sdk.dfu.j.a.a(b2.icType, i2)) {
                        ZLogger.w(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(i2), Integer.valueOf(b2.icType)));
                        b2.updateEnabled = false;
                        b2.status = 4101;
                        return b2;
                    }
                    if (y && 1 != com.realsil.sdk.dfu.j.a.checkSingleImageVersion2(openFileInputStream, g)) {
                        z = true;
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
        b2.lowVersionExist = z;
        b2.subBinInputStreams = arrayList2;
        b2.supportBinInputStreams = arrayList3;
        b2.supportSubFileInfos = arrayList;
        if (y && z && arrayList3.size() < 1) {
            b2.updateEnabled = false;
            b2.status = 4104;
        }
        return b2;
    }
}
