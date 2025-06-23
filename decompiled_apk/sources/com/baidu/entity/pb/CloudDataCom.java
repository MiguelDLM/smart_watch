package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class CloudDataCom extends MessageMicro {
    public static final int BASE_FIELD_NUMBER = 1;
    public static final int DETAIL_FIELD_NUMBER = 2;
    private boolean hasBase;
    private boolean hasDetail;
    private CloudDataBase base_ = null;
    private ByteStringMicro detail_ = ByteStringMicro.EMPTY;
    private int cachedSize = -1;

    public static CloudDataCom parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CloudDataCom().mergeFrom(codedInputStreamMicro);
    }

    public final CloudDataCom clear() {
        clearBase();
        clearDetail();
        this.cachedSize = -1;
        return this;
    }

    public CloudDataCom clearBase() {
        this.hasBase = false;
        this.base_ = null;
        return this;
    }

    public CloudDataCom clearDetail() {
        this.hasDetail = false;
        this.detail_ = ByteStringMicro.EMPTY;
        return this;
    }

    public CloudDataBase getBase() {
        return this.base_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getDetail() {
        return this.detail_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeMessageSize = hasBase() ? CodedOutputStreamMicro.computeMessageSize(1, getBase()) : 0;
        if (hasDetail()) {
            computeMessageSize += CodedOutputStreamMicro.computeBytesSize(2, getDetail());
        }
        this.cachedSize = computeMessageSize;
        return computeMessageSize;
    }

    public boolean hasBase() {
        return this.hasBase;
    }

    public boolean hasDetail() {
        return this.hasDetail;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public CloudDataCom mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                CloudDataBase cloudDataBase = new CloudDataBase();
                codedInputStreamMicro.readMessage(cloudDataBase);
                setBase(cloudDataBase);
            } else if (readTag == 18) {
                setDetail(codedInputStreamMicro.readBytes());
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public CloudDataCom setBase(CloudDataBase cloudDataBase) {
        if (cloudDataBase == null) {
            return clearBase();
        }
        this.hasBase = true;
        this.base_ = cloudDataBase;
        return this;
    }

    public CloudDataCom setDetail(ByteStringMicro byteStringMicro) {
        this.hasDetail = true;
        this.detail_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasBase()) {
            codedOutputStreamMicro.writeMessage(1, getBase());
        }
        if (hasDetail()) {
            codedOutputStreamMicro.writeBytes(2, getDetail());
        }
    }

    public static CloudDataCom parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CloudDataCom) new CloudDataCom().mergeFrom(bArr);
    }
}
