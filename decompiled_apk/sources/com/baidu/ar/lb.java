package com.baidu.ar;

/* loaded from: classes7.dex */
public class lb {
    private int DL;
    private String DM;
    private int DO;
    private String DP;
    private String id;
    private int DN = 1000;
    private boolean DQ = true;

    public void X(int i) {
        this.DL = i;
    }

    public void Y(int i) {
        this.DN = i;
    }

    public void Z(int i) {
        this.DO = i;
    }

    public void ag(boolean z) {
        this.DQ = z;
    }

    public void ct(String str) {
        this.DM = str;
    }

    public void cu(String str) {
        this.DP = str;
    }

    public String getId() {
        return this.id;
    }

    public int hH() {
        return this.DL;
    }

    public String hI() {
        return this.DM;
    }

    public int hJ() {
        return this.DN;
    }

    public int hK() {
        return this.DO;
    }

    public boolean hL() {
        return this.DQ;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "SlamModel{id='" + this.id + "', placeType=" + this.DL + ", position='" + this.DM + "', distance=" + this.DN + ", pitchAngle=" + this.DO + ", rotation='" + this.DP + "', mImmediatelyPlaceModel=" + this.DQ + '}';
    }
}
