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
public final class LinkAttrArray extends MessageMicro {
    public static final int GEO_ENCODE_FLAG_FIELD_NUMBER = 1;
    public static final int LINK_ATTRS_FIELD_NUMBER = 2;
    private boolean hasGeoEncodeFlag;
    private int geoEncodeFlag_ = 0;
    private List<LinkAttrt> linkAttrs_ = Collections.emptyList();
    private int cachedSize = -1;

    public static LinkAttrArray parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (LinkAttrArray) new LinkAttrArray().mergeFrom(bArr);
    }

    public LinkAttrArray addLinkAttrs(LinkAttrt linkAttrt) {
        if (linkAttrt == null) {
            return this;
        }
        if (this.linkAttrs_.isEmpty()) {
            this.linkAttrs_ = new ArrayList();
        }
        this.linkAttrs_.add(linkAttrt);
        return this;
    }

    public final LinkAttrArray clear() {
        clearGeoEncodeFlag();
        clearLinkAttrs();
        this.cachedSize = -1;
        return this;
    }

    public LinkAttrArray clearGeoEncodeFlag() {
        this.hasGeoEncodeFlag = false;
        this.geoEncodeFlag_ = 0;
        return this;
    }

    public LinkAttrArray clearLinkAttrs() {
        this.linkAttrs_ = Collections.emptyList();
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getGeoEncodeFlag() {
        return this.geoEncodeFlag_;
    }

    public LinkAttrt getLinkAttrs(int i) {
        return this.linkAttrs_.get(i);
    }

    public int getLinkAttrsCount() {
        return this.linkAttrs_.size();
    }

    public List<LinkAttrt> getLinkAttrsList() {
        return this.linkAttrs_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasGeoEncodeFlag()) {
            i = CodedOutputStreamMicro.computeUInt32Size(1, getGeoEncodeFlag());
        } else {
            i = 0;
        }
        Iterator<LinkAttrt> it = getLinkAttrsList().iterator();
        while (it.hasNext()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, it.next());
        }
        this.cachedSize = i;
        return i;
    }

    public boolean hasGeoEncodeFlag() {
        return this.hasGeoEncodeFlag;
    }

    public final boolean isInitialized() {
        Iterator<LinkAttrt> it = getLinkAttrsList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public LinkAttrArray setGeoEncodeFlag(int i) {
        this.hasGeoEncodeFlag = true;
        this.geoEncodeFlag_ = i;
        return this;
    }

    public LinkAttrArray setLinkAttrs(int i, LinkAttrt linkAttrt) {
        if (linkAttrt == null) {
            return this;
        }
        this.linkAttrs_.set(i, linkAttrt);
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasGeoEncodeFlag()) {
            codedOutputStreamMicro.writeUInt32(1, getGeoEncodeFlag());
        }
        Iterator<LinkAttrt> it = getLinkAttrsList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(2, it.next());
        }
    }

    public static LinkAttrArray parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new LinkAttrArray().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public LinkAttrArray mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setGeoEncodeFlag(codedInputStreamMicro.readUInt32());
            } else if (readTag != 18) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                LinkAttrt linkAttrt = new LinkAttrt();
                codedInputStreamMicro.readMessage(linkAttrt);
                addLinkAttrs(linkAttrt);
            }
        }
    }
}
