package com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.r;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes8.dex */
public class b extends RecyclerView.Adapter<c> {

    /* renamed from: a, reason: collision with root package name */
    private Context f8859a;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.a b;
    private ArrayList<r> c;
    private int d;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8860a;

        public a(int i) {
            this.f8860a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.b != null) {
                b.this.b.a(view, this.f8860a);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0462b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8861a;

        public ViewOnClickListenerC0462b(int i) {
            this.f8861a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.b != null) {
                b.this.b.a(view, this.f8861a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        ImageView f8862a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        TextView f;
        TextView g;
        TextView h;
        View i;
        View j;
        View k;
        View l;
        TextView m;
        LinearLayout n;
        LinearLayout o;
        LinearLayout p;

        public c(View view) {
            super(view);
            this.f8862a = (ImageView) view.findViewById(R.id.parking_icon);
            this.b = (TextView) view.findViewById(R.id.parking_name);
            this.c = (TextView) view.findViewById(R.id.parking_number);
            this.d = (TextView) view.findViewById(R.id.parking_distance);
            this.e = (TextView) view.findViewById(R.id.parking_cost);
            this.f = (TextView) view.findViewById(R.id.parking_label_desc);
            this.g = (TextView) view.findViewById(R.id.parking_label_type);
            this.h = (TextView) view.findViewById(R.id.parking_label_reservable);
            this.i = view.findViewById(R.id.parking_split_line);
            this.j = view.findViewById(R.id.parking_split_one);
            this.k = view.findViewById(R.id.parking_split_two);
            this.l = view.findViewById(R.id.parking_goto);
            this.m = (TextView) view.findViewById(R.id.parking_goto_tv);
            this.n = (LinearLayout) view.findViewById(R.id.parking_content);
            this.o = (LinearLayout) view.findViewById(R.id.parking_second_line_content);
            this.p = (LinearLayout) view.findViewById(R.id.parking_third_line_content);
        }
    }

    public b(Context context, com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.a aVar, ArrayList<r> arrayList, int i) {
        this.f8859a = context;
        this.b = aVar;
        this.c = arrayList;
        this.d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<r> arrayList = this.c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        int i2;
        boolean z;
        r rVar = this.c.get(i);
        if (rVar == null) {
            return;
        }
        cVar.f8862a.setImageDrawable(com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.c.a(i, i == this.d));
        cVar.b.setText(rVar.j);
        if (rVar.e < 0) {
            cVar.c.setVisibility(8);
            i2 = 0;
            z = false;
        } else {
            if (rVar.f < 0) {
                cVar.c.setText(String.format(Locale.getDefault(), "%d总", Integer.valueOf(rVar.e)));
            } else {
                cVar.c.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive_dest_park_desc, String.valueOf(rVar.f), String.valueOf(rVar.e)));
            }
            i2 = 1;
            z = true;
        }
        if (rVar.g <= 0) {
            cVar.d.setVisibility(8);
        } else {
            i2++;
            String format = String.format(Locale.getDefault(), "%.1f", Double.valueOf(rVar.g / 1000.0d));
            cVar.d.setVisibility(0);
            cVar.d.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive_dest_park_distance, format));
        }
        if (TextUtils.isEmpty(rVar.n)) {
            cVar.e.setVisibility(8);
        } else {
            i2++;
            cVar.e.setVisibility(0);
            cVar.e.setText(rVar.n);
        }
        if (i2 == 3) {
            cVar.j.setVisibility(0);
            cVar.k.setVisibility(0);
        } else if (i2 != 2) {
            cVar.j.setVisibility(8);
            cVar.k.setVisibility(8);
        } else if (z) {
            cVar.j.setVisibility(0);
            cVar.k.setVisibility(8);
        } else {
            cVar.j.setVisibility(8);
            cVar.k.setVisibility(0);
        }
        if (TextUtils.isEmpty(rVar.q)) {
            cVar.f.setVisibility(8);
        } else {
            cVar.f.setVisibility(0);
            cVar.f.setText(rVar.q);
            if (!TextUtils.equals(rVar.q, "空") && !TextUtils.equals(rVar.q, "车位充足")) {
                cVar.f.setSelected(true);
            } else {
                cVar.f.setSelected(false);
            }
        }
        String a2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.c.a(rVar.p);
        if (TextUtils.isEmpty(a2)) {
            cVar.g.setVisibility(8);
        } else {
            cVar.g.setVisibility(0);
            cVar.g.setText(a2);
        }
        String a3 = com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.c.a(rVar.r);
        if (TextUtils.isEmpty(a3)) {
            cVar.h.setVisibility(8);
        } else {
            cVar.h.setVisibility(0);
            cVar.h.setText(a3);
        }
        int d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_92dp);
        if (com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.c.a(rVar)) {
            cVar.o.setVisibility(8);
            d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_70dp);
        } else {
            cVar.o.setVisibility(0);
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.c.b(rVar)) {
            cVar.p.setVisibility(8);
            d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_70dp);
        } else {
            cVar.p.setVisibility(0);
        }
        ViewGroup.LayoutParams layoutParams = cVar.n.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = d;
            cVar.n.setLayoutParams(layoutParams);
        }
        if (i == this.c.size() - 1) {
            cVar.i.setVisibility(4);
        } else {
            cVar.i.setVisibility(0);
        }
        a(cVar);
        cVar.itemView.setOnClickListener(new a(i));
        cVar.l.setOnClickListener(new ViewOnClickListenerC0462b(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(com.baidu.navisdk.ui.util.b.a(this.f8859a, R.layout.nsdk_layout_rg_mapmode_arrive_dest_parking_item, null));
    }

    public void a(c cVar) {
        com.baidu.navisdk.ui.util.b.a(cVar.b, R.color.nsdk_cl_text_a);
        TextView textView = cVar.c;
        int i = R.color.nsdk_cl_text_i;
        com.baidu.navisdk.ui.util.b.a(textView, i);
        com.baidu.navisdk.ui.util.b.a(cVar.d, i);
        com.baidu.navisdk.ui.util.b.a(cVar.e, i);
        com.baidu.navisdk.ui.util.b.a(cVar.g, i);
        TextView textView2 = cVar.g;
        int i2 = R.drawable.nsdk_drawable_rg_arrive_dest_park_normal;
        com.baidu.navisdk.ui.util.b.a((View) textView2, i2);
        com.baidu.navisdk.ui.util.b.a(cVar.h, i);
        com.baidu.navisdk.ui.util.b.a((View) cVar.h, i2);
        com.baidu.navisdk.ui.util.b.a(cVar.m, i);
        com.baidu.navisdk.ui.util.b.a(cVar.i, R.color.nsdk_cl_bg_b);
        View view = cVar.j;
        int i3 = R.color.nsdk_cl_bg_g;
        com.baidu.navisdk.ui.util.b.a(view, i3);
        com.baidu.navisdk.ui.util.b.a(cVar.k, i3);
    }

    public void a(ArrayList<r> arrayList, int i) {
        this.c = arrayList;
        this.d = i;
        notifyDataSetChanged();
    }
}
