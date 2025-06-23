package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class OnBackPressedDispatcherKt {
    @OOXIXo
    public static final OnBackPressedCallback addCallback(@OOXIXo OnBackPressedDispatcher onBackPressedDispatcher, @oOoXoXO LifecycleOwner lifecycleOwner, boolean z, @OOXIXo Oox.oOoXoXO<? super OnBackPressedCallback, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(onBackPressedDispatcher, "<this>");
        IIX0o.x0xO0oo(oooxoxo, "onBackPressed");
        OnBackPressedDispatcherKt$addCallback$callback$1 onBackPressedDispatcherKt$addCallback$callback$1 = new OnBackPressedDispatcherKt$addCallback$callback$1(z, oooxoxo);
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, onBackPressedDispatcherKt$addCallback$callback$1);
        } else {
            onBackPressedDispatcher.addCallback(onBackPressedDispatcherKt$addCallback$callback$1);
        }
        return onBackPressedDispatcherKt$addCallback$callback$1;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z, oooxoxo);
    }
}
