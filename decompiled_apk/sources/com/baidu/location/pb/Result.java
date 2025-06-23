package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class Result extends MessageMicro {
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private boolean hasError;
    private boolean hasType;
    private int type_ = 0;
    private int error_ = 0;
    private int cachedSize = -1;

    public static Result parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Result) new Result().mergeFrom(bArr);
    }

    public final Result clear() {
        clearType();
        clearError();
        this.cachedSize = -1;
        return this;
    }

    public Result clearError() {
        this.hasError = false;
        this.error_ = 0;
        return this;
    }

    public Result clearType() {
        this.hasType = false;
        this.type_ = 0;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getError() {
        return this.error_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasType()) {
            i = CodedOutputStreamMicro.computeInt32Size(1, getType());
        } else {
            i = 0;
        }
        if (hasError()) {
            i += CodedOutputStreamMicro.computeSInt32Size(2, getError());
        }
        this.cachedSize = i;
        return i;
    }

    public int getType() {
        return this.type_;
    }

    public boolean hasError() {
        return this.hasError;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Result setError(int i) {
        this.hasError = true;
        this.error_ = i;
        return this;
    }

    public Result setType(int i) {
        this.hasType = true;
        this.type_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(1, getType());
        }
        if (hasError()) {
            codedOutputStreamMicro.writeSInt32(2, getError());
        }
    }

    public static Result parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Result().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public Result mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setType(codedInputStreamMicro.readInt32());
            } else if (readTag != 16) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setError(codedInputStreamMicro.readSInt32());
            }
        }
    }
}
