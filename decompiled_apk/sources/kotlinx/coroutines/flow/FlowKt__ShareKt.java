package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.X0IIOO;
import kotlinx.coroutines.xII;

@XX({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__ShareKt {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r3 == 0) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> kotlinx.coroutines.flow.IXxxXO<T> I0Io(kotlinx.coroutines.flow.X0o0xo<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.Oxx0IOOO$II0xO0 r0 = kotlinx.coroutines.channels.Oxx0IOOO.f29871xoIox
            int r0 = r0.oIX0oI()
            int r0 = X0.IIXOooo.OxxIIOOXO(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3c
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.X0o0xo r2 = r1.xoIox()
            if (r2 == 0) goto L3c
            kotlinx.coroutines.flow.IXxxXO r7 = new kotlinx.coroutines.flow.IXxxXO
            int r3 = r1.f30156Oo
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f30155IXxxXO
            kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = 0
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f30155IXxxXO
            kotlin.coroutines.CoroutineContext r1 = r1.f30157XO
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            kotlinx.coroutines.flow.IXxxXO r8 = new kotlinx.coroutines.flow.IXxxXO
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.I0Io(kotlinx.coroutines.flow.X0o0xo, int):kotlinx.coroutines.flow.IXxxXO");
    }

    public static /* synthetic */ x0XOIxOo II0XooXoX(X0o0xo x0o0xo, xII xii, Oxx0xo oxx0xo, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return Oxx0IOOO.O0xxXxI(x0o0xo, xii, oxx0xo, i);
    }

    @OXOo.OOXIXo
    public static final <T> IIXOooo<T> II0xO0(@OXOo.OOXIXo xoIox<T> xoiox) {
        return new oOoXoXO(xoiox, null);
    }

    @OXOo.OOXIXo
    public static final <T> x0XOIxOo<T> Oxx0IOOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii, @OXOo.OOXIXo Oxx0xo oxx0xo, int i) {
        IXxxXO I0Io2 = I0Io(x0o0xo, i);
        xxIXOIIO oIX0oI2 = oO.oIX0oI(i, I0Io2.f30121II0xO0, I0Io2.f30120I0Io);
        return new OOXIXo(oIX0oI2, oxoX(xii, I0Io2.f30123oxoX, I0Io2.f30122oIX0oI, oIX0oI2, oxx0xo, oO.f30205oIX0oI));
    }

    public static final <T> void X0o0xo(xII xii, CoroutineContext coroutineContext, X0o0xo<? extends T> x0o0xo, kotlinx.coroutines.OxI<IIXOooo<T>> oxI) {
        kotlinx.coroutines.xoIox.XO(xii, coroutineContext, null, new FlowKt__ShareKt$launchSharingDeferred$1(x0o0xo, oxI, null), 2, null);
    }

    @OXOo.OOXIXo
    public static final <T> x0XOIxOo<T> XO(@OXOo.OOXIXo x0XOIxOo<? extends T> x0xoixoo, @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return new SubscribedSharedFlow(x0xoixoo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> x0XOIxOo<T> oIX0oI(@OXOo.OOXIXo xxIXOIIO<T> xxixoiio) {
        return new OOXIXo(xxixoiio, null);
    }

    public static final <T> kotlinx.coroutines.oXIO0o0XI oxoX(xII xii, CoroutineContext coroutineContext, X0o0xo<? extends T> x0o0xo, xxIXOIIO<T> xxixoiio, Oxx0xo oxx0xo, T t) {
        CoroutineStart coroutineStart;
        if (IIX0o.Oxx0IOOO(oxx0xo, Oxx0xo.f30128oIX0oI.I0Io())) {
            coroutineStart = CoroutineStart.DEFAULT;
        } else {
            coroutineStart = CoroutineStart.UNDISPATCHED;
        }
        return kotlinx.coroutines.II0XooXoX.oxoX(xii, coroutineContext, coroutineStart, new FlowKt__ShareKt$launchSharing$1(oxx0xo, x0o0xo, xxixoiio, t, null));
    }

    @OXOo.OOXIXo
    public static final <T> IIXOooo<T> xoIox(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii, @OXOo.OOXIXo Oxx0xo oxx0xo, T t) {
        IXxxXO I0Io2 = I0Io(x0o0xo, 1);
        xoIox oIX0oI2 = xoXoI.oIX0oI(t);
        return new oOoXoXO(oIX0oI2, oxoX(xii, I0Io2.f30123oxoX, I0Io2.f30122oIX0oI, oIX0oI2, oxx0xo, t));
    }

    @OXOo.oOoXoXO
    public static final <T> Object xxIXOIIO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super IIXOooo<? extends T>> i0Io) {
        IXxxXO I0Io2 = I0Io(x0o0xo, 1);
        kotlinx.coroutines.OxI I0Io3 = X0IIOO.I0Io(null, 1, null);
        X0o0xo(xii, I0Io2.f30123oxoX, I0Io2.f30122oIX0oI, I0Io3);
        return I0Io3.XO(i0Io);
    }
}
