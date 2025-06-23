package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@kotlin.jvm.internal.XX({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n314#2,9:128\n323#2,2:141\n13#3:137\n19#3:140\n13579#4,2:138\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n*L\n71#1:128,9\n71#1:141,2\n78#1:137\n90#1:140\n83#1:138,2\n*E\n"})
/* loaded from: classes6.dex */
public final class X0o0xo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f29751II0xO0 = AtomicIntegerFieldUpdater.newUpdater(X0o0xo.class, "notCompletedCount");

    @XO0OX.o00
    private volatile int notCompletedCount;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final I0oOoX<T>[] f29752oIX0oI;

    @kotlin.jvm.internal.XX({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n13579#2,2:128\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n*L\n96#1:128,2\n*E\n"})
    /* loaded from: classes6.dex */
    public final class II0xO0 extends ooOOo0oXI {

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final X0o0xo<T>.oIX0oI[] f29754XO;

        public II0xO0(@OXOo.OOXIXo X0o0xo<T>.oIX0oI[] oix0oiArr) {
            this.f29754XO = oix0oiArr;
        }

        public final void OOXIXo() {
            for (X0o0xo<T>.oIX0oI oix0oi : this.f29754XO) {
                oix0oi.XI0IXoo().dispose();
            }
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
            xoIox(th);
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f29754XO + ']';
        }

        @Override // kotlinx.coroutines.x0XOIxOo
        public void xoIox(@OXOo.oOoXoXO Throwable th) {
            OOXIXo();
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n11335#2:128\n11670#2,3:129\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n*L\n121#1:128\n121#1:129,3\n*E\n"})
    /* loaded from: classes6.dex */
    public final class oIX0oI extends xx0X0 {

        /* renamed from: xoXoI, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final AtomicReferenceFieldUpdater f29755xoXoI = AtomicReferenceFieldUpdater.newUpdater(oIX0oI.class, Object.class, "_disposer");

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public I0oOIX f29757OxxIIOOXO;

        @OXOo.oOoXoXO
        @XO0OX.o00
        private volatile Object _disposer;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final oO<List<? extends T>> f29758oI0IIXIo;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(@OXOo.OOXIXo oO<? super List<? extends T>> oOVar) {
            this.f29758oI0IIXIo = oOVar;
        }

        @OXOo.oOoXoXO
        public final X0o0xo<T>.II0xO0 X0IIOO() {
            return (II0xO0) f29755xoXoI.get(this);
        }

        @OXOo.OOXIXo
        public final I0oOIX XI0IXoo() {
            I0oOIX i0oOIX = this.f29757OxxIIOOXO;
            if (i0oOIX != null) {
                return i0oOIX;
            }
            kotlin.jvm.internal.IIX0o.XOxIOxOx("handle");
            return null;
        }

        public final void XIxXXX0x0(@OXOo.oOoXoXO X0o0xo<T>.II0xO0 iI0xO0) {
            f29755xoXoI.set(this, iI0xO0);
        }

        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
            o00(th);
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }

        @Override // kotlinx.coroutines.xXxxox0I
        public void o00(@OXOo.oOoXoXO Throwable th) {
            if (th != null) {
                Object oo0xXOI0I2 = this.f29758oI0IIXIo.oo0xXOI0I(th);
                if (oo0xXOI0I2 != null) {
                    this.f29758oI0IIXIo.XIxXXX0x0(oo0xXOI0I2);
                    X0o0xo<T>.II0xO0 X0IIOO2 = X0IIOO();
                    if (X0IIOO2 != null) {
                        X0IIOO2.OOXIXo();
                        return;
                    }
                    return;
                }
                return;
            }
            if (X0o0xo.f29751II0xO0.decrementAndGet(X0o0xo.this) == 0) {
                oO<List<? extends T>> oOVar = this.f29758oI0IIXIo;
                I0oOoX[] i0oOoXArr = X0o0xo.this.f29752oIX0oI;
                ArrayList arrayList = new ArrayList(i0oOoXArr.length);
                for (I0oOoX i0oOoX : i0oOoXArr) {
                    arrayList.add(i0oOoX.oxoX());
                }
                Result.oIX0oI oix0oi = Result.Companion;
                oOVar.resumeWith(Result.m287constructorimpl(arrayList));
            }
        }

        public final void xxX(@OXOo.OOXIXo I0oOIX i0oOIX) {
            this.f29757OxxIIOOXO = i0oOIX;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public X0o0xo(@OXOo.OOXIXo I0oOoX<? extends T>[] i0oOoXArr) {
        this.f29752oIX0oI = i0oOoXArr;
        this.notCompletedCount = i0oOoXArr.length;
    }

    @OXOo.oOoXoXO
    public final Object I0Io(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super List<? extends T>> i0Io) {
        x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        int length = this.f29752oIX0oI.length;
        oIX0oI[] oix0oiArr = new oIX0oI[length];
        for (int i = 0; i < length; i++) {
            I0oOoX i0oOoX = this.f29752oIX0oI[i];
            i0oOoX.start();
            oIX0oI oix0oi = new oIX0oI(x0xo0oo);
            oix0oi.xxX(i0oOoX.Oo(oix0oi));
            kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
            oix0oiArr[i] = oix0oi;
        }
        X0o0xo<T>.II0xO0 iI0xO0 = new II0xO0(oix0oiArr);
        for (int i2 = 0; i2 < length; i2++) {
            oix0oiArr[i2].XIxXXX0x0(iI0xO0);
        }
        if (x0xo0oo.isCompleted()) {
            iI0xO0.OOXIXo();
        } else {
            x0xo0oo.ooXIXxIX(iI0xO0);
        }
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return o002;
    }
}
