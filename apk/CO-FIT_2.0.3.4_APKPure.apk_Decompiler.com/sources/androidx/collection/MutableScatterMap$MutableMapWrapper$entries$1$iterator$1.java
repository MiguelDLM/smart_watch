package androidx.collection;

import OI0IXox.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.util.Iterator;
import java.util.Map;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.IXxxXO;
import kotlin.sequences.oO;

public final class MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 implements Iterator<Map.Entry<K, V>>, oxoX {
    private int current = -1;
    @OOXIXo
    private Iterator<? extends Map.Entry<K, V>> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    @IXIxx0.oxoX(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1328}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
    @XX({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n363#2,6:1851\n373#2,3:1858\n376#2,9:1862\n1826#3:1857\n1688#3:1861\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1\n*L\n1326#1:1851,6\n1326#1:1858,3\n1326#1:1862,9\n1326#1:1857\n1326#1:1861\n*E\n"})
    /* renamed from: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements x0xO0oo<oO<? super Map.Entry<K, V>>, I0Io<? super oXIO0o0XI>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        @OOXIXo
        public final I0Io<oXIO0o0XI> create(@oOoXoXO Object obj, @OOXIXo I0Io<?> i0Io) {
            AnonymousClass1 r0 = new AnonymousClass1(mutableScatterMap, this, i0Io);
            r0.L$0 = obj;
            return r0;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00a9 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b2  */
        @OXOo.oOoXoXO
        public final java.lang.Object invokeSuspend(@OXOo.OOXIXo java.lang.Object r24) {
            /*
                r23 = this;
                r0 = r23
                java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
                int r2 = r0.label
                r4 = 8
                r5 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r5) goto L_0x002f
                int r2 = r0.I$3
                int r6 = r0.I$2
                long r7 = r0.J$0
                int r9 = r0.I$1
                int r10 = r0.I$0
                java.lang.Object r11 = r0.L$3
                long[] r11 = (long[]) r11
                java.lang.Object r12 = r0.L$2
                androidx.collection.MutableScatterMap r12 = (androidx.collection.MutableScatterMap) r12
                java.lang.Object r13 = r0.L$1
                androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 r13 = (androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1) r13
                java.lang.Object r14 = r0.L$0
                kotlin.sequences.oO r14 = (kotlin.sequences.oO) r14
                kotlin.I0oOoX.x0XOIxOo(r24)
                r3 = 1
                goto L_0x00aa
            L_0x002f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0037:
                kotlin.I0oOoX.x0XOIxOo(r24)
                java.lang.Object r2 = r0.L$0
                kotlin.sequences.oO r2 = (kotlin.sequences.oO) r2
                androidx.collection.MutableScatterMap<K, V> r6 = r3
                androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 r7 = r2
                long[] r8 = r6.metadata
                int r9 = r8.length
                int r9 = r9 + -2
                if (r9 < 0) goto L_0x00c6
                r10 = 0
            L_0x004a:
                r11 = r8[r10]
                long r13 = ~r11
                r15 = 7
                long r13 = r13 << r15
                long r13 = r13 & r11
                r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r13 = r13 & r15
                int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r17 == 0) goto L_0x00bf
                int r13 = r10 - r9
                int r13 = ~r13
                int r13 = r13 >>> 31
                int r13 = 8 - r13
                r14 = r2
                r2 = 0
                r20 = r11
                r12 = r6
                r11 = r8
                r6 = r13
                r13 = r7
                r7 = r20
                r22 = r10
                r10 = r9
                r9 = r22
            L_0x0070:
                if (r2 >= r6) goto L_0x00b2
                r15 = 255(0xff, double:1.26E-321)
                long r15 = r15 & r7
                r17 = 128(0x80, double:6.32E-322)
                int r19 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                if (r19 >= 0) goto L_0x00ad
                int r15 = r9 << 3
                int r15 = r15 + r2
                r13.setCurrent(r15)
                androidx.collection.MutableMapEntry r15 = new androidx.collection.MutableMapEntry
                java.lang.Object[] r3 = r12.keys
                java.lang.Object[] r4 = r12.values
                int r5 = r13.getCurrent()
                r15.<init>(r3, r4, r5)
                r0.L$0 = r14
                r0.L$1 = r13
                r0.L$2 = r12
                r0.L$3 = r11
                r0.I$0 = r10
                r0.I$1 = r9
                r0.J$0 = r7
                r0.I$2 = r6
                r0.I$3 = r2
                r3 = 1
                r0.label = r3
                java.lang.Object r4 = r14.II0xO0(r15, r0)
                if (r4 != r1) goto L_0x00aa
                return r1
            L_0x00aa:
                r4 = 8
                goto L_0x00ae
            L_0x00ad:
                r3 = 1
            L_0x00ae:
                long r7 = r7 >> r4
                int r2 = r2 + r3
                r5 = 1
                goto L_0x0070
            L_0x00b2:
                r3 = 1
                if (r6 != r4) goto L_0x00c6
                r8 = r11
                r6 = r12
                r7 = r13
                r2 = r14
                r20 = r10
                r10 = r9
                r9 = r20
                goto L_0x00c0
            L_0x00bf:
                r3 = 1
            L_0x00c0:
                if (r10 == r9) goto L_0x00c6
                int r10 = r10 + 1
                r5 = 1
                goto L_0x004a
            L_0x00c6:
                kotlin.oXIO0o0XI r1 = kotlin.oXIO0o0XI.f19155oIX0oI
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @oOoXoXO
        public final Object invoke(@OOXIXo oO<? super Map.Entry<K, V>> oOVar, @oOoXoXO I0Io<? super oXIO0o0XI> i0Io) {
            return ((AnonymousClass1) create(oOVar, i0Io)).invokeSuspend(oXIO0o0XI.f19155oIX0oI);
        }
    }

    public MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(final MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = IXxxXO.oIX0oI(new AnonymousClass1((I0Io<? super AnonymousClass1>) null));
    }

    public final int getCurrent() {
        return this.current;
    }

    @OOXIXo
    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public void remove() {
        int i = this.current;
        if (i != -1) {
            this.this$0.removeValueAt(i);
            this.current = -1;
        }
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setIterator(@OOXIXo Iterator<? extends Map.Entry<K, V>> it) {
        IIX0o.x0xO0oo(it, "<set-?>");
        this.iterator = it;
    }

    @OOXIXo
    public Map.Entry<K, V> next() {
        return (Map.Entry) this.iterator.next();
    }
}
