package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.I0oOIX;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.x0o;

@XX({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
/* loaded from: classes6.dex */
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.oIX0oI<x0xO0oo> implements xxIXOIIO<T>, kotlinx.coroutines.flow.oIX0oI<T>, kotlinx.coroutines.flow.internal.xxIXOIIO<T> {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final BufferOverflow f30132IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f30133O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public long f30134OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final int f30135OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f30136X0IIOO;

    /* renamed from: o00, reason: collision with root package name */
    public long f30137o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final int f30138oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object[] f30139xoXoI;

    /* loaded from: classes6.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f30140oIX0oI;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f30140oIX0oI = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements I0oOIX {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @XO0OX.XO
        @OXOo.oOoXoXO
        public final Object f30141IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @XO0OX.XO
        public long f30142Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        @OXOo.OOXIXo
        @XO0OX.XO
        public final kotlin.coroutines.I0Io<oXIO0o0XI> f30143Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        @XO0OX.XO
        public final SharedFlowImpl<?> f30144XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(@OXOo.OOXIXo SharedFlowImpl<?> sharedFlowImpl, long j, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
            this.f30144XO = sharedFlowImpl;
            this.f30142Oo = j;
            this.f30141IXxxXO = obj;
            this.f30143Oxx0xo = i0Io;
        }

        @Override // kotlinx.coroutines.I0oOIX
        public void dispose() {
            this.f30144XO.XI0IXoo(this);
        }
    }

    public SharedFlowImpl(int i, int i2, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        this.f30138oI0IIXIo = i;
        this.f30135OxxIIOOXO = i2;
        this.f30132IIXOooo = bufferOverflow;
    }

    public static /* synthetic */ void IO() {
    }

    public static /* synthetic */ <T> Object xI(SharedFlowImpl<T> sharedFlowImpl, T t, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        if (sharedFlowImpl.I0Io(t)) {
            return oXIO0o0XI.f29392oIX0oI;
        }
        Object oo0xXOI0I2 = sharedFlowImpl.oo0xXOI0I(t, i0Io);
        if (oo0xXOI0I2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return oo0xXOI0I2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:41|42))(1:43)|12|13|14|15|(3:16|(3:28|29|(2:31|32)(1:33))(4:18|(1:20)|21|(2:23|24)(1:26))|27))(4:44|45|46|47)|37|38)(5:53|54|55|(2:57|(1:59))|61)|48|49|15|(3:16|(0)(0)|27)))|64|6|(0)(0)|48|49|15|(3:16|(0)(0)|27)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
    
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <T> java.lang.Object xxX(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.XO<? super T> r9, kotlin.coroutines.I0Io<?> r10) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.xxX(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.XO, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.xxIXOIIO
    public boolean I0Io(T t) {
        int i;
        boolean z;
        kotlin.coroutines.I0Io<oXIO0o0XI>[] i0IoArr = kotlinx.coroutines.flow.internal.II0xO0.f30183oIX0oI;
        synchronized (this) {
            if (o0(t)) {
                i0IoArr = IoOoX(i0IoArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (kotlin.coroutines.I0Io<oXIO0o0XI> i0Io : i0IoArr) {
            if (i0Io != null) {
                Result.oIX0oI oix0oi = Result.Companion;
                i0Io.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
            }
        }
        return z;
    }

    public final long I0oOoX(x0xO0oo x0xo0oo) {
        long j = x0xo0oo.f30211oIX0oI;
        if (j < oOXoIIIo()) {
            return j;
        }
        if (this.f30135OxxIIOOXO > 0 || j > Xx000oIo() || this.f30136X0IIOO == 0) {
            return -1L;
        }
        return j;
    }

    @Override // kotlinx.coroutines.flow.xxIXOIIO
    public void II0xO0() {
        synchronized (this) {
            XoX(oOXoIIIo(), this.f30134OxI, oOXoIIIo(), x0o());
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    @Override // kotlinx.coroutines.flow.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: IIX0o, reason: merged with bridge method [inline-methods] */
    public x0xO0oo[] xoIox(int i) {
        return new x0xO0oo[i];
    }

    public final Object[] Io(Object[] objArr, int i, int i2) {
        if (i2 > 0) {
            Object[] objArr2 = new Object[i2];
            this.f30139xoXoI = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long Xx000oIo2 = Xx000oIo();
            for (int i3 = 0; i3 < i; i3++) {
                long j = i3 + Xx000oIo2;
                oO.oxoX(objArr2, j, oO.I0Io(objArr, j));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    public final kotlin.coroutines.I0Io<oXIO0o0XI>[] IoOoX(kotlin.coroutines.I0Io<oXIO0o0XI>[] i0IoArr) {
        kotlinx.coroutines.flow.internal.I0Io[] Oxx0IOOO2;
        x0xO0oo x0xo0oo;
        kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io;
        int length = i0IoArr.length;
        if (kotlinx.coroutines.flow.internal.oIX0oI.XO(this) != 0 && (Oxx0IOOO2 = kotlinx.coroutines.flow.internal.oIX0oI.Oxx0IOOO(this)) != null) {
            int length2 = Oxx0IOOO2.length;
            int i = 0;
            i0IoArr = i0IoArr;
            while (i < length2) {
                kotlinx.coroutines.flow.internal.I0Io i0Io2 = Oxx0IOOO2[i];
                if (i0Io2 != null && (i0Io = (x0xo0oo = (x0xO0oo) i0Io2).f30210II0xO0) != null && I0oOoX(x0xo0oo) >= 0) {
                    int length3 = i0IoArr.length;
                    i0IoArr = i0IoArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(i0IoArr, Math.max(2, i0IoArr.length * 2));
                        IIX0o.oO(copyOf, "copyOf(this, newSize)");
                        i0IoArr = copyOf;
                    }
                    i0IoArr[length] = i0Io;
                    x0xo0oo.f30210II0xO0 = null;
                    length++;
                }
                i++;
                i0IoArr = i0IoArr;
            }
        }
        return i0IoArr;
    }

    public final int OI0() {
        return this.f30133O0xOxO + this.f30136X0IIOO;
    }

    public final T X00IoxXI() {
        Object[] objArr = this.f30139xoXoI;
        IIX0o.ooOOo0oXI(objArr);
        return (T) oO.I0Io(objArr, (this.f30137o00 + XOxIOxOx()) - 1);
    }

    public final Object X0IIOO(x0xO0oo x0xo0oo, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        oXIO0o0XI oxio0o0xi;
        kotlinx.coroutines.x0xO0oo x0xo0oo2 = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo2.IO();
        synchronized (this) {
            try {
                if (I0oOoX(x0xo0oo) < 0) {
                    x0xo0oo.f30210II0xO0 = x0xo0oo2;
                } else {
                    Result.oIX0oI oix0oi = Result.Companion;
                    x0xo0oo2.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
                }
                oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object o002 = x0xo0oo2.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return o002;
        }
        return oxio0o0xi;
    }

    @Override // kotlinx.coroutines.flow.internal.xxIXOIIO
    @OXOo.OOXIXo
    public X0o0xo<T> X0o0xo(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return oO.X0o0xo(this, coroutineContext, i, bufferOverflow);
    }

    public final void XI0IXoo(oIX0oI oix0oi) {
        synchronized (this) {
            if (oix0oi.f30142Oo < Xx000oIo()) {
                return;
            }
            Object[] objArr = this.f30139xoXoI;
            IIX0o.ooOOo0oXI(objArr);
            if (oO.I0Io(objArr, oix0oi.f30142Oo) != oix0oi) {
                return;
            }
            oO.oxoX(objArr, oix0oi.f30142Oo, oO.f30205oIX0oI);
            XIxXXX0x0();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    public final void XIxXXX0x0() {
        if (this.f30135OxxIIOOXO == 0 && this.f30136X0IIOO <= 1) {
            return;
        }
        Object[] objArr = this.f30139xoXoI;
        IIX0o.ooOOo0oXI(objArr);
        while (this.f30136X0IIOO > 0 && oO.I0Io(objArr, (Xx000oIo() + OI0()) - 1) == oO.f30205oIX0oI) {
            this.f30136X0IIOO--;
            oO.oxoX(objArr, Xx000oIo() + OI0(), null);
        }
    }

    public final int XOxIOxOx() {
        return (int) ((Xx000oIo() + this.f30133O0xOxO) - this.f30137o00);
    }

    public final boolean XX(T t) {
        if (this.f30138oI0IIXIo == 0) {
            return true;
        }
        oo(t);
        int i = this.f30133O0xOxO + 1;
        this.f30133O0xOxO = i;
        if (i > this.f30138oI0IIXIo) {
            ooXIXxIX();
        }
        this.f30134OxI = Xx000oIo() + this.f30133O0xOxO;
        return true;
    }

    public final void XoX(long j, long j2, long j3, long j4) {
        long min = Math.min(j2, j);
        for (long Xx000oIo2 = Xx000oIo(); Xx000oIo2 < min; Xx000oIo2++) {
            Object[] objArr = this.f30139xoXoI;
            IIX0o.ooOOo0oXI(objArr);
            oO.oxoX(objArr, Xx000oIo2, null);
        }
        this.f30137o00 = j;
        this.f30134OxI = j2;
        this.f30133O0xOxO = (int) (j3 - min);
        this.f30136X0IIOO = (int) (j4 - j3);
    }

    public final long Xx000oIo() {
        return Math.min(this.f30134OxI, this.f30137o00);
    }

    public final void XxX0x0xxx(long j) {
        kotlinx.coroutines.flow.internal.I0Io[] Oxx0IOOO2;
        if (kotlinx.coroutines.flow.internal.oIX0oI.XO(this) != 0 && (Oxx0IOOO2 = kotlinx.coroutines.flow.internal.oIX0oI.Oxx0IOOO(this)) != null) {
            for (kotlinx.coroutines.flow.internal.I0Io i0Io : Oxx0IOOO2) {
                if (i0Io != null) {
                    x0xO0oo x0xo0oo = (x0xO0oo) i0Io;
                    long j2 = x0xo0oo.f30211oIX0oI;
                    if (j2 >= 0 && j2 < j) {
                        x0xo0oo.f30211oIX0oI = j;
                    }
                }
            }
        }
        this.f30134OxI = j;
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo, kotlinx.coroutines.flow.X0o0xo
    @OXOo.oOoXoXO
    public Object collect(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        return xxX(this, xo2, i0Io);
    }

    @Override // kotlinx.coroutines.flow.xxIXOIIO, kotlinx.coroutines.flow.XO
    @OXOo.oOoXoXO
    public Object emit(T t, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return xI(this, t, i0Io);
    }

    public final boolean o0(T t) {
        if (ooOOo0oXI() == 0) {
            return XX(t);
        }
        if (this.f30133O0xOxO >= this.f30135OxxIIOOXO && this.f30134OxI <= this.f30137o00) {
            int i = II0xO0.f30140oIX0oI[this.f30132IIXOooo.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        oo(t);
        int i2 = this.f30133O0xOxO + 1;
        this.f30133O0xOxO = i2;
        if (i2 > this.f30135OxxIIOOXO) {
            ooXIXxIX();
        }
        if (XOxIOxOx() > this.f30138oI0IIXIo) {
            XoX(this.f30137o00 + 1, this.f30134OxI, oOXoIIIo(), x0o());
        }
        return true;
    }

    @Override // kotlinx.coroutines.flow.x0XOIxOo
    @OXOo.OOXIXo
    public List<T> oIX0oI() {
        synchronized (this) {
            int XOxIOxOx2 = XOxIOxOx();
            if (XOxIOxOx2 == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            ArrayList arrayList = new ArrayList(XOxIOxOx2);
            Object[] objArr = this.f30139xoXoI;
            IIX0o.ooOOo0oXI(objArr);
            for (int i = 0; i < XOxIOxOx2; i++) {
                arrayList.add(oO.I0Io(objArr, this.f30137o00 + i));
            }
            return arrayList;
        }
    }

    public final long oOXoIIIo() {
        return Xx000oIo() + this.f30133O0xOxO;
    }

    public final void oo(Object obj) {
        int OI02 = OI0();
        Object[] objArr = this.f30139xoXoI;
        if (objArr == null) {
            objArr = Io(null, 0, 2);
        } else if (OI02 >= objArr.length) {
            objArr = Io(objArr, OI02, objArr.length * 2);
        }
        oO.oxoX(objArr, Xx000oIo() + OI02, obj);
    }

    public final Object oo0xXOI0I(T t, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        kotlin.coroutines.I0Io<oXIO0o0XI>[] i0IoArr;
        oIX0oI oix0oi;
        kotlinx.coroutines.x0xO0oo x0xo0oo = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        kotlin.coroutines.I0Io<oXIO0o0XI>[] i0IoArr2 = kotlinx.coroutines.flow.internal.II0xO0.f30183oIX0oI;
        synchronized (this) {
            try {
                if (o0(t)) {
                    Result.oIX0oI oix0oi2 = Result.Companion;
                    x0xo0oo.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
                    i0IoArr = IoOoX(i0IoArr2);
                    oix0oi = null;
                } else {
                    oIX0oI oix0oi3 = new oIX0oI(this, OI0() + Xx000oIo(), t, x0xo0oo);
                    oo(oix0oi3);
                    this.f30136X0IIOO++;
                    if (this.f30135OxxIIOOXO == 0) {
                        i0IoArr2 = IoOoX(i0IoArr2);
                    }
                    i0IoArr = i0IoArr2;
                    oix0oi = oix0oi3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (oix0oi != null) {
            kotlinx.coroutines.Oxx0xo.oIX0oI(x0xo0oo, oix0oi);
        }
        for (kotlin.coroutines.I0Io<oXIO0o0XI> i0Io2 : i0IoArr) {
            if (i0Io2 != null) {
                Result.oIX0oI oix0oi4 = Result.Companion;
                i0Io2.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
            }
        }
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return o002;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void ooXIXxIX() {
        Object[] objArr = this.f30139xoXoI;
        IIX0o.ooOOo0oXI(objArr);
        oO.oxoX(objArr, Xx000oIo(), null);
        this.f30133O0xOxO--;
        long Xx000oIo2 = Xx000oIo() + 1;
        if (this.f30137o00 < Xx000oIo2) {
            this.f30137o00 = Xx000oIo2;
        }
        if (this.f30134OxI < Xx000oIo2) {
            XxX0x0xxx(Xx000oIo2);
        }
    }

    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI>[] oxXx0IX(long j) {
        int i;
        long j2;
        long j3;
        long j4;
        boolean z;
        long j5;
        kotlinx.coroutines.flow.internal.I0Io[] Oxx0IOOO2;
        if (j > this.f30134OxI) {
            return kotlinx.coroutines.flow.internal.II0xO0.f30183oIX0oI;
        }
        long Xx000oIo2 = Xx000oIo();
        long j6 = this.f30133O0xOxO + Xx000oIo2;
        if (this.f30135OxxIIOOXO == 0 && this.f30136X0IIOO > 0) {
            j6++;
        }
        if (kotlinx.coroutines.flow.internal.oIX0oI.XO(this) != 0 && (Oxx0IOOO2 = kotlinx.coroutines.flow.internal.oIX0oI.Oxx0IOOO(this)) != null) {
            for (kotlinx.coroutines.flow.internal.I0Io i0Io : Oxx0IOOO2) {
                if (i0Io != null) {
                    long j7 = ((x0xO0oo) i0Io).f30211oIX0oI;
                    if (j7 >= 0 && j7 < j6) {
                        j6 = j7;
                    }
                }
            }
        }
        if (j6 <= this.f30134OxI) {
            return kotlinx.coroutines.flow.internal.II0xO0.f30183oIX0oI;
        }
        long oOXoIIIo2 = oOXoIIIo();
        if (ooOOo0oXI() > 0) {
            i = Math.min(this.f30136X0IIOO, this.f30135OxxIIOOXO - ((int) (oOXoIIIo2 - j6)));
        } else {
            i = this.f30136X0IIOO;
        }
        kotlin.coroutines.I0Io<oXIO0o0XI>[] i0IoArr = kotlinx.coroutines.flow.internal.II0xO0.f30183oIX0oI;
        long j8 = this.f30136X0IIOO + oOXoIIIo2;
        if (i > 0) {
            i0IoArr = new kotlin.coroutines.I0Io[i];
            Object[] objArr = this.f30139xoXoI;
            IIX0o.ooOOo0oXI(objArr);
            long j9 = oOXoIIIo2;
            int i2 = 0;
            while (true) {
                if (oOXoIIIo2 < j8) {
                    Object I0Io2 = oO.I0Io(objArr, oOXoIIIo2);
                    j2 = j6;
                    x0o x0oVar = oO.f30205oIX0oI;
                    if (I0Io2 != x0oVar) {
                        IIX0o.x0XOIxOo(I0Io2, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        oIX0oI oix0oi = (oIX0oI) I0Io2;
                        int i3 = i2 + 1;
                        j3 = j8;
                        i0IoArr[i2] = oix0oi.f30143Oxx0xo;
                        oO.oxoX(objArr, oOXoIIIo2, x0oVar);
                        oO.oxoX(objArr, j9, oix0oi.f30141IXxxXO);
                        j5 = 1;
                        j9++;
                        if (i3 >= i) {
                            break;
                        }
                        i2 = i3;
                    } else {
                        j3 = j8;
                        j5 = 1;
                    }
                    oOXoIIIo2 += j5;
                    j6 = j2;
                    j8 = j3;
                } else {
                    j2 = j6;
                    j3 = j8;
                    break;
                }
            }
            oOXoIIIo2 = j9;
        } else {
            j2 = j6;
            j3 = j8;
        }
        int i4 = (int) (oOXoIIIo2 - Xx000oIo2);
        if (ooOOo0oXI() == 0) {
            j4 = oOXoIIIo2;
        } else {
            j4 = j2;
        }
        long max = Math.max(this.f30137o00, oOXoIIIo2 - Math.min(this.f30138oI0IIXIo, i4));
        if (this.f30135OxxIIOOXO == 0 && max < j3) {
            Object[] objArr2 = this.f30139xoXoI;
            IIX0o.ooOOo0oXI(objArr2);
            if (IIX0o.Oxx0IOOO(oO.I0Io(objArr2, max), oO.f30205oIX0oI)) {
                oOXoIIIo2++;
                max++;
            }
        }
        XoX(max, j4, oOXoIIIo2, j3);
        XIxXXX0x0();
        if (i0IoArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return IoOoX(i0IoArr);
        }
        return i0IoArr;
    }

    public final Object oxxXoxO(x0xO0oo x0xo0oo) {
        Object obj;
        kotlin.coroutines.I0Io<oXIO0o0XI>[] i0IoArr = kotlinx.coroutines.flow.internal.II0xO0.f30183oIX0oI;
        synchronized (this) {
            try {
                long I0oOoX2 = I0oOoX(x0xo0oo);
                if (I0oOoX2 < 0) {
                    obj = oO.f30205oIX0oI;
                } else {
                    long j = x0xo0oo.f30211oIX0oI;
                    Object xII2 = xII(I0oOoX2);
                    x0xo0oo.f30211oIX0oI = I0oOoX2 + 1;
                    i0IoArr = oxXx0IX(j);
                    obj = xII2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (kotlin.coroutines.I0Io<oXIO0o0XI> i0Io : i0IoArr) {
            if (i0Io != null) {
                Result.oIX0oI oix0oi = Result.Companion;
                i0Io.resumeWith(Result.m287constructorimpl(oXIO0o0XI.f29392oIX0oI));
            }
        }
        return obj;
    }

    public final long x0o() {
        return Xx000oIo() + this.f30133O0xOxO + this.f30136X0IIOO;
    }

    public final Object xII(long j) {
        Object[] objArr = this.f30139xoXoI;
        IIX0o.ooOOo0oXI(objArr);
        Object I0Io2 = oO.I0Io(objArr, j);
        if (I0Io2 instanceof oIX0oI) {
            return ((oIX0oI) I0Io2).f30141IXxxXO;
        }
        return I0Io2;
    }

    @Override // kotlinx.coroutines.flow.internal.oIX0oI
    @OXOo.OOXIXo
    /* renamed from: xXxxox0I, reason: merged with bridge method [inline-methods] */
    public x0xO0oo xxIXOIIO() {
        return new x0xO0oo();
    }

    public final long xo0x() {
        long j = this.f30137o00;
        if (j < this.f30134OxI) {
            this.f30134OxI = j;
        }
        return j;
    }
}
