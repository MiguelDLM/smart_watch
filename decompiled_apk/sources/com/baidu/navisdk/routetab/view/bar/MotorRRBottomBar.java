package com.baidu.navisdk.routetab.view.bar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.routetab.view.bar.AbsRRBottomBar;

/* loaded from: classes7.dex */
public class MotorRRBottomBar extends AbsRRBottomBar {
    private View b;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbsRRBottomBar.b bVar = MotorRRBottomBar.this.f7976a;
            if (bVar != null) {
                bVar.a((AbsRRBottomBar.a) view.getTag());
            }
        }
    }

    public MotorRRBottomBar(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_motor_route_result_bottom_bar, this);
    }

    public MotorRRBottomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a() {
        View findViewById = findViewById(R.id.motor_to_pro_guide);
        this.b = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new a());
            this.b.setTag(AbsRRBottomBar.a.TO_PRO_NAV);
        }
    }

    public MotorRRBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
