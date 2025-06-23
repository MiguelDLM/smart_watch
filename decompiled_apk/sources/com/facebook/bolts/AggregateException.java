package com.facebook.bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class AggregateException extends Exception {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 1;

    @OXOo.OOXIXo
    private final List<Throwable> innerThrowables;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AggregateException(@OXOo.oOoXoXO java.lang.String r2, @OXOo.oOoXoXO java.util.List<? extends java.lang.Throwable> r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L13
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L13
            r0 = 0
            java.lang.Object r0 = r3.get(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            goto L14
        L13:
            r0 = 0
        L14:
            r1.<init>(r2, r0)
            if (r3 != 0) goto L1d
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
        L1d:
            java.util.List r2 = java.util.Collections.unmodifiableList(r3)
            java.lang.String r3 = "unmodifiableList(innerThrowables ?: emptyList())"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
            r1.innerThrowables = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bolts.AggregateException.<init>(java.lang.String, java.util.List):void");
    }

    @Override // java.lang.Throwable
    public void printStackTrace(@OXOo.OOXIXo PrintStream err) {
        IIX0o.x0xO0oo(err, "err");
        super.printStackTrace(err);
        int i = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i++;
            err.append((CharSequence) String.valueOf(i));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(@OXOo.OOXIXo PrintWriter err) {
        IIX0o.x0xO0oo(err, "err");
        super.printStackTrace(err);
        int i = -1;
        for (Throwable th : this.innerThrowables) {
            err.append("\n");
            err.append("  Inner throwable #");
            i++;
            err.append((CharSequence) String.valueOf(i));
            err.append(": ");
            if (th != null) {
                th.printStackTrace(err);
            }
            err.append("\n");
        }
    }
}
