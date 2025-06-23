package com.baidu.navisdk.module.newguide.settings.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.newguide.recommendvoice.a;
import com.baidu.navisdk.module.newguide.settings.g;
import com.baidu.navisdk.module.newguide.settings.i;
import com.baidu.navisdk.module.newguide.settings.shortcut.views.RGShortcutFunCellView;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class e extends g.b {
    private final RecyclerView b;
    private final C0262e c;
    private ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> d;
    private final com.baidu.navisdk.module.newguide.settings.i.a e;
    private com.baidu.navisdk.module.newguide.recommendvoice.a f;
    private View g;
    private BNSettingExplainSwitchItem h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.module.newguide.settings.viewmodel.a I;
            if (e.this.e != null && (I = e.this.e.I()) != null) {
                I.f(e.this.b(e.this.b.getChildAdapterPosition(view)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList) {
            e.this.d = arrayList;
            if (e.this.c != null) {
                e.this.c.a(e.this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Observer<Boolean> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "SETTING_PAGE_STATUS onChanged: " + bool);
            }
            if (e.this.f != null) {
                e.this.f.a(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Observer<Boolean> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "ROAD_CONDITION onChanged: " + bool);
            }
            if (e.this.h != null) {
                e.this.h.setChecked(bool.booleanValue());
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.settings.viewholder.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0262e extends RecyclerView.Adapter<f> {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> f7326a;
        private final View.OnClickListener b;
        private final com.baidu.navisdk.module.newguide.recommendvoice.a c;

        public C0262e(View.OnClickListener onClickListener, com.baidu.navisdk.module.newguide.recommendvoice.a aVar) {
            this.b = onClickListener;
            this.c = aVar;
        }

        public void a(ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList) {
            this.f7326a = arrayList;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(@NonNull f fVar) {
            super.onViewRecycled(fVar);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "onViewRecycled: " + fVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = this.f7326a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar = this.f7326a.get(i);
            if (this.c != null && aVar.f7279a == 6) {
                return 1;
            }
            return 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onDetachedFromRecyclerView(recyclerView);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "onDetachedFromRecyclerView: ");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public f onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return this.c.a(viewGroup, this.b);
            }
            View a2 = com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_shortcut_func_item, viewGroup, false);
            a2.setOnClickListener(this.b);
            return new f(a2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull f fVar, int i) {
            if (fVar instanceof a.e) {
                ((a.e) fVar).a(this.f7326a.get(i));
            } else {
                fVar.a(this.f7326a.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onViewDetachedFromWindow(@NonNull f fVar) {
            super.onViewDetachedFromWindow(fVar);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ShortcutFuncGroupItemVi", "onViewDetachedFromWindow: " + fVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final RGShortcutFunCellView f7327a;

        public f(View view) {
            super(view);
            if (view instanceof RGShortcutFunCellView) {
                this.f7327a = (RGShortcutFunCellView) view;
            } else {
                this.f7327a = null;
            }
        }

        public void a(com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar) {
            RGShortcutFunCellView rGShortcutFunCellView = this.f7327a;
            if (rGShortcutFunCellView != null) {
                rGShortcutFunCellView.setTextContent(aVar.b);
                this.f7327a.a(aVar.c);
                i.a(aVar.b, this.f7327a.getBubbleView());
            }
        }
    }

    public e(Context context, View view, BNSettingExplainSwitchItem.c cVar, g.a aVar, com.baidu.navisdk.module.newguide.settings.i.a aVar2) {
        super(1, view, aVar);
        this.e = aVar2;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bn_rg_setting_group_shortcut);
        this.b = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusableInTouchMode(false);
        recyclerView.addItemDecoration(new com.baidu.navisdk.module.newguide.widgets.a(4, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp), 0));
        if (j.d()) {
            this.f = new com.baidu.navisdk.module.newguide.recommendvoice.a();
        }
        C0262e c0262e = new C0262e(new a(), this.f);
        this.c = c0262e;
        recyclerView.setAdapter(c0262e);
        this.g = view.findViewById(R.id.nav_new_road_condition_layout);
        this.h = (BNSettingExplainSwitchItem) view.findViewById(R.id.nav_new_road_condition_item);
        if (aVar2 != null) {
            com.baidu.navisdk.module.newguide.settings.viewmodel.a I = aVar2.I();
            LifecycleOwner J = aVar2.J();
            if (I != null && J != null) {
                I.f().observe(J, new b());
                I.a(26).observe(J, new c());
                I.a(29).observe(J, new d());
            }
        }
        this.h.setOnCheckedListener(cVar);
        if (com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true)) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
        b();
    }

    private void b() {
        if (!com.baidu.navisdk.function.b.FUNC_GROUP_SHORTCUT.a()) {
            this.itemView.findViewById(R.id.shortcut_group).setVisibility(8);
        }
        if (!com.baidu.navisdk.function.b.FUNC_ROAD_CONDITION_SWITCH.a()) {
            this.g.setVisibility(8);
        }
        if (a()) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
            }
            this.itemView.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.settings.g.b, com.baidu.navisdk.module.newguide.settings.g.c
    public void a(com.baidu.navisdk.module.newguide.settings.model.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.g.b
    public boolean a() {
        if ((com.baidu.navisdk.function.b.FUNC_ROAD_CONDITION_SWITCH.a() && com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true)) || com.baidu.navisdk.function.b.FUNC_GROUP_SHORTCUT.a()) {
            return super.a();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        int size;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ShortcutFuncGroupItemVi", "getShortcutId: " + i);
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = this.d;
        if (arrayList == null || i < 0 || i >= (size = arrayList.size())) {
            return 0;
        }
        com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar = this.d.get(i);
        if (gVar.d()) {
            gVar.e("ShortcutFuncGroupItemVi", "getShortcutId: " + size + ", " + aVar);
        }
        if (aVar != null) {
            return aVar.f7279a;
        }
        return 0;
    }
}
