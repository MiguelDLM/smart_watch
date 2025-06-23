package androidx.core.view;

import Oox.oOoXoXO;
import android.view.View;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n*L\n1#1,414:1\n*E\n"})
public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ oOoXoXO<View, oXIO0o0XI> $action;
    final /* synthetic */ View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(oOoXoXO<? super View, oXIO0o0XI> oooxoxo, View view) {
        this.$action = oooxoxo;
        this.$this_doOnPreDraw = view;
    }

    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
