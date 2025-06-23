package XXIoX0;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@XX({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
@o0
/* loaded from: classes6.dex */
public class I0Io extends ExecutorCoroutineDispatcher {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f4034IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f4035Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final long f4036Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public CoroutineScheduler f4037OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f4038oI0IIXIo;

    public /* synthetic */ I0Io(int i, int i2, long j, String str, int i3, IIXOooo iIXOooo) {
        this(i, i2, j, (i3 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ CoroutineDispatcher o00(I0Io i0Io, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 16;
            }
            return i0Io.xoXoI(i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @OXOo.OOXIXo
    public Executor IIXOooo() {
        return this.f4037OxxIIOOXO;
    }

    public final CoroutineScheduler X0IIOO() {
        return new CoroutineScheduler(this.f4035Oo, this.f4034IXxxXO, this.f4036Oxx0xo, this.f4038oI0IIXIo);
    }

    public final void XIxXXX0x0(@OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo xoIox xoiox, boolean z) {
        try {
            this.f4037OxxIIOOXO.OOXIXo(runnable, xoiox, z);
        } catch (RejectedExecutionException unused) {
            kotlinx.coroutines.o0.f30326IIXOooo.oxxXoxO(this.f4037OxxIIOOXO.XO(runnable, xoiox));
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4037OxxIIOOXO.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        try {
            CoroutineScheduler.oOoXoXO(this.f4037OxxIIOOXO, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            kotlinx.coroutines.o0.f30326IIXOooo.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        try {
            CoroutineScheduler.oOoXoXO(this.f4037OxxIIOOXO, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            kotlinx.coroutines.o0.f30326IIXOooo.dispatchYield(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        return super.toString() + "[scheduler = " + this.f4037OxxIIOOXO + ']';
    }

    @OXOo.OOXIXo
    public final CoroutineDispatcher xoXoI(int i) {
        if (i > 0) {
            return new X0o0xo(this, i, null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i).toString());
    }

    @OXOo.OOXIXo
    public final CoroutineDispatcher xxX(int i) {
        if (i > 0) {
            if (i <= this.f4035Oo) {
                return new X0o0xo(this, i, null, 0);
            }
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f4035Oo + "), but have " + i).toString());
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i).toString());
    }

    public I0Io(int i, int i2, long j, @OXOo.OOXIXo String str) {
        this.f4035Oo = i;
        this.f4034IXxxXO = i2;
        this.f4036Oxx0xo = j;
        this.f4038oI0IIXIo = str;
        this.f4037OxxIIOOXO = X0IIOO();
    }

    public /* synthetic */ I0Io(int i, int i2, String str, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? ooOOo0oXI.f4061I0Io : i, (i3 & 2) != 0 ? ooOOo0oXI.f4068oxoX : i2, (i3 & 4) != 0 ? ooOOo0oXI.f4067oIX0oI : str);
    }

    public I0Io(int i, int i2, @OXOo.OOXIXo String str) {
        this(i, i2, ooOOo0oXI.f4065X0o0xo, str);
    }

    public /* synthetic */ I0Io(int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? ooOOo0oXI.f4061I0Io : i, (i3 & 2) != 0 ? ooOOo0oXI.f4068oxoX : i2);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ I0Io(int i, int i2) {
        this(i, i2, ooOOo0oXI.f4065X0o0xo, null, 8, null);
    }
}
