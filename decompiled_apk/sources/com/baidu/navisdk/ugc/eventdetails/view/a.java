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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.eventdetails.adapter.b;
import com.baidu.navisdk.ugc.eventdetails.control.e;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.eventdetails.view.VideoWidget;
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
public abstract class a implements com.baidu.navisdk.ugc.eventdetails.interfaces.b, View.OnClickListener, com.baidu.navisdk.ugc.listener.a, c.a, VideoWidget.a, com.baidu.navisdk.ugc.listener.c, c.e {
    private ImageView A;
    View B;
    private TextView C;
    private ImageView D;
    View E;
    TextView F;
    ViewGroup G;
    View H;
    TextView I;
    TextView J;
    View K;
    TextView L;
    ImageView M;
    TextView N;
    private View O;
    private View P;
    private View Q;
    private View U;

    /* renamed from: a, reason: collision with root package name */
    int f8083a;
    protected com.baidu.navisdk.ugc.eventdetails.control.a b;
    private View d;
    private TextView d0;
    private View e;
    private int e0;
    private View f;
    private View g;
    protected ViewGroup h;
    private com.baidu.navisdk.ugc.video.c i0;
    com.baidu.navisdk.ugc.eventdetails.adapter.b j;
    private com.baidu.navisdk.ugc.video.b j0;
    com.baidu.navisdk.ugc.pictures.previews.c k0;
    private View l;
    private boolean l0;
    private ViewGroup m;
    private final com.baidu.navisdk.ugc.eventdetails.control.e m0;
    private com.baidu.navisdk.ugc.listener.b n0;
    private InterceptTouchLinearLayout o;

