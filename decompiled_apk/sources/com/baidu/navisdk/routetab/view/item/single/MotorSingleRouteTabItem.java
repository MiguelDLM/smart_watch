package com.baidu.navisdk.routetab.view.item.single;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* loaded from: classes7.dex */
public class MotorSingleRouteTabItem extends SingleRouteTabItem {
    public MotorSingleRouteTabItem(Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.routetab.view.item.single.SingleRouteTabItem, com.baidu.navisdk.routetab.view.item.RouteTabItem
    public String getTAG() {
        return "MotorSingleRouteTabItem";
    }

    public MotorSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotorSingleRouteTabItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
