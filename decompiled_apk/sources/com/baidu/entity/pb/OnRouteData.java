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
public final class OnRouteData extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int MD5_FIELD_NUMBER = 1;
    private boolean hasMd5;
    private String md5_ = "";
    private List<CloudDataCom> data_ = Collections.emptyList();
    private int cachedSize = -1;

    public static OnRouteData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OnRouteData().mergeFrom(codedInputStreamMicro);
    }

    public OnRouteData addData(CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        if (this.data_.isEmpty()) {
            this.data_ = new ArrayList();
        }
        this.data_.add(cloudDataCom);
        return this;
    }

    public final OnRouteData clear() {
        clearMd5();
        clearData();
        this.cachedSize = -1;
        return this;
    }

    public OnRouteData clearData() {
        this.data_ = Collections.emptyList();
        return this;
    }

    public OnRouteData clearMd5() {
        this.hasMd5 = false;
        this.md5_ = "";
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

    public String getMd5() {
        return this.md5_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeStringSize = hasMd5() ? CodedOutputStreamMicro.computeStringSize(1, getMd5()) : 0;
        Iterator<CloudDataCom> it = getDataList().iterator();
        while (it.hasNext()) {
            computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, it.next());
        }
        this.cachedSize = computeStringSize;
        return computeStringSize;
    }

    public boolean hasMd5() {
        return this.hasMd5;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public OnRouteData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                setMd5(codedInputStreamMicro.readString());
            } else if (readTag == 18) {
                CloudDataCom cloudDataCom = new CloudDataCom();
                codedInputStreamMicro.readMessage(cloudDataCom);
                addData(cloudDataCom);
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public OnRouteData setData(int i, CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        this.data_.set(i, cloudDataCom);
        return this;
    }

    public OnRouteData setMd5(String str) {
        this.hasMd5 = true;
        this.md5_ = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasMd5()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        Iterator<CloudDataCom> it = getDataList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(2, it.next());
        }
    }

    public static OnRouteData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OnRouteData) new OnRouteData().mergeFrom(bArr);
    }
}
