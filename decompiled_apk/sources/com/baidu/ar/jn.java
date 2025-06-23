package com.baidu.ar;

import com.baidu.ar.arplay.representation.Number3D;

/* loaded from: classes7.dex */
public class jn {
    private String AH;
    private String AI;
    private int AJ;
    private int AK;
    private Number3D AL;
    private int cj;
    private int ck;
    private String mId;
    private String mName;

    public void O(int i) {
        this.AJ = i;
    }

    public void P(int i) {
        this.AK = i;
    }

    public void a(Number3D number3D) {
        this.AL = number3D;
    }

    public void bT(String str) {
        this.AI = str;
    }

    public String getPath() {
        return this.AH;
    }

    public String gp() {
        return this.AI;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPath(String str) {
        this.AH = str;
    }

    public void setTargetHeight(int i) {
        this.ck = i;
    }

    public void setTargetWidth(int i) {
        this.cj = i;
    }
}
