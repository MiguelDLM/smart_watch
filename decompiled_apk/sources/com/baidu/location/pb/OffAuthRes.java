package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class OffAuthRes extends MessageMicro {
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int ERRNUM_FIELD_NUMBER = 1;
    public static final int GKS_FIELD_NUMBER = 5;
    public static final int SN_FIELD_NUMBER = 4;
    public static final int VKEY_FIELD_NUMBER = 3;
    private int cachedSize;
    private ByteStringMicro errmsg_;
    private int errnum_ = 0;
    private List<GridKey> gks_;
    private boolean hasErrmsg;
    private boolean hasErrnum;
    private boolean hasSn;
    private boolean hasVkey;
    private ByteStringMicro sn_;
    private ByteStringMicro vkey_;

    public OffAuthRes() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.errmsg_ = byteStringMicro;
        this.vkey_ = byteStringMicro;
        this.sn_ = byteStringMicro;
        this.gks_ = Collections.emptyList();
        this.cachedSize = -1;
    }

    public static OffAuthRes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OffAuthRes) new OffAuthRes().mergeFrom(bArr);
    }

    public OffAuthRes addGks(GridKey gridKey) {
        if (gridKey == null) {
            return this;
        }
        if (this.gks_.isEmpty()) {
            this.gks_ = new ArrayList();
        }
        this.gks_.add(gridKey);
        return this;
    }

    public final OffAuthRes clear() {
        clearErrnum();
        clearErrmsg();
        clearVkey();
        clearSn();
        clearGks();
        this.cachedSize = -1;
        return this;
    }

    public OffAuthRes clearErrmsg() {
        this.hasErrmsg = false;
        this.errmsg_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffAuthRes clearErrnum() {
        this.hasErrnum = false;
        this.errnum_ = 0;
        return this;
    }

    public OffAuthRes clearGks() {
        this.gks_ = Collections.emptyList();
        return this;
    }

    public OffAuthRes clearSn() {
        this.hasSn = false;
        this.sn_ = ByteStringMicro.EMPTY;
        return this;
    }

    public OffAuthRes clearVkey() {
        this.hasVkey = false;
        this.vkey_ = ByteStringMicro.EMPTY;
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

    public GridKey getGks(int i) {
        return this.gks_.get(i);
    }

    public int getGksCount() {
        return this.gks_.size();
    }

    public List<GridKey> getGksList() {
        return this.gks_;
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
        if (hasVkey()) {
            i += CodedOutputStreamMicro.computeBytesSize(3, getVkey());
        }
        if (hasSn()) {
            i += CodedOutputStreamMicro.computeBytesSize(4, getSn());
        }
        Iterator<GridKey> it = getGksList().iterator();
        while (it.hasNext()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, it.next());
        }
        this.cachedSize = i;
        return i;
    }

    public ByteStringMicro getSn() {
        return this.sn_;
    }

    public ByteStringMicro getVkey() {
        return this.vkey_;
    }

    public boolean hasErrmsg() {
        return this.hasErrmsg;
    }

    public boolean hasErrnum() {
        return this.hasErrnum;
    }

    public boolean hasSn() {
        return this.hasSn;
    }

    public boolean hasVkey() {
        return this.hasVkey;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffAuthRes setErrmsg(ByteStringMicro byteStringMicro) {
        this.hasErrmsg = true;
        this.errmsg_ = byteStringMicro;
        return this;
    }

    public OffAuthRes setErrnum(int i) {
        this.hasErrnum = true;
        this.errnum_ = i;
        return this;
    }

    public OffAuthRes setGks(int i, GridKey gridKey) {
        if (gridKey == null) {
            return this;
        }
        this.gks_.set(i, gridKey);
        return this;
    }

    public OffAuthRes setSn(ByteStringMicro byteStringMicro) {
        this.hasSn = true;
        this.sn_ = byteStringMicro;
        return this;
    }

    public OffAuthRes setVkey(ByteStringMicro byteStringMicro) {
        this.hasVkey = true;
        this.vkey_ = byteStringMicro;
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
        if (hasVkey()) {
            codedOutputStreamMicro.writeBytes(3, getVkey());
        }
        if (hasSn()) {
            codedOutputStreamMicro.writeBytes(4, getSn());
        }
        Iterator<GridKey> it = getGksList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(5, it.next());
        }
    }

    public static OffAuthRes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OffAuthRes().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public OffAuthRes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setErrnum(codedInputStreamMicro.readInt32());
            } else if (readTag == 18) {
                setErrmsg(codedInputStreamMicro.readBytes());
            } else if (readTag == 26) {
                setVkey(codedInputStreamMicro.readBytes());
            } else if (readTag == 34) {
                setSn(codedInputStreamMicro.readBytes());
            } else if (readTag != 42) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                GridKey gridKey = new GridKey();
                codedInputStreamMicro.readMessage(gridKey);
                addGks(gridKey);
            }
        }
    }
}
