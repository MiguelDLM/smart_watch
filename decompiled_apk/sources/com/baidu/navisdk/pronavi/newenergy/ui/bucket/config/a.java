package com.baidu.navisdk.pronavi.newenergy.ui.bucket.config;

import OXOo.OOXIXo;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.pronavi.ui.bucket.config.b {
    @Override // com.baidu.navisdk.pronavi.ui.bucket.config.b, com.baidu.navisdk.pronavi.ui.bucket.config.a
    @OOXIXo
    public ArrayList<d> a() {
        ArrayList<d> leftBucketItemList = super.a();
        leftBucketItemList.add(new d(35, 1, 3, BNViewPriorityBucket.ItemLocation.END).a(8));
        IIX0o.oO(leftBucketItemList, "leftBucketItemList");
        return leftBucketItemList;
    }
}
