package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MyListView extends ListView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public MyListView(@OXOo.OOXIXo Context context, @OXOo.OOXIXo AttributeSet attrs) {
        super(context, attrs);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(attrs, "attrs");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
