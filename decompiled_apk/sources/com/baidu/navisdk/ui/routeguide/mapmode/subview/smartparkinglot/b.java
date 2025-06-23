package com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.destrec.f;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class b extends RecyclerView.Adapter<C0463b> {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> f8876a;

    @OOXIXo
    private final Context b;

    @OOXIXo
    private final ArrayList<f> c;

    @OOXIXo
    private final a d;
    private final int e;

    /* loaded from: classes8.dex */
    public interface a {
        void a(@oOoXoXO f fVar);

        void a(boolean z, int i, @oOoXoXO f fVar);
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0463b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final MutableLiveData<Boolean> f8877a;
        private f b;
        private a c;
        private ConstraintLayout d;
        private TextView e;
        private TextView f;
        private TextView g;
        private TextView h;
        private TextView i;
        private TextView j;
        private View k;
        private TextView l;
        private View m;
        private TextView n;
        private ImageView o;

        @OOXIXo
        private final Context p;

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a implements Observer<Boolean> {
            public a() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(@oOoXoXO Boolean bool) {
                if (bool == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    C0463b.this.d();
                } else {
                    C0463b.this.e();
                }
            }
        }

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0464b {
            private C0464b() {
            }

            public /* synthetic */ C0464b(IIXOooo iIXOooo) {
                this();
            }
        }

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b$b$c */
        /* loaded from: classes8.dex */
        public static final class c implements View.OnClickListener {
            final /* synthetic */ a b;

            public c(a aVar) {
                this.b = aVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.b.a(C0463b.this.b);
                if (C0463b.this.k.getVisibility() == 0) {
                    com.baidu.navisdk.util.statistic.userop.b.r().d("38.0.21.1467", "0");
                }
            }
        }

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b$b$d */
        /* loaded from: classes8.dex */
        public static final class d implements View.OnClickListener {
            final /* synthetic */ a b;

            public d(a aVar) {
                this.b = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                T value = C0463b.this.f8877a.getValue();
                IIX0o.ooOOo0oXI(value);
                boolean z = !((Boolean) value).booleanValue();
                this.b.a(z, C0463b.this.getLayoutPosition(), C0463b.this.b);
                C0463b.this.a(z);
            }
        }

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.b$b$e */
        /* loaded from: classes8.dex */
        public static final class e extends com.baidu.navisdk.util.worker.lite.b {
            public e(String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                int width;
                int width2;
                int width3 = C0463b.this.d.getWidth();
                int width4 = C0463b.this.e.getWidth() + C0463b.this.f.getWidth() + C0463b.this.j.getWidth() + C0463b.this.k.getWidth();
                g gVar = g.ACE;
                if (gVar.b()) {
                    gVar.b(com.baidu.navisdk.util.worker.g.TAG, "holder = " + hashCode() + " width = " + width3 + "  curWidth = " + width4 + " apploloWidth = " + C0463b.this.k.getWidth() + " titleWidth = " + C0463b.this.f.getWidth() + " + mRecLabel = " + C0463b.this.j.getWidth());
                }
                while (width4 != 0 && width3 != 0 && width4 - width3 > -150) {
                    g gVar2 = g.ACE;
                    if (gVar2.b()) {
                        gVar2.b(com.baidu.navisdk.util.worker.g.TAG, "in the loop holder = " + hashCode() + " width = " + width3 + "  curWidth = " + width4 + " apploloWidth = " + C0463b.this.k.getWidth() + " titleWidth = " + C0463b.this.f.getWidth() + " + mRecLabel = " + C0463b.this.j.getWidth());
                    }
                    if (C0463b.this.k.getVisibility() == 0) {
                        C0463b.this.k.setVisibility(8);
                        width = C0463b.this.e.getWidth() + C0463b.this.f.getWidth();
                        width2 = C0463b.this.j.getWidth();
                    } else if (C0463b.this.j.getVisibility() == 0) {
                        C0463b.this.j.setVisibility(8);
                        width = C0463b.this.e.getWidth();
                        width2 = C0463b.this.f.getWidth();
                    } else {
                        C0463b.this.f.setWidth((width3 - C0463b.this.e.getWidth()) - 100);
                        C0463b.this.f.setEllipsize(TextUtils.TruncateAt.END);
                        return;
                    }
                    width4 = width + width2;
                }
            }
        }

        static {
            new C0464b(null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0463b(@OOXIXo Context context, @OOXIXo View itemView) {
            super(itemView);
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(itemView, "itemView");
            this.p = context;
            MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
            this.f8877a = mutableLiveData;
            View findViewById = itemView.findViewById(R.id.parking_lot_item_layout);
            IIX0o.oO(findViewById, "itemView.findViewById(R.….parking_lot_item_layout)");
            this.d = (ConstraintLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.parking_lot_order);
            IIX0o.oO(findViewById2, "itemView.findViewById(R.id.parking_lot_order)");
            this.e = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.parking_lot_name);
            IIX0o.oO(findViewById3, "itemView.findViewById(R.id.parking_lot_name)");
            this.f = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.parking_lot_distance);
            IIX0o.oO(findViewById4, "itemView.findViewById(R.id.parking_lot_distance)");
            this.g = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.parking_lot_status);
            IIX0o.oO(findViewById5, "itemView.findViewById(R.id.parking_lot_status)");
            this.h = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.parking_lot_num);
            IIX0o.oO(findViewById6, "itemView.findViewById(R.id.parking_lot_num)");
            this.i = (TextView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.parking_lot_recommend);
            IIX0o.oO(findViewById7, "itemView.findViewById(R.id.parking_lot_recommend)");
            this.j = (TextView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.parking_lot_icon);
            IIX0o.oO(findViewById8, "itemView.findViewById(R.id.parking_lot_icon)");
            this.k = findViewById8;
            View findViewById9 = itemView.findViewById(R.id.parking_lot_fee);
            IIX0o.oO(findViewById9, "itemView.findViewById(R.id.parking_lot_fee)");
            this.l = (TextView) findViewById9;
            View findViewById10 = itemView.findViewById(R.id.nav_to_park_btn);
            IIX0o.oO(findViewById10, "itemView.findViewById(R.id.nav_to_park_btn)");
            this.m = findViewById10;
            View findViewById11 = itemView.findViewById(R.id.nav_to_park);
            IIX0o.oO(findViewById11, "itemView.findViewById(R.id.nav_to_park)");
            this.n = (TextView) findViewById11;
            View findViewById12 = itemView.findViewById(R.id.nav_to_park_icon);
            IIX0o.oO(findViewById12, "itemView.findViewById(R.id.nav_to_park_icon)");
            this.o = (ImageView) findViewById12;
            mutableLiveData.setValue(Boolean.FALSE);
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            LifecycleOwner f = V.f();
            IIX0o.ooOOo0oXI(f);
            mutableLiveData.observe(f, new a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d() {
            com.baidu.navisdk.ui.util.b.a(this.m, R.drawable.nsdk_smart_park_list_item_btn_onchecked_bg);
            com.baidu.navisdk.ui.util.b.a(this.o, R.drawable.nsdk_smart_park_list_item_navi_icon);
            this.n.setTextColor(Color.parseColor("#ffffff"));
            com.baidu.navisdk.ui.util.b.a(this.d, R.drawable.bnav_smart_park_list_item_checked_bg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e() {
            com.baidu.navisdk.ui.util.b.a(this.m, R.drawable.nsdk_smart_park_list_item_btn_unchecked_bg);
            com.baidu.navisdk.ui.util.b.a(this.o, R.drawable.nsdk_smart_park_list_item_navi_unchecked_icon);
            this.n.setTextColor(Color.parseColor("#3377ff"));
            com.baidu.navisdk.ui.util.b.a(this.d, R.drawable.bnav_smart_park_list_item_bg);
        }

        public final void a(@OOXIXo a listener) {
            IIX0o.x0xO0oo(listener, "listener");
            this.c = listener;
            this.m.setOnClickListener(new c(listener));
            this.d.setOnClickListener(new d(listener));
        }

        public final void b(boolean z) {
            this.k.setVisibility(z ? 0 : 8);
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("38.0.21.1466", "0");
            }
        }

        public final void c() {
            com.baidu.navisdk.util.worker.lite.a.c(new e("holderTextOmit"));
        }

        public final void f(@oOoXoXO String str) {
            if (TextUtils.isEmpty(str)) {
                this.f.setVisibility(8);
            } else {
                this.f.setText(str);
            }
        }

        public final void c(@oOoXoXO String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.n.setText(str);
        }

        public final void b(@oOoXoXO String str) {
            if (TextUtils.isEmpty(str)) {
                this.l.setVisibility(8);
            } else {
                this.l.setText(str);
            }
            if (this.h.getVisibility() == 8 && this.i.getVisibility() == 8) {
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.l.getLayoutParams());
                layoutParams.topToBottom = (this.g.getVisibility() != 0 ? this.e : this.g).getId();
                layoutParams.leftToLeft = this.e.getId();
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ScreenUtil.getInstance().dip2px(5);
                this.l.setLayoutParams(layoutParams);
            }
        }

        public final void a(@OOXIXo f data) {
            IIX0o.x0xO0oo(data, "data");
            this.b = data;
        }

        public final void a(@oOoXoXO String str) {
            if (TextUtils.isEmpty(str)) {
                this.g.setVisibility(8);
            } else {
                this.g.setText(str);
            }
        }

        public final void d(@OOXIXo String content) {
            IIX0o.x0xO0oo(content, "content");
            this.e.setText(content);
        }

        public final void e(@oOoXoXO String str) {
            if (TextUtils.isEmpty(str)) {
                this.j.setVisibility(8);
            } else {
                this.j.setText(str);
            }
        }

        public final void a(int i, int i2) {
            if (i2 == 0) {
                this.i.setVisibility(8);
                return;
            }
            TextView textView = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(i2);
            textView.setText(sb.toString());
        }

        public final void a(int i) {
            if (i == 1) {
                this.h.setBackgroundResource(R.drawable.bnav_smart_park_list_item_label_green_bg);
                this.h.setText("充足");
            } else if (i == 2) {
                this.h.setBackgroundResource(R.drawable.bnav_smart_park_list_item_label_red_bg);
                this.h.setText("紧张");
            } else if (i != 3) {
                this.h.setVisibility(8);
            } else {
                this.h.setBackgroundResource(R.drawable.bnav_smart_park_list_item_label_red_bg);
                this.h.setText("已满");
            }
        }

        public final void b() {
            a aVar = this.c;
            if (aVar != null) {
                f fVar = this.b;
                IIX0o.ooOOo0oXI(fVar);
                aVar.a(fVar);
            }
        }

        public final void a(boolean z) {
            this.f8877a.setValue(Boolean.valueOf(z));
        }

        public final void a() {
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            layoutParams.width = this.p.getResources().getDimensionPixelSize(R.dimen.navi_dimens_250dp);
            layoutParams.height = this.p.getResources().getDimensionPixelSize(R.dimen.navi_dimens_160dp);
            this.d.setLayoutParams(layoutParams);
        }
    }

    public b(@OOXIXo Context context, @OOXIXo ArrayList<f> dataList, @OOXIXo a listener, boolean z, int i) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(dataList, "dataList");
        IIX0o.x0xO0oo(listener, "listener");
        this.b = context;
        this.c = dataList;
        this.d = listener;
        this.e = i;
        this.f8876a = new ArrayList<>();
        int size = dataList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> arrayList = this.f8876a;
            f fVar = this.c.get(i2);
            IIX0o.oO(fVar, "dataList[i]");
            arrayList.add(a(fVar));
        }
    }

    @OOXIXo
    public final ArrayList<f> a() {
        return this.c;
    }

    @OOXIXo
    public final ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> b() {
        return this.f8876a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    public final void a(@OOXIXo ArrayList<com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.f8876a = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @OOXIXo
    public C0463b onCreateViewHolder(@OOXIXo ViewGroup parent, int i) {
        IIX0o.x0xO0oo(parent, "parent");
        View a2 = com.baidu.navisdk.ui.util.b.a(this.b, R.layout.bnav_layout_smart_parking_lot_item, parent, false);
        IIX0o.oO(a2, "BNStyleManager.inflate(c…_lot_item, parent, false)");
        return new C0463b(this.b, a2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@OOXIXo C0463b holder, int i) {
        IIX0o.x0xO0oo(holder, "holder");
        f fVar = this.c.get(i);
        IIX0o.oO(fVar, "dataList[position]");
        a(holder, i, fVar);
    }

    private final void a(C0463b c0463b, int i, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ParkingLotItemViewHolder", "updateView pos = " + i + " + data = " + this.f8876a.get(i));
        }
        c0463b.a(fVar);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a aVar = this.f8876a.get(i);
        IIX0o.oO(aVar, "mParkingItemInfoList[position]");
        com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a aVar2 = aVar;
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        sb.append(i + 1);
        c0463b.d(sb.toString());
        c0463b.f(aVar2.g());
        c0463b.e(aVar2.e());
        c0463b.a(aVar2.c());
        c0463b.a(aVar2.f());
        c0463b.b(aVar2.j());
        c0463b.a(aVar2.d(), aVar2.h());
        c0463b.b(aVar2.b());
        c0463b.c(aVar2.a());
        c0463b.a(aVar2.i());
        c0463b.a(this.d);
        if (this.e == 2) {
            c0463b.a();
        }
        c0463b.c();
    }

    private final com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a a(f fVar) {
        String str;
        String str2;
        String g = fVar.g();
        if (fVar.e().size() > 0) {
            f.b bVar = fVar.e().get(0);
            IIX0o.oO(bVar, "itemData.labelList[0]");
            str = bVar.a();
        } else {
            str = null;
        }
        if (fVar.e().size() > 0) {
            f.b bVar2 = fVar.e().get(0);
            IIX0o.oO(bVar2, "itemData.labelList[0]");
            str2 = bVar2.b();
        } else {
            str2 = null;
        }
        return new com.baidu.navisdk.ui.routeguide.mapmode.subview.smartparkinglot.a(g, str, str2, fVar.c().a(), fVar.c().c(), fVar.c().b(), fVar.b(), fVar.c().d(), fVar.a(), false, 512, null);
    }
}
