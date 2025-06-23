package kotlinx.coroutines.debug.internal;

import OI0IXox.Oxx0IOOO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import X0.IIXOooo;
import XO0OX.o00;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.internal.x0o;

@XX({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
/* loaded from: classes6.dex */
public final class ConcurrentWeakMap<K, V> extends kotlin.collections.X0o0xo<K, V> {

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public final ReferenceQueue<K> f29896XO;

    @o00
    private volatile int _size;

    @oOoXoXO
    @o00
    private volatile Object core;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public static final AtomicIntegerFieldUpdater f29895Oo = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public static final AtomicReferenceFieldUpdater f29894IXxxXO = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");

    /* loaded from: classes6.dex */
    public final class I0Io<E> extends kotlin.collections.XO<E> {

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        public final x0xO0oo<K, V, E> f29898XO;

        /* JADX WARN: Multi-variable type inference failed */
        public I0Io(@OOXIXo x0xO0oo<? super K, ? super V, ? extends E> x0xo0oo) {
            this.f29898XO = x0xo0oo;
        }

        @Override // kotlin.collections.XO, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            kotlinx.coroutines.debug.internal.II0xO0.X0o0xo();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.XO
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @OOXIXo
        public Iterator<E> iterator() {
            return ((oIX0oI) ConcurrentWeakMap.f29894IXxxXO.get(ConcurrentWeakMap.this)).Oxx0IOOO(this.f29898XO);
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0<K, V> implements Map.Entry<K, V>, Oxx0IOOO.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public final V f29899Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final K f29900XO;

        public II0xO0(K k, V v) {
            this.f29900XO = k;
            this.f29899Oo = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f29900XO;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f29899Oo;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            kotlinx.coroutines.debug.internal.II0xO0.X0o0xo();
            throw new KotlinNothingValueException();
        }
    }

    /* loaded from: classes6.dex */
    public final class oIX0oI {

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        @OOXIXo
        public static final AtomicIntegerFieldUpdater f29901Oxx0IOOO = AtomicIntegerFieldUpdater.newUpdater(oIX0oI.class, "load");

        /* renamed from: I0Io, reason: collision with root package name */
        public final int f29902I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final int f29903II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        @OOXIXo
        public final AtomicReferenceArray f29904X0o0xo;

        @o00
        private volatile int load;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f29906oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @OOXIXo
        public final AtomicReferenceArray f29907oxoX;

        @XX({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public final class C1112oIX0oI<E> implements Iterator<E>, OI0IXox.oxoX {

            /* renamed from: IXxxXO, reason: collision with root package name */
            public K f29908IXxxXO;

            /* renamed from: Oo, reason: collision with root package name */
            public int f29909Oo = -1;

            /* renamed from: Oxx0xo, reason: collision with root package name */
            public V f29910Oxx0xo;

            /* renamed from: XO, reason: collision with root package name */
            @OOXIXo
            public final x0xO0oo<K, V, E> f29911XO;

            /* JADX WARN: Multi-variable type inference failed */
            public C1112oIX0oI(@OOXIXo x0xO0oo<? super K, ? super V, ? extends E> x0xo0oo) {
                this.f29911XO = x0xo0oo;
                oIX0oI();
            }

            @Override // java.util.Iterator
            @OOXIXo
            /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.II0xO0.X0o0xo();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f29909Oo < oIX0oI.this.f29906oIX0oI) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f29909Oo < oIX0oI.this.f29906oIX0oI) {
                    x0xO0oo<K, V, E> x0xo0oo = this.f29911XO;
                    K k = this.f29908IXxxXO;
                    if (k == false) {
                        IIX0o.XOxIOxOx("key");
                        k = (K) oXIO0o0XI.f29392oIX0oI;
                    }
                    V v = this.f29910Oxx0xo;
                    if (v == false) {
                        IIX0o.XOxIOxOx("value");
                        v = (V) oXIO0o0XI.f29392oIX0oI;
                    }
                    E e = (E) x0xo0oo.invoke(k, v);
                    oIX0oI();
                    return e;
                }
                throw new NoSuchElementException();
            }

            public final void oIX0oI() {
                K k;
                while (true) {
                    int i = this.f29909Oo + 1;
                    this.f29909Oo = i;
                    if (i < oIX0oI.this.f29906oIX0oI) {
                        Oxx0IOOO oxx0IOOO = (Oxx0IOOO) oIX0oI.this.f29907oxoX.get(this.f29909Oo);
                        if (oxx0IOOO != null && (k = (K) oxx0IOOO.get()) != null) {
                            this.f29908IXxxXO = k;
                            Object obj = (V) oIX0oI.this.f29904X0o0xo.get(this.f29909Oo);
                            if (obj instanceof II0XooXoX) {
                                obj = (V) ((II0XooXoX) obj).f29941oIX0oI;
                            }
                            if (obj != null) {
                                this.f29910Oxx0xo = (V) obj;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public oIX0oI(int i) {
            this.f29906oIX0oI = i;
            this.f29903II0xO0 = Integer.numberOfLeadingZeros(i) + 1;
            this.f29902I0Io = (i * 2) / 3;
            this.f29907oxoX = new AtomicReferenceArray(i);
            this.f29904X0o0xo = new AtomicReferenceArray(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object xxIXOIIO(oIX0oI oix0oi, Object obj, Object obj2, Oxx0IOOO oxx0IOOO, int i, Object obj3) {
            if ((i & 4) != 0) {
                oxx0IOOO = null;
            }
            return oix0oi.II0XooXoX(obj, obj2, oxx0IOOO);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            r6 = r5.f29904X0o0xo.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        
            if ((r6 instanceof kotlinx.coroutines.debug.internal.II0XooXoX) == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        
            if (com.google.common.util.concurrent.oxoX.oIX0oI(r5.f29904X0o0xo, r0, r6, r7) == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
        
            r6 = kotlinx.coroutines.debug.internal.II0xO0.f29942I0Io;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        
            return r6;
         */
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object II0XooXoX(@OXOo.OOXIXo K r6, @OXOo.oOoXoXO V r7, @OXOo.oOoXoXO kotlinx.coroutines.debug.internal.Oxx0IOOO<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.XO(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f29907oxoX
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.Oxx0IOOO r2 = (kotlinx.coroutines.debug.internal.Oxx0IOOO) r2
                if (r2 != 0) goto L47
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L31
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.oIX0oI.f29901Oxx0IOOO
            L1b:
                int r1 = r3.get(r5)
                int r4 = r5.f29902I0Io
                if (r1 < r4) goto L28
                kotlinx.coroutines.internal.x0o r6 = kotlinx.coroutines.debug.internal.II0xO0.oIX0oI()
                return r6
            L28:
                int r4 = r1 + 1
                boolean r1 = r3.compareAndSet(r5, r1, r4)
                if (r1 == 0) goto L1b
                r1 = 1
            L31:
                if (r8 != 0) goto L3e
                kotlinx.coroutines.debug.internal.Oxx0IOOO r8 = new kotlinx.coroutines.debug.internal.Oxx0IOOO
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V> r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.II0XooXoX(r3)
                r8.<init>(r6, r3)
            L3e:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f29907oxoX
                boolean r2 = com.google.common.util.concurrent.oxoX.oIX0oI(r3, r0, r2, r8)
                if (r2 != 0) goto L58
                goto L9
            L47:
                java.lang.Object r2 = r2.get()
                boolean r3 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r6, r2)
                if (r3 == 0) goto L70
                if (r1 == 0) goto L58
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.oIX0oI.f29901Oxx0IOOO
                r6.decrementAndGet(r5)
            L58:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.f29904X0o0xo
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.II0XooXoX
                if (r8 == 0) goto L67
                kotlinx.coroutines.internal.x0o r6 = kotlinx.coroutines.debug.internal.II0xO0.oIX0oI()
                return r6
            L67:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.f29904X0o0xo
                boolean r8 = com.google.common.util.concurrent.oxoX.oIX0oI(r8, r0, r6, r7)
                if (r8 == 0) goto L58
                return r6
            L70:
                if (r2 != 0) goto L75
                r5.OOXIXo(r0)
            L75:
                if (r0 != 0) goto L79
                int r0 = r5.f29906oIX0oI
            L79:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.oIX0oI.II0XooXoX(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.Oxx0IOOO):java.lang.Object");
        }

        public final void OOXIXo(int i) {
            Object obj;
            do {
                obj = this.f29904X0o0xo.get(i);
                if (obj == null || (obj instanceof II0XooXoX)) {
                    return;
                }
            } while (!com.google.common.util.concurrent.oxoX.oIX0oI(this.f29904X0o0xo, i, obj, null));
            ConcurrentWeakMap.this.xoIox();
        }

        @OOXIXo
        public final <E> Iterator<E> Oxx0IOOO(@OOXIXo x0xO0oo<? super K, ? super V, ? extends E> x0xo0oo) {
            return new C1112oIX0oI(x0xo0oo);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @oOoXoXO
        public final V X0o0xo(@OOXIXo K k) {
            int XO2 = XO(k.hashCode());
            while (true) {
                Oxx0IOOO oxx0IOOO = (Oxx0IOOO) this.f29907oxoX.get(XO2);
                if (oxx0IOOO == null) {
                    return null;
                }
                T t = oxx0IOOO.get();
                if (IIX0o.Oxx0IOOO(k, t)) {
                    V v = (V) this.f29904X0o0xo.get(XO2);
                    if (v instanceof II0XooXoX) {
                        return (V) ((II0XooXoX) v).f29941oIX0oI;
                    }
                    return v;
                }
                if (t == 0) {
                    OOXIXo(XO2);
                }
                if (XO2 == 0) {
                    XO2 = this.f29906oIX0oI;
                }
                XO2--;
            }
        }

        public final int XO(int i) {
            return (i * kotlinx.coroutines.debug.internal.II0xO0.f29945oIX0oI) >>> this.f29903II0xO0;
        }

        public final void oOoXoXO(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Oox.oOoXoXO<? super Integer, Integer> oooxoxo, Object obj) {
            int i;
            do {
                i = atomicIntegerFieldUpdater.get(obj);
            } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i, oooxoxo.invoke(Integer.valueOf(i)).intValue()));
        }

        public final void oxoX(@OOXIXo Oxx0IOOO<?> oxx0IOOO) {
            int XO2 = XO(oxx0IOOO.f29947oIX0oI);
            while (true) {
                Oxx0IOOO<?> oxx0IOOO2 = (Oxx0IOOO) this.f29907oxoX.get(XO2);
                if (oxx0IOOO2 == null) {
                    return;
                }
                if (oxx0IOOO2 == oxx0IOOO) {
                    OOXIXo(XO2);
                    return;
                } else {
                    if (XO2 == 0) {
                        XO2 = this.f29906oIX0oI;
                    }
                    XO2--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @OOXIXo
        public final ConcurrentWeakMap<K, V>.oIX0oI xoIox() {
            Object obj;
            Object obj2;
            x0o x0oVar;
            II0XooXoX oxoX2;
            while (true) {
                ConcurrentWeakMap<K, V>.oIX0oI oix0oi = (ConcurrentWeakMap<K, V>.oIX0oI) new oIX0oI(Integer.highestOneBit(IIXOooo.OxxIIOOXO(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i = this.f29906oIX0oI;
                for (int i2 = 0; i2 < i; i2++) {
                    Oxx0IOOO oxx0IOOO = (Oxx0IOOO) this.f29907oxoX.get(i2);
                    if (oxx0IOOO != null) {
                        obj = oxx0IOOO.get();
                    } else {
                        obj = null;
                    }
                    if (oxx0IOOO != null && obj == null) {
                        OOXIXo(i2);
                    }
                    while (true) {
                        obj2 = this.f29904X0o0xo.get(i2);
                        if (obj2 instanceof II0XooXoX) {
                            obj2 = ((II0XooXoX) obj2).f29941oIX0oI;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.f29904X0o0xo;
                        oxoX2 = kotlinx.coroutines.debug.internal.II0xO0.oxoX(obj2);
                        if (com.google.common.util.concurrent.oxoX.oIX0oI(atomicReferenceArray, i2, obj2, oxoX2)) {
                            break;
                        }
                    }
                    if (obj != null && obj2 != null) {
                        Object II0XooXoX2 = oix0oi.II0XooXoX(obj, obj2, oxx0IOOO);
                        x0oVar = kotlinx.coroutines.debug.internal.II0xO0.f29942I0Io;
                        if (II0XooXoX2 != x0oVar) {
                        }
                    }
                }
                return oix0oi;
            }
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    @Override // kotlin.collections.X0o0xo
    @OOXIXo
    public Set<K> II0xO0() {
        return new I0Io(new x0xO0oo<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // Oox.x0xO0oo
            @OOXIXo
            public final K invoke(@OOXIXo K k, @OOXIXo V v) {
                return k;
            }
        });
    }

    public final synchronized V OOXIXo(K k, V v) {
        V v2;
        x0o x0oVar;
        oIX0oI oix0oi = (oIX0oI) f29894IXxxXO.get(this);
        while (true) {
            v2 = (V) oIX0oI.xxIXOIIO(oix0oi, k, v, null, 4, null);
            x0oVar = kotlinx.coroutines.debug.internal.II0xO0.f29942I0Io;
            if (v2 == x0oVar) {
                oix0oi = oix0oi.xoIox();
                f29894IXxxXO.set(this, oix0oi);
            }
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @oOoXoXO
    public V get(@oOoXoXO Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((oIX0oI) f29894IXxxXO.get(this)).X0o0xo(obj);
    }

    @Override // kotlin.collections.X0o0xo
    @OOXIXo
    public Set<Map.Entry<K, V>> oIX0oI() {
        return new I0Io(new x0xO0oo<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // Oox.x0xO0oo
            @OOXIXo
            public final Map.Entry<K, V> invoke(@OOXIXo K k, @OOXIXo V v) {
                return new ConcurrentWeakMap.II0xO0(k, v);
            }
        });
    }

    public final void oOoXoXO() {
        if (this.f29896XO == null) {
            throw new IllegalStateException("Must be created with weakRefQueue = true");
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.f29896XO.remove();
                IIX0o.x0XOIxOo(remove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                xxIXOIIO((Oxx0IOOO) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override // kotlin.collections.X0o0xo
    public int oxoX() {
        return f29895Oo.get(this);
    }

    @Override // kotlin.collections.X0o0xo, java.util.AbstractMap, java.util.Map
    @oOoXoXO
    public V put(@OOXIXo K k, @OOXIXo V v) {
        x0o x0oVar;
        V v2 = (V) oIX0oI.xxIXOIIO((oIX0oI) f29894IXxxXO.get(this), k, v, null, 4, null);
        x0oVar = kotlinx.coroutines.debug.internal.II0xO0.f29942I0Io;
        if (v2 == x0oVar) {
            v2 = OOXIXo(k, v);
        }
        if (v2 == null) {
            f29895Oo.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @oOoXoXO
    public V remove(@oOoXoXO Object obj) {
        x0o x0oVar;
        if (obj == 0) {
            return null;
        }
        V v = (V) oIX0oI.xxIXOIIO((oIX0oI) f29894IXxxXO.get(this), obj, null, null, 4, null);
        x0oVar = kotlinx.coroutines.debug.internal.II0xO0.f29942I0Io;
        if (v == x0oVar) {
            v = OOXIXo(obj, null);
        }
        if (v != null) {
            f29895Oo.decrementAndGet(this);
        }
        return v;
    }

    public final void xoIox() {
        f29895Oo.decrementAndGet(this);
    }

    public final void xxIXOIIO(Oxx0IOOO<?> oxx0IOOO) {
        ((oIX0oI) f29894IXxxXO.get(this)).oxoX(oxx0IOOO);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? false : z);
    }

    public ConcurrentWeakMap(boolean z) {
        this.core = new oIX0oI(16);
        this.f29896XO = z ? new ReferenceQueue<>() : null;
    }
}
