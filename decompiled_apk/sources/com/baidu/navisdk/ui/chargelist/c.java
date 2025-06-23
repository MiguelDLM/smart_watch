package com.baidu.navisdk.ui.chargelist;

import OXOo.OOXIXo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.chargelist.widget.ChargeListHeadView;
import com.baidu.navisdk.ui.chargelist.widget.ChargeListItemView;
import com.baidu.navisdk.ui.chargelist.widget.ChargeListSingleView;
import com.baidu.navisdk.ui.widget.dialog.BNCustomDialog;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.chargelist.interfaces.b f8361a;
    private List<? extends com.baidu.navisdk.ui.chargelist.data.beans.b> b;
    private final Context c;
    private final int d;

    /* loaded from: classes8.dex */
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private final ChargeListHeadView f8362a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@OOXIXo View itemView) {
            super(itemView);
            IIX0o.x0xO0oo(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.charge_list_head_container);
            IIX0o.oO(findViewById, "itemView.findViewById(R.…arge_list_head_container)");
            this.f8362a = (ChargeListHeadView) findViewById;
        }

        @OOXIXo
        public final ChargeListHeadView a() {
            return this.f8362a;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@OOXIXo View itemView) {
            super(itemView);
            IIX0o.x0xO0oo(itemView, "itemView");
        }
    }

    /* renamed from: com.baidu.navisdk.ui.chargelist.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0406c extends b {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private final RelativeLayout f8363a;

        @OOXIXo
        private final ChargeListItemView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0406c(@OOXIXo View itemView) {
            super(itemView);
            IIX0o.x0xO0oo(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.charge_list_medium_container);
            IIX0o.oO(findViewById, "itemView.findViewById(R.…ge_list_medium_container)");
            this.f8363a = (RelativeLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.charge_list_medium_item);
            IIX0o.oO(findViewById2, "itemView.findViewById(R.….charge_list_medium_item)");
            this.b = (ChargeListItemView) findViewById2;
        }

        @OOXIXo
        public final ChargeListItemView a() {
            return this.b;
        }

        @OOXIXo
        public final RelativeLayout b() {
            return this.f8363a;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private final ChargeListSingleView f8364a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@OOXIXo View itemView) {
            super(itemView);
            IIX0o.x0xO0oo(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.charge_list_single_container);
            IIX0o.oO(findViewById, "itemView.findViewById(R.…ge_list_single_container)");
            this.f8364a = (ChargeListSingleView) findViewById;
        }

        @OOXIXo
        public final ChargeListSingleView a() {
            return this.f8364a;
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private final FrameLayout f8365a;

        @OOXIXo
        private final ChargeListItemView b;

        @OOXIXo
        private final TextView c;

        @OOXIXo
        private final FrameLayout d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@OOXIXo View itemView) {
            super(itemView);
            IIX0o.x0xO0oo(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.charge_list_tail_container);
            IIX0o.oO(findViewById, "itemView.findViewById(R.…arge_list_tail_container)");
            this.f8365a = (FrameLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.charge_list_large_item);
            IIX0o.oO(findViewById2, "itemView.findViewById(R.id.charge_list_large_item)");
            this.b = (ChargeListItemView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.charge_list_text);
            IIX0o.oO(findViewById3, "itemView.findViewById(R.id.charge_list_text)");
            this.c = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.charge_list_fold_container);
            IIX0o.oO(findViewById4, "itemView.findViewById(R.…arge_list_fold_container)");
            this.d = (FrameLayout) findViewById4;
        }

        @OOXIXo
        public final ChargeListItemView a() {
            return this.b;
        }

        @OOXIXo
        public final FrameLayout b() {
            return this.d;
        }

        @OOXIXo
        public final FrameLayout c() {
            return this.f8365a;
        }

        @OOXIXo
        public final TextView d() {
            return this.c;
        }
    }

    /* loaded from: classes8.dex */
    public static final class f implements View.OnClickListener {
        final /* synthetic */ com.baidu.navisdk.ui.chargelist.data.beans.b b;

        public f(com.baidu.navisdk.ui.chargelist.data.beans.b bVar) {
            this.b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.f8361a != null) {
                com.baidu.navisdk.ui.chargelist.interfaces.b bVar = c.this.f8361a;
                IIX0o.ooOOo0oXI(bVar);
                bVar.b(this.b);
                String str = "0";
                if (((com.baidu.navisdk.ui.chargelist.data.beans.d) this.b).i()) {
                    com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
                    if (c.this.c()) {
                        str = "1";
                    }
                    r.d("11.11.6", str);
                    return;
                }
                com.baidu.navisdk.util.statistic.userop.b r2 = com.baidu.navisdk.util.statistic.userop.b.r();
                if (c.this.c()) {
                    str = "1";
                }
                r2.d("11.11.7", str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class g implements View.OnClickListener {
        final /* synthetic */ int b;

        public g(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List list;
            com.baidu.navisdk.ui.chargelist.data.beans.b bVar;
            if (c.this.f8361a != null && (list = c.this.b) != null && (bVar = (com.baidu.navisdk.ui.chargelist.data.beans.b) list.get(this.b)) != null) {
                com.baidu.navisdk.ui.chargelist.interfaces.b bVar2 = c.this.f8361a;
                IIX0o.ooOOo0oXI(bVar2);
                bVar2.a(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class h implements View.OnClickListener {
        final /* synthetic */ int b;

        public h(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.baidu.navisdk.ui.chargelist.data.beans.b bVar;
            List list = c.this.b;
            if (list != null) {
                bVar = (com.baidu.navisdk.ui.chargelist.data.beans.b) list.get(this.b);
            } else {
                bVar = null;
            }
            if ((bVar instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) && c.this.f8361a != null) {
                com.baidu.navisdk.ui.chargelist.data.beans.e eVar = (com.baidu.navisdk.ui.chargelist.data.beans.e) bVar;
                if (eVar.t()) {
                    com.baidu.navisdk.ui.chargelist.interfaces.b bVar2 = c.this.f8361a;
                    IIX0o.ooOOo0oXI(bVar2);
                    bVar2.a(eVar);
                } else {
                    com.baidu.navisdk.ui.chargelist.interfaces.b bVar3 = c.this.f8361a;
                    IIX0o.ooOOo0oXI(bVar3);
                    bVar3.c(eVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class i implements View.OnClickListener {
        final /* synthetic */ int b;

        /* loaded from: classes8.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ BNCustomDialog f8370a;

            public a(BNCustomDialog bNCustomDialog) {
                this.f8370a = bNCustomDialog;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8370a.dismiss();
            }
        }

        /* loaded from: classes8.dex */
        public static final class b implements View.OnClickListener {
            final /* synthetic */ BNCustomDialog b;
            final /* synthetic */ com.baidu.navisdk.ui.chargelist.data.beans.b c;

            public b(BNCustomDialog bNCustomDialog, com.baidu.navisdk.ui.chargelist.data.beans.b bVar) {
                this.b = bNCustomDialog;
                this.c = bVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.b.dismiss();
                if ((this.c instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) && c.this.f8361a != null) {
                    com.baidu.navisdk.ui.chargelist.interfaces.b bVar = c.this.f8361a;
                    IIX0o.ooOOo0oXI(bVar);
                    bVar.b((com.baidu.navisdk.ui.chargelist.data.beans.e) this.c);
                }
            }
        }

        public i(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.baidu.navisdk.ui.chargelist.data.beans.b bVar;
            String str;
            List list = c.this.b;
            if (list != null) {
                bVar = (com.baidu.navisdk.ui.chargelist.data.beans.b) list.get(this.b);
            } else {
                bVar = null;
            }
            if (bVar instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
                str = String.valueOf(((com.baidu.navisdk.ui.chargelist.data.beans.e) bVar).j().j());
            } else {
                str = "";
            }
            BNCustomDialog.Builder builder = new BNCustomDialog.Builder(c.this.c);
            BNCustomDialog build = builder.setContentView(R.layout.bnav_layout_charge_route_confirm_dialog).style(R.style.BNCommonDialogStyle).cancelTouchout(true).build();
            builder.setViewText(R.id.modify_dialog_title, "发起路线规划");
            builder.setViewText(R.id.modify_dialog_subtitle, "确定去" + str + (char) 20040);
            int i = R.id.modify_dialog_first_btn;
            builder.setViewText(i, "取消");
            int i2 = R.id.modify_dialog_second_btn;
            builder.setViewText(i2, "确定");
            builder.addViewOnclick(i, new a(build));
            builder.addViewOnclick(i2, new b(build, bVar));
            build.show();
        }
    }

    /* loaded from: classes8.dex */
    public static final class j implements View.OnClickListener {
        final /* synthetic */ int b;

        public j(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.baidu.navisdk.ui.chargelist.data.beans.b bVar;
            List list = c.this.b;
            if (list != null) {
                bVar = (com.baidu.navisdk.ui.chargelist.data.beans.b) list.get(this.b);
            } else {
                bVar = null;
            }
            if ((bVar instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) && c.this.f8361a != null) {
                com.baidu.navisdk.ui.chargelist.data.beans.e eVar = (com.baidu.navisdk.ui.chargelist.data.beans.e) bVar;
                if (eVar.t()) {
                    com.baidu.navisdk.ui.chargelist.interfaces.b bVar2 = c.this.f8361a;
                    IIX0o.ooOOo0oXI(bVar2);
                    bVar2.a(eVar);
                } else {
                    com.baidu.navisdk.ui.chargelist.interfaces.b bVar3 = c.this.f8361a;
                    IIX0o.ooOOo0oXI(bVar3);
                    bVar3.c(eVar);
                }
            }
        }
    }

    public c(@OOXIXo Context context, int i2) {
        IIX0o.x0xO0oo(context, "context");
        this.c = context;
        this.d = i2;
    }

    public final void a() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends com.baidu.navisdk.ui.chargelist.data.beans.b> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar;
        List<? extends com.baidu.navisdk.ui.chargelist.data.beans.b> list = this.b;
        if (list != null) {
            bVar = list.get(i2);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.e();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.chargelist.data.beans.ChargeWrapper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c() {
        return this.d == 2;
    }

    private final boolean d() {
        return this.d == 2;
    }

    public final void b() {
        this.f8361a = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @OOXIXo
    public b onCreateViewHolder(@OOXIXo ViewGroup parent, int i2) {
        IIX0o.x0xO0oo(parent, "parent");
        if (i2 == 0) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.bnav_layout_charge_single_container, parent, false);
            IIX0o.oO(inflate, "LayoutInflater.from(\n   …container, parent, false)");
            return new d(inflate);
        }
        if (i2 == 1) {
            View inflate2 = LayoutInflater.from(this.c).inflate(R.layout.bnav_layout_charge_head_container, parent, false);
            IIX0o.oO(inflate2, "LayoutInflater.from(\n   …container, parent, false)");
            return new a(inflate2);
        }
        if (i2 == 2) {
            View inflate3 = LayoutInflater.from(this.c).inflate(R.layout.bnav_layout_charge_list_view_medium, parent, false);
            IIX0o.oO(inflate3, "LayoutInflater.from(\n   …ew_medium, parent, false)");
            return new C0406c(inflate3);
        }
        if (i2 != 3) {
            View inflate4 = LayoutInflater.from(this.c).inflate(R.layout.bnav_layout_charge_list_view_medium, parent, false);
            IIX0o.oO(inflate4, "LayoutInflater.from(cont…ew_medium, parent, false)");
            return new b(inflate4);
        }
        View inflate5 = LayoutInflater.from(this.c).inflate(R.layout.bnav_layout_charge_list_view_tail, parent, false);
        IIX0o.oO(inflate5, "LayoutInflater.from(\n   …view_tail, parent, false)");
        return new e(inflate5);
    }

    private final int b(int i2) {
        List<? extends com.baidu.navisdk.ui.chargelist.data.beans.b> list = this.b;
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar = list != null ? list.get(i2) : null;
        if (bVar != null) {
            return bVar.d();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.chargelist.data.beans.ChargeWrapper");
    }

    public final void a(@OOXIXo List<? extends com.baidu.navisdk.ui.chargelist.data.beans.b> list) {
        IIX0o.x0xO0oo(list, "list");
        this.b = list;
        notifyDataSetChanged();
    }

    public final void a(@OOXIXo com.baidu.navisdk.ui.chargelist.interfaces.b changedCallBack) {
        IIX0o.x0xO0oo(changedCallBack, "changedCallBack");
        this.f8361a = changedCallBack;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@OOXIXo b holder, int i2) {
        IIX0o.x0xO0oo(holder, "holder");
        int adapterPosition = holder.getAdapterPosition();
        if (holder instanceof a) {
            a((a) holder, adapterPosition);
            return;
        }
        if (holder instanceof C0406c) {
            a((C0406c) holder, adapterPosition);
        } else if (holder instanceof e) {
            a((e) holder, adapterPosition);
        } else if (holder instanceof d) {
            a((d) holder, adapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@OOXIXo b holder, int i2, @OOXIXo List<Object> payloads) {
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(payloads, "payloads");
        super.onBindViewHolder(holder, i2, payloads);
    }

    private final com.baidu.navisdk.ui.chargelist.data.beans.b a(int i2) {
        List<? extends com.baidu.navisdk.ui.chargelist.data.beans.b> list = this.b;
        com.baidu.navisdk.ui.chargelist.data.beans.b bVar = list != null ? list.get(i2) : null;
        if (bVar != null) {
            return bVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.ui.chargelist.data.beans.ChargeWrapper");
    }

    private final void a(a aVar, int i2) {
        com.baidu.navisdk.ui.chargelist.data.beans.b a2 = a(i2);
        if (a2 instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
            aVar.a().a(this.d, (com.baidu.navisdk.ui.chargelist.data.beans.e) a2);
            a(aVar.a().getChargeListItemView(), i2);
        }
    }

    private final void a(C0406c c0406c, int i2) {
        com.baidu.navisdk.ui.chargelist.data.beans.b a2 = a(i2);
        if (a2 instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
            c0406c.a().a(this.d, (com.baidu.navisdk.ui.chargelist.data.beans.e) a2);
            com.baidu.navisdk.ui.chargelist.e.f8376a.a(c0406c.b(), d(), com.baidu.navisdk.ui.chargelist.d.a(com.baidu.navisdk.ui.chargelist.d.f8373a, 2, a2.a(), false, 4, null));
            a(c0406c.a(), i2);
        }
    }

    private final void a(e eVar, int i2) {
        int b2 = b(i2);
        if (b2 == 0 || b2 == 1) {
            com.baidu.navisdk.ui.chargelist.data.beans.b a2 = a(i2);
            if (a2 instanceof com.baidu.navisdk.ui.chargelist.data.beans.e) {
                int a3 = a2.a();
                a((View) eVar.a(), 0);
                a(eVar.b(), 8);
                eVar.a().a(this.d, (com.baidu.navisdk.ui.chargelist.data.beans.e) a2);
                a(eVar.a(), i2);
                com.baidu.navisdk.ui.chargelist.e.f8376a.a(eVar.c(), d(), com.baidu.navisdk.ui.chargelist.d.a(com.baidu.navisdk.ui.chargelist.d.f8373a, 3, a3, false, 4, null));
                return;
            }
            return;
        }
        if (b2 != 4) {
            return;
        }
        com.baidu.navisdk.ui.chargelist.data.beans.b a4 = a(i2);
        if (a4 instanceof com.baidu.navisdk.ui.chargelist.data.beans.d) {
            int a5 = a4.a();
            a((View) eVar.a(), 8);
            a(eVar.b(), 0);
            com.baidu.navisdk.ui.chargelist.e eVar2 = com.baidu.navisdk.ui.chargelist.e.f8376a;
            eVar2.a(eVar.b(), d(), R.drawable.bnav_energy_item_bottom_radius_bg);
            com.baidu.navisdk.ui.chargelist.data.beans.d dVar = (com.baidu.navisdk.ui.chargelist.data.beans.d) a4;
            Drawable b3 = eVar2.b(d(), dVar.i() ? R.drawable.nsdk_energy_charge_arrow_up : R.drawable.nsdk_energy_charge_arrow_down);
            IIX0o.ooOOo0oXI(b3);
            b3.setBounds(0, 0, ScreenUtil.getInstance().dip2px(10), ScreenUtil.getInstance().dip2px(10));
            eVar.d().setCompoundDrawables(null, null, b3, null);
            eVar.d().setText(dVar.h());
            eVar2.a(eVar.d(), d(), R.color.bnav_charge_list_tail_info_color);
            eVar2.a(eVar.c(), d(), com.baidu.navisdk.ui.chargelist.d.f8373a.a(3, a5, dVar.i()));
            eVar.b().setOnClickListener(new f(a4));
        }
    }

    private final void a(d dVar, int i2) {
        dVar.a().a(this.d, a(i2));
        a(dVar.a().getChargeListItemView(), i2);
    }

    private final void a(View view, int i2) {
        view.setVisibility(i2);
    }

    private final void a(ChargeListItemView chargeListItemView, int i2) {
        chargeListItemView.setItemContainerListener(new g(i2));
        chargeListItemView.setAddApproachNodeListener(new h(i2));
        chargeListItemView.setJumpToRouteResultListener(new i(i2));
        chargeListItemView.setNaviAddNodeListener(new j(i2));
    }
}
