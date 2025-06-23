package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class OffDataRes extends MessageMicro {
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int ERRNUM_FIELD_NUMBER = 1;
    public static final int GV_FIELD_NUMBER = 3;
    private int cachedSize;
    private ByteStringMicro errmsg_;
    private int errnum_ = 0;
    private ByteStringMicro gv_;
    private boolean hasErrmsg;
    private boolean hasErrnum;
    private boolean hasGv;

    public OffDataRes() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.errmsg_ = byteStringMicro;
        this.gv_ = byteStringMicro;
        this.cachedSize = -1;
    }

    public static OffDataRes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OffDataRes) new OffDataRes().mergeFrom(bArr);
    }

    public final OffDataRes clear() {
        clearErrnum();
        clearErrmsg();
        clearGv();
        this.cachedSize = -1;
        return this;
    }

    public OffDataRes clearErrmsg() {
        this.hasErrmsg = false;
        this.errmsg_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffDataRes clearErrnum() {
        this.hasErrnum = false;
        this.errnum_ = 0;
        return this;
    }

    public OffDataRes clearGv() {
        this.hasGv = false;
        this.gv_ = ByteStringMicro.EMPTY;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getErrmsg() {
        return this.errmsg_;
    }

    public int getErrnum() {
        return this.errnum_;
    }

    public ByteStringMicro getGv() {
        return this.gv_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasErrnum()) {
            i = CodedOutputStreamMicro.computeInt32Size(1, getErrnum());
        } else {
            i = 0;
        }
        if (hasErrmsg()) {
            i += CodedOutputStreamMicro.computeBytesSize(2, getErrmsg());
        }
        if (hasGv()) {
            i += CodedOutputStreamMicro.computeBytesSize(3, getGv());
        }
        this.cachedSize = i;
        return i;
    }

    public boolean hasErrmsg() {
        return this.hasErrmsg;
    }

    public boolean hasErrnum() {
        return this.hasErrnum;
    }

    public boolean hasGv() {
        return this.hasGv;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffDataRes setErrmsg(ByteStringMicro byteStringMicro) {
        this.hasErrmsg = true;
        this.errmsg_ = byteStringMicro;
        return this;
    }

    public OffDataRes setErrnum(int i) {
        this.hasErrnum = true;
        this.errnum_ = i;
        return this;
    }

    public OffDataRes setGv(ByteStringMicro byteStringMicro) {
        this.hasGv = true;
        this.gv_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasErrnum()) {
            codedOutputStreamMicro.writeInt32(1, getErrnum());
        }
        if (hasErrmsg()) {
            codedOutputStreamMicro.writeBytes(2, getErrmsg());
        }
        if (hasGv()) {
            codedOutputStreamMicro.writeBytes(3, getGv());
        }
    }

    public static OffDataRes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OffDataRes().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public OffDataRes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setErrnum(codedInputStreamMicro.readInt32());
            } else if (readTag == 18) {
                setErrmsg(codedInputStreamMicro.readBytes());
            } else if (readTag != 26) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setGv(codedInputStreamMicro.readBytes());
            }
        }
    }
}
