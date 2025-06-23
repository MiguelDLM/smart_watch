package com.baidu.platform.comapi.walknavi.h.c;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.R;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapapi.walknavi.model.a;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.platform.comapi.walknavi.e.g;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class c extends com.baidu.platform.comapi.walknavi.h.c.b implements CompoundButton.OnCheckedChangeListener, com.baidu.platform.comapi.walknavi.e.b {
    private RelativeLayout A;
    private ImageButton B;
    private TextView C;
    private View D;
    private RelativeLayout E;
    private ImageView F;
    private TextView G;
    private boolean H;
    private RelativeLayout I;
    private RelativeLayout J;
    private RelativeLayout K;
    private int M;
    private ImageView N;
    private RelativeLayout O;
    private ImageView Q;
    private String T;
    private RelativeLayout V;
    private TextView W;
    private int X;
    private String Y;

    /* renamed from: a, reason: collision with root package name */
    Animation f9774a;
    private com.baidu.platform.comapi.walknavi.widget.b aa;
    private IWMoreNPCModelOnClickListener ab;
    private IWNPCLoadAndInitListener ac;
    private a.b ai;
    private a.C0133a aj;
    private final View.OnClickListener ao;
    Animation b;
    CheckBox c;
    CheckBox d;
    CheckBox e;
    Button f;
    View g;
    ImageView h;
    final Runnable i;
    final Runnable j;
    private RelativeLayout k;
    private Context l;
    private View m;
    private com.baidu.platform.comapi.walknavi.h.b n;
    private View p;
    private RelativeLayout q;
    private ImageView r;
    private ImageButton s;
    private int w;
    private RelativeLayout z;
    private Handler o = new Handler();
    private final int t = 1;
    private final int u = 2;
    private final int v = 3;
    private int x = 1;
    private int y = 1;
    private ImageView L = null;
    private boolean P = false;
    private AlphaAnimation R = new AlphaAnimation(1.0f, 0.0f);
    private AlphaAnimation S = new AlphaAnimation(0.0f, 1.0f);
    private boolean U = false;
    private boolean Z = false;
    private boolean ad = true;
    private long ae = 0;
    private boolean af = true;
    private boolean ag = false;
    private boolean ah = false;
    private boolean ak = true;
    private TextView al = null;
    private View am = null;
    private TextView an = null;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i);

        void a(String str);
    }

    /* loaded from: classes8.dex */
    public static class b implements g.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<com.baidu.platform.comapi.walknavi.h.c.b> f9775a;

        public b(com.baidu.platform.comapi.walknavi.h.c.b bVar) {
            this.f9775a = null;
            this.f9775a = new WeakReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.e.g.a
        public void a(g.b bVar) {
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.h.c.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0538c {
        void a();

        void b();
    }

    public c(Context context, com.baidu.platform.comapi.walknavi.h.b bVar, View view) {
        ImageView imageView;
        ImageView imageView2;
        j jVar = new j(this);
        this.ao = jVar;
        this.i = new m(this);
        this.j = new t(this);
        this.l = context;
        this.m = view;
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.l, R.anim.wsdk_anim_rg_down_out);
        this.f9774a = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.l, R.anim.wsdk_anim_rg_down_in);
        this.b = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.R.setDuration(300L);
        this.S.setDuration(300L);
        this.n = bVar;
        this.p = view.findViewById(R.id.ar_mode_enter_mask);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.normal_layout);
        this.K = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.common_switch_panel);
        this.J = relativeLayout2;
        a(relativeLayout2);
        d(view);
        this.N = (ImageView) view.findViewById(R.id.ar_entry);
        if (com.baidu.platform.comapi.walknavi.b.a().c() && this.N != null) {
            if (com.baidu.platform.comapi.walknavi.b.a().K().p()) {
                this.N.setVisibility(8);
            } else {
                if (o != null && !o.getShowImageToAR() && (imageView2 = this.N) != null) {
                    imageView2.setVisibility(8);
                } else {
                    this.N.setVisibility(0);
                }
                if (o != null && o.getImageToAR() != null && (imageView = this.N) != null) {
                    imageView.setImageBitmap(o.getImageToAR());
                }
            }
        } else {
            ImageView imageView3 = this.N;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        }
        this.N.setOnClickListener(new p(this));
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.ar_entry_tip);
        this.O = relativeLayout3;
        relativeLayout3.setOnClickListener(new u(this));
        this.q = (RelativeLayout) view.findViewById(R.id.bnav_rg_location_layout);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.bnav_rg_btn_location);
        this.r = imageView4;
        imageView4.setOnClickListener(new v(this));
        a(view);
        this.F.setOnClickListener(new w(this));
        this.D.setOnClickListener(new x(this));
        this.H = true;
        this.V.setOnClickListener(new y(this));
        this.I.setOnClickListener(jVar);
        this.B.setOnClickListener(jVar);
        RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.normal_panel_top_ly);
        this.E = relativeLayout4;
        relativeLayout4.setOnClickListener(new z(this));
    }

    private void s() {
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == 0) {
            MapStatus h = com.baidu.platform.comapi.walknavi.b.a().N().h();
            if (h != null) {
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.overlook(0.0f);
                builder.zoom(19.0f);
                WinRound winRound = h.winRound;
                long abs = (long) (OOXIXo.f3760XO - ((Math.abs(winRound.bottom - winRound.top) - 75) * 0.25d));
                WinRound winRound2 = h.winRound;
                builder.targetScreen(new Point((winRound2.right + winRound2.left) / 2, ((winRound2.top + winRound2.bottom) / 2) - ((int) abs)));
                com.baidu.platform.comapi.basestruct.Point S = com.baidu.platform.comapi.walknavi.b.a().S();
                if (S != null) {
                    builder.target(new LatLng(S.getDoubleY(), S.getDoubleX()));
                }
                com.baidu.platform.comapi.walknavi.b.a().N().a(h, 500);
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.g(com.baidu.platform.comapi.walknavi.segmentbrowse.c.b());
    }

    private void t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        ImageView imageView;
        if (this.Q == null) {
            return;
        }
        String a2 = com.baidu.platform.comapi.walknavi.e.e.c().a();
        if (TextUtils.isEmpty(a2)) {
            this.Q.setVisibility(0);
            WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
            if (o != null && o.getImageNPC() != null && (imageView = this.Q) != null) {
                imageView.setImageBitmap(o.getImageNPC());
                return;
            } else {
                this.Q.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, R.drawable.wsdk_icon_classic));
                return;
            }
        }
        com.baidu.platform.comapi.walknavi.e.a a3 = com.baidu.platform.comapi.walknavi.b.a().a(a2);
        if (a3 == null) {
            return;
        }
        Bitmap d = a3.d();
        if (d != null) {
            this.Q.setVisibility(0);
            this.Q.setImageBitmap(d);
        } else {
            this.Q.setVisibility(0);
            this.Q.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, R.drawable.wsdk_npc_drawer_img_default));
        }
    }

    private void v() {
        if (com.baidu.platform.comapi.walknavi.b.a().O().a("WALKNAVI_AR_NPC_IS_DOWNLOADING", false)) {
            com.baidu.platform.comapi.walknavi.e.e.c().m();
        }
    }

    private int w() {
        return com.baidu.platform.comapi.wnplatform.p.h.c(this.l);
    }

    public void a(int i) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.sound_check) {
            if (com.baidu.platform.comapi.walknavi.b.a().Q() == 4) {
                return;
            }
            com.baidu.platform.comapi.wnplatform.d.a.c("yang12", "onCheckedChanged:sound_check:" + z);
            if (z) {
                if (com.baidu.platform.comapi.walknavi.b.a().Q() != 4) {
                    com.baidu.platform.comapi.wnplatform.m.a.a().a("sound", 1);
                    com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG");
                }
                WNaviTTSPlayer.resumeVoiceTTSOutput();
                com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_VOICE_ON_OFF", true);
                return;
            }
            if (com.baidu.platform.comapi.walknavi.b.a().Q() != 4) {
                com.baidu.platform.comapi.wnplatform.m.a.a().a("sound", 0);
                com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG");
            }
            WNaviTTSPlayer.pauseVoiceTTSOutput();
            com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_VOICE_ON_OFF", false);
            return;
        }
        if (compoundButton.getId() == R.id.pano_check) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang12", "onCheckedChanged:panocheck:" + z);
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_STREET_POI_ON_OFF", true);
                com.baidu.platform.comapi.walknavi.b.a().K().b(true);
                com.baidu.platform.comapi.wnplatform.m.a.a().a("streetPoi", 1);
                com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_STREET_POI_ON_OFF", false);
            com.baidu.platform.comapi.walknavi.b.a().K().b(false);
            com.baidu.platform.comapi.wnplatform.m.a.a().a("streetPoi", 0);
            com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG");
            return;
        }
        if (compoundButton.getId() == R.id.threeD_check) {
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_THREED_MAP_ON_OFF", true);
                d(true);
                com.baidu.platform.comapi.wnplatform.m.a.a().a("threeD", 1);
                com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_THREED_MAP_ON_OFF", false);
            d(false);
            com.baidu.platform.comapi.wnplatform.m.a.a().a("threeD", 0);
            com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.baidu.platform.comapi.wnplatform.c.a().a(this.l, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.baidu.platform.comapi.walknavi.b.a().b("底部bar点击：mLocBtnId：" + this.w + "；mLastLocBtnId：" + this.M);
        if (this.H) {
            com.baidu.platform.comapi.walknavi.b.a().M().run("[查看全览]按钮点击");
            this.C.setText("继续当前导航");
            this.W.setVisibility(8);
            this.H = !this.H;
            return;
        }
        this.C.setText("查看全览");
        this.W.setVisibility(0);
        this.H = !this.H;
        if (com.baidu.platform.comapi.walknavi.b.a().Q() == 4) {
            s();
        } else {
            com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().K().j();
            com.baidu.platform.comapi.walknavi.b.a().e(1);
        }
        a(true);
    }

    private boolean q() {
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        if (o == null) {
            Log.e("CustomWNaviView", "Load bottomSetting layout failed,WalkNaviDisplayOption is null.");
            return false;
        }
        int bottomSettingLayout = o.getBottomSettingLayout();
        if (bottomSettingLayout == 0) {
            Log.e("CustomWNaviView", "BottomSetting layout resource is empty.");
            return false;
        }
        if (this.z == null) {
            Log.e("CustomWNaviView", "BottomSetting layout add failed.");
            return false;
        }
        View inflate = LayoutInflater.from((Activity) this.l).inflate(bottomSettingLayout, (ViewGroup) this.z, false);
        if (inflate == null) {
            Log.e("CustomWNaviView", "Load bottomSetting layout failed,please checking xml layout.");
            return false;
        }
        if (!com.baidu.platform.comapi.walknavi.h.d.b.a().a((Activity) this.l, 3, bottomSettingLayout, this)) {
            Log.e("CustomWNaviView", "Parser bottomSetting layout failed,please checking layout.");
            return false;
        }
        a.C0133a c0133a = this.aj;
        if (c0133a == null) {
            Log.e("CustomWNaviView", "Parser bottomSetting layout failed,missing other keywords like TAG attribute or ID attribute.");
            return false;
        }
        if (!TextUtils.isEmpty(c0133a.a()) && !TextUtils.isEmpty(this.aj.b()) && !TextUtils.isEmpty(this.aj.c()) && !TextUtils.isEmpty(this.aj.d()) && !TextUtils.isEmpty(this.aj.e())) {
            try {
                this.D = inflate.findViewById(Integer.parseInt(this.aj.a().replace("@", "")));
                this.F = (ImageView) inflate.findViewById(Integer.parseInt(this.aj.b().replace("@", "")));
                this.G = (TextView) inflate.findViewById(Integer.parseInt(this.aj.c().replace("@", "")));
                this.C = (TextView) inflate.findViewById(Integer.parseInt(this.aj.d().replace("@", "")));
                TextView textView = (TextView) inflate.findViewById(Integer.parseInt(this.aj.e().replace("@", "")));
                this.W = textView;
                if (this.D == null || this.F == null || this.G == null || this.C == null || textView == null) {
                    Log.e("CustomWNaviView", "BottomSetting layout control initialize failed,Missing other keywords like TAG attribute or ID attribute.");
                    return false;
                }
                this.z.removeAllViews();
                this.z.addView(inflate);
                if (TextUtils.isEmpty(this.G.getText())) {
                    this.G.setText("退出");
                }
                this.C.setText("查看全览");
                this.ah = true;
                this.z.setBackgroundColor(0);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("CustomWNaviView", "BottomSetting layout control type error");
                return false;
            }
        }
        Log.e("CustomWNaviView", "BottomSetting layout missing other keywords like TAG attribute or ID attribute.");
        return false;
    }

    private void r() {
        if (com.baidu.platform.comapi.wnplatform.p.a.a()) {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            com.baidu.platform.comapi.walknavi.b.a().K().b(true);
        } else {
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            com.baidu.platform.comapi.walknavi.b.a().K().b(false);
        }
    }

    public void e() {
        if (this.Z) {
            com.baidu.platform.comapi.walknavi.e.e.c().a(new b(this));
            String a2 = com.baidu.platform.comapi.walknavi.e.e.c().a();
            if (TextUtils.isEmpty(a2)) {
                b(true);
                com.baidu.platform.comapi.walknavi.b.a().K().a(0, 0);
                u();
            } else {
                a(a2, (InterfaceC0538c) null);
            }
            this.Z = false;
        }
    }

    public void h() {
        t();
    }

    public TextView i() {
        return this.W;
    }

    public void j() {
        this.l = null;
        if (this.ab != null) {
            this.ab = null;
        }
        if (this.ac != null) {
            this.ac = null;
        }
        com.baidu.platform.comapi.walknavi.e.e.c().i();
    }

    public TextView k() {
        return this.W;
    }

    public void l() {
        com.baidu.platform.comapi.walknavi.b.a().K().d(true);
        com.baidu.platform.comapi.walknavi.e.e.c().h();
    }

    public void m() {
        Runnable runnable;
        com.baidu.platform.comapi.wnplatform.tts.d.a().a(false);
        if (com.baidu.platform.comapi.walknavi.e.e.c().d()) {
            v();
            com.baidu.platform.comapi.walknavi.e.e.c().c(true);
            com.baidu.platform.comapi.walknavi.e.e.c().a(false);
            com.baidu.platform.comapi.walknavi.e.e.c().i();
        }
        Handler handler = this.o;
        if (handler == null || (runnable = this.i) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.o = null;
    }

    public void n() {
        String a2 = com.baidu.platform.comapi.walknavi.e.e.c().a();
        if (TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.b.a().O().a(a2, ""))) {
            com.baidu.platform.comapi.walknavi.e.e.c().b(a2, new r(this, a2));
        }
    }

    public void c() {
        this.X = this.M;
        if (com.baidu.platform.comapi.walknavi.b.a().B()) {
            com.baidu.platform.comapi.walknavi.b.a().b(false);
        }
        com.baidu.platform.comapi.walknavi.b.a().a((com.baidu.platform.comapi.wnplatform.f.a().e() & (-2)) | 2, false);
        com.baidu.platform.comapi.walknavi.b.a().K().j();
        com.baidu.platform.comapi.walknavi.b.a().K().a(false);
        a(true);
        com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
        if (this.O.getVisibility() == 0) {
            com.baidu.platform.comapi.walknavi.h.b bVar = this.n;
            if (bVar != null) {
                bVar.i = true;
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.h.b bVar2 = this.n;
        if (bVar2 != null) {
            bVar2.i = false;
        }
    }

    public void d() {
        this.K.clearAnimation();
        this.K.setVisibility(8);
        this.z.clearAnimation();
        this.z.setVisibility(8);
    }

    private void b(View view) {
        this.A = (RelativeLayout) view.findViewById(R.id.sync_view);
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        if (o == null || o.getCustomBottomView() == null) {
            return;
        }
        this.A.removeAllViews();
        this.A.addView(o.getCustomBottomView());
        this.A.setVisibility(0);
    }

    private void a(View view) {
        b(view);
        this.z = (RelativeLayout) view.findViewById(R.id.bnav_rg_bar_layout);
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        if (o != null && o.getIsCustomWNaviRgBarLayout()) {
            if (q()) {
                return;
            }
            c(view);
            return;
        }
        c(view);
        if (o != null && !o.getIsShowBottomGuideLayout()) {
            this.z.setVisibility(8);
            this.ak = false;
        } else {
            this.ak = true;
        }
    }

    private void d(View view) {
        this.k = (RelativeLayout) view.findViewById(R.id.user_npc);
    }

    private void d(boolean z) {
        MapStatus h = com.baidu.platform.comapi.walknavi.b.a().N().h();
        MapStatus.Builder builder = new MapStatus.Builder();
        if (h == null) {
            return;
        }
        if (z) {
            builder.overlook(-50.0f);
            com.baidu.platform.comapi.walknavi.b.a().d(-50);
        } else {
            builder.overlook(0.0f);
            com.baidu.platform.comapi.walknavi.b.a().d(0);
        }
        com.baidu.platform.comapi.walknavi.b.a().N().a(h, FeatureCodes.VO);
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.b
    public void b() {
        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.l, R.anim.wsdk_anim_rg_down_out);
        if (com.baidu.platform.comapi.walknavi.h.b.b.f9767a == 2) {
            if (this.s.isShown()) {
                this.s.setAnimation(c);
            }
            this.s.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.e.a> s = com.baidu.platform.comapi.walknavi.b.a().s();
        if (s == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < s.size(); i++) {
            if (TextUtils.equals(str, s.get(i).c())) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        com.baidu.platform.comapi.walknavi.e.e.c().c(false);
    }

    public void b(int i) {
        int i2 = R.drawable.wsdk_drawable_rg_ic_walk_bike3d_new;
        if (i == i2) {
            this.r.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, i2));
            this.w = 1;
            return;
        }
        int i3 = R.drawable.wsdk_drawable_rg_ic_north_walk_bike2d;
        if (i == i3) {
            this.r.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, i3));
            this.w = 2;
            return;
        }
        int i4 = R.drawable.wsdk_drawable_rg_ic_locate_walk_bike_point;
        if (i == i4) {
            this.r.setImageDrawable(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.l, i4));
            this.w = 3;
        }
    }

    private void c(View view) {
        if (view != null) {
            this.F = (ImageView) view.findViewById(R.id.bnav_rg_bar_icon);
            this.D = view.findViewById(R.id.bnav_rg_bar_quit);
            this.G = (TextView) view.findViewById(R.id.bnav_rg_bar_tv);
            this.C = (TextView) view.findViewById(R.id.bnav_rg_bar_text);
            this.W = (TextView) view.findViewById(R.id.normal_remain);
            this.V = (RelativeLayout) view.findViewById(R.id.bottom_bar_ly);
            this.B = (ImageButton) view.findViewById(R.id.bnav_rg_bar_more);
            this.I = (RelativeLayout) view.findViewById(R.id.bnav_rg_bar_more_ly);
        }
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        this.ab = iWMoreNPCModelOnClickListener;
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        this.ac = iWNPCLoadAndInitListener;
    }

    private void a(String str, String str2) {
        if (!a(str2)) {
            Log.e("LoadLocalNPCError", "the localNPCPath is not found, please check");
            return;
        }
        if (com.baidu.platform.comapi.walknavi.e.e.c().n()) {
            b(str, str2);
            com.baidu.platform.comapi.walknavi.b.a().O().b(str, str2);
            IWNPCLoadAndInitListener iWNPCLoadAndInitListener = this.ac;
            if (iWNPCLoadAndInitListener != null) {
                iWNPCLoadAndInitListener.onSuccess();
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().a(new aa(this, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "call npcSwitchCase");
        com.baidu.platform.comapi.walknavi.e.e.c().c(false);
    }

    public void c(boolean z) {
        if (com.baidu.platform.comapi.walknavi.e.e.c().o()) {
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        com.baidu.platform.comapi.walknavi.e.e.c().a(str);
        b(str2);
        u();
    }

    public void a(BaseNpcModel baseNpcModel) {
        if (this.Q == null || this.l == null) {
            return;
        }
        if (baseNpcModel == null) {
            Log.e("BaseNpcModel error", "BaseNpcModel is null,please check!");
            return;
        }
        if (TextUtils.equals(baseNpcModel.getDownLoadKey(), "")) {
            com.baidu.platform.comapi.walknavi.e.e.c().a("");
            b(true);
            com.baidu.platform.comapi.walknavi.b.a().K().a(0, 0);
            u();
            return;
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().c() && baseNpcModel.isLoadFromLocal()) {
            a(baseNpcModel.getDownLoadKey(), baseNpcModel.getLocalPath());
            return;
        }
        if (!com.baidu.platform.comapi.walknavi.e.a.g.g.b(this.l)) {
            Toast.makeText(this.l, R.string.wsdk_string_arnpc_dialog_no_network, 0).show();
        } else if (!com.baidu.platform.comapi.walknavi.e.a.g.g.d(this.l)) {
            a(baseNpcModel.getDownLoadKey(), com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_arnpc_dialog_npc_download), 4);
        } else {
            a(baseNpcModel.getDownLoadKey(), new e(this, baseNpcModel));
        }
    }

    private void b(String str) {
        String a2 = com.baidu.platform.comapi.walknavi.e.e.c().a();
        ArrayList<com.baidu.platform.comapi.walknavi.e.a> s = com.baidu.platform.comapi.walknavi.b.a().s();
        if (s != null) {
            for (int i = 0; i < s.size(); i++) {
                if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, s.get(i).c())) {
                    String a3 = s.get(i).a();
                    String b2 = s.get(i).b();
                    if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2)) {
                        try {
                            com.baidu.platform.comapi.walknavi.b.a().K().a(Integer.parseInt(a3), Integer.parseInt(b2));
                        } catch (Exception unused) {
                        }
                    } else {
                        com.baidu.platform.comapi.walknavi.b.a().K().a(0, 0);
                    }
                }
            }
        }
        if (!com.baidu.platform.comapi.walknavi.e.e.c().d()) {
            com.baidu.platform.comapi.walknavi.e.e.c().a(this);
            new FrameLayout.LayoutParams(-1, (w() / 9) * 9);
            com.baidu.platform.comapi.walknavi.e.e.c().l().setZOrderOnTop(true);
            com.baidu.platform.comapi.walknavi.e.e.c().l().setFrameRate(30);
            com.baidu.platform.comapi.walknavi.e.e.c().f();
            this.o.postDelayed(new k(this, str), 500L);
            return;
        }
        com.baidu.platform.comapi.walknavi.e.e.c().f();
        this.o.postDelayed(new l(this, str), 500L);
    }

    private boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i) {
        Context context;
        com.baidu.platform.comapi.walknavi.widget.b a2 = new com.baidu.platform.comapi.walknavi.widget.b(this.l).a(true).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_nav_title_tip)).a(String.format(str2, Integer.valueOf(i))).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_exit_check)).b().b(new g(this, str)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_nav_dialog_cancel)).a(new f(this));
        this.aa = a2;
        if (a2.isShowing() || (context = this.l) == null || ((Activity) context).isFinishing()) {
            return;
        }
        this.aa.show();
    }

    public void b(boolean z) {
        if (z) {
            com.baidu.platform.comapi.walknavi.b.a().K().d(false);
            com.baidu.platform.comapi.walknavi.e.e.c().g();
            com.baidu.platform.comapi.wnplatform.tts.d.a().a(false);
            return;
        }
        com.baidu.platform.comapi.walknavi.e.e.c().e();
    }

    public void a(int i, boolean z) {
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            this.P = false;
            if (this.ak) {
                this.z.setVisibility(0);
                this.A.setVisibility(0);
            }
            this.K.setVisibility(0);
            if (com.baidu.platform.comapi.walknavi.e.e.c().d()) {
                c(true);
            }
            if (z) {
                return;
            }
            this.z.clearAnimation();
            this.z.startAnimation(this.b);
            this.K.clearAnimation();
            this.K.startAnimation(this.b);
            if (this.X == 2) {
                com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_NORTH_2D);
                return;
            } else {
                com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.BTN_CLICK_CAR_3D);
                return;
            }
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
            this.P = true;
            if (z) {
                this.z.setVisibility(8);
                this.K.setVisibility(8);
                this.A.setVisibility(8);
            } else {
                this.z.setVisibility(8);
                this.z.startAnimation(this.f9774a);
                this.K.startAnimation(this.f9774a);
                this.A.setVisibility(8);
                this.f9774a.setAnimationListener(new h(this));
            }
            com.baidu.platform.comapi.walknavi.b.a().K().d(true);
            this.o.postDelayed(this.i, 500L);
        }
    }

    private void a(RelativeLayout relativeLayout) {
        CheckBox checkBox = (CheckBox) relativeLayout.findViewById(R.id.sound_check);
        this.c = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        if (com.baidu.platform.comapi.walknavi.b.a().Q() == 4) {
            this.c.setClickable(false);
        }
        CheckBox checkBox2 = (CheckBox) relativeLayout.findViewById(R.id.pano_check);
        this.d = checkBox2;
        checkBox2.setOnCheckedChangeListener(this);
        this.g = relativeLayout.findViewById(R.id.pano_switch_layout);
        this.h = (ImageView) relativeLayout.findViewById(R.id.divider_line2);
        r();
        CheckBox checkBox3 = (CheckBox) relativeLayout.findViewById(R.id.threeD_check);
        this.e = checkBox3;
        checkBox3.setOnCheckedChangeListener(this);
        Button button = (Button) relativeLayout.findViewById(R.id.switch_hide_btn);
        this.f = button;
        button.setOnClickListener(new i(this));
    }

    @Override // com.baidu.platform.comapi.walknavi.h.c.b
    public void a() {
        Animation c = com.baidu.platform.comapi.wnplatform.p.a.a.c(this.l, R.anim.wsdk_anim_rg_down_in);
        if (com.baidu.platform.comapi.walknavi.b.a().y() == 1) {
            WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
            if (o != null && !o.getShowImageToLocation()) {
                RelativeLayout relativeLayout = this.q;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            } else {
                RelativeLayout relativeLayout2 = this.q;
                if (relativeLayout2 == null) {
                    return;
                }
                if (!relativeLayout2.isShown()) {
                    this.q.setAnimation(c);
                }
                this.q.setVisibility(0);
            }
            if (!this.z.isShown()) {
                this.z.setAnimation(c);
            }
            if (this.ak) {
                this.z.setVisibility(0);
            }
        }
    }

    public void a(boolean z) {
        this.H = z;
        if (z) {
            this.C.setVisibility(0);
            this.C.setText("查看全览");
            this.W.setVisibility(0);
        } else {
            this.C.setVisibility(0);
            this.C.setText("继续当前导航");
            this.W.setVisibility(8);
        }
    }

    private void a(String str, a aVar) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a(ARConfigKey.OLD_AR_KEY, str);
        com.baidu.platform.comapi.walknavi.e.e.c().a(str, new o(this, aVar));
    }

    public void a(String str, InterfaceC0538c interfaceC0538c) {
        String a2 = com.baidu.platform.comapi.walknavi.b.a().O().a(str, "");
        if (!TextUtils.isEmpty(a2)) {
            a(str, a2);
            return;
        }
        this.Y = com.baidu.platform.comapi.walknavi.e.e.c().d(str);
        if (!com.baidu.platform.comapi.walknavi.e.e.c().c(str) && !this.U) {
            String str2 = this.Y + File.separator + "ar";
            if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
                b(str, str2);
                if (interfaceC0538c != null) {
                    interfaceC0538c.a();
                    return;
                }
                return;
            }
            return;
        }
        a(str, new q(this, str, interfaceC0538c));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x011b, code lost:
    
        if (r10.equals("turnAndSayHi") == false) goto L31;
     */
    @Override // com.baidu.platform.comapi.walknavi.e.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r10, java.util.HashMap<java.lang.String, java.lang.Object> r11) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.walknavi.h.c.c.a(int, java.util.HashMap):void");
    }

    public void a(a.b bVar) {
        this.ai = bVar;
    }

    public void a(a.C0133a c0133a) {
        this.aj = c0133a;
    }
}
