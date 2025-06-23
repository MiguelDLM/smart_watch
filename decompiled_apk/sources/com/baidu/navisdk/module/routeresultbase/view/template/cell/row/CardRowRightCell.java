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
public class CardRowRightCell extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f7562a;
    private View b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private RowButton f;
    private LinearLayout g;

    public CardRowRightCell(Context context) {
        this(context, null);
    }

    private void a() {
        View inflate = View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_row_right, this);
        this.f7562a = inflate;
        this.b = inflate.findViewById(R.id.right_area_container);
        this.e = (ImageView) findViewById(R.id.left_image);
        this.c = (TextView) findViewById(R.id.content_title);
        this.g = (LinearLayout) findViewById(R.id.content_sub_text_items);
        this.f = (RowButton) findViewById(R.id.row_button);
        this.d = (TextView) findViewById(R.id.sub_title);
    }

    public void setResourceColor(BaseCell baseCell) {
        a aVar = (a) baseCell.serviceManager.getService(a.class);
        if (aVar != null && aVar.a() == 1) {
            getContext().getResources().getColor(R.color.nsdk_route_result_idss_green);
        } else {
            getContext().getResources().getColor(R.color.nsdk_route_result_idss_blue);
        }
    }

    public CardRowRightCell(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CardRowRightCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
