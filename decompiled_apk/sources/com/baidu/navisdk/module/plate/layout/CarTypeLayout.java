package com.baidu.navisdk.module.plate.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNLinearLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class CarTypeLayout extends BNLinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private int f7404a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private View f;
    private View g;
    private View h;
    private List<TextView> i;

    public CarTypeLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.i = new ArrayList(4);
        TextView textView = (TextView) findViewById(R.id.car_type_0);
        this.b = textView;
        textView.setTag(1);
        TextView textView2 = this.b;
        int i = R.id.view_tag_first;
        textView2.setTag(i, 0);
        TextView textView3 = (TextView) findViewById(R.id.car_type_pickup);
        this.e = textView3;
        textView3.setTag(4);
        this.e.setTag(i, 1);
        TextView textView4 = (TextView) findViewById(R.id.car_type_motor);
        this.d = textView4;
        textView4.setTag(2);
        this.d.setTag(i, 2);
        TextView textView5 = (TextView) findViewById(R.id.car_type_truck);
        this.c = textView5;
        textView5.setTag(3);
        this.c.setTag(i, 3);
        this.f = findViewById(R.id.divider_1);
        this.g = findViewById(R.id.divider_2);
        this.h = findViewById(R.id.divider_3);
        this.i.add(this.b);
        this.i.add(this.e);
        this.i.add(this.d);
        this.i.add(this.c);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    private void b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f.setVisibility(0);
                        this.g.setVisibility(0);
                        this.h.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                return;
            }
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            return;
        }
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
    }

    public int getCurrentCarType() {
        return this.f7404a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int intValue = ((Integer) view.getTag()).intValue();
        int intValue2 = ((Integer) view.getTag(R.id.view_tag_first)).intValue();
        b(intValue2);
        this.f7404a = intValue;
        for (int i = 0; i < this.i.size(); i++) {
            TextView textView = this.i.get(i);
            if (i == intValue2) {
                z = true;
            } else {
                z = false;
            }
            textView.setSelected(z);
        }
        com.baidu.navisdk.module.plate.controller.a.e().b(this.f7404a);
    }

    public CarTypeLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarTypeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_car_type, (ViewGroup) this, true);
        a(context);
    }

    public void a(int i) {
        this.f7404a = i;
        if (i == 1) {
            this.b.setSelected(true);
            this.c.setSelected(false);
            this.d.setSelected(false);
            this.e.setSelected(false);
            this.f.setVisibility(4);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            return;
        }
        if (i == 2) {
            this.b.setSelected(false);
            this.c.setSelected(false);
            this.d.setSelected(true);
            this.e.setSelected(false);
            this.f.setVisibility(0);
            this.g.setVisibility(4);
            this.h.setVisibility(4);
            return;
        }
        if (i == 3) {
            this.b.setSelected(false);
            this.c.setSelected(true);
            this.d.setSelected(false);
            this.e.setSelected(false);
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            this.h.setVisibility(4);
            return;
        }
        if (i != 4) {
            return;
        }
        this.b.setSelected(false);
        this.c.setSelected(false);
        this.d.setSelected(false);
        this.e.setSelected(true);
        this.f.setVisibility(4);
        this.g.setVisibility(4);
        this.h.setVisibility(0);
    }
}
