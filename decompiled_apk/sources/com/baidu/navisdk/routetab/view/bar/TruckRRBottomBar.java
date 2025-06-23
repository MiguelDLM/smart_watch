package com.baidu.navisdk.routetab.view.bar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.routetab.view.bar.AbsRRBottomBar;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes7.dex */
public class TruckRRBottomBar extends AbsRRBottomBar {
    private TextView b;
    private TextView c;
    private TextView d;
    private View e;
    private View f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.navisdk.routetab.view.bar.TruckRRBottomBar$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0363a implements com.baidu.navisdk.framework.interfaces.account.a {
            public C0363a(a aVar) {
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.navisdk.framework.b.e0()) {
                TruckRRBottomBar.this.b();
            } else {
                com.baidu.navisdk.framework.b.a((com.baidu.navisdk.framework.interfaces.account.a) new C0363a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbsRRBottomBar.b bVar = TruckRRBottomBar.this.f7976a;
            if (bVar != null) {
                bVar.a((AbsRRBottomBar.a) view.getTag());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f7981a;

        public c(View.OnClickListener onClickListener) {
            this.f7981a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e("TruckRRBottomBar", "truck bottom bar go to click challenge");
            }
            View.OnClickListener onClickListener = this.f7981a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public TruckRRBottomBar(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        RoutePlanNode o;
        int i;
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e("TruckRRBottomBar", "truck bottom bar go to community");
        }
        f h = BNRoutePlaner.getInstance().h();
        RoutePlanNode routePlanNode = null;
        if (h == null) {
            o = null;
        } else {
            o = h.o();
        }
        if (h != null) {
            routePlanNode = h.g();
        }
        int i2 = 0;
        if (o != null) {
            i = o.getDistrictID();
        } else {
            i = 0;
        }
        if (routePlanNode != null) {
            i2 = routePlanNode.getDistrictID();
        }
        String str = com.baidu.navisdk.module.cloudconfig.f.c().F.c;
        if (TextUtils.isEmpty(str)) {
            str = "baidumap://map/mnp?popRoot=no&url=mapmnp://swan/VP6yPRNNLI3fnfAtmKdGbmcAougGMrzd/pages/chat/chat?nl=1&_baiduboxapp={\"from\":\"\",\"ext\":{}}&src=sug";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(URLEncoder.encode("&startCityId=" + i + "&endCityId=" + i2, "UTF-8"));
            com.baidu.navisdk.framework.b.a(sb.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e("TruckRRBottomBar", "truck bottom bar go to two button ui");
        }
        this.d.setVisibility(8);
        this.c.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.nsdk_truck_to_challenge_mode_bg_selector, null));
        this.c.setTextColor(getResources().getColor(R.color.nsdk_truck_to_challenge_mode_btn_text_selector));
        this.c.setGravity(16);
        this.c.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.drawable.bnav_drawable_start_challenge_mode, null), (Drawable) null, (Drawable) null, (Drawable) null);
        this.c.setIncludeFontPadding(false);
        this.c.setWidth(ScreenUtil.getInstance().dip2px(120));
        this.c.setHeight(ScreenUtil.getInstance().dip2px(36));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.c.getLayoutParams());
        layoutParams.addRule(0, this.e.getId());
        layoutParams.addRule(9);
        layoutParams.addRule(4, this.b.getId());
        layoutParams.leftMargin = ScreenUtil.getInstance().dip2px(10);
        this.c.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams2.width = ScreenUtil.getInstance().dip2px(150);
        layoutParams2.addRule(1, this.e.getId());
        this.b.setLayoutParams(layoutParams2);
    }

    public void setStartChallengeModeBtnContainerVisibility(int i) {
        View view = this.f;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public TruckRRBottomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_truck_route_result_bottom_bar, this);
    }

    public TruckRRBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a() {
        this.b = (TextView) findViewById(R.id.truck_to_pro_guide);
        this.c = (TextView) findViewById(R.id.truck_to_challenge);
        this.d = (TextView) findViewById(R.id.truck_communicate);
        this.e = findViewById(R.id.mid_support_view);
        if (!com.baidu.navisdk.module.cloudconfig.f.c().F.f7129a) {
            c();
        }
        this.d.setText(com.baidu.navisdk.module.cloudconfig.f.c().F.b);
        this.d.setOnClickListener(new a());
        b bVar = new b();
        TextView textView = this.c;
        if (textView != null) {
            textView.setTag(AbsRRBottomBar.a.TO_EDOG_CHALLENGE);
            this.c.setOnClickListener(new c(bVar));
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setTag(AbsRRBottomBar.a.TO_PRO_NAV);
            this.b.setOnClickListener(bVar);
        }
    }
}
