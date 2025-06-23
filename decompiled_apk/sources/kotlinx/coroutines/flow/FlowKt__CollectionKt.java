package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__CollectionKt {

    /* JADX WARN: Incorrect field signature: TC; */
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements XO {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Collection f29980XO;

        /* JADX WARN: Incorrect types in method signature: (TC;)V */
        public oIX0oI(Collection collection) {
            this.f29980XO = collection;
        }

        @Override // kotlinx.coroutines.flow.XO
        @OXOo.oOoXoXO
        public final Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            this.f29980XO.add(t);
            return oXIO0o0XI.f29392oIX0oI;
        }
    }

    public static /* synthetic */ Object I0Io(X0o0xo x0o0xo, List list, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return Oxx0IOOO.XO00XOO(x0o0xo, list, i0Io);
    }

    @OXOo.oOoXoXO
    public static final <T> Object II0xO0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo List<T> list, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super List<? extends T>> i0Io) {
        return Oxx0IOOO.OOxOI(x0o0xo, list, i0Io);
    }

    public static /* synthetic */ Object X0o0xo(X0o0xo x0o0xo, Set set, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return Oxx0IOOO.XooIO0oo0(x0o0xo, set, i0Io);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object oIX0oI(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> r4, @OXOo.OOXIXo C r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super C> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = (kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.I0oOoX.x0XOIxOo(r6)
            goto L49
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.I0oOoX.x0XOIxOo(r6)
            kotlinx.coroutines.flow.FlowKt__CollectionKt$oIX0oI r6 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$oIX0oI
            r6.<init>(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.collect(r6, r0)
            if (r4 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.oIX0oI(kotlinx.coroutines.flow.X0o0xo, java.util.Collection, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.oOoXoXO
    public static final <T> Object oxoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Set<T> set, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Set<? extends T>> i0Io) {
        return Oxx0IOOO.OOxOI(x0o0xo, set, i0Io);
    }
}
