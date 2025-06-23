package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class VipBenefit extends JsonFieldContainer implements Serializable {
    private int ivIcon;

    @OOXIXo
    private String title;
    private int type;

    public VipBenefit() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ VipBenefit copy$default(VipBenefit vipBenefit, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = vipBenefit.title;
        }
        if ((i3 & 2) != 0) {
            i = vipBenefit.ivIcon;
        }
        if ((i3 & 4) != 0) {
            i2 = vipBenefit.type;
        }
        return vipBenefit.copy(str, i, i2);
    }

    @OOXIXo
    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.ivIcon;
    }

    public final int component3() {
        return this.type;
    }

    @OOXIXo
    public final VipBenefit copy(@OOXIXo String title, int i, int i2) {
        IIX0o.x0xO0oo(title, "title");
        return new VipBenefit(title, i, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipBenefit)) {
            return false;
        }
        VipBenefit vipBenefit = (VipBenefit) obj;
        return IIX0o.Oxx0IOOO(this.title, vipBenefit.title) && this.ivIcon == vipBenefit.ivIcon && this.type == vipBenefit.type;
    }

    public final int getIvIcon() {
        return this.ivIcon;
    }

    @OOXIXo
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.ivIcon) * 31) + this.type;
    }

    public final void setIvIcon(int i) {
        this.ivIcon = i;
    }

    public final void setTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.title = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @OOXIXo
    public String toString() {
        return "VipBenefit(title=" + this.title + ", ivIcon=" + this.ivIcon + ", type=" + this.type + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ VipBenefit(String str, int i, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }

    public VipBenefit(@OOXIXo String title, int i, int i2) {
        IIX0o.x0xO0oo(title, "title");
        this.title = title;
        this.ivIcon = i;
        this.type = i2;
    }
}
