package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class SubscribedSharedFlow<T> implements x0XOIxOo<T> {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<XO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f30153Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final x0XOIxOo<T> f30154XO;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedSharedFlow(@OXOo.OOXIXo x0XOIxOo<? extends T> x0xoixoo, @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        this.f30154XO = x0xoixoo;
        this.f30153Oo = x0xo0oo;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.x0XOIxOo, kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> r6, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r0 = (kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r0 = new kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L46
        L31:
            kotlin.I0oOoX.x0XOIxOo(r7)
            kotlinx.coroutines.flow.x0XOIxOo<T> r7 = r5.f30154XO
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = new kotlinx.coroutines.flow.SubscribedFlowCollector
            Oox.x0xO0oo<kotlinx.coroutines.flow.XO<? super T>, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, java.lang.Object> r4 = r5.f30153Oo
            r2.<init>(r6, r4)
            r0.label = r3
            java.lang.Object r6 = r7.collect(r2, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedSharedFlow.collect(kotlinx.coroutines.flow.XO, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo
    @OXOo.OOXIXo
    public List<T> oIX0oI() {
        return this.f30154XO.oIX0oI();
    }
}
