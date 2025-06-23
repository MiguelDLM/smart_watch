package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class OffStatReq extends MessageMicro {
    public static final int AK_FIELD_NUMBER = 2;
    public static final int CLIENT_INFO_FIELD_NUMBER = 5;
    public static final int CU_FIELD_NUMBER = 1;
    public static final int SD_FIELD_NUMBER = 4;
    public static final int TS_FIELD_NUMBER = 3;
    private ByteStringMicro ak_;
    private int cachedSize;
    private ByteStringMicro clientInfo_;
    private ByteStringMicro cu_;
    private boolean hasAk;
    private boolean hasClientInfo;
    private boolean hasCu;
    private boolean hasSd;
    private boolean hasTs;
    private StatData sd_;
    private long ts_;

    public OffStatReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cu_ = byteStringMicro;
        this.ak_ = byteStringMicro;
        this.ts_ = 0L;
        this.sd_ = null;
        this.clientInfo_ = byteStringMicro;
        this.cachedSize = -1;
    }

    public static OffStatReq parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OffStatReq) new OffStatReq().mergeFrom(bArr);
    }

    public final OffStatReq clear() {
        clearCu();
        clearAk();
        clearTs();
        clearSd();
        clearClientInfo();
        this.cachedSize = -1;
        return this;
    }

    public OffStatReq clearAk() {
        this.hasAk = false;
        this.ak_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffStatReq clearClientInfo() {
        this.hasClientInfo = false;
        this.clientInfo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffStatReq clearCu() {
        this.hasCu = false;
        this.cu_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffStatReq clearSd() {
        this.hasSd = false;
        this.sd_ = null;
        return this;
    }

    public OffStatReq clearTs() {
        this.hasTs = false;
        this.ts_ = 0L;
        return this;
    }

    public ByteStringMicro getAk() {
        return this.ak_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getClientInfo() {
        return this.clientInfo_;
    }

    public ByteStringMicro getCu() {
        return this.cu_;
    }

    public StatData getSd() {
        return this.sd_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasCu()) {
            i = CodedOutputStreamMicro.computeBytesSize(1, getCu());
        } else {
            i = 0;
        }
        if (hasAk()) {
            i += CodedOutputStreamMicro.computeBytesSize(2, getAk());
        }
        if (hasTs()) {
            i += CodedOutputStreamMicro.computeInt64Size(3, getTs());
        }
        if (hasSd()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, getSd());
        }
        if (hasClientInfo()) {
            i += CodedOutputStreamMicro.computeBytesSize(5, getClientInfo());
        }
        this.cachedSize = i;
        return i;
    }

    public long getTs() {
        return this.ts_;
    }

    public boolean hasAk() {
        return this.hasAk;
    }

    public boolean hasClientInfo() {
        return this.hasClientInfo;
    }

    public boolean hasCu() {
        return this.hasCu;
    }

    public boolean hasSd() {
        return this.hasSd;
    }

    public boolean hasTs() {
        return this.hasTs;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffStatReq setAk(ByteStringMicro byteStringMicro) {
        this.hasAk = true;
        this.ak_ = byteStringMicro;
        return this;
    }

    public OffStatReq setClientInfo(ByteStringMicro byteStringMicro) {
        this.hasClientInfo = true;
        this.clientInfo_ = byteStringMicro;
        return this;
    }

    public OffStatReq setCu(ByteStringMicro byteStringMicro) {
        this.hasCu = true;
        this.cu_ = byteStringMicro;
        return this;
    }

    public OffStatReq setSd(StatData statData) {
        if (statData == null) {
            return clearSd();
        }
        this.hasSd = true;
        this.sd_ = statData;
        return this;
    }

    public OffStatReq setTs(long j) {
        this.hasTs = true;
        this.ts_ = j;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCu()) {
            codedOutputStreamMicro.writeBytes(1, getCu());
        }
        if (hasAk()) {
            codedOutputStreamMicro.writeBytes(2, getAk());
        }
        if (hasTs()) {
            codedOutputStreamMicro.writeInt64(3, getTs());
        }
        if (hasSd()) {
            codedOutputStreamMicro.writeMessage(4, getSd());
        }
        if (hasClientInfo()) {
            codedOutputStreamMicro.writeBytes(5, getClientInfo());
        }
    }

    public static OffStatReq parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OffStatReq().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public OffStatReq mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                setCu(codedInputStreamMicro.readBytes());
            } else if (readTag == 18) {
                setAk(codedInputStreamMicro.readBytes());
            } else if (readTag == 24) {
                setTs(codedInputStreamMicro.readInt64());
            } else if (readTag == 34) {
                StatData statData = new StatData();
                codedInputStreamMicro.readMessage(statData);
                setSd(statData);
            } else if (readTag != 42) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setClientInfo(codedInputStreamMicro.readBytes());
            }
        }
    }
}
