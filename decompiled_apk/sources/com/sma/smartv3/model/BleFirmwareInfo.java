package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class BleFirmwareInfo extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private String bleName;

    @OOXIXo
    private String flag;
    private int id;
    private int projectId;

    @OOXIXo
    private String remark;

    public BleFirmwareInfo() {
        this(0, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ BleFirmwareInfo copy$default(BleFirmwareInfo bleFirmwareInfo, int i, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleFirmwareInfo.id;
        }
        if ((i3 & 2) != 0) {
            i2 = bleFirmwareInfo.projectId;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = bleFirmwareInfo.bleName;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = bleFirmwareInfo.flag;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = bleFirmwareInfo.remark;
        }
        return bleFirmwareInfo.copy(i, i4, str4, str5, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.projectId;
    }

    @OOXIXo
    public final String component3() {
        return this.bleName;
    }

    @OOXIXo
    public final String component4() {
        return this.flag;
    }

    @OOXIXo
    public final String component5() {
        return this.remark;
    }

    @OOXIXo
    public final BleFirmwareInfo copy(int i, int i2, @OOXIXo String bleName, @OOXIXo String flag, @OOXIXo String remark) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(flag, "flag");
        IIX0o.x0xO0oo(remark, "remark");
        return new BleFirmwareInfo(i, i2, bleName, flag, remark);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleFirmwareInfo)) {
            return false;
        }
        BleFirmwareInfo bleFirmwareInfo = (BleFirmwareInfo) obj;
        return this.id == bleFirmwareInfo.id && this.projectId == bleFirmwareInfo.projectId && IIX0o.Oxx0IOOO(this.bleName, bleFirmwareInfo.bleName) && IIX0o.Oxx0IOOO(this.flag, bleFirmwareInfo.flag) && IIX0o.Oxx0IOOO(this.remark, bleFirmwareInfo.remark);
    }

    @OOXIXo
    public final String getBleName() {
        return this.bleName;
    }

    @OOXIXo
    public final String getFlag() {
        return this.flag;
    }

    public final int getId() {
        return this.id;
    }

    public final int getProjectId() {
        return this.projectId;
    }

    @OOXIXo
    public final String getRemark() {
        return this.remark;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.projectId) * 31) + this.bleName.hashCode()) * 31) + this.flag.hashCode()) * 31) + this.remark.hashCode();
    }

    public final void setBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.bleName = str;
    }

    public final void setFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.flag = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setProjectId(int i) {
        this.projectId = i;
    }

    public final void setRemark(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.remark = str;
    }

    @OOXIXo
    public String toString() {
        return "BleFirmwareInfo(id=" + this.id + ", projectId=" + this.projectId + ", bleName=" + this.bleName + ", flag=" + this.flag + ", remark=" + this.remark + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleFirmwareInfo(int i, int i2, String str, String str2, String str3, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) == 0 ? i2 : 0, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3);
    }

    public BleFirmwareInfo(int i, int i2, @OOXIXo String bleName, @OOXIXo String flag, @OOXIXo String remark) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(flag, "flag");
        IIX0o.x0xO0oo(remark, "remark");
        this.id = i;
        this.projectId = i2;
        this.bleName = bleName;
        this.flag = flag;
        this.remark = remark;
    }
}
