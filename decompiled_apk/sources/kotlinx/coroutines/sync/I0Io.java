package kotlinx.coroutines.sync;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.google.common.util.concurrent.oxoX;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.internal.X00IoxXI;
import kotlinx.coroutines.internal.x0o;

@XX({"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n1#1,397:1\n371#1,2:398\n*S KotlinDebug\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreSegment\n*L\n384#1:398,2\n*E\n"})
/* loaded from: classes6.dex */
public final class I0Io extends X00IoxXI<I0Io> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OOXIXo
    public final AtomicReferenceArray f30432oI0IIXIo;

    public I0Io(long j, @oOoXoXO I0Io i0Io, int i) {
        super(j, i0Io, i);
        int i2;
        i2 = SemaphoreKt.f30459XO;
        this.f30432oI0IIXIo = new AtomicReferenceArray(i2);
    }

    @OOXIXo
    public final AtomicReferenceArray IIXOooo() {
        return this.f30432oI0IIXIo;
    }

    @Override // kotlinx.coroutines.internal.X00IoxXI
    public void Oo(int i, @oOoXoXO Throwable th, @OOXIXo CoroutineContext coroutineContext) {
        x0o x0oVar;
        x0oVar = SemaphoreKt.f30458X0o0xo;
        IIXOooo().set(i, x0oVar);
        IXxxXO();
    }

    @oOoXoXO
    public final Object OxxIIOOXO(int i) {
        return IIXOooo().get(i);
    }

    public final void o00(int i, @oOoXoXO Object obj) {
        IIXOooo().set(i, obj);
    }

    public final boolean oI0IIXIo(int i, @oOoXoXO Object obj, @oOoXoXO Object obj2) {
        return oxoX.oIX0oI(IIXOooo(), i, obj, obj2);
    }

    @OOXIXo
    public String toString() {
        return "SemaphoreSegment[id=" + this.f30276IXxxXO + ", hashCode=" + hashCode() + ']';
    }

    @Override // kotlinx.coroutines.internal.X00IoxXI
    public int x0xO0oo() {
        int i;
        i = SemaphoreKt.f30459XO;
        return i;
    }

    @oOoXoXO
    public final Object xoXoI(int i, @oOoXoXO Object obj) {
        return IIXOooo().getAndSet(i, obj);
    }
}
