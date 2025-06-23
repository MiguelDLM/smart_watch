package com.baidu.navisdk.ugc.eventdetails.view;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.eventdetails.adapter.b;
import com.baidu.navisdk.ugc.eventdetails.control.e;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.eventdetails.view.VideoWidget;
import com.baidu.navisdk.ugc.eventdetails.view.a;
import com.baidu.navisdk.ugc.pictures.previews.c;
import com.baidu.navisdk.ugc.quickinput.sugs.QuickInputPromptView;
import com.baidu.navisdk.ugc.video.c;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper;
import com.baidu.navisdk.ui.widget.TwoStateScrollView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.c0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.bumptech.glide.Glide;

/* loaded from: classes8.dex */
public abstract class b implements com.baidu.navisdk.ugc.eventdetails.interfaces.b, View.OnClickListener, com.baidu.navisdk.ugc.listener.a, c.a, VideoWidget.a, com.baidu.navisdk.ugc.listener.c, c.e {
    View A;
    private TextView B;
    private ImageView C;
    View D;
    TextView E;
    ViewGroup F;
    View G;
    TextView H;
    TextView I;
    View J;
    TextView K;
    ImageView L;
    TextView M;
    private View N;
    private View O;
    private View P;
    private View T;

    /* renamed from: a, reason: collision with root package name */
    protected com.baidu.navisdk.ugc.eventdetails.control.a f8112a;
    private View c;
    private TextView c0;
    private View d;
    private int d0;
    private View e;
    private View f;
    protected ViewGroup g;
    private com.baidu.navisdk.ugc.video.c h0;
    com.baidu.navisdk.ugc.eventdetails.adapter.b i;
    private com.baidu.navisdk.ugc.video.b i0;
    com.baidu.navisdk.ugc.pictures.previews.c j0;
    private View k;
    private boolean k0;
    private ViewGroup l;
    private final com.baidu.navisdk.ugc.eventdetails.control.e l0;
    private com.baidu.navisdk.ugc.listener.b m0;
    private InterceptTouchLinearLayout n;
    private ViewTreeObserver.OnGlobalLayoutListener n0;
    View o;

