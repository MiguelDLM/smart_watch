package kotlinx.coroutines.debug.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.o00;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.I0oOoX;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OI0;
import kotlin.collections.OxxIIOOXO;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.OxI;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.IIX0;
import kotlinx.coroutines.IO;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.X00IoxXI;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import kotlinx.coroutines.internal.Xx000oIo;
import kotlinx.coroutines.internal.xII;

@XX({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,620:1\n150#1:638\n151#1,4:640\n156#1,5:645\n150#1:650\n151#1,4:652\n156#1,5:657\n1#2:621\n1#2:639\n1#2:651\n766#3:622\n857#3,2:623\n1208#3,2:625\n1238#3,4:627\n1855#3,2:665\n350#3,7:673\n1819#3,8:680\n603#4:631\n603#4:644\n603#4:656\n603#4:662\n1295#4,2:663\n37#5,2:632\n37#5,2:634\n37#5,2:636\n1627#6,6:667\n1735#6,6:688\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n245#1:638\n245#1:640,4\n245#1:645,5\n252#1:650\n252#1:652,4\n252#1:657,5\n245#1:639\n252#1:651\n110#1:622\n110#1:623,2\n111#1:625,2\n111#1:627,4\n307#1:665,2\n416#1:673,7\n506#1:680,8\n154#1:631\n245#1:644\n252#1:656\n287#1:662\n288#1:663,2\n211#1:632,2\n212#1:634,2\n213#1:636,2\n355#1:667,6\n558#1:688,6\n*E\n"})
@o0
/* loaded from: classes6.dex */
public final class DebugProbesImpl {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final SimpleDateFormat f29917I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static boolean f29918II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final StackTraceElement f29919II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OOXIXo
    public static final II0xO0 f29920OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static boolean f29921Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public static final ConcurrentWeakMap<oIX0oI<?>, Boolean> f29922X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static boolean f29923XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final DebugProbesImpl f29924oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OOXIXo
    public static final I0Io f29925oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    @oOoXoXO
    public static Thread f29926oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public static final ConcurrentWeakMap<IXIxx0.I0Io, DebugCoroutineInfoImpl> f29927xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @oOoXoXO
    public static final Oox.oOoXoXO<Boolean, oXIO0o0XI> f29928xxIXOIIO;

    /* loaded from: classes6.dex */
    public static final class I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OOXIXo
        public static final AtomicLongFieldUpdater f29929oIX0oI = AtomicLongFieldUpdater.newUpdater(I0Io.class, "sequenceNumber");

        @o00
        private volatile long sequenceNumber;

        public I0Io() {
        }

        public /* synthetic */ I0Io(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OOXIXo
        public static final AtomicIntegerFieldUpdater f29930oIX0oI = AtomicIntegerFieldUpdater.newUpdater(II0xO0.class, "installations");

        @o00
        private volatile int installations;

        public II0xO0() {
        }

        public /* synthetic */ II0xO0(IIXOooo iIXOooo) {
            this();
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n287#2:329\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class X0o0xo<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return xX0ox.Oxx0IOOO.oOoXoXO(Long.valueOf(((oIX0oI) t).f29931Oo.f29914II0xO0), Long.valueOf(((oIX0oI) t2).f29931Oo.f29914II0xO0));
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements kotlin.coroutines.I0Io<T>, IXIxx0.I0Io {

        /* renamed from: Oo, reason: collision with root package name */
        @OOXIXo
        @XO0OX.XO
        public final DebugCoroutineInfoImpl f29931Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        @XO0OX.XO
        public final kotlin.coroutines.I0Io<T> f29932XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(@OOXIXo kotlin.coroutines.I0Io<? super T> i0Io, @OOXIXo DebugCoroutineInfoImpl debugCoroutineInfoImpl) {
            this.f29932XO = i0Io;
            this.f29931Oo = debugCoroutineInfoImpl;
        }

        public final xxIXOIIO II0xO0() {
            return this.f29931Oo.oxoX();
        }

        @Override // IXIxx0.I0Io
        @oOoXoXO
        public IXIxx0.I0Io getCallerFrame() {
            xxIXOIIO II0xO02 = II0xO0();
            if (II0xO02 != null) {
                return II0xO02.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.I0Io
        @OOXIXo
        public CoroutineContext getContext() {
            return this.f29932XO.getContext();
        }

        @Override // IXIxx0.I0Io
        @oOoXoXO
        public StackTraceElement getStackTraceElement() {
            xxIXOIIO II0xO02 = II0xO0();
            if (II0xO02 != null) {
                return II0xO02.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.I0Io
        public void resumeWith(@OOXIXo Object obj) {
            DebugProbesImpl.f29924oIX0oI.xXxxox0I(this);
            this.f29932XO.resumeWith(obj);
        }

        @OOXIXo
        public String toString() {
            return this.f29932XO.toString();
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n154#2:329\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oxoX<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return xX0ox.Oxx0IOOO.oOoXoXO(Long.valueOf(((oIX0oI) t).f29931Oo.f29914II0xO0), Long.valueOf(((oIX0oI) t2).f29931Oo.f29914II0xO0));
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f29924oIX0oI = debugProbesImpl;
        f29919II0xO0 = new oIX0oI.oIX0oI().II0xO0();
        f29917I0Io = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        IIXOooo iIXOooo = null;
        f29922X0o0xo = new ConcurrentWeakMap<>(false, 1, null);
        f29923XO = true;
        f29921Oxx0IOOO = true;
        f29918II0XooXoX = true;
        f29928xxIXOIIO = debugProbesImpl.oI0IIXIo();
        f29927xoIox = new ConcurrentWeakMap<>(true);
        f29920OOXIXo = new II0xO0(iIXOooo);
        f29925oOoXoXO = new I0Io(iIXOooo);
    }

    public static /* synthetic */ void Oxx0xo(kotlinx.coroutines.oXIO0o0XI oxio0o0xi) {
    }

    @OOXIXo
    public final Object[] II0XooXoX() {
        String str;
        String str2;
        String name;
        List<kotlinx.coroutines.debug.internal.I0Io> Oxx0IOOO2 = Oxx0IOOO();
        int size = Oxx0IOOO2.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (kotlinx.coroutines.debug.internal.I0Io i0Io : Oxx0IOOO2) {
            CoroutineContext oIX0oI2 = i0Io.oIX0oI();
            IO io2 = (IO) oIX0oI2.get(IO.f29691Oo);
            Long l = null;
            if (io2 != null && (name = io2.getName()) != null) {
                str = x0o(name);
            } else {
                str = null;
            }
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) oIX0oI2.get(CoroutineDispatcher.Key);
            if (coroutineDispatcher != null) {
                str2 = x0o(coroutineDispatcher);
            } else {
                str2 = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"name\": ");
            sb.append(str);
            sb.append(",\n                    \"id\": ");
            X00IoxXI x00IoxXI = (X00IoxXI) oIX0oI2.get(X00IoxXI.f29749Oo);
            if (x00IoxXI != null) {
                l = Long.valueOf(x00IoxXI.X0IIOO());
            }
            sb.append(l);
            sb.append(",\n                    \"dispatcher\": ");
            sb.append(str2);
            sb.append(",\n                    \"sequenceNumber\": ");
            sb.append(i0Io.XO());
            sb.append(",\n                    \"state\": \"");
            sb.append(i0Io.Oxx0IOOO());
            sb.append("\"\n                } \n                ");
            arrayList3.add(StringsKt__IndentKt.x0xO0oo(sb.toString()));
            arrayList2.add(i0Io.oxoX());
            arrayList.add(i0Io.X0o0xo());
        }
        return new Object[]{'[' + CollectionsKt___CollectionsKt.OoIXo(arrayList3, null, null, null, 0, null, null, 63, null) + ']', arrayList.toArray(new Thread[0]), arrayList2.toArray(new IXIxx0.I0Io[0]), Oxx0IOOO2.toArray(new kotlinx.coroutines.debug.internal.I0Io[0])};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OOXIXo
    public final <T> kotlin.coroutines.I0Io<T> IIX0o(@OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        xxIXOIIO xxixoiio;
        if (!X0IIOO()) {
            return i0Io;
        }
        if (f29918II0XooXoX && i0Io.getContext() == EmptyCoroutineContext.INSTANCE) {
            return i0Io;
        }
        if (xxX(i0Io) != null) {
            return i0Io;
        }
        if (f29921Oxx0IOOO) {
            xxixoiio = xII(oo(new Exception()));
        } else {
            xxixoiio = null;
        }
        return X0o0xo(i0Io, xxixoiio);
    }

    public final boolean IIXOooo() {
        return f29918II0XooXoX;
    }

    public final void IO() {
        Thread thread = f29926oxoX;
        if (thread == null) {
            return;
        }
        f29926oxoX = null;
        thread.interrupt();
        thread.join();
    }

    public final String IXxxXO(kotlinx.coroutines.oXIO0o0XI oxio0o0xi) {
        if (oxio0o0xi instanceof JobSupport) {
            return ((JobSupport) oxio0o0xi).IOoo();
        }
        return oxio0o0xi.toString();
    }

    public final void Io(kotlin.coroutines.I0Io<?> i0Io, String str) {
        IXIxx0.I0Io i0Io2;
        if (!X0IIOO()) {
            return;
        }
        if (f29918II0XooXoX && i0Io.getContext() == EmptyCoroutineContext.INSTANCE) {
            return;
        }
        if (IIX0o.Oxx0IOOO(str, kotlinx.coroutines.debug.internal.oxoX.f29951II0xO0)) {
            if (i0Io instanceof IXIxx0.I0Io) {
                i0Io2 = (IXIxx0.I0Io) i0Io;
            } else {
                i0Io2 = null;
            }
            if (i0Io2 == null) {
                return;
            }
            OI0(i0Io2, str);
            return;
        }
        oIX0oI<?> xxX2 = xxX(i0Io);
        if (xxX2 == null) {
            return;
        }
        o0(xxX2, i0Io, str);
    }

    public final void IoOoX(boolean z) {
        f29921Oxx0IOOO = z;
    }

    public final boolean O0xOxO(oIX0oI<?> oix0oi) {
        kotlinx.coroutines.oXIO0o0XI oxio0o0xi;
        CoroutineContext I0Io2 = oix0oi.f29931Oo.I0Io();
        if (I0Io2 == null || (oxio0o0xi = (kotlinx.coroutines.oXIO0o0XI) I0Io2.get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO)) == null || !oxio0o0xi.isCompleted()) {
            return false;
        }
        f29922X0o0xo.remove(oix0oi);
        return true;
    }

    public final void OI0(IXIxx0.I0Io i0Io, String str) {
        IXIxx0.I0Io i0Io2;
        boolean z;
        if (!X0IIOO()) {
            return;
        }
        ConcurrentWeakMap<IXIxx0.I0Io, DebugCoroutineInfoImpl> concurrentWeakMap = f29927xoIox;
        DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(i0Io);
        if (remove != null) {
            z = false;
        } else {
            oIX0oI<?> XIxXXX0x02 = XIxXXX0x0(i0Io);
            if (XIxXXX0x02 != null && (remove = XIxXXX0x02.f29931Oo) != null) {
                IXIxx0.I0Io XO2 = remove.XO();
                if (XO2 != null) {
                    i0Io2 = oo0xXOI0I(XO2);
                } else {
                    i0Io2 = null;
                }
                if (i0Io2 != null) {
                    concurrentWeakMap.remove(i0Io2);
                }
                z = true;
            } else {
                return;
            }
        }
        IIX0o.x0XOIxOo(i0Io, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
        remove.xoIox(str, (kotlin.coroutines.I0Io) i0Io, z);
        IXIxx0.I0Io oo0xXOI0I2 = oo0xXOI0I(i0Io);
        if (oo0xXOI0I2 == null) {
            return;
        }
        concurrentWeakMap.put(oo0xXOI0I2, remove);
    }

    @OOXIXo
    public final List<DebuggerInfo> OOXIXo() {
        if (X0IIOO()) {
            return SequencesKt___SequencesKt.oox000IX(SequencesKt___SequencesKt.IOoo(SequencesKt___SequencesKt.x0OOI(CollectionsKt___CollectionsKt.OooI(Oo()), new oxoX()), new Oox.oOoXoXO<oIX0oI<?>, DebuggerInfo>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // Oox.oOoXoXO
                @oOoXoXO
                public final DebuggerInfo invoke(@OOXIXo DebugProbesImpl.oIX0oI<?> oix0oi) {
                    boolean O0xOxO2;
                    CoroutineContext I0Io2;
                    O0xOxO2 = DebugProbesImpl.f29924oIX0oI.O0xOxO(oix0oi);
                    if (O0xOxO2 || (I0Io2 = oix0oi.f29931Oo.I0Io()) == null) {
                        return null;
                    }
                    return new DebuggerInfo(oix0oi.f29931Oo, I0Io2);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final Set<oIX0oI<?>> Oo() {
        return f29922X0o0xo.keySet();
    }

    public final void OxI() {
        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo;
        if (II0xO0.f29930oIX0oI.incrementAndGet(f29920OOXIXo) > 1) {
            return;
        }
        X00IoxXI();
        if (!kotlinx.coroutines.debug.internal.oIX0oI.f29949oIX0oI.oIX0oI() && (oooxoxo = f29928xxIXOIIO) != null) {
            oooxoxo.invoke(Boolean.TRUE);
        }
    }

    @OOXIXo
    public final List<kotlinx.coroutines.debug.internal.I0Io> Oxx0IOOO() {
        if (X0IIOO()) {
            return SequencesKt___SequencesKt.oox000IX(SequencesKt___SequencesKt.IOoo(SequencesKt___SequencesKt.x0OOI(CollectionsKt___CollectionsKt.OooI(Oo()), new oxoX()), new Oox.oOoXoXO<oIX0oI<?>, kotlinx.coroutines.debug.internal.I0Io>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // Oox.oOoXoXO
                @oOoXoXO
                public final I0Io invoke(@OOXIXo DebugProbesImpl.oIX0oI<?> oix0oi) {
                    boolean O0xOxO2;
                    CoroutineContext I0Io2;
                    O0xOxO2 = DebugProbesImpl.f29924oIX0oI.O0xOxO(oix0oi);
                    if (O0xOxO2 || (I0Io2 = oix0oi.f29931Oo.I0Io()) == null) {
                        return null;
                    }
                    return new I0Io(oix0oi.f29931Oo, I0Io2);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final boolean OxxIIOOXO() {
        return f29921Oxx0IOOO;
    }

    public final void X00IoxXI() {
        f29926oxoX = xoIXOxX.II0xO0.I0Io(false, true, null, "Coroutines Debugger Cleaner", 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$startWeakRefCleanerThread$1
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConcurrentWeakMap concurrentWeakMap;
                concurrentWeakMap = DebugProbesImpl.f29927xoIox;
                concurrentWeakMap.oOoXoXO();
            }
        }, 21, null);
    }

    @XO0OX.xxIXOIIO(name = "isInstalled$kotlinx_coroutines_debug")
    public final boolean X0IIOO() {
        return II0xO0.f29930oIX0oI.get(f29920OOXIXo) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> kotlin.coroutines.I0Io<T> X0o0xo(kotlin.coroutines.I0Io<? super T> i0Io, xxIXOIIO xxixoiio) {
        if (!X0IIOO()) {
            return i0Io;
        }
        oIX0oI<?> oix0oi = new oIX0oI<>(i0Io, new DebugCoroutineInfoImpl(i0Io.getContext(), xxixoiio, I0Io.f29929oIX0oI.incrementAndGet(f29925oOoXoXO)));
        ConcurrentWeakMap<oIX0oI<?>, Boolean> concurrentWeakMap = f29922X0o0xo;
        concurrentWeakMap.put(oix0oi, Boolean.TRUE);
        if (!X0IIOO()) {
            concurrentWeakMap.clear();
        }
        return oix0oi;
    }

    public final boolean XI0IXoo(StackTraceElement stackTraceElement) {
        return OxI.IOOoXo0Ix(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    public final oIX0oI<?> XIxXXX0x0(IXIxx0.I0Io i0Io) {
        while (!(i0Io instanceof oIX0oI)) {
            i0Io = i0Io.getCallerFrame();
            if (i0Io == null) {
                return null;
            }
        }
        return (oIX0oI) i0Io;
    }

    @XO0OX.xxIXOIIO(name = "dumpCoroutines")
    public final void XO(@OOXIXo PrintStream printStream) {
        synchronized (printStream) {
            f29924oIX0oI.xoIox(printStream);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    public final void XOxIOxOx() {
        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo;
        if (X0IIOO()) {
            if (II0xO0.f29930oIX0oI.decrementAndGet(f29920OOXIXo) != 0) {
                return;
            }
            IO();
            f29922X0o0xo.clear();
            f29927xoIox.clear();
            if (!kotlinx.coroutines.debug.internal.oIX0oI.f29949oIX0oI.oIX0oI() && (oooxoxo = f29928xxIXOIIO) != null) {
                oooxoxo.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        throw new IllegalStateException("Agent was not installed");
    }

    public final void Xx000oIo(boolean z) {
        f29923XO = z;
    }

    public final void XxX0x0xxx(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    public final void o0(oIX0oI<?> oix0oi, kotlin.coroutines.I0Io<?> i0Io, String str) {
        if (!X0IIOO()) {
            return;
        }
        oix0oi.f29931Oo.xoIox(str, i0Io, true);
    }

    @OOXIXo
    public final String o00(@OOXIXo kotlinx.coroutines.oXIO0o0XI oxio0o0xi) {
        if (X0IIOO()) {
            Set<oIX0oI<?>> Oo2 = Oo();
            ArrayList<oIX0oI> arrayList = new ArrayList();
            for (Object obj : Oo2) {
                if (((oIX0oI) obj).f29932XO.getContext().get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO) != null) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(OxxIIOOXO.xo0x(arrayList, 10)), 16));
            for (oIX0oI oix0oi : arrayList) {
                linkedHashMap.put(IIX0.XI0IXoo(oix0oi.f29932XO.getContext()), oix0oi.f29931Oo);
            }
            StringBuilder sb = new StringBuilder();
            f29924oIX0oI.oxoX(oxio0o0xi, linkedHashMap, sb, "");
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final Oox.oOoXoXO<Boolean, oXIO0o0XI> oI0IIXIo() {
        Object m287constructorimpl;
        Object obj = null;
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);
            IIX0o.x0XOIxOo(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            m287constructorimpl = Result.m287constructorimpl((Oox.oOoXoXO) XoX.Oo(newInstance, 1));
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
        }
        if (!Result.m293isFailureimpl(m287constructorimpl)) {
            obj = m287constructorimpl;
        }
        return (Oox.oOoXoXO) obj;
    }

    public final Pair<Integer, Integer> oO(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i2 = 0; i2 < 3; i2++) {
            int x0xO0oo2 = f29924oIX0oI.x0xO0oo((i - 1) - i2, stackTraceElementArr, list);
            if (x0xO0oo2 != -1) {
                return Xo0.oIX0oI(Integer.valueOf(x0xO0oo2), Integer.valueOf(i2));
            }
        }
        return Xo0.oIX0oI(-1, 0);
    }

    public final void oOXoIIIo(boolean z) {
        f29918II0XooXoX = z;
    }

    @OOXIXo
    public final List<StackTraceElement> oOoXoXO(@OOXIXo kotlinx.coroutines.debug.internal.I0Io i0Io, @OOXIXo List<StackTraceElement> list) {
        return x0XOIxOo(i0Io.Oxx0IOOO(), i0Io.X0o0xo(), list);
    }

    public final <T extends Throwable> List<StackTraceElement> oo(T t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                if (IIX0o.Oxx0IOOO(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i = length2;
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        int i3 = i + 1;
        if (!f29923XO) {
            int i4 = length - i3;
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(stackTrace[i5 + i3]);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i3) + 1);
        while (i3 < length) {
            if (XI0IXoo(stackTrace[i3])) {
                arrayList2.add(stackTrace[i3]);
                int i6 = i3 + 1;
                while (i6 < length && XI0IXoo(stackTrace[i6])) {
                    i6++;
                }
                int i7 = i6 - 1;
                int i8 = i7;
                while (i8 > i3 && stackTrace[i8].getFileName() == null) {
                    i8--;
                }
                if (i8 > i3 && i8 < i7) {
                    arrayList2.add(stackTrace[i8]);
                }
                arrayList2.add(stackTrace[i7]);
                i3 = i6;
            } else {
                arrayList2.add(stackTrace[i3]);
                i3++;
            }
        }
        return arrayList2;
    }

    public final IXIxx0.I0Io oo0xXOI0I(IXIxx0.I0Io i0Io) {
        do {
            i0Io = i0Io.getCallerFrame();
            if (i0Io == null) {
                return null;
            }
        } while (i0Io.getStackTraceElement() == null);
        return i0Io;
    }

    @OOXIXo
    public final String ooOOo0oXI(@OOXIXo kotlinx.coroutines.debug.internal.I0Io i0Io) {
        String str;
        List<StackTraceElement> oOoXoXO2 = oOoXoXO(i0Io, i0Io.II0XooXoX());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : oOoXoXO2) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"declaringClass\": \"");
            sb.append(stackTraceElement.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append(stackTraceElement.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            if (fileName != null) {
                str = x0o(fileName);
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(stackTraceElement.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(StringsKt__IndentKt.x0xO0oo(sb.toString()));
        }
        return '[' + CollectionsKt___CollectionsKt.OoIXo(arrayList, null, null, null, 0, null, null, 63, null) + ']';
    }

    public final void ooXIXxIX(@OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        Io(i0Io, kotlinx.coroutines.debug.internal.oxoX.f29951II0xO0);
    }

    public final void oxoX(kotlinx.coroutines.oXIO0o0XI oxio0o0xi, Map<kotlinx.coroutines.oXIO0o0XI, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(oxio0o0xi);
        if (debugCoroutineInfoImpl == null) {
            if (!(oxio0o0xi instanceof Xx000oIo)) {
                sb.append(str + IXxxXO(oxio0o0xi) + '\n');
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append('\t');
                str = sb2.toString();
            }
        } else {
            StackTraceElement stackTraceElement = (StackTraceElement) CollectionsKt___CollectionsKt.XxXX(debugCoroutineInfoImpl.II0XooXoX());
            sb.append(str + IXxxXO(oxio0o0xi) + ", continuation is " + debugCoroutineInfoImpl.Oxx0IOOO() + " at line " + stackTraceElement + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append('\t');
            str = sb3.toString();
        }
        Iterator<kotlinx.coroutines.oXIO0o0XI> it = oxio0o0xi.xXxxox0I().iterator();
        while (it.hasNext()) {
            oxoX(it.next(), map, sb, str);
        }
    }

    public final List<StackTraceElement> x0XOIxOo(String str, Thread thread, List<StackTraceElement> list) {
        Object m287constructorimpl;
        if (IIX0o.Oxx0IOOO(str, kotlinx.coroutines.debug.internal.oxoX.f29951II0xO0) && thread != null) {
            try {
                Result.oIX0oI oix0oi = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(thread.getStackTrace());
            } catch (Throwable th) {
                Result.oIX0oI oix0oi2 = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
            }
            if (Result.m293isFailureimpl(m287constructorimpl)) {
                m287constructorimpl = null;
            }
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m287constructorimpl;
            if (stackTraceElementArr == null) {
                return list;
            }
            int length = stackTraceElementArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if (IIX0o.Oxx0IOOO(stackTraceElement.getClassName(), xII.f30318oIX0oI) && IIX0o.Oxx0IOOO(stackTraceElement.getMethodName(), "resumeWith") && IIX0o.Oxx0IOOO(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            Pair<Integer, Integer> oO2 = oO(i, stackTraceElementArr, list);
            int intValue = oO2.component1().intValue();
            int intValue2 = oO2.component2().intValue();
            if (intValue == -1) {
                return list;
            }
            ArrayList arrayList = new ArrayList((((list.size() + i) - intValue) - 1) - intValue2);
            int i2 = i - intValue2;
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(stackTraceElementArr[i3]);
            }
            int size = list.size();
            for (int i4 = intValue + 1; i4 < size; i4++) {
                arrayList.add(list.get(i4));
            }
            return arrayList;
        }
        return list;
    }

    public final String x0o(Object obj) {
        String II0xO02;
        II0xO02 = kotlinx.coroutines.debug.internal.X0o0xo.II0xO0(obj.toString());
        return II0xO02;
    }

    public final int x0xO0oo(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt___ArraysKt.IxIOOxO(stackTraceElementArr, i);
        if (stackTraceElement == null) {
            return -1;
        }
        int i2 = 0;
        for (StackTraceElement stackTraceElement2 : list) {
            if (IIX0o.Oxx0IOOO(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && IIX0o.Oxx0IOOO(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && IIX0o.Oxx0IOOO(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void xI(@OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        Io(i0Io, kotlinx.coroutines.debug.internal.oxoX.f29950I0Io);
    }

    public final xxIXOIIO xII(List<StackTraceElement> list) {
        xxIXOIIO xxixoiio = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                xxixoiio = new xxIXOIIO(xxixoiio, listIterator.previous());
            }
        }
        return new xxIXOIIO(xxixoiio, f29919II0xO0);
    }

    public final void xXxxox0I(oIX0oI<?> oix0oi) {
        IXIxx0.I0Io oo0xXOI0I2;
        f29922X0o0xo.remove(oix0oi);
        IXIxx0.I0Io XO2 = oix0oi.f29931Oo.XO();
        if (XO2 != null && (oo0xXOI0I2 = oo0xXOI0I(XO2)) != null) {
            f29927xoIox.remove(oo0xXOI0I2);
        }
    }

    public final void xoIox(PrintStream printStream) {
        String Oxx0IOOO2;
        if (X0IIOO()) {
            printStream.print("Coroutines dump " + f29917I0Io.format(Long.valueOf(System.currentTimeMillis())));
            for (oIX0oI oix0oi : SequencesKt___SequencesKt.x0OOI(SequencesKt___SequencesKt.OO0x0xX(CollectionsKt___CollectionsKt.OooI(Oo()), new Oox.oOoXoXO<oIX0oI<?>, Boolean>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$2
                @Override // Oox.oOoXoXO
                @OOXIXo
                public final Boolean invoke(@OOXIXo DebugProbesImpl.oIX0oI<?> oix0oi2) {
                    boolean O0xOxO2;
                    O0xOxO2 = DebugProbesImpl.f29924oIX0oI.O0xOxO(oix0oi2);
                    return Boolean.valueOf(!O0xOxO2);
                }
            }), new X0o0xo())) {
                DebugCoroutineInfoImpl debugCoroutineInfoImpl = oix0oi.f29931Oo;
                List<StackTraceElement> II0XooXoX2 = debugCoroutineInfoImpl.II0XooXoX();
                DebugProbesImpl debugProbesImpl = f29924oIX0oI;
                List<StackTraceElement> x0XOIxOo2 = debugProbesImpl.x0XOIxOo(debugCoroutineInfoImpl.Oxx0IOOO(), debugCoroutineInfoImpl.lastObservedThread, II0XooXoX2);
                if (IIX0o.Oxx0IOOO(debugCoroutineInfoImpl.Oxx0IOOO(), kotlinx.coroutines.debug.internal.oxoX.f29951II0xO0) && x0XOIxOo2 == II0XooXoX2) {
                    Oxx0IOOO2 = debugCoroutineInfoImpl.Oxx0IOOO() + " (Last suspension stacktrace, not an actual stacktrace)";
                } else {
                    Oxx0IOOO2 = debugCoroutineInfoImpl.Oxx0IOOO();
                }
                printStream.print("\n\nCoroutine " + oix0oi.f29932XO + ", state: " + Oxx0IOOO2);
                if (II0XooXoX2.isEmpty()) {
                    printStream.print("\n\tat " + f29919II0xO0);
                    debugProbesImpl.XxX0x0xxx(printStream, debugCoroutineInfoImpl.X0o0xo());
                } else {
                    debugProbesImpl.XxX0x0xxx(printStream, x0XOIxOo2);
                }
            }
            return;
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final boolean xoXoI() {
        return f29923XO;
    }

    public final <R> List<R> xxIXOIIO(final x0xO0oo<? super oIX0oI<?>, ? super CoroutineContext, ? extends R> x0xo0oo) {
        if (X0IIOO()) {
            return SequencesKt___SequencesKt.oox000IX(SequencesKt___SequencesKt.IOoo(SequencesKt___SequencesKt.x0OOI(CollectionsKt___CollectionsKt.OooI(Oo()), new oxoX()), new Oox.oOoXoXO<oIX0oI<?>, R>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @oOoXoXO
                public final R invoke(@OOXIXo DebugProbesImpl.oIX0oI<?> oix0oi) {
                    boolean O0xOxO2;
                    CoroutineContext I0Io2;
                    O0xOxO2 = DebugProbesImpl.f29924oIX0oI.O0xOxO(oix0oi);
                    if (O0xOxO2 || (I0Io2 = oix0oi.f29931Oo.I0Io()) == null) {
                        return null;
                    }
                    return x0xo0oo.invoke(oix0oi, I0Io2);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final oIX0oI<?> xxX(kotlin.coroutines.I0Io<?> i0Io) {
        IXIxx0.I0Io i0Io2;
        if (i0Io instanceof IXIxx0.I0Io) {
            i0Io2 = (IXIxx0.I0Io) i0Io;
        } else {
            i0Io2 = null;
        }
        if (i0Io2 == null) {
            return null;
        }
        return XIxXXX0x0(i0Io2);
    }
}
