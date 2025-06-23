package androidx.activity;

import androidx.annotation.MainThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nOnBackPressedCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1855#2,2:106\n*S KotlinDebug\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n*L\n60#1:106,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {

    @OXOo.OOXIXo
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();

    @OXOo.oOoXoXO
    private Oox.oIX0oI<oXIO0o0XI> enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z) {
        this.isEnabled = z;
    }

    @XO0OX.xxIXOIIO(name = "addCancellable")
    public final void addCancellable(@OXOo.OOXIXo Cancellable cancellable) {
        IIX0o.x0xO0oo(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    @OXOo.oOoXoXO
    public final Oox.oIX0oI<oXIO0o0XI> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(@OXOo.OOXIXo BackEventCompat backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(@OXOo.OOXIXo BackEventCompat backEvent) {
        IIX0o.x0xO0oo(backEvent, "backEvent");
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((Cancellable) it.next()).cancel();
        }
    }

    @XO0OX.xxIXOIIO(name = "removeCancellable")
    public final void removeCancellable(@OXOo.OOXIXo Cancellable cancellable) {
        IIX0o.x0xO0oo(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        Oox.oIX0oI<oXIO0o0XI> oix0oi = this.enabledChangedCallback;
        if (oix0oi != null) {
            oix0oi.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(@OXOo.oOoXoXO Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        this.enabledChangedCallback = oix0oi;
    }
}
