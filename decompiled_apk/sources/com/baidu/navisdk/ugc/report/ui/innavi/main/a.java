package com.baidu.navisdk.ugc.report.ui.innavi.main;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ugc.replenishdetails.UgcReplenishDetailsTipsLayout;
import com.baidu.navisdk.ugc.utils.k;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class a extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    private Context f8275a;
    private com.baidu.navisdk.ugc.report.ui.innavi.main.c b;
    private int c;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> d;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> e;
    private ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> f;
    private int g;
    private int h;
    private LayoutInflater i;
    d j;
    int k = 0;
    int l = 0;
    int m = 0;
    ArrayList<Integer> n;
    private boolean o;

    /* renamed from: com.baidu.navisdk.ugc.report.ui.innavi.main.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0393a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f8276a;

        public C0393a(GridLayoutManager gridLayoutManager) {
            this.f8276a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            int itemViewType = a.this.getItemViewType(i);
            if (itemViewType == 1 || itemViewType == 5 || itemViewType == 6) {
                return 1;
            }
            return this.f8276a.getSpanCount();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.ViewHolder {
        public b(a aVar, View view) {
            super(view);
        }

        public void a(com.baidu.navisdk.ugc.report.data.datarepository.b bVar) {
        }

        public void a(String str) {
        }
    }

    /* loaded from: classes8.dex */
    public class c extends b {
        public c(a aVar, View view) {
            super(aVar, view);
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(UgcReplenishDetailsTipsLayout ugcReplenishDetailsTipsLayout);
    }

    /* loaded from: classes8.dex */
    public class e extends b {

        /* renamed from: a, reason: collision with root package name */
        TextView f8277a;

        public e(a aVar, View view) {
            super(aVar, view);
            this.f8277a = (TextView) view.findViewById(R.id.ugc_navi_report_subtitle);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.a.b
        public void a(String str) {
            this.f8277a.setText(str);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends b {

        /* renamed from: a, reason: collision with root package name */
        TextView f8278a;
        ImageView b;
        int c;

        /* renamed from: com.baidu.navisdk.ugc.report.ui.innavi.main.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class ViewOnClickListenerC0394a implements View.OnClickListener {
            public ViewOnClickListenerC0394a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.b != null) {
                    a.this.b.b(f.this.c);
                }
            }
        }

        public f(View view) {
            super(a.this, view);
            this.b = (ImageView) view.findViewById(R.id.ugc_report_child_iview);
            this.f8278a = (TextView) view.findViewById(R.id.ugc_report_child_tview);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.a.b
        public void a(com.baidu.navisdk.ugc.report.data.datarepository.b bVar) {
            this.c = bVar.b;
            k.a(this.itemView, this.b, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
            this.itemView.setOnClickListener(new ViewOnClickListenerC0394a());
            String e = com.baidu.navisdk.ugc.report.data.datarepository.c.e(bVar.b);
            if (TextUtils.isEmpty(e)) {
                if (a.this.b.q().f(this.c)) {
                    com.baidu.navisdk.ugc.utils.d.a(this.c, this.b);
                } else {
                    com.baidu.navisdk.ugc.utils.d.c(bVar.b, this.b);
                }
            } else if (j.d()) {
                ImageLoader.with(a.this.f8275a).load(e).into(this.b);
            } else {
                com.baidu.navisdk.widget.naviimageloader.c.d().a(e, this.b);
            }
            this.f8278a.setText(bVar.f8246a);
        }
    }

    /* loaded from: classes8.dex */
    public class g extends b {

        /* renamed from: a, reason: collision with root package name */
        UgcReplenishDetailsTipsLayout f8280a;

        public g(a aVar, UgcReplenishDetailsTipsLayout ugcReplenishDetailsTipsLayout) {
            super(aVar, ugcReplenishDetailsTipsLayout);
            this.f8280a = ugcReplenishDetailsTipsLayout;
        }

        public UgcReplenishDetailsTipsLayout a() {
            return this.f8280a;
        }
    }

    public a(com.baidu.navisdk.ugc.report.ui.innavi.main.c cVar, Context context, int i) {
        int size;
        this.g = 0;
        this.h = 0;
        this.f8275a = context;
        this.b = cVar;
        this.c = i;
        this.i = LayoutInflater.from(context);
        if (cVar != null) {
            this.d = cVar.d();
            this.e = cVar.k();
            this.f = cVar.u();
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList = this.d;
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            this.g = size;
            ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList2 = this.e;
            this.h = arrayList2 != null ? arrayList2.size() : 0;
        }
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<Integer> arrayList = this.n;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUgcReportItemRecyclerAdapter", "总数为：" + getItemCount());
        }
        ArrayList<Integer> arrayList = this.n;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.get(i).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new C0393a(gridLayoutManager));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(int r3) {
        /*
            r2 = this;
            int r0 = r2.g
            if (r0 <= 0) goto L18
            if (r3 >= r0) goto La
            java.lang.String r3 = "货车相关"
            goto L2a
        La:
            if (r3 <= r0) goto L12
            int r1 = r2.h
            int r1 = r1 + r0
            if (r3 >= r1) goto L12
            goto L1e
        L12:
            int r1 = r2.h
            int r0 = r0 + r1
            if (r3 <= r0) goto L28
            goto L24
        L18:
            if (r0 != 0) goto L28
            int r0 = r2.h
            if (r3 >= r0) goto L22
        L1e:
            java.lang.String r3 = "路况相关"
            goto L2a
        L22:
            if (r3 <= r0) goto L28
        L24:
            java.lang.String r3 = "道路相关"
            goto L2a
        L28:
            java.lang.String r3 = ""
        L2a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.report.ui.innavi.main.a.b(int):java.lang.String");
    }

    public void a(boolean z) {
        this.o = z;
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == 2) {
            return new c(this, this.i.inflate(R.layout.nsdk_layout_ugc_navi_report_line_layout, viewGroup, false));
        }
        if (i != 1 && i != 5 && i != 6) {
            if (i == 3) {
                return new e(this, this.i.inflate(R.layout.nsdk_layout_ugc_navi_report_subtitle_layout, viewGroup, false));
            }
            return new g(this, new UgcReplenishDetailsTipsLayout(viewGroup.getContext()));
        }
        if (this.c == 1) {
            inflate = this.i.inflate(R.layout.nsdk_layout_ugc_report_child_gride_item, viewGroup, false);
        } else {
            inflate = this.i.inflate(R.layout.nsdk_layout_ugc_report_child_gride_item_land, viewGroup, false);
        }
        return new f(inflate);
    }

    public void a(d dVar) {
        this.j = dVar;
    }

    public void a(ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList) {
        this.e = arrayList;
        this.h = arrayList.size();
        a();
    }

    private void a() {
        ArrayList<Integer> arrayList;
        ArrayList<Integer> arrayList2 = this.n;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.n = new ArrayList<>();
        }
        int i = this.g;
        int i2 = this.h;
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> arrayList3 = this.f;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i3 = i + i2 + size;
        boolean z = (i3 == i || i3 == size || i3 == i2) ? false : true;
        if (i > 0) {
            if (z) {
                this.n.add(3);
            }
            for (int i4 = 0; i4 < this.g; i4++) {
                this.n.add(6);
            }
            this.n.add(2);
        }
        if (i2 > 0) {
            if (z) {
                this.n.add(3);
            }
            if (this.o) {
                this.n.add(4);
            }
            for (int i5 = 0; i5 < this.h; i5++) {
                this.n.add(1);
            }
            if (z) {
                this.n.add(2);
            }
        }
        if (size > 0) {
            this.n.add(3);
            for (int i6 = 0; i6 < size; i6++) {
                this.n.add(5);
            }
        }
        int i7 = 0;
        while (true) {
            if (i7 >= this.n.size()) {
                break;
            }
            if (this.n.get(i7).intValue() == 6) {
                this.k = i7;
                break;
            }
            i7++;
        }
        int i8 = 0;
        while (true) {
            if (i8 >= this.n.size()) {
                break;
            }
            if (this.n.get(i8).intValue() == 5) {
                this.l = i8;
                break;
            }
            i8++;
        }
        int i9 = 0;
        while (true) {
            if (i9 >= this.n.size()) {
                break;
            }
            if (this.n.get(i9).intValue() == 1) {
                this.m = i9;
                break;
            }
            i9++;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (!gVar.d() || (arrayList = this.n) == null || arrayList.size() <= 0) {
            return;
        }
        gVar.e("NaviUgcReportItemRecyclerAdapter", "typeOrderList的长度为" + this.n.size() + "元素分别为：");
        for (int i10 = 0; i10 < this.n.size(); i10++) {
            com.baidu.navisdk.util.common.g.PRO_NAV.e("NaviUgcReportItemRecyclerAdapter", "typeOrderList第" + i10 + "个元素为 ：" + this.n.get(i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUgcReportItemRecyclerAdapter", "item总数为 : " + getItemCount());
            gVar.e("NaviUgcReportItemRecyclerAdapter", "类型为：" + getItemViewType(i));
        }
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1 || itemViewType == 5 || itemViewType == 6) {
            com.baidu.navisdk.ugc.report.data.datarepository.b a2 = a(i);
            if (a2 != null) {
                bVar.a(a2);
                return;
            }
            return;
        }
        if (itemViewType == 3) {
            String b2 = b(i);
            if (b2 != null) {
                bVar.a(b2);
                return;
            }
            return;
        }
        if (itemViewType == 4 && (bVar instanceof g)) {
            UgcReplenishDetailsTipsLayout a3 = ((g) bVar).a();
            d dVar = this.j;
            if (dVar != null) {
                dVar.a(a3);
            }
        }
    }

    private com.baidu.navisdk.ugc.report.data.datarepository.b a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUgcReportItemRecyclerAdapter", "firstIndexOfTruckItem为:" + this.k);
            gVar.e("NaviUgcReportItemRecyclerAdapter", "firstIndexOfRoadItem为:" + this.m);
            gVar.e("NaviUgcReportItemRecyclerAdapter", "firstIndexOfMayiItem为:" + this.l);
        }
        int itemViewType = getItemViewType(i);
        if (itemViewType == 6) {
            return this.d.get(i - this.k);
        }
        if (itemViewType == 1) {
            return this.e.get(i - this.m);
        }
        if (itemViewType == 5) {
            return this.f.get(i - this.l);
        }
        return null;
    }
}
