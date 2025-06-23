package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.X0xII0I;

/* loaded from: classes6.dex */
public final class XX0 {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0xII0I<Object>[] f30284I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Object[] f30285II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final CoroutineContext f30286oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f30287oxoX;

    public XX0(@OXOo.OOXIXo CoroutineContext coroutineContext, int i) {
        this.f30286oIX0oI = coroutineContext;
        this.f30285II0xO0 = new Object[i];
        this.f30284I0Io = new X0xII0I[i];
    }

    public final void II0xO0(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        int length = this.f30284I0Io.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            X0xII0I<Object> x0xII0I = this.f30284I0Io[length];
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(x0xII0I);
            x0xII0I.x0XOIxOo(coroutineContext, this.f30285II0xO0[length]);
            if (i >= 0) {
                length = i;
            } else {
                return;
            }
        }
    }

    public final void oIX0oI(@OXOo.OOXIXo X0xII0I<?> x0xII0I, @OXOo.oOoXoXO Object obj) {
        Object[] objArr = this.f30285II0xO0;
        int i = this.f30287oxoX;
        objArr[i] = obj;
        X0xII0I<Object>[] x0xII0IArr = this.f30284I0Io;
        this.f30287oxoX = i + 1;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(x0xII0I, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        x0xII0IArr[i] = x0xII0I;
    }
}
