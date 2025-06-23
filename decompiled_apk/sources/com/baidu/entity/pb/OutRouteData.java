package com.baidu.entity.pb;

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
public final class OutRouteData extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 1;
    private List<CloudDataCom> data_ = Collections.emptyList();
    private int cachedSize = -1;

    public static OutRouteData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OutRouteData().mergeFrom(codedInputStreamMicro);
    }

    public OutRouteData addData(CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        if (this.data_.isEmpty()) {
            this.data_ = new ArrayList();
        }
        this.data_.add(cloudDataCom);
        return this;
    }

    public final OutRouteData clear() {
        clearData();
        this.cachedSize = -1;
        return this;
    }

    public OutRouteData clearData() {
        this.data_ = Collections.emptyList();
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public CloudDataCom getData(int i) {
        return this.data_.get(i);
    }

    public int getDataCount() {
        return this.data_.size();
    }

    public List<CloudDataCom> getDataList() {
        return this.data_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        Iterator<CloudDataCom> it = getDataList().iterator();
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

    @Override // com.google.protobuf.micro.MessageMicro
    public OutRouteData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                CloudDataCom cloudDataCom = new CloudDataCom();
                codedInputStreamMicro.readMessage(cloudDataCom);
                addData(cloudDataCom);
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public OutRouteData setData(int i, CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        this.data_.set(i, cloudDataCom);
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        Iterator<CloudDataCom> it = getDataList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(1, it.next());
        }
    }

    public static OutRouteData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OutRouteData) new OutRouteData().mergeFrom(bArr);
    }
}
