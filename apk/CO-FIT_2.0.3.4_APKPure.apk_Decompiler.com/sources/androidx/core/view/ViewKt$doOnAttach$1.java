package androidx.core.view;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnAttach$1\n*L\n1#1,414:1\n*E\n"})
public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ oOoXoXO<View, oXIO0o0XI> $action;
    final /* synthetic */ View $this_doOnAttach;

    public ViewKt$doOnAttach$1(View view, oOoXoXO<? super View, oXIO0o0XI> oooxoxo) {
        this.$this_doOnAttach = view;
        this.$action = oooxoxo;
    }

    public void onViewAttachedToWindow(@OOXIXo View view) {
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }

    public void onViewDetachedFromWindow(@OOXIXo View view) {
    }
}
