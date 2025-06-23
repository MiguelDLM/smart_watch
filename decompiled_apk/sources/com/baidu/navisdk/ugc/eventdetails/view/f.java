package com.baidu.navisdk.ugc.eventdetails.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.o;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ugc.eventdetails.adapter.a;
import com.baidu.navisdk.ugc.eventdetails.adapter.b;
import com.baidu.navisdk.ugc.eventdetails.model.c;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.RoundImageView;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f extends com.baidu.navisdk.ugc.eventdetails.view.a {
    static final Long Z0 = 3000L;
    private TextView A0;
    private View B0;
    private TextView C0;
    private ImageView D0;
    private TextView E0;
    private BNRCEventDetailLabelsView F0;
    private ImageView G0;
    private Bitmap H0;

    /* renamed from: I0, reason: collision with root package name */
    private View f8150I0;
    private RecyclerView J0;
    private View K0;
    private View L0;
    private View M0;
    private RoundImageView N0;

    /* renamed from: O0, reason: collision with root package name */
    private View f8151O0;
    private TextView P0;
    private ImageView Q0;
    private View R0;
    private View S0;
    private ProgressBar T0;
    private n U0;
    private Runnable V0;
    private com.baidu.navisdk.ugc.eventdetails.a W0;

    /* renamed from: X0, reason: collision with root package name */
    private com.baidu.navisdk.ugc.https.c f8152X0;
    private a.InterfaceC0201a Y0;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.P0 != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(f.this.P0, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(500L);
                ofFloat.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.Q0 != null && f.this.U0 == n.TO_PAUSE) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(f.this.Q0, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(500L);
                ofFloat.start();
                f fVar = f.this;
                n nVar = n.PLAYING;
                fVar.U0 = nVar;
                if (f.this.W0 != null) {
                    f.this.W0.a().postValue(nVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.InterfaceC0201a {
        public d() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof o) {
                int i = ((o) obj).f6832a;
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "network change event = " + i);
                }
                if (i == 0) {
                    f.this.B();
                } else if (i != 2 && i != 3 && i == 1) {
                    TipTool.onCreateToastDialog(f.this.b.d(), "当前为非wifi网络，请注意流量");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.b {
        public e() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.adapter.a.b
        public void a(@NonNull com.baidu.navisdk.ugc.eventdetails.model.g gVar) {
            f.this.a(true, gVar.a(), false);
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.0.1.2", f.this.b.e().c() + "", f.this.b.k().d0 + "", f.this.b.e().g + "");
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.view.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0379f implements a.d {
        public C0379f() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.adapter.a.d
        public void a(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                f.this.a(str, i);
                com.baidu.navisdk.util.statistic.userop.b.r().a("8.0.1.1354", f.this.b.e().c() + "", f.this.b.k().d0 + "", f.this.b.e().g + "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements b.j {
        public g() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.adapter.b.j
        public void a(boolean z, String str, boolean z2) {
            f.this.a(z, str, z2);
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.z();
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8161a;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {

            /* renamed from: com.baidu.navisdk.ugc.eventdetails.view.f$i$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class ViewOnClickListenerC0380a implements View.OnClickListener {
                public ViewOnClickListenerC0380a(a aVar) {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.navisdk.ugc.dialog.g.e().b();
                }
            }

            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.navisdk.ugc.dialog.g.e().a(f.this.b.d(), f.this.u.getText().toString(), new ViewOnClickListenerC0380a(this));
            }
        }

        public i(int i) {
            this.f8161a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int lineCount = f.this.u.getLineCount();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "count = " + lineCount + " maxline = " + this.f8161a);
            }
            int i = this.f8161a;
            if (lineCount < i) {
                f.this.K0.setVisibility(8);
                return;
            }
            if (lineCount == i) {
                int ellipsisCount = f.this.u.getLayout().getEllipsisCount(this.f8161a - 1);
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "ellipseCount = " + ellipsisCount);
                }
                if (ellipsisCount > 0) {
                    f.this.K0.setVisibility(0);
                    f.this.K0.setOnClickListener(new a());
                    return;
                } else {
                    f.this.K0.setVisibility(8);
                    return;
                }
            }
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "line more than max line ,strange !!!");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.a(false, (String) null, false);
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8164a;

        /* loaded from: classes8.dex */
        public class a implements com.baidu.navisdk.ugc.listener.c {
            public a() {
            }

            @Override // com.baidu.navisdk.ugc.listener.c
            public void a(boolean z) {
                f.this.e(z);
            }
        }

        public k(String str) {
            this.f8164a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            if (fVar.k0 == null) {
                fVar.k0 = new com.baidu.navisdk.ugc.pictures.previews.c(null);
                f.this.k0.a(new a());
            }
            f fVar2 = f.this;
            fVar2.k0.a(fVar2.b.d(), this.f8164a, 4);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Observer<n> {
        public l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(n nVar) {
            if (nVar != n.PLAYING) {
                f.this.a(f.Z0.longValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.R0 != null) {
                f.this.R0.setVisibility(8);
            }
            if (f.this.T0 != null) {
                f.this.T0.setVisibility(0);
            }
            f fVar = f.this;
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = fVar.b;
            if (aVar != null) {
                aVar.a(fVar.f8152X0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum n {
        DEFAULT,
        PLAYING,
        TO_PAUSE,
        STOP
    }

    public f(Context context, int i2, com.baidu.navisdk.ugc.eventdetails.model.a aVar, com.baidu.navisdk.ugc.eventdetails.control.a aVar2) {
        super(context, i2, aVar, aVar2);
        this.A0 = null;
        this.F0 = null;
        this.U0 = n.DEFAULT;
        this.V0 = null;
        this.W0 = null;
    }

    private void A() {
        v();
        x();
        View view = this.S0;
        if (view != null) {
            view.setOnClickListener(new m());
        }
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
        if (aVar != null) {
            aVar.a(this.f8152X0);
        }
        com.baidu.navisdk.framework.message.a.a().a(this.Y0, o.class, new Class[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        View view = this.R0;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void C() {
        int i2 = this.b.k().S;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "updateCommentBtnStatues: " + i2);
        }
        if (i2 == 2) {
            View view = this.H;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView = this.I;
            if (textView != null) {
                textView.setVisibility(0);
                this.I.setOnClickListener(new h());
            }
            TextView textView2 = this.J;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        if (i2 == 3) {
            View view2 = this.H;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.q;
            if (view3 != null) {
                view3.setVisibility(4);
            }
        }
    }

    private void D() {
        View view;
        String trim;
        if (this.s != null) {
            if (!TextUtils.isEmpty(this.b.k().N())) {
                try {
                    this.s.setVisibility(0);
                    com.baidu.navisdk.ugc.utils.d.a(this.b.k().P(), this.s, this.b.k().N());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                int a2 = com.baidu.navisdk.ugc.eventdetails.control.b.a(this.r0.c());
                if (a2 > 0) {
                    this.s.setImageResource(a2);
                } else {
                    this.s.setVisibility(8);
                }
            }
        }
        TextView textView = this.t;
        if (textView != null) {
            textView.setText(this.b.k().O());
        }
        if (this.u != null) {
            if (this.b.k().f() == null) {
                trim = this.b.k().f();
            } else {
                trim = this.b.k().f().trim();
            }
            if (TextUtils.isEmpty(trim)) {
                this.u.setVisibility(8);
                View view2 = this.n;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            } else {
                this.u.setText(trim);
            }
        }
        if (this.w != null) {
            String A = this.b.k().A();
            if (TextUtils.isEmpty(A)) {
                this.w.setVisibility(8);
            } else {
                this.w.setText(A);
            }
        }
        TextView textView2 = this.r;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (!this.b.q()) {
            ViewGroup viewGroup = this.G;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        } else {
            ViewGroup viewGroup2 = this.G;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            View view3 = this.H;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            TextView textView3 = this.I;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.J;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        if (this.b.s()) {
            ViewGroup viewGroup3 = this.G;
            if (viewGroup3 != null) {
                viewGroup3.setVisibility(0);
            }
            View view4 = this.y;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            View view5 = this.B;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            f(true);
            f(false);
        } else {
            View view6 = this.y;
            if (view6 != null) {
                view6.setVisibility(8);
            }
            View view7 = this.B;
            if (view7 != null) {
                view7.setVisibility(8);
            }
        }
        if (this.v != null) {
            if (!TextUtils.isEmpty(this.b.k().z())) {
                this.v.setText(this.b.k().z());
            } else {
                String w = this.b.k().w();
                String j2 = this.b.k().j();
                if (!TextUtils.isEmpty(w) && !TextUtils.isEmpty(j2)) {
                    w = w + " · " + j2;
                } else if (TextUtils.isEmpty(w)) {
                    if (!TextUtils.isEmpty(j2)) {
                        w = j2;
                    } else {
                        w = null;
                    }
                }
                if (!TextUtils.isEmpty(w)) {
                    this.v.setText(w);
                } else {
                    this.v.setVisibility(8);
                }
            }
        }
        BNRCEventDetailLabelsView bNRCEventDetailLabelsView = this.F0;
        if (bNRCEventDetailLabelsView != null) {
            bNRCEventDetailLabelsView.a(this.b.k().p());
        }
        c.d dVar = new c.d[]{new c.d()}[0];
        dVar.b = 2;
        dVar.f8071a = "百度地图大数据";
        if (dVar != null && !TextUtils.isEmpty("百度地图大数据")) {
            TextView textView5 = this.C0;
            if (textView5 != null) {
                textView5.setText(Html.fromHtml(dVar.f8071a));
            }
            if (this.D0 != null) {
                int b2 = dVar.b();
                if (b2 > 0) {
                    this.D0.setImageDrawable(com.baidu.navisdk.ui.util.b.f(b2));
                } else {
                    this.D0.setVisibility(8);
                }
            }
        } else {
            View view8 = this.B0;
            if (view8 != null) {
                view8.setVisibility(8);
            }
        }
        View view9 = this.K;
        if (view9 != null) {
            view9.setVisibility(8);
        }
        String x = this.b.k().x();
        if (this.N0 != null && this.M0 != null) {
            if (!TextUtils.isEmpty(x)) {
                ImageLoader.with(this.b.f()).load(x).into(this.N0);
                this.M0.setVisibility(0);
                this.N0.setVisibility(0);
                this.N0.setOnClickListener(new k(x));
            } else {
                this.M0.setVisibility(8);
            }
        }
        if (!this.b.s() && (view = this.n) != null) {
            view.setVisibility(8);
        }
    }

    private void E() {
        View view = this.f8151O0;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.n;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        RecyclerView recyclerView = this.J0;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        if (this.b.k().R()) {
            View view3 = this.B0;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.K;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
    }

    private void u() {
        ViewGroup viewGroup = this.x;
        if (viewGroup == null || viewGroup.getVisibility() == 8) {
            TextView textView = this.u;
            if (textView != null) {
                textView.setMaxLines(8);
            }
            View view = this.K0;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    private void v() {
        if (this.f8152X0 == null) {
            this.f8152X0 = new c();
        }
        if (this.Y0 == null) {
            this.Y0 = new d();
        }
    }

    private void w() {
        com.baidu.navisdk.ugc.eventdetails.a aVar = (com.baidu.navisdk.ugc.eventdetails.a) new ViewModelProvider((ViewModelStoreOwner) this.b.d()).get(com.baidu.navisdk.ugc.eventdetails.a.class);
        this.W0 = aVar;
        aVar.a(this.U0);
        this.W0.a().observe((LifecycleOwner) this.b.d(), new l());
    }

    private void x() {
        this.V0 = new a();
        new b();
    }

    private boolean y() {
        int i2 = this.r0.f;
        if (i2 != 10 && i2 != 14 && !TextUtils.isEmpty(this.b.k().j()) && !TextUtils.isEmpty(this.b.k().w())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
        if (aVar != null) {
            com.baidu.navisdk.ugc.eventdetails.model.a aVar2 = this.r0;
            if (aVar.a(aVar2.r, aVar2.s, aVar.k().T)) {
                this.b.y();
                View view = this.c;
                if (view != null) {
                    view.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    @LayoutRes
    public int k() {
        return R.layout.nsdk_layout_ugc_detail_outline;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public void l() {
        super.l();
        this.j.a(new g());
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public void n() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar;
        int i2;
        int i3;
        super.n();
        TextView textView = this.r;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.baidu.navisdk.ugc.eventdetails.control.a aVar2 = this.b;
        if (aVar2 != null) {
            View view = this.H;
            if (view != null) {
                if (aVar2.q()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                view.setVisibility(i3);
            }
            TextView textView2 = this.J;
            if (textView2 != null) {
                if (this.b.q()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                textView2.setVisibility(i2);
            }
        }
        View view2 = this.B0;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        View view3 = this.f8150I0;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        RecyclerView recyclerView = this.J0;
        if (recyclerView != null && (aVar = this.b) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(aVar.f(), 0, false));
            ArrayList arrayList = new ArrayList();
            ArrayList<com.baidu.navisdk.ugc.eventdetails.model.g> i4 = this.b.k().i();
            if (i4 != null && i4.size() > 0) {
                arrayList.addAll(i4);
            }
            if (arrayList.size() == 0) {
                this.J0.setVisibility(8);
            } else {
                com.baidu.navisdk.ugc.eventdetails.adapter.a aVar3 = new com.baidu.navisdk.ugc.eventdetails.adapter.a(this.b.f(), arrayList);
                aVar3.a(new e());
                aVar3.a(new C0379f());
                this.J0.setAdapter(aVar3);
            }
        }
        C();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public boolean o() {
        ImageView imageView = this.G0;
        if (imageView == null || !imageView.isShown()) {
            return false;
        }
        a(false, (String) null, false);
        return true;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.img_thumbnail) {
            a(true, this.b.k().l(), false);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.4", this.b.m() + "", "1", null);
            return;
        }
        if (id == R.id.view_avoid_congestion) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.3", "" + this.b.m(), "1", null);
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
            if (aVar != null) {
                aVar.x();
                return;
            }
            return;
        }
        if (id == R.id.ugc_detail_close_icon) {
            com.baidu.navisdk.ugc.eventdetails.control.a aVar2 = this.b;
            if (aVar2 != null) {
                aVar2.y();
            }
            if (e() != null) {
                e().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a, com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onDestroy() {
        super.onDestroy();
        com.baidu.navisdk.ui.util.j.b(this.G0);
        Bitmap bitmap = this.H0;
        if (bitmap != null) {
            if (com.baidu.navisdk.k.f6861a) {
                bitmap.recycle();
            }
            this.H0 = null;
        }
        if (this.f8152X0 != null) {
            this.f8152X0 = null;
        }
        if (this.Y0 != null) {
            com.baidu.navisdk.framework.message.a.a().a(this.Y0);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a, com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a, com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public boolean p() {
        ImageView imageView = this.G0;
        if (imageView == null || !imageView.isShown()) {
            return false;
        }
        a(false, (String) null, false);
        return true;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public void s() {
        int maxLines;
        String str;
        super.s();
        TextView textView = this.u;
        if (textView == null) {
            maxLines = 0;
        } else {
            maxLines = textView.getMaxLines();
        }
        c(maxLines);
        if (y()) {
            String str2 = this.b.k().w() + " · " + this.b.k().j();
            TextView textView2 = this.v;
            if (textView2 != null) {
                textView2.setText(str2);
            }
        } else {
            String z = this.b.k().z();
            if (TextUtils.isEmpty(z)) {
                TextView textView3 = this.v;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
            } else {
                TextView textView4 = this.v;
                if (textView4 != null) {
                    textView4.setText(z);
                }
            }
        }
        if (this.b.k().R()) {
            View view = this.B0;
            if (view != null) {
                view.setVisibility(8);
            }
            TextView textView5 = this.L;
            if (textView5 != null) {
                textView5.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_enthusiastic_user));
            }
        } else {
            View view2 = this.K;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.B0;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            for (c.d dVar : this.b.k().B()) {
                if (dVar != null && !dVar.c()) {
                    int i2 = dVar.b;
                    if (i2 != 0 && i2 != 1) {
                        if (i2 == 2) {
                            View view4 = this.B0;
                            if (view4 != null) {
                                view4.setVisibility(0);
                            }
                            String str3 = dVar.f8071a;
                            if (!TextUtils.isEmpty(dVar.c)) {
                                str3 = str3 + dVar.c;
                            }
                            TextView textView6 = this.C0;
                            if (textView6 != null) {
                                textView6.setText(Html.fromHtml(str3));
                            }
                            ImageView imageView = this.D0;
                            if (imageView != null) {
                                imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(dVar.b()));
                            }
                        }
                    } else {
                        View view5 = this.K;
                        if (view5 != null) {
                            view5.setVisibility(0);
                        }
                        TextView textView7 = this.L;
                        if (textView7 != null) {
                            textView7.setText(Html.fromHtml(dVar.f8071a));
                        }
                        ImageView imageView2 = this.M;
                        if (imageView2 != null && dVar.b == 1) {
                            imageView2.setVisibility(0);
                            this.M.setImageDrawable(com.baidu.navisdk.ui.util.b.f(dVar.b()));
                        }
                        if (this.N != null && !TextUtils.isEmpty(dVar.c)) {
                            this.N.setText(Html.fromHtml(dVar.c));
                            this.N.setVisibility(0);
                        }
                    }
                }
            }
        }
        BNRCEventDetailLabelsView bNRCEventDetailLabelsView = this.F0;
        if (bNRCEventDetailLabelsView != null) {
            bNRCEventDetailLabelsView.a(this.b.k().p());
        }
        if (this.E0 != null) {
            if (this.b.k().C() != null) {
                str = this.b.k().C().a();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                this.E0.setVisibility(8);
            } else {
                this.E0.setText(str);
                this.E0.setVisibility(0);
            }
        }
        if (this.A0 != null) {
            if (TextUtils.isEmpty(this.b.k().E())) {
                this.A0.setVisibility(8);
            } else {
                this.A0.setText(this.b.k().E());
            }
        }
        if (this.L0 != null) {
            if (this.b.k().C() != null && TextUtils.isEmpty(this.b.k().C().a()) && TextUtils.isEmpty(this.b.k().E())) {
                this.L0.setVisibility(8);
            } else {
                this.L0.setVisibility(0);
            }
        }
        TextView textView8 = this.u;
        if (textView8 != null) {
            if (textView8.getVisibility() == 8) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public void t() {
        super.t();
        if (this.b.k().t().a()) {
            a(true, this.b.k().t().c(), this.b.k().t().e());
        }
    }

    private void c(int i2) {
        TextView textView = this.u;
        if (textView == null || this.K0 == null) {
            return;
        }
        textView.post(new i(i2));
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a, com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void f() {
        com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.r0;
        if (aVar.k == 3) {
            n();
            D();
        } else if (aVar.c() == 108 && com.baidu.navisdk.j.d()) {
            n();
            s();
            E();
            A();
            w();
        } else {
            super.f();
        }
        u();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public void g(boolean z) {
        super.g(z);
        int i2 = z ? 1 : 2;
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.3", i2 + "", null, null);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public void i() {
        super.i();
        this.G0 = (ImageView) this.c.findViewById(R.id.img_full_screen_iv);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.a
    public void j() {
        super.j();
        this.B0 = this.p.findViewById(R.id.layout_pgc_source);
        this.C0 = (TextView) this.p.findViewById(R.id.tv_event_reporter_pgc_name);
        this.D0 = (ImageView) this.p.findViewById(R.id.iv_event_reporter_pgc_icon);
        this.F0 = (BNRCEventDetailLabelsView) this.p.findViewById(R.id.ugc_detail_labels_view);
        this.L0 = this.p.findViewById(R.id.event_description_layout);
        this.E0 = (TextView) this.p.findViewById(R.id.tv_event_pgc_start_end_time);
        this.A0 = (TextView) this.p.findViewById(R.id.tv_event_description_time);
        this.f8150I0 = this.p.findViewById(R.id.ugc_detail_close_icon);
        this.J0 = (RecyclerView) this.p.findViewById(R.id.img_and_video);
        this.K0 = this.p.findViewById(R.id.description_more);
        this.M0 = this.p.findViewById(R.id.ugc_event_details_realistic_img_container);
        this.N0 = (RoundImageView) this.p.findViewById(R.id.ugc_event_details_realistic_img);
        this.f8151O0 = this.p.findViewById(R.id.ugc_live_area);
        this.P0 = (TextView) this.p.findViewById(R.id.video_info);
        this.Q0 = (ImageView) this.p.findViewById(R.id.center_control_area);
        this.R0 = this.p.findViewById(R.id.loading_failed_area);
        this.S0 = this.p.findViewById(R.id.loading_failed_retry);
        this.T0 = (ProgressBar) this.p.findViewById(R.id.ugc_live_loading);
    }

    /* loaded from: classes8.dex */
    public class c implements com.baidu.navisdk.ugc.https.c {
        public c() {
        }

        @Override // com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = f.this.b;
            if (aVar != null) {
                aVar.a(false);
            }
            f.this.B();
        }

        @Override // com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            String optString;
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = f.this.b;
            if (aVar != null) {
                aVar.a(false);
            }
            com.baidu.navisdk.ugc.eventdetails.model.c k = f.this.b.k();
            if (k != null) {
                if (jSONObject.has("video_url")) {
                    f.this.b.k().Z = jSONObject.optString("video_url");
                }
                if (jSONObject.has("camera_name")) {
                    f.this.b.k().a0 = jSONObject.optString("camera_name");
                }
            }
            if (k == null || k.Z == null) {
                jSONObject.optString("video_url");
            }
            if (k == null || (optString = k.a0) == null) {
                optString = jSONObject.optString("camera_name");
            }
            if (f.this.P0 != null) {
                f.this.P0.setText(optString);
                f.this.a(f.Z0.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, boolean z2) {
        if (this.G0 == null) {
            return;
        }
        e(z);
        if (z && !TextUtils.isEmpty(str)) {
            ImageLoader.with(this.b.f()).load(str).placeHolder(R.drawable.nsdk_rc_img_default_bg).into(this.G0);
        }
        this.G0.setVisibility(z ? 0 : 8);
        if (this.b.k() != null && this.b.k().t() != null) {
            this.b.k().t().a(z);
            this.b.k().t().b(z2);
            this.b.k().t().a(str);
        }
        if (z) {
            this.G0.setOnClickListener(new j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        TextView textView = this.P0;
        if (textView != null) {
            textView.setVisibility(0);
            this.P0.setAlpha(1.0f);
            this.P0.removeCallbacks(this.V0);
            this.P0.postDelayed(this.V0, j2);
        }
    }
}
