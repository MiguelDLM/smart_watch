package com.baidu.navisdk.module.routeresultbase.view.template.cell.meteor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class DailyWeatherItem extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7556a;
    private TextView b;
    private ImageView c;
    private TextView d;

    public DailyWeatherItem(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.nsdk_layout_route_result_card_cell_future_weather_item, this);
        setOrientation(1);
        a();
    }

    public DailyWeatherItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a() {
        this.f7556a = (TextView) findViewById(R.id.weather_day_of_the_week);
        this.b = (TextView) findViewById(R.id.weather_date);
        this.c = (ImageView) findViewById(R.id.weather_icon);
        this.d = (TextView) findViewById(R.id.weather_temperature);
    }
}
