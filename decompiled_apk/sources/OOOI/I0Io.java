package OOOI;

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

/* loaded from: classes12.dex */
public class I0Io extends PopupWindow {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final FrameLayout f1729I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final FrameLayout f1730II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f1731Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @oOoXoXO
    public Oox.oIX0oI<oXIO0o0XI> f1732X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public Oox.oIX0oI<oXIO0o0XI> f1733XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public Activity f1734oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f1735oxoX;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I0Io(@OOXIXo Activity mActivity) {
        super(mActivity);
        IIX0o.x0xO0oo(mActivity, "mActivity");
        this.f1734oIX0oI = mActivity;
        FrameLayout frameLayout = new FrameLayout(this.f1734oIX0oI);
        this.f1730II0xO0 = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(this.f1734oIX0oI);
        this.f1729I0Io = frameLayout2;
        this.f1735oxoX = true;
        this.f1731Oxx0IOOO = 80;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = this.f1731Oxx0IOOO;
        frameLayout.addView(frameLayout2, layoutParams);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: OOOI.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                I0Io.x0XOIxOo(I0Io.this, view);
            }
        });
        frameLayout2.setClickable(true);
        setContentView(frameLayout);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable(this.f1734oIX0oI.getResources(), (Bitmap) null));
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: OOOI.II0xO0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                I0Io.XO(I0Io.this);
            }
        });
    }

    public static final void XO(I0Io this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oOXoIIIo.oIX0oI.I0Io(this$0.f1734oIX0oI, 1.0f);
        Oox.oIX0oI<oXIO0o0XI> oix0oi = this$0.f1733XO;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    public static final void x0XOIxOo(I0Io this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.f1735oxoX) {
            this$0.dismiss();
        }
    }

    public final boolean II0XooXoX() {
        return this.f1735oxoX;
    }

    public final void IIXOooo() {
        oI0IIXIo(R.id.content);
    }

    public final void IXxxXO(@oOoXoXO Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        this.f1732X0o0xo = oix0oi;
    }

    @oOoXoXO
    public final Oox.oIX0oI<oXIO0o0XI> OOXIXo() {
        return this.f1732X0o0xo;
    }

    public final void Oo(@oOoXoXO Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        this.f1733XO = oix0oi;
    }

    public final void OxI(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        showAtLocation(anchor, 48, 0, anchor.getTop());
        oOXoIIIo.oIX0oI.I0Io(this.f1734oIX0oI, 0.6f);
        KeyboardUtils.hideSoftInput(anchor);
        Oox.oIX0oI<oXIO0o0XI> oix0oi = this.f1732X0o0xo;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    @OOXIXo
    public final Activity Oxx0IOOO() {
        return this.f1734oIX0oI;
    }

    public final void Oxx0xo(int i) {
        this.f1731Oxx0IOOO = i;
    }

    public void OxxIIOOXO(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        try {
            if (this.f1734oIX0oI.isFinishing()) {
                return;
            }
            showAtLocation(anchor, 80, 0, 0);
            oOXoIIIo.oIX0oI.I0Io(this.f1734oIX0oI, 0.6f);
            KeyboardUtils.hideSoftInput(anchor);
            Oox.oIX0oI<oXIO0o0XI> oix0oi = this.f1732X0o0xo;
            if (oix0oi != null) {
                oix0oi.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void o00(@IdRes int i) {
        View findViewById = this.f1734oIX0oI.findViewById(i);
        IIX0o.ooOOo0oXI(findViewById);
        OxI(findViewById);
    }

    public final void oI0IIXIo(@IdRes int i) {
        View findViewById = this.f1734oIX0oI.findViewById(i);
        IIX0o.ooOOo0oXI(findViewById);
        OxxIIOOXO(findViewById);
    }

    public final void oO(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "<set-?>");
        this.f1734oIX0oI = activity;
    }

    @OOXIXo
    public final FrameLayout oOoXoXO() {
        return this.f1730II0xO0;
    }

    public final int ooOOo0oXI() {
        return this.f1731Oxx0IOOO;
    }

    public final void x0xO0oo(boolean z) {
        this.f1735oxoX = z;
        setFocusable(z);
        setOutsideTouchable(z);
    }

    @oOoXoXO
    public final Oox.oIX0oI<oXIO0o0XI> xoIox() {
        return this.f1733XO;
    }

    public void xoXoI(@OOXIXo View anchor) {
        IIX0o.x0xO0oo(anchor, "anchor");
        try {
            if (this.f1734oIX0oI.isFinishing()) {
                return;
            }
            showAtLocation(anchor, 17, 0, ((-anchor.getHeight()) / 2) + (anchor.getHeight() / 8));
            oOXoIIIo.oIX0oI.I0Io(this.f1734oIX0oI, 0.6f);
            KeyboardUtils.hideSoftInput(anchor);
            Oox.oIX0oI<oXIO0o0XI> oix0oi = this.f1732X0o0xo;
            if (oix0oi != null) {
                oix0oi.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OOXIXo
    public final FrameLayout xxIXOIIO() {
        return this.f1729I0Io;
    }
}
