package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AudioBookItem implements Serializable {

    @OOXIXo
    private String binOnlinePath;
    private final int id;
    private boolean isChoose;
    private boolean isShowNewFlag;

    @OOXIXo
    private String mPackage;
    private int mSize;

    @OOXIXo
    private final String name;

    @OOXIXo
    private final String onlinePath;
    private final int size;

    public AudioBookItem() {
        this(0, null, 0, false, null, null, false, null, 0, 511, null);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.size;
    }

    public final boolean component4() {
        return this.isChoose;
    }

    @OOXIXo
    public final String component5() {
        return this.onlinePath;
    }

    @OOXIXo
    public final String component6() {
        return this.binOnlinePath;
    }

    public final boolean component7() {
        return this.isShowNewFlag;
    }

    @OOXIXo
    public final String component8() {
        return this.mPackage;
    }

    public final int component9() {
        return this.mSize;
    }

    @OOXIXo
    public final AudioBookItem copy(int i, @OOXIXo String name, int i2, boolean z, @OOXIXo String onlinePath, @OOXIXo String binOnlinePath, boolean z2, @OOXIXo String mPackage, int i3) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(onlinePath, "onlinePath");
        IIX0o.x0xO0oo(binOnlinePath, "binOnlinePath");
        IIX0o.x0xO0oo(mPackage, "mPackage");
        return new AudioBookItem(i, name, i2, z, onlinePath, binOnlinePath, z2, mPackage, i3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioBookItem)) {
            return false;
        }
        AudioBookItem audioBookItem = (AudioBookItem) obj;
        return this.id == audioBookItem.id && IIX0o.Oxx0IOOO(this.name, audioBookItem.name) && this.size == audioBookItem.size && this.isChoose == audioBookItem.isChoose && IIX0o.Oxx0IOOO(this.onlinePath, audioBookItem.onlinePath) && IIX0o.Oxx0IOOO(this.binOnlinePath, audioBookItem.binOnlinePath) && this.isShowNewFlag == audioBookItem.isShowNewFlag && IIX0o.Oxx0IOOO(this.mPackage, audioBookItem.mPackage) && this.mSize == audioBookItem.mSize;
    }

    @OOXIXo
    public final String getBinOnlinePath() {
        return this.binOnlinePath;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getMPackage() {
        return this.mPackage;
    }

    public final int getMSize() {
        return this.mSize;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final String getOnlinePath() {
        return this.onlinePath;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((((((((((((this.id * 31) + this.name.hashCode()) * 31) + this.size) * 31) + androidx.work.oIX0oI.oIX0oI(this.isChoose)) * 31) + this.onlinePath.hashCode()) * 31) + this.binOnlinePath.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isShowNewFlag)) * 31) + this.mPackage.hashCode()) * 31) + this.mSize;
    }

    public final boolean isChoose() {
        return this.isChoose;
    }

    public final boolean isShowNewFlag() {
        return this.isShowNewFlag;
    }

    public final void setBinOnlinePath(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.binOnlinePath = str;
    }

    public final void setChoose(boolean z) {
        this.isChoose = z;
    }

    public final void setMPackage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPackage = str;
    }

    public final void setMSize(int i) {
        this.mSize = i;
    }

    public final void setShowNewFlag(boolean z) {
        this.isShowNewFlag = z;
    }

    @OOXIXo
    public String toString() {
        return "AudioBookItem(id=" + this.id + ", name=" + this.name + ", size=" + this.size + ", isChoose=" + this.isChoose + ", onlinePath=" + this.onlinePath + ", binOnlinePath=" + this.binOnlinePath + ", isShowNewFlag=" + this.isShowNewFlag + ", mPackage=" + this.mPackage + ", mSize=" + this.mSize + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AudioBookItem(int i, @OOXIXo String name, int i2, boolean z, @OOXIXo String onlinePath, @OOXIXo String binOnlinePath, boolean z2, @OOXIXo String mPackage, int i3) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(onlinePath, "onlinePath");
        IIX0o.x0xO0oo(binOnlinePath, "binOnlinePath");
        IIX0o.x0xO0oo(mPackage, "mPackage");
        this.id = i;
        this.name = name;
        this.size = i2;
        this.isChoose = z;
        this.onlinePath = onlinePath;
        this.binOnlinePath = binOnlinePath;
        this.isShowNewFlag = z2;
        this.mPackage = mPackage;
        this.mSize = i3;
    }

    public /* synthetic */ AudioBookItem(int i, String str, int i2, boolean z, String str2, String str3, boolean z2, String str4, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? "" : str2, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? false : z2, (i4 & 128) == 0 ? str4 : "", (i4 & 256) == 0 ? i3 : 0);
    }
}
