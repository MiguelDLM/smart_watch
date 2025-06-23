package com.baidu.navisdk.module.routeresultbase.view.template.cell.single;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routeresultbase.view.template.cell.row.RowButton;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class CardSingerCell extends RelativeLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7565a;
    private RowButton b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private LinearLayout g;
    private RelativeLayout h;
    private View i;
    private TextView j;

    public CardSingerCell(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_single, this);
        this.i = findViewById(R.id.single_card_layout);
        this.j = (TextView) findViewById(R.id.operating_text);
        this.f7565a = (TextView) findViewById(R.id.content_title);
        this.h = (RelativeLayout) findViewById(R.id.content_sub_container);
        this.g = (LinearLayout) findViewById(R.id.content_sub_text_items);
        this.b = (RowButton) findViewById(R.id.row_button);
        this.c = (TextView) findViewById(R.id.sub_title);
        this.d = (ImageView) findViewById(R.id.background);
        this.e = (ImageView) findViewById(R.id.left_image);
        this.f = (ImageView) findViewById(R.id.left_image_sub);
    }

    public CardSingerCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
