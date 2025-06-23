package com.baidu.navisdk.module.routeresultbase.view.template.cell.viapoint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class ViaPointBottomCell extends RelativeLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7566a;
    private TextView b;
    private TextView c;
    private View d;

    public ViaPointBottomCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.nsdk_layout_route_result_card_cell_via_point_bottom, this);
        this.f7566a = (TextView) findViewById(R.id.left_button);
        this.b = (TextView) findViewById(R.id.count_text);
        this.d = findViewById(R.id.right_button);
        this.c = (TextView) findViewById(R.id.right_button_text);
    }

    public ViaPointBottomCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
