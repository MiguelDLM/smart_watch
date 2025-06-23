package com.baidu.navisdk.pronavi.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.routeguide.model.y;
import com.baidu.navisdk.ui.routeguide.subview.widget.BNAudioPlayView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private View f7963a;
    private BNAudioPlayView b;
    private TextView c;
    private boolean d;
    private boolean e;
    private long f;
    private volatile boolean g;
    private boolean h;
    private int i;
    private final TTSPlayerControl.c j;
    private final com.baidu.navisdk.util.worker.f<String, String> k;
    private final TTSPlayerControl.e l;
    private final int m;

    /* renamed from: com.baidu.navisdk.pronavi.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0359a {
        private C0359a() {
        }

        public /* synthetic */ C0359a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Runnable {
        final /* synthetic */ boolean b;

        /* renamed from: com.baidu.navisdk.pronavi.widget.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class RunnableC0360a implements Runnable {
            public RunnableC0360a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.g = true;
                TTSPlayerControl.stopVoiceTTSOutput();
                a.this.g = false;
            }
        }

        public b(boolean z) {
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGScenicBroadcastBtn", "doStopBroadcast, stop broadcast" + a.this.b() + ", " + this.b);
            }
            if (a.this.b()) {
                int i = 0;
                a.this.e = false;
                TTSPlayerControl.setEnableTimeOut(true);
                TTSPlayerControl.removeTTSPlayStateListener(a.this.l);
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f;
                if (elapsedRealtime > 30000) {
                    if (elapsedRealtime <= 60000) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.4.2", String.valueOf(i) + "", null, null);
                BNAudioPlayView bNAudioPlayView = a.this.b;
                IIX0o.ooOOo0oXI(bNAudioPlayView);
                bNAudioPlayView.c();
                TextView textView = a.this.c;
                IIX0o.ooOOo0oXI(textView);
                textView.setText("景区介绍");
                if (this.b) {
                    a.this.a("scenic_broadcast_stop", new RunnableC0360a());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements TTSPlayerControl.c {
        public c() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.c
        public final boolean a(String str, String str2) {
            if (TTSPlayerControl.isContainWarningVoice(str) || IIX0o.Oxx0IOOO("BNDiySpeakPreviewId", str2) || TextUtils.equals(str2, "scenic_broadcast") || (!a.this.b() && !a.this.c())) {
                return false;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGScenicBroadcastBtn", "scenic_broadcast_playing, return");
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.baidu.navisdk.util.worker.f<String, String> {
        public d(String str, Object obj) {
            super(str, obj);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        @oOoXoXO
        public String execute() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "scenic_cast_prepare timeout");
            }
            a.this.h = false;
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends TTSPlayerControl.f {

        /* renamed from: com.baidu.navisdk.pronavi.widget.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class RunnableC0361a implements Runnable {
            public RunnableC0361a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.e = true;
                a.this.f = SystemClock.elapsedRealtime();
                TTSPlayerControl.setEnableTimeOut(false);
                BNAudioPlayView bNAudioPlayView = a.this.b;
                IIX0o.ooOOo0oXI(bNAudioPlayView);
                bNAudioPlayView.b();
                TextView textView = a.this.c;
                IIX0o.ooOOo0oXI(textView);
                textView.setText("停止播放");
            }
        }

        public e() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(@OOXIXo String speechId) {
            IIX0o.x0xO0oo(speechId, "speechId");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGScenicBroadcastBtn", "onPlayStart " + speechId);
            }
            if (TextUtils.equals("scenic_broadcast", speechId)) {
                a.this.h = false;
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) a.this.k, true);
                a.this.b("scenic_play_start", new RunnableC0361a());
            }
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(@OOXIXo String speechId) {
            IIX0o.x0xO0oo(speechId, "speechId");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGScenicBroadcastBtn", "onPlayEnd " + speechId);
            }
            if (TextUtils.equals("scenic_broadcast", speechId) && a.this.b()) {
                a.this.a(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7970a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Runnable runnable, String str, String str2, Object obj) {
            super(str2, obj);
            this.f7970a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        @oOoXoXO
        public String execute() {
            this.f7970a.run();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7971a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Runnable runnable, String str, String str2, Object obj) {
            super(str2, obj);
            this.f7971a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        @oOoXoXO
        public String execute() {
            this.f7971a.run();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements i0.f {
        public h() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            a.this.d = false;
            a.this.f();
        }
    }

    static {
        new C0359a(null);
    }

    public a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, int i) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        this.m = i;
        this.d = true;
        this.j = new c();
        this.k = new d("scenic_cast_prepare", null);
        this.l = new e();
    }

    private final void g() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "showConfirmView");
        }
        i s = i.s();
        IIX0o.oO(s, "RGEnlargeRoadMapModel.getInstance()");
        if (!s.k() && s.T().b(115)) {
            x.b().k(115).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_scenic_broadcast)).D(100).v(20000).a("播报景区简介将暂停导航播报，仅播提示音").z(2).b("点击播放开始播报终点景区介绍").g("开始播放").f("取消").a(new h()).y();
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "isShowEnlargeRoadMap or not allow, return");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.h = true;
        com.baidu.navisdk.util.worker.c.a().b(this.k, new com.baidu.navisdk.util.worker.e(2, 0), 3000L);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGScenicBroadcastBtn", "play broadcast");
        }
        if (!this.g) {
            TTSPlayerControl.stopVoiceTTSOutput();
            TTSPlayerControl.removeTTSPlayStateListener(this.l);
            TTSPlayerControl.addTTSPlayStateListener(this.l);
            TTSPlayerControl.playXDTTSTextForResult(y.c(), 1, "scenic_broadcast");
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGScenicBroadcastBtn", "stopping, not play");
        }
    }

    public final boolean c() {
        return this.h;
    }

    public final void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScenicBroadcastBtn", "onDestroy: ");
        }
        this.h = false;
        if (this.e) {
            a(true);
        }
        TTSPlayerControl.removeTTSPlayStateListener(this.l);
        BNAudioPlayView bNAudioPlayView = this.b;
        if (bNAudioPlayView != null) {
            IIX0o.ooOOo0oXI(bNAudioPlayView);
            bNAudioPlayView.a();
        }
        TTSPlayerControl.removeTTSBreakListener(this.j);
    }

    public final void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScenicBroadcastBtn", "stopBroadcast: " + this.e);
        }
        if (this.e) {
            a(true);
        }
    }

    public final boolean b() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str, Runnable runnable) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new g(runnable, str, str, null), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    public final void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScenicBroadcastBtn", "handleOnClick: " + this.e + ", " + this.d);
        }
        if (this.e) {
            e();
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.p.4.3");
        } else if (this.d) {
            g();
        } else {
            f();
        }
    }

    public final void a(int i) {
        View view = this.f7963a;
        if (view == null || i == this.i) {
            return;
        }
        this.i = i;
        IIX0o.ooOOo0oXI(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            Pair<Integer, Integer> a2 = RGImageTextBtn.b.a(i);
            int intValue = a2.component1().intValue();
            int intValue2 = a2.component2().intValue();
            if (layoutParams.width != intValue || layoutParams.height != intValue2) {
                layoutParams.width = intValue;
                layoutParams.height = intValue2;
            }
        }
        BNAudioPlayView bNAudioPlayView = this.b;
        IIX0o.ooOOo0oXI(bNAudioPlayView);
        ViewGroup.LayoutParams layoutParams2 = bNAudioPlayView.getLayoutParams();
        if (layoutParams2 != null) {
            Pair<Integer, Integer> b2 = RGImageTextBtn.b.b(i);
            int intValue3 = b2.component1().intValue();
            int intValue4 = b2.component2().intValue();
            if (layoutParams2.width != intValue3 || layoutParams2.height != intValue4) {
                layoutParams2.width = intValue3;
                layoutParams2.height = intValue4;
            }
        }
        TextView textView = this.c;
        IIX0o.ooOOo0oXI(textView);
        textView.setTextSize(0, RGImageTextBtn.b.c(i));
    }

    @OOXIXo
    public final View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        if (this.f7963a == null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_scenic_broadcast, parentView, false);
            com.baidu.navisdk.ui.util.b.a(a2, this.m);
            this.f7963a = a2;
            this.b = (BNAudioPlayView) a2.findViewById(R.id.bnav_rg_iv_scenic);
            this.c = (TextView) a2.findViewById(R.id.bnav_rg_tv_scenic);
            this.i = 1;
            a(i);
        }
        View view = this.f7963a;
        IIX0o.ooOOo0oXI(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScenicBroadcastBtn", "doStopBroadcast: " + z);
        }
        b("doStopBroadcast", new b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, Runnable runnable) {
        com.baidu.navisdk.util.worker.c.a().c(new f(runnable, str, str, null), new com.baidu.navisdk.util.worker.e(2, 0));
    }
}
