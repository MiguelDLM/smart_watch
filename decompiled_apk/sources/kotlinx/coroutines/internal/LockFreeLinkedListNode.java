package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.OX00O0xII;
import org.apache.commons.lang3.ObjectUtils;

@kotlin.jvm.internal.XX({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
@OX00O0xII
/* loaded from: classes6.dex */
public class LockFreeLinkedListNode {

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _next = this;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _prev = this;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _removedRef;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30232XO = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30231Oo = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30230IXxxXO = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @kotlin.jvm.internal.XX({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n*L\n1#1,367:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0 extends oIX0oI {

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<Boolean> f30233oxoX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public II0xO0(LockFreeLinkedListNode lockFreeLinkedListNode, Oox.oIX0oI<Boolean> oix0oi) {
            super(lockFreeLinkedListNode);
            this.f30233oxoX = oix0oi;
        }

        @Override // kotlinx.coroutines.internal.II0xO0
        @OXOo.oOoXoXO
        /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
        public Object X0o0xo(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f30233oxoX.invoke().booleanValue()) {
                return null;
            }
            return o00.oIX0oI();
        }
    }

    @kotlin.o0
    /* loaded from: classes6.dex */
    public static abstract class oIX0oI extends kotlinx.coroutines.internal.II0xO0<LockFreeLinkedListNode> {

        /* renamed from: I0Io, reason: collision with root package name */
        @XO0OX.XO
        @OXOo.oOoXoXO
        public LockFreeLinkedListNode f30234I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        @XO0OX.XO
        public final LockFreeLinkedListNode f30235II0xO0;

        public oIX0oI(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f30235II0xO0 = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.II0xO0
        /* renamed from: XO, reason: merged with bridge method [inline-methods] */
        public void I0Io(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode, @OXOo.oOoXoXO Object obj) {
            boolean z;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                lockFreeLinkedListNode2 = this.f30235II0xO0;
            } else {
                lockFreeLinkedListNode2 = this.f30234I0Io;
            }
            if (lockFreeLinkedListNode2 != null && androidx.concurrent.futures.oIX0oI.oIX0oI(LockFreeLinkedListNode.f30232XO, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f30235II0xO0;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f30234I0Io;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.xoIox(lockFreeLinkedListNode4);
            }
        }
    }

    private final void oO(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final void I0Io(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!ooOOo0oXI().X0o0xo(lockFreeLinkedListNode, this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        if (androidx.concurrent.futures.oIX0oI.oIX0oI(r4, r3, r2, ((kotlinx.coroutines.internal.IoOoX) r5).f30229oIX0oI) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode II0XooXoX(kotlinx.coroutines.internal.xI r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f30231Oo
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f30232XO
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f30231Oo
            boolean r0 = androidx.concurrent.futures.oIX0oI.oIX0oI(r1, r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.x0XOIxOo()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.xI
            if (r6 == 0) goto L34
            kotlinx.coroutines.internal.xI r5 = (kotlinx.coroutines.internal.xI) r5
            r5.II0xO0(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.IoOoX
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            kotlinx.coroutines.internal.IoOoX r5 = (kotlinx.coroutines.internal.IoOoX) r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = r5.f30229oIX0oI
            boolean r2 = androidx.concurrent.futures.oIX0oI.oIX0oI(r4, r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f30231Oo
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r5, r3)
            r3 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.II0XooXoX(kotlinx.coroutines.internal.xI):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    @kotlin.o0
    public final int IIXOooo(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode, @OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode2, @OXOo.OOXIXo oIX0oI oix0oi) {
        f30231Oo.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30232XO;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        oix0oi.f30234I0Io = lockFreeLinkedListNode2;
        if (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, oix0oi)) {
            return 0;
        }
        if (oix0oi.II0xO0(this) == null) {
            return 1;
        }
        return 2;
    }

    public boolean IXxxXO() {
        if (Oxx0xo() == null) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final Object OOXIXo() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30232XO;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof xI)) {
                return obj;
            }
            ((xI) obj).II0xO0(this);
        }
    }

    @OXOo.oOoXoXO
    public LockFreeLinkedListNode Oo() {
        IoOoX ioOoX;
        Object OOXIXo2 = OOXIXo();
        if (OOXIXo2 instanceof IoOoX) {
            ioOoX = (IoOoX) OOXIXo2;
        } else {
            ioOoX = null;
        }
        if (ioOoX == null) {
            return null;
        }
        return ioOoX.f30229oIX0oI;
    }

    public final boolean Oxx0IOOO(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode) {
        f30231Oo.lazySet(lockFreeLinkedListNode, this);
        f30232XO.lazySet(lockFreeLinkedListNode, this);
        while (OOXIXo() == this) {
            if (androidx.concurrent.futures.oIX0oI.oIX0oI(f30232XO, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.xoIox(this);
                return true;
            }
        }
        return false;
    }

    @kotlin.o0
    @OXOo.oOoXoXO
    public final LockFreeLinkedListNode Oxx0xo() {
        Object OOXIXo2;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            OOXIXo2 = OOXIXo();
            if (OOXIXo2 instanceof IoOoX) {
                return ((IoOoX) OOXIXo2).f30229oIX0oI;
            }
            if (OOXIXo2 == this) {
                return (LockFreeLinkedListNode) OOXIXo2;
            }
            kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) OOXIXo2;
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(f30232XO, this, OOXIXo2, lockFreeLinkedListNode.OxxIIOOXO()));
        lockFreeLinkedListNode.II0XooXoX(null);
        return null;
    }

    public final IoOoX OxxIIOOXO() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30230IXxxXO;
        IoOoX ioOoX = (IoOoX) atomicReferenceFieldUpdater.get(this);
        if (ioOoX == null) {
            IoOoX ioOoX2 = new IoOoX(this);
            atomicReferenceFieldUpdater.lazySet(this, ioOoX2);
            return ioOoX2;
        }
        return ioOoX;
    }

    @kotlin.o0
    public final boolean X0o0xo(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode, @OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode2) {
        f30231Oo.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30232XO;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.xoIox(lockFreeLinkedListNode2);
        return true;
    }

    @OXOo.OOXIXo
    public final LockFreeLinkedListNode oOoXoXO() {
        return o00.XO(OOXIXo());
    }

    @OXOo.OOXIXo
    public final LockFreeLinkedListNode ooOOo0oXI() {
        LockFreeLinkedListNode II0XooXoX2 = II0XooXoX(null);
        if (II0XooXoX2 == null) {
            return xxIXOIIO((LockFreeLinkedListNode) f30231Oo.get(this));
        }
        return II0XooXoX2;
    }

    public final boolean oxoX(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode, @OXOo.OOXIXo Oox.oIX0oI<Boolean> oix0oi) {
        int IIXOooo2;
        II0xO0 iI0xO0 = new II0xO0(lockFreeLinkedListNode, oix0oi);
        do {
            IIXOooo2 = ooOOo0oXI().IIXOooo(lockFreeLinkedListNode, this, iI0xO0);
            if (IIXOooo2 == 1) {
                return true;
            }
        } while (IIXOooo2 != 2);
        return false;
    }

    @OXOo.OOXIXo
    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.oO
            @OXOo.oOoXoXO
            public Object get() {
                return kotlinx.coroutines.OI0.oIX0oI(this.receiver);
            }
        } + ObjectUtils.f32506oIX0oI + kotlinx.coroutines.OI0.II0xO0(this);
    }

    public boolean x0XOIxOo() {
        return OOXIXo() instanceof IoOoX;
    }

    @OXOo.OOXIXo
    @kotlin.o0
    public final oIX0oI x0xO0oo(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode, @OXOo.OOXIXo Oox.oIX0oI<Boolean> oix0oi) {
        return new II0xO0(lockFreeLinkedListNode, oix0oi);
    }

    public final void xoIox(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30231Oo;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (OOXIXo() != lockFreeLinkedListNode) {
                return;
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(f30231Oo, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (x0XOIxOo()) {
            lockFreeLinkedListNode.II0XooXoX(null);
        }
    }

    public final void xoXoI(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode, @OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode2) {
    }

    public final LockFreeLinkedListNode xxIXOIIO(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.x0XOIxOo()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) f30231Oo.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }
}
