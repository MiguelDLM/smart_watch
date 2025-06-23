package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.adapter.IBNRouteResultManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public class p0 extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private ViewGroup i;
    private ViewGroup j;
    private ViewGroup k;
    private TextView l;
    private ViewGroup m;
    private View n;
    private View o;
    private View p;
    private View q;
    private View r;
    private View s;
    private View t;
    private final int[] u;
    private final int[] v;
    private final int[] w;
    private final int[] x;
    private final int[] y;
    private final int[] z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (((com.baidu.navisdk.ui.routeguide.widget.d) p0.this).c != null && view != null) {
                if (view == p0.this.i) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().t1();
                    return;
                }
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                if (!com.baidu.navisdk.module.international.a.a(((com.baidu.navisdk.ui.routeguide.widget.d) p0.this).f9165a)) {
                    if (view == p0.this.n) {
                        str = IBNRouteResultManager.NearbySearchKeyword.Gas_Station;
                    } else if (view == p0.this.o) {
                        str = IBNRouteResultManager.NearbySearchKeyword.Toilet;
                    } else if (view == p0.this.p) {
                        str = IBNRouteResultManager.NearbySearchKeyword.Bank;
                    } else if (view == p0.this.q) {
                        str = IBNRouteResultManager.NearbySearchKeyword.Spots;
                    } else if (view == p0.this.r) {
                        str = IBNRouteResultManager.NearbySearchKeyword.Charging_Station;
                    } else if (view != p0.this.s) {
                        str = "";
                    } else {
                        str = IBNRouteResultManager.NearbySearchKeyword.Hotel;
                    }
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3", com.baidu.navisdk.poisearch.e.c(str), null, "1");
                    arrayList.add(com.baidu.navisdk.util.common.e0.a(((com.baidu.navisdk.ui.routeguide.widget.d) p0.this).f9165a).a(str, ""));
                    hashMap.put(str, arrayList);
                    ((com.baidu.navisdk.ui.routeguide.widget.d) p0.this).c.a(9, 0, 0, hashMap);
                }
                com.baidu.navisdk.ui.routeguide.model.g.i = false;
                p0.this.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            p0.this.n0();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public p0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.t = null;
        this.u = new int[]{R.id.bnav_rs_gas_station_iv, R.id.bnav_rs_charging_station_iv, R.id.bnav_rs_toilet_iv, R.id.bnav_rs_bank_iv, R.id.bnav_rs_hotel_iv, R.id.bnav_rs_spots_iv};
        this.v = new int[]{R.id.bnav_rs_gas_station_tv, R.id.bnav_rs_charging_station_tv, R.id.bnav_rs_toilet_tv, R.id.bnav_rs_bank_tv, R.id.bnav_rs_hotel_tv, R.id.bnav_rs_spots_tv};
        this.w = new int[]{R.string.nsdk_string_nearby_search_as_gas_station, R.string.nsdk_string_nearby_search_as_charging_station, R.string.nsdk_string_nearby_search_as_toilet, R.string.nsdk_string_nearby_search_as_bank, R.string.nsdk_string_nearby_search_as_hotel, R.string.nsdk_string_nearby_search_as_spots, R.string.nsdk_string_nearby_search_as_car_service, R.string.nsdk_string_nearby_search_as_park, R.string.nsdk_string_close};
        this.x = new int[]{R.drawable.nsdk_drawable_rg_route_search_gas_station, R.drawable.nsdk_drawable_rg_route_search_charging_station, R.drawable.nsdk_drawable_rg_route_search_toilet, R.drawable.nsdk_drawable_rg_route_search_bank, R.drawable.nsdk_drawable_rg_route_search_hotel, R.drawable.nsdk_drawable_rg_route_search_spots};
        this.y = new int[]{R.id.iv_h_divider_1, R.id.iv_h_divider_2};
        this.z = new int[]{R.id.iv_v_divider_1, R.id.iv_v_divider_2, R.id.iv_v_divider_3, R.id.iv_v_divider_4};
        p0();
        a(com.baidu.navisdk.ui.util.b.b());
        o0();
    }

    private void o0() {
        a aVar = new a();
        if (this.k == null) {
            LogUtil.e("RGMMRouteSearchView", "initListener return mRouteSearchView is null");
            return;
        }
        this.n.setOnClickListener(aVar);
        this.o.setOnClickListener(aVar);
        this.p.setOnClickListener(aVar);
        this.q.setOnClickListener(aVar);
        this.r.setOnClickListener(aVar);
        this.s.setOnClickListener(aVar);
        this.i.setOnClickListener(aVar);
    }

    private void p0() {
        int i;
        int i2;
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        this.i = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_route_search_panel);
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bnav_rg_route_search_container);
        this.j = viewGroup2;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
        ViewGroup viewGroup3 = (ViewGroup) JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_route_search, null);
        this.k = viewGroup3;
        if (this.j != null && viewGroup3 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
            if (j0()) {
                i = dimensionPixelOffset;
            } else {
                i = 0;
            }
            layoutParams.setMargins(i, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            this.k.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_layout_route_sort_background));
            this.j.addView(this.k, layoutParams);
            f0();
            this.m = (ViewGroup) this.k.findViewById(R.id.route_search_inner_panel);
            this.l = (TextView) this.k.findViewById(R.id.tv_route_search_title);
            this.n = this.k.findViewById(R.id.bnav_rs_gas_station);
            this.o = this.k.findViewById(R.id.bnav_rs_toilet);
            this.p = this.k.findViewById(R.id.bnav_rs_bank);
            this.q = this.k.findViewById(R.id.bnav_rs_spots);
            this.r = this.k.findViewById(R.id.bnav_rs_charging_station);
            this.s = this.k.findViewById(R.id.bnav_rs_hotel);
            this.t = this.k.findViewById(R.id.bnav_rg_close_content_panel);
            boolean j0 = j0();
            com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0 = h0();
            com.baidu.navisdk.pronavi.hd.d dVar = com.baidu.navisdk.pronavi.hd.d.f7723a;
            ViewGroup viewGroup4 = this.j;
            int i3 = h0.f6817a;
            if (j0) {
                i2 = h0.b;
            } else {
                i2 = h0.c;
            }
            dVar.a(viewGroup4, j0, i3, i2, false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        if (!j0()) {
            a(h0().b(), this.j);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i0() {
        com.baidu.navisdk.ui.routeguide.control.x.b().t1();
    }

    public void n0() {
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        ViewGroup viewGroup3 = this.j;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        u(10000);
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
            this.i.setBackgroundColor(com.baidu.navisdk.h.c());
        }
        if (this.m != null) {
            this.m.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L));
            this.m.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        TextView textView = this.l;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_b_mm));
            this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_route_search_title_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d));
        }
        View view = this.t;
        if (view != null) {
            view.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d));
        }
        ViewGroup viewGroup2 = this.k;
        if (viewGroup2 != null) {
            viewGroup2.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_layout_route_sort_background));
            int i = 0;
            int i2 = 0;
            while (true) {
                int[] iArr = this.y;
                if (i2 >= iArr.length) {
                    break;
                }
                View findViewById = this.k.findViewById(iArr[i2]);
                if (findViewById != null) {
                    findViewById.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d_mm));
                }
                i2++;
            }
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.z;
                if (i3 >= iArr2.length) {
                    break;
                }
                View findViewById2 = this.k.findViewById(iArr2[i3]);
                if (findViewById2 != null) {
                    findViewById2.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_bg_d_mm));
                }
                i3++;
            }
            int i4 = 0;
            while (true) {
                int[] iArr3 = this.v;
                if (i4 >= iArr3.length) {
                    break;
                }
                TextView textView2 = (TextView) this.k.findViewById(iArr3[i4]);
                if (textView2 != null) {
                    textView2.setText(com.baidu.navisdk.ui.util.b.h(this.w[i4]));
                    textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_b_mm));
                }
                i4++;
            }
            while (true) {
                int[] iArr4 = this.u;
                if (i >= iArr4.length) {
                    break;
                }
                ImageView imageView = (ImageView) this.k.findViewById(iArr4[i]);
                if (imageView != null) {
                    imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(this.x[i]));
                }
                i++;
            }
        }
        View view2 = this.n;
        if (view2 != null) {
            view2.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_common_bt_pressed_bg));
        }
        View view3 = this.o;
        if (view3 != null) {
            view3.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_common_bt_pressed_bg));
        }
        View view4 = this.p;
        if (view4 != null) {
            view4.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_common_bt_pressed_bg));
        }
        View view5 = this.q;
        if (view5 != null) {
            view5.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_common_bt_pressed_bg));
        }
        View view6 = this.r;
        if (view6 != null) {
            view6.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_common_bt_pressed_bg));
        }
        View view7 = this.s;
        if (view7 != null) {
            view7.setBackground(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_common_bt_pressed_bg));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        e0();
        Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
        a2.setFillAfter(true);
        a2.setAnimationListener(new b());
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.startAnimation(a2);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        Animator d;
        if (this.i == null) {
            return null;
        }
        if (z) {
            d = com.baidu.navisdk.pronavi.hd.d.f7723a.d(this.j, 0);
        } else {
            a(false, (View) this.j);
            int k = com.baidu.navisdk.ui.routeguide.utils.b.k();
            d = com.baidu.navisdk.pronavi.hd.d.f7723a.d(this.j, com.baidu.navisdk.ui.routeguide.utils.b.q() + k, k);
        }
        if (d == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(d);
        return arrayList;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        Animator d;
        if (this.i == null) {
            return null;
        }
        if (z) {
            d = com.baidu.navisdk.pronavi.hd.d.f7723a.d(this.j, 0);
        } else {
            a(false, (View) this.j);
            d = com.baidu.navisdk.pronavi.hd.d.f7723a.d(this.j, com.baidu.navisdk.ui.routeguide.utils.b.j(), 0);
        }
        if (d == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(d);
        return arrayList;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        Animator d;
        if (this.i == null) {
            return null;
        }
        if (z) {
            d = com.baidu.navisdk.pronavi.hd.d.f7723a.d(this.j, i2);
        } else {
            a(true, (View) this.j);
            d = com.baidu.navisdk.pronavi.hd.d.f7723a.d(this.j, com.baidu.navisdk.ui.routeguide.utils.b.q(), i2);
        }
        if (d == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(d);
        return arrayList;
    }
}
