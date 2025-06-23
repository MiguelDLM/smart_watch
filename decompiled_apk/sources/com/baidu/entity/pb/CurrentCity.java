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
public final class CurrentCity extends MessageMicro {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int GEO_FIELD_NUMBER = 2;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int SGEO_FIELD_NUMBER = 8;
    public static final int SUP_LUKUANG_FIELD_NUMBER = 6;
    public static final int SUP_SUBWAY_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 7;
    private boolean hasCode;
    private boolean hasGeo;
    private boolean hasLevel;
    private boolean hasName;
    private boolean hasSupLukuang;
    private boolean hasSupSubway;
    private boolean hasUid;
    private int code_ = 0;
    private String geo_ = "";
    private int level_ = 0;
    private String name_ = "";
    private boolean supSubway_ = false;
    private boolean supLukuang_ = false;
    private String uid_ = "";
    private List<Integer> sgeo_ = Collections.emptyList();
    private int cachedSize = -1;

    public static CurrentCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CurrentCity().mergeFrom(codedInputStreamMicro);
    }

    public CurrentCity addSgeo(int i) {
        if (this.sgeo_.isEmpty()) {
            this.sgeo_ = new ArrayList();
        }
        this.sgeo_.add(Integer.valueOf(i));
        return this;
    }

    public final CurrentCity clear() {
        clearCode();
        clearGeo();
        clearLevel();
        clearName();
        clearSupSubway();
        clearSupLukuang();
        clearUid();
        clearSgeo();
        this.cachedSize = -1;
        return this;
    }

    public CurrentCity clearCode() {
        this.hasCode = false;
        this.code_ = 0;
        return this;
    }

    public CurrentCity clearGeo() {
        this.hasGeo = false;
        this.geo_ = "";
        return this;
    }

    public CurrentCity clearLevel() {
        this.hasLevel = false;
        this.level_ = 0;
        return this;
    }

    public CurrentCity clearName() {
        this.hasName = false;
        this.name_ = "";
        return this;
    }

    public CurrentCity clearSgeo() {
        this.sgeo_ = Collections.emptyList();
        return this;
    }

    public CurrentCity clearSupLukuang() {
        this.hasSupLukuang = false;
        this.supLukuang_ = false;
        return this;
    }

    public CurrentCity clearSupSubway() {
        this.hasSupSubway = false;
        this.supSubway_ = false;
        return this;
    }

    public CurrentCity clearUid() {
        this.hasUid = false;
        this.uid_ = "";
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCode() {
        return this.code_;
    }

    public String getGeo() {
        return this.geo_;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i = 0;
        int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
        if (hasGeo()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getGeo());
        }
        if (hasLevel()) {
            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasName()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getName());
        }
        if (hasSupSubway()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(5, getSupSubway());
        }
        if (hasSupLukuang()) {
            computeInt32Size += CodedOutputStreamMicro.computeBoolSize(6, getSupLukuang());
        }
        if (hasUid()) {
            computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getUid());
        }
        Iterator<Integer> it = getSgeoList().iterator();
        while (it.hasNext()) {
            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
        }
        int size = computeInt32Size + i + getSgeoList().size();
        this.cachedSize = size;
        return size;
    }

    public int getSgeo(int i) {
        return this.sgeo_.get(i).intValue();
    }

    public int getSgeoCount() {
        return this.sgeo_.size();
    }

    public List<Integer> getSgeoList() {
        return this.sgeo_;
    }

    public boolean getSupLukuang() {
        return this.supLukuang_;
    }

    public boolean getSupSubway() {
        return this.supSubway_;
    }

    public String getUid() {
        return this.uid_;
    }

    public boolean hasCode() {
        return this.hasCode;
    }

    public boolean hasGeo() {
        return this.hasGeo;
    }

    public boolean hasLevel() {
        return this.hasLevel;
    }

    public boolean hasName() {
        return this.hasName;
    }

    public boolean hasSupLukuang() {
        return this.hasSupLukuang;
    }

    public boolean hasSupSubway() {
        return this.hasSupSubway;
    }

    public boolean hasUid() {
        return this.hasUid;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public CurrentCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setCode(codedInputStreamMicro.readInt32());
            } else if (readTag == 18) {
                setGeo(codedInputStreamMicro.readString());
            } else if (readTag == 24) {
                setLevel(codedInputStreamMicro.readInt32());
            } else if (readTag == 34) {
                setName(codedInputStreamMicro.readString());
            } else if (readTag == 40) {
                setSupSubway(codedInputStreamMicro.readBool());
            } else if (readTag == 48) {
                setSupLukuang(codedInputStreamMicro.readBool());
            } else if (readTag == 58) {
                setUid(codedInputStreamMicro.readString());
            } else if (readTag == 64) {
                addSgeo(codedInputStreamMicro.readSInt32());
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public CurrentCity setCode(int i) {
        this.hasCode = true;
        this.code_ = i;
        return this;
    }

    public CurrentCity setGeo(String str) {
        this.hasGeo = true;
        this.geo_ = str;
        return this;
    }

    public CurrentCity setLevel(int i) {
        this.hasLevel = true;
        this.level_ = i;
        return this;
    }

    public CurrentCity setName(String str) {
        this.hasName = true;
        this.name_ = str;
        return this;
    }

    public CurrentCity setSgeo(int i, int i2) {
        this.sgeo_.set(i, Integer.valueOf(i2));
        return this;
    }

    public CurrentCity setSupLukuang(boolean z) {
        this.hasSupLukuang = true;
        this.supLukuang_ = z;
        return this;
    }

    public CurrentCity setSupSubway(boolean z) {
        this.hasSupSubway = true;
        this.supSubway_ = z;
        return this;
    }

    public CurrentCity setUid(String str) {
        this.hasUid = true;
        this.uid_ = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCode()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (hasGeo()) {
            codedOutputStreamMicro.writeString(2, getGeo());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeString(4, getName());
        }
        if (hasSupSubway()) {
            codedOutputStreamMicro.writeBool(5, getSupSubway());
        }
        if (hasSupLukuang()) {
            codedOutputStreamMicro.writeBool(6, getSupLukuang());
        }
        if (hasUid()) {
            codedOutputStreamMicro.writeString(7, getUid());
        }
        Iterator<Integer> it = getSgeoList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeSInt32(8, it.next().intValue());
        }
    }

    public static CurrentCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CurrentCity) new CurrentCity().mergeFrom(bArr);
    }
}
