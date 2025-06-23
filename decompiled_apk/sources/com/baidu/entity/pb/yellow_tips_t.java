package com.baidu.entity.pb;

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
public final class yellow_tips_t extends MessageMicro {
    public static final int GROUP_TIPS_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int ROUTE_PREVIEW_OFF_FIELD_NUMBER = 3;
    public static final int TIPS_TYPE_FIELD_NUMBER = 1;
    private boolean hasName;
    private boolean hasRoutePreviewOff;
    private boolean hasTipsType;
    private int tipsType_ = 0;
    private ByteStringMicro name_ = ByteStringMicro.EMPTY;
    private boolean routePreviewOff_ = false;
    private List<group_yellow_tips_t> groupTips_ = Collections.emptyList();
    private int cachedSize = -1;

    public static yellow_tips_t parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new yellow_tips_t().mergeFrom(codedInputStreamMicro);
    }

    public yellow_tips_t addGroupTips(group_yellow_tips_t group_yellow_tips_tVar) {
        if (group_yellow_tips_tVar == null) {
            return this;
        }
        if (this.groupTips_.isEmpty()) {
            this.groupTips_ = new ArrayList();
        }
        this.groupTips_.add(group_yellow_tips_tVar);
        return this;
    }

    public final yellow_tips_t clear() {
        clearTipsType();
        clearName();
        clearRoutePreviewOff();
        clearGroupTips();
        this.cachedSize = -1;
        return this;
    }

    public yellow_tips_t clearGroupTips() {
        this.groupTips_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_t clearName() {
        this.hasName = false;
        this.name_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_t clearRoutePreviewOff() {
        this.hasRoutePreviewOff = false;
        this.routePreviewOff_ = false;
        return this;
    }

    public yellow_tips_t clearTipsType() {
        this.hasTipsType = false;
        this.tipsType_ = 0;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public group_yellow_tips_t getGroupTips(int i) {
        return this.groupTips_.get(i);
    }

    public int getGroupTipsCount() {
        return this.groupTips_.size();
    }

    public List<group_yellow_tips_t> getGroupTipsList() {
        return this.groupTips_;
    }

    public ByteStringMicro getName() {
        return this.name_;
    }

    public boolean getRoutePreviewOff() {
        return this.routePreviewOff_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeInt32Size = hasTipsType() ? CodedOutputStreamMicro.computeInt32Size(1, getTipsType()) : 0;
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeBytesSize(2, getName());
        }
        if (hasRoutePreviewOff()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(3, getRoutePreviewOff());
        }
        Iterator<group_yellow_tips_t> it = getGroupTipsList().iterator();
        while (it.hasNext()) {
            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, it.next());
        }
        this.cachedSize = computeInt32Size;
        return computeInt32Size;
    }

    public int getTipsType() {
        return this.tipsType_;
    }

    public boolean hasName() {
        return this.hasName;
    }

    public boolean hasRoutePreviewOff() {
        return this.hasRoutePreviewOff;
    }

    public boolean hasTipsType() {
        return this.hasTipsType;
    }

    public final boolean isInitialized() {
        Iterator<group_yellow_tips_t> it = getGroupTipsList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public yellow_tips_t mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setTipsType(codedInputStreamMicro.readInt32());
            } else if (readTag == 18) {
                setName(codedInputStreamMicro.readBytes());
            } else if (readTag == 24) {
                setRoutePreviewOff(codedInputStreamMicro.readBool());
            } else if (readTag == 34) {
                group_yellow_tips_t group_yellow_tips_tVar = new group_yellow_tips_t();
                codedInputStreamMicro.readMessage(group_yellow_tips_tVar);
                addGroupTips(group_yellow_tips_tVar);
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public yellow_tips_t setGroupTips(int i, group_yellow_tips_t group_yellow_tips_tVar) {
        if (group_yellow_tips_tVar == null) {
            return this;
        }
        this.groupTips_.set(i, group_yellow_tips_tVar);
        return this;
    }

    public yellow_tips_t setName(ByteStringMicro byteStringMicro) {
        this.hasName = true;
        this.name_ = byteStringMicro;
        return this;
    }

    public yellow_tips_t setRoutePreviewOff(boolean z) {
        this.hasRoutePreviewOff = true;
        this.routePreviewOff_ = z;
        return this;
    }

    public yellow_tips_t setTipsType(int i) {
        this.hasTipsType = true;
        this.tipsType_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTipsType()) {
            codedOutputStreamMicro.writeInt32(1, getTipsType());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeBytes(2, getName());
        }
        if (hasRoutePreviewOff()) {
            codedOutputStreamMicro.writeBool(3, getRoutePreviewOff());
        }
        Iterator<group_yellow_tips_t> it = getGroupTipsList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(4, it.next());
        }
    }

    public static yellow_tips_t parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (yellow_tips_t) new yellow_tips_t().mergeFrom(bArr);
    }
}
