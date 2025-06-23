package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.oxoX;

@XX({"SMAP\nBleCoaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleCoaching.kt\ncom/szabh/smable3/entity/BleCoaching\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,50:1\n2976#2,5:51\n*S KotlinDebug\n*F\n+ 1 BleCoaching.kt\ncom/szabh/smable3/entity/BleCoaching\n*L\n24#1:51,5\n*E\n"})
/* loaded from: classes13.dex */
public final class BleCoaching extends BleIdObject {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 21;
    public static final int LENGTH_FIXED = 19;
    public static final int LENGTH_TITLE = 15;
    public static final int MAX_LENGTH_DESCRIPTION = 128;

    @OOXIXo
    private String mDescription;
    private int mRepeat;

    @OOXIXo
    private List<BleCoachingSegment> mSegments;

    @OOXIXo
    private String mTitle;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleCoaching() {
        this(null, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BleCoaching copy$default(BleCoaching bleCoaching, String str, String str2, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bleCoaching.mTitle;
        }
        if ((i2 & 2) != 0) {
            str2 = bleCoaching.mDescription;
        }
        if ((i2 & 4) != 0) {
            i = bleCoaching.mRepeat;
        }
        if ((i2 & 8) != 0) {
            list = bleCoaching.mSegments;
        }
        return bleCoaching.copy(str, str2, i, list);
    }

    private final int getMDescriptionLength() {
        byte[] bytes = this.mDescription.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return Math.min(bytes.length, 128);
    }

    private final int getMSegmentsCount() {
        return this.mSegments.size();
    }

    @OOXIXo
    public final String component1() {
        return this.mTitle;
    }

    @OOXIXo
    public final String component2() {
        return this.mDescription;
    }

    public final int component3() {
        return this.mRepeat;
    }

    @OOXIXo
    public final List<BleCoachingSegment> component4() {
        return this.mSegments;
    }

    @OOXIXo
    public final BleCoaching copy(@OOXIXo String mTitle, @OOXIXo String mDescription, int i, @OOXIXo List<BleCoachingSegment> mSegments) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mDescription, "mDescription");
        IIX0o.x0xO0oo(mSegments, "mSegments");
        return new BleCoaching(mTitle, mDescription, i, mSegments);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(getMId());
        BleWritable.writeStringWithFix$default(this, this.mTitle, 15, null, 4, null);
        writeInt8(getMDescriptionLength());
        BleWritable.writeStringWithFix$default(this, this.mDescription, getMDescriptionLength(), null, 4, null);
        writeInt8(this.mRepeat);
        writeInt8(getMSegmentsCount());
        writeList(this.mSegments);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleCoaching)) {
            return false;
        }
        BleCoaching bleCoaching = (BleCoaching) obj;
        return IIX0o.Oxx0IOOO(this.mTitle, bleCoaching.mTitle) && IIX0o.Oxx0IOOO(this.mDescription, bleCoaching.mDescription) && this.mRepeat == bleCoaching.mRepeat && IIX0o.Oxx0IOOO(this.mSegments, bleCoaching.mSegments);
    }

    @OOXIXo
    public final String getMDescription() {
        return this.mDescription;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        int mDescriptionLength = getMDescriptionLength() + 19;
        Iterator<T> it = this.mSegments.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((BleCoachingSegment) it.next()).getMLengthToWrite();
        }
        return mDescriptionLength + i;
    }

    public final int getMRepeat() {
        return this.mRepeat;
    }

    @OOXIXo
    public final List<BleCoachingSegment> getMSegments() {
        return this.mSegments;
    }

    @OOXIXo
    public final String getMTitle() {
        return this.mTitle;
    }

    public int hashCode() {
        return (((((this.mTitle.hashCode() * 31) + this.mDescription.hashCode()) * 31) + this.mRepeat) * 31) + this.mSegments.hashCode();
    }

    public final void setMDescription(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mDescription = str;
    }

    public final void setMRepeat(int i) {
        this.mRepeat = i;
    }

    public final void setMSegments(@OOXIXo List<BleCoachingSegment> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mSegments = list;
    }

    public final void setMTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTitle = str;
    }

    @OOXIXo
    public String toString() {
        return "BleCoaching(mId=" + getMId() + ", mTitle='" + this.mTitle + "', mDescription='" + this.mDescription + "', mRepeat=" + this.mRepeat + ", mSegments=" + this.mSegments + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleCoaching(String str, String str2, int i, List list, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list);
    }

    public BleCoaching(@OOXIXo String mTitle, @OOXIXo String mDescription, int i, @OOXIXo List<BleCoachingSegment> mSegments) {
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mDescription, "mDescription");
        IIX0o.x0xO0oo(mSegments, "mSegments");
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mRepeat = i;
        this.mSegments = mSegments;
    }
}
