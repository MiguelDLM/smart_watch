package kotlinx.coroutines;

import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes6.dex */
public final class xX0IIXIx0 extends ooOOo0oXI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> f30483XO;

    /* JADX WARN: Multi-variable type inference failed */
    public xX0IIXIx0(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        this.f30483XO = oooxoxo;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        xoIox(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "InvokeOnCancel[" + OI0.oIX0oI(this.f30483XO) + ObjectUtils.f32506oIX0oI + OI0.II0xO0(this) + ']';
    }

    @Override // kotlinx.coroutines.x0XOIxOo
    public void xoIox(@OXOo.oOoXoXO Throwable th) {
        this.f30483XO.invoke(th);
    }
}
