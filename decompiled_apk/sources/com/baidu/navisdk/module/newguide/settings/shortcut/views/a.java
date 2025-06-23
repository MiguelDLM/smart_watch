package com.baidu.navisdk.module.newguide.settings.shortcut.views;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a extends RecyclerView.Adapter<C0258a> {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> f7288a;
    private boolean b;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.shortcut.views.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0258a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private RGShortcutFunCellView f7289a;

        public C0258a(RGShortcutFunCellView rGShortcutFunCellView) {
            super(rGShortcutFunCellView);
            this.f7289a = rGShortcutFunCellView;
        }

        public void a(com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar, boolean z) {
            if (aVar == null) {
                g gVar = g.PRO_NAV;
                if (gVar.c()) {
                    gVar.c("RGAllShortcutAdapter", "update data == null");
                    return;
                }
                return;
            }
            this.f7289a.setTextContent(aVar.b);
            this.f7289a.a(aVar.c);
            this.itemView.setTag(Integer.valueOf(aVar.f7279a));
            if (z) {
                this.f7289a.setTipVisibility(0);
                if (aVar.g) {
                    this.f7289a.setTipView(R.drawable.nsdk_ic_shortcut_added);
                    return;
                } else {
                    this.f7289a.setTipView(R.drawable.nsdk_ic_shortcut_add);
                    return;
                }
            }
            this.f7289a.setTipVisibility(4);
        }
    }

    public a(SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> sparseArray, boolean z) {
        this.f7288a = sparseArray;
        this.b = z;
    }

    @Nullable
    private com.baidu.navisdk.module.newguide.settings.shortcut.beans.a b(int i) {
        SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> sparseArray = this.f7288a;
        if (sparseArray != null && sparseArray.size() != 0 && i < this.f7288a.size()) {
            return this.f7288a.valueAt(i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C0258a c0258a, int i) {
        c0258a.a(b(i), this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> sparseArray = this.f7288a;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        return 0;
    }

    private int a(int i) {
        SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> sparseArray = this.f7288a;
        if (sparseArray == null || sparseArray.size() == 0) {
            return -1;
        }
        return this.f7288a.indexOfKey(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public C0258a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C0258a((RGShortcutFunCellView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nsdk_layout_rg_shortcut_all_func_cell, viewGroup, false));
    }

    public void a(SparseArray<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> sparseArray, boolean z) {
        this.b = z;
        this.f7288a = sparseArray;
        notifyDataSetChanged();
    }

    public void a(com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAllShortcutAdapter", "changeShortcut: " + aVar);
        }
        if (aVar == null) {
            return;
        }
        int a2 = a(aVar.f7279a);
        if (gVar.d()) {
            gVar.e("RGAllShortcutAdapter", "changeShortcut position: " + a2);
        }
        if (a2 >= 0) {
            notifyItemChanged(a2);
        }
    }

    public void a(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAllShortcutAdapter", "changeEditState new:" + z + ", old:" + this.b);
        }
        if (z == this.b) {
            return;
        }
        this.b = z;
        notifyDataSetChanged();
    }
}
