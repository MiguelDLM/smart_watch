package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import java.nio.ByteOrder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleNewsFeed extends BleWritable {
    public static final int CONTENT_MAX_LENGTH = 470;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int TITLE_LENGTH = 32;
    private int mCategory;

    @OOXIXo
    private String mContent;
    private long mTime;

    @OOXIXo
    private String mTitle;
    private int mUid;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleNewsFeed() {
        this(0, 0, 0L, null, null, 31, null);
    }

    public static /* synthetic */ BleNewsFeed copy$default(BleNewsFeed bleNewsFeed, int i, int i2, long j, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleNewsFeed.mCategory;
        }
        if ((i3 & 2) != 0) {
            i2 = bleNewsFeed.mUid;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            j = bleNewsFeed.mTime;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            str = bleNewsFeed.mTitle;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            str2 = bleNewsFeed.mContent;
        }
        return bleNewsFeed.copy(i, i4, j2, str3, str2);
    }

    public final int component1() {
        return this.mCategory;
    }

    public final int component2() {
        return this.mUid;
    }

    public final long component3() {
        return this.mTime;
    }

    @OOXIXo
    public final String component4() {
        return this.mTitle;
    }

    @OOXIXo
    public final String component5() {
        return this.mContent;
    }

    @OOXIXo
    public final BleNewsFeed copy(int i, int i2, long j, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleNewsFeed(i, i2, j, mTitle, mContent);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCategory);
        int i = this.mUid;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt24(i, LITTLE_ENDIAN);
        writeObject(BleTime.Companion.ofLocal(this.mTime));
        BleWritable.writeStringWithFix$default(this, this.mTitle, 32, null, 4, null);
        BleWritable.writeStringWithLimit$default(this, this.mContent, CONTENT_MAX_LENGTH, null, true, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleNewsFeed)) {
            return false;
        }
        BleNewsFeed bleNewsFeed = (BleNewsFeed) obj;
        return this.mCategory == bleNewsFeed.mCategory && this.mUid == bleNewsFeed.mUid && this.mTime == bleNewsFeed.mTime && IIX0o.Oxx0IOOO(this.mTitle, bleNewsFeed.mTitle) && IIX0o.Oxx0IOOO(this.mContent, bleNewsFeed.mContent);
    }

    public final int getMCategory() {
        return this.mCategory;
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        byte[] bytes = this.mContent.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return Math.min(bytes.length, CONTENT_MAX_LENGTH) + 42;
    }

    public final long getMTime() {
        return this.mTime;
    }

    @OOXIXo
    public final String getMTitle() {
        return this.mTitle;
    }

    public final int getMUid() {
        return this.mUid;
    }

    public int hashCode() {
        return (((((((this.mCategory * 31) + this.mUid) * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mTitle.hashCode()) * 31) + this.mContent.hashCode();
    }

    public final void setMCategory(int i) {
        this.mCategory = i;
    }

    public final void setMContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTitle = str;
    }

    public final void setMUid(int i) {
        this.mUid = i;
    }

    @OOXIXo
    public String toString() {
        return "BleNotification(mCategory=" + this.mCategory + ", mUid=" + this.mUid + ", mTime=" + this.mTime + ", mTitle='" + this.mTitle + "', mContent='" + this.mContent + "')";
    }

    public /* synthetic */ BleNewsFeed(int i, int i2, long j, String str, String str2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) == 0 ? i2 : 0, (i3 & 4) != 0 ? 0L : j, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? "" : str2);
    }

    public BleNewsFeed(int i, int i2, long j, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mCategory = i;
        this.mUid = i2;
        this.mTime = j;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }
}
