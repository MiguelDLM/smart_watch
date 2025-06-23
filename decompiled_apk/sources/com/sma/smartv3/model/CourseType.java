package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CourseType extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String createBy;

    @OOXIXo
    private final String createTime;

    /* renamed from: default, reason: not valid java name */
    @OOXIXo
    private final String f9default;

    @OOXIXo
    private final String dictCode;

    @OOXIXo
    private final String dictLabel;

    @OOXIXo
    private final String dictSort;

    @OOXIXo
    private final String dictType;

    @OOXIXo
    private final String dictValue;

    @OOXIXo
    private final String remark;

    @OOXIXo
    private final String status;

    public CourseType() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @OOXIXo
    public final String component1() {
        return this.dictCode;
    }

    @OOXIXo
    public final String component10() {
        return this.remark;
    }

    @OOXIXo
    public final String component2() {
        return this.dictSort;
    }

    @OOXIXo
    public final String component3() {
        return this.dictLabel;
    }

    @OOXIXo
    public final String component4() {
        return this.dictValue;
    }

    @OOXIXo
    public final String component5() {
        return this.dictType;
    }

    @OOXIXo
    public final String component6() {
        return this.f9default;
    }

    @OOXIXo
    public final String component7() {
        return this.status;
    }

    @OOXIXo
    public final String component8() {
        return this.createBy;
    }

    @OOXIXo
    public final String component9() {
        return this.createTime;
    }

    @OOXIXo
    public final CourseType copy(@OOXIXo String dictCode, @OOXIXo String dictSort, @OOXIXo String dictLabel, @OOXIXo String dictValue, @OOXIXo String dictType, @OOXIXo String str, @OOXIXo String status, @OOXIXo String createBy, @OOXIXo String createTime, @OOXIXo String remark) {
        IIX0o.x0xO0oo(dictCode, "dictCode");
        IIX0o.x0xO0oo(dictSort, "dictSort");
        IIX0o.x0xO0oo(dictLabel, "dictLabel");
        IIX0o.x0xO0oo(dictValue, "dictValue");
        IIX0o.x0xO0oo(dictType, "dictType");
        IIX0o.x0xO0oo(str, "default");
        IIX0o.x0xO0oo(status, "status");
        IIX0o.x0xO0oo(createBy, "createBy");
        IIX0o.x0xO0oo(createTime, "createTime");
        IIX0o.x0xO0oo(remark, "remark");
        return new CourseType(dictCode, dictSort, dictLabel, dictValue, dictType, str, status, createBy, createTime, remark);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseType)) {
            return false;
        }
        CourseType courseType = (CourseType) obj;
        return IIX0o.Oxx0IOOO(this.dictCode, courseType.dictCode) && IIX0o.Oxx0IOOO(this.dictSort, courseType.dictSort) && IIX0o.Oxx0IOOO(this.dictLabel, courseType.dictLabel) && IIX0o.Oxx0IOOO(this.dictValue, courseType.dictValue) && IIX0o.Oxx0IOOO(this.dictType, courseType.dictType) && IIX0o.Oxx0IOOO(this.f9default, courseType.f9default) && IIX0o.Oxx0IOOO(this.status, courseType.status) && IIX0o.Oxx0IOOO(this.createBy, courseType.createBy) && IIX0o.Oxx0IOOO(this.createTime, courseType.createTime) && IIX0o.Oxx0IOOO(this.remark, courseType.remark);
    }

    @OOXIXo
    public final String getCreateBy() {
        return this.createBy;
    }

    @OOXIXo
    public final String getCreateTime() {
        return this.createTime;
    }

    @OOXIXo
    public final String getDefault() {
        return this.f9default;
    }

    @OOXIXo
    public final String getDictCode() {
        return this.dictCode;
    }

    @OOXIXo
    public final String getDictLabel() {
        return this.dictLabel;
    }

    @OOXIXo
    public final String getDictSort() {
        return this.dictSort;
    }

    @OOXIXo
    public final String getDictType() {
        return this.dictType;
    }

    @OOXIXo
    public final String getDictValue() {
        return this.dictValue;
    }

    @OOXIXo
    public final String getRemark() {
        return this.remark;
    }

    @OOXIXo
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((((((((((((this.dictCode.hashCode() * 31) + this.dictSort.hashCode()) * 31) + this.dictLabel.hashCode()) * 31) + this.dictValue.hashCode()) * 31) + this.dictType.hashCode()) * 31) + this.f9default.hashCode()) * 31) + this.status.hashCode()) * 31) + this.createBy.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.remark.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "CourseType(dictCode=" + this.dictCode + ", dictSort=" + this.dictSort + ", dictLabel=" + this.dictLabel + ", dictValue=" + this.dictValue + ", dictType=" + this.dictType + ", default=" + this.f9default + ", status=" + this.status + ", createBy=" + this.createBy + ", createTime=" + this.createTime + ", remark=" + this.remark + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ CourseType(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) == 0 ? str10 : "");
    }

    public CourseType(@OOXIXo String dictCode, @OOXIXo String dictSort, @OOXIXo String dictLabel, @OOXIXo String dictValue, @OOXIXo String dictType, @OOXIXo String str, @OOXIXo String status, @OOXIXo String createBy, @OOXIXo String createTime, @OOXIXo String remark) {
        IIX0o.x0xO0oo(dictCode, "dictCode");
        IIX0o.x0xO0oo(dictSort, "dictSort");
        IIX0o.x0xO0oo(dictLabel, "dictLabel");
        IIX0o.x0xO0oo(dictValue, "dictValue");
        IIX0o.x0xO0oo(dictType, "dictType");
        IIX0o.x0xO0oo(str, "default");
        IIX0o.x0xO0oo(status, "status");
        IIX0o.x0xO0oo(createBy, "createBy");
        IIX0o.x0xO0oo(createTime, "createTime");
        IIX0o.x0xO0oo(remark, "remark");
        this.dictCode = dictCode;
        this.dictSort = dictSort;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
        this.dictType = dictType;
        this.f9default = str;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.remark = remark;
    }
}
