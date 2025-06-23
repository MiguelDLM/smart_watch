package com.baidu.mapclient.liteapp.pop.base;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.IdRes;
import com.blankj.utilcode.util.KeyboardUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public class BasePopup extends PopupWindow {

    @OOXIXo
    private Activity mActivity;
    private boolean mCancelable;

    @OOXIXo
    private final FrameLayout mLayout;

    @oOoXoXO
    private Oox.oIX0oI<oXIO0o0XI> mOnDismiss;

    @oOoXoXO
    private Oox.oIX0oI<oXIO0o0XI> mOnShow;

    @OOXIXo
    private final FrameLayout mRoot;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePopup(@OOXIXo Activity mActivity) {
        super(mActivity);
        IIX0o.x0xO0oo(mActivity, "mActivity");
        this.mActivity = mActivity;
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        this.mRoot = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(this.mActivity);
        this.mLayout = frameLayout2;
        this.mCancelable = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        frameLayout.addView(frameLayout2, layoutParams);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.pop.base.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BasePopup.lambda$4$lambda$3(BasePopup.this, view);
            }
        });
        frameLayout2.setClickable(true);
        setContentView(frameLayout);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable(this.mActivity.getResources(), (Bitmap) null));
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.mapclient.liteapp.pop.base.II0xO0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                BasePopup._init_$lambda$5(BasePopup.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(BasePopup this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oOXoIIIo.oIX0oI.I0Io(this$0.mActivity, 1.0f);
        Oox.oIX0oI<oXIO0o0XI> oix0oi = this$0.mOnDismiss;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$4$lambda$3(BasePopup this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.mCancelable) {
            this$0.dismiss();
        }
    }

    @OOXIXo
    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final boolean getMCancelable() {
        return this.mCancelable;
    }

    @OOXIXo
    public final FrameLayout getMLayout() {
        return this.mLayout;
    }

    @oOoXoXO
    public final Oox.oIX0oI<oXIO0o0XI> getMOnDismiss() {
        return this.mOnDismiss;
    }

    @oOoXoXO
    public final Oox.oIX0oI<oXIO0o0XI> getMOnShow() {
        return this.mOnShow;
    }

    @OOXIXo
    public final FrameLayout getMRoot() {
        return this.mRoot;
    }

    public final void setMActivity(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "<set-?>");
        this.mActivity = activity;
    }

    public final void setMCancelable(boolean z) {
        this.mCancelable = z;
        setFocusable(z);
        setOutsideTouchable(z);
    }

    public final void setMOnDismiss(@oOoXoXO Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        this.mOnDismiss = oix0oi;
    }

    public final void setMOnShow(@oOoXoXO Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        this.mOnShow = oix0oi;
    }

    public void showAlignBottom(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        try {
            if (this.mActivity.isFinishing()) {
                return;
            }
            showAtLocation(anchor, 80, 0, 0);
            oOXoIIIo.oIX0oI.I0Io(this.mActivity, 0.6f);
            KeyboardUtils.hideSoftInput(anchor);
            Oox.oIX0oI<oXIO0o0XI> oix0oi = this.mOnShow;
            if (oix0oi != null) {
                oix0oi.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void showAlignBottomContentView() {
        showAlignBottom(R.id.content);
    }

    public void showAlignCenter(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        try {
            if (this.mActivity.isFinishing()) {
                return;
            }
            showAtLocation(anchor, 17, 0, ((-anchor.getHeight()) / 2) + (anchor.getHeight() / 8));
            oOXoIIIo.oIX0oI.I0Io(this.mActivity, 0.6f);
            KeyboardUtils.hideSoftInput(anchor);
            Oox.oIX0oI<oXIO0o0XI> oix0oi = this.mOnShow;
            if (oix0oi != null) {
                oix0oi.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void showAlignTop(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        showAtLocation(anchor, 48, 0, anchor.getTop());
        oOXoIIIo.oIX0oI.I0Io(this.mActivity, 0.6f);
        KeyboardUtils.hideSoftInput(anchor);
        Oox.oIX0oI<oXIO0o0XI> oix0oi = this.mOnShow;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    public final void showAlignTop(@IdRes int i) {
        View findViewById = this.mActivity.findViewById(i);
        IIX0o.ooOOo0oXI(findViewById);
        showAlignTop(findViewById);
    }

    public final void showAlignBottom(@IdRes int i) {
        View findViewById = this.mActivity.findViewById(i);
        IIX0o.ooOOo0oXI(findViewById);
        showAlignBottom(findViewById);
    }
}
