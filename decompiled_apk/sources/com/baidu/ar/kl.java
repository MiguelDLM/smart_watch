package com.baidu.ar;

/* loaded from: classes7.dex */
public class kl<T> {
    private volatile T Dl;
    private volatile int Dm = 0;
    private String Dn;

    public kl(String str) {
        this.Dn = str;
    }

    public T hh() {
        if (this.Dl != null) {
            return this.Dl;
        }
        if (isAvailable()) {
            synchronized (this) {
                try {
                    if (this.Dl == null) {
                        this.Dl = (T) kr.cq(this.Dn);
                    }
                } finally {
                }
            }
        }
        return this.Dl;
    }

    public T hi() {
        return this.Dl;
    }

    public boolean isAvailable() {
        if (this.Dm == 1) {
            return true;
        }
        boolean z = false;
        if (this.Dm == -1) {
            return false;
        }
        try {
            Class.forName(this.Dn);
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        synchronized (this) {
            this.Dm = z ? 1 : -1;
        }
        return z;
    }

    public void release() {
        if (this.Dl != null) {
            this.Dl = null;
        }
    }
}
