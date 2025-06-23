package com.realsil.sdk.dfu.b;

import com.garmin.fit.OxXXx0X;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<BinIndicator> f19532a;

    static {
        ArrayList<BinIndicator> arrayList = new ArrayList<>();
        f19532a = arrayList;
        arrayList.add(new BinIndicator(0, "SOCV Config File", null, 257, true, 3));
        arrayList.add(new BinIndicator(1, "System Config", null, 256, true, 3));
        arrayList.add(new BinIndicator(2, "OTA Header", null, 2048, true, 2));
        arrayList.add(new BinIndicator(3, "Secure Boot Loader", null, SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE, true, 3));
        arrayList.add(new BinIndicator(4, "ROM Patch", null, 512, true, 3));
        arrayList.add(new BinIndicator(5, "App", null, 768, true, 3));
        arrayList.add(new BinIndicator(6, "APP Data1 File", null, 2305, false, 3));
        arrayList.add(new BinIndicator(7, "APP Data2 File", null, SubBinId.Bbpro.EXT_IMAGE_2, false, 3));
        arrayList.add(new BinIndicator(8, "APP Data3 File", null, SubBinId.Bbpro.EXT_IMAGE_3, false, 3));
        arrayList.add(new BinIndicator(9, "APP Data4 File", null, 2308, false, 3));
        arrayList.add(new BinIndicator(10, "APP Data5 File", null, 2309, false, 3));
        arrayList.add(new BinIndicator(11, "APP Data6 File", null, OxXXx0X.f13193oo00, false, 3));
        arrayList.add(new BinIndicator(12, "Upper Stack", null, SubBinId.Bbpro.FACTORY_IAMGE, true, 3));
    }

    public static BinIndicator a(int i) {
        Iterator<BinIndicator> it = f19532a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.subBinId == i) {
                return next;
            }
        }
        return null;
    }

    public static BinIndicator b(int i) {
        Iterator<BinIndicator> it = f19532a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.bitNumber == i) {
                return next;
            }
        }
        return null;
    }

    public static BinIndicator a(int i, boolean z) {
        Iterator<BinIndicator> it = f19532a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.bitNumber == i && next.versionCheckEnabled == z) {
                return next;
            }
        }
        return null;
    }
}
