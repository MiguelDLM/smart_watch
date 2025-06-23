package com.realsil.sdk.dfu.b;

import com.realsil.sdk.dfu.image.BinIndicator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes11.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<BinIndicator> f19531a;

    static {
        ArrayList<BinIndicator> arrayList = new ArrayList<>();
        f19531a = arrayList;
        arrayList.add(new BinIndicator(0, "Patch (Both MP and OTA)", null, -1, true, 7));
        arrayList.add(new BinIndicator(1, "App bank 0 image (Both MP and OTA)", null, -1, true, 7));
        arrayList.add(new BinIndicator(2, "APP bank 1 image (OTA)", null, -1, true, 7));
        arrayList.add(new BinIndicator(3, "User data (MP)", null, -1, true, 7));
        arrayList.add(new BinIndicator(4, "Patch extension image (Both MP and OTA)", null, -1, true, 7));
        arrayList.add(new BinIndicator(5, "Config file (MP)", null, -1, true, 7));
        arrayList.add(new BinIndicator(6, "External Flash (MP)", null, -1, true, 7));
    }

    public static BinIndicator a(int i) {
        Iterator<BinIndicator> it = f19531a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.bitNumber == i) {
                return next;
            }
        }
        return null;
    }

    public static BinIndicator b(int i) {
        Iterator<BinIndicator> it = f19531a.iterator();
        while (it.hasNext()) {
            BinIndicator next = it.next();
            if (next.imageId == i) {
                return next;
            }
        }
        return null;
    }
}
