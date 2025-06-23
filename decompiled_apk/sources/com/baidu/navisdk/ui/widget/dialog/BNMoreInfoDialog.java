package com.baidu.navisdk.ui.widget.dialog;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.app.Dialog;
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
public final class BNMoreInfoDialog extends Dialog {

    @OOXIXo
    private View mCloseView;

    @OOXIXo
    private TextView mContent;

    @OOXIXo
    private View mLayout;

    @OOXIXo
    private final ScrollView mScrollView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BNMoreInfoDialog(@oOoXoXO Activity activity) {
        super(activity, R.style.BNDialog);
        WindowManager.LayoutParams attributes;
        WindowManager.LayoutParams attributes2;
        IIX0o.ooOOo0oXI(activity);
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_description_dialog, null);
        IIX0o.oO(inflate, "JarUtils.inflate(activit…description_dialog, null)");
        this.mLayout = inflate;
        View findViewById = inflate.findViewById(R.id.close_icon);
        IIX0o.oO(findViewById, "mLayout.findViewById(R.id.close_icon)");
        this.mCloseView = findViewById;
        View findViewById2 = this.mLayout.findViewById(R.id.description_detail_content);
        IIX0o.oO(findViewById2, "mLayout.findViewById(R.i…scription_detail_content)");
        this.mContent = (TextView) findViewById2;
        View findViewById3 = this.mLayout.findViewById(R.id.description_scrollview);
        IIX0o.oO(findViewById3, "mLayout.findViewById(R.id.description_scrollview)");
        ScrollView scrollView = (ScrollView) findViewById3;
        this.mScrollView = scrollView;
        setContentView(this.mLayout);
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
        final ViewTreeObserver viewTreeObserver = scrollView.getViewTreeObserver();
        viewTreeObserver.addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: com.baidu.navisdk.ui.widget.dialog.BNMoreInfoDialog.1
            @Override // android.view.ViewTreeObserver.OnDrawListener
            public void onDraw() {
                int measuredHeight = BNMoreInfoDialog.this.getMContent().getMeasuredHeight();
                ViewGroup.LayoutParams layoutParams = BNMoreInfoDialog.this.getMScrollView().getLayoutParams();
                int dip2px = ScreenUtil.getInstance().dip2px(290);
                if (measuredHeight < dip2px) {
                    layoutParams.height = measuredHeight;
                } else {
                    layoutParams.height = dip2px;
                }
                BNMoreInfoDialog.this.getMScrollView().setLayoutParams(layoutParams);
                ViewTreeObserver mObserver = viewTreeObserver;
                IIX0o.oO(mObserver, "mObserver");
                if (mObserver.isAlive()) {
                    viewTreeObserver.removeOnDrawListener(this);
                }
            }
        });
        this.mCloseView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.dialog.BNMoreInfoDialog.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BNMoreInfoDialog.this.hide();
            }
        });
    }

    @OOXIXo
    public final View getMCloseView() {
        return this.mCloseView;
    }

    @OOXIXo
    public final TextView getMContent() {
        return this.mContent;
    }

    @OOXIXo
    public final View getMLayout() {
        return this.mLayout;
    }

    @OOXIXo
    public final ScrollView getMScrollView() {
        return this.mScrollView;
    }

    public final void setCloseClickEvent(@OOXIXo View.OnClickListener mListener) {
        IIX0o.x0xO0oo(mListener, "mListener");
        this.mCloseView.setOnClickListener(mListener);
    }

    public final void setContent(@OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        this.mContent.setText(text);
    }

    public final void setMCloseView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.mCloseView = view;
    }

    public final void setMContent(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.mContent = textView;
    }

    public final void setMLayout(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.mLayout = view;
    }
}
