package com.baidu.navisdk.module.routeresultbase.view.template.cell.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class CardButtonCell extends RelativeLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7553a;
    private ImageView b;
    private ImageView c;

    public CardButtonCell(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.nsdk_layout_route_result_card_cell_button, this);
        setBackgroundResource(R.drawable.bnav_route_result_dynamic_card_button_bg);
        this.f7553a = (TextView) findViewById(R.id.button);
        this.b = (ImageView) findViewById(R.id.arrow);
        this.c = (ImageView) findViewById(R.id.left_icon);
    }

    public CardButtonCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
