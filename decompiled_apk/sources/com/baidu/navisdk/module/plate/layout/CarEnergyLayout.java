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
public class CarEnergyLayout extends BNLinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7395a;
    private TextView b;
    private TextView c;
    private View d;
    private View e;
    private List<TextView> f;

    public CarEnergyLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.f = new ArrayList(3);
        TextView textView = (TextView) findViewById(R.id.energy_type_oil);
        this.f7395a = textView;
        textView.setTag(0);
        TextView textView2 = this.f7395a;
        int i = R.id.view_tag_first;
        textView2.setTag(i, 0);
        TextView textView3 = (TextView) findViewById(R.id.energy_type_electric);
        this.b = textView3;
        textView3.setTag(1);
        this.b.setTag(i, 1);
        TextView textView4 = (TextView) findViewById(R.id.energy_type_hybrid);
        this.c = textView4;
        textView4.setTag(2);
        this.c.setTag(i, 2);
        this.d = findViewById(R.id.divider_1);
        this.e = findViewById(R.id.divider_2);
        a();
        this.f.add(this.f7395a);
        this.f.add(this.b);
        this.f.add(this.c);
        this.f7395a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    public int getEnergyType() {
        for (int i = 0; i < this.f.size(); i++) {
            TextView textView = this.f.get(i);
            if (textView != null && textView.isSelected() && (textView.getTag() instanceof Integer)) {
                return ((Integer) textView.getTag()).intValue();
            }
        }
        return -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ((Integer) view.getTag()).intValue();
        int intValue = ((Integer) view.getTag(R.id.view_tag_first)).intValue();
        a(intValue);
        for (int i = 0; i < this.f.size(); i++) {
            TextView textView = this.f.get(i);
            if (i == intValue) {
                z = true;
            } else {
                z = false;
            }
            textView.setSelected(z);
        }
    }

    public CarEnergyLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarEnergyLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_car_energy, (ViewGroup) this, true);
        a(context);
    }

    public void a() {
        this.f7395a.setSelected(true);
        this.b.setSelected(false);
        this.c.setSelected(false);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
    }

    private void a(int i) {
        if (i == 0) {
            this.d.setVisibility(4);
            this.e.setVisibility(0);
        } else if (i == 1) {
            this.d.setVisibility(4);
            this.e.setVisibility(4);
        } else {
            if (i != 2) {
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(4);
        }
    }
}
