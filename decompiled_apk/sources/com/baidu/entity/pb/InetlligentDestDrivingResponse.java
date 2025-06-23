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
public final class InetlligentDestDrivingResponse extends MessageMicro {
    public static final int DEST_REC_INFO_FIELD_NUMBER = 2;
    public static final int ERR_NO_FIELD_NUMBER = 1;
    public static final int FIRST_PARKING_SPACE_FIELD_NUMBER = 4;
    public static final int PGUIDING_TRIGGER_DIST_FIELD_NUMBER = 3;
    private boolean hasDestRecInfo;
    private boolean hasErrNo;
    private boolean hasPguidingTriggerDist;
    private int errNo_ = 0;
    private ByteStringMicro destRecInfo_ = ByteStringMicro.EMPTY;
    private int pguidingTriggerDist_ = 0;
    private List<FirstParkingSpace> firstParkingSpace_ = Collections.emptyList();
    private int cachedSize = -1;

    public static InetlligentDestDrivingResponse parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new InetlligentDestDrivingResponse().mergeFrom(codedInputStreamMicro);
    }

    public InetlligentDestDrivingResponse addFirstParkingSpace(FirstParkingSpace firstParkingSpace) {
        if (firstParkingSpace == null) {
            return this;
        }
        if (this.firstParkingSpace_.isEmpty()) {
            this.firstParkingSpace_ = new ArrayList();
        }
        this.firstParkingSpace_.add(firstParkingSpace);
        return this;
    }

    public final InetlligentDestDrivingResponse clear() {
        clearErrNo();
        clearDestRecInfo();
        clearPguidingTriggerDist();
        clearFirstParkingSpace();
        this.cachedSize = -1;
        return this;
    }

    public InetlligentDestDrivingResponse clearDestRecInfo() {
        this.hasDestRecInfo = false;
        this.destRecInfo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public InetlligentDestDrivingResponse clearErrNo() {
        this.hasErrNo = false;
        this.errNo_ = 0;
        return this;
    }

    public InetlligentDestDrivingResponse clearFirstParkingSpace() {
        this.firstParkingSpace_ = Collections.emptyList();
        return this;
    }

    public InetlligentDestDrivingResponse clearPguidingTriggerDist() {
        this.hasPguidingTriggerDist = false;
        this.pguidingTriggerDist_ = 0;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getDestRecInfo() {
        return this.destRecInfo_;
    }

    public int getErrNo() {
        return this.errNo_;
    }

    public FirstParkingSpace getFirstParkingSpace(int i) {
        return this.firstParkingSpace_.get(i);
    }

    public int getFirstParkingSpaceCount() {
        return this.firstParkingSpace_.size();
    }

    public List<FirstParkingSpace> getFirstParkingSpaceList() {
        return this.firstParkingSpace_;
    }

    public int getPguidingTriggerDist() {
        return this.pguidingTriggerDist_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeInt32Size = hasErrNo() ? CodedOutputStreamMicro.computeInt32Size(1, getErrNo()) : 0;
        if (hasDestRecInfo()) {
            computeInt32Size += CodedOutputStreamMicro.computeBytesSize(2, getDestRecInfo());
        }
        if (hasPguidingTriggerDist()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getPguidingTriggerDist());
        }
        Iterator<FirstParkingSpace> it = getFirstParkingSpaceList().iterator();
        while (it.hasNext()) {
            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, it.next());
        }
        this.cachedSize = computeInt32Size;
        return computeInt32Size;
    }

    public boolean hasDestRecInfo() {
        return this.hasDestRecInfo;
    }

    public boolean hasErrNo() {
        return this.hasErrNo;
    }

    public boolean hasPguidingTriggerDist() {
        return this.hasPguidingTriggerDist;
    }

    public final boolean isInitialized() {
        Iterator<FirstParkingSpace> it = getFirstParkingSpaceList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public InetlligentDestDrivingResponse mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setErrNo(codedInputStreamMicro.readInt32());
            } else if (readTag == 18) {
                setDestRecInfo(codedInputStreamMicro.readBytes());
            } else if (readTag == 24) {
                setPguidingTriggerDist(codedInputStreamMicro.readInt32());
            } else if (readTag == 34) {
                FirstParkingSpace firstParkingSpace = new FirstParkingSpace();
                codedInputStreamMicro.readMessage(firstParkingSpace);
                addFirstParkingSpace(firstParkingSpace);
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public InetlligentDestDrivingResponse setDestRecInfo(ByteStringMicro byteStringMicro) {
        this.hasDestRecInfo = true;
        this.destRecInfo_ = byteStringMicro;
        return this;
    }

    public InetlligentDestDrivingResponse setErrNo(int i) {
        this.hasErrNo = true;
        this.errNo_ = i;
        return this;
    }

    public InetlligentDestDrivingResponse setFirstParkingSpace(int i, FirstParkingSpace firstParkingSpace) {
        if (firstParkingSpace == null) {
            return this;
        }
        this.firstParkingSpace_.set(i, firstParkingSpace);
        return this;
    }

    public InetlligentDestDrivingResponse setPguidingTriggerDist(int i) {
        this.hasPguidingTriggerDist = true;
        this.pguidingTriggerDist_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasErrNo()) {
            codedOutputStreamMicro.writeInt32(1, getErrNo());
        }
        if (hasDestRecInfo()) {
            codedOutputStreamMicro.writeBytes(2, getDestRecInfo());
        }
        if (hasPguidingTriggerDist()) {
            codedOutputStreamMicro.writeInt32(3, getPguidingTriggerDist());
        }
        Iterator<FirstParkingSpace> it = getFirstParkingSpaceList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(4, it.next());
        }
    }

    public static InetlligentDestDrivingResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (InetlligentDestDrivingResponse) new InetlligentDestDrivingResponse().mergeFrom(bArr);
    }
}
