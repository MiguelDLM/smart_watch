package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes6.dex */
public final class CoroutineContextKt {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29679oIX0oI = " @";

    public static final boolean I0Io(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, new Oox.x0xO0oo<Boolean, CoroutineContext.oIX0oI, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            @OXOo.OOXIXo
            public final Boolean invoke(boolean z, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
                return Boolean.valueOf(z || (oix0oi instanceof oo0xXOI0I));
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.oIX0oI oix0oi) {
                return invoke(bool.booleanValue(), oix0oi);
            }
        })).booleanValue();
    }

    public static final <T> T II0XooXoX(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        Oxx<?> oxx;
        CoroutineContext context = i0Io.getContext();
        Object I0Io2 = ThreadContextKt.I0Io(context, obj);
        if (I0Io2 != ThreadContextKt.f30273oIX0oI) {
            oxx = Oxx0IOOO(i0Io, context, I0Io2);
        } else {
            oxx = null;
        }
        try {
            return oix0oi.invoke();
        } finally {
            kotlin.jvm.internal.xxX.oxoX(1);
            if (oxx == null || oxx.OooI()) {
                ThreadContextKt.oIX0oI(context, I0Io2);
            }
            kotlin.jvm.internal.xxX.I0Io(1);
        }
    }

    @OXOo.oOoXoXO
    public static final String II0xO0(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return null;
    }

    @OXOo.oOoXoXO
    public static final Oxx<?> Oxx0IOOO(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.oOoXoXO Object obj) {
        if (!(i0Io instanceof IXIxx0.I0Io) || coroutineContext.get(oXIoO.f30345XO) == null) {
            return null;
        }
        Oxx<?> XO2 = XO((IXIxx0.I0Io) i0Io);
        if (XO2 != null) {
            XO2.OIx00oxx(coroutineContext, obj);
        }
        return XO2;
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final CoroutineContext X0o0xo(@OXOo.OOXIXo xII xii, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        CoroutineContext oIX0oI2 = oIX0oI(xii.getCoroutineContext(), coroutineContext, true);
        if (oIX0oI2 != Xo0.oIX0oI() && oIX0oI2.get(kotlin.coroutines.oxoX.f29196Oxx0IOOO) == null) {
            return oIX0oI2.plus(Xo0.oIX0oI());
        }
        return oIX0oI2;
    }

    @OXOo.oOoXoXO
    public static final Oxx<?> XO(@OXOo.OOXIXo IXIxx0.I0Io i0Io) {
        while (!(i0Io instanceof xXOx) && (i0Io = i0Io.getCallerFrame()) != null) {
            if (i0Io instanceof Oxx) {
                return (Oxx) i0Io;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext oIX0oI(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z) {
        boolean I0Io2 = I0Io(coroutineContext);
        boolean I0Io3 = I0Io(coroutineContext2);
        if (!I0Io2 && !I0Io3) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new Oox.x0xO0oo<CoroutineContext, CoroutineContext.oIX0oI, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // Oox.x0xO0oo
            @OXOo.OOXIXo
            public final CoroutineContext invoke(@OXOo.OOXIXo CoroutineContext coroutineContext4, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
                if (!(oix0oi instanceof oo0xXOI0I)) {
                    return coroutineContext4.plus(oix0oi);
                }
                CoroutineContext.oIX0oI oix0oi2 = objectRef.element.get(oix0oi.getKey());
                if (oix0oi2 == null) {
                    oo0xXOI0I oo0xxoi0i = (oo0xXOI0I) oix0oi;
                    if (z) {
                        oo0xxoi0i = oo0xxoi0i.oOoXoXO();
                    }
                    return coroutineContext4.plus(oo0xxoi0i);
                }
                Ref.ObjectRef<CoroutineContext> objectRef2 = objectRef;
                objectRef2.element = objectRef2.element.minusKey(oix0oi.getKey());
                return coroutineContext4.plus(((oo0xXOI0I) oix0oi).X0o0xo(oix0oi2));
            }
        });
        if (I0Io3) {
            objectRef.element = ((CoroutineContext) objectRef.element).fold(emptyCoroutineContext, new Oox.x0xO0oo<CoroutineContext, CoroutineContext.oIX0oI, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // Oox.x0xO0oo
                @OXOo.OOXIXo
                public final CoroutineContext invoke(@OXOo.OOXIXo CoroutineContext coroutineContext4, @OXOo.OOXIXo CoroutineContext.oIX0oI oix0oi) {
                    if (oix0oi instanceof oo0xXOI0I) {
                        return coroutineContext4.plus(((oo0xXOI0I) oix0oi).oOoXoXO());
                    }
                    return coroutineContext4.plus(oix0oi);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.element);
    }

    @OXOo.OOXIXo
    @OX00O0xII
    public static final CoroutineContext oxoX(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo CoroutineContext coroutineContext2) {
        if (!I0Io(coroutineContext2)) {
            return coroutineContext.plus(coroutineContext2);
        }
        return oIX0oI(coroutineContext, coroutineContext2, false);
    }

    public static final <T> T xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        Object I0Io2 = ThreadContextKt.I0Io(coroutineContext, obj);
        try {
            return oix0oi.invoke();
        } finally {
            kotlin.jvm.internal.xxX.oxoX(1);
            ThreadContextKt.oIX0oI(coroutineContext, I0Io2);
            kotlin.jvm.internal.xxX.I0Io(1);
        }
    }
}
