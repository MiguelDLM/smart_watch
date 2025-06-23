package com.sma.smartv3.db.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@Entity
/* loaded from: classes12.dex */
public final class AIRecords implements Serializable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int STATUS_FAIL = 2;
    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_WAIT = 1;
    public static final int STATUS_WORKING = 3;
    public static final int TYPE_QUESTION_TIP = 6;
    public static final int TYPE_RECEIVED = 2;
    public static final int TYPE_RECEIVED_AUDIO = 3;
    public static final int TYPE_RECEIVED_PROMPT = 4;
    public static final int TYPE_RECEIVED_PROMPT_MORE = 5;
    public static final int TYPE_SEND = 1;
    public static final int TYPE_SYSTEM = 4;

    @ColumnInfo
    private final int mAIFuncType;

    @OOXIXo
    @ColumnInfo
    private String mAITitle;

    @ColumnInfo
    private int mAudioDuration;

    @OOXIXo
    @ColumnInfo
    private String mAudioPath;

    @OOXIXo
    @ColumnInfo
    private String mContent;

    @OOXIXo
    @ColumnInfo
    private String mExtraInfo;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private final int mId;

    @ColumnInfo
    private int mIsDelete;

    @ColumnInfo
    private int mIsSync;

    @OOXIXo
    @ColumnInfo
    private final String mLocalTime;

    @OOXIXo
    @ColumnInfo
    private String mLocation;

    @ColumnInfo
    private int mStatus;

    @ColumnInfo
    private long mTime;

    @OOXIXo
    @ColumnInfo
    private String mTranslateLanguage;

    @OOXIXo
    @ColumnInfo
    private String mTranslateToLanguage;

    @ColumnInfo
    private final int mType;

    @OOXIXo
    @ColumnInfo
    private String ttsVoiceName;

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public AIRecords() {
        this(0, 0L, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, null, 0, null, 131071, null);
    }

    public final int component1() {
        return this.mId;
    }

    public final int component10() {
        return this.mIsDelete;
    }

    @OOXIXo
    public final String component11() {
        return this.mAITitle;
    }

    @OOXIXo
    public final String component12() {
        return this.mTranslateLanguage;
    }

    @OOXIXo
    public final String component13() {
        return this.mTranslateToLanguage;
    }

    @OOXIXo
    public final String component14() {
        return this.mLocation;
    }

    @OOXIXo
    public final String component15() {
        return this.mAudioPath;
    }

    public final int component16() {
        return this.mAudioDuration;
    }

    @OOXIXo
    public final String component17() {
        return this.ttsVoiceName;
    }

    public final long component2() {
        return this.mTime;
    }

    @OOXIXo
    public final String component3() {
        return this.mLocalTime;
    }

    public final int component4() {
        return this.mAIFuncType;
    }

    public final int component5() {
        return this.mType;
    }

    @OOXIXo
    public final String component6() {
        return this.mContent;
    }

    @OOXIXo
    public final String component7() {
        return this.mExtraInfo;
    }

    public final int component8() {
        return this.mStatus;
    }

    public final int component9() {
        return this.mIsSync;
    }

    @OOXIXo
    public final AIRecords copy(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, @OOXIXo String mContent, @OOXIXo String mExtraInfo, int i4, int i5, int i6, @OOXIXo String mAITitle, @OOXIXo String mTranslateLanguage, @OOXIXo String mTranslateToLanguage, @OOXIXo String mLocation, @OOXIXo String mAudioPath, int i7, @OOXIXo String ttsVoiceName) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mContent, "mContent");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        IIX0o.x0xO0oo(mAITitle, "mAITitle");
        IIX0o.x0xO0oo(mTranslateLanguage, "mTranslateLanguage");
        IIX0o.x0xO0oo(mTranslateToLanguage, "mTranslateToLanguage");
        IIX0o.x0xO0oo(mLocation, "mLocation");
        IIX0o.x0xO0oo(mAudioPath, "mAudioPath");
        IIX0o.x0xO0oo(ttsVoiceName, "ttsVoiceName");
        return new AIRecords(i, j, mLocalTime, i2, i3, mContent, mExtraInfo, i4, i5, i6, mAITitle, mTranslateLanguage, mTranslateToLanguage, mLocation, mAudioPath, i7, ttsVoiceName);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIRecords)) {
            return false;
        }
        AIRecords aIRecords = (AIRecords) obj;
        return this.mId == aIRecords.mId && this.mTime == aIRecords.mTime && IIX0o.Oxx0IOOO(this.mLocalTime, aIRecords.mLocalTime) && this.mAIFuncType == aIRecords.mAIFuncType && this.mType == aIRecords.mType && IIX0o.Oxx0IOOO(this.mContent, aIRecords.mContent) && IIX0o.Oxx0IOOO(this.mExtraInfo, aIRecords.mExtraInfo) && this.mStatus == aIRecords.mStatus && this.mIsSync == aIRecords.mIsSync && this.mIsDelete == aIRecords.mIsDelete && IIX0o.Oxx0IOOO(this.mAITitle, aIRecords.mAITitle) && IIX0o.Oxx0IOOO(this.mTranslateLanguage, aIRecords.mTranslateLanguage) && IIX0o.Oxx0IOOO(this.mTranslateToLanguage, aIRecords.mTranslateToLanguage) && IIX0o.Oxx0IOOO(this.mLocation, aIRecords.mLocation) && IIX0o.Oxx0IOOO(this.mAudioPath, aIRecords.mAudioPath) && this.mAudioDuration == aIRecords.mAudioDuration && IIX0o.Oxx0IOOO(this.ttsVoiceName, aIRecords.ttsVoiceName);
    }

    public final int getMAIFuncType() {
        return this.mAIFuncType;
    }

    @OOXIXo
    public final String getMAITitle() {
        return this.mAITitle;
    }

    public final int getMAudioDuration() {
        return this.mAudioDuration;
    }

    @OOXIXo
    public final String getMAudioPath() {
        return this.mAudioPath;
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @OOXIXo
    public final String getMExtraInfo() {
        return this.mExtraInfo;
    }

    public final int getMId() {
        return this.mId;
    }

    public final int getMIsDelete() {
        return this.mIsDelete;
    }

    public final int getMIsSync() {
        return this.mIsSync;
    }

    @OOXIXo
    public final String getMLocalTime() {
        return this.mLocalTime;
    }

    @OOXIXo
    public final String getMLocation() {
        return this.mLocation;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final long getMTime() {
        return this.mTime;
    }

    @OOXIXo
    public final String getMTranslateLanguage() {
        return this.mTranslateLanguage;
    }

    @OOXIXo
    public final String getMTranslateToLanguage() {
        return this.mTranslateToLanguage;
    }

    public final int getMType() {
        return this.mType;
    }

    @OOXIXo
    public final String getTtsVoiceName() {
        return this.ttsVoiceName;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.mId * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mLocalTime.hashCode()) * 31) + this.mAIFuncType) * 31) + this.mType) * 31) + this.mContent.hashCode()) * 31) + this.mExtraInfo.hashCode()) * 31) + this.mStatus) * 31) + this.mIsSync) * 31) + this.mIsDelete) * 31) + this.mAITitle.hashCode()) * 31) + this.mTranslateLanguage.hashCode()) * 31) + this.mTranslateToLanguage.hashCode()) * 31) + this.mLocation.hashCode()) * 31) + this.mAudioPath.hashCode()) * 31) + this.mAudioDuration) * 31) + this.ttsVoiceName.hashCode();
    }

    public final void setMAITitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mAITitle = str;
    }

    public final void setMAudioDuration(int i) {
        this.mAudioDuration = i;
    }

    public final void setMAudioPath(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mAudioPath = str;
    }

    public final void setMContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMExtraInfo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mExtraInfo = str;
    }

    public final void setMIsDelete(int i) {
        this.mIsDelete = i;
    }

    public final void setMIsSync(int i) {
        this.mIsSync = i;
    }

    public final void setMLocation(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mLocation = str;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMTranslateLanguage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTranslateLanguage = str;
    }

    public final void setMTranslateToLanguage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTranslateToLanguage = str;
    }

    public final void setTtsVoiceName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.ttsVoiceName = str;
    }

    @OOXIXo
    public String toString() {
        return "AIRecords(mId=" + this.mId + ", mTime=" + this.mTime + ", mLocalTime=" + this.mLocalTime + ", mAIFuncType=" + this.mAIFuncType + ", mType=" + this.mType + ", mContent=" + this.mContent + ", mExtraInfo=" + this.mExtraInfo + ", mStatus=" + this.mStatus + ", mIsSync=" + this.mIsSync + ", mIsDelete=" + this.mIsDelete + ", mAITitle=" + this.mAITitle + ", mTranslateLanguage=" + this.mTranslateLanguage + ", mTranslateToLanguage=" + this.mTranslateToLanguage + ", mLocation=" + this.mLocation + ", mAudioPath=" + this.mAudioPath + ", mAudioDuration=" + this.mAudioDuration + ", ttsVoiceName=" + this.ttsVoiceName + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AIRecords(int i, long j, @OOXIXo String mLocalTime, int i2, int i3, @OOXIXo String mContent, @OOXIXo String mExtraInfo, int i4, int i5, int i6, @OOXIXo String mAITitle, @OOXIXo String mTranslateLanguage, @OOXIXo String mTranslateToLanguage, @OOXIXo String mLocation, @OOXIXo String mAudioPath, int i7, @OOXIXo String ttsVoiceName) {
        IIX0o.x0xO0oo(mLocalTime, "mLocalTime");
        IIX0o.x0xO0oo(mContent, "mContent");
        IIX0o.x0xO0oo(mExtraInfo, "mExtraInfo");
        IIX0o.x0xO0oo(mAITitle, "mAITitle");
        IIX0o.x0xO0oo(mTranslateLanguage, "mTranslateLanguage");
        IIX0o.x0xO0oo(mTranslateToLanguage, "mTranslateToLanguage");
        IIX0o.x0xO0oo(mLocation, "mLocation");
        IIX0o.x0xO0oo(mAudioPath, "mAudioPath");
        IIX0o.x0xO0oo(ttsVoiceName, "ttsVoiceName");
        this.mId = i;
        this.mTime = j;
        this.mLocalTime = mLocalTime;
        this.mAIFuncType = i2;
        this.mType = i3;
        this.mContent = mContent;
        this.mExtraInfo = mExtraInfo;
        this.mStatus = i4;
        this.mIsSync = i5;
        this.mIsDelete = i6;
        this.mAITitle = mAITitle;
        this.mTranslateLanguage = mTranslateLanguage;
        this.mTranslateToLanguage = mTranslateToLanguage;
        this.mLocation = mLocation;
        this.mAudioPath = mAudioPath;
        this.mAudioDuration = i7;
        this.ttsVoiceName = ttsVoiceName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AIRecords(int r20, long r21, java.lang.String r23, int r24, int r25, java.lang.String r26, java.lang.String r27, int r28, int r29, int r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, java.lang.String r37, int r38, kotlin.jvm.internal.IIXOooo r39) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.db.entity.AIRecords.<init>(int, long, java.lang.String, int, int, java.lang.String, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.IIXOooo):void");
    }
}
