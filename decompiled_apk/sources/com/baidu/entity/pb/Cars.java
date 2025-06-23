package com.baidu.entity.pb;

import XIXIX.OOXIXo;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import com.jieli.jl_rcsp.constant.Command;
import com.sma.smartv3.view.picker.HeightPicker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class Cars extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int TEST_FIELD_NUMBER = 3;
    private boolean hasContent;
    private boolean hasOption;
    private boolean hasTest;
    private Option option_ = null;
    private Content content_ = null;
    private String test_ = "";
    private int cachedSize = -1;

    /* loaded from: classes7.dex */
    public static final class Content extends MessageMicro {
        public static final int ACCI_INFOS_FIELD_NUMBER = 6;
        public static final int AVOID_CAR_RULES_FIELD_NUMBER = 14;
        public static final int AVOID_JAM_PREFER_FIELD_NUMBER = 17;
        public static final int COMMUTER_TITLE_DESC_FIELD_NUMBER = 16;
        public static final int CRIP_TYPE_FIELD_NUMBER = 15;
        public static final int DYNAMIC_CONTENT_FIELD_NUMBER = 18;
        public static final int HEAT_EFFECTIVE_CITY_FLAG_FIELD_NUMBER = 13;
        public static final int LOCAL_INFO_TIPS_FIELD_NUMBER = 8;
        public static final int LONG_DISTANCE_INFO_FIELD_NUMBER = 11;
        public static final int ROUTEALL = 1;
        public static final int ROUTEPART = 2;
        public static final int ROUTESTATUS_FIELD_NUMBER = 7;
        public static final int ROUTES_FIELD_NUMBER = 1;
        public static final int SESSIONID_FIELD_NUMBER = 9;
        public static final int STEPS_FIELD_NUMBER = 2;
        public static final int STEPTS_FIELD_NUMBER = 3;
        public static final int TAXIS_FIELD_NUMBER = 4;
        public static final int TRAFFICS_FIELD_NUMBER = 5;
        public static final int WALKINF_FIELD_NUMBER = 10;
        public static final int YELLOW_TIPS_LIST_FIELD_NUMBER = 12;
        private boolean hasAvoidJamPrefer;
        private boolean hasCommuterTitleDesc;
        private boolean hasCripType;
        private boolean hasDynamicContent;
        private boolean hasHeatEffectiveCityFlag;
        private boolean hasLocalInfoTips;
        private boolean hasRouteStatus;
        private boolean hasSessionid;
        private boolean hasWalkinf;
        private List<Routes> routes_ = Collections.emptyList();
        private List<Steps> steps_ = Collections.emptyList();
        private List<Stepts> stepts_ = Collections.emptyList();
        private List<Taxis> taxis_ = Collections.emptyList();
        private List<Traffics> traffics_ = Collections.emptyList();
        private List<AcciInfos> acciInfos_ = Collections.emptyList();
        private int routeStatus_ = 1;
        private String localInfoTips_ = "";
        private String sessionid_ = "";
        private WalkInfoT walkinf_ = null;
        private List<LongDistanceInfo> longDistanceInfo_ = Collections.emptyList();
        private List<YellowTipsList> yellowTipsList_ = Collections.emptyList();
        private int heatEffectiveCityFlag_ = 0;
        private List<String> avoidCarRules_ = Collections.emptyList();
        private int cripType_ = 0;
        private String commuterTitleDesc_ = "";
        private AvoidJamInfoPrefer avoidJamPrefer_ = null;
        private ByteStringMicro dynamicContent_ = ByteStringMicro.EMPTY;
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class AcciInfos extends MessageMicro {
            public static final int PATH_FIELD_NUMBER = 2;
            public static final int TIPS_FIELD_NUMBER = 1;
            private boolean hasPath;
            private boolean hasTips;
            private String tips_ = "";
            private String path_ = "";
            private int cachedSize = -1;

            public static AcciInfos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AcciInfos().mergeFrom(codedInputStreamMicro);
            }

            public final AcciInfos clear() {
                clearTips();
                clearPath();
                this.cachedSize = -1;
                return this;
            }

            public AcciInfos clearPath() {
                this.hasPath = false;
                this.path_ = "";
                return this;
            }

            public AcciInfos clearTips() {
                this.hasTips = false;
                this.tips_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getPath() {
                return this.path_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasTips() ? CodedOutputStreamMicro.computeStringSize(1, getTips()) : 0;
                if (hasPath()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getPath());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getTips() {
                return this.tips_;
            }

            public boolean hasPath() {
                return this.hasPath;
            }

            public boolean hasTips() {
                return this.hasTips;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AcciInfos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setTips(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setPath(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AcciInfos setPath(String str) {
                this.hasPath = true;
                this.path_ = str;
                return this;
            }

            public AcciInfos setTips(String str) {
                this.hasTips = true;
                this.tips_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTips()) {
                    codedOutputStreamMicro.writeString(1, getTips());
                }
                if (hasPath()) {
                    codedOutputStreamMicro.writeString(2, getPath());
                }
            }

            public static AcciInfos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AcciInfos) new AcciInfos().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class AvoidJamInfo extends MessageMicro {
            public static final int AVOID_JAM_DISCRIPTION_FIELD_NUMBER = 3;
            public static final int AVOID_JAM_PERCENTAGE_FIELD_NUMBER = 1;
            public static final int AVOID_JAM_PERCENTAGE_TEXT_FIELD_NUMBER = 2;
            public static final int IS_DEFAULT_FIELD_NUMBER = 5;
            public static final int MRSL_FIELD_NUMBER = 4;
            private boolean hasAvoidJamDiscription;
            private boolean hasAvoidJamPercentage;
            private boolean hasAvoidJamPercentageText;
            private boolean hasIsDefault;
            private int avoidJamPercentage_ = 0;
            private String avoidJamPercentageText_ = "";
            private String avoidJamDiscription_ = "";
            private List<String> mrsl_ = Collections.emptyList();
            private boolean isDefault_ = false;
            private int cachedSize = -1;

            public static AvoidJamInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AvoidJamInfo().mergeFrom(codedInputStreamMicro);
            }

            public AvoidJamInfo addMrsl(String str) {
                str.getClass();
                if (this.mrsl_.isEmpty()) {
                    this.mrsl_ = new ArrayList();
                }
                this.mrsl_.add(str);
                return this;
            }

            public final AvoidJamInfo clear() {
                clearAvoidJamPercentage();
                clearAvoidJamPercentageText();
                clearAvoidJamDiscription();
                clearMrsl();
                clearIsDefault();
                this.cachedSize = -1;
                return this;
            }

            public AvoidJamInfo clearAvoidJamDiscription() {
                this.hasAvoidJamDiscription = false;
                this.avoidJamDiscription_ = "";
                return this;
            }

            public AvoidJamInfo clearAvoidJamPercentage() {
                this.hasAvoidJamPercentage = false;
                this.avoidJamPercentage_ = 0;
                return this;
            }

            public AvoidJamInfo clearAvoidJamPercentageText() {
                this.hasAvoidJamPercentageText = false;
                this.avoidJamPercentageText_ = "";
                return this;
            }

            public AvoidJamInfo clearIsDefault() {
                this.hasIsDefault = false;
                this.isDefault_ = false;
                return this;
            }

            public AvoidJamInfo clearMrsl() {
                this.mrsl_ = Collections.emptyList();
                return this;
            }

            public String getAvoidJamDiscription() {
                return this.avoidJamDiscription_;
            }

            public int getAvoidJamPercentage() {
                return this.avoidJamPercentage_;
            }

            public String getAvoidJamPercentageText() {
                return this.avoidJamPercentageText_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public boolean getIsDefault() {
                return this.isDefault_;
            }

            public String getMrsl(int i) {
                return this.mrsl_.get(i);
            }

            public int getMrslCount() {
                return this.mrsl_.size();
            }

            public List<String> getMrslList() {
                return this.mrsl_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasAvoidJamPercentage() ? CodedOutputStreamMicro.computeInt32Size(1, getAvoidJamPercentage()) : 0;
                if (hasAvoidJamPercentageText()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getAvoidJamPercentageText());
                }
                if (hasAvoidJamDiscription()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getAvoidJamDiscription());
                }
                Iterator<String> it = getMrslList().iterator();
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
                }
                int size = computeInt32Size + i + getMrslList().size();
                if (hasIsDefault()) {
                    size += CodedOutputStreamMicro.computeBoolSize(5, getIsDefault());
                }
                this.cachedSize = size;
                return size;
            }

            public boolean hasAvoidJamDiscription() {
                return this.hasAvoidJamDiscription;
            }

            public boolean hasAvoidJamPercentage() {
                return this.hasAvoidJamPercentage;
            }

            public boolean hasAvoidJamPercentageText() {
                return this.hasAvoidJamPercentageText;
            }

            public boolean hasIsDefault() {
                return this.hasIsDefault;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AvoidJamInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setAvoidJamPercentage(codedInputStreamMicro.readInt32());
                    } else if (readTag == 18) {
                        setAvoidJamPercentageText(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setAvoidJamDiscription(codedInputStreamMicro.readString());
                    } else if (readTag == 34) {
                        addMrsl(codedInputStreamMicro.readString());
                    } else if (readTag == 40) {
                        setIsDefault(codedInputStreamMicro.readBool());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AvoidJamInfo setAvoidJamDiscription(String str) {
                this.hasAvoidJamDiscription = true;
                this.avoidJamDiscription_ = str;
                return this;
            }

            public AvoidJamInfo setAvoidJamPercentage(int i) {
                this.hasAvoidJamPercentage = true;
                this.avoidJamPercentage_ = i;
                return this;
            }

            public AvoidJamInfo setAvoidJamPercentageText(String str) {
                this.hasAvoidJamPercentageText = true;
                this.avoidJamPercentageText_ = str;
                return this;
            }

            public AvoidJamInfo setIsDefault(boolean z) {
                this.hasIsDefault = true;
                this.isDefault_ = z;
                return this;
            }

            public AvoidJamInfo setMrsl(int i, String str) {
                str.getClass();
                this.mrsl_.set(i, str);
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasAvoidJamPercentage()) {
                    codedOutputStreamMicro.writeInt32(1, getAvoidJamPercentage());
                }
                if (hasAvoidJamPercentageText()) {
                    codedOutputStreamMicro.writeString(2, getAvoidJamPercentageText());
                }
                if (hasAvoidJamDiscription()) {
                    codedOutputStreamMicro.writeString(3, getAvoidJamDiscription());
                }
                Iterator<String> it = getMrslList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeString(4, it.next());
                }
                if (hasIsDefault()) {
                    codedOutputStreamMicro.writeBool(5, getIsDefault());
                }
            }

            public static AvoidJamInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AvoidJamInfo) new AvoidJamInfo().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class AvoidJamInfoPrefer extends MessageMicro {
            public static final int AVOID_JAM_INFO_FIELD_NUMBER = 1;
            public static final int PREFER_DISCRIPTION_FIELD_NUMBER = 3;
            public static final int SWITCH_AVOID_JAM_FIELD_NUMBER = 2;
            private boolean hasPreferDiscription;
            private boolean hasSwitchAvoidJam;
            private List<AvoidJamInfo> avoidJamInfo_ = Collections.emptyList();
            private boolean switchAvoidJam_ = false;
            private String preferDiscription_ = "";
            private int cachedSize = -1;

            public static AvoidJamInfoPrefer parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AvoidJamInfoPrefer().mergeFrom(codedInputStreamMicro);
            }

            public AvoidJamInfoPrefer addAvoidJamInfo(AvoidJamInfo avoidJamInfo) {
                if (avoidJamInfo == null) {
                    return this;
                }
                if (this.avoidJamInfo_.isEmpty()) {
                    this.avoidJamInfo_ = new ArrayList();
                }
                this.avoidJamInfo_.add(avoidJamInfo);
                return this;
            }

            public final AvoidJamInfoPrefer clear() {
                clearAvoidJamInfo();
                clearSwitchAvoidJam();
                clearPreferDiscription();
                this.cachedSize = -1;
                return this;
            }

            public AvoidJamInfoPrefer clearAvoidJamInfo() {
                this.avoidJamInfo_ = Collections.emptyList();
                return this;
            }

            public AvoidJamInfoPrefer clearPreferDiscription() {
                this.hasPreferDiscription = false;
                this.preferDiscription_ = "";
                return this;
            }

            public AvoidJamInfoPrefer clearSwitchAvoidJam() {
                this.hasSwitchAvoidJam = false;
                this.switchAvoidJam_ = false;
                return this;
            }

            public AvoidJamInfo getAvoidJamInfo(int i) {
                return this.avoidJamInfo_.get(i);
            }

            public int getAvoidJamInfoCount() {
                return this.avoidJamInfo_.size();
            }

            public List<AvoidJamInfo> getAvoidJamInfoList() {
                return this.avoidJamInfo_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getPreferDiscription() {
                return this.preferDiscription_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                Iterator<AvoidJamInfo> it = getAvoidJamInfoList().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                }
                if (hasSwitchAvoidJam()) {
                    i += CodedOutputStreamMicro.computeBoolSize(2, getSwitchAvoidJam());
                }
                if (hasPreferDiscription()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getPreferDiscription());
                }
                this.cachedSize = i;
                return i;
            }

            public boolean getSwitchAvoidJam() {
                return this.switchAvoidJam_;
            }

            public boolean hasPreferDiscription() {
                return this.hasPreferDiscription;
            }

            public boolean hasSwitchAvoidJam() {
                return this.hasSwitchAvoidJam;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AvoidJamInfoPrefer mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        AvoidJamInfo avoidJamInfo = new AvoidJamInfo();
                        codedInputStreamMicro.readMessage(avoidJamInfo);
                        addAvoidJamInfo(avoidJamInfo);
                    } else if (readTag == 16) {
                        setSwitchAvoidJam(codedInputStreamMicro.readBool());
                    } else if (readTag == 26) {
                        setPreferDiscription(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AvoidJamInfoPrefer setAvoidJamInfo(int i, AvoidJamInfo avoidJamInfo) {
                if (avoidJamInfo == null) {
                    return this;
                }
                this.avoidJamInfo_.set(i, avoidJamInfo);
                return this;
            }

            public AvoidJamInfoPrefer setPreferDiscription(String str) {
                this.hasPreferDiscription = true;
                this.preferDiscription_ = str;
                return this;
            }

            public AvoidJamInfoPrefer setSwitchAvoidJam(boolean z) {
                this.hasSwitchAvoidJam = true;
                this.switchAvoidJam_ = z;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<AvoidJamInfo> it = getAvoidJamInfoList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(1, it.next());
                }
                if (hasSwitchAvoidJam()) {
                    codedOutputStreamMicro.writeBool(2, getSwitchAvoidJam());
                }
                if (hasPreferDiscription()) {
                    codedOutputStreamMicro.writeString(3, getPreferDiscription());
                }
            }

            public static AvoidJamInfoPrefer parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AvoidJamInfoPrefer) new AvoidJamInfoPrefer().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class LongDistanceInfo extends MessageMicro {
            public static final int VIA_CHECKSER_FIELD_NUMBER = 4;
            public static final int VIA_CITY_INFO_FIELD_NUMBER = 1;
            public static final int VIA_MAIN_ROAD_FIELD_NUMBER = 2;
            public static final int VIA_SERVICE_FIELD_NUMBER = 3;
            private List<ViaCityInfo> viaCityInfo_ = Collections.emptyList();
            private List<ViaMainRoad> viaMainRoad_ = Collections.emptyList();
            private List<ViaService> viaService_ = Collections.emptyList();
            private List<ViaCheckSer> viaCheckser_ = Collections.emptyList();
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class Point extends MessageMicro {
                public static final int X_FIELD_NUMBER = 1;
                public static final int Y_FIELD_NUMBER = 2;
                private boolean hasX;
                private boolean hasY;
                private double x_ = OOXIXo.f3760XO;
                private double y_ = OOXIXo.f3760XO;
                private int cachedSize = -1;

                public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Point().mergeFrom(codedInputStreamMicro);
                }

                public final Point clear() {
                    clearX();
                    clearY();
                    this.cachedSize = -1;
                    return this;
                }

                public Point clearX() {
                    this.hasX = false;
                    this.x_ = OOXIXo.f3760XO;
                    return this;
                }

                public Point clearY() {
                    this.hasY = false;
                    this.y_ = OOXIXo.f3760XO;
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
                    int computeDoubleSize = hasX() ? CodedOutputStreamMicro.computeDoubleSize(1, getX()) : 0;
                    if (hasY()) {
                        computeDoubleSize += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                    }
                    this.cachedSize = computeDoubleSize;
                    return computeDoubleSize;
                }

                public double getX() {
                    return this.x_;
                }

                public double getY() {
                    return this.y_;
                }

                public boolean hasX() {
                    return this.hasX;
                }

                public boolean hasY() {
                    return this.hasY;
                }

                public final boolean isInitialized() {
                    return this.hasX && this.hasY;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Point mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 9) {
                            setX(codedInputStreamMicro.readDouble());
                        } else if (readTag == 17) {
                            setY(codedInputStreamMicro.readDouble());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public Point setX(double d) {
                    this.hasX = true;
                    this.x_ = d;
                    return this;
                }

                public Point setY(double d) {
                    this.hasY = true;
                    this.y_ = d;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasX()) {
                        codedOutputStreamMicro.writeDouble(1, getX());
                    }
                    if (hasY()) {
                        codedOutputStreamMicro.writeDouble(2, getY());
                    }
                }

                public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Point) new Point().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class ServiceGasInfo extends MessageMicro {
                public static final int BRAND_FIELD_NUMBER = 2;
                public static final int GAS_TYPE_FIELD_NUMBER = 4;
                public static final int LABEL_FIELD_NUMBER = 3;
                public static final int STATION_STATUS_FIELD_NUMBER = 1;
                private boolean hasBrand;
                private boolean hasGasType;
                private boolean hasLabel;
                private boolean hasStationStatus;
                private int stationStatus_ = 0;
                private int brand_ = 0;
                private int label_ = 0;
                private int gasType_ = 0;
                private int cachedSize = -1;

                public static ServiceGasInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ServiceGasInfo().mergeFrom(codedInputStreamMicro);
                }

                public final ServiceGasInfo clear() {
                    clearStationStatus();
                    clearBrand();
                    clearLabel();
                    clearGasType();
                    this.cachedSize = -1;
                    return this;
                }

                public ServiceGasInfo clearBrand() {
                    this.hasBrand = false;
                    this.brand_ = 0;
                    return this;
                }

                public ServiceGasInfo clearGasType() {
                    this.hasGasType = false;
                    this.gasType_ = 0;
                    return this;
                }

                public ServiceGasInfo clearLabel() {
                    this.hasLabel = false;
                    this.label_ = 0;
                    return this;
                }

                public ServiceGasInfo clearStationStatus() {
                    this.hasStationStatus = false;
                    this.stationStatus_ = 0;
                    return this;
                }

                public int getBrand() {
                    return this.brand_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getGasType() {
                    return this.gasType_;
                }

                public int getLabel() {
                    return this.label_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasStationStatus() ? CodedOutputStreamMicro.computeInt32Size(1, getStationStatus()) : 0;
                    if (hasBrand()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getBrand());
                    }
                    if (hasLabel()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLabel());
                    }
                    if (hasGasType()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getGasType());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public int getStationStatus() {
                    return this.stationStatus_;
                }

                public boolean hasBrand() {
                    return this.hasBrand;
                }

                public boolean hasGasType() {
                    return this.hasGasType;
                }

                public boolean hasLabel() {
                    return this.hasLabel;
                }

                public boolean hasStationStatus() {
                    return this.hasStationStatus;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ServiceGasInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setStationStatus(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setBrand(codedInputStreamMicro.readInt32());
                        } else if (readTag == 24) {
                            setLabel(codedInputStreamMicro.readInt32());
                        } else if (readTag == 32) {
                            setGasType(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public ServiceGasInfo setBrand(int i) {
                    this.hasBrand = true;
                    this.brand_ = i;
                    return this;
                }

                public ServiceGasInfo setGasType(int i) {
                    this.hasGasType = true;
                    this.gasType_ = i;
                    return this;
                }

                public ServiceGasInfo setLabel(int i) {
                    this.hasLabel = true;
                    this.label_ = i;
                    return this;
                }

                public ServiceGasInfo setStationStatus(int i) {
                    this.hasStationStatus = true;
                    this.stationStatus_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasStationStatus()) {
                        codedOutputStreamMicro.writeInt32(1, getStationStatus());
                    }
                    if (hasBrand()) {
                        codedOutputStreamMicro.writeInt32(2, getBrand());
                    }
                    if (hasLabel()) {
                        codedOutputStreamMicro.writeInt32(3, getLabel());
                    }
                    if (hasGasType()) {
                        codedOutputStreamMicro.writeInt32(4, getGasType());
                    }
                }

                public static ServiceGasInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ServiceGasInfo) new ServiceGasInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class ViaCheckSer extends MessageMicro {
                public static final int CAN_BE_VIA_NODE_FIELD_NUMBER = 5;
                public static final int CHECKSER_NAME_DISTANCE_FROM_START_FIELD_NUMBER = 2;
                public static final int CHECKSER_NAME_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 3;
                public static final int LABEL_POINT_FIELD_NUMBER = 4;
                private boolean hasCanBeViaNode;
                private boolean hasCheckserName;
                private boolean hasCheckserNameDistanceFromStart;
                private boolean hasDuration;
                private boolean hasLabelPoint;
                private String checkserName_ = "";
                private int checkserNameDistanceFromStart_ = 0;
                private int duration_ = 0;
                private Point labelPoint_ = null;
                private int canBeViaNode_ = 0;
                private int cachedSize = -1;

                public static ViaCheckSer parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ViaCheckSer().mergeFrom(codedInputStreamMicro);
                }

                public final ViaCheckSer clear() {
                    clearCheckserName();
                    clearCheckserNameDistanceFromStart();
                    clearDuration();
                    clearLabelPoint();
                    clearCanBeViaNode();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaCheckSer clearCanBeViaNode() {
                    this.hasCanBeViaNode = false;
                    this.canBeViaNode_ = 0;
                    return this;
                }

                public ViaCheckSer clearCheckserName() {
                    this.hasCheckserName = false;
                    this.checkserName_ = "";
                    return this;
                }

                public ViaCheckSer clearCheckserNameDistanceFromStart() {
                    this.hasCheckserNameDistanceFromStart = false;
                    this.checkserNameDistanceFromStart_ = 0;
                    return this;
                }

                public ViaCheckSer clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public ViaCheckSer clearLabelPoint() {
                    this.hasLabelPoint = false;
                    this.labelPoint_ = null;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCanBeViaNode() {
                    return this.canBeViaNode_;
                }

                public String getCheckserName() {
                    return this.checkserName_;
                }

                public int getCheckserNameDistanceFromStart() {
                    return this.checkserNameDistanceFromStart_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public Point getLabelPoint() {
                    return this.labelPoint_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasCheckserName() ? CodedOutputStreamMicro.computeStringSize(1, getCheckserName()) : 0;
                    if (hasCheckserNameDistanceFromStart()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getCheckserNameDistanceFromStart());
                    }
                    if (hasDuration()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getCanBeViaNode());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public boolean hasCanBeViaNode() {
                    return this.hasCanBeViaNode;
                }

                public boolean hasCheckserName() {
                    return this.hasCheckserName;
                }

                public boolean hasCheckserNameDistanceFromStart() {
                    return this.hasCheckserNameDistanceFromStart;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasLabelPoint() {
                    return this.hasLabelPoint;
                }

                public final boolean isInitialized() {
                    return this.hasCheckserName && this.hasCheckserNameDistanceFromStart && this.hasDuration && this.hasLabelPoint && this.hasCanBeViaNode && getLabelPoint().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ViaCheckSer mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setCheckserName(codedInputStreamMicro.readString());
                        } else if (readTag == 16) {
                            setCheckserNameDistanceFromStart(codedInputStreamMicro.readInt32());
                        } else if (readTag == 24) {
                            setDuration(codedInputStreamMicro.readInt32());
                        } else if (readTag == 34) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setLabelPoint(point);
                        } else if (readTag == 40) {
                            setCanBeViaNode(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public ViaCheckSer setCanBeViaNode(int i) {
                    this.hasCanBeViaNode = true;
                    this.canBeViaNode_ = i;
                    return this;
                }

                public ViaCheckSer setCheckserName(String str) {
                    this.hasCheckserName = true;
                    this.checkserName_ = str;
                    return this;
                }

                public ViaCheckSer setCheckserNameDistanceFromStart(int i) {
                    this.hasCheckserNameDistanceFromStart = true;
                    this.checkserNameDistanceFromStart_ = i;
                    return this;
                }

                public ViaCheckSer setDuration(int i) {
                    this.hasDuration = true;
                    this.duration_ = i;
                    return this;
                }

                public ViaCheckSer setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.hasLabelPoint = true;
                    this.labelPoint_ = point;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCheckserName()) {
                        codedOutputStreamMicro.writeString(1, getCheckserName());
                    }
                    if (hasCheckserNameDistanceFromStart()) {
                        codedOutputStreamMicro.writeInt32(2, getCheckserNameDistanceFromStart());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        codedOutputStreamMicro.writeMessage(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        codedOutputStreamMicro.writeInt32(5, getCanBeViaNode());
                    }
                }

                public static ViaCheckSer parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ViaCheckSer) new ViaCheckSer().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class ViaCityInfo extends MessageMicro {
                public static final int CITY_DISTANCE_FROM_START_FIELD_NUMBER = 3;
                public static final int CITY_ID_FIELD_NUMBER = 2;
                public static final int CITY_NAME_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 4;
                public static final int POINT_FIELD_NUMBER = 6;
                public static final int PRIORITY_FIELD_NUMBER = 5;
                private boolean hasCityDistanceFromStart;
                private boolean hasCityId;
                private boolean hasCityName;
                private boolean hasDuration;
                private boolean hasPoint;
                private boolean hasPriority;
                private String cityName_ = "";
                private int cityId_ = 0;
                private int cityDistanceFromStart_ = 0;
                private int duration_ = 0;
                private int priority_ = 0;
                private Point point_ = null;
                private int cachedSize = -1;

                public static ViaCityInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ViaCityInfo().mergeFrom(codedInputStreamMicro);
                }

                public final ViaCityInfo clear() {
                    clearCityName();
                    clearCityId();
                    clearCityDistanceFromStart();
                    clearDuration();
                    clearPriority();
                    clearPoint();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaCityInfo clearCityDistanceFromStart() {
                    this.hasCityDistanceFromStart = false;
                    this.cityDistanceFromStart_ = 0;
                    return this;
                }

                public ViaCityInfo clearCityId() {
                    this.hasCityId = false;
                    this.cityId_ = 0;
                    return this;
                }

                public ViaCityInfo clearCityName() {
                    this.hasCityName = false;
                    this.cityName_ = "";
                    return this;
                }

                public ViaCityInfo clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public ViaCityInfo clearPoint() {
                    this.hasPoint = false;
                    this.point_ = null;
                    return this;
                }

                public ViaCityInfo clearPriority() {
                    this.hasPriority = false;
                    this.priority_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCityDistanceFromStart() {
                    return this.cityDistanceFromStart_;
                }

                public int getCityId() {
                    return this.cityId_;
                }

                public String getCityName() {
                    return this.cityName_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public Point getPoint() {
                    return this.point_;
                }

                public int getPriority() {
                    return this.priority_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasCityName() ? CodedOutputStreamMicro.computeStringSize(1, getCityName()) : 0;
                    if (hasCityId()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getCityId());
                    }
                    if (hasCityDistanceFromStart()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getCityDistanceFromStart());
                    }
                    if (hasDuration()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (hasPriority()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getPriority());
                    }
                    if (hasPoint()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(6, getPoint());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public boolean hasCityDistanceFromStart() {
                    return this.hasCityDistanceFromStart;
                }

                public boolean hasCityId() {
                    return this.hasCityId;
                }

                public boolean hasCityName() {
                    return this.hasCityName;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasPoint() {
                    return this.hasPoint;
                }

                public boolean hasPriority() {
                    return this.hasPriority;
                }

                public final boolean isInitialized() {
                    return this.hasCityName && this.hasCityId && this.hasCityDistanceFromStart && this.hasDuration && this.hasPoint && getPoint().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ViaCityInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setCityName(codedInputStreamMicro.readString());
                        } else if (readTag == 16) {
                            setCityId(codedInputStreamMicro.readInt32());
                        } else if (readTag == 24) {
                            setCityDistanceFromStart(codedInputStreamMicro.readInt32());
                        } else if (readTag == 32) {
                            setDuration(codedInputStreamMicro.readInt32());
                        } else if (readTag == 40) {
                            setPriority(codedInputStreamMicro.readInt32());
                        } else if (readTag == 50) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setPoint(point);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public ViaCityInfo setCityDistanceFromStart(int i) {
                    this.hasCityDistanceFromStart = true;
                    this.cityDistanceFromStart_ = i;
                    return this;
                }

                public ViaCityInfo setCityId(int i) {
                    this.hasCityId = true;
                    this.cityId_ = i;
                    return this;
                }

                public ViaCityInfo setCityName(String str) {
                    this.hasCityName = true;
                    this.cityName_ = str;
                    return this;
                }

                public ViaCityInfo setDuration(int i) {
                    this.hasDuration = true;
                    this.duration_ = i;
                    return this;
                }

                public ViaCityInfo setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.hasPoint = true;
                    this.point_ = point;
                    return this;
                }

                public ViaCityInfo setPriority(int i) {
                    this.hasPriority = true;
                    this.priority_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCityName()) {
                        codedOutputStreamMicro.writeString(1, getCityName());
                    }
                    if (hasCityId()) {
                        codedOutputStreamMicro.writeInt32(2, getCityId());
                    }
                    if (hasCityDistanceFromStart()) {
                        codedOutputStreamMicro.writeInt32(3, getCityDistanceFromStart());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (hasPriority()) {
                        codedOutputStreamMicro.writeInt32(5, getPriority());
                    }
                    if (hasPoint()) {
                        codedOutputStreamMicro.writeMessage(6, getPoint());
                    }
                }

                public static ViaCityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ViaCityInfo) new ViaCityInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class ViaMainRoad extends MessageMicro {
                public static final int DISTANCE_FIELD_NUMBER = 5;
                public static final int END_FIELD_NUMBER = 8;
                public static final int LABEL_POINT_FIELD_NUMBER = 6;
                public static final int LANE_COUNT_FIELD_NUMBER = 3;
                public static final int MAIN_ROAD_NAME_FIELD_NUMBER = 1;
                public static final int MAIN_ROAD_TYPE_FIELD_NUMBER = 2;
                public static final int SPEED_LIMIT_FIELD_NUMBER = 4;
                public static final int START_FIELD_NUMBER = 7;
                private boolean hasDistance;
                private boolean hasEnd;
                private boolean hasLabelPoint;
                private boolean hasLaneCount;
                private boolean hasMainRoadName;
                private boolean hasMainRoadType;
                private boolean hasSpeedLimit;
                private boolean hasStart;
                private String mainRoadName_ = "";
                private int mainRoadType_ = 0;
                private String laneCount_ = "";
                private String speedLimit_ = "";
                private int distance_ = 0;
                private Point labelPoint_ = null;
                private Point start_ = null;
                private Point end_ = null;
                private int cachedSize = -1;

                public static ViaMainRoad parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ViaMainRoad().mergeFrom(codedInputStreamMicro);
                }

                public final ViaMainRoad clear() {
                    clearMainRoadName();
                    clearMainRoadType();
                    clearLaneCount();
                    clearSpeedLimit();
                    clearDistance();
                    clearLabelPoint();
                    clearStart();
                    clearEnd();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaMainRoad clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public ViaMainRoad clearEnd() {
                    this.hasEnd = false;
                    this.end_ = null;
                    return this;
                }

                public ViaMainRoad clearLabelPoint() {
                    this.hasLabelPoint = false;
                    this.labelPoint_ = null;
                    return this;
                }

                public ViaMainRoad clearLaneCount() {
                    this.hasLaneCount = false;
                    this.laneCount_ = "";
                    return this;
                }

                public ViaMainRoad clearMainRoadName() {
                    this.hasMainRoadName = false;
                    this.mainRoadName_ = "";
                    return this;
                }

                public ViaMainRoad clearMainRoadType() {
                    this.hasMainRoadType = false;
                    this.mainRoadType_ = 0;
                    return this;
                }

                public ViaMainRoad clearSpeedLimit() {
                    this.hasSpeedLimit = false;
                    this.speedLimit_ = "";
                    return this;
                }

                public ViaMainRoad clearStart() {
                    this.hasStart = false;
                    this.start_ = null;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDistance() {
                    return this.distance_;
                }

                public Point getEnd() {
                    return this.end_;
                }

                public Point getLabelPoint() {
                    return this.labelPoint_;
                }

                public String getLaneCount() {
                    return this.laneCount_;
                }

                public String getMainRoadName() {
                    return this.mainRoadName_;
                }

                public int getMainRoadType() {
                    return this.mainRoadType_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasMainRoadName() ? CodedOutputStreamMicro.computeStringSize(1, getMainRoadName()) : 0;
                    if (hasMainRoadType()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getMainRoadType());
                    }
                    if (hasLaneCount()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getLaneCount());
                    }
                    if (hasSpeedLimit()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getSpeedLimit());
                    }
                    if (hasDistance()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                    }
                    if (hasLabelPoint()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(6, getLabelPoint());
                    }
                    if (hasStart()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(7, getStart());
                    }
                    if (hasEnd()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(8, getEnd());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public String getSpeedLimit() {
                    return this.speedLimit_;
                }

                public Point getStart() {
                    return this.start_;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasEnd() {
                    return this.hasEnd;
                }

                public boolean hasLabelPoint() {
                    return this.hasLabelPoint;
                }

                public boolean hasLaneCount() {
                    return this.hasLaneCount;
                }

                public boolean hasMainRoadName() {
                    return this.hasMainRoadName;
                }

                public boolean hasMainRoadType() {
                    return this.hasMainRoadType;
                }

                public boolean hasSpeedLimit() {
                    return this.hasSpeedLimit;
                }

                public boolean hasStart() {
                    return this.hasStart;
                }

                public final boolean isInitialized() {
                    return this.hasMainRoadName && this.hasMainRoadType && this.hasDistance && this.hasLabelPoint && this.hasStart && this.hasEnd && getLabelPoint().isInitialized() && getStart().isInitialized() && getEnd().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ViaMainRoad mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setMainRoadName(codedInputStreamMicro.readString());
                        } else if (readTag == 16) {
                            setMainRoadType(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            setLaneCount(codedInputStreamMicro.readString());
                        } else if (readTag == 34) {
                            setSpeedLimit(codedInputStreamMicro.readString());
                        } else if (readTag == 40) {
                            setDistance(codedInputStreamMicro.readInt32());
                        } else if (readTag == 50) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setLabelPoint(point);
                        } else if (readTag == 58) {
                            Point point2 = new Point();
                            codedInputStreamMicro.readMessage(point2);
                            setStart(point2);
                        } else if (readTag == 66) {
                            Point point3 = new Point();
                            codedInputStreamMicro.readMessage(point3);
                            setEnd(point3);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public ViaMainRoad setDistance(int i) {
                    this.hasDistance = true;
                    this.distance_ = i;
                    return this;
                }

                public ViaMainRoad setEnd(Point point) {
                    if (point == null) {
                        return clearEnd();
                    }
                    this.hasEnd = true;
                    this.end_ = point;
                    return this;
                }

                public ViaMainRoad setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.hasLabelPoint = true;
                    this.labelPoint_ = point;
                    return this;
                }

                public ViaMainRoad setLaneCount(String str) {
                    this.hasLaneCount = true;
                    this.laneCount_ = str;
                    return this;
                }

                public ViaMainRoad setMainRoadName(String str) {
                    this.hasMainRoadName = true;
                    this.mainRoadName_ = str;
                    return this;
                }

                public ViaMainRoad setMainRoadType(int i) {
                    this.hasMainRoadType = true;
                    this.mainRoadType_ = i;
                    return this;
                }

                public ViaMainRoad setSpeedLimit(String str) {
                    this.hasSpeedLimit = true;
                    this.speedLimit_ = str;
                    return this;
                }

                public ViaMainRoad setStart(Point point) {
                    if (point == null) {
                        return clearStart();
                    }
                    this.hasStart = true;
                    this.start_ = point;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasMainRoadName()) {
                        codedOutputStreamMicro.writeString(1, getMainRoadName());
                    }
                    if (hasMainRoadType()) {
                        codedOutputStreamMicro.writeInt32(2, getMainRoadType());
                    }
                    if (hasLaneCount()) {
                        codedOutputStreamMicro.writeString(3, getLaneCount());
                    }
                    if (hasSpeedLimit()) {
                        codedOutputStreamMicro.writeString(4, getSpeedLimit());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(5, getDistance());
                    }
                    if (hasLabelPoint()) {
                        codedOutputStreamMicro.writeMessage(6, getLabelPoint());
                    }
                    if (hasStart()) {
                        codedOutputStreamMicro.writeMessage(7, getStart());
                    }
                    if (hasEnd()) {
                        codedOutputStreamMicro.writeMessage(8, getEnd());
                    }
                }

                public static ViaMainRoad parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ViaMainRoad) new ViaMainRoad().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class ViaService extends MessageMicro {
                public static final int CAN_BE_VIA_NODE_FIELD_NUMBER = 5;
                public static final int DURATION_FIELD_NUMBER = 3;
                public static final int LABEL_POINT_FIELD_NUMBER = 4;
                public static final int SERVICE_DISTANCE_FROM_START_FIELD_NUMBER = 2;
                public static final int SERVICE_GAS_INFO_FIELD_NUMBER = 7;
                public static final int SERVICE_NAME_FIELD_NUMBER = 1;
                public static final int SERVICE_SUPPORT_FIELD_NUMBER = 6;
                private boolean hasCanBeViaNode;
                private boolean hasDuration;
                private boolean hasLabelPoint;
                private boolean hasServiceDistanceFromStart;
                private boolean hasServiceGasInfo;
                private boolean hasServiceName;
                private boolean hasServiceSupport;
                private String serviceName_ = "";
                private int serviceDistanceFromStart_ = 0;
                private int duration_ = 0;
                private Point labelPoint_ = null;
                private int canBeViaNode_ = 0;
                private int serviceSupport_ = 0;
                private ServiceGasInfo serviceGasInfo_ = null;
                private int cachedSize = -1;

                public static ViaService parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ViaService().mergeFrom(codedInputStreamMicro);
                }

                public final ViaService clear() {
                    clearServiceName();
                    clearServiceDistanceFromStart();
                    clearDuration();
                    clearLabelPoint();
                    clearCanBeViaNode();
                    clearServiceSupport();
                    clearServiceGasInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public ViaService clearCanBeViaNode() {
                    this.hasCanBeViaNode = false;
                    this.canBeViaNode_ = 0;
                    return this;
                }

                public ViaService clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public ViaService clearLabelPoint() {
                    this.hasLabelPoint = false;
                    this.labelPoint_ = null;
                    return this;
                }

                public ViaService clearServiceDistanceFromStart() {
                    this.hasServiceDistanceFromStart = false;
                    this.serviceDistanceFromStart_ = 0;
                    return this;
                }

                public ViaService clearServiceGasInfo() {
                    this.hasServiceGasInfo = false;
                    this.serviceGasInfo_ = null;
                    return this;
                }

                public ViaService clearServiceName() {
                    this.hasServiceName = false;
                    this.serviceName_ = "";
                    return this;
                }

                public ViaService clearServiceSupport() {
                    this.hasServiceSupport = false;
                    this.serviceSupport_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCanBeViaNode() {
                    return this.canBeViaNode_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public Point getLabelPoint() {
                    return this.labelPoint_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasServiceName() ? CodedOutputStreamMicro.computeStringSize(1, getServiceName()) : 0;
                    if (hasServiceDistanceFromStart()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getServiceDistanceFromStart());
                    }
                    if (hasDuration()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getCanBeViaNode());
                    }
                    if (hasServiceSupport()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getServiceSupport());
                    }
                    if (hasServiceGasInfo()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(7, getServiceGasInfo());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public int getServiceDistanceFromStart() {
                    return this.serviceDistanceFromStart_;
                }

                public ServiceGasInfo getServiceGasInfo() {
                    return this.serviceGasInfo_;
                }

                public String getServiceName() {
                    return this.serviceName_;
                }

                public int getServiceSupport() {
                    return this.serviceSupport_;
                }

                public boolean hasCanBeViaNode() {
                    return this.hasCanBeViaNode;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasLabelPoint() {
                    return this.hasLabelPoint;
                }

                public boolean hasServiceDistanceFromStart() {
                    return this.hasServiceDistanceFromStart;
                }

                public boolean hasServiceGasInfo() {
                    return this.hasServiceGasInfo;
                }

                public boolean hasServiceName() {
                    return this.hasServiceName;
                }

                public boolean hasServiceSupport() {
                    return this.hasServiceSupport;
                }

                public final boolean isInitialized() {
                    return this.hasServiceName && this.hasServiceDistanceFromStart && this.hasDuration && this.hasLabelPoint && this.hasCanBeViaNode && getLabelPoint().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ViaService mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setServiceName(codedInputStreamMicro.readString());
                        } else if (readTag == 16) {
                            setServiceDistanceFromStart(codedInputStreamMicro.readInt32());
                        } else if (readTag == 24) {
                            setDuration(codedInputStreamMicro.readInt32());
                        } else if (readTag == 34) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setLabelPoint(point);
                        } else if (readTag == 40) {
                            setCanBeViaNode(codedInputStreamMicro.readInt32());
                        } else if (readTag == 48) {
                            setServiceSupport(codedInputStreamMicro.readInt32());
                        } else if (readTag == 58) {
                            ServiceGasInfo serviceGasInfo = new ServiceGasInfo();
                            codedInputStreamMicro.readMessage(serviceGasInfo);
                            setServiceGasInfo(serviceGasInfo);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public ViaService setCanBeViaNode(int i) {
                    this.hasCanBeViaNode = true;
                    this.canBeViaNode_ = i;
                    return this;
                }

                public ViaService setDuration(int i) {
                    this.hasDuration = true;
                    this.duration_ = i;
                    return this;
                }

                public ViaService setLabelPoint(Point point) {
                    if (point == null) {
                        return clearLabelPoint();
                    }
                    this.hasLabelPoint = true;
                    this.labelPoint_ = point;
                    return this;
                }

                public ViaService setServiceDistanceFromStart(int i) {
                    this.hasServiceDistanceFromStart = true;
                    this.serviceDistanceFromStart_ = i;
                    return this;
                }

                public ViaService setServiceGasInfo(ServiceGasInfo serviceGasInfo) {
                    if (serviceGasInfo == null) {
                        return clearServiceGasInfo();
                    }
                    this.hasServiceGasInfo = true;
                    this.serviceGasInfo_ = serviceGasInfo;
                    return this;
                }

                public ViaService setServiceName(String str) {
                    this.hasServiceName = true;
                    this.serviceName_ = str;
                    return this;
                }

                public ViaService setServiceSupport(int i) {
                    this.hasServiceSupport = true;
                    this.serviceSupport_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasServiceName()) {
                        codedOutputStreamMicro.writeString(1, getServiceName());
                    }
                    if (hasServiceDistanceFromStart()) {
                        codedOutputStreamMicro.writeInt32(2, getServiceDistanceFromStart());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(3, getDuration());
                    }
                    if (hasLabelPoint()) {
                        codedOutputStreamMicro.writeMessage(4, getLabelPoint());
                    }
                    if (hasCanBeViaNode()) {
                        codedOutputStreamMicro.writeInt32(5, getCanBeViaNode());
                    }
                    if (hasServiceSupport()) {
                        codedOutputStreamMicro.writeInt32(6, getServiceSupport());
                    }
                    if (hasServiceGasInfo()) {
                        codedOutputStreamMicro.writeMessage(7, getServiceGasInfo());
                    }
                }

                public static ViaService parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ViaService) new ViaService().mergeFrom(bArr);
                }
            }

            public static LongDistanceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new LongDistanceInfo().mergeFrom(codedInputStreamMicro);
            }

            public LongDistanceInfo addViaCheckser(ViaCheckSer viaCheckSer) {
                if (viaCheckSer == null) {
                    return this;
                }
                if (this.viaCheckser_.isEmpty()) {
                    this.viaCheckser_ = new ArrayList();
                }
                this.viaCheckser_.add(viaCheckSer);
                return this;
            }

            public LongDistanceInfo addViaCityInfo(ViaCityInfo viaCityInfo) {
                if (viaCityInfo == null) {
                    return this;
                }
                if (this.viaCityInfo_.isEmpty()) {
                    this.viaCityInfo_ = new ArrayList();
                }
                this.viaCityInfo_.add(viaCityInfo);
                return this;
            }

            public LongDistanceInfo addViaMainRoad(ViaMainRoad viaMainRoad) {
                if (viaMainRoad == null) {
                    return this;
                }
                if (this.viaMainRoad_.isEmpty()) {
                    this.viaMainRoad_ = new ArrayList();
                }
                this.viaMainRoad_.add(viaMainRoad);
                return this;
            }

            public LongDistanceInfo addViaService(ViaService viaService) {
                if (viaService == null) {
                    return this;
                }
                if (this.viaService_.isEmpty()) {
                    this.viaService_ = new ArrayList();
                }
                this.viaService_.add(viaService);
                return this;
            }

            public final LongDistanceInfo clear() {
                clearViaCityInfo();
                clearViaMainRoad();
                clearViaService();
                clearViaCheckser();
                this.cachedSize = -1;
                return this;
            }

            public LongDistanceInfo clearViaCheckser() {
                this.viaCheckser_ = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaCityInfo() {
                this.viaCityInfo_ = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaMainRoad() {
                this.viaMainRoad_ = Collections.emptyList();
                return this;
            }

            public LongDistanceInfo clearViaService() {
                this.viaService_ = Collections.emptyList();
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
                Iterator<ViaCityInfo> it = getViaCityInfoList().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                }
                Iterator<ViaMainRoad> it2 = getViaMainRoadList().iterator();
                while (it2.hasNext()) {
                    i += CodedOutputStreamMicro.computeMessageSize(2, it2.next());
                }
                Iterator<ViaService> it3 = getViaServiceList().iterator();
                while (it3.hasNext()) {
                    i += CodedOutputStreamMicro.computeMessageSize(3, it3.next());
                }
                Iterator<ViaCheckSer> it4 = getViaCheckserList().iterator();
                while (it4.hasNext()) {
                    i += CodedOutputStreamMicro.computeMessageSize(4, it4.next());
                }
                this.cachedSize = i;
                return i;
            }

            public ViaCheckSer getViaCheckser(int i) {
                return this.viaCheckser_.get(i);
            }

            public int getViaCheckserCount() {
                return this.viaCheckser_.size();
            }

            public List<ViaCheckSer> getViaCheckserList() {
                return this.viaCheckser_;
            }

            public ViaCityInfo getViaCityInfo(int i) {
                return this.viaCityInfo_.get(i);
            }

            public int getViaCityInfoCount() {
                return this.viaCityInfo_.size();
            }

            public List<ViaCityInfo> getViaCityInfoList() {
                return this.viaCityInfo_;
            }

            public ViaMainRoad getViaMainRoad(int i) {
                return this.viaMainRoad_.get(i);
            }

            public int getViaMainRoadCount() {
                return this.viaMainRoad_.size();
            }

            public List<ViaMainRoad> getViaMainRoadList() {
                return this.viaMainRoad_;
            }

            public ViaService getViaService(int i) {
                return this.viaService_.get(i);
            }

            public int getViaServiceCount() {
                return this.viaService_.size();
            }

            public List<ViaService> getViaServiceList() {
                return this.viaService_;
            }

            public final boolean isInitialized() {
                Iterator<ViaCityInfo> it = getViaCityInfoList().iterator();
                while (it.hasNext()) {
                    if (!it.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<ViaMainRoad> it2 = getViaMainRoadList().iterator();
                while (it2.hasNext()) {
                    if (!it2.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<ViaService> it3 = getViaServiceList().iterator();
                while (it3.hasNext()) {
                    if (!it3.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<ViaCheckSer> it4 = getViaCheckserList().iterator();
                while (it4.hasNext()) {
                    if (!it4.next().isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public LongDistanceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        ViaCityInfo viaCityInfo = new ViaCityInfo();
                        codedInputStreamMicro.readMessage(viaCityInfo);
                        addViaCityInfo(viaCityInfo);
                    } else if (readTag == 18) {
                        ViaMainRoad viaMainRoad = new ViaMainRoad();
                        codedInputStreamMicro.readMessage(viaMainRoad);
                        addViaMainRoad(viaMainRoad);
                    } else if (readTag == 26) {
                        ViaService viaService = new ViaService();
                        codedInputStreamMicro.readMessage(viaService);
                        addViaService(viaService);
                    } else if (readTag == 34) {
                        ViaCheckSer viaCheckSer = new ViaCheckSer();
                        codedInputStreamMicro.readMessage(viaCheckSer);
                        addViaCheckser(viaCheckSer);
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public LongDistanceInfo setViaCheckser(int i, ViaCheckSer viaCheckSer) {
                if (viaCheckSer == null) {
                    return this;
                }
                this.viaCheckser_.set(i, viaCheckSer);
                return this;
            }

            public LongDistanceInfo setViaCityInfo(int i, ViaCityInfo viaCityInfo) {
                if (viaCityInfo == null) {
                    return this;
                }
                this.viaCityInfo_.set(i, viaCityInfo);
                return this;
            }

            public LongDistanceInfo setViaMainRoad(int i, ViaMainRoad viaMainRoad) {
                if (viaMainRoad == null) {
                    return this;
                }
                this.viaMainRoad_.set(i, viaMainRoad);
                return this;
            }

            public LongDistanceInfo setViaService(int i, ViaService viaService) {
                if (viaService == null) {
                    return this;
                }
                this.viaService_.set(i, viaService);
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<ViaCityInfo> it = getViaCityInfoList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(1, it.next());
                }
                Iterator<ViaMainRoad> it2 = getViaMainRoadList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeMessage(2, it2.next());
                }
                Iterator<ViaService> it3 = getViaServiceList().iterator();
                while (it3.hasNext()) {
                    codedOutputStreamMicro.writeMessage(3, it3.next());
                }
                Iterator<ViaCheckSer> it4 = getViaCheckserList().iterator();
                while (it4.hasNext()) {
                    codedOutputStreamMicro.writeMessage(4, it4.next());
                }
            }

            public static LongDistanceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (LongDistanceInfo) new LongDistanceInfo().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Point extends MessageMicro {
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private boolean hasX;
            private boolean hasY;
            private double x_ = OOXIXo.f3760XO;
            private double y_ = OOXIXo.f3760XO;
            private int cachedSize = -1;

            public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Point().mergeFrom(codedInputStreamMicro);
            }

            public final Point clear() {
                clearX();
                clearY();
                this.cachedSize = -1;
                return this;
            }

            public Point clearX() {
                this.hasX = false;
                this.x_ = OOXIXo.f3760XO;
                return this;
            }

            public Point clearY() {
                this.hasY = false;
                this.y_ = OOXIXo.f3760XO;
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
                int computeDoubleSize = hasX() ? CodedOutputStreamMicro.computeDoubleSize(1, getX()) : 0;
                if (hasY()) {
                    computeDoubleSize += CodedOutputStreamMicro.computeDoubleSize(2, getY());
                }
                this.cachedSize = computeDoubleSize;
                return computeDoubleSize;
            }

            public double getX() {
                return this.x_;
            }

            public double getY() {
                return this.y_;
            }

            public boolean hasX() {
                return this.hasX;
            }

            public boolean hasY() {
                return this.hasY;
            }

            public final boolean isInitialized() {
                return this.hasX && this.hasY;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Point mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 9) {
                        setX(codedInputStreamMicro.readDouble());
                    } else if (readTag == 17) {
                        setY(codedInputStreamMicro.readDouble());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public Point setX(double d) {
                this.hasX = true;
                this.x_ = d;
                return this;
            }

            public Point setY(double d) {
                this.hasY = true;
                this.y_ = d;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasX()) {
                    codedOutputStreamMicro.writeDouble(1, getX());
                }
                if (hasY()) {
                    codedOutputStreamMicro.writeDouble(2, getY());
                }
            }

            public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Point) new Point().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Routes extends MessageMicro {
            public static final int CAMERA_INFO_FIELD_NUMBER = 28;
            public static final int CARROUTEPLANPREFERAVOIDJAM = 16;
            public static final int CARROUTEPLANPREFERCARNUM = 32;
            public static final int CARROUTEPLANPREFERDEFAULT = 1;
            public static final int CARROUTEPLANPREFERHIGHWAY = 2;
            public static final int CARROUTEPLANPREFERINVALID = 0;
            public static final int CARROUTEPLANPREFERNOHIGHWAY = 4;
            public static final int CARROUTEPLANPREFERNOTOLL = 8;
            public static final int CAR_PREFER_ARRAY_FIELD_NUMBER = 12;
            public static final int CONGESTION_LENGTH_FIELD_NUMBER = 9;
            public static final int DESC_FIELD_NUMBER = 1;
            public static final int DESC_INFO_FIELD_NUMBER = 23;
            public static final int HIT_CAR_RULES_FIELD_NUMBER = 18;
            public static final int IS_COLLECTED_FIELD_NUMBER = 22;
            public static final int IS_RP_BYPART_FIELD_NUMBER = 20;
            public static final int LEGS_FIELD_NUMBER = 3;
            public static final int LIGHT_NUM_FIELD_NUMBER = 7;
            public static final int MAIN_ROADS_FIELD_NUMBER = 5;
            public static final int MRSL_FIELD_NUMBER = 2;
            public static final int NE_LIST_PAGE_PANEL_FIELD_NUMBER = 30;
            public static final int NE_PANEL_INFO_FIELD_NUMBER = 25;
            public static final int NE_ROUTE_LABEL_FIELD_NUMBER = 32;
            public static final int OIL_TOLL_FIELD_NUMBER = 24;
            public static final int ROUTE_DESC_FIELD_NUMBER = 16;
            public static final int ROUTE_EVENT_FIELD_NUMBER = 27;
            public static final int ROUTE_LABEL_DESC_FIELD_NUMBER = 31;
            public static final int ROUTE_LABEL_FIELD_NUMBER = 26;
            public static final int ROUTE_LABEL_NAME_FIELD_NUMBER = 13;
            public static final int ROUTE_LABEL_TIPS_FIELD_NUMBER = 14;
            public static final int ROUTE_MD5_FIELD_NUMBER = 17;
            public static final int ROUTE_UNIQ_ID_FIELD_NUMBER = 21;
            public static final int STREET_VIEW_FIELD_NUMBER = 29;
            public static final int TAB_FIELD_NUMBER = 10;
            public static final int TAX_PRICE_FIELD_NUMBER = 19;
            public static final int TOLL_FIELD_NUMBER = 6;
            public static final int TRAFFIC_CONDITION_FIELD_NUMBER = 4;
            public static final int TRANS_ROUTE_TAG_INFO_FIELD_NUMBER = 33;
            public static final int UGC_TIPS_FIELD_NUMBER = 15;
            public static final int WAITING_TIME_FIELD_NUMBER = 8;
            public static final int WHOLE_CONDITION_FIELD_NUMBER = 11;
            private boolean hasCarPreferArray;
            private boolean hasCongestionLength;
            private boolean hasDesc;
            private boolean hasDescInfo;
            private boolean hasIsCollected;
            private boolean hasIsRpBypart;
            private boolean hasLightNum;
            private boolean hasMainRoads;
            private boolean hasMrsl;
            private boolean hasNeRouteLabel;
            private boolean hasOilToll;
            private boolean hasRouteDesc;
            private boolean hasRouteLabel;
            private boolean hasRouteLabelDesc;
            private boolean hasRouteLabelName;
            private boolean hasRouteLabelTips;
            private boolean hasRouteMd5;
            private boolean hasRouteUniqId;
            private boolean hasStreetView;
            private boolean hasTab;
            private boolean hasTaxPrice;
            private boolean hasToll;
            private boolean hasTrafficCondition;
            private boolean hasUgcTips;
            private boolean hasWaitingTime;
            private boolean hasWholeCondition;
            private String desc_ = "";
            private String mrsl_ = "";
            private List<Legs> legs_ = Collections.emptyList();
            private int trafficCondition_ = 0;
            private String mainRoads_ = "";
            private int toll_ = 0;
            private int lightNum_ = 0;
            private String waitingTime_ = "";
            private int congestionLength_ = 0;
            private String tab_ = "";
            private WholeCondition wholeCondition_ = null;
            private CarPreferInfoArray carPreferArray_ = null;
            private String routeLabelName_ = "";
            private String routeLabelTips_ = "";
            private String ugcTips_ = "";
            private String routeDesc_ = "";
            private String routeMd5_ = "";
            private List<String> hitCarRules_ = Collections.emptyList();
            private String taxPrice_ = "";
            private int isRpBypart_ = 0;
            private String routeUniqId_ = "";
            private int isCollected_ = 0;
            private DescribeInfo descInfo_ = null;
            private int oilToll_ = 0;
            private List<NEPanelInfo> nePanelInfo_ = Collections.emptyList();
            private RouteLabelInfo routeLabel_ = null;
            private List<RouteEvent> routeEvent_ = Collections.emptyList();
            private List<CameraInfo> cameraInfo_ = Collections.emptyList();
            private DstStreetView streetView_ = null;
            private List<NEPanelInfo> neListPagePanel_ = Collections.emptyList();
            private String routeLabelDesc_ = "";
            private NETransRouteLabel neRouteLabel_ = null;
            private List<RouteLabelUnit> transRouteTagInfo_ = Collections.emptyList();
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class CameraInfo extends MessageMicro {
                public static final int DIST_FIELD_NUMBER = 2;
                public static final int ICON_ID_FIELD_NUMBER = 5;
                public static final int POS_FIELD_NUMBER = 3;
                public static final int PRIORITY_FIELD_NUMBER = 4;
                public static final int SPEED_LIMIT_FIELD_NUMBER = 6;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasDist;
                private boolean hasIconId;
                private boolean hasPos;
                private boolean hasPriority;
                private boolean hasSpeedLimit;
                private boolean hasType;
                private int type_ = 0;
                private int dist_ = 0;
                private Point pos_ = null;
                private int priority_ = 0;
                private int iconId_ = 0;
                private int speedLimit_ = 0;
                private int cachedSize = -1;

                public static CameraInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new CameraInfo().mergeFrom(codedInputStreamMicro);
                }

                public final CameraInfo clear() {
                    clearType();
                    clearDist();
                    clearPos();
                    clearPriority();
                    clearIconId();
                    clearSpeedLimit();
                    this.cachedSize = -1;
                    return this;
                }

                public CameraInfo clearDist() {
                    this.hasDist = false;
                    this.dist_ = 0;
                    return this;
                }

                public CameraInfo clearIconId() {
                    this.hasIconId = false;
                    this.iconId_ = 0;
                    return this;
                }

                public CameraInfo clearPos() {
                    this.hasPos = false;
                    this.pos_ = null;
                    return this;
                }

                public CameraInfo clearPriority() {
                    this.hasPriority = false;
                    this.priority_ = 0;
                    return this;
                }

                public CameraInfo clearSpeedLimit() {
                    this.hasSpeedLimit = false;
                    this.speedLimit_ = 0;
                    return this;
                }

                public CameraInfo clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDist() {
                    return this.dist_;
                }

                public int getIconId() {
                    return this.iconId_;
                }

                public Point getPos() {
                    return this.pos_;
                }

                public int getPriority() {
                    return this.priority_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
                    if (hasDist()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDist());
                    }
                    if (hasPos()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, getPos());
                    }
                    if (hasPriority()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getPriority());
                    }
                    if (hasIconId()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getIconId());
                    }
                    if (hasSpeedLimit()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getSpeedLimit());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public int getSpeedLimit() {
                    return this.speedLimit_;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasDist() {
                    return this.hasDist;
                }

                public boolean hasIconId() {
                    return this.hasIconId;
                }

                public boolean hasPos() {
                    return this.hasPos;
                }

                public boolean hasPriority() {
                    return this.hasPriority;
                }

                public boolean hasSpeedLimit() {
                    return this.hasSpeedLimit;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return !hasPos() || getPos().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public CameraInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setType(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setDist(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setPos(point);
                        } else if (readTag == 32) {
                            setPriority(codedInputStreamMicro.readInt32());
                        } else if (readTag == 40) {
                            setIconId(codedInputStreamMicro.readInt32());
                        } else if (readTag == 48) {
                            setSpeedLimit(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public CameraInfo setDist(int i) {
                    this.hasDist = true;
                    this.dist_ = i;
                    return this;
                }

                public CameraInfo setIconId(int i) {
                    this.hasIconId = true;
                    this.iconId_ = i;
                    return this;
                }

                public CameraInfo setPos(Point point) {
                    if (point == null) {
                        return clearPos();
                    }
                    this.hasPos = true;
                    this.pos_ = point;
                    return this;
                }

                public CameraInfo setPriority(int i) {
                    this.hasPriority = true;
                    this.priority_ = i;
                    return this;
                }

                public CameraInfo setSpeedLimit(int i) {
                    this.hasSpeedLimit = true;
                    this.speedLimit_ = i;
                    return this;
                }

                public CameraInfo setType(int i) {
                    this.hasType = true;
                    this.type_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (hasDist()) {
                        codedOutputStreamMicro.writeInt32(2, getDist());
                    }
                    if (hasPos()) {
                        codedOutputStreamMicro.writeMessage(3, getPos());
                    }
                    if (hasPriority()) {
                        codedOutputStreamMicro.writeInt32(4, getPriority());
                    }
                    if (hasIconId()) {
                        codedOutputStreamMicro.writeInt32(5, getIconId());
                    }
                    if (hasSpeedLimit()) {
                        codedOutputStreamMicro.writeInt32(6, getSpeedLimit());
                    }
                }

                public static CameraInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (CameraInfo) new CameraInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class CarPreferInfo extends MessageMicro {
                public static final int CAR_PREFER_TAB_FIELD_NUMBER = 2;
                public static final int CAR_PREFER_VAL_FIELD_NUMBER = 1;
                private boolean hasCarPreferTab;
                private boolean hasCarPreferVal;
                private int carPreferVal_ = 0;
                private ByteStringMicro carPreferTab_ = ByteStringMicro.EMPTY;
                private int cachedSize = -1;

                public static CarPreferInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new CarPreferInfo().mergeFrom(codedInputStreamMicro);
                }

                public final CarPreferInfo clear() {
                    clearCarPreferVal();
                    clearCarPreferTab();
                    this.cachedSize = -1;
                    return this;
                }

                public CarPreferInfo clearCarPreferTab() {
                    this.hasCarPreferTab = false;
                    this.carPreferTab_ = ByteStringMicro.EMPTY;
                    return this;
                }

                public CarPreferInfo clearCarPreferVal() {
                    this.hasCarPreferVal = false;
                    this.carPreferVal_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public ByteStringMicro getCarPreferTab() {
                    return this.carPreferTab_;
                }

                public int getCarPreferVal() {
                    return this.carPreferVal_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasCarPreferVal() ? CodedOutputStreamMicro.computeInt32Size(1, getCarPreferVal()) : 0;
                    if (hasCarPreferTab()) {
                        computeInt32Size += CodedOutputStreamMicro.computeBytesSize(2, getCarPreferTab());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasCarPreferTab() {
                    return this.hasCarPreferTab;
                }

                public boolean hasCarPreferVal() {
                    return this.hasCarPreferVal;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public CarPreferInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setCarPreferVal(codedInputStreamMicro.readInt32());
                        } else if (readTag == 18) {
                            setCarPreferTab(codedInputStreamMicro.readBytes());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public CarPreferInfo setCarPreferTab(ByteStringMicro byteStringMicro) {
                    this.hasCarPreferTab = true;
                    this.carPreferTab_ = byteStringMicro;
                    return this;
                }

                public CarPreferInfo setCarPreferVal(int i) {
                    this.hasCarPreferVal = true;
                    this.carPreferVal_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCarPreferVal()) {
                        codedOutputStreamMicro.writeInt32(1, getCarPreferVal());
                    }
                    if (hasCarPreferTab()) {
                        codedOutputStreamMicro.writeBytes(2, getCarPreferTab());
                    }
                }

                public static CarPreferInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (CarPreferInfo) new CarPreferInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class CarPreferInfoArray extends MessageMicro {
                public static final int CAR_CITY_CODE_FIELD_NUMBER = 2;
                public static final int CAR_INFO_ARRAY_FIELD_NUMBER = 1;
                public static final int LOCAL_ENABLE_TIPS_FIELD_NUMBER = 3;
                private boolean hasCarCityCode;
                private boolean hasLocalEnableTips;
                private List<CarPreferInfo> carInfoArray_ = Collections.emptyList();
                private int carCityCode_ = -1;
                private ByteStringMicro localEnableTips_ = ByteStringMicro.EMPTY;
                private int cachedSize = -1;

                public static CarPreferInfoArray parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new CarPreferInfoArray().mergeFrom(codedInputStreamMicro);
                }

                public CarPreferInfoArray addCarInfoArray(CarPreferInfo carPreferInfo) {
                    if (carPreferInfo == null) {
                        return this;
                    }
                    if (this.carInfoArray_.isEmpty()) {
                        this.carInfoArray_ = new ArrayList();
                    }
                    this.carInfoArray_.add(carPreferInfo);
                    return this;
                }

                public final CarPreferInfoArray clear() {
                    clearCarInfoArray();
                    clearCarCityCode();
                    clearLocalEnableTips();
                    this.cachedSize = -1;
                    return this;
                }

                public CarPreferInfoArray clearCarCityCode() {
                    this.hasCarCityCode = false;
                    this.carCityCode_ = -1;
                    return this;
                }

                public CarPreferInfoArray clearCarInfoArray() {
                    this.carInfoArray_ = Collections.emptyList();
                    return this;
                }

                public CarPreferInfoArray clearLocalEnableTips() {
                    this.hasLocalEnableTips = false;
                    this.localEnableTips_ = ByteStringMicro.EMPTY;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCarCityCode() {
                    return this.carCityCode_;
                }

                public CarPreferInfo getCarInfoArray(int i) {
                    return this.carInfoArray_.get(i);
                }

                public int getCarInfoArrayCount() {
                    return this.carInfoArray_.size();
                }

                public List<CarPreferInfo> getCarInfoArrayList() {
                    return this.carInfoArray_;
                }

                public ByteStringMicro getLocalEnableTips() {
                    return this.localEnableTips_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    Iterator<CarPreferInfo> it = getCarInfoArrayList().iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                    }
                    if (hasCarCityCode()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getCarCityCode());
                    }
                    if (hasLocalEnableTips()) {
                        i += CodedOutputStreamMicro.computeBytesSize(3, getLocalEnableTips());
                    }
                    this.cachedSize = i;
                    return i;
                }

                public boolean hasCarCityCode() {
                    return this.hasCarCityCode;
                }

                public boolean hasLocalEnableTips() {
                    return this.hasLocalEnableTips;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public CarPreferInfoArray mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            CarPreferInfo carPreferInfo = new CarPreferInfo();
                            codedInputStreamMicro.readMessage(carPreferInfo);
                            addCarInfoArray(carPreferInfo);
                        } else if (readTag == 16) {
                            setCarCityCode(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            setLocalEnableTips(codedInputStreamMicro.readBytes());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public CarPreferInfoArray setCarCityCode(int i) {
                    this.hasCarCityCode = true;
                    this.carCityCode_ = i;
                    return this;
                }

                public CarPreferInfoArray setCarInfoArray(int i, CarPreferInfo carPreferInfo) {
                    if (carPreferInfo == null) {
                        return this;
                    }
                    this.carInfoArray_.set(i, carPreferInfo);
                    return this;
                }

                public CarPreferInfoArray setLocalEnableTips(ByteStringMicro byteStringMicro) {
                    this.hasLocalEnableTips = true;
                    this.localEnableTips_ = byteStringMicro;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    Iterator<CarPreferInfo> it = getCarInfoArrayList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeMessage(1, it.next());
                    }
                    if (hasCarCityCode()) {
                        codedOutputStreamMicro.writeInt32(2, getCarCityCode());
                    }
                    if (hasLocalEnableTips()) {
                        codedOutputStreamMicro.writeBytes(3, getLocalEnableTips());
                    }
                }

                public static CarPreferInfoArray parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (CarPreferInfoArray) new CarPreferInfoArray().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class DescribeInfo extends MessageMicro {
                public static final int ATTR_STR_FIELD_NUMBER = 2;
                public static final int LABEL_TYPE_FIELD_NUMBER = 1;
                public static final int POS_FIELD_NUMBER = 5;
                public static final int RC_STR_FIELD_NUMBER = 4;
                public static final int ROAD_STR_FIELD_NUMBER = 3;
                private boolean hasAttrStr;
                private boolean hasLabelType;
                private boolean hasPos;
                private boolean hasRcStr;
                private boolean hasRoadStr;
                private int labelType_ = 0;
                private String attrStr_ = "";
                private String roadStr_ = "";
                private String rcStr_ = "";
                private Point pos_ = null;
                private int cachedSize = -1;

                public static DescribeInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new DescribeInfo().mergeFrom(codedInputStreamMicro);
                }

                public final DescribeInfo clear() {
                    clearLabelType();
                    clearAttrStr();
                    clearRoadStr();
                    clearRcStr();
                    clearPos();
                    this.cachedSize = -1;
                    return this;
                }

                public DescribeInfo clearAttrStr() {
                    this.hasAttrStr = false;
                    this.attrStr_ = "";
                    return this;
                }

                public DescribeInfo clearLabelType() {
                    this.hasLabelType = false;
                    this.labelType_ = 0;
                    return this;
                }

                public DescribeInfo clearPos() {
                    this.hasPos = false;
                    this.pos_ = null;
                    return this;
                }

                public DescribeInfo clearRcStr() {
                    this.hasRcStr = false;
                    this.rcStr_ = "";
                    return this;
                }

                public DescribeInfo clearRoadStr() {
                    this.hasRoadStr = false;
                    this.roadStr_ = "";
                    return this;
                }

                public String getAttrStr() {
                    return this.attrStr_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getLabelType() {
                    return this.labelType_;
                }

                public Point getPos() {
                    return this.pos_;
                }

                public String getRcStr() {
                    return this.rcStr_;
                }

                public String getRoadStr() {
                    return this.roadStr_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasLabelType() ? CodedOutputStreamMicro.computeInt32Size(1, getLabelType()) : 0;
                    if (hasAttrStr()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getAttrStr());
                    }
                    if (hasRoadStr()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getRoadStr());
                    }
                    if (hasRcStr()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getRcStr());
                    }
                    if (hasPos()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, getPos());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasAttrStr() {
                    return this.hasAttrStr;
                }

                public boolean hasLabelType() {
                    return this.hasLabelType;
                }

                public boolean hasPos() {
                    return this.hasPos;
                }

                public boolean hasRcStr() {
                    return this.hasRcStr;
                }

                public boolean hasRoadStr() {
                    return this.hasRoadStr;
                }

                public final boolean isInitialized() {
                    return !hasPos() || getPos().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public DescribeInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setLabelType(codedInputStreamMicro.readInt32());
                        } else if (readTag == 18) {
                            setAttrStr(codedInputStreamMicro.readString());
                        } else if (readTag == 26) {
                            setRoadStr(codedInputStreamMicro.readString());
                        } else if (readTag == 34) {
                            setRcStr(codedInputStreamMicro.readString());
                        } else if (readTag == 42) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setPos(point);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public DescribeInfo setAttrStr(String str) {
                    this.hasAttrStr = true;
                    this.attrStr_ = str;
                    return this;
                }

                public DescribeInfo setLabelType(int i) {
                    this.hasLabelType = true;
                    this.labelType_ = i;
                    return this;
                }

                public DescribeInfo setPos(Point point) {
                    if (point == null) {
                        return clearPos();
                    }
                    this.hasPos = true;
                    this.pos_ = point;
                    return this;
                }

                public DescribeInfo setRcStr(String str) {
                    this.hasRcStr = true;
                    this.rcStr_ = str;
                    return this;
                }

                public DescribeInfo setRoadStr(String str) {
                    this.hasRoadStr = true;
                    this.roadStr_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasLabelType()) {
                        codedOutputStreamMicro.writeInt32(1, getLabelType());
                    }
                    if (hasAttrStr()) {
                        codedOutputStreamMicro.writeString(2, getAttrStr());
                    }
                    if (hasRoadStr()) {
                        codedOutputStreamMicro.writeString(3, getRoadStr());
                    }
                    if (hasRcStr()) {
                        codedOutputStreamMicro.writeString(4, getRcStr());
                    }
                    if (hasPos()) {
                        codedOutputStreamMicro.writeMessage(5, getPos());
                    }
                }

                public static DescribeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (DescribeInfo) new DescribeInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class DstStreetView extends MessageMicro {
                public static final int IMAGE_TYPE_FIELD_NUMBER = 4;
                public static final int IMAGE_URL_FIELD_NUMBER = 3;
                public static final int POINT_FIELD_NUMBER = 2;
                public static final int STREET_VIEW_URL_FIELD_NUMBER = 1;
                private boolean hasImageType;
                private boolean hasImageUrl;
                private boolean hasPoint;
                private boolean hasStreetViewUrl;
                private String streetViewUrl_ = "";
                private Point point_ = null;
                private String imageUrl_ = "";
                private int imageType_ = 0;
                private int cachedSize = -1;

                public static DstStreetView parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new DstStreetView().mergeFrom(codedInputStreamMicro);
                }

                public final DstStreetView clear() {
                    clearStreetViewUrl();
                    clearPoint();
                    clearImageUrl();
                    clearImageType();
                    this.cachedSize = -1;
                    return this;
                }

                public DstStreetView clearImageType() {
                    this.hasImageType = false;
                    this.imageType_ = 0;
                    return this;
                }

                public DstStreetView clearImageUrl() {
                    this.hasImageUrl = false;
                    this.imageUrl_ = "";
                    return this;
                }

                public DstStreetView clearPoint() {
                    this.hasPoint = false;
                    this.point_ = null;
                    return this;
                }

                public DstStreetView clearStreetViewUrl() {
                    this.hasStreetViewUrl = false;
                    this.streetViewUrl_ = "";
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getImageType() {
                    return this.imageType_;
                }

                public String getImageUrl() {
                    return this.imageUrl_;
                }

                public Point getPoint() {
                    return this.point_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasStreetViewUrl() ? CodedOutputStreamMicro.computeStringSize(1, getStreetViewUrl()) : 0;
                    if (hasPoint()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, getPoint());
                    }
                    if (hasImageUrl()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getImageUrl());
                    }
                    if (hasImageType()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getImageType());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public String getStreetViewUrl() {
                    return this.streetViewUrl_;
                }

                public boolean hasImageType() {
                    return this.hasImageType;
                }

                public boolean hasImageUrl() {
                    return this.hasImageUrl;
                }

                public boolean hasPoint() {
                    return this.hasPoint;
                }

                public boolean hasStreetViewUrl() {
                    return this.hasStreetViewUrl;
                }

                public final boolean isInitialized() {
                    return !hasPoint() || getPoint().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public DstStreetView mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setStreetViewUrl(codedInputStreamMicro.readString());
                        } else if (readTag == 18) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setPoint(point);
                        } else if (readTag == 26) {
                            setImageUrl(codedInputStreamMicro.readString());
                        } else if (readTag == 32) {
                            setImageType(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public DstStreetView setImageType(int i) {
                    this.hasImageType = true;
                    this.imageType_ = i;
                    return this;
                }

                public DstStreetView setImageUrl(String str) {
                    this.hasImageUrl = true;
                    this.imageUrl_ = str;
                    return this;
                }

                public DstStreetView setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.hasPoint = true;
                    this.point_ = point;
                    return this;
                }

                public DstStreetView setStreetViewUrl(String str) {
                    this.hasStreetViewUrl = true;
                    this.streetViewUrl_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasStreetViewUrl()) {
                        codedOutputStreamMicro.writeString(1, getStreetViewUrl());
                    }
                    if (hasPoint()) {
                        codedOutputStreamMicro.writeMessage(2, getPoint());
                    }
                    if (hasImageUrl()) {
                        codedOutputStreamMicro.writeString(3, getImageUrl());
                    }
                    if (hasImageType()) {
                        codedOutputStreamMicro.writeInt32(4, getImageType());
                    }
                }

                public static DstStreetView parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (DstStreetView) new DstStreetView().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class Legs extends MessageMicro {
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int DURATION_INFO_FIELD_NUMBER = 5;
                public static final int DURATION_WHOLEDAY_FIELD_NUMBER = 6;
                public static final int MRSL_FIELD_NUMBER = 4;
                public static final int STEPIS_FIELD_NUMBER = 3;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasDurationInfo;
                private boolean hasDurationWholeday;
                private boolean hasMrsl;
                private int distance_ = 0;
                private int duration_ = 0;
                private List<Stepis> stepis_ = Collections.emptyList();
                private String mrsl_ = "";
                private DurationInfo durationInfo_ = null;
                private DurationWholeday durationWholeday_ = null;
                private int cachedSize = -1;

                /* loaded from: classes7.dex */
                public static final class DurationInfo extends MessageMicro {
                    public static final int INFOS_FIELD_NUMBER = 3;
                    public static final int INTERVAL_FIELD_NUMBER = 1;
                    public static final int TIMESTAMP_FIELD_NUMBER = 2;
                    private boolean hasInterval;
                    private boolean hasTimestamp;
                    private List<Infos> infos_ = Collections.emptyList();
                    private int interval_ = 0;
                    private String timestamp_ = "";
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class Infos extends MessageMicro {
                        public static final int DURATION_FIELD_NUMBER = 2;
                        public static final int INDEX_FIELD_NUMBER = 1;
                        private boolean hasDuration;
                        private boolean hasIndex;
                        private int index_ = 0;
                        private int duration_ = 0;
                        private int cachedSize = -1;

                        public static Infos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Infos().mergeFrom(codedInputStreamMicro);
                        }

                        public final Infos clear() {
                            clearIndex();
                            clearDuration();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Infos clearDuration() {
                            this.hasDuration = false;
                            this.duration_ = 0;
                            return this;
                        }

                        public Infos clearIndex() {
                            this.hasIndex = false;
                            this.index_ = 0;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDuration() {
                            return this.duration_;
                        }

                        public int getIndex() {
                            return this.index_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeInt32Size = hasIndex() ? CodedOutputStreamMicro.computeInt32Size(1, getIndex()) : 0;
                            if (hasDuration()) {
                                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                            }
                            this.cachedSize = computeInt32Size;
                            return computeInt32Size;
                        }

                        public boolean hasDuration() {
                            return this.hasDuration;
                        }

                        public boolean hasIndex() {
                            return this.hasIndex;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Infos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 8) {
                                    setIndex(codedInputStreamMicro.readInt32());
                                } else if (readTag == 16) {
                                    setDuration(codedInputStreamMicro.readInt32());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Infos setDuration(int i) {
                            this.hasDuration = true;
                            this.duration_ = i;
                            return this;
                        }

                        public Infos setIndex(int i) {
                            this.hasIndex = true;
                            this.index_ = i;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasIndex()) {
                                codedOutputStreamMicro.writeInt32(1, getIndex());
                            }
                            if (hasDuration()) {
                                codedOutputStreamMicro.writeInt32(2, getDuration());
                            }
                        }

                        public static Infos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Infos) new Infos().mergeFrom(bArr);
                        }
                    }

                    public static DurationInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DurationInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public DurationInfo addInfos(Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        if (this.infos_.isEmpty()) {
                            this.infos_ = new ArrayList();
                        }
                        this.infos_.add(infos);
                        return this;
                    }

                    public final DurationInfo clear() {
                        clearInfos();
                        clearInterval();
                        clearTimestamp();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DurationInfo clearInfos() {
                        this.infos_ = Collections.emptyList();
                        return this;
                    }

                    public DurationInfo clearInterval() {
                        this.hasInterval = false;
                        this.interval_ = 0;
                        return this;
                    }

                    public DurationInfo clearTimestamp() {
                        this.hasTimestamp = false;
                        this.timestamp_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Infos getInfos(int i) {
                        return this.infos_.get(i);
                    }

                    public int getInfosCount() {
                        return this.infos_.size();
                    }

                    public List<Infos> getInfosList() {
                        return this.infos_;
                    }

                    public int getInterval() {
                        return this.interval_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasInterval() ? CodedOutputStreamMicro.computeInt32Size(1, getInterval()) : 0;
                        if (hasTimestamp()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, it.next());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public String getTimestamp() {
                        return this.timestamp_;
                    }

                    public boolean hasInterval() {
                        return this.hasInterval;
                    }

                    public boolean hasTimestamp() {
                        return this.hasTimestamp;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public DurationInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setInterval(codedInputStreamMicro.readInt32());
                            } else if (readTag == 18) {
                                setTimestamp(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                Infos infos = new Infos();
                                codedInputStreamMicro.readMessage(infos);
                                addInfos(infos);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public DurationInfo setInfos(int i, Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        this.infos_.set(i, infos);
                        return this;
                    }

                    public DurationInfo setInterval(int i) {
                        this.hasInterval = true;
                        this.interval_ = i;
                        return this;
                    }

                    public DurationInfo setTimestamp(String str) {
                        this.hasTimestamp = true;
                        this.timestamp_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasInterval()) {
                            codedOutputStreamMicro.writeInt32(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            codedOutputStreamMicro.writeString(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeMessage(3, it.next());
                        }
                    }

                    public static DurationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DurationInfo) new DurationInfo().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class DurationWholeday extends MessageMicro {
                    public static final int INFOS_FIELD_NUMBER = 3;
                    public static final int INTERVAL_FIELD_NUMBER = 1;
                    public static final int TIMESTAMP_FIELD_NUMBER = 2;
                    private boolean hasInterval;
                    private boolean hasTimestamp;
                    private List<Infos> infos_ = Collections.emptyList();
                    private int interval_ = 0;
                    private String timestamp_ = "";
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class Infos extends MessageMicro {
                        public static final int DURATION_FIELD_NUMBER = 2;
                        public static final int INDEX_FIELD_NUMBER = 1;
                        private boolean hasDuration;
                        private boolean hasIndex;
                        private int index_ = 0;
                        private int duration_ = 0;
                        private int cachedSize = -1;

                        public static Infos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Infos().mergeFrom(codedInputStreamMicro);
                        }

                        public final Infos clear() {
                            clearIndex();
                            clearDuration();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Infos clearDuration() {
                            this.hasDuration = false;
                            this.duration_ = 0;
                            return this;
                        }

                        public Infos clearIndex() {
                            this.hasIndex = false;
                            this.index_ = 0;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDuration() {
                            return this.duration_;
                        }

                        public int getIndex() {
                            return this.index_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeInt32Size = hasIndex() ? CodedOutputStreamMicro.computeInt32Size(1, getIndex()) : 0;
                            if (hasDuration()) {
                                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                            }
                            this.cachedSize = computeInt32Size;
                            return computeInt32Size;
                        }

                        public boolean hasDuration() {
                            return this.hasDuration;
                        }

                        public boolean hasIndex() {
                            return this.hasIndex;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Infos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 8) {
                                    setIndex(codedInputStreamMicro.readInt32());
                                } else if (readTag == 16) {
                                    setDuration(codedInputStreamMicro.readInt32());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Infos setDuration(int i) {
                            this.hasDuration = true;
                            this.duration_ = i;
                            return this;
                        }

                        public Infos setIndex(int i) {
                            this.hasIndex = true;
                            this.index_ = i;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasIndex()) {
                                codedOutputStreamMicro.writeInt32(1, getIndex());
                            }
                            if (hasDuration()) {
                                codedOutputStreamMicro.writeInt32(2, getDuration());
                            }
                        }

                        public static Infos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Infos) new Infos().mergeFrom(bArr);
                        }
                    }

                    public static DurationWholeday parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DurationWholeday().mergeFrom(codedInputStreamMicro);
                    }

                    public DurationWholeday addInfos(Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        if (this.infos_.isEmpty()) {
                            this.infos_ = new ArrayList();
                        }
                        this.infos_.add(infos);
                        return this;
                    }

                    public final DurationWholeday clear() {
                        clearInfos();
                        clearInterval();
                        clearTimestamp();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DurationWholeday clearInfos() {
                        this.infos_ = Collections.emptyList();
                        return this;
                    }

                    public DurationWholeday clearInterval() {
                        this.hasInterval = false;
                        this.interval_ = 0;
                        return this;
                    }

                    public DurationWholeday clearTimestamp() {
                        this.hasTimestamp = false;
                        this.timestamp_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Infos getInfos(int i) {
                        return this.infos_.get(i);
                    }

                    public int getInfosCount() {
                        return this.infos_.size();
                    }

                    public List<Infos> getInfosList() {
                        return this.infos_;
                    }

                    public int getInterval() {
                        return this.interval_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasInterval() ? CodedOutputStreamMicro.computeInt32Size(1, getInterval()) : 0;
                        if (hasTimestamp()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, it.next());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public String getTimestamp() {
                        return this.timestamp_;
                    }

                    public boolean hasInterval() {
                        return this.hasInterval;
                    }

                    public boolean hasTimestamp() {
                        return this.hasTimestamp;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public DurationWholeday mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setInterval(codedInputStreamMicro.readInt32());
                            } else if (readTag == 18) {
                                setTimestamp(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                Infos infos = new Infos();
                                codedInputStreamMicro.readMessage(infos);
                                addInfos(infos);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public DurationWholeday setInfos(int i, Infos infos) {
                        if (infos == null) {
                            return this;
                        }
                        this.infos_.set(i, infos);
                        return this;
                    }

                    public DurationWholeday setInterval(int i) {
                        this.hasInterval = true;
                        this.interval_ = i;
                        return this;
                    }

                    public DurationWholeday setTimestamp(String str) {
                        this.hasTimestamp = true;
                        this.timestamp_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasInterval()) {
                            codedOutputStreamMicro.writeInt32(1, getInterval());
                        }
                        if (hasTimestamp()) {
                            codedOutputStreamMicro.writeString(2, getTimestamp());
                        }
                        Iterator<Infos> it = getInfosList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeMessage(3, it.next());
                        }
                    }

                    public static DurationWholeday parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DurationWholeday) new DurationWholeday().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Stepis extends MessageMicro {
                    public static final int N_FIELD_NUMBER = 1;
                    public static final int S_FIELD_NUMBER = 2;
                    private boolean hasN;
                    private boolean hasS;
                    private int n_ = 0;
                    private int s_ = 0;
                    private int cachedSize = -1;

                    public static Stepis parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Stepis().mergeFrom(codedInputStreamMicro);
                    }

                    public final Stepis clear() {
                        clearN();
                        clearS();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Stepis clearN() {
                        this.hasN = false;
                        this.n_ = 0;
                        return this;
                    }

                    public Stepis clearS() {
                        this.hasS = false;
                        this.s_ = 0;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getN() {
                        return this.n_;
                    }

                    public int getS() {
                        return this.s_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasN() ? CodedOutputStreamMicro.computeInt32Size(1, getN()) : 0;
                        if (hasS()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getS());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public boolean hasN() {
                        return this.hasN;
                    }

                    public boolean hasS() {
                        return this.hasS;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Stepis mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setN(codedInputStreamMicro.readInt32());
                            } else if (readTag == 16) {
                                setS(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Stepis setN(int i) {
                        this.hasN = true;
                        this.n_ = i;
                        return this;
                    }

                    public Stepis setS(int i) {
                        this.hasS = true;
                        this.s_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasN()) {
                            codedOutputStreamMicro.writeInt32(1, getN());
                        }
                        if (hasS()) {
                            codedOutputStreamMicro.writeInt32(2, getS());
                        }
                    }

                    public static Stepis parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Stepis) new Stepis().mergeFrom(bArr);
                    }
                }

                public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Legs().mergeFrom(codedInputStreamMicro);
                }

                public Legs addStepis(Stepis stepis) {
                    if (stepis == null) {
                        return this;
                    }
                    if (this.stepis_.isEmpty()) {
                        this.stepis_ = new ArrayList();
                    }
                    this.stepis_.add(stepis);
                    return this;
                }

                public final Legs clear() {
                    clearDistance();
                    clearDuration();
                    clearStepis();
                    clearMrsl();
                    clearDurationInfo();
                    clearDurationWholeday();
                    this.cachedSize = -1;
                    return this;
                }

                public Legs clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public Legs clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public Legs clearDurationInfo() {
                    this.hasDurationInfo = false;
                    this.durationInfo_ = null;
                    return this;
                }

                public Legs clearDurationWholeday() {
                    this.hasDurationWholeday = false;
                    this.durationWholeday_ = null;
                    return this;
                }

                public Legs clearMrsl() {
                    this.hasMrsl = false;
                    this.mrsl_ = "";
                    return this;
                }

                public Legs clearStepis() {
                    this.stepis_ = Collections.emptyList();
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDistance() {
                    return this.distance_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public DurationInfo getDurationInfo() {
                    return this.durationInfo_;
                }

                public DurationWholeday getDurationWholeday() {
                    return this.durationWholeday_;
                }

                public String getMrsl() {
                    return this.mrsl_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasDistance() ? CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
                    if (hasDuration()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                    }
                    Iterator<Stepis> it = getStepisList().iterator();
                    while (it.hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, it.next());
                    }
                    if (hasMrsl()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getMrsl());
                    }
                    if (hasDurationInfo()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, getDurationInfo());
                    }
                    if (hasDurationWholeday()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(6, getDurationWholeday());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public Stepis getStepis(int i) {
                    return this.stepis_.get(i);
                }

                public int getStepisCount() {
                    return this.stepis_.size();
                }

                public List<Stepis> getStepisList() {
                    return this.stepis_;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasDurationInfo() {
                    return this.hasDurationInfo;
                }

                public boolean hasDurationWholeday() {
                    return this.hasDurationWholeday;
                }

                public boolean hasMrsl() {
                    return this.hasMrsl;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setDistance(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setDuration(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            Stepis stepis = new Stepis();
                            codedInputStreamMicro.readMessage(stepis);
                            addStepis(stepis);
                        } else if (readTag == 34) {
                            setMrsl(codedInputStreamMicro.readString());
                        } else if (readTag == 42) {
                            DurationInfo durationInfo = new DurationInfo();
                            codedInputStreamMicro.readMessage(durationInfo);
                            setDurationInfo(durationInfo);
                        } else if (readTag == 50) {
                            DurationWholeday durationWholeday = new DurationWholeday();
                            codedInputStreamMicro.readMessage(durationWholeday);
                            setDurationWholeday(durationWholeday);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public Legs setDistance(int i) {
                    this.hasDistance = true;
                    this.distance_ = i;
                    return this;
                }

                public Legs setDuration(int i) {
                    this.hasDuration = true;
                    this.duration_ = i;
                    return this;
                }

                public Legs setDurationInfo(DurationInfo durationInfo) {
                    if (durationInfo == null) {
                        return clearDurationInfo();
                    }
                    this.hasDurationInfo = true;
                    this.durationInfo_ = durationInfo;
                    return this;
                }

                public Legs setDurationWholeday(DurationWholeday durationWholeday) {
                    if (durationWholeday == null) {
                        return clearDurationWholeday();
                    }
                    this.hasDurationWholeday = true;
                    this.durationWholeday_ = durationWholeday;
                    return this;
                }

                public Legs setMrsl(String str) {
                    this.hasMrsl = true;
                    this.mrsl_ = str;
                    return this;
                }

                public Legs setStepis(int i, Stepis stepis) {
                    if (stepis == null) {
                        return this;
                    }
                    this.stepis_.set(i, stepis);
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(1, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(2, getDuration());
                    }
                    Iterator<Stepis> it = getStepisList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeMessage(3, it.next());
                    }
                    if (hasMrsl()) {
                        codedOutputStreamMicro.writeString(4, getMrsl());
                    }
                    if (hasDurationInfo()) {
                        codedOutputStreamMicro.writeMessage(5, getDurationInfo());
                    }
                    if (hasDurationWholeday()) {
                        codedOutputStreamMicro.writeMessage(6, getDurationWholeday());
                    }
                }

                public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Legs) new Legs().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class NEPanelInfo extends MessageMicro {
                public static final int ICON_TYPE_FIELD_NUMBER = 7;
                public static final int NE_COPYWRITING_FIELD_NUMBER = 1;
                public static final int NE_JUMP_PAGE_INDEX_FIELD_NUMBER = 2;
                public static final int NE_JUMP_PAGE_URL_FIELD_NUMBER = 3;
                public static final int PATTERN_ID_FIELD_NUMBER = 5;
                public static final int SUB_CW_FIELD_NUMBER = 4;
                public static final int TAG_FIELD_NUMBER = 6;
                private boolean hasIconType;
                private boolean hasNeCopywriting;
                private boolean hasNeJumpPageIndex;
                private boolean hasNeJumpPageUrl;
                private boolean hasPatternId;
                private boolean hasSubCw;
                private boolean hasTag;
                private String neCopywriting_ = "";
                private int neJumpPageIndex_ = 0;
                private String neJumpPageUrl_ = "";
                private String subCw_ = "";
                private int patternId_ = 0;
                private int tag_ = 0;
                private int iconType_ = 0;
                private int cachedSize = -1;

                public static NEPanelInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new NEPanelInfo().mergeFrom(codedInputStreamMicro);
                }

                public final NEPanelInfo clear() {
                    clearNeCopywriting();
                    clearNeJumpPageIndex();
                    clearNeJumpPageUrl();
                    clearSubCw();
                    clearPatternId();
                    clearTag();
                    clearIconType();
                    this.cachedSize = -1;
                    return this;
                }

                public NEPanelInfo clearIconType() {
                    this.hasIconType = false;
                    this.iconType_ = 0;
                    return this;
                }

                public NEPanelInfo clearNeCopywriting() {
                    this.hasNeCopywriting = false;
                    this.neCopywriting_ = "";
                    return this;
                }

                public NEPanelInfo clearNeJumpPageIndex() {
                    this.hasNeJumpPageIndex = false;
                    this.neJumpPageIndex_ = 0;
                    return this;
                }

                public NEPanelInfo clearNeJumpPageUrl() {
                    this.hasNeJumpPageUrl = false;
                    this.neJumpPageUrl_ = "";
                    return this;
                }

                public NEPanelInfo clearPatternId() {
                    this.hasPatternId = false;
                    this.patternId_ = 0;
                    return this;
                }

                public NEPanelInfo clearSubCw() {
                    this.hasSubCw = false;
                    this.subCw_ = "";
                    return this;
                }

                public NEPanelInfo clearTag() {
                    this.hasTag = false;
                    this.tag_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIconType() {
                    return this.iconType_;
                }

                public String getNeCopywriting() {
                    return this.neCopywriting_;
                }

                public int getNeJumpPageIndex() {
                    return this.neJumpPageIndex_;
                }

                public String getNeJumpPageUrl() {
                    return this.neJumpPageUrl_;
                }

                public int getPatternId() {
                    return this.patternId_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasNeCopywriting() ? CodedOutputStreamMicro.computeStringSize(1, getNeCopywriting()) : 0;
                    if (hasNeJumpPageIndex()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getNeJumpPageIndex());
                    }
                    if (hasNeJumpPageUrl()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getNeJumpPageUrl());
                    }
                    if (hasSubCw()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getSubCw());
                    }
                    if (hasPatternId()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getPatternId());
                    }
                    if (hasTag()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getTag());
                    }
                    if (hasIconType()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getIconType());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public String getSubCw() {
                    return this.subCw_;
                }

                public int getTag() {
                    return this.tag_;
                }

                public boolean hasIconType() {
                    return this.hasIconType;
                }

                public boolean hasNeCopywriting() {
                    return this.hasNeCopywriting;
                }

                public boolean hasNeJumpPageIndex() {
                    return this.hasNeJumpPageIndex;
                }

                public boolean hasNeJumpPageUrl() {
                    return this.hasNeJumpPageUrl;
                }

                public boolean hasPatternId() {
                    return this.hasPatternId;
                }

                public boolean hasSubCw() {
                    return this.hasSubCw;
                }

                public boolean hasTag() {
                    return this.hasTag;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public NEPanelInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setNeCopywriting(codedInputStreamMicro.readString());
                        } else if (readTag == 16) {
                            setNeJumpPageIndex(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            setNeJumpPageUrl(codedInputStreamMicro.readString());
                        } else if (readTag == 34) {
                            setSubCw(codedInputStreamMicro.readString());
                        } else if (readTag == 40) {
                            setPatternId(codedInputStreamMicro.readInt32());
                        } else if (readTag == 48) {
                            setTag(codedInputStreamMicro.readInt32());
                        } else if (readTag == 56) {
                            setIconType(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public NEPanelInfo setIconType(int i) {
                    this.hasIconType = true;
                    this.iconType_ = i;
                    return this;
                }

                public NEPanelInfo setNeCopywriting(String str) {
                    this.hasNeCopywriting = true;
                    this.neCopywriting_ = str;
                    return this;
                }

                public NEPanelInfo setNeJumpPageIndex(int i) {
                    this.hasNeJumpPageIndex = true;
                    this.neJumpPageIndex_ = i;
                    return this;
                }

                public NEPanelInfo setNeJumpPageUrl(String str) {
                    this.hasNeJumpPageUrl = true;
                    this.neJumpPageUrl_ = str;
                    return this;
                }

                public NEPanelInfo setPatternId(int i) {
                    this.hasPatternId = true;
                    this.patternId_ = i;
                    return this;
                }

                public NEPanelInfo setSubCw(String str) {
                    this.hasSubCw = true;
                    this.subCw_ = str;
                    return this;
                }

                public NEPanelInfo setTag(int i) {
                    this.hasTag = true;
                    this.tag_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasNeCopywriting()) {
                        codedOutputStreamMicro.writeString(1, getNeCopywriting());
                    }
                    if (hasNeJumpPageIndex()) {
                        codedOutputStreamMicro.writeInt32(2, getNeJumpPageIndex());
                    }
                    if (hasNeJumpPageUrl()) {
                        codedOutputStreamMicro.writeString(3, getNeJumpPageUrl());
                    }
                    if (hasSubCw()) {
                        codedOutputStreamMicro.writeString(4, getSubCw());
                    }
                    if (hasPatternId()) {
                        codedOutputStreamMicro.writeInt32(5, getPatternId());
                    }
                    if (hasTag()) {
                        codedOutputStreamMicro.writeInt32(6, getTag());
                    }
                    if (hasIconType()) {
                        codedOutputStreamMicro.writeInt32(7, getIconType());
                    }
                }

                public static NEPanelInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (NEPanelInfo) new NEPanelInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class NETransRouteLabel extends MessageMicro {
                public static final int ICON_TYPE_FIELD_NUMBER = 1;
                private boolean hasIconType;
                private int iconType_ = 0;
                private int cachedSize = -1;

                public static NETransRouteLabel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new NETransRouteLabel().mergeFrom(codedInputStreamMicro);
                }

                public final NETransRouteLabel clear() {
                    clearIconType();
                    this.cachedSize = -1;
                    return this;
                }

                public NETransRouteLabel clearIconType() {
                    this.hasIconType = false;
                    this.iconType_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIconType() {
                    return this.iconType_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasIconType() ? CodedOutputStreamMicro.computeInt32Size(1, getIconType()) : 0;
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasIconType() {
                    return this.hasIconType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public NETransRouteLabel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setIconType(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public NETransRouteLabel setIconType(int i) {
                    this.hasIconType = true;
                    this.iconType_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasIconType()) {
                        codedOutputStreamMicro.writeInt32(1, getIconType());
                    }
                }

                public static NETransRouteLabel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (NETransRouteLabel) new NETransRouteLabel().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class RouteEvent extends MessageMicro {
                public static final int CONTENT_FIELD_NUMBER = 6;
                public static final int EVENT_ID_FIELD_NUMBER = 2;
                public static final int EVENT_TYPE_FIELD_NUMBER = 1;
                public static final int PATTERN_ID_FIELD_NUMBER = 5;
                public static final int POS_FIELD_NUMBER = 3;
                public static final int ROOM_ID_FIELD_NUMBER = 7;
                public static final int WEIGHT_FIELD_NUMBER = 4;
                private boolean hasContent;
                private boolean hasEventId;
                private boolean hasEventType;
                private boolean hasPatternId;
                private boolean hasPos;
                private boolean hasRoomId;
                private boolean hasWeight;
                private int eventType_ = 0;
                private long eventId_ = 0;
                private Point pos_ = null;
                private int weight_ = 0;
                private int patternId_ = 0;
                private String content_ = "";
                private long roomId_ = 0;
                private int cachedSize = -1;

                public static RouteEvent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new RouteEvent().mergeFrom(codedInputStreamMicro);
                }

                public final RouteEvent clear() {
                    clearEventType();
                    clearEventId();
                    clearPos();
                    clearWeight();
                    clearPatternId();
                    clearContent();
                    clearRoomId();
                    this.cachedSize = -1;
                    return this;
                }

                public RouteEvent clearContent() {
                    this.hasContent = false;
                    this.content_ = "";
                    return this;
                }

                public RouteEvent clearEventId() {
                    this.hasEventId = false;
                    this.eventId_ = 0L;
                    return this;
                }

                public RouteEvent clearEventType() {
                    this.hasEventType = false;
                    this.eventType_ = 0;
                    return this;
                }

                public RouteEvent clearPatternId() {
                    this.hasPatternId = false;
                    this.patternId_ = 0;
                    return this;
                }

                public RouteEvent clearPos() {
                    this.hasPos = false;
                    this.pos_ = null;
                    return this;
                }

                public RouteEvent clearRoomId() {
                    this.hasRoomId = false;
                    this.roomId_ = 0L;
                    return this;
                }

                public RouteEvent clearWeight() {
                    this.hasWeight = false;
                    this.weight_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getContent() {
                    return this.content_;
                }

                public long getEventId() {
                    return this.eventId_;
                }

                public int getEventType() {
                    return this.eventType_;
                }

                public int getPatternId() {
                    return this.patternId_;
                }

                public Point getPos() {
                    return this.pos_;
                }

                public long getRoomId() {
                    return this.roomId_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasEventType() ? CodedOutputStreamMicro.computeInt32Size(1, getEventType()) : 0;
                    if (hasEventId()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt64Size(2, getEventId());
                    }
                    if (hasPos()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, getPos());
                    }
                    if (hasWeight()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getWeight());
                    }
                    if (hasPatternId()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getPatternId());
                    }
                    if (hasContent()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getContent());
                    }
                    if (hasRoomId()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt64Size(7, getRoomId());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public int getWeight() {
                    return this.weight_;
                }

                public boolean hasContent() {
                    return this.hasContent;
                }

                public boolean hasEventId() {
                    return this.hasEventId;
                }

                public boolean hasEventType() {
                    return this.hasEventType;
                }

                public boolean hasPatternId() {
                    return this.hasPatternId;
                }

                public boolean hasPos() {
                    return this.hasPos;
                }

                public boolean hasRoomId() {
                    return this.hasRoomId;
                }

                public boolean hasWeight() {
                    return this.hasWeight;
                }

                public final boolean isInitialized() {
                    return !hasPos() || getPos().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public RouteEvent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setEventType(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setEventId(codedInputStreamMicro.readInt64());
                        } else if (readTag == 26) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setPos(point);
                        } else if (readTag == 32) {
                            setWeight(codedInputStreamMicro.readInt32());
                        } else if (readTag == 40) {
                            setPatternId(codedInputStreamMicro.readInt32());
                        } else if (readTag == 50) {
                            setContent(codedInputStreamMicro.readString());
                        } else if (readTag == 56) {
                            setRoomId(codedInputStreamMicro.readInt64());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public RouteEvent setContent(String str) {
                    this.hasContent = true;
                    this.content_ = str;
                    return this;
                }

                public RouteEvent setEventId(long j) {
                    this.hasEventId = true;
                    this.eventId_ = j;
                    return this;
                }

                public RouteEvent setEventType(int i) {
                    this.hasEventType = true;
                    this.eventType_ = i;
                    return this;
                }

                public RouteEvent setPatternId(int i) {
                    this.hasPatternId = true;
                    this.patternId_ = i;
                    return this;
                }

                public RouteEvent setPos(Point point) {
                    if (point == null) {
                        return clearPos();
                    }
                    this.hasPos = true;
                    this.pos_ = point;
                    return this;
                }

                public RouteEvent setRoomId(long j) {
                    this.hasRoomId = true;
                    this.roomId_ = j;
                    return this;
                }

                public RouteEvent setWeight(int i) {
                    this.hasWeight = true;
                    this.weight_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasEventType()) {
                        codedOutputStreamMicro.writeInt32(1, getEventType());
                    }
                    if (hasEventId()) {
                        codedOutputStreamMicro.writeInt64(2, getEventId());
                    }
                    if (hasPos()) {
                        codedOutputStreamMicro.writeMessage(3, getPos());
                    }
                    if (hasWeight()) {
                        codedOutputStreamMicro.writeInt32(4, getWeight());
                    }
                    if (hasPatternId()) {
                        codedOutputStreamMicro.writeInt32(5, getPatternId());
                    }
                    if (hasContent()) {
                        codedOutputStreamMicro.writeString(6, getContent());
                    }
                    if (hasRoomId()) {
                        codedOutputStreamMicro.writeInt64(7, getRoomId());
                    }
                }

                public static RouteEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (RouteEvent) new RouteEvent().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class RouteLabelInfo extends MessageMicro {
                public static final int LABELS_FIELD_NUMBER = 1;
                private List<DynamicLabel> labels_ = Collections.emptyList();
                private int cachedSize = -1;

                /* loaded from: classes7.dex */
                public static final class DynamicLabel extends MessageMicro {
                    public static final int CONTENT_FIELD_NUMBER = 3;
                    public static final int LABEL_TYPE_FIELD_NUMBER = 2;
                    public static final int POS_FIELD_NUMBER = 4;
                    public static final int ROUTE_NO_FIELD_NUMBER = 1;
                    private boolean hasContent;
                    private boolean hasLabelType;
                    private boolean hasPos;
                    private boolean hasRouteNo;
                    private int routeNo_ = 0;
                    private int labelType_ = 0;
                    private String content_ = "";
                    private Point pos_ = null;
                    private int cachedSize = -1;

                    public static DynamicLabel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DynamicLabel().mergeFrom(codedInputStreamMicro);
                    }

                    public final DynamicLabel clear() {
                        clearRouteNo();
                        clearLabelType();
                        clearContent();
                        clearPos();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DynamicLabel clearContent() {
                        this.hasContent = false;
                        this.content_ = "";
                        return this;
                    }

                    public DynamicLabel clearLabelType() {
                        this.hasLabelType = false;
                        this.labelType_ = 0;
                        return this;
                    }

                    public DynamicLabel clearPos() {
                        this.hasPos = false;
                        this.pos_ = null;
                        return this;
                    }

                    public DynamicLabel clearRouteNo() {
                        this.hasRouteNo = false;
                        this.routeNo_ = 0;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getContent() {
                        return this.content_;
                    }

                    public int getLabelType() {
                        return this.labelType_;
                    }

                    public Point getPos() {
                        return this.pos_;
                    }

                    public int getRouteNo() {
                        return this.routeNo_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasRouteNo() ? CodedOutputStreamMicro.computeInt32Size(1, getRouteNo()) : 0;
                        if (hasLabelType()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getLabelType());
                        }
                        if (hasContent()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getContent());
                        }
                        if (hasPos()) {
                            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, getPos());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public boolean hasContent() {
                        return this.hasContent;
                    }

                    public boolean hasLabelType() {
                        return this.hasLabelType;
                    }

                    public boolean hasPos() {
                        return this.hasPos;
                    }

                    public boolean hasRouteNo() {
                        return this.hasRouteNo;
                    }

                    public final boolean isInitialized() {
                        return !hasPos() || getPos().isInitialized();
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public DynamicLabel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setRouteNo(codedInputStreamMicro.readInt32());
                            } else if (readTag == 16) {
                                setLabelType(codedInputStreamMicro.readInt32());
                            } else if (readTag == 26) {
                                setContent(codedInputStreamMicro.readString());
                            } else if (readTag == 34) {
                                Point point = new Point();
                                codedInputStreamMicro.readMessage(point);
                                setPos(point);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public DynamicLabel setContent(String str) {
                        this.hasContent = true;
                        this.content_ = str;
                        return this;
                    }

                    public DynamicLabel setLabelType(int i) {
                        this.hasLabelType = true;
                        this.labelType_ = i;
                        return this;
                    }

                    public DynamicLabel setPos(Point point) {
                        if (point == null) {
                            return clearPos();
                        }
                        this.hasPos = true;
                        this.pos_ = point;
                        return this;
                    }

                    public DynamicLabel setRouteNo(int i) {
                        this.hasRouteNo = true;
                        this.routeNo_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasRouteNo()) {
                            codedOutputStreamMicro.writeInt32(1, getRouteNo());
                        }
                        if (hasLabelType()) {
                            codedOutputStreamMicro.writeInt32(2, getLabelType());
                        }
                        if (hasContent()) {
                            codedOutputStreamMicro.writeString(3, getContent());
                        }
                        if (hasPos()) {
                            codedOutputStreamMicro.writeMessage(4, getPos());
                        }
                    }

                    public static DynamicLabel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DynamicLabel) new DynamicLabel().mergeFrom(bArr);
                    }
                }

                public static RouteLabelInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new RouteLabelInfo().mergeFrom(codedInputStreamMicro);
                }

                public RouteLabelInfo addLabels(DynamicLabel dynamicLabel) {
                    if (dynamicLabel == null) {
                        return this;
                    }
                    if (this.labels_.isEmpty()) {
                        this.labels_ = new ArrayList();
                    }
                    this.labels_.add(dynamicLabel);
                    return this;
                }

                public final RouteLabelInfo clear() {
                    clearLabels();
                    this.cachedSize = -1;
                    return this;
                }

                public RouteLabelInfo clearLabels() {
                    this.labels_ = Collections.emptyList();
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public DynamicLabel getLabels(int i) {
                    return this.labels_.get(i);
                }

                public int getLabelsCount() {
                    return this.labels_.size();
                }

                public List<DynamicLabel> getLabelsList() {
                    return this.labels_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    Iterator<DynamicLabel> it = getLabelsList().iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                    }
                    this.cachedSize = i;
                    return i;
                }

                public final boolean isInitialized() {
                    Iterator<DynamicLabel> it = getLabelsList().iterator();
                    while (it.hasNext()) {
                        if (!it.next().isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public RouteLabelInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            DynamicLabel dynamicLabel = new DynamicLabel();
                            codedInputStreamMicro.readMessage(dynamicLabel);
                            addLabels(dynamicLabel);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public RouteLabelInfo setLabels(int i, DynamicLabel dynamicLabel) {
                    if (dynamicLabel == null) {
                        return this;
                    }
                    this.labels_.set(i, dynamicLabel);
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    Iterator<DynamicLabel> it = getLabelsList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeMessage(1, it.next());
                    }
                }

                public static RouteLabelInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (RouteLabelInfo) new RouteLabelInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class RouteLabelUnit extends MessageMicro {
                public static final int LABEL_CONFIG_ID_FIELD_NUMBER = 4;
                public static final int LABEL_DESC_FIELD_NUMBER = 2;
                public static final int LABEL_FLAG_FIELD_NUMBER = 3;
                public static final int LABEL_NAME_FIELD_NUMBER = 1;
                private boolean hasLabelConfigId;
                private boolean hasLabelDesc;
                private boolean hasLabelFlag;
                private boolean hasLabelName;
                private String labelName_ = "";
                private String labelDesc_ = "";
                private boolean labelFlag_ = false;
                private int labelConfigId_ = 0;
                private int cachedSize = -1;

                public static RouteLabelUnit parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new RouteLabelUnit().mergeFrom(codedInputStreamMicro);
                }

                public final RouteLabelUnit clear() {
                    clearLabelName();
                    clearLabelDesc();
                    clearLabelFlag();
                    clearLabelConfigId();
                    this.cachedSize = -1;
                    return this;
                }

                public RouteLabelUnit clearLabelConfigId() {
                    this.hasLabelConfigId = false;
                    this.labelConfigId_ = 0;
                    return this;
                }

                public RouteLabelUnit clearLabelDesc() {
                    this.hasLabelDesc = false;
                    this.labelDesc_ = "";
                    return this;
                }

                public RouteLabelUnit clearLabelFlag() {
                    this.hasLabelFlag = false;
                    this.labelFlag_ = false;
                    return this;
                }

                public RouteLabelUnit clearLabelName() {
                    this.hasLabelName = false;
                    this.labelName_ = "";
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getLabelConfigId() {
                    return this.labelConfigId_;
                }

                public String getLabelDesc() {
                    return this.labelDesc_;
                }

                public boolean getLabelFlag() {
                    return this.labelFlag_;
                }

                public String getLabelName() {
                    return this.labelName_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasLabelName() ? CodedOutputStreamMicro.computeStringSize(1, getLabelName()) : 0;
                    if (hasLabelDesc()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getLabelDesc());
                    }
                    if (hasLabelFlag()) {
                        computeStringSize += CodedOutputStreamMicro.computeBoolSize(3, getLabelFlag());
                    }
                    if (hasLabelConfigId()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getLabelConfigId());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public boolean hasLabelConfigId() {
                    return this.hasLabelConfigId;
                }

                public boolean hasLabelDesc() {
                    return this.hasLabelDesc;
                }

                public boolean hasLabelFlag() {
                    return this.hasLabelFlag;
                }

                public boolean hasLabelName() {
                    return this.hasLabelName;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public RouteLabelUnit mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setLabelName(codedInputStreamMicro.readString());
                        } else if (readTag == 18) {
                            setLabelDesc(codedInputStreamMicro.readString());
                        } else if (readTag == 24) {
                            setLabelFlag(codedInputStreamMicro.readBool());
                        } else if (readTag == 32) {
                            setLabelConfigId(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public RouteLabelUnit setLabelConfigId(int i) {
                    this.hasLabelConfigId = true;
                    this.labelConfigId_ = i;
                    return this;
                }

                public RouteLabelUnit setLabelDesc(String str) {
                    this.hasLabelDesc = true;
                    this.labelDesc_ = str;
                    return this;
                }

                public RouteLabelUnit setLabelFlag(boolean z) {
                    this.hasLabelFlag = true;
                    this.labelFlag_ = z;
                    return this;
                }

                public RouteLabelUnit setLabelName(String str) {
                    this.hasLabelName = true;
                    this.labelName_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasLabelName()) {
                        codedOutputStreamMicro.writeString(1, getLabelName());
                    }
                    if (hasLabelDesc()) {
                        codedOutputStreamMicro.writeString(2, getLabelDesc());
                    }
                    if (hasLabelFlag()) {
                        codedOutputStreamMicro.writeBool(3, getLabelFlag());
                    }
                    if (hasLabelConfigId()) {
                        codedOutputStreamMicro.writeInt32(4, getLabelConfigId());
                    }
                }

                public static RouteLabelUnit parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (RouteLabelUnit) new RouteLabelUnit().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class WholeCondition extends MessageMicro {
                public static final int LENGTH_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasLength;
                private boolean hasType;
                private int type_ = 0;
                private int length_ = 0;
                private int cachedSize = -1;

                public static WholeCondition parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new WholeCondition().mergeFrom(codedInputStreamMicro);
                }

                public final WholeCondition clear() {
                    clearType();
                    clearLength();
                    this.cachedSize = -1;
                    return this;
                }

                public WholeCondition clearLength() {
                    this.hasLength = false;
                    this.length_ = 0;
                    return this;
                }

                public WholeCondition clearType() {
                    this.hasType = false;
                    this.type_ = 0;
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

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
                    if (hasLength()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getLength());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasLength() {
                    return this.hasLength;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public WholeCondition mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setType(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setLength(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public WholeCondition setLength(int i) {
                    this.hasLength = true;
                    this.length_ = i;
                    return this;
                }

                public WholeCondition setType(int i) {
                    this.hasType = true;
                    this.type_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (hasLength()) {
                        codedOutputStreamMicro.writeInt32(2, getLength());
                    }
                }

                public static WholeCondition parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (WholeCondition) new WholeCondition().mergeFrom(bArr);
                }
            }

            public static Routes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Routes().mergeFrom(codedInputStreamMicro);
            }

            public Routes addCameraInfo(CameraInfo cameraInfo) {
                if (cameraInfo == null) {
                    return this;
                }
                if (this.cameraInfo_.isEmpty()) {
                    this.cameraInfo_ = new ArrayList();
                }
                this.cameraInfo_.add(cameraInfo);
                return this;
            }

            public Routes addHitCarRules(String str) {
                str.getClass();
                if (this.hitCarRules_.isEmpty()) {
                    this.hitCarRules_ = new ArrayList();
                }
                this.hitCarRules_.add(str);
                return this;
            }

            public Routes addLegs(Legs legs) {
                if (legs == null) {
                    return this;
                }
                if (this.legs_.isEmpty()) {
                    this.legs_ = new ArrayList();
                }
                this.legs_.add(legs);
                return this;
            }

            public Routes addNeListPagePanel(NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                if (this.neListPagePanel_.isEmpty()) {
                    this.neListPagePanel_ = new ArrayList();
                }
                this.neListPagePanel_.add(nEPanelInfo);
                return this;
            }

            public Routes addNePanelInfo(NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                if (this.nePanelInfo_.isEmpty()) {
                    this.nePanelInfo_ = new ArrayList();
                }
                this.nePanelInfo_.add(nEPanelInfo);
                return this;
            }

            public Routes addRouteEvent(RouteEvent routeEvent) {
                if (routeEvent == null) {
                    return this;
                }
                if (this.routeEvent_.isEmpty()) {
                    this.routeEvent_ = new ArrayList();
                }
                this.routeEvent_.add(routeEvent);
                return this;
            }

            public Routes addTransRouteTagInfo(RouteLabelUnit routeLabelUnit) {
                if (routeLabelUnit == null) {
                    return this;
                }
                if (this.transRouteTagInfo_.isEmpty()) {
                    this.transRouteTagInfo_ = new ArrayList();
                }
                this.transRouteTagInfo_.add(routeLabelUnit);
                return this;
            }

            public final Routes clear() {
                clearDesc();
                clearMrsl();
                clearLegs();
                clearTrafficCondition();
                clearMainRoads();
                clearToll();
                clearLightNum();
                clearWaitingTime();
                clearCongestionLength();
                clearTab();
                clearWholeCondition();
                clearCarPreferArray();
                clearRouteLabelName();
                clearRouteLabelTips();
                clearUgcTips();
                clearRouteDesc();
                clearRouteMd5();
                clearHitCarRules();
                clearTaxPrice();
                clearIsRpBypart();
                clearRouteUniqId();
                clearIsCollected();
                clearDescInfo();
                clearOilToll();
                clearNePanelInfo();
                clearRouteLabel();
                clearRouteEvent();
                clearCameraInfo();
                clearStreetView();
                clearNeListPagePanel();
                clearRouteLabelDesc();
                clearNeRouteLabel();
                clearTransRouteTagInfo();
                this.cachedSize = -1;
                return this;
            }

            public Routes clearCameraInfo() {
                this.cameraInfo_ = Collections.emptyList();
                return this;
            }

            public Routes clearCarPreferArray() {
                this.hasCarPreferArray = false;
                this.carPreferArray_ = null;
                return this;
            }

            public Routes clearCongestionLength() {
                this.hasCongestionLength = false;
                this.congestionLength_ = 0;
                return this;
            }

            public Routes clearDesc() {
                this.hasDesc = false;
                this.desc_ = "";
                return this;
            }

            public Routes clearDescInfo() {
                this.hasDescInfo = false;
                this.descInfo_ = null;
                return this;
            }

            public Routes clearHitCarRules() {
                this.hitCarRules_ = Collections.emptyList();
                return this;
            }

            public Routes clearIsCollected() {
                this.hasIsCollected = false;
                this.isCollected_ = 0;
                return this;
            }

            public Routes clearIsRpBypart() {
                this.hasIsRpBypart = false;
                this.isRpBypart_ = 0;
                return this;
            }

            public Routes clearLegs() {
                this.legs_ = Collections.emptyList();
                return this;
            }

            public Routes clearLightNum() {
                this.hasLightNum = false;
                this.lightNum_ = 0;
                return this;
            }

            public Routes clearMainRoads() {
                this.hasMainRoads = false;
                this.mainRoads_ = "";
                return this;
            }

            public Routes clearMrsl() {
                this.hasMrsl = false;
                this.mrsl_ = "";
                return this;
            }

            public Routes clearNeListPagePanel() {
                this.neListPagePanel_ = Collections.emptyList();
                return this;
            }

            public Routes clearNePanelInfo() {
                this.nePanelInfo_ = Collections.emptyList();
                return this;
            }

            public Routes clearNeRouteLabel() {
                this.hasNeRouteLabel = false;
                this.neRouteLabel_ = null;
                return this;
            }

            public Routes clearOilToll() {
                this.hasOilToll = false;
                this.oilToll_ = 0;
                return this;
            }

            public Routes clearRouteDesc() {
                this.hasRouteDesc = false;
                this.routeDesc_ = "";
                return this;
            }

            public Routes clearRouteEvent() {
                this.routeEvent_ = Collections.emptyList();
                return this;
            }

            public Routes clearRouteLabel() {
                this.hasRouteLabel = false;
                this.routeLabel_ = null;
                return this;
            }

            public Routes clearRouteLabelDesc() {
                this.hasRouteLabelDesc = false;
                this.routeLabelDesc_ = "";
                return this;
            }

            public Routes clearRouteLabelName() {
                this.hasRouteLabelName = false;
                this.routeLabelName_ = "";
                return this;
            }

            public Routes clearRouteLabelTips() {
                this.hasRouteLabelTips = false;
                this.routeLabelTips_ = "";
                return this;
            }

            public Routes clearRouteMd5() {
                this.hasRouteMd5 = false;
                this.routeMd5_ = "";
                return this;
            }

            public Routes clearRouteUniqId() {
                this.hasRouteUniqId = false;
                this.routeUniqId_ = "";
                return this;
            }

            public Routes clearStreetView() {
                this.hasStreetView = false;
                this.streetView_ = null;
                return this;
            }

            public Routes clearTab() {
                this.hasTab = false;
                this.tab_ = "";
                return this;
            }

            public Routes clearTaxPrice() {
                this.hasTaxPrice = false;
                this.taxPrice_ = "";
                return this;
            }

            public Routes clearToll() {
                this.hasToll = false;
                this.toll_ = 0;
                return this;
            }

            public Routes clearTrafficCondition() {
                this.hasTrafficCondition = false;
                this.trafficCondition_ = 0;
                return this;
            }

            public Routes clearTransRouteTagInfo() {
                this.transRouteTagInfo_ = Collections.emptyList();
                return this;
            }

            public Routes clearUgcTips() {
                this.hasUgcTips = false;
                this.ugcTips_ = "";
                return this;
            }

            public Routes clearWaitingTime() {
                this.hasWaitingTime = false;
                this.waitingTime_ = "";
                return this;
            }

            public Routes clearWholeCondition() {
                this.hasWholeCondition = false;
                this.wholeCondition_ = null;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public CameraInfo getCameraInfo(int i) {
                return this.cameraInfo_.get(i);
            }

            public int getCameraInfoCount() {
                return this.cameraInfo_.size();
            }

            public List<CameraInfo> getCameraInfoList() {
                return this.cameraInfo_;
            }

            public CarPreferInfoArray getCarPreferArray() {
                return this.carPreferArray_;
            }

            public int getCongestionLength() {
                return this.congestionLength_;
            }

            public String getDesc() {
                return this.desc_;
            }

            public DescribeInfo getDescInfo() {
                return this.descInfo_;
            }

            public String getHitCarRules(int i) {
                return this.hitCarRules_.get(i);
            }

            public int getHitCarRulesCount() {
                return this.hitCarRules_.size();
            }

            public List<String> getHitCarRulesList() {
                return this.hitCarRules_;
            }

            public int getIsCollected() {
                return this.isCollected_;
            }

            public int getIsRpBypart() {
                return this.isRpBypart_;
            }

            public Legs getLegs(int i) {
                return this.legs_.get(i);
            }

            public int getLegsCount() {
                return this.legs_.size();
            }

            public List<Legs> getLegsList() {
                return this.legs_;
            }

            public int getLightNum() {
                return this.lightNum_;
            }

            public String getMainRoads() {
                return this.mainRoads_;
            }

            public String getMrsl() {
                return this.mrsl_;
            }

            public NEPanelInfo getNeListPagePanel(int i) {
                return this.neListPagePanel_.get(i);
            }

            public int getNeListPagePanelCount() {
                return this.neListPagePanel_.size();
            }

            public List<NEPanelInfo> getNeListPagePanelList() {
                return this.neListPagePanel_;
            }

            public NEPanelInfo getNePanelInfo(int i) {
                return this.nePanelInfo_.get(i);
            }

            public int getNePanelInfoCount() {
                return this.nePanelInfo_.size();
            }

            public List<NEPanelInfo> getNePanelInfoList() {
                return this.nePanelInfo_;
            }

            public NETransRouteLabel getNeRouteLabel() {
                return this.neRouteLabel_;
            }

            public int getOilToll() {
                return this.oilToll_;
            }

            public String getRouteDesc() {
                return this.routeDesc_;
            }

            public RouteEvent getRouteEvent(int i) {
                return this.routeEvent_.get(i);
            }

            public int getRouteEventCount() {
                return this.routeEvent_.size();
            }

            public List<RouteEvent> getRouteEventList() {
                return this.routeEvent_;
            }

            public RouteLabelInfo getRouteLabel() {
                return this.routeLabel_;
            }

            public String getRouteLabelDesc() {
                return this.routeLabelDesc_;
            }

            public String getRouteLabelName() {
                return this.routeLabelName_;
            }

            public String getRouteLabelTips() {
                return this.routeLabelTips_;
            }

            public String getRouteMd5() {
                return this.routeMd5_;
            }

            public String getRouteUniqId() {
                return this.routeUniqId_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasDesc() ? CodedOutputStreamMicro.computeStringSize(1, getDesc()) : 0;
                if (hasMrsl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getMrsl());
                }
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, it.next());
                }
                if (hasTrafficCondition()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getTrafficCondition());
                }
                if (hasMainRoads()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getMainRoads());
                }
                if (hasToll()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getToll());
                }
                if (hasLightNum()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getLightNum());
                }
                if (hasWaitingTime()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getWaitingTime());
                }
                if (hasCongestionLength()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(9, getCongestionLength());
                }
                if (hasTab()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(10, getTab());
                }
                if (hasWholeCondition()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(11, getWholeCondition());
                }
                if (hasCarPreferArray()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(12, getCarPreferArray());
                }
                if (hasRouteLabelName()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(13, getRouteLabelName());
                }
                if (hasRouteLabelTips()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(14, getRouteLabelTips());
                }
                if (hasUgcTips()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(15, getUgcTips());
                }
                if (hasRouteDesc()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(16, getRouteDesc());
                }
                if (hasRouteMd5()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(17, getRouteMd5());
                }
                Iterator<String> it2 = getHitCarRulesList().iterator();
                while (it2.hasNext()) {
                    i += CodedOutputStreamMicro.computeStringSizeNoTag(it2.next());
                }
                int size = computeStringSize + i + (getHitCarRulesList().size() * 2);
                if (hasTaxPrice()) {
                    size += CodedOutputStreamMicro.computeStringSize(19, getTaxPrice());
                }
                if (hasIsRpBypart()) {
                    size += CodedOutputStreamMicro.computeInt32Size(20, getIsRpBypart());
                }
                if (hasRouteUniqId()) {
                    size += CodedOutputStreamMicro.computeStringSize(21, getRouteUniqId());
                }
                if (hasIsCollected()) {
                    size += CodedOutputStreamMicro.computeInt32Size(22, getIsCollected());
                }
                if (hasDescInfo()) {
                    size += CodedOutputStreamMicro.computeMessageSize(23, getDescInfo());
                }
                if (hasOilToll()) {
                    size += CodedOutputStreamMicro.computeInt32Size(24, getOilToll());
                }
                Iterator<NEPanelInfo> it3 = getNePanelInfoList().iterator();
                while (it3.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(25, it3.next());
                }
                if (hasRouteLabel()) {
                    size += CodedOutputStreamMicro.computeMessageSize(26, getRouteLabel());
                }
                Iterator<RouteEvent> it4 = getRouteEventList().iterator();
                while (it4.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(27, it4.next());
                }
                Iterator<CameraInfo> it5 = getCameraInfoList().iterator();
                while (it5.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(28, it5.next());
                }
                if (hasStreetView()) {
                    size += CodedOutputStreamMicro.computeMessageSize(29, getStreetView());
                }
                Iterator<NEPanelInfo> it6 = getNeListPagePanelList().iterator();
                while (it6.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(30, it6.next());
                }
                if (hasRouteLabelDesc()) {
                    size += CodedOutputStreamMicro.computeStringSize(31, getRouteLabelDesc());
                }
                if (hasNeRouteLabel()) {
                    size += CodedOutputStreamMicro.computeMessageSize(32, getNeRouteLabel());
                }
                Iterator<RouteLabelUnit> it7 = getTransRouteTagInfoList().iterator();
                while (it7.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(33, it7.next());
                }
                this.cachedSize = size;
                return size;
            }

            public DstStreetView getStreetView() {
                return this.streetView_;
            }

            public String getTab() {
                return this.tab_;
            }

            public String getTaxPrice() {
                return this.taxPrice_;
            }

            public int getToll() {
                return this.toll_;
            }

            public int getTrafficCondition() {
                return this.trafficCondition_;
            }

            public RouteLabelUnit getTransRouteTagInfo(int i) {
                return this.transRouteTagInfo_.get(i);
            }

            public int getTransRouteTagInfoCount() {
                return this.transRouteTagInfo_.size();
            }

            public List<RouteLabelUnit> getTransRouteTagInfoList() {
                return this.transRouteTagInfo_;
            }

            public String getUgcTips() {
                return this.ugcTips_;
            }

            public String getWaitingTime() {
                return this.waitingTime_;
            }

            public WholeCondition getWholeCondition() {
                return this.wholeCondition_;
            }

            public boolean hasCarPreferArray() {
                return this.hasCarPreferArray;
            }

            public boolean hasCongestionLength() {
                return this.hasCongestionLength;
            }

            public boolean hasDesc() {
                return this.hasDesc;
            }

            public boolean hasDescInfo() {
                return this.hasDescInfo;
            }

            public boolean hasIsCollected() {
                return this.hasIsCollected;
            }

            public boolean hasIsRpBypart() {
                return this.hasIsRpBypart;
            }

            public boolean hasLightNum() {
                return this.hasLightNum;
            }

            public boolean hasMainRoads() {
                return this.hasMainRoads;
            }

            public boolean hasMrsl() {
                return this.hasMrsl;
            }

            public boolean hasNeRouteLabel() {
                return this.hasNeRouteLabel;
            }

            public boolean hasOilToll() {
                return this.hasOilToll;
            }

            public boolean hasRouteDesc() {
                return this.hasRouteDesc;
            }

            public boolean hasRouteLabel() {
                return this.hasRouteLabel;
            }

            public boolean hasRouteLabelDesc() {
                return this.hasRouteLabelDesc;
            }

            public boolean hasRouteLabelName() {
                return this.hasRouteLabelName;
            }

            public boolean hasRouteLabelTips() {
                return this.hasRouteLabelTips;
            }

            public boolean hasRouteMd5() {
                return this.hasRouteMd5;
            }

            public boolean hasRouteUniqId() {
                return this.hasRouteUniqId;
            }

            public boolean hasStreetView() {
                return this.hasStreetView;
            }

            public boolean hasTab() {
                return this.hasTab;
            }

            public boolean hasTaxPrice() {
                return this.hasTaxPrice;
            }

            public boolean hasToll() {
                return this.hasToll;
            }

            public boolean hasTrafficCondition() {
                return this.hasTrafficCondition;
            }

            public boolean hasUgcTips() {
                return this.hasUgcTips;
            }

            public boolean hasWaitingTime() {
                return this.hasWaitingTime;
            }

            public boolean hasWholeCondition() {
                return this.hasWholeCondition;
            }

            public final boolean isInitialized() {
                if (hasDescInfo() && !getDescInfo().isInitialized()) {
                    return false;
                }
                if (hasRouteLabel() && !getRouteLabel().isInitialized()) {
                    return false;
                }
                Iterator<RouteEvent> it = getRouteEventList().iterator();
                while (it.hasNext()) {
                    if (!it.next().isInitialized()) {
                        return false;
                    }
                }
                Iterator<CameraInfo> it2 = getCameraInfoList().iterator();
                while (it2.hasNext()) {
                    if (!it2.next().isInitialized()) {
                        return false;
                    }
                }
                return !hasStreetView() || getStreetView().isInitialized();
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 10:
                            setDesc(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            setMrsl(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            Legs legs = new Legs();
                            codedInputStreamMicro.readMessage(legs);
                            addLegs(legs);
                            break;
                        case 32:
                            setTrafficCondition(codedInputStreamMicro.readInt32());
                            break;
                        case 42:
                            setMainRoads(codedInputStreamMicro.readString());
                            break;
                        case 48:
                            setToll(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            setLightNum(codedInputStreamMicro.readInt32());
                            break;
                        case 66:
                            setWaitingTime(codedInputStreamMicro.readString());
                            break;
                        case 72:
                            setCongestionLength(codedInputStreamMicro.readInt32());
                            break;
                        case 82:
                            setTab(codedInputStreamMicro.readString());
                            break;
                        case 90:
                            WholeCondition wholeCondition = new WholeCondition();
                            codedInputStreamMicro.readMessage(wholeCondition);
                            setWholeCondition(wholeCondition);
                            break;
                        case 98:
                            CarPreferInfoArray carPreferInfoArray = new CarPreferInfoArray();
                            codedInputStreamMicro.readMessage(carPreferInfoArray);
                            setCarPreferArray(carPreferInfoArray);
                            break;
                        case 106:
                            setRouteLabelName(codedInputStreamMicro.readString());
                            break;
                        case 114:
                            setRouteLabelTips(codedInputStreamMicro.readString());
                            break;
                        case 122:
                            setUgcTips(codedInputStreamMicro.readString());
                            break;
                        case 130:
                            setRouteDesc(codedInputStreamMicro.readString());
                            break;
                        case 138:
                            setRouteMd5(codedInputStreamMicro.readString());
                            break;
                        case 146:
                            addHitCarRules(codedInputStreamMicro.readString());
                            break;
                        case 154:
                            setTaxPrice(codedInputStreamMicro.readString());
                            break;
                        case 160:
                            setIsRpBypart(codedInputStreamMicro.readInt32());
                            break;
                        case 170:
                            setRouteUniqId(codedInputStreamMicro.readString());
                            break;
                        case 176:
                            setIsCollected(codedInputStreamMicro.readInt32());
                            break;
                        case 186:
                            DescribeInfo describeInfo = new DescribeInfo();
                            codedInputStreamMicro.readMessage(describeInfo);
                            setDescInfo(describeInfo);
                            break;
                        case 192:
                            setOilToll(codedInputStreamMicro.readInt32());
                            break;
                        case 202:
                            NEPanelInfo nEPanelInfo = new NEPanelInfo();
                            codedInputStreamMicro.readMessage(nEPanelInfo);
                            addNePanelInfo(nEPanelInfo);
                            break;
                        case 210:
                            RouteLabelInfo routeLabelInfo = new RouteLabelInfo();
                            codedInputStreamMicro.readMessage(routeLabelInfo);
                            setRouteLabel(routeLabelInfo);
                            break;
                        case HeightPicker.f25534xoXoI /* 218 */:
                            RouteEvent routeEvent = new RouteEvent();
                            codedInputStreamMicro.readMessage(routeEvent);
                            addRouteEvent(routeEvent);
                            break;
                        case 226:
                            CameraInfo cameraInfo = new CameraInfo();
                            codedInputStreamMicro.readMessage(cameraInfo);
                            addCameraInfo(cameraInfo);
                            break;
                        case 234:
                            DstStreetView dstStreetView = new DstStreetView();
                            codedInputStreamMicro.readMessage(dstStreetView);
                            setStreetView(dstStreetView);
                            break;
                        case Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE /* 242 */:
                            NEPanelInfo nEPanelInfo2 = new NEPanelInfo();
                            codedInputStreamMicro.readMessage(nEPanelInfo2);
                            addNeListPagePanel(nEPanelInfo2);
                            break;
                        case 250:
                            setRouteLabelDesc(codedInputStreamMicro.readString());
                            break;
                        case 258:
                            NETransRouteLabel nETransRouteLabel = new NETransRouteLabel();
                            codedInputStreamMicro.readMessage(nETransRouteLabel);
                            setNeRouteLabel(nETransRouteLabel);
                            break;
                        case 266:
                            RouteLabelUnit routeLabelUnit = new RouteLabelUnit();
                            codedInputStreamMicro.readMessage(routeLabelUnit);
                            addTransRouteTagInfo(routeLabelUnit);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public Routes setCameraInfo(int i, CameraInfo cameraInfo) {
                if (cameraInfo == null) {
                    return this;
                }
                this.cameraInfo_.set(i, cameraInfo);
                return this;
            }

            public Routes setCarPreferArray(CarPreferInfoArray carPreferInfoArray) {
                if (carPreferInfoArray == null) {
                    return clearCarPreferArray();
                }
                this.hasCarPreferArray = true;
                this.carPreferArray_ = carPreferInfoArray;
                return this;
            }

            public Routes setCongestionLength(int i) {
                this.hasCongestionLength = true;
                this.congestionLength_ = i;
                return this;
            }

            public Routes setDesc(String str) {
                this.hasDesc = true;
                this.desc_ = str;
                return this;
            }

            public Routes setDescInfo(DescribeInfo describeInfo) {
                if (describeInfo == null) {
                    return clearDescInfo();
                }
                this.hasDescInfo = true;
                this.descInfo_ = describeInfo;
                return this;
            }

            public Routes setHitCarRules(int i, String str) {
                str.getClass();
                this.hitCarRules_.set(i, str);
                return this;
            }

            public Routes setIsCollected(int i) {
                this.hasIsCollected = true;
                this.isCollected_ = i;
                return this;
            }

            public Routes setIsRpBypart(int i) {
                this.hasIsRpBypart = true;
                this.isRpBypart_ = i;
                return this;
            }

            public Routes setLegs(int i, Legs legs) {
                if (legs == null) {
                    return this;
                }
                this.legs_.set(i, legs);
                return this;
            }

            public Routes setLightNum(int i) {
                this.hasLightNum = true;
                this.lightNum_ = i;
                return this;
            }

            public Routes setMainRoads(String str) {
                this.hasMainRoads = true;
                this.mainRoads_ = str;
                return this;
            }

            public Routes setMrsl(String str) {
                this.hasMrsl = true;
                this.mrsl_ = str;
                return this;
            }

            public Routes setNeListPagePanel(int i, NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                this.neListPagePanel_.set(i, nEPanelInfo);
                return this;
            }

            public Routes setNePanelInfo(int i, NEPanelInfo nEPanelInfo) {
                if (nEPanelInfo == null) {
                    return this;
                }
                this.nePanelInfo_.set(i, nEPanelInfo);
                return this;
            }

            public Routes setNeRouteLabel(NETransRouteLabel nETransRouteLabel) {
                if (nETransRouteLabel == null) {
                    return clearNeRouteLabel();
                }
                this.hasNeRouteLabel = true;
                this.neRouteLabel_ = nETransRouteLabel;
                return this;
            }

            public Routes setOilToll(int i) {
                this.hasOilToll = true;
                this.oilToll_ = i;
                return this;
            }

            public Routes setRouteDesc(String str) {
                this.hasRouteDesc = true;
                this.routeDesc_ = str;
                return this;
            }

            public Routes setRouteEvent(int i, RouteEvent routeEvent) {
                if (routeEvent == null) {
                    return this;
                }
                this.routeEvent_.set(i, routeEvent);
                return this;
            }

            public Routes setRouteLabel(RouteLabelInfo routeLabelInfo) {
                if (routeLabelInfo == null) {
                    return clearRouteLabel();
                }
                this.hasRouteLabel = true;
                this.routeLabel_ = routeLabelInfo;
                return this;
            }

            public Routes setRouteLabelDesc(String str) {
                this.hasRouteLabelDesc = true;
                this.routeLabelDesc_ = str;
                return this;
            }

            public Routes setRouteLabelName(String str) {
                this.hasRouteLabelName = true;
                this.routeLabelName_ = str;
                return this;
            }

            public Routes setRouteLabelTips(String str) {
                this.hasRouteLabelTips = true;
                this.routeLabelTips_ = str;
                return this;
            }

            public Routes setRouteMd5(String str) {
                this.hasRouteMd5 = true;
                this.routeMd5_ = str;
                return this;
            }

            public Routes setRouteUniqId(String str) {
                this.hasRouteUniqId = true;
                this.routeUniqId_ = str;
                return this;
            }

            public Routes setStreetView(DstStreetView dstStreetView) {
                if (dstStreetView == null) {
                    return clearStreetView();
                }
                this.hasStreetView = true;
                this.streetView_ = dstStreetView;
                return this;
            }

            public Routes setTab(String str) {
                this.hasTab = true;
                this.tab_ = str;
                return this;
            }

            public Routes setTaxPrice(String str) {
                this.hasTaxPrice = true;
                this.taxPrice_ = str;
                return this;
            }

            public Routes setToll(int i) {
                this.hasToll = true;
                this.toll_ = i;
                return this;
            }

            public Routes setTrafficCondition(int i) {
                this.hasTrafficCondition = true;
                this.trafficCondition_ = i;
                return this;
            }

            public Routes setTransRouteTagInfo(int i, RouteLabelUnit routeLabelUnit) {
                if (routeLabelUnit == null) {
                    return this;
                }
                this.transRouteTagInfo_.set(i, routeLabelUnit);
                return this;
            }

            public Routes setUgcTips(String str) {
                this.hasUgcTips = true;
                this.ugcTips_ = str;
                return this;
            }

            public Routes setWaitingTime(String str) {
                this.hasWaitingTime = true;
                this.waitingTime_ = str;
                return this;
            }

            public Routes setWholeCondition(WholeCondition wholeCondition) {
                if (wholeCondition == null) {
                    return clearWholeCondition();
                }
                this.hasWholeCondition = true;
                this.wholeCondition_ = wholeCondition;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(1, getDesc());
                }
                if (hasMrsl()) {
                    codedOutputStreamMicro.writeString(2, getMrsl());
                }
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(3, it.next());
                }
                if (hasTrafficCondition()) {
                    codedOutputStreamMicro.writeInt32(4, getTrafficCondition());
                }
                if (hasMainRoads()) {
                    codedOutputStreamMicro.writeString(5, getMainRoads());
                }
                if (hasToll()) {
                    codedOutputStreamMicro.writeInt32(6, getToll());
                }
                if (hasLightNum()) {
                    codedOutputStreamMicro.writeInt32(7, getLightNum());
                }
                if (hasWaitingTime()) {
                    codedOutputStreamMicro.writeString(8, getWaitingTime());
                }
                if (hasCongestionLength()) {
                    codedOutputStreamMicro.writeInt32(9, getCongestionLength());
                }
                if (hasTab()) {
                    codedOutputStreamMicro.writeString(10, getTab());
                }
                if (hasWholeCondition()) {
                    codedOutputStreamMicro.writeMessage(11, getWholeCondition());
                }
                if (hasCarPreferArray()) {
                    codedOutputStreamMicro.writeMessage(12, getCarPreferArray());
                }
                if (hasRouteLabelName()) {
                    codedOutputStreamMicro.writeString(13, getRouteLabelName());
                }
                if (hasRouteLabelTips()) {
                    codedOutputStreamMicro.writeString(14, getRouteLabelTips());
                }
                if (hasUgcTips()) {
                    codedOutputStreamMicro.writeString(15, getUgcTips());
                }
                if (hasRouteDesc()) {
                    codedOutputStreamMicro.writeString(16, getRouteDesc());
                }
                if (hasRouteMd5()) {
                    codedOutputStreamMicro.writeString(17, getRouteMd5());
                }
                Iterator<String> it2 = getHitCarRulesList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeString(18, it2.next());
                }
                if (hasTaxPrice()) {
                    codedOutputStreamMicro.writeString(19, getTaxPrice());
                }
                if (hasIsRpBypart()) {
                    codedOutputStreamMicro.writeInt32(20, getIsRpBypart());
                }
                if (hasRouteUniqId()) {
                    codedOutputStreamMicro.writeString(21, getRouteUniqId());
                }
                if (hasIsCollected()) {
                    codedOutputStreamMicro.writeInt32(22, getIsCollected());
                }
                if (hasDescInfo()) {
                    codedOutputStreamMicro.writeMessage(23, getDescInfo());
                }
                if (hasOilToll()) {
                    codedOutputStreamMicro.writeInt32(24, getOilToll());
                }
                Iterator<NEPanelInfo> it3 = getNePanelInfoList().iterator();
                while (it3.hasNext()) {
                    codedOutputStreamMicro.writeMessage(25, it3.next());
                }
                if (hasRouteLabel()) {
                    codedOutputStreamMicro.writeMessage(26, getRouteLabel());
                }
                Iterator<RouteEvent> it4 = getRouteEventList().iterator();
                while (it4.hasNext()) {
                    codedOutputStreamMicro.writeMessage(27, it4.next());
                }
                Iterator<CameraInfo> it5 = getCameraInfoList().iterator();
                while (it5.hasNext()) {
                    codedOutputStreamMicro.writeMessage(28, it5.next());
                }
                if (hasStreetView()) {
                    codedOutputStreamMicro.writeMessage(29, getStreetView());
                }
                Iterator<NEPanelInfo> it6 = getNeListPagePanelList().iterator();
                while (it6.hasNext()) {
                    codedOutputStreamMicro.writeMessage(30, it6.next());
                }
                if (hasRouteLabelDesc()) {
                    codedOutputStreamMicro.writeString(31, getRouteLabelDesc());
                }
                if (hasNeRouteLabel()) {
                    codedOutputStreamMicro.writeMessage(32, getNeRouteLabel());
                }
                Iterator<RouteLabelUnit> it7 = getTransRouteTagInfoList().iterator();
                while (it7.hasNext()) {
                    codedOutputStreamMicro.writeMessage(33, it7.next());
                }
            }

            public static Routes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Routes) new Routes().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Steps extends MessageMicro {
            public static final int DIRECTION_FIELD_NUMBER = 1;
            public static final int DISTANCE_FIELD_NUMBER = 2;
            public static final int END_INSTRUCTIONS_FIELD_NUMBER = 7;
            public static final int INSTRUCTIONS_FIELD_NUMBER = 3;
            public static final int IS_UNKNOWN_ROAD_FIELD_NUMBER = 13;
            public static final int LEVEL_FIELD_NUMBER = 10;
            public static final int PATH_FIELD_NUMBER = 4;
            public static final int ROAD_TYPE_FIELD_NUMBER = 12;
            public static final int SPATH_FIELD_NUMBER = 8;
            public static final int START_INSTRUCTIONS_FIELD_NUMBER = 6;
            public static final int STEPRCS_FIELD_NUMBER = 11;
            public static final int TURN_FIELD_NUMBER = 5;
            public static final int USROADNAME_FIELD_NUMBER = 9;
            private boolean hasDirection;
            private boolean hasDistance;
            private boolean hasEndInstructions;
            private boolean hasInstructions;
            private boolean hasIsUnknownRoad;
            private boolean hasLevel;
            private boolean hasPath;
            private boolean hasRoadType;
            private boolean hasStartInstructions;
            private boolean hasTurn;
            private boolean hasUsroadname;
            private int direction_ = 0;
            private int distance_ = 0;
            private String instructions_ = "";
            private String path_ = "";
            private int turn_ = 0;
            private String startInstructions_ = "";
            private String endInstructions_ = "";
            private List<Integer> spath_ = Collections.emptyList();
            private String usroadname_ = "";
            private int level_ = 0;
            private List<Steprcs> steprcs_ = Collections.emptyList();
            private int roadType_ = 0;
            private int isUnknownRoad_ = 0;
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class Steprcs extends MessageMicro {
                public static final int END_FIELD_NUMBER = 1;
                public static final int STATUS_FIELD_NUMBER = 2;
                private boolean hasEnd;
                private boolean hasStatus;
                private int end_ = 0;
                private int status_ = 0;
                private int cachedSize = -1;

                public static Steprcs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steprcs().mergeFrom(codedInputStreamMicro);
                }

                public final Steprcs clear() {
                    clearEnd();
                    clearStatus();
                    this.cachedSize = -1;
                    return this;
                }

                public Steprcs clearEnd() {
                    this.hasEnd = false;
                    this.end_ = 0;
                    return this;
                }

                public Steprcs clearStatus() {
                    this.hasStatus = false;
                    this.status_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getEnd() {
                    return this.end_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasEnd() ? CodedOutputStreamMicro.computeInt32Size(1, getEnd()) : 0;
                    if (hasStatus()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getStatus());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public int getStatus() {
                    return this.status_;
                }

                public boolean hasEnd() {
                    return this.hasEnd;
                }

                public boolean hasStatus() {
                    return this.hasStatus;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Steprcs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setEnd(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setStatus(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public Steprcs setEnd(int i) {
                    this.hasEnd = true;
                    this.end_ = i;
                    return this;
                }

                public Steprcs setStatus(int i) {
                    this.hasStatus = true;
                    this.status_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasEnd()) {
                        codedOutputStreamMicro.writeInt32(1, getEnd());
                    }
                    if (hasStatus()) {
                        codedOutputStreamMicro.writeInt32(2, getStatus());
                    }
                }

                public static Steprcs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steprcs) new Steprcs().mergeFrom(bArr);
                }
            }

            public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Steps().mergeFrom(codedInputStreamMicro);
            }

            public Steps addSpath(int i) {
                if (this.spath_.isEmpty()) {
                    this.spath_ = new ArrayList();
                }
                this.spath_.add(Integer.valueOf(i));
                return this;
            }

            public Steps addSteprcs(Steprcs steprcs) {
                if (steprcs == null) {
                    return this;
                }
                if (this.steprcs_.isEmpty()) {
                    this.steprcs_ = new ArrayList();
                }
                this.steprcs_.add(steprcs);
                return this;
            }

            public final Steps clear() {
                clearDirection();
                clearDistance();
                clearInstructions();
                clearPath();
                clearTurn();
                clearStartInstructions();
                clearEndInstructions();
                clearSpath();
                clearUsroadname();
                clearLevel();
                clearSteprcs();
                clearRoadType();
                clearIsUnknownRoad();
                this.cachedSize = -1;
                return this;
            }

            public Steps clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public Steps clearDistance() {
                this.hasDistance = false;
                this.distance_ = 0;
                return this;
            }

            public Steps clearEndInstructions() {
                this.hasEndInstructions = false;
                this.endInstructions_ = "";
                return this;
            }

            public Steps clearInstructions() {
                this.hasInstructions = false;
                this.instructions_ = "";
                return this;
            }

            public Steps clearIsUnknownRoad() {
                this.hasIsUnknownRoad = false;
                this.isUnknownRoad_ = 0;
                return this;
            }

            public Steps clearLevel() {
                this.hasLevel = false;
                this.level_ = 0;
                return this;
            }

            public Steps clearPath() {
                this.hasPath = false;
                this.path_ = "";
                return this;
            }

            public Steps clearRoadType() {
                this.hasRoadType = false;
                this.roadType_ = 0;
                return this;
            }

            public Steps clearSpath() {
                this.spath_ = Collections.emptyList();
                return this;
            }

            public Steps clearStartInstructions() {
                this.hasStartInstructions = false;
                this.startInstructions_ = "";
                return this;
            }

            public Steps clearSteprcs() {
                this.steprcs_ = Collections.emptyList();
                return this;
            }

            public Steps clearTurn() {
                this.hasTurn = false;
                this.turn_ = 0;
                return this;
            }

            public Steps clearUsroadname() {
                this.hasUsroadname = false;
                this.usroadname_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDistance() {
                return this.distance_;
            }

            public String getEndInstructions() {
                return this.endInstructions_;
            }

            public String getInstructions() {
                return this.instructions_;
            }

            public int getIsUnknownRoad() {
                return this.isUnknownRoad_;
            }

            public int getLevel() {
                return this.level_;
            }

            public String getPath() {
                return this.path_;
            }

            public int getRoadType() {
                return this.roadType_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasDirection() ? CodedOutputStreamMicro.computeInt32Size(1, getDirection()) : 0;
                if (hasDistance()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDistance());
                }
                if (hasInstructions()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getInstructions());
                }
                if (hasPath()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getPath());
                }
                if (hasTurn()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getTurn());
                }
                if (hasStartInstructions()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getStartInstructions());
                }
                if (hasEndInstructions()) {
                    computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getEndInstructions());
                }
                Iterator<Integer> it = getSpathList().iterator();
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = computeInt32Size + i + getSpathList().size();
                if (hasUsroadname()) {
                    size += CodedOutputStreamMicro.computeStringSize(9, getUsroadname());
                }
                if (hasLevel()) {
                    size += CodedOutputStreamMicro.computeInt32Size(10, getLevel());
                }
                Iterator<Steprcs> it2 = getSteprcsList().iterator();
                while (it2.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(11, it2.next());
                }
                if (hasRoadType()) {
                    size += CodedOutputStreamMicro.computeInt32Size(12, getRoadType());
                }
                if (hasIsUnknownRoad()) {
                    size += CodedOutputStreamMicro.computeInt32Size(13, getIsUnknownRoad());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpath(int i) {
                return this.spath_.get(i).intValue();
            }

            public int getSpathCount() {
                return this.spath_.size();
            }

            public List<Integer> getSpathList() {
                return this.spath_;
            }

            public String getStartInstructions() {
                return this.startInstructions_;
            }

            public Steprcs getSteprcs(int i) {
                return this.steprcs_.get(i);
            }

            public int getSteprcsCount() {
                return this.steprcs_.size();
            }

            public List<Steprcs> getSteprcsList() {
                return this.steprcs_;
            }

            public int getTurn() {
                return this.turn_;
            }

            public String getUsroadname() {
                return this.usroadname_;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasEndInstructions() {
                return this.hasEndInstructions;
            }

            public boolean hasInstructions() {
                return this.hasInstructions;
            }

            public boolean hasIsUnknownRoad() {
                return this.hasIsUnknownRoad;
            }

            public boolean hasLevel() {
                return this.hasLevel;
            }

            public boolean hasPath() {
                return this.hasPath;
            }

            public boolean hasRoadType() {
                return this.hasRoadType;
            }

            public boolean hasStartInstructions() {
                return this.hasStartInstructions;
            }

            public boolean hasTurn() {
                return this.hasTurn;
            }

            public boolean hasUsroadname() {
                return this.hasUsroadname;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Steps mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            setDirection(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            setDistance(codedInputStreamMicro.readInt32());
                            break;
                        case 26:
                            setInstructions(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            setPath(codedInputStreamMicro.readString());
                            break;
                        case 40:
                            setTurn(codedInputStreamMicro.readInt32());
                            break;
                        case 50:
                            setStartInstructions(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            setEndInstructions(codedInputStreamMicro.readString());
                            break;
                        case 64:
                            addSpath(codedInputStreamMicro.readSInt32());
                            break;
                        case 74:
                            setUsroadname(codedInputStreamMicro.readString());
                            break;
                        case 80:
                            setLevel(codedInputStreamMicro.readInt32());
                            break;
                        case 90:
                            Steprcs steprcs = new Steprcs();
                            codedInputStreamMicro.readMessage(steprcs);
                            addSteprcs(steprcs);
                            break;
                        case 96:
                            setRoadType(codedInputStreamMicro.readInt32());
                            break;
                        case 104:
                            setIsUnknownRoad(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public Steps setDirection(int i) {
                this.hasDirection = true;
                this.direction_ = i;
                return this;
            }

            public Steps setDistance(int i) {
                this.hasDistance = true;
                this.distance_ = i;
                return this;
            }

            public Steps setEndInstructions(String str) {
                this.hasEndInstructions = true;
                this.endInstructions_ = str;
                return this;
            }

            public Steps setInstructions(String str) {
                this.hasInstructions = true;
                this.instructions_ = str;
                return this;
            }

            public Steps setIsUnknownRoad(int i) {
                this.hasIsUnknownRoad = true;
                this.isUnknownRoad_ = i;
                return this;
            }

            public Steps setLevel(int i) {
                this.hasLevel = true;
                this.level_ = i;
                return this;
            }

            public Steps setPath(String str) {
                this.hasPath = true;
                this.path_ = str;
                return this;
            }

            public Steps setRoadType(int i) {
                this.hasRoadType = true;
                this.roadType_ = i;
                return this;
            }

            public Steps setSpath(int i, int i2) {
                this.spath_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Steps setStartInstructions(String str) {
                this.hasStartInstructions = true;
                this.startInstructions_ = str;
                return this;
            }

            public Steps setSteprcs(int i, Steprcs steprcs) {
                if (steprcs == null) {
                    return this;
                }
                this.steprcs_.set(i, steprcs);
                return this;
            }

            public Steps setTurn(int i) {
                this.hasTurn = true;
                this.turn_ = i;
                return this;
            }

            public Steps setUsroadname(String str) {
                this.hasUsroadname = true;
                this.usroadname_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(1, getDirection());
                }
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(2, getDistance());
                }
                if (hasInstructions()) {
                    codedOutputStreamMicro.writeString(3, getInstructions());
                }
                if (hasPath()) {
                    codedOutputStreamMicro.writeString(4, getPath());
                }
                if (hasTurn()) {
                    codedOutputStreamMicro.writeInt32(5, getTurn());
                }
                if (hasStartInstructions()) {
                    codedOutputStreamMicro.writeString(6, getStartInstructions());
                }
                if (hasEndInstructions()) {
                    codedOutputStreamMicro.writeString(7, getEndInstructions());
                }
                Iterator<Integer> it = getSpathList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(8, it.next().intValue());
                }
                if (hasUsroadname()) {
                    codedOutputStreamMicro.writeString(9, getUsroadname());
                }
                if (hasLevel()) {
                    codedOutputStreamMicro.writeInt32(10, getLevel());
                }
                Iterator<Steprcs> it2 = getSteprcsList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeMessage(11, it2.next());
                }
                if (hasRoadType()) {
                    codedOutputStreamMicro.writeInt32(12, getRoadType());
                }
                if (hasIsUnknownRoad()) {
                    codedOutputStreamMicro.writeInt32(13, getIsUnknownRoad());
                }
            }

            public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Steps) new Steps().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Stepts extends MessageMicro {
            public static final int END_FIELD_NUMBER = 1;
            public static final int STATUS_FIELD_NUMBER = 2;
            private List<Integer> end_ = Collections.emptyList();
            private List<Integer> status_ = Collections.emptyList();
            private int cachedSize = -1;

            public static Stepts parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Stepts().mergeFrom(codedInputStreamMicro);
            }

            public Stepts addEnd(int i) {
                if (this.end_.isEmpty()) {
                    this.end_ = new ArrayList();
                }
                this.end_.add(Integer.valueOf(i));
                return this;
            }

            public Stepts addStatus(int i) {
                if (this.status_.isEmpty()) {
                    this.status_ = new ArrayList();
                }
                this.status_.add(Integer.valueOf(i));
                return this;
            }

            public final Stepts clear() {
                clearEnd();
                clearStatus();
                this.cachedSize = -1;
                return this;
            }

            public Stepts clearEnd() {
                this.end_ = Collections.emptyList();
                return this;
            }

            public Stepts clearStatus() {
                this.status_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getEnd(int i) {
                return this.end_.get(i).intValue();
            }

            public int getEndCount() {
                return this.end_.size();
            }

            public List<Integer> getEndList() {
                return this.end_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                Iterator<Integer> it = getEndList().iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    i2 += CodedOutputStreamMicro.computeInt32SizeNoTag(it.next().intValue());
                }
                int size = i2 + getEndList().size();
                Iterator<Integer> it2 = getStatusList().iterator();
                while (it2.hasNext()) {
                    i += CodedOutputStreamMicro.computeInt32SizeNoTag(it2.next().intValue());
                }
                int size2 = size + i + getStatusList().size();
                this.cachedSize = size2;
                return size2;
            }

            public int getStatus(int i) {
                return this.status_.get(i).intValue();
            }

            public int getStatusCount() {
                return this.status_.size();
            }

            public List<Integer> getStatusList() {
                return this.status_;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Stepts mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        addEnd(codedInputStreamMicro.readInt32());
                    } else if (readTag == 16) {
                        addStatus(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public Stepts setEnd(int i, int i2) {
                this.end_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Stepts setStatus(int i, int i2) {
                this.status_.set(i, Integer.valueOf(i2));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<Integer> it = getEndList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeInt32(1, it.next().intValue());
                }
                Iterator<Integer> it2 = getStatusList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeInt32(2, it2.next().intValue());
                }
            }

            public static Stepts parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Stepts) new Stepts().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Taxis extends MessageMicro {
            public static final int TOTAL_PRICE_FIELD_NUMBER = 1;
            private boolean hasTotalPrice;
            private String totalPrice_ = "";
            private int cachedSize = -1;

            public static Taxis parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Taxis().mergeFrom(codedInputStreamMicro);
            }

            public final Taxis clear() {
                clearTotalPrice();
                this.cachedSize = -1;
                return this;
            }

            public Taxis clearTotalPrice() {
                this.hasTotalPrice = false;
                this.totalPrice_ = "";
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
                int computeStringSize = hasTotalPrice() ? CodedOutputStreamMicro.computeStringSize(1, getTotalPrice()) : 0;
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getTotalPrice() {
                return this.totalPrice_;
            }

            public boolean hasTotalPrice() {
                return this.hasTotalPrice;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Taxis mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setTotalPrice(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public Taxis setTotalPrice(String str) {
                this.hasTotalPrice = true;
                this.totalPrice_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTotalPrice()) {
                    codedOutputStreamMicro.writeString(1, getTotalPrice());
                }
            }

            public static Taxis parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Taxis) new Taxis().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Traffics extends MessageMicro {
            public static final int CONGESTION_LENGTH_FIELD_NUMBER = 3;
            public static final int DIGEST_FIELD_NUMBER = 1;
            public static final int LEGS_FIELD_NUMBER = 2;
            public static final int UGC_TIPS_FIELD_NUMBER = 4;
            private boolean hasCongestionLength;
            private boolean hasDigest;
            private boolean hasUgcTips;
            private String digest_ = "";
            private List<Legs> legs_ = Collections.emptyList();
            private int congestionLength_ = 0;
            private String ugcTips_ = "";
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class Legs extends MessageMicro {
                public static final int DISTANCE_FIELD_NUMBER = 1;
                public static final int DURATION_FIELD_NUMBER = 2;
                public static final int MRSL_FIELD_NUMBER = 4;
                public static final int STEPTIS_FIELD_NUMBER = 3;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasMrsl;
                private int distance_ = 0;
                private int duration_ = 0;
                private List<Steptis> steptis_ = Collections.emptyList();
                private String mrsl_ = "";
                private int cachedSize = -1;

                /* loaded from: classes7.dex */
                public static final class Steptis extends MessageMicro {
                    public static final int N_FIELD_NUMBER = 1;
                    public static final int S_FIELD_NUMBER = 2;
                    private boolean hasN;
                    private boolean hasS;
                    private int n_ = 0;
                    private int s_ = 0;
                    private int cachedSize = -1;

                    public static Steptis parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Steptis().mergeFrom(codedInputStreamMicro);
                    }

                    public final Steptis clear() {
                        clearN();
                        clearS();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Steptis clearN() {
                        this.hasN = false;
                        this.n_ = 0;
                        return this;
                    }

                    public Steptis clearS() {
                        this.hasS = false;
                        this.s_ = 0;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getN() {
                        return this.n_;
                    }

                    public int getS() {
                        return this.s_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasN() ? CodedOutputStreamMicro.computeInt32Size(1, getN()) : 0;
                        if (hasS()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getS());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public boolean hasN() {
                        return this.hasN;
                    }

                    public boolean hasS() {
                        return this.hasS;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Steptis mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setN(codedInputStreamMicro.readInt32());
                            } else if (readTag == 16) {
                                setS(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Steptis setN(int i) {
                        this.hasN = true;
                        this.n_ = i;
                        return this;
                    }

                    public Steptis setS(int i) {
                        this.hasS = true;
                        this.s_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasN()) {
                            codedOutputStreamMicro.writeInt32(1, getN());
                        }
                        if (hasS()) {
                            codedOutputStreamMicro.writeInt32(2, getS());
                        }
                    }

                    public static Steptis parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Steptis) new Steptis().mergeFrom(bArr);
                    }
                }

                public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Legs().mergeFrom(codedInputStreamMicro);
                }

                public Legs addSteptis(Steptis steptis) {
                    if (steptis == null) {
                        return this;
                    }
                    if (this.steptis_.isEmpty()) {
                        this.steptis_ = new ArrayList();
                    }
                    this.steptis_.add(steptis);
                    return this;
                }

                public final Legs clear() {
                    clearDistance();
                    clearDuration();
                    clearSteptis();
                    clearMrsl();
                    this.cachedSize = -1;
                    return this;
                }

                public Legs clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public Legs clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public Legs clearMrsl() {
                    this.hasMrsl = false;
                    this.mrsl_ = "";
                    return this;
                }

                public Legs clearSteptis() {
                    this.steptis_ = Collections.emptyList();
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDistance() {
                    return this.distance_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public String getMrsl() {
                    return this.mrsl_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasDistance() ? CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
                    if (hasDuration()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                    }
                    Iterator<Steptis> it = getSteptisList().iterator();
                    while (it.hasNext()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, it.next());
                    }
                    if (hasMrsl()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getMrsl());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public Steptis getSteptis(int i) {
                    return this.steptis_.get(i);
                }

                public int getSteptisCount() {
                    return this.steptis_.size();
                }

                public List<Steptis> getSteptisList() {
                    return this.steptis_;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasMrsl() {
                    return this.hasMrsl;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setDistance(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setDuration(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            Steptis steptis = new Steptis();
                            codedInputStreamMicro.readMessage(steptis);
                            addSteptis(steptis);
                        } else if (readTag == 34) {
                            setMrsl(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public Legs setDistance(int i) {
                    this.hasDistance = true;
                    this.distance_ = i;
                    return this;
                }

                public Legs setDuration(int i) {
                    this.hasDuration = true;
                    this.duration_ = i;
                    return this;
                }

                public Legs setMrsl(String str) {
                    this.hasMrsl = true;
                    this.mrsl_ = str;
                    return this;
                }

                public Legs setSteptis(int i, Steptis steptis) {
                    if (steptis == null) {
                        return this;
                    }
                    this.steptis_.set(i, steptis);
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(1, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(2, getDuration());
                    }
                    Iterator<Steptis> it = getSteptisList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeMessage(3, it.next());
                    }
                    if (hasMrsl()) {
                        codedOutputStreamMicro.writeString(4, getMrsl());
                    }
                }

                public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Legs) new Legs().mergeFrom(bArr);
                }
            }

            public static Traffics parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Traffics().mergeFrom(codedInputStreamMicro);
            }

            public Traffics addLegs(Legs legs) {
                if (legs == null) {
                    return this;
                }
                if (this.legs_.isEmpty()) {
                    this.legs_ = new ArrayList();
                }
                this.legs_.add(legs);
                return this;
            }

            public final Traffics clear() {
                clearDigest();
                clearLegs();
                clearCongestionLength();
                clearUgcTips();
                this.cachedSize = -1;
                return this;
            }

            public Traffics clearCongestionLength() {
                this.hasCongestionLength = false;
                this.congestionLength_ = 0;
                return this;
            }

            public Traffics clearDigest() {
                this.hasDigest = false;
                this.digest_ = "";
                return this;
            }

            public Traffics clearLegs() {
                this.legs_ = Collections.emptyList();
                return this;
            }

            public Traffics clearUgcTips() {
                this.hasUgcTips = false;
                this.ugcTips_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCongestionLength() {
                return this.congestionLength_;
            }

            public String getDigest() {
                return this.digest_;
            }

            public Legs getLegs(int i) {
                return this.legs_.get(i);
            }

            public int getLegsCount() {
                return this.legs_.size();
            }

            public List<Legs> getLegsList() {
                return this.legs_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasDigest() ? CodedOutputStreamMicro.computeStringSize(1, getDigest()) : 0;
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, it.next());
                }
                if (hasCongestionLength()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getCongestionLength());
                }
                if (hasUgcTips()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getUgcTips());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getUgcTips() {
                return this.ugcTips_;
            }

            public boolean hasCongestionLength() {
                return this.hasCongestionLength;
            }

            public boolean hasDigest() {
                return this.hasDigest;
            }

            public boolean hasUgcTips() {
                return this.hasUgcTips;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Traffics mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setDigest(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        Legs legs = new Legs();
                        codedInputStreamMicro.readMessage(legs);
                        addLegs(legs);
                    } else if (readTag == 24) {
                        setCongestionLength(codedInputStreamMicro.readInt32());
                    } else if (readTag == 34) {
                        setUgcTips(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public Traffics setCongestionLength(int i) {
                this.hasCongestionLength = true;
                this.congestionLength_ = i;
                return this;
            }

            public Traffics setDigest(String str) {
                this.hasDigest = true;
                this.digest_ = str;
                return this;
            }

            public Traffics setLegs(int i, Legs legs) {
                if (legs == null) {
                    return this;
                }
                this.legs_.set(i, legs);
                return this;
            }

            public Traffics setUgcTips(String str) {
                this.hasUgcTips = true;
                this.ugcTips_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDigest()) {
                    codedOutputStreamMicro.writeString(1, getDigest());
                }
                Iterator<Legs> it = getLegsList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(2, it.next());
                }
                if (hasCongestionLength()) {
                    codedOutputStreamMicro.writeInt32(3, getCongestionLength());
                }
                if (hasUgcTips()) {
                    codedOutputStreamMicro.writeString(4, getUgcTips());
                }
            }

            public static Traffics parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Traffics) new Traffics().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class WalkInfoT extends MessageMicro {
            public static final int DIST_FIELD_NUMBER = 1;
            public static final int PT_FIELD_NUMBER = 2;
            private boolean hasDist;
            private int dist_ = 0;
            private List<Integer> pt_ = Collections.emptyList();
            private int cachedSize = -1;

            public static WalkInfoT parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new WalkInfoT().mergeFrom(codedInputStreamMicro);
            }

            public WalkInfoT addPt(int i) {
                if (this.pt_.isEmpty()) {
                    this.pt_ = new ArrayList();
                }
                this.pt_.add(Integer.valueOf(i));
                return this;
            }

            public final WalkInfoT clear() {
                clearDist();
                clearPt();
                this.cachedSize = -1;
                return this;
            }

            public WalkInfoT clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public WalkInfoT clearPt() {
                this.pt_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getDist() {
                return this.dist_;
            }

            public int getPt(int i) {
                return this.pt_.get(i).intValue();
            }

            public int getPtCount() {
                return this.pt_.size();
            }

            public List<Integer> getPtList() {
                return this.pt_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasDist() ? CodedOutputStreamMicro.computeInt32Size(1, getDist()) : 0;
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeInt32SizeNoTag(it.next().intValue());
                }
                int size = computeInt32Size + i + getPtList().size();
                this.cachedSize = size;
                return size;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public final boolean isInitialized() {
                return this.hasDist;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public WalkInfoT mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setDist(codedInputStreamMicro.readInt32());
                    } else if (readTag == 16) {
                        addPt(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public WalkInfoT setDist(int i) {
                this.hasDist = true;
                this.dist_ = i;
                return this;
            }

            public WalkInfoT setPt(int i, int i2) {
                this.pt_.set(i, Integer.valueOf(i2));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(1, getDist());
                }
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeInt32(2, it.next().intValue());
                }
            }

            public static WalkInfoT parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (WalkInfoT) new WalkInfoT().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class YellowTipsList extends MessageMicro {
            public static final int MRSL_FIELD_NUMBER = 2;
            public static final int YELLOW_TIPS_INFO_FIELD_NUMBER = 1;
            private boolean hasMrsl;
            private List<YellowTipsInfo> yellowTipsInfo_ = Collections.emptyList();
            private String mrsl_ = "";
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class YellowTipsInfo extends MessageMicro {
                public static final int ASSIST_INFO_FIELD_NUMBER = 3;
                public static final int BACK_COLOR_ID_FIELD_NUMBER = 6;
                public static final int DISPLAY_POS_FIELD_NUMBER = 20;
                public static final int END_BTN_FIELD_NUMBER = 7;
                public static final int EVENT_ID_FIELD_NUMBER = 13;
                public static final int EVENT_TYPE_FIELD_NUMBER = 14;
                public static final int EXPLAIN_BUBBLE_FIELD_NUMBER = 19;
                public static final int EXPLAIN_SUB_TITLE_FIELD_NUMBER = 18;
                public static final int EXPLAIN_TITLE_FIELD_NUMBER = 8;
                public static final int ICON_ID_FIELD_NUMBER = 5;
                public static final int IMAGE_EXPLAIN_FIELD_NUMBER = 16;
                public static final int IMAGE_URL_FIELD_NUMBER = 15;
                public static final int JUMP_FLAG_FIELD_NUMBER = 11;
                public static final int NEW_PATTERN_FIELD_NUMBER = 17;
                public static final int PANEL_FLAG_FIELD_NUMBER = 12;
                public static final int PERMIT_INFO_ID_FIELD_NUMBER = 9;
                public static final int ROAD_NO_FIELD_NUMBER = 10;
                public static final int SUB_TITLE_FIELD_NUMBER = 2;
                public static final int TIP_ID_FIELD_NUMBER = 4;
                public static final int TITLE_FIELD_NUMBER = 1;
                private boolean hasAssistInfo;
                private boolean hasBackColorId;
                private boolean hasDisplayPos;
                private boolean hasEventId;
                private boolean hasEventType;
                private boolean hasExplainBubble;
                private boolean hasExplainSubTitle;
                private boolean hasExplainTitle;
                private boolean hasIconId;
                private boolean hasJumpFlag;
                private boolean hasNewPattern;
                private boolean hasPanelFlag;
                private boolean hasPermitInfoId;
                private boolean hasRoadNo;
                private boolean hasSubTitle;
                private boolean hasTipId;
                private boolean hasTitle;
                private String title_ = "";
                private String subTitle_ = "";
                private String assistInfo_ = "";
                private int tipId_ = 0;
                private int iconId_ = 0;
                private int backColorId_ = 0;
                private List<end_button_info> endBtn_ = Collections.emptyList();
                private String explainTitle_ = "";
                private String permitInfoId_ = "";
                private int roadNo_ = 0;
                private int jumpFlag_ = 0;
                private int panelFlag_ = 0;
                private String eventId_ = "";
                private int eventType_ = 0;
                private List<String> imageUrl_ = Collections.emptyList();
                private List<String> imageExplain_ = Collections.emptyList();
                private int newPattern_ = 0;
                private String explainSubTitle_ = "";
                private explain_bubble_t explainBubble_ = null;
                private int displayPos_ = 0;
                private int cachedSize = -1;

                public static YellowTipsInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new YellowTipsInfo().mergeFrom(codedInputStreamMicro);
                }

                public YellowTipsInfo addEndBtn(end_button_info end_button_infoVar) {
                    if (end_button_infoVar == null) {
                        return this;
                    }
                    if (this.endBtn_.isEmpty()) {
                        this.endBtn_ = new ArrayList();
                    }
                    this.endBtn_.add(end_button_infoVar);
                    return this;
                }

                public YellowTipsInfo addImageExplain(String str) {
                    str.getClass();
                    if (this.imageExplain_.isEmpty()) {
                        this.imageExplain_ = new ArrayList();
                    }
                    this.imageExplain_.add(str);
                    return this;
                }

                public YellowTipsInfo addImageUrl(String str) {
                    str.getClass();
                    if (this.imageUrl_.isEmpty()) {
                        this.imageUrl_ = new ArrayList();
                    }
                    this.imageUrl_.add(str);
                    return this;
                }

                public final YellowTipsInfo clear() {
                    clearTitle();
                    clearSubTitle();
                    clearAssistInfo();
                    clearTipId();
                    clearIconId();
                    clearBackColorId();
                    clearEndBtn();
                    clearExplainTitle();
                    clearPermitInfoId();
                    clearRoadNo();
                    clearJumpFlag();
                    clearPanelFlag();
                    clearEventId();
                    clearEventType();
                    clearImageUrl();
                    clearImageExplain();
                    clearNewPattern();
                    clearExplainSubTitle();
                    clearExplainBubble();
                    clearDisplayPos();
                    this.cachedSize = -1;
                    return this;
                }

                public YellowTipsInfo clearAssistInfo() {
                    this.hasAssistInfo = false;
                    this.assistInfo_ = "";
                    return this;
                }

                public YellowTipsInfo clearBackColorId() {
                    this.hasBackColorId = false;
                    this.backColorId_ = 0;
                    return this;
                }

                public YellowTipsInfo clearDisplayPos() {
                    this.hasDisplayPos = false;
                    this.displayPos_ = 0;
                    return this;
                }

                public YellowTipsInfo clearEndBtn() {
                    this.endBtn_ = Collections.emptyList();
                    return this;
                }

                public YellowTipsInfo clearEventId() {
                    this.hasEventId = false;
                    this.eventId_ = "";
                    return this;
                }

                public YellowTipsInfo clearEventType() {
                    this.hasEventType = false;
                    this.eventType_ = 0;
                    return this;
                }

                public YellowTipsInfo clearExplainBubble() {
                    this.hasExplainBubble = false;
                    this.explainBubble_ = null;
                    return this;
                }

                public YellowTipsInfo clearExplainSubTitle() {
                    this.hasExplainSubTitle = false;
                    this.explainSubTitle_ = "";
                    return this;
                }

                public YellowTipsInfo clearExplainTitle() {
                    this.hasExplainTitle = false;
                    this.explainTitle_ = "";
                    return this;
                }

                public YellowTipsInfo clearIconId() {
                    this.hasIconId = false;
                    this.iconId_ = 0;
                    return this;
                }

                public YellowTipsInfo clearImageExplain() {
                    this.imageExplain_ = Collections.emptyList();
                    return this;
                }

                public YellowTipsInfo clearImageUrl() {
                    this.imageUrl_ = Collections.emptyList();
                    return this;
                }

                public YellowTipsInfo clearJumpFlag() {
                    this.hasJumpFlag = false;
                    this.jumpFlag_ = 0;
                    return this;
                }

                public YellowTipsInfo clearNewPattern() {
                    this.hasNewPattern = false;
                    this.newPattern_ = 0;
                    return this;
                }

                public YellowTipsInfo clearPanelFlag() {
                    this.hasPanelFlag = false;
                    this.panelFlag_ = 0;
                    return this;
                }

                public YellowTipsInfo clearPermitInfoId() {
                    this.hasPermitInfoId = false;
                    this.permitInfoId_ = "";
                    return this;
                }

                public YellowTipsInfo clearRoadNo() {
                    this.hasRoadNo = false;
                    this.roadNo_ = 0;
                    return this;
                }

                public YellowTipsInfo clearSubTitle() {
                    this.hasSubTitle = false;
                    this.subTitle_ = "";
                    return this;
                }

                public YellowTipsInfo clearTipId() {
                    this.hasTipId = false;
                    this.tipId_ = 0;
                    return this;
                }

                public YellowTipsInfo clearTitle() {
                    this.hasTitle = false;
                    this.title_ = "";
                    return this;
                }

                public String getAssistInfo() {
                    return this.assistInfo_;
                }

                public int getBackColorId() {
                    return this.backColorId_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDisplayPos() {
                    return this.displayPos_;
                }

                public end_button_info getEndBtn(int i) {
                    return this.endBtn_.get(i);
                }

                public int getEndBtnCount() {
                    return this.endBtn_.size();
                }

                public List<end_button_info> getEndBtnList() {
                    return this.endBtn_;
                }

                public String getEventId() {
                    return this.eventId_;
                }

                public int getEventType() {
                    return this.eventType_;
                }

                public explain_bubble_t getExplainBubble() {
                    return this.explainBubble_;
                }

                public String getExplainSubTitle() {
                    return this.explainSubTitle_;
                }

                public String getExplainTitle() {
                    return this.explainTitle_;
                }

                public int getIconId() {
                    return this.iconId_;
                }

                public String getImageExplain(int i) {
                    return this.imageExplain_.get(i);
                }

                public int getImageExplainCount() {
                    return this.imageExplain_.size();
                }

                public List<String> getImageExplainList() {
                    return this.imageExplain_;
                }

                public String getImageUrl(int i) {
                    return this.imageUrl_.get(i);
                }

                public int getImageUrlCount() {
                    return this.imageUrl_.size();
                }

                public List<String> getImageUrlList() {
                    return this.imageUrl_;
                }

                public int getJumpFlag() {
                    return this.jumpFlag_;
                }

                public int getNewPattern() {
                    return this.newPattern_;
                }

                public int getPanelFlag() {
                    return this.panelFlag_;
                }

                public String getPermitInfoId() {
                    return this.permitInfoId_;
                }

                public int getRoadNo() {
                    return this.roadNo_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int i = 0;
                    int computeStringSize = hasTitle() ? CodedOutputStreamMicro.computeStringSize(1, getTitle()) : 0;
                    if (hasSubTitle()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
                    }
                    if (hasAssistInfo()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getAssistInfo());
                    }
                    if (hasTipId()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getTipId());
                    }
                    if (hasIconId()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getIconId());
                    }
                    if (hasBackColorId()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getBackColorId());
                    }
                    Iterator<end_button_info> it = getEndBtnList().iterator();
                    while (it.hasNext()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(7, it.next());
                    }
                    if (hasExplainTitle()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getExplainTitle());
                    }
                    if (hasPermitInfoId()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(9, getPermitInfoId());
                    }
                    if (hasRoadNo()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(10, getRoadNo());
                    }
                    if (hasJumpFlag()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(11, getJumpFlag());
                    }
                    if (hasPanelFlag()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(12, getPanelFlag());
                    }
                    if (hasEventId()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(13, getEventId());
                    }
                    if (hasEventType()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(14, getEventType());
                    }
                    Iterator<String> it2 = getImageUrlList().iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        i2 += CodedOutputStreamMicro.computeStringSizeNoTag(it2.next());
                    }
                    int size = computeStringSize + i2 + getImageUrlList().size();
                    Iterator<String> it3 = getImageExplainList().iterator();
                    while (it3.hasNext()) {
                        i += CodedOutputStreamMicro.computeStringSizeNoTag(it3.next());
                    }
                    int size2 = size + i + (getImageExplainList().size() * 2);
                    if (hasNewPattern()) {
                        size2 += CodedOutputStreamMicro.computeInt32Size(17, getNewPattern());
                    }
                    if (hasExplainSubTitle()) {
                        size2 += CodedOutputStreamMicro.computeStringSize(18, getExplainSubTitle());
                    }
                    if (hasExplainBubble()) {
                        size2 += CodedOutputStreamMicro.computeMessageSize(19, getExplainBubble());
                    }
                    if (hasDisplayPos()) {
                        size2 += CodedOutputStreamMicro.computeInt32Size(20, getDisplayPos());
                    }
                    this.cachedSize = size2;
                    return size2;
                }

                public String getSubTitle() {
                    return this.subTitle_;
                }

                public int getTipId() {
                    return this.tipId_;
                }

                public String getTitle() {
                    return this.title_;
                }

                public boolean hasAssistInfo() {
                    return this.hasAssistInfo;
                }

                public boolean hasBackColorId() {
                    return this.hasBackColorId;
                }

                public boolean hasDisplayPos() {
                    return this.hasDisplayPos;
                }

                public boolean hasEventId() {
                    return this.hasEventId;
                }

                public boolean hasEventType() {
                    return this.hasEventType;
                }

                public boolean hasExplainBubble() {
                    return this.hasExplainBubble;
                }

                public boolean hasExplainSubTitle() {
                    return this.hasExplainSubTitle;
                }

                public boolean hasExplainTitle() {
                    return this.hasExplainTitle;
                }

                public boolean hasIconId() {
                    return this.hasIconId;
                }

                public boolean hasJumpFlag() {
                    return this.hasJumpFlag;
                }

                public boolean hasNewPattern() {
                    return this.hasNewPattern;
                }

                public boolean hasPanelFlag() {
                    return this.hasPanelFlag;
                }

                public boolean hasPermitInfoId() {
                    return this.hasPermitInfoId;
                }

                public boolean hasRoadNo() {
                    return this.hasRoadNo;
                }

                public boolean hasSubTitle() {
                    return this.hasSubTitle;
                }

                public boolean hasTipId() {
                    return this.hasTipId;
                }

                public boolean hasTitle() {
                    return this.hasTitle;
                }

                public final boolean isInitialized() {
                    if (!this.hasTitle || !this.hasTipId) {
                        return false;
                    }
                    Iterator<end_button_info> it = getEndBtnList().iterator();
                    while (it.hasNext()) {
                        if (!it.next().isInitialized()) {
                            return false;
                        }
                    }
                    return !hasExplainBubble() || getExplainBubble().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public YellowTipsInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                return this;
                            case 10:
                                setTitle(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                setSubTitle(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                setAssistInfo(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                setTipId(codedInputStreamMicro.readInt32());
                                break;
                            case 40:
                                setIconId(codedInputStreamMicro.readInt32());
                                break;
                            case 48:
                                setBackColorId(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                end_button_info end_button_infoVar = new end_button_info();
                                codedInputStreamMicro.readMessage(end_button_infoVar);
                                addEndBtn(end_button_infoVar);
                                break;
                            case 66:
                                setExplainTitle(codedInputStreamMicro.readString());
                                break;
                            case 74:
                                setPermitInfoId(codedInputStreamMicro.readString());
                                break;
                            case 80:
                                setRoadNo(codedInputStreamMicro.readInt32());
                                break;
                            case 88:
                                setJumpFlag(codedInputStreamMicro.readInt32());
                                break;
                            case 96:
                                setPanelFlag(codedInputStreamMicro.readInt32());
                                break;
                            case 106:
                                setEventId(codedInputStreamMicro.readString());
                                break;
                            case 112:
                                setEventType(codedInputStreamMicro.readInt32());
                                break;
                            case 122:
                                addImageUrl(codedInputStreamMicro.readString());
                                break;
                            case 130:
                                addImageExplain(codedInputStreamMicro.readString());
                                break;
                            case 136:
                                setNewPattern(codedInputStreamMicro.readInt32());
                                break;
                            case 146:
                                setExplainSubTitle(codedInputStreamMicro.readString());
                                break;
                            case 154:
                                explain_bubble_t explain_bubble_tVar = new explain_bubble_t();
                                codedInputStreamMicro.readMessage(explain_bubble_tVar);
                                setExplainBubble(explain_bubble_tVar);
                                break;
                            case 160:
                                setDisplayPos(codedInputStreamMicro.readInt32());
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                                break;
                        }
                    }
                }

                public YellowTipsInfo setAssistInfo(String str) {
                    this.hasAssistInfo = true;
                    this.assistInfo_ = str;
                    return this;
                }

                public YellowTipsInfo setBackColorId(int i) {
                    this.hasBackColorId = true;
                    this.backColorId_ = i;
                    return this;
                }

                public YellowTipsInfo setDisplayPos(int i) {
                    this.hasDisplayPos = true;
                    this.displayPos_ = i;
                    return this;
                }

                public YellowTipsInfo setEndBtn(int i, end_button_info end_button_infoVar) {
                    if (end_button_infoVar == null) {
                        return this;
                    }
                    this.endBtn_.set(i, end_button_infoVar);
                    return this;
                }

                public YellowTipsInfo setEventId(String str) {
                    this.hasEventId = true;
                    this.eventId_ = str;
                    return this;
                }

                public YellowTipsInfo setEventType(int i) {
                    this.hasEventType = true;
                    this.eventType_ = i;
                    return this;
                }

                public YellowTipsInfo setExplainBubble(explain_bubble_t explain_bubble_tVar) {
                    if (explain_bubble_tVar == null) {
                        return clearExplainBubble();
                    }
                    this.hasExplainBubble = true;
                    this.explainBubble_ = explain_bubble_tVar;
                    return this;
                }

                public YellowTipsInfo setExplainSubTitle(String str) {
                    this.hasExplainSubTitle = true;
                    this.explainSubTitle_ = str;
                    return this;
                }

                public YellowTipsInfo setExplainTitle(String str) {
                    this.hasExplainTitle = true;
                    this.explainTitle_ = str;
                    return this;
                }

                public YellowTipsInfo setIconId(int i) {
                    this.hasIconId = true;
                    this.iconId_ = i;
                    return this;
                }

                public YellowTipsInfo setImageExplain(int i, String str) {
                    str.getClass();
                    this.imageExplain_.set(i, str);
                    return this;
                }

                public YellowTipsInfo setImageUrl(int i, String str) {
                    str.getClass();
                    this.imageUrl_.set(i, str);
                    return this;
                }

                public YellowTipsInfo setJumpFlag(int i) {
                    this.hasJumpFlag = true;
                    this.jumpFlag_ = i;
                    return this;
                }

                public YellowTipsInfo setNewPattern(int i) {
                    this.hasNewPattern = true;
                    this.newPattern_ = i;
                    return this;
                }

                public YellowTipsInfo setPanelFlag(int i) {
                    this.hasPanelFlag = true;
                    this.panelFlag_ = i;
                    return this;
                }

                public YellowTipsInfo setPermitInfoId(String str) {
                    this.hasPermitInfoId = true;
                    this.permitInfoId_ = str;
                    return this;
                }

                public YellowTipsInfo setRoadNo(int i) {
                    this.hasRoadNo = true;
                    this.roadNo_ = i;
                    return this;
                }

                public YellowTipsInfo setSubTitle(String str) {
                    this.hasSubTitle = true;
                    this.subTitle_ = str;
                    return this;
                }

                public YellowTipsInfo setTipId(int i) {
                    this.hasTipId = true;
                    this.tipId_ = i;
                    return this;
                }

                public YellowTipsInfo setTitle(String str) {
                    this.hasTitle = true;
                    this.title_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasTitle()) {
                        codedOutputStreamMicro.writeString(1, getTitle());
                    }
                    if (hasSubTitle()) {
                        codedOutputStreamMicro.writeString(2, getSubTitle());
                    }
                    if (hasAssistInfo()) {
                        codedOutputStreamMicro.writeString(3, getAssistInfo());
                    }
                    if (hasTipId()) {
                        codedOutputStreamMicro.writeInt32(4, getTipId());
                    }
                    if (hasIconId()) {
                        codedOutputStreamMicro.writeInt32(5, getIconId());
                    }
                    if (hasBackColorId()) {
                        codedOutputStreamMicro.writeInt32(6, getBackColorId());
                    }
                    Iterator<end_button_info> it = getEndBtnList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeMessage(7, it.next());
                    }
                    if (hasExplainTitle()) {
                        codedOutputStreamMicro.writeString(8, getExplainTitle());
                    }
                    if (hasPermitInfoId()) {
                        codedOutputStreamMicro.writeString(9, getPermitInfoId());
                    }
                    if (hasRoadNo()) {
                        codedOutputStreamMicro.writeInt32(10, getRoadNo());
                    }
                    if (hasJumpFlag()) {
                        codedOutputStreamMicro.writeInt32(11, getJumpFlag());
                    }
                    if (hasPanelFlag()) {
                        codedOutputStreamMicro.writeInt32(12, getPanelFlag());
                    }
                    if (hasEventId()) {
                        codedOutputStreamMicro.writeString(13, getEventId());
                    }
                    if (hasEventType()) {
                        codedOutputStreamMicro.writeInt32(14, getEventType());
                    }
                    Iterator<String> it2 = getImageUrlList().iterator();
                    while (it2.hasNext()) {
                        codedOutputStreamMicro.writeString(15, it2.next());
                    }
                    Iterator<String> it3 = getImageExplainList().iterator();
                    while (it3.hasNext()) {
                        codedOutputStreamMicro.writeString(16, it3.next());
                    }
                    if (hasNewPattern()) {
                        codedOutputStreamMicro.writeInt32(17, getNewPattern());
                    }
                    if (hasExplainSubTitle()) {
                        codedOutputStreamMicro.writeString(18, getExplainSubTitle());
                    }
                    if (hasExplainBubble()) {
                        codedOutputStreamMicro.writeMessage(19, getExplainBubble());
                    }
                    if (hasDisplayPos()) {
                        codedOutputStreamMicro.writeInt32(20, getDisplayPos());
                    }
                }

                public static YellowTipsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (YellowTipsInfo) new YellowTipsInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class end_button_info extends MessageMicro {
                public static final int BACKGROUND_COLOR_FIELD_NUMBER = 8;
                public static final int BORDER_COLOR_FIELD_NUMBER = 7;
                public static final int BTN_TITLE_FIELD_NUMBER = 1;
                public static final int CITYID_FIELD_NUMBER = 6;
                public static final int CNAME_FIELD_NUMBER = 5;
                public static final int END_INPUT_FIELD_NUMBER = 2;
                public static final int SHOW_POINT_FIELD_NUMBER = 3;
                public static final int UID_FIELD_NUMBER = 4;
                private boolean hasBackgroundColor;
                private boolean hasBorderColor;
                private boolean hasBtnTitle;
                private boolean hasCityid;
                private boolean hasCname;
                private boolean hasEndInput;
                private boolean hasShowPoint;
                private boolean hasUid;
                private String btnTitle_ = "";
                private String endInput_ = "";
                private Point showPoint_ = null;
                private String uid_ = "";
                private String cname_ = "";
                private int cityid_ = 0;
                private int borderColor_ = 0;
                private int backgroundColor_ = 0;
                private int cachedSize = -1;

                public static end_button_info parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new end_button_info().mergeFrom(codedInputStreamMicro);
                }

                public final end_button_info clear() {
                    clearBtnTitle();
                    clearEndInput();
                    clearShowPoint();
                    clearUid();
                    clearCname();
                    clearCityid();
                    clearBorderColor();
                    clearBackgroundColor();
                    this.cachedSize = -1;
                    return this;
                }

                public end_button_info clearBackgroundColor() {
                    this.hasBackgroundColor = false;
                    this.backgroundColor_ = 0;
                    return this;
                }

                public end_button_info clearBorderColor() {
                    this.hasBorderColor = false;
                    this.borderColor_ = 0;
                    return this;
                }

                public end_button_info clearBtnTitle() {
                    this.hasBtnTitle = false;
                    this.btnTitle_ = "";
                    return this;
                }

                public end_button_info clearCityid() {
                    this.hasCityid = false;
                    this.cityid_ = 0;
                    return this;
                }

                public end_button_info clearCname() {
                    this.hasCname = false;
                    this.cname_ = "";
                    return this;
                }

                public end_button_info clearEndInput() {
                    this.hasEndInput = false;
                    this.endInput_ = "";
                    return this;
                }

                public end_button_info clearShowPoint() {
                    this.hasShowPoint = false;
                    this.showPoint_ = null;
                    return this;
                }

                public end_button_info clearUid() {
                    this.hasUid = false;
                    this.uid_ = "";
                    return this;
                }

                public int getBackgroundColor() {
                    return this.backgroundColor_;
                }

                public int getBorderColor() {
                    return this.borderColor_;
                }

                public String getBtnTitle() {
                    return this.btnTitle_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCityid() {
                    return this.cityid_;
                }

                public String getCname() {
                    return this.cname_;
                }

                public String getEndInput() {
                    return this.endInput_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasBtnTitle() ? CodedOutputStreamMicro.computeStringSize(1, getBtnTitle()) : 0;
                    if (hasEndInput()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getEndInput());
                    }
                    if (hasShowPoint()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, getShowPoint());
                    }
                    if (hasUid()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getUid());
                    }
                    if (hasCname()) {
                        computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getCname());
                    }
                    if (hasCityid()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getCityid());
                    }
                    if (hasBorderColor()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getBorderColor());
                    }
                    if (hasBackgroundColor()) {
                        computeStringSize += CodedOutputStreamMicro.computeInt32Size(8, getBackgroundColor());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public Point getShowPoint() {
                    return this.showPoint_;
                }

                public String getUid() {
                    return this.uid_;
                }

                public boolean hasBackgroundColor() {
                    return this.hasBackgroundColor;
                }

                public boolean hasBorderColor() {
                    return this.hasBorderColor;
                }

                public boolean hasBtnTitle() {
                    return this.hasBtnTitle;
                }

                public boolean hasCityid() {
                    return this.hasCityid;
                }

                public boolean hasCname() {
                    return this.hasCname;
                }

                public boolean hasEndInput() {
                    return this.hasEndInput;
                }

                public boolean hasShowPoint() {
                    return this.hasShowPoint;
                }

                public boolean hasUid() {
                    return this.hasUid;
                }

                public final boolean isInitialized() {
                    return !hasShowPoint() || getShowPoint().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public end_button_info mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setBtnTitle(codedInputStreamMicro.readString());
                        } else if (readTag == 18) {
                            setEndInput(codedInputStreamMicro.readString());
                        } else if (readTag == 26) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setShowPoint(point);
                        } else if (readTag == 34) {
                            setUid(codedInputStreamMicro.readString());
                        } else if (readTag == 42) {
                            setCname(codedInputStreamMicro.readString());
                        } else if (readTag == 48) {
                            setCityid(codedInputStreamMicro.readInt32());
                        } else if (readTag == 56) {
                            setBorderColor(codedInputStreamMicro.readInt32());
                        } else if (readTag == 64) {
                            setBackgroundColor(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public end_button_info setBackgroundColor(int i) {
                    this.hasBackgroundColor = true;
                    this.backgroundColor_ = i;
                    return this;
                }

                public end_button_info setBorderColor(int i) {
                    this.hasBorderColor = true;
                    this.borderColor_ = i;
                    return this;
                }

                public end_button_info setBtnTitle(String str) {
                    this.hasBtnTitle = true;
                    this.btnTitle_ = str;
                    return this;
                }

                public end_button_info setCityid(int i) {
                    this.hasCityid = true;
                    this.cityid_ = i;
                    return this;
                }

                public end_button_info setCname(String str) {
                    this.hasCname = true;
                    this.cname_ = str;
                    return this;
                }

                public end_button_info setEndInput(String str) {
                    this.hasEndInput = true;
                    this.endInput_ = str;
                    return this;
                }

                public end_button_info setShowPoint(Point point) {
                    if (point == null) {
                        return clearShowPoint();
                    }
                    this.hasShowPoint = true;
                    this.showPoint_ = point;
                    return this;
                }

                public end_button_info setUid(String str) {
                    this.hasUid = true;
                    this.uid_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasBtnTitle()) {
                        codedOutputStreamMicro.writeString(1, getBtnTitle());
                    }
                    if (hasEndInput()) {
                        codedOutputStreamMicro.writeString(2, getEndInput());
                    }
                    if (hasShowPoint()) {
                        codedOutputStreamMicro.writeMessage(3, getShowPoint());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(4, getUid());
                    }
                    if (hasCname()) {
                        codedOutputStreamMicro.writeString(5, getCname());
                    }
                    if (hasCityid()) {
                        codedOutputStreamMicro.writeInt32(6, getCityid());
                    }
                    if (hasBorderColor()) {
                        codedOutputStreamMicro.writeInt32(7, getBorderColor());
                    }
                    if (hasBackgroundColor()) {
                        codedOutputStreamMicro.writeInt32(8, getBackgroundColor());
                    }
                }

                public static end_button_info parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (end_button_info) new end_button_info().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class explain_bubble_t extends MessageMicro {
                public static final int CONTENT_FIELD_NUMBER = 3;
                public static final int POINT_FIELD_NUMBER = 2;
                public static final int SUB_CONTENT_FIELD_NUMBER = 4;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasContent;
                private boolean hasPoint;
                private boolean hasSubContent;
                private boolean hasType;
                private int type_ = 0;
                private Point point_ = null;
                private String content_ = "";
                private String subContent_ = "";
                private int cachedSize = -1;

                public static explain_bubble_t parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new explain_bubble_t().mergeFrom(codedInputStreamMicro);
                }

                public final explain_bubble_t clear() {
                    clearType();
                    clearPoint();
                    clearContent();
                    clearSubContent();
                    this.cachedSize = -1;
                    return this;
                }

                public explain_bubble_t clearContent() {
                    this.hasContent = false;
                    this.content_ = "";
                    return this;
                }

                public explain_bubble_t clearPoint() {
                    this.hasPoint = false;
                    this.point_ = null;
                    return this;
                }

                public explain_bubble_t clearSubContent() {
                    this.hasSubContent = false;
                    this.subContent_ = "";
                    return this;
                }

                public explain_bubble_t clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getContent() {
                    return this.content_;
                }

                public Point getPoint() {
                    return this.point_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
                    if (hasPoint()) {
                        computeInt32Size += CodedOutputStreamMicro.computeMessageSize(2, getPoint());
                    }
                    if (hasContent()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getContent());
                    }
                    if (hasSubContent()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getSubContent());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public String getSubContent() {
                    return this.subContent_;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasContent() {
                    return this.hasContent;
                }

                public boolean hasPoint() {
                    return this.hasPoint;
                }

                public boolean hasSubContent() {
                    return this.hasSubContent;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return !hasPoint() || getPoint().isInitialized();
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public explain_bubble_t mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setType(codedInputStreamMicro.readInt32());
                        } else if (readTag == 18) {
                            Point point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setPoint(point);
                        } else if (readTag == 26) {
                            setContent(codedInputStreamMicro.readString());
                        } else if (readTag == 34) {
                            setSubContent(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public explain_bubble_t setContent(String str) {
                    this.hasContent = true;
                    this.content_ = str;
                    return this;
                }

                public explain_bubble_t setPoint(Point point) {
                    if (point == null) {
                        return clearPoint();
                    }
                    this.hasPoint = true;
                    this.point_ = point;
                    return this;
                }

                public explain_bubble_t setSubContent(String str) {
                    this.hasSubContent = true;
                    this.subContent_ = str;
                    return this;
                }

                public explain_bubble_t setType(int i) {
                    this.hasType = true;
                    this.type_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (hasPoint()) {
                        codedOutputStreamMicro.writeMessage(2, getPoint());
                    }
                    if (hasContent()) {
                        codedOutputStreamMicro.writeString(3, getContent());
                    }
                    if (hasSubContent()) {
                        codedOutputStreamMicro.writeString(4, getSubContent());
                    }
                }

                public static explain_bubble_t parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (explain_bubble_t) new explain_bubble_t().mergeFrom(bArr);
                }
            }

            public static YellowTipsList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new YellowTipsList().mergeFrom(codedInputStreamMicro);
            }

            public YellowTipsList addYellowTipsInfo(YellowTipsInfo yellowTipsInfo) {
                if (yellowTipsInfo == null) {
                    return this;
                }
                if (this.yellowTipsInfo_.isEmpty()) {
                    this.yellowTipsInfo_ = new ArrayList();
                }
                this.yellowTipsInfo_.add(yellowTipsInfo);
                return this;
            }

            public final YellowTipsList clear() {
                clearYellowTipsInfo();
                clearMrsl();
                this.cachedSize = -1;
                return this;
            }

            public YellowTipsList clearMrsl() {
                this.hasMrsl = false;
                this.mrsl_ = "";
                return this;
            }

            public YellowTipsList clearYellowTipsInfo() {
                this.yellowTipsInfo_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getMrsl() {
                return this.mrsl_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                Iterator<YellowTipsInfo> it = getYellowTipsInfoList().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                }
                if (hasMrsl()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getMrsl());
                }
                this.cachedSize = i;
                return i;
            }

            public YellowTipsInfo getYellowTipsInfo(int i) {
                return this.yellowTipsInfo_.get(i);
            }

            public int getYellowTipsInfoCount() {
                return this.yellowTipsInfo_.size();
            }

            public List<YellowTipsInfo> getYellowTipsInfoList() {
                return this.yellowTipsInfo_;
            }

            public boolean hasMrsl() {
                return this.hasMrsl;
            }

            public final boolean isInitialized() {
                Iterator<YellowTipsInfo> it = getYellowTipsInfoList().iterator();
                while (it.hasNext()) {
                    if (!it.next().isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public YellowTipsList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        YellowTipsInfo yellowTipsInfo = new YellowTipsInfo();
                        codedInputStreamMicro.readMessage(yellowTipsInfo);
                        addYellowTipsInfo(yellowTipsInfo);
                    } else if (readTag == 18) {
                        setMrsl(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public YellowTipsList setMrsl(String str) {
                this.hasMrsl = true;
                this.mrsl_ = str;
                return this;
            }

            public YellowTipsList setYellowTipsInfo(int i, YellowTipsInfo yellowTipsInfo) {
                if (yellowTipsInfo == null) {
                    return this;
                }
                this.yellowTipsInfo_.set(i, yellowTipsInfo);
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<YellowTipsInfo> it = getYellowTipsInfoList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(1, it.next());
                }
                if (hasMrsl()) {
                    codedOutputStreamMicro.writeString(2, getMrsl());
                }
            }

            public static YellowTipsList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (YellowTipsList) new YellowTipsList().mergeFrom(bArr);
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public Content addAcciInfos(AcciInfos acciInfos) {
            if (acciInfos == null) {
                return this;
            }
            if (this.acciInfos_.isEmpty()) {
                this.acciInfos_ = new ArrayList();
            }
            this.acciInfos_.add(acciInfos);
            return this;
        }

        public Content addAvoidCarRules(String str) {
            str.getClass();
            if (this.avoidCarRules_.isEmpty()) {
                this.avoidCarRules_ = new ArrayList();
            }
            this.avoidCarRules_.add(str);
            return this;
        }

        public Content addLongDistanceInfo(LongDistanceInfo longDistanceInfo) {
            if (longDistanceInfo == null) {
                return this;
            }
            if (this.longDistanceInfo_.isEmpty()) {
                this.longDistanceInfo_ = new ArrayList();
            }
            this.longDistanceInfo_.add(longDistanceInfo);
            return this;
        }

        public Content addRoutes(Routes routes) {
            if (routes == null) {
                return this;
            }
            if (this.routes_.isEmpty()) {
                this.routes_ = new ArrayList();
            }
            this.routes_.add(routes);
            return this;
        }

        public Content addSteps(Steps steps) {
            if (steps == null) {
                return this;
            }
            if (this.steps_.isEmpty()) {
                this.steps_ = new ArrayList();
            }
            this.steps_.add(steps);
            return this;
        }

        public Content addStepts(Stepts stepts) {
            if (stepts == null) {
                return this;
            }
            if (this.stepts_.isEmpty()) {
                this.stepts_ = new ArrayList();
            }
            this.stepts_.add(stepts);
            return this;
        }

        public Content addTaxis(Taxis taxis) {
            if (taxis == null) {
                return this;
            }
            if (this.taxis_.isEmpty()) {
                this.taxis_ = new ArrayList();
            }
            this.taxis_.add(taxis);
            return this;
        }

        public Content addTraffics(Traffics traffics) {
            if (traffics == null) {
                return this;
            }
            if (this.traffics_.isEmpty()) {
                this.traffics_ = new ArrayList();
            }
            this.traffics_.add(traffics);
            return this;
        }

        public Content addYellowTipsList(YellowTipsList yellowTipsList) {
            if (yellowTipsList == null) {
                return this;
            }
            if (this.yellowTipsList_.isEmpty()) {
                this.yellowTipsList_ = new ArrayList();
            }
            this.yellowTipsList_.add(yellowTipsList);
            return this;
        }

        public final Content clear() {
            clearRoutes();
            clearSteps();
            clearStepts();
            clearTaxis();
            clearTraffics();
            clearAcciInfos();
            clearRouteStatus();
            clearLocalInfoTips();
            clearSessionid();
            clearWalkinf();
            clearLongDistanceInfo();
            clearYellowTipsList();
            clearHeatEffectiveCityFlag();
            clearAvoidCarRules();
            clearCripType();
            clearCommuterTitleDesc();
            clearAvoidJamPrefer();
            clearDynamicContent();
            this.cachedSize = -1;
            return this;
        }

        public Content clearAcciInfos() {
            this.acciInfos_ = Collections.emptyList();
            return this;
        }

        public Content clearAvoidCarRules() {
            this.avoidCarRules_ = Collections.emptyList();
            return this;
        }

        public Content clearAvoidJamPrefer() {
            this.hasAvoidJamPrefer = false;
            this.avoidJamPrefer_ = null;
            return this;
        }

        public Content clearCommuterTitleDesc() {
            this.hasCommuterTitleDesc = false;
            this.commuterTitleDesc_ = "";
            return this;
        }

        public Content clearCripType() {
            this.hasCripType = false;
            this.cripType_ = 0;
            return this;
        }

        public Content clearDynamicContent() {
            this.hasDynamicContent = false;
            this.dynamicContent_ = ByteStringMicro.EMPTY;
            return this;
        }

        public Content clearHeatEffectiveCityFlag() {
            this.hasHeatEffectiveCityFlag = false;
            this.heatEffectiveCityFlag_ = 0;
            return this;
        }

        public Content clearLocalInfoTips() {
            this.hasLocalInfoTips = false;
            this.localInfoTips_ = "";
            return this;
        }

        public Content clearLongDistanceInfo() {
            this.longDistanceInfo_ = Collections.emptyList();
            return this;
        }

        public Content clearRouteStatus() {
            this.hasRouteStatus = false;
            this.routeStatus_ = 1;
            return this;
        }

        public Content clearRoutes() {
            this.routes_ = Collections.emptyList();
            return this;
        }

        public Content clearSessionid() {
            this.hasSessionid = false;
            this.sessionid_ = "";
            return this;
        }

        public Content clearSteps() {
            this.steps_ = Collections.emptyList();
            return this;
        }

        public Content clearStepts() {
            this.stepts_ = Collections.emptyList();
            return this;
        }

        public Content clearTaxis() {
            this.taxis_ = Collections.emptyList();
            return this;
        }

        public Content clearTraffics() {
            this.traffics_ = Collections.emptyList();
            return this;
        }

        public Content clearWalkinf() {
            this.hasWalkinf = false;
            this.walkinf_ = null;
            return this;
        }

        public Content clearYellowTipsList() {
            this.yellowTipsList_ = Collections.emptyList();
            return this;
        }

        public AcciInfos getAcciInfos(int i) {
            return this.acciInfos_.get(i);
        }

        public int getAcciInfosCount() {
            return this.acciInfos_.size();
        }

        public List<AcciInfos> getAcciInfosList() {
            return this.acciInfos_;
        }

        public String getAvoidCarRules(int i) {
            return this.avoidCarRules_.get(i);
        }

        public int getAvoidCarRulesCount() {
            return this.avoidCarRules_.size();
        }

        public List<String> getAvoidCarRulesList() {
            return this.avoidCarRules_;
        }

        public AvoidJamInfoPrefer getAvoidJamPrefer() {
            return this.avoidJamPrefer_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getCommuterTitleDesc() {
            return this.commuterTitleDesc_;
        }

        public int getCripType() {
            return this.cripType_;
        }

        public ByteStringMicro getDynamicContent() {
            return this.dynamicContent_;
        }

        public int getHeatEffectiveCityFlag() {
            return this.heatEffectiveCityFlag_;
        }

        public String getLocalInfoTips() {
            return this.localInfoTips_;
        }

        public LongDistanceInfo getLongDistanceInfo(int i) {
            return this.longDistanceInfo_.get(i);
        }

        public int getLongDistanceInfoCount() {
            return this.longDistanceInfo_.size();
        }

        public List<LongDistanceInfo> getLongDistanceInfoList() {
            return this.longDistanceInfo_;
        }

        public int getRouteStatus() {
            return this.routeStatus_;
        }

        public Routes getRoutes(int i) {
            return this.routes_.get(i);
        }

        public int getRoutesCount() {
            return this.routes_.size();
        }

        public List<Routes> getRoutesList() {
            return this.routes_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            Iterator<Routes> it = getRoutesList().iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(1, it.next());
            }
            Iterator<Steps> it2 = getStepsList().iterator();
            while (it2.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(2, it2.next());
            }
            Iterator<Stepts> it3 = getSteptsList().iterator();
            while (it3.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(3, it3.next());
            }
            Iterator<Taxis> it4 = getTaxisList().iterator();
            while (it4.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, it4.next());
            }
            Iterator<Traffics> it5 = getTrafficsList().iterator();
            while (it5.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, it5.next());
            }
            Iterator<AcciInfos> it6 = getAcciInfosList().iterator();
            while (it6.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, it6.next());
            }
            if (hasRouteStatus()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(7, getRouteStatus());
            }
            if (hasLocalInfoTips()) {
                i2 += CodedOutputStreamMicro.computeStringSize(8, getLocalInfoTips());
            }
            if (hasSessionid()) {
                i2 += CodedOutputStreamMicro.computeStringSize(9, getSessionid());
            }
            if (hasWalkinf()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, getWalkinf());
            }
            Iterator<LongDistanceInfo> it7 = getLongDistanceInfoList().iterator();
            while (it7.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(11, it7.next());
            }
            Iterator<YellowTipsList> it8 = getYellowTipsListList().iterator();
            while (it8.hasNext()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(12, it8.next());
            }
            if (hasHeatEffectiveCityFlag()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(13, getHeatEffectiveCityFlag());
            }
            Iterator<String> it9 = getAvoidCarRulesList().iterator();
            while (it9.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it9.next());
            }
            int size = i2 + i + getAvoidCarRulesList().size();
            if (hasCripType()) {
                size += CodedOutputStreamMicro.computeInt32Size(15, getCripType());
            }
            if (hasCommuterTitleDesc()) {
                size += CodedOutputStreamMicro.computeStringSize(16, getCommuterTitleDesc());
            }
            if (hasAvoidJamPrefer()) {
                size += CodedOutputStreamMicro.computeMessageSize(17, getAvoidJamPrefer());
            }
            if (hasDynamicContent()) {
                size += CodedOutputStreamMicro.computeBytesSize(18, getDynamicContent());
            }
            this.cachedSize = size;
            return size;
        }

        public String getSessionid() {
            return this.sessionid_;
        }

        public Steps getSteps(int i) {
            return this.steps_.get(i);
        }

        public int getStepsCount() {
            return this.steps_.size();
        }

        public List<Steps> getStepsList() {
            return this.steps_;
        }

        public Stepts getStepts(int i) {
            return this.stepts_.get(i);
        }

        public int getSteptsCount() {
            return this.stepts_.size();
        }

        public List<Stepts> getSteptsList() {
            return this.stepts_;
        }

        public Taxis getTaxis(int i) {
            return this.taxis_.get(i);
        }

        public int getTaxisCount() {
            return this.taxis_.size();
        }

        public List<Taxis> getTaxisList() {
            return this.taxis_;
        }

        public Traffics getTraffics(int i) {
            return this.traffics_.get(i);
        }

        public int getTrafficsCount() {
            return this.traffics_.size();
        }

        public List<Traffics> getTrafficsList() {
            return this.traffics_;
        }

        public WalkInfoT getWalkinf() {
            return this.walkinf_;
        }

        public YellowTipsList getYellowTipsList(int i) {
            return this.yellowTipsList_.get(i);
        }

        public int getYellowTipsListCount() {
            return this.yellowTipsList_.size();
        }

        public List<YellowTipsList> getYellowTipsListList() {
            return this.yellowTipsList_;
        }

        public boolean hasAvoidJamPrefer() {
            return this.hasAvoidJamPrefer;
        }

        public boolean hasCommuterTitleDesc() {
            return this.hasCommuterTitleDesc;
        }

        public boolean hasCripType() {
            return this.hasCripType;
        }

        public boolean hasDynamicContent() {
            return this.hasDynamicContent;
        }

        public boolean hasHeatEffectiveCityFlag() {
            return this.hasHeatEffectiveCityFlag;
        }

        public boolean hasLocalInfoTips() {
            return this.hasLocalInfoTips;
        }

        public boolean hasRouteStatus() {
            return this.hasRouteStatus;
        }

        public boolean hasSessionid() {
            return this.hasSessionid;
        }

        public boolean hasWalkinf() {
            return this.hasWalkinf;
        }

        public final boolean isInitialized() {
            Iterator<Routes> it = getRoutesList().iterator();
            while (it.hasNext()) {
                if (!it.next().isInitialized()) {
                    return false;
                }
            }
            if (hasWalkinf() && !getWalkinf().isInitialized()) {
                return false;
            }
            Iterator<LongDistanceInfo> it2 = getLongDistanceInfoList().iterator();
            while (it2.hasNext()) {
                if (!it2.next().isInitialized()) {
                    return false;
                }
            }
            Iterator<YellowTipsList> it3 = getYellowTipsListList().iterator();
            while (it3.hasNext()) {
                if (!it3.next().isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        Routes routes = new Routes();
                        codedInputStreamMicro.readMessage(routes);
                        addRoutes(routes);
                        break;
                    case 18:
                        Steps steps = new Steps();
                        codedInputStreamMicro.readMessage(steps);
                        addSteps(steps);
                        break;
                    case 26:
                        Stepts stepts = new Stepts();
                        codedInputStreamMicro.readMessage(stepts);
                        addStepts(stepts);
                        break;
                    case 34:
                        Taxis taxis = new Taxis();
                        codedInputStreamMicro.readMessage(taxis);
                        addTaxis(taxis);
                        break;
                    case 42:
                        Traffics traffics = new Traffics();
                        codedInputStreamMicro.readMessage(traffics);
                        addTraffics(traffics);
                        break;
                    case 50:
                        AcciInfos acciInfos = new AcciInfos();
                        codedInputStreamMicro.readMessage(acciInfos);
                        addAcciInfos(acciInfos);
                        break;
                    case 56:
                        setRouteStatus(codedInputStreamMicro.readInt32());
                        break;
                    case 66:
                        setLocalInfoTips(codedInputStreamMicro.readString());
                        break;
                    case 74:
                        setSessionid(codedInputStreamMicro.readString());
                        break;
                    case 82:
                        WalkInfoT walkInfoT = new WalkInfoT();
                        codedInputStreamMicro.readMessage(walkInfoT);
                        setWalkinf(walkInfoT);
                        break;
                    case 90:
                        LongDistanceInfo longDistanceInfo = new LongDistanceInfo();
                        codedInputStreamMicro.readMessage(longDistanceInfo);
                        addLongDistanceInfo(longDistanceInfo);
                        break;
                    case 98:
                        YellowTipsList yellowTipsList = new YellowTipsList();
                        codedInputStreamMicro.readMessage(yellowTipsList);
                        addYellowTipsList(yellowTipsList);
                        break;
                    case 104:
                        setHeatEffectiveCityFlag(codedInputStreamMicro.readInt32());
                        break;
                    case 114:
                        addAvoidCarRules(codedInputStreamMicro.readString());
                        break;
                    case 120:
                        setCripType(codedInputStreamMicro.readInt32());
                        break;
                    case 130:
                        setCommuterTitleDesc(codedInputStreamMicro.readString());
                        break;
                    case 138:
                        AvoidJamInfoPrefer avoidJamInfoPrefer = new AvoidJamInfoPrefer();
                        codedInputStreamMicro.readMessage(avoidJamInfoPrefer);
                        setAvoidJamPrefer(avoidJamInfoPrefer);
                        break;
                    case 146:
                        setDynamicContent(codedInputStreamMicro.readBytes());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public Content setAcciInfos(int i, AcciInfos acciInfos) {
            if (acciInfos == null) {
                return this;
            }
            this.acciInfos_.set(i, acciInfos);
            return this;
        }

        public Content setAvoidCarRules(int i, String str) {
            str.getClass();
            this.avoidCarRules_.set(i, str);
            return this;
        }

        public Content setAvoidJamPrefer(AvoidJamInfoPrefer avoidJamInfoPrefer) {
            if (avoidJamInfoPrefer == null) {
                return clearAvoidJamPrefer();
            }
            this.hasAvoidJamPrefer = true;
            this.avoidJamPrefer_ = avoidJamInfoPrefer;
            return this;
        }

        public Content setCommuterTitleDesc(String str) {
            this.hasCommuterTitleDesc = true;
            this.commuterTitleDesc_ = str;
            return this;
        }

        public Content setCripType(int i) {
            this.hasCripType = true;
            this.cripType_ = i;
            return this;
        }

        public Content setDynamicContent(ByteStringMicro byteStringMicro) {
            this.hasDynamicContent = true;
            this.dynamicContent_ = byteStringMicro;
            return this;
        }

        public Content setHeatEffectiveCityFlag(int i) {
            this.hasHeatEffectiveCityFlag = true;
            this.heatEffectiveCityFlag_ = i;
            return this;
        }

        public Content setLocalInfoTips(String str) {
            this.hasLocalInfoTips = true;
            this.localInfoTips_ = str;
            return this;
        }

        public Content setLongDistanceInfo(int i, LongDistanceInfo longDistanceInfo) {
            if (longDistanceInfo == null) {
                return this;
            }
            this.longDistanceInfo_.set(i, longDistanceInfo);
            return this;
        }

        public Content setRouteStatus(int i) {
            this.hasRouteStatus = true;
            this.routeStatus_ = i;
            return this;
        }

        public Content setRoutes(int i, Routes routes) {
            if (routes == null) {
                return this;
            }
            this.routes_.set(i, routes);
            return this;
        }

        public Content setSessionid(String str) {
            this.hasSessionid = true;
            this.sessionid_ = str;
            return this;
        }

        public Content setSteps(int i, Steps steps) {
            if (steps == null) {
                return this;
            }
            this.steps_.set(i, steps);
            return this;
        }

        public Content setStepts(int i, Stepts stepts) {
            if (stepts == null) {
                return this;
            }
            this.stepts_.set(i, stepts);
            return this;
        }

        public Content setTaxis(int i, Taxis taxis) {
            if (taxis == null) {
                return this;
            }
            this.taxis_.set(i, taxis);
            return this;
        }

        public Content setTraffics(int i, Traffics traffics) {
            if (traffics == null) {
                return this;
            }
            this.traffics_.set(i, traffics);
            return this;
        }

        public Content setWalkinf(WalkInfoT walkInfoT) {
            if (walkInfoT == null) {
                return clearWalkinf();
            }
            this.hasWalkinf = true;
            this.walkinf_ = walkInfoT;
            return this;
        }

        public Content setYellowTipsList(int i, YellowTipsList yellowTipsList) {
            if (yellowTipsList == null) {
                return this;
            }
            this.yellowTipsList_.set(i, yellowTipsList);
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            Iterator<Routes> it = getRoutesList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(1, it.next());
            }
            Iterator<Steps> it2 = getStepsList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeMessage(2, it2.next());
            }
            Iterator<Stepts> it3 = getSteptsList().iterator();
            while (it3.hasNext()) {
                codedOutputStreamMicro.writeMessage(3, it3.next());
            }
            Iterator<Taxis> it4 = getTaxisList().iterator();
            while (it4.hasNext()) {
                codedOutputStreamMicro.writeMessage(4, it4.next());
            }
            Iterator<Traffics> it5 = getTrafficsList().iterator();
            while (it5.hasNext()) {
                codedOutputStreamMicro.writeMessage(5, it5.next());
            }
            Iterator<AcciInfos> it6 = getAcciInfosList().iterator();
            while (it6.hasNext()) {
                codedOutputStreamMicro.writeMessage(6, it6.next());
            }
            if (hasRouteStatus()) {
                codedOutputStreamMicro.writeInt32(7, getRouteStatus());
            }
            if (hasLocalInfoTips()) {
                codedOutputStreamMicro.writeString(8, getLocalInfoTips());
            }
            if (hasSessionid()) {
                codedOutputStreamMicro.writeString(9, getSessionid());
            }
            if (hasWalkinf()) {
                codedOutputStreamMicro.writeMessage(10, getWalkinf());
            }
            Iterator<LongDistanceInfo> it7 = getLongDistanceInfoList().iterator();
            while (it7.hasNext()) {
                codedOutputStreamMicro.writeMessage(11, it7.next());
            }
            Iterator<YellowTipsList> it8 = getYellowTipsListList().iterator();
            while (it8.hasNext()) {
                codedOutputStreamMicro.writeMessage(12, it8.next());
            }
            if (hasHeatEffectiveCityFlag()) {
                codedOutputStreamMicro.writeInt32(13, getHeatEffectiveCityFlag());
            }
            Iterator<String> it9 = getAvoidCarRulesList().iterator();
            while (it9.hasNext()) {
                codedOutputStreamMicro.writeString(14, it9.next());
            }
            if (hasCripType()) {
                codedOutputStreamMicro.writeInt32(15, getCripType());
            }
            if (hasCommuterTitleDesc()) {
                codedOutputStreamMicro.writeString(16, getCommuterTitleDesc());
            }
            if (hasAvoidJamPrefer()) {
                codedOutputStreamMicro.writeMessage(17, getAvoidJamPrefer());
            }
            if (hasDynamicContent()) {
                codedOutputStreamMicro.writeBytes(18, getDynamicContent());
            }
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Option extends MessageMicro {
        public static final int AVOID_JAM_FIELD_NUMBER = 1;
        public static final int END_BID_FIELD_NUMBER = 15;
        public static final int END_FIELD_NUMBER = 6;
        public static final int END_NAME_FIELD_NUMBER = 4;
        public static final int FUTURE_ROUTEETA_INFO_FIELD_NUMBER = 16;
        public static final int IS_LONG_DISTANCE_FIELD_NUMBER = 12;
        public static final int IS_RC_PREDICATION_FIELD_NUMBER = 17;
        public static final int LOCAL_INFO_URL_FIELD_NUMBER = 11;
        public static final int NAVI_TYPE_FIELD_NUMBER = 13;
        public static final int PREFER_FIELD_NUMBER = 8;
        public static final int ROUTE_PLAN_NET_MODE_FIELD_NUMBER = 10;
        public static final int Route_Plan_Net_Mode_Offline = 1;
        public static final int Route_Plan_Net_Mode_Offline2Online = 3;
        public static final int Route_Plan_Net_Mode_Online = 0;
        public static final int Route_Plan_Net_Mode_Online2Offline = 2;
        public static final int START_BID_FIELD_NUMBER = 14;
        public static final int START_FIELD_NUMBER = 5;
        public static final int START_NAME_FIELD_NUMBER = 3;
        public static final int STRONG_WEAK_FLAG_FIELD_NUMBER = 18;
        public static final int SY_FIELD_NUMBER = 7;
        public static final int TOTAL_FIELD_NUMBER = 2;
        public static final int VIA_NAME_FIELD_NUMBER = 9;
        private boolean hasAvoidJam;
        private boolean hasEndName;
        private boolean hasIsLongDistance;
        private boolean hasIsRcPredication;
        private boolean hasLocalInfoUrl;
        private boolean hasNaviType;
        private boolean hasPrefer;
        private boolean hasRoutePlanNetMode;
        private boolean hasStart;
        private boolean hasStartBid;
        private boolean hasStartName;
        private boolean hasStrongWeakFlag;
        private boolean hasSy;
        private boolean hasTotal;
        private int avoidJam_ = 0;
        private int total_ = 0;
        private String startName_ = "";
        private String endName_ = "";
        private Start start_ = null;
        private List<End> end_ = Collections.emptyList();
        private int sy_ = 0;
        private int prefer_ = 0;
        private List<String> viaName_ = Collections.emptyList();
        private int routePlanNetMode_ = 0;
        private LocalInfoUrl localInfoUrl_ = null;
        private int isLongDistance_ = 0;
        private int naviType_ = 0;
        private String startBid_ = "";
        private List<String> endBid_ = Collections.emptyList();
        private List<FutureRouteEtaInfo> futureRouteetaInfo_ = Collections.emptyList();
        private int isRcPredication_ = 0;
        private int strongWeakFlag_ = 0;
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class End extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 11;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int BWANDA_FIELD_NUMBER = 6;
            public static final int CITYID_FIELD_NUMBER = 7;
            public static final int CITYNAME_FIELD_NUMBER = 8;
            public static final int DIRECTION_FIELD_NUMBER = 13;
            public static final int DIST_FIELD_NUMBER = 12;
            public static final int ICON_TYPE_FIELD_NUMBER = 14;
            public static final int IMAGE_URL_FIELD_NUMBER = 10;
            public static final int NEW_CATALOGID_FIELD_NUMBER = 9;
            public static final int ORIGIN_IDX_FIELD_NUMBER = 15;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 2;
            public static final int WD_FIELD_NUMBER = 3;
            private boolean hasAddr;
            private boolean hasBusStop;
            private boolean hasBwanda;
            private boolean hasCityid;
            private boolean hasCityname;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasIconType;
            private boolean hasImageUrl;
            private boolean hasNewCatalogid;
            private boolean hasOriginIdx;
            private boolean hasPt;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String uid_ = "";
            private String wd_ = "";
            private int busStop_ = 0;
            private List<Integer> spt_ = Collections.emptyList();
            private int bwanda_ = 0;
            private int cityid_ = 0;
            private String cityname_ = "";
            private int newCatalogid_ = 0;
            private ByteStringMicro imageUrl_ = ByteStringMicro.EMPTY;
            private String addr_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private int iconType_ = 0;
            private int originIdx_ = 0;
            private int cachedSize = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public End addSpt(int i) {
                if (this.spt_.isEmpty()) {
                    this.spt_ = new ArrayList();
                }
                this.spt_.add(Integer.valueOf(i));
                return this;
            }

            public final End clear() {
                clearPt();
                clearUid();
                clearWd();
                clearBusStop();
                clearSpt();
                clearBwanda();
                clearCityid();
                clearCityname();
                clearNewCatalogid();
                clearImageUrl();
                clearAddr();
                clearDist();
                clearDirection();
                clearIconType();
                clearOriginIdx();
                this.cachedSize = -1;
                return this;
            }

            public End clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public End clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = 0;
                return this;
            }

            public End clearBwanda() {
                this.hasBwanda = false;
                this.bwanda_ = 0;
                return this;
            }

            public End clearCityid() {
                this.hasCityid = false;
                this.cityid_ = 0;
                return this;
            }

            public End clearCityname() {
                this.hasCityname = false;
                this.cityname_ = "";
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

            public End clearIconType() {
                this.hasIconType = false;
                this.iconType_ = 0;
                return this;
            }

            public End clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = ByteStringMicro.EMPTY;
                return this;
            }

            public End clearNewCatalogid() {
                this.hasNewCatalogid = false;
                this.newCatalogid_ = 0;
                return this;
            }

            public End clearOriginIdx() {
                this.hasOriginIdx = false;
                this.originIdx_ = 0;
                return this;
            }

            public End clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public End clearSpt() {
                this.spt_ = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public End clearWd() {
                this.hasWd = false;
                this.wd_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
            }

            public int getBusStop() {
                return this.busStop_;
            }

            public int getBwanda() {
                return this.bwanda_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCityid() {
                return this.cityid_;
            }

            public String getCityname() {
                return this.cityname_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public int getIconType() {
                return this.iconType_;
            }

            public ByteStringMicro getImageUrl() {
                return this.imageUrl_;
            }

            public int getNewCatalogid() {
                return this.newCatalogid_;
            }

            public int getOriginIdx() {
                return this.originIdx_;
            }

            public String getPt() {
                return this.pt_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) : 0;
                if (hasUid()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getWd());
                }
                if (hasBusStop()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = computeStringSize + i + getSptList().size();
                if (hasBwanda()) {
                    size += CodedOutputStreamMicro.computeInt32Size(6, getBwanda());
                }
                if (hasCityid()) {
                    size += CodedOutputStreamMicro.computeInt32Size(7, getCityid());
                }
                if (hasCityname()) {
                    size += CodedOutputStreamMicro.computeStringSize(8, getCityname());
                }
                if (hasNewCatalogid()) {
                    size += CodedOutputStreamMicro.computeInt32Size(9, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    size += CodedOutputStreamMicro.computeBytesSize(10, getImageUrl());
                }
                if (hasAddr()) {
                    size += CodedOutputStreamMicro.computeStringSize(11, getAddr());
                }
                if (hasDist()) {
                    size += CodedOutputStreamMicro.computeInt32Size(12, getDist());
                }
                if (hasDirection()) {
                    size += CodedOutputStreamMicro.computeInt32Size(13, getDirection());
                }
                if (hasIconType()) {
                    size += CodedOutputStreamMicro.computeInt32Size(14, getIconType());
                }
                if (hasOriginIdx()) {
                    size += CodedOutputStreamMicro.computeInt32Size(15, getOriginIdx());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpt(int i) {
                return this.spt_.get(i).intValue();
            }

            public int getSptCount() {
                return this.spt_.size();
            }

            public List<Integer> getSptList() {
                return this.spt_;
            }

            public String getUid() {
                return this.uid_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasBwanda() {
                return this.hasBwanda;
            }

            public boolean hasCityid() {
                return this.hasCityid;
            }

            public boolean hasCityname() {
                return this.hasCityname;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasIconType() {
                return this.hasIconType;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasNewCatalogid() {
                return this.hasNewCatalogid;
            }

            public boolean hasOriginIdx() {
                return this.hasOriginIdx;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public boolean hasWd() {
                return this.hasWd;
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
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            setUid(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            setWd(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            setBusStop(codedInputStreamMicro.readInt32());
                            break;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
                            break;
                        case 48:
                            setBwanda(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            setCityid(codedInputStreamMicro.readInt32());
                            break;
                        case 66:
                            setCityname(codedInputStreamMicro.readString());
                            break;
                        case 72:
                            setNewCatalogid(codedInputStreamMicro.readInt32());
                            break;
                        case 82:
                            setImageUrl(codedInputStreamMicro.readBytes());
                            break;
                        case 90:
                            setAddr(codedInputStreamMicro.readString());
                            break;
                        case 96:
                            setDist(codedInputStreamMicro.readInt32());
                            break;
                        case 104:
                            setDirection(codedInputStreamMicro.readInt32());
                            break;
                        case 112:
                            setIconType(codedInputStreamMicro.readInt32());
                            break;
                        case 120:
                            setOriginIdx(codedInputStreamMicro.readInt32());
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

            public End setBusStop(int i) {
                this.hasBusStop = true;
                this.busStop_ = i;
                return this;
            }

            public End setBwanda(int i) {
                this.hasBwanda = true;
                this.bwanda_ = i;
                return this;
            }

            public End setCityid(int i) {
                this.hasCityid = true;
                this.cityid_ = i;
                return this;
            }

            public End setCityname(String str) {
                this.hasCityname = true;
                this.cityname_ = str;
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

            public End setIconType(int i) {
                this.hasIconType = true;
                this.iconType_ = i;
                return this;
            }

            public End setImageUrl(ByteStringMicro byteStringMicro) {
                this.hasImageUrl = true;
                this.imageUrl_ = byteStringMicro;
                return this;
            }

            public End setNewCatalogid(int i) {
                this.hasNewCatalogid = true;
                this.newCatalogid_ = i;
                return this;
            }

            public End setOriginIdx(int i) {
                this.hasOriginIdx = true;
                this.originIdx_ = i;
                return this;
            }

            public End setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public End setSpt(int i, int i2) {
                this.spt_.set(i, Integer.valueOf(i2));
                return this;
            }

            public End setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            public End setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(3, getWd());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeInt32(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(5, it.next().intValue());
                }
                if (hasBwanda()) {
                    codedOutputStreamMicro.writeInt32(6, getBwanda());
                }
                if (hasCityid()) {
                    codedOutputStreamMicro.writeInt32(7, getCityid());
                }
                if (hasCityname()) {
                    codedOutputStreamMicro.writeString(8, getCityname());
                }
                if (hasNewCatalogid()) {
                    codedOutputStreamMicro.writeInt32(9, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    codedOutputStreamMicro.writeBytes(10, getImageUrl());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(11, getAddr());
                }
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(12, getDist());
                }
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(13, getDirection());
                }
                if (hasIconType()) {
                    codedOutputStreamMicro.writeInt32(14, getIconType());
                }
                if (hasOriginIdx()) {
                    codedOutputStreamMicro.writeInt32(15, getOriginIdx());
                }
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class FutureRouteEtaInfo extends MessageMicro {
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int TIMESTAMP_FIELD_NUMBER = 1;
            private boolean hasDuration;
            private boolean hasTimestamp;
            private int timestamp_ = 0;
            private int duration_ = 0;
            private int cachedSize = -1;

            public static FutureRouteEtaInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new FutureRouteEtaInfo().mergeFrom(codedInputStreamMicro);
            }

            public final FutureRouteEtaInfo clear() {
                clearTimestamp();
                clearDuration();
                this.cachedSize = -1;
                return this;
            }

            public FutureRouteEtaInfo clearDuration() {
                this.hasDuration = false;
                this.duration_ = 0;
                return this;
            }

            public FutureRouteEtaInfo clearTimestamp() {
                this.hasTimestamp = false;
                this.timestamp_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getDuration() {
                return this.duration_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasTimestamp() ? CodedOutputStreamMicro.computeInt32Size(1, getTimestamp()) : 0;
                if (hasDuration()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public int getTimestamp() {
                return this.timestamp_;
            }

            public boolean hasDuration() {
                return this.hasDuration;
            }

            public boolean hasTimestamp() {
                return this.hasTimestamp;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public FutureRouteEtaInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setTimestamp(codedInputStreamMicro.readInt32());
                    } else if (readTag == 16) {
                        setDuration(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public FutureRouteEtaInfo setDuration(int i) {
                this.hasDuration = true;
                this.duration_ = i;
                return this;
            }

            public FutureRouteEtaInfo setTimestamp(int i) {
                this.hasTimestamp = true;
                this.timestamp_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTimestamp()) {
                    codedOutputStreamMicro.writeInt32(1, getTimestamp());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(2, getDuration());
                }
            }

            public static FutureRouteEtaInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (FutureRouteEtaInfo) new FutureRouteEtaInfo().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class LocalInfoUrl extends MessageMicro {
            public static final int URL_FIELD_NUMBER = 1;
            private boolean hasUrl;
            private String url_ = "";
            private int cachedSize = -1;

            public static LocalInfoUrl parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new LocalInfoUrl().mergeFrom(codedInputStreamMicro);
            }

            public final LocalInfoUrl clear() {
                clearUrl();
                this.cachedSize = -1;
                return this;
            }

            public LocalInfoUrl clearUrl() {
                this.hasUrl = false;
                this.url_ = "";
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
                int computeStringSize = hasUrl() ? CodedOutputStreamMicro.computeStringSize(1, getUrl()) : 0;
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getUrl() {
                return this.url_;
            }

            public boolean hasUrl() {
                return this.hasUrl;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public LocalInfoUrl mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setUrl(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public LocalInfoUrl setUrl(String str) {
                this.hasUrl = true;
                this.url_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUrl()) {
                    codedOutputStreamMicro.writeString(1, getUrl());
                }
            }

            public static LocalInfoUrl parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (LocalInfoUrl) new LocalInfoUrl().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Start extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 10;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int CITYID_FIELD_NUMBER = 6;
            public static final int CITYNAME_FIELD_NUMBER = 7;
            public static final int DIRECTION_FIELD_NUMBER = 12;
            public static final int DIST_FIELD_NUMBER = 11;
            public static final int IMAGE_URL_FIELD_NUMBER = 9;
            public static final int NEW_CATALOGID_FIELD_NUMBER = 8;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 2;
            public static final int WD_FIELD_NUMBER = 3;
            private boolean hasAddr;
            private boolean hasBusStop;
            private boolean hasCityid;
            private boolean hasCityname;
            private boolean hasDirection;
            private boolean hasDist;
            private boolean hasImageUrl;
            private boolean hasNewCatalogid;
            private boolean hasPt;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String uid_ = "";
            private String wd_ = "";
            private int busStop_ = 0;
            private List<Integer> spt_ = Collections.emptyList();
            private int cityid_ = 0;
            private String cityname_ = "";
            private int newCatalogid_ = 0;
            private ByteStringMicro imageUrl_ = ByteStringMicro.EMPTY;
            private String addr_ = "";
            private int dist_ = 0;
            private int direction_ = 0;
            private int cachedSize = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public Start addSpt(int i) {
                if (this.spt_.isEmpty()) {
                    this.spt_ = new ArrayList();
                }
                this.spt_.add(Integer.valueOf(i));
                return this;
            }

            public final Start clear() {
                clearPt();
                clearUid();
                clearWd();
                clearBusStop();
                clearSpt();
                clearCityid();
                clearCityname();
                clearNewCatalogid();
                clearImageUrl();
                clearAddr();
                clearDist();
                clearDirection();
                this.cachedSize = -1;
                return this;
            }

            public Start clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public Start clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = 0;
                return this;
            }

            public Start clearCityid() {
                this.hasCityid = false;
                this.cityid_ = 0;
                return this;
            }

            public Start clearCityname() {
                this.hasCityname = false;
                this.cityname_ = "";
                return this;
            }

            public Start clearDirection() {
                this.hasDirection = false;
                this.direction_ = 0;
                return this;
            }

            public Start clearDist() {
                this.hasDist = false;
                this.dist_ = 0;
                return this;
            }

            public Start clearImageUrl() {
                this.hasImageUrl = false;
                this.imageUrl_ = ByteStringMicro.EMPTY;
                return this;
            }

            public Start clearNewCatalogid() {
                this.hasNewCatalogid = false;
                this.newCatalogid_ = 0;
                return this;
            }

            public Start clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public Start clearSpt() {
                this.spt_ = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public Start clearWd() {
                this.hasWd = false;
                this.wd_ = "";
                return this;
            }

            public String getAddr() {
                return this.addr_;
            }

            public int getBusStop() {
                return this.busStop_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCityid() {
                return this.cityid_;
            }

            public String getCityname() {
                return this.cityname_;
            }

            public int getDirection() {
                return this.direction_;
            }

            public int getDist() {
                return this.dist_;
            }

            public ByteStringMicro getImageUrl() {
                return this.imageUrl_;
            }

            public int getNewCatalogid() {
                return this.newCatalogid_;
            }

            public String getPt() {
                return this.pt_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) : 0;
                if (hasUid()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getWd());
                }
                if (hasBusStop()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = computeStringSize + i + getSptList().size();
                if (hasCityid()) {
                    size += CodedOutputStreamMicro.computeInt32Size(6, getCityid());
                }
                if (hasCityname()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, getCityname());
                }
                if (hasNewCatalogid()) {
                    size += CodedOutputStreamMicro.computeInt32Size(8, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    size += CodedOutputStreamMicro.computeBytesSize(9, getImageUrl());
                }
                if (hasAddr()) {
                    size += CodedOutputStreamMicro.computeStringSize(10, getAddr());
                }
                if (hasDist()) {
                    size += CodedOutputStreamMicro.computeInt32Size(11, getDist());
                }
                if (hasDirection()) {
                    size += CodedOutputStreamMicro.computeInt32Size(12, getDirection());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpt(int i) {
                return this.spt_.get(i).intValue();
            }

            public int getSptCount() {
                return this.spt_.size();
            }

            public List<Integer> getSptList() {
                return this.spt_;
            }

            public String getUid() {
                return this.uid_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasCityid() {
                return this.hasCityid;
            }

            public boolean hasCityname() {
                return this.hasCityname;
            }

            public boolean hasDirection() {
                return this.hasDirection;
            }

            public boolean hasDist() {
                return this.hasDist;
            }

            public boolean hasImageUrl() {
                return this.hasImageUrl;
            }

            public boolean hasNewCatalogid() {
                return this.hasNewCatalogid;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public boolean hasWd() {
                return this.hasWd;
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
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            setUid(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            setWd(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            setBusStop(codedInputStreamMicro.readInt32());
                            break;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
                            break;
                        case 48:
                            setCityid(codedInputStreamMicro.readInt32());
                            break;
                        case 58:
                            setCityname(codedInputStreamMicro.readString());
                            break;
                        case 64:
                            setNewCatalogid(codedInputStreamMicro.readInt32());
                            break;
                        case 74:
                            setImageUrl(codedInputStreamMicro.readBytes());
                            break;
                        case 82:
                            setAddr(codedInputStreamMicro.readString());
                            break;
                        case 88:
                            setDist(codedInputStreamMicro.readInt32());
                            break;
                        case 96:
                            setDirection(codedInputStreamMicro.readInt32());
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

            public Start setBusStop(int i) {
                this.hasBusStop = true;
                this.busStop_ = i;
                return this;
            }

            public Start setCityid(int i) {
                this.hasCityid = true;
                this.cityid_ = i;
                return this;
            }

            public Start setCityname(String str) {
                this.hasCityname = true;
                this.cityname_ = str;
                return this;
            }

            public Start setDirection(int i) {
                this.hasDirection = true;
                this.direction_ = i;
                return this;
            }

            public Start setDist(int i) {
                this.hasDist = true;
                this.dist_ = i;
                return this;
            }

            public Start setImageUrl(ByteStringMicro byteStringMicro) {
                this.hasImageUrl = true;
                this.imageUrl_ = byteStringMicro;
                return this;
            }

            public Start setNewCatalogid(int i) {
                this.hasNewCatalogid = true;
                this.newCatalogid_ = i;
                return this;
            }

            public Start setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public Start setSpt(int i, int i2) {
                this.spt_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Start setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            public Start setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(3, getWd());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeInt32(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(5, it.next().intValue());
                }
                if (hasCityid()) {
                    codedOutputStreamMicro.writeInt32(6, getCityid());
                }
                if (hasCityname()) {
                    codedOutputStreamMicro.writeString(7, getCityname());
                }
                if (hasNewCatalogid()) {
                    codedOutputStreamMicro.writeInt32(8, getNewCatalogid());
                }
                if (hasImageUrl()) {
                    codedOutputStreamMicro.writeBytes(9, getImageUrl());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(10, getAddr());
                }
                if (hasDist()) {
                    codedOutputStreamMicro.writeInt32(11, getDist());
                }
                if (hasDirection()) {
                    codedOutputStreamMicro.writeInt32(12, getDirection());
                }
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public Option addEnd(End end) {
            if (end == null) {
                return this;
            }
            if (this.end_.isEmpty()) {
                this.end_ = new ArrayList();
            }
            this.end_.add(end);
            return this;
        }

        public Option addEndBid(String str) {
            str.getClass();
            if (this.endBid_.isEmpty()) {
                this.endBid_ = new ArrayList();
            }
            this.endBid_.add(str);
            return this;
        }

        public Option addFutureRouteetaInfo(FutureRouteEtaInfo futureRouteEtaInfo) {
            if (futureRouteEtaInfo == null) {
                return this;
            }
            if (this.futureRouteetaInfo_.isEmpty()) {
                this.futureRouteetaInfo_ = new ArrayList();
            }
            this.futureRouteetaInfo_.add(futureRouteEtaInfo);
            return this;
        }

        public Option addViaName(String str) {
            str.getClass();
            if (this.viaName_.isEmpty()) {
                this.viaName_ = new ArrayList();
            }
            this.viaName_.add(str);
            return this;
        }

        public final Option clear() {
            clearAvoidJam();
            clearTotal();
            clearStartName();
            clearEndName();
            clearStart();
            clearEnd();
            clearSy();
            clearPrefer();
            clearViaName();
            clearRoutePlanNetMode();
            clearLocalInfoUrl();
            clearIsLongDistance();
            clearNaviType();
            clearStartBid();
            clearEndBid();
            clearFutureRouteetaInfo();
            clearIsRcPredication();
            clearStrongWeakFlag();
            this.cachedSize = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.hasAvoidJam = false;
            this.avoidJam_ = 0;
            return this;
        }

        public Option clearEnd() {
            this.end_ = Collections.emptyList();
            return this;
        }

        public Option clearEndBid() {
            this.endBid_ = Collections.emptyList();
            return this;
        }

        public Option clearEndName() {
            this.hasEndName = false;
            this.endName_ = "";
            return this;
        }

        public Option clearFutureRouteetaInfo() {
            this.futureRouteetaInfo_ = Collections.emptyList();
            return this;
        }

        public Option clearIsLongDistance() {
            this.hasIsLongDistance = false;
            this.isLongDistance_ = 0;
            return this;
        }

        public Option clearIsRcPredication() {
            this.hasIsRcPredication = false;
            this.isRcPredication_ = 0;
            return this;
        }

        public Option clearLocalInfoUrl() {
            this.hasLocalInfoUrl = false;
            this.localInfoUrl_ = null;
            return this;
        }

        public Option clearNaviType() {
            this.hasNaviType = false;
            this.naviType_ = 0;
            return this;
        }

        public Option clearPrefer() {
            this.hasPrefer = false;
            this.prefer_ = 0;
            return this;
        }

        public Option clearRoutePlanNetMode() {
            this.hasRoutePlanNetMode = false;
            this.routePlanNetMode_ = 0;
            return this;
        }

        public Option clearStart() {
            this.hasStart = false;
            this.start_ = null;
            return this;
        }

        public Option clearStartBid() {
            this.hasStartBid = false;
            this.startBid_ = "";
            return this;
        }

        public Option clearStartName() {
            this.hasStartName = false;
            this.startName_ = "";
            return this;
        }

        public Option clearStrongWeakFlag() {
            this.hasStrongWeakFlag = false;
            this.strongWeakFlag_ = 0;
            return this;
        }

        public Option clearSy() {
            this.hasSy = false;
            this.sy_ = 0;
            return this;
        }

        public Option clearTotal() {
            this.hasTotal = false;
            this.total_ = 0;
            return this;
        }

        public Option clearViaName() {
            this.viaName_ = Collections.emptyList();
            return this;
        }

        public int getAvoidJam() {
            return this.avoidJam_;
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

        public String getEndBid(int i) {
            return this.endBid_.get(i);
        }

        public int getEndBidCount() {
            return this.endBid_.size();
        }

        public List<String> getEndBidList() {
            return this.endBid_;
        }

        public int getEndCount() {
            return this.end_.size();
        }

        public List<End> getEndList() {
            return this.end_;
        }

        public String getEndName() {
            return this.endName_;
        }

        public FutureRouteEtaInfo getFutureRouteetaInfo(int i) {
            return this.futureRouteetaInfo_.get(i);
        }

        public int getFutureRouteetaInfoCount() {
            return this.futureRouteetaInfo_.size();
        }

        public List<FutureRouteEtaInfo> getFutureRouteetaInfoList() {
            return this.futureRouteetaInfo_;
        }

        public int getIsLongDistance() {
            return this.isLongDistance_;
        }

        public int getIsRcPredication() {
            return this.isRcPredication_;
        }

        public LocalInfoUrl getLocalInfoUrl() {
            return this.localInfoUrl_;
        }

        public int getNaviType() {
            return this.naviType_;
        }

        public int getPrefer() {
            return this.prefer_;
        }

        public int getRoutePlanNetMode() {
            return this.routePlanNetMode_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasAvoidJam() ? CodedOutputStreamMicro.computeInt32Size(1, getAvoidJam()) : 0;
            if (hasTotal()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasStartName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getStartName());
            }
            if (hasEndName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getEndName());
            }
            if (hasStart()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(6, it.next());
            }
            if (hasSy()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getSy());
            }
            if (hasPrefer()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(8, getPrefer());
            }
            Iterator<String> it2 = getViaNameList().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                i2 += CodedOutputStreamMicro.computeStringSizeNoTag(it2.next());
            }
            int size = computeInt32Size + i2 + getViaNameList().size();
            if (hasRoutePlanNetMode()) {
                size += CodedOutputStreamMicro.computeInt32Size(10, getRoutePlanNetMode());
            }
            if (hasLocalInfoUrl()) {
                size += CodedOutputStreamMicro.computeMessageSize(11, getLocalInfoUrl());
            }
            if (hasIsLongDistance()) {
                size += CodedOutputStreamMicro.computeInt32Size(12, getIsLongDistance());
            }
            if (hasNaviType()) {
                size += CodedOutputStreamMicro.computeInt32Size(13, getNaviType());
            }
            if (hasStartBid()) {
                size += CodedOutputStreamMicro.computeStringSize(14, getStartBid());
            }
            Iterator<String> it3 = getEndBidList().iterator();
            while (it3.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it3.next());
            }
            int size2 = size + i + getEndBidList().size();
            Iterator<FutureRouteEtaInfo> it4 = getFutureRouteetaInfoList().iterator();
            while (it4.hasNext()) {
                size2 += CodedOutputStreamMicro.computeMessageSize(16, it4.next());
            }
            if (hasIsRcPredication()) {
                size2 += CodedOutputStreamMicro.computeInt32Size(17, getIsRcPredication());
            }
            if (hasStrongWeakFlag()) {
                size2 += CodedOutputStreamMicro.computeInt32Size(18, getStrongWeakFlag());
            }
            this.cachedSize = size2;
            return size2;
        }

        public Start getStart() {
            return this.start_;
        }

        public String getStartBid() {
            return this.startBid_;
        }

        public String getStartName() {
            return this.startName_;
        }

        public int getStrongWeakFlag() {
            return this.strongWeakFlag_;
        }

        public int getSy() {
            return this.sy_;
        }

        public int getTotal() {
            return this.total_;
        }

        public String getViaName(int i) {
            return this.viaName_.get(i);
        }

        public int getViaNameCount() {
            return this.viaName_.size();
        }

        public List<String> getViaNameList() {
            return this.viaName_;
        }

        public boolean hasAvoidJam() {
            return this.hasAvoidJam;
        }

        public boolean hasEndName() {
            return this.hasEndName;
        }

        public boolean hasIsLongDistance() {
            return this.hasIsLongDistance;
        }

        public boolean hasIsRcPredication() {
            return this.hasIsRcPredication;
        }

        public boolean hasLocalInfoUrl() {
            return this.hasLocalInfoUrl;
        }

        public boolean hasNaviType() {
            return this.hasNaviType;
        }

        public boolean hasPrefer() {
            return this.hasPrefer;
        }

        public boolean hasRoutePlanNetMode() {
            return this.hasRoutePlanNetMode;
        }

        public boolean hasStart() {
            return this.hasStart;
        }

        public boolean hasStartBid() {
            return this.hasStartBid;
        }

        public boolean hasStartName() {
            return this.hasStartName;
        }

        public boolean hasStrongWeakFlag() {
            return this.hasStrongWeakFlag;
        }

        public boolean hasSy() {
            return this.hasSy;
        }

        public boolean hasTotal() {
            return this.hasTotal;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        setAvoidJam(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        setTotal(codedInputStreamMicro.readInt32());
                        break;
                    case 26:
                        setStartName(codedInputStreamMicro.readString());
                        break;
                    case 34:
                        setEndName(codedInputStreamMicro.readString());
                        break;
                    case 42:
                        Start start = new Start();
                        codedInputStreamMicro.readMessage(start);
                        setStart(start);
                        break;
                    case 50:
                        End end = new End();
                        codedInputStreamMicro.readMessage(end);
                        addEnd(end);
                        break;
                    case 56:
                        setSy(codedInputStreamMicro.readInt32());
                        break;
                    case 64:
                        setPrefer(codedInputStreamMicro.readInt32());
                        break;
                    case 74:
                        addViaName(codedInputStreamMicro.readString());
                        break;
                    case 80:
                        setRoutePlanNetMode(codedInputStreamMicro.readInt32());
                        break;
                    case 90:
                        LocalInfoUrl localInfoUrl = new LocalInfoUrl();
                        codedInputStreamMicro.readMessage(localInfoUrl);
                        setLocalInfoUrl(localInfoUrl);
                        break;
                    case 96:
                        setIsLongDistance(codedInputStreamMicro.readInt32());
                        break;
                    case 104:
                        setNaviType(codedInputStreamMicro.readInt32());
                        break;
                    case 114:
                        setStartBid(codedInputStreamMicro.readString());
                        break;
                    case 122:
                        addEndBid(codedInputStreamMicro.readString());
                        break;
                    case 130:
                        FutureRouteEtaInfo futureRouteEtaInfo = new FutureRouteEtaInfo();
                        codedInputStreamMicro.readMessage(futureRouteEtaInfo);
                        addFutureRouteetaInfo(futureRouteEtaInfo);
                        break;
                    case 136:
                        setIsRcPredication(codedInputStreamMicro.readInt32());
                        break;
                    case 144:
                        setStrongWeakFlag(codedInputStreamMicro.readInt32());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public Option setAvoidJam(int i) {
            this.hasAvoidJam = true;
            this.avoidJam_ = i;
            return this;
        }

        public Option setEnd(int i, End end) {
            if (end == null) {
                return this;
            }
            this.end_.set(i, end);
            return this;
        }

        public Option setEndBid(int i, String str) {
            str.getClass();
            this.endBid_.set(i, str);
            return this;
        }

        public Option setEndName(String str) {
            this.hasEndName = true;
            this.endName_ = str;
            return this;
        }

        public Option setFutureRouteetaInfo(int i, FutureRouteEtaInfo futureRouteEtaInfo) {
            if (futureRouteEtaInfo == null) {
                return this;
            }
            this.futureRouteetaInfo_.set(i, futureRouteEtaInfo);
            return this;
        }

        public Option setIsLongDistance(int i) {
            this.hasIsLongDistance = true;
            this.isLongDistance_ = i;
            return this;
        }

        public Option setIsRcPredication(int i) {
            this.hasIsRcPredication = true;
            this.isRcPredication_ = i;
            return this;
        }

        public Option setLocalInfoUrl(LocalInfoUrl localInfoUrl) {
            if (localInfoUrl == null) {
                return clearLocalInfoUrl();
            }
            this.hasLocalInfoUrl = true;
            this.localInfoUrl_ = localInfoUrl;
            return this;
        }

        public Option setNaviType(int i) {
            this.hasNaviType = true;
            this.naviType_ = i;
            return this;
        }

        public Option setPrefer(int i) {
            this.hasPrefer = true;
            this.prefer_ = i;
            return this;
        }

        public Option setRoutePlanNetMode(int i) {
            this.hasRoutePlanNetMode = true;
            this.routePlanNetMode_ = i;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.hasStart = true;
            this.start_ = start;
            return this;
        }

        public Option setStartBid(String str) {
            this.hasStartBid = true;
            this.startBid_ = str;
            return this;
        }

        public Option setStartName(String str) {
            this.hasStartName = true;
            this.startName_ = str;
            return this;
        }

        public Option setStrongWeakFlag(int i) {
            this.hasStrongWeakFlag = true;
            this.strongWeakFlag_ = i;
            return this;
        }

        public Option setSy(int i) {
            this.hasSy = true;
            this.sy_ = i;
            return this;
        }

        public Option setTotal(int i) {
            this.hasTotal = true;
            this.total_ = i;
            return this;
        }

        public Option setViaName(int i, String str) {
            str.getClass();
            this.viaName_.set(i, str);
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAvoidJam()) {
                codedOutputStreamMicro.writeInt32(1, getAvoidJam());
            }
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasStartName()) {
                codedOutputStreamMicro.writeString(3, getStartName());
            }
            if (hasEndName()) {
                codedOutputStreamMicro.writeString(4, getEndName());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(5, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(6, it.next());
            }
            if (hasSy()) {
                codedOutputStreamMicro.writeInt32(7, getSy());
            }
            if (hasPrefer()) {
                codedOutputStreamMicro.writeInt32(8, getPrefer());
            }
            Iterator<String> it2 = getViaNameList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeString(9, it2.next());
            }
            if (hasRoutePlanNetMode()) {
                codedOutputStreamMicro.writeInt32(10, getRoutePlanNetMode());
            }
            if (hasLocalInfoUrl()) {
                codedOutputStreamMicro.writeMessage(11, getLocalInfoUrl());
            }
            if (hasIsLongDistance()) {
                codedOutputStreamMicro.writeInt32(12, getIsLongDistance());
            }
            if (hasNaviType()) {
                codedOutputStreamMicro.writeInt32(13, getNaviType());
            }
            if (hasStartBid()) {
                codedOutputStreamMicro.writeString(14, getStartBid());
            }
            Iterator<String> it3 = getEndBidList().iterator();
            while (it3.hasNext()) {
                codedOutputStreamMicro.writeString(15, it3.next());
            }
            Iterator<FutureRouteEtaInfo> it4 = getFutureRouteetaInfoList().iterator();
            while (it4.hasNext()) {
                codedOutputStreamMicro.writeMessage(16, it4.next());
            }
            if (hasIsRcPredication()) {
                codedOutputStreamMicro.writeInt32(17, getIsRcPredication());
            }
            if (hasStrongWeakFlag()) {
                codedOutputStreamMicro.writeInt32(18, getStrongWeakFlag());
            }
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }
    }

    public static Cars parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Cars().mergeFrom(codedInputStreamMicro);
    }

    public final Cars clear() {
        clearOption();
        clearContent();
        clearTest();
        this.cachedSize = -1;
        return this;
    }

    public Cars clearContent() {
        this.hasContent = false;
        this.content_ = null;
        return this;
    }

    public Cars clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public Cars clearTest() {
        this.hasTest = false;
        this.test_ = "";
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

    public Option getOption() {
        return this.option_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeMessageSize = hasOption() ? CodedOutputStreamMicro.computeMessageSize(1, getOption()) : 0;
        if (hasContent()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        if (hasTest()) {
            computeMessageSize += CodedOutputStreamMicro.computeStringSize(3, getTest());
        }
        this.cachedSize = computeMessageSize;
        return computeMessageSize;
    }

    public String getTest() {
        return this.test_;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasTest() {
        return this.hasTest;
    }

    public final boolean isInitialized() {
        return !hasContent() || getContent().isInitialized();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public Cars mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                Content content = new Content();
                codedInputStreamMicro.readMessage(content);
                setContent(content);
            } else if (readTag == 26) {
                setTest(codedInputStreamMicro.readString());
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public Cars setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.hasContent = true;
        this.content_ = content;
        return this;
    }

    public Cars setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public Cars setTest(String str) {
        this.hasTest = true;
        this.test_ = str;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
        if (hasTest()) {
            codedOutputStreamMicro.writeString(3, getTest());
        }
    }

    public static Cars parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Cars) new Cars().mergeFrom(bArr);
    }
}
