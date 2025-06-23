package com.angcyo.dsladapter;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslDataFilter;
import com.angcyo.dsladapter.internal.RBatchingListUpdateCallback;
import com.angcyo.dsladapter.internal.RDiffCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDslDataFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslDataFilter.kt\ncom/angcyo/dsladapter/DslDataFilter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,549:1\n1855#2,2:550\n*S KotlinDebug\n*F\n+ 1 DslDataFilter.kt\ncom/angcyo/dsladapter/DslDataFilter\n*L\n106#1:550,2\n*E\n"})
/* loaded from: classes7.dex */
public class DslDataFilter {

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static boolean f5192ooOOo0oXI;

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Set<oOXoIIIo> f5194I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<UpdateTaskRunnable> f5195II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<DslAdapterItem> f5196II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.xxIXOIIO> f5197Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.II0XooXoX> f5198X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.xxIXOIIO> f5199XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DslAdapter f5200oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public Oox.x0xO0oo<? super List<? extends DslAdapterItem>, ? super List<? extends DslAdapterItem>, ? extends List<? extends DslAdapterItem>> f5201oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.X0IIOO f5202xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.xxIXOIIO> f5203xxIXOIIO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f5190OOXIXo = new oIX0oI(null);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static long f5191oOoXoXO = 6;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO<ExecutorService> f5193x0XOIxOo = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ExecutorService>() { // from class: com.angcyo.dsladapter.DslDataFilter$Companion$asyncExecutor$2
        @Override // Oox.oIX0oI
        public final ExecutorService invoke() {
            return Executors.newCachedThreadPool();
        }
    });

    /* loaded from: classes7.dex */
    public static final class II0xO0 extends com.angcyo.dsladapter.filter.X0o0xo {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<com.angcyo.dsladapter.filter.Oxx0IOOO, List<DslAdapterItem>> f5204Oo;

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(Oox.oOoXoXO<? super com.angcyo.dsladapter.filter.Oxx0IOOO, ? extends List<? extends DslAdapterItem>> oooxoxo) {
            this.f5204Oo = oooxoxo;
        }

        @Override // com.angcyo.dsladapter.filter.xxIXOIIO
        @OXOo.OOXIXo
        public List<DslAdapterItem> II0xO0(@OXOo.OOXIXo com.angcyo.dsladapter.filter.Oxx0IOOO chain) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(chain, "chain");
            return this.f5204Oo.invoke(chain);
        }
    }

    @XX({"SMAP\nDslDataFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslDataFilter.kt\ncom/angcyo/dsladapter/DslDataFilter$UpdateTaskRunnable\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,549:1\n1855#2,2:550\n1855#2,2:552\n1855#2,2:554\n1864#2,2:556\n1855#2,2:558\n1866#2:560\n*S KotlinDebug\n*F\n+ 1 DslDataFilter.kt\ncom/angcyo/dsladapter/DslDataFilter$UpdateTaskRunnable\n*L\n368#1:550,2\n398#1:552,2\n427#1:554,2\n470#1:556,2\n475#1:558,2\n470#1:560\n*E\n"})
    /* loaded from: classes7.dex */
    public final class UpdateTaskRunnable implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public long f5205IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final AtomicBoolean f5206Oo = new AtomicBoolean(false);

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.oOoXoXO
        public XxX0x0xxx f5208XO;

        /* loaded from: classes7.dex */
        public static final class oIX0oI implements com.angcyo.dsladapter.internal.ooOOo0oXI<DslAdapterItem> {
            public oIX0oI() {
            }

            @Override // com.angcyo.dsladapter.internal.ooOOo0oXI
            /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
            public boolean I0Io(@OXOo.OOXIXo DslAdapterItem oldData, @OXOo.OOXIXo DslAdapterItem newData, int i, int i2) {
                DslAdapterItem dslAdapterItem;
                kotlin.jvm.internal.IIX0o.x0xO0oo(oldData, "oldData");
                kotlin.jvm.internal.IIX0o.x0xO0oo(newData, "newData");
                Oox.Oxx0xo<DslAdapterItem, DslAdapterItem, Integer, Integer, Boolean> thisAreItemsTheSame = oldData.getThisAreItemsTheSame();
                XxX0x0xxx oO2 = UpdateTaskRunnable.this.oO();
                if (oO2 != null) {
                    dslAdapterItem = oO2.x0xO0oo();
                } else {
                    dslAdapterItem = null;
                }
                return thisAreItemsTheSame.invoke(dslAdapterItem, newData, Integer.valueOf(i), Integer.valueOf(i2)).booleanValue();
            }

            @Override // com.angcyo.dsladapter.internal.ooOOo0oXI
            @OXOo.oOoXoXO
            /* renamed from: XO, reason: merged with bridge method [inline-methods] */
            public Object oIX0oI(@OXOo.OOXIXo DslAdapterItem oldData, @OXOo.OOXIXo DslAdapterItem newData, int i, int i2) {
                DslAdapterItem dslAdapterItem;
                Object obj;
                kotlin.jvm.internal.IIX0o.x0xO0oo(oldData, "oldData");
                kotlin.jvm.internal.IIX0o.x0xO0oo(newData, "newData");
                Oox.oI0IIXIo<DslAdapterItem, Object, DslAdapterItem, Integer, Integer, Object> thisGetChangePayload = oldData.getThisGetChangePayload();
                XxX0x0xxx oO2 = UpdateTaskRunnable.this.oO();
                if (oO2 != null) {
                    dslAdapterItem = oO2.x0xO0oo();
                } else {
                    dslAdapterItem = null;
                }
                XxX0x0xxx oO3 = UpdateTaskRunnable.this.oO();
                if (oO3 != null) {
                    obj = oO3.OxxIIOOXO();
                } else {
                    obj = null;
                }
                return thisGetChangePayload.invoke(dslAdapterItem, obj, newData, Integer.valueOf(i), Integer.valueOf(i2));
            }

            @Override // com.angcyo.dsladapter.internal.ooOOo0oXI
            /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
            public boolean II0xO0(@OXOo.OOXIXo DslAdapterItem oldData, @OXOo.OOXIXo DslAdapterItem newData, int i, int i2) {
                DslAdapterItem dslAdapterItem;
                kotlin.jvm.internal.IIX0o.x0xO0oo(oldData, "oldData");
                kotlin.jvm.internal.IIX0o.x0xO0oo(newData, "newData");
                Oox.Oxx0xo<DslAdapterItem, DslAdapterItem, Integer, Integer, Boolean> thisAreContentsTheSame = oldData.getThisAreContentsTheSame();
                XxX0x0xxx oO2 = UpdateTaskRunnable.this.oO();
                if (oO2 != null) {
                    dslAdapterItem = oO2.x0xO0oo();
                } else {
                    dslAdapterItem = null;
                }
                return thisAreContentsTheSame.invoke(dslAdapterItem, newData, Integer.valueOf(i), Integer.valueOf(i2)).booleanValue();
            }
        }

        public UpdateTaskRunnable() {
        }

        public static final void IIXOooo(UpdateTaskRunnable this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.xxIXOIIO();
        }

        public static final void OOXIXo(UpdateTaskRunnable this$0, DiffUtil.DiffResult diffResult, List resultList, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            kotlin.jvm.internal.IIX0o.x0xO0oo(diffResult, "$diffResult");
            kotlin.jvm.internal.IIX0o.x0xO0oo(resultList, "$resultList");
            this$0.oI0IIXIo(diffResult, resultList, i);
        }

        public static final void Oxx0xo(UpdateTaskRunnable this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.IXxxXO(this$0.x0XOIxOo());
        }

        public static final void OxxIIOOXO(DiffUtil.DiffResult diffResult, DslDataFilter this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(diffResult, "$diffResult");
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            diffResult.dispatchUpdatesTo(new RBatchingListUpdateCallback(this$0.IXxxXO()));
        }

        public static final void o00(UpdateTaskRunnable this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.xxIXOIIO();
        }

        public static final void xoIox(UpdateTaskRunnable this$0, DiffUtil.DiffResult diffResult, List resultList, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            kotlin.jvm.internal.IIX0o.x0xO0oo(diffResult, "$diffResult");
            kotlin.jvm.internal.IIX0o.x0xO0oo(resultList, "$resultList");
            this$0.oI0IIXIo(diffResult, resultList, i);
        }

        public static final void xoXoI(UpdateTaskRunnable this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.run();
        }

        public final DiffUtil.DiffResult II0XooXoX(List<DslAdapterItem> list, StringBuilder sb) {
            ArrayList arrayList = new ArrayList(DslDataFilter.this.Oxx0xo());
            DslDataFilter dslDataFilter = DslDataFilter.this;
            List<DslAdapterItem> ooOOo0oXI2 = dslDataFilter.ooOOo0oXI(dslDataFilter.IXxxXO().getAdapterItems());
            List<DslAdapterItem> OOXIXo2 = DslDataFilter.this.OOXIXo(arrayList, ooOOo0oXI2);
            list.addAll(OOXIXo2);
            if (DslDataFilter.f5190OOXIXo.oxoX()) {
                sb.append(" 数据列表->原:" + arrayList.size() + " 后:" + ooOOo0oXI2.size() + " 终:" + OOXIXo2.size());
            }
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new RDiffCallback(arrayList, OOXIXo2, new oIX0oI()));
            kotlin.jvm.internal.IIX0o.oO(calculateDiff, "private fun calculateDif…turn diffResult\n        }");
            return calculateDiff;
        }

        public final void IXxxXO(List<? extends DslAdapterItem> list) {
            DslAdapterItem dslAdapterItem;
            XxX0x0xxx xxX0x0xxx = this.f5208XO;
            if (xxX0x0xxx != null) {
                dslAdapterItem = xxX0x0xxx.x0xO0oo();
            } else {
                dslAdapterItem = null;
            }
            if (dslAdapterItem != null && !this.f5206Oo.get()) {
                XxX0x0xxx xxX0x0xxx2 = this.f5208XO;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx2);
                DslAdapterItem x0xO0oo2 = xxX0x0xxx2.x0xO0oo();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(x0xO0oo2);
                if (!list.isEmpty() && DslDataFilter.f5190OOXIXo.oxoX()) {
                    L.f5267oIX0oI.ooXIXxIX("来自:" + LibExKt.xOoOIoI(x0xO0oo2) + " tag:" + x0xO0oo2.getItemTag() + "的更新↓");
                }
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.XoX();
                    }
                    DslAdapterItem dslAdapterItem2 = (DslAdapterItem) obj;
                    if (dslAdapterItem2.getItemUpdateFrom().invoke(x0xO0oo2).booleanValue()) {
                        DslAdapterItem.updateAdapterItem$default(dslAdapterItem2, Boolean.TRUE, false, 2, null);
                    }
                    Iterator<T> it = dslAdapterItem2.getItemUpdateFromListenerList().iterator();
                    while (it.hasNext()) {
                        ((Oox.oOoXoXO) it.next()).invoke(x0xO0oo2);
                    }
                    if (DslDataFilter.f5190OOXIXo.oxoX()) {
                        L.f5267oIX0oI.ooXIXxIX(i + "->通知更新:" + LibExKt.xOoOIoI(dslAdapterItem2) + " tag:" + dslAdapterItem2.getItemTag());
                    }
                    i = i2;
                }
            }
        }

        public final void O0xOxO(long j) {
            this.f5205IXxxXO = j;
        }

        public final void Oo() {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(Looper.getMainLooper(), Looper.myLooper())) {
                IXxxXO(x0XOIxOo());
            } else {
                DslDataFilter.this.OxxIIOOXO().post(new Runnable() { // from class: com.angcyo.dsladapter.XO
                    @Override // java.lang.Runnable
                    public final void run() {
                        DslDataFilter.UpdateTaskRunnable.Oxx0xo(DslDataFilter.UpdateTaskRunnable.this);
                    }
                });
            }
        }

        public final void OxI(@OXOo.oOoXoXO XxX0x0xxx xxX0x0xxx) {
            this.f5208XO = xxX0x0xxx;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00ea A[LOOP:1: B:20:0x00e4->B:22:0x00ea, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void oI0IIXIo(final androidx.recyclerview.widget.DiffUtil.DiffResult r9, java.util.List<com.angcyo.dsladapter.DslAdapterItem> r10, int r11) {
            /*
                Method dump skipped, instructions count: 344
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.angcyo.dsladapter.DslDataFilter.UpdateTaskRunnable.oI0IIXIo(androidx.recyclerview.widget.DiffUtil$DiffResult, java.util.List, int):void");
        }

        @OXOo.oOoXoXO
        public final XxX0x0xxx oO() {
            return this.f5208XO;
        }

        @OXOo.OOXIXo
        public final AtomicBoolean oOoXoXO() {
            return this.f5206Oo;
        }

        public final boolean ooOOo0oXI() {
            if (this.f5206Oo.get()) {
                return true;
            }
            XxX0x0xxx xxX0x0xxx = this.f5208XO;
            if (xxX0x0xxx != null && xxX0x0xxx.xoXoI()) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ooOOo0oXI()) {
                return;
            }
            XxX0x0xxx xxX0x0xxx = this.f5208XO;
            if (xxX0x0xxx != null) {
                DslDataFilter dslDataFilter = DslDataFilter.this;
                if (xxX0x0xxx.x0XOIxOo()) {
                    DslDataFilter.f5190OOXIXo.II0xO0().submit(new Runnable() { // from class: com.angcyo.dsladapter.II0XooXoX
                        @Override // java.lang.Runnable
                        public final void run() {
                            DslDataFilter.UpdateTaskRunnable.IIXOooo(DslDataFilter.UpdateTaskRunnable.this);
                        }
                    });
                } else if (xxX0x0xxx.IXxxXO()) {
                    RecyclerView recyclerView = dslDataFilter.IXxxXO().get_recyclerView();
                    if (recyclerView != null && recyclerView.isComputingLayout()) {
                        dslDataFilter.OxxIIOOXO().post(new Runnable() { // from class: com.angcyo.dsladapter.xxIXOIIO
                            @Override // java.lang.Runnable
                            public final void run() {
                                DslDataFilter.UpdateTaskRunnable.xoXoI(DslDataFilter.UpdateTaskRunnable.this);
                            }
                        });
                    } else {
                        xxIXOIIO();
                    }
                } else {
                    dslDataFilter.OxxIIOOXO().post(new Runnable() { // from class: com.angcyo.dsladapter.xoIox
                        @Override // java.lang.Runnable
                        public final void run() {
                            DslDataFilter.UpdateTaskRunnable.o00(DslDataFilter.UpdateTaskRunnable.this);
                        }
                    });
                }
            } else {
                xxX0x0xxx = null;
            }
            LibExKt.XIxXXX0x0(xxX0x0xxx, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslDataFilter$UpdateTaskRunnable$run$2
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DslDataFilter.UpdateTaskRunnable.this.oOoXoXO().set(true);
                }
            });
        }

        public final List<DslAdapterItem> x0XOIxOo() {
            DslAdapterItem x0xO0oo2;
            ArrayList arrayList = new ArrayList();
            XxX0x0xxx xxX0x0xxx = this.f5208XO;
            if (xxX0x0xxx != null && (x0xO0oo2 = xxX0x0xxx.x0xO0oo()) != null) {
                arrayList.addAll(DslDataFilter.this.IXxxXO().getUpdateDependItemListFrom(x0xO0oo2));
            }
            return arrayList;
        }

        public final long x0xO0oo() {
            return this.f5205IXxxXO;
        }

        public final void xxIXOIIO() {
            long j;
            if (ooOOo0oXI()) {
                return;
            }
            final ArrayList arrayList = new ArrayList();
            long o0xxxXXxX2 = LibExKt.o0xxxXXxX();
            StringBuilder sb = new StringBuilder();
            oIX0oI oix0oi = DslDataFilter.f5190OOXIXo;
            if (oix0oi.oxoX()) {
                sb.append(LibExKt.xXOx(DslDataFilter.this.IXxxXO()) + ':' + LibExKt.xXOx(this) + " 开始计算Diff:" + o0xxxXXxX2);
            }
            final DiffUtil.DiffResult II0XooXoX2 = II0XooXoX(arrayList, sb);
            long o0xxxXXxX3 = LibExKt.o0xxxXXxX() - o0xxxXXxX2;
            long j2 = 1000;
            long j3 = o0xxxXXxX3 / j2;
            long j4 = o0xxxXXxX3 % j2;
            if (oix0oi.oxoX()) {
                sb.append(" Diff计算耗时:" + j3 + 's' + j4 + "ms");
                if (o0xxxXXxX3 > 20) {
                    L.f5267oIX0oI.ooXIXxIX(sb);
                }
            }
            final int size = DslDataFilter.this.Oxx0xo().size();
            DslDataFilter dslDataFilter = DslDataFilter.this;
            dslDataFilter.Oxx0xo().clear();
            dslDataFilter.Oxx0xo().addAll(arrayList);
            XxX0x0xxx xxX0x0xxx = this.f5208XO;
            if (xxX0x0xxx != null) {
                j = xxX0x0xxx.Oxx0xo();
            } else {
                j = -1;
            }
            if (j >= 0) {
                DslDataFilter.this.OxxIIOOXO().postDelayed(new Runnable() { // from class: com.angcyo.dsladapter.OOXIXo
                    @Override // java.lang.Runnable
                    public final void run() {
                        DslDataFilter.UpdateTaskRunnable.xoIox(DslDataFilter.UpdateTaskRunnable.this, II0XooXoX2, arrayList, size);
                    }
                }, j);
            } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(Looper.getMainLooper(), Looper.myLooper())) {
                oI0IIXIo(II0XooXoX2, arrayList, size);
            } else {
                DslDataFilter.this.OxxIIOOXO().post(new Runnable() { // from class: com.angcyo.dsladapter.oOoXoXO
                    @Override // java.lang.Runnable
                    public final void run() {
                        DslDataFilter.UpdateTaskRunnable.OOXIXo(DslDataFilter.UpdateTaskRunnable.this, II0XooXoX2, arrayList, size);
                    }
                });
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final long I0Io() {
            return DslDataFilter.f5191oOoXoXO;
        }

        public final ExecutorService II0xO0() {
            Object value = DslDataFilter.f5193x0XOIxOo.getValue();
            kotlin.jvm.internal.IIX0o.oO(value, "<get-asyncExecutor>(...)");
            return (ExecutorService) value;
        }

        public final void X0o0xo(long j) {
            DslDataFilter.f5191oOoXoXO = j;
        }

        public final void XO(boolean z) {
            DslDataFilter.f5192ooOOo0oXI = z;
        }

        public final boolean oxoX() {
            return DslDataFilter.f5192ooOOo0oXI;
        }

        public oIX0oI() {
        }
    }

    public DslDataFilter(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        this.f5200oIX0oI = dslAdapter;
        this.f5196II0xO0 = new ArrayList();
        this.f5194I0Io = new LinkedHashSet();
        this.f5201oxoX = new Oox.x0xO0oo<List<? extends DslAdapterItem>, List<? extends DslAdapterItem>, List<? extends DslAdapterItem>>() { // from class: com.angcyo.dsladapter.DslDataFilter$onDataFilterAfter$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.x0xO0oo
            @OXOo.OOXIXo
            public final List<DslAdapterItem> invoke(@OXOo.OOXIXo List<? extends DslAdapterItem> list, @OXOo.OOXIXo List<? extends DslAdapterItem> newDataList) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 0>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(newDataList, "newDataList");
                return newDataList;
            }
        };
        this.f5198X0o0xo = CollectionsKt__CollectionsKt.XOxIOxOx(new com.angcyo.dsladapter.filter.II0xO0());
        this.f5199XO = new ArrayList();
        this.f5197Oxx0IOOO = CollectionsKt__CollectionsKt.XOxIOxOx(new com.angcyo.dsladapter.internal.II0XooXoX(), new com.angcyo.dsladapter.internal.oO(), new com.angcyo.dsladapter.internal.xxIXOIIO());
        this.f5195II0XooXoX = new ArrayList();
        this.f5203xxIXOIIO = new ArrayList();
        this.f5202xoIox = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Handler>() { // from class: com.angcyo.dsladapter.DslDataFilter$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T] */
    public static final void oOoXoXO(Ref.BooleanRef booleanRef, Ref.ObjectRef<List<DslAdapterItem>> objectRef, com.angcyo.dsladapter.filter.XO xo2, List<? extends com.angcyo.dsladapter.filter.II0XooXoX> list) {
        if (!booleanRef.element) {
            for (com.angcyo.dsladapter.filter.II0XooXoX iI0XooXoX : list) {
                if (iI0XooXoX.oIX0oI()) {
                    ?? II0xO02 = iI0XooXoX.II0xO0(xo2);
                    objectRef.element = II0xO02;
                    xo2.x0XOIxOo((List) II0xO02);
                    if (xo2.xoIox()) {
                        booleanRef.element = true;
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T] */
    public static final void x0XOIxOo(Ref.BooleanRef booleanRef, Ref.ObjectRef<List<DslAdapterItem>> objectRef, com.angcyo.dsladapter.filter.Oxx0IOOO oxx0IOOO, List<? extends com.angcyo.dsladapter.filter.xxIXOIIO> list) {
        if (!booleanRef.element) {
            for (com.angcyo.dsladapter.filter.xxIXOIIO xxixoiio : list) {
                if (xxixoiio.oIX0oI()) {
                    ?? II0xO02 = xxixoiio.II0xO0(oxx0IOOO);
                    objectRef.element = II0xO02;
                    oxx0IOOO.x0xO0oo((List) II0xO02);
                    if (oxx0IOOO.oOoXoXO()) {
                        booleanRef.element = true;
                        return;
                    }
                }
            }
        }
    }

    public final void II0XooXoX(@OXOo.OOXIXo oOXoIIIo listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        this.f5194I0Io.add(listener);
    }

    @OXOo.OOXIXo
    public final Oox.x0xO0oo<List<? extends DslAdapterItem>, List<? extends DslAdapterItem>, List<DslAdapterItem>> IIXOooo() {
        return this.f5201oxoX;
    }

    @OXOo.OOXIXo
    public final DslAdapter IXxxXO() {
        return this.f5200oIX0oI;
    }

    public void O0xOxO(@OXOo.OOXIXo XxX0x0xxx params) {
        long j;
        XxX0x0xxx xxX0x0xxx;
        kotlin.jvm.internal.IIX0o.x0xO0oo(params, "params");
        long currentTimeMillis = System.currentTimeMillis();
        xoIox();
        if (params.Oo()) {
            j = currentTimeMillis;
            xxX0x0xxx = params.oOoXoXO((r28 & 1) != 0 ? params.f5335oIX0oI : null, (r28 & 2) != 0 ? params.f5330II0xO0 : false, (r28 & 4) != 0 ? params.f5328I0Io : false, (r28 & 8) != 0 ? params.f5336oxoX : true, (r28 & 16) != 0 ? params.f5333X0o0xo : false, (r28 & 32) != 0 ? params.f5334XO : false, (r28 & 64) != 0 ? params.f5332Oxx0IOOO : null, (r28 & 128) != 0 ? params.f5329II0XooXoX : null, (r28 & 256) != 0 ? params.f5338xxIXOIIO : 0L, (r28 & 512) != 0 ? params.f5337xoIox : 0L, (r28 & 1024) != 0 ? params.f5331OOXIXo : null);
        } else {
            j = currentTimeMillis;
            xxX0x0xxx = params;
        }
        UpdateTaskRunnable updateTaskRunnable = new UpdateTaskRunnable();
        updateTaskRunnable.OxI(xxX0x0xxx);
        updateTaskRunnable.O0xOxO(j);
        if (params.IXxxXO()) {
            updateTaskRunnable.run();
        } else {
            OxxIIOOXO().postDelayed(updateTaskRunnable, params.IIXOooo());
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.ArrayList] */
    @OXOo.OOXIXo
    public List<DslAdapterItem> OOXIXo(@OXOo.OOXIXo List<? extends DslAdapterItem> originList, @OXOo.OOXIXo List<? extends DslAdapterItem> requestList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(originList, "originList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(requestList, "requestList");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList(requestList);
        oOoXoXO(new Ref.BooleanRef(), objectRef, new com.angcyo.dsladapter.filter.XO(this.f5200oIX0oI, this, originList, requestList, false), this.f5198X0o0xo);
        return (List) this.f5201oxoX.invoke(originList, objectRef.element);
    }

    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.II0XooXoX> Oo() {
        return this.f5198X0o0xo;
    }

    public final void OxI(@OXOo.OOXIXo Oox.x0xO0oo<? super List<? extends DslAdapterItem>, ? super List<? extends DslAdapterItem>, ? extends List<? extends DslAdapterItem>> x0xo0oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xo0oo, "<set-?>");
        this.f5201oxoX = x0xo0oo;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> Oxx0xo() {
        return this.f5196II0xO0;
    }

    public final Handler OxxIIOOXO() {
        return (Handler) this.f5202xoIox.getValue();
    }

    public final void o00(@OXOo.OOXIXo oOXoIIIo listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        this.f5194I0Io.remove(listener);
    }

    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.xxIXOIIO> oI0IIXIo() {
        return this.f5197Oxx0IOOO;
    }

    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.xxIXOIIO> oO() {
        return this.f5203xxIXOIIO;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList] */
    @OXOo.OOXIXo
    public List<DslAdapterItem> ooOOo0oXI(@OXOo.OOXIXo List<? extends DslAdapterItem> originList) {
        XxX0x0xxx xxX0x0xxx;
        kotlin.jvm.internal.IIX0o.x0xO0oo(originList, "originList");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList(originList);
        DslAdapter dslAdapter = this.f5200oIX0oI;
        UpdateTaskRunnable updateTaskRunnable = (UpdateTaskRunnable) CollectionsKt___CollectionsKt.xX0ox(this.f5195II0XooXoX);
        if (updateTaskRunnable == null || (xxX0x0xxx = updateTaskRunnable.oO()) == null) {
            xxX0x0xxx = new XxX0x0xxx(null, false, false, false, false, false, null, null, 0L, 0L, null, 2047, null);
        }
        com.angcyo.dsladapter.filter.Oxx0IOOO oxx0IOOO = new com.angcyo.dsladapter.filter.Oxx0IOOO(dslAdapter, this, xxX0x0xxx, originList, originList, false);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        x0XOIxOo(booleanRef, objectRef, oxx0IOOO, this.f5199XO);
        x0XOIxOo(booleanRef, objectRef, oxx0IOOO, this.f5197Oxx0IOOO);
        x0XOIxOo(booleanRef, objectRef, oxx0IOOO, this.f5203xxIXOIIO);
        return (List) objectRef.element;
    }

    @OXOo.OOXIXo
    public final List<com.angcyo.dsladapter.filter.xxIXOIIO> x0xO0oo() {
        return this.f5199XO;
    }

    public final void xoIox() {
        Iterator<T> it = this.f5195II0XooXoX.iterator();
        while (it.hasNext()) {
            ((UpdateTaskRunnable) it.next()).oOoXoXO().set(true);
        }
        this.f5195II0XooXoX.clear();
    }

    @OXOo.OOXIXo
    public final Set<oOXoIIIo> xoXoI() {
        return this.f5194I0Io;
    }

    @OXOo.OOXIXo
    public final com.angcyo.dsladapter.filter.xxIXOIIO xxIXOIIO(@OXOo.OOXIXo Oox.oOoXoXO<? super com.angcyo.dsladapter.filter.Oxx0IOOO, ? extends List<? extends DslAdapterItem>> intercept) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(intercept, "intercept");
        II0xO0 iI0xO0 = new II0xO0(intercept);
        this.f5197Oxx0IOOO.add(iI0xO0);
        return iI0xO0;
    }
}
