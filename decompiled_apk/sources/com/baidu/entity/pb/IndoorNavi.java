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
public final class IndoorNavi extends MessageMicro {
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int ROUTES_FIELD_NUMBER = 2;
    private boolean hasOption;
    private Option option_ = null;
    private List<Routes> routes_ = Collections.emptyList();
    private int cachedSize = -1;

    /* loaded from: classes7.dex */
    public static final class Option extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int TIPS_INFO_FIELD_NUMBER = 4;
        public static final int TOTAL_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 3;
        private boolean hasError;
        private boolean hasTotal;
        private boolean hasType;
        private int error_ = 0;
        private int total_ = 0;
        private int type_ = 0;
        private List<TipsInfo> tipsInfo_ = Collections.emptyList();
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class TipsInfo extends MessageMicro {
            public static final int BUTTONS_FIELD_NUMBER = 2;
            public static final int TIPS_TEXT_FIELD_NUMBER = 1;
            private boolean hasTipsText;
            private String tipsText_ = "";
            private List<ButtonInfo> buttons_ = Collections.emptyList();
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class ButtonInfo extends MessageMicro {
                public static final int BUTTON_LOC_FIELD_NUMBER = 1;
                public static final int BUTTON_PARAVAL_FIELD_NUMBER = 2;
                public static final int BUTTON_STATUS_FIELD_NUMBER = 4;
                public static final int BUTTON_TEXT_FIELD_NUMBER = 3;
                private boolean hasButtonLoc;
                private boolean hasButtonParaval;
                private boolean hasButtonStatus;
                private boolean hasButtonText;
                private int buttonLoc_ = 0;
                private int buttonParaval_ = 0;
                private String buttonText_ = "";
                private int buttonStatus_ = 0;
                private int cachedSize = -1;

                public static ButtonInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ButtonInfo().mergeFrom(codedInputStreamMicro);
                }

                public final ButtonInfo clear() {
                    clearButtonLoc();
                    clearButtonParaval();
                    clearButtonText();
                    clearButtonStatus();
                    this.cachedSize = -1;
                    return this;
                }

                public ButtonInfo clearButtonLoc() {
                    this.hasButtonLoc = false;
                    this.buttonLoc_ = 0;
                    return this;
                }

                public ButtonInfo clearButtonParaval() {
                    this.hasButtonParaval = false;
                    this.buttonParaval_ = 0;
                    return this;
                }

                public ButtonInfo clearButtonStatus() {
                    this.hasButtonStatus = false;
                    this.buttonStatus_ = 0;
                    return this;
                }

                public ButtonInfo clearButtonText() {
                    this.hasButtonText = false;
                    this.buttonText_ = "";
                    return this;
                }

                public int getButtonLoc() {
                    return this.buttonLoc_;
                }

                public int getButtonParaval() {
                    return this.buttonParaval_;
                }

                public int getButtonStatus() {
                    return this.buttonStatus_;
                }

                public String getButtonText() {
                    return this.buttonText_;
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
                    int computeInt32Size = hasButtonLoc() ? CodedOutputStreamMicro.computeInt32Size(1, getButtonLoc()) : 0;
                    if (hasButtonParaval()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getButtonParaval());
                    }
                    if (hasButtonText()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getButtonText());
                    }
                    if (hasButtonStatus()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getButtonStatus());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public boolean hasButtonLoc() {
                    return this.hasButtonLoc;
                }

                public boolean hasButtonParaval() {
                    return this.hasButtonParaval;
                }

                public boolean hasButtonStatus() {
                    return this.hasButtonStatus;
                }

                public boolean hasButtonText() {
                    return this.hasButtonText;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ButtonInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setButtonLoc(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setButtonParaval(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            setButtonText(codedInputStreamMicro.readString());
                        } else if (readTag == 32) {
                            setButtonStatus(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public ButtonInfo setButtonLoc(int i) {
                    this.hasButtonLoc = true;
                    this.buttonLoc_ = i;
                    return this;
                }

                public ButtonInfo setButtonParaval(int i) {
                    this.hasButtonParaval = true;
                    this.buttonParaval_ = i;
                    return this;
                }

                public ButtonInfo setButtonStatus(int i) {
                    this.hasButtonStatus = true;
                    this.buttonStatus_ = i;
                    return this;
                }

                public ButtonInfo setButtonText(String str) {
                    this.hasButtonText = true;
                    this.buttonText_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasButtonLoc()) {
                        codedOutputStreamMicro.writeInt32(1, getButtonLoc());
                    }
                    if (hasButtonParaval()) {
                        codedOutputStreamMicro.writeInt32(2, getButtonParaval());
                    }
                    if (hasButtonText()) {
                        codedOutputStreamMicro.writeString(3, getButtonText());
                    }
                    if (hasButtonStatus()) {
                        codedOutputStreamMicro.writeInt32(4, getButtonStatus());
                    }
                }

                public static ButtonInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ButtonInfo) new ButtonInfo().mergeFrom(bArr);
                }
            }

