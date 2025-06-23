package androidx.activity;

import Oox.oOoXoXO;
import kotlin.oXIO0o0XI;

public final class OnBackPressedDispatcherKt$addCallback$callback$1 extends OnBackPressedCallback {
    final /* synthetic */ oOoXoXO<OnBackPressedCallback, oXIO0o0XI> $onBackPressed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnBackPressedDispatcherKt$addCallback$callback$1(boolean z, oOoXoXO<? super OnBackPressedCallback, oXIO0o0XI> oooxoxo) {
        super(z);
        this.$onBackPressed = oooxoxo;
    }

    public void handleOnBackPressed() {
        this.$onBackPressed.invoke(this);
    }
}
