package com.baidu.navisdk.ui.routeguide.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.e;
import com.baidu.navisdk.ui.routeguide.control.x;
import java.util.List;

/* loaded from: classes8.dex */
public class c extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    private List<e> f8440a;
    private InterfaceC0412c b = null;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8441a;
        final /* synthetic */ e b;

        public a(int i, e eVar) {
            this.f8441a = i;
            this.b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.b != null) {
                c.this.b.a(this.f8441a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        TextView f8442a;

        public b(@NonNull c cVar, View view) {
            super(view);
            this.f8442a = (TextView) view.findViewById(R.id.banv_zone_type);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.adapter.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0412c {
        void a(int i, e eVar);
    }

    public c(List<e> list) {
        this.f8440a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<e> list = this.f8440a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(List<e> list) {
        this.f8440a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this, com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().c(), R.layout.nsdk_layout_rg_mapmode_service_area_zone_item));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        e eVar = this.f8440a.get(i);
        bVar.f8442a.setText(eVar.b());
        bVar.f8442a.setOnClickListener(new a(i, eVar));
        boolean s2 = x.b().s2();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) bVar.f8442a.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RecyclerView.LayoutParams(-1, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_36dp));
        }
        if (!s2) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_107dp);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        }
        bVar.f8442a.setLayoutParams(layoutParams);
    }

    public void a(InterfaceC0412c interfaceC0412c) {
        this.b = interfaceC0412c;
    }
}
