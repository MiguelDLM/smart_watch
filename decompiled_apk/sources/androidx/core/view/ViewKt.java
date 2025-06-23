package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import kotlin.sequences.SequencesKt__SequencesKt;

@kotlin.jvm.internal.XX({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,414:1\n37#1:415\n53#1:416\n326#1,4:420\n43#2,3:417\n*S KotlinDebug\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt\n*L\n68#1:415\n68#1:416\n310#1:420,4\n232#1:417,3\n*E\n"})
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnAttach(@OXOo.OOXIXo final View view, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, kotlin.oXIO0o0XI> oooxoxo) {
        if (view.isAttachedToWindow()) {
            oooxoxo.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@OXOo.OOXIXo View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    oooxoxo.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@OXOo.OOXIXo View view2) {
                }
            });
        }
    }

    public static final void doOnDetach(@OXOo.OOXIXo final View view, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, kotlin.oXIO0o0XI> oooxoxo) {
        if (!view.isAttachedToWindow()) {
            oooxoxo.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@OXOo.OOXIXo View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@OXOo.OOXIXo View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    oooxoxo.invoke(view2);
                }
            });
        }
    }

    public static final void doOnLayout(@OXOo.OOXIXo View view, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, kotlin.oXIO0o0XI> oooxoxo) {
        if (view.isLaidOut() && !view.isLayoutRequested()) {
            oooxoxo.invoke(view);
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@OXOo.OOXIXo View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view2.removeOnLayoutChangeListener(this);
                    Oox.oOoXoXO.this.invoke(view2);
                }
            });
        }
    }

    public static final void doOnNextLayout(@OXOo.OOXIXo View view, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, kotlin.oXIO0o0XI> oooxoxo) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@OXOo.OOXIXo View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view2.removeOnLayoutChangeListener(this);
                oooxoxo.invoke(view2);
            }
        });
    }

    @OXOo.OOXIXo
    public static final OneShotPreDrawListener doOnPreDraw(@OXOo.OOXIXo final View view, @OXOo.OOXIXo final Oox.oOoXoXO<? super View, kotlin.oXIO0o0XI> oooxoxo) {
        return OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                oooxoxo.invoke(view);
            }
        });
    }

    @OXOo.OOXIXo
    public static final Bitmap drawToBitmap(@OXOo.OOXIXo View view, @OXOo.OOXIXo Bitmap.Config config) {
        if (view.isLaidOut()) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-view.getScrollX(), -view.getScrollY());
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

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<View> getAllViews(@OXOo.OOXIXo View view) {
        return kotlin.sequences.IXxxXO.II0xO0(new ViewKt$allViews$1(view, null));
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<ViewParent> getAncestors(@OXOo.OOXIXo View view) {
        return SequencesKt__SequencesKt.x0XOIxOo(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(@OXOo.OOXIXo View view) {
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

    public static final int getMarginEnd(@OXOo.OOXIXo View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(@OXOo.OOXIXo View view) {
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

    public static final int getMarginRight(@OXOo.OOXIXo View view) {
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

    public static final int getMarginStart(@OXOo.OOXIXo View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(@OXOo.OOXIXo View view) {
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

    public static final boolean isGone(@OXOo.OOXIXo View view) {
        if (view.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(@OXOo.OOXIXo View view) {
        if (view.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(@OXOo.OOXIXo View view) {
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final Runnable postDelayed(@OXOo.OOXIXo View view, long j, @OXOo.OOXIXo final Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                oix0oi.invoke();
            }
        };
        view.postDelayed(runnable, j);
        return runnable;
    }

    @OXOo.OOXIXo
    public static final Runnable postOnAnimationDelayed(@OXOo.OOXIXo View view, long j, @OXOo.OOXIXo final Oox.oIX0oI<kotlin.oXIO0o0XI> oix0oi) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.Xx000oIo
            @Override // java.lang.Runnable
            public final void run() {
                Oox.oIX0oI.this.invoke();
            }
        };
        view.postOnAnimationDelayed(runnable, j);
        return runnable;
    }

    public static final void setGone(@OXOo.OOXIXo View view, boolean z) {
        int i;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    public static final void setInvisible(@OXOo.OOXIXo View view, boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        view.setVisibility(i);
    }

    public static final void setPadding(@OXOo.OOXIXo View view, @Px int i) {
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(@OXOo.OOXIXo View view, boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    public static final void updateLayoutParams(@OXOo.OOXIXo View view, @OXOo.OOXIXo Oox.oOoXoXO<? super ViewGroup.LayoutParams, kotlin.oXIO0o0XI> oooxoxo) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            oooxoxo.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @XO0OX.xxIXOIIO(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Oox.oOoXoXO<? super T, kotlin.oXIO0o0XI> oooxoxo) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        kotlin.jvm.internal.IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
        oooxoxo.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@OXOo.OOXIXo View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
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

    public static final void updatePaddingRelative(@OXOo.OOXIXo View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
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
