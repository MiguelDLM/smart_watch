package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSMSQuickReplyContent extends BleIdObject {
    public static final int CONTENT_MAX_LENGTH = 60;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 61;

    @OOXIXo
    private String mContent;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BleSMSQuickReplyContent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleSMSQuickReplyContent copy$default(BleSMSQuickReplyContent bleSMSQuickReplyContent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleSMSQuickReplyContent.mContent;
        }
        return bleSMSQuickReplyContent.copy(str);
    }

    @OOXIXo
    public final String component1() {
        return this.mContent;
    }

    @OOXIXo
    public final BleSMSQuickReplyContent copy(@OOXIXo String mContent) {
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleSMSQuickReplyContent(mContent);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(getMId());
        BleWritable.writeStringWithFix$default(this, this.mContent, 60, null, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleSMSQuickReplyContent) && IIX0o.Oxx0IOOO(this.mContent, ((BleSMSQuickReplyContent) obj).mContent);
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 61;
    }

    public int hashCode() {
        return this.mContent.hashCode();
    }

    public final void setMContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    @OOXIXo
    public String toString() {
        return "BleSMSQuickReplyContent(mId='" + getMId() + "',mContent='" + this.mContent + "')";
    }

    public /* synthetic */ BleSMSQuickReplyContent(String str, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str);
    }

    public BleSMSQuickReplyContent(@OOXIXo String mContent) {
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mContent = mContent;
    }
}
