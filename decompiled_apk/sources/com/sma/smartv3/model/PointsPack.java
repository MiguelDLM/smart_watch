package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class PointsPack extends JsonFieldContainer implements Serializable {
    private float amount;
    private int id;
    private boolean isSelect;
    private float originalAmount;

    @OOXIXo
    private String packName;
    private boolean recommend;

    public PointsPack() {
        this(0, null, 0.0f, 0.0f, false, false, 63, null);
    }

    public static /* synthetic */ PointsPack copy$default(PointsPack pointsPack, int i, String str, float f, float f2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pointsPack.id;
        }
        if ((i2 & 2) != 0) {
            str = pointsPack.packName;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            f = pointsPack.originalAmount;
        }
        float f3 = f;
        if ((i2 & 8) != 0) {
            f2 = pointsPack.amount;
        }
        float f4 = f2;
        if ((i2 & 16) != 0) {
            z = pointsPack.recommend;
        }
        boolean z3 = z;
        if ((i2 & 32) != 0) {
            z2 = pointsPack.isSelect;
        }
        return pointsPack.copy(i, str2, f3, f4, z3, z2);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.packName;
    }

    public final float component3() {
        return this.originalAmount;
    }

    public final float component4() {
        return this.amount;
    }

    public final boolean component5() {
        return this.recommend;
    }

    public final boolean component6() {
        return this.isSelect;
    }

    @OOXIXo
    public final PointsPack copy(int i, @OOXIXo String packName, float f, float f2, boolean z, boolean z2) {
        IIX0o.x0xO0oo(packName, "packName");
        return new PointsPack(i, packName, f, f2, z, z2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointsPack)) {
            return false;
        }
        PointsPack pointsPack = (PointsPack) obj;
        return this.id == pointsPack.id && IIX0o.Oxx0IOOO(this.packName, pointsPack.packName) && Float.compare(this.originalAmount, pointsPack.originalAmount) == 0 && Float.compare(this.amount, pointsPack.amount) == 0 && this.recommend == pointsPack.recommend && this.isSelect == pointsPack.isSelect;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final int getId() {
        return this.id;
    }

    public final float getOriginalAmount() {
        return this.originalAmount;
    }

    @OOXIXo
    public final String getPackName() {
        return this.packName;
    }

    public final boolean getRecommend() {
        return this.recommend;
    }

    public int hashCode() {
        return (((((((((this.id * 31) + this.packName.hashCode()) * 31) + Float.floatToIntBits(this.originalAmount)) * 31) + Float.floatToIntBits(this.amount)) * 31) + androidx.work.oIX0oI.oIX0oI(this.recommend)) * 31) + androidx.work.oIX0oI.oIX0oI(this.isSelect);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setAmount(float f) {
        this.amount = f;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setOriginalAmount(float f) {
        this.originalAmount = f;
    }

    public final void setPackName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.packName = str;
    }

    public final void setRecommend(boolean z) {
        this.recommend = z;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    @OOXIXo
    public String toString() {
        return "PointsPack(id=" + this.id + ", packName=" + this.packName + ", originalAmount=" + this.originalAmount + ", amount=" + this.amount + ", recommend=" + this.recommend + ", isSelect=" + this.isSelect + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ PointsPack(int i, String str, float f, float f2, boolean z, boolean z2, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0.0f : f, (i2 & 8) != 0 ? 0.0f : f2, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2);
    }

    public PointsPack(int i, @OOXIXo String packName, float f, float f2, boolean z, boolean z2) {
        IIX0o.x0xO0oo(packName, "packName");
        this.id = i;
        this.packName = packName;
        this.originalAmount = f;
        this.amount = f2;
        this.recommend = z;
        this.isSelect = z2;
    }
}
