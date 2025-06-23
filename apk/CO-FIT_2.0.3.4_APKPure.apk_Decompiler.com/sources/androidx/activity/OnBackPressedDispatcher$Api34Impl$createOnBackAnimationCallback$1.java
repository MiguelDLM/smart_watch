package androidx.activity;

import Oox.oIX0oI;
import Oox.oOoXoXO;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1 implements OnBackAnimationCallback {
    final /* synthetic */ oIX0oI<oXIO0o0XI> $onBackCancelled;
    final /* synthetic */ oIX0oI<oXIO0o0XI> $onBackInvoked;
    final /* synthetic */ oOoXoXO<BackEventCompat, oXIO0o0XI> $onBackProgressed;
    final /* synthetic */ oOoXoXO<BackEventCompat, oXIO0o0XI> $onBackStarted;

    public OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(oOoXoXO<? super BackEventCompat, oXIO0o0XI> oooxoxo, oOoXoXO<? super BackEventCompat, oXIO0o0XI> oooxoxo2, oIX0oI<oXIO0o0XI> oix0oi, oIX0oI<oXIO0o0XI> oix0oi2) {
        this.$onBackStarted = oooxoxo;
        this.$onBackProgressed = oooxoxo2;
        this.$onBackInvoked = oix0oi;
        this.$onBackCancelled = oix0oi2;
    }

    public void onBackCancelled() {
        this.$onBackCancelled.invoke();
    }

    public void onBackInvoked() {
        this.$onBackInvoked.invoke();
    }

    public void onBackProgressed(BackEvent backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        this.$onBackProgressed.invoke(new BackEventCompat(backEvent));
    }

    public void onBackStarted(BackEvent backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
        this.$onBackStarted.invoke(new BackEventCompat(backEvent));
    }
}
