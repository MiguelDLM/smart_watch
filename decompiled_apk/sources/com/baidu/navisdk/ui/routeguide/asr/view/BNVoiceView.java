package com.baidu.navisdk.ui.routeguide.asr.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapframework.voice.widget.VoiceContentAnimView;
import com.baidu.mapframework.voice.widget.VoiceHeadView;
import com.baidu.mapframework.voice.widget.VoiceViewInterface;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.asr.i.c;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.asr.e;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Random;

/* loaded from: classes8.dex */
public class BNVoiceView extends FrameLayout implements com.baidu.navisdk.asr.i.c {
    private static String x = "BNVoiceView";

    /* renamed from: a, reason: collision with root package name */
    private boolean f8487a;
    private FrameLayout b;
    private FrameLayout c;
    private RelativeLayout d;
    private VoiceHeadView e;
    private VoiceContentAnimView f;
    private ImageView g;
    private LinearLayout h;
    private FrameLayout i;
    private View j;
    private TextView k;
    private TextView l;
    private c.a m;
    private ScaleAnimation n;
    private Animation o;
    private Animation p;
    private boolean q;
    private boolean r;
    private TextView s;
    private int t;
    private int u;
    private AnimatorSet v;
    private AnimatorSet w;
    private static final String[] y = {"你可以说", "你可以这样说", "试试说", "试试这样说"};
    private static final int z = (int) JarUtils.getResources().getDimension(R.dimen.navi_dimens_44dp);
    private static final int A = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_16dp);
    private static final int B = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp);

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.ASR.e(BNVoiceView.x, "head onClick() status = " + BNVoiceView.this.m);
            if (BNVoiceView.this.m != c.a.START && BNVoiceView.this.m != c.a.LISTEN && BNVoiceView.this.m != c.a.RELISTEN) {
                if (BNVoiceView.this.m == c.a.PLAY) {
                    TTSPlayerControl.stopVoiceTTSOutput();
                    BNVoiceView.this.r = true;
                    BNVoiceView.this.a("");
                    return;
                }
                return;
            }
            c.b m = d.B().m();
            if (m != null) {
                m.onStop();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.ASR.e(BNVoiceView.x, "closeBtn clicked");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.5", null, null, "0");
            e.INSTANCE.a("voiceRobotClick.close", new Bundle());
            c.b m = d.B().m();
            if (m != null) {
                m.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public BNVoiceView(Context context) {
        this(context, null);
    }

    private void d() {
        ScaleAnimation scaleAnimation = this.n;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    private void e() {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e(x, "cancelStartAnim() contentAnim hasStarted is " + this.o.hasStarted() + " hasEnded is " + this.o.hasEnded());
        }
        Animation animation = this.o;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.p;
        if (animation2 != null) {
            animation2.cancel();
        }
        setOperateAreaVisibility(0);
    }

    private void f() {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e(x, "initView()");
        }
        JarUtils.inflate(com.baidu.navisdk.framework.a.c().a(), R.layout.nsdk_voice_view, this);
        this.b = (FrameLayout) findViewById(R.id.fl_voice_container);
        this.c = (FrameLayout) findViewById(R.id.fl_voice_content);
        this.d = (RelativeLayout) findViewById(R.id.rl_operate_area);
        VoiceHeadView findViewById = findViewById(R.id.vw_head);
        this.e = findViewById;
        ImageView headImg = findViewById.getHeadImg();
        ViewGroup.LayoutParams layoutParams = headImg.getLayoutParams();
        layoutParams.width = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_37dp);
        layoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_24dp);
        headImg.setLayoutParams(layoutParams);
        headImg.setPadding(0, JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp), 0, 0);
        VoiceContentAnimView findViewById2 = findViewById(R.id.vw_content_anim);
        this.f = findViewById2;
        this.g = findViewById2.getVoiceBall();
        this.e.setContentAnimView(this.f);
        this.k = (TextView) findViewById(R.id.tv_voice_text);
        this.l = (TextView) findViewById(R.id.tv_voice_hint);
        this.i = (FrameLayout) findViewById(R.id.fl_voice_card);
        this.h = (LinearLayout) findViewById(R.id.ll_voice_text);
        this.j = findViewById(R.id.ll_voice_close);
        this.e.setOnClickListener(new a());
        this.j.setOnClickListener(new b());
        this.c.setOnClickListener(new c());
        this.s = (TextView) findViewById(R.id.tv_voice_state);
        setVoicePanelBackground(com.baidu.navisdk.ui.routeguide.mapmode.a.o5().s2());
        int a2 = a(R.dimen.navi_dimens_156dp);
        this.u = a2;
        this.t = a2;
    }

    private void g() {
        FrameLayout frameLayout;
        if (this.d != null && (frameLayout = this.c) != null) {
            if (frameLayout.getLayoutParams().height <= this.t) {
                ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                layoutParams.height = this.t;
                this.c.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, a(R.dimen.navi_dimens_40dp));
            }
            if (x.b().s2()) {
                layoutParams2.topMargin = (this.t - layoutParams2.height) - this.c.getPaddingBottom();
            } else {
                layoutParams2.topMargin = this.c.getPaddingTop();
            }
            this.d.setLayoutParams(layoutParams2);
        }
    }

    private String getRandomHelpTitle() {
        Random random = new Random();
        String[] strArr = y;
        int nextInt = random.nextInt(strArr.length);
        if (nextInt >= 0 && nextInt < strArr.length) {
            return strArr[nextInt];
        }
        return "小度来了，你可以这么说";
    }

    private void h() {
        VoiceHeadView voiceHeadView = this.e;
        if (voiceHeadView == null) {
            return;
        }
        c.a aVar = this.m;
        if (aVar == c.a.START) {
            if (this.q) {
                voiceHeadView.start(true);
                return;
            } else {
                voiceHeadView.start(false);
                return;
            }
        }
        if (aVar == c.a.LISTEN) {
            voiceHeadView.listen();
            return;
        }
        if (aVar == c.a.PLAY) {
            voiceHeadView.play();
        } else if (aVar == c.a.RECOGNIZE) {
            voiceHeadView.recognize();
        } else if (aVar == c.a.RELISTEN) {
            voiceHeadView.reListen();
        }
    }

    private void setContentVisiblityAfterClearAnim(int i) {
        FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            if (i != 0) {
                frameLayout.clearAnimation();
            }
            this.c.setVisibility(i);
        }
    }

    public void b() {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null && this.h != null && this.c != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, a(R.dimen.navi_dimens_40dp));
            }
            if (x.b().s2()) {
                setVoicePanelBackground(true);
                setContentViewBackground(true);
                this.h.setPadding(0, 0, 0, a(R.dimen.navi_dimens_13dp));
                int i = this.u;
                if (i <= 0) {
                    i = a(R.dimen.navi_dimens_156dp);
                }
                layoutParams.topMargin = (i - layoutParams.height) - this.c.getPaddingBottom();
            } else {
                setVoicePanelBackground(false);
                setContentViewBackground(false);
                this.h.setPadding(0, a(R.dimen.navi_dimens_13dp), 0, 0);
                layoutParams.topMargin = this.c.getPaddingTop();
            }
            layoutParams.leftMargin = this.c.getPaddingLeft();
            layoutParams.rightMargin = this.c.getPaddingRight();
            this.d.setLayoutParams(layoutParams);
            int paddingTop = (this.t - this.c.getPaddingTop()) - this.c.getPaddingBottom();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.h.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, paddingTop);
            } else {
                layoutParams2.height = paddingTop;
            }
            this.h.setLayoutParams(layoutParams2);
            if (x.b().s2()) {
                this.k.setPadding(0, 0, 0, (int) JarUtils.getResources().getDimension(R.dimen.navi_dimens_20dp));
            } else {
                this.k.setPadding(0, 0, 0, 0);
            }
        }
    }

    public VoiceContentAnimView getContentAnimView() {
        return this.f;
    }

    public int getContentHeight() {
        return this.t;
    }

    public c.a getCurrentStatus() {
        return this.m;
    }

    public VoiceHeadView getHeadView() {
        return this.e;
    }

    public void setContentViewBackground(boolean z2) {
    }

    public void setOperateAreaVisibility(int i) {
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void setVoiceCallback(c.b bVar) {
    }

    public void setVoicePanelBackground(boolean z2) {
        FrameLayout frameLayout = this.c;
        if (frameLayout == null) {
            return;
        }
        try {
            if (z2) {
                frameLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_voice_panel_voice_info));
            } else {
                frameLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BNVoiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNVoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8487a = false;
        this.m = c.a.FINISH;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = false;
        this.r = false;
        this.t = 0;
        this.u = 0;
        this.f8487a = true;
        f();
    }

    public void a(String str) {
        String str2;
        g gVar = g.ASR;
        if (gVar.d()) {
            String str3 = x;
            StringBuilder sb = new StringBuilder();
            sb.append("IAsrView status : start text = ");
            sb.append(str);
            sb.append("，curThread == isMainThread : ");
            sb.append(Looper.getMainLooper().getThread() == Thread.currentThread());
            sb.append("，currentStatus = ");
            sb.append(this.m);
            sb.append(", isRestartAsr = ");
            sb.append(this.r);
            gVar.e(str3, sb.toString());
        }
        setVisibility(0);
        TextView textView = this.k;
        if (str == null) {
            str2 = null;
        } else {
            str2 = "“" + str + "”";
        }
        textView.setText(str2);
        String l = d.B().l();
        if (TextUtils.isEmpty(l)) {
            l = getRandomHelpTitle();
        }
        this.l.setText(l);
        this.l.setVisibility(0);
        this.k.setVisibility(0);
        this.i.setVisibility(8);
        c.a aVar = this.m;
        boolean z2 = aVar == c.a.PLAY || aVar == c.a.RELISTEN;
        if (z2) {
            this.h.setVisibility(4);
            this.s.setText(VoiceViewInterface.StatusText.RELISTEN.text);
        } else {
            this.h.setVisibility(0);
            this.s.setText(VoiceViewInterface.StatusText.START.text);
        }
        c.a aVar2 = this.m;
        if (aVar2 == c.a.FINISH || aVar2 == c.a.CANCEL || this.r) {
            if (z2) {
                this.e.reListen();
            }
            c.b m = d.B().m();
            if (this.r) {
                this.r = false;
                m.a(true);
            } else if (m != null && d.B().k() == null) {
                m.a(false);
            }
        } else if (z2) {
            this.e.reListen();
        }
        this.m = z2 ? c.a.RELISTEN : c.a.START;
    }

    public void a(Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation;
        this.u = this.t;
        setVisibility(0);
        setContentVisiblityAfterClearAnim(0);
        this.d.setVisibility(4);
        g();
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        if (x.b().s2()) {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.1f, 1, 1.0f);
        } else {
            scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 0, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left), 0, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_top));
        }
        scaleAnimation.setDuration(500L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(animationListener);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(50);
        alphaAnimation2.setStartOffset(450);
        this.o = animationSet;
        this.p = alphaAnimation2;
        this.c.startAnimation(animationSet);
        this.d.startAnimation(this.p);
        this.g.setPadding(0, 0, 0, x.b().s2() ? z : A);
    }

    public void a() {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e(x, "orientationChanged");
        }
        d();
        e();
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.w.cancel();
        }
        AnimatorSet animatorSet2 = this.v;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.v.cancel();
        }
        c.a aVar = this.m;
        if (aVar == c.a.FINISH || aVar == c.a.CANCEL) {
            setVisibility(8);
        }
        b();
        h();
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setAlpha(1.0f);
            if (x.b().s2()) {
                this.g.setPadding(0, 0, 0, this.u == this.t ? z : B);
            } else {
                this.g.setPadding(0, 0, 0, this.u == this.t ? A : B);
            }
        }
    }

    private int a(int i) {
        return JarUtils.getResources().getDimensionPixelOffset(i);
    }
}
