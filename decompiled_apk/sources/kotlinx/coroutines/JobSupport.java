package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.oXIO0o0XI;
import org.apache.commons.lang3.ObjectUtils;

@kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@kotlin.jvm.internal.XX({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1454:1\n706#1,2:1461\n367#1,2:1471\n369#1,4:1476\n373#1,4:1482\n377#1,2:1489\n367#1,2:1491\n369#1,4:1496\n373#1,4:1502\n377#1,2:1509\n178#1,2:1518\n707#1:1520\n178#1,2:1521\n178#1,2:1540\n178#1,2:1555\n706#1,2:1557\n706#1,2:1559\n178#1,2:1561\n706#1,2:1563\n178#1,2:1565\n178#1,2:1572\n178#1,2:1574\n1#2:1455\n1#2:1480\n1#2:1500\n28#3,4:1456\n28#3,4:1523\n28#3,4:1567\n28#3,4:1576\n20#4:1460\n20#4:1527\n20#4:1571\n20#4:1580\n288#5,2:1463\n288#5,2:1465\n19#6:1467\n163#7:1468\n163#7:1469\n153#7,4:1583\n75#8:1470\n75#8:1481\n75#8:1501\n75#8:1514\n341#9,3:1473\n344#9,3:1486\n341#9,3:1493\n344#9,3:1506\n341#9,3:1511\n344#9,3:1515\n47#10:1528\n22#11:1529\n22#11:1530\n13#11:1551\n13#11:1554\n13#11:1581\n13#11:1582\n13#11:1587\n13#11:1588\n134#12:1531\n73#12,3:1532\n135#12,5:1535\n314#13,9:1542\n323#13,2:1552\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n250#1:1461,2\n332#1:1471,2\n332#1:1476,4\n332#1:1482,4\n332#1:1489,2\n364#1:1491,2\n364#1:1496,4\n364#1:1502,4\n364#1:1509,2\n381#1:1518,2\n426#1:1520\n461#1:1521,2\n553#1:1540,2\n594#1:1555,2\n621#1:1557,2\n630#1:1559,2\n694#1:1561,2\n723#1:1563,2\n736#1:1565,2\n809#1:1572,2\n831#1:1574,2\n332#1:1480\n364#1:1500\n213#1:1456,4\n478#1:1523,4\n739#1:1567,4\n884#1:1576,4\n213#1:1460\n478#1:1527\n739#1:1571\n884#1:1580\n261#1:1463,2\n265#1:1465,2\n273#1:1467\n279#1:1468\n281#1:1469\n1218#1:1583,4\n284#1:1470\n332#1:1481\n364#1:1501\n372#1:1514\n332#1:1473,3\n332#1:1486,3\n364#1:1493,3\n364#1:1506,3\n368#1:1511,3\n368#1:1515,3\n483#1:1528\n495#1:1529\n505#1:1530\n561#1:1551\n577#1:1554\n924#1:1581\n974#1:1582\n1237#1:1587\n1259#1:1588\n526#1:1531\n526#1:1532,3\n526#1:1535,5\n559#1:1542,9\n559#1:1552,2\n*E\n"})
/* loaded from: classes6.dex */
public class JobSupport implements oXIO0o0XI, o00, oOoIIO0 {

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _parentHandle;

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _state;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29715XO = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29714Oo = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    @kotlin.jvm.internal.XX({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class I0Io implements ooOx {

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final XIXIxO f29719XO;

        @OXOo.oOoXoXO
        @XO0OX.o00
        private volatile Object _exceptionsHolder;

        @XO0OX.o00
        private volatile int _isCompleting;

        @OXOo.oOoXoXO
        @XO0OX.o00
        private volatile Object _rootCause;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final AtomicIntegerFieldUpdater f29717Oo = AtomicIntegerFieldUpdater.newUpdater(I0Io.class, "_isCompleting");

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final AtomicReferenceFieldUpdater f29716IXxxXO = AtomicReferenceFieldUpdater.newUpdater(I0Io.class, Object.class, "_rootCause");

        /* renamed from: Oxx0xo, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final AtomicReferenceFieldUpdater f29718Oxx0xo = AtomicReferenceFieldUpdater.newUpdater(I0Io.class, Object.class, "_exceptionsHolder");

        public I0Io(@OXOo.OOXIXo XIXIxO xIXIxO, boolean z, @OXOo.oOoXoXO Throwable th) {
            this.f29719XO = xIXIxO;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public final Object I0Io() {
            return f29718Oxx0xo.get(this);
        }

        @OXOo.OOXIXo
        public final List<Throwable> II0XooXoX(@OXOo.oOoXoXO Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.x0o x0oVar;
            Object I0Io2 = I0Io();
            if (I0Io2 == null) {
                arrayList = II0xO0();
            } else if (I0Io2 instanceof Throwable) {
                ArrayList<Throwable> II0xO02 = II0xO0();
                II0xO02.add(I0Io2);
                arrayList = II0xO02;
            } else if (I0Io2 instanceof ArrayList) {
                arrayList = (ArrayList) I0Io2;
            } else {
                throw new IllegalStateException(("State is " + I0Io2).toString());
            }
            Throwable oxoX2 = oxoX();
            if (oxoX2 != null) {
                arrayList.add(0, oxoX2);
            }
            if (th != null && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(th, oxoX2)) {
                arrayList.add(th);
            }
            x0oVar = xI0oxI00.f30472II0XooXoX;
            xoIox(x0oVar);
            return arrayList;
        }

        public final ArrayList<Throwable> II0xO0() {
            return new ArrayList<>(4);
        }

        public final void OOXIXo(@OXOo.oOoXoXO Throwable th) {
            f29716IXxxXO.set(this, th);
        }

        public final boolean Oxx0IOOO() {
            kotlinx.coroutines.internal.x0o x0oVar;
            Object I0Io2 = I0Io();
            x0oVar = xI0oxI00.f30472II0XooXoX;
            if (I0Io2 == x0oVar) {
                return true;
            }
            return false;
        }

        public final boolean X0o0xo() {
            if (oxoX() != null) {
                return true;
            }
            return false;
        }

        public final boolean XO() {
            if (f29717Oo.get(this) != 0) {
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.ooOx
        @OXOo.OOXIXo
        public XIXIxO getList() {
            return this.f29719XO;
        }

        @Override // kotlinx.coroutines.ooOx
        public boolean isActive() {
            if (oxoX() == null) {
                return true;
            }
            return false;
        }

        public final void oIX0oI(@OXOo.OOXIXo Throwable th) {
            Throwable oxoX2 = oxoX();
            if (oxoX2 == null) {
                OOXIXo(th);
                return;
            }
            if (th == oxoX2) {
                return;
            }
            Object I0Io2 = I0Io();
            if (I0Io2 == null) {
                xoIox(th);
                return;
            }
            if (I0Io2 instanceof Throwable) {
                if (th == I0Io2) {
                    return;
                }
                ArrayList<Throwable> II0xO02 = II0xO0();
                II0xO02.add(I0Io2);
                II0xO02.add(th);
                xoIox(II0xO02);
                return;
            }
            if (I0Io2 instanceof ArrayList) {
                ((ArrayList) I0Io2).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + I0Io2).toString());
        }

        @OXOo.oOoXoXO
        public final Throwable oxoX() {
            return (Throwable) f29716IXxxXO.get(this);
        }

        @OXOo.OOXIXo
        public String toString() {
            return "Finishing[cancelling=" + X0o0xo() + ", completing=" + XO() + ", rootCause=" + oxoX() + ", exceptions=" + I0Io() + ", list=" + getList() + ']';
        }

        public final void xoIox(Object obj) {
            f29718Oxx0xo.set(this, obj);
        }

        public final void xxIXOIIO(boolean z) {
            f29717Oo.set(this, z ? 1 : 0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends xx0X0 {

        /* renamed from: IIXOooo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final xoXoI f29720IIXOooo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final I0Io f29721OxxIIOOXO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final JobSupport f29722oI0IIXIo;

        /* renamed from: xoXoI, reason: collision with root package name */
        @OXOo.oOoXoXO
        public final Object f29723xoXoI;

        public II0xO0(@OXOo.OOXIXo JobSupport jobSupport, @OXOo.OOXIXo I0Io i0Io, @OXOo.OOXIXo xoXoI xoxoi, @OXOo.oOoXoXO Object obj) {
            this.f29722oI0IIXIo = jobSupport;
            this.f29721OxxIIOOXO = i0Io;
            this.f29720IIXOooo = xoxoi;
            this.f29723xoXoI = obj;
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
            o00(th);
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }

        @Override // kotlinx.coroutines.xXxxox0I
        public void o00(@OXOo.oOoXoXO Throwable th) {
            this.f29722oI0IIXIo.OO0x0xX(this.f29721OxxIIOOXO, this.f29720IIXOooo, this.f29723xoXoI);
        }
    }

    /* loaded from: classes6.dex */
    public final class X0o0xo extends xx0X0 {

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final kotlinx.coroutines.selects.xoIox<?> f29725oI0IIXIo;

        public X0o0xo(@OXOo.OOXIXo kotlinx.coroutines.selects.xoIox<?> xoiox) {
            this.f29725oI0IIXIo = xoiox;
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
            o00(th);
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }

        @Override // kotlinx.coroutines.xXxxox0I
        public void o00(@OXOo.oOoXoXO Throwable th) {
            this.f29725oI0IIXIo.xxIXOIIO(JobSupport.this, kotlin.oXIO0o0XI.f29392oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,367:1\n526#2:368\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class XO extends LockFreeLinkedListNode.oIX0oI {

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final /* synthetic */ Object f29726X0o0xo;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ JobSupport f29727oxoX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public XO(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.f29727oxoX = jobSupport;
            this.f29726X0o0xo = obj;
        }

        @Override // kotlinx.coroutines.internal.II0xO0
        @OXOo.oOoXoXO
        /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
        public Object X0o0xo(@OXOo.OOXIXo LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f29727oxoX.oXIO0o0XI() == this.f29726X0o0xo) {
                return null;
            }
            return kotlinx.coroutines.internal.o00.oIX0oI();
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> extends x0xO0oo<T> {

        /* renamed from: o00, reason: collision with root package name */
        @OXOo.OOXIXo
        public final JobSupport f29728o00;

        public oIX0oI(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io, @OXOo.OOXIXo JobSupport jobSupport) {
            super(i0Io, 1);
            this.f29728o00 = jobSupport;
        }

        @Override // kotlinx.coroutines.x0xO0oo
        @OXOo.OOXIXo
        public Throwable IIXOooo(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
            Throwable oxoX2;
            Object oXIO0o0XI2 = this.f29728o00.oXIO0o0XI();
            if ((oXIO0o0XI2 instanceof I0Io) && (oxoX2 = ((I0Io) oXIO0o0XI2).oxoX()) != null) {
                return oxoX2;
            }
            if (oXIO0o0XI2 instanceof xxX) {
                return ((xxX) oXIO0o0XI2).f30502oIX0oI;
            }
            return oxio0o0xi.xI();
        }

        @Override // kotlinx.coroutines.x0xO0oo
        @OXOo.OOXIXo
        public String IoOoX() {
            return "AwaitContinuation";
        }
    }

    /* loaded from: classes6.dex */
    public final class oxoX extends xx0X0 {

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final kotlinx.coroutines.selects.xoIox<?> f29730oI0IIXIo;

        public oxoX(@OXOo.OOXIXo kotlinx.coroutines.selects.xoIox<?> xoiox) {
            this.f29730oI0IIXIo = xoiox;
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
            o00(th);
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }

        @Override // kotlinx.coroutines.xXxxox0I
        public void o00(@OXOo.oOoXoXO Throwable th) {
            Object oXIO0o0XI2 = JobSupport.this.oXIO0o0XI();
            if (!(oXIO0o0XI2 instanceof xxX)) {
                oXIO0o0XI2 = xI0oxI00.II0XooXoX(oXIO0o0XI2);
            }
            this.f29730oI0IIXIo.xxIXOIIO(JobSupport.this, oXIO0o0XI2);
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? xI0oxI00.f30479xoIox : xI0oxI00.f30480xxIXOIIO;
    }

    private final void IoIOOxIIo(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, kotlin.oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static /* synthetic */ CancellationException XI(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.XOxxooXI(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public static /* synthetic */ void xX0IIXIx0() {
    }

    public static /* synthetic */ void xoO0xx0() {
    }

    public static /* synthetic */ JobCancellationException xxIO(JobSupport jobSupport, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = jobSupport.IoOoo();
            }
            return new JobCancellationException(str, th, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    public boolean I0() {
        return true;
    }

    public void I0X0x0oIo(@OXOo.oOoXoXO Object obj) {
    }

    public void I0oOIX(@OXOo.OOXIXo Throwable th) {
        O0Xx(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object I0xX0(ooOx ooox, Object obj) {
        I0Io i0Io;
        xxX xxx2;
        kotlinx.coroutines.internal.x0o x0oVar;
        kotlinx.coroutines.internal.x0o x0oVar2;
        kotlinx.coroutines.internal.x0o x0oVar3;
        XIXIxO xOOOX2 = xOOOX(ooox);
        if (xOOOX2 == null) {
            x0oVar3 = xI0oxI00.f30471I0Io;
            return x0oVar3;
        }
        ?? r2 = 0;
        if (ooox instanceof I0Io) {
            i0Io = (I0Io) ooox;
        } else {
            i0Io = null;
        }
        if (i0Io == null) {
            i0Io = new I0Io(xOOOX2, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (i0Io) {
            if (i0Io.XO()) {
                x0oVar2 = xI0oxI00.f30477oIX0oI;
                return x0oVar2;
            }
            i0Io.xxIXOIIO(true);
            if (i0Io != ooox && !androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, ooox, i0Io)) {
                x0oVar = xI0oxI00.f30471I0Io;
                return x0oVar;
            }
            boolean X0o0xo2 = i0Io.X0o0xo();
            if (obj instanceof xxX) {
                xxx2 = (xxX) obj;
            } else {
                xxx2 = null;
            }
            if (xxx2 != null) {
                i0Io.oIX0oI(xxx2.f30502oIX0oI);
            }
            Throwable oxoX2 = i0Io.oxoX();
            if (!X0o0xo2) {
                r2 = oxoX2;
            }
            objectRef.element = r2;
            kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
            if (r2 != 0) {
                IxIX0I(xOOOX2, r2);
            }
            xoXoI o0xxxXXxX2 = o0xxxXXxX(ooox);
            if (o0xxxXXxX2 != null && Oxx(i0Io, o0xxxXXxX2, obj)) {
                return xI0oxI00.f30473II0xO0;
            }
            return XX0xXo(i0Io, obj);
        }
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(IoOoo(), null, this);
        }
        I0oOIX(cancellationException);
    }

    public final void IIX0(@OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        if (oxio0o0xi == null) {
            X0xxXX0(x0OIX00oO.f30462XO);
            return;
        }
        oxio0o0xi.start();
        IIXOooo XI0IXoo2 = oxio0o0xi.XI0IXoo(this);
        X0xxXX0(XI0IXoo2);
        if (isCompleted()) {
            XI0IXoo2.dispose();
            X0xxXX0(x0OIX00oO.f30462XO);
        }
    }

    @OXOo.oOoXoXO
    public final Throwable IIX0o() {
        Object oXIO0o0XI2 = oXIO0o0XI();
        if (!(oXIO0o0XI2 instanceof ooOx)) {
            return OOXIxO0(oXIO0o0XI2);
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    public final Throwable IIxOXoOo0(I0Io i0Io, List<? extends Throwable> list) {
        Object obj;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (!i0Io.X0o0xo()) {
                return null;
            }
            return new JobCancellationException(IoOoo(), null, this);
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public final int IO0XoXxO(Object obj) {
        xoIxX xoixx;
        if (obj instanceof xoIxX) {
            if (((xoIxX) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29715XO;
            xoixx = xI0oxI00.f30479xoIox;
            if (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj, xoixx)) {
                return -1;
            }
            xxOXOOoIX();
            return 1;
        }
        if (!(obj instanceof I0)) {
            return 0;
        }
        if (!androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, obj, ((I0) obj).getList())) {
            return -1;
        }
        xxOXOOoIX();
        return 1;
    }

    @OXOo.OOXIXo
    @OX00O0xII
    public final String IOoo() {
        return x0OIX00oO() + '{' + oXxOI0oIx(oXIO0o0XI()) + '}';
    }

    public final /* synthetic */ <T extends xx0X0> void IXO(XIXIxO xIXIxO, Throwable th) {
        Object OOXIXo2 = xIXIxO.OOXIXo();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) OOXIXo2; !kotlin.jvm.internal.IIX0o.Oxx0IOOO(lockFreeLinkedListNode, xIXIxO); lockFreeLinkedListNode = lockFreeLinkedListNode.oOoXoXO()) {
            kotlin.jvm.internal.IIX0o.OxI(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                xx0X0 xx0x0 = (xx0X0) lockFreeLinkedListNode;
                try {
                    xx0x0.o00(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.oO.oIX0oI(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + xx0x0 + " for " + this, th2);
                        kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            O0X(completionHandlerException);
        }
    }

    @OXOo.OOXIXo
    public String IoOoo() {
        return "Job was cancelled";
    }

    public void IoXIXo(@OXOo.oOoXoXO Object obj) {
    }

    @OXOo.OOXIXo
    public final JobCancellationException Ioxxx(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Throwable th) {
        if (str == null) {
            str = IoOoo();
        }
        return new JobCancellationException(str, th, this);
    }

    public final void Ix00oIoI(kotlinx.coroutines.selects.xoIox<?> xoiox, Object obj) {
        Object oXIO0o0XI2;
        do {
            oXIO0o0XI2 = oXIO0o0XI();
            if (!(oXIO0o0XI2 instanceof ooOx)) {
                if (!(oXIO0o0XI2 instanceof xxX)) {
                    oXIO0o0XI2 = xI0oxI00.II0XooXoX(oXIO0o0XI2);
                }
                xoiox.XO(oXIO0o0XI2);
                return;
            }
        } while (IO0XoXxO(oXIO0o0XI2) < 0);
        xoiox.Oxx0IOOO(Oo(new oxoX(xoiox)));
    }

    public final void IxIX0I(XIXIxO xIXIxO, Throwable th) {
        O0IxXx(th);
        Object OOXIXo2 = xIXIxO.OOXIXo();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) OOXIXo2; !kotlin.jvm.internal.IIX0o.Oxx0IOOO(lockFreeLinkedListNode, xIXIxO); lockFreeLinkedListNode = lockFreeLinkedListNode.oOoXoXO()) {
            if (lockFreeLinkedListNode instanceof oOo) {
                xx0X0 xx0x0 = (xx0X0) lockFreeLinkedListNode;
                try {
                    xx0x0.o00(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.oO.oIX0oI(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + xx0x0 + " for " + this, th2);
                        kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            O0X(completionHandlerException);
        }
        OO(th);
    }

    public boolean O0() {
        return false;
    }

    @OXOo.oOoXoXO
    public final Object O00XxXI() {
        Object oXIO0o0XI2 = oXIO0o0XI();
        if (!(oXIO0o0XI2 instanceof ooOx)) {
            if (!(oXIO0o0XI2 instanceof xxX)) {
                return xI0oxI00.II0XooXoX(oXIO0o0XI2);
            }
            throw ((xxX) oXIO0o0XI2).f30502oIX0oI;
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    public void O0IxXx(@OXOo.oOoXoXO Throwable th) {
    }

    public final boolean O0Xx(@OXOo.oOoXoXO Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.x0o x0oVar;
        kotlinx.coroutines.internal.x0o x0oVar2;
        kotlinx.coroutines.internal.x0o x0oVar3;
        obj2 = xI0oxI00.f30477oIX0oI;
        if (!OX00O0xII() || (obj2 = xoxXI(obj)) != xI0oxI00.f30473II0xO0) {
            x0oVar = xI0oxI00.f30477oIX0oI;
            if (obj2 == x0oVar) {
                obj2 = o0oIxOo(obj);
            }
            x0oVar2 = xI0oxI00.f30477oIX0oI;
            if (obj2 != x0oVar2 && obj2 != xI0oxI00.f30473II0xO0) {
                x0oVar3 = xI0oxI00.f30478oxoX;
                if (obj2 == x0oVar3) {
                    return false;
                }
                I0X0x0oIo(obj2);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public final I0oOIX O0xOxO(boolean z, boolean z2, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        xxX xxx2;
        xx0X0 OIOoIIOIx2 = OIOoIIOIx(oooxoxo, z);
        while (true) {
            Object oXIO0o0XI2 = oXIO0o0XI();
            if (oXIO0o0XI2 instanceof xoIxX) {
                xoIxX xoixx = (xoIxX) oXIO0o0XI2;
                if (xoixx.isActive()) {
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, oXIO0o0XI2, OIOoIIOIx2)) {
                        return OIOoIIOIx2;
                    }
                } else {
                    xXoOI00O(xoixx);
                }
            } else {
                Throwable th = null;
                if (oXIO0o0XI2 instanceof ooOx) {
                    XIXIxO list = ((ooOx) oXIO0o0XI2).getList();
                    if (list == null) {
                        kotlin.jvm.internal.IIX0o.x0XOIxOo(oXIO0o0XI2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        x0OxxIOxX((xx0X0) oXIO0o0XI2);
                    } else {
                        I0oOIX i0oOIX = x0OIX00oO.f30462XO;
                        if (z && (oXIO0o0XI2 instanceof I0Io)) {
                            synchronized (oXIO0o0XI2) {
                                try {
                                    th = ((I0Io) oXIO0o0XI2).oxoX();
                                    if (th != null) {
                                        if ((oooxoxo instanceof xoXoI) && !((I0Io) oXIO0o0XI2).XO()) {
                                        }
                                        kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }
                                    if (xXOx(oXIO0o0XI2, list, OIOoIIOIx2)) {
                                        if (th == null) {
                                            return OIOoIIOIx2;
                                        }
                                        i0oOIX = OIOoIIOIx2;
                                        kotlin.oXIO0o0XI oxio0o0xi2 = kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        if (th != null) {
                            if (z2) {
                                oooxoxo.invoke(th);
                            }
                            return i0oOIX;
                        }
                        if (xXOx(oXIO0o0XI2, list, OIOoIIOIx2)) {
                            return OIOoIIOIx2;
                        }
                    }
                } else {
                    if (z2) {
                        if (oXIO0o0XI2 instanceof xxX) {
                            xxx2 = (xxX) oXIO0o0XI2;
                        } else {
                            xxx2 = null;
                        }
                        if (xxx2 != null) {
                            th = xxx2.f30502oIX0oI;
                        }
                        oooxoxo.invoke(th);
                    }
                    return x0OIX00oO.f30462XO;
                }
            }
        }
    }

    public final xx0X0 OIOoIIOIx(Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo, boolean z) {
        xx0X0 xx0x0 = null;
        if (z) {
            if (oooxoxo instanceof oOo) {
                xx0x0 = (oOo) oooxoxo;
            }
            if (xx0x0 == null) {
                xx0x0 = new xOOOX(oooxoxo);
            }
        } else {
            if (oooxoxo instanceof xx0X0) {
                xx0x0 = (xx0X0) oooxoxo;
            }
            if (xx0x0 == null) {
                xx0x0 = new XIXIX(oooxoxo);
            }
        }
        xx0x0.O0xOxO(this);
        return xx0x0;
    }

    public final boolean OO(Throwable th) {
        if (O0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        IIXOooo XIXIX2 = XIXIX();
        if (XIXIX2 != null && XIXIX2 != x0OIX00oO.f30462XO) {
            if (XIXIX2.XO(th) || z) {
                return true;
            }
            return false;
        }
        return z;
    }

    public final void OO0x0xX(I0Io i0Io, xoXoI xoxoi, Object obj) {
        xoXoI XXoOx02 = XXoOx0(xoxoi);
        if (XXoOx02 != null && Oxx(i0Io, XXoOx02, obj)) {
            return;
        }
        I0X0x0oIo(XX0xXo(i0Io, obj));
    }

    public final Throwable OOXIxO0(Object obj) {
        xxX xxx2;
        if (obj instanceof xxX) {
            xxx2 = (xxX) obj;
        } else {
            xxx2 = null;
        }
        if (xxx2 == null) {
            return null;
        }
        return xxx2.f30502oIX0oI;
    }

    public boolean OX00O0xII() {
        return false;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public final I0oOIX Oo(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        return O0xOxO(false, true, oooxoxo);
    }

    @OXOo.oOoXoXO
    public final Object OoO(@OXOo.oOoXoXO Object obj) {
        Object XXXI2;
        kotlinx.coroutines.internal.x0o x0oVar;
        kotlinx.coroutines.internal.x0o x0oVar2;
        do {
            XXXI2 = XXXI(oXIO0o0XI(), obj);
            x0oVar = xI0oxI00.f30477oIX0oI;
            if (XXXI2 != x0oVar) {
                x0oVar2 = xI0oxI00.f30471I0Io;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, OOXIxO0(obj));
            }
        } while (XXXI2 == x0oVar2);
        return XXXI2;
    }

    public final boolean Ox0O() {
        return oXIO0o0XI() instanceof xxX;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public final kotlinx.coroutines.selects.I0Io OxI() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.INSTANCE;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.oxoX(this, (Oox.IXxxXO) kotlin.jvm.internal.XoX.Oo(jobSupport$onJoin$1, 3), null, 4, null);
    }

    public final boolean Oxx(I0Io i0Io, xoXoI xoxoi, Object obj) {
        while (oXIO0o0XI.oIX0oI.Oxx0IOOO(xoxoi.f30490oI0IIXIo, false, false, new II0xO0(this, i0Io, xoxoi, obj), 1, null) == x0OIX00oO.f30462XO) {
            xoxoi = XXoOx0(xoxoi);
            if (xoxoi == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.o00
    public final void Oxx0IOOO(@OXOo.OOXIXo oOoIIO0 oooiio0) {
        O0Xx(oooiio0);
    }

    public final void X0xII0I(@OXOo.OOXIXo xx0X0 xx0x0) {
        Object oXIO0o0XI2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        xoIxX xoixx;
        do {
            oXIO0o0XI2 = oXIO0o0XI();
            if (oXIO0o0XI2 instanceof xx0X0) {
                if (oXIO0o0XI2 != xx0x0) {
                    return;
                }
                atomicReferenceFieldUpdater = f29715XO;
                xoixx = xI0oxI00.f30479xoIox;
            } else {
                if ((oXIO0o0XI2 instanceof ooOx) && ((ooOx) oXIO0o0XI2).getList() != null) {
                    xx0x0.IXxxXO();
                    return;
                }
                return;
            }
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, oXIO0o0XI2, xoixx));
    }

    public final void X0xxXX0(@OXOo.oOoXoXO IIXOooo iIXOooo) {
        f29714Oo.set(this, iIXOooo);
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public final IIXOooo XI0IXoo(@OXOo.OOXIXo o00 o00Var) {
        I0oOIX Oxx0IOOO2 = oXIO0o0XI.oIX0oI.Oxx0IOOO(this, true, false, new xoXoI(o00Var), 2, null);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(Oxx0IOOO2, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (IIXOooo) Oxx0IOOO2;
    }

    public final boolean XI0oooXX() {
        Object oXIO0o0XI2 = oXIO0o0XI();
        if ((oXIO0o0XI2 instanceof xxX) && ((xxX) oXIO0o0XI2).oIX0oI()) {
            return true;
        }
        return false;
    }

    @OXOo.oOoXoXO
    public final IIXOooo XIXIX() {
        return (IIXOooo) f29714Oo.get(this);
    }

    public final boolean XIXIxO(@OXOo.oOoXoXO Object obj) {
        Object XXXI2;
        kotlinx.coroutines.internal.x0o x0oVar;
        kotlinx.coroutines.internal.x0o x0oVar2;
        do {
            XXXI2 = XXXI(oXIO0o0XI(), obj);
            x0oVar = xI0oxI00.f30477oIX0oI;
            if (XXXI2 == x0oVar) {
                return false;
            }
            if (XXXI2 != xI0oxI00.f30473II0xO0) {
                x0oVar2 = xI0oxI00.f30471I0Io;
            } else {
                return true;
            }
        } while (XXXI2 == x0oVar2);
        I0X0x0oIo(XXXI2);
        return true;
    }

    public final Throwable XIo0oOXIx(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof Throwable;
        }
        if (z) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(IoOoo(), null, this);
            }
            return th;
        }
        kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((oOoIIO0) obj).oo();
    }

    @OXOo.OOXIXo
    public final CancellationException XOxxooXI(@OXOo.OOXIXo Throwable th, @OXOo.oOoXoXO String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = IoOoo();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    public final void XX0(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                kotlin.oO.oIX0oI(th, th2);
            }
        }
    }

    public final Object XX0xXo(I0Io i0Io, Object obj) {
        xxX xxx2;
        Throwable th;
        boolean X0o0xo2;
        Throwable IIxOXoOo02;
        if (obj instanceof xxX) {
            xxx2 = (xxX) obj;
        } else {
            xxx2 = null;
        }
        if (xxx2 != null) {
            th = xxx2.f30502oIX0oI;
        } else {
            th = null;
        }
        synchronized (i0Io) {
            X0o0xo2 = i0Io.X0o0xo();
            List<Throwable> II0XooXoX2 = i0Io.II0XooXoX(th);
            IIxOXoOo02 = IIxOXoOo0(i0Io, II0XooXoX2);
            if (IIxOXoOo02 != null) {
                XX0(IIxOXoOo02, II0XooXoX2);
            }
        }
        if (IIxOXoOo02 != null && IIxOXoOo02 != th) {
            obj = new xxX(IIxOXoOo02, false, 2, null);
        }
        if (IIxOXoOo02 != null && (OO(IIxOXoOo02) || oOo(IIxOXoOo02))) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((xxX) obj).II0xO0();
        }
        if (!X0o0xo2) {
            O0IxXx(IIxOXoOo02);
        }
        IoXIXo(obj);
        androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, i0Io, xI0oxI00.Oxx0IOOO(obj));
        x0xO(i0Io, obj);
        return obj;
    }

    public final Object XXXI(Object obj, Object obj2) {
        kotlinx.coroutines.internal.x0o x0oVar;
        kotlinx.coroutines.internal.x0o x0oVar2;
        if (!(obj instanceof ooOx)) {
            x0oVar2 = xI0oxI00.f30477oIX0oI;
            return x0oVar2;
        }
        if (((obj instanceof xoIxX) || (obj instanceof xx0X0)) && !(obj instanceof xoXoI) && !(obj2 instanceof xxX)) {
            if (!oIIxXoo((ooOx) obj, obj2)) {
                x0oVar = xI0oxI00.f30471I0Io;
                return x0oVar;
            }
            return obj2;
        }
        return I0xX0((ooOx) obj, obj2);
    }

    public final xoXoI XXoOx0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.x0XOIxOo()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.ooOOo0oXI();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.oOoXoXO();
            if (!lockFreeLinkedListNode.x0XOIxOo()) {
                if (lockFreeLinkedListNode instanceof xoXoI) {
                    return (xoXoI) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof XIXIxO) {
                    return null;
                }
            }
        }
    }

    public final Object Xo0(kotlin.coroutines.I0Io<Object> i0Io) {
        oIX0oI oix0oi = new oIX0oI(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), this);
        oix0oi.IO();
        Oxx0xo.oIX0oI(oix0oi, Oo(new IXO(oix0oi)));
        Object o002 = oix0oi.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return o002;
    }

    public final boolean XoI0Ixx0(@OXOo.oOoXoXO Throwable th) {
        return O0Xx(th);
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        oXIO0o0XI.oIX0oI.oIX0oI(this);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> x0xo0oo) {
        return (R) oXIO0o0XI.oIX0oI.oxoX(this, r, x0xo0oo);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OXOo.OOXIXo CoroutineContext.II0xO0<E> iI0xO0) {
        return (E) oXIO0o0XI.oIX0oI.X0o0xo(this, iI0xO0);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI
    @OXOo.OOXIXo
    public final CoroutineContext.II0xO0<?> getKey() {
        return oXIO0o0XI.f30343xxIXOIIO;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.oOoXoXO
    public oXIO0o0XI getParent() {
        IIXOooo XIXIX2 = XIXIX();
        if (XIXIX2 != null) {
            return XIXIX2.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public boolean isActive() {
        Object oXIO0o0XI2 = oXIO0o0XI();
        if ((oXIO0o0XI2 instanceof ooOx) && ((ooOx) oXIO0o0XI2).isActive()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public final boolean isCancelled() {
        Object oXIO0o0XI2 = oXIO0o0XI();
        if (!(oXIO0o0XI2 instanceof xxX) && (!(oXIO0o0XI2 instanceof I0Io) || !((I0Io) oXIO0o0XI2).X0o0xo())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public final boolean isCompleted() {
        return !(oXIO0o0XI() instanceof ooOx);
    }

    @Override // kotlin.coroutines.CoroutineContext.oIX0oI, kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext minusKey(@OXOo.OOXIXo CoroutineContext.II0xO0<?> iI0xO0) {
        return oXIO0o0XI.oIX0oI.II0XooXoX(this, iI0xO0);
    }

    public final Object o0oIxOo(Object obj) {
        kotlinx.coroutines.internal.x0o x0oVar;
        kotlinx.coroutines.internal.x0o x0oVar2;
        kotlinx.coroutines.internal.x0o x0oVar3;
        kotlinx.coroutines.internal.x0o x0oVar4;
        kotlinx.coroutines.internal.x0o x0oVar5;
        kotlinx.coroutines.internal.x0o x0oVar6;
        Throwable th = null;
        Throwable th2 = null;
        while (true) {
            Object oXIO0o0XI2 = oXIO0o0XI();
            if (oXIO0o0XI2 instanceof I0Io) {
                synchronized (oXIO0o0XI2) {
                    if (((I0Io) oXIO0o0XI2).Oxx0IOOO()) {
                        x0oVar2 = xI0oxI00.f30478oxoX;
                        return x0oVar2;
                    }
                    boolean X0o0xo2 = ((I0Io) oXIO0o0XI2).X0o0xo();
                    if (obj != null || !X0o0xo2) {
                        if (th2 == null) {
                            th2 = XIo0oOXIx(obj);
                        }
                        ((I0Io) oXIO0o0XI2).oIX0oI(th2);
                    }
                    Throwable oxoX2 = ((I0Io) oXIO0o0XI2).oxoX();
                    if (!X0o0xo2) {
                        th = oxoX2;
                    }
                    if (th != null) {
                        IxIX0I(((I0Io) oXIO0o0XI2).getList(), th);
                    }
                    x0oVar = xI0oxI00.f30477oIX0oI;
                    return x0oVar;
                }
            }
            if (!(oXIO0o0XI2 instanceof ooOx)) {
                x0oVar3 = xI0oxI00.f30478oxoX;
                return x0oVar3;
            }
            if (th2 == null) {
                th2 = XIo0oOXIx(obj);
            }
            ooOx ooox = (ooOx) oXIO0o0XI2;
            if (ooox.isActive()) {
                if (oXX0IoI(ooox, th2)) {
                    x0oVar4 = xI0oxI00.f30477oIX0oI;
                    return x0oVar4;
                }
            } else {
                Object XXXI2 = XXXI(oXIO0o0XI2, new xxX(th2, false, 2, null));
                x0oVar5 = xI0oxI00.f30477oIX0oI;
                if (XXXI2 != x0oVar5) {
                    x0oVar6 = xI0oxI00.f30471I0Io;
                    if (XXXI2 != x0oVar6) {
                        return XXXI2;
                    }
                } else {
                    throw new IllegalStateException(("Cannot happen in " + oXIO0o0XI2).toString());
                }
            }
        }
    }

    public final xoXoI o0xxxXXxX(ooOx ooox) {
        xoXoI xoxoi;
        if (ooox instanceof xoXoI) {
            xoxoi = (xoXoI) ooox;
        } else {
            xoxoi = null;
        }
        if (xoxoi == null) {
            XIXIxO list = ooox.getList();
            if (list == null) {
                return null;
            }
            return XXoOx0(list);
        }
        return xoxoi;
    }

    public final Object oI(Object obj, Object obj2) {
        if (!(obj2 instanceof xxX)) {
            return obj2;
        }
        throw ((xxX) obj2).f30502oIX0oI;
    }

    public final boolean oIIxXoo(ooOx ooox, Object obj) {
        if (!androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, ooox, xI0oxI00.Oxx0IOOO(obj))) {
            return false;
        }
        O0IxXx(null);
        IoXIXo(obj);
        x0xO(ooox, obj);
        return true;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean oIX0oI(Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = XI(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(IoOoo(), null, this);
        }
        I0oOIX(jobCancellationException);
        return true;
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.oOoXoXO
    public final Object oOXoIIIo(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        if (!xx0X0()) {
            IIX0.O0xOxO(i0Io.getContext());
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }
        Object xI0oxI002 = xI0oxI00(i0Io);
        if (xI0oxI002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return xI0oxI002;
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    public boolean oOo(@OXOo.OOXIXo Throwable th) {
        return false;
    }

    public final void oOoIIO0(XIXIxO xIXIxO, Throwable th) {
        Object OOXIXo2 = xIXIxO.OOXIXo();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(OOXIXo2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) OOXIXo2; !kotlin.jvm.internal.IIX0o.Oxx0IOOO(lockFreeLinkedListNode, xIXIxO); lockFreeLinkedListNode = lockFreeLinkedListNode.oOoXoXO()) {
            if (lockFreeLinkedListNode instanceof xx0X0) {
                xx0X0 xx0x0 = (xx0X0) lockFreeLinkedListNode;
                try {
                    xx0x0.o00(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.oO.oIX0oI(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + xx0x0 + " for " + this, th2);
                        kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            O0X(completionHandlerException);
        }
    }

    @OXOo.oOoXoXO
    public final Object oX(@OXOo.OOXIXo kotlin.coroutines.I0Io<Object> i0Io) {
        Object oXIO0o0XI2;
        do {
            oXIO0o0XI2 = oXIO0o0XI();
            if (!(oXIO0o0XI2 instanceof ooOx)) {
                if (!(oXIO0o0XI2 instanceof xxX)) {
                    return xI0oxI00.II0XooXoX(oXIO0o0XI2);
                }
                throw ((xxX) oXIO0o0XI2).f30502oIX0oI;
            }
        } while (IO0XoXxO(oXIO0o0XI2) < 0);
        return Xo0(i0Io);
    }

    @OXOo.oOoXoXO
    public final Object oXIO0o0XI() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29715XO;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof kotlinx.coroutines.internal.xI)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.xI) obj).II0xO0(this);
        }
    }

    public final boolean oXX0IoI(ooOx ooox, Throwable th) {
        XIXIxO xOOOX2 = xOOOX(ooox);
        if (xOOOX2 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, ooox, new I0Io(xOOOX2, false, th))) {
            return false;
        }
        IxIX0I(xOOOX2, th);
        return true;
    }

    public final String oXxOI0oIx(Object obj) {
        if (obj instanceof I0Io) {
            I0Io i0Io = (I0Io) obj;
            if (i0Io.X0o0xo()) {
                return "Cancelling";
            }
            if (!i0Io.XO()) {
                return "Active";
            }
            return "Completing";
        }
        if (obj instanceof ooOx) {
            if (((ooOx) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
        if (obj instanceof xxX) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.oOoIIO0
    @OXOo.OOXIXo
    public CancellationException oo() {
        CancellationException cancellationException;
        Object oXIO0o0XI2 = oXIO0o0XI();
        CancellationException cancellationException2 = null;
        if (oXIO0o0XI2 instanceof I0Io) {
            cancellationException = ((I0Io) oXIO0o0XI2).oxoX();
        } else if (oXIO0o0XI2 instanceof xxX) {
            cancellationException = ((xxX) oXIO0o0XI2).f30502oIX0oI;
        } else if (!(oXIO0o0XI2 instanceof ooOx)) {
            cancellationException = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + oXIO0o0XI2).toString());
        }
        if (cancellationException instanceof CancellationException) {
            cancellationException2 = cancellationException;
        }
        if (cancellationException2 == null) {
            return new JobCancellationException("Parent job is " + oXxOI0oIx(oXIO0o0XI2), cancellationException, this);
        }
        return cancellationException2;
    }

    @OXOo.OOXIXo
    public final kotlinx.coroutines.selects.X0o0xo<?> ooOx() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.INSTANCE;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Oox.IXxxXO iXxxXO = (Oox.IXxxXO) kotlin.jvm.internal.XoX.Oo(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.INSTANCE;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.XO(this, iXxxXO, (Oox.IXxxXO) kotlin.jvm.internal.XoX.Oo(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    @OXOo.oOoXoXO
    public final Throwable ox() {
        Object oXIO0o0XI2 = oXIO0o0XI();
        if (oXIO0o0XI2 instanceof I0Io) {
            Throwable oxoX2 = ((I0Io) oXIO0o0XI2).oxoX();
            if (oxoX2 == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            return oxoX2;
        }
        if (!(oXIO0o0XI2 instanceof ooOx)) {
            if (oXIO0o0XI2 instanceof xxX) {
                return ((xxX) oXIO0o0XI2).f30502oIX0oI;
            }
            return null;
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final Void oxIIX0o(Oox.oOoXoXO<Object, kotlin.oXIO0o0XI> oooxoxo) {
        while (true) {
            oooxoxo.invoke(oXIO0o0XI());
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OXOo.OOXIXo
    public CoroutineContext plus(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        return oXIO0o0XI.oIX0oI.xxIXOIIO(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    public final boolean start() {
        int IO0XoXxO2;
        do {
            IO0XoXxO2 = IO0XoXxO(oXIO0o0XI());
            if (IO0XoXxO2 == 0) {
                return false;
            }
        } while (IO0XoXxO2 != 1);
        return true;
    }

    @OXOo.OOXIXo
    public String toString() {
        return IOoo() + ObjectUtils.f32506oIX0oI + OI0.II0xO0(this);
    }

    public final void x0(kotlinx.coroutines.selects.xoIox<?> xoiox, Object obj) {
        if (!xx0X0()) {
            xoiox.XO(kotlin.oXIO0o0XI.f29392oIX0oI);
        } else {
            xoiox.Oxx0IOOO(Oo(new X0o0xo(xoiox)));
        }
    }

    @OXOo.OOXIXo
    public String x0OIX00oO() {
        return OI0.oIX0oI(this);
    }

    public final void x0OxxIOxX(xx0X0 xx0x0) {
        xx0x0.Oxx0IOOO(new XIXIxO());
        androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, xx0x0, xx0x0.oOoXoXO());
    }

    public final void x0xO(ooOx ooox, Object obj) {
        xxX xxx2;
        IIXOooo XIXIX2 = XIXIX();
        if (XIXIX2 != null) {
            XIXIX2.dispose();
            X0xxXX0(x0OIX00oO.f30462XO);
        }
        Throwable th = null;
        if (obj instanceof xxX) {
            xxx2 = (xxX) obj;
        } else {
            xxx2 = null;
        }
        if (xxx2 != null) {
            th = xxx2.f30502oIX0oI;
        }
        if (ooox instanceof xx0X0) {
            try {
                ((xx0X0) ooox).o00(th);
                return;
            } catch (Throwable th2) {
                O0X(new CompletionHandlerException("Exception in completion handler " + ooox + " for " + this, th2));
                return;
            }
        }
        XIXIxO list = ooox.getList();
        if (list != null) {
            oOoIIO0(list, th);
        }
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public final CancellationException xI() {
        Object oXIO0o0XI2 = oXIO0o0XI();
        if (oXIO0o0XI2 instanceof I0Io) {
            Throwable oxoX2 = ((I0Io) oXIO0o0XI2).oxoX();
            if (oxoX2 != null) {
                CancellationException XOxxooXI2 = XOxxooXI(oxoX2, OI0.oIX0oI(this) + " is cancelling");
                if (XOxxooXI2 != null) {
                    return XOxxooXI2;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(oXIO0o0XI2 instanceof ooOx)) {
            if (oXIO0o0XI2 instanceof xxX) {
                return XI(this, ((xxX) oXIO0o0XI2).f30502oIX0oI, null, 1, null);
            }
            return new JobCancellationException(OI0.oIX0oI(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final Object xI0oxI00(kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        Oxx0xo.oIX0oI(x0xo0oo, Oo(new oI(x0xo0oo)));
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return o002;
        }
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    public final XIXIxO xOOOX(ooOx ooox) {
        XIXIxO list = ooox.getList();
        if (list == null) {
            if (ooox instanceof xoIxX) {
                return new XIXIxO();
            }
            if (ooox instanceof xx0X0) {
                x0OxxIOxX((xx0X0) ooox);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + ooox).toString());
        }
        return list;
    }

    public final boolean xOoOIoI(ooOx ooox) {
        if ((ooox instanceof I0Io) && ((I0Io) ooox).X0o0xo()) {
            return true;
        }
        return false;
    }

    public final boolean xXOx(Object obj, XIXIxO xIXIxO, xx0X0 xx0x0) {
        int IIXOooo2;
        XO xo2 = new XO(xx0x0, this, obj);
        do {
            IIXOooo2 = xIXIxO.ooOOo0oXI().IIXOooo(xx0x0, xIXIxO, xo2);
            if (IIXOooo2 == 1) {
                return true;
            }
        } while (IIXOooo2 != 2);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.I0] */
    public final void xXoOI00O(xoIxX xoixx) {
        XIXIxO xIXIxO = new XIXIxO();
        if (!xoixx.isActive()) {
            xIXIxO = new I0(xIXIxO);
        }
        androidx.concurrent.futures.oIX0oI.oIX0oI(f29715XO, this, xoixx, xIXIxO);
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @OXOo.OOXIXo
    public final kotlin.sequences.ooOOo0oXI<oXIO0o0XI> xXxxox0I() {
        return kotlin.sequences.IXxxXO.II0xO0(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @OXOo.OOXIXo
    public oXIO0o0XI xoIox(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        return oXIO0o0XI.oIX0oI.xoIox(this, oxio0o0xi);
    }

    public boolean xoIxX(@OXOo.OOXIXo Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (O0Xx(th) && I0()) {
            return true;
        }
        return false;
    }

    public final Object xoxXI(Object obj) {
        kotlinx.coroutines.internal.x0o x0oVar;
        Object XXXI2;
        kotlinx.coroutines.internal.x0o x0oVar2;
        do {
            Object oXIO0o0XI2 = oXIO0o0XI();
            if (!(oXIO0o0XI2 instanceof ooOx) || ((oXIO0o0XI2 instanceof I0Io) && ((I0Io) oXIO0o0XI2).XO())) {
                x0oVar = xI0oxI00.f30477oIX0oI;
                return x0oVar;
            }
            XXXI2 = XXXI(oXIO0o0XI2, new xxX(XIo0oOXIx(obj), false, 2, null));
            x0oVar2 = xI0oxI00.f30471I0Io;
        } while (XXXI2 == x0oVar2);
        return XXXI2;
    }

    public final boolean xx0X0() {
        Object oXIO0o0XI2;
        do {
            oXIO0o0XI2 = oXIO0o0XI();
            if (!(oXIO0o0XI2 instanceof ooOx)) {
                return false;
            }
        } while (IO0XoXxO(oXIO0o0XI2) < 0);
        return true;
    }

    public void xxOXOOoIX() {
    }

    public void O0X(@OXOo.OOXIXo Throwable th) {
        throw th;
    }
}
