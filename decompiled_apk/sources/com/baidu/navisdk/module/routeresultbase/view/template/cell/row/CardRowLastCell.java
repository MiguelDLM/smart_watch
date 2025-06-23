package com.baidu.navisdk.module.routeresultbase.view.template.cell.row;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class CardRowLastCell extends LinearLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7561a;

    public CardRowLastCell(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_row_last, this);
        setOrientation(1);
        this.f7561a = (TextView) findViewById(R.id.text);
    }

    public CardRowLastCell(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
