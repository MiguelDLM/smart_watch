package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes6.dex */
public final class xOOOX extends oOo {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30481OxxIIOOXO = AtomicIntegerFieldUpdater.newUpdater(xOOOX.class, "_invoked");

    @XO0OX.o00
    private volatile int _invoked;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> f30482oI0IIXIo;

    /* JADX WARN: Multi-variable type inference failed */
    public xOOOX(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        this.f30482oI0IIXIo = oooxoxo;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        o00(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.xXxxox0I
    public void o00(@OXOo.oOoXoXO Throwable th) {
        if (f30481OxxIIOOXO.compareAndSet(this, 0, 1)) {
            this.f30482oI0IIXIo.invoke(th);
        }
    }
}
