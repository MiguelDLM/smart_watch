package com.baidu.navisdk.module.newguide.settings.shortcut;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.l;
import com.baidu.navisdk.framework.message.bean.q;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.newguide.settings.drag.a;
import com.baidu.navisdk.module.newguide.settings.shortcut.vm.RGShortcutPageVM;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class c implements l, com.baidu.navisdk.framework.interfaces.h, a.b {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.framework.interfaces.l f7280a;
    private Context b;
    private ViewGroup c;
    private BNCommonTitleBar d;
    private View e;
    private RecyclerView f;
    private com.baidu.navisdk.module.newguide.settings.shortcut.views.b g;
    private ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> h;
    private ItemTouchHelper i;
    private com.baidu.navisdk.module.newguide.settings.drag.a j;
    private com.baidu.navisdk.module.newguide.settings.drag.b k;
    private boolean l = false;
    private SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> m;
    private RecyclerView n;
    private com.baidu.navisdk.module.newguide.settings.shortcut.views.a o;
    private RGShortcutPageVM p;
    private LifecycleOwner q;
    private ViewModelProvider r;
    private com.baidu.navisdk.comapi.commontool.b s;
    private TextView t;
    private TextView u;
    private View v;
    private View w;

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.comapi.commontool.b {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (i == 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return;
                            }
                        }
                    }
                    c.this.q(false);
                    return;
                }
                c.this.q(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b(c cVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGShortcutPageImpl", "onClick: ");
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.settings.shortcut.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0257c extends com.baidu.navisdk.module.newguide.settings.drag.b {
        public C0257c(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // com.baidu.navisdk.module.newguide.settings.drag.b
        public void a(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view.getTag() instanceof Integer) {
                c.this.p(((Integer) view.getTag()).intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.module.newguide.settings.drag.b {
        public d(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // com.baidu.navisdk.module.newguide.settings.drag.b
        public void a(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view.getTag() instanceof Integer) {
                c.this.o(((Integer) view.getTag()).intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.navisdk.ui.util.g.a()) {
                return;
            }
            if (c.this.l) {
                c.this.z0();
            } else {
                c.this.y0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.navisdk.ui.util.g.a() && c.this.f7280a != null) {
                c.this.f7280a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Observer<SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> {
        public g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> sparseArray) {
            c.this.m = sparseArray;
            if (c.this.o != null) {
                c.this.o.a(c.this.m, c.this.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Observer<ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> {
        public h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList) {
            c.this.h = arrayList;
            if (c.this.g != null) {
                c.this.g.a(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Observer<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> {
        public i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar) {
            if (c.this.o != null && aVar != null) {
                c.this.o.a(aVar);
            }
        }
    }

    private void A0() {
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "handlerEditStateChange: " + this.l);
        }
        G0();
        View view = this.e;
        if (view != null) {
            if (this.l) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        com.baidu.navisdk.module.newguide.settings.shortcut.views.b bVar = this.g;
        if (bVar != null) {
            bVar.a(this.l);
        }
        com.baidu.navisdk.module.newguide.settings.shortcut.views.a aVar = this.o;
        if (aVar != null) {
            aVar.a(this.l);
        }
    }

    private void B0() {
        this.n = (RecyclerView) this.c.findViewById(R.id.bn_rg_all_shortcut_recycler);
        this.o = new com.baidu.navisdk.module.newguide.settings.shortcut.views.a(this.m, this.l);
        this.n.setLayoutManager(new GridLayoutManager(this.b, 4));
        this.n.addItemDecoration(new com.baidu.navisdk.module.newguide.settings.shortcut.views.c(4));
        this.n.setAdapter(this.o);
        this.n.setHasFixedSize(true);
    }

    private void C0() {
        this.f = (RecyclerView) this.c.findViewById(R.id.bn_rg_all_shortcut_custom_recycler);
        this.g = new com.baidu.navisdk.module.newguide.settings.shortcut.views.b(this.h, this.l);
        com.baidu.navisdk.module.newguide.settings.drag.a a2 = new com.baidu.navisdk.module.newguide.settings.drag.a(this.g).a(this);
        this.j = a2;
        this.i = new ItemTouchHelper(a2);
        this.e = this.c.findViewById(R.id.bn_rg_all_shortcut_drag_tip);
        this.f.setLayoutManager(new GridLayoutManager(this.b, 4));
        this.f.addItemDecoration(new com.baidu.navisdk.module.newguide.settings.shortcut.views.c(4));
        this.f.setAdapter(this.g);
        this.f.setHasFixedSize(true);
        this.i.attachToRecyclerView(this.f);
    }

    private void D0() {
        if (this.s == null) {
            this.s = new a();
        }
    }

    private void E0() {
        BNCommonTitleBar bNCommonTitleBar = (BNCommonTitleBar) this.c.findViewById(R.id.bn_rg_all_shortcut_title_bar);
        this.d = bNCommonTitleBar;
        bNCommonTitleBar.setTitleBarDivideLineVisibility(8);
        this.t = (TextView) this.c.findViewById(R.id.bn_rg_all_shortcut_my_txt);
        this.u = (TextView) this.c.findViewById(R.id.bn_rg_all_shortcut_all_func_txt);
        this.v = this.c.findViewById(R.id.bn_rg_all_shortcut_line1);
        this.w = this.c.findViewById(R.id.bn_rg_all_shortcut_line2);
        G0();
        C0();
        B0();
    }

    private View F0() {
        if (this.c == null) {
            this.c = (ViewGroup) com.baidu.navisdk.ui.util.b.a(this.b, R.layout.nsdk_layout_rg_more_shotcut_func_page);
            E0();
            b0();
        }
        x0();
        q(com.baidu.navisdk.ui.util.b.b());
        return this.c;
    }

    private void G0() {
        BNCommonTitleBar bNCommonTitleBar = this.d;
        if (bNCommonTitleBar != null) {
            if (this.l) {
                bNCommonTitleBar.setRightText("完成");
            } else {
                bNCommonTitleBar.setRightText("编辑");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "handleClickAllShortcutFunc: " + i2 + ",isEditState: " + this.l);
        }
        if (this.l) {
            RGShortcutPageVM rGShortcutPageVM = this.p;
            if (rGShortcutPageVM != null) {
                rGShortcutPageVM.addCustomShortcut(i2);
                return;
            }
            return;
        }
        q(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "handleClickCustomShortcutFunc: " + i2 + ",isEditState: " + this.l);
        }
        if (i2 == 0) {
            return;
        }
        if (this.l) {
            RGShortcutPageVM rGShortcutPageVM = this.p;
            if (rGShortcutPageVM != null) {
                rGShortcutPageVM.removeCustomShortcut(i2);
                return;
            }
            return;
        }
        q(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "onDayNightChanged: " + z);
        }
        BNCommonTitleBar bNCommonTitleBar = this.d;
        if (bNCommonTitleBar != null) {
            if (z) {
                bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.bnav_titlebar_bg));
                BNCommonTitleBar bNCommonTitleBar2 = this.d;
                int i2 = R.color.bnav_titlebar_middle_text;
                bNCommonTitleBar2.setMiddleTextColor(com.baidu.navisdk.ui.util.b.b(i2));
                this.d.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_titlebar_ic_back_new));
                this.d.setRightTextColor(com.baidu.navisdk.ui.util.b.b(i2));
            } else {
                bNCommonTitleBar.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_d, false));
                this.d.setMiddleTextColor(Color.parseColor("#ffffff"));
                this.d.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.c(R.drawable.bnav_titlebar_ic_back_normal, false));
                this.d.setRightTextColor(Color.parseColor("#ffffff"));
            }
        }
        TextView textView = this.u;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_a, z));
        }
        TextView textView2 = this.t;
        if (textView2 != null) {
            textView2.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_a, z));
        }
        View view = this.v;
        if (view != null) {
            view.setBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_b, z));
        }
        View view2 = this.w;
        if (view2 != null) {
            view2.setBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_b, z));
        }
    }

    private void x0() {
        ViewModelProvider viewModelProvider;
        if (this.q != null && (viewModelProvider = this.r) != null) {
            RGShortcutPageVM rGShortcutPageVM = (RGShortcutPageVM) viewModelProvider.get(RGShortcutPageVM.class);
            this.p = rGShortcutPageVM;
            rGShortcutPageVM.getAllShortcutLiveData().observe(this.q, new g());
            this.p.getCustomShortcutLiveData().observe(this.q, new h());
            this.p.getShortcutStateChangeLiveData().observe(this.q, new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "enterEditState: ");
        }
        this.l = true;
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "exitEditState: ");
        }
        this.l = false;
        A0();
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.b
    public void C() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "onFinishDrag: ");
        }
        RGShortcutPageVM rGShortcutPageVM = this.p;
        if (rGShortcutPageVM != null) {
            rGShortcutPageVM.changeCustomShortcutPosition(this.h);
        }
    }

    public void b0() {
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new b(this));
        }
        C0257c c0257c = new C0257c(this.f);
        this.k = c0257c;
        this.f.addOnItemTouchListener(c0257c);
        this.n.addOnItemTouchListener(new d(this.n));
        BNCommonTitleBar bNCommonTitleBar = this.d;
        if (bNCommonTitleBar != null) {
            bNCommonTitleBar.setRightOnClickedListener(new e());
            this.d.setLeftOnClickedListener(new f());
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onDestroy() {
        if (j.d()) {
            com.baidu.navisdk.module.asr.a.b().a(true);
        }
        if (this.s != null) {
            com.baidu.navisdk.comapi.commontool.a.getInstance().deleteObserver(this.s);
            this.s = null;
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.c = null;
        }
        this.f7280a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onPause() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onResume() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStart() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStop() {
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.b
    public void v0() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.l
    public void a(com.baidu.navisdk.framework.interfaces.l lVar) {
        this.f7280a = lVar;
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void a(Context context, Bundle bundle) {
        D0();
        com.baidu.navisdk.comapi.commontool.a.getInstance().addObserver(this.s);
        if (j.d()) {
            com.baidu.navisdk.module.asr.a.b().a(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.framework.interfaces.i
    public View a(Activity activity, Bundle bundle, View view) {
        this.b = activity;
        a(bundle);
        if (activity instanceof FragmentActivity) {
            this.q = (LifecycleOwner) activity;
            this.r = com.baidu.navisdk.module.newguide.viewmodels.b.b((FragmentActivity) activity, bundle);
        }
        return F0();
    }

    private void a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "parseConfig: " + bundle);
        }
        if (bundle != null) {
            bundle.getBoolean("is_new_energy_car", false);
        }
    }

    private void q(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutPageImpl", "onClickShortcutFun: " + i2);
        }
        com.baidu.navisdk.framework.interfaces.l lVar = this.f7280a;
        if (lVar != null) {
            lVar.a();
        }
        com.baidu.navisdk.framework.message.a.a().a(new q(i2));
    }
}
