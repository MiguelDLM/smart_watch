package kotlinx.coroutines.channels;

import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.xoIox;

/* loaded from: classes6.dex */
public final class xxIXOIIO {
    public static /* synthetic */ Oxx0IOOO I0Io(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return oxoX(i, null, null, 6, null);
    }

    @OXOo.OOXIXo
    public static final <T> Object II0XooXoX(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> oooxoxo) {
        if (!(obj instanceof xoIox.I0Io)) {
            oooxoxo.invoke(obj);
        }
        return obj;
    }

    @OXOo.OOXIXo
    public static final <E> Oxx0IOOO<E> II0xO0(int i, @OXOo.OOXIXo BufferOverflow bufferOverflow, @OXOo.oOoXoXO Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo) {
        Oxx0IOOO<E> x0xoixoo;
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != Integer.MAX_VALUE) {
                        if (bufferOverflow == BufferOverflow.SUSPEND) {
                            return new BufferedChannel(i, oooxoxo);
                        }
                        return new x0XOIxOo(i, bufferOverflow, oooxoxo);
                    }
                    return new BufferedChannel(Integer.MAX_VALUE, oooxoxo);
                }
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    x0xoixoo = new BufferedChannel<>(0, oooxoxo);
                } else {
                    x0xoixoo = new x0XOIxOo<>(1, bufferOverflow, oooxoxo);
                }
            } else {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new x0XOIxOo(1, BufferOverflow.DROP_OLDEST, oooxoxo);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            x0xoixoo = new BufferedChannel<>(Oxx0IOOO.f29871xoIox.oIX0oI(), oooxoxo);
        } else {
            x0xoixoo = new x0XOIxOo<>(1, bufferOverflow, oooxoxo);
        }
        return x0xoixoo;
    }

    @OXOo.OOXIXo
    public static final <T> Object Oxx0IOOO(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        if (obj instanceof xoIox.I0Io) {
            oooxoxo.invoke(xoIox.XO(obj));
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T X0o0xo(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, ? extends T> oooxoxo) {
        if (obj instanceof xoIox.I0Io) {
            return oooxoxo.invoke(xoIox.XO(obj));
        }
        return obj;
    }

    @OXOo.OOXIXo
    public static final <T> Object XO(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        if (obj instanceof xoIox.oIX0oI) {
            oooxoxo.invoke(xoIox.XO(obj));
        }
        return obj;
    }

    public static /* synthetic */ Oxx0IOOO oxoX(int i, BufferOverflow bufferOverflow, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            oooxoxo = null;
        }
        return II0xO0(i, bufferOverflow, oooxoxo);
    }
}