    /* renamed from: o0, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f8113o0;
    View p;
    private boolean p0;
    TextView q;
    com.baidu.navisdk.ugc.eventdetails.model.a q0;
    ImageView r;
    private a.d0 r0;
    TextView s;
    TextView t;
    TextView v;
    ViewGroup w;
    View x;
    private TextView y;
    private ImageView z;
    protected View b = null;
    private PullToRefreshRecyclerView h = null;
    private boolean j = false;
    View m = null;
    TextView u = null;
    private TextView Q = null;
    private ImageView R = null;
    private com.baidu.navisdk.ugc.dialog.b S = null;
    private EditText U = null;
    private ImageView V = null;
    private View W = null;
    private ImageView X = null;
    private ImageView Y = null;
    private ImageView Z = null;
    private boolean a0 = false;
    private boolean b0 = false;
    private boolean e0 = false;
    private boolean f0 = false;
    private boolean g0 = false;
    private final com.baidu.navisdk.util.worker.f<String, String> s0 = new u("UgcModule_EventDetails-EnablePullTask", null);
    private final e.d t0 = new w();
    private final e.d u0 = new x();
    private final View.OnFocusChangeListener v0 = new n();
    private final TextWatcher w0 = new r();

    /* loaded from: classes8.dex */
    public class a implements b.f {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.adapter.b.f
        public void a(e.a aVar) {
            b.this.f8112a.a(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class a0 implements PullToRefreshRecyclerView.PagingableListener {
        public a0() {
        }

        @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.PagingableListener
        public void onLoadMoreItems() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "onLoadMoreItems:  --> ");
                TipTool.onCreateToastDialog(b.this.f8112a.f(), "onLoadMoreItems");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.2", null, null, null);
            b.this.f8112a.b();
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnTouchListenerC0377b implements View.OnTouchListener {
        public ViewOnTouchListenerC0377b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "onTouch: action --> " + motionEvent.getAction());
            if (motionEvent.getAction() == 1) {
                b.this.f(true);
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements BaseLoadMoreView.OnDrawListener {
        public b0() {
        }

        @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView.OnDrawListener
        public boolean onDrawLoadMore(Canvas canvas, RecyclerView recyclerView) {
            View view;
            if (b.this.l.getChildCount() == 0) {
                if (b.this.l0 != null) {
                    view = b.this.l0.a(b.this.f8112a.f());
                } else {
                    view = null;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    b.this.l.addView(view, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            b.this.l.setVisibility(0);
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "onTouch: action --> " + motionEvent.getAction());
            if (motionEvent.getAction() == 1) {
                b.this.f(false);
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 0) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = b.this.f8112a;
            if (aVar != null) {
                aVar.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.F();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.h != null && b.this.p0) {
                b.this.h.goToTop();
                b.this.E();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.L();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.u();
            b.this.C();
            b.this.g(false);
            com.baidu.navisdk.ugc.dialog.g.e().a(b.this.f8112a.d(), 257, b.this.m0, b.this.h0, b.this, 2);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.U != null && b.this.a0) {
                b.this.a0 = false;
                if (b.this.R != null) {
                    b.this.R.setVisibility(8);
                }
                if (b.this.V != null) {
                    b.this.V.setVisibility(8);
                }
                if (b.this.U != null) {
                    b.this.U.setText("");
                }
                if (b.this.Q != null) {
                    b.this.Q.setText("");
                    b.this.Q.setHint(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_ugc_detail_post_comment_prompt));
                    b.this.Q.setHintTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_ugc_txt_normal));
                }
                b.this.f8112a.k().g(null);
                b.this.O();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.u();
            if (com.baidu.navisdk.ui.util.g.a()) {
                return;
            }
            if (b.this.f8112a.u()) {
                TipTool.onCreateToastDialog(b.this.f8112a.f(), "正在发布中...");
                return;
            }
            if (!com.baidu.navisdk.util.common.z.a(b.this.f8112a.f())) {
                TipTool.onCreateToastDialog(b.this.f8112a.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
                return;
            }
            String a2 = com.baidu.navisdk.ugc.https.d.a(b.this.q0.m());
            if (TextUtils.isEmpty(a2)) {
                TipTool.onCreateToastDialog(b.this.f8112a.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_lackgps));
                return;
            }
            b.this.f8112a.k().r(a2);
            if (!b.this.f8112a.B()) {
                b.this.f8112a.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements com.baidu.navisdk.ugc.eventdetails.view.h {
        public k(b bVar) {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.view.h
        public boolean a(MotionEvent motionEvent) {
            motionEvent.getAction();
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements View.OnTouchListener {
        public l(b bVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnFocusChangeListener {
        public n() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                b.this.w();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public o() {
        }

        @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            b.this.u();
        }

        @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i) {
        }
    }

    /* loaded from: classes8.dex */
    public class p implements QuickInputPromptView.b {
        public p() {
        }

        @Override // com.baidu.navisdk.ugc.quickinput.sugs.QuickInputPromptView.b
        public void a(String str, String str2) {
            b.this.f8112a.k().a(str, str2);
        }
    }

    /* loaded from: classes8.dex */
    public class q implements com.baidu.navisdk.ugc.quickinput.tags.a {
        public q() {
        }

        @Override // com.baidu.navisdk.ugc.quickinput.tags.a
        public void a(int i, String str, int i2) {
            if (i2 == 2) {
                b.this.f8112a.k().a(i, str);
            } else {
                b.this.f8112a.k().b(i, str);
            }
            b.this.O();
        }
    }

    /* loaded from: classes8.dex */
    public class r implements TextWatcher {
        public r() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (b.this.U == null) {
                return;
            }
            if (editable.length() <= 0) {
                if (b.this.a0) {
                    b.this.a0 = false;
                    if (b.this.R != null) {
                        b.this.R.setVisibility(8);
                    }
                    if (b.this.V != null) {
                        b.this.V.setVisibility(8);
                    }
                }
            } else if (!b.this.a0) {
                b.this.a0 = true;
                if (b.this.R != null) {
                    b.this.R.setVisibility(0);
                }
                if (b.this.V != null) {
                    b.this.V.setVisibility(0);
                }
            }
            if (editable.length() > 40) {
                b.this.U.setText(b.this.U.getText().toString().substring(0, 40));
                Selection.setSelection(b.this.U.getText(), 40);
                TipTool.onCreateToastDialog(b.this.f8112a.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_content_max_length));
            }
            b.this.f8112a.k().g(b.this.U.getText().toString().trim());
            b.this.O();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes8.dex */
    public class s implements ViewTreeObserver.OnGlobalLayoutListener {
        public s() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b.this.b(1);
            b bVar = b.this;
            bVar.a(bVar.e);
            b bVar2 = b.this;
            bVar2.b(bVar2.e, b.this.f8113o0);
        }
    }

    /* loaded from: classes8.dex */
    public class t implements Animation.AnimationListener {
        public t() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.A();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class u extends com.baidu.navisdk.util.worker.f<String, String> {
        public u(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (b.this.h == null) {
                return null;
            }
            b.this.h.setScrollSupport(true);
            b.this.h.onFinishLoading(true, false);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class v implements Animator.AnimatorListener {
        public v() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewGroup viewGroup = b.this.g;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes8.dex */
    public class w implements e.d {
        public w() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.e.d
        public void onAction(int i) {
            if (i == 1) {
                com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "mOutlineLoadingListener: --> ACTION_RETRY");
                b.this.b(1);
                b.this.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x implements e.d {
        public x() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.e.d
        public void onAction(int i) {
            if (i == 1) {
                com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "mCommentsLoadingListener: --> ACTION_RETRY");
                b.this.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y implements ViewTreeObserver.OnGlobalLayoutListener {
        public y() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "onGlobalLayout: outlineViewContainer --> " + b.this.o + ", scrollViewInited: " + b.this.e0);
            }
            b bVar = b.this;
            if (bVar.o == null || bVar.e0) {
                return;
            }
            int measuredHeight = b.this.o.getMeasuredHeight();
            b.this.y();
            if (b.this.h != null) {
                int measuredHeight2 = b.this.f.getMeasuredHeight() - b.this.h.getTopMargin();
                b.this.h.setHeights(measuredHeight, measuredHeight2);
                int max = Math.max((measuredHeight2 - measuredHeight) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_detail_post_comment_height), JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_161dp));
                if (b.this.f8112a.t()) {
                    max -= ScreenUtil.getInstance().getStatusBarHeight(b.this.f8112a.d());
                }
                b.this.i.a(max);
                b bVar2 = b.this;
                bVar2.i.a(bVar2.f8112a.k().c(), b.this.f8112a.k().F(), b.this.f8112a.k().m());
                b.this.i.notifyDataSetChanged();
                if (b.this.k0) {
                    b.this.k0 = false;
                    PullToRefreshRecyclerView pullToRefreshRecyclerView = b.this.h;
                    TwoStateScrollView.DragState dragState = TwoStateScrollView.DragState.BOTTOM;
                    pullToRefreshRecyclerView.status = dragState;
                    b.this.f8112a.a(dragState);
                    b bVar3 = b.this;
                    bVar3.e0 = bVar3.h.goToTop(2);
                } else {
                    b bVar4 = b.this;
                    bVar4.e0 = bVar4.h.goToBottom(2);
                }
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "onGlobalLayout: scrollViewInited --> " + b.this.e0);
                }
                if (b.this.f8112a.g() == TwoStateScrollView.DragState.TOP) {
                    b.this.f0 = true;
                }
            }
            if (b.this.q0.l()) {
                b bVar5 = b.this;
                bVar5.a(bVar5.o, measuredHeight - bVar5.g.getHeight());
                b bVar6 = b.this;
                bVar6.a(bVar6.k, measuredHeight - b.this.g.getHeight());
            }
            b bVar7 = b.this;
            bVar7.b(bVar7.n, b.this.n0);
        }
    }

    /* loaded from: classes8.dex */
    public class z implements TwoStateScrollView.OnStatusChangeListener {
        public z() {
        }

        @Override // com.baidu.navisdk.ui.widget.TwoStateScrollView.OnStatusChangeListener
        public void onStatusChange(TwoStateScrollView.DragState dragState) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "onStatusChange: --> mCurState: " + b.this.f8112a.g() + ", state: " + dragState + ", needRecoverState: " + b.this.f0);
            }
            if (b.this.r0 != null) {
                b.this.r0.a(dragState);
            }
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = b.this.f8112a;
            if (aVar != null && aVar.g() != dragState) {
                b.this.f8112a.a(dragState);
                if (dragState == TwoStateScrollView.DragState.BOTTOM) {
                    if (b.this.f0) {
                        b.this.f0 = false;
                        if (b.this.h != null) {
                            b.this.h.goToTop(2);
                        }
                    } else {
                        View view = b.this.p;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                    }
                    b.this.f8112a.C();
                } else {
                    View view2 = b.this.p;
                    if (view2 != null) {
                        view2.setVisibility(4);
                    }
                    b.this.E();
                    if (b.this.g0 && b.this.f8112a.k().d() == 0) {
                        b.this.L();
                    }
                    b.this.f8112a.c(false);
                }
            }
            b.this.g0 = false;
        }
    }

    public b(Context context, int i2, com.baidu.navisdk.ugc.eventdetails.model.a aVar, com.baidu.navisdk.ugc.eventdetails.control.a aVar2) {
        boolean z2;
        this.d0 = 1;
        this.k0 = false;
        this.p0 = true;
        this.f8112a = aVar2;
        this.d0 = i2;
        this.q0 = aVar;
        if (aVar.e() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.p0 = z2;
        this.l0 = new com.baidu.navisdk.ugc.eventdetails.control.e();
        this.k0 = aVar.f == 7;
        if (!this.p0) {
            this.k0 = false;
        }
        a(context);
        d(false);
    }

    private void H() {
        if (this.j0 == null) {
            com.baidu.navisdk.ugc.pictures.previews.c cVar = new com.baidu.navisdk.ugc.pictures.previews.c(this);
            this.j0 = cVar;
            cVar.a(this);
        }
        this.j0.a(this.f8112a.d(), this.f8112a.k().u(), 2);
    }

    private void I() {
        com.baidu.navisdk.ugc.video.c cVar = this.h0;
        if (cVar != null) {
            cVar.a(this.f8112a.d());
        }
    }

    private void J() {
        if (!TextUtils.isEmpty(this.f8112a.k().o()) && this.U != null && this.Q != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "recoverInputs: txt --> " + this.f8112a.k().o());
            }
            this.Q.setText(this.f8112a.k().o());
            this.U.setText(this.f8112a.k().o());
            this.Q.setTextColor(this.U.getCurrentTextColor());
        }
        if (!TextUtils.isEmpty(this.f8112a.k().u())) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcModule_EventDetails", "recoverInputs: pic --> " + this.f8112a.k().u());
            }
            a((Bitmap) null, this.f8112a.k().u());
        } else if (this.f8112a.k().U()) {
            C();
            e.b bVar = this.f8112a.k().P;
            b((Bitmap) null, bVar.b);
            com.baidu.navisdk.ugc.video.c cVar = this.h0;
            cVar.f8345a = bVar.f8076a;
            cVar.b = bVar.b;
            cVar.c = bVar.c;
        }
        O();
    }

    private void K() {
        ImageView imageView = this.Y;
        if (imageView != null && this.X != null && this.Z != null) {
            int i2 = 0;
            this.b0 = false;
            imageView.setVisibility(8);
            this.Z.setVisibility(8);
            ImageView imageView2 = this.X;
            if (!com.baidu.navisdk.j.d()) {
                i2 = 8;
            }
            imageView2.setVisibility(i2);
            this.f8112a.k().i(null);
            this.Y.setImageDrawable(null);
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        u();
        if (this.O != null && this.P != null && this.Q != null && this.T != null && this.U != null) {
            d(true);
            if (this.S == null) {
                com.baidu.navisdk.ugc.dialog.b bVar = new com.baidu.navisdk.ugc.dialog.b();
                this.S = bVar;
                bVar.c(this.O);
                this.S.b(this.P);
                this.S.a(this.Q);
                this.S.a(this.T);
                this.S.a(this.U);
                this.S.a(this.d0);
                this.S.b(2);
                this.S.a(new o());
                this.S.h.b = this.f8112a.k().P();
                this.S.h.e = new p();
                this.S.h.i = new q();
                this.S.h.g = this.f8112a.m();
                if (com.baidu.navisdk.module.ugc.a.b(this.q0.c())) {
                    com.baidu.navisdk.ugc.quickinput.a aVar = this.S.h;
                    aVar.c = false;
                    aVar.d = false;
                } else {
                    com.baidu.navisdk.ugc.quickinput.a aVar2 = this.S.h;
                    aVar2.c = true;
                    aVar2.d = true;
                }
            }
            if (this.f8112a.k().N != null) {
                this.S.h.j = this.f8112a.k().N.b;
            } else {
                this.S.h.j = -1;
            }
            if (this.f8112a.k().M != null) {
                this.S.h.k = this.f8112a.k().M.b;
            } else {
                this.S.h.k = -1;
            }
            com.baidu.navisdk.ugc.dialog.g.e().a(this.f8112a.d(), this.S);
        }
    }

    private void M() {
        if (this.E != null && this.f8112a.k().S == 1) {
            this.E.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_comment, Integer.valueOf(this.f8112a.k().d())));
        }
    }

    private void N() {
        boolean T = this.f8112a.k().T();
        this.p0 = T;
        if (!T) {
            this.k0 = false;
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setScrollSupport(T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.c0 != null) {
            if (!this.a0 && !this.b0 && !this.f8112a.k().S()) {
                this.c0.setEnabled(false);
                this.c0.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_ugc_txt_normal));
            } else {
                this.c0.setEnabled(true);
                this.c0.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_link_a));
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.listener.a
    public void c(String str) {
    }

    @LayoutRes
    public abstract int k();

    public void l() {
    }

    public boolean o() {
        return false;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onActivityResult(int i2, int i3, Intent intent) {
        com.baidu.navisdk.ugc.video.c cVar = this.h0;
        if (cVar != null && cVar.a(i2)) {
            this.h0.b(i3, intent);
            return;
        }
        if (com.baidu.navisdk.ugc.utils.a.a(i2)) {
            com.baidu.navisdk.ugc.utils.a.a(i2, i3, intent, this);
            return;
        }
        com.baidu.navisdk.ugc.video.b bVar = this.i0;
        if (bVar != null && bVar.a(i2)) {
            this.i0.a(this.f8112a.d(), i2, i3, intent);
        } else if (com.baidu.navisdk.ugc.dialog.g.e().a(i2)) {
            com.baidu.navisdk.ugc.dialog.g.e().a(i2, i3, intent);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public boolean onBackPressed() {
        if (p()) {
            return true;
        }
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
        if (aVar != null) {
            aVar.y();
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ugc_rc_details_bg) {
            G();
            return;
        }
        if (id != R.id.layout_pgc_source && id != R.id.layout_ugc_source) {
            if (id == R.id.back_container) {
                com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
                if (aVar != null) {
                    aVar.y();
                }
                View view2 = this.b;
                if (view2 != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            if (id == R.id.ugc_sub_photo_show_iv) {
                ImageView imageView = this.Z;
                if (imageView != null && imageView.getVisibility() == 0) {
                    I();
                    return;
                } else {
                    H();
                    return;
                }
            }
            return;
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null && this.p0) {
            pullToRefreshRecyclerView.goToTop();
            E();
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onDestroy() {
        TextWatcher textWatcher;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "BNUgcEventDetailsSlidablyView onDestroy");
        }
        d(false);
        u();
        v();
        h(false);
        com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.l0;
        if (eVar != null) {
            eVar.a();
        }
        b(this.n, this.n0);
        this.n0 = null;
        b(this.e, this.f8113o0);
        this.f8113o0 = null;
        com.baidu.navisdk.ugc.video.b bVar = this.i0;
        if (bVar != null) {
            bVar.a();
            this.i0 = null;
        }
        com.baidu.navisdk.ugc.video.c cVar = this.h0;
        if (cVar != null) {
            cVar.a();
            this.h0 = null;
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setOnStatusChangeListener(null);
        }
        EditText editText = this.U;
        if (editText != null && (textWatcher = this.w0) != null) {
            editText.removeTextChangedListener(textWatcher);
        }
        if (this.q0.g == 1) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "BNUgcEventDetailsSlidablyView naving onDestroy focus resumeVoiceTTSOutput");
            }
            TTSPlayerControl.resumeVoiceTTSOutput();
            com.baidu.navisdk.ugc.utils.e.f8333a.a(com.baidu.navisdk.framework.a.c().a());
        }
        this.j = false;
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar2 = this.i;
        if (bVar2 != null) {
            bVar2.a((VideoWidget.a) null);
            this.i.a((b.f) null);
        }
        com.baidu.navisdk.ui.util.j.b(this.r);
        com.baidu.navisdk.ui.util.j.b(this.Y);
        this.o = null;
        if (!com.baidu.navisdk.ugc.utils.h.c.c()) {
            com.baidu.navisdk.framework.b.b(true);
        }
        com.baidu.navisdk.ugc.pictures.previews.c cVar2 = this.j0;
        if (cVar2 != null) {
            cVar2.c();
            this.j0 = null;
        }
        this.f8112a = null;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onPause() {
        com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "onPause: --> ");
        u();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onResume() {
        com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "onResume: --> ");
        if (this.e != null && this.f8113o0 == null) {
            s sVar = new s();
            this.f8113o0 = sVar;
            a(this.e, sVar);
        }
    }

    public boolean p() {
        return false;
    }

    public abstract boolean q();

    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "initOutlineData mPanelType: " + this.q0.k);
        }
        if (this.q0.d() == 1) {
            if (this.f8112a.c(this.q0.j())) {
                return;
            }
            a(1, JarUtils.getResources().getString(R.string.nsdk_string_ugc_load_failed_try_again), false);
        } else {
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
            if (aVar == null || aVar.a()) {
                return;
            }
            this.f8112a.o();
        }
    }

    private void B() {
        View view = this.N;
        if (view != null) {
            this.O = view.findViewById(R.id.ugc_detail_post_comment_edit_layout);
            this.P = this.N.findViewById(R.id.ugc_post_comment_input_tv_view);
            this.Q = (TextView) this.N.findViewById(R.id.ugc_post_comment_input_tv);
            this.V = (ImageView) this.N.findViewById(R.id.ugc_post_comment_delete_tv);
            this.T = this.N.findViewById(R.id.ugc_post_comment_input_et_view);
            this.U = (EditText) this.N.findViewById(R.id.ugc_post_comment_input_et);
            this.R = (ImageView) this.N.findViewById(R.id.ugc_post_comment_delete_et);
            this.W = this.N.findViewById(R.id.ugc_sub_photo_show_layout);
            ImageView imageView = (ImageView) this.N.findViewById(R.id.ugc_sub_info_fill_photo_iv);
            this.X = imageView;
            imageView.setVisibility(com.baidu.navisdk.j.d() ? 0 : 8);
            this.Y = (ImageView) this.N.findViewById(R.id.ugc_sub_photo_show_iv);
            this.c0 = (TextView) this.N.findViewById(R.id.ugc_post_comment_submit_tv);
            this.Z = (ImageView) this.N.findViewById(R.id.ugc_sub_photo_show_play_video_iv);
            this.P.setVisibility(0);
            this.T.setVisibility(8);
            O();
            TextView textView = this.Q;
            if (textView != null) {
                textView.setOnClickListener(new g());
            }
            EditText editText = this.U;
            if (editText != null) {
                editText.setOnFocusChangeListener(this.v0);
                this.U.addTextChangedListener(this.w0);
            }
            if (q()) {
                ImageView imageView2 = this.Y;
                if (imageView2 != null) {
                    imageView2.setOnClickListener(this);
                }
                ImageView imageView3 = this.X;
                if (imageView3 != null) {
                    imageView3.setOnClickListener(new h());
                }
            } else {
                View view2 = this.W;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            i iVar = new i();
            ImageView imageView4 = this.V;
            if (imageView4 != null) {
                imageView4.setOnClickListener(iVar);
            }
            ImageView imageView5 = this.R;
            if (imageView5 != null) {
                imageView5.setOnClickListener(iVar);
            }
            TextView textView2 = this.c0;
            if (textView2 != null) {
                textView2.setOnClickListener(new j());
            }
            View view3 = this.N;
            if (view3 != null) {
                view3.setOnTouchListener(new l(this));
            }
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.h0 == null) {
            com.baidu.navisdk.ugc.video.c cVar = new com.baidu.navisdk.ugc.video.c(this.q0.g == 1);
            this.h0 = cVar;
            cVar.a((c.a) this);
            this.h0.a((com.baidu.navisdk.ugc.listener.c) this);
        }
    }

    private void D() {
        if (this.f8112a.k() == null || this.f8112a.k().t() == null) {
            return;
        }
        s();
        int d2 = this.f8112a.k().t().d();
        if (d2 != 0) {
            if (d2 == 1) {
                this.f8112a.k().e(1);
                this.f8112a.k().c(this.f8112a.k().I() + 1);
                e(true);
            } else {
                this.f8112a.k().e(2);
                this.f8112a.k().d(this.f8112a.k().J() + 1);
                e(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        int i2 = this.q0.g;
        int i3 = i2 != 1 ? i2 == 2 ? 3 : i2 == 3 ? 4 : 1 : 2;
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.1", "" + i3, null, null);
        x();
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setSwipeEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null && this.p0) {
            this.g0 = pullToRefreshRecyclerView.goToTop();
        }
        if (this.g0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.6", this.f8112a.m() + "", null, null);
        }
    }

    private void G() {
        if (o()) {
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
        if (aVar != null) {
            aVar.y();
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z2) {
        if (this.m0 == null || z2) {
            this.m0 = new m();
        }
    }

    private void t() {
        ImageView imageView;
        if (this.X == null || (imageView = this.Y) == null || this.Z == null) {
            return;
        }
        this.b0 = false;
        imageView.setVisibility(8);
        this.Z.setVisibility(8);
        this.X.setVisibility(0);
        this.Y.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.baidu.navisdk.ugc.dialog.g.e().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.baidu.navisdk.ugc.dialog.g.e().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.U != null) {
            ((InputMethodManager) com.baidu.navisdk.framework.a.c().a().getSystemService("input_method")).hideSoftInputFromWindow(this.U.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar;
        if (this.j || (aVar = this.f8112a) == null || aVar.b()) {
            return;
        }
        this.j = true;
        b(3);
        this.f8112a.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void y() {
        try {
            if (this.i == null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "initCommentsList: --> ");
                }
                this.h.setNeedStatusChangeAlways(true);
                this.h.setScrollSupport(this.p0);
                if (this.f8112a.r()) {
                    this.c.setVisibility(0);
                    int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_details_title_height);
                    if (this.f8112a.t()) {
                        dimensionPixelOffset += ScreenUtil.getInstance().getStatusBarHeight(this.f8112a.d());
                    }
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = dimensionPixelOffset;
                    }
                    this.c.setLayoutParams(layoutParams);
                    this.h.setTopMargin(dimensionPixelOffset + this.f8112a.h());
                    this.h.setTitleView(this.c, (int) (ScreenUtil.getInstance().getHeightPixels() / 3.0d));
                    this.h.setTitleAnimEnabled(true);
                } else {
                    this.h.setTitleView(null, 0);
                    this.h.setTitleAnimEnabled(false);
                    this.h.setTopMargin(this.f8112a.h());
                }
                this.h.setViewBg(this.k);
                this.h.setEnableBg(true);
                this.h.setBottomView(this.N, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_detail_post_comment_height), (int) (ScreenUtil.getInstance().getHeightPixels() / 3.0d));
                this.h.setEnableBottomAnim(true);
                this.h.setSwipeEnable(true);
                this.h.setLayoutManager(new DetailLinearLayoutManager(this.f8112a.f()));
                this.h.setPagingableListener(new a0());
                BaseLoadMoreView baseLoadMoreView = new BaseLoadMoreView(this.f8112a.f(), this.h.getRecyclerView());
                baseLoadMoreView.setLoadMorePadding(JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_detail_loading_footer_height));
                this.h.setLoadMoreFooter(baseLoadMoreView);
                this.h.getLoadMoreFooter().setOnDrawListener(new b0());
                com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = new com.baidu.navisdk.ugc.eventdetails.adapter.b(this.f8112a.f(), this.f8112a);
                this.i = bVar;
                bVar.a(new a());
                this.i.a(this);
                this.i.b(false);
                if (this.o.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.o.getParent()).removeView(this.o);
                }
                this.i.a(this.o);
                this.h.setAdapter(this.i);
                this.h.setVisibility(0);
                l();
                B();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void z() {
        View view = this.f;
        if (view != null && this.q0.g != 3) {
            view.setOnClickListener(this);
        }
        View view2 = this.d;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        if (this.n != null && this.n0 == null) {
            y yVar = new y();
            this.n0 = yVar;
            a(this.n, yVar);
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setOnStatusChangeListener(new z());
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void h() {
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.i;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void i() {
        this.c = this.b.findViewById(R.id.title_container);
        this.d = this.b.findViewById(R.id.back_container);
        this.e = this.b.findViewById(R.id.detail_contents);
        View findViewById = this.b.findViewById(R.id.ugc_rc_details_bg);
        this.f = findViewById;
        if (this.q0.g == 4) {
            findViewById.setBackgroundColor(Color.parseColor("#66000000"));
        } else {
            findViewById.setBackgroundColor(JarUtils.getResources().getColor(android.R.color.transparent));
        }
        this.g = (ViewGroup) this.b.findViewById(R.id.contents_loading_state_container);
        InterceptTouchLinearLayout interceptTouchLinearLayout = (InterceptTouchLinearLayout) this.b.findViewById(R.id.outline_container_outer);
        this.n = interceptTouchLinearLayout;
        interceptTouchLinearLayout.setOnInterceptTouchListener(new k(this));
        this.w = (ViewGroup) this.b.findViewById(R.id.im_container);
        this.k = this.b.findViewById(R.id.ugc_comments_listview_bg);
        this.l = (ViewGroup) this.b.findViewById(R.id.ugc_comments_loading_footer_container);
        this.h = (PullToRefreshRecyclerView) this.b.findViewById(R.id.ugc_comments_listview);
        this.N = this.b.findViewById(R.id.post_comment_container);
    }

    public void j() {
        this.p = this.o.findViewById(R.id.v_pull_up);
        this.r = (ImageView) this.o.findViewById(R.id.ic_event_type);
        this.s = (TextView) this.o.findViewById(R.id.tv_event_type);
        this.m = this.o.findViewById(R.id.ugc_event_details_content_layout);
        this.t = (TextView) this.o.findViewById(R.id.tv_event_description);
        this.u = (TextView) this.o.findViewById(R.id.tv_event_address_and_distance);
        this.q = (TextView) this.o.findViewById(R.id.view_avoid_congestion);
        this.v = (TextView) this.o.findViewById(R.id.tv_event_time_stamp);
        this.J = this.o.findViewById(R.id.layout_ugc_source);
        this.K = (TextView) this.o.findViewById(R.id.tv_event_reporter_ugc_name);
        this.L = (ImageView) this.o.findViewById(R.id.iv_event_reporter_ugc_icon);
        this.M = (TextView) this.o.findViewById(R.id.tv_event_reporter_ugc_supplement);
        this.x = this.o.findViewById(R.id.view_useful);
        this.y = (TextView) this.o.findViewById(R.id.tv_useful);
        this.z = (ImageView) this.o.findViewById(R.id.iv_useful);
        this.A = this.o.findViewById(R.id.view_useless);
        this.B = (TextView) this.o.findViewById(R.id.tv_useless);
        this.C = (ImageView) this.o.findViewById(R.id.iv_useless);
        this.D = this.o.findViewById(R.id.view_detail_comment);
        this.E = (TextView) this.o.findViewById(R.id.tv_detail_comment);
        this.F = (ViewGroup) this.o.findViewById(R.id.nsdk_layout_ugc_useful_new);
        this.G = this.o.findViewById(R.id.btn_container_new);
        this.H = (TextView) this.o.findViewById(R.id.report_open);
        this.I = (TextView) this.o.findViewById(R.id.try_to_avoid);
    }

    @Override // com.baidu.navisdk.ugc.listener.a
    public void m() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
        if (aVar != null) {
            aVar.D();
        }
    }

    public void n() {
        if (this.n == null) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "initOutlineView: --> outlineViewContainerOuter = null");
            return;
        }
        View inflate = JarUtils.inflate(this.f8112a.f(), k(), null);
        this.o = inflate;
        if (inflate == null) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "initUgcPanelOutlineView: --> inflate fail");
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
            if (aVar != null) {
                aVar.y();
            }
            View view = this.b;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        j();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "initOutlineView: --> outlineViewContainerOuter add inner view");
        }
        if (this.n.getChildCount() == 0) {
            this.n.addView(this.o, new ViewGroup.LayoutParams(-1, -2));
            this.n.setVisibility(0);
        }
        View view2 = this.x;
        if (view2 != null) {
            view2.setOnTouchListener(new ViewOnTouchListenerC0377b());
        }
        View view3 = this.A;
        if (view3 != null) {
            view3.setOnTouchListener(new c());
        }
        TextView textView = this.I;
        if (textView != null) {
            textView.setOnClickListener(new d());
        }
        if (this.D != null) {
            this.E.setText("评论(0)");
            this.D.setOnClickListener(new e());
        }
        View view4 = this.J;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
        View view5 = this.o;
        if (view5 != null) {
            view5.setOnClickListener(new f());
        }
    }

    public void r() {
        if (this.r != null) {
            if (!TextUtils.isEmpty(this.f8112a.k().N())) {
                try {
                    this.r.setVisibility(0);
                    com.baidu.navisdk.ugc.utils.d.a(this.f8112a.k().P(), this.r, this.f8112a.k().N());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                this.r.setVisibility(8);
            }
        }
        TextView textView = this.s;
        if (textView != null) {
            textView.setText(this.f8112a.k().O());
        }
        if (this.t != null) {
            String f2 = this.f8112a.k().f() == null ? this.f8112a.k().f() : this.f8112a.k().f().trim();
            if (TextUtils.isEmpty(f2)) {
                this.t.setVisibility(8);
                View view = this.m;
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                this.t.setText(f2);
            }
        }
        if (this.v != null) {
            String A = this.f8112a.k().A();
            if (TextUtils.isEmpty(A)) {
                this.v.setVisibility(8);
            } else {
                this.v.setText(A);
            }
        }
        e(true);
        e(false);
        M();
        D();
    }

    public void b(int i2) {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar;
        com.baidu.navisdk.ugc.eventdetails.control.a aVar2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "loadingStart: type --> " + i2);
        }
        if (i2 == 1) {
            ViewGroup viewGroup = this.g;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.l0;
            if (eVar == null || (aVar = this.f8112a) == null) {
                return;
            }
            eVar.a(aVar.d(), 2, this.g);
            return;
        }
        if (i2 != 3) {
            com.baidu.navisdk.ugc.eventdetails.control.e eVar2 = this.l0;
            if (eVar2 == null || (aVar2 = this.f8112a) == null) {
                return;
            }
            eVar2.a(aVar2.d(), 1, null);
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.i;
        if (bVar != null) {
            bVar.a(b.i.LOADING);
            this.i.notifyDataSetChanged();
        }
    }

    public void d(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "setIsUserOperating: " + z2);
        }
        int i2 = this.q0.g;
        if (i2 == 1 || i2 == 3) {
            com.baidu.navisdk.ugc.d.a(z2);
        }
    }

