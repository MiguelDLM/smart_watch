package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import com.bestmafen.baseble.data.BleWritable;
import com.bluetrum.fota.manager.OtaCommandGenerator;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.TimeZone;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleTimeZone extends BleWritable {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 1;
    private int mOffset = TimeZone.getDefault().getOffset(System.currentTimeMillis());

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mOffset = readInt8() * OtaCommandGenerator.CMD_OTA_INFO;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(((this.mOffset / 1000) / 60) / 15);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 1;
    }

    @OOXIXo
    public String toString() {
        return "BleTimeZone(mOffset=" + this.mOffset + HexStringBuilder.COMMENT_END_CHAR;
    }
}
