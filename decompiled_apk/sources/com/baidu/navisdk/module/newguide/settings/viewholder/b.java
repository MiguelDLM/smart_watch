package com.baidu.navisdk.module.newguide.settings.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.settings.g;
import com.baidu.navisdk.module.routepreference.j;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class b extends g.b {
    private RecyclerView b;
    private g c;
    private ArrayList<j> d;
    private final com.baidu.navisdk.module.newguide.settings.i.a e;
    private View f;
    private View g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private BNSettingExplainSwitchItem m;
    private View n;
    private View o;
    private View p;
    private final BNSettingExplainSwitchItem.c q;
    private final View.OnClickListener r;
    private int s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.module.newguide.settings.viewmodel.a I;
            if (b.this.e != null && (I = b.this.e.I()) != null) {
                int b = b.this.b(b.this.b.getChildAdapterPosition(view));
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("ShortcutFuncGroupItemVi", "onClick clickPrefer: " + b + ",mCurrentPrefer: " + b.this.s);
                }
                I.b(b, b.this.s);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.settings.viewholder.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0260b implements Observer<ArrayList<j>> {
        public C0260b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable ArrayList<j> arrayList) {
            b.this.d = arrayList;
            if (b.this.c != null) {
                b.this.c.a(b.this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Observer<com.baidu.navisdk.module.newguide.settings.model.b> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable com.baidu.navisdk.module.newguide.settings.model.b bVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "onChanged CURRENT_PREFER_VALUE: " + bVar);
            }
            if (bVar != null) {
                b.this.s = bVar.f7275a;
                if (b.this.c != null) {
                    b.this.c.a(b.this.s, bVar.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Observer<com.baidu.navisdk.module.newguide.settings.model.a> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable com.baidu.navisdk.module.newguide.settings.model.a aVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "plate limit onChanged: " + aVar);
            }
            b.this.a(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Observer<Boolean> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "DAY_NIGHT_MODE_CHANGE onChanged: " + bool);
            }
            if (b.this.c != null) {
                b.this.c.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final ImageView f7313a;
        private final TextView b;
        private final TextView c;

        public f(View view) {
            super(view);
            this.f7313a = (ImageView) view.findViewById(R.id.bnav_rg_setting_prefer_icon);
            this.b = (TextView) view.findViewById(R.id.bnav_rg_setting_prefer_name);
            this.c = (TextView) view.findViewById(R.id.bnav_rg_setting_default_prefer_tip);
        }

        public void a(j jVar, int i, int i2) {
            if (jVar == null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.c()) {
                    gVar.c("ShortcutFuncGroupItemVi", "update: data null");
                    return;
                }
                return;
            }
            if ((jVar.b & i) != 0 && com.baidu.navisdk.module.routepreference.c.g(i) == 1) {
                if (jVar.c <= 0) {
                    jVar.c = jVar.c();
                }
                this.f7313a.setImageDrawable(JarUtils.getResources().getDrawable(jVar.c));
                this.itemView.setSelected(true);
            } else {
                if (com.baidu.navisdk.ui.util.b.b()) {
                    if (jVar.d <= 0) {
                        jVar.d = jVar.a();
                    }
                    this.f7313a.setImageDrawable(JarUtils.getResources().getDrawable(jVar.d));
                } else {
                    this.f7313a.setImageDrawable(JarUtils.getResources().getDrawable(jVar.b()));
                }
                this.itemView.setSelected(false);
            }
            this.b.setText(jVar.f7486a);
            if ((jVar.b & i2) != 0) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(4);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends RecyclerView.Adapter<f> {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<j> f7314a;
        private final View.OnClickListener b;
        private int c;
        private int d;

        public g(View.OnClickListener onClickListener) {
            this.b = onClickListener;
        }

        public void a(ArrayList<j> arrayList) {
            this.f7314a = arrayList;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<j> arrayList = this.f7314a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public f onCreateViewHolder(ViewGroup viewGroup, int i) {
            View a2 = com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_prefer_item, viewGroup, false);
            a2.setOnClickListener(this.b);
            return new f(a2);
        }

        public void a(int i, int i2) {
            this.c = i;
            this.d = i2;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull f fVar, int i) {
            fVar.a(this.f7314a.get(i), this.c, this.d);
        }
    }

    public b(Context context, View view, View.OnClickListener onClickListener, g.a aVar, com.baidu.navisdk.module.newguide.settings.i.a aVar2, BNSettingExplainSwitchItem.c cVar) {
        super(2, view, aVar);
        this.e = aVar2;
        this.q = cVar;
        this.r = onClickListener;
        a(context);
        d();
        c();
    }

    private void c() {
        if (com.baidu.navisdk.function.b.FUNC_LICENSE_PASS.a()) {
            this.o.setOnClickListener(this.r);
        }
        this.f.setOnClickListener(this.r);
        this.m.setOnCheckedListener(this.q);
    }

    private void d() {
        com.baidu.navisdk.module.newguide.settings.i.a aVar = this.e;
        if (aVar != null) {
            com.baidu.navisdk.module.newguide.settings.viewmodel.a I = aVar.I();
            LifecycleOwner J = this.e.J();
            if (I == null || J == null) {
                return;
            }
            I.e().observe(J, new C0260b());
            I.d().observe(J, new c());
            I.c().observe(J, new d());
            I.a(2).observe(J, new e());
        }
    }

    private void b() {
        if (!com.baidu.navisdk.function.b.FUNC_ROUTE_PREFER.a()) {
            this.b.setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a()) {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_LICENSE_PASS.a()) {
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        }
        if (a()) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
            }
            this.itemView.setVisibility(8);
        }
    }

    private void a(Context context) {
        this.b = (RecyclerView) this.itemView.findViewById(R.id.bn_rg_setting_group_route_prefer);
        this.b.setLayoutManager(new GridLayoutManager(context, 3));
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_2dp);
        this.b.addItemDecoration(new com.baidu.navisdk.module.newguide.widgets.a(3, dimensionPixelSize, dimensionPixelSize));
        this.b.setNestedScrollingEnabled(false);
        this.b.setFocusableInTouchMode(false);
        g gVar = new g(new a());
        this.c = gVar;
        this.b.setAdapter(gVar);
        this.h = (TextView) a(R.id.car_plate);
        this.i = (TextView) a(R.id.nav_car_plate_tips_tv);
        this.j = (TextView) a(R.id.car_plate_guide);
        this.l = (ImageView) a(R.id.navi_set_arrow);
        this.m = (BNSettingExplainSwitchItem) a(R.id.nav_license_plates_limit_layout);
        this.f = a(R.id.car_plate_setting_view);
        this.g = a(R.id.bn_rg_setting_group_route_l1);
        this.n = a(R.id.bn_rg_setting_group_route_l2);
        this.o = a(R.id.nav_license_passport_layout);
        this.p = a(R.id.bn_rg_setting_group_route_l3);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        int size;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ShortcutFuncGroupItemVi", "getPreferValue: " + i);
        }
        ArrayList<j> arrayList = this.d;
        if (arrayList == null || i < 0 || i >= (size = arrayList.size())) {
            return -1;
        }
        j jVar = this.d.get(i);
        if (gVar.d()) {
            gVar.e("ShortcutFuncGroupItemVi", "getPreferValue: " + size + ", " + jVar);
        }
        if (jVar != null) {
            return jVar.b;
        }
        return -1;
    }

    @Override // com.baidu.navisdk.module.newguide.settings.g.b, com.baidu.navisdk.module.newguide.settings.g.c
    public void a(com.baidu.navisdk.module.newguide.settings.model.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.g.b
    public boolean a() {
        if (com.baidu.navisdk.function.b.FUNC_ROUTE_PREFER.a() || ((com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a() && this.n.getVisibility() != 8) || (com.baidu.navisdk.function.b.FUNC_LICENSE_PASS.a() && this.p.getVisibility() != 8))) {
            return super.a();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable com.baidu.navisdk.module.newguide.settings.model.a aVar) {
        if (aVar != null) {
            TextView textView = this.h;
            if (textView != null) {
                textView.setText(aVar.b);
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setText(aVar.c);
            }
            TextView textView3 = this.j;
            if (textView3 != null) {
                textView3.setText(aVar.d);
            }
            BNSettingExplainSwitchItem bNSettingExplainSwitchItem = this.m;
            if (bNSettingExplainSwitchItem != null) {
                bNSettingExplainSwitchItem.setChecked(aVar.f7274a);
                if (!TextUtils.isEmpty(aVar.e)) {
                    if (this.k == null) {
                        TextView textView4 = new TextView(this.itemView.getContext());
                        this.k = textView4;
                        textView4.setTextColor(Color.parseColor("#45cc6a"));
                        this.k.setText(aVar.e);
                        this.m.b(this.k);
                    }
                } else {
                    this.m.a();
                    this.k = null;
                }
            }
            if (aVar.g) {
                TextView textView5 = this.j;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
                ImageView imageView = this.l;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                View view = this.f;
                if (view != null) {
                    view.setEnabled(true);
                }
            } else {
                TextView textView6 = this.j;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
                ImageView imageView2 = this.l;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                View view2 = this.f;
                if (view2 != null) {
                    view2.setEnabled(false);
                }
            }
            if (aVar.f) {
                boolean a2 = com.baidu.navisdk.function.b.FUNC_PLATE_LIMIT.a();
                View view3 = this.f;
                if (view3 != null) {
                    view3.setVisibility(a2 ? 0 : 8);
                }
                View view4 = this.g;
                if (view4 != null) {
                    view4.setVisibility(a2 ? 0 : 8);
                }
                BNSettingExplainSwitchItem bNSettingExplainSwitchItem2 = this.m;
                if (bNSettingExplainSwitchItem2 != null) {
                    bNSettingExplainSwitchItem2.setVisibility(a2 ? 0 : 8);
                }
                View view5 = this.n;
                if (view5 != null) {
                    view5.setVisibility(a2 ? 0 : 8);
                }
            } else {
                View view6 = this.f;
                if (view6 != null) {
                    view6.setVisibility(8);
                }
                View view7 = this.g;
                if (view7 != null) {
                    view7.setVisibility(8);
                }
                BNSettingExplainSwitchItem bNSettingExplainSwitchItem3 = this.m;
                if (bNSettingExplainSwitchItem3 != null) {
                    bNSettingExplainSwitchItem3.setVisibility(8);
                }
                View view8 = this.n;
                if (view8 != null) {
                    view8.setVisibility(8);
                }
            }
            if (aVar.h) {
                View view9 = this.o;
                if (view9 != null) {
                    view9.setVisibility(0);
                }
                View view10 = this.p;
                if (view10 != null) {
                    view10.setVisibility(0);
                }
            } else {
                View view11 = this.o;
                if (view11 != null) {
                    view11.setVisibility(8);
                }
                View view12 = this.p;
                if (view12 != null) {
                    view12.setVisibility(8);
                }
            }
        }
        b();
    }
}
