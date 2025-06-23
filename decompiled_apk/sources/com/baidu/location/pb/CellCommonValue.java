package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class CellCommonValue extends MessageMicro {
    public static final int CELLCONNECTIONSTATUS_FIELD_NUMBER = 6;
    public static final int CELL_TYPE_FIELD_NUMBER = 1;
    public static final int MCC_FIELD_NUMBER = 2;
    public static final int MNC_FIELD_NUMBER = 3;
    public static final int REGISTERED_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_FIELD_NUMBER = 5;
    private int cachedSize;
    private int cellType_ = 0;
    private int cellconnectionstatus_;
    private boolean hasCellType;
    private boolean hasCellconnectionstatus;
    private boolean hasMcc;
    private boolean hasMnc;
    private boolean hasRegistered;
    private boolean hasTimestamp;
    private ByteStringMicro mcc_;
    private ByteStringMicro mnc_;
    private int registered_;
    private long timestamp_;

    public CellCommonValue() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.mcc_ = byteStringMicro;
        this.mnc_ = byteStringMicro;
        this.registered_ = 0;
        this.timestamp_ = 0L;
        this.cellconnectionstatus_ = 0;
        this.cachedSize = -1;
    }

    public static CellCommonValue parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CellCommonValue) new CellCommonValue().mergeFrom(bArr);
    }

    public final CellCommonValue clear() {
        clearCellType();
        clearMcc();
        clearMnc();
        clearRegistered();
        clearTimestamp();
        clearCellconnectionstatus();
        this.cachedSize = -1;
        return this;
    }

    public CellCommonValue clearCellType() {
        this.hasCellType = false;
        this.cellType_ = 0;
        return this;
    }

    public CellCommonValue clearCellconnectionstatus() {
        this.hasCellconnectionstatus = false;
        this.cellconnectionstatus_ = 0;
        return this;
    }

    public CellCommonValue clearMcc() {
        this.hasMcc = false;
        this.mcc_ = ByteStringMicro.EMPTY;
        return this;
    }

    public CellCommonValue clearMnc() {
        this.hasMnc = false;
        this.mnc_ = ByteStringMicro.EMPTY;
        return this;
    }

    public CellCommonValue clearRegistered() {
        this.hasRegistered = false;
        this.registered_ = 0;
        return this;
    }

    public CellCommonValue clearTimestamp() {
        this.hasTimestamp = false;
        this.timestamp_ = 0L;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCellType() {
        return this.cellType_;
    }

    public int getCellconnectionstatus() {
        return this.cellconnectionstatus_;
    }

    public ByteStringMicro getMcc() {
        return this.mcc_;
    }

    public ByteStringMicro getMnc() {
        return this.mnc_;
    }

    public int getRegistered() {
        return this.registered_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasCellType()) {
            i = CodedOutputStreamMicro.computeInt32Size(1, getCellType());
        } else {
            i = 0;
        }
        if (hasMcc()) {
            i += CodedOutputStreamMicro.computeBytesSize(2, getMcc());
        }
        if (hasMnc()) {
            i += CodedOutputStreamMicro.computeBytesSize(3, getMnc());
        }
        if (hasRegistered()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getRegistered());
        }
        if (hasTimestamp()) {
            i += CodedOutputStreamMicro.computeUInt64Size(5, getTimestamp());
        }
        if (hasCellconnectionstatus()) {
            i += CodedOutputStreamMicro.computeInt32Size(6, getCellconnectionstatus());
        }
        this.cachedSize = i;
        return i;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public boolean hasCellType() {
        return this.hasCellType;
    }

    public boolean hasCellconnectionstatus() {
        return this.hasCellconnectionstatus;
    }

    public boolean hasMcc() {
        return this.hasMcc;
    }

    public boolean hasMnc() {
        return this.hasMnc;
    }

    public boolean hasRegistered() {
        return this.hasRegistered;
    }

    public boolean hasTimestamp() {
        return this.hasTimestamp;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CellCommonValue setCellType(int i) {
        this.hasCellType = true;
        this.cellType_ = i;
        return this;
    }

    public CellCommonValue setCellconnectionstatus(int i) {
        this.hasCellconnectionstatus = true;
        this.cellconnectionstatus_ = i;
        return this;
    }

    public CellCommonValue setMcc(ByteStringMicro byteStringMicro) {
        this.hasMcc = true;
        this.mcc_ = byteStringMicro;
        return this;
    }

    public CellCommonValue setMnc(ByteStringMicro byteStringMicro) {
        this.hasMnc = true;
        this.mnc_ = byteStringMicro;
        return this;
    }

    public CellCommonValue setRegistered(int i) {
        this.hasRegistered = true;
        this.registered_ = i;
        return this;
    }

    public CellCommonValue setTimestamp(long j) {
        this.hasTimestamp = true;
        this.timestamp_ = j;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCellType()) {
            codedOutputStreamMicro.writeInt32(1, getCellType());
        }
        if (hasMcc()) {
            codedOutputStreamMicro.writeBytes(2, getMcc());
        }
        if (hasMnc()) {
            codedOutputStreamMicro.writeBytes(3, getMnc());
        }
        if (hasRegistered()) {
            codedOutputStreamMicro.writeInt32(4, getRegistered());
        }
        if (hasTimestamp()) {
            codedOutputStreamMicro.writeUInt64(5, getTimestamp());
        }
        if (hasCellconnectionstatus()) {
            codedOutputStreamMicro.writeInt32(6, getCellconnectionstatus());
        }
    }

    public static CellCommonValue parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CellCommonValue().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public CellCommonValue mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setCellType(codedInputStreamMicro.readInt32());
            } else if (readTag == 18) {
                setMcc(codedInputStreamMicro.readBytes());
            } else if (readTag == 26) {
                setMnc(codedInputStreamMicro.readBytes());
            } else if (readTag == 32) {
                setRegistered(codedInputStreamMicro.readInt32());
            } else if (readTag == 40) {
                setTimestamp(codedInputStreamMicro.readUInt64());
            } else if (readTag != 48) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setCellconnectionstatus(codedInputStreamMicro.readInt32());
            }
        }
    }
}
