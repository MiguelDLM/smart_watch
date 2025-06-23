package com.baidu.navisdk.ui.routeguide.asr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapframework.voice.widget.VoiceContentAnimView;
import com.baidu.mapframework.voice.widget.VoiceHeadView;
import com.baidu.navisdk.asr.i.c;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.widget.BNCommonCornerView;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNVoiceAidView extends LinearLayout implements com.baidu.navisdk.asr.i.c {

    /* renamed from: a, reason: collision with root package name */
    private VoiceHeadView f8478a;
    private ImageView b;
    private View c;
    private c.a d;
    private VoiceContentAnimView e;
    private ImageView f;
    private BNCommonCornerView g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Animator l;
    private Animator m;
    private Animator n;
    private Animator o;
    private Animator p;
    private i q;
    private j r;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "onClickClose()");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.o.4", "1", "", "0");
            Bundle bundle = new Bundle();
            bundle.putString("type", "click");
            com.baidu.navisdk.module.asr.e.INSTANCE.a(bundle);
            c.b m = com.baidu.navisdk.asr.d.B().m();
            if (m != null) {
                m.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "onAnimationUpdate() " + intValue);
            }
            ViewGroup.LayoutParams layoutParams = BNVoiceAidView.this.getLayoutParams();
            layoutParams.width = intValue;
            BNVoiceAidView.this.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "startWithAnim mainViewWidthAnim onAnimationCancel()");
            }
            super.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "startWithAnim mainViewWidthAnim onAnimationEnd()");
            }
            super.onAnimationEnd(animator);
            if (BNVoiceAidView.this.c != null) {
                BNVoiceAidView.this.c.setVisibility(0);
            }
            if (BNVoiceAidView.this.b != null) {
                BNVoiceAidView.this.b.setVisibility(0);
            }
            if (BNVoiceAidView.this.f != null) {
                BNVoiceAidView.this.f.setVisibility(0);
            }
            if (BNVoiceAidView.this.f8478a != null && BNVoiceAidView.this.d == c.a.START) {
                BNVoiceAidView.this.f8478a.start(false);
            }
            x.b().I().r();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "startWithAnim mainViewWidthAnim onAnimationStart()");
            }
            super.onAnimationStart(animator);
            if (BNVoiceAidView.this.c != null) {
                BNVoiceAidView.this.c.setVisibility(8);
            }
            if (BNVoiceAidView.this.b != null) {
                BNVoiceAidView.this.b.setVisibility(8);
            }
            if (BNVoiceAidView.this.f != null) {
                BNVoiceAidView.this.f.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BNVoiceAidView.this.f8478a != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BNVoiceAidView.this.f8478a.getLayoutParams();
                layoutParams.leftMargin = intValue;
                BNVoiceAidView.this.f8478a.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = BNVoiceAidView.this.getLayoutParams();
            layoutParams.width = intValue;
            BNVoiceAidView.this.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "exitWithAnim onAnimationEnd() ");
            }
            BNVoiceAidView.this.setVisibility(8);
            if (BNVoiceAidView.this.q != null) {
                BNVoiceAidView.this.q.n(false);
            }
            x.b().I().r();
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "exitWithAnim onAnimationStart() ");
            }
            super.onAnimationStart(animator);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BNVoiceAidView.this.f8478a != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BNVoiceAidView.this.f8478a.getLayoutParams();
                layoutParams.leftMargin = intValue;
                BNVoiceAidView.this.f8478a.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceBNVoiceAidView", "contentViewAlphaAnim onAnimationEnd()()");
            }
            if (BNVoiceAidView.this.f != null) {
                BNVoiceAidView.this.f.setAlpha(1.0f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface i {
        void n(boolean z);
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a(int i);
    }

    public BNVoiceAidView(Context context) {
        this(context, null);
    }

    private void g() {
        JarUtils.inflate(getContext(), R.layout.nsdk_voice_aid_view, this);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(a(R.dimen.navi_dimens_132dp), a(R.dimen.navi_dimens_53dp));
        marginLayoutParams.leftMargin = a(R.dimen.navi_dimens_5dp);
        marginLayoutParams.topMargin = a(R.dimen.navi_dimens_4dp);
        setLayoutParams(marginLayoutParams);
        setGravity(16);
        setOrientation(0);
        com.baidu.navisdk.ui.util.b.a(this, R.drawable.nsdk_xd_voice_aid_view_bg);
        this.b = (ImageView) findViewById(R.id.voice_add_close_iv);
        VoiceHeadView findViewById = findViewById(R.id.voice_add_head_iv);
        this.f8478a = findViewById;
        ImageView headImg = findViewById.getHeadImg();
        ViewGroup.LayoutParams layoutParams = headImg.getLayoutParams();
        layoutParams.width = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_37dp);
        layoutParams.height = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_24dp);
        headImg.setLayoutParams(layoutParams);
        this.c = findViewById(R.id.voice_add_line_view);
        this.e = findViewById(R.id.content_anim);
        BNCommonCornerView bNCommonCornerView = (BNCommonCornerView) findViewById(R.id.cornerView);
        this.g = bNCommonCornerView;
        bNCommonCornerView.setCorner(JarUtils.getResources().getDimension(R.dimen.navi_dimens_26dp));
        ImageView voiceBall = this.e.getVoiceBall();
        this.f = voiceBall;
        if (voiceBall != null) {
            voiceBall.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        this.b.setOnClickListener(new a());
        this.f8478a.setContentAnimView(this.e);
        d();
    }

    public void setOnAidSceneAnimChangedListener(i iVar) {
        this.q = iVar;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        j jVar = this.r;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public void setVisibilityCallBack(j jVar) {
        this.r = jVar;
    }

    public void setVoiceCallback(c.b bVar) {
    }

    public BNVoiceAidView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int a(int i2) {
        return getContext().getResources().getDimensionPixelOffset(i2);
    }

    private void e() {
        Animator animator = this.n;
        if (animator != null && animator.isRunning()) {
            this.n.end();
        }
        Animator animator2 = this.o;
        if (animator2 != null && animator2.isRunning()) {
            this.o.end();
        }
        Animator animator3 = this.p;
        if (animator3 == null || !animator3.isRunning()) {
            return;
        }
        this.p.end();
    }

    private void f() {
        Animator animator = this.l;
        if (animator != null && animator.isRunning()) {
            this.l.end();
        }
        Animator animator2 = this.m;
        if (animator2 == null || !animator2.isRunning()) {
            return;
        }
        this.m.end();
    }

    public void b() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.d()) {
            gVar.e("XDVoiceBNVoiceAidView", "orientationChanged()");
        }
    }

    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.d()) {
            gVar.e("XDVoiceBNVoiceAidView", "startWithAnim()");
        }
        e();
        setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.j, this.k);
        ofInt.setDuration(380L);
        ofInt.addUpdateListener(new b());
        ofInt.addListener(new c());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.h, this.i);
        ofInt2.setDuration(300L);
        ofInt2.addUpdateListener(new d());
        this.l = ofInt;
        this.m = ofInt2;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.l, this.m);
        animatorSet.start();
        i iVar = this.q;
        if (iVar != null) {
            iVar.n(true);
        }
    }

    public void d() {
        this.g.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_xd_voice_aid_view_bg));
    }

    public BNVoiceAidView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = c.a.FINISH;
        this.h = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_8dp);
        this.i = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_19dp);
        this.j = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_53dp);
        this.k = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_132dp);
        g();
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.d()) {
            gVar.e("XDVoiceBNVoiceAidView", "exitWithAnim()");
        }
        f();
        ValueAnimator ofInt = ValueAnimator.ofInt(this.k, this.j);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new e());
        ofInt.addListener(new f());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.i, this.h);
        ofInt2.setDuration(300L);
        ofInt2.addUpdateListener(new g());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new h());
        this.n = ofInt;
        this.o = ofInt2;
        this.p = ofFloat;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.n, this.o, this.p);
        animatorSet.start();
    }
}
