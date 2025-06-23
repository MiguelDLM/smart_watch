package com.sma.smartv3.biz.voice;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@kotlin.OOXIXo(message = "")
/* loaded from: classes12.dex */
public final class VoiceMessage {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int STATUS_FAIL = 2;
    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_WAIT = 1;
    public static final int STATUS_WORKING = 3;
    public static final int TYPE_RECEIVED = 2;
    public static final int TYPE_RECEIVED_AUDIO = 3;
    public static final int TYPE_SEND = 1;
    public static final int TYPE_SEND_AUDIO = 4;
    public static final int TYPE_SYSTEM = 4;

    @OXOo.OOXIXo
    private String mContent;

    @OXOo.OOXIXo
    private String mExtraInfo;
    private final int mId;

    @OXOo.OOXIXo
    private String mLocalTime;
    private int mStatus;
    private int mType;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public VoiceMessage() {
        this(0, null, 0, null, null, 0, 63, null);
    }

    public static /* synthetic */ VoiceMessage copy$default(VoiceMessage voiceMessage, int i, String str, int i2, String str2, String str3, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = voiceMessage.mId;
        }
        if ((i4 & 2) != 0) {
            str = voiceMessage.mLocalTime;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            i2 = voiceMessage.mType;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            str2 = voiceMessage.mContent;
        }
        String str5 = str2;
        if ((i4 & 16) != 0) {
            str3 = voiceMessage.mExtraInfo;
        }
        String str6 = str3;
        if ((i4 & 32) != 0) {
            i3 = voiceMessage.mStatus;
        }
        return voiceMessage.copy(i, str4, i5, str5, str6, i3);
    }

    public final int component1() {
        return this.mId;
    }

    @OXOo.OOXIXo
    public final String component2() {
        return this.mLocalTime;
    }

    public final int component3() {
        return this.mType;
    }

    @OXOo.OOXIXo
    public final String component4() {
        return this.mContent;
    }

    @OXOo.OOXIXo
    public final String component5() {
        return this.mExtraInfo;
    }

    public final int component6() {
        return this.mStatus;
    }

    @OXOo.OOXIXo
    public final VoiceMessage copy(int i, @OXOo.OOXIXo String mLocalTime, int i2, @OXOo.OOXIXo String mContent, @OXOo.OOXIXo String mExtraInfo, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mContent, "mContent");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        return new VoiceMessage(i, mLocalTime, i2, mContent, mExtraInfo, i3);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoiceMessage)) {
            return false;
        }
        VoiceMessage voiceMessage = (VoiceMessage) obj;
        return this.mId == voiceMessage.mId && IIX0o.Oxx0IOOO(this.mLocalTime, voiceMessage.mLocalTime) && this.mType == voiceMessage.mType && IIX0o.Oxx0IOOO(this.mContent, voiceMessage.mContent) && IIX0o.Oxx0IOOO(this.mExtraInfo, voiceMessage.mExtraInfo) && this.mStatus == voiceMessage.mStatus;
    }

    @OXOo.OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @OXOo.OOXIXo
    public final String getMExtraInfo() {
        return this.mExtraInfo;
    }

    public final int getMId() {
        return this.mId;
    }

    @OXOo.OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final int getMType() {
        return this.mType;
    }

    public int hashCode() {
        return (((((((((this.mId * 31) + this.mLocalTime.hashCode()) * 31) + this.mType) * 31) + this.mContent.hashCode()) * 31) + this.mExtraInfo.hashCode()) * 31) + this.mStatus;
    }

    public final void setMContent(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMExtraInfo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mExtraInfo = str;
    }

    public final void setMLocalTime(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocalTime = str;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "VoiceMessage(mId=" + this.mId + ", mLocalTime=" + this.mLocalTime + ", mType=" + this.mType + ", mContent=" + this.mContent + ", mExtraInfo=" + this.mExtraInfo + ", mStatus=" + this.mStatus + HexStringBuilder.COMMENT_END_CHAR;
    }

    public VoiceMessage(int i, @OXOo.OOXIXo String mLocalTime, int i2, @OXOo.OOXIXo String mContent, @OXOo.OOXIXo String mExtraInfo, int i3) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mContent, "mContent");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        this.mId = i;
        this.mLocalTime = mLocalTime;
        this.mType = i2;
        this.mContent = mContent;
        this.mExtraInfo = mExtraInfo;
        this.mStatus = i3;
    }

    public /* synthetic */ VoiceMessage(int i, String str, int i2, String str2, String str3, int i3, int i4, IIXOooo iIXOooo) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? "" : str2, (i4 & 16) == 0 ? str3 : "", (i4 & 32) != 0 ? 0 : i3);
    }
}
