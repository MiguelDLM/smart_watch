package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class CourSelectByType extends JsonFieldContainer implements Serializable {

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

    public CourSelectByType() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CourSelectByType copy$default(CourSelectByType courSelectByType, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courSelectByType.dictCode;
        }
        if ((i & 2) != 0) {
            str2 = courSelectByType.dictSort;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = courSelectByType.dictLabel;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = courSelectByType.dictValue;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = courSelectByType.dictType;
        }
        return courSelectByType.copy(str, str6, str7, str8, str5);
    }

    @OOXIXo
    public final String component1() {
        return this.dictCode;
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
    public final CourSelectByType copy(@OOXIXo String dictCode, @OOXIXo String dictSort, @OOXIXo String dictLabel, @OOXIXo String dictValue, @OOXIXo String dictType) {
        IIX0o.x0xO0oo(dictCode, "dictCode");
        IIX0o.x0xO0oo(dictSort, "dictSort");
        IIX0o.x0xO0oo(dictLabel, "dictLabel");
        IIX0o.x0xO0oo(dictValue, "dictValue");
        IIX0o.x0xO0oo(dictType, "dictType");
        return new CourSelectByType(dictCode, dictSort, dictLabel, dictValue, dictType);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourSelectByType)) {
            return false;
        }
        CourSelectByType courSelectByType = (CourSelectByType) obj;
        return IIX0o.Oxx0IOOO(this.dictCode, courSelectByType.dictCode) && IIX0o.Oxx0IOOO(this.dictSort, courSelectByType.dictSort) && IIX0o.Oxx0IOOO(this.dictLabel, courSelectByType.dictLabel) && IIX0o.Oxx0IOOO(this.dictValue, courSelectByType.dictValue) && IIX0o.Oxx0IOOO(this.dictType, courSelectByType.dictType);
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

    public int hashCode() {
        return (((((((this.dictCode.hashCode() * 31) + this.dictSort.hashCode()) * 31) + this.dictLabel.hashCode()) * 31) + this.dictValue.hashCode()) * 31) + this.dictType.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "CourSelectByType(dictCode=" + this.dictCode + ", dictSort=" + this.dictSort + ", dictLabel=" + this.dictLabel + ", dictValue=" + this.dictValue + ", dictType=" + this.dictType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ CourSelectByType(String str, String str2, String str3, String str4, String str5, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    public CourSelectByType(@OOXIXo String dictCode, @OOXIXo String dictSort, @OOXIXo String dictLabel, @OOXIXo String dictValue, @OOXIXo String dictType) {
        IIX0o.x0xO0oo(dictCode, "dictCode");
        IIX0o.x0xO0oo(dictSort, "dictSort");
        IIX0o.x0xO0oo(dictLabel, "dictLabel");
        IIX0o.x0xO0oo(dictValue, "dictValue");
        IIX0o.x0xO0oo(dictType, "dictType");
        this.dictCode = dictCode;
        this.dictSort = dictSort;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
        this.dictType = dictType;
    }
}
