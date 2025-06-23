package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class JobDetailV2 extends JsonFieldContainer {

    @OOXIXo
    private String imageSign;

    @OOXIXo
    private String[] images;

    public /* synthetic */ JobDetailV2(String str, String[] strArr, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, strArr);
    }

    public static /* synthetic */ JobDetailV2 copy$default(JobDetailV2 jobDetailV2, String str, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jobDetailV2.imageSign;
        }
        if ((i & 2) != 0) {
            strArr = jobDetailV2.images;
        }
        return jobDetailV2.copy(str, strArr);
    }

    @OOXIXo
    public final String component1() {
        return this.imageSign;
    }

    @OOXIXo
    public final String[] component2() {
        return this.images;
    }

    @OOXIXo
    public final JobDetailV2 copy(@OOXIXo String imageSign, @OOXIXo String[] images) {
        IIX0o.x0xO0oo(imageSign, "imageSign");
        IIX0o.x0xO0oo(images, "images");
        return new JobDetailV2(imageSign, images);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JobDetailV2)) {
            return false;
        }
        JobDetailV2 jobDetailV2 = (JobDetailV2) obj;
        return IIX0o.Oxx0IOOO(this.imageSign, jobDetailV2.imageSign) && IIX0o.Oxx0IOOO(this.images, jobDetailV2.images);
    }

    @OOXIXo
    public final String getImageSign() {
        return this.imageSign;
    }

    @OOXIXo
    public final String[] getImages() {
        return this.images;
    }

    public int hashCode() {
        return (this.imageSign.hashCode() * 31) + Arrays.hashCode(this.images);
    }

    public final void setImageSign(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.imageSign = str;
    }

    public final void setImages(@OOXIXo String[] strArr) {
        IIX0o.x0xO0oo(strArr, "<set-?>");
        this.images = strArr;
    }

    @OOXIXo
    public String toString() {
        return "JobDetailV2(imageSign=" + this.imageSign + ", images=" + Arrays.toString(this.images) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public JobDetailV2(@OOXIXo String imageSign, @OOXIXo String[] images) {
        IIX0o.x0xO0oo(imageSign, "imageSign");
        IIX0o.x0xO0oo(images, "images");
        this.imageSign = imageSign;
        this.images = images;
    }
}