    /* renamed from: o0, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f8084o0;
    View p;
    private ViewTreeObserver.OnGlobalLayoutListener p0;
    View q;
    private boolean q0;
    com.baidu.navisdk.ugc.eventdetails.model.a r0;
    ImageView s;
    private d0 s0;
    TextView t;
    private c0 t0;
    TextView u;
    TextView w;
    ViewGroup x;
    View y;
    private TextView z;
    protected View c = null;
    private PullToRefreshRecyclerView i = null;
    private boolean k = false;
    View n = null;
    TextView r = null;
    TextView v = null;
    private TextView R = null;
    private ImageView S = null;
    private com.baidu.navisdk.ugc.dialog.b T = null;
    private EditText V = null;
    private ImageView W = null;
    private View X = null;
    private ImageView Y = null;
    private ImageView Z = null;
    private ImageView a0 = null;
    private boolean b0 = false;
    private boolean c0 = false;
    private boolean f0 = false;
    private boolean g0 = false;
    private boolean h0 = false;
    private boolean u0 = false;
    private final com.baidu.navisdk.util.worker.f<String, String> v0 = new u("UgcModule_EventDetails-EnablePullTask", null);
    private final e.d w0 = new w();

    /* renamed from: x0, reason: collision with root package name */
    private final e.d f8085x0 = new x();
    private final View.OnFocusChangeListener y0 = new n();
    private final TextWatcher z0 = new r();

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0376a implements b.f {
        public C0376a() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.adapter.b.f
        public void a(e.a aVar) {
            a.this.b.a(aVar);
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
                TipTool.onCreateToastDialog(a.this.b.f(), "onLoadMoreItems");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.2", null, null, null);
            a.this.b.b();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "onTouch: action --> " + motionEvent.getAction());
            if (motionEvent.getAction() == 1) {
                a.this.g(true);
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
            if (a.this.m.getChildCount() == 0) {
                if (a.this.m0 != null) {
                    view = a.this.m0.a(a.this.b.f());
                } else {
                    view = null;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    a.this.m.addView(view, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            a.this.m.setVisibility(0);
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
                a.this.g(false);
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 0) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public interface c0 {
        void a();
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = a.this.b;
            if (aVar != null) {
                aVar.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d0 {
        void a(TwoStateScrollView.DragState dragState);
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.H();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i != null && a.this.q0) {
                a.this.i.goToTop();
                a.this.G();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.O();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.w();
            a.this.E();
            a.this.h(false);
            com.baidu.navisdk.ugc.dialog.g.e().a(a.this.b.d(), 257, a.this.n0, a.this.i0, a.this, 2);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.V != null && a.this.b0) {
                a.this.b0 = false;
                if (a.this.S != null) {
                    a.this.S.setVisibility(8);
                }
                if (a.this.W != null) {
                    a.this.W.setVisibility(8);
                }
                if (a.this.V != null) {
                    a.this.V.setText("");
                }
                if (a.this.R != null) {
                    a.this.R.setText("");
                    a.this.R.setHint(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_ugc_detail_post_comment_prompt));
                    a.this.R.setHintTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_ugc_txt_normal));
                }
                a.this.b.k().g(null);
                a.this.S();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.w();
            if (com.baidu.navisdk.ui.util.g.a()) {
                return;
            }
            if (a.this.b.u()) {
                TipTool.onCreateToastDialog(a.this.b.f(), "正在发布中...");
                return;
            }
            if (!com.baidu.navisdk.util.common.z.a(a.this.b.f())) {
                TipTool.onCreateToastDialog(a.this.b.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
                return;
            }
            String a2 = com.baidu.navisdk.ugc.https.d.a(a.this.r0.m());
            if (TextUtils.isEmpty(a2)) {
                TipTool.onCreateToastDialog(a.this.b.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_lackgps));
                return;
            }
            a.this.b.k().r(a2);
            if (!a.this.b.B()) {
                a.this.b.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements com.baidu.navisdk.ugc.eventdetails.view.h {
        public k(a aVar) {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.view.h
        public boolean a(MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements View.OnTouchListener {
        public l(a aVar) {
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
                a.this.y();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public o() {
        }

        @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            a.this.w();
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
            a.this.b.k().a(str, str2);
        }
    }

    /* loaded from: classes8.dex */
    public class q implements com.baidu.navisdk.ugc.quickinput.tags.a {
        public q() {
        }

        @Override // com.baidu.navisdk.ugc.quickinput.tags.a
        public void a(int i, String str, int i2) {
            if (i2 == 2) {
                a.this.b.k().a(i, str);
            } else {
                a.this.b.k().b(i, str);
            }
            a.this.S();
        }
    }

    /* loaded from: classes8.dex */
    public class r implements TextWatcher {
        public r() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.V == null) {
                return;
            }
            if (editable.length() <= 0) {
                if (a.this.b0) {
                    a.this.b0 = false;
                    if (a.this.S != null) {
                        a.this.S.setVisibility(8);
                    }
                    if (a.this.W != null) {
                        a.this.W.setVisibility(8);
                    }
                }
            } else if (!a.this.b0) {
                a.this.b0 = true;
                if (a.this.S != null) {
                    a.this.S.setVisibility(0);
                }
                if (a.this.W != null) {
                    a.this.W.setVisibility(0);
                }
            }
            if (editable.length() > 40) {
                a.this.V.setText(a.this.V.getText().toString().substring(0, 40));
                Selection.setSelection(a.this.V.getText(), 40);
                TipTool.onCreateToastDialog(a.this.b.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_content_max_length));
            }
            a.this.b.k().g(a.this.V.getText().toString().trim());
            a.this.S();
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
            a.this.b(1);
            a aVar = a.this;
            aVar.a(aVar.f);
            a aVar2 = a.this;
            aVar2.b(aVar2.f, a.this.p0);
        }
    }

    /* loaded from: classes8.dex */
    public class t implements Animation.AnimationListener {
        public t() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.C();
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
            if (a.this.i == null) {
                return null;
            }
            a.this.i.setScrollSupport(true);
            a.this.i.onFinishLoading(true, false);
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
            ViewGroup viewGroup = a.this.h;
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
                a.this.b(1);
                a.this.C();
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
                a.this.z();
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
                gVar.e("UgcModule_EventDetails", "onGlobalLayout: outlineViewContainer --> " + a.this.p + ", scrollViewInited: " + a.this.f0);
            }
            a aVar = a.this;
            if (aVar.p == null || aVar.f0) {
                return;
            }
            int measuredHeight = a.this.p.getMeasuredHeight();
            a aVar2 = a.this;
            int i = aVar2.f8083a;
            if (i == 1) {
                aVar2.A();
                if (a.this.i != null) {
                    int measuredHeight2 = a.this.g.getMeasuredHeight() - a.this.i.getTopMargin();
                    a.this.i.setHeights(measuredHeight, measuredHeight2);
                    int max = Math.max((measuredHeight2 - measuredHeight) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_detail_post_comment_height), JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_161dp));
                    if (a.this.b.t()) {
                        max -= ScreenUtil.getInstance().getStatusBarHeight(a.this.b.d());
                    }
                    a.this.j.a(max);
                    a aVar3 = a.this;
                    aVar3.j.a(aVar3.b.k().c(), a.this.b.k().F(), a.this.b.k().m());
                    a.this.j.notifyDataSetChanged();
                    if (a.this.l0) {
                        a.this.l0 = false;
                        PullToRefreshRecyclerView pullToRefreshRecyclerView = a.this.i;
                        TwoStateScrollView.DragState dragState = TwoStateScrollView.DragState.BOTTOM;
                        pullToRefreshRecyclerView.status = dragState;
                        a.this.b.a(dragState);
                        a aVar4 = a.this;
                        aVar4.f0 = aVar4.i.goToTop(2);
                    } else {
                        a aVar5 = a.this;
                        aVar5.f0 = aVar5.i.goToBottom(2);
                    }
                    if (gVar.d()) {
                        gVar.e("UgcModule_EventDetails", "onGlobalLayout: scrollViewInited --> " + a.this.f0);
                    }
                    if (a.this.b.g() == TwoStateScrollView.DragState.TOP) {
                        a.this.g0 = true;
                    }
                }
            } else if (i == 0) {
                if (aVar2.d != null) {
                    a.this.d.setVisibility(8);
                }
                if (a.this.i != null) {
                    a.this.i.setVisibility(8);
                }
                if (a.this.m != null) {
                    a.this.m.setVisibility(8);
                }
                if (a.this.l != null) {
                    a.this.l.setVisibility(8);
                }
                if (a.this.O != null) {
                    a.this.O.setVisibility(8);
                }
            }
            if (a.this.r0.l()) {
                a aVar6 = a.this;
                aVar6.a(aVar6.p, measuredHeight - aVar6.h.getHeight());
                a aVar7 = a.this;
                aVar7.a(aVar7.l, measuredHeight - a.this.h.getHeight());
            }
            a aVar8 = a.this;
            aVar8.b(aVar8.o, a.this.f8084o0);
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
                gVar.e("UgcModule_EventDetails", "onStatusChange: --> mCurState: " + a.this.b.g() + ", state: " + dragState + ", needRecoverState: " + a.this.g0);
            }
            if (a.this.s0 != null) {
                a.this.s0.a(dragState);
            }
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = a.this.b;
            if (aVar != null && aVar.g() != dragState) {
                a.this.b.a(dragState);
                if (dragState == TwoStateScrollView.DragState.BOTTOM) {
                    if (a.this.g0) {
                        a.this.g0 = false;
                        if (a.this.i != null) {
                            a.this.i.goToTop(2);
                        }
                    } else {
                        View view = a.this.q;
                        if (view != null) {
                            view.setVisibility(0);
                        }
                    }
                    a.this.b.C();
                } else {
                    View view2 = a.this.q;
                    if (view2 != null) {
                        view2.setVisibility(4);
                    }
                    a.this.G();
                    if (a.this.h0 && a.this.b.k().d() == 0) {
                        a.this.O();
                    }
                    a.this.b.c(false);
                }
            }
            a.this.h0 = false;
        }
    }

