package XXIoX0;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIXOooo;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends ExecutorCoroutineDispatcher {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f4041IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f4042Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final long f4043Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public CoroutineScheduler f4044OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f4045oI0IIXIo;

    public Oxx0IOOO() {
        this(0, 0, 0L, null, 15, null);
    }

    private final CoroutineScheduler xoXoI() {
        return new CoroutineScheduler(this.f4042Oo, this.f4041IXxxXO, this.f4043Oxx0xo, this.f4045oI0IIXIo);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @OXOo.OOXIXo
    public Executor IIXOooo() {
        return this.f4044OxxIIOOXO;
    }

    public final void X0IIOO() {
        xxX();
    }

    public final synchronized void XIxXXX0x0(long j) {
        this.f4044OxxIIOOXO.O0xOxO(j);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4044OxxIIOOXO.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        CoroutineScheduler.oOoXoXO(this.f4044OxxIIOOXO, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        CoroutineScheduler.oOoXoXO(this.f4044OxxIIOOXO, runnable, null, true, 2, null);
    }

    public final void o00(@OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo xoIox xoiox, boolean z) {
        this.f4044OxxIIOOXO.OOXIXo(runnable, xoiox, z);
    }

    public final synchronized void xxX() {
        this.f4044OxxIIOOXO.O0xOxO(1000L);
        this.f4044OxxIIOOXO = xoXoI();
    }

    public /* synthetic */ Oxx0IOOO(int i, int i2, long j, String str, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? ooOOo0oXI.f4061I0Io : i, (i3 & 2) != 0 ? ooOOo0oXI.f4068oxoX : i2, (i3 & 4) != 0 ? ooOOo0oXI.f4065X0o0xo : j, (i3 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public Oxx0IOOO(int i, int i2, long j, @OXOo.OOXIXo String str) {
        this.f4042Oo = i;
        this.f4041IXxxXO = i2;
        this.f4043Oxx0xo = j;
        this.f4045oI0IIXIo = str;
        this.f4044OxxIIOOXO = xoXoI();
    }
}
