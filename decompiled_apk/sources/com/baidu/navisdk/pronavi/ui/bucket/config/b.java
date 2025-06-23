package com.baidu.navisdk.pronavi.ui.bucket.config;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class b implements a {
    @Override // com.baidu.navisdk.pronavi.ui.bucket.config.a
    public ArrayList<d> a() {
        ArrayList<d> arrayList = new ArrayList<>();
        BNViewPriorityBucket.ItemLocation itemLocation = BNViewPriorityBucket.ItemLocation.START;
        arrayList.add(new d(1, 2, 1, itemLocation));
        arrayList.add(new d(27, 11, 2, itemLocation));
        arrayList.add(new d(2, 3, 5, itemLocation));
        arrayList.add(new d(38, 3, 7, itemLocation));
        arrayList.add(new d(42, 3, 9, itemLocation));
        arrayList.add(new d(3, 4, 10, itemLocation));
        arrayList.add(new d(43, 4, 11, itemLocation));
        BNViewPriorityBucket.ItemLocation itemLocation2 = BNViewPriorityBucket.ItemLocation.END;
        arrayList.add(new d(28, 10, 0, itemLocation2));
        arrayList.add(new d(36, 1, 6, itemLocation2, 2));
        arrayList.add(new d(39, 1, 6, itemLocation2, 2));
        arrayList.add(new d(8, 1, 15, itemLocation2).b(0));
        arrayList.add(new d(7, 1, 20, itemLocation2).b(10));
        arrayList.add(new d(4, 1, 25, itemLocation2).b(12));
        arrayList.add(new d(5, 1, 30, itemLocation2).b(13));
        arrayList.add(new d(10, 1, 35, itemLocation2).b(6));
        return arrayList;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.config.a
    public ArrayList<d> b() {
        ArrayList<d> arrayList = new ArrayList<>();
        BNViewPriorityBucket.ItemLocation itemLocation = BNViewPriorityBucket.ItemLocation.START;
        arrayList.add(new d(37, 13, 1, itemLocation, 1));
        arrayList.add(new d(18, 5, 3, itemLocation));
        arrayList.add(new d(19, 6, 5, itemLocation, 1));
        arrayList.add(new d(11, 1, 10, itemLocation));
        arrayList.add(new d(12, 1, 15, itemLocation));
        BNViewPriorityBucket.ItemLocation itemLocation2 = BNViewPriorityBucket.ItemLocation.END;
        arrayList.add(new d(29, 10, 0, itemLocation2));
        arrayList.add(new d(25, 1, 1, itemLocation2));
        arrayList.add(new d(26, 1, 2, itemLocation2));
        arrayList.add(new d(24, 1, 3, itemLocation2));
        arrayList.add(new d(36, 1, 6, itemLocation2, 1));
        arrayList.add(new d(39, 1, 6, itemLocation2, 1));
        arrayList.add(new d(22, 1, 10, itemLocation2));
        arrayList.add(new d(23, 1, 15, itemLocation2));
        arrayList.add(new d(21, 1, 20, itemLocation2));
        if (j.d() || BNSettingManager.isZoomButtonVisible()) {
            arrayList.add(new d(16, 10, 25, itemLocation2));
        }
        arrayList.add(new d(14, 10, 28, itemLocation2));
        arrayList.add(new d(15, 1, 30, itemLocation2));
        arrayList.add(new d(34, 1, 31, itemLocation2));
        arrayList.add(new d(33, 1, 32, itemLocation2));
        arrayList.add(new d(32, 1, 33, itemLocation2));
        arrayList.add(new d(31, 1, 34, itemLocation2));
        return arrayList;
    }
}
