package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class LearnCardDataItem implements Serializable {
    private final int id;
    private boolean isChoose;

    @OOXIXo
    private final String name;
    private final int path;

    @OOXIXo
    private final String size;

    public LearnCardDataItem() {
        this(0, null, null, false, 0, 31, null);
    }

    public static /* synthetic */ LearnCardDataItem copy$default(LearnCardDataItem learnCardDataItem, int i, String str, String str2, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = learnCardDataItem.id;
        }
        if ((i3 & 2) != 0) {
            str = learnCardDataItem.name;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = learnCardDataItem.size;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            z = learnCardDataItem.isChoose;
        }
        boolean z2 = z;
        if ((i3 & 16) != 0) {
            i2 = learnCardDataItem.path;
        }
        return learnCardDataItem.copy(i, str3, str4, z2, i2);
    }

    public final int component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.name;
    }

    @OOXIXo
    public final String component3() {
        return this.size;
    }

    public final boolean component4() {
        return this.isChoose;
    }

    public final int component5() {
        return this.path;
    }

    @OOXIXo
    public final LearnCardDataItem copy(int i, @OOXIXo String name, @OOXIXo String size, boolean z, int i2) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(size, "size");
        return new LearnCardDataItem(i, name, size, z, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LearnCardDataItem)) {
            return false;
        }
        LearnCardDataItem learnCardDataItem = (LearnCardDataItem) obj;
        return this.id == learnCardDataItem.id && IIX0o.Oxx0IOOO(this.name, learnCardDataItem.name) && IIX0o.Oxx0IOOO(this.size, learnCardDataItem.size) && this.isChoose == learnCardDataItem.isChoose && this.path == learnCardDataItem.path;
    }

    public final int getId() {
        return this.id;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    public final int getPath() {
        return this.path;
    }

    @OOXIXo
    public final String getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.name.hashCode()) * 31) + this.size.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isChoose)) * 31) + this.path;
    }

    public final boolean isChoose() {
        return this.isChoose;
    }

    public final void setChoose(boolean z) {
        this.isChoose = z;
    }

    @OOXIXo
    public String toString() {
        return "LearnCardDataItem(id=" + this.id + ", name=" + this.name + ", size=" + this.size + ", isChoose=" + this.isChoose + ", path=" + this.path + HexStringBuilder.COMMENT_END_CHAR;
    }

    public LearnCardDataItem(int i, @OOXIXo String name, @OOXIXo String size, boolean z, int i2) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(size, "size");
        this.id = i;
        this.name = name;
        this.size = size;
        this.isChoose = z;
        this.path = i2;
    }

    public /* synthetic */ LearnCardDataItem(int i, String str, String str2, boolean z, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "0KB" : str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? -1 : i2);
    }
}
