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
public class TruckTypeLayout extends BNLinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7422a;
    private TextView b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private List<TextView> h;

    public TruckTypeLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.h = new ArrayList(4);
        TextView textView = (TextView) findViewById(R.id.truck_type_miniature);
        this.f7422a = textView;
        textView.setTag(1);
        TextView textView2 = this.f7422a;
        int i = R.id.view_tag_first;
        textView2.setTag(i, 0);
        TextView textView3 = (TextView) findViewById(R.id.truck_type_light);
        this.b = textView3;
        textView3.setTag(2);
        this.b.setTag(i, 1);
        TextView textView4 = (TextView) findViewById(R.id.truck_type_medium);
        this.c = textView4;
        textView4.setTag(3);
        this.c.setTag(i, 2);
        TextView textView5 = (TextView) findViewById(R.id.truck_type_heavy);
        this.d = textView5;
        textView5.setTag(4);
        this.d.setTag(i, 3);
        this.e = findViewById(R.id.divider_1);
        this.f = findViewById(R.id.divider_2);
        this.g = findViewById(R.id.divider_3);
        a();
        this.h.add(this.f7422a);
        this.h.add(this.b);
        this.h.add(this.c);
        this.h.add(this.d);
        this.f7422a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    public int getTruckType() {
        for (int i = 0; i < this.h.size(); i++) {
            TextView textView = this.h.get(i);
            if (textView != null && textView.isSelected() && (textView.getTag() instanceof Integer)) {
                return ((Integer) textView.getTag()).intValue();
            }
        }
        return 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((Integer) view.getTag()).intValue();
        int intValue = ((Integer) view.getTag(R.id.view_tag_first)).intValue();
        a(intValue);
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < this.h.size()) {
                TextView textView = this.h.get(i);
                if (i != intValue) {
                    z = false;
                }
                textView.setSelected(z);
                i++;
            } else {
                com.baidu.navisdk.module.plate.controller.a.e().a(true);
                return;
            }
        }
    }

    public TruckTypeLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TruckTypeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_truck_type, (ViewGroup) this, true);
        a(context);
    }

    public void a() {
        this.f7422a.setSelected(false);
        this.b.setSelected(false);
        this.c.setSelected(false);
        this.d.setSelected(false);
    }

    private void a(int i) {
        if (i == 0) {
            this.e.setVisibility(4);
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            return;
        }
        if (i == 1) {
            this.e.setVisibility(4);
            this.f.setVisibility(4);
            this.g.setVisibility(0);
        } else if (i == 2) {
            this.e.setVisibility(0);
            this.f.setVisibility(4);
            this.g.setVisibility(4);
        } else {
            if (i != 3) {
                return;
            }
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.g.setVisibility(4);
        }
    }
}
