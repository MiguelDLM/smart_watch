package kotlinx.coroutines;

import kotlin.Result;

/* loaded from: classes6.dex */
public final class oI extends xx0X0 {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<kotlin.oXIO0o0XI> f30336oI0IIXIo;

    /* JADX WARN: Multi-variable type inference failed */
    public oI(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        this.f30336oI0IIXIo = i0Io;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        o00(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.xXxxox0I
    public void o00(@OXOo.oOoXoXO Throwable th) {
        kotlin.coroutines.I0Io<kotlin.oXIO0o0XI> i0Io = this.f30336oI0IIXIo;
        Result.oIX0oI oix0oi = Result.Companion;
        i0Io.resumeWith(Result.m287constructorimpl(kotlin.oXIO0o0XI.f29392oIX0oI));
    }
}
