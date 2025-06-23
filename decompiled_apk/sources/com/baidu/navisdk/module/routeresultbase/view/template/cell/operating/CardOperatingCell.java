package com.baidu.navisdk.module.routeresultbase.view.template.cell.operating;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class CardOperatingCell extends FrameLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f7558a;

    public CardOperatingCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_operating, this);
        this.f7558a = (ImageView) findViewById(R.id.background);
    }

    public CardOperatingCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
