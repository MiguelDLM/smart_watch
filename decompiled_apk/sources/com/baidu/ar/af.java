package com.baidu.ar;

/* loaded from: classes7.dex */
public class af {
    private int gd;
    private boolean ge;
    private float gf;
    private long gg;
    private String id;
    private String targetName;
    private String url;

    public void E(String str) {
        this.targetName = str;
    }

    public int aM() {
        return this.gd;
    }

    public long aN() {
        return this.gg;
    }

    public boolean aO() {
        return this.ge;
    }

    public void b(long j) {
        this.gg = j;
    }

    public void f(int i) {
        this.gd = i;
    }

    public String getId() {
        return this.id;
    }

    public String getTargetName() {
        return this.targetName;
    }

    public String getUrl() {
        return this.url;
    }

    public void k(boolean z) {
        this.ge = z;
    }

    public void setDelay(float f) {
        this.gf = f;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
