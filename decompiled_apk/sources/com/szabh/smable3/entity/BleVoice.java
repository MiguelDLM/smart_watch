package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.component.BleCache;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleVoice extends BleWritable {
    public static final int CATEGORY_INPUT_TEXT = 0;
    public static final int CATEGORY_OUTPUT_TEXT = 1;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private int mCategory;

    @OOXIXo
    private String mContent;
    private int mStatus;
    private long mTime;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public final int getCONTENT_MAX_LENGTH() {
            int i;
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.getMSupportVoiceMaxLength() == 1) {
                BleDeviceInfo mDeviceInfo = bleCache.getMDeviceInfo();
                if (mDeviceInfo != null) {
                    i = (int) mDeviceInfo.getMIOBufferSize();
                } else {
                    i = 1024;
                }
                return i - 25;
            }
            return 512;
        }

        private Companion() {
        }
    }

    public BleVoice() {
        this(0, 0L, null, 0, 15, null);
    }

    public static /* synthetic */ BleVoice copy$default(BleVoice bleVoice, int i, long j, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bleVoice.mCategory;
        }
        if ((i3 & 2) != 0) {
            j = bleVoice.mTime;
        }
        long j2 = j;
        if ((i3 & 4) != 0) {
            str = bleVoice.mContent;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            i2 = bleVoice.mStatus;
        }
        return bleVoice.copy(i, j2, str2, i2);
    }

    public final int component1() {
        return this.mCategory;
    }

    public final long component2() {
        return this.mTime;
    }

    @OOXIXo
    public final String component3() {
        return this.mContent;
    }

    public final int component4() {
        return this.mStatus;
    }

    @OOXIXo
    public final BleVoice copy(int i, long j, @OOXIXo String mContent, int i2) {
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleVoice(i, j, mContent, i2);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCategory);
        BleWritable.writeBytes$default(this, new byte[7], null, 2, null);
        writeObject(BleTime.Companion.ofLocal(this.mTime));
        byte[] bytes = this.mContent.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        int length = bytes.length;
        Companion companion = Companion;
        BleWritable.writeInt16$default(this, Math.min(length, companion.getCONTENT_MAX_LENGTH()), null, 2, null);
        BleWritable.writeStringWithLimit$default(this, this.mContent, companion.getCONTENT_MAX_LENGTH(), null, true, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleVoice)) {
            return false;
        }
        BleVoice bleVoice = (BleVoice) obj;
        return this.mCategory == bleVoice.mCategory && this.mTime == bleVoice.mTime && IIX0o.Oxx0IOOO(this.mContent, bleVoice.mContent) && this.mStatus == bleVoice.mStatus;
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
        return Math.min(bytes.length, Companion.getCONTENT_MAX_LENGTH()) + 16;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public int hashCode() {
        return (((((this.mCategory * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mContent.hashCode()) * 31) + this.mStatus;
    }

    public final void setMCategory(int i) {
        this.mCategory = i;
    }

    public final void setMContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleVoice(mCategory=");
        sb.append(this.mCategory);
        sb.append(", mTime=");
        sb.append(this.mTime);
        sb.append(", mMax=");
        sb.append(Companion.getCONTENT_MAX_LENGTH());
        sb.append(", mSize=");
        byte[] bytes = this.mContent.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        sb.append(bytes.length);
        sb.append(", mContent='");
        sb.append(this.mContent);
        sb.append("', mStatus=");
        sb.append(this.mStatus);
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        return sb.toString();
    }

    public /* synthetic */ BleVoice(int i, long j, String str, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? 0 : i2);
    }

    public BleVoice(int i, long j, @OOXIXo String mContent, int i2) {
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mCategory = i;
        this.mTime = j;
        this.mContent = mContent;
        this.mStatus = i2;
    }
}
