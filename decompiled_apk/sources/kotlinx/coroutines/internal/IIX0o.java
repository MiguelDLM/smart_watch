package kotlinx.coroutines.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nOnDemandAllocatingPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPoolKt\n*L\n1#1,107:1\n41#1:108\n41#1:109\n35#1,7:110\n41#1:127\n1549#2:117\n1620#2,2:118\n1622#2:122\n1549#2:123\n1620#2,3:124\n101#3,2:120\n*S KotlinDebug\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n*L\n35#1:108\n54#1:109\n76#1:110,7\n92#1:127\n77#1:117\n77#1:118,2\n77#1:122\n91#1:123\n91#1:124,3\n79#1:120,2\n*E\n"})
/* loaded from: classes6.dex */
public final class IIX0o<T> {

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30224oxoX = AtomicIntegerFieldUpdater.newUpdater(IIX0o.class, "controlState");

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final AtomicReferenceArray f30225I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<Integer, T> f30226II0xO0;

    @XO0OX.o00
    private volatile int controlState;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f30227oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public IIX0o(int i, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends T> oooxoxo) {
        this.f30227oIX0oI = i;
        this.f30226II0xO0 = oooxoxo;
        this.f30225I0Io = new AtomicReferenceArray(i);
    }

    public final boolean I0Io(int i) {
        return (i & Integer.MIN_VALUE) != 0;
    }

    @OXOo.OOXIXo
    public final List<T> II0xO0() {
        int i;
        Object andSet;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30224oxoX;
        while (true) {
            i = atomicIntegerFieldUpdater.get(this);
            if ((i & Integer.MIN_VALUE) != 0) {
                i = 0;
                break;
            }
            if (f30224oxoX.compareAndSet(this, i, Integer.MIN_VALUE | i)) {
                break;
            }
        }
        X0.oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, i);
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(X00xOoXI2, 10));
        Iterator<Integer> it = X00xOoXI2.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.oOXoIIIo) it).nextInt();
            do {
                andSet = this.f30225I0Io.getAndSet(nextInt, null);
            } while (andSet == null);
            arrayList.add(andSet);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public final String X0o0xo() {
        String str;
        int i = f30224oxoX.get(this);
        X0.oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, Integer.MAX_VALUE & i);
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(X00xOoXI2, 10));
        Iterator<Integer> it = X00xOoXI2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f30225I0Io.get(((kotlin.collections.oOXoIIIo) it).nextInt()));
        }
        String obj = arrayList.toString();
        if ((i & Integer.MIN_VALUE) != 0) {
            str = "[closed]";
        } else {
            str = "";
        }
        return obj + str;
    }

    public final int XO() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30224oxoX;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if ((i & Integer.MIN_VALUE) != 0) {
                return 0;
            }
        } while (!f30224oxoX.compareAndSet(this, i, Integer.MIN_VALUE | i));
        return i;
    }

    public final boolean oIX0oI() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30224oxoX;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if ((Integer.MIN_VALUE & i) != 0) {
                return false;
            }
            if (i >= this.f30227oIX0oI) {
                return true;
            }
        } while (!f30224oxoX.compareAndSet(this, i, i + 1));
        this.f30225I0Io.set(i, this.f30226II0xO0.invoke(Integer.valueOf(i)));
        return true;
    }

    public final void oxoX(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    @OXOo.OOXIXo
    public String toString() {
        return "OnDemandAllocatingPool(" + X0o0xo() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
