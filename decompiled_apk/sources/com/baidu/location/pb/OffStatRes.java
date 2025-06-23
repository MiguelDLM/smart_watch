package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class OffStatRes extends MessageMicro {
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int ERRNUM_FIELD_NUMBER = 1;
    private boolean hasErrmsg;
    private boolean hasErrnum;
    private int errnum_ = 0;
    private ByteStringMicro errmsg_ = ByteStringMicro.EMPTY;
    private int cachedSize = -1;

    public static OffStatRes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OffStatRes) new OffStatRes().mergeFrom(bArr);
    }

    public final OffStatRes clear() {
        clearErrnum();
        clearErrmsg();
        this.cachedSize = -1;
        return this;
    }

    public OffStatRes clearErrmsg() {
        this.hasErrmsg = false;
        this.errmsg_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffStatRes clearErrnum() {
        this.hasErrnum = false;
        this.errnum_ = 0;
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
        this.cachedSize = i;
        return i;
    }

    public boolean hasErrmsg() {
        return this.hasErrmsg;
    }

    public boolean hasErrnum() {
        return this.hasErrnum;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffStatRes setErrmsg(ByteStringMicro byteStringMicro) {
        this.hasErrmsg = true;
        this.errmsg_ = byteStringMicro;
        return this;
    }

    public OffStatRes setErrnum(int i) {
        this.hasErrnum = true;
        this.errnum_ = i;
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
    }

    public static OffStatRes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OffStatRes().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public OffStatRes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setErrnum(codedInputStreamMicro.readInt32());
            } else if (readTag != 18) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setErrmsg(codedInputStreamMicro.readBytes());
            }
        }
    }
}
