package com.kwad.framework.filedownloader.message;

/* loaded from: classes11.dex */
public final class e {
    private volatile g aii;
    private volatile b aij;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final e aik = new e();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e wJ() {
        return a.aik;
    }

    public final void a(b bVar) {
        this.aij = bVar;
        if (bVar == null) {
            this.aii = null;
        } else {
            this.aii = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.aij != null) {
                this.aij.r(messageSnapshot);
            }
        } else if (this.aii != null) {
            this.aii.u(messageSnapshot);
        }
    }
}
