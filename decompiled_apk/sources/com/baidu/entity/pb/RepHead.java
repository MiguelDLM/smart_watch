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
public final class RepHead extends MessageMicro {
    public static final int MD5_FIELD_NUMBER = 1;
    public static final int MESSAGE_HEAD_FIELD_NUMBER = 3;
    public static final int RANGE_FIELD_NUMBER = 2;
    private boolean hasMd5;
    private boolean hasRange;
    private String md5_ = "";
    private String range_ = "";
    private List<MessageHead> messageHead_ = Collections.emptyList();
    private int cachedSize = -1;

    /* loaded from: classes7.dex */
    public static final class MessageHead extends MessageMicro {
        public static final int LENGTH_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int OFFSET_FIELD_NUMBER = 1;
        private boolean hasLength;
        private boolean hasName;
        private boolean hasOffset;
        private int offset_ = 0;
        private int length_ = 0;
        private String name_ = "";
        private int cachedSize = -1;

        public static MessageHead parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MessageHead().mergeFrom(codedInputStreamMicro);
        }

        public final MessageHead clear() {
            clearOffset();
            clearLength();
            clearName();
            this.cachedSize = -1;
            return this;
        }

        public MessageHead clearLength() {
            this.hasLength = false;
            this.length_ = 0;
            return this;
        }

        public MessageHead clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public MessageHead clearOffset() {
            this.hasOffset = false;
            this.offset_ = 0;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getLength() {
            return this.length_;
        }

        public String getName() {
            return this.name_;
        }

        public int getOffset() {
            return this.offset_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasOffset() ? CodedOutputStreamMicro.computeInt32Size(1, getOffset()) : 0;
            if (hasLength()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getLength());
            }
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasLength() {
            return this.hasLength;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasOffset() {
            return this.hasOffset;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public MessageHead mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setOffset(codedInputStreamMicro.readInt32());
                } else if (readTag == 16) {
                    setLength(codedInputStreamMicro.readInt32());
                } else if (readTag == 26) {
                    setName(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public MessageHead setLength(int i) {
            this.hasLength = true;
            this.length_ = i;
            return this;
        }

        public MessageHead setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public MessageHead setOffset(int i) {
            this.hasOffset = true;
            this.offset_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasOffset()) {
                codedOutputStreamMicro.writeInt32(1, getOffset());
            }
            if (hasLength()) {
                codedOutputStreamMicro.writeInt32(2, getLength());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
        }

        public static MessageHead parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MessageHead) new MessageHead().mergeFrom(bArr);
        }
    }

    public static RepHead parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new RepHead().mergeFrom(codedInputStreamMicro);
    }

    public RepHead addMessageHead(MessageHead messageHead) {
        if (messageHead == null) {
            return this;
        }
        if (this.messageHead_.isEmpty()) {
            this.messageHead_ = new ArrayList();
        }
        this.messageHead_.add(messageHead);
        return this;
    }

    public final RepHead clear() {
        clearMd5();
        clearRange();
        clearMessageHead();
        this.cachedSize = -1;
        return this;
    }

    public RepHead clearMd5() {
        this.hasMd5 = false;
        this.md5_ = "";
        return this;
    }

    public RepHead clearMessageHead() {
        this.messageHead_ = Collections.emptyList();
        return this;
    }

    public RepHead clearRange() {
        this.hasRange = false;
        this.range_ = "";
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public String getMd5() {
        return this.md5_;
    }

    public MessageHead getMessageHead(int i) {
        return this.messageHead_.get(i);
    }

    public int getMessageHeadCount() {
        return this.messageHead_.size();
    }

    public List<MessageHead> getMessageHeadList() {
        return this.messageHead_;
    }

    public String getRange() {
        return this.range_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeStringSize = hasMd5() ? CodedOutputStreamMicro.computeStringSize(1, getMd5()) : 0;
        if (hasRange()) {
            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getRange());
        }
        Iterator<MessageHead> it = getMessageHeadList().iterator();
        while (it.hasNext()) {
            computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, it.next());
        }
        this.cachedSize = computeStringSize;
        return computeStringSize;
    }

    public boolean hasMd5() {
        return this.hasMd5;
    }

    public boolean hasRange() {
        return this.hasRange;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public RepHead mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                setMd5(codedInputStreamMicro.readString());
            } else if (readTag == 18) {
                setRange(codedInputStreamMicro.readString());
            } else if (readTag == 26) {
                MessageHead messageHead = new MessageHead();
                codedInputStreamMicro.readMessage(messageHead);
                addMessageHead(messageHead);
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public RepHead setMd5(String str) {
        this.hasMd5 = true;
        this.md5_ = str;
        return this;
    }

    public RepHead setMessageHead(int i, MessageHead messageHead) {
        if (messageHead == null) {
            return this;
        }
        this.messageHead_.set(i, messageHead);
        return this;
    }

    public RepHead setRange(String str) {
        this.hasRange = true;
        this.range_ = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasMd5()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        if (hasRange()) {
            codedOutputStreamMicro.writeString(2, getRange());
        }
        Iterator<MessageHead> it = getMessageHeadList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(3, it.next());
        }
    }

    public static RepHead parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (RepHead) new RepHead().mergeFrom(bArr);
    }
}
