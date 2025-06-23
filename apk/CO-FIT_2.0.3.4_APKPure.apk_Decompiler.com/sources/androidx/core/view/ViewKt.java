package androidx.core.view;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.IXxxXO;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.ooOOo0oXI;

@XX({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,414:1\n37#1:415\n53#1:416\n326#1,4:420\n43#2,3:417\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n68#1:415\n68#1:416\n310#1:420,4\n232#1:417,3\n*E\n"})
public final class ViewKt {
    public static final void doOnAttach(@OOXIXo View view, @OOXIXo oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        if (view.isAttachedToWindow()) {
            oooxoxo.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(view, oooxoxo));
        }
    }

    public static final void doOnDetach(@OOXIXo View view, @OOXIXo oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        if (!view.isAttachedToWindow()) {
            oooxoxo.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(view, oooxoxo));
        }
    }

    public static final void doOnLayout(@OOXIXo View view, @OOXIXo oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(oooxoxo));
        } else {
            oooxoxo.invoke(view);
        }
    }

    public static final void doOnNextLayout(@OOXIXo View view, @OOXIXo oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        view.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(oooxoxo));
    }

    @OOXIXo
    public static final OneShotPreDrawListener doOnPreDraw(@OOXIXo View view, @OOXIXo oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        return OneShotPreDrawListener.add(view, new ViewKt$doOnPreDraw$1(oooxoxo, view));
    }

    @OOXIXo
    public static final Bitmap drawToBitmap(@OOXIXo View view, @OOXIXo Bitmap.Config config) {
        if (view.isLaidOut()) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-((float) view.getScrollX()), -((float) view.getScrollY()));
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    @OOXIXo
    public static final ooOOo0oXI<View> getAllViews(@OOXIXo View view) {
        return IXxxXO.II0xO0(new ViewKt$allViews$1(view, (I0Io<? super ViewKt$allViews$1>) null));
    }

    @OOXIXo
    public static final ooOOo0oXI<ViewParent> getAncestors(@OOXIXo View view) {
        return SequencesKt__SequencesKt.x0XOIxOo(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(@OOXIXo View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@OOXIXo View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(@OOXIXo View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@OOXIXo View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@OOXIXo View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(@OOXIXo View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@OOXIXo View view) {
        if (view.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(@OOXIXo View view) {
        if (view.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(@OOXIXo View view) {
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final Runnable postDelayed(@OOXIXo View view, long j, @OOXIXo oIX0oI<oXIO0o0XI> oix0oi) {
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(oix0oi);
        view.postDelayed(viewKt$postDelayed$runnable$1, j);
        return viewKt$postDelayed$runnable$1;
    }

    @OOXIXo
    public static final Runnable postOnAnimationDelayed(@OOXIXo View view, long j, @OOXIXo oIX0oI<oXIO0o0XI> oix0oi) {
        Xx000oIo xx000oIo = new Xx000oIo(oix0oi);
        view.postOnAnimationDelayed(xx000oIo, j);
        return xx000oIo;
    }

    /* access modifiers changed from: private */
    public static final void postOnAnimationDelayed$lambda$1(oIX0oI oix0oi) {
        oix0oi.invoke();
    }

    public static final void setGone(@OOXIXo View view, boolean z) {
        int i;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    public static final void setInvisible(@OOXIXo View view, boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    public static final void setPadding(@OOXIXo View view, @Px int i) {
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(@OOXIXo View view, boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    public static final void updateLayoutParams(@OOXIXo View view, @OOXIXo oOoXoXO<? super ViewGroup.LayoutParams, oXIO0o0XI> oooxoxo) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            oooxoxo.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @xxIXOIIO(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, oOoXoXO<? super T, oXIO0o0XI> oooxoxo) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
        oooxoxo.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@OOXIXo View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        view.setPadding(i, i2, i3, i4);
    }

    public static final void updatePaddingRelative(@OOXIXo View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i, i2, i3, i4);
    }
}
