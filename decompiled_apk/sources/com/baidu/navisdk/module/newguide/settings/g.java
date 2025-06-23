package com.baidu.navisdk.module.newguide.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.settings.drag.a;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingExplainSwitchItem;
import com.baidu.navisdk.module.vehiclemanager.widgets.BNSettingNewTextRadioGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class g extends RecyclerView.Adapter<c> implements a.InterfaceC0253a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> f7269a;
    private View.OnClickListener c;
    private BNSettingNewTextRadioGroup.a d;
    private a e;
    private BNSettingExplainSwitchItem.c f;
    private com.baidu.navisdk.module.newguide.settings.i.a g;
    private boolean b = false;
    private String h = null;
    private String i = null;
    private Map<String, b> j = new HashMap();

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view);
    }

    /* loaded from: classes7.dex */
    public static class b extends c {

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f7270a;

            public a(b bVar, a aVar) {
                this.f7270a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.navisdk.ui.util.g.a()) {
                    return;
                }
                a aVar = this.f7270a;
                if (aVar != null) {
                    aVar.a(view);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.7.4");
            }
        }

        public b(int i, View view, a aVar) {
            super(view);
            view.setTag(Integer.valueOf(i));
            view.findViewById(R.id.bn_rg_setting_group_sort).setOnClickListener(new a(this, aVar));
        }

        public boolean a() {
            return false;
        }

        @Override // com.baidu.navisdk.module.newguide.settings.g.c
        public void a(com.baidu.navisdk.module.newguide.settings.model.e eVar) {
            super.a(eVar);
            this.itemView.setTag(Integer.valueOf(eVar.f7278a));
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends c {
        public d(View view) {
            super(view);
        }

        public void a() {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
            }
            this.itemView.setVisibility(8);
        }
    }

    public g(ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList, com.baidu.navisdk.module.newguide.settings.i.a aVar) {
        this.f7269a = arrayList;
        this.g = aVar;
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.InterfaceC0253a
    public boolean a(int i) {
        return true;
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.InterfaceC0253a
    public void b(int i) {
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.InterfaceC0253a
    public boolean c(int i) {
        com.baidu.navisdk.module.newguide.settings.model.e eVar;
        if (!this.b || i < 0) {
            return true;
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList = this.f7269a;
        if (arrayList != null && arrayList.size() > i) {
            eVar = this.f7269a.get(i);
        } else {
            eVar = null;
        }
        if (eVar != null) {
            return !eVar.c;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList = this.f7269a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.b) {
            return this.f7269a.get(i).f7278a + 100;
        }
        return this.f7269a.get(i).f7278a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageAdapter", "onDetachedFromRecyclerView: ");
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        protected TextView f7271a;

        public c(View view) {
            super(view);
            this.f7271a = (TextView) view.findViewById(R.id.bn_rg_setting_group_title_func);
        }

        public void a(com.baidu.navisdk.module.newguide.settings.model.e eVar) {
            int i = eVar.f7278a;
            this.f7271a.setText(eVar.b);
        }

        @Nullable
        public <T extends View> T a(@IdRes int i) {
            return (T) this.itemView.findViewById(i);
        }
    }

    public void a(View.OnClickListener onClickListener, BNSettingNewTextRadioGroup.a aVar, a aVar2, BNSettingExplainSwitchItem.c cVar) {
        this.c = onClickListener;
        this.d = aVar;
        this.e = aVar2;
        this.f = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NonNull c cVar) {
        super.onViewRecycled(cVar);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageAdapter", "onViewRecycled: ");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        b eVar;
        Context context = viewGroup.getContext();
        if (this.b) {
            d dVar = new d(com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_group_title_item, viewGroup, false));
            Map<String, b> map = this.j;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 100;
            sb.append(i2);
            sb.append("SettingsGroupType");
            if (map.get(sb.toString()) != null) {
                if (this.j.get(i2 + "SettingsGroupType").a()) {
                    dVar.a();
                }
            }
            return dVar;
        }
        if (i == 1) {
            eVar = new com.baidu.navisdk.module.newguide.settings.viewholder.e(viewGroup.getContext(), com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_shortcut_item, viewGroup, false), this.f, this.e, this.g);
        } else if (i == 2) {
            eVar = new com.baidu.navisdk.module.newguide.settings.viewholder.b(context, com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_navi_route_item, viewGroup, false), this.c, this.e, this.g, this.f);
        } else if (i == 3) {
            eVar = new com.baidu.navisdk.module.newguide.settings.viewholder.d(com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_navi_voice_item, viewGroup, false), this.c, this.d, this.e, this.g);
        } else if (i != 4) {
            eVar = new com.baidu.navisdk.module.newguide.settings.viewholder.a(com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_navi_assist_func_item, viewGroup, false), this.c, this.f, this.d, this.e, this.g);
        } else {
            eVar = new com.baidu.navisdk.module.newguide.settings.viewholder.c(com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_navi_show_item, viewGroup, false), this.f, this.d, this.e, this.g);
        }
        this.j.put(i + "SettingsGroupType", eVar);
        return eVar;
    }

    public String b() {
        return this.h;
    }

    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageAdapter", "setSortStatus oldStatus:" + this.b + ", new:" + z);
        }
        this.b = z;
        notifyDataSetChanged();
    }

    public void a(ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList) {
        this.f7269a = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        cVar.a(this.f7269a.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NonNull c cVar) {
        super.onViewDetachedFromWindow(cVar);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageAdapter", "onViewDetachedFromWindow: ");
        }
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.InterfaceC0253a
    public void a(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageAdapter", "onMove fromPosition:" + i + ", toPosition:" + i2);
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList = this.f7269a;
        int size = arrayList != null ? arrayList.size() : 0;
        if (i < 0 || i >= size || i2 < 0 || i2 >= size) {
            return;
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList2 = this.f7269a;
        String valueOf = (arrayList2 == null || arrayList2.get(i) == null) ? null : String.valueOf(this.f7269a.get(i).f7278a);
        String valueOf2 = String.valueOf(i2 + 1);
        if (i < i2) {
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(this.f7269a, i3, i4);
                i3 = i4;
            }
        } else {
            for (int i5 = i; i5 > i2; i5--) {
                Collections.swap(this.f7269a, i5, i5 - 1);
            }
        }
        notifyItemMoved(i, i2);
        a(valueOf, valueOf2);
    }

    private void a(String str, String str2) {
        if (str != null) {
            this.h = str;
        }
        if (str2 != null) {
            this.i = str2;
        }
    }

    public String a() {
        return this.i;
    }
}
