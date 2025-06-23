package com.baidu.navisdk.module.routeresultbase.view.template.cell.row;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routeresultbase.view.panel.bottom.a;
import com.baidu.navisdk.ui.widget.recyclerview.structure.BaseCell;

/* loaded from: classes7.dex */
public class CardRowRightCell2 extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f7563a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private RowButton f;
    private LinearLayout g;

    public CardRowRightCell2(Context context) {
        this(context, null);
    }

    private void a() {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_row_right2, this);
        this.f7563a = findViewById(R.id.right_area_style2_container);
        this.d = (ImageView) findViewById(R.id.left_image);
        this.e = (ImageView) findViewById(R.id.left_image_sub);
        this.b = (TextView) findViewById(R.id.content_title);
        this.g = (LinearLayout) findViewById(R.id.content_sub_text_items);
        this.f = (RowButton) findViewById(R.id.row_button);
        this.c = (TextView) findViewById(R.id.sub_title);
    }

    public void setResourceColor(BaseCell baseCell) {
        a aVar = (a) baseCell.serviceManager.getService(a.class);
        if (aVar != null && aVar.a() == 1) {
            getContext().getResources().getColor(R.color.nsdk_route_result_idss_green);
        } else {
            getContext().getResources().getColor(R.color.nsdk_route_result_idss_blue);
        }
    }

    public CardRowRightCell2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CardRowRightCell2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
