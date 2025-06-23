package com.baidu.navisdk.pronavi.newenergy.ui.bucket.config;

import OXOo.OOXIXo;
import com.baidu.navisdk.pronavi.ui.bucket.config.c;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class b extends c {
    @Override // com.baidu.navisdk.pronavi.ui.bucket.config.c, com.baidu.navisdk.pronavi.ui.bucket.config.a
    @OOXIXo
    public ArrayList<d> b() {
        ArrayList<d> b = super.b();
        b.add(new d(35, 1, 4, BNViewPriorityBucket.ItemLocation.END));
        return b;
    }
}
