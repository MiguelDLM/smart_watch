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
public final class TrafficPois extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int CURRENT_CITY_FIELD_NUMBER = 2;
    public static final int IMGE_SHOW_FIELD_NUMBER = 6;
    public static final int LIST_TYPE_FIELD_NUMBER = 7;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
    public static final int SUGGEST_QUERY_FLAG_FIELD_NUMBER = 5;
    private boolean hasContent;
    private boolean hasCurrentCity;
    private boolean hasImgeShow;
    private boolean hasListType;
    private boolean hasOption;
    private boolean hasSuggestQueryFlag;
    private Option option_ = null;
    private CurrentCity currentCity_ = null;
    private Content content_ = null;
    private List<SuggestQuery> suggestQuery_ = Collections.emptyList();
    private int suggestQueryFlag_ = 0;
    private ImageShow imgeShow_ = null;
    private int listType_ = 0;
    private int cachedSize = -1;

    /* loaded from: classes7.dex */
    public static final class Content extends MessageMicro {
        public static final int END_FIELD_NUMBER = 2;
        public static final int MULTI_WAYPOINTS_FIELD_NUMBER = 4;
        public static final int START_FIELD_NUMBER = 1;
        public static final int WAY_POINTS_FIELD_NUMBER = 3;
        private List<Start> start_ = Collections.emptyList();
        private List<End> end_ = Collections.emptyList();
        private List<WayPoints> wayPoints_ = Collections.emptyList();
        private List<MultiWaypoints> multiWaypoints_ = Collections.emptyList();
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class End extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 13;
            public static final int DIRECTION_FIELD_NUMBER = 12;
            public static final int DIST_FIELD_NUMBER = 11;
            public static final int EXT_FIELD_NUMBER = 7;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int HISTORY_ADDRESS_FIELD_NUMBER = 15;
            public static final int IMAGE_URL_FIELD_NUMBER = 14;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 9;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 10;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int POITYPE_FIELD_NUMBER = 8;
            public static final int UID_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasCode;
            private boolean hasDescribe;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasExt;
            private boolean hasGeo;
            private boolean hasHistoryAddress;
            private boolean hasImageUrl;
            private boolean hasIndoorFloor;
            private boolean hasIndoorParentUid;
            private boolean hasName;
            private boolean hasNum;
            private boolean hasPoiType;
            private boolean hasUid;
            private int code_ = 0;
            private String name_ = "";
            private int num_ = 0;
            private String uid_ = "";
            private String addr_ = "";
            private String geo_ = "";
            private String ext_ = "";
            private int poiType_ = 0;
            private String indoorFloor_ = "";
            private String indoorParentUid_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private String describe_ = "";
            private ByteStringMicro imageUrl_ = ByteStringMicro.EMPTY;
            private String historyAddress_ = "";
            private int cachedSize = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public final End clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearExt();
                clearPoiType();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDist();
                clearDirection();
                clearDescribe();
                clearImageUrl();
                clearHistoryAddress();
                this.cachedSize = -1;
                return this;
            }

            public End clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public End clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            public End clearDescribe() {
                this.hasDescribe = false;
                this.describe_ = "";
                return this;
            }

            public End clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public End clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public End clearExt() {
                this.hasExt = false;
                this.ext_ = "";
                return this;
            }

            public End clearGeo() {
                this.hasGeo = false;
                this.geo_ = "";
                return this;
            }

            public End clearHistoryAddress() {
                this.hasHistoryAddress = false;
                this.historyAddress_ = "";
                return this;
            }

            public End clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = ByteStringMicro.EMPTY;
                return this;
            }

            public End clearIndoorFloor() {
                this.hasIndoorFloor = false;
                this.indoorFloor_ = "";
                return this;
            }

            public End clearIndoorParentUid() {
                this.hasIndoorParentUid = false;
                this.indoorParentUid_ = "";
                return this;
            }

            public End clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public End clearNum() {
                this.hasNum = false;
                this.num_ = 0;
                return this;
            }

            public End clearPoiType() {
                this.hasPoiType = false;
                this.poiType_ = 0;
                return this;
            }

            public End clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
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

            public String getDescribe() {
                return this.describe_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public String getExt() {
                return this.ext_;
            }

            public String getGeo() {
                return this.geo_;
            }

            public String getHistoryAddress() {
                return this.historyAddress_;
            }

            public ByteStringMicro getImageUrl() {
                return this.imageUrl_;
            }

            public String getIndoorFloor() {
                return this.indoorFloor_;
            }

            public String getIndoorParentUid() {
                return this.indoorParentUid_;
            }

            public String getName() {
                return this.name_;
            }

            public int getNum() {
                return this.num_;
            }

            public int getPoiType() {
                return this.poiType_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (hasName()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasNum()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                }
                if (hasUid()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getUid());
                }
                if (hasAddr()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                }
                if (hasGeo()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                }
                if (hasExt()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getExt());
                }
                if (hasPoiType()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(8, getPoiType());
                }
                if (hasIndoorFloor()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(10, getIndoorParentUid());
                }
                if (hasDist()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(11, getDist());
                }
                if (hasDirection()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(12, getDirection());
                }
                if (hasDescribe()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(13, getDescribe());
                }
                if (hasImageUrl()) {
                    computeInt32Size += CodedOutputStreamMicro.computeBytesSize(14, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(15, getHistoryAddress());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public boolean hasDescribe() {
                return this.hasDescribe;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasExt() {
                return this.hasExt;
            }

            public boolean hasGeo() {
                return this.hasGeo;
            }

            public boolean hasHistoryAddress() {
                return this.hasHistoryAddress;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasIndoorFloor() {
                return this.hasIndoorFloor;
            }

            public boolean hasIndoorParentUid() {
                return this.hasIndoorParentUid;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasNum() {
                return this.hasNum;
            }

            public boolean hasPoiType() {
                return this.hasPoiType;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public End mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            setName(codedInputStreamMicro.readString());
                            break;
                        case 24:
                            setNum(codedInputStreamMicro.readInt32());
                            break;
                        case 34:
                            setUid(codedInputStreamMicro.readString());
                            break;
                        case 42:
                            setAddr(codedInputStreamMicro.readString());
                            break;
                        case 50:
                            setGeo(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            setExt(codedInputStreamMicro.readString());
                            break;
                        case 64:
                            setPoiType(codedInputStreamMicro.readInt32());
                            break;
                        case 74:
                            setIndoorFloor(codedInputStreamMicro.readString());
                            break;
                        case 82:
                            setIndoorParentUid(codedInputStreamMicro.readString());
                            break;
                        case 88:
                            setDist(codedInputStreamMicro.readInt32());
                            break;
                        case 96:
                            setDirection(codedInputStreamMicro.readInt32());
                            break;
                        case 106:
                            setDescribe(codedInputStreamMicro.readString());
                            break;
                        case 114:
                            setImageUrl(codedInputStreamMicro.readBytes());
                            break;
                        case 122:
                            setHistoryAddress(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public End setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public End setCode(int i) {
                this.hasCode = true;
                this.code_ = i;
                return this;
            }

            public End setDescribe(String str) {
                this.hasDescribe = true;
                this.describe_ = str;
                return this;
            }

            public End setDirection(int i) {
                this.hasDirection = true;
                this.direction_ = i;
                return this;
            }

            public End setDist(int i) {
                this.hasDist = true;
                this.dist_ = i;
                return this;
            }

            public End setExt(String str) {
                this.hasExt = true;
                this.ext_ = str;
                return this;
            }

            public End setGeo(String str) {
                this.hasGeo = true;
                this.geo_ = str;
                return this;
            }

            public End setHistoryAddress(String str) {
                this.hasHistoryAddress = true;
                this.historyAddress_ = str;
                return this;
            }

            public End setImageUrl(ByteStringMicro byteStringMicro) {
                this.hasImageUrl = true;
                this.imageUrl_ = byteStringMicro;
                return this;
            }

            public End setIndoorFloor(String str) {
                this.hasIndoorFloor = true;
                this.indoorFloor_ = str;
                return this;
            }

            public End setIndoorParentUid(String str) {
                this.hasIndoorParentUid = true;
                this.indoorParentUid_ = str;
                return this;
            }

            public End setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public End setNum(int i) {
                this.hasNum = true;
                this.num_ = i;
                return this;
            }

            public End setPoiType(int i) {
                this.hasPoiType = true;
                this.poiType_ = i;
                return this;
            }

            public End setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasNum()) {
                    codedOutputStreamMicro.writeInt32(3, getNum());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(4, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(5, getAddr());
                }
                if (hasGeo()) {
                    codedOutputStreamMicro.writeString(6, getGeo());
                }
                if (hasExt()) {
                    codedOutputStreamMicro.writeString(7, getExt());
                }
                if (hasPoiType()) {
                    codedOutputStreamMicro.writeInt32(8, getPoiType());
                }
                if (hasIndoorFloor()) {
                    codedOutputStreamMicro.writeString(9, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    codedOutputStreamMicro.writeString(10, getIndoorParentUid());
                }
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(11, getDist());
                }
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(12, getDirection());
                }
                if (hasDescribe()) {
                    codedOutputStreamMicro.writeString(13, getDescribe());
                }
                if (hasImageUrl()) {
                    codedOutputStreamMicro.writeBytes(14, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    codedOutputStreamMicro.writeString(15, getHistoryAddress());
                }
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class MultiWaypoints extends MessageMicro {
            public static final int WAY_POINTS_FIELD_NUMBER = 1;
            private List<WayPoints> wayPoints_ = Collections.emptyList();
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class WayPoints extends MessageMicro {
                public static final int ADDR_FIELD_NUMBER = 5;
                public static final int CODE_FIELD_NUMBER = 1;
                public static final int GEO_FIELD_NUMBER = 6;
                public static final int NAME_FIELD_NUMBER = 2;
                public static final int NUM_FIELD_NUMBER = 3;
                public static final int UID_FIELD_NUMBER = 4;
                private boolean hasAddr;
                private boolean hasCode;
                private boolean hasGeo;
                private boolean hasName;
                private boolean hasNum;
                private boolean hasUid;
                private int code_ = 0;
                private String name_ = "";
                private int num_ = 0;
                private String uid_ = "";
                private String addr_ = "";
                private String geo_ = "";
                private int cachedSize = -1;

                public static WayPoints parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new WayPoints().mergeFrom(codedInputStreamMicro);
                }

                public final WayPoints clear() {
                    clearCode();
                    clearName();
                    clearNum();
                    clearUid();
                    clearAddr();
                    clearGeo();
                    this.cachedSize = -1;
                    return this;
                }

                public WayPoints clearAddr() {
                    this.hasAddr = false;
                    this.addr_ = "";
                    return this;
                }

                public WayPoints clearCode() {
                    this.hasCode = false;
                    this.code_ = 0;
                    return this;
                }

                public WayPoints clearGeo() {
                    this.hasGeo = false;
                    this.geo_ = "";
                    return this;
                }

                public WayPoints clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public WayPoints clearNum() {
                    this.hasNum = false;
                    this.num_ = 0;
                    return this;
                }

                public WayPoints clearUid() {
                    this.hasUid = false;
                    this.uid_ = "";
                    return this;
                }

                public String getAddr() {
                    return this.addr_;
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

                public String getName() {
                    return this.name_;
                }

                public int getNum() {
                    return this.num_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                    if (hasName()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    if (hasNum()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                    }
                    if (hasUid()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getUid());
                    }
                    if (hasAddr()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                    }
                    if (hasGeo()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public String getUid() {
                    return this.uid_;
                }

                public boolean hasAddr() {
                    return this.hasAddr;
                }

                public boolean hasCode() {
                    return this.hasCode;
                }

                public boolean hasGeo() {
                    return this.hasGeo;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasNum() {
                    return this.hasNum;
                }

                public boolean hasUid() {
                    return this.hasUid;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public WayPoints mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setCode(codedInputStreamMicro.readInt32());
                        } else if (readTag == 18) {
                            setName(codedInputStreamMicro.readString());
                        } else if (readTag == 24) {
                            setNum(codedInputStreamMicro.readInt32());
                        } else if (readTag == 34) {
                            setUid(codedInputStreamMicro.readString());
                        } else if (readTag == 42) {
                            setAddr(codedInputStreamMicro.readString());
                        } else if (readTag == 50) {
                            setGeo(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public WayPoints setAddr(String str) {
                    this.hasAddr = true;
                    this.addr_ = str;
                    return this;
                }

                public WayPoints setCode(int i) {
                    this.hasCode = true;
                    this.code_ = i;
                    return this;
                }

                public WayPoints setGeo(String str) {
                    this.hasGeo = true;
                    this.geo_ = str;
                    return this;
                }

                public WayPoints setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public WayPoints setNum(int i) {
                    this.hasNum = true;
                    this.num_ = i;
                    return this;
                }

                public WayPoints setUid(String str) {
                    this.hasUid = true;
                    this.uid_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCode()) {
                        codedOutputStreamMicro.writeInt32(1, getCode());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (hasNum()) {
                        codedOutputStreamMicro.writeInt32(3, getNum());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(4, getUid());
                    }
                    if (hasAddr()) {
                        codedOutputStreamMicro.writeString(5, getAddr());
                    }
                    if (hasGeo()) {
                        codedOutputStreamMicro.writeString(6, getGeo());
                    }
                }

                public static WayPoints parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (WayPoints) new WayPoints().mergeFrom(bArr);
                }
            }

            public static MultiWaypoints parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new MultiWaypoints().mergeFrom(codedInputStreamMicro);
            }

            public MultiWaypoints addWayPoints(WayPoints wayPoints) {
                if (wayPoints == null) {
                    return this;
                }
                if (this.wayPoints_.isEmpty()) {
                    this.wayPoints_ = new ArrayList();
                }
                this.wayPoints_.add(wayPoints);
                return this;
            }

            public final MultiWaypoints clear() {
                clearWayPoints();
                this.cachedSize = -1;
                return this;
            }

            public MultiWaypoints clearWayPoints() {
                this.wayPoints_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                Iterator<WayPoints> it = getWayPointsList().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                }
                this.cachedSize = i;
                return i;
            }

            public WayPoints getWayPoints(int i) {
                return this.wayPoints_.get(i);
            }

            public int getWayPointsCount() {
                return this.wayPoints_.size();
            }

            public List<WayPoints> getWayPointsList() {
                return this.wayPoints_;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public MultiWaypoints mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        WayPoints wayPoints = new WayPoints();
                        codedInputStreamMicro.readMessage(wayPoints);
                        addWayPoints(wayPoints);
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public MultiWaypoints setWayPoints(int i, WayPoints wayPoints) {
                if (wayPoints == null) {
                    return this;
                }
                this.wayPoints_.set(i, wayPoints);
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<WayPoints> it = getWayPointsList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(1, it.next());
                }
            }

            public static MultiWaypoints parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (MultiWaypoints) new MultiWaypoints().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Start extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 9;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int HISTORY_ADDRESS_FIELD_NUMBER = 11;
            public static final int IMAGE_URL_FIELD_NUMBER = 10;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasCode;
            private boolean hasDescribe;
            private boolean hasGeo;
            private boolean hasHistoryAddress;
            private boolean hasImageUrl;
            private boolean hasIndoorFloor;
            private boolean hasIndoorParentUid;
            private boolean hasName;
            private boolean hasNum;
            private boolean hasUid;
            private int code_ = 0;
            private String name_ = "";
            private int num_ = 0;
            private String uid_ = "";
            private String addr_ = "";
            private String geo_ = "";
            private String indoorFloor_ = "";
            private String indoorParentUid_ = "";
            private String describe_ = "";
            private ByteStringMicro imageUrl_ = ByteStringMicro.EMPTY;
            private String historyAddress_ = "";
            private int cachedSize = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public final Start clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDescribe();
                clearImageUrl();
                clearHistoryAddress();
                this.cachedSize = -1;
                return this;
            }

            public Start clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public Start clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            public Start clearDescribe() {
                this.hasDescribe = false;
                this.describe_ = "";
                return this;
            }

            public Start clearGeo() {
                this.hasGeo = false;
                this.geo_ = "";
                return this;
            }

            public Start clearHistoryAddress() {
                this.hasHistoryAddress = false;
                this.historyAddress_ = "";
                return this;
            }

            public Start clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = ByteStringMicro.EMPTY;
                return this;
            }

            public Start clearIndoorFloor() {
                this.hasIndoorFloor = false;
                this.indoorFloor_ = "";
                return this;
            }

            public Start clearIndoorParentUid() {
                this.hasIndoorParentUid = false;
                this.indoorParentUid_ = "";
                return this;
            }

            public Start clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public Start clearNum() {
                this.hasNum = false;
                this.num_ = 0;
                return this;
            }

            public Start clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
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

            public String getDescribe() {
                return this.describe_;
            }

            public String getGeo() {
                return this.geo_;
            }

            public String getHistoryAddress() {
                return this.historyAddress_;
            }

            public ByteStringMicro getImageUrl() {
                return this.imageUrl_;
            }

            public String getIndoorFloor() {
                return this.indoorFloor_;
            }

            public String getIndoorParentUid() {
                return this.indoorParentUid_;
            }

            public String getName() {
                return this.name_;
            }

            public int getNum() {
                return this.num_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (hasName()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasNum()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                }
                if (hasUid()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getUid());
                }
                if (hasAddr()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                }
                if (hasGeo()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
                }
                if (hasDescribe()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getDescribe());
                }
                if (hasImageUrl()) {
                    computeInt32Size += CodedOutputStreamMicro.computeBytesSize(10, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(11, getHistoryAddress());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public boolean hasDescribe() {
                return this.hasDescribe;
            }

            public boolean hasGeo() {
                return this.hasGeo;
            }

            public boolean hasHistoryAddress() {
                return this.hasHistoryAddress;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasIndoorFloor() {
                return this.hasIndoorFloor;
            }

            public boolean hasIndoorParentUid() {
                return this.hasIndoorParentUid;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasNum() {
                return this.hasNum;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Start mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            setName(codedInputStreamMicro.readString());
                            break;
                        case 24:
                            setNum(codedInputStreamMicro.readInt32());
                            break;
                        case 34:
                            setUid(codedInputStreamMicro.readString());
                            break;
                        case 42:
                            setAddr(codedInputStreamMicro.readString());
                            break;
                        case 50:
                            setGeo(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            setIndoorFloor(codedInputStreamMicro.readString());
                            break;
                        case 66:
                            setIndoorParentUid(codedInputStreamMicro.readString());
                            break;
                        case 74:
                            setDescribe(codedInputStreamMicro.readString());
                            break;
                        case 82:
                            setImageUrl(codedInputStreamMicro.readBytes());
                            break;
                        case 90:
                            setHistoryAddress(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public Start setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public Start setCode(int i) {
                this.hasCode = true;
                this.code_ = i;
                return this;
            }

            public Start setDescribe(String str) {
                this.hasDescribe = true;
                this.describe_ = str;
                return this;
            }

            public Start setGeo(String str) {
                this.hasGeo = true;
                this.geo_ = str;
                return this;
            }

            public Start setHistoryAddress(String str) {
                this.hasHistoryAddress = true;
                this.historyAddress_ = str;
                return this;
            }

            public Start setImageUrl(ByteStringMicro byteStringMicro) {
                this.hasImageUrl = true;
                this.imageUrl_ = byteStringMicro;
                return this;
            }

            public Start setIndoorFloor(String str) {
                this.hasIndoorFloor = true;
                this.indoorFloor_ = str;
                return this;
            }

            public Start setIndoorParentUid(String str) {
                this.hasIndoorParentUid = true;
                this.indoorParentUid_ = str;
                return this;
            }

            public Start setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public Start setNum(int i) {
                this.hasNum = true;
                this.num_ = i;
                return this;
            }

            public Start setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasNum()) {
                    codedOutputStreamMicro.writeInt32(3, getNum());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(4, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(5, getAddr());
                }
                if (hasGeo()) {
                    codedOutputStreamMicro.writeString(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    codedOutputStreamMicro.writeString(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    codedOutputStreamMicro.writeString(8, getIndoorParentUid());
                }
                if (hasDescribe()) {
                    codedOutputStreamMicro.writeString(9, getDescribe());
                }
                if (hasImageUrl()) {
                    codedOutputStreamMicro.writeBytes(10, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    codedOutputStreamMicro.writeString(11, getHistoryAddress());
                }
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class WayPoints extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 5;
            public static final int CODE_FIELD_NUMBER = 1;
            public static final int DESCRIBE_FIELD_NUMBER = 11;
            public static final int DIRECTION_FIELD_NUMBER = 10;
            public static final int DIST_FIELD_NUMBER = 9;
            public static final int GEO_FIELD_NUMBER = 6;
            public static final int HISTORY_ADDRESS_FIELD_NUMBER = 13;
            public static final int IMAGE_URL_FIELD_NUMBER = 12;
            public static final int INDOOR_FLOOR_FIELD_NUMBER = 7;
            public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 8;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int NUM_FIELD_NUMBER = 3;
            public static final int UID_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasCode;
            private boolean hasDescribe;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasGeo;
            private boolean hasHistoryAddress;
            private boolean hasImageUrl;
            private boolean hasIndoorFloor;
            private boolean hasIndoorParentUid;
            private boolean hasName;
            private boolean hasNum;
            private boolean hasUid;
            private int code_ = 0;
            private String name_ = "";
            private int num_ = 0;
            private String uid_ = "";
            private String addr_ = "";
            private String geo_ = "";
            private String indoorFloor_ = "";
            private String indoorParentUid_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private String describe_ = "";
            private ByteStringMicro imageUrl_ = ByteStringMicro.EMPTY;
            private String historyAddress_ = "";
            private int cachedSize = -1;

            public static WayPoints parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new WayPoints().mergeFrom(codedInputStreamMicro);
            }

            public final WayPoints clear() {
                clearCode();
                clearName();
                clearNum();
                clearUid();
                clearAddr();
                clearGeo();
                clearIndoorFloor();
                clearIndoorParentUid();
                clearDist();
                clearDirection();
                clearDescribe();
                clearImageUrl();
                clearHistoryAddress();
                this.cachedSize = -1;
                return this;
            }

            public WayPoints clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public WayPoints clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            public WayPoints clearDescribe() {
                this.hasDescribe = false;
                this.describe_ = "";
                return this;
            }

            public WayPoints clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public WayPoints clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public WayPoints clearGeo() {
                this.hasGeo = false;
                this.geo_ = "";
                return this;
            }

            public WayPoints clearHistoryAddress() {
                this.hasHistoryAddress = false;
                this.historyAddress_ = "";
                return this;
            }

            public WayPoints clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = ByteStringMicro.EMPTY;
                return this;
            }

            public WayPoints clearIndoorFloor() {
                this.hasIndoorFloor = false;
                this.indoorFloor_ = "";
                return this;
            }

            public WayPoints clearIndoorParentUid() {
                this.hasIndoorParentUid = false;
                this.indoorParentUid_ = "";
                return this;
            }

            public WayPoints clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public WayPoints clearNum() {
                this.hasNum = false;
                this.num_ = 0;
                return this;
            }

            public WayPoints clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
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

            public String getDescribe() {
                return this.describe_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public String getGeo() {
                return this.geo_;
            }

            public String getHistoryAddress() {
                return this.historyAddress_;
            }

            public ByteStringMicro getImageUrl() {
                return this.imageUrl_;
            }

            public String getIndoorFloor() {
                return this.indoorFloor_;
            }

            public String getIndoorParentUid() {
                return this.indoorParentUid_;
            }

            public String getName() {
                return this.name_;
            }

            public int getNum() {
                return this.num_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (hasName()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasNum()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getNum());
                }
                if (hasUid()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getUid());
                }
                if (hasAddr()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getAddr());
                }
                if (hasGeo()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(8, getIndoorParentUid());
                }
                if (hasDist()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(9, getDist());
                }
                if (hasDirection()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(10, getDirection());
                }
                if (hasDescribe()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(11, getDescribe());
                }
                if (hasImageUrl()) {
                    computeInt32Size += CodedOutputStreamMicro.computeBytesSize(12, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(13, getHistoryAddress());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public boolean hasDescribe() {
                return this.hasDescribe;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasGeo() {
                return this.hasGeo;
            }

            public boolean hasHistoryAddress() {
                return this.hasHistoryAddress;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasIndoorFloor() {
                return this.hasIndoorFloor;
            }

            public boolean hasIndoorParentUid() {
                return this.hasIndoorParentUid;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasNum() {
                return this.hasNum;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public WayPoints mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            setCode(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            setName(codedInputStreamMicro.readString());
                            break;
                        case 24:
                            setNum(codedInputStreamMicro.readInt32());
                            break;
                        case 34:
                            setUid(codedInputStreamMicro.readString());
                            break;
                        case 42:
                            setAddr(codedInputStreamMicro.readString());
                            break;
                        case 50:
                            setGeo(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            setIndoorFloor(codedInputStreamMicro.readString());
                            break;
                        case 66:
                            setIndoorParentUid(codedInputStreamMicro.readString());
                            break;
                        case 72:
                            setDist(codedInputStreamMicro.readInt32());
                            break;
                        case 80:
                            setDirection(codedInputStreamMicro.readInt32());
                            break;
                        case 90:
                            setDescribe(codedInputStreamMicro.readString());
                            break;
                        case 98:
                            setImageUrl(codedInputStreamMicro.readBytes());
                            break;
                        case 106:
                            setHistoryAddress(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public WayPoints setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public WayPoints setCode(int i) {
                this.hasCode = true;
                this.code_ = i;
                return this;
            }

            public WayPoints setDescribe(String str) {
                this.hasDescribe = true;
                this.describe_ = str;
                return this;
            }

            public WayPoints setDirection(int i) {
                this.hasDirection = true;
                this.direction_ = i;
                return this;
            }

            public WayPoints setDist(int i) {
                this.hasDist = true;
                this.dist_ = i;
                return this;
            }

            public WayPoints setGeo(String str) {
                this.hasGeo = true;
                this.geo_ = str;
                return this;
            }

            public WayPoints setHistoryAddress(String str) {
                this.hasHistoryAddress = true;
                this.historyAddress_ = str;
                return this;
            }

            public WayPoints setImageUrl(ByteStringMicro byteStringMicro) {
                this.hasImageUrl = true;
                this.imageUrl_ = byteStringMicro;
                return this;
            }

            public WayPoints setIndoorFloor(String str) {
                this.hasIndoorFloor = true;
                this.indoorFloor_ = str;
                return this;
            }

            public WayPoints setIndoorParentUid(String str) {
                this.hasIndoorParentUid = true;
                this.indoorParentUid_ = str;
                return this;
            }

            public WayPoints setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public WayPoints setNum(int i) {
                this.hasNum = true;
                this.num_ = i;
                return this;
            }

            public WayPoints setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasNum()) {
                    codedOutputStreamMicro.writeInt32(3, getNum());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(4, getUid());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(5, getAddr());
                }
                if (hasGeo()) {
                    codedOutputStreamMicro.writeString(6, getGeo());
                }
                if (hasIndoorFloor()) {
                    codedOutputStreamMicro.writeString(7, getIndoorFloor());
                }
                if (hasIndoorParentUid()) {
                    codedOutputStreamMicro.writeString(8, getIndoorParentUid());
                }
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(9, getDist());
                }
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(10, getDirection());
                }
                if (hasDescribe()) {
                    codedOutputStreamMicro.writeString(11, getDescribe());
                }
                if (hasImageUrl()) {
                    codedOutputStreamMicro.writeBytes(12, getImageUrl());
                }
                if (hasHistoryAddress()) {
                    codedOutputStreamMicro.writeString(13, getHistoryAddress());
                }
            }

            public static WayPoints parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (WayPoints) new WayPoints().mergeFrom(bArr);
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public Content addEnd(End end) {
            if (end == null) {
                return this;
            }
            if (this.end_.isEmpty()) {
                this.end_ = new ArrayList();
            }
            this.end_.add(end);
            return this;
        }

        public Content addMultiWaypoints(MultiWaypoints multiWaypoints) {
            if (multiWaypoints == null) {
                return this;
            }
            if (this.multiWaypoints_.isEmpty()) {
                this.multiWaypoints_ = new ArrayList();
            }
            this.multiWaypoints_.add(multiWaypoints);
            return this;
        }

        public Content addStart(Start start) {
            if (start == null) {
                return this;
            }
            if (this.start_.isEmpty()) {
                this.start_ = new ArrayList();
            }
            this.start_.add(start);
            return this;
        }

        public Content addWayPoints(WayPoints wayPoints) {
            if (wayPoints == null) {
                return this;
            }
            if (this.wayPoints_.isEmpty()) {
                this.wayPoints_ = new ArrayList();
            }
            this.wayPoints_.add(wayPoints);
            return this;
        }

        public final Content clear() {
            clearStart();
            clearEnd();
            clearWayPoints();
            clearMultiWaypoints();
            this.cachedSize = -1;
            return this;
        }

        public Content clearEnd() {
            this.end_ = Collections.emptyList();
            return this;
        }

        public Content clearMultiWaypoints() {
            this.multiWaypoints_ = Collections.emptyList();
            return this;
        }

        public Content clearStart() {
            this.start_ = Collections.emptyList();
            return this;
        }

        public Content clearWayPoints() {
            this.wayPoints_ = Collections.emptyList();
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public End getEnd(int i) {
            return this.end_.get(i);
        }

        public int getEndCount() {
            return this.end_.size();
        }

        public List<End> getEndList() {
            return this.end_;
        }

        public MultiWaypoints getMultiWaypoints(int i) {
            return this.multiWaypoints_.get(i);
        }

        public int getMultiWaypointsCount() {
            return this.multiWaypoints_.size();
        }

        public List<MultiWaypoints> getMultiWaypointsList() {
            return this.multiWaypoints_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            Iterator<Start> it = getStartList().iterator();
            int i = 0;
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
            }
            Iterator<End> it2 = getEndList().iterator();
            while (it2.hasNext()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, it2.next());
            }
            Iterator<WayPoints> it3 = getWayPointsList().iterator();
            while (it3.hasNext()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, it3.next());
            }
            Iterator<MultiWaypoints> it4 = getMultiWaypointsList().iterator();
            while (it4.hasNext()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, it4.next());
            }
            this.cachedSize = i;
            return i;
        }

        public Start getStart(int i) {
            return this.start_.get(i);
        }

        public int getStartCount() {
            return this.start_.size();
        }

        public List<Start> getStartList() {
            return this.start_;
        }

        public WayPoints getWayPoints(int i) {
            return this.wayPoints_.get(i);
        }

        public int getWayPointsCount() {
            return this.wayPoints_.size();
        }

        public List<WayPoints> getWayPointsList() {
            return this.wayPoints_;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    Start start = new Start();
                    codedInputStreamMicro.readMessage(start);
                    addStart(start);
                } else if (readTag == 18) {
                    End end = new End();
                    codedInputStreamMicro.readMessage(end);
                    addEnd(end);
                } else if (readTag == 26) {
                    WayPoints wayPoints = new WayPoints();
                    codedInputStreamMicro.readMessage(wayPoints);
                    addWayPoints(wayPoints);
                } else if (readTag == 34) {
                    MultiWaypoints multiWaypoints = new MultiWaypoints();
                    codedInputStreamMicro.readMessage(multiWaypoints);
                    addMultiWaypoints(multiWaypoints);
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Content setEnd(int i, End end) {
            if (end == null) {
                return this;
            }
            this.end_.set(i, end);
            return this;
        }

        public Content setMultiWaypoints(int i, MultiWaypoints multiWaypoints) {
            if (multiWaypoints == null) {
                return this;
            }
            this.multiWaypoints_.set(i, multiWaypoints);
            return this;
        }

        public Content setStart(int i, Start start) {
            if (start == null) {
                return this;
            }
            this.start_.set(i, start);
            return this;
        }

        public Content setWayPoints(int i, WayPoints wayPoints) {
            if (wayPoints == null) {
                return this;
            }
            this.wayPoints_.set(i, wayPoints);
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            Iterator<Start> it = getStartList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(1, it.next());
            }
            Iterator<End> it2 = getEndList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeMessage(2, it2.next());
            }
            Iterator<WayPoints> it3 = getWayPointsList().iterator();
            while (it3.hasNext()) {
                codedOutputStreamMicro.writeMessage(3, it3.next());
            }
            Iterator<MultiWaypoints> it4 = getMultiWaypointsList().iterator();
            while (it4.hasNext()) {
                codedOutputStreamMicro.writeMessage(4, it4.next());
            }
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ImageShow extends MessageMicro {
        public static final int IMAGE_EXT_FIELD_NUMBER = 1;
        public static final int RES_BOUND_FIELD_NUMBER = 2;
        private boolean hasImageExt;
        private boolean hasResBound;
        private ByteStringMicro imageExt_ = ByteStringMicro.EMPTY;
        private String resBound_ = "";
        private int cachedSize = -1;

        public static ImageShow parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ImageShow().mergeFrom(codedInputStreamMicro);
        }

        public final ImageShow clear() {
            clearImageExt();
            clearResBound();
            this.cachedSize = -1;
            return this;
        }

        public ImageShow clearImageExt() {
            this.hasImageExt = false;
            this.imageExt_ = ByteStringMicro.EMPTY;
            return this;
        }

        public ImageShow clearResBound() {
            this.hasResBound = false;
            this.resBound_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public ByteStringMicro getImageExt() {
            return this.imageExt_;
        }

        public String getResBound() {
            return this.resBound_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeBytesSize = hasImageExt() ? CodedOutputStreamMicro.computeBytesSize(1, getImageExt()) : 0;
            if (hasResBound()) {
                computeBytesSize += CodedOutputStreamMicro.computeStringSize(2, getResBound());
            }
            this.cachedSize = computeBytesSize;
            return computeBytesSize;
        }

        public boolean hasImageExt() {
            return this.hasImageExt;
        }

        public boolean hasResBound() {
            return this.hasResBound;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public ImageShow mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setImageExt(codedInputStreamMicro.readBytes());
                } else if (readTag == 18) {
                    setResBound(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public ImageShow setImageExt(ByteStringMicro byteStringMicro) {
            this.hasImageExt = true;
            this.imageExt_ = byteStringMicro;
            return this;
        }

        public ImageShow setResBound(String str) {
            this.hasResBound = true;
            this.resBound_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImageExt()) {
                codedOutputStreamMicro.writeBytes(1, getImageExt());
            }
            if (hasResBound()) {
                codedOutputStreamMicro.writeString(2, getResBound());
            }
        }

        public static ImageShow parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ImageShow) new ImageShow().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Option extends MessageMicro {
        public static final int CITY_LIST_FIELD_NUMBER = 1;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int E_WD_FIELD_NUMBER = 5;
        public static final int IF_NAV_FIELD_NUMBER = 6;
        public static final int PRIO_FLAG_FIELD_NUMBER = 2;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int S_WD_FIELD_NUMBER = 4;
        public static final int WP_WD_FIELD_NUMBER = 3;
        private boolean hasIfNav;
        private boolean hasSWd;
        private boolean hasStartCity;
        private List<String> cityList_ = Collections.emptyList();
        private List<String> prioFlag_ = Collections.emptyList();
        private List<String> wpWd_ = Collections.emptyList();
        private String sWd_ = "";
        private List<String> eWd_ = Collections.emptyList();
        private boolean ifNav_ = false;
        private StartCity startCity_ = null;
        private List<EndCity> endCity_ = Collections.emptyList();
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class EndCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            private boolean hasCname;
            private boolean hasCode;
            private int code_ = 0;
            private String cname_ = "";
            private int cachedSize = -1;

            public static EndCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new EndCity().mergeFrom(codedInputStreamMicro);
            }

            public final EndCity clear() {
                clearCode();
                clearCname();
                this.cachedSize = -1;
                return this;
            }

            public EndCity clearCname() {
                this.hasCname = false;
                this.cname_ = "";
                return this;
            }

            public EndCity clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCname() {
                return this.cname_;
            }

            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (hasCname()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public boolean hasCname() {
                return this.hasCname;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public EndCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setCode(codedInputStreamMicro.readInt32());
                    } else if (readTag == 18) {
                        setCname(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public EndCity setCname(String str) {
                this.hasCname = true;
                this.cname_ = str;
                return this;
            }

            public EndCity setCode(int i) {
                this.hasCode = true;
                this.code_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }

            public static EndCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class StartCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            private boolean hasCname;
            private boolean hasCode;
            private int code_ = 0;
            private String cname_ = "";
            private int cachedSize = -1;

            public static StartCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartCity().mergeFrom(codedInputStreamMicro);
            }

            public final StartCity clear() {
                clearCode();
                clearCname();
                this.cachedSize = -1;
                return this;
            }

            public StartCity clearCname() {
                this.hasCname = false;
                this.cname_ = "";
                return this;
            }

            public StartCity clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCname() {
                return this.cname_;
            }

            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (hasCname()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public boolean hasCname() {
                return this.hasCname;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public StartCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setCode(codedInputStreamMicro.readInt32());
                    } else if (readTag == 18) {
                        setCname(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public StartCity setCname(String str) {
                this.hasCname = true;
                this.cname_ = str;
                return this;
            }

            public StartCity setCode(int i) {
                this.hasCode = true;
                this.code_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }

            public static StartCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public Option addCityList(String str) {
            str.getClass();
            if (this.cityList_.isEmpty()) {
                this.cityList_ = new ArrayList();
            }
            this.cityList_.add(str);
            return this;
        }

        public Option addEWd(String str) {
            str.getClass();
            if (this.eWd_.isEmpty()) {
                this.eWd_ = new ArrayList();
            }
            this.eWd_.add(str);
            return this;
        }

        public Option addEndCity(EndCity endCity) {
            if (endCity == null) {
                return this;
            }
            if (this.endCity_.isEmpty()) {
                this.endCity_ = new ArrayList();
            }
            this.endCity_.add(endCity);
            return this;
        }

        public Option addPrioFlag(String str) {
            str.getClass();
            if (this.prioFlag_.isEmpty()) {
                this.prioFlag_ = new ArrayList();
            }
            this.prioFlag_.add(str);
            return this;
        }

        public Option addWpWd(String str) {
            str.getClass();
            if (this.wpWd_.isEmpty()) {
                this.wpWd_ = new ArrayList();
            }
            this.wpWd_.add(str);
            return this;
        }

        public final Option clear() {
            clearCityList();
            clearPrioFlag();
            clearWpWd();
            clearSWd();
            clearEWd();
            clearIfNav();
            clearStartCity();
            clearEndCity();
            this.cachedSize = -1;
            return this;
        }

        public Option clearCityList() {
            this.cityList_ = Collections.emptyList();
            return this;
        }

        public Option clearEWd() {
            this.eWd_ = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.endCity_ = Collections.emptyList();
            return this;
        }

        public Option clearIfNav() {
            this.hasIfNav = false;
            this.ifNav_ = false;
            return this;
        }

        public Option clearPrioFlag() {
            this.prioFlag_ = Collections.emptyList();
            return this;
        }

        public Option clearSWd() {
            this.hasSWd = false;
            this.sWd_ = "";
            return this;
        }

        public Option clearStartCity() {
            this.hasStartCity = false;
            this.startCity_ = null;
            return this;
        }

        public Option clearWpWd() {
            this.wpWd_ = Collections.emptyList();
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getCityList(int i) {
            return this.cityList_.get(i);
        }

        public int getCityListCount() {
            return this.cityList_.size();
        }

        public List<String> getCityListList() {
            return this.cityList_;
        }

        public String getEWd(int i) {
            return this.eWd_.get(i);
        }

        public int getEWdCount() {
            return this.eWd_.size();
        }

        public List<String> getEWdList() {
            return this.eWd_;
        }

        public EndCity getEndCity(int i) {
            return this.endCity_.get(i);
        }

        public int getEndCityCount() {
            return this.endCity_.size();
        }

        public List<EndCity> getEndCityList() {
            return this.endCity_;
        }

        public boolean getIfNav() {
            return this.ifNav_;
        }

        public String getPrioFlag(int i) {
            return this.prioFlag_.get(i);
        }

        public int getPrioFlagCount() {
            return this.prioFlag_.size();
        }

        public List<String> getPrioFlagList() {
            return this.prioFlag_;
        }

        public String getSWd() {
            return this.sWd_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            Iterator<String> it = getCityListList().iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                i2 += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
            }
            int size = i2 + getCityListList().size();
            Iterator<String> it2 = getPrioFlagList().iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                i3 += CodedOutputStreamMicro.computeStringSizeNoTag(it2.next());
            }
            int size2 = size + i3 + getPrioFlagList().size();
            Iterator<String> it3 = getWpWdList().iterator();
            int i4 = 0;
            while (it3.hasNext()) {
                i4 += CodedOutputStreamMicro.computeStringSizeNoTag(it3.next());
            }
            int size3 = size2 + i4 + getWpWdList().size();
            if (hasSWd()) {
                size3 += CodedOutputStreamMicro.computeStringSize(4, getSWd());
            }
            Iterator<String> it4 = getEWdList().iterator();
            while (it4.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it4.next());
            }
            int size4 = size3 + i + getEWdList().size();
            if (hasIfNav()) {
                size4 += CodedOutputStreamMicro.computeBoolSize(6, getIfNav());
            }
            if (hasStartCity()) {
                size4 += CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
            }
            Iterator<EndCity> it5 = getEndCityList().iterator();
            while (it5.hasNext()) {
                size4 += CodedOutputStreamMicro.computeMessageSize(8, it5.next());
            }
            this.cachedSize = size4;
            return size4;
        }

        public StartCity getStartCity() {
            return this.startCity_;
        }

        public String getWpWd(int i) {
            return this.wpWd_.get(i);
        }

        public int getWpWdCount() {
            return this.wpWd_.size();
        }

        public List<String> getWpWdList() {
            return this.wpWd_;
        }

        public boolean hasIfNav() {
            return this.hasIfNav;
        }

        public boolean hasSWd() {
            return this.hasSWd;
        }

        public boolean hasStartCity() {
            return this.hasStartCity;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    addCityList(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    addPrioFlag(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    addWpWd(codedInputStreamMicro.readString());
                } else if (readTag == 34) {
                    setSWd(codedInputStreamMicro.readString());
                } else if (readTag == 42) {
                    addEWd(codedInputStreamMicro.readString());
                } else if (readTag == 48) {
                    setIfNav(codedInputStreamMicro.readBool());
                } else if (readTag == 58) {
                    StartCity startCity = new StartCity();
                    codedInputStreamMicro.readMessage(startCity);
                    setStartCity(startCity);
                } else if (readTag == 66) {
                    EndCity endCity = new EndCity();
                    codedInputStreamMicro.readMessage(endCity);
                    addEndCity(endCity);
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Option setCityList(int i, String str) {
            str.getClass();
            this.cityList_.set(i, str);
            return this;
        }

        public Option setEWd(int i, String str) {
            str.getClass();
            this.eWd_.set(i, str);
            return this;
        }

        public Option setEndCity(int i, EndCity endCity) {
            if (endCity == null) {
                return this;
            }
            this.endCity_.set(i, endCity);
            return this;
        }

        public Option setIfNav(boolean z) {
            this.hasIfNav = true;
            this.ifNav_ = z;
            return this;
        }

        public Option setPrioFlag(int i, String str) {
            str.getClass();
            this.prioFlag_.set(i, str);
            return this;
        }

        public Option setSWd(String str) {
            this.hasSWd = true;
            this.sWd_ = str;
            return this;
        }

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.hasStartCity = true;
            this.startCity_ = startCity;
            return this;
        }

        public Option setWpWd(int i, String str) {
            str.getClass();
            this.wpWd_.set(i, str);
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            Iterator<String> it = getCityListList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeString(1, it.next());
            }
            Iterator<String> it2 = getPrioFlagList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeString(2, it2.next());
            }
            Iterator<String> it3 = getWpWdList().iterator();
            while (it3.hasNext()) {
                codedOutputStreamMicro.writeString(3, it3.next());
            }
            if (hasSWd()) {
                codedOutputStreamMicro.writeString(4, getSWd());
            }
            Iterator<String> it4 = getEWdList().iterator();
            while (it4.hasNext()) {
                codedOutputStreamMicro.writeString(5, it4.next());
            }
            if (hasIfNav()) {
                codedOutputStreamMicro.writeBool(6, getIfNav());
            }
            if (hasStartCity()) {
                codedOutputStreamMicro.writeMessage(7, getStartCity());
            }
            Iterator<EndCity> it5 = getEndCityList().iterator();
            while (it5.hasNext()) {
                codedOutputStreamMicro.writeMessage(8, it5.next());
            }
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class SuggestQuery extends MessageMicro {
        public static final int QUERY_FIELD_NUMBER = 1;
        private boolean hasQuery;
        private String query_ = "";
        private int cachedSize = -1;

        public static SuggestQuery parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SuggestQuery().mergeFrom(codedInputStreamMicro);
        }

        public final SuggestQuery clear() {
            clearQuery();
            this.cachedSize = -1;
            return this;
        }

        public SuggestQuery clearQuery() {
            this.hasQuery = false;
            this.query_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getQuery() {
            return this.query_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasQuery() ? CodedOutputStreamMicro.computeStringSize(1, getQuery()) : 0;
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public boolean hasQuery() {
            return this.hasQuery;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public SuggestQuery mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setQuery(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public SuggestQuery setQuery(String str) {
            this.hasQuery = true;
            this.query_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasQuery()) {
                codedOutputStreamMicro.writeString(1, getQuery());
            }
        }

        public static SuggestQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SuggestQuery) new SuggestQuery().mergeFrom(bArr);
        }
    }

    public static TrafficPois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrafficPois().mergeFrom(codedInputStreamMicro);
    }

    public TrafficPois addSuggestQuery(SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        if (this.suggestQuery_.isEmpty()) {
            this.suggestQuery_ = new ArrayList();
        }
        this.suggestQuery_.add(suggestQuery);
        return this;
    }

    public final TrafficPois clear() {
        clearOption();
        clearCurrentCity();
        clearContent();
        clearSuggestQuery();
        clearSuggestQueryFlag();
        clearImgeShow();
        clearListType();
        this.cachedSize = -1;
        return this;
    }

    public TrafficPois clearContent() {
        this.hasContent = false;
        this.content_ = null;
        return this;
    }

    public TrafficPois clearCurrentCity() {
        this.hasCurrentCity = false;
        this.currentCity_ = null;
        return this;
    }

    public TrafficPois clearImgeShow() {
        this.hasImgeShow = false;
        this.imgeShow_ = null;
        return this;
    }

    public TrafficPois clearListType() {
        this.hasListType = false;
        this.listType_ = 0;
        return this;
    }

    public TrafficPois clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public TrafficPois clearSuggestQuery() {
        this.suggestQuery_ = Collections.emptyList();
        return this;
    }

    public TrafficPois clearSuggestQueryFlag() {
        this.hasSuggestQueryFlag = false;
        this.suggestQueryFlag_ = 0;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public Content getContent() {
        return this.content_;
    }

    public CurrentCity getCurrentCity() {
        return this.currentCity_;
    }

    public ImageShow getImgeShow() {
        return this.imgeShow_;
    }

    public int getListType() {
        return this.listType_;
    }

    public Option getOption() {
        return this.option_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeMessageSize = hasOption() ? CodedOutputStreamMicro.computeMessageSize(1, getOption()) : 0;
        if (hasCurrentCity()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, getCurrentCity());
        }
        if (hasContent()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(3, getContent());
        }
        Iterator<SuggestQuery> it = getSuggestQueryList().iterator();
        while (it.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(4, it.next());
        }
        if (hasSuggestQueryFlag()) {
            computeMessageSize += CodedOutputStreamMicro.computeInt32Size(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(6, getImgeShow());
        }
        if (hasListType()) {
            computeMessageSize += CodedOutputStreamMicro.computeInt32Size(7, getListType());
        }
        this.cachedSize = computeMessageSize;
        return computeMessageSize;
    }

    public SuggestQuery getSuggestQuery(int i) {
        return this.suggestQuery_.get(i);
    }

    public int getSuggestQueryCount() {
        return this.suggestQuery_.size();
    }

    public int getSuggestQueryFlag() {
        return this.suggestQueryFlag_;
    }

    public List<SuggestQuery> getSuggestQueryList() {
        return this.suggestQuery_;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasCurrentCity() {
        return this.hasCurrentCity;
    }

    public boolean hasImgeShow() {
        return this.hasImgeShow;
    }

    public boolean hasListType() {
        return this.hasListType;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasSuggestQueryFlag() {
        return this.hasSuggestQueryFlag;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TrafficPois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                Option option = new Option();
                codedInputStreamMicro.readMessage(option);
                setOption(option);
            } else if (readTag == 18) {
                CurrentCity currentCity = new CurrentCity();
                codedInputStreamMicro.readMessage(currentCity);
                setCurrentCity(currentCity);
            } else if (readTag == 26) {
                Content content = new Content();
                codedInputStreamMicro.readMessage(content);
                setContent(content);
            } else if (readTag == 34) {
                SuggestQuery suggestQuery = new SuggestQuery();
                codedInputStreamMicro.readMessage(suggestQuery);
                addSuggestQuery(suggestQuery);
            } else if (readTag == 40) {
                setSuggestQueryFlag(codedInputStreamMicro.readInt32());
            } else if (readTag == 50) {
                ImageShow imageShow = new ImageShow();
                codedInputStreamMicro.readMessage(imageShow);
                setImgeShow(imageShow);
            } else if (readTag == 56) {
                setListType(codedInputStreamMicro.readInt32());
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public TrafficPois setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.hasContent = true;
        this.content_ = content;
        return this;
    }

    public TrafficPois setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.hasCurrentCity = true;
        this.currentCity_ = currentCity;
        return this;
    }

    public TrafficPois setImgeShow(ImageShow imageShow) {
        if (imageShow == null) {
            return clearImgeShow();
        }
        this.hasImgeShow = true;
        this.imgeShow_ = imageShow;
        return this;
    }

    public TrafficPois setListType(int i) {
        this.hasListType = true;
        this.listType_ = i;
        return this;
    }

    public TrafficPois setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public TrafficPois setSuggestQuery(int i, SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        this.suggestQuery_.set(i, suggestQuery);
        return this;
    }

    public TrafficPois setSuggestQueryFlag(int i) {
        this.hasSuggestQueryFlag = true;
        this.suggestQueryFlag_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(2, getCurrentCity());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(3, getContent());
        }
        Iterator<SuggestQuery> it = getSuggestQueryList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(4, it.next());
        }
        if (hasSuggestQueryFlag()) {
            codedOutputStreamMicro.writeInt32(5, getSuggestQueryFlag());
        }
        if (hasImgeShow()) {
            codedOutputStreamMicro.writeMessage(6, getImgeShow());
        }
        if (hasListType()) {
            codedOutputStreamMicro.writeInt32(7, getListType());
        }
    }

    public static TrafficPois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrafficPois) new TrafficPois().mergeFrom(bArr);
    }
}
