package com.baidu.location.pb;

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
public final class BhpsPackage extends MessageMicro {
    public static final int AK_FIELD_NUMBER = 15;
    public static final int ANDROID_VERSION_FIELD_NUMBER = 13;
    public static final int APP_NAME_FIELD_NUMBER = 17;
    public static final int CUID_FIELD_NUMBER = 3;
    public static final int EVENT_BRAND_FIELD_NUMBER = 11;
    public static final int FROM_FIELD_NUMBER = 8;
    public static final int GPS_FIRST_FIELD_NUMBER = 4;
    public static final int GPS_POINT_DELAT_FIELD_NUMBER = 7;
    public static final int GPS_POINT_NUM_FIELD_NUMBER = 1;
    public static final int NAVI_START_OR_END_FLAG_FIELD_NUMBER = 10;
    public static final int PHONE_TYPE_FIELD_NUMBER = 16;
    public static final int RTK_SDK_VERSION_FIELD_NUMBER = 12;
    public static final int SERVICE_VERSION_FIELD_NUMBER = 14;
    public static final int SUB_FROM_FIELD_NUMBER = 9;
    public static final int VERSION_FIELD_NUMBER = 2;
    private boolean hasAndroidVersion;
    private boolean hasCuid;
    private boolean hasEventBrand;
    private boolean hasFrom;
    private boolean hasGpsFirst;
    private boolean hasGpsPointNum;
    private boolean hasNaviStartOrEndFlag;
    private boolean hasPhoneType;
    private boolean hasRtkSdkVersion;
    private boolean hasServiceVersion;
    private boolean hasSubFrom;
    private boolean hasVersion;
    private int gpsPointNum_ = 0;
    private String version_ = "";
    private ByteStringMicro cuid_ = ByteStringMicro.EMPTY;
    private BhpsPointFirst gpsFirst_ = null;
    private List<BhpsPointDelta> gpsPointDelat_ = Collections.emptyList();
    private int from_ = 0;
    private String subFrom_ = "";
    private int naviStartOrEndFlag_ = 0;
    private int eventBrand_ = 0;
    private String rtkSdkVersion_ = "";
    private String androidVersion_ = "";
    private String serviceVersion_ = "";
    private List<String> ak_ = Collections.emptyList();
    private String phoneType_ = "";
    private List<String> appName_ = Collections.emptyList();
    private int cachedSize = -1;

