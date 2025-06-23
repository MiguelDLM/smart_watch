package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class LinkAttrt extends MessageMicro {
    public static final int ATTR_FIELD_NUMBER = 6;
    public static final int DIREC_FIELD_NUMBER = 5;
    public static final int ENODE_ID_FIELD_NUMBER = 2;
    public static final int GEO_FIELD_NUMBER = 7;
    public static final int LENGTH_FIELD_NUMBER = 4;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int PARKING_FLOOR_FIELD_NUMBER = 8;
    public static final int PARKING_THEME_FIELD_NUMBER = 9;
    public static final int SNODE_ID_FIELD_NUMBER = 1;
    private int cachedSize;
    private ByteStringMicro geo_;
    private boolean hasAttr;
    private boolean hasDirec;
    private boolean hasEnodeId;
    private boolean hasGeo;
    private boolean hasLength;
    private boolean hasLevel;
    private boolean hasParkingFloor;
    private boolean hasParkingTheme;
    private boolean hasSnodeId;
    private ByteStringMicro parkingFloor_;
    private int parkingTheme_;
    private int snodeId_ = 0;
    private int enodeId_ = 0;
    private int level_ = 0;
    private int length_ = 0;
    private int direc_ = 0;
    private int attr_ = 0;

    public LinkAttrt() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.geo_ = byteStringMicro;
        this.parkingFloor_ = byteStringMicro;
        this.parkingTheme_ = 0;
        this.cachedSize = -1;
    }

    public static LinkAttrt parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (LinkAttrt) new LinkAttrt().mergeFrom(bArr);
    }

    public final LinkAttrt clear() {
        clearSnodeId();
        clearEnodeId();
        clearLevel();
        clearLength();
        clearDirec();
        clearAttr();
        clearGeo();
        clearParkingFloor();
        clearParkingTheme();
        this.cachedSize = -1;
        return this;
    }

    public LinkAttrt clearAttr() {
        this.hasAttr = false;
        this.attr_ = 0;
        return this;
    }

    public LinkAttrt clearDirec() {
        this.hasDirec = false;
        this.direc_ = 0;
        return this;
    }

    public LinkAttrt clearEnodeId() {
        this.hasEnodeId = false;
        this.enodeId_ = 0;
        return this;
    }

    public LinkAttrt clearGeo() {
        this.hasGeo = false;
        this.geo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public LinkAttrt clearLength() {
        this.hasLength = false;
        this.length_ = 0;
        return this;
    }

    public LinkAttrt clearLevel() {
        this.hasLevel = false;
        this.level_ = 0;
        return this;
    }

    public LinkAttrt clearParkingFloor() {
        this.hasParkingFloor = false;
        this.parkingFloor_ = ByteStringMicro.EMPTY;
        return this;
    }

    public LinkAttrt clearParkingTheme() {
        this.hasParkingTheme = false;
        this.parkingTheme_ = 0;
        return this;
    }

    public LinkAttrt clearSnodeId() {
        this.hasSnodeId = false;
        this.snodeId_ = 0;
        return this;
    }

    public int getAttr() {
        return this.attr_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getDirec() {
        return this.direc_;
    }

    public int getEnodeId() {
        return this.enodeId_;
    }

    public ByteStringMicro getGeo() {
        return this.geo_;
    }

    public int getLength() {
        return this.length_;
    }

    public int getLevel() {
        return this.level_;
    }

    public ByteStringMicro getParkingFloor() {
        return this.parkingFloor_;
    }

    public int getParkingTheme() {
        return this.parkingTheme_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasSnodeId()) {
            i = CodedOutputStreamMicro.computeUInt32Size(1, getSnodeId());
        } else {
            i = 0;
        }
        if (hasEnodeId()) {
            i += CodedOutputStreamMicro.computeUInt32Size(2, getEnodeId());
        }
        if (hasLevel()) {
            i += CodedOutputStreamMicro.computeUInt32Size(3, getLevel());
        }
        if (hasLength()) {
            i += CodedOutputStreamMicro.computeUInt32Size(4, getLength());
        }
        if (hasDirec()) {
            i += CodedOutputStreamMicro.computeUInt32Size(5, getDirec());
        }
        if (hasAttr()) {
            i += CodedOutputStreamMicro.computeUInt32Size(6, getAttr());
        }
        if (hasGeo()) {
            i += CodedOutputStreamMicro.computeBytesSize(7, getGeo());
        }
        if (hasParkingFloor()) {
            i += CodedOutputStreamMicro.computeBytesSize(8, getParkingFloor());
        }
        if (hasParkingTheme()) {
            i += CodedOutputStreamMicro.computeInt32Size(9, getParkingTheme());
        }
        this.cachedSize = i;
        return i;
    }

    public int getSnodeId() {
        return this.snodeId_;
    }

    public boolean hasAttr() {
        return this.hasAttr;
    }

    public boolean hasDirec() {
        return this.hasDirec;
    }

    public boolean hasEnodeId() {
        return this.hasEnodeId;
    }

    public boolean hasGeo() {
        return this.hasGeo;
    }

    public boolean hasLength() {
        return this.hasLength;
    }

    public boolean hasLevel() {
        return this.hasLevel;
    }

    public boolean hasParkingFloor() {
        return this.hasParkingFloor;
    }

    public boolean hasParkingTheme() {
        return this.hasParkingTheme;
    }

    public boolean hasSnodeId() {
        return this.hasSnodeId;
    }

    public final boolean isInitialized() {
        if (!this.hasSnodeId || !this.hasEnodeId || !this.hasLevel || !this.hasLength || !this.hasDirec || !this.hasGeo) {
            return false;
        }
        return true;
    }

    public LinkAttrt setAttr(int i) {
        this.hasAttr = true;
        this.attr_ = i;
        return this;
    }

    public LinkAttrt setDirec(int i) {
        this.hasDirec = true;
        this.direc_ = i;
        return this;
    }

    public LinkAttrt setEnodeId(int i) {
        this.hasEnodeId = true;
        this.enodeId_ = i;
        return this;
    }

    public LinkAttrt setGeo(ByteStringMicro byteStringMicro) {
        this.hasGeo = true;
        this.geo_ = byteStringMicro;
        return this;
    }

    public LinkAttrt setLength(int i) {
        this.hasLength = true;
        this.length_ = i;
        return this;
    }

    public LinkAttrt setLevel(int i) {
        this.hasLevel = true;
        this.level_ = i;
        return this;
    }

    public LinkAttrt setParkingFloor(ByteStringMicro byteStringMicro) {
        this.hasParkingFloor = true;
        this.parkingFloor_ = byteStringMicro;
        return this;
    }

    public LinkAttrt setParkingTheme(int i) {
        this.hasParkingTheme = true;
        this.parkingTheme_ = i;
        return this;
    }

    public LinkAttrt setSnodeId(int i) {
        this.hasSnodeId = true;
        this.snodeId_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasSnodeId()) {
            codedOutputStreamMicro.writeUInt32(1, getSnodeId());
        }
        if (hasEnodeId()) {
            codedOutputStreamMicro.writeUInt32(2, getEnodeId());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeUInt32(3, getLevel());
        }
        if (hasLength()) {
            codedOutputStreamMicro.writeUInt32(4, getLength());
        }
        if (hasDirec()) {
            codedOutputStreamMicro.writeUInt32(5, getDirec());
        }
        if (hasAttr()) {
            codedOutputStreamMicro.writeUInt32(6, getAttr());
        }
        if (hasGeo()) {
            codedOutputStreamMicro.writeBytes(7, getGeo());
        }
        if (hasParkingFloor()) {
            codedOutputStreamMicro.writeBytes(8, getParkingFloor());
        }
        if (hasParkingTheme()) {
            codedOutputStreamMicro.writeInt32(9, getParkingTheme());
        }
    }

    public static LinkAttrt parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new LinkAttrt().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public LinkAttrt mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setSnodeId(codedInputStreamMicro.readUInt32());
            } else if (readTag == 16) {
                setEnodeId(codedInputStreamMicro.readUInt32());
            } else if (readTag == 24) {
                setLevel(codedInputStreamMicro.readUInt32());
            } else if (readTag == 32) {
                setLength(codedInputStreamMicro.readUInt32());
            } else if (readTag == 40) {
                setDirec(codedInputStreamMicro.readUInt32());
            } else if (readTag == 48) {
                setAttr(codedInputStreamMicro.readUInt32());
            } else if (readTag == 58) {
                setGeo(codedInputStreamMicro.readBytes());
            } else if (readTag == 66) {
                setParkingFloor(codedInputStreamMicro.readBytes());
            } else if (readTag != 72) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                setParkingTheme(codedInputStreamMicro.readInt32());
            }
        }
    }
}
