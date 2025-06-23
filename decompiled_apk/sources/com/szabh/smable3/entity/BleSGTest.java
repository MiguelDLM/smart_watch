package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleSGTest extends BleWritable {

    @OOXIXo
    private SGTestType mType;

    /* JADX WARN: Multi-variable type inference failed */
    public BleSGTest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BleSGTest copy$default(BleSGTest bleSGTest, SGTestType sGTestType, int i, Object obj) {
        if ((i & 1) != 0) {
            sGTestType = bleSGTest.mType;
        }
        return bleSGTest.copy(sGTestType);
    }

    @OOXIXo
    public final SGTestType component1() {
        return this.mType;
    }

    @OOXIXo
    public final BleSGTest copy(@OOXIXo SGTestType mType) {
        IIX0o.x0xO0oo(mType, "mType");
        return new BleSGTest(mType);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mType = SGTestType.Companion.of(readUInt8());
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mType.getType());
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleSGTest) && this.mType == ((BleSGTest) obj).mType;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    @OOXIXo
    public final SGTestType getMType() {
        return this.mType;
    }

    public int hashCode() {
        return this.mType.hashCode();
    }

    public final void setMType(@OOXIXo SGTestType sGTestType) {
        IIX0o.x0xO0oo(sGTestType, "<set-?>");
        this.mType = sGTestType;
    }

    @OOXIXo
    public String toString() {
        return "BleSGTest(mType=" + this.mType + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleSGTest(SGTestType sGTestType, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? SGTestType.ENTER : sGTestType);
    }

    public BleSGTest(@OOXIXo SGTestType mType) {
        IIX0o.x0xO0oo(mType, "mType");
        this.mType = mType;
    }
}
