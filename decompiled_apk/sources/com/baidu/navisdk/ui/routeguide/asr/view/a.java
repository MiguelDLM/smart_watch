package com.baidu.navisdk.ui.routeguide.asr.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.widget.BNVoiceBtn;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes8.dex */
public class a extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    private BNVoiceBtn f8491a;
    private ViewGroup b;
    private TextView c;
    private final f<String, String> d;
    private final BNVoiceBtn.XDVoiceBtnCallback e;

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0425a implements Runnable {
        public RunnableC0425a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.setVoiceTipsVisibility(8);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements BNVoiceBtn.XDVoiceBtnCallback {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNVoiceBtn.XDVoiceBtnCallback
        public boolean isAllowedBtnShow() {
            if (com.baidu.navisdk.module.pronavi.a.j == 2 || !com.baidu.navisdk.function.b.FUNC_XIAODU.a() || com.baidu.navisdk.module.cloudconfig.f.c().c.v != 0 || !BNCommSettingManager.getInstance().isShowXiaoDu() || com.baidu.navisdk.module.routeresultbase.framework.utils.b.a() != 0) {
                return false;
            }
            if ((!com.baidu.navisdk.ui.routeguide.asr.c.n().h() && !com.baidu.navisdk.ui.routeguide.asr.c.n().c()) || RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getCurrentState()) || com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
                return false;
            }
            if (!com.baidu.navisdk.ui.routeguide.asr.c.n().g() && !RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                return false;
            }
            return true;
        }

        @Override // com.baidu.navisdk.ui.widget.BNVoiceBtn.XDVoiceBtnCallback
        public boolean isSwitchOn() {
            if (d.B().t() && com.baidu.navisdk.asr.f.b() && com.baidu.navisdk.ui.routeguide.asr.c.n().a(1) && com.baidu.navisdk.ui.routeguide.asr.c.n().a(9) && !d.B().p()) {
                return true;
            }
            return false;
        }
    }

    public a(Context context) {
        super(context);
        this.d = new b("BNVoiceAlwaysView-mAutoClearVoiceTipsTask", null);
        this.e = new c();
        i();
    }

    private void i() {
        com.baidu.navisdk.ui.util.b.a(getContext(), R.layout.bnav_voice_always_view, this);
        BNVoiceBtn bNVoiceBtn = (BNVoiceBtn) findViewById(R.id.xd_voice_btn);
        this.f8491a = bNVoiceBtn;
        bNVoiceBtn.setBtnCallback(this.e);
        this.f8491a.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_voice_head_bg));
        this.f8491a.setTag("bucket_xd_voice_btn");
    }

    public boolean a(int i) {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn == null) {
            return false;
        }
        if (!bNVoiceBtn.isAllowedBtnShow()) {
            this.f8491a.setVisibility(8);
            return false;
        }
        this.f8491a.setVisibility(i);
        return true;
    }

    public ViewGroup b() {
        if (this.b == null) {
            this.b = (ViewGroup) findViewById(R.id.bnav_rg_xd_voice_guide_container);
        }
        return this.b;
    }

    public boolean c() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null && bNVoiceBtn.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void d() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null && bNVoiceBtn.getViewTreeObserver().isAlive()) {
            this.f8491a.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    public void e() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null) {
            bNVoiceBtn.startAni();
        }
    }

    public void f() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null) {
            bNVoiceBtn.stopAni();
        }
    }

    public void g() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null && bNVoiceBtn.getViewTreeObserver().isAlive()) {
            this.f8491a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public void h() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null) {
            bNVoiceBtn.updateStatus();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null && !bNVoiceBtn.isShown()) {
            setVoiceTipsVisibility(8);
            g();
        }
    }

    public void setVoiceAlwaysTips(TextView textView) {
        this.c = textView;
    }

    public void setVoiceBtnClickListener(View.OnClickListener onClickListener) {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null) {
            bNVoiceBtn.setOnClickListener(onClickListener);
        }
    }

    public void setVoiceTipsVisibility(int i) {
        if (this.c != null) {
            if (i == 0 && c()) {
                if (com.baidu.navisdk.module.pronavi.a.j != 2) {
                    if (com.baidu.navisdk.ui.routeguide.asr.c.n().g() || RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.BrowseMap)) {
                        this.c.setVisibility(0);
                        this.c.postDelayed(new RunnableC0425a(), 50L);
                        com.baidu.navisdk.util.worker.c.a().a(this.d, new e(2, 0), 10000L);
                        return;
                    }
                    return;
                }
                return;
            }
            g();
            this.c.setVisibility(i);
        }
    }

    public void a(String str) {
        this.c.setText(str);
        setVoiceTipsVisibility(0);
    }

    public void a() {
        BNVoiceBtn bNVoiceBtn = this.f8491a;
        if (bNVoiceBtn != null) {
            bNVoiceBtn.setBtnCallback(null);
        }
        g();
        com.baidu.navisdk.util.worker.c.a().a((g) this.d, true);
    }
}
