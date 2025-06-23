package com.baidu.navisdk.module.routeresultbase.view.support.module.level;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.ui.widget.BNRelativeLayout;
import com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin;

/* loaded from: classes7.dex */
public class BNRRLevelView extends BNRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7523a;
    private TextView b;
    private TextView c;
    private View d;

    /* loaded from: classes7.dex */
    public class a implements BNScaleLevelViewPlugin.SwitchModeCallback {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNScaleLevelViewPlugin.SwitchModeCallback
        public void switchMode(int i) {
            BNRRLevelView.this.a(i);
        }
    }

    public BNRRLevelView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_route_result_level_view, (ViewGroup) this, true);
        this.f7523a = (TextView) findViewById(R.id.level_tv);
        this.b = (TextView) findViewById(R.id.level_bg);
        this.c = (TextView) findViewById(R.id.level_drawable);
        this.d = findViewById(R.id.baidu_map_logo);
        new BNScaleLevelViewPlugin(new a());
    }

    public void setCallback(com.baidu.navisdk.module.routeresultbase.view.support.module.level.a aVar) {
    }

    @Override // com.baidu.navisdk.ui.widget.BNRelativeLayout, android.view.View
    public void setVisibility(int i) {
        if (i == 0 && !b.G()) {
            setVisibility(8);
        } else {
            super.setVisibility(i);
        }
    }

    public BNRRLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        View view;
        TextView textView = this.b;
        if (textView == null || this.c == null || this.f7523a == null || (view = this.d) == null) {
            return;
        }
        if (i == 1) {
            textView.setVisibility(4);
            this.c.setVisibility(4);
            this.f7523a.setVisibility(4);
            this.d.setVisibility(0);
            return;
        }
        view.setVisibility(4);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        this.f7523a.setVisibility(0);
    }

    public BNRRLevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
