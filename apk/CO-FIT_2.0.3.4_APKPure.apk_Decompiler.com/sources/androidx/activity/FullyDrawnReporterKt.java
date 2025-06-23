package androidx.activity;

import Oox.oOoXoXO;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

public final class FullyDrawnReporterKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @OXOo.oOoXoXO
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object reportWhenComplete(@OXOo.OOXIXo androidx.activity.FullyDrawnReporter r4, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends java.lang.Object> r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            androidx.activity.FullyDrawnReporter r4 = (androidx.activity.FullyDrawnReporter) r4
            kotlin.I0oOoX.x0XOIxOo(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r5 = move-exception
            goto L_0x005d
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.I0oOoX.x0XOIxOo(r6)
            r4.addReporter()
            boolean r6 = r4.isFullyDrawnReported()
            if (r6 == 0) goto L_0x0046
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f19155oIX0oI
            return r4
        L_0x0046:
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.invoke(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0051
            return r1
        L_0x0051:
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.removeReporter()
            kotlin.jvm.internal.xxX.I0Io(r3)
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f19155oIX0oI
            return r4
        L_0x005d:
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.removeReporter()
            kotlin.jvm.internal.xxX.I0Io(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, Oox.oOoXoXO, kotlin.coroutines.I0Io):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, oOoXoXO<? super I0Io<? super oXIO0o0XI>, ? extends Object> oooxoxo, I0Io<? super oXIO0o0XI> i0Io) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return oXIO0o0XI.f19155oIX0oI;
        }
        try {
            oooxoxo.invoke(i0Io);
            xxX.oxoX(1);
            fullyDrawnReporter.removeReporter();
            xxX.I0Io(1);
            return oXIO0o0XI.f19155oIX0oI;
        } catch (Throwable th) {
            xxX.oxoX(1);
            fullyDrawnReporter.removeReporter();
            xxX.I0Io(1);
            throw th;
        }
    }
}
