package androidx.core.view;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnNextLayout$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,414:1\n69#2,2:415\n*E\n"})
public final class ViewKt$doOnLayout$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ oOoXoXO $action$inlined;

    public ViewKt$doOnLayout$$inlined$doOnNextLayout$1(oOoXoXO oooxoxo) {
        this.$action$inlined = oooxoxo;
    }

    public void onLayoutChange(@OOXIXo View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        view.removeOnLayoutChangeListener(this);
        this.$action$inlined.invoke(view);
    }
}
