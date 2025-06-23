package com.baidu.navisdk.ui.chargelist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes8.dex */
public class b extends RecyclerView.Adapter<e> {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.c> f8358a;
    private ArrayList<Integer> b = new ArrayList<>();
    private c c = null;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f8359a;
        final /* synthetic */ com.baidu.navisdk.ui.chargelist.data.beans.c b;

        public a(e eVar, com.baidu.navisdk.ui.chargelist.data.beans.c cVar) {
            this.f8359a = eVar;
            this.b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (-1 == this.f8359a.getAdapterPosition()) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("20.0.18.2", this.b.b() + "");
            if (b.this.c != null) {
                HashSet hashSet = new HashSet();
                if (this.f8359a.getAdapterPosition() == 0) {
                    hashSet.add(Integer.valueOf(((com.baidu.navisdk.ui.chargelist.data.beans.c) b.this.f8358a.get(0)).b()));
                    Iterator it = b.this.f8358a.iterator();
                    while (it.hasNext()) {
                        com.baidu.navisdk.ui.chargelist.data.beans.c cVar = (com.baidu.navisdk.ui.chargelist.data.beans.c) it.next();
                        if (cVar.b() != 0) {
                            cVar.a(false);
                        }
                    }
                } else {
                    this.b.a(!r0.c());
                    Iterator it2 = b.this.f8358a.iterator();
                    while (it2.hasNext()) {
                        com.baidu.navisdk.ui.chargelist.data.beans.c cVar2 = (com.baidu.navisdk.ui.chargelist.data.beans.c) it2.next();
                        if (cVar2.c()) {
                            hashSet.add(Integer.valueOf(cVar2.b()));
                        }
                    }
                }
                b.this.c.a(hashSet);
                b.this.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.chargelist.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0405b extends e {
        public C0405b(@NonNull b bVar, View view) {
            super(bVar, view);
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(Set<Integer> set);
    }

    /* loaded from: classes8.dex */
    public class d extends e {
        public d(@NonNull b bVar, View view) {
            super(bVar, view);
            this.f8360a = (TextView) view.findViewById(R.id.bnavi_ele_type);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f8360a;

        public e(@NonNull b bVar, View view) {
            super(view);
        }
    }

    public b(Context context, ArrayList<com.baidu.navisdk.ui.chargelist.data.beans.c> arrayList) {
        this.f8358a = new ArrayList<>();
        this.f8358a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f8358a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull e eVar, int i) {
        com.baidu.navisdk.ui.chargelist.data.beans.c cVar = this.f8358a.get(i);
        if (eVar.f8360a != null) {
            if (this.b.size() <= 0) {
                eVar.f8360a.setText(cVar.a());
            } else {
                for (int i2 = 0; i2 < this.b.size() - 1 && this.b.get(i2).intValue() != cVar.b(); i2++) {
                    eVar.f8360a.setText(cVar.a());
                }
            }
            if (cVar.c()) {
                eVar.f8360a.setSelected(true);
                eVar.f8360a.setBackgroundResource(R.drawable.nsdk_energy_charge_tv_select);
                eVar.f8360a.setTextColor(Color.parseColor("#FF1FCCA1"));
            } else {
                eVar.f8360a.setSelected(false);
                eVar.f8360a.setBackgroundResource(R.drawable.nsdk_energy_charge_tv_noselect);
                eVar.f8360a.setTextColor(Color.parseColor("#FF11141A"));
            }
        }
        eVar.itemView.setOnClickListener(new a(eVar, cVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new C0405b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bnav_layout_charge_list_filter_item_all, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bnav_layout_charge_list_filter_item_other, viewGroup, false));
    }

    public void a(c cVar) {
        this.c = cVar;
    }
}
