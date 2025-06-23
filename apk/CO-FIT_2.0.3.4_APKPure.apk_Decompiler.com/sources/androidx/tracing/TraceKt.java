package androidx.tracing;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.oOoXoXO;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;

public final class TraceKt {
    public static final <T> T trace(@OOXIXo String str, @OOXIXo oIX0oI<? extends T> oix0oi) {
        IIX0o.x0xO0oo(str, TTDownloadField.TT_LABEL);
        IIX0o.x0xO0oo(oix0oi, "block");
        Trace.beginSection(str);
        try {
            return oix0oi.invoke();
        } finally {
            xxX.oxoX(1);
            Trace.endSection();
            xxX.I0Io(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object traceAsync(@OXOo.OOXIXo java.lang.String r4, int r5, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super T>, ? extends java.lang.Object> r6, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> r7) {
        /*
            boolean r0 = r7 instanceof androidx.tracing.TraceKt$traceAsync$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.tracing.TraceKt$traceAsync$1 r0 = (androidx.tracing.TraceKt$traceAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.tracing.TraceKt$traceAsync$1 r0 = new androidx.tracing.TraceKt$traceAsync$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r5 = r0.I$0
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.I0oOoX.x0XOIxOo(r7)     // Catch:{ all -> 0x002f }
            goto L_0x004c
        L_0x002f:
            r6 = move-exception
            goto L_0x0056
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.I0oOoX.x0XOIxOo(r7)
            androidx.tracing.Trace.beginAsyncSection(r4, r5)
            r0.L$0 = r4     // Catch:{ all -> 0x002f }
            r0.I$0 = r5     // Catch:{ all -> 0x002f }
            r0.label = r3     // Catch:{ all -> 0x002f }
            java.lang.Object r7 = r6.invoke(r0)     // Catch:{ all -> 0x002f }
            if (r7 != r1) goto L_0x004c
            return r1
        L_0x004c:
            kotlin.jvm.internal.xxX.oxoX(r3)
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            kotlin.jvm.internal.xxX.I0Io(r3)
            return r7
        L_0x0056:
            kotlin.jvm.internal.xxX.oxoX(r3)
            androidx.tracing.Trace.endAsyncSection(r4, r5)
            kotlin.jvm.internal.xxX.I0Io(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.tracing.TraceKt.traceAsync(java.lang.String, int, Oox.oOoXoXO, kotlin.coroutines.I0Io):java.lang.Object");
    }

    private static final <T> Object traceAsync$$forInline(String str, int i, oOoXoXO<? super I0Io<? super T>, ? extends Object> oooxoxo, I0Io<? super T> i0Io) {
        Trace.beginAsyncSection(str, i);
        try {
            return oooxoxo.invoke(i0Io);
        } finally {
            xxX.oxoX(1);
            Trace.endAsyncSection(str, i);
            xxX.I0Io(1);
        }
    }

    public static final <T> T trace(@OOXIXo oIX0oI<String> oix0oi, @OOXIXo oIX0oI<? extends T> oix0oi2) {
        IIX0o.x0xO0oo(oix0oi, "lazyLabel");
        IIX0o.x0xO0oo(oix0oi2, "block");
        boolean isEnabled = Trace.isEnabled();
        if (isEnabled) {
            Trace.beginSection(oix0oi.invoke());
        }
        try {
            return oix0oi2.invoke();
        } finally {
            xxX.oxoX(1);
            if (isEnabled) {
                Trace.endSection();
            }
            xxX.I0Io(1);
        }
    }

    public static final <T> T traceAsync(@OOXIXo oIX0oI<String> oix0oi, @OOXIXo oIX0oI<Integer> oix0oi2, @OOXIXo oIX0oI<? extends T> oix0oi3) {
        int i;
        String str;
        IIX0o.x0xO0oo(oix0oi, "lazyMethodName");
        IIX0o.x0xO0oo(oix0oi2, "lazyCookie");
        IIX0o.x0xO0oo(oix0oi3, "block");
        if (Trace.isEnabled()) {
            str = oix0oi.invoke();
            i = oix0oi2.invoke().intValue();
            Trace.beginAsyncSection(str, i);
        } else {
            str = null;
            i = 0;
        }
        try {
            return oix0oi3.invoke();
        } finally {
            xxX.oxoX(1);
            if (str != null) {
                Trace.endAsyncSection(str, i);
            }
            xxX.I0Io(1);
        }
    }
}
