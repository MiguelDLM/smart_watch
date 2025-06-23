package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class QrcodeTypeInfo implements Serializable {
    private int QrcodeType;

    @OOXIXo
    private byte[] data;
    private long dateTime;
    private int iconResId;

    @OOXIXo
    private String name;
    private int qrcodeStreamType;
    private int width;

    public QrcodeTypeInfo() {
        this(0, 0, 0, null, 0L, 0, null, 127, null);
    }

    public final int component1() {
        return this.qrcodeStreamType;
    }

    public final int component2() {
        return this.QrcodeType;
    }

    public final int component3() {
        return this.iconResId;
    }

    @OOXIXo
    public final String component4() {
        return this.name;
    }

    public final long component5() {
        return this.dateTime;
    }

    public final int component6() {
        return this.width;
    }

    @OOXIXo
    public final byte[] component7() {
        return this.data;
    }

    @OOXIXo
    public final QrcodeTypeInfo copy(int i, int i2, int i3, @OOXIXo String name, long j, int i4, @OOXIXo byte[] data) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(data, "data");
        return new QrcodeTypeInfo(i, i2, i3, name, j, i4, data);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrcodeTypeInfo)) {
            return false;
        }
        QrcodeTypeInfo qrcodeTypeInfo = (QrcodeTypeInfo) obj;
        return this.qrcodeStreamType == qrcodeTypeInfo.qrcodeStreamType && this.QrcodeType == qrcodeTypeInfo.QrcodeType && this.iconResId == qrcodeTypeInfo.iconResId && IIX0o.Oxx0IOOO(this.name, qrcodeTypeInfo.name) && this.dateTime == qrcodeTypeInfo.dateTime && this.width == qrcodeTypeInfo.width && IIX0o.Oxx0IOOO(this.data, qrcodeTypeInfo.data);
    }

    @OOXIXo
    public final byte[] getData() {
        return this.data;
    }

    public final long getDateTime() {
        return this.dateTime;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    public final int getQrcodeStreamType() {
        return this.qrcodeStreamType;
    }

    public final int getQrcodeType() {
        return this.QrcodeType;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((((this.qrcodeStreamType * 31) + this.QrcodeType) * 31) + this.iconResId) * 31) + this.name.hashCode()) * 31) + androidx.collection.oIX0oI.oIX0oI(this.dateTime)) * 31) + this.width) * 31) + Arrays.hashCode(this.data);
    }

    public final void setData(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.data = bArr;
    }

    public final void setDateTime(long j) {
        this.dateTime = j;
    }

    public final void setIconResId(int i) {
        this.iconResId = i;
    }

    public final void setName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.name = str;
    }

    public final void setQrcodeStreamType(int i) {
        this.qrcodeStreamType = i;
    }

    public final void setQrcodeType(int i) {
        this.QrcodeType = i;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    @OOXIXo
    public String toString() {
        return "QrcodeTypeInfo(qrcodeStreamType=" + this.qrcodeStreamType + ", QrcodeType=" + this.QrcodeType + ", iconResId=" + this.iconResId + ", name=" + this.name + ", dateTime=" + this.dateTime + ", width=" + this.width + ", data=" + Arrays.toString(this.data) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public QrcodeTypeInfo(int i, int i2, int i3, @OOXIXo String name, long j, int i4, @OOXIXo byte[] data) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(data, "data");
        this.qrcodeStreamType = i;
        this.QrcodeType = i2;
        this.iconResId = i3;
        this.name = name;
        this.dateTime = j;
        this.width = i4;
        this.data = data;
    }

    public /* synthetic */ QrcodeTypeInfo(int i, int i2, int i3, String str, long j, int i4, byte[] bArr, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? "" : str, (i5 & 16) != 0 ? 0L : j, (i5 & 32) != 0 ? 0 : i4, (i5 & 64) != 0 ? new byte[0] : bArr);
    }
}
