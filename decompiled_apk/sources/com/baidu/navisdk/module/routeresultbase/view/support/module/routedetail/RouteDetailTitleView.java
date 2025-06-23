package com.baidu.navisdk.module.routeresultbase.view.support.module.routedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class RouteDetailTitleView extends RelativeLayout implements IRecyclerViewLifeCycle {
    public RouteDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_detail_item_head, this);
    }

    public RouteDetailTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
