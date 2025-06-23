package kotlinx.coroutines.android;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.IIXOooo;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.I0oOIX;
import kotlinx.coroutines.IIX0;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.XoX;
import kotlinx.coroutines.oO;
import kotlinx.coroutines.x0OIX00oO;

@XX({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,217:1\n1#2:218\n17#3:219\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n*L\n147#1:219\n*E\n"})
/* loaded from: classes6.dex */
public final class HandlerContext extends oxoX implements XoX {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final boolean f29790IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @oOoXoXO
    public final String f29791Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public final HandlerContext f29792Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final Handler f29793XO;

    @oOoXoXO
    private volatile HandlerContext _immediate;

    @XX({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n148#2:19\n149#2:21\n1#3:20\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ HandlerContext f29794Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ oO f29795XO;

        public oIX0oI(oO oOVar, HandlerContext handlerContext) {
            this.f29795XO = oOVar;
            this.f29794Oo = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f29795XO.X00IoxXI(this.f29794Oo, oXIO0o0XI.f29392oIX0oI);
        }
    }

    public HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.f29793XO = handler;
        this.f29791Oo = str;
        this.f29790IXxxXO = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.f29792Oxx0xo = handlerContext;
    }

    public static final void ooXIXxIX(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f29793XO.removeCallbacks(runnable);
    }

    @Override // kotlinx.coroutines.XoX
    public void OOXIXo(long j, @OOXIXo oO<? super oXIO0o0XI> oOVar) {
        final oIX0oI oix0oi = new oIX0oI(oOVar, this);
        if (this.f29793XO.postDelayed(oix0oi, IIXOooo.XIxXXX0x0(j, 4611686018427387903L))) {
            oOVar.ooXIXxIX(new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                    invoke2(th);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@oOoXoXO Throwable th) {
                    Handler handler;
                    handler = HandlerContext.this.f29793XO;
                    handler.removeCallbacks(oix0oi);
                }
            });
        } else {
            xxX(oOVar.getContext(), oix0oi);
        }
    }

    @Override // kotlinx.coroutines.android.oxoX, kotlinx.coroutines.XoX
    @OOXIXo
    public I0oOIX Oxx0xo(long j, @OOXIXo final Runnable runnable, @OOXIXo CoroutineContext coroutineContext) {
        if (this.f29793XO.postDelayed(runnable, IIXOooo.XIxXXX0x0(j, 4611686018427387903L))) {
            return new I0oOIX() { // from class: kotlinx.coroutines.android.I0Io
                @Override // kotlinx.coroutines.I0oOIX
                public final void dispose() {
                    HandlerContext.ooXIXxIX(HandlerContext.this, runnable);
                }
            };
        }
        xxX(coroutineContext, runnable);
        return x0OIX00oO.f30462XO;
    }

    @Override // kotlinx.coroutines.android.oxoX
    @OOXIXo
    /* renamed from: XxX0x0xxx, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public HandlerContext o00() {
        return this.f29792Oxx0xo;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@OOXIXo CoroutineContext coroutineContext, @OOXIXo Runnable runnable) {
        if (!this.f29793XO.post(runnable)) {
            xxX(coroutineContext, runnable);
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if ((obj instanceof HandlerContext) && ((HandlerContext) obj).f29793XO == this.f29793XO) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f29793XO);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@OOXIXo CoroutineContext coroutineContext) {
        if (this.f29790IXxxXO && IIX0o.Oxx0IOOO(Looper.myLooper(), this.f29793XO.getLooper())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.o0oIxOo, kotlinx.coroutines.CoroutineDispatcher
    @OOXIXo
    public String toString() {
        String xoXoI2 = xoXoI();
        if (xoXoI2 == null) {
            String str = this.f29791Oo;
            if (str == null) {
                str = this.f29793XO.toString();
            }
            if (this.f29790IXxxXO) {
                return str + ".immediate";
            }
            return str;
        }
        return xoXoI2;
    }

    public final void xxX(CoroutineContext coroutineContext, Runnable runnable) {
        IIX0.XO(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Xo0.I0Io().dispatch(coroutineContext, runnable);
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(@OOXIXo Handler handler, @oOoXoXO String str) {
        this(handler, str, false);
    }
}
