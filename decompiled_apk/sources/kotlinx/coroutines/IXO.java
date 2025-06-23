package kotlinx.coroutines;

import kotlin.Result;

@kotlin.jvm.internal.XX({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/ResumeAwaitOnCompletion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
/* loaded from: classes6.dex */
public final class IXO<T> extends xx0X0 {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final x0xO0oo<T> f29698oI0IIXIo;

    /* JADX WARN: Multi-variable type inference failed */
    public IXO(@OXOo.OOXIXo x0xO0oo<? super T> x0xo0oo) {
        this.f29698oI0IIXIo = x0xo0oo;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        o00(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.xXxxox0I
    public void o00(@OXOo.oOoXoXO Throwable th) {
        Object oXIO0o0XI2 = OxI().oXIO0o0XI();
        if (oXIO0o0XI2 instanceof xxX) {
            x0xO0oo<T> x0xo0oo = this.f29698oI0IIXIo;
            Result.oIX0oI oix0oi = Result.Companion;
            x0xo0oo.resumeWith(Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(((xxX) oXIO0o0XI2).f30502oIX0oI)));
        } else {
            x0xO0oo<T> x0xo0oo2 = this.f29698oI0IIXIo;
            Result.oIX0oI oix0oi2 = Result.Companion;
            x0xo0oo2.resumeWith(Result.m287constructorimpl(xI0oxI00.II0XooXoX(oXIO0o0XI2)));
        }
    }
}
