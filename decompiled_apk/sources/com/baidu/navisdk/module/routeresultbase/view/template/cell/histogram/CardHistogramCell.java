package com.baidu.navisdk.module.routeresultbase.view.template.cell.histogram;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class CardHistogramCell extends RelativeLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7555a;
    private ViewGroup b;
    private RelativeLayout c;
    private View d;

    public CardHistogramCell(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_histogram, this);
        new a(context);
        this.f7555a = (TextView) findViewById(R.id.tag_name);
        this.b = (ViewGroup) findViewById(R.id.items_container);
        this.d = findViewById(R.id.mid_line);
        this.c = (RelativeLayout) findViewById(R.id.y_text_layout);
    }

    public CardHistogramCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new ArrayList();
        a(context);
    }
}
