package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class I0xX0 extends CoroutineDispatcher {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0xX0 f29689XO = new I0xX0();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        XoIxOXIXo xoIxOXIXo = (XoIxOXIXo) coroutineContext.get(XoIxOXIXo.f29785Oo);
        if (xoIxOXIXo != null) {
            xoIxOXIXo.f29786XO = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    @XI0oooXX
    public CoroutineDispatcher limitedParallelism(int i) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
