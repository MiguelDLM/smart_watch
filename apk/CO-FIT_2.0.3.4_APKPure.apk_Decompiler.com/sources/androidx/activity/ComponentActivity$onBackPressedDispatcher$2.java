package androidx.activity;

import Oox.oIX0oI;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class ComponentActivity$onBackPressedDispatcher$2 extends Lambda implements oIX0oI<OnBackPressedDispatcher> {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentActivity$onBackPressedDispatcher$2(ComponentActivity componentActivity) {
        super(0);
        this.this$0 = componentActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(ComponentActivity componentActivity) {
        try {
            ComponentActivity$onBackPressedDispatcher$2.super.onBackPressed();
        } catch (IllegalStateException e) {
            if (!IIX0o.Oxx0IOOO(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!IIX0o.Oxx0IOOO(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        componentActivity.addObserverForBackInvoker(onBackPressedDispatcher);
    }

    public final OnBackPressedDispatcher invoke() {
        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new xoIox(this.this$0));
        ComponentActivity componentActivity = this.this$0;
        if (Build.VERSION.SDK_INT >= 33) {
            if (!IIX0o.Oxx0IOOO(Looper.myLooper(), Looper.getMainLooper())) {
                new Handler(Looper.getMainLooper()).post(new OOXIXo(componentActivity, onBackPressedDispatcher));
            } else {
                componentActivity.addObserverForBackInvoker(onBackPressedDispatcher);
            }
        }
        return onBackPressedDispatcher;
    }
}
