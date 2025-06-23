package kotlinx.coroutines.channels;

import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.xoIox;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.o0IXXIx;

@XX({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
/* loaded from: classes6.dex */
public class x0XOIxOo<E> extends BufferedChannel<E> {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public final int f29888XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final BufferOverflow f29889XIxXXX0x0;

    public /* synthetic */ x0XOIxOo(int i, BufferOverflow bufferOverflow, Oox.oOoXoXO oooxoxo, int i2, IIXOooo iIXOooo) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : oooxoxo);
    }

    public static /* synthetic */ <E> Object IxX00(x0XOIxOo<E> x0xoixoo, E e, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        Object x00IOx2 = x0xoixoo.x00IOx(e, true);
        if (!(x00IOx2 instanceof xoIox.I0Io)) {
            return IXIxx0.oIX0oI.oIX0oI(true);
        }
        return IXIxx0.oIX0oI.oIX0oI(false);
    }

    public static /* synthetic */ <E> Object oxOXxoXII(x0XOIxOo<E> x0xoixoo, E e, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        UndeliveredElementException oxoX2;
        Object x00IOx2 = x0xoixoo.x00IOx(e, true);
        if (x00IOx2 instanceof xoIox.oIX0oI) {
            xoIox.XO(x00IOx2);
            Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo = x0xoixoo.f29819Oo;
            if (oooxoxo != null && (oxoX2 = OnUndeliveredElementKt.oxoX(oooxoxo, e, null, 2, null)) != null) {
                kotlin.oO.oIX0oI(oxoX2, x0xoixoo.xoIxX());
                throw oxoX2;
            }
            throw x0xoixoo.xoIxX();
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean I0xX0() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean IIxOXoOo0() {
        if (this.f29889XIxXXX0x0 == BufferOverflow.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    public final Object XO0o(E e, boolean z) {
        Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo;
        UndeliveredElementException oxoX2;
        Object x0xO0oo2 = super.x0xO0oo(e);
        if (!xoIox.ooOOo0oXI(x0xO0oo2) && !xoIox.OOXIXo(x0xO0oo2)) {
            if (z && (oooxoxo = this.f29819Oo) != null && (oxoX2 = OnUndeliveredElementKt.oxoX(oooxoxo, e, null, 2, null)) != null) {
                throw oxoX2;
            }
            return xoIox.f29891II0xO0.I0Io(oXIO0o0XI.f29392oIX0oI);
        }
        return x0xO0oo2;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.oOoXoXO
    public Object XOxIOxOx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return oxOXxoXII(this, e, i0Io);
    }

    public final Object oX0I0O(E e) {
        OOXIXo oOXIXo;
        o0IXXIx o0ixxix;
        Object obj = BufferedChannelKt.f29843XO;
        OOXIXo oOXIXo2 = (OOXIXo) BufferedChannel.f29817xoXoI.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f29812Oxx0xo.getAndIncrement(this);
            long j = andIncrement & BufferedChannelKt.f29829IIX0o;
            boolean OOXIxO02 = OOXIxO0(andIncrement);
            int i = BufferedChannelKt.f29828II0xO0;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (oOXIXo2.f30276IXxxXO != j2) {
                OOXIXo xXOx2 = xXOx(j2, oOXIXo2);
                if (xXOx2 == null) {
                    if (OOXIxO02) {
                        return xoIox.f29891II0xO0.oIX0oI(xoIxX());
                    }
                } else {
                    oOXIXo = xXOx2;
                }
            } else {
                oOXIXo = oOXIXo2;
            }
            int xIXX2 = xIXX(oOXIXo, i2, e, j, obj, OOXIxO02);
            if (xIXX2 != 0) {
                if (xIXX2 != 1) {
                    if (xIXX2 != 2) {
                        if (xIXX2 != 3) {
                            if (xIXX2 != 4) {
                                if (xIXX2 == 5) {
                                    oOXIXo.II0xO0();
                                }
                                oOXIXo2 = oOXIXo;
                            } else {
                                if (j < IoOoo()) {
                                    oOXIXo.II0xO0();
                                }
                                return xoIox.f29891II0xO0.oIX0oI(xoIxX());
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else {
                        if (OOXIxO02) {
                            oOXIXo.IXxxXO();
                            return xoIox.f29891II0xO0.oIX0oI(xoIxX());
                        }
                        if (obj instanceof o0IXXIx) {
                            o0ixxix = (o0IXXIx) obj;
                        } else {
                            o0ixxix = null;
                        }
                        if (o0ixxix != null) {
                            XIXIxO(o0ixxix, oOXIXo, i2);
                        }
                        oxxXoxO((oOXIXo.f30276IXxxXO * i) + i2);
                        return xoIox.f29891II0xO0.I0Io(oXIO0o0XI.f29392oIX0oI);
                    }
                } else {
                    return xoIox.f29891II0xO0.I0Io(oXIO0o0XI.f29392oIX0oI);
                }
            } else {
                oOXIXo.II0xO0();
                return xoIox.f29891II0xO0.I0Io(oXIO0o0XI.f29392oIX0oI);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @OXOo.oOoXoXO
    public Object oXxOI0oIx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return IxX00(this, e, i0Io);
    }

    public final Object x00IOx(E e, boolean z) {
        if (this.f29889XIxXXX0x0 == BufferOverflow.DROP_LATEST) {
            return XO0o(e, z);
        }
        return oX0I0O(e);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public Object x0xO0oo(E e) {
        return x00IOx(e, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void xXoOI00O(@OXOo.OOXIXo kotlinx.coroutines.selects.xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
        Object x0xO0oo2 = x0xO0oo(obj);
        if (!(x0xO0oo2 instanceof xoIox.I0Io)) {
            xoiox.XO(oXIO0o0XI.f29392oIX0oI);
        } else {
            if (x0xO0oo2 instanceof xoIox.oIX0oI) {
                xoIox.XO(x0xO0oo2);
                xoiox.XO(BufferedChannelKt.O0xOxO());
                return;
            }
            throw new IllegalStateException("unreachable");
        }
    }

    public x0XOIxOo(int i, @OXOo.OOXIXo BufferOverflow bufferOverflow, @OXOo.oOoXoXO Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo) {
        super(i, oooxoxo);
        this.f29888XI0IXoo = i;
        this.f29889XIxXXX0x0 = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + IO.oxoX(BufferedChannel.class).xoXoI() + " instead").toString());
        }
        if (i >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
    }
}
