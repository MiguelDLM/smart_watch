package com.baidu.ar;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes7.dex */
public class hk implements Parcelable {
    public static final Parcelable.Creator<hk> CREATOR = new Parcelable.Creator<hk>() { // from class: com.baidu.ar.hk.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public hk[] newArray(int i) {
            return new hk[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public hk createFromParcel(Parcel parcel) {
            hk hkVar = new hk();
            hkVar.wg = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.arKey = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.nV = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wh = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wi = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wj = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wk = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wl = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wm = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wn = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.tag = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wo = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wp = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wq = (String) parcel.readValue(String.class.getClassLoader());
            hkVar.wr = (String) parcel.readValue(String.class.getClassLoader());
            return hkVar;
        }
    };
    private String arKey;
    private String nV;
    private String tag;
    private String wg;
    private String wh;
    private String wi;
    private String wj;
    private String wk;
    private String wl;
    private String wm;
    private String wn;
    private String wo;
    private String wp;
    private String wq;
    private String wr;

    public void U(String str) {
        this.nV = str;
    }

    public void be(String str) {
        this.wg = str;
    }

    public void bf(String str) {
        this.wh = str;
    }

    public void bg(String str) {
        this.wi = str;
    }

    public void bh(String str) {
        this.wj = str;
    }

    public void bi(String str) {
        this.wk = str;
    }

    public void bj(String str) {
        this.wl = str;
    }

    public void bk(String str) {
        this.wm = str;
    }

    public void bl(String str) {
        this.wn = str;
    }

    public void bm(String str) {
        this.tag = str;
    }

    public void bn(String str) {
        this.wo = str;
    }

    public void bo(String str) {
        this.wp = str;
    }

    public void bp(String str) {
        this.wq = str;
    }

    public void bq(String str) {
        this.wr = str;
    }

    public String cJ() {
        return this.nV;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String fd() {
        return this.wg;
    }

    public String getArKey() {
        return this.arKey;
    }

    public void setArKey(String str) {
        this.arKey = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.wg);
        parcel.writeValue(this.arKey);
        parcel.writeValue(this.nV);
        parcel.writeValue(this.wh);
        parcel.writeValue(this.wi);
        parcel.writeValue(this.wj);
        parcel.writeValue(this.wk);
        parcel.writeValue(this.wl);
        parcel.writeValue(this.wm);
        parcel.writeValue(this.wn);
        parcel.writeValue(this.tag);
        parcel.writeValue(this.wo);
        parcel.writeValue(this.wp);
        parcel.writeValue(this.wq);
        parcel.writeValue(this.wr);
    }
}
