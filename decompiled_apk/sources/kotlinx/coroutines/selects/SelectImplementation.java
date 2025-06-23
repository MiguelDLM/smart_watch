package kotlinx.coroutines.selects;

import Oox.IXxxXO;
import Oox.x0xO0oo;
import XO0OX.o00;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.I0oOIX;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.internal.X00IoxXI;
import kotlinx.coroutines.internal.x0o;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.selects.II0xO0;

@XX({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
@o0
/* loaded from: classes6.dex */
public class SelectImplementation<R> extends kotlinx.coroutines.ooOOo0oXI implements II0xO0<R>, OOXIXo<R> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30395OxxIIOOXO = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f30396IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public List<SelectImplementation<R>.oIX0oI> f30397Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f30398Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineContext f30399XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f30400oI0IIXIo;

    @OXOo.oOoXoXO
    @o00
    private volatile Object state;

    @XX({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    /* loaded from: classes6.dex */
    public final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public final IXxxXO<Object, Object, Object, Object> f30401I0Io;

        /* renamed from: II0XooXoX, reason: collision with root package name */
        @XO0OX.XO
        public int f30402II0XooXoX = -1;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public final IXxxXO<Object, xoIox<?>, Object, oXIO0o0XI> f30403II0xO0;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        @XO0OX.XO
        @OXOo.oOoXoXO
        public Object f30404Oxx0IOOO;

        /* renamed from: X0o0xo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Object f30405X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        @XO0OX.XO
        @OXOo.oOoXoXO
        public final IXxxXO<xoIox<?>, Object, Object, Oox.oOoXoXO<Throwable, oXIO0o0XI>> f30406XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        @XO0OX.XO
        public final Object f30407oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @OXOo.oOoXoXO
        public final Object f30408oxoX;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo IXxxXO<Object, ? super xoIox<?>, Object, oXIO0o0XI> iXxxXO, @OXOo.OOXIXo IXxxXO<Object, Object, Object, ? extends Object> iXxxXO2, @OXOo.oOoXoXO Object obj2, @OXOo.OOXIXo Object obj3, @OXOo.oOoXoXO IXxxXO<? super xoIox<?>, Object, Object, ? extends Oox.oOoXoXO<? super Throwable, oXIO0o0XI>> iXxxXO3) {
            this.f30407oIX0oI = obj;
            this.f30403II0xO0 = iXxxXO;
            this.f30401I0Io = iXxxXO2;
            this.f30408oxoX = obj2;
            this.f30405X0o0xo = obj3;
            this.f30406XO = iXxxXO3;
        }

        @OXOo.oOoXoXO
        public final Object I0Io(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
            Object obj2 = this.f30405X0o0xo;
            if (this.f30408oxoX == SelectKt.oOoXoXO()) {
                IIX0o.x0XOIxOo(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Oox.oOoXoXO) obj2).invoke(i0Io);
            }
            IIX0o.x0XOIxOo(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((x0xO0oo) obj2).invoke(obj, i0Io);
        }

        public final void II0xO0() {
            Object obj = this.f30404Oxx0IOOO;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            I0oOIX i0oOIX = null;
            if (obj instanceof X00IoxXI) {
                ((X00IoxXI) obj).Oo(this.f30402II0XooXoX, null, selectImplementation.getContext());
                return;
            }
            if (obj instanceof I0oOIX) {
                i0oOIX = (I0oOIX) obj;
            }
            if (i0oOIX != null) {
                i0oOIX.dispose();
            }
        }

        public final boolean X0o0xo(@OXOo.OOXIXo SelectImplementation<R> selectImplementation) {
            x0o x0oVar;
            this.f30403II0xO0.invoke(this.f30407oIX0oI, selectImplementation, this.f30408oxoX);
            Object obj = selectImplementation.f30400oI0IIXIo;
            x0oVar = SelectKt.f30419xxIXOIIO;
            if (obj == x0oVar) {
                return true;
            }
            return false;
        }

        @OXOo.oOoXoXO
        public final Oox.oOoXoXO<Throwable, oXIO0o0XI> oIX0oI(@OXOo.OOXIXo xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
            IXxxXO<xoIox<?>, Object, Object, Oox.oOoXoXO<Throwable, oXIO0o0XI>> iXxxXO = this.f30406XO;
            if (iXxxXO != null) {
                return iXxxXO.invoke(xoiox, this.f30408oxoX, obj);
            }
            return null;
        }

        @OXOo.oOoXoXO
        public final Object oxoX(@OXOo.oOoXoXO Object obj) {
            return this.f30401I0Io.invoke(this.f30407oIX0oI, this.f30408oxoX, obj);
        }
    }

    public SelectImplementation(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        x0o x0oVar;
        x0o x0oVar2;
        this.f30399XO = coroutineContext;
        x0oVar = SelectKt.f30415XO;
        this.state = x0oVar;
        this.f30397Oo = new ArrayList(2);
        this.f30398Oxx0xo = -1;
        x0oVar2 = SelectKt.f30419xxIXOIIO;
        this.f30400oI0IIXIo = x0oVar2;
    }

    @o0
    public static /* synthetic */ <R> Object OxI(SelectImplementation<R> selectImplementation, kotlin.coroutines.I0Io<? super R> i0Io) {
        if (selectImplementation.xxX()) {
            return selectImplementation.xoXoI(i0Io);
        }
        return selectImplementation.O0xOxO(i0Io);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean XIxXXX0x0() {
        x0o x0oVar;
        Object obj = f30395OxxIIOOXO.get(this);
        x0oVar = SelectKt.f30411II0XooXoX;
        if (obj == x0oVar) {
            return true;
        }
        return false;
    }

    private final void XxX0x0xxx(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static /* synthetic */ void ooXIXxIX(SelectImplementation selectImplementation, oIX0oI oix0oi, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            selectImplementation.IIX0o(oix0oi, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    private final boolean xxX() {
        return f30395OxxIIOOXO.get(this) instanceof oIX0oI;
    }

    @Override // kotlinx.coroutines.selects.II0xO0
    public <P, Q> void I0Io(@OXOo.OOXIXo Oxx0IOOO<? super P, ? extends Q> oxx0IOOO, P p, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        ooXIXxIX(this, new oIX0oI(oxx0IOOO.oxoX(), oxx0IOOO.I0Io(), oxx0IOOO.II0xO0(), p, x0xo0oo, oxx0IOOO.oIX0oI()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.II0xO0
    public <P, Q> void II0XooXoX(@OXOo.OOXIXo Oxx0IOOO<? super P, ? extends Q> oxx0IOOO, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        II0xO0.oIX0oI.oIX0oI(this, oxx0IOOO, x0xo0oo);
    }

    @Override // kotlinx.coroutines.o0IXXIx
    public void II0xO0(@OXOo.OOXIXo X00IoxXI<?> x00IoxXI, int i) {
        this.f30396IXxxXO = x00IoxXI;
        this.f30398Oxx0xo = i;
    }

    @XO0OX.xxIXOIIO(name = "register")
    public final void IIX0o(@OXOo.OOXIXo SelectImplementation<R>.oIX0oI oix0oi, boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30395OxxIIOOXO;
        if (atomicReferenceFieldUpdater.get(this) instanceof oIX0oI) {
            return;
        }
        if (!z) {
            OxxIIOOXO(oix0oi.f30407oIX0oI);
        }
        if (oix0oi.X0o0xo(this)) {
            if (!z) {
                List<SelectImplementation<R>.oIX0oI> list = this.f30397Oo;
                IIX0o.ooOOo0oXI(list);
                list.add(oix0oi);
            }
            oix0oi.f30404Oxx0IOOO = this.f30396IXxxXO;
            oix0oi.f30402II0XooXoX = this.f30398Oxx0xo;
            this.f30396IXxxXO = null;
            this.f30398Oxx0xo = -1;
            return;
        }
        atomicReferenceFieldUpdater.set(this, oix0oi);
    }

    public final void IIXOooo(SelectImplementation<R>.oIX0oI oix0oi) {
        x0o x0oVar;
        x0o x0oVar2;
        List<SelectImplementation<R>.oIX0oI> list = this.f30397Oo;
        if (list == null) {
            return;
        }
        for (SelectImplementation<R>.oIX0oI oix0oi2 : list) {
            if (oix0oi2 != oix0oi) {
                oix0oi2.II0xO0();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30395OxxIIOOXO;
        x0oVar = SelectKt.f30413Oxx0IOOO;
        atomicReferenceFieldUpdater.set(this, x0oVar);
        x0oVar2 = SelectKt.f30419xxIXOIIO;
        this.f30400oI0IIXIo = x0oVar2;
        this.f30397Oo = null;
    }

    public final void IoOoX(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, ? extends Object> oooxoxo, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, obj, obj2, oooxoxo.invoke(obj2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057 A[PHI: r6
      0x0057: PHI (r6v5 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:17:0x0054, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O0xOxO(kotlin.coroutines.I0Io<? super R> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.I0oOoX.x0XOIxOo(r6)
            goto L57
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2
            kotlin.I0oOoX.x0XOIxOo(r6)
            goto L4b
        L3c:
            kotlin.I0oOoX.x0XOIxOo(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.oOXoIIIo(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r2 = r5
        L4b:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.xoXoI(r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.O0xOxO(kotlin.coroutines.I0Io):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.xoIox
    public void Oxx0IOOO(@OXOo.OOXIXo I0oOIX i0oOIX) {
        this.f30396IXxxXO = i0oOIX;
    }

    public final void OxxIIOOXO(Object obj) {
        List<SelectImplementation<R>.oIX0oI> list = this.f30397Oo;
        IIX0o.ooOOo0oXI(list);
        List<SelectImplementation<R>.oIX0oI> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (((oIX0oI) it.next()).f30407oIX0oI == obj) {
                    throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                }
            }
        }
    }

    public final SelectImplementation<R>.oIX0oI X0IIOO(Object obj) {
        List<SelectImplementation<R>.oIX0oI> list = this.f30397Oo;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((oIX0oI) next).f30407oIX0oI == obj) {
                obj2 = next;
                break;
            }
        }
        SelectImplementation<R>.oIX0oI oix0oi = (oIX0oI) obj2;
        if (oix0oi != null) {
            return oix0oi;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    @Override // kotlinx.coroutines.selects.II0xO0
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @kotlin.XX(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @xx0o0O.II0XooXoX
    @XI0oooXX
    public void X0o0xo(long j, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo) {
        II0xO0.oIX0oI.II0xO0(this, j, oooxoxo);
    }

    public final boolean XI0IXoo() {
        x0o x0oVar;
        Object obj = f30395OxxIIOOXO.get(this);
        x0oVar = SelectKt.f30415XO;
        if (obj != x0oVar && !(obj instanceof List)) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.selects.xoIox
    public void XO(@OXOo.oOoXoXO Object obj) {
        this.f30400oI0IIXIo = obj;
    }

    @Override // kotlinx.coroutines.selects.xoIox
    @OXOo.OOXIXo
    public CoroutineContext getContext() {
        return this.f30399XO;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
        xoIox(th);
        return oXIO0o0XI.f29392oIX0oI;
    }

    @o0
    @OXOo.oOoXoXO
    public Object o00(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        return OxI(this, i0Io);
    }

    @Override // kotlinx.coroutines.selects.II0xO0
    public <Q> void oIX0oI(@OXOo.OOXIXo X0o0xo<? extends Q> x0o0xo, @OXOo.OOXIXo x0xO0oo<? super Q, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        ooXIXxIX(this, new oIX0oI(x0o0xo.oxoX(), x0o0xo.I0Io(), x0o0xo.II0xO0(), null, x0xo0oo, x0o0xo.oIX0oI()), false, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r0 = r0.o00();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        IXIxx0.XO.I0Io(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        return kotlin.oXIO0o0XI.f29392oIX0oI;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object oOXoIIIo(kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
        /*
            r5 = this;
            kotlinx.coroutines.x0xO0oo r0 = new kotlinx.coroutines.x0xO0oo
            kotlin.coroutines.I0Io r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.IO()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = oO()
        L11:
            java.lang.Object r2 = r1.get(r5)
            kotlinx.coroutines.internal.x0o r3 = kotlinx.coroutines.selects.SelectKt.xoIox()
            if (r2 != r3) goto L29
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = oO()
            boolean r2 = androidx.concurrent.futures.oIX0oI.oIX0oI(r3, r5, r2, r0)
            if (r2 == 0) goto L11
            r0.ooXIXxIX(r5)
            goto L62
        L29:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = oO()
            kotlinx.coroutines.internal.x0o r4 = kotlinx.coroutines.selects.SelectKt.xoIox()
            boolean r3 = androidx.concurrent.futures.oIX0oI.oIX0oI(r3, r5, r2, r4)
            if (r3 == 0) goto L11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L41:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L11
            java.lang.Object r3 = r2.next()
            IXxxXO(r5, r3)
            goto L41
        L4f:
            boolean r1 = r2 instanceof kotlinx.coroutines.selects.SelectImplementation.oIX0oI
            if (r1 == 0) goto L79
            kotlin.oXIO0o0XI r1 = kotlin.oXIO0o0XI.f29392oIX0oI
            kotlinx.coroutines.selects.SelectImplementation$oIX0oI r2 = (kotlinx.coroutines.selects.SelectImplementation.oIX0oI) r2
            java.lang.Object r3 = x0XOIxOo(r5)
            Oox.oOoXoXO r2 = r2.oIX0oI(r5, r3)
            r0.OxxIIOOXO(r1, r2)
        L62:
            java.lang.Object r0 = r0.o00()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            if (r0 != r1) goto L6f
            IXIxx0.XO.I0Io(r6)
        L6f:
            java.lang.Object r6 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            if (r0 != r6) goto L76
            return r0
        L76:
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        L79:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unexpected state: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.oOXoIIIo(kotlin.coroutines.I0Io):java.lang.Object");
    }

    public final int oo(Object obj, Object obj2) {
        boolean oO2;
        x0o x0oVar;
        boolean z;
        x0o x0oVar2;
        x0o x0oVar3;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30395OxxIIOOXO;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof oO)) {
                x0oVar = SelectKt.f30413Oxx0IOOO;
                if (IIX0o.Oxx0IOOO(obj3, x0oVar)) {
                    z = true;
                } else {
                    z = obj3 instanceof oIX0oI;
                }
                if (!z) {
                    x0oVar2 = SelectKt.f30411II0XooXoX;
                    if (!IIX0o.Oxx0IOOO(obj3, x0oVar2)) {
                        x0oVar3 = SelectKt.f30415XO;
                        if (IIX0o.Oxx0IOOO(obj3, x0oVar3)) {
                            if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj3, oI0IIXIo.OOXIXo(obj))) {
                                return 1;
                            }
                        } else if (obj3 instanceof List) {
                            if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj3, CollectionsKt___CollectionsKt.OIxOIX0II((Collection) obj3, obj))) {
                                return 1;
                            }
                        } else {
                            throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                        }
                    } else {
                        return 2;
                    }
                } else {
                    return 3;
                }
            } else {
                SelectImplementation<R>.oIX0oI X0IIOO2 = X0IIOO(obj);
                if (X0IIOO2 == null) {
                    continue;
                } else {
                    Oox.oOoXoXO<Throwable, oXIO0o0XI> oIX0oI2 = X0IIOO2.oIX0oI(this, obj2);
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj3, X0IIOO2)) {
                        this.f30400oI0IIXIo = obj2;
                        oO2 = SelectKt.oO((oO) obj3, oIX0oI2);
                        if (oO2) {
                            return 0;
                        }
                        this.f30400oI0IIXIo = null;
                        return 2;
                    }
                }
            }
        }
    }

    @OXOo.OOXIXo
    public final TrySelectDetailedResult oo0xXOI0I(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO Object obj2) {
        TrySelectDetailedResult oxoX2;
        oxoX2 = SelectKt.oxoX(oo(obj, obj2));
        return oxoX2;
    }

    @Override // kotlinx.coroutines.selects.II0xO0
    public void oxoX(@OXOo.OOXIXo I0Io i0Io, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oooxoxo) {
        ooXIXxIX(this, new oIX0oI(i0Io.oxoX(), i0Io.I0Io(), i0Io.II0xO0(), SelectKt.oOoXoXO(), oooxoxo, i0Io.oIX0oI()), false, 1, null);
    }

    public final void xI(Object obj) {
        SelectImplementation<R>.oIX0oI X0IIOO2 = X0IIOO(obj);
        IIX0o.ooOOo0oXI(X0IIOO2);
        X0IIOO2.f30404Oxx0IOOO = null;
        X0IIOO2.f30402II0XooXoX = -1;
        IIX0o(X0IIOO2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object xXxxox0I(kotlinx.coroutines.selects.SelectImplementation<R>.oIX0oI r5, java.lang.Object r6, kotlin.coroutines.I0Io<? super R> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.I0oOoX.x0XOIxOo(r7)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.I0oOoX.x0XOIxOo(r7)
            java.lang.Object r6 = r5.oxoX(r6)
            r0.label = r3
            java.lang.Object r7 = r5.I0Io(r6, r0)
            if (r7 != r1) goto L41
            return r1
        L41:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.xXxxox0I(kotlinx.coroutines.selects.SelectImplementation$oIX0oI, java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @Override // kotlinx.coroutines.x0XOIxOo
    public void xoIox(@OXOo.oOoXoXO Throwable th) {
        Object obj;
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30395OxxIIOOXO;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            x0oVar = SelectKt.f30413Oxx0IOOO;
            if (obj != x0oVar) {
                x0oVar2 = SelectKt.f30411II0XooXoX;
            } else {
                return;
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj, x0oVar2));
        List<SelectImplementation<R>.oIX0oI> list = this.f30397Oo;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((oIX0oI) it.next()).II0xO0();
        }
        x0oVar3 = SelectKt.f30419xxIXOIIO;
        this.f30400oI0IIXIo = x0oVar3;
        this.f30397Oo = null;
    }

    public final Object xoXoI(kotlin.coroutines.I0Io<? super R> i0Io) {
        Object obj = f30395OxxIIOOXO.get(this);
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.oIX0oI oix0oi = (oIX0oI) obj;
        Object obj2 = this.f30400oI0IIXIo;
        IIXOooo(oix0oi);
        return oix0oi.I0Io(oix0oi.oxoX(obj2), i0Io);
    }

    @Override // kotlinx.coroutines.selects.xoIox
    public boolean xxIXOIIO(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO Object obj2) {
        if (oo(obj, obj2) == 0) {
            return true;
        }
        return false;
    }
}
