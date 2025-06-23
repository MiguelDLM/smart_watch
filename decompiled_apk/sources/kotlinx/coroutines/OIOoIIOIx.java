package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class OIOoIIOIx extends kotlin.coroutines.oIX0oI implements oXIO0o0XI {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29734Oo = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OIOoIIOIx f29735XO = new OIOoIIOIx();

    public OIOoIIOIx() {
        super(oXIO0o0XI.f30343xxIXOIIO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public static /* synthetic */ void IIXOooo() {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public static /* synthetic */ void X0IIOO() {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public static /* synthetic */ void XIxXXX0x0() {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public static /* synthetic */ void o00() {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public static /* synthetic */ void xoXoI() {
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public static /* synthetic */ void xxX() {
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    @OXOo.OOXIXo
    public I0oOIX O0xOxO(boolean z, boolean z2, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        return x0OIX00oO.f30462XO;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    @OXOo.OOXIXo
    public I0oOIX Oo(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        return x0OIX00oO.f30462XO;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.I0Io OxI() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    @OXOo.OOXIXo
    public IIXOooo XI0IXoo(@OXOo.OOXIXo o00 o00Var) {
        return x0OIX00oO.f30462XO;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        II0xO0(null);
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.oOoXoXO
    public oXIO0o0XI getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean oIX0oI(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    @OXOo.oOoXoXO
    public Object oOXoIIIo(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    public boolean start() {
        return false;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = f29734Oo)
    @OXOo.OOXIXo
    public CancellationException xI() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public kotlin.sequences.ooOOo0oXI<oXIO0o0XI> xXxxox0I() {
        return SequencesKt__SequencesKt.Oxx0IOOO();
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @OXOo.OOXIXo
    public oXIO0o0XI xoIox(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        return oXIO0o0XI.oIX0oI.xoIox(this, oxio0o0xi);
    }
}
