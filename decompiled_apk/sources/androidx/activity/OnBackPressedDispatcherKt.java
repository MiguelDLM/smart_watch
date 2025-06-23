package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcherKt {
    @OXOo.OOXIXo
    public static final OnBackPressedCallback addCallback(@OXOo.OOXIXo OnBackPressedDispatcher onBackPressedDispatcher, @OXOo.oOoXoXO LifecycleOwner lifecycleOwner, final boolean z, @OXOo.OOXIXo final Oox.oOoXoXO<? super OnBackPressedCallback, oXIO0o0XI> onBackPressed) {
        IIX0o.x0xO0oo(onBackPressedDispatcher, "<this>");
        IIX0o.x0xO0oo(onBackPressed, "onBackPressed");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(z) { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                onBackPressed.invoke(this);
            }
        };
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, onBackPressedCallback);
        } else {
            onBackPressedDispatcher.addCallback(onBackPressedCallback);
        }
        return onBackPressedCallback;
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
