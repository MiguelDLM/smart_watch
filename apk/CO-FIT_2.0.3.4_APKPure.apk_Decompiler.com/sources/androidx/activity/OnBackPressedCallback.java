package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.xxIXOIIO;
import androidx.annotation.MainThread;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nOnBackPressedCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1855#2,2:106\n*S KotlinDebug\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n*L\n60#1:106,2\n*E\n"})
public abstract class OnBackPressedCallback {
    @OOXIXo
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    @oOoXoXO
    private oIX0oI<oXIO0o0XI> enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z) {
        this.isEnabled = z;
    }

    @xxIXOIIO(name = "addCancellable")
    public final void addCancellable(@OOXIXo Cancellable cancellable) {
        IIX0o.x0xO0oo(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    @oOoXoXO
    public final oIX0oI<oXIO0o0XI> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(@OOXIXo BackEventCompat backEventCompat) {
        IIX0o.x0xO0oo(backEventCompat, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(@OOXIXo BackEventCompat backEventCompat) {
        IIX0o.x0xO0oo(backEventCompat, "backEvent");
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        for (Cancellable cancel : this.cancellables) {
            cancel.cancel();
        }
    }

    @xxIXOIIO(name = "removeCancellable")
    public final void removeCancellable(@OOXIXo Cancellable cancellable) {
        IIX0o.x0xO0oo(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        oIX0oI<oXIO0o0XI> oix0oi = this.enabledChangedCallback;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(@oOoXoXO oIX0oI<oXIO0o0XI> oix0oi) {
        this.enabledChangedCallback = oix0oi;
    }
}
