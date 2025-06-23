package com.kwad.sdk.utils;

/* loaded from: classes11.dex */
public class be {
    protected final int mHeight;
    protected final int mWidth;

    public be(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final float Ns() {
        return this.mWidth;
    }

    public final float Nt() {
        return this.mHeight;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof be) {
            be beVar = (be) obj;
            if (this.mWidth == beVar.mWidth && this.mHeight == beVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
