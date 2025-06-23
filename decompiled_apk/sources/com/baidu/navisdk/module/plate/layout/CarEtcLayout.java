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
public class CarEtcLayout extends BNLinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private int f7396a;
    private TextView b;
    private TextView c;
    private View d;
    private List<TextView> e;

    public CarEtcLayout(Context context) {
        this(context, null);
    }

    private void initView() {
        this.e = new ArrayList(2);
        TextView textView = (TextView) findViewById(R.id.car_etc_install);
        this.b = textView;
        textView.setTag(1);
        TextView textView2 = this.b;
        int i = R.id.view_tag_first;
        textView2.setTag(i, 0);
        TextView textView3 = (TextView) findViewById(R.id.car_etc_uninstall);
        this.c = textView3;
        textView3.setTag(0);
        this.c.setTag(i, 1);
        this.d = findViewById(R.id.divider);
        this.e.add(this.b);
        this.e.add(this.c);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    public void a() {
        this.f7396a = -1;
        this.b.setSelected(false);
        this.c.setSelected(false);
    }

    public int getCurrentEtcType() {
        return this.f7396a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        int intValue2 = ((Integer) view.getTag(R.id.view_tag_first)).intValue();
        this.d.setVisibility(4);
        this.f7396a = intValue;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < this.e.size()) {
                TextView textView = this.e.get(i);
                if (i != intValue2) {
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

    public CarEtcLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarEtcLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7396a = -1;
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_car_etc, (ViewGroup) this, true);
        initView();
    }
}
