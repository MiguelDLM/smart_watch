package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.download.app.k;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class TextState implements Serializable {
    private static final long serialVersionUID = 7108815858139240703L;
    private int defaultTextFlag;
    private String language;
    private int showPosition;
    private int state;
    private String text;

    /* renamed from: com.huawei.openalliance.ad.beans.metadata.TextState$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[k.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public int B() {
        return this.defaultTextFlag;
    }

    public int Code() {
        return this.showPosition;
    }

    public String I() {
        return this.language;
    }

    public int V() {
        return this.state;
    }

    public String Z() {
        return this.text;
    }

    public static int Code(k kVar) {
        switch (AnonymousClass1.Code[kVar.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 6;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return -1;
        }
    }
}
