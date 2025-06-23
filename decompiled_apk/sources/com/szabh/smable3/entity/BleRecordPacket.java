package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.garmin.fit.OOxOOxIO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleRecordPacket extends BleWritable {
    public static final int AI_MODE_BAIDU = 0;
    public static final int AI_MODE_DEEP_SEEK = 3;
    public static final int AI_MODE_OPENAI = 1;
    public static final int AI_MODE_SPARK_CHAIN = 2;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int MODE_VOICE_AI_IDENTIFY = 6;
    public static final int MODE_VOICE_AI_TRANSLATION = 2;
    public static final int MODE_VOICE_AI_WATCHFACE = 1;
    public static final int MODE_VOICE_EARPHONE_NORMAL = 3;
    public static final int MODE_VOICE_EARPHONE_TRANSLATE = 4;
    public static final int MODE_VOICE_NORMAL = 0;
    public static final int MODE_VOICE_REAL_TIME_CONVERSATION = 7;
    public static final int TRANSFER_STATUE_END_CONTEXT = 4;
    public static final int TRANSFER_STATUE_RESET = 8;
    public static final int TRANSFER_STATUE_SAVE_ANSWER = 5;
    public static final int TRANSFER_STATUE_VOICE_PLAY_START = 6;
    public static final int TRANSFER_STATUE_VOICE_PLAY_STOP = 7;
    public static final int TRANSFER_STATUS_END = 2;
    public static final int TRANSFER_STATUS_GO_ON = 1;
    public static final int TRANSFER_STATUS_REPLY_DCS = 5;
    public static final int TRANSFER_STATUS_START = 0;
    public static final int TRANSFER_STATUS_SUSPEND = 3;
    private int mAIMode;
    private int mDay;
    private int mEarDirection;
    private int mHour;
    private int mLanguage;
    private int mLength;
    private final int mLengthToWrite;
    private int mMinute;
    private int mMode;
    private int mMonth;

    @OOXIXo
    private byte[] mPacket;
    private int mSecond;
    private int mStatus;
    private int mToLanguage;
    private int mYear;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleRecordPacket() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, OOxOOxIO.f12624oIX0oI, null);
    }

    public final int component1() {
        return this.mYear;
    }

    public final int component10() {
        return this.mLanguage;
    }

    public final int component11() {
        return this.mToLanguage;
    }

    public final int component12() {
        return this.mEarDirection;
    }

    public final int component13() {
        return this.mAIMode;
    }

    @OOXIXo
    public final byte[] component14() {
        return this.mPacket;
    }

    public final int component2() {
        return this.mMonth;
    }

    public final int component3() {
        return this.mDay;
    }

    public final int component4() {
        return this.mHour;
    }

    public final int component5() {
        return this.mMinute;
    }

    public final int component6() {
        return this.mSecond;
    }

    public final int component7() {
        return this.mLength;
    }

    public final int component8() {
        return this.mStatus;
    }

    public final int component9() {
        return this.mMode;
    }

    @OOXIXo
    public final BleRecordPacket copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, @OOXIXo byte[] mPacket) {
        IIX0o.x0xO0oo(mPacket, "mPacket");
        return new BleRecordPacket(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, mPacket);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mYear = readUInt8() + 2000;
        this.mMonth = readUInt8();
        this.mDay = readUInt8();
        this.mHour = readUInt8();
        this.mMinute = readUInt8();
        this.mSecond = readUInt8();
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        this.mLength = readUInt16(LITTLE_ENDIAN);
        this.mStatus = readUInt8();
        this.mMode = readUInt8();
        this.mLanguage = readUInt8();
        this.mToLanguage = readUInt8();
        this.mEarDirection = readInt8();
        this.mAIMode = readInt8();
        readBytes(18);
        this.mPacket = readBytes(this.mLength);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mYear - 2000);
        writeInt8(this.mMonth);
        writeInt8(this.mDay);
        writeInt8(this.mHour);
        writeInt8(this.mMinute);
        writeInt8(this.mSecond);
        int i = this.mLength;
        ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
        writeInt16(i, LITTLE_ENDIAN);
        writeInt8(this.mStatus);
        writeInt8(this.mMode);
        writeInt8(this.mLanguage);
        writeInt8(this.mToLanguage);
        writeInt8(this.mEarDirection);
        writeInt8(this.mAIMode);
        BleWritable.writeBytes$default(this, new byte[18], null, 2, null);
        BleWritable.writeBytes$default(this, this.mPacket, null, 2, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleRecordPacket)) {
            return false;
        }
        BleRecordPacket bleRecordPacket = (BleRecordPacket) obj;
        return this.mYear == bleRecordPacket.mYear && this.mMonth == bleRecordPacket.mMonth && this.mDay == bleRecordPacket.mDay && this.mHour == bleRecordPacket.mHour && this.mMinute == bleRecordPacket.mMinute && this.mSecond == bleRecordPacket.mSecond && this.mLength == bleRecordPacket.mLength && this.mStatus == bleRecordPacket.mStatus && this.mMode == bleRecordPacket.mMode && this.mLanguage == bleRecordPacket.mLanguage && this.mToLanguage == bleRecordPacket.mToLanguage && this.mEarDirection == bleRecordPacket.mEarDirection && this.mAIMode == bleRecordPacket.mAIMode && IIX0o.Oxx0IOOO(this.mPacket, bleRecordPacket.mPacket);
    }

    public final int getMAIMode() {
        return this.mAIMode;
    }

    public final int getMDay() {
        return this.mDay;
    }

    public final int getMEarDirection() {
        return this.mEarDirection;
    }

    public final int getMHour() {
        return this.mHour;
    }

    public final int getMLanguage() {
        return this.mLanguage;
    }

    public final int getMLength() {
        return this.mLength;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return this.mLengthToWrite;
    }

    public final int getMMinute() {
        return this.mMinute;
    }

    public final int getMMode() {
        return this.mMode;
    }

    public final int getMMonth() {
        return this.mMonth;
    }

    @OOXIXo
    public final byte[] getMPacket() {
        return this.mPacket;
    }

    public final int getMSecond() {
        return this.mSecond;
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final int getMToLanguage() {
        return this.mToLanguage;
    }

    public final int getMYear() {
        return this.mYear;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.mYear * 31) + this.mMonth) * 31) + this.mDay) * 31) + this.mHour) * 31) + this.mMinute) * 31) + this.mSecond) * 31) + this.mLength) * 31) + this.mStatus) * 31) + this.mMode) * 31) + this.mLanguage) * 31) + this.mToLanguage) * 31) + this.mEarDirection) * 31) + this.mAIMode) * 31) + Arrays.hashCode(this.mPacket);
    }

    public final void setMAIMode(int i) {
        this.mAIMode = i;
    }

    public final void setMDay(int i) {
        this.mDay = i;
    }

    public final void setMEarDirection(int i) {
        this.mEarDirection = i;
    }

    public final void setMHour(int i) {
        this.mHour = i;
    }

    public final void setMLanguage(int i) {
        this.mLanguage = i;
    }

    public final void setMLength(int i) {
        this.mLength = i;
    }

    public final void setMMinute(int i) {
        this.mMinute = i;
    }

    public final void setMMode(int i) {
        this.mMode = i;
    }

    public final void setMMonth(int i) {
        this.mMonth = i;
    }

    public final void setMPacket(@OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<set-?>");
        this.mPacket = bArr;
    }

    public final void setMSecond(int i) {
        this.mSecond = i;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final void setMToLanguage(int i) {
        this.mToLanguage = i;
    }

    public final void setMYear(int i) {
        this.mYear = i;
    }

    @OOXIXo
    public String toString() {
        return "BleRecordPacket(mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMinute=" + this.mMinute + ", mSecond=" + this.mSecond + ", mLength=" + this.mLength + ", mStatus=" + this.mStatus + ", mMode=" + this.mMode + ", mLanguage=" + this.mLanguage + ", mToLanguage=" + this.mToLanguage + ", mEarDirection=" + this.mEarDirection + ", mAIMode=" + this.mAIMode + ", mPacket=" + this.mPacket.length + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleRecordPacket(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, byte[] bArr, int i14, IIXOooo iIXOooo) {
        this((i14 & 1) != 0 ? 0 : i, (i14 & 2) != 0 ? 0 : i2, (i14 & 4) != 0 ? 0 : i3, (i14 & 8) != 0 ? 0 : i4, (i14 & 16) != 0 ? 0 : i5, (i14 & 32) != 0 ? 0 : i6, (i14 & 64) != 0 ? 0 : i7, (i14 & 128) != 0 ? 0 : i8, (i14 & 256) != 0 ? 0 : i9, (i14 & 512) != 0 ? 0 : i10, (i14 & 1024) != 0 ? 0 : i11, (i14 & 2048) != 0 ? 0 : i12, (i14 & 4096) != 0 ? 0 : i13, (i14 & 8192) != 0 ? new byte[0] : bArr);
    }

    public BleRecordPacket(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, @OOXIXo byte[] mPacket) {
        IIX0o.x0xO0oo(mPacket, "mPacket");
        this.mYear = i;
        this.mMonth = i2;
        this.mDay = i3;
        this.mHour = i4;
        this.mMinute = i5;
        this.mSecond = i6;
        this.mLength = i7;
        this.mStatus = i8;
        this.mMode = i9;
        this.mLanguage = i10;
        this.mToLanguage = i11;
        this.mEarDirection = i12;
        this.mAIMode = i13;
        this.mPacket = mPacket;
        this.mLengthToWrite = mPacket.length + 32;
    }
}
