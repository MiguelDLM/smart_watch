package com.realsil.sdk.dfu.b;

import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<BinIndicator> f19528a;

    static {
        ArrayList<BinIndicator> arrayList = new ArrayList<>();
        f19528a = arrayList;
        arrayList.add(new BinIndicator(0, "SOCV Config File", null, 257, false, 1));
        arrayList.add(new BinIndicator(1, "System Config", null, 256, true, 1));
        arrayList.add(new BinIndicator(2, "OTA Header", null, ErrorCode.MSP_ERROR_CONFIG_INITIALIZE, 2048, true, 1, false));
        arrayList.add(new BinIndicator(3, "Secure Boot Loader", null, ErrorCode.MSP_ERROR_CREATE_HANDLE, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, true, 3, false));
        arrayList.add(new BinIndicator(4, "ROM Patch", null, ErrorCode.MSP_ERROR_CODING_LIB_NOT_LOAD, 512, true, 3, false));
        arrayList.add(new BinIndicator(5, "App", null, ErrorCode.MSP_ERROR_USER_CANCELLED, 768, true, 5, false));
        arrayList.add(new BinIndicator(6, "DSP System", null, ErrorCode.MSP_ERROR_INVALID_OPERATION, 1280, true, 515, false));
        arrayList.add(new BinIndicator(7, "DSP App", null, ErrorCode.MSP_ERROR_MESSAGE_NOT_COMPLETE, SubBinId.Bbpro.DSP_APP_IMAGE, true, 515, false));
        arrayList.add(new BinIndicator(8, "DSP Config", null, 10135, SubBinId.Bbpro.DSP_UI_PARAMETER_FILE, true, 514, true));
        arrayList.add(new BinIndicator(9, "App Config", null, 10134, 1024, true, 2, true));
        arrayList.add(new BinIndicator(10, "Ext Image 0", null, ErrorCode.MSP_ERROR_USER_ACTIVE_ABORT, 2304, false, 1, true));
        arrayList.add(new BinIndicator(11, "Ext Image 1", null, ErrorCode.MSP_ERROR_BUSY_GRMBUILDING, 2305, false, 1, false));
        arrayList.add(new BinIndicator(12, "Ext Image 2", null, ErrorCode.MSP_ERROR_BUSY_LEXUPDATING, SubBinId.Bbpro.EXT_IMAGE_2, false, 1, false));
        arrayList.add(new BinIndicator(13, "Ext Image 3", null, 10139, SubBinId.Bbpro.EXT_IMAGE_3, false, 1, false));
        arrayList.add(new BinIndicator(17, "Sys Patch", null, ErrorCode.MSP_ERROR_BOS_TIMEOUT, 513, false, 3, false));
        arrayList.add(new BinIndicator(18, "Stack Patch", null, ErrorCode.MSP_ERROR_GROUP_EMPTY, 514, false, 3, false));
        arrayList.add(new BinIndicator(19, "Upper Stack", null, ErrorCode.MSP_ERROR_NO_USER, 515, false, 1, false));
        arrayList.add(new BinIndicator(20, "Framework", null, ErrorCode.MSP_ERROR_NO_GROUP, 516, false, 1, false));
        arrayList.add(new BinIndicator(14, "Factory Image", null, SubBinId.Bbpro.FACTORY_IAMGE, false, 1));
        arrayList.add(new BinIndicator(15, "Backup Data 1", null, SubBinId.Bbpro.BACKUP_DATA_1, false, 1));
        arrayList.add(new BinIndicator(16, "Backup Data 2", null, SubBinId.Bbpro.BACKUP_DATA_2, false, 1));
        arrayList.add(new BinIndicator(17, "Platform Ext", null, 10145, 517, false, 3, false));
        arrayList.add(new BinIndicator(18, "Stack Patch", null, ErrorCode.MSP_ERROR_GROUP_EMPTY, 518, false, 1, false));
        arrayList.add(new BinIndicator(19, "Upper stack", null, ErrorCode.MSP_ERROR_NO_USER, 519, false, 3, false));
        arrayList.add(new BinIndicator(24, "Voice Prompt Data", null, 10148, 520, false, 2, false));
        arrayList.add(new BinIndicator(24, "User Data 1", null, 10145, 61441, false, 1, false));
        arrayList.add(new BinIndicator(24, "User Data 2", null, 10145, 61442, false, 1, false));
        arrayList.add(new BinIndicator(24, "User Data 3", null, 10145, 61443, false, 1, false));
        arrayList.add(new BinIndicator(24, "User Data 4", null, 10145, 61444, false, 1, false));
        arrayList.add(new BinIndicator(24, "User Data 5", null, 10145, 61445, false, 1, false));
        arrayList.add(new BinIndicator(24, "User Data 6", null, 10145, 61446, false, 1, false));
        arrayList.add(new BinIndicator(24, "User Data 7", null, 10145, 61447, false, 1, false));
        arrayList.add(new BinIndicator(24, "User Data 8", null, 10145, 61448, false, 1, false));
    }

    public static BinIndicator a(int i) {
        Iterator<BinIndicator> it = f19528a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.subBinId == i) {
                return next;
            }
        }
        return null;
    }

    public static BinIndicator b(int i) {
        Iterator<BinIndicator> it = f19528a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.imageId == i) {
                return next;
            }
        }
        return null;
    }
}
