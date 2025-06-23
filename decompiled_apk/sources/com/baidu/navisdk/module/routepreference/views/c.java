package com.baidu.navisdk.module.routepreference.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routepreference.j;
import com.baidu.navisdk.module.routepreference.views.a;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.module.routepreference.views.a {

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7492a;

        public a(b bVar) {
            this.f7492a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition;
            j jVar;
            if (view == null || c.this.d == null || (adapterPosition = this.f7492a.getAdapterPosition()) < 0 || (jVar = c.this.d.get(adapterPosition)) == null) {
                return;
            }
            c cVar = c.this;
            int i = jVar.b;
            cVar.e = i;
            a.InterfaceC0282a interfaceC0282a = cVar.b;
            if (interfaceC0282a != null) {
                interfaceC0282a.b(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        View f7493a;
        View b;
        TextView c;
        View d;

        public b(View view) {
            super(view);
            this.c = (TextView) view.findViewById(R.id.nsdk_route_sort_item_tv);
            this.d = view.findViewById(R.id.nsdk_route_sort_default_tips_layout);
            this.f7493a = view.findViewById(R.id.nsdk_route_sort_item_divider_vertical);
            this.b = view.findViewById(R.id.nsdk_route_sort_item_divider_bottom);
        }
    }

    public c(Context context, com.baidu.navisdk.module.routepreference.interfaces.b bVar, ArrayList<j> arrayList, int i, int i2) {
        super(context, bVar, arrayList, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        j jVar;
        b bVar = (b) viewHolder;
        bVar.itemView.setOnClickListener(new a(bVar));
        if ((i + 1) % com.baidu.navisdk.module.routepreference.views.a.g == 0) {
            bVar.f7493a.setVisibility(4);
        } else {
            bVar.f7493a.setVisibility(0);
        }
        if (i >= com.baidu.navisdk.module.routepreference.views.a.g) {
            bVar.b.setVisibility(4);
        } else {
            bVar.b.setVisibility(0);
        }
        View view = bVar.f7493a;
        int i2 = R.color.nsdk_cl_bg_d_mm;
        view.setBackgroundColor(a(i2));
        bVar.b.setBackgroundColor(a(i2));
        bVar.itemView.setBackgroundDrawable(b(R.drawable.nsdk_common_bt_pressed_bg));
        List<j> list = this.d;
        if (list == null || i < 0 || i >= list.size() || (jVar = this.d.get(i)) == null) {
            return;
        }
        bVar.c.setText(jVar.f7486a);
        int i3 = jVar.b;
        int i4 = this.e;
        if ((i3 & i4) != 0 && com.baidu.navisdk.module.routepreference.c.g(i4) == 1) {
            bVar.c.setTextColor(a(R.color.nsdk_route_sort_setting_default));
            bVar.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(jVar.a(true)), (Drawable) null, (Drawable) null);
        } else {
            bVar.c.setTextColor(a(R.color.nsdk_route_sort_item_text));
            bVar.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, b(jVar.a(false)), (Drawable) null, (Drawable) null);
        }
        if ((jVar.b & this.f) != 0) {
            bVar.d.setVisibility(0);
        } else {
            bVar.d.setVisibility(4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(JarUtils.inflate(this.c, R.layout.nsdk_layout_route_sort_child_grid_item, null));
    }
}
