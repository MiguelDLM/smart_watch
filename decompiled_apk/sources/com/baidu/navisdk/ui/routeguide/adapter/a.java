package com.baidu.navisdk.ui.routeguide.adapter;

import OIII0O.OOXIXo;
import XXO0.oIX0oI;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a extends PtrrvBaseAdapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    private e f8432a;
    private final List<com.baidu.navisdk.module.pronavi.model.d> b;
    private final List<Object> c;
    private final List<h> d;
    private final int e;
    private final int f;
    private String g;
    private String h;
    private final View i;

    /* renamed from: com.baidu.navisdk.ui.routeguide.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0411a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8433a;
        final /* synthetic */ int b;
        final /* synthetic */ com.baidu.navisdk.module.pronavi.model.d c;

        public ViewOnClickListenerC0411a(int i, int i2, com.baidu.navisdk.module.pronavi.model.d dVar) {
            this.f8433a = i;
            this.b = i2;
            this.c = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f8432a != null) {
                a.this.f8432a.a(this.f8433a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f8434a;
        TextView b;

        public b(a aVar, View view) {
            super(view);
            this.f8434a = (TextView) view.findViewById(R.id.bnav_rg_weather_update_time);
            this.b = (TextView) view.findViewById(R.id.bnav_rg_weather_source_name);
        }

        public void a(String str, String str2) {
            TextView textView = this.f8434a;
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setText(str2);
                this.b.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_rg_external_weather_source_name_color));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public TextView f8435a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;

        public c(a aVar, View view) {
            super(view);
            this.f8435a = (TextView) view.findViewById(R.id.hw_subscript_distance_value);
            this.b = (TextView) view.findViewById(R.id.hw_subscript_service_count);
            this.c = (TextView) view.findViewById(R.id.hw_subscript_toll_station_count);
            this.g = (TextView) view.findViewById(R.id.hw_subscript_charge_station_count);
            this.h = view.findViewById(R.id.hw_subscript_charge_station);
            this.d = (TextView) view.findViewById(R.id.hw_subscript_distance_label);
            this.e = (TextView) view.findViewById(R.id.hw_subscript_service_count_label);
            this.f = (TextView) view.findViewById(R.id.hw_subscript_toll_station_count_label);
        }
    }

    /* loaded from: classes8.dex */
    public class d extends RecyclerView.ViewHolder {
        private final LinearLayout A;
        private final TextView B;
        private final View C;
        private int D;
        private boolean E;

        /* renamed from: a, reason: collision with root package name */
        public View f8436a;
        private final View b;
        private final View c;
        private final View d;
        private final View e;
        private final View f;
        private final TextView g;
        private final TextView h;
        private final TextView i;
        private final TextView j;
        private final TextView k;
        private ImageView l;
        private ImageView m;
        private ImageView n;
        private ImageView o;
        private ImageView p;
        private ImageView q;
        private ImageView r;
        private ImageView s;
        private final ImageView t;
        private ImageView u;
        private final ImageView v;
        private final TextView w;
        private final List<ImageView> x;
        private final LinearLayout y;
        private final TextView z;

        public d(View view) {
            super(view);
            this.E = false;
            a(view);
            ArrayList arrayList = new ArrayList();
            this.x = arrayList;
            arrayList.add(this.l);
            arrayList.add(this.m);
            arrayList.add(this.p);
            arrayList.add(this.n);
            arrayList.add(this.o);
            arrayList.add(this.q);
            arrayList.add(this.r);
            arrayList.add(this.s);
            arrayList.add(this.u);
            this.b = view.findViewById(R.id.hw_service_icon_layout);
            this.c = view.findViewById(R.id.hw_service_exit_layout);
            this.d = view.findViewById(R.id.hw_service_name_and_dist_layout);
            this.f = view.findViewById(R.id.hw_service_gas_layout);
            this.g = (TextView) view.findViewById(R.id.hw_service_gas_text);
            this.e = view.findViewById(R.id.hw_service_charge_layout);
            this.f8436a = view.findViewById(R.id.service_subscribe_layout);
            this.v = (ImageView) view.findViewById(R.id.hw_service_script_icon);
            this.w = (TextView) view.findViewById(R.id.hw_service_script_text);
            this.h = (TextView) view.findViewById(R.id.hw_service_name);
            this.i = (TextView) view.findViewById(R.id.hw_service_distance);
            this.j = (TextView) view.findViewById(R.id.bnavi_rg_hw_service_panel_exit_code);
            this.t = (ImageView) view.findViewById(R.id.hw_item_icon_toll_station);
            this.y = (LinearLayout) view.findViewById(R.id.hw_item_charge_1);
            this.z = (TextView) view.findViewById(R.id.hw_item_charge_count_1);
            this.A = (LinearLayout) view.findViewById(R.id.hw_item_charge_2);
            this.B = (TextView) view.findViewById(R.id.hw_item_charge_count_2);
            this.C = view.findViewById(R.id.constraintLayout);
            this.k = (TextView) view.findViewById(R.id.hw_empty_parking_space_info);
        }

        private String a(int i, String str, boolean z) {
            if (l0.c(str)) {
                return str;
            }
            String trim = str.trim();
            if (j.a(this.h, i, trim)) {
                return trim;
            }
            String a2 = a(trim, z);
            this.E = true;
            return a(i, a2, z);
        }

        public void b(com.baidu.navisdk.module.pronavi.model.d dVar) {
            if (dVar.q() && a.this.a() && dVar.p() == 4) {
                this.v.setVisibility(8);
                this.w.setVisibility(8);
                return;
            }
            this.v.setVisibility(0);
            this.w.setVisibility(0);
            if (dVar.b() == 1) {
                this.v.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_drawable_hw_add_via_point));
                this.w.setText("途经点");
            } else if (dVar.b() == 2) {
                this.v.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_drawable_hw_go_here));
                this.w.setText("到这去");
            } else {
                boolean s = dVar.s();
                this.v.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_hw_subscript_selector));
                this.v.setEnabled(!s);
                this.w.setText(s ? "取消提醒" : "到达提醒");
            }
        }

        public void c(com.baidu.navisdk.module.pronavi.model.d dVar) {
            com.baidu.navisdk.model.datastruct.chargestation.b bVar;
            String h = dVar.h();
            String str = dVar.m() + dVar.l();
            int p = dVar.p();
            if (dVar.p() == 6 && (bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) dVar.a("charge_station_info", null)) != null) {
                h = bVar.j();
            }
            if (this.d == null || this.h == null || this.i == null) {
                return;
            }
            int a2 = a();
            if (a2 <= 0) {
                a2 = this.d.getMeasuredWidth();
            }
            int a3 = (((a2 - j.a(this.i, "99.9公里")) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_service_subscribe_list_item_dist_margin_left)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_service_subscribe_list_item_service_name_margin_left)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp);
            this.E = false;
            boolean z = p == 3 || p == 5;
            String a4 = a(a3, h, z);
            if (this.E && !z && a4.length() > 2) {
                a4 = a4.substring(0, a4.length() - 1) + "..";
            }
            if (!this.h.getText().toString().equals(a4)) {
                this.h.setText(a4);
            }
            this.i.setText(str);
        }

        private String a(String str, boolean z) {
            if (z && str.contains(" ")) {
                return str.substring(0, str.lastIndexOf(" "));
            }
            return str.substring(0, str.length() - 1);
        }

        private int a() {
            int b;
            if (x.b().s2()) {
                b = com.baidu.navisdk.pronavi.util.a.h.e();
            } else {
                b = com.baidu.navisdk.ui.routeguide.utils.a.f9151a.b();
            }
            if (this.D <= 0) {
                if (a.this.i != null && this.itemView != null && this.f8436a != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.i.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.itemView.getLayoutParams();
                    this.D = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + this.itemView.getPaddingLeft() + this.itemView.getPaddingRight() + this.f8436a.getPaddingLeft() + this.f8436a.getPaddingRight() + j.a(this.w, "到达提醒") + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_service_subscribe_list_item_service_name_margin_left);
                } else {
                    g gVar = g.PRO_NAV;
                    if (!gVar.d()) {
                        return 0;
                    }
                    gVar.e("RGHwSubscribeAdapter", "getMeasureWidth-> return ! mContentView=" + a.this.i + ", itemView=" + this.itemView + ", mServiceSubscriptLayout=" + this.f8436a);
                    return 0;
                }
            }
            return b - this.D;
        }

        public void a(int i) {
            if (i == 3 || i == 5) {
                this.t.setVisibility(8);
                this.b.setVisibility(4);
                this.c.setVisibility(0);
                this.itemView.setBackgroundResource(R.drawable.nsdk_drawable_rg_hw_bg_green_bottom);
                return;
            }
            if (i == 1) {
                this.c.setVisibility(8);
                this.b.setVisibility(4);
                this.t.setVisibility(0);
                this.itemView.setBackgroundResource(R.drawable.nsdk_drawable_rg_hw_bg_blue_bottom);
                return;
            }
            if (i == 6) {
                this.c.setVisibility(8);
                this.b.setVisibility(8);
                this.t.setVisibility(8);
                this.itemView.setBackgroundResource(R.drawable.nsdk_drawable_rg_hw_bg_blue_bottom);
                return;
            }
            this.c.setVisibility(8);
            this.t.setVisibility(8);
            this.b.setVisibility(0);
            this.itemView.setBackgroundResource(R.drawable.nsdk_drawable_rg_hw_bg_green_bottom);
        }

        public void a(String str) {
            if (!l0.c(str)) {
                this.j.setText(str);
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }

        private void a(View view) {
            this.l = (ImageView) view.findViewById(R.id.hw_item_icon_park);
            this.m = (ImageView) view.findViewById(R.id.hw_item_icon_petrol_station);
            this.n = (ImageView) view.findViewById(R.id.hw_item_icon_diningroom);
            this.o = (ImageView) view.findViewById(R.id.hw_item_icon_wc);
            this.p = (ImageView) view.findViewById(R.id.hw_item_icon_charging_station);
            this.q = (ImageView) view.findViewById(R.id.hw_item_icon_shop);
            this.r = (ImageView) view.findViewById(R.id.hw_item_icon_garage);
            this.s = (ImageView) view.findViewById(R.id.hw_item_icon_recreation);
            this.u = (ImageView) view.findViewById(R.id.hw_item_icon_gas);
            this.l.setTag(8);
            this.m.setTag(1);
            this.n.setTag(32);
            this.o.setTag(64);
            this.p.setTag(2);
            this.q.setTag(128);
            this.r.setTag(16);
            this.s.setTag(256);
            this.u.setTag(4);
        }

        public void a(com.baidu.navisdk.module.pronavi.model.d dVar) {
            i.a(new ArrayList(dVar.o()), this.x, com.baidu.navisdk.ui.routeguide.b.V().D() ? i.b : i.f8769a);
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i, int i2, com.baidu.navisdk.module.pronavi.model.d dVar);
    }

    /* loaded from: classes8.dex */
    public class f extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        ImageView f8437a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        public f(a aVar, View view) {
            super(view);
            this.f8437a = (ImageView) view.findViewById(R.id.bnav_extreme_weather_icon);
            this.b = (TextView) view.findViewById(R.id.bnav_extreme_weather_route_event_tv);
            this.c = (TextView) view.findViewById(R.id.bnav_extreme_weather_route_name);
            this.d = (TextView) view.findViewById(R.id.bnav_extreme_weather_distance);
            this.e = (TextView) view.findViewById(R.id.bnav_extreme_weather_temp);
        }

        public void a(h hVar) {
            String str;
            String str2;
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHwSubscribeAdapter", "WeatherViewHolder update: " + hVar);
            }
            if (hVar != null) {
                hVar.a(t.s().a());
            }
            if (hVar != null && hVar.b() > 0 && hVar.e != null) {
                this.itemView.setVisibility(0);
                h.d dVar = hVar.f;
                if (dVar != null && !TextUtils.isEmpty(dVar.c)) {
                    this.f8437a.setVisibility(0);
                    if (gVar.d()) {
                        gVar.e("RGHwSubscribeAdapter", "WeatherViewHolder update displayImage: " + hVar.f);
                    }
                    com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e.a(this.f8437a, hVar, com.baidu.navisdk.comapi.commontool.a.getInstance().a());
                } else {
                    this.f8437a.setVisibility(8);
                }
                if (!TextUtils.isEmpty(hVar.e.d) && !TextUtils.isEmpty(hVar.e.e)) {
                    str = hVar.e.d + OOXIXo.f1567xI + hVar.e.e;
                } else if (!TextUtils.isEmpty(hVar.e.d)) {
                    str = hVar.e.d;
                } else if (!TextUtils.isEmpty(hVar.e.e)) {
                    str = hVar.e.e;
                } else {
                    str = null;
                }
                if (this.b != null && !TextUtils.isEmpty(str)) {
                    this.b.setText(str);
                }
                TextView textView = this.c;
                if (textView != null) {
                    textView.setText(hVar.e.b);
                }
                if (this.d != null) {
                    if ("km".equals(hVar.d())) {
                        str2 = "公里";
                    } else {
                        str2 = "米";
                    }
                    this.d.setText(hVar.c() + str2);
                }
                TextView textView2 = this.e;
                if (textView2 != null) {
                    textView2.setText(hVar.f.b);
                    return;
                }
                return;
            }
            this.itemView.setVisibility(8);
        }
    }

    public a(Context context, View view) {
        super(context);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.i = view;
        this.e = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_8dp);
        this.f = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_21dp);
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.c.size();
        int i = size + 1;
        if (!this.d.isEmpty()) {
            return size + 2;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = i - 1;
        if (i2 == this.c.size()) {
            return 3;
        }
        if (this.c.get(i2) instanceof com.baidu.navisdk.module.pronavi.model.d) {
            return 1;
        }
        return 2;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int d2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        super.onBindViewHolder(viewHolder, i);
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() == null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHwSubscribeAdapter", "onBindViewHolder-> getServiceAreaModel == null,return!");
                return;
            }
            return;
        }
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            c cVar = (c) viewHolder;
            int l = a0.I().l();
            if (com.baidu.navisdk.ui.routeguide.b.V().D()) {
                str5 = l / 1000 >= 1 ? "km" : "m";
            } else {
                str5 = l / 1000 >= 1 ? "公里" : "米";
            }
            cVar.f8435a.setText(a(l));
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.navisdk.ui.routeguide.b.V().D() ? "总公里" : "全程剩余");
            sb.append(oIX0oI.I0Io.f4096II0xO0);
            sb.append(str5);
            sb.append(oIX0oI.I0Io.f4095I0Io);
            cVar.d.setText(sb.toString());
            cVar.f.setText(com.baidu.navisdk.ui.routeguide.b.V().D() ? "收费站(个)" : "前方收费站(个)");
            cVar.b.setText(String.valueOf(com.baidu.navisdk.ui.routeguide.b.V().i().c().l()));
            cVar.c.setText(String.valueOf(com.baidu.navisdk.ui.routeguide.b.V().i().c().o()));
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null && k.m()) {
                cVar.h.setVisibility(com.baidu.navisdk.ui.routeguide.b.V().D() ? 0 : 8);
            } else {
                cVar.h.setVisibility(8);
            }
            cVar.g.setText(String.valueOf(com.baidu.navisdk.ui.routeguide.b.V().i().c().c()));
            return;
        }
        if (itemViewType == 3) {
            ((b) viewHolder).a(this.g, this.h);
            return;
        }
        int i2 = i - 1;
        Object obj = this.c.get(i2);
        if (obj instanceof com.baidu.navisdk.module.pronavi.model.d) {
            com.baidu.navisdk.module.pronavi.model.d dVar = (com.baidu.navisdk.module.pronavi.model.d) obj;
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHwSubscribeAdapter", "onBindViewHolder --> dataIndex = " + i2 + ", bean = " + dVar);
            }
            d dVar2 = (d) viewHolder;
            dVar2.a(dVar.p());
            if (dVar.p() == 3 || dVar.p() == 5) {
                dVar2.a(dVar.d());
            }
            dVar.a(com.baidu.navisdk.ui.routeguide.b.V().i().c().d());
            if (dVar.k() <= 0) {
                dVar2.itemView.setVisibility(8);
            } else {
                dVar2.itemView.setVisibility(0);
                dVar2.a(dVar);
                dVar2.b(dVar);
                dVar2.c(dVar);
            }
            dVar2.f8436a.setOnClickListener(new ViewOnClickListenerC0411a(a(dVar), i2, dVar));
            if (!a() || dVar.p() != 4) {
                dVar2.k.setVisibility(8);
            } else if (!dVar.r()) {
                dVar2.k.setVisibility(8);
            } else {
                com.baidu.navisdk.module.pronavi.model.a aVar = (com.baidu.navisdk.module.pronavi.model.a) dVar.a("parking_lot_info");
                if (aVar == null || aVar.a() <= 0) {
                    dVar2.k.setVisibility(8);
                } else {
                    dVar2.k.setText("空车位: " + aVar.a());
                    dVar2.k.setVisibility(0);
                }
            }
            if (dVar.p() != 6 && dVar.p() != 7) {
                if (dVar.p() == 4) {
                    dVar2.e.setVisibility(8);
                    if (dVar.f() == null) {
                        dVar2.f.setVisibility(8);
                    } else {
                        String a2 = dVar.f().a();
                        String b2 = dVar.f().b();
                        StringBuilder sb2 = new StringBuilder();
                        if (!TextUtils.isEmpty(a2)) {
                            sb2.append(dVar.f().a());
                        }
                        if (sb2.length() != 0 && !TextUtils.isEmpty(b2)) {
                            sb2.append(" ");
                        }
                        if (!TextUtils.isEmpty(b2)) {
                            sb2.append(b2);
                        }
                        if (sb2.toString().length() > 0) {
                            dVar2.f.setVisibility(0);
                            dVar2.g.setText(sb2.toString());
                        } else {
                            dVar2.f.setVisibility(8);
                        }
                    }
                } else {
                    dVar2.e.setVisibility(8);
                    dVar2.f.setVisibility(8);
                }
            } else {
                com.baidu.navisdk.model.datastruct.chargestation.b bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) dVar.a("charge_station_info", null);
                if (bVar != null) {
                    dVar2.f.setVisibility(8);
                    dVar2.e.setVisibility(0);
                    if (dVar.p() == 6) {
                        dVar2.z.setTextColor(Color.parseColor("#3883FA"));
                        dVar2.B.setTextColor(Color.parseColor("#3883FA"));
                        d2 = 0;
                    } else {
                        dVar2.z.setTextColor(Color.parseColor("#00945B"));
                        dVar2.B.setTextColor(Color.parseColor("#00945B"));
                        d2 = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_2dp);
                    }
                    ViewGroup.LayoutParams layoutParams = dVar2.e.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).topMargin = d2;
                        dVar2.e.setLayoutParams(layoutParams);
                    }
                    if (bVar.d().c() != 0 && bVar.d().g() != 0) {
                        if (bVar.d().b() <= 0) {
                            str3 = "快充 共" + bVar.d().c() + "个";
                        } else {
                            str3 = "快充 " + bVar.d().b() + "/" + bVar.d().c();
                        }
                        dVar2.y.setVisibility(0);
                        dVar2.z.setText(str3);
                        if (bVar.d().f() <= 0) {
                            str4 = "慢充 共" + bVar.d().g() + "个";
                        } else {
                            str4 = "慢充 " + bVar.d().f() + "/" + bVar.d().g();
                        }
                        dVar2.A.setVisibility(0);
                        dVar2.B.setText(str4);
                    } else if (bVar.d().c() != 0 || bVar.d().g() != 0) {
                        dVar2.y.setVisibility(0);
                        dVar2.A.setVisibility(8);
                        if (bVar.d().c() != 0) {
                            if (bVar.d().b() <= 0) {
                                str2 = "快充 共" + bVar.d().c() + "个";
                            } else {
                                str2 = "快充 " + bVar.d().b() + "/" + bVar.d().c();
                            }
                            dVar2.z.setText(str2);
                        } else {
                            if (bVar.d().f() <= 0) {
                                str = "慢充 共" + bVar.d().g() + "个";
                            } else {
                                str = "慢充 " + bVar.d().f() + "/" + bVar.d().g();
                            }
                            dVar2.z.setText(str);
                        }
                    } else {
                        dVar2.y.setVisibility(8);
                        dVar2.A.setVisibility(8);
                    }
                    if (!com.baidu.navisdk.ui.routeguide.model.d.g().b(bVar.p())) {
                        com.baidu.navisdk.ui.routeguide.model.d.g().a(bVar.p());
                        if (dVar.b() == 1) {
                            com.baidu.navisdk.util.statistic.userop.b.r().b("3.17.1.4");
                        } else if (dVar.b() == 2) {
                            com.baidu.navisdk.util.statistic.userop.b.r().b("3.17.1.6");
                        } else {
                            com.baidu.navisdk.util.statistic.userop.b.r().b("3.17.1.2");
                        }
                    }
                } else {
                    dVar2.itemView.setVisibility(8);
                }
                k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k2 != null && !k2.m()) {
                    if (dVar.p() != 6) {
                        dVar2.e.setVisibility(8);
                    } else {
                        dVar2.itemView.setVisibility(8);
                    }
                }
            }
            if (dVar2.f.getVisibility() != 8 || dVar2.k.getVisibility() != 8) {
                dVar2.C.setVisibility(0);
                return;
            } else {
                dVar2.C.setVisibility(8);
                return;
            }
        }
        if (obj instanceof h) {
            ((f) viewHolder).a((h) obj);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PtrrvBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().c(), R.layout.nsdk_layout_rg_extreme_weather_update_time_item);
                    int i2 = this.f;
                    layoutParams.setMargins(i2, 0, i2, 0);
                    a2.setLayoutParams(layoutParams);
                    return new b(this, a2);
                }
                View a3 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().c(), R.layout.nsdk_layout_rg_extreme_weather_list_item);
                int i3 = this.f;
                layoutParams.setMargins(i3, this.e, i3, 0);
                a3.setLayoutParams(layoutParams);
                return new f(this, a3);
            }
            View a4 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().c(), R.layout.nsdk_layout_hw_subscript_list_item);
            int i4 = this.f;
            layoutParams.setMargins(i4, this.e, i4, 0);
            a4.setLayoutParams(layoutParams);
            return new d(a4);
        }
        View a5 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().c(), R.layout.nsdk_layout_hw_subscript_list_head);
        layoutParams.setMargins(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp), 0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_20dp));
        a5.setLayoutParams(layoutParams);
        return new c(this, a5);
    }

    private void b() {
        this.c.clear();
        int i = 0;
        int i2 = 0;
        while (i < this.b.size()) {
            com.baidu.navisdk.module.pronavi.model.d dVar = this.b.get(i);
            while (i2 < this.d.size()) {
                h hVar = this.d.get(i2);
                if (hVar.a() < dVar.a()) {
                    this.c.add(hVar);
                    i2++;
                }
            }
            this.c.add(dVar);
            i++;
        }
        while (i < this.b.size()) {
            this.c.add(this.b.get(i));
            i++;
        }
        while (i2 < this.d.size()) {
            this.c.add(this.d.get(i2));
            i2++;
        }
    }

    public void a(List<com.baidu.navisdk.module.pronavi.model.d> list, List<h> list2) {
        this.b.clear();
        this.d.clear();
        if (list != null && !list.isEmpty()) {
            this.b.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            this.d.addAll(list2);
        }
        if (this.d.isEmpty()) {
            this.c.clear();
            this.c.addAll(this.b);
        } else if (this.b.isEmpty()) {
            this.c.clear();
            this.c.addAll(this.d);
        } else {
            b();
        }
        notifyDataSetChanged();
    }

    public void a(String str, String str2) {
        this.g = str;
        this.h = str2;
    }

    private int a(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar != null && !this.b.isEmpty()) {
            for (int i = 0; i < this.b.size(); i++) {
                com.baidu.navisdk.module.pronavi.model.d dVar2 = this.b.get(i);
                if (dVar2 != null) {
                    String g = dVar2.g();
                    if (!TextUtils.isEmpty(g) && g.equals(dVar.g())) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public boolean a() {
        boolean z = com.baidu.navisdk.module.vehiclemanager.b.i().f() && com.baidu.navisdk.module.vehiclemanager.b.i().a() == 0;
        boolean a2 = com.baidu.navisdk.function.b.FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO.a();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHwSubscribeAdapter", "isShowEmptyParkingSpaceInfoScene--> isCar-->" + z + ", FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO is -->" + a2);
        }
        return z && a2;
    }

    private String a(int i) {
        StringBuilder sb = new StringBuilder();
        l0.a(i, sb);
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0' && sb.charAt(sb.length() - 2) == '.') {
            return sb.substring(0, sb.length() - 2);
        }
        return sb.toString();
    }

    public void a(e eVar) {
        this.f8432a = eVar;
    }
}
