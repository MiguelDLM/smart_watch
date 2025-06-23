package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* loaded from: classes6.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements XO {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final /* synthetic */ Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super Boolean>, Object> f30022IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ XO<T> f30023Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f30024XO;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, XO<? super T> xo2, Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        this.f30024XO = booleanRef;
        this.f30023Oo = xo2;
        this.f30022IXxxXO = x0xo0oo;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(T r7, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L41
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L88
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            java.lang.Object r7 = r0.L$1
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1) r2
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L6c
        L41:
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L59
        L45:
            kotlin.I0oOoX.x0XOIxOo(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f30024XO
            boolean r8 = r8.element
            if (r8 == 0) goto L5c
            kotlinx.coroutines.flow.XO<T> r8 = r6.f30023Oo
            r0.label = r5
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        L5c:
            Oox.x0xO0oo<T, kotlin.coroutines.I0Io<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f30022IXxxXO
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L6b
            return r1
        L6b:
            r2 = r6
        L6c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L8b
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.f30024XO
            r8.element = r5
            kotlinx.coroutines.flow.XO<T> r8 = r2.f30023Oo
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L88
            return r1
        L88:
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        L8b:
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.emit(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }
}
