package com.baidu.navisdk.module.routeresultbase.view.template.cell.routedetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routeresultbase.view.support.module.routedetail.a;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;

/* loaded from: classes7.dex */
public class RouteDetailContentCell extends RelativeLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7559a;
    private TextView b;
    private View c;
    private View d;
    private ImageView e;
    private View f;
    private View g;

    public RouteDetailContentCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_detail_item_content_cell, this);
        b();
    }

    private void b() {
        this.f7559a = (TextView) findViewById(R.id.tv_road_info);
        this.b = (TextView) findViewById(R.id.tv_action);
        this.e = (ImageView) findViewById(R.id.icon);
        this.c = findViewById(R.id.connect_line_up);
        this.d = findViewById(R.id.connect_line_down);
        this.f = findViewById(R.id.bottom_divider);
        this.g = findViewById(R.id.route_result_content_view);
    }

    private void setData(@NonNull a aVar) {
        aVar.a();
        throw null;
    }

    public RouteDetailContentCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
