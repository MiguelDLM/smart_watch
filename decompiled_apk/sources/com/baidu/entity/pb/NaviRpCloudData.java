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
public final class NaviRpCloudData extends MessageMicro {
    public static final int ERROR_NO_FIELD_NUMBER = 1;
    public static final int ON_ROUTE_DATA_FIELD_NUMBER = 2;
    public static final int OUT_ROUTE_DATA_FIELD_NUMBER = 3;
    private boolean hasErrorNo;
    private boolean hasOutRouteData;
    private int errorNo_ = 0;
    private List<OnRouteData> onRouteData_ = Collections.emptyList();
    private OutRouteData outRouteData_ = null;
    private int cachedSize = -1;

    public static NaviRpCloudData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new NaviRpCloudData().mergeFrom(codedInputStreamMicro);
    }

    public NaviRpCloudData addOnRouteData(OnRouteData onRouteData) {
        if (onRouteData == null) {
            return this;
        }
        if (this.onRouteData_.isEmpty()) {
            this.onRouteData_ = new ArrayList();
        }
        this.onRouteData_.add(onRouteData);
        return this;
    }

    public final NaviRpCloudData clear() {
        clearErrorNo();
        clearOnRouteData();
        clearOutRouteData();
        this.cachedSize = -1;
        return this;
    }

    public NaviRpCloudData clearErrorNo() {
        this.hasErrorNo = false;
        this.errorNo_ = 0;
        return this;
    }

    public NaviRpCloudData clearOnRouteData() {
        this.onRouteData_ = Collections.emptyList();
        return this;
    }

    public NaviRpCloudData clearOutRouteData() {
        this.hasOutRouteData = false;
        this.outRouteData_ = null;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getErrorNo() {
        return this.errorNo_;
    }

    public OnRouteData getOnRouteData(int i) {
        return this.onRouteData_.get(i);
    }

    public int getOnRouteDataCount() {
        return this.onRouteData_.size();
    }

    public List<OnRouteData> getOnRouteDataList() {
        return this.onRouteData_;
    }

    public OutRouteData getOutRouteData() {
        return this.outRouteData_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeInt32Size = hasErrorNo() ? CodedOutputStreamMicro.computeInt32Size(1, getErrorNo()) : 0;
        Iterator<OnRouteData> it = getOnRouteDataList().iterator();
        while (it.hasNext()) {
            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(2, it.next());
        }
        if (hasOutRouteData()) {
            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, getOutRouteData());
        }
        this.cachedSize = computeInt32Size;
        return computeInt32Size;
    }

    public boolean hasErrorNo() {
        return this.hasErrorNo;
    }

    public boolean hasOutRouteData() {
        return this.hasOutRouteData;
    }

    public final boolean isInitialized() {
        return this.hasErrorNo;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public NaviRpCloudData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setErrorNo(codedInputStreamMicro.readInt32());
            } else if (readTag == 18) {
                OnRouteData onRouteData = new OnRouteData();
                codedInputStreamMicro.readMessage(onRouteData);
                addOnRouteData(onRouteData);
            } else if (readTag == 26) {
                OutRouteData outRouteData = new OutRouteData();
                codedInputStreamMicro.readMessage(outRouteData);
                setOutRouteData(outRouteData);
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public NaviRpCloudData setErrorNo(int i) {
        this.hasErrorNo = true;
        this.errorNo_ = i;
        return this;
    }

    public NaviRpCloudData setOnRouteData(int i, OnRouteData onRouteData) {
        if (onRouteData == null) {
            return this;
        }
        this.onRouteData_.set(i, onRouteData);
        return this;
    }

    public NaviRpCloudData setOutRouteData(OutRouteData outRouteData) {
        if (outRouteData == null) {
            return clearOutRouteData();
        }
        this.hasOutRouteData = true;
        this.outRouteData_ = outRouteData;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasErrorNo()) {
            codedOutputStreamMicro.writeInt32(1, getErrorNo());
        }
        Iterator<OnRouteData> it = getOnRouteDataList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(2, it.next());
        }
        if (hasOutRouteData()) {
            codedOutputStreamMicro.writeMessage(3, getOutRouteData());
        }
    }

    public static NaviRpCloudData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (NaviRpCloudData) new NaviRpCloudData().mergeFrom(bArr);
    }
}
