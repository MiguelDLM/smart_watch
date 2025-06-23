package com.baidu.location.pb;

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
public final class GridValue extends MessageMicro {
    public static final int DV_FIELD_NUMBER = 2;
    public static final int GK_FIELD_NUMBER = 1;
    public static final int IS_COMPRESSED_FIELD_NUMBER = 4;
    public static final int LEN_FIELD_NUMBER = 3;
    public static final int ORIG_FIELD_NUMBER = 5;
    private boolean hasGk;
    private boolean hasIsCompressed;
    private boolean hasLen;
    private boolean hasOrig;
    private GridKey gk_ = null;
    private List<DataValue> dv_ = Collections.emptyList();
    private int len_ = 0;
    private boolean isCompressed_ = false;
    private Loc orig_ = null;
    private int cachedSize = -1;

    public static GridValue parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (GridValue) new GridValue().mergeFrom(bArr);
    }

    public GridValue addDv(DataValue dataValue) {
        if (dataValue == null) {
            return this;
        }
        if (this.dv_.isEmpty()) {
            this.dv_ = new ArrayList();
        }
        this.dv_.add(dataValue);
        return this;
    }

    public final GridValue clear() {
        clearGk();
        clearDv();
        clearLen();
        clearIsCompressed();
        clearOrig();
        this.cachedSize = -1;
        return this;
    }

    public GridValue clearDv() {
        this.dv_ = Collections.emptyList();
        return this;
    }

    public GridValue clearGk() {
        this.hasGk = false;
        this.gk_ = null;
        return this;
    }

    public GridValue clearIsCompressed() {
        this.hasIsCompressed = false;
        this.isCompressed_ = false;
        return this;
    }

    public GridValue clearLen() {
        this.hasLen = false;
        this.len_ = 0;
        return this;
    }

    public GridValue clearOrig() {
        this.hasOrig = false;
        this.orig_ = null;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public DataValue getDv(int i) {
        return this.dv_.get(i);
    }

    public int getDvCount() {
        return this.dv_.size();
    }

    public List<DataValue> getDvList() {
        return this.dv_;
    }

    public GridKey getGk() {
        return this.gk_;
    }

    public boolean getIsCompressed() {
        return this.isCompressed_;
    }

    public int getLen() {
        return this.len_;
    }

    public Loc getOrig() {
        return this.orig_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasGk()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, getGk());
        } else {
            i = 0;
        }
        Iterator<DataValue> it = getDvList().iterator();
        while (it.hasNext()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, it.next());
        }
        if (hasLen()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getLen());
        }
        if (hasIsCompressed()) {
            i += CodedOutputStreamMicro.computeBoolSize(4, getIsCompressed());
        }
        if (hasOrig()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, getOrig());
        }
        this.cachedSize = i;
        return i;
    }

    public boolean hasGk() {
        return this.hasGk;
    }

    public boolean hasIsCompressed() {
        return this.hasIsCompressed;
    }

    public boolean hasLen() {
        return this.hasLen;
    }

    public boolean hasOrig() {
        return this.hasOrig;
    }

    public final boolean isInitialized() {
        return true;
    }

    public GridValue setDv(int i, DataValue dataValue) {
        if (dataValue == null) {
            return this;
        }
        this.dv_.set(i, dataValue);
        return this;
    }

    public GridValue setGk(GridKey gridKey) {
        if (gridKey == null) {
            return clearGk();
        }
        this.hasGk = true;
        this.gk_ = gridKey;
        return this;
    }

    public GridValue setIsCompressed(boolean z) {
        this.hasIsCompressed = true;
        this.isCompressed_ = z;
        return this;
    }

    public GridValue setLen(int i) {
        this.hasLen = true;
        this.len_ = i;
        return this;
    }

    public GridValue setOrig(Loc loc) {
        if (loc == null) {
            return clearOrig();
        }
        this.hasOrig = true;
        this.orig_ = loc;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasGk()) {
            codedOutputStreamMicro.writeMessage(1, getGk());
        }
        Iterator<DataValue> it = getDvList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(2, it.next());
        }
        if (hasLen()) {
            codedOutputStreamMicro.writeInt32(3, getLen());
        }
        if (hasIsCompressed()) {
            codedOutputStreamMicro.writeBool(4, getIsCompressed());
        }
        if (hasOrig()) {
            codedOutputStreamMicro.writeMessage(5, getOrig());
        }
    }

    public static GridValue parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new GridValue().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public GridValue mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                GridKey gridKey = new GridKey();
                codedInputStreamMicro.readMessage(gridKey);
                setGk(gridKey);
            } else if (readTag == 18) {
                DataValue dataValue = new DataValue();
                codedInputStreamMicro.readMessage(dataValue);
                addDv(dataValue);
            } else if (readTag == 24) {
                setLen(codedInputStreamMicro.readInt32());
            } else if (readTag == 32) {
                setIsCompressed(codedInputStreamMicro.readBool());
            } else if (readTag != 42) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                Loc loc = new Loc();
                codedInputStreamMicro.readMessage(loc);
                setOrig(loc);
            }
        }
    }
}