    public static BhpsPackage parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (BhpsPackage) new BhpsPackage().mergeFrom(bArr);
    }

    public BhpsPackage addAk(String str) {
        str.getClass();
        if (this.ak_.isEmpty()) {
            this.ak_ = new ArrayList();
        }
        this.ak_.add(str);
        return this;
    }

    public BhpsPackage addAppName(String str) {
        str.getClass();
        if (this.appName_.isEmpty()) {
            this.appName_ = new ArrayList();
        }
        this.appName_.add(str);
        return this;
    }

    public BhpsPackage addGpsPointDelat(BhpsPointDelta bhpsPointDelta) {
        if (bhpsPointDelta == null) {
            return this;
        }
        if (this.gpsPointDelat_.isEmpty()) {
            this.gpsPointDelat_ = new ArrayList();
        }
        this.gpsPointDelat_.add(bhpsPointDelta);
        return this;
    }

    public final BhpsPackage clear() {
        clearGpsPointNum();
        clearVersion();
        clearCuid();
        clearGpsFirst();
        clearGpsPointDelat();
        clearFrom();
        clearSubFrom();
        clearNaviStartOrEndFlag();
        clearEventBrand();
        clearRtkSdkVersion();
        clearAndroidVersion();
        clearServiceVersion();
        clearAk();
        clearPhoneType();
        clearAppName();
        this.cachedSize = -1;
        return this;
    }

    public BhpsPackage clearAk() {
        this.ak_ = Collections.emptyList();
        return this;
    }

    public BhpsPackage clearAndroidVersion() {
        this.hasAndroidVersion = false;
        this.androidVersion_ = "";
        return this;
    }

    public BhpsPackage clearAppName() {
        this.appName_ = Collections.emptyList();
        return this;
    }

    public BhpsPackage clearCuid() {
        this.hasCuid = false;
        this.cuid_ = ByteStringMicro.EMPTY;
        return this;
    }

    public BhpsPackage clearEventBrand() {
        this.hasEventBrand = false;
        this.eventBrand_ = 0;
        return this;
    }

    public BhpsPackage clearFrom() {
        this.hasFrom = false;
        this.from_ = 0;
        return this;
    }

    public BhpsPackage clearGpsFirst() {
        this.hasGpsFirst = false;
        this.gpsFirst_ = null;
        return this;
    }

    public BhpsPackage clearGpsPointDelat() {
        this.gpsPointDelat_ = Collections.emptyList();
        return this;
    }

    public BhpsPackage clearGpsPointNum() {
        this.hasGpsPointNum = false;
        this.gpsPointNum_ = 0;
        return this;
    }

    public BhpsPackage clearNaviStartOrEndFlag() {
        this.hasNaviStartOrEndFlag = false;
        this.naviStartOrEndFlag_ = 0;
        return this;
    }

    public BhpsPackage clearPhoneType() {
        this.hasPhoneType = false;
        this.phoneType_ = "";
        return this;
    }

    public BhpsPackage clearRtkSdkVersion() {
        this.hasRtkSdkVersion = false;
        this.rtkSdkVersion_ = "";
        return this;
    }

    public BhpsPackage clearServiceVersion() {
        this.hasServiceVersion = false;
        this.serviceVersion_ = "";
        return this;
    }

    public BhpsPackage clearSubFrom() {
        this.hasSubFrom = false;
        this.subFrom_ = "";
        return this;
    }

    public BhpsPackage clearVersion() {
        this.hasVersion = false;
        this.version_ = "";
        return this;
    }

    public String getAk(int i) {
        return this.ak_.get(i);
    }

    public int getAkCount() {
        return this.ak_.size();
    }

    public List<String> getAkList() {
        return this.ak_;
    }

    public String getAndroidVersion() {
        return this.androidVersion_;
    }

    public String getAppName(int i) {
        return this.appName_.get(i);
    }

    public int getAppNameCount() {
        return this.appName_.size();
    }

    public List<String> getAppNameList() {
        return this.appName_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getCuid() {
        return this.cuid_;
    }

    public int getEventBrand() {
        return this.eventBrand_;
    }

    public int getFrom() {
        return this.from_;
    }

    public BhpsPointFirst getGpsFirst() {
        return this.gpsFirst_;
    }

    public BhpsPointDelta getGpsPointDelat(int i) {
        return this.gpsPointDelat_.get(i);
    }

    public int getGpsPointDelatCount() {
        return this.gpsPointDelat_.size();
    }

    public List<BhpsPointDelta> getGpsPointDelatList() {
        return this.gpsPointDelat_;
    }

    public int getGpsPointNum() {
        return this.gpsPointNum_;
    }

    public int getNaviStartOrEndFlag() {
        return this.naviStartOrEndFlag_;
    }

    public String getPhoneType() {
        return this.phoneType_;
    }

    public String getRtkSdkVersion() {
        return this.rtkSdkVersion_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        int i2 = 0;
        if (hasGpsPointNum()) {
            i = CodedOutputStreamMicro.computeUInt32Size(1, getGpsPointNum());
        } else {
            i = 0;
        }
        if (hasVersion()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getVersion());
        }
        if (hasCuid()) {
            i += CodedOutputStreamMicro.computeBytesSize(3, getCuid());
        }
        if (hasGpsFirst()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, getGpsFirst());
        }
        Iterator<BhpsPointDelta> it = getGpsPointDelatList().iterator();
        while (it.hasNext()) {
            i += CodedOutputStreamMicro.computeMessageSize(7, it.next());
        }
        if (hasFrom()) {
            i += CodedOutputStreamMicro.computeUInt32Size(8, getFrom());
        }
        if (hasSubFrom()) {
            i += CodedOutputStreamMicro.computeStringSize(9, getSubFrom());
        }
        if (hasNaviStartOrEndFlag()) {
            i += CodedOutputStreamMicro.computeUInt32Size(10, getNaviStartOrEndFlag());
        }
        if (hasEventBrand()) {
            i += CodedOutputStreamMicro.computeUInt32Size(11, getEventBrand());
        }
        if (hasRtkSdkVersion()) {
            i += CodedOutputStreamMicro.computeStringSize(12, getRtkSdkVersion());
        }
        if (hasAndroidVersion()) {
            i += CodedOutputStreamMicro.computeStringSize(13, getAndroidVersion());
        }
        if (hasServiceVersion()) {
            i += CodedOutputStreamMicro.computeStringSize(14, getServiceVersion());
        }
        Iterator<String> it2 = getAkList().iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            i3 += CodedOutputStreamMicro.computeStringSizeNoTag(it2.next());
        }
        int size = i + i3 + getAkList().size();
        if (hasPhoneType()) {
            size += CodedOutputStreamMicro.computeStringSize(16, getPhoneType());
        }
        Iterator<String> it3 = getAppNameList().iterator();
        while (it3.hasNext()) {
            i2 += CodedOutputStreamMicro.computeStringSizeNoTag(it3.next());
        }
        int size2 = size + i2 + (getAppNameList().size() * 2);
        this.cachedSize = size2;
        return size2;
    }

    public String getServiceVersion() {
        return this.serviceVersion_;
    }

    public String getSubFrom() {
        return this.subFrom_;
    }

    public String getVersion() {
        return this.version_;
    }

    public boolean hasAndroidVersion() {
        return this.hasAndroidVersion;
    }

    public boolean hasCuid() {
        return this.hasCuid;
    }

    public boolean hasEventBrand() {
        return this.hasEventBrand;
    }

    public boolean hasFrom() {
        return this.hasFrom;
    }

    public boolean hasGpsFirst() {
        return this.hasGpsFirst;
    }

    public boolean hasGpsPointNum() {
        return this.hasGpsPointNum;
    }

    public boolean hasNaviStartOrEndFlag() {
        return this.hasNaviStartOrEndFlag;
    }

    public boolean hasPhoneType() {
        return this.hasPhoneType;
    }

    public boolean hasRtkSdkVersion() {
        return this.hasRtkSdkVersion;
    }

    public boolean hasServiceVersion() {
        return this.hasServiceVersion;
    }

    public boolean hasSubFrom() {
        return this.hasSubFrom;
    }

    public boolean hasVersion() {
        return this.hasVersion;
    }

    public final boolean isInitialized() {
        if (!this.hasGpsPointNum || !this.hasVersion || !this.hasCuid || !this.hasGpsFirst || !this.hasFrom || !this.hasSubFrom || !getGpsFirst().isInitialized()) {
            return false;
        }
        Iterator<BhpsPointDelta> it = getGpsPointDelatList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public BhpsPackage setAk(int i, String str) {
        str.getClass();
        this.ak_.set(i, str);
        return this;
    }

    public BhpsPackage setAndroidVersion(String str) {
        this.hasAndroidVersion = true;
        this.androidVersion_ = str;
        return this;
    }

    public BhpsPackage setAppName(int i, String str) {
        str.getClass();
        this.appName_.set(i, str);
        return this;
    }

    public BhpsPackage setCuid(ByteStringMicro byteStringMicro) {
        this.hasCuid = true;
        this.cuid_ = byteStringMicro;
        return this;
    }

    public BhpsPackage setEventBrand(int i) {
        this.hasEventBrand = true;
        this.eventBrand_ = i;
        return this;
    }

    public BhpsPackage setFrom(int i) {
        this.hasFrom = true;
        this.from_ = i;
        return this;
    }

    public BhpsPackage setGpsFirst(BhpsPointFirst bhpsPointFirst) {
        if (bhpsPointFirst == null) {
            return clearGpsFirst();
        }
        this.hasGpsFirst = true;
        this.gpsFirst_ = bhpsPointFirst;
        return this;
    }

    public BhpsPackage setGpsPointDelat(int i, BhpsPointDelta bhpsPointDelta) {
        if (bhpsPointDelta == null) {
            return this;
        }
        this.gpsPointDelat_.set(i, bhpsPointDelta);
        return this;
    }

    public BhpsPackage setGpsPointNum(int i) {
        this.hasGpsPointNum = true;
        this.gpsPointNum_ = i;
        return this;
    }

    public BhpsPackage setNaviStartOrEndFlag(int i) {
        this.hasNaviStartOrEndFlag = true;
        this.naviStartOrEndFlag_ = i;
        return this;
    }

    public BhpsPackage setPhoneType(String str) {
        this.hasPhoneType = true;
        this.phoneType_ = str;
        return this;
    }

    public BhpsPackage setRtkSdkVersion(String str) {
        this.hasRtkSdkVersion = true;
        this.rtkSdkVersion_ = str;
        return this;
    }

    public BhpsPackage setServiceVersion(String str) {
        this.hasServiceVersion = true;
        this.serviceVersion_ = str;
        return this;
    }

    public BhpsPackage setSubFrom(String str) {
        this.hasSubFrom = true;
        this.subFrom_ = str;
        return this;
    }

    public BhpsPackage setVersion(String str) {
        this.hasVersion = true;
        this.version_ = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasGpsPointNum()) {
            codedOutputStreamMicro.writeUInt32(1, getGpsPointNum());
        }
        if (hasVersion()) {
            codedOutputStreamMicro.writeString(2, getVersion());
        }
        if (hasCuid()) {
            codedOutputStreamMicro.writeBytes(3, getCuid());
        }
        if (hasGpsFirst()) {
            codedOutputStreamMicro.writeMessage(4, getGpsFirst());
        }
        Iterator<BhpsPointDelta> it = getGpsPointDelatList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(7, it.next());
        }
        if (hasFrom()) {
            codedOutputStreamMicro.writeUInt32(8, getFrom());
        }
        if (hasSubFrom()) {
            codedOutputStreamMicro.writeString(9, getSubFrom());
        }
        if (hasNaviStartOrEndFlag()) {
            codedOutputStreamMicro.writeUInt32(10, getNaviStartOrEndFlag());
        }
        if (hasEventBrand()) {
            codedOutputStreamMicro.writeUInt32(11, getEventBrand());
        }
        if (hasRtkSdkVersion()) {
            codedOutputStreamMicro.writeString(12, getRtkSdkVersion());
        }
        if (hasAndroidVersion()) {
            codedOutputStreamMicro.writeString(13, getAndroidVersion());
        }
        if (hasServiceVersion()) {
            codedOutputStreamMicro.writeString(14, getServiceVersion());
        }
        Iterator<String> it2 = getAkList().iterator();
        while (it2.hasNext()) {
            codedOutputStreamMicro.writeString(15, it2.next());
        }
        if (hasPhoneType()) {
            codedOutputStreamMicro.writeString(16, getPhoneType());
        }
        Iterator<String> it3 = getAppNameList().iterator();
        while (it3.hasNext()) {
            codedOutputStreamMicro.writeString(17, it3.next());
        }
    }

    public static BhpsPackage parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new BhpsPackage().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public BhpsPackage mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    setGpsPointNum(codedInputStreamMicro.readUInt32());
                    break;
                case 18:
                    setVersion(codedInputStreamMicro.readString());
                    break;
                case 26:
                    setCuid(codedInputStreamMicro.readBytes());
                    break;
                case 34:
                    BhpsPointFirst bhpsPointFirst = new BhpsPointFirst();
                    codedInputStreamMicro.readMessage(bhpsPointFirst);
                    setGpsFirst(bhpsPointFirst);
                    break;
                case 58:
                    BhpsPointDelta bhpsPointDelta = new BhpsPointDelta();
                    codedInputStreamMicro.readMessage(bhpsPointDelta);
                    addGpsPointDelat(bhpsPointDelta);
                    break;
                case 64:
                    setFrom(codedInputStreamMicro.readUInt32());
                    break;
                case 74:
                    setSubFrom(codedInputStreamMicro.readString());
                    break;
                case 80:
                    setNaviStartOrEndFlag(codedInputStreamMicro.readUInt32());
                    break;
                case 88:
                    setEventBrand(codedInputStreamMicro.readUInt32());
                    break;
                case 98:
                    setRtkSdkVersion(codedInputStreamMicro.readString());
                    break;
                case 106:
                    setAndroidVersion(codedInputStreamMicro.readString());
                    break;
                case 114:
                    setServiceVersion(codedInputStreamMicro.readString());
                    break;
                case 122:
                    addAk(codedInputStreamMicro.readString());
                    break;
                case 130:
                    setPhoneType(codedInputStreamMicro.readString());
                    break;
                case 138:
                    addAppName(codedInputStreamMicro.readString());
                    break;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
