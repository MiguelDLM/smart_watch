package androidx.core.view;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnNextLayout$1\n*L\n1#1,414:1\n*E\n"})
public final class ViewKt$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ oOoXoXO<View, oXIO0o0XI> $action;

    public ViewKt$doOnNextLayout$1(oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        this.$action = oooxoxo;
    }

    public void onLayoutChange(@OOXIXo View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        view.removeOnLayoutChangeListener(this);
        this.$action.invoke(view);
    }
}