            public static TipsInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new TipsInfo().mergeFrom(codedInputStreamMicro);
            }

            public TipsInfo addButtons(ButtonInfo buttonInfo) {
                if (buttonInfo == null) {
                    return this;
                }
                if (this.buttons_.isEmpty()) {
                    this.buttons_ = new ArrayList();
                }
                this.buttons_.add(buttonInfo);
                return this;
            }

            public final TipsInfo clear() {
                clearTipsText();
                clearButtons();
                this.cachedSize = -1;
                return this;
            }

            public TipsInfo clearButtons() {
                this.buttons_ = Collections.emptyList();
                return this;
            }

            public TipsInfo clearTipsText() {
                this.hasTipsText = false;
                this.tipsText_ = "";
                return this;
            }

            public ButtonInfo getButtons(int i) {
                return this.buttons_.get(i);
            }

            public int getButtonsCount() {
                return this.buttons_.size();
            }

            public List<ButtonInfo> getButtonsList() {
                return this.buttons_;
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
                int computeStringSize = hasTipsText() ? CodedOutputStreamMicro.computeStringSize(1, getTipsText()) : 0;
                Iterator<ButtonInfo> it = getButtonsList().iterator();
                while (it.hasNext()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, it.next());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getTipsText() {
                return this.tipsText_;
            }

            public boolean hasTipsText() {
                return this.hasTipsText;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public TipsInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setTipsText(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        ButtonInfo buttonInfo = new ButtonInfo();
                        codedInputStreamMicro.readMessage(buttonInfo);
                        addButtons(buttonInfo);
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public TipsInfo setButtons(int i, ButtonInfo buttonInfo) {
                if (buttonInfo == null) {
                    return this;
                }
                this.buttons_.set(i, buttonInfo);
                return this;
            }

            public TipsInfo setTipsText(String str) {
                this.hasTipsText = true;
                this.tipsText_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTipsText()) {
                    codedOutputStreamMicro.writeString(1, getTipsText());
                }
                Iterator<ButtonInfo> it = getButtonsList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(2, it.next());
                }
            }

            public static TipsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (TipsInfo) new TipsInfo().mergeFrom(bArr);
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public Option addTipsInfo(TipsInfo tipsInfo) {
            if (tipsInfo == null) {
                return this;
            }
            if (this.tipsInfo_.isEmpty()) {
                this.tipsInfo_ = new ArrayList();
            }
            this.tipsInfo_.add(tipsInfo);
            return this;
        }

        public final Option clear() {
            clearError();
            clearTotal();
            clearType();
            clearTipsInfo();
            this.cachedSize = -1;
            return this;
        }

        public Option clearError() {
            this.hasError = false;
            this.error_ = 0;
            return this;
        }

        public Option clearTipsInfo() {
            this.tipsInfo_ = Collections.emptyList();
            return this;
        }

        public Option clearTotal() {
            this.hasTotal = false;
            this.total_ = 0;
            return this;
        }

        public Option clearType() {
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

        public int getError() {
            return this.error_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasError() ? CodedOutputStreamMicro.computeInt32Size(1, getError()) : 0;
            if (hasTotal()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            if (hasType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getType());
            }
            Iterator<TipsInfo> it = getTipsInfoList().iterator();
            while (it.hasNext()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, it.next());
            }
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
        }

        public TipsInfo getTipsInfo(int i) {
            return this.tipsInfo_.get(i);
        }

        public int getTipsInfoCount() {
            return this.tipsInfo_.size();
        }

        public List<TipsInfo> getTipsInfoList() {
            return this.tipsInfo_;
        }

        public int getTotal() {
            return this.total_;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasError() {
            return this.hasError;
        }

        public boolean hasTotal() {
            return this.hasTotal;
        }

        public boolean hasType() {
            return this.hasType;
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
                if (readTag == 8) {
                    setError(codedInputStreamMicro.readInt32());
                } else if (readTag == 16) {
                    setTotal(codedInputStreamMicro.readInt32());
                } else if (readTag == 24) {
                    setType(codedInputStreamMicro.readInt32());
                } else if (readTag == 34) {
                    TipsInfo tipsInfo = new TipsInfo();
                    codedInputStreamMicro.readMessage(tipsInfo);
                    addTipsInfo(tipsInfo);
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Option setError(int i) {
            this.hasError = true;
            this.error_ = i;
            return this;
        }

        public Option setTipsInfo(int i, TipsInfo tipsInfo) {
            if (tipsInfo == null) {
                return this;
            }
            this.tipsInfo_.set(i, tipsInfo);
            return this;
        }

        public Option setTotal(int i) {
            this.hasTotal = true;
            this.total_ = i;
            return this;
        }

        public Option setType(int i) {
            this.hasType = true;
            this.type_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(3, getType());
            }
            Iterator<TipsInfo> it = getTipsInfoList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(4, it.next());
            }
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Routes extends MessageMicro {
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int FACILITY_TYPE_FIELD_NUMBER = 7;
        public static final int LEGS_FIELD_NUMBER = 3;
        public static final int LOC_LEVEL_FIELD_NUMBER = 4;
        public static final int MBR_LEFTDOWN_LOCATION_FIELD_NUMBER = 5;
        public static final int MBR_RIGHTUP_LOCATION_FIELD_NUMBER = 6;
        private boolean hasDistance;
        private boolean hasDuration;
        private boolean hasFacilityType;
        private boolean hasLocLevel;
        private int distance_ = 0;
        private int duration_ = 0;
        private List<Legs> legs_ = Collections.emptyList();
        private int locLevel_ = 0;
        private List<Integer> mbrLeftdownLocation_ = Collections.emptyList();
        private List<Integer> mbrRightupLocation_ = Collections.emptyList();
        private int facilityType_ = 0;
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class Legs extends MessageMicro {
            public static final int DISTANCE_FIELD_NUMBER = 3;
            public static final int DURATION_FIELD_NUMBER = 4;
            public static final int SEND_LOCATION_FIELD_NUMBER = 2;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
            public static final int STEPS_FIELD_NUMBER = 5;
            private boolean hasDistance;
            private boolean hasDuration;
            private List<Double> sstartLocation_ = Collections.emptyList();
            private List<Double> sendLocation_ = Collections.emptyList();
            private int distance_ = 0;
            private int duration_ = 0;
            private List<Steps> steps_ = Collections.emptyList();
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class Steps extends MessageMicro {
                public static final int BUILDINGID_FIELD_NUMBER = 10;
                public static final int BUILDINGNAME_FIELD_NUMBER = 11;
                public static final int DISTANCE_FIELD_NUMBER = 3;
                public static final int DURATION_FIELD_NUMBER = 4;
                public static final int FLOORID_FIELD_NUMBER = 7;
                public static final int INDOORTURNTYPE_FIELD_NUMBER = 12;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 5;
                public static final int POIS_FIELD_NUMBER = 9;
                public static final int SEND_LOCATION_FIELD_NUMBER = 2;
                public static final int SPATH_FIELD_NUMBER = 8;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
                public static final int TYPE_FIELD_NUMBER = 6;
                public static final int YAW_INFO_FIELD_NUMBER = 13;
                private boolean hasBuildingid;
                private boolean hasBuildingname;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasFloorid;
                private boolean hasInstructions;
                private boolean hasType;
                private List<Double> sstartLocation_ = Collections.emptyList();
                private List<Double> sendLocation_ = Collections.emptyList();
                private int distance_ = 0;
                private int duration_ = 0;
                private String instructions_ = "";
                private int type_ = 0;
                private String floorid_ = "";
                private List<Double> spath_ = Collections.emptyList();
                private List<Pois> pois_ = Collections.emptyList();
                private String buildingid_ = "";
                private String buildingname_ = "";
                private List<IndoorTurnType> indoorturntype_ = Collections.emptyList();
                private List<YawInfo> yawInfo_ = Collections.emptyList();
                private int cachedSize = -1;

                /* loaded from: classes7.dex */
                public static final class IndoorTurnType extends MessageMicro {
                    public static final int SPATH_INDEX_FIELD_NUMBER = 1;
                    public static final int TURN_TYPE_FIELD_NUMBER = 2;
                    private boolean hasSpathIndex;
                    private boolean hasTurnType;
                    private int spathIndex_ = 0;
                    private int turnType_ = 0;
                    private int cachedSize = -1;

                    public static IndoorTurnType parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new IndoorTurnType().mergeFrom(codedInputStreamMicro);
                    }

                    public final IndoorTurnType clear() {
                        clearSpathIndex();
                        clearTurnType();
                        this.cachedSize = -1;
                        return this;
                    }

                    public IndoorTurnType clearSpathIndex() {
                        this.hasSpathIndex = false;
                        this.spathIndex_ = 0;
                        return this;
                    }

                    public IndoorTurnType clearTurnType() {
                        this.hasTurnType = false;
                        this.turnType_ = 0;
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
                        int computeInt32Size = hasSpathIndex() ? CodedOutputStreamMicro.computeInt32Size(1, getSpathIndex()) : 0;
                        if (hasTurnType()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTurnType());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public int getSpathIndex() {
                        return this.spathIndex_;
                    }

                    public int getTurnType() {
                        return this.turnType_;
                    }

                    public boolean hasSpathIndex() {
                        return this.hasSpathIndex;
                    }

                    public boolean hasTurnType() {
                        return this.hasTurnType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public IndoorTurnType mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setSpathIndex(codedInputStreamMicro.readInt32());
                            } else if (readTag == 16) {
                                setTurnType(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public IndoorTurnType setSpathIndex(int i) {
                        this.hasSpathIndex = true;
                        this.spathIndex_ = i;
                        return this;
                    }

                    public IndoorTurnType setTurnType(int i) {
                        this.hasTurnType = true;
                        this.turnType_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasSpathIndex()) {
                            codedOutputStreamMicro.writeInt32(1, getSpathIndex());
                        }
                        if (hasTurnType()) {
                            codedOutputStreamMicro.writeInt32(2, getTurnType());
                        }
                    }

                    public static IndoorTurnType parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (IndoorTurnType) new IndoorTurnType().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Pois extends MessageMicro {
                    public static final int BID_FIELD_NUMBER = 5;
                    public static final int CONNDIS_FROM_S_FIELD_NUMBER = 8;
                    public static final int DETAIL_FIELD_NUMBER = 4;
                    public static final int INDEX_CONN_POI_FIELD_NUMBER = 7;
                    public static final int LOCATION_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int STYLEID_FIELD_NUMBER = 6;
                    public static final int TYPE_FIELD_NUMBER = 2;
                    private boolean hasBid;
                    private boolean hasConndisFromS;
                    private boolean hasDetail;
                    private boolean hasIndexConnPoi;
                    private boolean hasName;
                    private boolean hasStyleid;
                    private boolean hasType;
                    private String name_ = "";
                    private int type_ = 0;
                    private List<Double> location_ = Collections.emptyList();
                    private String detail_ = "";
                    private String bid_ = "";
                    private String styleid_ = "";
                    private int indexConnPoi_ = 0;
                    private int conndisFromS_ = 0;
                    private int cachedSize = -1;

                    public static Pois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Pois().mergeFrom(codedInputStreamMicro);
                    }

                    public Pois addLocation(double d) {
                        if (this.location_.isEmpty()) {
                            this.location_ = new ArrayList();
                        }
                        this.location_.add(Double.valueOf(d));
                        return this;
                    }

                    public final Pois clear() {
                        clearName();
                        clearType();
                        clearLocation();
                        clearDetail();
                        clearBid();
                        clearStyleid();
                        clearIndexConnPoi();
                        clearConndisFromS();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Pois clearBid() {
                        this.hasBid = false;
                        this.bid_ = "";
                        return this;
                    }

                    public Pois clearConndisFromS() {
                        this.hasConndisFromS = false;
                        this.conndisFromS_ = 0;
                        return this;
                    }

                    public Pois clearDetail() {
                        this.hasDetail = false;
                        this.detail_ = "";
                        return this;
                    }

                    public Pois clearIndexConnPoi() {
                        this.hasIndexConnPoi = false;
                        this.indexConnPoi_ = 0;
                        return this;
                    }

                    public Pois clearLocation() {
                        this.location_ = Collections.emptyList();
                        return this;
                    }

                    public Pois clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public Pois clearStyleid() {
                        this.hasStyleid = false;
                        this.styleid_ = "";
                        return this;
                    }

                    public Pois clearType() {
                        this.hasType = false;
                        this.type_ = 0;
                        return this;
                    }

                    public String getBid() {
                        return this.bid_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getConndisFromS() {
                        return this.conndisFromS_;
                    }

                    public String getDetail() {
                        return this.detail_;
                    }

                    public int getIndexConnPoi() {
                        return this.indexConnPoi_;
                    }

                    public double getLocation(int i) {
                        return this.location_.get(i).doubleValue();
                    }

                    public int getLocationCount() {
                        return this.location_.size();
                    }

                    public List<Double> getLocationList() {
                        return this.location_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasType()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                        }
                        int size = computeStringSize + (getLocationList().size() * 8) + getLocationList().size();
                        if (hasDetail()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getDetail());
                        }
                        if (hasBid()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, getBid());
                        }
                        if (hasStyleid()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, getStyleid());
                        }
                        if (hasIndexConnPoi()) {
                            size += CodedOutputStreamMicro.computeInt32Size(7, getIndexConnPoi());
                        }
                        if (hasConndisFromS()) {
                            size += CodedOutputStreamMicro.computeInt32Size(8, getConndisFromS());
                        }
                        this.cachedSize = size;
                        return size;
                    }

                    public String getStyleid() {
                        return this.styleid_;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasBid() {
                        return this.hasBid;
                    }

                    public boolean hasConndisFromS() {
                        return this.hasConndisFromS;
                    }

                    public boolean hasDetail() {
                        return this.hasDetail;
                    }

                    public boolean hasIndexConnPoi() {
                        return this.hasIndexConnPoi;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasStyleid() {
                        return this.hasStyleid;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Pois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setName(codedInputStreamMicro.readString());
                            } else if (readTag == 16) {
                                setType(codedInputStreamMicro.readInt32());
                            } else if (readTag == 25) {
                                addLocation(codedInputStreamMicro.readDouble());
                            } else if (readTag == 34) {
                                setDetail(codedInputStreamMicro.readString());
                            } else if (readTag == 42) {
                                setBid(codedInputStreamMicro.readString());
                            } else if (readTag == 50) {
                                setStyleid(codedInputStreamMicro.readString());
                            } else if (readTag == 56) {
                                setIndexConnPoi(codedInputStreamMicro.readInt32());
                            } else if (readTag == 64) {
                                setConndisFromS(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Pois setBid(String str) {
                        this.hasBid = true;
                        this.bid_ = str;
                        return this;
                    }

                    public Pois setConndisFromS(int i) {
                        this.hasConndisFromS = true;
                        this.conndisFromS_ = i;
                        return this;
                    }

                    public Pois setDetail(String str) {
                        this.hasDetail = true;
                        this.detail_ = str;
                        return this;
                    }

                    public Pois setIndexConnPoi(int i) {
                        this.hasIndexConnPoi = true;
                        this.indexConnPoi_ = i;
                        return this;
                    }

                    public Pois setLocation(int i, double d) {
                        this.location_.set(i, Double.valueOf(d));
                        return this;
                    }

                    public Pois setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public Pois setStyleid(String str) {
                        this.hasStyleid = true;
                        this.styleid_ = str;
                        return this;
                    }

                    public Pois setType(int i) {
                        this.hasType = true;
                        this.type_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(2, getType());
                        }
                        Iterator<Double> it = getLocationList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeDouble(3, it.next().doubleValue());
                        }
                        if (hasDetail()) {
                            codedOutputStreamMicro.writeString(4, getDetail());
                        }
                        if (hasBid()) {
                            codedOutputStreamMicro.writeString(5, getBid());
                        }
                        if (hasStyleid()) {
                            codedOutputStreamMicro.writeString(6, getStyleid());
                        }
                        if (hasIndexConnPoi()) {
                            codedOutputStreamMicro.writeInt32(7, getIndexConnPoi());
                        }
                        if (hasConndisFromS()) {
                            codedOutputStreamMicro.writeInt32(8, getConndisFromS());
                        }
                    }

                    public static Pois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Pois) new Pois().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class YawInfo extends MessageMicro {
                    public static final int END_SPATH_INDEX_FIELD_NUMBER = 2;
                    public static final int START_SPATH_INDEX_FIELD_NUMBER = 1;
                    public static final int YAW_THRESHOLD_FIELD_NUMBER = 3;
                    private boolean hasEndSpathIndex;
                    private boolean hasStartSpathIndex;
                    private boolean hasYawThreshold;
                    private int startSpathIndex_ = 0;
                    private int endSpathIndex_ = 0;
                    private int yawThreshold_ = 0;
                    private int cachedSize = -1;

                    public static YawInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new YawInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public final YawInfo clear() {
                        clearStartSpathIndex();
                        clearEndSpathIndex();
                        clearYawThreshold();
                        this.cachedSize = -1;
                        return this;
                    }

                    public YawInfo clearEndSpathIndex() {
                        this.hasEndSpathIndex = false;
                        this.endSpathIndex_ = 0;
                        return this;
                    }

                    public YawInfo clearStartSpathIndex() {
                        this.hasStartSpathIndex = false;
                        this.startSpathIndex_ = 0;
                        return this;
                    }

                    public YawInfo clearYawThreshold() {
                        this.hasYawThreshold = false;
                        this.yawThreshold_ = 0;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getEndSpathIndex() {
                        return this.endSpathIndex_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasStartSpathIndex() ? CodedOutputStreamMicro.computeInt32Size(1, getStartSpathIndex()) : 0;
                        if (hasEndSpathIndex()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getEndSpathIndex());
                        }
                        if (hasYawThreshold()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getYawThreshold());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public int getStartSpathIndex() {
                        return this.startSpathIndex_;
                    }

                    public int getYawThreshold() {
                        return this.yawThreshold_;
                    }

                    public boolean hasEndSpathIndex() {
                        return this.hasEndSpathIndex;
                    }

                    public boolean hasStartSpathIndex() {
                        return this.hasStartSpathIndex;
                    }

                    public boolean hasYawThreshold() {
                        return this.hasYawThreshold;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public YawInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setStartSpathIndex(codedInputStreamMicro.readInt32());
                            } else if (readTag == 16) {
                                setEndSpathIndex(codedInputStreamMicro.readInt32());
                            } else if (readTag == 24) {
                                setYawThreshold(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public YawInfo setEndSpathIndex(int i) {
                        this.hasEndSpathIndex = true;
                        this.endSpathIndex_ = i;
                        return this;
                    }

                    public YawInfo setStartSpathIndex(int i) {
                        this.hasStartSpathIndex = true;
                        this.startSpathIndex_ = i;
                        return this;
                    }

                    public YawInfo setYawThreshold(int i) {
                        this.hasYawThreshold = true;
                        this.yawThreshold_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasStartSpathIndex()) {
                            codedOutputStreamMicro.writeInt32(1, getStartSpathIndex());
                        }
                        if (hasEndSpathIndex()) {
                            codedOutputStreamMicro.writeInt32(2, getEndSpathIndex());
                        }
                        if (hasYawThreshold()) {
                            codedOutputStreamMicro.writeInt32(3, getYawThreshold());
                        }
                    }

                    public static YawInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (YawInfo) new YawInfo().mergeFrom(bArr);
                    }
                }

                public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steps().mergeFrom(codedInputStreamMicro);
                }

                public Steps addIndoorturntype(IndoorTurnType indoorTurnType) {
                    if (indoorTurnType == null) {
                        return this;
                    }
                    if (this.indoorturntype_.isEmpty()) {
                        this.indoorturntype_ = new ArrayList();
                    }
                    this.indoorturntype_.add(indoorTurnType);
                    return this;
                }

                public Steps addPois(Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    if (this.pois_.isEmpty()) {
                        this.pois_ = new ArrayList();
                    }
                    this.pois_.add(pois);
                    return this;
                }

                public Steps addSendLocation(double d) {
                    if (this.sendLocation_.isEmpty()) {
                        this.sendLocation_ = new ArrayList();
                    }
                    this.sendLocation_.add(Double.valueOf(d));
                    return this;
                }

                public Steps addSpath(double d) {
                    if (this.spath_.isEmpty()) {
                        this.spath_ = new ArrayList();
                    }
                    this.spath_.add(Double.valueOf(d));
                    return this;
                }

                public Steps addSstartLocation(double d) {
                    if (this.sstartLocation_.isEmpty()) {
                        this.sstartLocation_ = new ArrayList();
                    }
                    this.sstartLocation_.add(Double.valueOf(d));
                    return this;
                }

                public Steps addYawInfo(YawInfo yawInfo) {
                    if (yawInfo == null) {
                        return this;
                    }
                    if (this.yawInfo_.isEmpty()) {
                        this.yawInfo_ = new ArrayList();
                    }
                    this.yawInfo_.add(yawInfo);
                    return this;
                }

                public final Steps clear() {
                    clearSstartLocation();
                    clearSendLocation();
                    clearDistance();
                    clearDuration();
                    clearInstructions();
                    clearType();
                    clearFloorid();
                    clearSpath();
                    clearPois();
                    clearBuildingid();
                    clearBuildingname();
                    clearIndoorturntype();
                    clearYawInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public Steps clearBuildingid() {
                    this.hasBuildingid = false;
                    this.buildingid_ = "";
                    return this;
                }

                public Steps clearBuildingname() {
                    this.hasBuildingname = false;
                    this.buildingname_ = "";
                    return this;
                }

                public Steps clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public Steps clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public Steps clearFloorid() {
                    this.hasFloorid = false;
                    this.floorid_ = "";
                    return this;
                }

                public Steps clearIndoorturntype() {
                    this.indoorturntype_ = Collections.emptyList();
                    return this;
                }

                public Steps clearInstructions() {
                    this.hasInstructions = false;
                    this.instructions_ = "";
                    return this;
                }

                public Steps clearPois() {
                    this.pois_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSendLocation() {
                    this.sendLocation_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath() {
                    this.spath_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.sstartLocation_ = Collections.emptyList();
                    return this;
                }

                public Steps clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public Steps clearYawInfo() {
                    this.yawInfo_ = Collections.emptyList();
                    return this;
                }

                public String getBuildingid() {
                    return this.buildingid_;
                }

                public String getBuildingname() {
                    return this.buildingname_;
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

                public String getFloorid() {
                    return this.floorid_;
                }

                public IndoorTurnType getIndoorturntype(int i) {
                    return this.indoorturntype_.get(i);
                }

                public int getIndoorturntypeCount() {
                    return this.indoorturntype_.size();
                }

                public List<IndoorTurnType> getIndoorturntypeList() {
                    return this.indoorturntype_;
                }

                public String getInstructions() {
                    return this.instructions_;
                }

                public Pois getPois(int i) {
                    return this.pois_.get(i);
                }

                public int getPoisCount() {
                    return this.pois_.size();
                }

                public List<Pois> getPoisList() {
                    return this.pois_;
                }

                public double getSendLocation(int i) {
                    return this.sendLocation_.get(i).doubleValue();
                }

                public int getSendLocationCount() {
                    return this.sendLocation_.size();
                }

                public List<Double> getSendLocationList() {
                    return this.sendLocation_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int size = (getSstartLocationList().size() * 8) + getSstartLocationList().size() + (getSendLocationList().size() * 8) + getSendLocationList().size();
                    if (hasDistance()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                    }
                    if (hasInstructions()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getType());
                    }
                    if (hasFloorid()) {
                        size += CodedOutputStreamMicro.computeStringSize(7, getFloorid());
                    }
                    int size2 = size + (getSpathList().size() * 8) + getSpathList().size();
                    Iterator<Pois> it = getPoisList().iterator();
                    while (it.hasNext()) {
                        size2 += CodedOutputStreamMicro.computeMessageSize(9, it.next());
                    }
                    if (hasBuildingid()) {
                        size2 += CodedOutputStreamMicro.computeStringSize(10, getBuildingid());
                    }
                    if (hasBuildingname()) {
                        size2 += CodedOutputStreamMicro.computeStringSize(11, getBuildingname());
                    }
                    Iterator<IndoorTurnType> it2 = getIndoorturntypeList().iterator();
                    while (it2.hasNext()) {
                        size2 += CodedOutputStreamMicro.computeMessageSize(12, it2.next());
                    }
                    Iterator<YawInfo> it3 = getYawInfoList().iterator();
                    while (it3.hasNext()) {
                        size2 += CodedOutputStreamMicro.computeMessageSize(13, it3.next());
                    }
                    this.cachedSize = size2;
                    return size2;
                }

                public double getSpath(int i) {
                    return this.spath_.get(i).doubleValue();
                }

                public int getSpathCount() {
                    return this.spath_.size();
                }

                public List<Double> getSpathList() {
                    return this.spath_;
                }

                public double getSstartLocation(int i) {
                    return this.sstartLocation_.get(i).doubleValue();
                }

                public int getSstartLocationCount() {
                    return this.sstartLocation_.size();
                }

                public List<Double> getSstartLocationList() {
                    return this.sstartLocation_;
                }

                public int getType() {
                    return this.type_;
                }

                public YawInfo getYawInfo(int i) {
                    return this.yawInfo_.get(i);
                }

                public int getYawInfoCount() {
                    return this.yawInfo_.size();
                }

                public List<YawInfo> getYawInfoList() {
                    return this.yawInfo_;
                }

                public boolean hasBuildingid() {
                    return this.hasBuildingid;
                }

                public boolean hasBuildingname() {
                    return this.hasBuildingname;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasFloorid() {
                    return this.hasFloorid;
                }

                public boolean hasInstructions() {
                    return this.hasInstructions;
                }

                public boolean hasType() {
                    return this.hasType;
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
                            case 9:
                                addSstartLocation(codedInputStreamMicro.readDouble());
                                break;
                            case 17:
                                addSendLocation(codedInputStreamMicro.readDouble());
                                break;
                            case 24:
                                setDistance(codedInputStreamMicro.readInt32());
                                break;
                            case 32:
                                setDuration(codedInputStreamMicro.readInt32());
                                break;
                            case 42:
                                setInstructions(codedInputStreamMicro.readString());
                                break;
                            case 48:
                                setType(codedInputStreamMicro.readInt32());
                                break;
                            case 58:
                                setFloorid(codedInputStreamMicro.readString());
                                break;
                            case 65:
                                addSpath(codedInputStreamMicro.readDouble());
                                break;
                            case 74:
                                Pois pois = new Pois();
                                codedInputStreamMicro.readMessage(pois);
                                addPois(pois);
                                break;
                            case 82:
                                setBuildingid(codedInputStreamMicro.readString());
                                break;
                            case 90:
                                setBuildingname(codedInputStreamMicro.readString());
                                break;
                            case 98:
                                IndoorTurnType indoorTurnType = new IndoorTurnType();
                                codedInputStreamMicro.readMessage(indoorTurnType);
                                addIndoorturntype(indoorTurnType);
                                break;
                            case 106:
                                YawInfo yawInfo = new YawInfo();
                                codedInputStreamMicro.readMessage(yawInfo);
                                addYawInfo(yawInfo);
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                                break;
                        }
                    }
                }

                public Steps setBuildingid(String str) {
                    this.hasBuildingid = true;
                    this.buildingid_ = str;
                    return this;
                }

                public Steps setBuildingname(String str) {
                    this.hasBuildingname = true;
                    this.buildingname_ = str;
                    return this;
                }

                public Steps setDistance(int i) {
                    this.hasDistance = true;
                    this.distance_ = i;
                    return this;
                }

                public Steps setDuration(int i) {
                    this.hasDuration = true;
                    this.duration_ = i;
                    return this;
                }

                public Steps setFloorid(String str) {
                    this.hasFloorid = true;
                    this.floorid_ = str;
                    return this;
                }

                public Steps setIndoorturntype(int i, IndoorTurnType indoorTurnType) {
                    if (indoorTurnType == null) {
                        return this;
                    }
                    this.indoorturntype_.set(i, indoorTurnType);
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.hasInstructions = true;
                    this.instructions_ = str;
                    return this;
                }

                public Steps setPois(int i, Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    this.pois_.set(i, pois);
                    return this;
                }

                public Steps setSendLocation(int i, double d) {
                    this.sendLocation_.set(i, Double.valueOf(d));
                    return this;
                }

                public Steps setSpath(int i, double d) {
                    this.spath_.set(i, Double.valueOf(d));
                    return this;
                }

                public Steps setSstartLocation(int i, double d) {
                    this.sstartLocation_.set(i, Double.valueOf(d));
                    return this;
                }

                public Steps setType(int i) {
                    this.hasType = true;
                    this.type_ = i;
                    return this;
                }

                public Steps setYawInfo(int i, YawInfo yawInfo) {
                    if (yawInfo == null) {
                        return this;
                    }
                    this.yawInfo_.set(i, yawInfo);
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    Iterator<Double> it = getSstartLocationList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeDouble(1, it.next().doubleValue());
                    }
                    Iterator<Double> it2 = getSendLocationList().iterator();
                    while (it2.hasNext()) {
                        codedOutputStreamMicro.writeDouble(2, it2.next().doubleValue());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(3, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(4, getDuration());
                    }
                    if (hasInstructions()) {
                        codedOutputStreamMicro.writeString(5, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(6, getType());
                    }
                    if (hasFloorid()) {
                        codedOutputStreamMicro.writeString(7, getFloorid());
                    }
                    Iterator<Double> it3 = getSpathList().iterator();
                    while (it3.hasNext()) {
                        codedOutputStreamMicro.writeDouble(8, it3.next().doubleValue());
                    }
                    Iterator<Pois> it4 = getPoisList().iterator();
                    while (it4.hasNext()) {
                        codedOutputStreamMicro.writeMessage(9, it4.next());
                    }
                    if (hasBuildingid()) {
                        codedOutputStreamMicro.writeString(10, getBuildingid());
                    }
                    if (hasBuildingname()) {
                        codedOutputStreamMicro.writeString(11, getBuildingname());
                    }
                    Iterator<IndoorTurnType> it5 = getIndoorturntypeList().iterator();
                    while (it5.hasNext()) {
                        codedOutputStreamMicro.writeMessage(12, it5.next());
                    }
                    Iterator<YawInfo> it6 = getYawInfoList().iterator();
                    while (it6.hasNext()) {
                        codedOutputStreamMicro.writeMessage(13, it6.next());
                    }
                }

                public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steps) new Steps().mergeFrom(bArr);
                }
            }

            public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Legs().mergeFrom(codedInputStreamMicro);
            }

            public Legs addSendLocation(double d) {
                if (this.sendLocation_.isEmpty()) {
                    this.sendLocation_ = new ArrayList();
                }
                this.sendLocation_.add(Double.valueOf(d));
                return this;
            }

            public Legs addSstartLocation(double d) {
                if (this.sstartLocation_.isEmpty()) {
                    this.sstartLocation_ = new ArrayList();
                }
                this.sstartLocation_.add(Double.valueOf(d));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps == null) {
                    return this;
                }
                if (this.steps_.isEmpty()) {
                    this.steps_ = new ArrayList();
                }
                this.steps_.add(steps);
                return this;
            }

            public final Legs clear() {
                clearSstartLocation();
                clearSendLocation();
                clearDistance();
                clearDuration();
                clearSteps();
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

            public Legs clearSendLocation() {
                this.sendLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearSstartLocation() {
                this.sstartLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearSteps() {
                this.steps_ = Collections.emptyList();
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

            public double getSendLocation(int i) {
                return this.sendLocation_.get(i).doubleValue();
            }

            public int getSendLocationCount() {
                return this.sendLocation_.size();
            }

            public List<Double> getSendLocationList() {
                return this.sendLocation_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int size = (getSstartLocationList().size() * 8) + getSstartLocationList().size() + (getSendLocationList().size() * 8) + getSendLocationList().size();
                if (hasDistance()) {
                    size += CodedOutputStreamMicro.computeInt32Size(3, getDistance());
                }
                if (hasDuration()) {
                    size += CodedOutputStreamMicro.computeInt32Size(4, getDuration());
                }
                Iterator<Steps> it = getStepsList().iterator();
                while (it.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(5, it.next());
                }
                this.cachedSize = size;
                return size;
            }

            public double getSstartLocation(int i) {
                return this.sstartLocation_.get(i).doubleValue();
            }

            public int getSstartLocationCount() {
                return this.sstartLocation_.size();
            }

            public List<Double> getSstartLocationList() {
                return this.sstartLocation_;
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

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasDuration() {
                return this.hasDuration;
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
                    if (readTag == 9) {
                        addSstartLocation(codedInputStreamMicro.readDouble());
                    } else if (readTag == 17) {
                        addSendLocation(codedInputStreamMicro.readDouble());
                    } else if (readTag == 24) {
                        setDistance(codedInputStreamMicro.readInt32());
                    } else if (readTag == 32) {
                        setDuration(codedInputStreamMicro.readInt32());
                    } else if (readTag == 42) {
                        Steps steps = new Steps();
                        codedInputStreamMicro.readMessage(steps);
                        addSteps(steps);
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

            public Legs setSendLocation(int i, double d) {
                this.sendLocation_.set(i, Double.valueOf(d));
                return this;
            }

            public Legs setSstartLocation(int i, double d) {
                this.sstartLocation_.set(i, Double.valueOf(d));
                return this;
            }

            public Legs setSteps(int i, Steps steps) {
                if (steps == null) {
                    return this;
                }
                this.steps_.set(i, steps);
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<Double> it = getSstartLocationList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeDouble(1, it.next().doubleValue());
                }
                Iterator<Double> it2 = getSendLocationList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeDouble(2, it2.next().doubleValue());
                }
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(3, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(4, getDuration());
                }
                Iterator<Steps> it3 = getStepsList().iterator();
                while (it3.hasNext()) {
                    codedOutputStreamMicro.writeMessage(5, it3.next());
                }
            }

            public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Legs) new Legs().mergeFrom(bArr);
            }
        }

        public static Routes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Routes().mergeFrom(codedInputStreamMicro);
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

        public Routes addMbrLeftdownLocation(int i) {
            if (this.mbrLeftdownLocation_.isEmpty()) {
                this.mbrLeftdownLocation_ = new ArrayList();
            }
            this.mbrLeftdownLocation_.add(Integer.valueOf(i));
            return this;
        }

        public Routes addMbrRightupLocation(int i) {
            if (this.mbrRightupLocation_.isEmpty()) {
                this.mbrRightupLocation_ = new ArrayList();
            }
            this.mbrRightupLocation_.add(Integer.valueOf(i));
            return this;
        }

        public final Routes clear() {
            clearDistance();
            clearDuration();
            clearLegs();
            clearLocLevel();
            clearMbrLeftdownLocation();
            clearMbrRightupLocation();
            clearFacilityType();
            this.cachedSize = -1;
            return this;
        }

        public Routes clearDistance() {
            this.hasDistance = false;
            this.distance_ = 0;
            return this;
        }

        public Routes clearDuration() {
            this.hasDuration = false;
            this.duration_ = 0;
            return this;
        }

        public Routes clearFacilityType() {
            this.hasFacilityType = false;
            this.facilityType_ = 0;
            return this;
        }

        public Routes clearLegs() {
            this.legs_ = Collections.emptyList();
            return this;
        }

        public Routes clearLocLevel() {
            this.hasLocLevel = false;
            this.locLevel_ = 0;
            return this;
        }

        public Routes clearMbrLeftdownLocation() {
            this.mbrLeftdownLocation_ = Collections.emptyList();
            return this;
        }

        public Routes clearMbrRightupLocation() {
            this.mbrRightupLocation_ = Collections.emptyList();
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

        public int getFacilityType() {
            return this.facilityType_;
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

        public int getLocLevel() {
            return this.locLevel_;
        }

        public int getMbrLeftdownLocation(int i) {
            return this.mbrLeftdownLocation_.get(i).intValue();
        }

        public int getMbrLeftdownLocationCount() {
            return this.mbrLeftdownLocation_.size();
        }

        public List<Integer> getMbrLeftdownLocationList() {
            return this.mbrLeftdownLocation_;
        }

        public int getMbrRightupLocation(int i) {
            return this.mbrRightupLocation_.get(i).intValue();
        }

        public int getMbrRightupLocationCount() {
            return this.mbrRightupLocation_.size();
        }

        public List<Integer> getMbrRightupLocationList() {
            return this.mbrRightupLocation_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasDistance() ? CodedOutputStreamMicro.computeInt32Size(1, getDistance()) : 0;
            if (hasDuration()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDuration());
            }
            Iterator<Legs> it = getLegsList().iterator();
            while (it.hasNext()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, it.next());
            }
            if (hasLocLevel()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getLocLevel());
            }
            Iterator<Integer> it2 = getMbrLeftdownLocationList().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                i2 += CodedOutputStreamMicro.computeInt32SizeNoTag(it2.next().intValue());
            }
            int size = computeInt32Size + i2 + getMbrLeftdownLocationList().size();
            Iterator<Integer> it3 = getMbrRightupLocationList().iterator();
            while (it3.hasNext()) {
                i += CodedOutputStreamMicro.computeInt32SizeNoTag(it3.next().intValue());
            }
            int size2 = size + i + getMbrRightupLocationList().size();
            if (hasFacilityType()) {
                size2 += CodedOutputStreamMicro.computeInt32Size(7, getFacilityType());
            }
            this.cachedSize = size2;
            return size2;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasDuration() {
            return this.hasDuration;
        }

        public boolean hasFacilityType() {
            return this.hasFacilityType;
        }

        public boolean hasLocLevel() {
            return this.hasLocLevel;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    Legs legs = new Legs();
                    codedInputStreamMicro.readMessage(legs);
                    addLegs(legs);
                } else if (readTag == 32) {
                    setLocLevel(codedInputStreamMicro.readInt32());
                } else if (readTag == 40) {
                    addMbrLeftdownLocation(codedInputStreamMicro.readInt32());
                } else if (readTag == 48) {
                    addMbrRightupLocation(codedInputStreamMicro.readInt32());
                } else if (readTag == 56) {
                    setFacilityType(codedInputStreamMicro.readInt32());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Routes setDistance(int i) {
            this.hasDistance = true;
            this.distance_ = i;
            return this;
        }

        public Routes setDuration(int i) {
            this.hasDuration = true;
            this.duration_ = i;
            return this;
        }

        public Routes setFacilityType(int i) {
            this.hasFacilityType = true;
            this.facilityType_ = i;
            return this;
        }

        public Routes setLegs(int i, Legs legs) {
            if (legs == null) {
                return this;
            }
            this.legs_.set(i, legs);
            return this;
        }

        public Routes setLocLevel(int i) {
            this.hasLocLevel = true;
            this.locLevel_ = i;
            return this;
        }

        public Routes setMbrLeftdownLocation(int i, int i2) {
            this.mbrLeftdownLocation_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Routes setMbrRightupLocation(int i, int i2) {
            this.mbrRightupLocation_.set(i, Integer.valueOf(i2));
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
            Iterator<Legs> it = getLegsList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(3, it.next());
            }
            if (hasLocLevel()) {
                codedOutputStreamMicro.writeInt32(4, getLocLevel());
            }
            Iterator<Integer> it2 = getMbrLeftdownLocationList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeInt32(5, it2.next().intValue());
            }
            Iterator<Integer> it3 = getMbrRightupLocationList().iterator();
            while (it3.hasNext()) {
                codedOutputStreamMicro.writeInt32(6, it3.next().intValue());
            }
            if (hasFacilityType()) {
                codedOutputStreamMicro.writeInt32(7, getFacilityType());
            }
        }

        public static Routes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Routes) new Routes().mergeFrom(bArr);
        }
    }

    public static IndoorNavi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new IndoorNavi().mergeFrom(codedInputStreamMicro);
    }

    public IndoorNavi addRoutes(Routes routes) {
        if (routes == null) {
            return this;
        }
        if (this.routes_.isEmpty()) {
            this.routes_ = new ArrayList();
        }
        this.routes_.add(routes);
        return this;
    }

    public final IndoorNavi clear() {
        clearOption();
        clearRoutes();
        this.cachedSize = -1;
        return this;
    }

    public IndoorNavi clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public IndoorNavi clearRoutes() {
        this.routes_ = Collections.emptyList();
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public Option getOption() {
        return this.option_;
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
        int computeMessageSize = hasOption() ? CodedOutputStreamMicro.computeMessageSize(1, getOption()) : 0;
        Iterator<Routes> it = getRoutesList().iterator();
        while (it.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, it.next());
        }
        this.cachedSize = computeMessageSize;
        return computeMessageSize;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public IndoorNavi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                Routes routes = new Routes();
                codedInputStreamMicro.readMessage(routes);
                addRoutes(routes);
            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                return this;
            }
        }
    }

    public IndoorNavi setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public IndoorNavi setRoutes(int i, Routes routes) {
        if (routes == null) {
            return this;
        }
        this.routes_.set(i, routes);
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        Iterator<Routes> it = getRoutesList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(2, it.next());
        }
    }

    public static IndoorNavi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (IndoorNavi) new IndoorNavi().mergeFrom(bArr);
    }
}
