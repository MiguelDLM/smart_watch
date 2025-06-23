package com.baidu.navisdk.ugc.dialog;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class c extends f {

    @OOXIXo
    private View c;

    @OOXIXo
    private View d;

    @OOXIXo
    private TextView e;

    @OOXIXo
    private final ScrollView f;

    @OOXIXo
    private final Context g;

    /* loaded from: classes8.dex */
    public static final class a implements ViewTreeObserver.OnDrawListener {
        final /* synthetic */ ViewTreeObserver b;

        public a(ViewTreeObserver viewTreeObserver) {
            this.b = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            int measuredHeight = c.this.a().getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = c.this.b().getLayoutParams();
            int dip2px = ScreenUtil.getInstance().dip2px(290);
            if (measuredHeight < dip2px) {
                layoutParams.height = measuredHeight;
            } else {
                layoutParams.height = dip2px;
            }
            c.this.b().setLayoutParams(layoutParams);
            ViewTreeObserver mObserver = this.b;
            IIX0o.oO(mObserver, "mObserver");
            if (mObserver.isAlive()) {
                this.b.removeOnDrawListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@OOXIXo Context mContext) {
        super(mContext, R.style.BNDialog);
        WindowManager.LayoutParams attributes;
        WindowManager.LayoutParams attributes2;
        IIX0o.x0xO0oo(mContext, "mContext");
        this.g = mContext;
        View inflate = JarUtils.inflate(mContext, R.layout.nsdk_layout_description_dialog, null);
        IIX0o.oO(inflate, "JarUtils.inflate(mContex…description_dialog, null)");
        this.c = inflate;
        View findViewById = inflate.findViewById(R.id.close_icon);
        IIX0o.oO(findViewById, "mLayout.findViewById(R.id.close_icon)");
        this.d = findViewById;
        View findViewById2 = this.c.findViewById(R.id.description_detail_content);
        IIX0o.oO(findViewById2, "mLayout.findViewById(R.i…scription_detail_content)");
        this.e = (TextView) findViewById2;
        View findViewById3 = this.c.findViewById(R.id.description_scrollview);
        IIX0o.oO(findViewById3, "mLayout.findViewById(R.id.description_scrollview)");
        ScrollView scrollView = (ScrollView) findViewById3;
        this.f = scrollView;
        setContentView(this.c);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null && (attributes2 = window2.getAttributes()) != null) {
            attributes2.width = -1;
        }
        Window window3 = getWindow();
        if (window3 != null && (attributes = window3.getAttributes()) != null) {
            attributes.windowAnimations = R.anim.nsdk_anim_dialog_slide_in_from_bottom;
        }
        ViewTreeObserver viewTreeObserver = scrollView.getViewTreeObserver();
        viewTreeObserver.addOnDrawListener(new a(viewTreeObserver));
    }

    @OOXIXo
    public final TextView a() {
        return this.e;
    }

    @OOXIXo
    public final ScrollView b() {
        return this.f;
    }

    public final void a(@OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        this.e.setText(text);
    }

    public final void a(@OOXIXo View.OnClickListener mListener) {
        IIX0o.x0xO0oo(mListener, "mListener");
        this.d.setOnClickListener(mListener);
    }
}
