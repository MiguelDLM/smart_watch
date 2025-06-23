package com.baidu.navisdk.module.newguide.settings.shortcut.views;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.settings.drag.a;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes7.dex */
public class b extends RecyclerView.Adapter<a> implements a.InterfaceC0253a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> f7290a;
    private boolean b;

    /* loaded from: classes7.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private RGShortcutFunImgTipCell f7291a;

        public a(RGShortcutFunImgTipCell rGShortcutFunImgTipCell) {
            super(rGShortcutFunImgTipCell);
            this.f7291a = rGShortcutFunImgTipCell;
        }

        public void a(com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar, boolean z) {
            if (aVar == null) {
                this.f7291a.setTextContent("待添加");
                this.f7291a.a(R.drawable.nsdk_ic_shortcut_placehold);
                this.f7291a.setTag(0);
                z = false;
            } else {
                this.f7291a.setTextContent(aVar.b);
                this.f7291a.a(aVar.c);
                this.itemView.setTag(Integer.valueOf(aVar.f7279a));
            }
            if (z) {
                this.f7291a.setTipVisibility(0);
                this.f7291a.setTipView(R.drawable.nsdk_ic_shortcut_del);
            } else {
                this.f7291a.setTipVisibility(4);
                this.f7291a.setTipView(0);
            }
        }
    }

    public b(ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList, boolean z) {
        this.f7290a = arrayList;
        this.b = z;
    }

    @Nullable
    private com.baidu.navisdk.module.newguide.settings.shortcut.beans.a d(int i) {
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = this.f7290a;
        if (arrayList != null && !arrayList.isEmpty() && i < this.f7290a.size()) {
            return this.f7290a.get(i);
        }
        return null;
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
        int i2;
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = this.f7290a;
        if (arrayList != null) {
            i2 = arrayList.size();
        } else {
            i2 = 0;
        }
        if (i < i2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2;
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = this.f7290a;
        if (arrayList != null) {
            i2 = arrayList.size();
        } else {
            i2 = 0;
        }
        if (i >= i2) {
            return 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        aVar.a(d(i), this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((RGShortcutFunImgTipCell) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nsdk_layout_rg_shortcut_func_imgtip_cell, viewGroup, false));
    }

    @Override // com.baidu.navisdk.module.newguide.settings.drag.a.InterfaceC0253a
    public void a(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutCustomAdapter", "onMove fromPosition:" + i + ", toPosition:" + i2);
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = this.f7290a;
        int size = arrayList != null ? arrayList.size() : 0;
        if (i < 0 || i >= size || i2 < 0 || i2 >= size) {
            return;
        }
        if (i < i2) {
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(this.f7290a, i3, i4);
                i3 = i4;
            }
        } else {
            for (int i5 = i; i5 > i2; i5--) {
                Collections.swap(this.f7290a, i5, i5 - 1);
            }
        }
        notifyItemMoved(i, i2);
    }

    public void a(ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList) {
        this.f7290a = arrayList;
        notifyDataSetChanged();
    }

    public void a(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGShortcutCustomAdapter", "changeEditState new:" + z + ", old:" + this.b);
        }
        if (z == this.b) {
            return;
        }
        this.b = z;
        notifyDataSetChanged();
    }
}
