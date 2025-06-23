package kotlinx.coroutines.android;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.DeprecationLevel;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.x0xO0oo;

@XX({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n314#2,11:218\n314#2,9:229\n323#2,2:239\n17#3:238\n1#4:241\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n189#1:218,11\n197#1:229,9\n197#1:239,2\n201#1:238\n*E\n"})
/* loaded from: classes6.dex */
public final class XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    @XO0OX.XO
    @oOoXoXO
    public static final oxoX f29799II0xO0;

    @oOoXoXO
    private static volatile Choreographer choreographer = null;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f29800oIX0oI = 4611686018427387903L;

    @XX({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n1#1,18:1\n202#2,2:19\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ oO f29801XO;

        public oIX0oI(oO oOVar) {
            this.f29801XO = oOVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            XO.x0XOIxOo(this.f29801XO);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object m287constructorimpl;
        Object obj = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(new HandlerContext(X0o0xo(Looper.getMainLooper(), true), objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0));
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(I0oOoX.oIX0oI(th));
        }
        if (!Result.m293isFailureimpl(m287constructorimpl)) {
            obj = m287constructorimpl;
        }
        f29799II0xO0 = (oxoX) obj;
    }

    @OOXIXo
    @xxIXOIIO(name = TypedValues.TransitionType.S_FROM)
    @xoIox
    public static final oxoX II0XooXoX(@OOXIXo Handler handler) {
        return xoIox(handler, null, 1, null);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void OOXIXo() {
    }

    public static final Object Oxx0IOOO(kotlin.coroutines.I0Io<? super Long> i0Io) {
        x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            x0XOIxOo(x0xo0oo);
        } else {
            Xo0.X0o0xo().dispatch(x0xo0oo.getContext(), new oIX0oI(x0xo0oo));
        }
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        return o002;
    }

    @OOXIXo
    @VisibleForTesting
    public static final Handler X0o0xo(@OOXIXo Looper looper, boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT >= 28) {
                Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
                IIX0o.x0XOIxOo(invoke, "null cannot be cast to non-null type android.os.Handler");
                return (Handler) invoke;
            }
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    @oOoXoXO
    public static final Object XO(@OOXIXo kotlin.coroutines.I0Io<? super Long> i0Io) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
            x0xo0oo.IO();
            oOoXoXO(choreographer2, x0xo0oo);
            Object o002 = x0xo0oo.o00();
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            return o002;
        }
        return Oxx0IOOO(i0Io);
    }

    public static final void oOoXoXO(Choreographer choreographer2, final oO<? super Long> oOVar) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.X0o0xo
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                XO.ooOOo0oXI(oO.this, j);
            }
        });
    }

    public static final void ooOOo0oXI(oO oOVar, long j) {
        oOVar.X00IoxXI(Xo0.X0o0xo(), Long.valueOf(j));
    }

    public static final void x0XOIxOo(oO<? super Long> oOVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            IIX0o.ooOOo0oXI(choreographer2);
            choreographer = choreographer2;
        }
        oOoXoXO(choreographer2, oOVar);
    }

    public static /* synthetic */ oxoX xoIox(Handler handler, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return xxIXOIIO(handler, str);
    }

    @OOXIXo
    @xxIXOIIO(name = TypedValues.TransitionType.S_FROM)
    @xoIox
    public static final oxoX xxIXOIIO(@OOXIXo Handler handler, @oOoXoXO String str) {
        return new HandlerContext(handler, str);
    }
}
