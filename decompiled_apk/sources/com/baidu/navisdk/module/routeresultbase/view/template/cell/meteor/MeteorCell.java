package com.baidu.navisdk.module.routeresultbase.view.template.cell.meteor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.recyclerview.structure.view.IRecyclerViewLifeCycle;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class MeteorCell extends RelativeLayout implements IRecyclerViewLifeCycle {

    /* renamed from: a, reason: collision with root package name */
    private View f7557a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private View h;
    private TextView i;
    private LinearLayout j;

    public MeteorCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new ArrayList();
        new ArrayList();
        a();
    }

    private void a() {
        View.inflate(getContext(), R.layout.nsdk_layout_route_result_card_cell_meteor, this);
        this.f7557a = findViewById(R.id.extreme_weather);
        this.b = (ImageView) findViewById(R.id.extreme_weather_icon);
        this.c = (TextView) findViewById(R.id.extreme_weather_high_temp);
        this.d = (TextView) findViewById(R.id.extreme_weather_low_temp);
        this.e = (TextView) findViewById(R.id.extreme_weather_eta_time);
        this.f = (TextView) findViewById(R.id.extreme_weather_city_name);
        this.h = findViewById(R.id.dest_weather_split_line);
        this.i = (TextView) findViewById(R.id.dest_weather_title);
        this.j = (LinearLayout) findViewById(R.id.dest_daily_weathers);
        this.g = findViewById(R.id.extreme_weather_split_line);
    }

    public MeteorCell(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new ArrayList();
        new ArrayList();
        a();
    }
}
