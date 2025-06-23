package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class GridTypeLen extends MessageMicro {
    public static final int GL_FIELD_NUMBER = 2;
    public static final int GT_FIELD_NUMBER = 1;
    private boolean hasGl;
    private boolean hasGt;
    private int gt_ = 0;
    private int gl_ = 0;
    private int cachedSize = -1;

    public static GridTypeLen parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (GridTypeLen) new GridTypeLen().mergeFrom(bArr);
    }

    public final GridTypeLen clear() {
        clearGt();
        clearGl();
        this.cachedSize = -1;
        return this;
    }

    public GridTypeLen clearGl() {
        this.hasGl = false;
        this.gl_ = 0;
        return this;
    }

    public GridTypeLen clearGt() {
        this.hasGt = false;
        this.gt_ = 0;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getGl() {
        return this.gl_;
    }

    public int getGt() {
        return this.gt_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasGt()) {
            i = CodedOutputStreamMicro.computeInt32Size(1, getGt());
        } else {
            i = 0;
        }
        if (hasGl()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getGl());
        }
        this.cachedSize = i;
        return i;
    }

    public boolean hasGl() {
        return this.hasGl;
    }

    public boolean hasGt() {
        return this.hasGt;
    }

    public final boolean isInitialized() {
        return true;
    }

    public GridTypeLen setGl(int i) {
        this.hasGl = true;
        this.gl_ = i;
        return this;
    }

    public GridTypeLen setGt(int i) {
        this.hasGt = true;
        this.gt_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasGt()) {
            codedOutputStreamMicro.writeInt32(1, getGt());
        }
        if (hasGl()) {
            codedOutputStreamMicro.writeInt32(2, getGl());
        }
    }

    public static GridTypeLen parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new GridTypeLen().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public GridTypeLen mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setGt(codedInputStreamMicro.readInt32());
            } else if (readTag != 16) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setGl(codedInputStreamMicro.readInt32());
            }
        }
    }
}
