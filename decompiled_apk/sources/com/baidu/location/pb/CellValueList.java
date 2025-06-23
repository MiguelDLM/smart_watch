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
public final class CellValueList extends MessageMicro {
    public static final int CELL_VALUE_FIELD_NUMBER = 1;
    private List<CellValue> cellValue_ = Collections.emptyList();
    private int cachedSize = -1;

    public static CellValueList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CellValueList) new CellValueList().mergeFrom(bArr);
    }

    public CellValueList addCellValue(CellValue cellValue) {
        if (cellValue == null) {
            return this;
        }
        if (this.cellValue_.isEmpty()) {
            this.cellValue_ = new ArrayList();
        }
        this.cellValue_.add(cellValue);
        return this;
    }

    public final CellValueList clear() {
        clearCellValue();
        this.cachedSize = -1;
        return this;
    }

    public CellValueList clearCellValue() {
        this.cellValue_ = Collections.emptyList();
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public CellValue getCellValue(int i) {
        return this.cellValue_.get(i);
    }

    public int getCellValueCount() {
        return this.cellValue_.size();
    }

    public List<CellValue> getCellValueList() {
        return this.cellValue_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        Iterator<CellValue> it = getCellValueList().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
        }
        this.cachedSize = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CellValueList setCellValue(int i, CellValue cellValue) {
        if (cellValue == null) {
            return this;
        }
        this.cellValue_.set(i, cellValue);
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        Iterator<CellValue> it = getCellValueList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(1, it.next());
        }
    }

    public static CellValueList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CellValueList().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public CellValueList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                CellValue cellValue = new CellValue();
                codedInputStreamMicro.readMessage(cellValue);
                addCellValue(cellValue);
            }
        }
    }
}
