package kotlinx.coroutines.selects;

import Oox.IXxxXO;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.OX00O0xII;
import kotlinx.coroutines.internal.x0o;
import kotlinx.coroutines.oO;

/* loaded from: classes6.dex */
public final class SelectKt {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f30410I0Io = 1;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f30412II0xO0 = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f30414X0o0xo = 3;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f30417oxoX = 2;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IXxxXO<Object, Object, Object, Object> f30416oIX0oI = new IXxxXO() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
        @Override // Oox.IXxxXO
        @OXOo.oOoXoXO
        public final Void invoke(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO Object obj2, @OXOo.oOoXoXO Object obj3) {
            return null;
        }
    };

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f30415XO = new x0o("STATE_REG");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f30413Oxx0IOOO = new x0o("STATE_COMPLETED");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f30411II0XooXoX = new x0o("STATE_CANCELLED");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f30419xxIXOIIO = new x0o("NO_RESULT");

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0o f30418xoIox = new x0o("PARAM_CLAUSE_0");

    @OX00O0xII
    public static /* synthetic */ void I0Io() {
    }

    @OX00O0xII
    public static /* synthetic */ void II0xO0() {
    }

    @OX00O0xII
    public static /* synthetic */ void oIX0oI() {
    }

    public static final boolean oO(oO<? super oXIO0o0XI> oOVar, Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        Object OI02 = oOVar.OI0(oXIO0o0XI.f29392oIX0oI, null, oooxoxo);
        if (OI02 == null) {
            return false;
        }
        oOVar.XIxXXX0x0(OI02);
        return true;
    }

    @OXOo.OOXIXo
    public static final x0o oOoXoXO() {
        return f30418xoIox;
    }

    @OXOo.oOoXoXO
    public static final <R> Object ooOOo0oXI(@OXOo.OOXIXo Oox.oOoXoXO<? super II0xO0<? super R>, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        SelectImplementation selectImplementation = new SelectImplementation(i0Io.getContext());
        oooxoxo.invoke(selectImplementation);
        return selectImplementation.o00(i0Io);
    }

    public static final TrySelectDetailedResult oxoX(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return TrySelectDetailedResult.ALREADY_SELECTED;
                    }
                    throw new IllegalStateException(("Unexpected internal result: " + i).toString());
                }
                return TrySelectDetailedResult.CANCELLED;
            }
            return TrySelectDetailedResult.REREGISTER;
        }
        return TrySelectDetailedResult.SUCCESSFUL;
    }

    public static final <R> Object x0XOIxOo(Oox.oOoXoXO<? super II0xO0<? super R>, oXIO0o0XI> oooxoxo, kotlin.coroutines.I0Io<? super R> i0Io) {
        xxX.X0o0xo(3);
        throw null;
    }
}
