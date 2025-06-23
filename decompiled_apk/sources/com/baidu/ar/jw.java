package com.baidu.ar;

/* loaded from: classes7.dex */
public class jw {
    private int Bz = -1;
    private int BA = -1;

    public boolean X(boolean z) {
        int i = this.BA;
        if (i != -1) {
            this.Bz = i;
            this.BA = !z ? 1 : 0;
        } else if (z) {
            this.Bz = i;
            this.BA = 0;
        }
        return this.BA != -1;
    }

    public boolean gC() {
        int i = this.Bz;
        return (i == 1 || i == -1) && this.BA == 0;
    }

    public boolean gD() {
        return this.Bz == 0 && this.BA == 1;
    }

    public void reset() {
        this.Bz = -1;
        this.BA = -1;
    }
}
