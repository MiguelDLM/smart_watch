package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class f extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private boolean f;
    private View g;
    private View h;
    private TextView i;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7863a = new b();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            if (com.baidu.navisdk.ui.util.g.a()) {
                return;
            }
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("HDShowMapBtn", "onClicked: not hasCalcRouteOk");
                    return;
                }
                return;
            }
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
            if (b != null) {
                int f = b.f();
                if (f == 3 || f == 2) {
                    b.a(f);
                    if (f == 3) {
                        str = "asr_e_c_hd_full";
                    } else {
                        str = "asr_e_c_hd_half";
                    }
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(str));
                }
            }
        }
    }

    static {
        new a(null);
    }

    public f(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar, @oOoXoXO com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        View view = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_normal_hd_btn, parentView, false);
        a(view);
        IIX0o.oO(view, "view");
        return view;
    }

    public final void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("HDShowMapBtn", "updateState: " + z);
        }
        this.f = z;
        refreshVisible();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("HDShowMapBtn", "visibility: not hasCalcRouteOk");
            }
            return 8;
        }
        com.baidu.navisdk.ui.routeguide.model.a0 I = com.baidu.navisdk.ui.routeguide.model.a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("HDShowMapBtn", "visibility: isYawing");
            }
            return 8;
        }
        if (!this.f) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    @OOXIXo
    public View.OnClickListener getOnClickListener() {
        return b.f7863a;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        boolean z;
        super.onVisibleChange(i);
        com.baidu.navisdk.apicenter.a a2 = this.f7853a.j().e("RGBucketGroupComponent").a(1024);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        a2.a(Boolean.valueOf(z)).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest, RGFSMTable.FsmState.BrowseMap};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public void a(int i) {
        super.a(i);
        b(this.g, i);
        a(this.h, i);
        a(this.i, i);
    }

    private final void a(View view) {
        if (view != null) {
            this.g = view.findViewById(R.id.bn_normal_hd_btn);
            this.h = view.findViewById(R.id.bn_normal_hd_btn_icon);
            this.i = (TextView) view.findViewById(R.id.bn_normal_hd_btn_text);
        }
    }
}
