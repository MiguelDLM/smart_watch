package com.realsil.sdk.dfu.image;

import com.garmin.fit.OxXXx0X;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.b.a;
import com.realsil.sdk.dfu.b.b;
import com.realsil.sdk.dfu.b.c;
import com.realsil.sdk.dfu.b.d;
import com.realsil.sdk.dfu.b.e;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes11.dex */
public class BinIndicator {
    public static final ArrayList<BinIndicator> BBPRO;
    public static final ArrayList<BinIndicator> BEE2;
    public static final int INDICATOR_FULL = -1;
    public static final int INDICATOR_MASK = 1;
    public static boolean VDBG = false;
    public int bitNumber;
    public String description;
    public String flashLayoutName;
    public int imageId;
    public boolean isConfigEnabled;
    public int subBinId;
    public boolean versionCheckEnabled;
    public int versionFormat;

    static {
        ArrayList<BinIndicator> arrayList = new ArrayList<>();
        BEE2 = arrayList;
        arrayList.add(new BinIndicator(0, "SOCV Config File", null, 257, true, 3));
        arrayList.add(new BinIndicator(1, "System Config", null, 256, true, 3));
        for (int i = 0; i < 2; i++) {
            ArrayList<BinIndicator> arrayList2 = BEE2;
            int i2 = i * 16;
            arrayList2.add(new BinIndicator(i2 + 2, "OTA Header", null, 2048, true, 2));
            arrayList2.add(new BinIndicator(i2 + 3, "Secure Boot Loader", null, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, true, 3));
            arrayList2.add(new BinIndicator(i2 + 4, "ROM Patch", null, 512, true, 3));
            arrayList2.add(new BinIndicator(i2 + 5, "App", null, 768, true, 3));
            arrayList2.add(new BinIndicator(i2 + 6, "APP Data1 File", null, 2305, false, 3));
            arrayList2.add(new BinIndicator(i2 + 7, "APP Data2 File", null, SubBinId.Bbpro.EXT_IMAGE_2, false, 3));
            arrayList2.add(new BinIndicator(i2 + 8, "APP Data3 File", null, SubBinId.Bbpro.EXT_IMAGE_3, false, 3));
            arrayList2.add(new BinIndicator(i2 + 9, "APP Data4 File", null, 2308, false, 3));
            arrayList2.add(new BinIndicator(i2 + 10, "APP Data5 File", null, 2309, false, 3));
            arrayList2.add(new BinIndicator(i2 + 11, "APP Data6 File", null, OxXXx0X.f13193oo00, false, 3));
            arrayList2.add(new BinIndicator(i2 + 12, "Upper Stack", null, SubBinId.Bbpro.FACTORY_IAMGE, true, 3));
        }
        ArrayList<BinIndicator> arrayList3 = new ArrayList<>();
        BBPRO = arrayList3;
        arrayList3.add(new BinIndicator(0, "SOCV Config File", null, 257, false, 1));
        arrayList3.add(new BinIndicator(1, "System Config", null, 256, true, 1));
        for (int i3 = 0; i3 < 2; i3++) {
            ArrayList<BinIndicator> arrayList4 = BBPRO;
            int i4 = i3 * 16;
            arrayList4.add(new BinIndicator(i4 + 2, "OTA Header", null, ErrorCode.MSP_ERROR_CONFIG_INITIALIZE, 2048, true, 1, false));
            arrayList4.add(new BinIndicator(i4 + 3, "Secure Boot Loader", null, ErrorCode.MSP_ERROR_CREATE_HANDLE, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, true, 3, false));
            arrayList4.add(new BinIndicator(i4 + 4, "ROM Patch", null, ErrorCode.MSP_ERROR_CODING_LIB_NOT_LOAD, 512, true, 3, false));
            arrayList4.add(new BinIndicator(i4 + 5, "App", null, ErrorCode.MSP_ERROR_USER_CANCELLED, 768, true, 5, false));
            arrayList4.add(new BinIndicator(i4 + 6, "DSP System", null, ErrorCode.MSP_ERROR_INVALID_OPERATION, 1280, true, 515, false));
            arrayList4.add(new BinIndicator(i4 + 7, "DSP App", null, ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE, SubBinId.Bbpro.DSP_APP_IMAGE, true, 515, false));
            arrayList4.add(new BinIndicator(i4 + 8, "DSP Config", null, 10135, SubBinId.Bbpro.DSP_UI_PARAMETER_FILE, true, 514, true));
            arrayList4.add(new BinIndicator(i4 + 9, "App Config", null, 10134, 1024, true, 2, true));
            arrayList4.add(new BinIndicator(i4 + 10, "Ext Image 0", null, ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT, 2304, false, 1, true));
            arrayList4.add(new BinIndicator(i4 + 11, "Ext Image 1", null, ErrorCode.MSP_ERROR_BUSY_GRMBUILDING, 2305, false, 1, false));
            arrayList4.add(new BinIndicator(i4 + 12, "Ext Image 2", null, ErrorCode.MSP_ERROR_BUSY_LEXUPDATING, SubBinId.Bbpro.EXT_IMAGE_2, false, 1, false));
            arrayList4.add(new BinIndicator(i4 + 13, "Ext Image 3", null, 10139, SubBinId.Bbpro.EXT_IMAGE_3, false, 1, false));
            arrayList4.add(new BinIndicator(i4 + 17, "Sys Patch", null, ErrorCode.MSP_ERROR_BOS_TIMEOUT, 513, false, 3, false));
            arrayList4.add(new BinIndicator(i4 + 18, "Stack Patch", null, ErrorCode.MSP_ERROR_GROUP_EMPTY, 514, false, 3, false));
            arrayList4.add(new BinIndicator(i4 + 19, "Upper Stack", null, ErrorCode.MSP_ERROR_NO_USER, 515, false, 1, false));
            arrayList4.add(new BinIndicator(i4 + 20, "Framework", null, ErrorCode.MSP_ERROR_NO_GROUP, 516, false, 1, false));
        }
        ArrayList<BinIndicator> arrayList5 = BBPRO;
        arrayList5.add(new BinIndicator(14, "Factory", null, SubBinId.Bbpro.FACTORY_IAMGE, false, 1));
        arrayList5.add(new BinIndicator(15, "Backup Data 1", null, SubBinId.Bbpro.BACKUP_DATA_1, false, 1));
        arrayList5.add(new BinIndicator(16, "Backup Data 2", null, SubBinId.Bbpro.BACKUP_DATA_2, false, 1));
        arrayList5.add(new BinIndicator(24, "Voice Prompt Data", null, 10148, 520, false, 2, false));
        arrayList5.add(new BinIndicator(24, "Platform Ext", null, 10145, 517, false, 3, false));
    }

