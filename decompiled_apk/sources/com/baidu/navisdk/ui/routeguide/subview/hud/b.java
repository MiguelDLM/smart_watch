package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.subview.util.a;
import com.baidu.navisdk.ui.routeguide.widget.f;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.g;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class b extends f implements View.OnClickListener {
    private Activity b;
    private RGHUDView c;
    private boolean d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private d i;
    private boolean j;
    private Animation.AnimationListener k;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && !b.this.d) {
                if (b.this.j) {
                    return true;
                }
                if (b.this.e.getVisibility() == 0) {
                    b.this.d();
                } else {
                    com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410287", "410287");
                    b.this.g();
                    b.this.i.sendEmptyMessage(3);
                }
                return true;
            }
            if (motionEvent.getAction() == 0 && b.this.d) {
                if (b.this.j) {
                    return true;
                }
                if (b.this.h.getVisibility() == 0) {
                    b.this.e();
                    return false;
                }
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410287", "410287");
                b.this.h();
                b.this.i.sendEmptyMessage(1);
                return false;
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.hud.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class AnimationAnimationListenerC0476b implements Animation.AnimationListener {
        public AnimationAnimationListenerC0476b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.j = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.j = true;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.InterfaceC0477a {
        public c() {
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f9095a;
        private int b;
        private final com.baidu.navisdk.util.worker.f<String, String> c = new a("FadeTask", null);

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {
            public a(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                b bVar = (b) d.this.f9095a.get();
                if (bVar == null) {
                    return null;
                }
                if (d.this.b == 1) {
                    bVar.e();
                } else {
                    bVar.d();
                }
                return null;
            }
        }

        public d(b bVar) {
            this.f9095a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f9095a.get() == null) {
                return;
            }
            this.b = message.what;
            com.baidu.navisdk.util.worker.c.a().a((g) this.c, false);
            com.baidu.navisdk.util.worker.c.a().a(this.c, new e(2, 0), 5000L);
        }
    }

    public b(Activity activity, int i, boolean z) {
        super(activity, i);
        this.d = false;
        this.i = null;
        this.j = false;
        this.b = activity;
        requestWindowFeature(1);
        f();
        this.i = new d(this);
        this.k = new AnimationAnimationListenerC0476b();
        h(z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
        com.baidu.navisdk.ui.routeguide.asr.c.n().k();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bnav_rg_btn_hud_back) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.8.2");
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410289", "410289");
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
            com.baidu.navisdk.ui.routeguide.subview.util.a.a(new c());
            return;
        }
        if (view.getId() == R.id.bnav_rg_btn_hud) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.8.1");
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410291", "410291");
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_HUD_GOTO_MIRROR);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hud_mirror"));
            return;
        }
        if (view.getId() == R.id.bnav_rg_btn_hud_mirror) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.8.1");
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410291", "410291");
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_MIRROR_GOTO_HUD);
        } else if (view.getId() == R.id.bnav_rg_btn_hud_mirror_back) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.8.2");
            if (this.d) {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410289", "410289");
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hud_quit"));
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        h(this.d);
        if (this.d) {
            this.i.sendEmptyMessage(1);
        } else {
            this.i.sendEmptyMessage(3);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Animation loadAnimation = JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_fade_out);
        loadAnimation.setAnimationListener(this.k);
        this.e.setAnimation(loadAnimation);
        this.g.setAnimation(loadAnimation);
        this.e.setVisibility(4);
        this.g.setVisibility(4);
        this.g.setClickable(false);
        this.e.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f.setVisibility(8);
        this.f.setClickable(false);
        this.h.setVisibility(8);
        this.h.setClickable(false);
    }

    private void f() {
        setContentView(JarUtils.inflate(this.b, R.layout.nsdk_layout_rg_hud_dialog, null));
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().setStatusBarColor(0);
        this.c = (RGHUDView) findViewById(R.id.bnav_rg_hud_dialog_main);
        this.e = (TextView) findViewById(R.id.bnav_rg_btn_hud);
        this.f = (TextView) findViewById(R.id.bnav_rg_btn_hud_mirror);
        this.h = (TextView) findViewById(R.id.bnav_rg_btn_hud_mirror_back);
        this.g = (TextView) findViewById(R.id.bnav_rg_btn_hud_back);
        this.f.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.c.setOnTouchListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Animation loadAnimation = JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_fade_in);
        loadAnimation.setAnimationListener(this.k);
        this.e.setAnimation(loadAnimation);
        this.g.setAnimation(loadAnimation);
        this.e.setVisibility(0);
        this.g.setVisibility(0);
        this.g.setClickable(true);
        this.e.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f.setVisibility(0);
        this.f.setClickable(true);
        this.h.setVisibility(0);
        this.h.setClickable(true);
    }

    public void b(int i) {
        this.c.setNormalTurnIcon(i);
    }

    public void c(String str) {
        this.c.setDirection(str);
    }

    public void a() {
        RGHUDView rGHUDView = this.c;
        if (rGHUDView != null) {
            rGHUDView.b();
        }
    }

    public void b(String str) {
        this.c.setDirectCurrentRoad(str);
    }

    public void c(boolean z) {
        this.c.f(z);
    }

    public void b(boolean z) {
        this.c.c(z);
    }

    public void c() {
        this.c.d();
    }

    public void a(String str) {
        this.c.setDirectDistance(str);
    }

    public void b() {
        this.c.c();
    }

    public void a(int i) {
        this.c.setHighWayTurnIcon(i);
    }

    public void e(String str) {
        this.c.setHighWayExitRoad(str);
    }

    public void h(String str) {
        this.c.setNormalCurrentRoad(str);
    }

    private void h(boolean z) {
        if (z) {
            this.c.setMirror(true);
            this.c.invalidate();
            d();
            h();
            return;
        }
        this.c.setMirror(false);
        this.c.invalidate();
        g();
        e();
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public void e(boolean z) {
        this.c.b(z);
    }

    public void d(boolean z) {
        this.d = z;
    }

    public void g(String str) {
        this.c.setNormalGoMeters(str);
    }

    public void d(String str) {
        this.c.setHighWayExitCode(str);
    }

    public void g(boolean z) {
        this.c.e(z);
    }

    public void f(String str) {
        this.c.setHighWayRemainDistance(str);
    }

    public void f(boolean z) {
        this.c.d(z);
    }
}
