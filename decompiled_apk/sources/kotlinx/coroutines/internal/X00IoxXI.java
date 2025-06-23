package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.XXoOx0;
import kotlinx.coroutines.internal.X00IoxXI;

@kotlin.jvm.internal.XX({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n1#1,269:1\n252#2,4:270\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/Segment\n*L\n225#1:270,4\n*E\n"})
/* loaded from: classes6.dex */
public abstract class X00IoxXI<S extends X00IoxXI<S>> extends Oxx0IOOO<S> implements XXoOx0 {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30275Oxx0xo = AtomicIntegerFieldUpdater.newUpdater(X00IoxXI.class, "cleanedAndPointers");

    /* renamed from: IXxxXO, reason: collision with root package name */
    @XO0OX.XO
    public final long f30276IXxxXO;

    @XO0OX.o00
    private volatile int cleanedAndPointers;

    public X00IoxXI(long j, @OXOo.oOoXoXO S s, int i) {
        super(s);
        this.f30276IXxxXO = j;
        this.cleanedAndPointers = i << 16;
    }

    @Override // kotlinx.coroutines.internal.Oxx0IOOO
    public boolean II0XooXoX() {
        if (f30275Oxx0xo.get(this) == x0xO0oo() && !xxIXOIIO()) {
            return true;
        }
        return false;
    }

    public final void IXxxXO() {
        if (f30275Oxx0xo.incrementAndGet(this) == x0xO0oo()) {
            oOoXoXO();
        }
    }

    public abstract void Oo(int i, @OXOo.oOoXoXO Throwable th, @OXOo.OOXIXo CoroutineContext coroutineContext);

    public final boolean Oxx0xo() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30275Oxx0xo;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i == x0xO0oo() && !xxIXOIIO()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }

    public final boolean oO() {
        if (f30275Oxx0xo.addAndGet(this, SupportMenu.CATEGORY_MASK) == x0xO0oo() && !xxIXOIIO()) {
            return true;
        }
        return false;
    }

    public abstract int x0xO0oo();
}
