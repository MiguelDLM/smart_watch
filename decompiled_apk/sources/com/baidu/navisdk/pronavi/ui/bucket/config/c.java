package com.baidu.navisdk.pronavi.ui.bucket.config;

import OXOo.OOXIXo;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class c implements a {
    @Override // com.baidu.navisdk.pronavi.ui.bucket.config.a
    @OOXIXo
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
        arrayList.add(new d(40, 100, 3, itemLocation2));
        arrayList.add(new d(41, 100, 4, itemLocation2));
        return arrayList;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.config.a
    @OOXIXo
    public ArrayList<d> b() {
        ArrayList<d> arrayList = new ArrayList<>();
        BNViewPriorityBucket.ItemLocation itemLocation = BNViewPriorityBucket.ItemLocation.START;
        arrayList.add(new d(37, 13, 1, itemLocation, 1));
        arrayList.add(new d(18, 5, 1, itemLocation));
        arrayList.add(new d(19, 6, 5, itemLocation, 1));
        BNViewPriorityBucket.ItemLocation itemLocation2 = BNViewPriorityBucket.ItemLocation.END;
        arrayList.add(new d(29, 10, 0, itemLocation2));
        arrayList.add(new d(24, 1, 3, itemLocation2));
        arrayList.add(new d(25, 1, 5, itemLocation2));
        arrayList.add(new d(26, 1, 6, itemLocation2));
        arrayList.add(new d(23, 1, 15, itemLocation2));
        arrayList.add(new d(16, 10, 25, itemLocation2));
        arrayList.add(new d(34, 1, 31, itemLocation2));
        arrayList.add(new d(33, 1, 32, itemLocation2));
        arrayList.add(new d(32, 1, 33, itemLocation2));
        arrayList.add(new d(31, 1, 34, itemLocation2));
        return arrayList;
    }
}
