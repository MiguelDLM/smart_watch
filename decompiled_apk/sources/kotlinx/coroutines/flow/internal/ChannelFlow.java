package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.OI0;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.IXxxXO;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;

@XX({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
@OX00O0xII
/* loaded from: classes6.dex */
public abstract class ChannelFlow<T> implements xxIXOIIO<T> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final BufferOverflow f30155IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @XO0OX.XO
    public final int f30156Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final CoroutineContext f30157XO;

    public ChannelFlow(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        this.f30157XO = coroutineContext;
        this.f30156Oo = i;
        this.f30155IXxxXO = bufferOverflow;
    }

    public static /* synthetic */ <T> Object Oxx0IOOO(ChannelFlow<T> channelFlow, kotlinx.coroutines.flow.XO<? super T> xo2, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        Object Oxx0IOOO2 = x0o.Oxx0IOOO(new ChannelFlow$collect$2(xo2, channelFlow, null), i0Io);
        if (Oxx0IOOO2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return Oxx0IOOO2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public abstract Object II0XooXoX(@OXOo.OOXIXo IXxxXO<? super T> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io);

    @OXOo.OOXIXo
    public final x0xO0oo<IXxxXO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> OOXIXo() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    @Override // kotlinx.coroutines.flow.internal.xxIXOIIO
    @OXOo.OOXIXo
    public kotlinx.coroutines.flow.X0o0xo<T> X0o0xo(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        CoroutineContext plus = coroutineContext.plus(this.f30157XO);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i2 = this.f30156Oo;
            if (i2 != -3) {
                if (i != -3) {
                    if (i2 != -2) {
                        if (i != -2) {
                            i += i2;
                            if (i < 0) {
                                i = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i = i2;
            }
            bufferOverflow = this.f30155IXxxXO;
        }
        if (IIX0o.Oxx0IOOO(plus, this.f30157XO) && i == this.f30156Oo && bufferOverflow == this.f30155IXxxXO) {
            return this;
        }
        return xxIXOIIO(plus, i, bufferOverflow);
    }

    @OXOo.oOoXoXO
    public String XO() {
        return null;
    }

    @Override // kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return Oxx0IOOO(this, xo2, i0Io);
    }

    public final int oOoXoXO() {
        int i = this.f30156Oo;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    @OXOo.OOXIXo
    public ReceiveChannel<T> ooOOo0oXI(@OXOo.OOXIXo xII xii) {
        return ProduceKt.II0XooXoX(xii, this.f30157XO, oOoXoXO(), this.f30155IXxxXO, CoroutineStart.ATOMIC, null, OOXIXo(), 16, null);
    }

    @OXOo.OOXIXo
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String XO2 = XO();
        if (XO2 != null) {
            arrayList.add(XO2);
        }
        if (this.f30157XO != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.f30157XO);
        }
        if (this.f30156Oo != -3) {
            arrayList.add("capacity=" + this.f30156Oo);
        }
        if (this.f30155IXxxXO != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f30155IXxxXO);
        }
        return OI0.oIX0oI(this) + '[' + CollectionsKt___CollectionsKt.OoIXo(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    @OXOo.oOoXoXO
    public kotlinx.coroutines.flow.X0o0xo<T> xoIox() {
        return null;
    }

    @OXOo.OOXIXo
    public abstract ChannelFlow<T> xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow);
}
