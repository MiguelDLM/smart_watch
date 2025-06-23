package com.baidu.navisdk.module.routeresultbase.view.template.cell.head;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class CardHeadCell extends RelativeLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f7554a;
    public TextView b;
    public TextView c;
    public TextView d;
    private CheckBox e;

    static {
        ScreenUtil.getInstance().dip2px(19);
        ScreenUtil.getInstance().dip2px(14);
    }

    public CardHeadCell(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_title, this);
        this.f7554a = (ImageView) findViewById(R.id.iv);
        this.b = (TextView) findViewById(R.id.tv);
        this.c = (TextView) findViewById(R.id.sub_tv);
        this.d = (TextView) findViewById(R.id.jump_btn);
        this.e = (CheckBox) findViewById(R.id.check_box);
        TextView textView = this.b;
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
            this.b.setPivotX(0.0f);
            this.b.setPivotY(ScreenUtil.getInstance().dip2px(13));
        }
    }

    public CardHeadCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
