package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class GridKey extends MessageMicro {
    public static final int GT_FIELD_NUMBER = 3;
    public static final int GX_FIELD_NUMBER = 1;
    public static final int GY_FIELD_NUMBER = 2;
    public static final int LEN_FIELD_NUMBER = 4;
    private boolean hasGt;
    private boolean hasGx;
    private boolean hasGy;
    private boolean hasLen;
    private int gx_ = 0;
    private int gy_ = 0;
    private int gt_ = 0;
    private int len_ = 0;
    private int cachedSize = -1;

    public static GridKey parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (GridKey) new GridKey().mergeFrom(bArr);
    }

    public final GridKey clear() {
        clearGx();
        clearGy();
        clearGt();
        clearLen();
        this.cachedSize = -1;
        return this;
    }

    public GridKey clearGt() {
        this.hasGt = false;
        this.gt_ = 0;
        return this;
    }

    public GridKey clearGx() {
        this.hasGx = false;
        this.gx_ = 0;
        return this;
    }

    public GridKey clearGy() {
        this.hasGy = false;
        this.gy_ = 0;
        return this;
    }

    public GridKey clearLen() {
        this.hasLen = false;
        this.len_ = 0;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getGt() {
        return this.gt_;
    }

    public int getGx() {
        return this.gx_;
    }

    public int getGy() {
        return this.gy_;
    }

    public int getLen() {
        return this.len_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasGx()) {
            i = CodedOutputStreamMicro.computeInt32Size(1, getGx());
        } else {
            i = 0;
        }
        if (hasGy()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getGy());
        }
        if (hasGt()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getGt());
        }
        if (hasLen()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getLen());
        }
        this.cachedSize = i;
        return i;
    }

    public boolean hasGt() {
        return this.hasGt;
    }

    public boolean hasGx() {
        return this.hasGx;
    }

    public boolean hasGy() {
        return this.hasGy;
    }

    public boolean hasLen() {
        return this.hasLen;
    }

    public final boolean isInitialized() {
        return true;
    }

    public GridKey setGt(int i) {
        this.hasGt = true;
        this.gt_ = i;
        return this;
    }

    public GridKey setGx(int i) {
        this.hasGx = true;
        this.gx_ = i;
        return this;
    }

    public GridKey setGy(int i) {
        this.hasGy = true;
        this.gy_ = i;
        return this;
    }

    public GridKey setLen(int i) {
        this.hasLen = true;
        this.len_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasGx()) {
            codedOutputStreamMicro.writeInt32(1, getGx());
        }
        if (hasGy()) {
            codedOutputStreamMicro.writeInt32(2, getGy());
        }
        if (hasGt()) {
            codedOutputStreamMicro.writeInt32(3, getGt());
        }
        if (hasLen()) {
            codedOutputStreamMicro.writeInt32(4, getLen());
        }
    }

    public static GridKey parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new GridKey().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public GridKey mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setGx(codedInputStreamMicro.readInt32());
            } else if (readTag == 16) {
                setGy(codedInputStreamMicro.readInt32());
            } else if (readTag == 24) {
                setGt(codedInputStreamMicro.readInt32());
            } else if (readTag != 32) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setLen(codedInputStreamMicro.readInt32());
            }
        }
    }
}
