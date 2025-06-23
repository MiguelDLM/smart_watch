package com.baidu.navisdk.ugc.report.ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.report.ui.d;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class d extends c implements View.OnClickListener {
    private d.c B;
    private Context d;
    private int e;
    private int f;
    private TextView g;
    private LinearLayout h;
    private View i;
    private com.baidu.navisdk.ugc.report.ui.a j;
    private int k;
    private int l;
    private int m;
    private int n;
    private ArrayList<TextView> p;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> q;
    private int r;
    private int s;
    private int t;
    private float o = 26.0f;
    private int u = ScreenUtil.getInstance().dip2px(0.5f);
    private int v = ScreenUtil.getInstance().dip2px(3);
    private int w = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_a, true);
    private int x = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_link_ugc_a, true);
    private int y = com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_d, true);
    private boolean z = false;
    private boolean A = false;

    public d(Context context, com.baidu.navisdk.ugc.report.ui.a aVar, int i, d.c cVar, int i2, int i3) {
        this.d = context;
        this.j = aVar;
        this.e = i;
        this.B = cVar;
        this.k = i3;
        g();
    }

    private void b(View view) {
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList;
        if (this.z || (arrayList = this.q) == null || arrayList.size() == 0) {
            return;
        }
        this.g = (TextView) view.findViewById(R.id.ugc_sub_lane_tv);
        this.h = (LinearLayout) view.findViewById(R.id.ugc_report_sub_item_content);
        this.i = view.findViewById(R.id.ugc_sub_detail_falg_tv);
        b(this.A);
        this.p = new ArrayList<>();
        this.o = ScreenUtil.getInstance().dip2px(13.0f);
        if (this.k == 1) {
            this.n = ScreenUtil.getInstance().dip2px(36);
        } else {
            this.n = ScreenUtil.getInstance().dip2px(34);
        }
        if (this.l != 0) {
            h();
        }
    }

    private int c(int i) {
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList;
        if (i > 0 && (arrayList = this.q) != null && !arrayList.isEmpty()) {
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                com.baidu.navisdk.ugc.report.data.datarepository.b bVar = this.q.get(i2);
                if (bVar != null && bVar.b == i) {
                    return i2;
                }
            }
        }
        return -1;
    }

    private LinearLayout d(int i) {
        int i2;
        boolean z;
        LinearLayout linearLayout = new LinearLayout(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (i != this.t - 1) {
            layoutParams.bottomMargin = ScreenUtil.getInstance().dip2px(5);
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        int i3 = this.t - 1;
        if (i == i3) {
            i2 = this.r - (this.s * i3);
        } else {
            i2 = this.s;
        }
        if (i2 == 0) {
            return null;
        }
        int i4 = i2 - 1;
        this.m = (int) ((this.l - (i4 * this.o)) / i2);
        for (int i5 = 0; i5 < i2; i5++) {
            if (i5 == i4) {
                z = true;
            } else {
                z = false;
            }
            TextView a2 = a(this.m, this.n, z);
            a2.setText(this.q.get((i * i2) + i5).f8246a);
            this.p.add(a2);
            linearLayout.addView(a2);
        }
        return linearLayout;
    }

    private void e(int i) {
        int i2 = 0;
        while (true) {
            ArrayList<TextView> arrayList = this.p;
            if (arrayList != null && i2 < arrayList.size()) {
                if (i2 == i) {
                    this.p.get(i2).setBackgroundDrawable(a(true));
                    this.p.get(i2).setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_link_ugc_a, true));
                    this.p.get(i2).setTag(new Object());
                } else {
                    this.p.get(i2).setBackgroundDrawable(a(false));
                    this.p.get(i2).setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_ugc_a, true));
                    this.p.get(i2).setTag(null);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void g() {
        if (this.k == 1) {
            this.l -= JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_15dp) * 2;
        } else {
            this.l -= JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_25dp) * 2;
        }
    }

    private void h() {
        LinearLayout linearLayout;
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = this.q;
        if (arrayList != null && arrayList.size() != 0) {
            int size = this.q.size();
            this.r = size;
            if (size % 3 == 1) {
                this.s = 4;
            } else {
                this.s = 3;
            }
            this.t = (size / (this.s + 1)) + 1;
            LinearLayout linearLayout2 = this.h;
            if (linearLayout2 != null) {
                linearLayout2.removeAllViews();
            }
            for (int i = 0; i < this.t; i++) {
                LinearLayout d = d(i);
                if (d != null && (linearLayout = this.h) != null) {
                    linearLayout.addView(d);
                }
            }
        }
    }

    private void i() {
        com.baidu.navisdk.ugc.report.ui.a aVar = this.j;
        if (aVar != null) {
            switch (this.e) {
                case 2000:
                    this.q = aVar.l();
                    break;
                case 2001:
                    this.q = aVar.f();
                    break;
                case 2002:
                    this.q = aVar.g();
                    break;
            }
            this.f = this.j.p();
            this.A = false;
        }
    }

    private void j() {
        TextView textView = this.g;
        if (textView == null) {
            return;
        }
        switch (this.e) {
            case 2000:
                textView.setText("车道信息");
                return;
            case 2001:
                int i = this.f;
                if (i == 46) {
                    textView.setText("错误原因");
                    return;
                } else if (i == 15) {
                    textView.setText("正确限速");
                    return;
                } else {
                    textView.setText("问题详情");
                    return;
                }
            case 2002:
                textView.setText("事件详情");
                return;
            default:
                return;
        }
    }

    private void k() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        com.baidu.navisdk.ugc.report.ui.a aVar;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
        if (aVar2 == null && (aVar = this.j) != null) {
            aVar2 = aVar.c();
        }
        if (aVar2 != null) {
            i = aVar2.X;
            i2 = aVar2.Z;
            i3 = aVar2.Y;
            if (i == -1 && (i5 = aVar2.E) > 0) {
                i = c(i5);
            }
            if (i3 == -1 && (i4 = aVar2.G) > 0) {
                i3 = c(i4);
            }
        } else {
            i = -1;
            i2 = -1;
            i3 = -1;
        }
        switch (this.e) {
            case 2000:
                if (i != -1) {
                    e(i);
                    this.B.a(i, this.e);
                    return;
                }
                return;
            case 2001:
                if (i2 != -1) {
                    e(i2);
                    this.B.a(i2, this.e);
                    return;
                }
                return;
            case 2002:
                if (i3 != -1) {
                    e(i3);
                    this.B.a(i3, this.e);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.c
    public void a(View view) {
        i();
        b(view);
        j();
        k();
        this.z = true;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.c
    public int f() {
        if (this.k == 1) {
            return R.layout.nsdk_layout_ugc_report_sub_detail_content_item_view;
        }
        return R.layout.nsdk_layout_ugc_report_sub_detail_content_item_view_land;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView = (TextView) view;
        int i = 0;
        while (true) {
            ArrayList<TextView> arrayList = this.p;
            if (arrayList != null && i < arrayList.size()) {
                if (this.p.get(i).equals(textView)) {
                    if (this.p.get(i).getTag() == null) {
                        this.p.get(i).setBackgroundDrawable(a(true));
                        this.p.get(i).setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_link_ugc_a, true));
                        this.B.a(i, this.e);
                        this.p.get(i).setTag(new Object());
                    } else {
                        this.p.get(i).setBackgroundDrawable(a(false));
                        this.p.get(i).setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_ugc_a, true));
                        this.B.a(-1, this.e);
                        this.p.get(i).setTag(null);
                    }
                } else {
                    this.p.get(i).setBackgroundDrawable(a(false));
                    this.p.get(i).setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_ugc_a, true));
                    this.p.get(i).setTag(null);
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void a(Configuration configuration) {
        k();
    }

    private TextView a(int i, int i2, boolean z) {
        TextView textView = new TextView(this.d);
        textView.setTextSize(0, ScreenUtil.getInstance().dip2px(14));
        textView.setBackgroundDrawable(a(false));
        textView.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_ugc_a, true));
        textView.setGravity(17);
        textView.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        if (!z) {
            layoutParams.rightMargin = (int) this.o;
        }
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private void b(boolean z) {
        View view = this.i;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    private GradientDrawable a(boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.v);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor(this.y);
        if (z) {
            gradientDrawable.setStroke(this.u, this.x);
        } else {
            gradientDrawable.setStroke(this.u, this.w);
        }
        return gradientDrawable;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void b(int i) {
        if (i == 0 || i != this.l) {
            this.z = false;
            this.l = i;
            g();
        }
    }
}