    public BinIndicator(int i, String str, String str2, int i2, int i3, boolean z, int i4, boolean z2) {
        this.bitNumber = i;
        this.flashLayoutName = str;
        this.description = str2;
        this.imageId = i2;
        this.subBinId = i3;
        this.versionCheckEnabled = z;
        this.versionFormat = i4;
        this.isConfigEnabled = z2;
    }

    public static BinIndicator getBinIndicatorByBinId(int i, int i2, int i3) {
        if (i == 14) {
            return e.a(i2);
        }
        if (i != 5 && i != 9 && i != 12) {
            if (i != 4 && i != 6 && i != 7 && i != 8 && i != 13 && i != 10) {
                if (i == 11) {
                    return a.a(i2);
                }
                if (i == 3) {
                    return c.a(i3);
                }
                return getByBitNumber(BBPRO, i3);
            }
            return b.a(i2);
        }
        return d.a(i2);
    }

    public static BinIndicator getBinIndicatorByBitNumber(int i, int i2) {
        if (i <= 3) {
            return c.a(i2);
        }
        if (i != 5 && i != 9 && i != 12) {
            if (i != 4 && i != 6 && i != 7 && i != 13 && i != 8 && i != 10 && i != 11 && i != 14) {
                return null;
            }
            return b.b(i2);
        }
        return d.b(i2);
    }

    public static BinIndicator getBinIndicatorByImageId(int i, int i2, int i3) {
        if (i == 14) {
            return e.b(i2);
        }
        if (i != 5 && i != 9 && i != 12) {
            if (i != 4 && i != 6 && i != 7 && i != 8 && i != 13 && i != 10) {
                if (i == 11) {
                    return a.b(i2);
                }
                if (i == 3) {
                    return c.a(i3);
                }
                return getByBitNumber(BBPRO, i3);
            }
            return b.c(i2);
        }
        return b.c(i2);
    }

    public static BinIndicator getByBitNumber(ArrayList<BinIndicator> arrayList, int i) {
        Iterator<BinIndicator> it = arrayList.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.bitNumber == i) {
                return next;
            }
        }
        ZLogger.v("undefined indicator, bitNumber=" + i);
        return null;
    }

    public static BinIndicator getIndByBinId(int i, int i2) {
        if (i == 14) {
            return e.a(i2);
        }
        if (i != 5 && i != 9 && i != 12) {
            if (i != 4 && i != 6 && i != 7 && i != 8 && i != 13 && i != 10) {
                if (i == 11) {
                    return a.a(i2);
                }
                return null;
            }
            return b.a(i2);
        }
        return d.a(i2);
    }

    public static BinIndicator getIndByImageId(int i, int i2) {
        if (i == 14) {
            return e.b(i2);
        }
        if (i != 5 && i != 9 && i != 12) {
            if (i != 4 && i != 6 && i != 7 && i != 8 && i != 13 && i != 10) {
                if (i == 11) {
                    return a.b(i2);
                }
                if (i == 3) {
                    return c.b(i2);
                }
                return null;
            }
            return b.c(i2);
        }
        return b.c(i2);
    }

    public static boolean isIndicatorEnabled(int i, int i2) {
        return i == -1 || ((i >> i2) & 1) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        sb.append(String.format(locale, "bitNumber=%d, flashLayoutName=%s, imageId=0x%04X, subBinId=0x%04X", Integer.valueOf(this.bitNumber), this.flashLayoutName, Integer.valueOf(this.imageId), Integer.valueOf(this.subBinId)));
        sb.append(String.format(locale, ", versionCheckEnabled=%b, versionFormat=0x%04X, isConfigEnabled=%b", Boolean.valueOf(this.versionCheckEnabled), Integer.valueOf(this.versionFormat), Boolean.valueOf(this.isConfigEnabled)));
        return sb.toString();
    }

    public BinIndicator(int i, String str, String str2, int i2, boolean z, int i3) {
        this(i, str, str2, 0, i2, z, i3, false);
    }
}
