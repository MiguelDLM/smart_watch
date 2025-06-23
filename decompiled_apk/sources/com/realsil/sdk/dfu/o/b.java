package com.realsil.sdk.dfu.o;

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
import java.util.Comparator;
import java.util.Locale;

/* loaded from: classes11.dex */
public class b extends com.realsil.sdk.dfu.j.a {

    /* loaded from: classes11.dex */
    public class a implements Comparator<BaseBinInputStream> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BaseBinInputStream baseBinInputStream, BaseBinInputStream baseBinInputStream2) {
            return baseBinInputStream2.otaTempBufferCheckOrder - baseBinInputStream.otaTempBufferCheckOrder;
        }
    }

    /* renamed from: com.realsil.sdk.dfu.o.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0914b implements Comparator<BaseBinInputStream> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BaseBinInputStream baseBinInputStream, BaseBinInputStream baseBinInputStream2) {
            return baseBinInputStream2.otaTempBufferCheckOrder - baseBinInputStream.otaTempBufferCheckOrder;
        }
    }

    public static int a(int i) {
        if (i == 513 || i == 517 || i == 519 || i == 768) {
            return 3;
        }
        switch (i) {
            case 61441:
            case 61442:
            case 61443:
            case 61444:
            case 61445:
            case 61446:
            case 61447:
            case 61448:
                return 0;
            default:
                return 1;
        }
    }

    public static boolean b(int i) {
        if (i == 4 || i == 6 || i == 7 || i == 8 || i == 13 || i == 10) {
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0108, code lost:
    
        if (r15 != 519) goto L38;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:170:0x035b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.realsil.sdk.dfu.model.BinInfo loadImageBinInfo(com.realsil.sdk.dfu.image.LoadParams r23) throws com.realsil.sdk.dfu.exception.LoadFileException {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.o.b.loadImageBinInfo(com.realsil.sdk.dfu.image.LoadParams):com.realsil.sdk.dfu.model.BinInfo");
    }
}
