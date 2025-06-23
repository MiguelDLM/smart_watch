package kotlinx.coroutines.debug.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.sequences.IXxxXO;
import kotlin.sequences.SequencesKt___SequencesKt;

@XX({"SMAP\nDebugCoroutineInfoImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugCoroutineInfoImpl.kt\nkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
@o0
/* loaded from: classes6.dex */
public final class DebugCoroutineInfoImpl {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final WeakReference<CoroutineContext> f29913I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @XO0OX.XO
    public final long f29914II0xO0;

    @XO0OX.XO
    @oOoXoXO
    public volatile WeakReference<IXIxx0.I0Io> _lastObservedFrame;

    @OOXIXo
    @XO0OX.XO
    public volatile String _state = oxoX.f29952oIX0oI;

    @XO0OX.XO
    @oOoXoXO
    public volatile Thread lastObservedThread;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @oOoXoXO
    public final xxIXOIIO f29915oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f29916oxoX;

    public DebugCoroutineInfoImpl(@oOoXoXO CoroutineContext coroutineContext, @oOoXoXO xxIXOIIO xxixoiio, long j) {
        this.f29915oIX0oI = xxixoiio;
        this.f29914II0xO0 = j;
        this.f29913I0Io = new WeakReference<>(coroutineContext);
    }

    @oOoXoXO
    public final CoroutineContext I0Io() {
        return this.f29913I0Io.get();
    }

    @OOXIXo
    public final List<StackTraceElement> II0XooXoX() {
        IXIxx0.I0Io XO2 = XO();
        if (XO2 == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList();
        while (XO2 != null) {
            StackTraceElement stackTraceElement = XO2.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            XO2 = XO2.getCallerFrame();
        }
        return arrayList;
    }

    public final List<StackTraceElement> II0xO0() {
        xxIXOIIO xxixoiio = this.f29915oIX0oI;
        if (xxixoiio == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return SequencesKt___SequencesKt.oox000IX(IXxxXO.II0xO0(new DebugCoroutineInfoImpl$creationStackTrace$1(this, xxixoiio, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004a -> B:11:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:10:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object OOXIXo(kotlin.sequences.oO<? super java.lang.StackTraceElement> r6, IXIxx0.I0Io r7, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            IXIxx0.I0Io r6 = (IXIxx0.I0Io) r6
            java.lang.Object r7 = r0.L$1
            kotlin.sequences.oO r7 = (kotlin.sequences.oO) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L5e
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.I0oOoX.x0XOIxOo(r8)
            r2 = r5
        L41:
            if (r7 != 0) goto L46
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        L46:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L61
            r0.L$0 = r2
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r6.II0xO0(r8, r0)
            if (r8 != r1) goto L5b
            return r1
        L5b:
            r4 = r7
            r7 = r6
            r6 = r4
        L5e:
            r4 = r7
            r7 = r6
            r6 = r4
        L61:
            IXIxx0.I0Io r7 = r7.getCallerFrame()
            if (r7 == 0) goto L68
            goto L41
        L68:
            kotlin.oXIO0o0XI r6 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.OOXIXo(kotlin.sequences.oO, IXIxx0.I0Io, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OOXIXo
    public final String Oxx0IOOO() {
        return this._state;
    }

    @OOXIXo
    public final List<StackTraceElement> X0o0xo() {
        return II0xO0();
    }

    @oOoXoXO
    public final IXIxx0.I0Io XO() {
        WeakReference<IXIxx0.I0Io> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @oOoXoXO
    public final xxIXOIIO oxoX() {
        return this.f29915oIX0oI;
    }

    @OOXIXo
    public String toString() {
        return "DebugCoroutineInfo(state=" + Oxx0IOOO() + ",context=" + I0Io() + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final synchronized void xoIox(@OOXIXo String str, @OOXIXo kotlin.coroutines.I0Io<?> i0Io, boolean z) {
        IXIxx0.I0Io i0Io2;
        try {
            if (IIX0o.Oxx0IOOO(this._state, oxoX.f29951II0xO0) && IIX0o.Oxx0IOOO(str, oxoX.f29951II0xO0) && z) {
                this.f29916oxoX++;
            } else if (this.f29916oxoX > 0 && IIX0o.Oxx0IOOO(str, oxoX.f29950I0Io)) {
                this.f29916oxoX--;
                return;
            }
            if (IIX0o.Oxx0IOOO(this._state, str) && IIX0o.Oxx0IOOO(str, oxoX.f29950I0Io) && XO() != null) {
                return;
            }
            this._state = str;
            Thread thread = null;
            if (i0Io instanceof IXIxx0.I0Io) {
                i0Io2 = (IXIxx0.I0Io) i0Io;
            } else {
                i0Io2 = null;
            }
            xxIXOIIO(i0Io2);
            if (IIX0o.Oxx0IOOO(str, oxoX.f29951II0xO0)) {
                thread = Thread.currentThread();
            }
            this.lastObservedThread = thread;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void xxIXOIIO(@oOoXoXO IXIxx0.I0Io i0Io) {
        WeakReference<IXIxx0.I0Io> weakReference;
        if (i0Io != null) {
            weakReference = new WeakReference<>(i0Io);
        } else {
            weakReference = null;
        }
        this._lastObservedFrame = weakReference;
    }
}
