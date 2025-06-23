package androidx.activity;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCallback$1 extends FunctionReferenceImpl implements Oox.oIX0oI<oXIO0o0XI> {
    public OnBackPressedDispatcher$addCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
    }
}
