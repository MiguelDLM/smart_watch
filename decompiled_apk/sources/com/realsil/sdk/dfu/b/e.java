package com.realsil.sdk.dfu.b;

import com.garmin.fit.OxXXx0X;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes11.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<BinIndicator> f19533a;

    static {
        ArrayList<BinIndicator> arrayList = new ArrayList<>();
        f19533a = arrayList;
        arrayList.add(new BinIndicator(2, "SOCV Config", null, 14237, 257, true, 3, false));
        arrayList.add(new BinIndicator(2, "OEM Config", null, 14238, 256, true, 3, false));
        arrayList.add(new BinIndicator(2, "Boot Patch", null, 14239, SubBinId.Bbpro.BACKUP_DATA_2, true, 3, false));
        arrayList.add(new BinIndicator(2, "OTA Header", null, 14240, 2048, true, 1, false));
        arrayList.add(new BinIndicator(2, "Secure Patch", null, 14241, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, true, 3, false));
        arrayList.add(new BinIndicator(2, "Secure Patch", null, 14241, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, true, 3, false));
        arrayList.add(new BinIndicator(2, "Secure App", null, 14242, 769, true, 3, false));
        arrayList.add(new BinIndicator(2, "Secure App Data", null, 14243, 1041, true, 3, false));
        arrayList.add(new BinIndicator(2, "PMC Patch", null, 14244, 514, true, 3, false));
        arrayList.add(new BinIndicator(2, "BT System Patch", null, 14245, 516, true, 3, false));
        arrayList.add(new BinIndicator(2, "BT Lowerstack Patch", null, 14246, 515, true, 3, false));
        arrayList.add(new BinIndicator(2, "Non-secure Patch", null, 14247, 512, true, 3, false));
        arrayList.add(new BinIndicator(2, "Upperstack", null, 14248, SubBinId.Bbpro.FACTORY_IAMGE, true, 3, false));
        arrayList.add(new BinIndicator(2, "App", null, 14249, 768, true, 3, false));
        arrayList.add(new BinIndicator(2, "App Config Data", null, 14250, 1024, true, 3, false));
        arrayList.add(new BinIndicator(2, "DSP Patch", null, 14251, 1280, true, 3, false));
        arrayList.add(new BinIndicator(2, "DSP App", null, 14252, SubBinId.Bbpro.DSP_APP_IMAGE, true, 3, false));
        arrayList.add(new BinIndicator(2, "DSP Data", null, 14253, SubBinId.Bbpro.DSP_UI_PARAMETER_FILE, true, 3, false));
        arrayList.add(new BinIndicator(2, "App Data 1", null, 14254, 2305, true, 3, false));
        arrayList.add(new BinIndicator(2, "App Data 2", null, 14255, SubBinId.Bbpro.EXT_IMAGE_2, true, 3, false));
        arrayList.add(new BinIndicator(2, "App Data 3", null, 14256, SubBinId.Bbpro.EXT_IMAGE_3, true, 3, false));
        arrayList.add(new BinIndicator(2, "App Data 4", null, 14257, 2308, true, 3, false));
        arrayList.add(new BinIndicator(2, "App Data 5", null, 14258, 2309, true, 3, false));
        arrayList.add(new BinIndicator(2, "App Data 6", null, 14259, OxXXx0X.f13193oo00, true, 3, false));
        arrayList.add(new BinIndicator(2, "MAX", null, 14260, 14260, true, 3, false));
        arrayList.add(new BinIndicator(2, "RO_DATA1", null, 14977, 14977, true, 3, false));
        arrayList.add(new BinIndicator(2, "RO_DATA2", null, 14978, 14978, true, 3, false));
        arrayList.add(new BinIndicator(2, "RO_DATA3", null, 14979, 14979, true, 3, false));
        arrayList.add(new BinIndicator(2, "RO_DATA4", null, 14980, 14980, true, 3, false));
        arrayList.add(new BinIndicator(2, "RO_DATA5", null, 14981, 14981, true, 3, false));
        arrayList.add(new BinIndicator(2, "RO_DATA6", null, 14982, 14982, true, 3, false));
        arrayList.add(new BinIndicator(2, "USER_DATA2", null, 65533, 65533, true, 3, false));
        arrayList.add(new BinIndicator(2, "USER_DATA1", null, 65534, 65534, true, 3, false));
    }

    public static BinIndicator a(int i) {
        Iterator<BinIndicator> it = f19533a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.subBinId == i) {
                return next;
            }
        }
        return null;
    }

    public static BinIndicator b(int i) {
        Iterator<BinIndicator> it = f19533a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.imageId == i) {
                return next;
            }
        }
        return null;
    }
}
