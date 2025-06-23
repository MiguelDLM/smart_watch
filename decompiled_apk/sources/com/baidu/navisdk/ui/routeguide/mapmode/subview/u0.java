package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.subview.widget.BNAudioPlayView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class u0 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private View i;
    private BNAudioPlayView j;
    private TextView k;
    private boolean l;
    private boolean m;
    private long n;
    private volatile boolean o;
    private boolean p;
    private TTSPlayerControl.c q;
    private com.baidu.navisdk.util.worker.f<String, String> r;
    private TTSPlayerControl.e s;

    /* loaded from: classes8.dex */
    public class a implements TTSPlayerControl.c {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.c
        public boolean a(String str, String str2) {
            if (TTSPlayerControl.isContainWarningVoice(str) || "BNDiySpeakPreviewId".equals(str2) || TextUtils.equals(str2, "scenic_broadcast") || (!u0.this.n0() && !u0.this.o0())) {
                return false;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("scenic_broadcast", "scenic_broadcast_playing, return");
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("scenic_broadcast", "scenic_cast_prepare timeout");
            }
            u0.this.p = false;
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends TTSPlayerControl.f {

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                u0.this.m = true;
                u0.this.n = SystemClock.elapsedRealtime();
                TTSPlayerControl.setEnableTimeOut(false);
                u0.this.j.b();
                u0.this.k.setText("停止播放");
            }
        }

        public c() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("scenic_broadcast", "onPlayStart " + str);
            }
            if (TextUtils.equals("scenic_broadcast", str)) {
                u0.this.p = false;
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) u0.this.r, true);
                u0.this.b("scenic_play_start", new a());
            }
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("scenic_broadcast", "onPlayEnd " + str);
            }
            if (TextUtils.equals("scenic_broadcast", str) && u0.this.m) {
                u0.this.y(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (u0.this.m) {
                u0.this.p0();
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.p.4.3");
            } else if (u0.this.l) {
                u0.this.s0();
            } else {
                u0.this.r0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8899a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                u0.this.o = true;
                TTSPlayerControl.stopVoiceTTSOutput();
                u0.this.o = false;
            }
        }

        public e(boolean z) {
            this.f8899a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.this.m) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("scenic_broadcast", "stop broadcast");
                }
                int i = 0;
                u0.this.m = false;
                TTSPlayerControl.setEnableTimeOut(true);
                TTSPlayerControl.removeTTSPlayStateListener(u0.this.s);
                long elapsedRealtime = SystemClock.elapsedRealtime() - u0.this.n;
                if (elapsedRealtime > 30000) {
                    if (elapsedRealtime <= 60000) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.4.2", i + "", null, null);
                u0.this.j.c();
                u0.this.k.setText("景区介绍");
                if (this.f8899a) {
                    u0.this.a("scenic_broadcast_stop", new a());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements i0.f {
        public f() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            u0.this.l = false;
            u0.this.r0();
        }
    }

    public u0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.l = true;
        this.q = new a();
        this.r = new b("scenic_cast_prepare", null);
        this.s = new c();
        q0();
    }

    private void q0() {
        if (this.b == null) {
            return;
        }
        TTSPlayerControl.addTTSBreakListener(this.q);
        View findViewById = this.b.findViewById(R.id.bnav_rg_rl_scenic_broadcast);
        this.i = findViewById;
        if (findViewById == null) {
            return;
        }
        this.j = (BNAudioPlayView) findViewById.findViewById(R.id.bnav_rg_iv_scenic);
        this.k = (TextView) this.i.findViewById(R.id.bnav_rg_tv_scenic);
        this.i.setOnClickListener(new d());
        a(com.baidu.navisdk.ui.util.b.b());
        if (a()) {
            y();
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.p = true;
        com.baidu.navisdk.util.worker.c.a().b(this.r, new com.baidu.navisdk.util.worker.e(2, 0), 3000L);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "play broadcast");
        }
        if (!this.o) {
            TTSPlayerControl.stopVoiceTTSOutput();
            TTSPlayerControl.removeTTSPlayStateListener(this.s);
            TTSPlayerControl.addTTSPlayStateListener(this.s);
            TTSPlayerControl.playXDTTSTextForResult(com.baidu.navisdk.ui.routeguide.model.y.c(), 1, "scenic_broadcast");
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "stopping, not play");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "showConfirmView");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.i.s().k() && com.baidu.navisdk.ui.routeguide.control.s.T().b(115)) {
            com.baidu.navisdk.ui.routeguide.control.x.b().k(115).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_scenic_broadcast)).D(100).v(20000).a("播报景区简介将暂停导航播报，仅播提示音").z(2).b("点击播放开始播报终点景区介绍").g("开始播放").f("取消").a(new f()).y();
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "isShowEnlargeRoadMap, return");
        }
    }

    public boolean n0() {
        return this.m;
    }

    public boolean o0() {
        return this.p;
    }

    public void p0() {
        if (this.m) {
            y(true);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "ScenicBtn, show");
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(0);
        }
        return super.y();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        this.p = false;
        if (this.m) {
            y(true);
        }
        TTSPlayerControl.removeTTSPlayStateListener(this.s);
        BNAudioPlayView bNAudioPlayView = this.j;
        if (bNAudioPlayView != null) {
            bNAudioPlayView.a();
        }
        TTSPlayerControl.removeTTSBreakListener(this.q);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
        super.c();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        BNAudioPlayView bNAudioPlayView = this.j;
        if (bNAudioPlayView != null) {
            bNAudioPlayView.a();
        }
        q0();
        if (this.m) {
            this.j.b();
            this.k.setText("停止播放");
        } else {
            this.j.c();
            this.k.setText("景区介绍");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z) {
        b("doStopBroadcast", new e(z));
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        BNAudioPlayView bNAudioPlayView = this.j;
        if (bNAudioPlayView != null) {
            bNAudioPlayView.a(z);
        }
        View view = this.i;
        if (view != null) {
            view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.g(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h));
        }
    }
}
