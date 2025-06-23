package com.baidu.ar.arrender;

/* loaded from: classes7.dex */
public class Texture {
    public static final long NOT_CREATE_INSIDE = -1;
    public static final int NO_TEXTURE = -1;
    private long kx;
    private int mId;
    private int mType;

    public Texture() {
        this.kx = -1L;
        this.mId = -1;
        this.mType = 3553;
    }

    public long getHandle() {
        return this.kx;
    }

    public int getId() {
        return this.mId;
    }

    public int getType() {
        return this.mType;
    }

    public void setHandle(long j) {
        this.kx = j;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public Texture(int i, int i2) {
        this.kx = -1L;
        this.mId = i;
        this.mType = i2;
    }
}