    public a(Context context, int i2, com.baidu.navisdk.ugc.eventdetails.model.a aVar, com.baidu.navisdk.ugc.eventdetails.control.a aVar2) {
        boolean z2;
        this.e0 = 1;
        this.l0 = false;
        this.q0 = true;
        this.b = aVar2;
        this.e0 = i2;
        this.r0 = aVar;
        if (aVar.e() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.q0 = z2;
        this.m0 = new com.baidu.navisdk.ugc.eventdetails.control.e();
        this.l0 = aVar.f == 7;
        if (!this.q0) {
            this.l0 = false;
        }
        b(context);
        e(false);
    }

    private void J() {
        if (this.k0 == null) {
            com.baidu.navisdk.ugc.pictures.previews.c cVar = new com.baidu.navisdk.ugc.pictures.previews.c(this);
            this.k0 = cVar;
            cVar.a(this);
        }
        this.k0.a(this.b.d(), this.b.k().u(), 2);
    }

    private void K() {
        com.baidu.navisdk.ugc.video.c cVar = this.i0;
        if (cVar != null) {
            cVar.a(this.b.d());
        }
    }

    private void L() {
        if (!TextUtils.isEmpty(this.b.k().o()) && this.V != null && this.R != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "recoverInputs: txt --> " + this.b.k().o());
            }
            this.R.setText(this.b.k().o());
            this.V.setText(this.b.k().o());
            this.R.setTextColor(this.V.getCurrentTextColor());
        }
        if (!TextUtils.isEmpty(this.b.k().u())) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcModule_EventDetails", "recoverInputs: pic --> " + this.b.k().u());
            }
            a((Bitmap) null, this.b.k().u());
        } else if (this.b.k().U()) {
            E();
            e.b bVar = this.b.k().P;
            b((Bitmap) null, bVar.b);
            com.baidu.navisdk.ugc.video.c cVar = this.i0;
            cVar.f8345a = bVar.f8076a;
            cVar.b = bVar.b;
            cVar.c = bVar.c;
        }
        S();
    }

    private void M() {
        try {
            ((FragmentActivity) com.baidu.navisdk.framework.a.c().b()).getSupportFragmentManager().beginTransaction();
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.IMLog;
            if (gVar.c()) {
                gVar.c(e2.getMessage());
            }
        }
    }

    private void N() {
        ImageView imageView = this.Z;
        if (imageView != null && this.Y != null && this.a0 != null) {
            int i2 = 0;
            this.c0 = false;
            imageView.setVisibility(8);
            this.a0.setVisibility(8);
            ImageView imageView2 = this.Y;
            if (!com.baidu.navisdk.j.d()) {
                i2 = 8;
            }
            imageView2.setVisibility(i2);
            this.b.k().i(null);
            this.Z.setImageDrawable(null);
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        w();
        if (this.P != null && this.Q != null && this.R != null && this.U != null && this.V != null) {
            e(true);
            if (this.T == null) {
                com.baidu.navisdk.ugc.dialog.b bVar = new com.baidu.navisdk.ugc.dialog.b();
                this.T = bVar;
                bVar.c(this.P);
                this.T.b(this.Q);
                this.T.a(this.R);
                this.T.a(this.U);
                this.T.a(this.V);
                this.T.a(this.e0);
                this.T.b(2);
                this.T.a(new o());
                this.T.h.b = this.b.k().P();
                this.T.h.e = new p();
                this.T.h.i = new q();
                this.T.h.g = this.b.m();
                if (com.baidu.navisdk.module.ugc.a.b(this.r0.c())) {
                    com.baidu.navisdk.ugc.quickinput.a aVar = this.T.h;
                    aVar.c = false;
                    aVar.d = false;
                } else {
                    com.baidu.navisdk.ugc.quickinput.a aVar2 = this.T.h;
                    aVar2.c = true;
                    aVar2.d = true;
                }
            }
            if (this.b.k().N != null) {
                this.T.h.j = this.b.k().N.b;
            } else {
                this.T.h.j = -1;
            }
            if (this.b.k().M != null) {
                this.T.h.k = this.b.k().M.b;
            } else {
                this.T.h.k = -1;
            }
            com.baidu.navisdk.ugc.dialog.g.e().a(this.b.d(), this.T);
        }
    }

    private void P() {
        if (this.F != null && this.b.k().S == 1) {
            this.F.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_comment, Integer.valueOf(this.b.k().d())));
        }
    }

    private void Q() {
        if (!com.baidu.navisdk.j.d()) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "chatId from mapJson or engine = " + this.r0.x + " chatId from server = " + this.b.k().X);
        }
        if (this.e0 == 2) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "chat room not show in landscape");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.module.cloudconfig.f.c().J.a()) {
            long j2 = this.b.k().X;
            if (j2 == 0 && !TextUtils.isEmpty(this.r0.x) && !this.r0.x.equals("0")) {
                try {
                    j2 = Long.parseLong(this.r0.x);
                } catch (Exception unused) {
                }
            }
            if (j2 != 0) {
                b(j2, this.b.k().Y);
            }
        } else if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "chat cloud disable");
        }
        if (this.x != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            if (this.x.getVisibility() == 0) {
                layoutParams.removeRule(12);
            } else if (this.x.getVisibility() == 8) {
                layoutParams.addRule(12);
            }
            this.o.setLayoutParams(layoutParams);
        }
    }

    private void R() {
        boolean T = this.b.k().T();
        this.q0 = T;
        if (!T) {
            this.l0 = false;
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setScrollSupport(T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (this.d0 != null) {
            if (!this.b0 && !this.c0 && !this.b.k().S()) {
                this.d0.setEnabled(false);
                this.d0.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_ugc_txt_normal));
            } else {
                this.d0.setEnabled(true);
                this.d0.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_link_a));
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
        com.baidu.navisdk.ugc.video.c cVar = this.i0;
        if (cVar != null && cVar.a(i2)) {
            this.i0.b(i3, intent);
            return;
        }
        if (com.baidu.navisdk.ugc.utils.a.a(i2)) {
            com.baidu.navisdk.ugc.utils.a.a(i2, i3, intent, this);
            return;
        }
        com.baidu.navisdk.ugc.video.b bVar = this.j0;
        if (bVar != null && bVar.a(i2)) {
            this.j0.a(this.b.d(), i2, i3, intent);
        } else if (com.baidu.navisdk.ugc.dialog.g.e().a(i2)) {
            com.baidu.navisdk.ugc.dialog.g.e().a(i2, i3, intent);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public boolean onBackPressed() {
        if (p()) {
            return true;
        }
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
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
            I();
            return;
        }
        if (id != R.id.layout_pgc_source && id != R.id.layout_ugc_source) {
            if (id == R.id.back_container) {
                com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
                if (aVar != null) {
                    aVar.y();
                }
                View view2 = this.c;
                if (view2 != null) {
                    view2.setVisibility(8);
                    return;
                }
                return;
            }
            if (id == R.id.ugc_sub_photo_show_iv) {
                ImageView imageView = this.a0;
                if (imageView != null && imageView.getVisibility() == 0) {
                    K();
                    return;
                } else {
                    J();
                    return;
                }
            }
            return;
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView != null && this.q0) {
            pullToRefreshRecyclerView.goToTop();
            G();
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onDestroy() {
        TextWatcher textWatcher;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "BNUgcEventDetailsSlidablyView onDestroy");
        }
        e(false);
        w();
        x();
        i(false);
        j(true);
        M();
        d(false);
        com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.m0;
        if (eVar != null) {
            eVar.a();
        }
        b(this.o, this.f8084o0);
        this.f8084o0 = null;
        b(this.f, this.p0);
        this.p0 = null;
        com.baidu.navisdk.ugc.video.b bVar = this.j0;
        if (bVar != null) {
            bVar.a();
            this.j0 = null;
        }
        com.baidu.navisdk.ugc.video.c cVar = this.i0;
        if (cVar != null) {
            cVar.a();
            this.i0 = null;
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setOnStatusChangeListener(null);
        }
        EditText editText = this.V;
        if (editText != null && (textWatcher = this.z0) != null) {
            editText.removeTextChangedListener(textWatcher);
        }
        if (this.r0.g == 1) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "BNUgcEventDetailsSlidablyView naving onDestroy focus resumeVoiceTTSOutput");
            }
            TTSPlayerControl.resumeVoiceTTSOutput();
            com.baidu.navisdk.ugc.utils.e.f8333a.a(com.baidu.navisdk.framework.a.c().a());
        }
        this.k = false;
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar2 = this.j;
        if (bVar2 != null) {
            bVar2.a((VideoWidget.a) null);
            this.j.a((b.f) null);
        }
        com.baidu.navisdk.ui.util.j.b(this.s);
        com.baidu.navisdk.ui.util.j.b(this.Z);
        this.p = null;
        if (!com.baidu.navisdk.ugc.utils.h.c.c()) {
            com.baidu.navisdk.framework.b.b(true);
        }
        com.baidu.navisdk.ugc.pictures.previews.c cVar2 = this.k0;
        if (cVar2 != null) {
            cVar2.c();
            this.k0 = null;
        }
        this.b = null;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onPause() {
        com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "onPause: --> ");
        w();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void onResume() {
        com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "onResume: --> ");
        if (this.r0.l() && this.f != null && this.p0 == null) {
            s sVar = new s();
            this.p0 = sVar;
            a(this.f, sVar);
        }
    }

    public boolean p() {
        return false;
    }

    public void t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A() {
        try {
            if (this.j == null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "initCommentsList: --> ");
                }
                this.i.setNeedStatusChangeAlways(true);
                this.i.setScrollSupport(this.q0);
                if (this.b.r()) {
                    this.d.setVisibility(0);
                    int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_details_title_height);
                    if (this.b.t()) {
                        dimensionPixelOffset += ScreenUtil.getInstance().getStatusBarHeight(this.b.d());
                    }
                    ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = dimensionPixelOffset;
                    }
                    this.d.setLayoutParams(layoutParams);
                    this.i.setTopMargin(dimensionPixelOffset + this.b.h());
                    this.i.setTitleView(this.d, (int) (ScreenUtil.getInstance().getHeightPixels() / 3.0d));
                    this.i.setTitleAnimEnabled(true);
                } else {
                    this.i.setTitleView(null, 0);
                    this.i.setTitleAnimEnabled(false);
                    this.i.setTopMargin(this.b.h());
                }
                this.i.setViewBg(this.l);
                this.i.setEnableBg(true);
                this.i.setBottomView(this.O, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_detail_post_comment_height), (int) (ScreenUtil.getInstance().getHeightPixels() / 3.0d));
                this.i.setEnableBottomAnim(true);
                this.i.setSwipeEnable(true);
                this.i.setLayoutManager(new DetailLinearLayoutManager(this.b.f()));
                this.i.setPagingableListener(new a0());
                BaseLoadMoreView baseLoadMoreView = new BaseLoadMoreView(this.b.f(), this.i.getRecyclerView());
                baseLoadMoreView.setLoadMorePadding(JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_ugc_detail_loading_footer_height));
                this.i.setLoadMoreFooter(baseLoadMoreView);
                this.i.getLoadMoreFooter().setOnDrawListener(new b0());
                com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = new com.baidu.navisdk.ugc.eventdetails.adapter.b(this.b.f(), this.b);
                this.j = bVar;
                bVar.a(new C0376a());
                this.j.a(this);
                this.j.b(false);
                if (this.p.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.p.getParent()).removeView(this.p);
                }
                this.j.a(this.p);
                this.i.setAdapter(this.j);
                this.i.setVisibility(0);
                l();
                D();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void B() {
        View view = this.g;
        if (view != null && this.r0.g != 3) {
            view.setOnClickListener(this);
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        View view3 = this.d;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        if (this.o != null && this.f8084o0 == null) {
            y yVar = new y();
            this.f8084o0 = yVar;
            a(this.o, yVar);
        }
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView == null || this.f8083a != 1) {
            return;
        }
        pullToRefreshRecyclerView.setOnStatusChangeListener(new z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "initOutlineData mPanelType: " + this.r0.k);
        }
        if (this.r0.d() == 1) {
            if (this.b.c(this.r0.j())) {
                return;
            }
            a(1, JarUtils.getResources().getString(R.string.nsdk_string_ugc_load_failed_try_again), false);
        } else {
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
            if (aVar == null || aVar.a()) {
                return;
            }
            this.b.o();
        }
    }

    private void D() {
        View view = this.O;
        if (view != null) {
            this.P = view.findViewById(R.id.ugc_detail_post_comment_edit_layout);
            this.Q = this.O.findViewById(R.id.ugc_post_comment_input_tv_view);
            this.R = (TextView) this.O.findViewById(R.id.ugc_post_comment_input_tv);
            this.W = (ImageView) this.O.findViewById(R.id.ugc_post_comment_delete_tv);
            this.U = this.O.findViewById(R.id.ugc_post_comment_input_et_view);
            this.V = (EditText) this.O.findViewById(R.id.ugc_post_comment_input_et);
            this.S = (ImageView) this.O.findViewById(R.id.ugc_post_comment_delete_et);
            this.X = this.O.findViewById(R.id.ugc_sub_photo_show_layout);
            ImageView imageView = (ImageView) this.O.findViewById(R.id.ugc_sub_info_fill_photo_iv);
            this.Y = imageView;
            imageView.setVisibility(com.baidu.navisdk.j.d() ? 0 : 8);
            this.Z = (ImageView) this.O.findViewById(R.id.ugc_sub_photo_show_iv);
            this.d0 = (TextView) this.O.findViewById(R.id.ugc_post_comment_submit_tv);
            this.a0 = (ImageView) this.O.findViewById(R.id.ugc_sub_photo_show_play_video_iv);
            this.Q.setVisibility(0);
            this.U.setVisibility(8);
            S();
            TextView textView = this.R;
            if (textView != null) {
                textView.setOnClickListener(new g());
            }
            EditText editText = this.V;
            if (editText != null) {
                editText.setOnFocusChangeListener(this.y0);
                this.V.addTextChangedListener(this.z0);
            }
            if (r()) {
                ImageView imageView2 = this.Z;
                if (imageView2 != null) {
                    imageView2.setOnClickListener(this);
                }
                ImageView imageView3 = this.Y;
                if (imageView3 != null) {
                    imageView3.setOnClickListener(new h());
                }
            } else {
                View view2 = this.X;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            i iVar = new i();
            ImageView imageView4 = this.W;
            if (imageView4 != null) {
                imageView4.setOnClickListener(iVar);
            }
            ImageView imageView5 = this.S;
            if (imageView5 != null) {
                imageView5.setOnClickListener(iVar);
            }
            TextView textView2 = this.d0;
            if (textView2 != null) {
                textView2.setOnClickListener(new j());
            }
            View view3 = this.O;
            if (view3 != null) {
                view3.setOnTouchListener(new l(this));
            }
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.i0 == null) {
            com.baidu.navisdk.ugc.video.c cVar = new com.baidu.navisdk.ugc.video.c(this.r0.g == 1);
            this.i0 = cVar;
            cVar.a((c.a) this);
            this.i0.a((com.baidu.navisdk.ugc.listener.c) this);
        }
    }

    private void F() {
        if (this.b.k() == null || this.b.k().t() == null) {
            return;
        }
        t();
        int d2 = this.b.k().t().d();
        if (d2 != 0) {
            if (d2 == 1) {
                this.b.k().e(1);
                this.b.k().c(this.b.k().I() + 1);
                f(true);
            } else {
                this.b.k().e(2);
                this.b.k().d(this.b.k().J() + 1);
                f(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        int i2 = this.r0.g;
        int i3 = i2 != 1 ? i2 == 2 ? 3 : i2 == 3 ? 4 : 1 : 2;
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.1", "" + i3, null, null);
        z();
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setSwipeEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView != null && this.q0) {
            this.h0 = pullToRefreshRecyclerView.goToTop();
        }
        if (this.h0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.6", this.b.m() + "", null, null);
        }
    }

    private void I() {
        if (o()) {
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
        if (aVar != null) {
            aVar.y();
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z2) {
        if (this.n0 == null || z2) {
            this.n0 = new m();
        }
    }

    private void u() {
        int absoluteHeight;
        View view = this.f;
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            if (ScreenUtil.getInstance().isNavibarShown()) {
                absoluteHeight = ScreenUtil.getInstance().getHeightPixels();
            } else {
                absoluteHeight = ScreenUtil.getInstance().getAbsoluteHeight();
            }
            layoutParams.height = (absoluteHeight - ScreenUtil.getInstance().getStatusBarHeight(this.b.d())) - ScreenUtil.getInstance().dip2px(5);
            this.f.setLayoutParams(layoutParams);
        }
        ViewGroup viewGroup = this.x;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.setBackgroundColor(Color.parseColor("#66000000"));
        }
    }

    private void v() {
        ImageView imageView;
        if (this.Y == null || (imageView = this.Z) == null || this.a0 == null) {
            return;
        }
        this.c0 = false;
        imageView.setVisibility(8);
        this.a0.setVisibility(8);
        this.Y.setVisibility(0);
        this.Z.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.baidu.navisdk.ugc.dialog.g.e().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.baidu.navisdk.ugc.dialog.g.e().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.V != null) {
            ((InputMethodManager) com.baidu.navisdk.framework.a.c().a().getSystemService("input_method")).hideSoftInputFromWindow(this.V.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar;
        if (this.k || (aVar = this.b) == null || aVar.b()) {
            return;
        }
        this.k = true;
        b(3);
        this.b.n();
    }

    public void g(boolean z2) {
        if (!com.baidu.navisdk.util.common.z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(this.b.f(), JarUtils.getResources().getString(R.string.ugc_network_unconnected));
            return;
        }
        int i2 = z2 ? 1 : 2;
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
        if (aVar == null || aVar.v()) {
            return;
        }
        if (this.b.k().M() == 0) {
            this.b.b(z2);
            this.b.a(i2);
            b(2);
        } else if (this.b.d() != null) {
            TipTool.onCreateToastDialog(this.b.d(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_evaluated));
        } else {
            TipTool.onCreateToastDialog(this.b.f(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_evaluated));
        }
    }

    public void i() {
        this.d = this.c.findViewById(R.id.title_container);
        this.e = this.c.findViewById(R.id.back_container);
        this.f = this.c.findViewById(R.id.detail_contents);
        View findViewById = this.c.findViewById(R.id.ugc_rc_details_bg);
        this.g = findViewById;
        if (this.r0.g == 4) {
            findViewById.setBackgroundColor(Color.parseColor("#66000000"));
        } else {
            findViewById.setBackgroundColor(JarUtils.getResources().getColor(android.R.color.transparent));
        }
        this.h = (ViewGroup) this.c.findViewById(R.id.contents_loading_state_container);
        InterceptTouchLinearLayout interceptTouchLinearLayout = (InterceptTouchLinearLayout) this.c.findViewById(R.id.outline_container_outer);
        this.o = interceptTouchLinearLayout;
        interceptTouchLinearLayout.setOnInterceptTouchListener(new k(this));
        this.x = (ViewGroup) this.c.findViewById(R.id.im_container);
        this.l = this.c.findViewById(R.id.ugc_comments_listview_bg);
        this.m = (ViewGroup) this.c.findViewById(R.id.ugc_comments_loading_footer_container);
        this.i = (PullToRefreshRecyclerView) this.c.findViewById(R.id.ugc_comments_listview);
        this.O = this.c.findViewById(R.id.post_comment_container);
    }

    public void j() {
        this.q = this.p.findViewById(R.id.v_pull_up);
        this.s = (ImageView) this.p.findViewById(R.id.ic_event_type);
        this.t = (TextView) this.p.findViewById(R.id.tv_event_type);
        this.n = this.p.findViewById(R.id.ugc_event_details_content_layout);
        this.u = (TextView) this.p.findViewById(R.id.tv_event_description);
        this.v = (TextView) this.p.findViewById(R.id.tv_event_address_and_distance);
        this.r = (TextView) this.p.findViewById(R.id.view_avoid_congestion);
        this.w = (TextView) this.p.findViewById(R.id.tv_event_time_stamp);
        this.K = this.p.findViewById(R.id.layout_ugc_source);
        this.L = (TextView) this.p.findViewById(R.id.tv_event_reporter_ugc_name);
        this.M = (ImageView) this.p.findViewById(R.id.iv_event_reporter_ugc_icon);
        this.N = (TextView) this.p.findViewById(R.id.tv_event_reporter_ugc_supplement);
        this.y = this.p.findViewById(R.id.view_useful);
        this.z = (TextView) this.p.findViewById(R.id.tv_useful);
        this.A = (ImageView) this.p.findViewById(R.id.iv_useful);
        this.B = this.p.findViewById(R.id.view_useless);
        this.C = (TextView) this.p.findViewById(R.id.tv_useless);
        this.D = (ImageView) this.p.findViewById(R.id.iv_useless);
        this.E = this.p.findViewById(R.id.view_detail_comment);
        this.F = (TextView) this.p.findViewById(R.id.tv_detail_comment);
        this.G = (ViewGroup) this.p.findViewById(R.id.nsdk_layout_ugc_useful_new);
        this.H = this.p.findViewById(R.id.btn_container_new);
        this.I = (TextView) this.p.findViewById(R.id.report_open);
        this.J = (TextView) this.p.findViewById(R.id.try_to_avoid);
    }

    @Override // com.baidu.navisdk.ugc.listener.a
    public void m() {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
        if (aVar != null) {
            aVar.D();
        }
    }

    public void n() {
        if (this.o == null) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "initOutlineView: --> outlineViewContainerOuter = null");
            return;
        }
        View inflate = JarUtils.inflate(this.b.f(), k(), null);
        this.p = inflate;
        if (inflate == null) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "initUgcPanelOutlineView: --> inflate fail");
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
            if (aVar != null) {
                aVar.y();
            }
            View view = this.c;
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
        if (this.o.getChildCount() == 0) {
            this.o.addView(this.p, new ViewGroup.LayoutParams(-1, -2));
            this.o.setVisibility(0);
        }
        View view2 = this.y;
        if (view2 != null) {
            view2.setOnTouchListener(new b());
        }
        View view3 = this.B;
        if (view3 != null) {
            view3.setOnTouchListener(new c());
        }
        TextView textView = this.J;
        if (textView != null) {
            textView.setOnClickListener(new d());
        }
        if (this.E != null) {
            this.F.setText("评论(0)");
            this.E.setOnClickListener(new e());
        }
        View view4 = this.K;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
        View view5 = this.p;
        if (view5 != null) {
            view5.setOnClickListener(new f());
        }
    }

    public boolean q() {
        return this.u0;
    }

    public boolean r() {
        return com.baidu.navisdk.j.d();
    }

    public void s() {
        if (this.s != null) {
            if (!TextUtils.isEmpty(this.b.k().N())) {
                try {
                    this.s.setVisibility(0);
                    com.baidu.navisdk.ugc.utils.d.a(this.b.k().P(), this.s, this.b.k().N());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                this.s.setVisibility(8);
            }
        }
        TextView textView = this.t;
        if (textView != null) {
            textView.setText(this.b.k().O());
        }
        if (this.u != null) {
            String f2 = this.b.k().f() == null ? this.b.k().f() : this.b.k().f().trim();
            if (TextUtils.isEmpty(f2)) {
                this.u.setVisibility(8);
                View view = this.n;
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                this.u.setText(f2);
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
        f(true);
        f(false);
        P();
        F();
    }

    private void b(Context context) {
        if (context == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_EventDetails", "BNUgcEventDetailsSlidablyView initViews context == null");
            }
            this.c = null;
            return;
        }
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_ugc_details_view, null);
        this.c = inflate;
        if (inflate != null) {
            i();
            i(true);
            this.d.setVisibility(8);
            B();
            if (!this.r0.l()) {
                b(1);
                C();
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
        v();
        com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
        if (aVar != null) {
            aVar.k().a(null, null, 0);
        }
        S();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public View e() {
        return this.c;
    }

    public void f(boolean z2) {
        Drawable f2;
        Drawable f3;
        int M = this.b.k().M();
        int color = JarUtils.getResources().getColor(R.color.nsdk_ugc_txt_unfocused);
        int color2 = JarUtils.getResources().getColor(R.color.nsdk_ugc_txt_normal);
        if (z2) {
            boolean z3 = M == 1;
            TextView textView = this.z;
            if (textView != null) {
                textView.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_useful, Integer.valueOf(this.b.k().I())));
                TextView textView2 = this.z;
                if (z3) {
                    color = color2;
                }
                textView2.setTextColor(color);
            }
            ImageView imageView = this.A;
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
        TextView textView3 = this.C;
        if (textView3 != null) {
            textView3.setText(JarUtils.getResources().getString(R.string.nsdk_string_ugc_useless, Integer.valueOf(this.b.k().J())));
            TextView textView4 = this.C;
            if (z4) {
                color = color2;
            }
            textView4.setTextColor(color);
        }
        ImageView imageView2 = this.D;
        if (imageView2 != null) {
            if (z4) {
                f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useless_selected);
            } else {
                f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_useless_normal);
            }
            imageView2.setImageDrawable(f2);
        }
    }

    /* loaded from: classes8.dex */
    public class m implements com.baidu.navisdk.ugc.listener.b {
        public m() {
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(c0.a aVar) {
            a.this.b.k().i(aVar.f9222a);
            a.this.a(aVar.b, aVar.f9222a);
            a.this.x();
            a.this.S();
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(String str) {
            a.this.x();
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void c(boolean z2) {
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.j;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public void e(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "setIsUserOperating: " + z2);
        }
        int i2 = this.r0.g;
        if (i2 == 1 || i2 == 3) {
            com.baidu.navisdk.ugc.d.a(z2);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void h() {
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.baidu.navisdk.ugc.video.c.a
    public void c() {
        x();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void a(int i2, String str, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "loadingEnd: --> type: " + i2 + ", suc: " + z2 + ", err: " + str);
        }
        if (i2 == 1) {
            if (!z2) {
                this.l0 = false;
                com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.m0;
                if (eVar != null) {
                    eVar.a(2, z2, this.h, this.w0);
                    return;
                }
                return;
            }
            R();
            Q();
            com.baidu.navisdk.ugc.eventdetails.control.e eVar2 = this.m0;
            if (eVar2 != null) {
                eVar2.a(2, z2, this.h, null);
            }
            com.baidu.navisdk.utils.a.a(this.h, 300, new v());
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                com.baidu.navisdk.ugc.eventdetails.control.e eVar3 = this.m0;
                if (eVar3 != null) {
                    eVar3.a(1, z2, null, null);
                }
                TipTool.onCreateToastDialog(this.b.f(), str);
                return;
            }
            if (z2) {
                return;
            }
            this.j.notifyDataSetChanged();
            TipTool.onCreateToastDialog(this.b.f(), str);
            return;
        }
        if (z2) {
            return;
        }
        if (this.b.k().g() == 0) {
            this.k = false;
            com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.j;
            if (bVar != null) {
                bVar.a(b.i.LOADED_FAILED);
                this.j.notifyDataSetChanged();
            }
            com.baidu.navisdk.ugc.eventdetails.control.e eVar4 = this.m0;
            if (eVar4 != null) {
                eVar4.a(2, z2, null, this.f8085x0);
                return;
            }
            return;
        }
        TipTool.onCreateToastDialog(this.b.f(), str);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.onFinishLoading(false, false);
            this.i.setScrollSupport(false);
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.v0, false);
        com.baidu.navisdk.util.worker.c.a().a(this.v0, new com.baidu.navisdk.util.worker.e(2, 0), 500L);
    }

    public void d(boolean z2) {
        this.u0 = z2;
    }

    public void b(int i2) {
        com.baidu.navisdk.ugc.eventdetails.control.a aVar;
        com.baidu.navisdk.ugc.eventdetails.control.a aVar2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "loadingStart: type --> " + i2);
        }
        if (i2 == 1) {
            ViewGroup viewGroup = this.h;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.m0;
            if (eVar == null || (aVar = this.b) == null) {
                return;
            }
            eVar.a(aVar.d(), 2, this.h);
            return;
        }
        if (i2 != 3) {
            com.baidu.navisdk.ugc.eventdetails.control.e eVar2 = this.m0;
            if (eVar2 == null || (aVar2 = this.b) == null) {
                return;
            }
            eVar2.a(aVar2.d(), 1, null);
            return;
        }
        com.baidu.navisdk.ugc.eventdetails.adapter.b bVar = this.j;
        if (bVar != null) {
            bVar.a(b.i.LOADING);
            this.j.notifyDataSetChanged();
        }
    }

    private void i(boolean z2) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView = this.i;
        if (pullToRefreshRecyclerView != null) {
            pullToRefreshRecyclerView.setNotInterruptBlankTouchEvent(z2);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public int g() {
        View view = this.p;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        return measuredHeight == 0 ? JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_161dp) : measuredHeight;
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void f() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onFixedPanelDataSetChanged: --> start: scrollViewInited = " + this.f0);
        }
        R();
        if (!this.f0) {
            n();
            s();
        }
        gVar.e("UgcModule_EventDetails", "onFixedPanelDataSetChanged: --> end");
    }

    private void j(boolean z2) {
        com.baidu.navisdk.framework.interfaces.f b2 = com.baidu.navisdk.framework.interfaces.c.p().b();
        if (b2 != null) {
            b2.n(z2);
        }
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
            this.b.k().e(1);
            this.b.k().c(this.b.k().I() + 1);
            this.b.k().t().a(1);
        } else {
            this.b.k().e(2);
            this.b.k().d(this.b.k().J() + 1);
            this.b.k().t().a(2);
        }
        f(z2);
        if (z2) {
            com.baidu.navisdk.utils.a.a(this.y, 3.0f, 500);
        } else {
            com.baidu.navisdk.utils.a.a(this.B, 3.0f, 500);
        }
    }

    private void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view == null || onGlobalLayoutListener == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private void b(Bitmap bitmap, String str) {
        ImageView imageView;
        if (this.a0 == null || (imageView = this.Z) == null || this.Y == null) {
            return;
        }
        this.c0 = true;
        imageView.setVisibility(0);
        this.a0.setVisibility(0);
        this.Y.setVisibility(8);
        if (bitmap != null) {
            this.Z.setImageBitmap(bitmap);
        } else {
            Glide.with(this.b.f()).load(str).into(this.Z);
        }
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void a() {
        if (this.j == null || this.m == null) {
            return;
        }
        boolean p2 = this.b.p();
        int g2 = this.b.k().g();
        P();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onCommentsDataSetChanged: --> moreCommentsPending: " + p2 + ", dataCount: " + g2);
        }
        if (g2 == 0) {
            this.j.a(b.i.LOADED_NO_DATA);
            this.j.notifyDataSetChanged();
            return;
        }
        A();
        this.j.a(b.i.LOADED_HAS_DATA);
        this.j.a(this.b.k().c(), this.b.k().F(), this.b.k().m());
        if (!p2) {
            this.j.b(true);
            this.j.notifyDataSetChanged();
            this.m.setVisibility(8);
            this.i.onFinishLoading(false, false);
            return;
        }
        this.j.notifyDataSetChanged();
        this.i.onFinishLoading(true, false);
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public void b() {
        this.b.k().g(null);
        this.b.k().a(-1, (String) null);
        this.b.k().b(-1, null);
        w();
        EditText editText = this.V;
        if (editText != null) {
            editText.setText("");
        }
        TextView textView = this.R;
        if (textView != null) {
            textView.setText("");
            this.R.setHint(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_ugc_detail_post_comment_prompt));
            this.R.setHintTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_ugc_txt_normal));
        }
        N();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public void b(Context context, int i2) {
        this.f0 = false;
        this.g0 = false;
        this.h0 = false;
        this.k = false;
        this.b0 = false;
        this.c0 = false;
        this.o = null;
        this.j = null;
        this.T = null;
        this.e0 = i2;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, String str) {
        ImageView imageView = this.Z;
        if (imageView == null || this.Y == null || this.a0 == null) {
            return;
        }
        this.c0 = true;
        imageView.setVisibility(0);
        this.a0.setVisibility(8);
        this.Y.setVisibility(8);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "showPhotoBmpOrFile --> " + bitmap + ", localFilePath: " + str + ", photoShowIv:" + this.Z);
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            this.Z.setImageBitmap(bitmap);
        } else if (!TextUtils.isEmpty(str)) {
            Glide.with(this.b.f()).load(str).into(this.Z);
        } else {
            N();
        }
    }

    private void b(long j2, String str) {
        j(false);
        a(j2, str);
        d(true);
        c0 c0Var = this.t0;
        if (c0Var != null) {
            c0Var.a();
        }
        e(true);
        com.baidu.navisdk.util.statistic.userop.b.r().d("e.1.b", this.r0.c() + "");
        u();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.c
    public boolean a(int i2) {
        com.baidu.navisdk.ugc.video.b bVar;
        com.baidu.navisdk.ugc.video.c cVar = this.i0;
        return (cVar != null && cVar.a(i2)) || com.baidu.navisdk.ugc.utils.a.a(i2) || ((bVar = this.j0) != null && bVar.a(i2)) || com.baidu.navisdk.ugc.dialog.g.e().a(i2) || i2 == 100 || i2 == 101;
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
        if (this.b == null || this.i0 == null) {
            return;
        }
        x();
        b(bitmap, (String) null);
        com.baidu.navisdk.ugc.eventdetails.model.c k2 = this.b.k();
        com.baidu.navisdk.ugc.video.c cVar = this.i0;
        k2.a(cVar.f8345a, cVar.b, cVar.c);
        S();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.view.VideoWidget.a
    public void a(String str, int i2) {
        if (this.j0 == null) {
            com.baidu.navisdk.ugc.video.b bVar = new com.baidu.navisdk.ugc.video.b(this.b.f(), this.r0.g == 1);
            this.j0 = bVar;
            bVar.a(this);
        }
        this.j0.a(this.b.d(), str);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.5", this.b.m() + "", i2 + "", null);
    }

    @Override // com.baidu.navisdk.ugc.listener.c
    public void a(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onUserOperate: " + z2);
        }
        e(z2);
    }

    @Override // com.baidu.navisdk.ugc.pictures.previews.c.e
    public void a(String str) {
        N();
    }

    @Override // com.baidu.navisdk.ugc.eventdetails.interfaces.b
    public View a(Context context, int i2) {
        com.baidu.navisdk.ugc.eventdetails.control.e eVar = this.m0;
        if (eVar != null) {
            return eVar.a(context, i2);
        }
        return null;
    }

    private void a(Context context) {
        if (q()) {
            this.c = null;
            d(false);
        } else {
            b(context);
        }
    }

    public void a(d0 d0Var) {
        this.s0 = d0Var;
    }

    public void a(c0 c0Var) {
        this.t0 = c0Var;
    }

    private void a(long j2, String str) {
        FragmentActivity fragmentActivity;
        try {
            com.baidu.navisdk.ugc.eventdetails.control.a aVar = this.b;
            if (aVar == null || (fragmentActivity = (FragmentActivity) aVar.d()) == null || fragmentActivity.isFinishing()) {
                return;
            }
        } catch (Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.IMLog;
            if (gVar.c()) {
                gVar.c(th.getMessage());
            }
        }
    }
}
