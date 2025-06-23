package com.huawei.openalliance.ad.beans.metadata.v3.openrtb;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;
import com.sma.smartv3.util.xoIox;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class Image implements Serializable {
    private static final long serialVersionUID = 3793768731771300290L;

    @c(Code = "Ext")
    private ImageExt ext;

    @c(Code = xoIox.f24717xXxxox0I)
    private int height;
    private String localPath;
    private String url;

    @c(Code = "W")
    private int width;

    public String B() {
        return this.localPath;
    }

    public String Code() {
        return this.url;
    }

    public int I() {
        return this.height;
    }

    public int V() {
        return this.width;
    }

    public ImageExt Z() {
        return this.ext;
    }

    public void Code(int i) {
        this.width = i;
    }

    public void V(int i) {
        this.height = i;
    }

    public void Code(ImageExt imageExt) {
        this.ext = imageExt;
    }

    public void V(String str) {
        this.localPath = str;
    }

    public void Code(String str) {
        this.url = str;
    }
}
