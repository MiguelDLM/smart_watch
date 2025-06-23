package androidx.activity;

import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class FullyDrawnReporterKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.oXIO0o0XI, java.lang.Object] */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object reportWhenComplete(@OXOo.OOXIXo androidx.activity.FullyDrawnReporter r4, @OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI>, ? extends java.lang.Object> r5, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r6) {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            androidx.activity.FullyDrawnReporter r4 = (androidx.activity.FullyDrawnReporter) r4
            kotlin.I0oOoX.x0XOIxOo(r6)     // Catch: java.lang.Throwable -> L2d
            goto L51
        L2d:
            r5 = move-exception
            goto L5d
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.I0oOoX.x0XOIxOo(r6)
            r4.addReporter()
            boolean r6 = r4.isFullyDrawnReported()
            if (r6 == 0) goto L46
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r4
        L46:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2d
            r0.label = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L2d
            if (r5 != r1) goto L51
            return r1
        L51:
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.removeReporter()
            kotlin.jvm.internal.xxX.I0Io(r3)
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r4
        L5d:
            kotlin.jvm.internal.xxX.oxoX(r3)
            r4.removeReporter()
            kotlin.jvm.internal.xxX.I0Io(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, Oox.oOoXoXO, kotlin.coroutines.I0Io):java.lang.Object");
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oooxoxo, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return oXIO0o0XI.f29392oIX0oI;
        }
        try {
            oooxoxo.invoke(i0Io);
            xxX.oxoX(1);
            fullyDrawnReporter.removeReporter();
            xxX.I0Io(1);
            return oXIO0o0XI.f29392oIX0oI;
        } catch (Throwable th) {
            xxX.oxoX(1);
            fullyDrawnReporter.removeReporter();
            xxX.I0Io(1);
            throw th;
        }
    }
}
