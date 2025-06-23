package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class JobV2Extra {

    @OOXIXo
    private String img_n;

    @OOXIXo
    private String img_style;

    /* JADX WARN: Multi-variable type inference failed */
    public JobV2Extra() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ JobV2Extra copy$default(JobV2Extra jobV2Extra, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jobV2Extra.img_style;
        }
        if ((i & 2) != 0) {
            str2 = jobV2Extra.img_n;
        }
        return jobV2Extra.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.img_style;
    }

    @OOXIXo
    public final String component2() {
        return this.img_n;
    }

    @OOXIXo
    public final JobV2Extra copy(@OOXIXo String img_style, @OOXIXo String img_n) {
        IIX0o.x0xO0oo(img_style, "img_style");
        IIX0o.x0xO0oo(img_n, "img_n");
        return new JobV2Extra(img_style, img_n);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JobV2Extra)) {
            return false;
        }
        JobV2Extra jobV2Extra = (JobV2Extra) obj;
        return IIX0o.Oxx0IOOO(this.img_style, jobV2Extra.img_style) && IIX0o.Oxx0IOOO(this.img_n, jobV2Extra.img_n);
    }

    @OOXIXo
    public final String getImg_n() {
        return this.img_n;
    }

    @OOXIXo
    public final String getImg_style() {
        return this.img_style;
    }

    public int hashCode() {
        return (this.img_style.hashCode() * 31) + this.img_n.hashCode();
    }

    public final void setImg_n(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.img_n = str;
    }

    public final void setImg_style(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.img_style = str;
    }

    @OOXIXo
    public String toString() {
        return "JobV2Extra(img_style=" + this.img_style + ", img_n=" + this.img_n + HexStringBuilder.COMMENT_END_CHAR;
    }

    public JobV2Extra(@OOXIXo String img_style, @OOXIXo String img_n) {
        IIX0o.x0xO0oo(img_style, "img_style");
        IIX0o.x0xO0oo(img_n, "img_n");
        this.img_style = img_style;
        this.img_n = img_n;
    }

    public /* synthetic */ JobV2Extra(String str, String str2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "default" : str, (i & 2) != 0 ? "1" : str2);
    }
}
