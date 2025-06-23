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
public final class group_yellow_tips_t extends MessageMicro {
    public static final int ROUTE_TAG_OFF_FIELD_NUMBER = 4;
    public static final int TAG_FIELD_NUMBER = 1;
    public static final int TAG_INFO_FIELD_NUMBER = 2;
    public static final int YELLOW_TIPS_FIELD_NUMBER = 3;
    private int cachedSize;
    private boolean hasRouteTagOff;
    private boolean hasTag;
    private boolean hasTagInfo;
    private boolean routeTagOff_;
    private ByteStringMicro tagInfo_;
    private ByteStringMicro tag_;
    private List<yellow_tips_list_t> yellowTips_;

    public group_yellow_tips_t() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.tag_ = byteStringMicro;
        this.tagInfo_ = byteStringMicro;
        this.yellowTips_ = Collections.emptyList();
        this.routeTagOff_ = false;
        this.cachedSize = -1;
    }

    public static group_yellow_tips_t parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new group_yellow_tips_t().mergeFrom(codedInputStreamMicro);
    }

    public group_yellow_tips_t addYellowTips(yellow_tips_list_t yellow_tips_list_tVar) {
        if (yellow_tips_list_tVar == null) {
            return this;
        }
        if (this.yellowTips_.isEmpty()) {
            this.yellowTips_ = new ArrayList();
        }
        this.yellowTips_.add(yellow_tips_list_tVar);
        return this;
    }

    public final group_yellow_tips_t clear() {
        clearTag();
        clearTagInfo();
        clearYellowTips();
        clearRouteTagOff();
        this.cachedSize = -1;
        return this;
    }

    public group_yellow_tips_t clearRouteTagOff() {
        this.hasRouteTagOff = false;
        this.routeTagOff_ = false;
        return this;
    }

    public group_yellow_tips_t clearTag() {
        this.hasTag = false;
        this.tag_ = ByteStringMicro.EMPTY;
        return this;
    }

    public group_yellow_tips_t clearTagInfo() {
        this.hasTagInfo = false;
        this.tagInfo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public group_yellow_tips_t clearYellowTips() {
        this.yellowTips_ = Collections.emptyList();
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public boolean getRouteTagOff() {
        return this.routeTagOff_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeBytesSize = hasTag() ? CodedOutputStreamMicro.computeBytesSize(1, getTag()) : 0;
        if (hasTagInfo()) {
            computeBytesSize += CodedOutputStreamMicro.computeBytesSize(2, getTagInfo());
        }
        Iterator<yellow_tips_list_t> it = getYellowTipsList().iterator();
        while (it.hasNext()) {
            computeBytesSize += CodedOutputStreamMicro.computeMessageSize(3, it.next());
        }
        if (hasRouteTagOff()) {
            computeBytesSize += CodedOutputStreamMicro.computeBoolSize(4, getRouteTagOff());
        }
        this.cachedSize = computeBytesSize;
        return computeBytesSize;
    }

    public ByteStringMicro getTag() {
        return this.tag_;
    }

    public ByteStringMicro getTagInfo() {
        return this.tagInfo_;
    }

    public yellow_tips_list_t getYellowTips(int i) {
        return this.yellowTips_.get(i);
    }

    public int getYellowTipsCount() {
        return this.yellowTips_.size();
    }

    public List<yellow_tips_list_t> getYellowTipsList() {
        return this.yellowTips_;
    }

    public boolean hasRouteTagOff() {
        return this.hasRouteTagOff;
    }

    public boolean hasTag() {
        return this.hasTag;
    }

    public boolean hasTagInfo() {
        return this.hasTagInfo;
    }

    public final boolean isInitialized() {
        Iterator<yellow_tips_list_t> it = getYellowTipsList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public group_yellow_tips_t mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                setTag(codedInputStreamMicro.readBytes());
            } else if (readTag == 18) {
                setTagInfo(codedInputStreamMicro.readBytes());
            } else if (readTag == 26) {
                yellow_tips_list_t yellow_tips_list_tVar = new yellow_tips_list_t();
                codedInputStreamMicro.readMessage(yellow_tips_list_tVar);
                addYellowTips(yellow_tips_list_tVar);
            } else if (readTag == 32) {
                setRouteTagOff(codedInputStreamMicro.readBool());
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public group_yellow_tips_t setRouteTagOff(boolean z) {
        this.hasRouteTagOff = true;
        this.routeTagOff_ = z;
        return this;
    }

    public group_yellow_tips_t setTag(ByteStringMicro byteStringMicro) {
        this.hasTag = true;
        this.tag_ = byteStringMicro;
        return this;
    }

    public group_yellow_tips_t setTagInfo(ByteStringMicro byteStringMicro) {
        this.hasTagInfo = true;
        this.tagInfo_ = byteStringMicro;
        return this;
    }

    public group_yellow_tips_t setYellowTips(int i, yellow_tips_list_t yellow_tips_list_tVar) {
        if (yellow_tips_list_tVar == null) {
            return this;
        }
        this.yellowTips_.set(i, yellow_tips_list_tVar);
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTag()) {
            codedOutputStreamMicro.writeBytes(1, getTag());
        }
        if (hasTagInfo()) {
            codedOutputStreamMicro.writeBytes(2, getTagInfo());
        }
        Iterator<yellow_tips_list_t> it = getYellowTipsList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(3, it.next());
        }
        if (hasRouteTagOff()) {
            codedOutputStreamMicro.writeBool(4, getRouteTagOff());
        }
    }

    public static group_yellow_tips_t parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (group_yellow_tips_t) new group_yellow_tips_t().mergeFrom(bArr);
    }
}
