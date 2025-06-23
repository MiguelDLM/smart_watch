package com.huawei.openalliance.ad.beans.metadata.v3;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Data;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Image;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Title;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Video;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class Asset implements Serializable {
    private static final long serialVersionUID = 5132069519973155133L;
    private String alias;
    private String context;
    private Data data;
    private String filePath;
    private int id;
    private Image img;
    private Title title;
    private Video video;

    public Video B() {
        return this.video;
    }

    public Title C() {
        return this.title;
    }

    public int Code() {
        return this.id;
    }

    public String F() {
        return this.context;
    }

    public Data I() {
        return this.data;
    }

    public String S() {
        return this.filePath;
    }

    public String V() {
        return this.alias;
    }

    public Image Z() {
        return this.img;
    }

    public void Code(int i) {
        this.id = i;
    }

    public void I(String str) {
        this.context = str;
    }

    public void V(String str) {
        this.filePath = str;
    }

    public void Code(Data data) {
        this.data = data;
    }

    public void Code(Image image) {
        this.img = image;
    }

    public void Code(Title title) {
        this.title = title;
    }

    public void Code(Video video) {
        this.video = video;
    }

    public void Code(String str) {
        this.alias = str;
    }
}
