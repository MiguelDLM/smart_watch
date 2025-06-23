package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

@OX00O0xII
/* loaded from: classes6.dex */
public abstract class oIX0oI<T> extends JobSupport implements oXIO0o0XI, kotlin.coroutines.I0Io<T>, xII {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineContext f30338IXxxXO;

    public oIX0oI(@OXOo.OOXIXo CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            IIX0((oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO));
        }
        this.f30338IXxxXO = coroutineContext.plus(this);
    }

    public static /* synthetic */ void oXIoO() {
    }

    @Override // kotlinx.coroutines.JobSupport
    @OXOo.OOXIXo
    public String IoOoo() {
        return OI0.oIX0oI(this) + " was cancelled";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void IoXIXo(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof xxX) {
            xxX xxx2 = (xxX) obj;
            o0IXXIx(xxx2.f30502oIX0oI, xxx2.oIX0oI());
        } else {
            XoIxOXIXo(obj);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void O0X(@OXOo.OOXIXo Throwable th) {
        Xx000oIo.II0xO0(this.f30338IXxxXO, th);
    }

    public final <R> void OO0(@OXOo.OOXIXo CoroutineStart coroutineStart, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo) {
        coroutineStart.invoke(x0xo0oo, r, this);
    }

    public void OX(@OXOo.oOoXoXO Object obj) {
        I0X0x0oIo(obj);
    }

    public void XoIxOXIXo(T t) {
    }

    @Override // kotlin.coroutines.I0Io
    @OXOo.OOXIXo
    public final CoroutineContext getContext() {
        return this.f30338IXxxXO;
    }

    @Override // kotlinx.coroutines.xII
    @OXOo.OOXIXo
    public CoroutineContext getCoroutineContext() {
        return this.f30338IXxxXO;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.oXIO0o0XI
    public boolean isActive() {
        return super.isActive();
    }

    public void o0IXXIx(@OXOo.OOXIXo Throwable th, boolean z) {
    }

    @Override // kotlin.coroutines.I0Io
    public final void resumeWith(@OXOo.OOXIXo Object obj) {
        Object OoO2 = OoO(xI.oxoX(obj, null, 1, null));
        if (OoO2 == xI0oxI00.f30473II0xO0) {
            return;
        }
        OX(OoO2);
    }

    @Override // kotlinx.coroutines.JobSupport
    @OXOo.OOXIXo
    public String x0OIX00oO() {
        String II0xO02 = CoroutineContextKt.II0xO0(this.f30338IXxxXO);
        if (II0xO02 == null) {
            return super.x0OIX00oO();
        }
        return '\"' + II0xO02 + "\":" + super.x0OIX00oO();
    }
}
