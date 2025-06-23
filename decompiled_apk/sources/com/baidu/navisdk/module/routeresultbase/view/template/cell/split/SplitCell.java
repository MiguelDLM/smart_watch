package com.baidu.navisdk.module.routeresultbase.view.template.cell.split;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class SplitCell extends BNRelativeLayout implements IRecyclerViewLifeCycle {
    public SplitCell(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void init(Context context) {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_split, this);
    }

    public SplitCell(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
