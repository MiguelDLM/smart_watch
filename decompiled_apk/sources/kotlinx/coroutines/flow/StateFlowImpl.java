package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.x0o;

@XX({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,428:1\n18#2:429\n18#2:443\n28#3,4:430\n28#3,4:437\n20#4:434\n20#4:441\n13579#5,2:435\n329#6:442\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n315#1:429\n396#1:443\n324#1:430,4\n352#1:437,4\n324#1:434\n352#1:441\n348#1:435,2\n385#1:442\n*E\n"})
/* loaded from: classes6.dex */
public final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.oIX0oI<o00> implements xoIox<T>, oIX0oI<T>, kotlinx.coroutines.flow.internal.xxIXOIIO<T> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30149OxxIIOOXO = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _state;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f30150oI0IIXIo;

    public StateFlowImpl(@OXOo.OOXIXo Object obj) {
        this._state = obj;
    }

    public static /* synthetic */ void Oo() {
    }

    @Override // kotlinx.coroutines.flow.xxIXOIIO
    public boolean I0Io(T t) {
        setValue(t);
        return true;
    }

    @Override // kotlinx.coroutines.flow.xxIXOIIO
    public void II0xO0() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public final boolean IXxxXO(Object obj, Object obj2) {
        int i;
        o00[] x0XOIxOo2;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30149OxxIIOOXO;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !IIX0o.Oxx0IOOO(obj3, obj)) {
                return false;
            }
            if (IIX0o.Oxx0IOOO(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i2 = this.f30150oI0IIXIo;
            if ((i2 & 1) == 0) {
                int i3 = i2 + 1;
                this.f30150oI0IIXIo = i3;
                o00[] x0XOIxOo3 = x0XOIxOo();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                while (true) {
                    o00[] o00VarArr = x0XOIxOo3;
                    if (o00VarArr != null) {
                        for (o00 o00Var : o00VarArr) {
                            if (o00Var != null) {
                                o00Var.II0XooXoX();
                            }
                        }
                    }
                    synchronized (this) {
                        i = this.f30150oI0IIXIo;
                        if (i == i3) {
                            this.f30150oI0IIXIo = i3 + 1;
                            return true;
                        }
                        x0XOIxOo2 = x0XOIxOo();
                        oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                    }
                    x0XOIxOo3 = x0XOIxOo2;
                    i3 = i;
                }
            } else {
                this.f30150oI0IIXIo = i2 + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.xxIXOIIO
    @OXOo.OOXIXo
    public X0o0xo<T> X0o0xo(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return xoXoI.oxoX(this, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bc, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r11, r12) == false) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b3 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x003e, B:14:0x00ab, B:16:0x00b3, B:18:0x00b8, B:20:0x00d9, B:22:0x00df, B:26:0x00be, B:29:0x00c5, B:38:0x0060, B:40:0x0073, B:41:0x009c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b8 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x003e, B:14:0x00ab, B:16:0x00b3, B:18:0x00b8, B:20:0x00d9, B:22:0x00df, B:26:0x00be, B:29:0x00c5, B:38:0x0060, B:40:0x0073, B:41:0x009c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00df A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x003e, B:14:0x00ab, B:16:0x00b3, B:18:0x00b8, B:20:0x00d9, B:22:0x00df, B:26:0x00be, B:29:0x00c5, B:38:0x0060, B:40:0x0073, B:41:0x009c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.I0Io] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00dd -> B:14:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ef -> B:14:0x00ab). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.x0XOIxOo, kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<? super T> r11, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.XO, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.xoIox
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
        }
        if (t2 == null) {
            t2 = (T) kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
        }
        return IXxxXO(t, t2);
    }

    @Override // kotlinx.coroutines.flow.xxIXOIIO, kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    public Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        setValue(t);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.xoIox, kotlinx.coroutines.flow.IIXOooo
    public T getValue() {
        x0o x0oVar = kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
        T t = (T) f30149OxxIIOOXO.get(this);
        if (t == x0oVar) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo
    @OXOo.OOXIXo
    public List<T> oIX0oI() {
        return kotlin.collections.oI0IIXIo.OOXIXo(getValue());
    }

    @Override // kotlinx.coroutines.flow.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: oO, reason: merged with bridge method [inline-methods] */
    public o00 xxIXOIIO() {
        return new o00();
    }

    @Override // kotlinx.coroutines.flow.xoIox
    public void setValue(T t) {
        if (t == null) {
            t = (T) kotlinx.coroutines.flow.internal.oOoXoXO.f30198oIX0oI;
        }
        IXxxXO(null, t);
    }

    @Override // kotlinx.coroutines.flow.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: x0xO0oo, reason: merged with bridge method [inline-methods] */
    public o00[] xoIox(int i) {
        return new o00[i];
    }
}
