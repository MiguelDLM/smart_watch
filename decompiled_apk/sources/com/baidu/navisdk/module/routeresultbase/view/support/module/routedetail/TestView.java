package com.baidu.navisdk.module.routeresultbase.view.support.module.routedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class TestView extends FrameLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7542a;

    public TestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        View.inflate(getContext(), R.layout.nsdk_layout_rr_recycler_view_item_test, this);
        this.f7542a = (TextView) findViewById(R.id.title);
    }

    public TestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
