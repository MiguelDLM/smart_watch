package com.kwad.components.core.q;

/* loaded from: classes11.dex */
public class a {
    private static volatile a SZ;
    private int PD;
    private int Ta;
    private boolean Tb;
    private boolean Tc;
    private int Td;
    private boolean Te;

    private a() {
    }

    public static a rj() {
        if (SZ == null) {
            synchronized (a.class) {
                try {
                    if (SZ == null) {
                        SZ = new a();
                    }
                } finally {
                }
            }
        }
        return SZ;
    }

    public final void aH(int i) {
        this.Ta = i;
    }

    public final void aI(int i) {
        this.Td = i;
    }

    public final void aJ(int i) {
        this.PD = i;
    }

    public final void aK(boolean z) {
        this.Tb = true;
    }

    public final void aL(boolean z) {
        this.Tc = z;
    }

    public final void aM(boolean z) {
        this.Te = z;
    }

    public final void clear() {
        this.Tc = false;
        this.Tb = false;
        this.Td = 0;
        this.Te = false;
        this.Ta = -1;
        this.PD = 0;
    }

    public final int rk() {
        return this.Ta;
    }

    public final boolean rl() {
        return this.Tb;
    }

    public final boolean rm() {
        return this.Tc;
    }

    public final boolean rn() {
        int i = this.Td;
        if (i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    public final int ro() {
        return this.Td;
    }

    public final boolean rp() {
        return this.Te;
    }

    public final int rq() {
        return this.PD;
    }
}