    public void e(boolean z2) {
        Drawable f2;
        Drawable f3;
        int M = this.f8112a.k().M();
        int color = JarUtils.getResources().getColor(R.color.nsdk_ugc_txt_unfocused);
        int color2 = JarUtils.getResources().getColor(R.color.nsdk_ugc_txt_normal);
        if (z2) {
            boolean z3 = M == 1;
            TextView textView = this.y;
            if (textView != null) {
                textView.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_useful, Integer.valueOf(this.f8112a.k().I())));
                TextView textView2 = this.y;
                if (z3) {
                    color = color2;
                }
                textView2.setTextColor(color);
            }
            ImageView imageView = this.z;
            if (imageView != null) {
                if (z3) {
                    f3 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useful_selected);
                } else {
                    f3 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useful_normal);
                }
                imageView.setImageDrawable(f3);
                return;
            }
            return;
        }
        boolean z4 = M == 2;
        TextView textView3 = this.B;
        if (textView3 != null) {
            textView3.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_useless, Integer.valueOf(this.f8112a.k().J())));
            TextView textView4 = this.B;
            if (z4) {
                color = color2;
            }
            textView4.setTextColor(color);
        }
        ImageView imageView2 = this.C;
        if (imageView2 != null) {
            if (z4) {
                f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useless_selected);
            } else {
                f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useless_normal);
            }
            imageView2.setImageDrawable(f2);
        }
    }

    public void f(boolean z2) {
        if (!com.baidu.navisdk.util.common.z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(this.f8112a.f(), JarUtils.getResources().getString(R.string.ugc_network_unconnected));
            return;
        }
        int i2 = z2 ? 1 : 2;
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
        if (aVar == null || aVar.v()) {
            return;
        }
        if (this.f8112a.k().M() == 0) {
            this.f8112a.b(z2);
            this.f8112a.a(i2);
            b(2);
        } else if (this.f8112a.d() != null) {
            TipTool.onCreateToastDialog(this.f8112a.d(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_evaluated));
        } else {
            TipTool.onCreateToastDialog(this.f8112a.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_evaluated));
        }
    }

    /* loaded from: classes8.dex */
    public class m implements com.baidu.navisdk.ugc.listener.b {
        public m() {
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(c0.a aVar) {
            b.this.f8112a.k().i(aVar.f9222a);
            b.this.a(aVar.b, aVar.f9222a);
            b.this.v();
            b.this.O();
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(String str) {
            b.this.v();
        }
    }

    private void h(boolean z2) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setNotInterruptBlankTouchEvent(z2);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void c(boolean z2) {
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.i;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public int g() {
        View view = this.o;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        return measuredHeight == 0 ? JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_161dp) : measuredHeight;
    }

    @Override // com.baidu.navisdk.ugc.video.c.a
    public void c() {
        v();
    }

    private void a(Context context) {
        if (context == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_EventDetails", "BNUgcEventDetailsSlidablyView initViews context == null");
            }
            this.b = null;
            return;
        }
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_ugc_details_view, null);
        this.b = inflate;
        if (inflate != null) {
            i();
            h(true);
            this.c.setVisibility(8);
            z();
            if (!this.q0.l()) {
                b(1);
                A();
            }
            if (com.baidu.navisdk.ugc.utils.h.c.c()) {
                return;
            }
            com.baidu.navisdk.framework.b.b(false);
        }
    }

    @Override // com.baidu.navisdk.ugc.video.c.a
    public void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onDeleteVideo ");
        }
        t();
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.f8112a;
        if (aVar != null) {
            aVar.k().a(null, null, 0);
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view == null || onGlobalLayoutListener == null) {
            return;
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void b(boolean z2) {
        if (z2) {
            this.f8112a.k().e(1);
            this.f8112a.k().c(this.f8112a.k().I() + 1);
            this.f8112a.k().t().a(1);
        } else {
            this.f8112a.k().e(2);
            this.f8112a.k().d(this.f8112a.k().J() + 1);
            this.f8112a.k().t().a(2);
        }
        e(z2);
        if (z2) {
            com.baidu.navisdk.utils.a.a(this.x, 3.0f, 500);
        } else {
            com.baidu.navisdk.utils.a.a(this.A, 3.0f, 500);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void f() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onFixedPanelDataSetChanged: --> start: scrollViewInited = " + this.e0);
        }
        N();
        if (!this.e0) {
            n();
            r();
        }
        gVar.e("UgcModule_EventDetails", "onFixedPanelDataSetChanged: --> end");
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void a(int i2, String str, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "loadingEnd: --> type: " + i2 + ", suc: " + z2 + ", err: " + str);
        }
        if (i2 == 1) {
            if (!z2) {
                this.k0 = false;
                com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.l0;
                if (eVar != null) {
                    eVar.a(2, z2, this.g, this.t0);
                    return;
                }
                return;
            }
            N();
            com.baidu.navisdk.ugc.eventdetails.control.e eVar2 = this.l0;
            if (eVar2 != null) {
                eVar2.a(2, z2, this.g, null);
            }
            com.baidu.navisdk.utils.a.a(this.g, 300, new v());
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                com.baidu.navisdk.ugc.eventdetails.control.e eVar3 = this.l0;
                if (eVar3 != null) {
                    eVar3.a(1, z2, null, null);
                }
                TipTool.onCreateToastDialog(this.f8112a.f(), str);
                return;
            }
            if (z2) {
                return;
            }
            this.i.notifyDataSetChanged();
            TipTool.onCreateToastDialog(this.f8112a.f(), str);
            return;
        }
        if (z2) {
            return;
        }
        if (this.f8112a.k().g() == 0) {
            this.j = false;
            com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.i;
            if (bVar != null) {
                bVar.a(b.i.LOADED_FAILED);
                this.i.notifyDataSetChanged();
            }
            com.baidu.navisdk.ugc.eventdetails.control.e eVar4 = this.l0;
            if (eVar4 != null) {
                eVar4.a(2, z2, null, this.u0);
                return;
            }
            return;
        }
        TipTool.onCreateToastDialog(this.f8112a.f(), str);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.h;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.onFinishLoading(false, false);
            this.h.setScrollSupport(false);
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.s0, false);
        com.baidu.navisdk.util.worker.c.a().a(this.s0, new com.baidu.navisdk.util.worker.e(2, 0), 500L);
    }

    private void b(Bitmap bitmap, String str) {
        ImageView imageView;
        if (this.Z == null || (imageView = this.Y) == null || this.X == null) {
            return;
        }
        this.b0 = true;
        imageView.setVisibility(0);
        this.Z.setVisibility(0);
        this.X.setVisibility(8);
        if (bitmap != null) {
            this.Y.setImageBitmap(bitmap);
        } else {
            Glide.with(this.f8112a.f()).load(str).into(this.Y);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public View e() {
        return this.b;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void b() {
        this.f8112a.k().g(null);
        this.f8112a.k().a(-1, (String) null);
        this.f8112a.k().b(-1, null);
        u();
        EditText editText = this.U;
        if (editText != null) {
            editText.setText("");
        }
        TextView textView = this.Q;
        if (textView != null) {
            textView.setText("");
            this.Q.setHint(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_ugc_detail_post_comment_prompt));
            this.Q.setHintTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_ugc_txt_normal));
        }
        K();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void b(Context context, int i2) {
        this.e0 = false;
        this.f0 = false;
        this.g0 = false;
        this.j = false;
        this.a0 = false;
        this.b0 = false;
        this.n = null;
        this.i = null;
        this.S = null;
        this.d0 = i2;
    }

    private void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view == null || onGlobalLayoutListener == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void a() {
        if (this.i == null || this.l == null) {
            return;
        }
        boolean p2 = this.f8112a.p();
        int g2 = this.f8112a.k().g();
        M();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onCommentsDataSetChanged: --> moreCommentsPending: " + p2 + ", dataCount: " + g2);
        }
        if (g2 == 0) {
            this.i.a(b.i.LOADED_NO_DATA);
            this.i.notifyDataSetChanged();
            return;
        }
        y();
        this.i.a(b.i.LOADED_HAS_DATA);
        this.i.a(this.f8112a.k().c(), this.f8112a.k().F(), this.f8112a.k().m());
        if (!p2) {
            this.i.b(true);
            this.i.notifyDataSetChanged();
            this.l.setVisibility(8);
            this.h.onFinishLoading(false, false);
            return;
        }
        this.i.notifyDataSetChanged();
        this.h.onFinishLoading(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, String str) {
        ImageView imageView = this.Y;
        if (imageView == null || this.X == null || this.Z == null) {
            return;
        }
        this.b0 = true;
        imageView.setVisibility(0);
        this.Z.setVisibility(8);
        this.X.setVisibility(8);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "showPhotoBmpOrFile --> " + bitmap + ", localFilePath: " + str + ", photoShowIv:" + this.Y);
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            this.Y.setImageBitmap(bitmap);
        } else if (!TextUtils.isEmpty(str)) {
            Glide.with(this.f8112a.f()).load(str).into(this.Y);
        } else {
            K();
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public boolean a(int i2) {
        com.baidu.navisdk.ugc.video.b bVar;
        com.baidu.navisdk.ugc.video.c cVar = this.h0;
        return (cVar != null && cVar.a(i2)) || com.baidu.navisdk.ugc.utils.a.a(i2) || ((bVar = this.i0) != null && bVar.a(i2)) || com.baidu.navisdk.ugc.dialog.g.e().a(i2) || i2 == 100 || i2 == 101;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, view.getHeight(), 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setAnimationListener(new t());
        view.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i2) {
        if (view == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i2, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        view.startAnimation(translateAnimation);
    }

    @Override // com.baidu.navisdk.ugc.video.c.a
    public void a(Bitmap bitmap) {
        if (this.f8112a == null || this.h0 == null) {
            return;
        }
        v();
        b(bitmap, (String) null);
        com.baidu.navisdk.ugc.eventdetails.model.c k2 = this.f8112a.k();
        com.baidu.navisdk.ugc.video.c cVar = this.h0;
        k2.a(cVar.f8345a, cVar.b, cVar.c);
        O();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.VideoWidget.a
    public void a(String str, int i2) {
        if (this.i0 == null) {
            com.baidu.navisdk.ugc.video.b bVar = new com.baidu.navisdk.ugc.video.b(this.f8112a.f(), this.q0.g == 1);
            this.i0 = bVar;
            bVar.a(this);
        }
        this.i0.a(this.f8112a.d(), str);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.5", this.f8112a.m() + "", i2 + "", null);
    }

    @Override // com.baidu.navisdk.ugc.listener.c
    public void a(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onUserOperate: " + z2);
        }
        d(z2);
    }

    @Override // com.baidu.navisdk.ugc.pictures.previews.c.e
    public void a(String str) {
        K();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public View a(Context context, int i2) {
        com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.l0;
        if (eVar != null) {
            return eVar.a(context, i2);
        }
        return null;
    }
}
