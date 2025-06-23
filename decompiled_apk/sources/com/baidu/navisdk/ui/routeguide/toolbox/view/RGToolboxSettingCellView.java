package com.baidu.navisdk.ui.routeguide.toolbox.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;

/* loaded from: classes8.dex */
public class RGToolboxSettingCellView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f9117a;
    private View b;
    private TextView c;
    private View d;

    public RGToolboxSettingCellView(Context context) {
        super(context);
        a();
    }

    private void a() {
        b.a(getContext(), R.layout.bnav_rg_tool_box_setting_cell_view, this);
        this.f9117a = (TextView) findViewById(R.id.bnav_rg_toolbox_cell_tv);
        this.b = findViewById(R.id.bnav_tg_toolbox_cell_new_tag);
        this.c = (TextView) findViewById(R.id.bnav_rg_toolbox_text_tag);
        this.d = findViewById(R.id.bnav_rg_toolbox_divider);
    }

    public RGToolboxSettingCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RGToolboxSettingCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void a(com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar) {
        if (aVar != null) {
            this.f9117a.setText(aVar.d());
            int e = aVar.e();
            if (e != 0) {
                b.a(this.f9117a, e);
            }
            b.a(this.f9117a, -1, aVar.a(), -1, -1);
            if (aVar.h()) {
                this.b.setVisibility(8);
                this.c.setVisibility(0);
                this.c.setText(aVar.c());
            } else {
                this.c.setVisibility(8);
                this.b.setVisibility(aVar.g() ? 0 : 8);
            }
            this.d.setVisibility(aVar.f() ? 0 : 8);
        }
    }
}
