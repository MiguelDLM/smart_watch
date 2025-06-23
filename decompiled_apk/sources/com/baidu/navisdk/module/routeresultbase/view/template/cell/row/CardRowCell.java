package com.baidu.navisdk.module.routeresultbase.view.template.cell.row;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class CardRowCell extends LinearLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7560a;
    private TextView b;
    private View c;
    private ImageView d;
    private CardRowRightCell e;
    private CardRowRightCell2 f;

    public CardRowCell(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_row, this);
        setOrientation(0);
        this.c = findViewById(R.id.left_area);
        this.f7560a = (TextView) findViewById(R.id.head_title);
        this.d = (ImageView) findViewById(R.id.head_image);
        this.b = (TextView) findViewById(R.id.head_sub_title);
        this.e = (CardRowRightCell) findViewById(R.id.right_area);
        this.f = (CardRowRightCell2) findViewById(R.id.right_area_style2);
    }

    public CardRowCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
