package com.baidu.entity.pb;

import XIXIX.OOXIXo;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.garmin.fit.IXXIXx00I;
import com.garmin.fit.OxXXx0X;
import com.garmin.fit.X0xOO;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import com.huawei.openalliance.ad.constant.ah;
import com.jieli.jl_rcsp.constant.Command;
import com.realsil.sdk.dfu.DfuConstants;
import com.sma.smartv3.view.picker.HeightPicker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class PoiResult extends MessageMicro {
    public static final int ADDRS_FIELD_NUMBER = 2;
    public static final int ADS_EXT_INFO_FIELD_NUMBER = 16;
    public static final int ADS_FIELD_NUMBER = 14;
    public static final int BRAND_BAR_FIELD_NUMBER = 10;
    public static final int CAR_PRELOAD_FIELD_NUMBER = 21;
    public static final int CHILDREN_FIELD_NUMBER = 8;
    public static final int CONTENTS_FIELD_NUMBER = 6;
    public static final int CORRECTION_INFO_FIELD_NUMBER = 20;
    public static final int CURRENT_CITY_FIELD_NUMBER = 7;
    public static final int EMPTY_RESULT_DYNAMIC_CARD_FIELD_NUMBER = 27;
    public static final int FLOAT_ICONS_FIELD_NUMBER = 28;
    public static final int GUIDE_TAG_FIELD_NUMBER = 13;
    public static final int HORIZON_SLIDE_RESULT_FIELD_NUMBER = 26;
    public static final int IMGE_EXT_FIELD_NUMBER = 11;
    public static final int IMG_BANNER_FIELD_NUMBER = 23;
    public static final int INDUS_INFO_FIELD_NUMBER = 18;
    public static final int LIST_ADS_DATA_FIELD_NUMBER = 32;
    public static final int MYSTIQUE_LIST_FIELD_NUMBER = 24;
    public static final int OFFLINE_FIELD_NUMBER = 12;
    public static final int OPTION_FIELD_NUMBER = 1;
    public static final int PLACE_INFO_FIELD_NUMBER = 5;
    public static final int POPUP_WINDOW_FIELD_NUMBER = 30;
    public static final int PREVIOUS_CITY_FIELD_NUMBER = 9;
    public static final int PSRS_FIELD_NUMBER = 3;
    public static final int RECOMMEND_FIELD_NUMBER = 19;
    public static final int SEARCH_BOX_BG_IMG_FIELD_NUMBER = 29;
    public static final int SPEECH_FINAL_WORD_FIELD_NUMBER = 22;
    public static final int SUGGEST_QUERY_FIELD_NUMBER = 4;
    public static final int SUG_REC_RES_FIELD_NUMBER = 25;
    public static final int TALOS_DATA_FIELD_NUMBER = 33;
    public static final int WIDGET_BAR_FIELD_NUMBER = 31;
    private boolean hasAdsExtInfo;
    private boolean hasBrandBar;
    private boolean hasCarPreload;
    private boolean hasCorrectionInfo;
    private boolean hasCurrentCity;
    private boolean hasEmptyResultDynamicCard;
    private boolean hasHorizonSlideResult;
    private boolean hasImgBanner;
    private boolean hasImgeExt;
    private boolean hasIndusInfo;
    private boolean hasListAdsData;
    private boolean hasOffline;
    private boolean hasOption;
    private boolean hasPlaceInfo;
    private boolean hasPopupWindow;
    private boolean hasPreviousCity;
    private boolean hasPsrs;
    private boolean hasRecommend;
    private boolean hasSearchBoxBgImg;
    private boolean hasSpeechFinalWord;
    private boolean hasSugRecRes;
    private boolean hasTalosData;
    private boolean hasWidgetBar;
    private Option option_ = null;
    private List<Addrs> addrs_ = Collections.emptyList();
    private Psrs psrs_ = null;
    private List<SuggestQuery> suggestQuery_ = Collections.emptyList();
    private PlaceInfo placeInfo_ = null;
    private List<Contents> contents_ = Collections.emptyList();
    private List<Children> children_ = Collections.emptyList();
    private PreviousCity previousCity_ = null;
    private CurrentCity currentCity_ = null;
    private BrandBar brandBar_ = null;
    private ByteStringMicro imgeExt_ = ByteStringMicro.EMPTY;
    private int offline_ = 0;
    private List<GuideTag> guideTag_ = Collections.emptyList();
    private List<Ads> ads_ = Collections.emptyList();
    private AdsExtInfo adsExtInfo_ = null;
    private IndusInfo indusInfo_ = null;
    private Recommend recommend_ = null;
    private CorrectionInfo correctionInfo_ = null;
    private int carPreload_ = 0;
    private String speechFinalWord_ = "";
    private ImgBanner imgBanner_ = null;
    private List<MystiqueList> mystiqueList_ = Collections.emptyList();
    private SugRecResult sugRecRes_ = null;
    private HorizonSlideResult horizonSlideResult_ = null;
    private String emptyResultDynamicCard_ = "";
    private List<FloatIcon> floatIcons_ = Collections.emptyList();
    private String searchBoxBgImg_ = "";
    private String popupWindow_ = "";
    private WidgetBar widgetBar_ = null;
    private ListAdsData listAdsData_ = null;
    private TalosData talosData_ = null;
    private int cachedSize = -1;

    /* loaded from: classes7.dex */
    public static final class AddrButton extends MessageMicro {
        public static final int DARK_ICON_URL_FIELD_NUMBER = 3;
        public static final int ICON_URL_FIELD_NUMBER = 2;
        public static final int JUMP_URL_FIELD_NUMBER = 4;
        public static final int TEXT_FIELD_NUMBER = 1;
        private boolean hasDarkIconUrl;
        private boolean hasIconUrl;
        private boolean hasJumpUrl;
        private boolean hasText;
        private String text_ = "";
        private String iconUrl_ = "";
        private String darkIconUrl_ = "";
        private String jumpUrl_ = "";
        private int cachedSize = -1;

        public static AddrButton parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AddrButton().mergeFrom(codedInputStreamMicro);
        }

        public final AddrButton clear() {
            clearText();
            clearIconUrl();
            clearDarkIconUrl();
            clearJumpUrl();
            this.cachedSize = -1;
            return this;
        }

        public AddrButton clearDarkIconUrl() {
            this.hasDarkIconUrl = false;
            this.darkIconUrl_ = "";
            return this;
        }

        public AddrButton clearIconUrl() {
            this.hasIconUrl = false;
            this.iconUrl_ = "";
            return this;
        }

        public AddrButton clearJumpUrl() {
            this.hasJumpUrl = false;
            this.jumpUrl_ = "";
            return this;
        }

        public AddrButton clearText() {
            this.hasText = false;
            this.text_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getDarkIconUrl() {
            return this.darkIconUrl_;
        }

        public String getIconUrl() {
            return this.iconUrl_;
        }

        public String getJumpUrl() {
            return this.jumpUrl_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasText() ? CodedOutputStreamMicro.computeStringSize(1, getText()) : 0;
            if (hasIconUrl()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getIconUrl());
            }
            if (hasDarkIconUrl()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getDarkIconUrl());
            }
            if (hasJumpUrl()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getJumpUrl());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public String getText() {
            return this.text_;
        }

        public boolean hasDarkIconUrl() {
            return this.hasDarkIconUrl;
        }

        public boolean hasIconUrl() {
            return this.hasIconUrl;
        }

        public boolean hasJumpUrl() {
            return this.hasJumpUrl;
        }

        public boolean hasText() {
            return this.hasText;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public AddrButton mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setText(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setIconUrl(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    setDarkIconUrl(codedInputStreamMicro.readString());
                } else if (readTag == 34) {
                    setJumpUrl(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public AddrButton setDarkIconUrl(String str) {
            this.hasDarkIconUrl = true;
            this.darkIconUrl_ = str;
            return this;
        }

        public AddrButton setIconUrl(String str) {
            this.hasIconUrl = true;
            this.iconUrl_ = str;
            return this;
        }

        public AddrButton setJumpUrl(String str) {
            this.hasJumpUrl = true;
            this.jumpUrl_ = str;
            return this;
        }

        public AddrButton setText(String str) {
            this.hasText = true;
            this.text_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasText()) {
                codedOutputStreamMicro.writeString(1, getText());
            }
            if (hasIconUrl()) {
                codedOutputStreamMicro.writeString(2, getIconUrl());
            }
            if (hasDarkIconUrl()) {
                codedOutputStreamMicro.writeString(3, getDarkIconUrl());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(4, getJumpUrl());
            }
        }

        public static AddrButton parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AddrButton) new AddrButton().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Addrs extends MessageMicro {
        public static final int ACC_FLAG_FIELD_NUMBER = 5;
        public static final int ADDR_FIELD_NUMBER = 1;
        public static final int ADDR_TRANSFER_PARAM_FIELD_NUMBER = 12;
        public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 6;
        public static final int DISTANCE_FIELD_NUMBER = 9;
        public static final int GEO_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int PRECISE_FIELD_NUMBER = 4;
        public static final int RIGHT_UPPER_BTN_FIELD_NUMBER = 11;
        public static final int STREET_MAP_IMG_FIELD_NUMBER = 10;
        public static final int UID_FIELD_NUMBER = 8;
        public static final int VUI_PROCESS_DATA_FIELD_NUMBER = 7;
        private boolean hasAccFlag;
        private boolean hasAddr;
        private boolean hasAddrTransferParam;
        private boolean hasCloudTemplate;
        private boolean hasDistance;
        private boolean hasGeo;
        private boolean hasName;
        private boolean hasPrecise;
        private boolean hasRightUpperBtn;
        private boolean hasStreetMapImg;
        private boolean hasUid;
        private boolean hasVuiProcessData;
        private String addr_ = "";
        private String geo_ = "";
        private String name_ = "";
        private int precise_ = 0;
        private int accFlag_ = 0;
        private ByteStringMicro cloudTemplate_ = ByteStringMicro.EMPTY;
        private VuiProcessData vuiProcessData_ = null;
        private String uid_ = "";
        private String distance_ = "";
        private StreetImg streetMapImg_ = null;
        private AddrButton rightUpperBtn_ = null;
        private String addrTransferParam_ = "";
        private int cachedSize = -1;

        public static Addrs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Addrs().mergeFrom(codedInputStreamMicro);
        }

        public final Addrs clear() {
            clearAddr();
            clearGeo();
            clearName();
            clearPrecise();
            clearAccFlag();
            clearCloudTemplate();
            clearVuiProcessData();
            clearUid();
            clearDistance();
            clearStreetMapImg();
            clearRightUpperBtn();
            clearAddrTransferParam();
            this.cachedSize = -1;
            return this;
        }

        public Addrs clearAccFlag() {
            this.hasAccFlag = false;
            this.accFlag_ = 0;
            return this;
        }

        public Addrs clearAddr() {
            this.hasAddr = false;
            this.addr_ = "";
            return this;
        }

        public Addrs clearAddrTransferParam() {
            this.hasAddrTransferParam = false;
            this.addrTransferParam_ = "";
            return this;
        }

        public Addrs clearCloudTemplate() {
            this.hasCloudTemplate = false;
            this.cloudTemplate_ = ByteStringMicro.EMPTY;
            return this;
        }

        public Addrs clearDistance() {
            this.hasDistance = false;
            this.distance_ = "";
            return this;
        }

        public Addrs clearGeo() {
            this.hasGeo = false;
            this.geo_ = "";
            return this;
        }

        public Addrs clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public Addrs clearPrecise() {
            this.hasPrecise = false;
            this.precise_ = 0;
            return this;
        }

        public Addrs clearRightUpperBtn() {
            this.hasRightUpperBtn = false;
            this.rightUpperBtn_ = null;
            return this;
        }

        public Addrs clearStreetMapImg() {
            this.hasStreetMapImg = false;
            this.streetMapImg_ = null;
            return this;
        }

        public Addrs clearUid() {
            this.hasUid = false;
            this.uid_ = "";
            return this;
        }

        public Addrs clearVuiProcessData() {
            this.hasVuiProcessData = false;
            this.vuiProcessData_ = null;
            return this;
        }

        public int getAccFlag() {
            return this.accFlag_;
        }

        public String getAddr() {
            return this.addr_;
        }

        public String getAddrTransferParam() {
            return this.addrTransferParam_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public ByteStringMicro getCloudTemplate() {
            return this.cloudTemplate_;
        }

        public String getDistance() {
            return this.distance_;
        }

        public String getGeo() {
            return this.geo_;
        }

        public String getName() {
            return this.name_;
        }

        public int getPrecise() {
            return this.precise_;
        }

        public AddrButton getRightUpperBtn() {
            return this.rightUpperBtn_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasAddr() ? CodedOutputStreamMicro.computeStringSize(1, getAddr()) : 0;
            if (hasGeo()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getGeo());
            }
            if (hasName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            if (hasPrecise()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getPrecise());
            }
            if (hasAccFlag()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getAccFlag());
            }
            if (hasCloudTemplate()) {
                computeStringSize += CodedOutputStreamMicro.computeBytesSize(6, getCloudTemplate());
            }
            if (hasVuiProcessData()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(7, getVuiProcessData());
            }
            if (hasUid()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getUid());
            }
            if (hasDistance()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(9, getDistance());
            }
            if (hasStreetMapImg()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(10, getStreetMapImg());
            }
            if (hasRightUpperBtn()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(11, getRightUpperBtn());
            }
            if (hasAddrTransferParam()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(12, getAddrTransferParam());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public StreetImg getStreetMapImg() {
            return this.streetMapImg_;
        }

        public String getUid() {
            return this.uid_;
        }

        public VuiProcessData getVuiProcessData() {
            return this.vuiProcessData_;
        }

        public boolean hasAccFlag() {
            return this.hasAccFlag;
        }

        public boolean hasAddr() {
            return this.hasAddr;
        }

        public boolean hasAddrTransferParam() {
            return this.hasAddrTransferParam;
        }

        public boolean hasCloudTemplate() {
            return this.hasCloudTemplate;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasGeo() {
            return this.hasGeo;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasPrecise() {
            return this.hasPrecise;
        }

        public boolean hasRightUpperBtn() {
            return this.hasRightUpperBtn;
        }

        public boolean hasStreetMapImg() {
            return this.hasStreetMapImg;
        }

        public boolean hasUid() {
            return this.hasUid;
        }

        public boolean hasVuiProcessData() {
            return this.hasVuiProcessData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Addrs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        setAddr(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        setGeo(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        setName(codedInputStreamMicro.readString());
                        break;
                    case 32:
                        setPrecise(codedInputStreamMicro.readInt32());
                        break;
                    case 40:
                        setAccFlag(codedInputStreamMicro.readInt32());
                        break;
                    case 50:
                        setCloudTemplate(codedInputStreamMicro.readBytes());
                        break;
                    case 58:
                        VuiProcessData vuiProcessData = new VuiProcessData();
                        codedInputStreamMicro.readMessage(vuiProcessData);
                        setVuiProcessData(vuiProcessData);
                        break;
                    case 66:
                        setUid(codedInputStreamMicro.readString());
                        break;
                    case 74:
                        setDistance(codedInputStreamMicro.readString());
                        break;
                    case 82:
                        StreetImg streetImg = new StreetImg();
                        codedInputStreamMicro.readMessage(streetImg);
                        setStreetMapImg(streetImg);
                        break;
                    case 90:
                        AddrButton addrButton = new AddrButton();
                        codedInputStreamMicro.readMessage(addrButton);
                        setRightUpperBtn(addrButton);
                        break;
                    case 98:
                        setAddrTransferParam(codedInputStreamMicro.readString());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public Addrs setAccFlag(int i) {
            this.hasAccFlag = true;
            this.accFlag_ = i;
            return this;
        }

        public Addrs setAddr(String str) {
            this.hasAddr = true;
            this.addr_ = str;
            return this;
        }

        public Addrs setAddrTransferParam(String str) {
            this.hasAddrTransferParam = true;
            this.addrTransferParam_ = str;
            return this;
        }

        public Addrs setCloudTemplate(ByteStringMicro byteStringMicro) {
            this.hasCloudTemplate = true;
            this.cloudTemplate_ = byteStringMicro;
            return this;
        }

        public Addrs setDistance(String str) {
            this.hasDistance = true;
            this.distance_ = str;
            return this;
        }

        public Addrs setGeo(String str) {
            this.hasGeo = true;
            this.geo_ = str;
            return this;
        }

        public Addrs setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public Addrs setPrecise(int i) {
            this.hasPrecise = true;
            this.precise_ = i;
            return this;
        }

        public Addrs setRightUpperBtn(AddrButton addrButton) {
            if (addrButton == null) {
                return clearRightUpperBtn();
            }
            this.hasRightUpperBtn = true;
            this.rightUpperBtn_ = addrButton;
            return this;
        }

        public Addrs setStreetMapImg(StreetImg streetImg) {
            if (streetImg == null) {
                return clearStreetMapImg();
            }
            this.hasStreetMapImg = true;
            this.streetMapImg_ = streetImg;
            return this;
        }

        public Addrs setUid(String str) {
            this.hasUid = true;
            this.uid_ = str;
            return this;
        }

        public Addrs setVuiProcessData(VuiProcessData vuiProcessData) {
            if (vuiProcessData == null) {
                return clearVuiProcessData();
            }
            this.hasVuiProcessData = true;
            this.vuiProcessData_ = vuiProcessData;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAddr()) {
                codedOutputStreamMicro.writeString(1, getAddr());
            }
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(2, getGeo());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
            if (hasPrecise()) {
                codedOutputStreamMicro.writeInt32(4, getPrecise());
            }
            if (hasAccFlag()) {
                codedOutputStreamMicro.writeInt32(5, getAccFlag());
            }
            if (hasCloudTemplate()) {
                codedOutputStreamMicro.writeBytes(6, getCloudTemplate());
            }
            if (hasVuiProcessData()) {
                codedOutputStreamMicro.writeMessage(7, getVuiProcessData());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(8, getUid());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(9, getDistance());
            }
            if (hasStreetMapImg()) {
                codedOutputStreamMicro.writeMessage(10, getStreetMapImg());
            }
            if (hasRightUpperBtn()) {
                codedOutputStreamMicro.writeMessage(11, getRightUpperBtn());
            }
            if (hasAddrTransferParam()) {
                codedOutputStreamMicro.writeString(12, getAddrTransferParam());
            }
        }

        public static Addrs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Addrs) new Addrs().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Ads extends MessageMicro {
        public static final int ADS_DATA_FIELD_NUMBER = 8;
        public static final int ADS_EXT_FIELD_NUMBER = 4;
        public static final int ADS_INFO_FIELD_NUMBER = 3;
        public static final int ADS_POS_FIELD_NUMBER = 6;
        public static final int ADS_TYPE_FIELD_NUMBER = 7;
        public static final int POS_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        private boolean hasAdsData;
        private boolean hasAdsExt;
        private boolean hasAdsInfo;
        private boolean hasAdsPos;
        private boolean hasAdsType;
        private boolean hasPos;
        private boolean hasType;
        private int pos_ = 0;
        private int type_ = 0;
        private AdsInfo adsInfo_ = null;
        private AdsExt adsExt_ = null;
        private int adsPos_ = 0;
        private int adsType_ = 0;
        private String adsData_ = "";
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class AdsExt extends MessageMicro {
            public static final int ADS_LOGS_FIELD_NUMBER = 3;
            public static final int INTIMESIGN_FIELD_NUMBER = 1;
            public static final int PROMOTE_STYLE_FIELD_NUMBER = 2;
            private boolean hasAdsLogs;
            private boolean hasInTimeSign;
            private boolean hasPromoteStyle;
            private String inTimeSign_ = "";
            private int promoteStyle_ = 0;
            private String adsLogs_ = "";
            private int cachedSize = -1;

            public static AdsExt parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdsExt().mergeFrom(codedInputStreamMicro);
            }

            public final AdsExt clear() {
                clearInTimeSign();
                clearPromoteStyle();
                clearAdsLogs();
                this.cachedSize = -1;
                return this;
            }

            public AdsExt clearAdsLogs() {
                this.hasAdsLogs = false;
                this.adsLogs_ = "";
                return this;
            }

            public AdsExt clearInTimeSign() {
                this.hasInTimeSign = false;
                this.inTimeSign_ = "";
                return this;
            }

            public AdsExt clearPromoteStyle() {
                this.hasPromoteStyle = false;
                this.promoteStyle_ = 0;
                return this;
            }

            public String getAdsLogs() {
                return this.adsLogs_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getInTimeSign() {
                return this.inTimeSign_;
            }

            public int getPromoteStyle() {
                return this.promoteStyle_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasInTimeSign() ? CodedOutputStreamMicro.computeStringSize(1, getInTimeSign()) : 0;
                if (hasPromoteStyle()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getPromoteStyle());
                }
                if (hasAdsLogs()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getAdsLogs());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public boolean hasAdsLogs() {
                return this.hasAdsLogs;
            }

            public boolean hasInTimeSign() {
                return this.hasInTimeSign;
            }

            public boolean hasPromoteStyle() {
                return this.hasPromoteStyle;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AdsExt mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setInTimeSign(codedInputStreamMicro.readString());
                    } else if (readTag == 16) {
                        setPromoteStyle(codedInputStreamMicro.readInt32());
                    } else if (readTag == 26) {
                        setAdsLogs(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AdsExt setAdsLogs(String str) {
                this.hasAdsLogs = true;
                this.adsLogs_ = str;
                return this;
            }

            public AdsExt setInTimeSign(String str) {
                this.hasInTimeSign = true;
                this.inTimeSign_ = str;
                return this;
            }

            public AdsExt setPromoteStyle(int i) {
                this.hasPromoteStyle = true;
                this.promoteStyle_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasInTimeSign()) {
                    codedOutputStreamMicro.writeString(1, getInTimeSign());
                }
                if (hasPromoteStyle()) {
                    codedOutputStreamMicro.writeInt32(2, getPromoteStyle());
                }
                if (hasAdsLogs()) {
                    codedOutputStreamMicro.writeString(3, getAdsLogs());
                }
            }

            public static AdsExt parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdsExt) new AdsExt().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class AdsInfo extends MessageMicro {
            public static final int ADS_MAIN_FIELD_NUMBER = 1;
            private AdsMain adsMain_ = null;
            private int cachedSize = -1;
            private boolean hasAdsMain;

            /* loaded from: classes7.dex */
            public static final class AdsMain extends MessageMicro {
                public static final int ADDR_FIELD_NUMBER = 9;
                public static final int BRIEF_FIELD_NUMBER = 10;
                public static final int DISTANCE_FIELD_NUMBER = 7;
                public static final int NAME_FIELD_NUMBER = 3;
                public static final int PIC_FIELD_NUMBER = 11;
                public static final int PRIMARY_UID_FIELD_NUMBER = 2;
                public static final int PROMOTE_STYLE_FIELD_NUMBER = 12;
                public static final int SRC_NAME_FIELD_NUMBER = 8;
                public static final int STYLE_FIELD_NUMBER = 1;
                public static final int URL_FIELD_NUMBER = 4;
                public static final int X_FIELD_NUMBER = 5;
                public static final int Y_FIELD_NUMBER = 6;
                private boolean hasAddr;
                private boolean hasBrief;
                private boolean hasDistance;
                private boolean hasName;
                private boolean hasPic;
                private boolean hasPrimaryUid;
                private boolean hasPromoteStyle;
                private boolean hasSrcName;
                private boolean hasStyle;
                private boolean hasUrl;
                private boolean hasX;
                private boolean hasY;
                private int style_ = 0;
                private String primaryUid_ = "";
                private String name_ = "";
                private String url_ = "";
                private String x_ = "";
                private String y_ = "";
                private int distance_ = 0;
                private String srcName_ = "";
                private String addr_ = "";
                private String brief_ = "";
                private String pic_ = "";
                private int promoteStyle_ = 0;
                private int cachedSize = -1;

                public static AdsMain parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new AdsMain().mergeFrom(codedInputStreamMicro);
                }

                public final AdsMain clear() {
                    clearStyle();
                    clearPrimaryUid();
                    clearName();
                    clearUrl();
                    clearX();
                    clearY();
                    clearDistance();
                    clearSrcName();
                    clearAddr();
                    clearBrief();
                    clearPic();
                    clearPromoteStyle();
                    this.cachedSize = -1;
                    return this;
                }

                public AdsMain clearAddr() {
                    this.hasAddr = false;
                    this.addr_ = "";
                    return this;
                }

                public AdsMain clearBrief() {
                    this.hasBrief = false;
                    this.brief_ = "";
                    return this;
                }

                public AdsMain clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public AdsMain clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public AdsMain clearPic() {
                    this.hasPic = false;
                    this.pic_ = "";
                    return this;
                }

                public AdsMain clearPrimaryUid() {
                    this.hasPrimaryUid = false;
                    this.primaryUid_ = "";
                    return this;
                }

                public AdsMain clearPromoteStyle() {
                    this.hasPromoteStyle = false;
                    this.promoteStyle_ = 0;
                    return this;
                }

                public AdsMain clearSrcName() {
                    this.hasSrcName = false;
                    this.srcName_ = "";
                    return this;
                }

                public AdsMain clearStyle() {
                    this.hasStyle = false;
                    this.style_ = 0;
                    return this;
                }

                public AdsMain clearUrl() {
                    this.hasUrl = false;
                    this.url_ = "";
                    return this;
                }

                public AdsMain clearX() {
                    this.hasX = false;
                    this.x_ = "";
                    return this;
                }

                public AdsMain clearY() {
                    this.hasY = false;
                    this.y_ = "";
                    return this;
                }

                public String getAddr() {
                    return this.addr_;
                }

                public String getBrief() {
                    return this.brief_;
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

                public String getName() {
                    return this.name_;
                }

                public String getPic() {
                    return this.pic_;
                }

                public String getPrimaryUid() {
                    return this.primaryUid_;
                }

                public int getPromoteStyle() {
                    return this.promoteStyle_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasStyle() ? CodedOutputStreamMicro.computeInt32Size(1, getStyle()) : 0;
                    if (hasPrimaryUid()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getPrimaryUid());
                    }
                    if (hasName()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getName());
                    }
                    if (hasUrl()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getUrl());
                    }
                    if (hasX()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(5, getX());
                    }
                    if (hasY()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getY());
                    }
                    if (hasDistance()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getDistance());
                    }
                    if (hasSrcName()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(8, getSrcName());
                    }
                    if (hasAddr()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getAddr());
                    }
                    if (hasBrief()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(10, getBrief());
                    }
                    if (hasPic()) {
                        computeInt32Size += CodedOutputStreamMicro.computeStringSize(11, getPic());
                    }
                    if (hasPromoteStyle()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(12, getPromoteStyle());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public String getSrcName() {
                    return this.srcName_;
                }

                public int getStyle() {
                    return this.style_;
                }

                public String getUrl() {
                    return this.url_;
                }

                public String getX() {
                    return this.x_;
                }

                public String getY() {
                    return this.y_;
                }

                public boolean hasAddr() {
                    return this.hasAddr;
                }

                public boolean hasBrief() {
                    return this.hasBrief;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasPic() {
                    return this.hasPic;
                }

                public boolean hasPrimaryUid() {
                    return this.hasPrimaryUid;
                }

                public boolean hasPromoteStyle() {
                    return this.hasPromoteStyle;
                }

                public boolean hasSrcName() {
                    return this.hasSrcName;
                }

                public boolean hasStyle() {
                    return this.hasStyle;
                }

                public boolean hasUrl() {
                    return this.hasUrl;
                }

                public boolean hasX() {
                    return this.hasX;
                }

                public boolean hasY() {
                    return this.hasY;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public AdsMain mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                return this;
                            case 8:
                                setStyle(codedInputStreamMicro.readInt32());
                                break;
                            case 18:
                                setPrimaryUid(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                setName(codedInputStreamMicro.readString());
                                break;
                            case 34:
                                setUrl(codedInputStreamMicro.readString());
                                break;
                            case 42:
                                setX(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                setY(codedInputStreamMicro.readString());
                                break;
                            case 56:
                                setDistance(codedInputStreamMicro.readInt32());
                                break;
                            case 66:
                                setSrcName(codedInputStreamMicro.readString());
                                break;
                            case 74:
                                setAddr(codedInputStreamMicro.readString());
                                break;
                            case 82:
                                setBrief(codedInputStreamMicro.readString());
                                break;
                            case 90:
                                setPic(codedInputStreamMicro.readString());
                                break;
                            case 96:
                                setPromoteStyle(codedInputStreamMicro.readInt32());
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                                break;
                        }
                    }
                }

                public AdsMain setAddr(String str) {
                    this.hasAddr = true;
                    this.addr_ = str;
                    return this;
                }

                public AdsMain setBrief(String str) {
                    this.hasBrief = true;
                    this.brief_ = str;
                    return this;
                }

                public AdsMain setDistance(int i) {
                    this.hasDistance = true;
                    this.distance_ = i;
                    return this;
                }

                public AdsMain setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public AdsMain setPic(String str) {
                    this.hasPic = true;
                    this.pic_ = str;
                    return this;
                }

                public AdsMain setPrimaryUid(String str) {
                    this.hasPrimaryUid = true;
                    this.primaryUid_ = str;
                    return this;
                }

                public AdsMain setPromoteStyle(int i) {
                    this.hasPromoteStyle = true;
                    this.promoteStyle_ = i;
                    return this;
                }

                public AdsMain setSrcName(String str) {
                    this.hasSrcName = true;
                    this.srcName_ = str;
                    return this;
                }

                public AdsMain setStyle(int i) {
                    this.hasStyle = true;
                    this.style_ = i;
                    return this;
                }

                public AdsMain setUrl(String str) {
                    this.hasUrl = true;
                    this.url_ = str;
                    return this;
                }

                public AdsMain setX(String str) {
                    this.hasX = true;
                    this.x_ = str;
                    return this;
                }

                public AdsMain setY(String str) {
                    this.hasY = true;
                    this.y_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasStyle()) {
                        codedOutputStreamMicro.writeInt32(1, getStyle());
                    }
                    if (hasPrimaryUid()) {
                        codedOutputStreamMicro.writeString(2, getPrimaryUid());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(3, getName());
                    }
                    if (hasUrl()) {
                        codedOutputStreamMicro.writeString(4, getUrl());
                    }
                    if (hasX()) {
                        codedOutputStreamMicro.writeString(5, getX());
                    }
                    if (hasY()) {
                        codedOutputStreamMicro.writeString(6, getY());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(7, getDistance());
                    }
                    if (hasSrcName()) {
                        codedOutputStreamMicro.writeString(8, getSrcName());
                    }
                    if (hasAddr()) {
                        codedOutputStreamMicro.writeString(9, getAddr());
                    }
                    if (hasBrief()) {
                        codedOutputStreamMicro.writeString(10, getBrief());
                    }
                    if (hasPic()) {
                        codedOutputStreamMicro.writeString(11, getPic());
                    }
                    if (hasPromoteStyle()) {
                        codedOutputStreamMicro.writeInt32(12, getPromoteStyle());
                    }
                }

                public static AdsMain parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (AdsMain) new AdsMain().mergeFrom(bArr);
                }
            }

            public static AdsInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdsInfo().mergeFrom(codedInputStreamMicro);
            }

            public final AdsInfo clear() {
                clearAdsMain();
                this.cachedSize = -1;
                return this;
            }

            public AdsInfo clearAdsMain() {
                this.hasAdsMain = false;
                this.adsMain_ = null;
                return this;
            }

            public AdsMain getAdsMain() {
                return this.adsMain_;
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
                int computeMessageSize = hasAdsMain() ? CodedOutputStreamMicro.computeMessageSize(1, getAdsMain()) : 0;
                this.cachedSize = computeMessageSize;
                return computeMessageSize;
            }

            public boolean hasAdsMain() {
                return this.hasAdsMain;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AdsInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        AdsMain adsMain = new AdsMain();
                        codedInputStreamMicro.readMessage(adsMain);
                        setAdsMain(adsMain);
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AdsInfo setAdsMain(AdsMain adsMain) {
                if (adsMain == null) {
                    return clearAdsMain();
                }
                this.hasAdsMain = true;
                this.adsMain_ = adsMain;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasAdsMain()) {
                    codedOutputStreamMicro.writeMessage(1, getAdsMain());
                }
            }

            public static AdsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdsInfo) new AdsInfo().mergeFrom(bArr);
            }
        }

        public static Ads parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Ads().mergeFrom(codedInputStreamMicro);
        }

        public final Ads clear() {
            clearPos();
            clearType();
            clearAdsInfo();
            clearAdsExt();
            clearAdsPos();
            clearAdsType();
            clearAdsData();
            this.cachedSize = -1;
            return this;
        }

        public Ads clearAdsData() {
            this.hasAdsData = false;
            this.adsData_ = "";
            return this;
        }

        public Ads clearAdsExt() {
            this.hasAdsExt = false;
            this.adsExt_ = null;
            return this;
        }

        public Ads clearAdsInfo() {
            this.hasAdsInfo = false;
            this.adsInfo_ = null;
            return this;
        }

        public Ads clearAdsPos() {
            this.hasAdsPos = false;
            this.adsPos_ = 0;
            return this;
        }

        public Ads clearAdsType() {
            this.hasAdsType = false;
            this.adsType_ = 0;
            return this;
        }

        public Ads clearPos() {
            this.hasPos = false;
            this.pos_ = 0;
            return this;
        }

        public Ads clearType() {
            this.hasType = false;
            this.type_ = 0;
            return this;
        }

        public String getAdsData() {
            return this.adsData_;
        }

        public AdsExt getAdsExt() {
            return this.adsExt_;
        }

        public AdsInfo getAdsInfo() {
            return this.adsInfo_;
        }

        public int getAdsPos() {
            return this.adsPos_;
        }

        public int getAdsType() {
            return this.adsType_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getPos() {
            return this.pos_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasPos() ? CodedOutputStreamMicro.computeInt32Size(1, getPos()) : 0;
            if (hasType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getType());
            }
            if (hasAdsInfo()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, getAdsInfo());
            }
            if (hasAdsExt()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, getAdsExt());
            }
            if (hasAdsPos()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getAdsPos());
            }
            if (hasAdsType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getAdsType());
            }
            if (hasAdsData()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(8, getAdsData());
            }
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasAdsData() {
            return this.hasAdsData;
        }

        public boolean hasAdsExt() {
            return this.hasAdsExt;
        }

        public boolean hasAdsInfo() {
            return this.hasAdsInfo;
        }

        public boolean hasAdsPos() {
            return this.hasAdsPos;
        }

        public boolean hasAdsType() {
            return this.hasAdsType;
        }

        public boolean hasPos() {
            return this.hasPos;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Ads mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setPos(codedInputStreamMicro.readInt32());
                } else if (readTag == 16) {
                    setType(codedInputStreamMicro.readInt32());
                } else if (readTag == 26) {
                    AdsInfo adsInfo = new AdsInfo();
                    codedInputStreamMicro.readMessage(adsInfo);
                    setAdsInfo(adsInfo);
                } else if (readTag == 34) {
                    AdsExt adsExt = new AdsExt();
                    codedInputStreamMicro.readMessage(adsExt);
                    setAdsExt(adsExt);
                } else if (readTag == 48) {
                    setAdsPos(codedInputStreamMicro.readInt32());
                } else if (readTag == 56) {
                    setAdsType(codedInputStreamMicro.readInt32());
                } else if (readTag == 66) {
                    setAdsData(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Ads setAdsData(String str) {
            this.hasAdsData = true;
            this.adsData_ = str;
            return this;
        }

        public Ads setAdsExt(AdsExt adsExt) {
            if (adsExt == null) {
                return clearAdsExt();
            }
            this.hasAdsExt = true;
            this.adsExt_ = adsExt;
            return this;
        }

        public Ads setAdsInfo(AdsInfo adsInfo) {
            if (adsInfo == null) {
                return clearAdsInfo();
            }
            this.hasAdsInfo = true;
            this.adsInfo_ = adsInfo;
            return this;
        }

        public Ads setAdsPos(int i) {
            this.hasAdsPos = true;
            this.adsPos_ = i;
            return this;
        }

        public Ads setAdsType(int i) {
            this.hasAdsType = true;
            this.adsType_ = i;
            return this;
        }

        public Ads setPos(int i) {
            this.hasPos = true;
            this.pos_ = i;
            return this;
        }

        public Ads setType(int i) {
            this.hasType = true;
            this.type_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPos()) {
                codedOutputStreamMicro.writeInt32(1, getPos());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(2, getType());
            }
            if (hasAdsInfo()) {
                codedOutputStreamMicro.writeMessage(3, getAdsInfo());
            }
            if (hasAdsExt()) {
                codedOutputStreamMicro.writeMessage(4, getAdsExt());
            }
            if (hasAdsPos()) {
                codedOutputStreamMicro.writeInt32(6, getAdsPos());
            }
            if (hasAdsType()) {
                codedOutputStreamMicro.writeInt32(7, getAdsType());
            }
            if (hasAdsData()) {
                codedOutputStreamMicro.writeString(8, getAdsData());
            }
        }

        public static Ads parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Ads) new Ads().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class AdsExtInfo extends MessageMicro {
        public static final int ADS_PAGE_LOGS_FIELD_NUMBER = 1;
        private String adsPageLogs_ = "";
        private int cachedSize = -1;
        private boolean hasAdsPageLogs;

        public static AdsExtInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AdsExtInfo().mergeFrom(codedInputStreamMicro);
        }

        public final AdsExtInfo clear() {
            clearAdsPageLogs();
            this.cachedSize = -1;
            return this;
        }

        public AdsExtInfo clearAdsPageLogs() {
            this.hasAdsPageLogs = false;
            this.adsPageLogs_ = "";
            return this;
        }

        public String getAdsPageLogs() {
            return this.adsPageLogs_;
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
            int computeStringSize = hasAdsPageLogs() ? CodedOutputStreamMicro.computeStringSize(1, getAdsPageLogs()) : 0;
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public boolean hasAdsPageLogs() {
            return this.hasAdsPageLogs;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public AdsExtInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setAdsPageLogs(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public AdsExtInfo setAdsPageLogs(String str) {
            this.hasAdsPageLogs = true;
            this.adsPageLogs_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAdsPageLogs()) {
                codedOutputStreamMicro.writeString(1, getAdsPageLogs());
            }
        }

        public static AdsExtInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AdsExtInfo) new AdsExtInfo().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class BrandBar extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 6;
        public static final int IMG_FIELD_NUMBER = 1;
        public static final int LINK_FIELD_NUMBER = 5;
        public static final int SUBTITLE_FIELD_NUMBER = 3;
        public static final int TEL_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 2;
        private boolean hasDesc;
        private boolean hasImg;
        private boolean hasLink;
        private boolean hasSubtitle;
        private boolean hasTel;
        private boolean hasTitle;
        private String img_ = "";
        private String title_ = "";
        private String subtitle_ = "";
        private String tel_ = "";
        private String link_ = "";
        private String desc_ = "";
        private int cachedSize = -1;

        public static BrandBar parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BrandBar().mergeFrom(codedInputStreamMicro);
        }

        public final BrandBar clear() {
            clearImg();
            clearTitle();
            clearSubtitle();
            clearTel();
            clearLink();
            clearDesc();
            this.cachedSize = -1;
            return this;
        }

        public BrandBar clearDesc() {
            this.hasDesc = false;
            this.desc_ = "";
            return this;
        }

        public BrandBar clearImg() {
            this.hasImg = false;
            this.img_ = "";
            return this;
        }

        public BrandBar clearLink() {
            this.hasLink = false;
            this.link_ = "";
            return this;
        }

        public BrandBar clearSubtitle() {
            this.hasSubtitle = false;
            this.subtitle_ = "";
            return this;
        }

        public BrandBar clearTel() {
            this.hasTel = false;
            this.tel_ = "";
            return this;
        }

        public BrandBar clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getDesc() {
            return this.desc_;
        }

        public String getImg() {
            return this.img_;
        }

        public String getLink() {
            return this.link_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasImg() ? CodedOutputStreamMicro.computeStringSize(1, getImg()) : 0;
            if (hasTitle()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasSubtitle()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getSubtitle());
            }
            if (hasTel()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getTel());
            }
            if (hasLink()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getLink());
            }
            if (hasDesc()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getDesc());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public String getSubtitle() {
            return this.subtitle_;
        }

        public String getTel() {
            return this.tel_;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasDesc() {
            return this.hasDesc;
        }

        public boolean hasImg() {
            return this.hasImg;
        }

        public boolean hasLink() {
            return this.hasLink;
        }

        public boolean hasSubtitle() {
            return this.hasSubtitle;
        }

        public boolean hasTel() {
            return this.hasTel;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public BrandBar mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setImg(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setTitle(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    setSubtitle(codedInputStreamMicro.readString());
                } else if (readTag == 34) {
                    setTel(codedInputStreamMicro.readString());
                } else if (readTag == 42) {
                    setLink(codedInputStreamMicro.readString());
                } else if (readTag == 50) {
                    setDesc(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public BrandBar setDesc(String str) {
            this.hasDesc = true;
            this.desc_ = str;
            return this;
        }

        public BrandBar setImg(String str) {
            this.hasImg = true;
            this.img_ = str;
            return this;
        }

        public BrandBar setLink(String str) {
            this.hasLink = true;
            this.link_ = str;
            return this;
        }

        public BrandBar setSubtitle(String str) {
            this.hasSubtitle = true;
            this.subtitle_ = str;
            return this;
        }

        public BrandBar setTel(String str) {
            this.hasTel = true;
            this.tel_ = str;
            return this;
        }

        public BrandBar setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImg()) {
                codedOutputStreamMicro.writeString(1, getImg());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasSubtitle()) {
                codedOutputStreamMicro.writeString(3, getSubtitle());
            }
            if (hasTel()) {
                codedOutputStreamMicro.writeString(4, getTel());
            }
            if (hasLink()) {
                codedOutputStreamMicro.writeString(5, getLink());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(6, getDesc());
            }
        }

        public static BrandBar parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BrandBar) new BrandBar().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Children extends MessageMicro {
        public static final int CHILDREN_CONTENT_FIELD_NUMBER = 2;
        public static final int FATER_ID_FIELD_NUMBER = 1;
        private boolean hasFaterId;
        private String faterId_ = "";
        private List<Contents> childrenContent_ = Collections.emptyList();
        private int cachedSize = -1;

        public static Children parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Children().mergeFrom(codedInputStreamMicro);
        }

        public Children addChildrenContent(Contents contents) {
            if (contents == null) {
                return this;
            }
            if (this.childrenContent_.isEmpty()) {
                this.childrenContent_ = new ArrayList();
            }
            this.childrenContent_.add(contents);
            return this;
        }

        public final Children clear() {
            clearFaterId();
            clearChildrenContent();
            this.cachedSize = -1;
            return this;
        }

        public Children clearChildrenContent() {
            this.childrenContent_ = Collections.emptyList();
            return this;
        }

        public Children clearFaterId() {
            this.hasFaterId = false;
            this.faterId_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public Contents getChildrenContent(int i) {
            return this.childrenContent_.get(i);
        }

        public int getChildrenContentCount() {
            return this.childrenContent_.size();
        }

        public List<Contents> getChildrenContentList() {
            return this.childrenContent_;
        }

        public String getFaterId() {
            return this.faterId_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasFaterId() ? CodedOutputStreamMicro.computeStringSize(1, getFaterId()) : 0;
            Iterator<Contents> it = getChildrenContentList().iterator();
            while (it.hasNext()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, it.next());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public boolean hasFaterId() {
            return this.hasFaterId;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Children mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setFaterId(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    Contents contents = new Contents();
                    codedInputStreamMicro.readMessage(contents);
                    addChildrenContent(contents);
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Children setChildrenContent(int i, Contents contents) {
            if (contents == null) {
                return this;
            }
            this.childrenContent_.set(i, contents);
            return this;
        }

        public Children setFaterId(String str) {
            this.hasFaterId = true;
            this.faterId_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFaterId()) {
                codedOutputStreamMicro.writeString(1, getFaterId());
            }
            Iterator<Contents> it = getChildrenContentList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(2, it.next());
            }
        }

        public static Children parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Children) new Children().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Contents extends MessageMicro {
        public static final int ACC_FLAG_FIELD_NUMBER = 4;
        public static final int ADDR_FIELD_NUMBER = 5;
        public static final int ADS_DATA_FIELD_NUMBER = 80;
        public static final int ADVERTISE_INFO_FIELD_NUMBER = 78;
        public static final int AISPACE_ADS_FIELD_NUMBER = 83;
        public static final int AOI_FIELD_NUMBER = 12;
        public static final int AREA_NAME_FIELD_NUMBER = 51;
        public static final int ATTACHED_ADDR_FIELD_NUMBER = 58;
        public static final int AVOCADO_FORWARD_PARAM_FIELD_NUMBER = 66;
        public static final int BAR_BUTTON_FIELD_NUMBER = 75;
        public static final int BAR_TEMPLATE_FIELD_NUMBER = 41;
        public static final int BRAND_ICON_ID_FIELD_NUMBER = 32;
        public static final int BURIED_POINT_FIELD_NUMBER = 68;
        public static final int BUTTON_FIELD_NUMBER = 39;
        public static final int CARD_TYPE_FIELD_NUMBER = 77;
        public static final int CHILD_CATALOG_FIELD_NUMBER = 24;
        public static final int CITY_FIELD_NUMBER = 59;
        public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 38;
        public static final int DETAIL_DISPLAY_TYPE_FIELD_NUMBER = 62;
        public static final int DETAIL_FIELD_NUMBER = 6;
        public static final int DISTANCE_FIELD_NUMBER = 48;
        public static final int END_TIME_FIELD_NUMBER = 16;
        public static final int EXT_FIELD_NUMBER = 14;
        public static final int FATHER_SON_FIELD_NUMBER = 20;
        public static final int FAV_NUM_FIELD_NUMBER = 82;
        public static final int FOUR_STATE_SWITCH_FIELD_NUMBER = 79;
        public static final int GEO_FIELD_NUMBER = 1;
        public static final int HALF_KILL_FIELD_NUMBER = 70;
        public static final int HAS_RTBUS_FIELD_NUMBER = 17;
        public static final int HEADWAY_FIELD_NUMBER = 43;
        public static final int HEAD_ICON_BUBBLE_INFO_FIELD_NUMBER = 71;
        public static final int HEAD_ICON_FIELD_NUMBER = 53;
        public static final int HEAD_RESULT_MSG_FIELD_NUMBER = 73;
        public static final int HEAT_MAP_FIELD_NUMBER = 23;
        public static final int HISTORY_ADDRESS_FIELD_NUMBER = 81;
        public static final int HORIZON_SLIDE_DATA_FIELD_NUMBER = 67;
        public static final int HW_BROWSE_RECORDS_FIELD_NUMBER = 74;
        public static final int ICON_ID_FIELD_NUMBER = 30;
        public static final int INDOOR_FLOOR_FIELD_NUMBER = 36;
        public static final int INDOOR_GEOZ_FIELD_NUMBER = 64;
        public static final int INDOOR_OVER_LOOKING_FIELD_NUMBER = 54;
        public static final int INDOOR_PANO_FIELD_NUMBER = 11;
        public static final int INDOOR_PARENT_UID_FIELD_NUMBER = 37;
        public static final int INF_DYN_REQUEST_FIELD_NUMBER = 69;
        public static final int INTERVENT_TIPS_FIELD_NUMBER = 44;
        public static final int ISMODIFIED_FIELD_NUMBER = 42;
        public static final int KINDTYPE_FIELD_NUMBER = 31;
        public static final int LIST_SHOW_FIELD_NUMBER = 28;
        public static final int MAP_POITAG_FIELD_NUMBER = 40;
        public static final int MAX_SHOW_LEVEL_FIELD_NUMBER = 35;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEWSGEO_FIELD_NUMBER = 57;
        public static final int NEW_CATALOG_ID_FIELD_NUMBER = 26;
        public static final int PANO_FIELD_NUMBER = 10;
        public static final int PHOTO_LIST_FIELD_NUMBER = 52;
        public static final int POITYPE_FIELD_NUMBER = 9;
        public static final int POI_CHILD_TEXT_FIELD_NUMBER = 25;
        public static final int POI_REGION_TYPE_FIELD_NUMBER = 45;
        public static final int POI_SIMILAR_FIELD_NUMBER = 65;
        public static final int POI_TYPE_TEXT_FIELD_NUMBER = 22;
        public static final int PROVINCE_FIELD_NUMBER = 60;
        public static final int QUERY_GUIDE_FIELD_NUMBER = 63;
        public static final int RANK_FIELD_NUMBER = 34;
        public static final int RECOMMEND_TYPE_FIELD_NUMBER = 61;
        public static final int REC_REASON_FIELD_NUMBER = 7;
        public static final int REGION_TYPE_FIELD_NUMBER = 46;
        public static final int RTBUS_UPDATE_TIME_FIELD_NUMBER = 19;
        public static final int SERVICE_TAG_FIELD_NUMBER = 50;
        public static final int SGEO_FIELD_NUMBER = 21;
        public static final int SHOW_FIELD_NUMBER = 13;
        public static final int SHOW_LEVEL_FIELD_NUMBER = 29;
        public static final int START_TIME_FIELD_NUMBER = 15;
        public static final int STD_TAG_FIELD_NUMBER = 49;
        public static final int STD_TAG_ID_FIELD_NUMBER = 55;
        public static final int TAG_FIELD_NUMBER = 33;
        public static final int TEL_FIELD_NUMBER = 8;
        public static final int THIRD_PARTY_FIELD_NUMBER = 72;
        public static final int TIP_RTBUS_FIELD_NUMBER = 18;
        public static final int TRAVEL_BUTTON_FIELD_NUMBER = 76;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int VIEW_TYPE_FIELD_NUMBER = 27;
        public static final int VUI_PROCESS_DATA_FIELD_NUMBER = 56;
        private AdsData adsData_;
        private AdvertiseInfo advertiseInfo_;
        private AispaceAds aispaceAds_;
        private String areaName_;
        private int attachedAddr_;
        private String avocadoForwardParam_;
        private List<BarButton> barButton_;
        private ByteStringMicro barTemplate_;
        private String buriedPoint_;
        private Button button_;
        private int cachedSize;
        private int cardType_;
        private String city_;
        private ByteStringMicro cloudTemplate_;
        private int detailDisplayType_;
        private String distance_;
        private int favNum_;
        private int fourStateSwitch_;
        private boolean halfKill_;
        private boolean hasAccFlag;
        private boolean hasAddr;
        private boolean hasAdsData;
        private boolean hasAdvertiseInfo;
        private boolean hasAispaceAds;
        private boolean hasAoi;
        private boolean hasAreaName;
        private boolean hasAttachedAddr;
        private boolean hasAvocadoForwardParam;
        private boolean hasBarTemplate;
        private boolean hasBrandIconId;
        private boolean hasBuriedPoint;
        private boolean hasButton;
        private boolean hasCardType;
        private boolean hasChildCatalog;
        private boolean hasCity;
        private boolean hasCloudTemplate;
        private boolean hasDetail;
        private boolean hasDetailDisplayType;
        private boolean hasDistance;
        private boolean hasEndTime;
        private boolean hasExt;
        private boolean hasFatherSon;
        private boolean hasFavNum;
        private boolean hasFourStateSwitch;
        private boolean hasGeo;
        private boolean hasHalfKill;
        private boolean hasHasRtbus;
        private boolean hasHeadIcon;
        private boolean hasHeadIconBubbleInfo;
        private boolean hasHeadResultMsg;
        private boolean hasHeadway;
        private boolean hasHeatMap;
        private boolean hasHistoryAddress;
        private boolean hasHorizonSlideData;
        private boolean hasHwBrowseRecords;
        private boolean hasIconId;
        private boolean hasIndoorFloor;
        private boolean hasIndoorGeoz;
        private boolean hasIndoorOverLooking;
        private boolean hasIndoorPano;
        private boolean hasIndoorParentUid;
        private boolean hasInfDynRequest;
        private boolean hasInterventTips;
        private boolean hasIsmodified;
        private boolean hasKindtype;
        private boolean hasListShow;
        private boolean hasMapPoitag;
        private boolean hasMaxShowLevel;
        private boolean hasName;
        private boolean hasNewCatalogId;
        private boolean hasNewsgeo;
        private boolean hasPano;
        private boolean hasPhotoList;
        private boolean hasPoiChildText;
        private boolean hasPoiRegionType;
        private boolean hasPoiSimilar;
        private boolean hasPoiType;
        private boolean hasPoiTypeText;
        private boolean hasProvince;
        private boolean hasQueryGuide;
        private boolean hasRank;
        private boolean hasRecommendType;
        private boolean hasRegionType;
        private boolean hasRtbusUpdateTime;
        private boolean hasServiceTag;
        private boolean hasSgeo;
        private boolean hasShow;
        private boolean hasShowLevel;
        private boolean hasStartTime;
        private boolean hasStdTag;
        private boolean hasStdTagId;
        private boolean hasTag;
        private boolean hasTel;
        private boolean hasThirdParty;
        private boolean hasTipRtbus;
        private boolean hasTravelButton;
        private boolean hasUid;
        private boolean hasViewType;
        private boolean hasVuiProcessData;
        private HeadIconBubbleInfo headIconBubbleInfo_;
        private HeadIcon headIcon_;
        private ByteStringMicro headResultMsg_;
        private String headway_;
        private String historyAddress_;
        private String horizonSlideData_;
        private StartPageData hwBrowseRecords_;
        private int indoorGeoz_;
        private int indoorOverLooking_;
        private int infDynRequest_;
        private String interventTips_;
        private int ismodified_;
        private MapPoitag mapPoitag_;
        private Sgeo newsgeo_;
        private String photoList_;
        private String poiRegionType_;
        private PoiSimilar poiSimilar_;
        private String province_;
        private String queryGuide_;
        private int recommendType_;
        private String regionType_;
        private String serviceTag_;
        private String stdTagId_;
        private String stdTag_;
        private ThirdParty thirdParty_;
        private TravelButton travelButton_;
        private VuiProcessData vuiProcessData_;
        private Show show_ = null;
        private Ext ext_ = null;
        private HeatMap heatMap_ = null;
        private Sgeo sgeo_ = null;
        private String geo_ = "";
        private String name_ = "";
        private String uid_ = "";
        private int accFlag_ = 0;
        private String addr_ = "";
        private int detail_ = 0;
        private List<String> recReason_ = Collections.emptyList();
        private String tel_ = "";
        private int poiType_ = 0;
        private int pano_ = 0;
        private String indoorPano_ = "";
        private String aoi_ = "";
        private String startTime_ = "";
        private String endTime_ = "";
        private int hasRtbus_ = 0;
        private String tipRtbus_ = "";
        private int rtbusUpdateTime_ = 0;
        private int fatherSon_ = 0;
        private String poiTypeText_ = "";
        private String childCatalog_ = "";
        private String poiChildText_ = "";
        private String newCatalogId_ = "";
        private int viewType_ = 0;
        private int listShow_ = 0;
        private int showLevel_ = 0;
        private int iconId_ = 0;
        private int kindtype_ = 0;
        private int brandIconId_ = 0;
        private int tag_ = 0;
        private int rank_ = 0;
        private int maxShowLevel_ = 0;
        private String indoorFloor_ = "";
        private String indoorParentUid_ = "";

        /* loaded from: classes7.dex */
        public static final class AdsData extends MessageMicro {
            public static final int FLOAT_ICON_FIELD_NUMBER = 1;
            private boolean hasFloatIcon;
            private AdsPoiFloatIcon floatIcon_ = null;
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class AdsPoiFloatIcon extends MessageMicro {
                public static final int DATA_FIELD_NUMBER = 1;
                private boolean hasData;
                private String data_ = "";
                private int cachedSize = -1;

                public static AdsPoiFloatIcon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new AdsPoiFloatIcon().mergeFrom(codedInputStreamMicro);
                }

                public final AdsPoiFloatIcon clear() {
                    clearData();
                    this.cachedSize = -1;
                    return this;
                }

                public AdsPoiFloatIcon clearData() {
                    this.hasData = false;
                    this.data_ = "";
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getData() {
                    return this.data_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasData() ? CodedOutputStreamMicro.computeStringSize(1, getData()) : 0;
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public boolean hasData() {
                    return this.hasData;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public AdsPoiFloatIcon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setData(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public AdsPoiFloatIcon setData(String str) {
                    this.hasData = true;
                    this.data_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasData()) {
                        codedOutputStreamMicro.writeString(1, getData());
                    }
                }

                public static AdsPoiFloatIcon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (AdsPoiFloatIcon) new AdsPoiFloatIcon().mergeFrom(bArr);
                }
            }

            public static AdsData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdsData().mergeFrom(codedInputStreamMicro);
            }

            public final AdsData clear() {
                clearFloatIcon();
                this.cachedSize = -1;
                return this;
            }

            public AdsData clearFloatIcon() {
                this.hasFloatIcon = false;
                this.floatIcon_ = null;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public AdsPoiFloatIcon getFloatIcon() {
                return this.floatIcon_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeMessageSize = hasFloatIcon() ? CodedOutputStreamMicro.computeMessageSize(1, getFloatIcon()) : 0;
                this.cachedSize = computeMessageSize;
                return computeMessageSize;
            }

            public boolean hasFloatIcon() {
                return this.hasFloatIcon;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AdsData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        AdsPoiFloatIcon adsPoiFloatIcon = new AdsPoiFloatIcon();
                        codedInputStreamMicro.readMessage(adsPoiFloatIcon);
                        setFloatIcon(adsPoiFloatIcon);
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AdsData setFloatIcon(AdsPoiFloatIcon adsPoiFloatIcon) {
                if (adsPoiFloatIcon == null) {
                    return clearFloatIcon();
                }
                this.hasFloatIcon = true;
                this.floatIcon_ = adsPoiFloatIcon;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasFloatIcon()) {
                    codedOutputStreamMicro.writeMessage(1, getFloatIcon());
                }
            }

            public static AdsData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdsData) new AdsData().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class AdvertiseInfo extends MessageMicro {
            public static final int JUMP_URL_FIELD_NUMBER = 3;
            public static final int LOCATION_FIELD_NUMBER = 2;
            public static final int PIC_URL_FIELD_NUMBER = 1;
            private boolean hasJumpUrl;
            private boolean hasLocation;
            private boolean hasPicUrl;
            private String picUrl_ = "";
            private int location_ = 0;
            private String jumpUrl_ = "";
            private int cachedSize = -1;

            public static AdvertiseInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdvertiseInfo().mergeFrom(codedInputStreamMicro);
            }

            public final AdvertiseInfo clear() {
                clearPicUrl();
                clearLocation();
                clearJumpUrl();
                this.cachedSize = -1;
                return this;
            }

            public AdvertiseInfo clearJumpUrl() {
                this.hasJumpUrl = false;
                this.jumpUrl_ = "";
                return this;
            }

            public AdvertiseInfo clearLocation() {
                this.hasLocation = false;
                this.location_ = 0;
                return this;
            }

            public AdvertiseInfo clearPicUrl() {
                this.hasPicUrl = false;
                this.picUrl_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getJumpUrl() {
                return this.jumpUrl_;
            }

            public int getLocation() {
                return this.location_;
            }

            public String getPicUrl() {
                return this.picUrl_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasPicUrl() ? CodedOutputStreamMicro.computeStringSize(1, getPicUrl()) : 0;
                if (hasLocation()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getLocation());
                }
                if (hasJumpUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getJumpUrl());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public boolean hasJumpUrl() {
                return this.hasJumpUrl;
            }

            public boolean hasLocation() {
                return this.hasLocation;
            }

            public boolean hasPicUrl() {
                return this.hasPicUrl;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AdvertiseInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setPicUrl(codedInputStreamMicro.readString());
                    } else if (readTag == 16) {
                        setLocation(codedInputStreamMicro.readInt32());
                    } else if (readTag == 26) {
                        setJumpUrl(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AdvertiseInfo setJumpUrl(String str) {
                this.hasJumpUrl = true;
                this.jumpUrl_ = str;
                return this;
            }

            public AdvertiseInfo setLocation(int i) {
                this.hasLocation = true;
                this.location_ = i;
                return this;
            }

            public AdvertiseInfo setPicUrl(String str) {
                this.hasPicUrl = true;
                this.picUrl_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPicUrl()) {
                    codedOutputStreamMicro.writeString(1, getPicUrl());
                }
                if (hasLocation()) {
                    codedOutputStreamMicro.writeInt32(2, getLocation());
                }
                if (hasJumpUrl()) {
                    codedOutputStreamMicro.writeString(3, getJumpUrl());
                }
            }

            public static AdvertiseInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdvertiseInfo) new AdvertiseInfo().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class AispaceAds extends MessageMicro {
            public static final int DATA_FIELD_NUMBER = 1;
            private boolean hasData;
            private String data_ = "";
            private int cachedSize = -1;

            public static AispaceAds parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AispaceAds().mergeFrom(codedInputStreamMicro);
            }

            public final AispaceAds clear() {
                clearData();
                this.cachedSize = -1;
                return this;
            }

            public AispaceAds clearData() {
                this.hasData = false;
                this.data_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getData() {
                return this.data_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasData() ? CodedOutputStreamMicro.computeStringSize(1, getData()) : 0;
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public boolean hasData() {
                return this.hasData;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AispaceAds mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setData(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AispaceAds setData(String str) {
                this.hasData = true;
                this.data_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasData()) {
                    codedOutputStreamMicro.writeString(1, getData());
                }
            }

            public static AispaceAds parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AispaceAds) new AispaceAds().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class BarButton extends MessageMicro {
            public static final int ALL_POS = 0;
            public static final int BAR_FIELD_NUMBER = 1;
            public static final int DETAIL_POS = 2;
            public static final int POS_FIELD_NUMBER = 2;
            public static final int SLIDE_POS = 1;
            private boolean hasBar;
            private boolean hasPos;
            private Button bar_ = null;
            private int pos_ = 0;
            private int cachedSize = -1;

            public static BarButton parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new BarButton().mergeFrom(codedInputStreamMicro);
            }

            public final BarButton clear() {
                clearBar();
                clearPos();
                this.cachedSize = -1;
                return this;
            }

            public BarButton clearBar() {
                this.hasBar = false;
                this.bar_ = null;
                return this;
            }

            public BarButton clearPos() {
                this.hasPos = false;
                this.pos_ = 0;
                return this;
            }

            public Button getBar() {
                return this.bar_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getPos() {
                return this.pos_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeMessageSize = hasBar() ? CodedOutputStreamMicro.computeMessageSize(1, getBar()) : 0;
                if (hasPos()) {
                    computeMessageSize += CodedOutputStreamMicro.computeInt32Size(2, getPos());
                }
                this.cachedSize = computeMessageSize;
                return computeMessageSize;
            }

            public boolean hasBar() {
                return this.hasBar;
            }

            public boolean hasPos() {
                return this.hasPos;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public BarButton mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        Button button = new Button();
                        codedInputStreamMicro.readMessage(button);
                        setBar(button);
                    } else if (readTag == 16) {
                        setPos(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public BarButton setBar(Button button) {
                if (button == null) {
                    return clearBar();
                }
                this.hasBar = true;
                this.bar_ = button;
                return this;
            }

            public BarButton setPos(int i) {
                this.hasPos = true;
                this.pos_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasBar()) {
                    codedOutputStreamMicro.writeMessage(1, getBar());
                }
                if (hasPos()) {
                    codedOutputStreamMicro.writeInt32(2, getPos());
                }
            }

            public static BarButton parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (BarButton) new BarButton().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Button extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int GIF_URL_FIELD_NUMBER = 6;
            public static final int HINT_TEXT_FIELD_NUMBER = 9;
            public static final int ICON_URL_FIELD_NUMBER = 4;
            public static final int ONCE_BUBBLE_FIELD_NUMBER = 7;
            public static final int ONCE_BUBBLE_ICON_URL_FIELD_NUMBER = 8;
            public static final int SUB_ICON_URL_FIELD_NUMBER = 5;
            public static final int TIME_DURATION_FIELD_NUMBER = 11;
            public static final int TIME_ENTRANCE_FIELD_NUMBER = 10;
            public static final int TITLE_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 3;
            private boolean hasContent;
            private boolean hasGifUrl;
            private boolean hasHintText;
            private boolean hasIconUrl;
            private boolean hasOnceBubble;
            private boolean hasOnceBubbleIconUrl;
            private boolean hasSubIconUrl;
            private boolean hasTimeDuration;
            private boolean hasTimeEntrance;
            private boolean hasTitle;
            private boolean hasType;
            private String content_ = "";
            private String title_ = "";
            private String type_ = "";
            private String iconUrl_ = "";
            private String subIconUrl_ = "";
            private String gifUrl_ = "";
            private String onceBubble_ = "";
            private String onceBubbleIconUrl_ = "";
            private String hintText_ = "";
            private int timeEntrance_ = 0;
            private int timeDuration_ = 0;
            private int cachedSize = -1;

            public static Button parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Button().mergeFrom(codedInputStreamMicro);
            }

            public final Button clear() {
                clearContent();
                clearTitle();
                clearType();
                clearIconUrl();
                clearSubIconUrl();
                clearGifUrl();
                clearOnceBubble();
                clearOnceBubbleIconUrl();
                clearHintText();
                clearTimeEntrance();
                clearTimeDuration();
                this.cachedSize = -1;
                return this;
            }

            public Button clearContent() {
                this.hasContent = false;
                this.content_ = "";
                return this;
            }

            public Button clearGifUrl() {
                this.hasGifUrl = false;
                this.gifUrl_ = "";
                return this;
            }

            public Button clearHintText() {
                this.hasHintText = false;
                this.hintText_ = "";
                return this;
            }

            public Button clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public Button clearOnceBubble() {
                this.hasOnceBubble = false;
                this.onceBubble_ = "";
                return this;
            }

            public Button clearOnceBubbleIconUrl() {
                this.hasOnceBubbleIconUrl = false;
                this.onceBubbleIconUrl_ = "";
                return this;
            }

            public Button clearSubIconUrl() {
                this.hasSubIconUrl = false;
                this.subIconUrl_ = "";
                return this;
            }

            public Button clearTimeDuration() {
                this.hasTimeDuration = false;
                this.timeDuration_ = 0;
                return this;
            }

            public Button clearTimeEntrance() {
                this.hasTimeEntrance = false;
                this.timeEntrance_ = 0;
                return this;
            }

            public Button clearTitle() {
                this.hasTitle = false;
                this.title_ = "";
                return this;
            }

            public Button clearType() {
                this.hasType = false;
                this.type_ = "";
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

            public String getGifUrl() {
                return this.gifUrl_;
            }

            public String getHintText() {
                return this.hintText_;
            }

            public String getIconUrl() {
                return this.iconUrl_;
            }

            public String getOnceBubble() {
                return this.onceBubble_;
            }

            public String getOnceBubbleIconUrl() {
                return this.onceBubbleIconUrl_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasContent() ? CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (hasTitle()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                }
                if (hasType()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getType());
                }
                if (hasIconUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getIconUrl());
                }
                if (hasSubIconUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getSubIconUrl());
                }
                if (hasGifUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getGifUrl());
                }
                if (hasOnceBubble()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getOnceBubble());
                }
                if (hasOnceBubbleIconUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getOnceBubbleIconUrl());
                }
                if (hasHintText()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(9, getHintText());
                }
                if (hasTimeEntrance()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(10, getTimeEntrance());
                }
                if (hasTimeDuration()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(11, getTimeDuration());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getSubIconUrl() {
                return this.subIconUrl_;
            }

            public int getTimeDuration() {
                return this.timeDuration_;
            }

            public int getTimeEntrance() {
                return this.timeEntrance_;
            }

            public String getTitle() {
                return this.title_;
            }

            public String getType() {
                return this.type_;
            }

            public boolean hasContent() {
                return this.hasContent;
            }

            public boolean hasGifUrl() {
                return this.hasGifUrl;
            }

            public boolean hasHintText() {
                return this.hasHintText;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasOnceBubble() {
                return this.hasOnceBubble;
            }

            public boolean hasOnceBubbleIconUrl() {
                return this.hasOnceBubbleIconUrl;
            }

            public boolean hasSubIconUrl() {
                return this.hasSubIconUrl;
            }

            public boolean hasTimeDuration() {
                return this.hasTimeDuration;
            }

            public boolean hasTimeEntrance() {
                return this.hasTimeEntrance;
            }

            public boolean hasTitle() {
                return this.hasTitle;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Button mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 10:
                            setContent(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            setTitle(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            setType(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            setIconUrl(codedInputStreamMicro.readString());
                            break;
                        case 42:
                            setSubIconUrl(codedInputStreamMicro.readString());
                            break;
                        case 50:
                            setGifUrl(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            setOnceBubble(codedInputStreamMicro.readString());
                            break;
                        case 66:
                            setOnceBubbleIconUrl(codedInputStreamMicro.readString());
                            break;
                        case 74:
                            setHintText(codedInputStreamMicro.readString());
                            break;
                        case 80:
                            setTimeEntrance(codedInputStreamMicro.readInt32());
                            break;
                        case 88:
                            setTimeDuration(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public Button setContent(String str) {
                this.hasContent = true;
                this.content_ = str;
                return this;
            }

            public Button setGifUrl(String str) {
                this.hasGifUrl = true;
                this.gifUrl_ = str;
                return this;
            }

            public Button setHintText(String str) {
                this.hasHintText = true;
                this.hintText_ = str;
                return this;
            }

            public Button setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public Button setOnceBubble(String str) {
                this.hasOnceBubble = true;
                this.onceBubble_ = str;
                return this;
            }

            public Button setOnceBubbleIconUrl(String str) {
                this.hasOnceBubbleIconUrl = true;
                this.onceBubbleIconUrl_ = str;
                return this;
            }

            public Button setSubIconUrl(String str) {
                this.hasSubIconUrl = true;
                this.subIconUrl_ = str;
                return this;
            }

            public Button setTimeDuration(int i) {
                this.hasTimeDuration = true;
                this.timeDuration_ = i;
                return this;
            }

            public Button setTimeEntrance(int i) {
                this.hasTimeEntrance = true;
                this.timeEntrance_ = i;
                return this;
            }

            public Button setTitle(String str) {
                this.hasTitle = true;
                this.title_ = str;
                return this;
            }

            public Button setType(String str) {
                this.hasType = true;
                this.type_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasContent()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(2, getTitle());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeString(3, getType());
                }
                if (hasIconUrl()) {
                    codedOutputStreamMicro.writeString(4, getIconUrl());
                }
                if (hasSubIconUrl()) {
                    codedOutputStreamMicro.writeString(5, getSubIconUrl());
                }
                if (hasGifUrl()) {
                    codedOutputStreamMicro.writeString(6, getGifUrl());
                }
                if (hasOnceBubble()) {
                    codedOutputStreamMicro.writeString(7, getOnceBubble());
                }
                if (hasOnceBubbleIconUrl()) {
                    codedOutputStreamMicro.writeString(8, getOnceBubbleIconUrl());
                }
                if (hasHintText()) {
                    codedOutputStreamMicro.writeString(9, getHintText());
                }
                if (hasTimeEntrance()) {
                    codedOutputStreamMicro.writeInt32(10, getTimeEntrance());
                }
                if (hasTimeDuration()) {
                    codedOutputStreamMicro.writeInt32(11, getTimeDuration());
                }
            }

            public static Button parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Button) new Button().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Ext extends MessageMicro {
            public static final int ADV_INFO_FIELD_NUMBER = 3;
            public static final int DETAIL_INFO_FIELD_NUMBER = 2;
            public static final int SRC_NAME_FIELD_NUMBER = 1;
            private boolean hasAdvInfo;
            private boolean hasDetailInfo;
            private boolean hasSrcName;
            private DetailInfo detailInfo_ = null;
            private String srcName_ = "";
            private AdvInfo advInfo_ = null;
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class AdvInfo extends MessageMicro {
                public static final int OP_INFO_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasOpInfo;
                private boolean hasType;
                private String type_ = "";
                private OpInfo opInfo_ = null;
                private int cachedSize = -1;

                /* loaded from: classes7.dex */
                public static final class OpInfo extends MessageMicro {
                    public static final int ADDR_FIELD_NUMBER = 8;
                    public static final int ADVID_FIELD_NUMBER = 5;
                    public static final int CITY_FIELD_NUMBER = 6;
                    public static final int DES_FIELD_NUMBER = 4;
                    public static final int ICON_FIELD_NUMBER = 2;
                    public static final int NAME_FIELD_NUMBER = 7;
                    public static final int PRIMARY_UID_FIELD_NUMBER = 1;
                    public static final int SDES_FIELD_NUMBER = 3;
                    public static final int URL_FIELD_NUMBER = 9;
                    private boolean hasAddr;
                    private boolean hasAdvid;
                    private boolean hasCity;
                    private boolean hasDes;
                    private boolean hasIcon;
                    private boolean hasName;
                    private boolean hasPrimaryUid;
                    private boolean hasSdes;
                    private boolean hasUrl;
                    private String primaryUid_ = "";
                    private String icon_ = "";
                    private String sdes_ = "";
                    private String des_ = "";
                    private String advid_ = "";
                    private String city_ = "";
                    private String name_ = "";
                    private String addr_ = "";
                    private String url_ = "";
                    private int cachedSize = -1;

                    public static OpInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new OpInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public final OpInfo clear() {
                        clearPrimaryUid();
                        clearIcon();
                        clearSdes();
                        clearDes();
                        clearAdvid();
                        clearCity();
                        clearName();
                        clearAddr();
                        clearUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public OpInfo clearAddr() {
                        this.hasAddr = false;
                        this.addr_ = "";
                        return this;
                    }

                    public OpInfo clearAdvid() {
                        this.hasAdvid = false;
                        this.advid_ = "";
                        return this;
                    }

                    public OpInfo clearCity() {
                        this.hasCity = false;
                        this.city_ = "";
                        return this;
                    }

                    public OpInfo clearDes() {
                        this.hasDes = false;
                        this.des_ = "";
                        return this;
                    }

                    public OpInfo clearIcon() {
                        this.hasIcon = false;
                        this.icon_ = "";
                        return this;
                    }

                    public OpInfo clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public OpInfo clearPrimaryUid() {
                        this.hasPrimaryUid = false;
                        this.primaryUid_ = "";
                        return this;
                    }

                    public OpInfo clearSdes() {
                        this.hasSdes = false;
                        this.sdes_ = "";
                        return this;
                    }

                    public OpInfo clearUrl() {
                        this.hasUrl = false;
                        this.url_ = "";
                        return this;
                    }

                    public String getAddr() {
                        return this.addr_;
                    }

                    public String getAdvid() {
                        return this.advid_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getCity() {
                        return this.city_;
                    }

                    public String getDes() {
                        return this.des_;
                    }

                    public String getIcon() {
                        return this.icon_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    public String getPrimaryUid() {
                        return this.primaryUid_;
                    }

                    public String getSdes() {
                        return this.sdes_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasPrimaryUid() ? CodedOutputStreamMicro.computeStringSize(1, getPrimaryUid()) : 0;
                        if (hasIcon()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getIcon());
                        }
                        if (hasSdes()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getSdes());
                        }
                        if (hasDes()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDes());
                        }
                        if (hasAdvid()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getAdvid());
                        }
                        if (hasCity()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getCity());
                        }
                        if (hasName()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getName());
                        }
                        if (hasAddr()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getAddr());
                        }
                        if (hasUrl()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(9, getUrl());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public String getUrl() {
                        return this.url_;
                    }

                    public boolean hasAddr() {
                        return this.hasAddr;
                    }

                    public boolean hasAdvid() {
                        return this.hasAdvid;
                    }

                    public boolean hasCity() {
                        return this.hasCity;
                    }

                    public boolean hasDes() {
                        return this.hasDes;
                    }

                    public boolean hasIcon() {
                        return this.hasIcon;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasPrimaryUid() {
                        return this.hasPrimaryUid;
                    }

                    public boolean hasSdes() {
                        return this.hasSdes;
                    }

                    public boolean hasUrl() {
                        return this.hasUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public OpInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setPrimaryUid(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setIcon(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                setSdes(codedInputStreamMicro.readString());
                            } else if (readTag == 34) {
                                setDes(codedInputStreamMicro.readString());
                            } else if (readTag == 42) {
                                setAdvid(codedInputStreamMicro.readString());
                            } else if (readTag == 50) {
                                setCity(codedInputStreamMicro.readString());
                            } else if (readTag == 58) {
                                setName(codedInputStreamMicro.readString());
                            } else if (readTag == 66) {
                                setAddr(codedInputStreamMicro.readString());
                            } else if (readTag == 74) {
                                setUrl(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public OpInfo setAddr(String str) {
                        this.hasAddr = true;
                        this.addr_ = str;
                        return this;
                    }

                    public OpInfo setAdvid(String str) {
                        this.hasAdvid = true;
                        this.advid_ = str;
                        return this;
                    }

                    public OpInfo setCity(String str) {
                        this.hasCity = true;
                        this.city_ = str;
                        return this;
                    }

                    public OpInfo setDes(String str) {
                        this.hasDes = true;
                        this.des_ = str;
                        return this;
                    }

                    public OpInfo setIcon(String str) {
                        this.hasIcon = true;
                        this.icon_ = str;
                        return this;
                    }

                    public OpInfo setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public OpInfo setPrimaryUid(String str) {
                        this.hasPrimaryUid = true;
                        this.primaryUid_ = str;
                        return this;
                    }

                    public OpInfo setSdes(String str) {
                        this.hasSdes = true;
                        this.sdes_ = str;
                        return this;
                    }

                    public OpInfo setUrl(String str) {
                        this.hasUrl = true;
                        this.url_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasPrimaryUid()) {
                            codedOutputStreamMicro.writeString(1, getPrimaryUid());
                        }
                        if (hasIcon()) {
                            codedOutputStreamMicro.writeString(2, getIcon());
                        }
                        if (hasSdes()) {
                            codedOutputStreamMicro.writeString(3, getSdes());
                        }
                        if (hasDes()) {
                            codedOutputStreamMicro.writeString(4, getDes());
                        }
                        if (hasAdvid()) {
                            codedOutputStreamMicro.writeString(5, getAdvid());
                        }
                        if (hasCity()) {
                            codedOutputStreamMicro.writeString(6, getCity());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(7, getName());
                        }
                        if (hasAddr()) {
                            codedOutputStreamMicro.writeString(8, getAddr());
                        }
                        if (hasUrl()) {
                            codedOutputStreamMicro.writeString(9, getUrl());
                        }
                    }

                    public static OpInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (OpInfo) new OpInfo().mergeFrom(bArr);
                    }
                }

                public static AdvInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new AdvInfo().mergeFrom(codedInputStreamMicro);
                }

                public final AdvInfo clear() {
                    clearType();
                    clearOpInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public AdvInfo clearOpInfo() {
                    this.hasOpInfo = false;
                    this.opInfo_ = null;
                    return this;
                }

                public AdvInfo clearType() {
                    this.hasType = false;
                    this.type_ = "";
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public OpInfo getOpInfo() {
                    return this.opInfo_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeStringSize = hasType() ? CodedOutputStreamMicro.computeStringSize(1, getType()) : 0;
                    if (hasOpInfo()) {
                        computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, getOpInfo());
                    }
                    this.cachedSize = computeStringSize;
                    return computeStringSize;
                }

                public String getType() {
                    return this.type_;
                }

                public boolean hasOpInfo() {
                    return this.hasOpInfo;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public AdvInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 10) {
                            setType(codedInputStreamMicro.readString());
                        } else if (readTag == 18) {
                            OpInfo opInfo = new OpInfo();
                            codedInputStreamMicro.readMessage(opInfo);
                            setOpInfo(opInfo);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public AdvInfo setOpInfo(OpInfo opInfo) {
                    if (opInfo == null) {
                        return clearOpInfo();
                    }
                    this.hasOpInfo = true;
                    this.opInfo_ = opInfo;
                    return this;
                }

                public AdvInfo setType(String str) {
                    this.hasType = true;
                    this.type_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeString(1, getType());
                    }
                    if (hasOpInfo()) {
                        codedOutputStreamMicro.writeMessage(2, getOpInfo());
                    }
                }

                public static AdvInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (AdvInfo) new AdvInfo().mergeFrom(bArr);
                }
            }

            /* loaded from: classes7.dex */
            public static final class DetailInfo extends MessageMicro {
                public static final int ACTIVITY_FIELD_NUMBER = 23;
                public static final int ALLCARDEXTENSION_FIELD_NUMBER = 47;
                public static final int AOI_FIELD_NUMBER = 43;
                public static final int BLINK_BUILDING_FIELD_NUMBER = 55;
                public static final int BOOK_INFO_FIELD_NUMBER = 18;
                public static final int BUSINESS_SERVICE_FIELD_NUMBER = 37;
                public static final int COMMENT_NUM_FIELD_NUMBER = 11;
                public static final int DISCOUNT_FIELD_NUMBER = 21;
                public static final int DISCOUNT_TOTAL_FIELD_NUMBER = 8;
                public static final int DISPLAY_INFO_COMMENT_LABEL_FIELD_NUMBER = 41;
                public static final int DISPLAY_INFO_REDU_FIELD_NUMBER = 40;
                public static final int DIS_TEXT_FIELD_NUMBER = 33;
                public static final int FLAG_FIELD_NUMBER = 1;
                public static final int FLAG_ON_LEFT_FIELD_NUMBER = 26;
                public static final int GRADE_FIELD_NUMBER = 22;
                public static final int GROUPON_FLAG_FIELD_NUMBER = 14;
                public static final int GROUPON_INFO_FIELD_NUMBER = 15;
                public static final int GROUPON_TOTAL_FIELD_NUMBER = 9;
                public static final int GUIDE_FIELD_NUMBER = 24;
                public static final int HOTEL_SERVICE_FIELD_NUMBER = 46;
                public static final int IMAGE_FIELD_NUMBER = 5;
                public static final int IMPRESSION_FIELD_NUMBER = 27;
                public static final int LBC_BUSINESS_VIP_FIELD_NUMBER = 34;
                public static final int MARKETBIZ_FIELD_NUMBER = 30;
                public static final int MBC_FIELD_NUMBER = 42;
                public static final int MEISHIPAIHAO_FIELD_NUMBER = 28;
                public static final int MINIPROGRAM_FIELD_NUMBER = 53;
                public static final int MNP_KEY_INFO_FIELD_NUMBER = 54;
                public static final int MOVIE_FILM_COUNT_FIELD_NUMBER = 13;
                public static final int MOVIE_FLAG_FIELD_NUMBER = 12;
                public static final int NEW_BUSINESS_TIME_FIELD_NUMBER = 52;
                public static final int ORIGIN_PRICE_TEXT_FIELD_NUMBER = 45;
                public static final int ORIL_INFO_FIELD_NUMBER = 16;
                public static final int OVERALL_RATING_FIELD_NUMBER = 2;
                public static final int PHONE_DETAIL_FIELD_NUMBER = 50;
                public static final int PHONE_RISK_FIELD_NUMBER = 51;
                public static final int PREMIUM_FLAG_FIELD_NUMBER = 7;
                public static final int PREMIUM_INFO_FIELD_NUMBER = 10;
                public static final int PRICE_FIELD_NUMBER = 19;
                public static final int PRICE_TEXT_FIELD_NUMBER = 3;
                public static final int RECOMMEND_DISH_FIELD_NUMBER = 36;
                public static final int SHOP_HOURS_FIELD_NUMBER = 48;
                public static final int SHOW_INFO_FIELD_NUMBER = 6;
                public static final int SPECIAL_SERVICE_FIELD_NUMBER = 25;
                public static final int SPECIAL_TAG_FIELD_NUMBER = 44;
                public static final int STATUS_LABEL_FIELD_NUMBER = 38;
                public static final int TAG_FIELD_NUMBER = 4;
                public static final int TRADE_TAG_FIELD_NUMBER = 29;
                public static final int UPPERLEFTCORNER_FIELD_NUMBER = 39;
                public static final int VALIDATE_FIELD_NUMBER = 31;
                public static final int VS_CONTENT_FIELD_NUMBER = 49;
                public static final int WAP_BOOKABLE_FIELD_NUMBER = 17;
                public static final int WISE_FULLROOM_FIELD_NUMBER = 20;
                public static final int WISE_HOURLY_BOOKABLE_FIELD_NUMBER = 32;
                private boolean hasAllcardextension;
                private boolean hasAoi;
                private boolean hasBlinkBuilding;
                private boolean hasBookInfo;
                private boolean hasBusinessService;
                private boolean hasCommentNum;
                private boolean hasDisText;
                private boolean hasDiscount;
                private boolean hasDiscountTotal;
                private boolean hasDisplayInfoCommentLabel;
                private boolean hasDisplayInfoRedu;
                private boolean hasFlagOnLeft;
                private boolean hasGrade;
                private boolean hasGrouponFlag;
                private boolean hasGrouponInfo;
                private boolean hasGrouponTotal;
                private boolean hasGuide;
                private boolean hasImage;
                private boolean hasLbcBusinessVip;
                private boolean hasMarketbiz;
                private boolean hasMbc;
                private boolean hasMeishipaihao;
                private boolean hasMiniprogram;
                private boolean hasMnpKeyInfo;
                private boolean hasMovieFilmCount;
                private boolean hasMovieFlag;
                private boolean hasNewBusinessTime;
                private boolean hasOriginPriceText;
                private boolean hasOrilInfo;
                private boolean hasOverallRating;
                private boolean hasPhoneDetail;
                private boolean hasPhoneRisk;
                private boolean hasPremiumFlag;
                private boolean hasPremiumInfo;
                private boolean hasPrice;
                private boolean hasPriceText;
                private boolean hasRecommendDish;
                private boolean hasShopHours;
                private boolean hasShowInfo;
                private boolean hasSpecialService;
                private boolean hasSpecialTag;
                private boolean hasStatusLabel;
                private boolean hasTag;
                private boolean hasTradeTag;
                private boolean hasUpperleftcorner;
                private boolean hasValidate;
                private boolean hasVsContent;
                private boolean hasWapBookable;
                private boolean hasWiseFullroom;
                private boolean hasWiseHourlyBookable;
                private PremiumInfo premiumInfo_ = null;
                private GrouponInfo grouponInfo_ = null;
                private OrilInfo orilInfo_ = null;
                private BookInfo bookInfo_ = null;
                private List<Activity> activity_ = Collections.emptyList();
                private List<String> flag_ = Collections.emptyList();
                private String overallRating_ = "";
                private String priceText_ = "";
                private String tag_ = "";
                private String image_ = "";
                private String showInfo_ = "";
                private int premiumFlag_ = 0;
                private int discountTotal_ = 0;
                private int grouponTotal_ = 0;
                private String commentNum_ = "";
                private String movieFlag_ = "";
                private int movieFilmCount_ = 0;
                private int grouponFlag_ = 0;
                private String wapBookable_ = "";
                private String price_ = "";
                private String wiseFullroom_ = "";
                private String discount_ = "";
                private String grade_ = "";
                private String guide_ = "";
                private String specialService_ = "";
                private String flagOnLeft_ = "";
                private List<Impression> impression_ = Collections.emptyList();
                private Meishipaihao meishipaihao_ = null;
                private String tradeTag_ = "";
                private Marketbiz marketbiz_ = null;
                private String validate_ = "";
                private String wiseHourlyBookable_ = "";
                private String disText_ = "";
                private LbcBusinessVip lbcBusinessVip_ = null;
                private RecommendDish recommendDish_ = null;
                private BusinessService businessService_ = null;
                private String statusLabel_ = "";
                private Upperleftcorner upperleftcorner_ = null;
                private String displayInfoRedu_ = "";
                private DisplayInfoCommentLabel displayInfoCommentLabel_ = null;
                private Mbc mbc_ = null;
                private String aoi_ = "";
                private String specialTag_ = "";
                private String originPriceText_ = "";
                private List<HotelService> hotelService_ = Collections.emptyList();
                private Allcardextension allcardextension_ = null;
                private String shopHours_ = "";
                private String vsContent_ = "";
                private PhoneDetail phoneDetail_ = null;
                private PhoneRisk phoneRisk_ = null;
                private String newBusinessTime_ = "";
                private String miniprogram_ = "";
                private MnpKeyInfo mnpKeyInfo_ = null;
                private BlinkBuilding blinkBuilding_ = null;
                private int cachedSize = -1;

                /* loaded from: classes7.dex */
                public static final class Activity extends MessageMicro {
                    public static final int ACTIVITY_PRICE_FIELD_NUMBER = 9;
                    public static final int BG_COLOR_FIELD_NUMBER = 4;
                    public static final int COLOR_FIELD_NUMBER = 3;
                    public static final int DESC_FIELD_NUMBER = 5;
                    public static final int HREF_FIELD_NUMBER = 6;
                    public static final int IMG_URL_FIELD_NUMBER = 7;
                    public static final int LEVEL_FIELD_NUMBER = 1;
                    public static final int ORIGIN_PRICE_FIELD_NUMBER = 8;
                    public static final int TITLE_FIELD_NUMBER = 2;
                    private boolean hasActivityPrice;
                    private boolean hasBgColor;
                    private boolean hasColor;
                    private boolean hasDesc;
                    private boolean hasHref;
                    private boolean hasImgUrl;
                    private boolean hasLevel;
                    private boolean hasOriginPrice;
                    private boolean hasTitle;
                    private String level_ = "";
                    private String title_ = "";
                    private String color_ = "";
                    private String bgColor_ = "";
                    private String desc_ = "";
                    private String href_ = "";
                    private String imgUrl_ = "";
                    private String originPrice_ = "";
                    private String activityPrice_ = "";
                    private int cachedSize = -1;

                    public static Activity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Activity().mergeFrom(codedInputStreamMicro);
                    }

                    public final Activity clear() {
                        clearLevel();
                        clearTitle();
                        clearColor();
                        clearBgColor();
                        clearDesc();
                        clearHref();
                        clearImgUrl();
                        clearOriginPrice();
                        clearActivityPrice();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Activity clearActivityPrice() {
                        this.hasActivityPrice = false;
                        this.activityPrice_ = "";
                        return this;
                    }

                    public Activity clearBgColor() {
                        this.hasBgColor = false;
                        this.bgColor_ = "";
                        return this;
                    }

                    public Activity clearColor() {
                        this.hasColor = false;
                        this.color_ = "";
                        return this;
                    }

                    public Activity clearDesc() {
                        this.hasDesc = false;
                        this.desc_ = "";
                        return this;
                    }

                    public Activity clearHref() {
                        this.hasHref = false;
                        this.href_ = "";
                        return this;
                    }

                    public Activity clearImgUrl() {
                        this.hasImgUrl = false;
                        this.imgUrl_ = "";
                        return this;
                    }

                    public Activity clearLevel() {
                        this.hasLevel = false;
                        this.level_ = "";
                        return this;
                    }

                    public Activity clearOriginPrice() {
                        this.hasOriginPrice = false;
                        this.originPrice_ = "";
                        return this;
                    }

                    public Activity clearTitle() {
                        this.hasTitle = false;
                        this.title_ = "";
                        return this;
                    }

                    public String getActivityPrice() {
                        return this.activityPrice_;
                    }

                    public String getBgColor() {
                        return this.bgColor_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getColor() {
                        return this.color_;
                    }

                    public String getDesc() {
                        return this.desc_;
                    }

                    public String getHref() {
                        return this.href_;
                    }

                    public String getImgUrl() {
                        return this.imgUrl_;
                    }

                    public String getLevel() {
                        return this.level_;
                    }

                    public String getOriginPrice() {
                        return this.originPrice_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasLevel() ? CodedOutputStreamMicro.computeStringSize(1, getLevel()) : 0;
                        if (hasTitle()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                        }
                        if (hasColor()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getColor());
                        }
                        if (hasBgColor()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getBgColor());
                        }
                        if (hasDesc()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getDesc());
                        }
                        if (hasHref()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getHref());
                        }
                        if (hasImgUrl()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getImgUrl());
                        }
                        if (hasOriginPrice()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getOriginPrice());
                        }
                        if (hasActivityPrice()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(9, getActivityPrice());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public String getTitle() {
                        return this.title_;
                    }

                    public boolean hasActivityPrice() {
                        return this.hasActivityPrice;
                    }

                    public boolean hasBgColor() {
                        return this.hasBgColor;
                    }

                    public boolean hasColor() {
                        return this.hasColor;
                    }

                    public boolean hasDesc() {
                        return this.hasDesc;
                    }

                    public boolean hasHref() {
                        return this.hasHref;
                    }

                    public boolean hasImgUrl() {
                        return this.hasImgUrl;
                    }

                    public boolean hasLevel() {
                        return this.hasLevel;
                    }

                    public boolean hasOriginPrice() {
                        return this.hasOriginPrice;
                    }

                    public boolean hasTitle() {
                        return this.hasTitle;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Activity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setLevel(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setTitle(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                setColor(codedInputStreamMicro.readString());
                            } else if (readTag == 34) {
                                setBgColor(codedInputStreamMicro.readString());
                            } else if (readTag == 42) {
                                setDesc(codedInputStreamMicro.readString());
                            } else if (readTag == 50) {
                                setHref(codedInputStreamMicro.readString());
                            } else if (readTag == 58) {
                                setImgUrl(codedInputStreamMicro.readString());
                            } else if (readTag == 66) {
                                setOriginPrice(codedInputStreamMicro.readString());
                            } else if (readTag == 74) {
                                setActivityPrice(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Activity setActivityPrice(String str) {
                        this.hasActivityPrice = true;
                        this.activityPrice_ = str;
                        return this;
                    }

                    public Activity setBgColor(String str) {
                        this.hasBgColor = true;
                        this.bgColor_ = str;
                        return this;
                    }

                    public Activity setColor(String str) {
                        this.hasColor = true;
                        this.color_ = str;
                        return this;
                    }

                    public Activity setDesc(String str) {
                        this.hasDesc = true;
                        this.desc_ = str;
                        return this;
                    }

                    public Activity setHref(String str) {
                        this.hasHref = true;
                        this.href_ = str;
                        return this;
                    }

                    public Activity setImgUrl(String str) {
                        this.hasImgUrl = true;
                        this.imgUrl_ = str;
                        return this;
                    }

                    public Activity setLevel(String str) {
                        this.hasLevel = true;
                        this.level_ = str;
                        return this;
                    }

                    public Activity setOriginPrice(String str) {
                        this.hasOriginPrice = true;
                        this.originPrice_ = str;
                        return this;
                    }

                    public Activity setTitle(String str) {
                        this.hasTitle = true;
                        this.title_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasLevel()) {
                            codedOutputStreamMicro.writeString(1, getLevel());
                        }
                        if (hasTitle()) {
                            codedOutputStreamMicro.writeString(2, getTitle());
                        }
                        if (hasColor()) {
                            codedOutputStreamMicro.writeString(3, getColor());
                        }
                        if (hasBgColor()) {
                            codedOutputStreamMicro.writeString(4, getBgColor());
                        }
                        if (hasDesc()) {
                            codedOutputStreamMicro.writeString(5, getDesc());
                        }
                        if (hasHref()) {
                            codedOutputStreamMicro.writeString(6, getHref());
                        }
                        if (hasImgUrl()) {
                            codedOutputStreamMicro.writeString(7, getImgUrl());
                        }
                        if (hasOriginPrice()) {
                            codedOutputStreamMicro.writeString(8, getOriginPrice());
                        }
                        if (hasActivityPrice()) {
                            codedOutputStreamMicro.writeString(9, getActivityPrice());
                        }
                    }

                    public static Activity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Activity) new Activity().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Allcardextension extends MessageMicro {
                    public static final int IMAGE_URL_FIELD_NUMBER = 1;
                    public static final int LANDING_URL_FIELD_NUMBER = 2;
                    private boolean hasImageUrl;
                    private boolean hasLandingUrl;
                    private String imageUrl_ = "";
                    private String landingUrl_ = "";
                    private int cachedSize = -1;

                    public static Allcardextension parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Allcardextension().mergeFrom(codedInputStreamMicro);
                    }

                    public final Allcardextension clear() {
                        clearImageUrl();
                        clearLandingUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Allcardextension clearImageUrl() {
                        this.hasImageUrl = false;
                        this.imageUrl_ = "";
                        return this;
                    }

                    public Allcardextension clearLandingUrl() {
                        this.hasLandingUrl = false;
                        this.landingUrl_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getImageUrl() {
                        return this.imageUrl_;
                    }

                    public String getLandingUrl() {
                        return this.landingUrl_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasImageUrl() ? CodedOutputStreamMicro.computeStringSize(1, getImageUrl()) : 0;
                        if (hasLandingUrl()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getLandingUrl());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasImageUrl() {
                        return this.hasImageUrl;
                    }

                    public boolean hasLandingUrl() {
                        return this.hasLandingUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Allcardextension mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setImageUrl(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setLandingUrl(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Allcardextension setImageUrl(String str) {
                        this.hasImageUrl = true;
                        this.imageUrl_ = str;
                        return this;
                    }

                    public Allcardextension setLandingUrl(String str) {
                        this.hasLandingUrl = true;
                        this.landingUrl_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasImageUrl()) {
                            codedOutputStreamMicro.writeString(1, getImageUrl());
                        }
                        if (hasLandingUrl()) {
                            codedOutputStreamMicro.writeString(2, getLandingUrl());
                        }
                    }

                    public static Allcardextension parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Allcardextension) new Allcardextension().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class BlinkBuilding extends MessageMicro {
                    public static final int ANGLE_FIELD_NUMBER = 1;
                    public static final int CENTER_LAT_FIELD_NUMBER = 3;
                    public static final int CENTER_LNG_FIELD_NUMBER = 2;
                    public static final int LEVEL_FIELD_NUMBER = 6;
                    public static final int NEED_PLAY_FIELD_NUMBER = 4;
                    public static final int VIDEO_TYPE_FIELD_NUMBER = 5;
                    private boolean hasAngle;
                    private boolean hasCenterLat;
                    private boolean hasCenterLng;
                    private boolean hasLevel;
                    private boolean hasNeedPlay;
                    private boolean hasVideoType;
                    private int angle_ = 0;
                    private double centerLng_ = OOXIXo.f3760XO;
                    private double centerLat_ = OOXIXo.f3760XO;
                    private int needPlay_ = 0;
                    private int videoType_ = 0;
                    private float level_ = 0.0f;
                    private int cachedSize = -1;

                    public static BlinkBuilding parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new BlinkBuilding().mergeFrom(codedInputStreamMicro);
                    }

                    public final BlinkBuilding clear() {
                        clearAngle();
                        clearCenterLng();
                        clearCenterLat();
                        clearNeedPlay();
                        clearVideoType();
                        clearLevel();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BlinkBuilding clearAngle() {
                        this.hasAngle = false;
                        this.angle_ = 0;
                        return this;
                    }

                    public BlinkBuilding clearCenterLat() {
                        this.hasCenterLat = false;
                        this.centerLat_ = OOXIXo.f3760XO;
                        return this;
                    }

                    public BlinkBuilding clearCenterLng() {
                        this.hasCenterLng = false;
                        this.centerLng_ = OOXIXo.f3760XO;
                        return this;
                    }

                    public BlinkBuilding clearLevel() {
                        this.hasLevel = false;
                        this.level_ = 0.0f;
                        return this;
                    }

                    public BlinkBuilding clearNeedPlay() {
                        this.hasNeedPlay = false;
                        this.needPlay_ = 0;
                        return this;
                    }

                    public BlinkBuilding clearVideoType() {
                        this.hasVideoType = false;
                        this.videoType_ = 0;
                        return this;
                    }

                    public int getAngle() {
                        return this.angle_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public double getCenterLat() {
                        return this.centerLat_;
                    }

                    public double getCenterLng() {
                        return this.centerLng_;
                    }

                    public float getLevel() {
                        return this.level_;
                    }

                    public int getNeedPlay() {
                        return this.needPlay_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasAngle() ? CodedOutputStreamMicro.computeInt32Size(1, getAngle()) : 0;
                        if (hasCenterLng()) {
                            computeInt32Size += CodedOutputStreamMicro.computeDoubleSize(2, getCenterLng());
                        }
                        if (hasCenterLat()) {
                            computeInt32Size += CodedOutputStreamMicro.computeDoubleSize(3, getCenterLat());
                        }
                        if (hasNeedPlay()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getNeedPlay());
                        }
                        if (hasVideoType()) {
                            computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getVideoType());
                        }
                        if (hasLevel()) {
                            computeInt32Size += CodedOutputStreamMicro.computeFloatSize(6, getLevel());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public int getVideoType() {
                        return this.videoType_;
                    }

                    public boolean hasAngle() {
                        return this.hasAngle;
                    }

                    public boolean hasCenterLat() {
                        return this.hasCenterLat;
                    }

                    public boolean hasCenterLng() {
                        return this.hasCenterLng;
                    }

                    public boolean hasLevel() {
                        return this.hasLevel;
                    }

                    public boolean hasNeedPlay() {
                        return this.hasNeedPlay;
                    }

                    public boolean hasVideoType() {
                        return this.hasVideoType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public BlinkBuilding mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setAngle(codedInputStreamMicro.readInt32());
                            } else if (readTag == 17) {
                                setCenterLng(codedInputStreamMicro.readDouble());
                            } else if (readTag == 25) {
                                setCenterLat(codedInputStreamMicro.readDouble());
                            } else if (readTag == 32) {
                                setNeedPlay(codedInputStreamMicro.readInt32());
                            } else if (readTag == 40) {
                                setVideoType(codedInputStreamMicro.readInt32());
                            } else if (readTag == 53) {
                                setLevel(codedInputStreamMicro.readFloat());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public BlinkBuilding setAngle(int i) {
                        this.hasAngle = true;
                        this.angle_ = i;
                        return this;
                    }

                    public BlinkBuilding setCenterLat(double d) {
                        this.hasCenterLat = true;
                        this.centerLat_ = d;
                        return this;
                    }

                    public BlinkBuilding setCenterLng(double d) {
                        this.hasCenterLng = true;
                        this.centerLng_ = d;
                        return this;
                    }

                    public BlinkBuilding setLevel(float f) {
                        this.hasLevel = true;
                        this.level_ = f;
                        return this;
                    }

                    public BlinkBuilding setNeedPlay(int i) {
                        this.hasNeedPlay = true;
                        this.needPlay_ = i;
                        return this;
                    }

                    public BlinkBuilding setVideoType(int i) {
                        this.hasVideoType = true;
                        this.videoType_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasAngle()) {
                            codedOutputStreamMicro.writeInt32(1, getAngle());
                        }
                        if (hasCenterLng()) {
                            codedOutputStreamMicro.writeDouble(2, getCenterLng());
                        }
                        if (hasCenterLat()) {
                            codedOutputStreamMicro.writeDouble(3, getCenterLat());
                        }
                        if (hasNeedPlay()) {
                            codedOutputStreamMicro.writeInt32(4, getNeedPlay());
                        }
                        if (hasVideoType()) {
                            codedOutputStreamMicro.writeInt32(5, getVideoType());
                        }
                        if (hasLevel()) {
                            codedOutputStreamMicro.writeFloat(6, getLevel());
                        }
                    }

                    public static BlinkBuilding parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (BlinkBuilding) new BlinkBuilding().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class BookInfo extends MessageMicro {
                    public static final int COMS_FIELD_NUMBER = 3;
                    public static final int TEL_FIELD_NUMBER = 1;
                    public static final int WEB_FIELD_NUMBER = 2;
                    private boolean hasComs;
                    private boolean hasTel;
                    private boolean hasWeb;
                    private Tel tel_ = null;
                    private Web web_ = null;
                    private Coms coms_ = null;
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class Coms extends MessageMicro {
                        public static final int CONTENT_FIELD_NUMBER = 1;
                        public static final int TITLE_FIELD_NUMBER = 2;
                        public static final int TYPE_FIELD_NUMBER = 3;
                        private boolean hasContent;
                        private boolean hasTitle;
                        private boolean hasType;
                        private String content_ = "";
                        private String title_ = "";
                        private String type_ = "";
                        private int cachedSize = -1;

                        public static Coms parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Coms().mergeFrom(codedInputStreamMicro);
                        }

                        public final Coms clear() {
                            clearContent();
                            clearTitle();
                            clearType();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Coms clearContent() {
                            this.hasContent = false;
                            this.content_ = "";
                            return this;
                        }

                        public Coms clearTitle() {
                            this.hasTitle = false;
                            this.title_ = "";
                            return this;
                        }

                        public Coms clearType() {
                            this.hasType = false;
                            this.type_ = "";
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

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeStringSize = hasContent() ? CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                            if (hasTitle()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                            }
                            if (hasType()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getType());
                            }
                            this.cachedSize = computeStringSize;
                            return computeStringSize;
                        }

                        public String getTitle() {
                            return this.title_;
                        }

                        public String getType() {
                            return this.type_;
                        }

                        public boolean hasContent() {
                            return this.hasContent;
                        }

                        public boolean hasTitle() {
                            return this.hasTitle;
                        }

                        public boolean hasType() {
                            return this.hasType;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Coms mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 10) {
                                    setContent(codedInputStreamMicro.readString());
                                } else if (readTag == 18) {
                                    setTitle(codedInputStreamMicro.readString());
                                } else if (readTag == 26) {
                                    setType(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Coms setContent(String str) {
                            this.hasContent = true;
                            this.content_ = str;
                            return this;
                        }

                        public Coms setTitle(String str) {
                            this.hasTitle = true;
                            this.title_ = str;
                            return this;
                        }

                        public Coms setType(String str) {
                            this.hasType = true;
                            this.type_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasContent()) {
                                codedOutputStreamMicro.writeString(1, getContent());
                            }
                            if (hasTitle()) {
                                codedOutputStreamMicro.writeString(2, getTitle());
                            }
                            if (hasType()) {
                                codedOutputStreamMicro.writeString(3, getType());
                            }
                        }

                        public static Coms parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Coms) new Coms().mergeFrom(bArr);
                        }
                    }

                    /* loaded from: classes7.dex */
                    public static final class Tel extends MessageMicro {
                        public static final int CONTENT_FIELD_NUMBER = 2;
                        public static final int TITLE_FIELD_NUMBER = 1;
                        private boolean hasContent;
                        private boolean hasTitle;
                        private String title_ = "";
                        private String content_ = "";
                        private int cachedSize = -1;

                        public static Tel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Tel().mergeFrom(codedInputStreamMicro);
                        }

                        public final Tel clear() {
                            clearTitle();
                            clearContent();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Tel clearContent() {
                            this.hasContent = false;
                            this.content_ = "";
                            return this;
                        }

                        public Tel clearTitle() {
                            this.hasTitle = false;
                            this.title_ = "";
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

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeStringSize = hasTitle() ? CodedOutputStreamMicro.computeStringSize(1, getTitle()) : 0;
                            if (hasContent()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getContent());
                            }
                            this.cachedSize = computeStringSize;
                            return computeStringSize;
                        }

                        public String getTitle() {
                            return this.title_;
                        }

                        public boolean hasContent() {
                            return this.hasContent;
                        }

                        public boolean hasTitle() {
                            return this.hasTitle;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Tel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 10) {
                                    setTitle(codedInputStreamMicro.readString());
                                } else if (readTag == 18) {
                                    setContent(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Tel setContent(String str) {
                            this.hasContent = true;
                            this.content_ = str;
                            return this;
                        }

                        public Tel setTitle(String str) {
                            this.hasTitle = true;
                            this.title_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasTitle()) {
                                codedOutputStreamMicro.writeString(1, getTitle());
                            }
                            if (hasContent()) {
                                codedOutputStreamMicro.writeString(2, getContent());
                            }
                        }

                        public static Tel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Tel) new Tel().mergeFrom(bArr);
                        }
                    }

                    /* loaded from: classes7.dex */
                    public static final class Web extends MessageMicro {
                        public static final int CONTENT_FIELD_NUMBER = 2;
                        public static final int TITLE_FIELD_NUMBER = 1;
                        private boolean hasContent;
                        private boolean hasTitle;
                        private String title_ = "";
                        private String content_ = "";
                        private int cachedSize = -1;

                        public static Web parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Web().mergeFrom(codedInputStreamMicro);
                        }

                        public final Web clear() {
                            clearTitle();
                            clearContent();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Web clearContent() {
                            this.hasContent = false;
                            this.content_ = "";
                            return this;
                        }

                        public Web clearTitle() {
                            this.hasTitle = false;
                            this.title_ = "";
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

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeStringSize = hasTitle() ? CodedOutputStreamMicro.computeStringSize(1, getTitle()) : 0;
                            if (hasContent()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getContent());
                            }
                            this.cachedSize = computeStringSize;
                            return computeStringSize;
                        }

                        public String getTitle() {
                            return this.title_;
                        }

                        public boolean hasContent() {
                            return this.hasContent;
                        }

                        public boolean hasTitle() {
                            return this.hasTitle;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Web mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 10) {
                                    setTitle(codedInputStreamMicro.readString());
                                } else if (readTag == 18) {
                                    setContent(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Web setContent(String str) {
                            this.hasContent = true;
                            this.content_ = str;
                            return this;
                        }

                        public Web setTitle(String str) {
                            this.hasTitle = true;
                            this.title_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasTitle()) {
                                codedOutputStreamMicro.writeString(1, getTitle());
                            }
                            if (hasContent()) {
                                codedOutputStreamMicro.writeString(2, getContent());
                            }
                        }

                        public static Web parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Web) new Web().mergeFrom(bArr);
                        }
                    }

                    public static BookInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new BookInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public final BookInfo clear() {
                        clearTel();
                        clearWeb();
                        clearComs();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BookInfo clearComs() {
                        this.hasComs = false;
                        this.coms_ = null;
                        return this;
                    }

                    public BookInfo clearTel() {
                        this.hasTel = false;
                        this.tel_ = null;
                        return this;
                    }

                    public BookInfo clearWeb() {
                        this.hasWeb = false;
                        this.web_ = null;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Coms getComs() {
                        return this.coms_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeMessageSize = hasTel() ? CodedOutputStreamMicro.computeMessageSize(1, getTel()) : 0;
                        if (hasWeb()) {
                            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, getWeb());
                        }
                        if (hasComs()) {
                            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(3, getComs());
                        }
                        this.cachedSize = computeMessageSize;
                        return computeMessageSize;
                    }

                    public Tel getTel() {
                        return this.tel_;
                    }

                    public Web getWeb() {
                        return this.web_;
                    }

                    public boolean hasComs() {
                        return this.hasComs;
                    }

                    public boolean hasTel() {
                        return this.hasTel;
                    }

                    public boolean hasWeb() {
                        return this.hasWeb;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public BookInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                Tel tel = new Tel();
                                codedInputStreamMicro.readMessage(tel);
                                setTel(tel);
                            } else if (readTag == 18) {
                                Web web = new Web();
                                codedInputStreamMicro.readMessage(web);
                                setWeb(web);
                            } else if (readTag == 26) {
                                Coms coms = new Coms();
                                codedInputStreamMicro.readMessage(coms);
                                setComs(coms);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public BookInfo setComs(Coms coms) {
                        if (coms == null) {
                            return clearComs();
                        }
                        this.hasComs = true;
                        this.coms_ = coms;
                        return this;
                    }

                    public BookInfo setTel(Tel tel) {
                        if (tel == null) {
                            return clearTel();
                        }
                        this.hasTel = true;
                        this.tel_ = tel;
                        return this;
                    }

                    public BookInfo setWeb(Web web) {
                        if (web == null) {
                            return clearWeb();
                        }
                        this.hasWeb = true;
                        this.web_ = web;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasTel()) {
                            codedOutputStreamMicro.writeMessage(1, getTel());
                        }
                        if (hasWeb()) {
                            codedOutputStreamMicro.writeMessage(2, getWeb());
                        }
                        if (hasComs()) {
                            codedOutputStreamMicro.writeMessage(3, getComs());
                        }
                    }

                    public static BookInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (BookInfo) new BookInfo().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class BusinessService extends MessageMicro {
                    public static final int NUOMI_FIELD_NUMBER = 1;
                    private boolean hasNuomi;
                    private Nuomi nuomi_ = null;
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class Nuomi extends MessageMicro {
                        public static final int DAODIANFU_STATUS_FIELD_NUMBER = 1;
                        private boolean hasDaodianfuStatus;
                        private int daodianfuStatus_ = 0;
                        private int cachedSize = -1;

                        public static Nuomi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Nuomi().mergeFrom(codedInputStreamMicro);
                        }

                        public final Nuomi clear() {
                            clearDaodianfuStatus();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Nuomi clearDaodianfuStatus() {
                            this.hasDaodianfuStatus = false;
                            this.daodianfuStatus_ = 0;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDaodianfuStatus() {
                            return this.daodianfuStatus_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeInt32Size = hasDaodianfuStatus() ? CodedOutputStreamMicro.computeInt32Size(1, getDaodianfuStatus()) : 0;
                            this.cachedSize = computeInt32Size;
                            return computeInt32Size;
                        }

                        public boolean hasDaodianfuStatus() {
                            return this.hasDaodianfuStatus;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Nuomi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 8) {
                                    setDaodianfuStatus(codedInputStreamMicro.readInt32());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Nuomi setDaodianfuStatus(int i) {
                            this.hasDaodianfuStatus = true;
                            this.daodianfuStatus_ = i;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasDaodianfuStatus()) {
                                codedOutputStreamMicro.writeInt32(1, getDaodianfuStatus());
                            }
                        }

                        public static Nuomi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Nuomi) new Nuomi().mergeFrom(bArr);
                        }
                    }

                    public static BusinessService parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new BusinessService().mergeFrom(codedInputStreamMicro);
                    }

                    public final BusinessService clear() {
                        clearNuomi();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BusinessService clearNuomi() {
                        this.hasNuomi = false;
                        this.nuomi_ = null;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Nuomi getNuomi() {
                        return this.nuomi_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeMessageSize = hasNuomi() ? CodedOutputStreamMicro.computeMessageSize(1, getNuomi()) : 0;
                        this.cachedSize = computeMessageSize;
                        return computeMessageSize;
                    }

                    public boolean hasNuomi() {
                        return this.hasNuomi;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public BusinessService mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                Nuomi nuomi = new Nuomi();
                                codedInputStreamMicro.readMessage(nuomi);
                                setNuomi(nuomi);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public BusinessService setNuomi(Nuomi nuomi) {
                        if (nuomi == null) {
                            return clearNuomi();
                        }
                        this.hasNuomi = true;
                        this.nuomi_ = nuomi;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasNuomi()) {
                            codedOutputStreamMicro.writeMessage(1, getNuomi());
                        }
                    }

                    public static BusinessService parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (BusinessService) new BusinessService().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class DisplayInfoCommentLabel extends MessageMicro {
                    public static final int BEAUTY_FIELD_NUMBER = 5;
                    public static final int CATER_FIELD_NUMBER = 3;
                    public static final int COMMON_FIELD_NUMBER = 2;
                    public static final int LIFE_FIELD_NUMBER = 1;
                    public static final int SCOPE_FIELD_NUMBER = 4;
                    private boolean hasBeauty;
                    private boolean hasCater;
                    private boolean hasCommon;
                    private boolean hasLife;
                    private boolean hasScope;
                    private String life_ = "";
                    private String common_ = "";
                    private String cater_ = "";
                    private String scope_ = "";
                    private String beauty_ = "";
                    private int cachedSize = -1;

                    public static DisplayInfoCommentLabel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DisplayInfoCommentLabel().mergeFrom(codedInputStreamMicro);
                    }

                    public final DisplayInfoCommentLabel clear() {
                        clearLife();
                        clearCommon();
                        clearCater();
                        clearScope();
                        clearBeauty();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DisplayInfoCommentLabel clearBeauty() {
                        this.hasBeauty = false;
                        this.beauty_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearCater() {
                        this.hasCater = false;
                        this.cater_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearCommon() {
                        this.hasCommon = false;
                        this.common_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearLife() {
                        this.hasLife = false;
                        this.life_ = "";
                        return this;
                    }

                    public DisplayInfoCommentLabel clearScope() {
                        this.hasScope = false;
                        this.scope_ = "";
                        return this;
                    }

                    public String getBeauty() {
                        return this.beauty_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getCater() {
                        return this.cater_;
                    }

                    public String getCommon() {
                        return this.common_;
                    }

                    public String getLife() {
                        return this.life_;
                    }

                    public String getScope() {
                        return this.scope_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasLife() ? CodedOutputStreamMicro.computeStringSize(1, getLife()) : 0;
                        if (hasCommon()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getCommon());
                        }
                        if (hasCater()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getCater());
                        }
                        if (hasScope()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getScope());
                        }
                        if (hasBeauty()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getBeauty());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasBeauty() {
                        return this.hasBeauty;
                    }

                    public boolean hasCater() {
                        return this.hasCater;
                    }

                    public boolean hasCommon() {
                        return this.hasCommon;
                    }

                    public boolean hasLife() {
                        return this.hasLife;
                    }

                    public boolean hasScope() {
                        return this.hasScope;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public DisplayInfoCommentLabel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setLife(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setCommon(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                setCater(codedInputStreamMicro.readString());
                            } else if (readTag == 34) {
                                setScope(codedInputStreamMicro.readString());
                            } else if (readTag == 42) {
                                setBeauty(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public DisplayInfoCommentLabel setBeauty(String str) {
                        this.hasBeauty = true;
                        this.beauty_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setCater(String str) {
                        this.hasCater = true;
                        this.cater_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setCommon(String str) {
                        this.hasCommon = true;
                        this.common_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setLife(String str) {
                        this.hasLife = true;
                        this.life_ = str;
                        return this;
                    }

                    public DisplayInfoCommentLabel setScope(String str) {
                        this.hasScope = true;
                        this.scope_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasLife()) {
                            codedOutputStreamMicro.writeString(1, getLife());
                        }
                        if (hasCommon()) {
                            codedOutputStreamMicro.writeString(2, getCommon());
                        }
                        if (hasCater()) {
                            codedOutputStreamMicro.writeString(3, getCater());
                        }
                        if (hasScope()) {
                            codedOutputStreamMicro.writeString(4, getScope());
                        }
                        if (hasBeauty()) {
                            codedOutputStreamMicro.writeString(5, getBeauty());
                        }
                    }

                    public static DisplayInfoCommentLabel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DisplayInfoCommentLabel) new DisplayInfoCommentLabel().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class GrouponInfo extends MessageMicro {
                    public static final int GROUPON_IMAGE_FIELD_NUMBER = 4;
                    public static final int GROUPON_NUM_FIELD_NUMBER = 1;
                    public static final int GROUPON_PRICE_FIELD_NUMBER = 2;
                    public static final int GROUPON_RESERVATION_FIELD_NUMBER = 8;
                    public static final int GROUPON_TITLE_FIELD_NUMBER = 3;
                    public static final int GROUPON_URL_MOBILE_FIELD_NUMBER = 6;
                    public static final int GROUPON_WEBAPP_URL_FIELD_NUMBER = 7;
                    public static final int REGULAR_PRICE_FIELD_NUMBER = 5;
                    private boolean hasGrouponImage;
                    private boolean hasGrouponNum;
                    private boolean hasGrouponPrice;
                    private boolean hasGrouponReservation;
                    private boolean hasGrouponTitle;
                    private boolean hasGrouponUrlMobile;
                    private boolean hasGrouponWebappUrl;
                    private boolean hasRegularPrice;
                    private String grouponNum_ = "";
                    private String grouponPrice_ = "";
                    private String grouponTitle_ = "";
                    private String grouponImage_ = "";
                    private String regularPrice_ = "";
                    private String grouponUrlMobile_ = "";
                    private String grouponWebappUrl_ = "";
                    private String grouponReservation_ = "";
                    private int cachedSize = -1;

                    public static GrouponInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new GrouponInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public final GrouponInfo clear() {
                        clearGrouponNum();
                        clearGrouponPrice();
                        clearGrouponTitle();
                        clearGrouponImage();
                        clearRegularPrice();
                        clearGrouponUrlMobile();
                        clearGrouponWebappUrl();
                        clearGrouponReservation();
                        this.cachedSize = -1;
                        return this;
                    }

                    public GrouponInfo clearGrouponImage() {
                        this.hasGrouponImage = false;
                        this.grouponImage_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponNum() {
                        this.hasGrouponNum = false;
                        this.grouponNum_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponPrice() {
                        this.hasGrouponPrice = false;
                        this.grouponPrice_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponReservation() {
                        this.hasGrouponReservation = false;
                        this.grouponReservation_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponTitle() {
                        this.hasGrouponTitle = false;
                        this.grouponTitle_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponUrlMobile() {
                        this.hasGrouponUrlMobile = false;
                        this.grouponUrlMobile_ = "";
                        return this;
                    }

                    public GrouponInfo clearGrouponWebappUrl() {
                        this.hasGrouponWebappUrl = false;
                        this.grouponWebappUrl_ = "";
                        return this;
                    }

                    public GrouponInfo clearRegularPrice() {
                        this.hasRegularPrice = false;
                        this.regularPrice_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getGrouponImage() {
                        return this.grouponImage_;
                    }

                    public String getGrouponNum() {
                        return this.grouponNum_;
                    }

                    public String getGrouponPrice() {
                        return this.grouponPrice_;
                    }

                    public String getGrouponReservation() {
                        return this.grouponReservation_;
                    }

                    public String getGrouponTitle() {
                        return this.grouponTitle_;
                    }

                    public String getGrouponUrlMobile() {
                        return this.grouponUrlMobile_;
                    }

                    public String getGrouponWebappUrl() {
                        return this.grouponWebappUrl_;
                    }

                    public String getRegularPrice() {
                        return this.regularPrice_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasGrouponNum() ? CodedOutputStreamMicro.computeStringSize(1, getGrouponNum()) : 0;
                        if (hasGrouponPrice()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getGrouponPrice());
                        }
                        if (hasGrouponTitle()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getGrouponTitle());
                        }
                        if (hasGrouponImage()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getGrouponImage());
                        }
                        if (hasRegularPrice()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getRegularPrice());
                        }
                        if (hasGrouponUrlMobile()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getGrouponUrlMobile());
                        }
                        if (hasGrouponWebappUrl()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getGrouponWebappUrl());
                        }
                        if (hasGrouponReservation()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getGrouponReservation());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasGrouponImage() {
                        return this.hasGrouponImage;
                    }

                    public boolean hasGrouponNum() {
                        return this.hasGrouponNum;
                    }

                    public boolean hasGrouponPrice() {
                        return this.hasGrouponPrice;
                    }

                    public boolean hasGrouponReservation() {
                        return this.hasGrouponReservation;
                    }

                    public boolean hasGrouponTitle() {
                        return this.hasGrouponTitle;
                    }

                    public boolean hasGrouponUrlMobile() {
                        return this.hasGrouponUrlMobile;
                    }

                    public boolean hasGrouponWebappUrl() {
                        return this.hasGrouponWebappUrl;
                    }

                    public boolean hasRegularPrice() {
                        return this.hasRegularPrice;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public GrouponInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setGrouponNum(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setGrouponPrice(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                setGrouponTitle(codedInputStreamMicro.readString());
                            } else if (readTag == 34) {
                                setGrouponImage(codedInputStreamMicro.readString());
                            } else if (readTag == 42) {
                                setRegularPrice(codedInputStreamMicro.readString());
                            } else if (readTag == 50) {
                                setGrouponUrlMobile(codedInputStreamMicro.readString());
                            } else if (readTag == 58) {
                                setGrouponWebappUrl(codedInputStreamMicro.readString());
                            } else if (readTag == 66) {
                                setGrouponReservation(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public GrouponInfo setGrouponImage(String str) {
                        this.hasGrouponImage = true;
                        this.grouponImage_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponNum(String str) {
                        this.hasGrouponNum = true;
                        this.grouponNum_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponPrice(String str) {
                        this.hasGrouponPrice = true;
                        this.grouponPrice_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponReservation(String str) {
                        this.hasGrouponReservation = true;
                        this.grouponReservation_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponTitle(String str) {
                        this.hasGrouponTitle = true;
                        this.grouponTitle_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponUrlMobile(String str) {
                        this.hasGrouponUrlMobile = true;
                        this.grouponUrlMobile_ = str;
                        return this;
                    }

                    public GrouponInfo setGrouponWebappUrl(String str) {
                        this.hasGrouponWebappUrl = true;
                        this.grouponWebappUrl_ = str;
                        return this;
                    }

                    public GrouponInfo setRegularPrice(String str) {
                        this.hasRegularPrice = true;
                        this.regularPrice_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasGrouponNum()) {
                            codedOutputStreamMicro.writeString(1, getGrouponNum());
                        }
                        if (hasGrouponPrice()) {
                            codedOutputStreamMicro.writeString(2, getGrouponPrice());
                        }
                        if (hasGrouponTitle()) {
                            codedOutputStreamMicro.writeString(3, getGrouponTitle());
                        }
                        if (hasGrouponImage()) {
                            codedOutputStreamMicro.writeString(4, getGrouponImage());
                        }
                        if (hasRegularPrice()) {
                            codedOutputStreamMicro.writeString(5, getRegularPrice());
                        }
                        if (hasGrouponUrlMobile()) {
                            codedOutputStreamMicro.writeString(6, getGrouponUrlMobile());
                        }
                        if (hasGrouponWebappUrl()) {
                            codedOutputStreamMicro.writeString(7, getGrouponWebappUrl());
                        }
                        if (hasGrouponReservation()) {
                            codedOutputStreamMicro.writeString(8, getGrouponReservation());
                        }
                    }

                    public static GrouponInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (GrouponInfo) new GrouponInfo().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class HotelService extends MessageMicro {
                    public static final int ICON_ID_FIELD_NUMBER = 1;
                    public static final int NAME_FIELD_NUMBER = 2;
                    private boolean hasIconId;
                    private boolean hasName;
                    private String iconId_ = "";
                    private String name_ = "";
                    private int cachedSize = -1;

                    public static HotelService parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new HotelService().mergeFrom(codedInputStreamMicro);
                    }

                    public final HotelService clear() {
                        clearIconId();
                        clearName();
                        this.cachedSize = -1;
                        return this;
                    }

                    public HotelService clearIconId() {
                        this.hasIconId = false;
                        this.iconId_ = "";
                        return this;
                    }

                    public HotelService clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getIconId() {
                        return this.iconId_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasIconId() ? CodedOutputStreamMicro.computeStringSize(1, getIconId()) : 0;
                        if (hasName()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasIconId() {
                        return this.hasIconId;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public HotelService mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setIconId(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setName(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public HotelService setIconId(String str) {
                        this.hasIconId = true;
                        this.iconId_ = str;
                        return this;
                    }

                    public HotelService setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasIconId()) {
                            codedOutputStreamMicro.writeString(1, getIconId());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(2, getName());
                        }
                    }

                    public static HotelService parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (HotelService) new HotelService().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Impression extends MessageMicro {
                    public static final int KEYWORD_FIELD_NUMBER = 1;
                    public static final int NUM_FIELD_NUMBER = 2;
                    private boolean hasKeyword;
                    private boolean hasNum;
                    private String keyword_ = "";
                    private int num_ = 0;
                    private int cachedSize = -1;

                    public static Impression parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Impression().mergeFrom(codedInputStreamMicro);
                    }

                    public final Impression clear() {
                        clearKeyword();
                        clearNum();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Impression clearKeyword() {
                        this.hasKeyword = false;
                        this.keyword_ = "";
                        return this;
                    }

                    public Impression clearNum() {
                        this.hasNum = false;
                        this.num_ = 0;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getKeyword() {
                        return this.keyword_;
                    }

                    public int getNum() {
                        return this.num_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasKeyword() ? CodedOutputStreamMicro.computeStringSize(1, getKeyword()) : 0;
                        if (hasNum()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getNum());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasKeyword() {
                        return this.hasKeyword;
                    }

                    public boolean hasNum() {
                        return this.hasNum;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Impression mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setKeyword(codedInputStreamMicro.readString());
                            } else if (readTag == 16) {
                                setNum(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Impression setKeyword(String str) {
                        this.hasKeyword = true;
                        this.keyword_ = str;
                        return this;
                    }

                    public Impression setNum(int i) {
                        this.hasNum = true;
                        this.num_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasKeyword()) {
                            codedOutputStreamMicro.writeString(1, getKeyword());
                        }
                        if (hasNum()) {
                            codedOutputStreamMicro.writeInt32(2, getNum());
                        }
                    }

                    public static Impression parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Impression) new Impression().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class LbcBusinessVip extends MessageMicro {
                    public static final int AMOUNT_FIELD_NUMBER = 3;
                    public static final int COMMENT_FIELD_NUMBER = 2;
                    public static final int LISTS_FIELD_NUMBER = 4;
                    public static final int TYPE_FIELD_NUMBER = 1;
                    private boolean hasAmount;
                    private boolean hasComment;
                    private boolean hasLists;
                    private boolean hasType;
                    private int type_ = 0;
                    private String comment_ = "";
                    private String amount_ = "";
                    private String lists_ = "";
                    private int cachedSize = -1;

                    public static LbcBusinessVip parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new LbcBusinessVip().mergeFrom(codedInputStreamMicro);
                    }

                    public final LbcBusinessVip clear() {
                        clearType();
                        clearComment();
                        clearAmount();
                        clearLists();
                        this.cachedSize = -1;
                        return this;
                    }

                    public LbcBusinessVip clearAmount() {
                        this.hasAmount = false;
                        this.amount_ = "";
                        return this;
                    }

                    public LbcBusinessVip clearComment() {
                        this.hasComment = false;
                        this.comment_ = "";
                        return this;
                    }

                    public LbcBusinessVip clearLists() {
                        this.hasLists = false;
                        this.lists_ = "";
                        return this;
                    }

                    public LbcBusinessVip clearType() {
                        this.hasType = false;
                        this.type_ = 0;
                        return this;
                    }

                    public String getAmount() {
                        return this.amount_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getComment() {
                        return this.comment_;
                    }

                    public String getLists() {
                        return this.lists_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
                        if (hasComment()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getComment());
                        }
                        if (hasAmount()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getAmount());
                        }
                        if (hasLists()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getLists());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasAmount() {
                        return this.hasAmount;
                    }

                    public boolean hasComment() {
                        return this.hasComment;
                    }

                    public boolean hasLists() {
                        return this.hasLists;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public LbcBusinessVip mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setType(codedInputStreamMicro.readInt32());
                            } else if (readTag == 18) {
                                setComment(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                setAmount(codedInputStreamMicro.readString());
                            } else if (readTag == 34) {
                                setLists(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public LbcBusinessVip setAmount(String str) {
                        this.hasAmount = true;
                        this.amount_ = str;
                        return this;
                    }

                    public LbcBusinessVip setComment(String str) {
                        this.hasComment = true;
                        this.comment_ = str;
                        return this;
                    }

                    public LbcBusinessVip setLists(String str) {
                        this.hasLists = true;
                        this.lists_ = str;
                        return this;
                    }

                    public LbcBusinessVip setType(int i) {
                        this.hasType = true;
                        this.type_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(1, getType());
                        }
                        if (hasComment()) {
                            codedOutputStreamMicro.writeString(2, getComment());
                        }
                        if (hasAmount()) {
                            codedOutputStreamMicro.writeString(3, getAmount());
                        }
                        if (hasLists()) {
                            codedOutputStreamMicro.writeString(4, getLists());
                        }
                    }

                    public static LbcBusinessVip parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (LbcBusinessVip) new LbcBusinessVip().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Marketbiz extends MessageMicro {
                    public static final int ACT_FIELD_NUMBER = 3;
                    public static final int CONTENT_FIELD_NUMBER = 2;
                    public static final int DTYPE_FIELD_NUMBER = 5;
                    public static final int SRCNAME_FIELD_NUMBER = 1;
                    public static final int STYPE_FIELD_NUMBER = 4;
                    private boolean hasAct;
                    private boolean hasContent;
                    private boolean hasDtype;
                    private boolean hasSrcname;
                    private boolean hasStype;
                    private String srcname_ = "";
                    private String content_ = "";
                    private int act_ = 0;
                    private int stype_ = 0;
                    private int dtype_ = 0;
                    private int cachedSize = -1;

                    public static Marketbiz parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Marketbiz().mergeFrom(codedInputStreamMicro);
                    }

                    public final Marketbiz clear() {
                        clearSrcname();
                        clearContent();
                        clearAct();
                        clearStype();
                        clearDtype();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Marketbiz clearAct() {
                        this.hasAct = false;
                        this.act_ = 0;
                        return this;
                    }

                    public Marketbiz clearContent() {
                        this.hasContent = false;
                        this.content_ = "";
                        return this;
                    }

                    public Marketbiz clearDtype() {
                        this.hasDtype = false;
                        this.dtype_ = 0;
                        return this;
                    }

                    public Marketbiz clearSrcname() {
                        this.hasSrcname = false;
                        this.srcname_ = "";
                        return this;
                    }

                    public Marketbiz clearStype() {
                        this.hasStype = false;
                        this.stype_ = 0;
                        return this;
                    }

                    public int getAct() {
                        return this.act_;
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

                    public int getDtype() {
                        return this.dtype_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasSrcname() ? CodedOutputStreamMicro.computeStringSize(1, getSrcname()) : 0;
                        if (hasContent()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getContent());
                        }
                        if (hasAct()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getAct());
                        }
                        if (hasStype()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getStype());
                        }
                        if (hasDtype()) {
                            computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getDtype());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public String getSrcname() {
                        return this.srcname_;
                    }

                    public int getStype() {
                        return this.stype_;
                    }

                    public boolean hasAct() {
                        return this.hasAct;
                    }

                    public boolean hasContent() {
                        return this.hasContent;
                    }

                    public boolean hasDtype() {
                        return this.hasDtype;
                    }

                    public boolean hasSrcname() {
                        return this.hasSrcname;
                    }

                    public boolean hasStype() {
                        return this.hasStype;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Marketbiz mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setSrcname(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setContent(codedInputStreamMicro.readString());
                            } else if (readTag == 24) {
                                setAct(codedInputStreamMicro.readInt32());
                            } else if (readTag == 32) {
                                setStype(codedInputStreamMicro.readInt32());
                            } else if (readTag == 40) {
                                setDtype(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Marketbiz setAct(int i) {
                        this.hasAct = true;
                        this.act_ = i;
                        return this;
                    }

                    public Marketbiz setContent(String str) {
                        this.hasContent = true;
                        this.content_ = str;
                        return this;
                    }

                    public Marketbiz setDtype(int i) {
                        this.hasDtype = true;
                        this.dtype_ = i;
                        return this;
                    }

                    public Marketbiz setSrcname(String str) {
                        this.hasSrcname = true;
                        this.srcname_ = str;
                        return this;
                    }

                    public Marketbiz setStype(int i) {
                        this.hasStype = true;
                        this.stype_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasSrcname()) {
                            codedOutputStreamMicro.writeString(1, getSrcname());
                        }
                        if (hasContent()) {
                            codedOutputStreamMicro.writeString(2, getContent());
                        }
                        if (hasAct()) {
                            codedOutputStreamMicro.writeInt32(3, getAct());
                        }
                        if (hasStype()) {
                            codedOutputStreamMicro.writeInt32(4, getStype());
                        }
                        if (hasDtype()) {
                            codedOutputStreamMicro.writeInt32(5, getDtype());
                        }
                    }

                    public static Marketbiz parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Marketbiz) new Marketbiz().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Mbc extends MessageMicro {
                    public static final int MARKV_FIELD_NUMBER = 1;
                    private boolean hasMarkv;
                    private String markv_ = "";
                    private int cachedSize = -1;

                    public static Mbc parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Mbc().mergeFrom(codedInputStreamMicro);
                    }

                    public final Mbc clear() {
                        clearMarkv();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Mbc clearMarkv() {
                        this.hasMarkv = false;
                        this.markv_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getMarkv() {
                        return this.markv_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasMarkv() ? CodedOutputStreamMicro.computeStringSize(1, getMarkv()) : 0;
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasMarkv() {
                        return this.hasMarkv;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Mbc mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setMarkv(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Mbc setMarkv(String str) {
                        this.hasMarkv = true;
                        this.markv_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasMarkv()) {
                            codedOutputStreamMicro.writeString(1, getMarkv());
                        }
                    }

                    public static Mbc parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Mbc) new Mbc().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Meishipaihao extends MessageMicro {
                    public static final int IS_OK_FIELD_NUMBER = 1;
                    public static final int MAIN_FIELD_NUMBER = 2;
                    private boolean hasIsOk;
                    private boolean hasMain;
                    private int isOk_ = 0;
                    private Main main_ = null;
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class Main extends MessageMicro {
                        public static final int THIRD_FROM_FIELD_NUMBER = 1;
                        public static final int THIRD_ID_FIELD_NUMBER = 2;
                        private boolean hasThirdFrom;
                        private boolean hasThirdId;
                        private String thirdFrom_ = "";
                        private String thirdId_ = "";
                        private int cachedSize = -1;

                        public static Main parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Main().mergeFrom(codedInputStreamMicro);
                        }

                        public final Main clear() {
                            clearThirdFrom();
                            clearThirdId();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Main clearThirdFrom() {
                            this.hasThirdFrom = false;
                            this.thirdFrom_ = "";
                            return this;
                        }

                        public Main clearThirdId() {
                            this.hasThirdId = false;
                            this.thirdId_ = "";
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
                            int computeStringSize = hasThirdFrom() ? CodedOutputStreamMicro.computeStringSize(1, getThirdFrom()) : 0;
                            if (hasThirdId()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getThirdId());
                            }
                            this.cachedSize = computeStringSize;
                            return computeStringSize;
                        }

                        public String getThirdFrom() {
                            return this.thirdFrom_;
                        }

                        public String getThirdId() {
                            return this.thirdId_;
                        }

                        public boolean hasThirdFrom() {
                            return this.hasThirdFrom;
                        }

                        public boolean hasThirdId() {
                            return this.hasThirdId;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Main mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 10) {
                                    setThirdFrom(codedInputStreamMicro.readString());
                                } else if (readTag == 18) {
                                    setThirdId(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Main setThirdFrom(String str) {
                            this.hasThirdFrom = true;
                            this.thirdFrom_ = str;
                            return this;
                        }

                        public Main setThirdId(String str) {
                            this.hasThirdId = true;
                            this.thirdId_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasThirdFrom()) {
                                codedOutputStreamMicro.writeString(1, getThirdFrom());
                            }
                            if (hasThirdId()) {
                                codedOutputStreamMicro.writeString(2, getThirdId());
                            }
                        }

                        public static Main parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Main) new Main().mergeFrom(bArr);
                        }
                    }

                    public static Meishipaihao parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Meishipaihao().mergeFrom(codedInputStreamMicro);
                    }

                    public final Meishipaihao clear() {
                        clearIsOk();
                        clearMain();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Meishipaihao clearIsOk() {
                        this.hasIsOk = false;
                        this.isOk_ = 0;
                        return this;
                    }

                    public Meishipaihao clearMain() {
                        this.hasMain = false;
                        this.main_ = null;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getIsOk() {
                        return this.isOk_;
                    }

                    public Main getMain() {
                        return this.main_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasIsOk() ? CodedOutputStreamMicro.computeInt32Size(1, getIsOk()) : 0;
                        if (hasMain()) {
                            computeInt32Size += CodedOutputStreamMicro.computeMessageSize(2, getMain());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public boolean hasIsOk() {
                        return this.hasIsOk;
                    }

                    public boolean hasMain() {
                        return this.hasMain;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Meishipaihao mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setIsOk(codedInputStreamMicro.readInt32());
                            } else if (readTag == 18) {
                                Main main = new Main();
                                codedInputStreamMicro.readMessage(main);
                                setMain(main);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Meishipaihao setIsOk(int i) {
                        this.hasIsOk = true;
                        this.isOk_ = i;
                        return this;
                    }

                    public Meishipaihao setMain(Main main) {
                        if (main == null) {
                            return clearMain();
                        }
                        this.hasMain = true;
                        this.main_ = main;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasIsOk()) {
                            codedOutputStreamMicro.writeInt32(1, getIsOk());
                        }
                        if (hasMain()) {
                            codedOutputStreamMicro.writeMessage(2, getMain());
                        }
                    }

                    public static Meishipaihao parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Meishipaihao) new Meishipaihao().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class MnpKeyInfo extends MessageMicro {
                    public static final int APP_KEY_LIST_FIELD_NUMBER = 1;
                    private List<MnpAppList> appKeyList_ = Collections.emptyList();
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class MnpAppList extends MessageMicro {
                        public static final int IS_PRE_LOAD_FIELD_NUMBER = 2;
                        public static final int KEY_FIELD_NUMBER = 1;
                        private boolean hasIsPreLoad;
                        private boolean hasKey;
                        private String key_ = "";
                        private String isPreLoad_ = "";
                        private int cachedSize = -1;

                        public static MnpAppList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new MnpAppList().mergeFrom(codedInputStreamMicro);
                        }

                        public final MnpAppList clear() {
                            clearKey();
                            clearIsPreLoad();
                            this.cachedSize = -1;
                            return this;
                        }

                        public MnpAppList clearIsPreLoad() {
                            this.hasIsPreLoad = false;
                            this.isPreLoad_ = "";
                            return this;
                        }

                        public MnpAppList clearKey() {
                            this.hasKey = false;
                            this.key_ = "";
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public String getIsPreLoad() {
                            return this.isPreLoad_;
                        }

                        public String getKey() {
                            return this.key_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeStringSize = hasKey() ? CodedOutputStreamMicro.computeStringSize(1, getKey()) : 0;
                            if (hasIsPreLoad()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getIsPreLoad());
                            }
                            this.cachedSize = computeStringSize;
                            return computeStringSize;
                        }

                        public boolean hasIsPreLoad() {
                            return this.hasIsPreLoad;
                        }

                        public boolean hasKey() {
                            return this.hasKey;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public MnpAppList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 10) {
                                    setKey(codedInputStreamMicro.readString());
                                } else if (readTag == 18) {
                                    setIsPreLoad(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public MnpAppList setIsPreLoad(String str) {
                            this.hasIsPreLoad = true;
                            this.isPreLoad_ = str;
                            return this;
                        }

                        public MnpAppList setKey(String str) {
                            this.hasKey = true;
                            this.key_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasKey()) {
                                codedOutputStreamMicro.writeString(1, getKey());
                            }
                            if (hasIsPreLoad()) {
                                codedOutputStreamMicro.writeString(2, getIsPreLoad());
                            }
                        }

                        public static MnpAppList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (MnpAppList) new MnpAppList().mergeFrom(bArr);
                        }
                    }

                    public static MnpKeyInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new MnpKeyInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public MnpKeyInfo addAppKeyList(MnpAppList mnpAppList) {
                        if (mnpAppList == null) {
                            return this;
                        }
                        if (this.appKeyList_.isEmpty()) {
                            this.appKeyList_ = new ArrayList();
                        }
                        this.appKeyList_.add(mnpAppList);
                        return this;
                    }

                    public final MnpKeyInfo clear() {
                        clearAppKeyList();
                        this.cachedSize = -1;
                        return this;
                    }

                    public MnpKeyInfo clearAppKeyList() {
                        this.appKeyList_ = Collections.emptyList();
                        return this;
                    }

                    public MnpAppList getAppKeyList(int i) {
                        return this.appKeyList_.get(i);
                    }

                    public int getAppKeyListCount() {
                        return this.appKeyList_.size();
                    }

                    public List<MnpAppList> getAppKeyListList() {
                        return this.appKeyList_;
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
                        Iterator<MnpAppList> it = getAppKeyListList().iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                        }
                        this.cachedSize = i;
                        return i;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public MnpKeyInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                MnpAppList mnpAppList = new MnpAppList();
                                codedInputStreamMicro.readMessage(mnpAppList);
                                addAppKeyList(mnpAppList);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public MnpKeyInfo setAppKeyList(int i, MnpAppList mnpAppList) {
                        if (mnpAppList == null) {
                            return this;
                        }
                        this.appKeyList_.set(i, mnpAppList);
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        Iterator<MnpAppList> it = getAppKeyListList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeMessage(1, it.next());
                        }
                    }

                    public static MnpKeyInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (MnpKeyInfo) new MnpKeyInfo().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class OrilInfo extends MessageMicro {
                    public static final int ORIL_DETAIL_FIELD_NUMBER = 1;
                    private List<OrilDetail> orilDetail_ = Collections.emptyList();
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class OrilDetail extends MessageMicro {
                        public static final int ORIL_PRICE_FIELD_NUMBER = 1;
                        public static final int ORIL_TYPE_FIELD_NUMBER = 2;
                        private boolean hasOrilPrice;
                        private boolean hasOrilType;
                        private String orilPrice_ = "";
                        private String orilType_ = "";
                        private int cachedSize = -1;

                        public static OrilDetail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new OrilDetail().mergeFrom(codedInputStreamMicro);
                        }

                        public final OrilDetail clear() {
                            clearOrilPrice();
                            clearOrilType();
                            this.cachedSize = -1;
                            return this;
                        }

                        public OrilDetail clearOrilPrice() {
                            this.hasOrilPrice = false;
                            this.orilPrice_ = "";
                            return this;
                        }

                        public OrilDetail clearOrilType() {
                            this.hasOrilType = false;
                            this.orilType_ = "";
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public String getOrilPrice() {
                            return this.orilPrice_;
                        }

                        public String getOrilType() {
                            return this.orilType_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeStringSize = hasOrilPrice() ? CodedOutputStreamMicro.computeStringSize(1, getOrilPrice()) : 0;
                            if (hasOrilType()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getOrilType());
                            }
                            this.cachedSize = computeStringSize;
                            return computeStringSize;
                        }

                        public boolean hasOrilPrice() {
                            return this.hasOrilPrice;
                        }

                        public boolean hasOrilType() {
                            return this.hasOrilType;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public OrilDetail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 10) {
                                    setOrilPrice(codedInputStreamMicro.readString());
                                } else if (readTag == 18) {
                                    setOrilType(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public OrilDetail setOrilPrice(String str) {
                            this.hasOrilPrice = true;
                            this.orilPrice_ = str;
                            return this;
                        }

                        public OrilDetail setOrilType(String str) {
                            this.hasOrilType = true;
                            this.orilType_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasOrilPrice()) {
                                codedOutputStreamMicro.writeString(1, getOrilPrice());
                            }
                            if (hasOrilType()) {
                                codedOutputStreamMicro.writeString(2, getOrilType());
                            }
                        }

                        public static OrilDetail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (OrilDetail) new OrilDetail().mergeFrom(bArr);
                        }
                    }

                    public static OrilInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new OrilInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public OrilInfo addOrilDetail(OrilDetail orilDetail) {
                        if (orilDetail == null) {
                            return this;
                        }
                        if (this.orilDetail_.isEmpty()) {
                            this.orilDetail_ = new ArrayList();
                        }
                        this.orilDetail_.add(orilDetail);
                        return this;
                    }

                    public final OrilInfo clear() {
                        clearOrilDetail();
                        this.cachedSize = -1;
                        return this;
                    }

                    public OrilInfo clearOrilDetail() {
                        this.orilDetail_ = Collections.emptyList();
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public OrilDetail getOrilDetail(int i) {
                        return this.orilDetail_.get(i);
                    }

                    public int getOrilDetailCount() {
                        return this.orilDetail_.size();
                    }

                    public List<OrilDetail> getOrilDetailList() {
                        return this.orilDetail_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        Iterator<OrilDetail> it = getOrilDetailList().iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                        }
                        this.cachedSize = i;
                        return i;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public OrilInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                OrilDetail orilDetail = new OrilDetail();
                                codedInputStreamMicro.readMessage(orilDetail);
                                addOrilDetail(orilDetail);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public OrilInfo setOrilDetail(int i, OrilDetail orilDetail) {
                        if (orilDetail == null) {
                            return this;
                        }
                        this.orilDetail_.set(i, orilDetail);
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        Iterator<OrilDetail> it = getOrilDetailList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeMessage(1, it.next());
                        }
                    }

                    public static OrilInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (OrilInfo) new OrilInfo().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class PhoneDetail extends MessageMicro {
                    public static final int GROUP_FIELD_NUMBER = 1;
                    private List<Group> group_ = Collections.emptyList();
                    private int cachedSize = -1;

                    /* loaded from: classes7.dex */
                    public static final class Group extends MessageMicro {
                        public static final int BID_FIELD_NUMBER = 2;
                        public static final int NAME_FIELD_NUMBER = 3;
                        public static final int PHONE_FIELD_NUMBER = 1;
                        private boolean hasBid;
                        private boolean hasName;
                        private boolean hasPhone;
                        private String phone_ = "";
                        private String bid_ = "";
                        private String name_ = "";
                        private int cachedSize = -1;

                        public static Group parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Group().mergeFrom(codedInputStreamMicro);
                        }

                        public final Group clear() {
                            clearPhone();
                            clearBid();
                            clearName();
                            this.cachedSize = -1;
                            return this;
                        }

                        public Group clearBid() {
                            this.hasBid = false;
                            this.bid_ = "";
                            return this;
                        }

                        public Group clearName() {
                            this.hasName = false;
                            this.name_ = "";
                            return this;
                        }

                        public Group clearPhone() {
                            this.hasPhone = false;
                            this.phone_ = "";
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

                        public String getName() {
                            return this.name_;
                        }

                        public String getPhone() {
                            return this.phone_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int computeStringSize = hasPhone() ? CodedOutputStreamMicro.computeStringSize(1, getPhone()) : 0;
                            if (hasBid()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getBid());
                            }
                            if (hasName()) {
                                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getName());
                            }
                            this.cachedSize = computeStringSize;
                            return computeStringSize;
                        }

                        public boolean hasBid() {
                            return this.hasBid;
                        }

                        public boolean hasName() {
                            return this.hasName;
                        }

                        public boolean hasPhone() {
                            return this.hasPhone;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public Group mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                if (readTag == 0) {
                                    return this;
                                }
                                if (readTag == 10) {
                                    setPhone(codedInputStreamMicro.readString());
                                } else if (readTag == 18) {
                                    setBid(codedInputStreamMicro.readString());
                                } else if (readTag == 26) {
                                    setName(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                            }
                        }

                        public Group setBid(String str) {
                            this.hasBid = true;
                            this.bid_ = str;
                            return this;
                        }

                        public Group setName(String str) {
                            this.hasName = true;
                            this.name_ = str;
                            return this;
                        }

                        public Group setPhone(String str) {
                            this.hasPhone = true;
                            this.phone_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasPhone()) {
                                codedOutputStreamMicro.writeString(1, getPhone());
                            }
                            if (hasBid()) {
                                codedOutputStreamMicro.writeString(2, getBid());
                            }
                            if (hasName()) {
                                codedOutputStreamMicro.writeString(3, getName());
                            }
                        }

                        public static Group parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Group) new Group().mergeFrom(bArr);
                        }
                    }

                    public static PhoneDetail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new PhoneDetail().mergeFrom(codedInputStreamMicro);
                    }

                    public PhoneDetail addGroup(Group group) {
                        if (group == null) {
                            return this;
                        }
                        if (this.group_.isEmpty()) {
                            this.group_ = new ArrayList();
                        }
                        this.group_.add(group);
                        return this;
                    }

                    public final PhoneDetail clear() {
                        clearGroup();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PhoneDetail clearGroup() {
                        this.group_ = Collections.emptyList();
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public Group getGroup(int i) {
                        return this.group_.get(i);
                    }

                    public int getGroupCount() {
                        return this.group_.size();
                    }

                    public List<Group> getGroupList() {
                        return this.group_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        Iterator<Group> it = getGroupList().iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                        }
                        this.cachedSize = i;
                        return i;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public PhoneDetail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                Group group = new Group();
                                codedInputStreamMicro.readMessage(group);
                                addGroup(group);
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public PhoneDetail setGroup(int i, Group group) {
                        if (group == null) {
                            return this;
                        }
                        this.group_.set(i, group);
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        Iterator<Group> it = getGroupList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeMessage(1, it.next());
                        }
                    }

                    public static PhoneDetail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (PhoneDetail) new PhoneDetail().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class PhoneRisk extends MessageMicro {
                    public static final int BID_FIELD_NUMBER = 1;
                    public static final int WORD_FIELD_NUMBER = 2;
                    private boolean hasBid;
                    private boolean hasWord;
                    private String bid_ = "";
                    private String word_ = "";
                    private int cachedSize = -1;

                    public static PhoneRisk parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new PhoneRisk().mergeFrom(codedInputStreamMicro);
                    }

                    public final PhoneRisk clear() {
                        clearBid();
                        clearWord();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PhoneRisk clearBid() {
                        this.hasBid = false;
                        this.bid_ = "";
                        return this;
                    }

                    public PhoneRisk clearWord() {
                        this.hasWord = false;
                        this.word_ = "";
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

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasBid() ? CodedOutputStreamMicro.computeStringSize(1, getBid()) : 0;
                        if (hasWord()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWord());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public String getWord() {
                        return this.word_;
                    }

                    public boolean hasBid() {
                        return this.hasBid;
                    }

                    public boolean hasWord() {
                        return this.hasWord;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public PhoneRisk mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setBid(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setWord(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public PhoneRisk setBid(String str) {
                        this.hasBid = true;
                        this.bid_ = str;
                        return this;
                    }

                    public PhoneRisk setWord(String str) {
                        this.hasWord = true;
                        this.word_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasBid()) {
                            codedOutputStreamMicro.writeString(1, getBid());
                        }
                        if (hasWord()) {
                            codedOutputStreamMicro.writeString(2, getWord());
                        }
                    }

                    public static PhoneRisk parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (PhoneRisk) new PhoneRisk().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class PremiumInfo extends MessageMicro {
                    public static final int DISCOUNT_CONTENT_FIELD_NUMBER = 1;
                    public static final int DISCOUNT_DL_FIELD_NUMBER = 2;
                    public static final int DISCOUNT_ID_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 4;
                    private boolean hasDiscountContent;
                    private boolean hasDiscountDl;
                    private boolean hasDiscountId;
                    private boolean hasName;
                    private String discountContent_ = "";
                    private String discountDl_ = "";
                    private String discountId_ = "";
                    private String name_ = "";
                    private int cachedSize = -1;

                    public static PremiumInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new PremiumInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public final PremiumInfo clear() {
                        clearDiscountContent();
                        clearDiscountDl();
                        clearDiscountId();
                        clearName();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PremiumInfo clearDiscountContent() {
                        this.hasDiscountContent = false;
                        this.discountContent_ = "";
                        return this;
                    }

                    public PremiumInfo clearDiscountDl() {
                        this.hasDiscountDl = false;
                        this.discountDl_ = "";
                        return this;
                    }

                    public PremiumInfo clearDiscountId() {
                        this.hasDiscountId = false;
                        this.discountId_ = "";
                        return this;
                    }

                    public PremiumInfo clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getDiscountContent() {
                        return this.discountContent_;
                    }

                    public String getDiscountDl() {
                        return this.discountDl_;
                    }

                    public String getDiscountId() {
                        return this.discountId_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeStringSize = hasDiscountContent() ? CodedOutputStreamMicro.computeStringSize(1, getDiscountContent()) : 0;
                        if (hasDiscountDl()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDiscountDl());
                        }
                        if (hasDiscountId()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getDiscountId());
                        }
                        if (hasName()) {
                            computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getName());
                        }
                        this.cachedSize = computeStringSize;
                        return computeStringSize;
                    }

                    public boolean hasDiscountContent() {
                        return this.hasDiscountContent;
                    }

                    public boolean hasDiscountDl() {
                        return this.hasDiscountDl;
                    }

                    public boolean hasDiscountId() {
                        return this.hasDiscountId;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public PremiumInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 10) {
                                setDiscountContent(codedInputStreamMicro.readString());
                            } else if (readTag == 18) {
                                setDiscountDl(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                setDiscountId(codedInputStreamMicro.readString());
                            } else if (readTag == 34) {
                                setName(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public PremiumInfo setDiscountContent(String str) {
                        this.hasDiscountContent = true;
                        this.discountContent_ = str;
                        return this;
                    }

                    public PremiumInfo setDiscountDl(String str) {
                        this.hasDiscountDl = true;
                        this.discountDl_ = str;
                        return this;
                    }

                    public PremiumInfo setDiscountId(String str) {
                        this.hasDiscountId = true;
                        this.discountId_ = str;
                        return this;
                    }

                    public PremiumInfo setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasDiscountContent()) {
                            codedOutputStreamMicro.writeString(1, getDiscountContent());
                        }
                        if (hasDiscountDl()) {
                            codedOutputStreamMicro.writeString(2, getDiscountDl());
                        }
                        if (hasDiscountId()) {
                            codedOutputStreamMicro.writeString(3, getDiscountId());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(4, getName());
                        }
                    }

                    public static PremiumInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (PremiumInfo) new PremiumInfo().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class RecommendDish extends MessageMicro {
                    public static final int COLOR_FIELD_NUMBER = 3;
                    public static final int DISH_NAME_FIELD_NUMBER = 2;
                    public static final int DISH_NUM_FIELD_NUMBER = 1;
                    private boolean hasColor;
                    private boolean hasDishName;
                    private boolean hasDishNum;
                    private int dishNum_ = 0;
                    private String dishName_ = "";
                    private String color_ = "";
                    private int cachedSize = -1;

                    public static RecommendDish parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new RecommendDish().mergeFrom(codedInputStreamMicro);
                    }

                    public final RecommendDish clear() {
                        clearDishNum();
                        clearDishName();
                        clearColor();
                        this.cachedSize = -1;
                        return this;
                    }

                    public RecommendDish clearColor() {
                        this.hasColor = false;
                        this.color_ = "";
                        return this;
                    }

                    public RecommendDish clearDishName() {
                        this.hasDishName = false;
                        this.dishName_ = "";
                        return this;
                    }

                    public RecommendDish clearDishNum() {
                        this.hasDishNum = false;
                        this.dishNum_ = 0;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getColor() {
                        return this.color_;
                    }

                    public String getDishName() {
                        return this.dishName_;
                    }

                    public int getDishNum() {
                        return this.dishNum_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasDishNum() ? CodedOutputStreamMicro.computeInt32Size(1, getDishNum()) : 0;
                        if (hasDishName()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getDishName());
                        }
                        if (hasColor()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getColor());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public boolean hasColor() {
                        return this.hasColor;
                    }

                    public boolean hasDishName() {
                        return this.hasDishName;
                    }

                    public boolean hasDishNum() {
                        return this.hasDishNum;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public RecommendDish mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setDishNum(codedInputStreamMicro.readInt32());
                            } else if (readTag == 18) {
                                setDishName(codedInputStreamMicro.readString());
                            } else if (readTag == 26) {
                                setColor(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public RecommendDish setColor(String str) {
                        this.hasColor = true;
                        this.color_ = str;
                        return this;
                    }

                    public RecommendDish setDishName(String str) {
                        this.hasDishName = true;
                        this.dishName_ = str;
                        return this;
                    }

                    public RecommendDish setDishNum(int i) {
                        this.hasDishNum = true;
                        this.dishNum_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasDishNum()) {
                            codedOutputStreamMicro.writeInt32(1, getDishNum());
                        }
                        if (hasDishName()) {
                            codedOutputStreamMicro.writeString(2, getDishName());
                        }
                        if (hasColor()) {
                            codedOutputStreamMicro.writeString(3, getColor());
                        }
                    }

                    public static RecommendDish parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (RecommendDish) new RecommendDish().mergeFrom(bArr);
                    }
                }

                /* loaded from: classes7.dex */
                public static final class Upperleftcorner extends MessageMicro {
                    public static final int RESOURCE_ID_FIELD_NUMBER = 1;
                    public static final int RESOURCE_URL_FIELD_NUMBER = 2;
                    private boolean hasResourceId;
                    private boolean hasResourceUrl;
                    private int resourceId_ = 0;
                    private String resourceUrl_ = "";
                    private int cachedSize = -1;

                    public static Upperleftcorner parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Upperleftcorner().mergeFrom(codedInputStreamMicro);
                    }

                    public final Upperleftcorner clear() {
                        clearResourceId();
                        clearResourceUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Upperleftcorner clearResourceId() {
                        this.hasResourceId = false;
                        this.resourceId_ = 0;
                        return this;
                    }

                    public Upperleftcorner clearResourceUrl() {
                        this.hasResourceUrl = false;
                        this.resourceUrl_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getResourceId() {
                        return this.resourceId_;
                    }

                    public String getResourceUrl() {
                        return this.resourceUrl_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int computeInt32Size = hasResourceId() ? CodedOutputStreamMicro.computeInt32Size(1, getResourceId()) : 0;
                        if (hasResourceUrl()) {
                            computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getResourceUrl());
                        }
                        this.cachedSize = computeInt32Size;
                        return computeInt32Size;
                    }

                    public boolean hasResourceId() {
                        return this.hasResourceId;
                    }

                    public boolean hasResourceUrl() {
                        return this.hasResourceUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Upperleftcorner mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                setResourceId(codedInputStreamMicro.readInt32());
                            } else if (readTag == 18) {
                                setResourceUrl(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public Upperleftcorner setResourceId(int i) {
                        this.hasResourceId = true;
                        this.resourceId_ = i;
                        return this;
                    }

                    public Upperleftcorner setResourceUrl(String str) {
                        this.hasResourceUrl = true;
                        this.resourceUrl_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasResourceId()) {
                            codedOutputStreamMicro.writeInt32(1, getResourceId());
                        }
                        if (hasResourceUrl()) {
                            codedOutputStreamMicro.writeString(2, getResourceUrl());
                        }
                    }

                    public static Upperleftcorner parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Upperleftcorner) new Upperleftcorner().mergeFrom(bArr);
                    }
                }

                public static DetailInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new DetailInfo().mergeFrom(codedInputStreamMicro);
                }

                public DetailInfo addActivity(Activity activity) {
                    if (activity == null) {
                        return this;
                    }
                    if (this.activity_.isEmpty()) {
                        this.activity_ = new ArrayList();
                    }
                    this.activity_.add(activity);
                    return this;
                }

                public DetailInfo addFlag(String str) {
                    str.getClass();
                    if (this.flag_.isEmpty()) {
                        this.flag_ = new ArrayList();
                    }
                    this.flag_.add(str);
                    return this;
                }

                public DetailInfo addHotelService(HotelService hotelService) {
                    if (hotelService == null) {
                        return this;
                    }
                    if (this.hotelService_.isEmpty()) {
                        this.hotelService_ = new ArrayList();
                    }
                    this.hotelService_.add(hotelService);
                    return this;
                }

                public DetailInfo addImpression(Impression impression) {
                    if (impression == null) {
                        return this;
                    }
                    if (this.impression_.isEmpty()) {
                        this.impression_ = new ArrayList();
                    }
                    this.impression_.add(impression);
                    return this;
                }

                public final DetailInfo clear() {
                    clearPremiumInfo();
                    clearGrouponInfo();
                    clearOrilInfo();
                    clearBookInfo();
                    clearActivity();
                    clearFlag();
                    clearOverallRating();
                    clearPriceText();
                    clearTag();
                    clearImage();
                    clearShowInfo();
                    clearPremiumFlag();
                    clearDiscountTotal();
                    clearGrouponTotal();
                    clearCommentNum();
                    clearMovieFlag();
                    clearMovieFilmCount();
                    clearGrouponFlag();
                    clearWapBookable();
                    clearPrice();
                    clearWiseFullroom();
                    clearDiscount();
                    clearGrade();
                    clearGuide();
                    clearSpecialService();
                    clearFlagOnLeft();
                    clearImpression();
                    clearMeishipaihao();
                    clearTradeTag();
                    clearMarketbiz();
                    clearValidate();
                    clearWiseHourlyBookable();
                    clearDisText();
                    clearLbcBusinessVip();
                    clearRecommendDish();
                    clearBusinessService();
                    clearStatusLabel();
                    clearUpperleftcorner();
                    clearDisplayInfoRedu();
                    clearDisplayInfoCommentLabel();
                    clearMbc();
                    clearAoi();
                    clearSpecialTag();
                    clearOriginPriceText();
                    clearHotelService();
                    clearAllcardextension();
                    clearShopHours();
                    clearVsContent();
                    clearPhoneDetail();
                    clearPhoneRisk();
                    clearNewBusinessTime();
                    clearMiniprogram();
                    clearMnpKeyInfo();
                    clearBlinkBuilding();
                    this.cachedSize = -1;
                    return this;
                }

                public DetailInfo clearActivity() {
                    this.activity_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearAllcardextension() {
                    this.hasAllcardextension = false;
                    this.allcardextension_ = null;
                    return this;
                }

                public DetailInfo clearAoi() {
                    this.hasAoi = false;
                    this.aoi_ = "";
                    return this;
                }

                public DetailInfo clearBlinkBuilding() {
                    this.hasBlinkBuilding = false;
                    this.blinkBuilding_ = null;
                    return this;
                }

                public DetailInfo clearBookInfo() {
                    this.hasBookInfo = false;
                    this.bookInfo_ = null;
                    return this;
                }

                public DetailInfo clearBusinessService() {
                    this.hasBusinessService = false;
                    this.businessService_ = null;
                    return this;
                }

                public DetailInfo clearCommentNum() {
                    this.hasCommentNum = false;
                    this.commentNum_ = "";
                    return this;
                }

                public DetailInfo clearDisText() {
                    this.hasDisText = false;
                    this.disText_ = "";
                    return this;
                }

                public DetailInfo clearDiscount() {
                    this.hasDiscount = false;
                    this.discount_ = "";
                    return this;
                }

                public DetailInfo clearDiscountTotal() {
                    this.hasDiscountTotal = false;
                    this.discountTotal_ = 0;
                    return this;
                }

                public DetailInfo clearDisplayInfoCommentLabel() {
                    this.hasDisplayInfoCommentLabel = false;
                    this.displayInfoCommentLabel_ = null;
                    return this;
                }

                public DetailInfo clearDisplayInfoRedu() {
                    this.hasDisplayInfoRedu = false;
                    this.displayInfoRedu_ = "";
                    return this;
                }

                public DetailInfo clearFlag() {
                    this.flag_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearFlagOnLeft() {
                    this.hasFlagOnLeft = false;
                    this.flagOnLeft_ = "";
                    return this;
                }

                public DetailInfo clearGrade() {
                    this.hasGrade = false;
                    this.grade_ = "";
                    return this;
                }

                public DetailInfo clearGrouponFlag() {
                    this.hasGrouponFlag = false;
                    this.grouponFlag_ = 0;
                    return this;
                }

                public DetailInfo clearGrouponInfo() {
                    this.hasGrouponInfo = false;
                    this.grouponInfo_ = null;
                    return this;
                }

                public DetailInfo clearGrouponTotal() {
                    this.hasGrouponTotal = false;
                    this.grouponTotal_ = 0;
                    return this;
                }

                public DetailInfo clearGuide() {
                    this.hasGuide = false;
                    this.guide_ = "";
                    return this;
                }

                public DetailInfo clearHotelService() {
                    this.hotelService_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearImage() {
                    this.hasImage = false;
                    this.image_ = "";
                    return this;
                }

                public DetailInfo clearImpression() {
                    this.impression_ = Collections.emptyList();
                    return this;
                }

                public DetailInfo clearLbcBusinessVip() {
                    this.hasLbcBusinessVip = false;
                    this.lbcBusinessVip_ = null;
                    return this;
                }

                public DetailInfo clearMarketbiz() {
                    this.hasMarketbiz = false;
                    this.marketbiz_ = null;
                    return this;
                }

                public DetailInfo clearMbc() {
                    this.hasMbc = false;
                    this.mbc_ = null;
                    return this;
                }

                public DetailInfo clearMeishipaihao() {
                    this.hasMeishipaihao = false;
                    this.meishipaihao_ = null;
                    return this;
                }

                public DetailInfo clearMiniprogram() {
                    this.hasMiniprogram = false;
                    this.miniprogram_ = "";
                    return this;
                }

                public DetailInfo clearMnpKeyInfo() {
                    this.hasMnpKeyInfo = false;
                    this.mnpKeyInfo_ = null;
                    return this;
                }

                public DetailInfo clearMovieFilmCount() {
                    this.hasMovieFilmCount = false;
                    this.movieFilmCount_ = 0;
                    return this;
                }

                public DetailInfo clearMovieFlag() {
                    this.hasMovieFlag = false;
                    this.movieFlag_ = "";
                    return this;
                }

                public DetailInfo clearNewBusinessTime() {
                    this.hasNewBusinessTime = false;
                    this.newBusinessTime_ = "";
                    return this;
                }

                public DetailInfo clearOriginPriceText() {
                    this.hasOriginPriceText = false;
                    this.originPriceText_ = "";
                    return this;
                }

                public DetailInfo clearOrilInfo() {
                    this.hasOrilInfo = false;
                    this.orilInfo_ = null;
                    return this;
                }

                public DetailInfo clearOverallRating() {
                    this.hasOverallRating = false;
                    this.overallRating_ = "";
                    return this;
                }

                public DetailInfo clearPhoneDetail() {
                    this.hasPhoneDetail = false;
                    this.phoneDetail_ = null;
                    return this;
                }

                public DetailInfo clearPhoneRisk() {
                    this.hasPhoneRisk = false;
                    this.phoneRisk_ = null;
                    return this;
                }

                public DetailInfo clearPremiumFlag() {
                    this.hasPremiumFlag = false;
                    this.premiumFlag_ = 0;
                    return this;
                }

                public DetailInfo clearPremiumInfo() {
                    this.hasPremiumInfo = false;
                    this.premiumInfo_ = null;
                    return this;
                }

                public DetailInfo clearPrice() {
                    this.hasPrice = false;
                    this.price_ = "";
                    return this;
                }

                public DetailInfo clearPriceText() {
                    this.hasPriceText = false;
                    this.priceText_ = "";
                    return this;
                }

                public DetailInfo clearRecommendDish() {
                    this.hasRecommendDish = false;
                    this.recommendDish_ = null;
                    return this;
                }

                public DetailInfo clearShopHours() {
                    this.hasShopHours = false;
                    this.shopHours_ = "";
                    return this;
                }

                public DetailInfo clearShowInfo() {
                    this.hasShowInfo = false;
                    this.showInfo_ = "";
                    return this;
                }

                public DetailInfo clearSpecialService() {
                    this.hasSpecialService = false;
                    this.specialService_ = "";
                    return this;
                }

                public DetailInfo clearSpecialTag() {
                    this.hasSpecialTag = false;
                    this.specialTag_ = "";
                    return this;
                }

                public DetailInfo clearStatusLabel() {
                    this.hasStatusLabel = false;
                    this.statusLabel_ = "";
                    return this;
                }

                public DetailInfo clearTag() {
                    this.hasTag = false;
                    this.tag_ = "";
                    return this;
                }

                public DetailInfo clearTradeTag() {
                    this.hasTradeTag = false;
                    this.tradeTag_ = "";
                    return this;
                }

                public DetailInfo clearUpperleftcorner() {
                    this.hasUpperleftcorner = false;
                    this.upperleftcorner_ = null;
                    return this;
                }

                public DetailInfo clearValidate() {
                    this.hasValidate = false;
                    this.validate_ = "";
                    return this;
                }

                public DetailInfo clearVsContent() {
                    this.hasVsContent = false;
                    this.vsContent_ = "";
                    return this;
                }

                public DetailInfo clearWapBookable() {
                    this.hasWapBookable = false;
                    this.wapBookable_ = "";
                    return this;
                }

                public DetailInfo clearWiseFullroom() {
                    this.hasWiseFullroom = false;
                    this.wiseFullroom_ = "";
                    return this;
                }

                public DetailInfo clearWiseHourlyBookable() {
                    this.hasWiseHourlyBookable = false;
                    this.wiseHourlyBookable_ = "";
                    return this;
                }

                public Activity getActivity(int i) {
                    return this.activity_.get(i);
                }

                public int getActivityCount() {
                    return this.activity_.size();
                }

                public List<Activity> getActivityList() {
                    return this.activity_;
                }

                public Allcardextension getAllcardextension() {
                    return this.allcardextension_;
                }

                public String getAoi() {
                    return this.aoi_;
                }

                public BlinkBuilding getBlinkBuilding() {
                    return this.blinkBuilding_;
                }

                public BookInfo getBookInfo() {
                    return this.bookInfo_;
                }

                public BusinessService getBusinessService() {
                    return this.businessService_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getCommentNum() {
                    return this.commentNum_;
                }

                public String getDisText() {
                    return this.disText_;
                }

                public String getDiscount() {
                    return this.discount_;
                }

                public int getDiscountTotal() {
                    return this.discountTotal_;
                }

                public DisplayInfoCommentLabel getDisplayInfoCommentLabel() {
                    return this.displayInfoCommentLabel_;
                }

                public String getDisplayInfoRedu() {
                    return this.displayInfoRedu_;
                }

                public String getFlag(int i) {
                    return this.flag_.get(i);
                }

                public int getFlagCount() {
                    return this.flag_.size();
                }

                public List<String> getFlagList() {
                    return this.flag_;
                }

                public String getFlagOnLeft() {
                    return this.flagOnLeft_;
                }

                public String getGrade() {
                    return this.grade_;
                }

                public int getGrouponFlag() {
                    return this.grouponFlag_;
                }

                public GrouponInfo getGrouponInfo() {
                    return this.grouponInfo_;
                }

                public int getGrouponTotal() {
                    return this.grouponTotal_;
                }

                public String getGuide() {
                    return this.guide_;
                }

                public HotelService getHotelService(int i) {
                    return this.hotelService_.get(i);
                }

                public int getHotelServiceCount() {
                    return this.hotelService_.size();
                }

                public List<HotelService> getHotelServiceList() {
                    return this.hotelService_;
                }

                public String getImage() {
                    return this.image_;
                }

                public Impression getImpression(int i) {
                    return this.impression_.get(i);
                }

                public int getImpressionCount() {
                    return this.impression_.size();
                }

                public List<Impression> getImpressionList() {
                    return this.impression_;
                }

                public LbcBusinessVip getLbcBusinessVip() {
                    return this.lbcBusinessVip_;
                }

                public Marketbiz getMarketbiz() {
                    return this.marketbiz_;
                }

                public Mbc getMbc() {
                    return this.mbc_;
                }

                public Meishipaihao getMeishipaihao() {
                    return this.meishipaihao_;
                }

                public String getMiniprogram() {
                    return this.miniprogram_;
                }

                public MnpKeyInfo getMnpKeyInfo() {
                    return this.mnpKeyInfo_;
                }

                public int getMovieFilmCount() {
                    return this.movieFilmCount_;
                }

                public String getMovieFlag() {
                    return this.movieFlag_;
                }

                public String getNewBusinessTime() {
                    return this.newBusinessTime_;
                }

                public String getOriginPriceText() {
                    return this.originPriceText_;
                }

                public OrilInfo getOrilInfo() {
                    return this.orilInfo_;
                }

                public String getOverallRating() {
                    return this.overallRating_;
                }

                public PhoneDetail getPhoneDetail() {
                    return this.phoneDetail_;
                }

                public PhoneRisk getPhoneRisk() {
                    return this.phoneRisk_;
                }

                public int getPremiumFlag() {
                    return this.premiumFlag_;
                }

                public PremiumInfo getPremiumInfo() {
                    return this.premiumInfo_;
                }

                public String getPrice() {
                    return this.price_;
                }

                public String getPriceText() {
                    return this.priceText_;
                }

                public RecommendDish getRecommendDish() {
                    return this.recommendDish_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    Iterator<String> it = getFlagList().iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
                    }
                    int size = i + getFlagList().size();
                    if (hasOverallRating()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getOverallRating());
                    }
                    if (hasPriceText()) {
                        size += CodedOutputStreamMicro.computeStringSize(3, getPriceText());
                    }
                    if (hasTag()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getTag());
                    }
                    if (hasImage()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getImage());
                    }
                    if (hasShowInfo()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, getShowInfo());
                    }
                    if (hasPremiumFlag()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, getPremiumFlag());
                    }
                    if (hasDiscountTotal()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, getDiscountTotal());
                    }
                    if (hasGrouponTotal()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, getGrouponTotal());
                    }
                    if (hasPremiumInfo()) {
                        size += CodedOutputStreamMicro.computeMessageSize(10, getPremiumInfo());
                    }
                    if (hasCommentNum()) {
                        size += CodedOutputStreamMicro.computeStringSize(11, getCommentNum());
                    }
                    if (hasMovieFlag()) {
                        size += CodedOutputStreamMicro.computeStringSize(12, getMovieFlag());
                    }
                    if (hasMovieFilmCount()) {
                        size += CodedOutputStreamMicro.computeInt32Size(13, getMovieFilmCount());
                    }
                    if (hasGrouponFlag()) {
                        size += CodedOutputStreamMicro.computeInt32Size(14, getGrouponFlag());
                    }
                    if (hasGrouponInfo()) {
                        size += CodedOutputStreamMicro.computeMessageSize(15, getGrouponInfo());
                    }
                    if (hasOrilInfo()) {
                        size += CodedOutputStreamMicro.computeMessageSize(16, getOrilInfo());
                    }
                    if (hasWapBookable()) {
                        size += CodedOutputStreamMicro.computeStringSize(17, getWapBookable());
                    }
                    if (hasBookInfo()) {
                        size += CodedOutputStreamMicro.computeMessageSize(18, getBookInfo());
                    }
                    if (hasPrice()) {
                        size += CodedOutputStreamMicro.computeStringSize(19, getPrice());
                    }
                    if (hasWiseFullroom()) {
                        size += CodedOutputStreamMicro.computeStringSize(20, getWiseFullroom());
                    }
                    if (hasDiscount()) {
                        size += CodedOutputStreamMicro.computeStringSize(21, getDiscount());
                    }
                    if (hasGrade()) {
                        size += CodedOutputStreamMicro.computeStringSize(22, getGrade());
                    }
                    Iterator<Activity> it2 = getActivityList().iterator();
                    while (it2.hasNext()) {
                        size += CodedOutputStreamMicro.computeMessageSize(23, it2.next());
                    }
                    if (hasGuide()) {
                        size += CodedOutputStreamMicro.computeStringSize(24, getGuide());
                    }
                    if (hasSpecialService()) {
                        size += CodedOutputStreamMicro.computeStringSize(25, getSpecialService());
                    }
                    if (hasFlagOnLeft()) {
                        size += CodedOutputStreamMicro.computeStringSize(26, getFlagOnLeft());
                    }
                    Iterator<Impression> it3 = getImpressionList().iterator();
                    while (it3.hasNext()) {
                        size += CodedOutputStreamMicro.computeMessageSize(27, it3.next());
                    }
                    if (hasMeishipaihao()) {
                        size += CodedOutputStreamMicro.computeMessageSize(28, getMeishipaihao());
                    }
                    if (hasTradeTag()) {
                        size += CodedOutputStreamMicro.computeStringSize(29, getTradeTag());
                    }
                    if (hasMarketbiz()) {
                        size += CodedOutputStreamMicro.computeMessageSize(30, getMarketbiz());
                    }
                    if (hasValidate()) {
                        size += CodedOutputStreamMicro.computeStringSize(31, getValidate());
                    }
                    if (hasWiseHourlyBookable()) {
                        size += CodedOutputStreamMicro.computeStringSize(32, getWiseHourlyBookable());
                    }
                    if (hasDisText()) {
                        size += CodedOutputStreamMicro.computeStringSize(33, getDisText());
                    }
                    if (hasLbcBusinessVip()) {
                        size += CodedOutputStreamMicro.computeMessageSize(34, getLbcBusinessVip());
                    }
                    if (hasRecommendDish()) {
                        size += CodedOutputStreamMicro.computeMessageSize(36, getRecommendDish());
                    }
                    if (hasBusinessService()) {
                        size += CodedOutputStreamMicro.computeMessageSize(37, getBusinessService());
                    }
                    if (hasStatusLabel()) {
                        size += CodedOutputStreamMicro.computeStringSize(38, getStatusLabel());
                    }
                    if (hasUpperleftcorner()) {
                        size += CodedOutputStreamMicro.computeMessageSize(39, getUpperleftcorner());
                    }
                    if (hasDisplayInfoRedu()) {
                        size += CodedOutputStreamMicro.computeStringSize(40, getDisplayInfoRedu());
                    }
                    if (hasDisplayInfoCommentLabel()) {
                        size += CodedOutputStreamMicro.computeMessageSize(41, getDisplayInfoCommentLabel());
                    }
                    if (hasMbc()) {
                        size += CodedOutputStreamMicro.computeMessageSize(42, getMbc());
                    }
                    if (hasAoi()) {
                        size += CodedOutputStreamMicro.computeStringSize(43, getAoi());
                    }
                    if (hasSpecialTag()) {
                        size += CodedOutputStreamMicro.computeStringSize(44, getSpecialTag());
                    }
                    if (hasOriginPriceText()) {
                        size += CodedOutputStreamMicro.computeStringSize(45, getOriginPriceText());
                    }
                    Iterator<HotelService> it4 = getHotelServiceList().iterator();
                    while (it4.hasNext()) {
                        size += CodedOutputStreamMicro.computeMessageSize(46, it4.next());
                    }
                    if (hasAllcardextension()) {
                        size += CodedOutputStreamMicro.computeMessageSize(47, getAllcardextension());
                    }
                    if (hasShopHours()) {
                        size += CodedOutputStreamMicro.computeStringSize(48, getShopHours());
                    }
                    if (hasVsContent()) {
                        size += CodedOutputStreamMicro.computeStringSize(49, getVsContent());
                    }
                    if (hasPhoneDetail()) {
                        size += CodedOutputStreamMicro.computeMessageSize(50, getPhoneDetail());
                    }
                    if (hasPhoneRisk()) {
                        size += CodedOutputStreamMicro.computeMessageSize(51, getPhoneRisk());
                    }
                    if (hasNewBusinessTime()) {
                        size += CodedOutputStreamMicro.computeStringSize(52, getNewBusinessTime());
                    }
                    if (hasMiniprogram()) {
                        size += CodedOutputStreamMicro.computeStringSize(53, getMiniprogram());
                    }
                    if (hasMnpKeyInfo()) {
                        size += CodedOutputStreamMicro.computeMessageSize(54, getMnpKeyInfo());
                    }
                    if (hasBlinkBuilding()) {
                        size += CodedOutputStreamMicro.computeMessageSize(55, getBlinkBuilding());
                    }
                    this.cachedSize = size;
                    return size;
                }

                public String getShopHours() {
                    return this.shopHours_;
                }

                public String getShowInfo() {
                    return this.showInfo_;
                }

                public String getSpecialService() {
                    return this.specialService_;
                }

                public String getSpecialTag() {
                    return this.specialTag_;
                }

                public String getStatusLabel() {
                    return this.statusLabel_;
                }

                public String getTag() {
                    return this.tag_;
                }

                public String getTradeTag() {
                    return this.tradeTag_;
                }

                public Upperleftcorner getUpperleftcorner() {
                    return this.upperleftcorner_;
                }

                public String getValidate() {
                    return this.validate_;
                }

                public String getVsContent() {
                    return this.vsContent_;
                }

                public String getWapBookable() {
                    return this.wapBookable_;
                }

                public String getWiseFullroom() {
                    return this.wiseFullroom_;
                }

                public String getWiseHourlyBookable() {
                    return this.wiseHourlyBookable_;
                }

                public boolean hasAllcardextension() {
                    return this.hasAllcardextension;
                }

                public boolean hasAoi() {
                    return this.hasAoi;
                }

                public boolean hasBlinkBuilding() {
                    return this.hasBlinkBuilding;
                }

                public boolean hasBookInfo() {
                    return this.hasBookInfo;
                }

                public boolean hasBusinessService() {
                    return this.hasBusinessService;
                }

                public boolean hasCommentNum() {
                    return this.hasCommentNum;
                }

                public boolean hasDisText() {
                    return this.hasDisText;
                }

                public boolean hasDiscount() {
                    return this.hasDiscount;
                }

                public boolean hasDiscountTotal() {
                    return this.hasDiscountTotal;
                }

                public boolean hasDisplayInfoCommentLabel() {
                    return this.hasDisplayInfoCommentLabel;
                }

                public boolean hasDisplayInfoRedu() {
                    return this.hasDisplayInfoRedu;
                }

                public boolean hasFlagOnLeft() {
                    return this.hasFlagOnLeft;
                }

                public boolean hasGrade() {
                    return this.hasGrade;
                }

                public boolean hasGrouponFlag() {
                    return this.hasGrouponFlag;
                }

                public boolean hasGrouponInfo() {
                    return this.hasGrouponInfo;
                }

                public boolean hasGrouponTotal() {
                    return this.hasGrouponTotal;
                }

                public boolean hasGuide() {
                    return this.hasGuide;
                }

                public boolean hasImage() {
                    return this.hasImage;
                }

                public boolean hasLbcBusinessVip() {
                    return this.hasLbcBusinessVip;
                }

                public boolean hasMarketbiz() {
                    return this.hasMarketbiz;
                }

                public boolean hasMbc() {
                    return this.hasMbc;
                }

                public boolean hasMeishipaihao() {
                    return this.hasMeishipaihao;
                }

                public boolean hasMiniprogram() {
                    return this.hasMiniprogram;
                }

                public boolean hasMnpKeyInfo() {
                    return this.hasMnpKeyInfo;
                }

                public boolean hasMovieFilmCount() {
                    return this.hasMovieFilmCount;
                }

                public boolean hasMovieFlag() {
                    return this.hasMovieFlag;
                }

                public boolean hasNewBusinessTime() {
                    return this.hasNewBusinessTime;
                }

                public boolean hasOriginPriceText() {
                    return this.hasOriginPriceText;
                }

                public boolean hasOrilInfo() {
                    return this.hasOrilInfo;
                }

                public boolean hasOverallRating() {
                    return this.hasOverallRating;
                }

                public boolean hasPhoneDetail() {
                    return this.hasPhoneDetail;
                }

                public boolean hasPhoneRisk() {
                    return this.hasPhoneRisk;
                }

                public boolean hasPremiumFlag() {
                    return this.hasPremiumFlag;
                }

                public boolean hasPremiumInfo() {
                    return this.hasPremiumInfo;
                }

                public boolean hasPrice() {
                    return this.hasPrice;
                }

                public boolean hasPriceText() {
                    return this.hasPriceText;
                }

                public boolean hasRecommendDish() {
                    return this.hasRecommendDish;
                }

                public boolean hasShopHours() {
                    return this.hasShopHours;
                }

                public boolean hasShowInfo() {
                    return this.hasShowInfo;
                }

                public boolean hasSpecialService() {
                    return this.hasSpecialService;
                }

                public boolean hasSpecialTag() {
                    return this.hasSpecialTag;
                }

                public boolean hasStatusLabel() {
                    return this.hasStatusLabel;
                }

                public boolean hasTag() {
                    return this.hasTag;
                }

                public boolean hasTradeTag() {
                    return this.hasTradeTag;
                }

                public boolean hasUpperleftcorner() {
                    return this.hasUpperleftcorner;
                }

                public boolean hasValidate() {
                    return this.hasValidate;
                }

                public boolean hasVsContent() {
                    return this.hasVsContent;
                }

                public boolean hasWapBookable() {
                    return this.hasWapBookable;
                }

                public boolean hasWiseFullroom() {
                    return this.hasWiseFullroom;
                }

                public boolean hasWiseHourlyBookable() {
                    return this.hasWiseHourlyBookable;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public DetailInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                return this;
                            case 10:
                                addFlag(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                setOverallRating(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                setPriceText(codedInputStreamMicro.readString());
                                break;
                            case 34:
                                setTag(codedInputStreamMicro.readString());
                                break;
                            case 42:
                                setImage(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                setShowInfo(codedInputStreamMicro.readString());
                                break;
                            case 56:
                                setPremiumFlag(codedInputStreamMicro.readInt32());
                                break;
                            case 64:
                                setDiscountTotal(codedInputStreamMicro.readInt32());
                                break;
                            case 72:
                                setGrouponTotal(codedInputStreamMicro.readInt32());
                                break;
                            case 82:
                                PremiumInfo premiumInfo = new PremiumInfo();
                                codedInputStreamMicro.readMessage(premiumInfo);
                                setPremiumInfo(premiumInfo);
                                break;
                            case 90:
                                setCommentNum(codedInputStreamMicro.readString());
                                break;
                            case 98:
                                setMovieFlag(codedInputStreamMicro.readString());
                                break;
                            case 104:
                                setMovieFilmCount(codedInputStreamMicro.readInt32());
                                break;
                            case 112:
                                setGrouponFlag(codedInputStreamMicro.readInt32());
                                break;
                            case 122:
                                GrouponInfo grouponInfo = new GrouponInfo();
                                codedInputStreamMicro.readMessage(grouponInfo);
                                setGrouponInfo(grouponInfo);
                                break;
                            case 130:
                                OrilInfo orilInfo = new OrilInfo();
                                codedInputStreamMicro.readMessage(orilInfo);
                                setOrilInfo(orilInfo);
                                break;
                            case 138:
                                setWapBookable(codedInputStreamMicro.readString());
                                break;
                            case 146:
                                BookInfo bookInfo = new BookInfo();
                                codedInputStreamMicro.readMessage(bookInfo);
                                setBookInfo(bookInfo);
                                break;
                            case 154:
                                setPrice(codedInputStreamMicro.readString());
                                break;
                            case 162:
                                setWiseFullroom(codedInputStreamMicro.readString());
                                break;
                            case 170:
                                setDiscount(codedInputStreamMicro.readString());
                                break;
                            case 178:
                                setGrade(codedInputStreamMicro.readString());
                                break;
                            case 186:
                                Activity activity = new Activity();
                                codedInputStreamMicro.readMessage(activity);
                                addActivity(activity);
                                break;
                            case 194:
                                setGuide(codedInputStreamMicro.readString());
                                break;
                            case 202:
                                setSpecialService(codedInputStreamMicro.readString());
                                break;
                            case 210:
                                setFlagOnLeft(codedInputStreamMicro.readString());
                                break;
                            case HeightPicker.f25534xoXoI /* 218 */:
                                Impression impression = new Impression();
                                codedInputStreamMicro.readMessage(impression);
                                addImpression(impression);
                                break;
                            case 226:
                                Meishipaihao meishipaihao = new Meishipaihao();
                                codedInputStreamMicro.readMessage(meishipaihao);
                                setMeishipaihao(meishipaihao);
                                break;
                            case 234:
                                setTradeTag(codedInputStreamMicro.readString());
                                break;
                            case Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE /* 242 */:
                                Marketbiz marketbiz = new Marketbiz();
                                codedInputStreamMicro.readMessage(marketbiz);
                                setMarketbiz(marketbiz);
                                break;
                            case 250:
                                setValidate(codedInputStreamMicro.readString());
                                break;
                            case 258:
                                setWiseHourlyBookable(codedInputStreamMicro.readString());
                                break;
                            case 266:
                                setDisText(codedInputStreamMicro.readString());
                                break;
                            case 274:
                                LbcBusinessVip lbcBusinessVip = new LbcBusinessVip();
                                codedInputStreamMicro.readMessage(lbcBusinessVip);
                                setLbcBusinessVip(lbcBusinessVip);
                                break;
                            case 290:
                                RecommendDish recommendDish = new RecommendDish();
                                codedInputStreamMicro.readMessage(recommendDish);
                                setRecommendDish(recommendDish);
                                break;
                            case 298:
                                BusinessService businessService = new BusinessService();
                                codedInputStreamMicro.readMessage(businessService);
                                setBusinessService(businessService);
                                break;
                            case 306:
                                setStatusLabel(codedInputStreamMicro.readString());
                                break;
                            case 314:
                                Upperleftcorner upperleftcorner = new Upperleftcorner();
                                codedInputStreamMicro.readMessage(upperleftcorner);
                                setUpperleftcorner(upperleftcorner);
                                break;
                            case X0xOO.f13558IXX /* 322 */:
                                setDisplayInfoRedu(codedInputStreamMicro.readString());
                                break;
                            case 330:
                                DisplayInfoCommentLabel displayInfoCommentLabel = new DisplayInfoCommentLabel();
                                codedInputStreamMicro.readMessage(displayInfoCommentLabel);
                                setDisplayInfoCommentLabel(displayInfoCommentLabel);
                                break;
                            case 338:
                                Mbc mbc = new Mbc();
                                codedInputStreamMicro.readMessage(mbc);
                                setMbc(mbc);
                                break;
                            case IXXIXx00I.f11690IoXIXo /* 346 */:
                                setAoi(codedInputStreamMicro.readString());
                                break;
                            case 354:
                                setSpecialTag(codedInputStreamMicro.readString());
                                break;
                            case 362:
                                setOriginPriceText(codedInputStreamMicro.readString());
                                break;
                            case IXXIXx00I.f11791xxOXOOoIX /* 370 */:
                                HotelService hotelService = new HotelService();
                                codedInputStreamMicro.readMessage(hotelService);
                                addHotelService(hotelService);
                                break;
                            case 378:
                                Allcardextension allcardextension = new Allcardextension();
                                codedInputStreamMicro.readMessage(allcardextension);
                                setAllcardextension(allcardextension);
                                break;
                            case 386:
                                setShopHours(codedInputStreamMicro.readString());
                                break;
                            case 394:
                                setVsContent(codedInputStreamMicro.readString());
                                break;
                            case 402:
                                PhoneDetail phoneDetail = new PhoneDetail();
                                codedInputStreamMicro.readMessage(phoneDetail);
                                setPhoneDetail(phoneDetail);
                                break;
                            case 410:
                                PhoneRisk phoneRisk = new PhoneRisk();
                                codedInputStreamMicro.readMessage(phoneRisk);
                                setPhoneRisk(phoneRisk);
                                break;
                            case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                setNewBusinessTime(codedInputStreamMicro.readString());
                                break;
                            case 426:
                                setMiniprogram(codedInputStreamMicro.readString());
                                break;
                            case 434:
                                MnpKeyInfo mnpKeyInfo = new MnpKeyInfo();
                                codedInputStreamMicro.readMessage(mnpKeyInfo);
                                setMnpKeyInfo(mnpKeyInfo);
                                break;
                            case ah.t /* 442 */:
                                BlinkBuilding blinkBuilding = new BlinkBuilding();
                                codedInputStreamMicro.readMessage(blinkBuilding);
                                setBlinkBuilding(blinkBuilding);
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                    return this;
                                }
                                break;
                        }
                    }
                }

                public DetailInfo setActivity(int i, Activity activity) {
                    if (activity == null) {
                        return this;
                    }
                    this.activity_.set(i, activity);
                    return this;
                }

                public DetailInfo setAllcardextension(Allcardextension allcardextension) {
                    if (allcardextension == null) {
                        return clearAllcardextension();
                    }
                    this.hasAllcardextension = true;
                    this.allcardextension_ = allcardextension;
                    return this;
                }

                public DetailInfo setAoi(String str) {
                    this.hasAoi = true;
                    this.aoi_ = str;
                    return this;
                }

                public DetailInfo setBlinkBuilding(BlinkBuilding blinkBuilding) {
                    if (blinkBuilding == null) {
                        return clearBlinkBuilding();
                    }
                    this.hasBlinkBuilding = true;
                    this.blinkBuilding_ = blinkBuilding;
                    return this;
                }

                public DetailInfo setBookInfo(BookInfo bookInfo) {
                    if (bookInfo == null) {
                        return clearBookInfo();
                    }
                    this.hasBookInfo = true;
                    this.bookInfo_ = bookInfo;
                    return this;
                }

                public DetailInfo setBusinessService(BusinessService businessService) {
                    if (businessService == null) {
                        return clearBusinessService();
                    }
                    this.hasBusinessService = true;
                    this.businessService_ = businessService;
                    return this;
                }

                public DetailInfo setCommentNum(String str) {
                    this.hasCommentNum = true;
                    this.commentNum_ = str;
                    return this;
                }

                public DetailInfo setDisText(String str) {
                    this.hasDisText = true;
                    this.disText_ = str;
                    return this;
                }

                public DetailInfo setDiscount(String str) {
                    this.hasDiscount = true;
                    this.discount_ = str;
                    return this;
                }

                public DetailInfo setDiscountTotal(int i) {
                    this.hasDiscountTotal = true;
                    this.discountTotal_ = i;
                    return this;
                }

                public DetailInfo setDisplayInfoCommentLabel(DisplayInfoCommentLabel displayInfoCommentLabel) {
                    if (displayInfoCommentLabel == null) {
                        return clearDisplayInfoCommentLabel();
                    }
                    this.hasDisplayInfoCommentLabel = true;
                    this.displayInfoCommentLabel_ = displayInfoCommentLabel;
                    return this;
                }

                public DetailInfo setDisplayInfoRedu(String str) {
                    this.hasDisplayInfoRedu = true;
                    this.displayInfoRedu_ = str;
                    return this;
                }

                public DetailInfo setFlag(int i, String str) {
                    str.getClass();
                    this.flag_.set(i, str);
                    return this;
                }

                public DetailInfo setFlagOnLeft(String str) {
                    this.hasFlagOnLeft = true;
                    this.flagOnLeft_ = str;
                    return this;
                }

                public DetailInfo setGrade(String str) {
                    this.hasGrade = true;
                    this.grade_ = str;
                    return this;
                }

                public DetailInfo setGrouponFlag(int i) {
                    this.hasGrouponFlag = true;
                    this.grouponFlag_ = i;
                    return this;
                }

                public DetailInfo setGrouponInfo(GrouponInfo grouponInfo) {
                    if (grouponInfo == null) {
                        return clearGrouponInfo();
                    }
                    this.hasGrouponInfo = true;
                    this.grouponInfo_ = grouponInfo;
                    return this;
                }

                public DetailInfo setGrouponTotal(int i) {
                    this.hasGrouponTotal = true;
                    this.grouponTotal_ = i;
                    return this;
                }

                public DetailInfo setGuide(String str) {
                    this.hasGuide = true;
                    this.guide_ = str;
                    return this;
                }

                public DetailInfo setHotelService(int i, HotelService hotelService) {
                    if (hotelService == null) {
                        return this;
                    }
                    this.hotelService_.set(i, hotelService);
                    return this;
                }

                public DetailInfo setImage(String str) {
                    this.hasImage = true;
                    this.image_ = str;
                    return this;
                }

                public DetailInfo setImpression(int i, Impression impression) {
                    if (impression == null) {
                        return this;
                    }
                    this.impression_.set(i, impression);
                    return this;
                }

                public DetailInfo setLbcBusinessVip(LbcBusinessVip lbcBusinessVip) {
                    if (lbcBusinessVip == null) {
                        return clearLbcBusinessVip();
                    }
                    this.hasLbcBusinessVip = true;
                    this.lbcBusinessVip_ = lbcBusinessVip;
                    return this;
                }

                public DetailInfo setMarketbiz(Marketbiz marketbiz) {
                    if (marketbiz == null) {
                        return clearMarketbiz();
                    }
                    this.hasMarketbiz = true;
                    this.marketbiz_ = marketbiz;
                    return this;
                }

                public DetailInfo setMbc(Mbc mbc) {
                    if (mbc == null) {
                        return clearMbc();
                    }
                    this.hasMbc = true;
                    this.mbc_ = mbc;
                    return this;
                }

                public DetailInfo setMeishipaihao(Meishipaihao meishipaihao) {
                    if (meishipaihao == null) {
                        return clearMeishipaihao();
                    }
                    this.hasMeishipaihao = true;
                    this.meishipaihao_ = meishipaihao;
                    return this;
                }

                public DetailInfo setMiniprogram(String str) {
                    this.hasMiniprogram = true;
                    this.miniprogram_ = str;
                    return this;
                }

                public DetailInfo setMnpKeyInfo(MnpKeyInfo mnpKeyInfo) {
                    if (mnpKeyInfo == null) {
                        return clearMnpKeyInfo();
                    }
                    this.hasMnpKeyInfo = true;
                    this.mnpKeyInfo_ = mnpKeyInfo;
                    return this;
                }

                public DetailInfo setMovieFilmCount(int i) {
                    this.hasMovieFilmCount = true;
                    this.movieFilmCount_ = i;
                    return this;
                }

                public DetailInfo setMovieFlag(String str) {
                    this.hasMovieFlag = true;
                    this.movieFlag_ = str;
                    return this;
                }

                public DetailInfo setNewBusinessTime(String str) {
                    this.hasNewBusinessTime = true;
                    this.newBusinessTime_ = str;
                    return this;
                }

                public DetailInfo setOriginPriceText(String str) {
                    this.hasOriginPriceText = true;
                    this.originPriceText_ = str;
                    return this;
                }

                public DetailInfo setOrilInfo(OrilInfo orilInfo) {
                    if (orilInfo == null) {
                        return clearOrilInfo();
                    }
                    this.hasOrilInfo = true;
                    this.orilInfo_ = orilInfo;
                    return this;
                }

                public DetailInfo setOverallRating(String str) {
                    this.hasOverallRating = true;
                    this.overallRating_ = str;
                    return this;
                }

                public DetailInfo setPhoneDetail(PhoneDetail phoneDetail) {
                    if (phoneDetail == null) {
                        return clearPhoneDetail();
                    }
                    this.hasPhoneDetail = true;
                    this.phoneDetail_ = phoneDetail;
                    return this;
                }

                public DetailInfo setPhoneRisk(PhoneRisk phoneRisk) {
                    if (phoneRisk == null) {
                        return clearPhoneRisk();
                    }
                    this.hasPhoneRisk = true;
                    this.phoneRisk_ = phoneRisk;
                    return this;
                }

                public DetailInfo setPremiumFlag(int i) {
                    this.hasPremiumFlag = true;
                    this.premiumFlag_ = i;
                    return this;
                }

                public DetailInfo setPremiumInfo(PremiumInfo premiumInfo) {
                    if (premiumInfo == null) {
                        return clearPremiumInfo();
                    }
                    this.hasPremiumInfo = true;
                    this.premiumInfo_ = premiumInfo;
                    return this;
                }

                public DetailInfo setPrice(String str) {
                    this.hasPrice = true;
                    this.price_ = str;
                    return this;
                }

                public DetailInfo setPriceText(String str) {
                    this.hasPriceText = true;
                    this.priceText_ = str;
                    return this;
                }

                public DetailInfo setRecommendDish(RecommendDish recommendDish) {
                    if (recommendDish == null) {
                        return clearRecommendDish();
                    }
                    this.hasRecommendDish = true;
                    this.recommendDish_ = recommendDish;
                    return this;
                }

                public DetailInfo setShopHours(String str) {
                    this.hasShopHours = true;
                    this.shopHours_ = str;
                    return this;
                }

                public DetailInfo setShowInfo(String str) {
                    this.hasShowInfo = true;
                    this.showInfo_ = str;
                    return this;
                }

                public DetailInfo setSpecialService(String str) {
                    this.hasSpecialService = true;
                    this.specialService_ = str;
                    return this;
                }

                public DetailInfo setSpecialTag(String str) {
                    this.hasSpecialTag = true;
                    this.specialTag_ = str;
                    return this;
                }

                public DetailInfo setStatusLabel(String str) {
                    this.hasStatusLabel = true;
                    this.statusLabel_ = str;
                    return this;
                }

                public DetailInfo setTag(String str) {
                    this.hasTag = true;
                    this.tag_ = str;
                    return this;
                }

                public DetailInfo setTradeTag(String str) {
                    this.hasTradeTag = true;
                    this.tradeTag_ = str;
                    return this;
                }

                public DetailInfo setUpperleftcorner(Upperleftcorner upperleftcorner) {
                    if (upperleftcorner == null) {
                        return clearUpperleftcorner();
                    }
                    this.hasUpperleftcorner = true;
                    this.upperleftcorner_ = upperleftcorner;
                    return this;
                }

                public DetailInfo setValidate(String str) {
                    this.hasValidate = true;
                    this.validate_ = str;
                    return this;
                }

                public DetailInfo setVsContent(String str) {
                    this.hasVsContent = true;
                    this.vsContent_ = str;
                    return this;
                }

                public DetailInfo setWapBookable(String str) {
                    this.hasWapBookable = true;
                    this.wapBookable_ = str;
                    return this;
                }

                public DetailInfo setWiseFullroom(String str) {
                    this.hasWiseFullroom = true;
                    this.wiseFullroom_ = str;
                    return this;
                }

                public DetailInfo setWiseHourlyBookable(String str) {
                    this.hasWiseHourlyBookable = true;
                    this.wiseHourlyBookable_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    Iterator<String> it = getFlagList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeString(1, it.next());
                    }
                    if (hasOverallRating()) {
                        codedOutputStreamMicro.writeString(2, getOverallRating());
                    }
                    if (hasPriceText()) {
                        codedOutputStreamMicro.writeString(3, getPriceText());
                    }
                    if (hasTag()) {
                        codedOutputStreamMicro.writeString(4, getTag());
                    }
                    if (hasImage()) {
                        codedOutputStreamMicro.writeString(5, getImage());
                    }
                    if (hasShowInfo()) {
                        codedOutputStreamMicro.writeString(6, getShowInfo());
                    }
                    if (hasPremiumFlag()) {
                        codedOutputStreamMicro.writeInt32(7, getPremiumFlag());
                    }
                    if (hasDiscountTotal()) {
                        codedOutputStreamMicro.writeInt32(8, getDiscountTotal());
                    }
                    if (hasGrouponTotal()) {
                        codedOutputStreamMicro.writeInt32(9, getGrouponTotal());
                    }
                    if (hasPremiumInfo()) {
                        codedOutputStreamMicro.writeMessage(10, getPremiumInfo());
                    }
                    if (hasCommentNum()) {
                        codedOutputStreamMicro.writeString(11, getCommentNum());
                    }
                    if (hasMovieFlag()) {
                        codedOutputStreamMicro.writeString(12, getMovieFlag());
                    }
                    if (hasMovieFilmCount()) {
                        codedOutputStreamMicro.writeInt32(13, getMovieFilmCount());
                    }
                    if (hasGrouponFlag()) {
                        codedOutputStreamMicro.writeInt32(14, getGrouponFlag());
                    }
                    if (hasGrouponInfo()) {
                        codedOutputStreamMicro.writeMessage(15, getGrouponInfo());
                    }
                    if (hasOrilInfo()) {
                        codedOutputStreamMicro.writeMessage(16, getOrilInfo());
                    }
                    if (hasWapBookable()) {
                        codedOutputStreamMicro.writeString(17, getWapBookable());
                    }
                    if (hasBookInfo()) {
                        codedOutputStreamMicro.writeMessage(18, getBookInfo());
                    }
                    if (hasPrice()) {
                        codedOutputStreamMicro.writeString(19, getPrice());
                    }
                    if (hasWiseFullroom()) {
                        codedOutputStreamMicro.writeString(20, getWiseFullroom());
                    }
                    if (hasDiscount()) {
                        codedOutputStreamMicro.writeString(21, getDiscount());
                    }
                    if (hasGrade()) {
                        codedOutputStreamMicro.writeString(22, getGrade());
                    }
                    Iterator<Activity> it2 = getActivityList().iterator();
                    while (it2.hasNext()) {
                        codedOutputStreamMicro.writeMessage(23, it2.next());
                    }
                    if (hasGuide()) {
                        codedOutputStreamMicro.writeString(24, getGuide());
                    }
                    if (hasSpecialService()) {
                        codedOutputStreamMicro.writeString(25, getSpecialService());
                    }
                    if (hasFlagOnLeft()) {
                        codedOutputStreamMicro.writeString(26, getFlagOnLeft());
                    }
                    Iterator<Impression> it3 = getImpressionList().iterator();
                    while (it3.hasNext()) {
                        codedOutputStreamMicro.writeMessage(27, it3.next());
                    }
                    if (hasMeishipaihao()) {
                        codedOutputStreamMicro.writeMessage(28, getMeishipaihao());
                    }
                    if (hasTradeTag()) {
                        codedOutputStreamMicro.writeString(29, getTradeTag());
                    }
                    if (hasMarketbiz()) {
                        codedOutputStreamMicro.writeMessage(30, getMarketbiz());
                    }
                    if (hasValidate()) {
                        codedOutputStreamMicro.writeString(31, getValidate());
                    }
                    if (hasWiseHourlyBookable()) {
                        codedOutputStreamMicro.writeString(32, getWiseHourlyBookable());
                    }
                    if (hasDisText()) {
                        codedOutputStreamMicro.writeString(33, getDisText());
                    }
                    if (hasLbcBusinessVip()) {
                        codedOutputStreamMicro.writeMessage(34, getLbcBusinessVip());
                    }
                    if (hasRecommendDish()) {
                        codedOutputStreamMicro.writeMessage(36, getRecommendDish());
                    }
                    if (hasBusinessService()) {
                        codedOutputStreamMicro.writeMessage(37, getBusinessService());
                    }
                    if (hasStatusLabel()) {
                        codedOutputStreamMicro.writeString(38, getStatusLabel());
                    }
                    if (hasUpperleftcorner()) {
                        codedOutputStreamMicro.writeMessage(39, getUpperleftcorner());
                    }
                    if (hasDisplayInfoRedu()) {
                        codedOutputStreamMicro.writeString(40, getDisplayInfoRedu());
                    }
                    if (hasDisplayInfoCommentLabel()) {
                        codedOutputStreamMicro.writeMessage(41, getDisplayInfoCommentLabel());
                    }
                    if (hasMbc()) {
                        codedOutputStreamMicro.writeMessage(42, getMbc());
                    }
                    if (hasAoi()) {
                        codedOutputStreamMicro.writeString(43, getAoi());
                    }
                    if (hasSpecialTag()) {
                        codedOutputStreamMicro.writeString(44, getSpecialTag());
                    }
                    if (hasOriginPriceText()) {
                        codedOutputStreamMicro.writeString(45, getOriginPriceText());
                    }
                    Iterator<HotelService> it4 = getHotelServiceList().iterator();
                    while (it4.hasNext()) {
                        codedOutputStreamMicro.writeMessage(46, it4.next());
                    }
                    if (hasAllcardextension()) {
                        codedOutputStreamMicro.writeMessage(47, getAllcardextension());
                    }
                    if (hasShopHours()) {
                        codedOutputStreamMicro.writeString(48, getShopHours());
                    }
                    if (hasVsContent()) {
                        codedOutputStreamMicro.writeString(49, getVsContent());
                    }
                    if (hasPhoneDetail()) {
                        codedOutputStreamMicro.writeMessage(50, getPhoneDetail());
                    }
                    if (hasPhoneRisk()) {
                        codedOutputStreamMicro.writeMessage(51, getPhoneRisk());
                    }
                    if (hasNewBusinessTime()) {
                        codedOutputStreamMicro.writeString(52, getNewBusinessTime());
                    }
                    if (hasMiniprogram()) {
                        codedOutputStreamMicro.writeString(53, getMiniprogram());
                    }
                    if (hasMnpKeyInfo()) {
                        codedOutputStreamMicro.writeMessage(54, getMnpKeyInfo());
                    }
                    if (hasBlinkBuilding()) {
                        codedOutputStreamMicro.writeMessage(55, getBlinkBuilding());
                    }
                }

                public static DetailInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (DetailInfo) new DetailInfo().mergeFrom(bArr);
                }
            }

            public static Ext parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Ext().mergeFrom(codedInputStreamMicro);
            }

            public final Ext clear() {
                clearDetailInfo();
                clearSrcName();
                clearAdvInfo();
                this.cachedSize = -1;
                return this;
            }

            public Ext clearAdvInfo() {
                this.hasAdvInfo = false;
                this.advInfo_ = null;
                return this;
            }

            public Ext clearDetailInfo() {
                this.hasDetailInfo = false;
                this.detailInfo_ = null;
                return this;
            }

            public Ext clearSrcName() {
                this.hasSrcName = false;
                this.srcName_ = "";
                return this;
            }

            public AdvInfo getAdvInfo() {
                return this.advInfo_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public DetailInfo getDetailInfo() {
                return this.detailInfo_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasSrcName() ? CodedOutputStreamMicro.computeStringSize(1, getSrcName()) : 0;
                if (hasDetailInfo()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, getDetailInfo());
                }
                if (hasAdvInfo()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, getAdvInfo());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getSrcName() {
                return this.srcName_;
            }

            public boolean hasAdvInfo() {
                return this.hasAdvInfo;
            }

            public boolean hasDetailInfo() {
                return this.hasDetailInfo;
            }

            public boolean hasSrcName() {
                return this.hasSrcName;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Ext mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setSrcName(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        DetailInfo detailInfo = new DetailInfo();
                        codedInputStreamMicro.readMessage(detailInfo);
                        setDetailInfo(detailInfo);
                    } else if (readTag == 26) {
                        AdvInfo advInfo = new AdvInfo();
                        codedInputStreamMicro.readMessage(advInfo);
                        setAdvInfo(advInfo);
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public Ext setAdvInfo(AdvInfo advInfo) {
                if (advInfo == null) {
                    return clearAdvInfo();
                }
                this.hasAdvInfo = true;
                this.advInfo_ = advInfo;
                return this;
            }

            public Ext setDetailInfo(DetailInfo detailInfo) {
                if (detailInfo == null) {
                    return clearDetailInfo();
                }
                this.hasDetailInfo = true;
                this.detailInfo_ = detailInfo;
                return this;
            }

            public Ext setSrcName(String str) {
                this.hasSrcName = true;
                this.srcName_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasSrcName()) {
                    codedOutputStreamMicro.writeString(1, getSrcName());
                }
                if (hasDetailInfo()) {
                    codedOutputStreamMicro.writeMessage(2, getDetailInfo());
                }
                if (hasAdvInfo()) {
                    codedOutputStreamMicro.writeMessage(3, getAdvInfo());
                }
            }

            public static Ext parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Ext) new Ext().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class HeadIcon extends MessageMicro {
            public static final int COLOR_FIELD_NUMBER = 5;
            public static final int CONTEXT_FIELD_NUMBER = 6;
            public static final int DARK_URL_FIELD_NUMBER = 10;
            public static final int LINKS_FIELD_NUMBER = 3;
            public static final int NO_THIRD_WARNING_FIELD_NUMBER = 9;
            public static final int PARAM_API_FIELD_NUMBER = 8;
            public static final int PID_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int URL_FIELD_NUMBER = 1;
            public static final int USECONTEXT_FIELD_NUMBER = 7;
            private boolean hasColor;
            private boolean hasContext;
            private boolean hasDarkUrl;
            private boolean hasLinks;
            private boolean hasNoThirdWarning;
            private boolean hasParamApi;
            private boolean hasPid;
            private boolean hasType;
            private boolean hasUrl;
            private boolean hasUsecontext;
            private String url_ = "";
            private int type_ = 0;
            private String links_ = "";
            private String pid_ = "";
            private int color_ = 0;
            private String context_ = "";
            private int usecontext_ = 0;
            private String paramApi_ = "";
            private int noThirdWarning_ = 0;
            private String darkUrl_ = "";
            private int cachedSize = -1;

            public static HeadIcon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new HeadIcon().mergeFrom(codedInputStreamMicro);
            }

            public final HeadIcon clear() {
                clearUrl();
                clearType();
                clearLinks();
                clearPid();
                clearColor();
                clearContext();
                clearUsecontext();
                clearParamApi();
                clearNoThirdWarning();
                clearDarkUrl();
                this.cachedSize = -1;
                return this;
            }

            public HeadIcon clearColor() {
                this.hasColor = false;
                this.color_ = 0;
                return this;
            }

            public HeadIcon clearContext() {
                this.hasContext = false;
                this.context_ = "";
                return this;
            }

            public HeadIcon clearDarkUrl() {
                this.hasDarkUrl = false;
                this.darkUrl_ = "";
                return this;
            }

            public HeadIcon clearLinks() {
                this.hasLinks = false;
                this.links_ = "";
                return this;
            }

            public HeadIcon clearNoThirdWarning() {
                this.hasNoThirdWarning = false;
                this.noThirdWarning_ = 0;
                return this;
            }

            public HeadIcon clearParamApi() {
                this.hasParamApi = false;
                this.paramApi_ = "";
                return this;
            }

            public HeadIcon clearPid() {
                this.hasPid = false;
                this.pid_ = "";
                return this;
            }

            public HeadIcon clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            public HeadIcon clearUrl() {
                this.hasUrl = false;
                this.url_ = "";
                return this;
            }

            public HeadIcon clearUsecontext() {
                this.hasUsecontext = false;
                this.usecontext_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getColor() {
                return this.color_;
            }

            public String getContext() {
                return this.context_;
            }

            public String getDarkUrl() {
                return this.darkUrl_;
            }

            public String getLinks() {
                return this.links_;
            }

            public int getNoThirdWarning() {
                return this.noThirdWarning_;
            }

            public String getParamApi() {
                return this.paramApi_;
            }

            public String getPid() {
                return this.pid_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasUrl() ? CodedOutputStreamMicro.computeStringSize(1, getUrl()) : 0;
                if (hasType()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                }
                if (hasLinks()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getLinks());
                }
                if (hasPid()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getPid());
                }
                if (hasColor()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getColor());
                }
                if (hasContext()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getContext());
                }
                if (hasUsecontext()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getUsecontext());
                }
                if (hasParamApi()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getParamApi());
                }
                if (hasNoThirdWarning()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(9, getNoThirdWarning());
                }
                if (hasDarkUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(10, getDarkUrl());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public int getType() {
                return this.type_;
            }

            public String getUrl() {
                return this.url_;
            }

            public int getUsecontext() {
                return this.usecontext_;
            }

            public boolean hasColor() {
                return this.hasColor;
            }

            public boolean hasContext() {
                return this.hasContext;
            }

            public boolean hasDarkUrl() {
                return this.hasDarkUrl;
            }

            public boolean hasLinks() {
                return this.hasLinks;
            }

            public boolean hasNoThirdWarning() {
                return this.hasNoThirdWarning;
            }

            public boolean hasParamApi() {
                return this.hasParamApi;
            }

            public boolean hasPid() {
                return this.hasPid;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public boolean hasUrl() {
                return this.hasUrl;
            }

            public boolean hasUsecontext() {
                return this.hasUsecontext;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public HeadIcon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 10:
                            setUrl(codedInputStreamMicro.readString());
                            break;
                        case 16:
                            setType(codedInputStreamMicro.readInt32());
                            break;
                        case 26:
                            setLinks(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            setPid(codedInputStreamMicro.readString());
                            break;
                        case 40:
                            setColor(codedInputStreamMicro.readInt32());
                            break;
                        case 50:
                            setContext(codedInputStreamMicro.readString());
                            break;
                        case 56:
                            setUsecontext(codedInputStreamMicro.readInt32());
                            break;
                        case 66:
                            setParamApi(codedInputStreamMicro.readString());
                            break;
                        case 72:
                            setNoThirdWarning(codedInputStreamMicro.readInt32());
                            break;
                        case 82:
                            setDarkUrl(codedInputStreamMicro.readString());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public HeadIcon setColor(int i) {
                this.hasColor = true;
                this.color_ = i;
                return this;
            }

            public HeadIcon setContext(String str) {
                this.hasContext = true;
                this.context_ = str;
                return this;
            }

            public HeadIcon setDarkUrl(String str) {
                this.hasDarkUrl = true;
                this.darkUrl_ = str;
                return this;
            }

            public HeadIcon setLinks(String str) {
                this.hasLinks = true;
                this.links_ = str;
                return this;
            }

            public HeadIcon setNoThirdWarning(int i) {
                this.hasNoThirdWarning = true;
                this.noThirdWarning_ = i;
                return this;
            }

            public HeadIcon setParamApi(String str) {
                this.hasParamApi = true;
                this.paramApi_ = str;
                return this;
            }

            public HeadIcon setPid(String str) {
                this.hasPid = true;
                this.pid_ = str;
                return this;
            }

            public HeadIcon setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            public HeadIcon setUrl(String str) {
                this.hasUrl = true;
                this.url_ = str;
                return this;
            }

            public HeadIcon setUsecontext(int i) {
                this.hasUsecontext = true;
                this.usecontext_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUrl()) {
                    codedOutputStreamMicro.writeString(1, getUrl());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(2, getType());
                }
                if (hasLinks()) {
                    codedOutputStreamMicro.writeString(3, getLinks());
                }
                if (hasPid()) {
                    codedOutputStreamMicro.writeString(4, getPid());
                }
                if (hasColor()) {
                    codedOutputStreamMicro.writeInt32(5, getColor());
                }
                if (hasContext()) {
                    codedOutputStreamMicro.writeString(6, getContext());
                }
                if (hasUsecontext()) {
                    codedOutputStreamMicro.writeInt32(7, getUsecontext());
                }
                if (hasParamApi()) {
                    codedOutputStreamMicro.writeString(8, getParamApi());
                }
                if (hasNoThirdWarning()) {
                    codedOutputStreamMicro.writeInt32(9, getNoThirdWarning());
                }
                if (hasDarkUrl()) {
                    codedOutputStreamMicro.writeString(10, getDarkUrl());
                }
            }

            public static HeadIcon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (HeadIcon) new HeadIcon().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class HeadIconBubbleInfo extends MessageMicro {
            public static final int BURIED_POINT_FIELD_NUMBER = 4;
            public static final int ICON_URL_FIELD_NUMBER = 2;
            public static final int JUMP_URL_FIELD_NUMBER = 3;
            public static final int TEXT_FIELD_NUMBER = 1;
            private boolean hasBuriedPoint;
            private boolean hasIconUrl;
            private boolean hasJumpUrl;
            private boolean hasText;
            private String text_ = "";
            private String iconUrl_ = "";
            private String jumpUrl_ = "";
            private String buriedPoint_ = "";
            private int cachedSize = -1;

            public static HeadIconBubbleInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new HeadIconBubbleInfo().mergeFrom(codedInputStreamMicro);
            }

            public final HeadIconBubbleInfo clear() {
                clearText();
                clearIconUrl();
                clearJumpUrl();
                clearBuriedPoint();
                this.cachedSize = -1;
                return this;
            }

            public HeadIconBubbleInfo clearBuriedPoint() {
                this.hasBuriedPoint = false;
                this.buriedPoint_ = "";
                return this;
            }

            public HeadIconBubbleInfo clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public HeadIconBubbleInfo clearJumpUrl() {
                this.hasJumpUrl = false;
                this.jumpUrl_ = "";
                return this;
            }

            public HeadIconBubbleInfo clearText() {
                this.hasText = false;
                this.text_ = "";
                return this;
            }

            public String getBuriedPoint() {
                return this.buriedPoint_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getIconUrl() {
                return this.iconUrl_;
            }

            public String getJumpUrl() {
                return this.jumpUrl_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasText() ? CodedOutputStreamMicro.computeStringSize(1, getText()) : 0;
                if (hasIconUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getIconUrl());
                }
                if (hasJumpUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getJumpUrl());
                }
                if (hasBuriedPoint()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getBuriedPoint());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getText() {
                return this.text_;
            }

            public boolean hasBuriedPoint() {
                return this.hasBuriedPoint;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasJumpUrl() {
                return this.hasJumpUrl;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public HeadIconBubbleInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setText(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setIconUrl(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setJumpUrl(codedInputStreamMicro.readString());
                    } else if (readTag == 34) {
                        setBuriedPoint(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public HeadIconBubbleInfo setBuriedPoint(String str) {
                this.hasBuriedPoint = true;
                this.buriedPoint_ = str;
                return this;
            }

            public HeadIconBubbleInfo setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public HeadIconBubbleInfo setJumpUrl(String str) {
                this.hasJumpUrl = true;
                this.jumpUrl_ = str;
                return this;
            }

            public HeadIconBubbleInfo setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasText()) {
                    codedOutputStreamMicro.writeString(1, getText());
                }
                if (hasIconUrl()) {
                    codedOutputStreamMicro.writeString(2, getIconUrl());
                }
                if (hasJumpUrl()) {
                    codedOutputStreamMicro.writeString(3, getJumpUrl());
                }
                if (hasBuriedPoint()) {
                    codedOutputStreamMicro.writeString(4, getBuriedPoint());
                }
            }

            public static HeadIconBubbleInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (HeadIconBubbleInfo) new HeadIconBubbleInfo().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class HeatMap extends MessageMicro {
            public static final int POINTS_FIELD_NUMBER = 2;
            public static final int RANKSTR_FIELD_NUMBER = 1;
            public static final int RANK_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 3;
            private boolean hasPoints;
            private boolean hasRank;
            private boolean hasRankstr;
            private boolean hasType;
            private Points points_ = null;
            private String rankstr_ = "";
            private int type_ = 0;
            private int rank_ = 0;
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class Points extends MessageMicro {
                public static final int BOUND_FIELD_NUMBER = 1;
                public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
                public static final int TYPE_FIELD_NUMBER = 2;
                private boolean hasType;
                private List<Integer> bound_ = Collections.emptyList();
                private int type_ = 0;
                private List<GeoElements> geoElements_ = Collections.emptyList();
                private int cachedSize = -1;

                /* loaded from: classes7.dex */
                public static final class GeoElements extends MessageMicro {
                    public static final int POINT_FIELD_NUMBER = 1;
                    private List<Integer> point_ = Collections.emptyList();
                    private int cachedSize = -1;

                    public static GeoElements parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new GeoElements().mergeFrom(codedInputStreamMicro);
                    }

                    public GeoElements addPoint(int i) {
                        if (this.point_.isEmpty()) {
                            this.point_ = new ArrayList();
                        }
                        this.point_.add(Integer.valueOf(i));
                        return this;
                    }

                    public final GeoElements clear() {
                        clearPoint();
                        this.cachedSize = -1;
                        return this;
                    }

                    public GeoElements clearPoint() {
                        this.point_ = Collections.emptyList();
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getPoint(int i) {
                        return this.point_.get(i).intValue();
                    }

                    public int getPointCount() {
                        return this.point_.size();
                    }

                    public List<Integer> getPointList() {
                        return this.point_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        Iterator<Integer> it = getPointList().iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                        }
                        int size = i + getPointList().size();
                        this.cachedSize = size;
                        return size;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public GeoElements mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            if (readTag == 0) {
                                return this;
                            }
                            if (readTag == 8) {
                                addPoint(codedInputStreamMicro.readSInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                        }
                    }

                    public GeoElements setPoint(int i, int i2) {
                        this.point_.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        Iterator<Integer> it = getPointList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeSInt32(1, it.next().intValue());
                        }
                    }

                    public static GeoElements parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (GeoElements) new GeoElements().mergeFrom(bArr);
                    }
                }

                public static Points parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Points().mergeFrom(codedInputStreamMicro);
                }

                public Points addBound(int i) {
                    if (this.bound_.isEmpty()) {
                        this.bound_ = new ArrayList();
                    }
                    this.bound_.add(Integer.valueOf(i));
                    return this;
                }

                public Points addGeoElements(GeoElements geoElements) {
                    if (geoElements == null) {
                        return this;
                    }
                    if (this.geoElements_.isEmpty()) {
                        this.geoElements_ = new ArrayList();
                    }
                    this.geoElements_.add(geoElements);
                    return this;
                }

                public final Points clear() {
                    clearBound();
                    clearType();
                    clearGeoElements();
                    this.cachedSize = -1;
                    return this;
                }

                public Points clearBound() {
                    this.bound_ = Collections.emptyList();
                    return this;
                }

                public Points clearGeoElements() {
                    this.geoElements_ = Collections.emptyList();
                    return this;
                }

                public Points clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public int getBound(int i) {
                    return this.bound_.get(i).intValue();
                }

                public int getBoundCount() {
                    return this.bound_.size();
                }

                public List<Integer> getBoundList() {
                    return this.bound_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public GeoElements getGeoElements(int i) {
                    return this.geoElements_.get(i);
                }

                public int getGeoElementsCount() {
                    return this.geoElements_.size();
                }

                public List<GeoElements> getGeoElementsList() {
                    return this.geoElements_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    Iterator<Integer> it = getBoundList().iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                    }
                    int size = i + getBoundList().size();
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(2, getType());
                    }
                    Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                    while (it2.hasNext()) {
                        size += CodedOutputStreamMicro.computeMessageSize(3, it2.next());
                    }
                    this.cachedSize = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Points mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            addBound(codedInputStreamMicro.readSInt32());
                        } else if (readTag == 16) {
                            setType(codedInputStreamMicro.readInt32());
                        } else if (readTag == 26) {
                            GeoElements geoElements = new GeoElements();
                            codedInputStreamMicro.readMessage(geoElements);
                            addGeoElements(geoElements);
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public Points setBound(int i, int i2) {
                    this.bound_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Points setGeoElements(int i, GeoElements geoElements) {
                    if (geoElements == null) {
                        return this;
                    }
                    this.geoElements_.set(i, geoElements);
                    return this;
                }

                public Points setType(int i) {
                    this.hasType = true;
                    this.type_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    Iterator<Integer> it = getBoundList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(1, it.next().intValue());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(2, getType());
                    }
                    Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                    while (it2.hasNext()) {
                        codedOutputStreamMicro.writeMessage(3, it2.next());
                    }
                }

                public static Points parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Points) new Points().mergeFrom(bArr);
                }
            }

            public static HeatMap parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new HeatMap().mergeFrom(codedInputStreamMicro);
            }

            public final HeatMap clear() {
                clearPoints();
                clearRankstr();
                clearType();
                clearRank();
                this.cachedSize = -1;
                return this;
            }

            public HeatMap clearPoints() {
                this.hasPoints = false;
                this.points_ = null;
                return this;
            }

            public HeatMap clearRank() {
                this.hasRank = false;
                this.rank_ = 0;
                return this;
            }

            public HeatMap clearRankstr() {
                this.hasRankstr = false;
                this.rankstr_ = "";
                return this;
            }

            public HeatMap clearType() {
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

            public Points getPoints() {
                return this.points_;
            }

            public int getRank() {
                return this.rank_;
            }

            public String getRankstr() {
                return this.rankstr_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasRankstr() ? CodedOutputStreamMicro.computeStringSize(1, getRankstr()) : 0;
                if (hasPoints()) {
                    computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, getPoints());
                }
                if (hasType()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getType());
                }
                if (hasRank()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getRank());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasPoints() {
                return this.hasPoints;
            }

            public boolean hasRank() {
                return this.hasRank;
            }

            public boolean hasRankstr() {
                return this.hasRankstr;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public HeatMap mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setRankstr(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        Points points = new Points();
                        codedInputStreamMicro.readMessage(points);
                        setPoints(points);
                    } else if (readTag == 24) {
                        setType(codedInputStreamMicro.readInt32());
                    } else if (readTag == 32) {
                        setRank(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public HeatMap setPoints(Points points) {
                if (points == null) {
                    return clearPoints();
                }
                this.hasPoints = true;
                this.points_ = points;
                return this;
            }

            public HeatMap setRank(int i) {
                this.hasRank = true;
                this.rank_ = i;
                return this;
            }

            public HeatMap setRankstr(String str) {
                this.hasRankstr = true;
                this.rankstr_ = str;
                return this;
            }

            public HeatMap setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasRankstr()) {
                    codedOutputStreamMicro.writeString(1, getRankstr());
                }
                if (hasPoints()) {
                    codedOutputStreamMicro.writeMessage(2, getPoints());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(3, getType());
                }
                if (hasRank()) {
                    codedOutputStreamMicro.writeInt32(4, getRank());
                }
            }

            public static HeatMap parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (HeatMap) new HeatMap().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class MapPoitag extends MessageMicro {
            public static final int TAG_FIELD_NUMBER = 1;
            private boolean hasTag;
            private String tag_ = "";
            private int cachedSize = -1;

            public static MapPoitag parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new MapPoitag().mergeFrom(codedInputStreamMicro);
            }

            public final MapPoitag clear() {
                clearTag();
                this.cachedSize = -1;
                return this;
            }

            public MapPoitag clearTag() {
                this.hasTag = false;
                this.tag_ = "";
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
                int computeStringSize = hasTag() ? CodedOutputStreamMicro.computeStringSize(1, getTag()) : 0;
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getTag() {
                return this.tag_;
            }

            public boolean hasTag() {
                return this.hasTag;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public MapPoitag mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setTag(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public MapPoitag setTag(String str) {
                this.hasTag = true;
                this.tag_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTag()) {
                    codedOutputStreamMicro.writeString(1, getTag());
                }
            }

            public static MapPoitag parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (MapPoitag) new MapPoitag().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class PoiSimilar extends MessageMicro {
            public static final int ICON_FIELD_NUMBER = 4;
            public static final int NAVI_FIELD_NUMBER = 3;
            public static final int OPENAPI_FIELD_NUMBER = 2;
            public static final int TEXT_FIELD_NUMBER = 1;
            private boolean hasIcon;
            private boolean hasNavi;
            private boolean hasOpenapi;
            private boolean hasText;
            private String text_ = "";
            private String openapi_ = "";
            private String navi_ = "";
            private String icon_ = "";
            private int cachedSize = -1;

            public static PoiSimilar parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new PoiSimilar().mergeFrom(codedInputStreamMicro);
            }

            public final PoiSimilar clear() {
                clearText();
                clearOpenapi();
                clearNavi();
                clearIcon();
                this.cachedSize = -1;
                return this;
            }

            public PoiSimilar clearIcon() {
                this.hasIcon = false;
                this.icon_ = "";
                return this;
            }

            public PoiSimilar clearNavi() {
                this.hasNavi = false;
                this.navi_ = "";
                return this;
            }

            public PoiSimilar clearOpenapi() {
                this.hasOpenapi = false;
                this.openapi_ = "";
                return this;
            }

            public PoiSimilar clearText() {
                this.hasText = false;
                this.text_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getIcon() {
                return this.icon_;
            }

            public String getNavi() {
                return this.navi_;
            }

            public String getOpenapi() {
                return this.openapi_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasText() ? CodedOutputStreamMicro.computeStringSize(1, getText()) : 0;
                if (hasOpenapi()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getOpenapi());
                }
                if (hasNavi()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getNavi());
                }
                if (hasIcon()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getIcon());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getText() {
                return this.text_;
            }

            public boolean hasIcon() {
                return this.hasIcon;
            }

            public boolean hasNavi() {
                return this.hasNavi;
            }

            public boolean hasOpenapi() {
                return this.hasOpenapi;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public PoiSimilar mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setText(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setOpenapi(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setNavi(codedInputStreamMicro.readString());
                    } else if (readTag == 34) {
                        setIcon(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public PoiSimilar setIcon(String str) {
                this.hasIcon = true;
                this.icon_ = str;
                return this;
            }

            public PoiSimilar setNavi(String str) {
                this.hasNavi = true;
                this.navi_ = str;
                return this;
            }

            public PoiSimilar setOpenapi(String str) {
                this.hasOpenapi = true;
                this.openapi_ = str;
                return this;
            }

            public PoiSimilar setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasText()) {
                    codedOutputStreamMicro.writeString(1, getText());
                }
                if (hasOpenapi()) {
                    codedOutputStreamMicro.writeString(2, getOpenapi());
                }
                if (hasNavi()) {
                    codedOutputStreamMicro.writeString(3, getNavi());
                }
                if (hasIcon()) {
                    codedOutputStreamMicro.writeString(4, getIcon());
                }
            }

            public static PoiSimilar parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (PoiSimilar) new PoiSimilar().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Sgeo extends MessageMicro {
            public static final int BOUND_FIELD_NUMBER = 1;
            public static final int GEO_ELEMENTS_FIELD_NUMBER = 3;
            public static final int TYPE_FIELD_NUMBER = 2;
            private boolean hasType;
            private List<Integer> bound_ = Collections.emptyList();
            private int type_ = 0;
            private List<GeoElements> geoElements_ = Collections.emptyList();
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class GeoElements extends MessageMicro {
                public static final int POINT_FIELD_NUMBER = 1;
                private List<Integer> point_ = Collections.emptyList();
                private int cachedSize = -1;

                public static GeoElements parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new GeoElements().mergeFrom(codedInputStreamMicro);
                }

                public GeoElements addPoint(int i) {
                    if (this.point_.isEmpty()) {
                        this.point_ = new ArrayList();
                    }
                    this.point_.add(Integer.valueOf(i));
                    return this;
                }

                public final GeoElements clear() {
                    clearPoint();
                    this.cachedSize = -1;
                    return this;
                }

                public GeoElements clearPoint() {
                    this.point_ = Collections.emptyList();
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getPoint(int i) {
                    return this.point_.get(i).intValue();
                }

                public int getPointCount() {
                    return this.point_.size();
                }

                public List<Integer> getPointList() {
                    return this.point_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    Iterator<Integer> it = getPointList().iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                    }
                    int size = i + getPointList().size();
                    this.cachedSize = size;
                    return size;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public GeoElements mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            addPoint(codedInputStreamMicro.readSInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public GeoElements setPoint(int i, int i2) {
                    this.point_.set(i, Integer.valueOf(i2));
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    Iterator<Integer> it = getPointList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(1, it.next().intValue());
                    }
                }

                public static GeoElements parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (GeoElements) new GeoElements().mergeFrom(bArr);
                }
            }

            public static Sgeo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Sgeo().mergeFrom(codedInputStreamMicro);
            }

            public Sgeo addBound(int i) {
                if (this.bound_.isEmpty()) {
                    this.bound_ = new ArrayList();
                }
                this.bound_.add(Integer.valueOf(i));
                return this;
            }

            public Sgeo addGeoElements(GeoElements geoElements) {
                if (geoElements == null) {
                    return this;
                }
                if (this.geoElements_.isEmpty()) {
                    this.geoElements_ = new ArrayList();
                }
                this.geoElements_.add(geoElements);
                return this;
            }

            public final Sgeo clear() {
                clearBound();
                clearType();
                clearGeoElements();
                this.cachedSize = -1;
                return this;
            }

            public Sgeo clearBound() {
                this.bound_ = Collections.emptyList();
                return this;
            }

            public Sgeo clearGeoElements() {
                this.geoElements_ = Collections.emptyList();
                return this;
            }

            public Sgeo clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            public int getBound(int i) {
                return this.bound_.get(i).intValue();
            }

            public int getBoundCount() {
                return this.bound_.size();
            }

            public List<Integer> getBoundList() {
                return this.bound_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public GeoElements getGeoElements(int i) {
                return this.geoElements_.get(i);
            }

            public int getGeoElementsCount() {
                return this.geoElements_.size();
            }

            public List<GeoElements> getGeoElementsList() {
                return this.geoElements_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                Iterator<Integer> it = getBoundList().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = i + getBoundList().size();
                if (hasType()) {
                    size += CodedOutputStreamMicro.computeInt32Size(2, getType());
                }
                Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                while (it2.hasNext()) {
                    size += CodedOutputStreamMicro.computeMessageSize(3, it2.next());
                }
                this.cachedSize = size;
                return size;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Sgeo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        addBound(codedInputStreamMicro.readSInt32());
                    } else if (readTag == 16) {
                        setType(codedInputStreamMicro.readInt32());
                    } else if (readTag == 26) {
                        GeoElements geoElements = new GeoElements();
                        codedInputStreamMicro.readMessage(geoElements);
                        addGeoElements(geoElements);
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public Sgeo setBound(int i, int i2) {
                this.bound_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Sgeo setGeoElements(int i, GeoElements geoElements) {
                if (geoElements == null) {
                    return this;
                }
                this.geoElements_.set(i, geoElements);
                return this;
            }

            public Sgeo setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<Integer> it = getBoundList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(1, it.next().intValue());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(2, getType());
                }
                Iterator<GeoElements> it2 = getGeoElementsList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeMessage(3, it2.next());
                }
            }

            public static Sgeo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Sgeo) new Sgeo().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class Show extends MessageMicro {
            public static final int ADDRESS_FIELD_NUMBER = 1;
            public static final int BOOK_INFO_FIELD_NUMBER = 11;
            public static final int DISTANCE_FIELD_NUMBER = 5;
            public static final int EC_REASON_FIELD_NUMBER = 9;
            public static final int EP_CHAR_FIELD_NUMBER = 8;
            public static final int ICON_FIELD_NUMBER = 4;
            public static final int IMAGE_FIELD_NUMBER = 2;
            public static final int MAP_BUTTON_FIELD_NUMBER = 12;
            public static final int NAME_FIELD_NUMBER = 3;
            public static final int OVERALL_RATING_FIELD_NUMBER = 6;
            public static final int PHONE_BUTTON_FIELD_NUMBER = 10;
            public static final int PRICE_FIELD_NUMBER = 7;
            private boolean hasAddress;
            private boolean hasBookInfo;
            private boolean hasDistance;
            private boolean hasEcReason;
            private boolean hasEpChar;
            private boolean hasIcon;
            private boolean hasImage;
            private boolean hasMapButton;
            private boolean hasName;
            private boolean hasOverallRating;
            private boolean hasPhoneButton;
            private boolean hasPrice;
            private int address_ = 0;
            private int image_ = 0;
            private int name_ = 0;
            private int icon_ = 0;
            private int distance_ = 0;
            private int overallRating_ = 0;
            private int price_ = 0;
            private int epChar_ = 0;
            private int ecReason_ = 0;
            private int phoneButton_ = 0;
            private int bookInfo_ = 0;
            private int mapButton_ = 0;
            private int cachedSize = -1;

            public static Show parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Show().mergeFrom(codedInputStreamMicro);
            }

            public final Show clear() {
                clearAddress();
                clearImage();
                clearName();
                clearIcon();
                clearDistance();
                clearOverallRating();
                clearPrice();
                clearEpChar();
                clearEcReason();
                clearPhoneButton();
                clearBookInfo();
                clearMapButton();
                this.cachedSize = -1;
                return this;
            }

            public Show clearAddress() {
                this.hasAddress = false;
                this.address_ = 0;
                return this;
            }

            public Show clearBookInfo() {
                this.hasBookInfo = false;
                this.bookInfo_ = 0;
                return this;
            }

            public Show clearDistance() {
                this.hasDistance = false;
                this.distance_ = 0;
                return this;
            }

            public Show clearEcReason() {
                this.hasEcReason = false;
                this.ecReason_ = 0;
                return this;
            }

            public Show clearEpChar() {
                this.hasEpChar = false;
                this.epChar_ = 0;
                return this;
            }

            public Show clearIcon() {
                this.hasIcon = false;
                this.icon_ = 0;
                return this;
            }

            public Show clearImage() {
                this.hasImage = false;
                this.image_ = 0;
                return this;
            }

            public Show clearMapButton() {
                this.hasMapButton = false;
                this.mapButton_ = 0;
                return this;
            }

            public Show clearName() {
                this.hasName = false;
                this.name_ = 0;
                return this;
            }

            public Show clearOverallRating() {
                this.hasOverallRating = false;
                this.overallRating_ = 0;
                return this;
            }

            public Show clearPhoneButton() {
                this.hasPhoneButton = false;
                this.phoneButton_ = 0;
                return this;
            }

            public Show clearPrice() {
                this.hasPrice = false;
                this.price_ = 0;
                return this;
            }

            public int getAddress() {
                return this.address_;
            }

            public int getBookInfo() {
                return this.bookInfo_;
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

            public int getEcReason() {
                return this.ecReason_;
            }

            public int getEpChar() {
                return this.epChar_;
            }

            public int getIcon() {
                return this.icon_;
            }

            public int getImage() {
                return this.image_;
            }

            public int getMapButton() {
                return this.mapButton_;
            }

            public int getName() {
                return this.name_;
            }

            public int getOverallRating() {
                return this.overallRating_;
            }

            public int getPhoneButton() {
                return this.phoneButton_;
            }

            public int getPrice() {
                return this.price_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasAddress() ? CodedOutputStreamMicro.computeInt32Size(1, getAddress()) : 0;
                if (hasImage()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getImage());
                }
                if (hasName()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getName());
                }
                if (hasIcon()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getIcon());
                }
                if (hasDistance()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasOverallRating()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getOverallRating());
                }
                if (hasPrice()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getPrice());
                }
                if (hasEpChar()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(8, getEpChar());
                }
                if (hasEcReason()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(9, getEcReason());
                }
                if (hasPhoneButton()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(10, getPhoneButton());
                }
                if (hasBookInfo()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(11, getBookInfo());
                }
                if (hasMapButton()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(12, getMapButton());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public boolean hasAddress() {
                return this.hasAddress;
            }

            public boolean hasBookInfo() {
                return this.hasBookInfo;
            }

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasEcReason() {
                return this.hasEcReason;
            }

            public boolean hasEpChar() {
                return this.hasEpChar;
            }

            public boolean hasIcon() {
                return this.hasIcon;
            }

            public boolean hasImage() {
                return this.hasImage;
            }

            public boolean hasMapButton() {
                return this.hasMapButton;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasOverallRating() {
                return this.hasOverallRating;
            }

            public boolean hasPhoneButton() {
                return this.hasPhoneButton;
            }

            public boolean hasPrice() {
                return this.hasPrice;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Show mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            setAddress(codedInputStreamMicro.readInt32());
                            break;
                        case 16:
                            setImage(codedInputStreamMicro.readInt32());
                            break;
                        case 24:
                            setName(codedInputStreamMicro.readInt32());
                            break;
                        case 32:
                            setIcon(codedInputStreamMicro.readInt32());
                            break;
                        case 40:
                            setDistance(codedInputStreamMicro.readInt32());
                            break;
                        case 48:
                            setOverallRating(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            setPrice(codedInputStreamMicro.readInt32());
                            break;
                        case 64:
                            setEpChar(codedInputStreamMicro.readInt32());
                            break;
                        case 72:
                            setEcReason(codedInputStreamMicro.readInt32());
                            break;
                        case 80:
                            setPhoneButton(codedInputStreamMicro.readInt32());
                            break;
                        case 88:
                            setBookInfo(codedInputStreamMicro.readInt32());
                            break;
                        case 96:
                            setMapButton(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public Show setAddress(int i) {
                this.hasAddress = true;
                this.address_ = i;
                return this;
            }

            public Show setBookInfo(int i) {
                this.hasBookInfo = true;
                this.bookInfo_ = i;
                return this;
            }

            public Show setDistance(int i) {
                this.hasDistance = true;
                this.distance_ = i;
                return this;
            }

            public Show setEcReason(int i) {
                this.hasEcReason = true;
                this.ecReason_ = i;
                return this;
            }

            public Show setEpChar(int i) {
                this.hasEpChar = true;
                this.epChar_ = i;
                return this;
            }

            public Show setIcon(int i) {
                this.hasIcon = true;
                this.icon_ = i;
                return this;
            }

            public Show setImage(int i) {
                this.hasImage = true;
                this.image_ = i;
                return this;
            }

            public Show setMapButton(int i) {
                this.hasMapButton = true;
                this.mapButton_ = i;
                return this;
            }

            public Show setName(int i) {
                this.hasName = true;
                this.name_ = i;
                return this;
            }

            public Show setOverallRating(int i) {
                this.hasOverallRating = true;
                this.overallRating_ = i;
                return this;
            }

            public Show setPhoneButton(int i) {
                this.hasPhoneButton = true;
                this.phoneButton_ = i;
                return this;
            }

            public Show setPrice(int i) {
                this.hasPrice = true;
                this.price_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasAddress()) {
                    codedOutputStreamMicro.writeInt32(1, getAddress());
                }
                if (hasImage()) {
                    codedOutputStreamMicro.writeInt32(2, getImage());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeInt32(3, getName());
                }
                if (hasIcon()) {
                    codedOutputStreamMicro.writeInt32(4, getIcon());
                }
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasOverallRating()) {
                    codedOutputStreamMicro.writeInt32(6, getOverallRating());
                }
                if (hasPrice()) {
                    codedOutputStreamMicro.writeInt32(7, getPrice());
                }
                if (hasEpChar()) {
                    codedOutputStreamMicro.writeInt32(8, getEpChar());
                }
                if (hasEcReason()) {
                    codedOutputStreamMicro.writeInt32(9, getEcReason());
                }
                if (hasPhoneButton()) {
                    codedOutputStreamMicro.writeInt32(10, getPhoneButton());
                }
                if (hasBookInfo()) {
                    codedOutputStreamMicro.writeInt32(11, getBookInfo());
                }
                if (hasMapButton()) {
                    codedOutputStreamMicro.writeInt32(12, getMapButton());
                }
            }

            public static Show parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Show) new Show().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class StartPageData extends MessageMicro {
            public static final int ADDR_FIELD_NUMBER = 2;
            public static final int ICON_URL_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int PARAM_FIELD_NUMBER = 5;
            public static final int TAG_FIELD_NUMBER = 4;
            private boolean hasAddr;
            private boolean hasIconUrl;
            private boolean hasName;
            private boolean hasParam;
            private boolean hasTag;
            private String name_ = "";
            private String addr_ = "";
            private String iconUrl_ = "";
            private String tag_ = "";
            private String param_ = "";
            private int cachedSize = -1;

            public static StartPageData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartPageData().mergeFrom(codedInputStreamMicro);
            }

            public final StartPageData clear() {
                clearName();
                clearAddr();
                clearIconUrl();
                clearTag();
                clearParam();
                this.cachedSize = -1;
                return this;
            }

            public StartPageData clearAddr() {
                this.hasAddr = false;
                this.addr_ = "";
                return this;
            }

            public StartPageData clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public StartPageData clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public StartPageData clearParam() {
                this.hasParam = false;
                this.param_ = "";
                return this;
            }

            public StartPageData clearTag() {
                this.hasTag = false;
                this.tag_ = "";
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

            public String getIconUrl() {
                return this.iconUrl_;
            }

            public String getName() {
                return this.name_;
            }

            public String getParam() {
                return this.param_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                if (hasAddr()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getAddr());
                }
                if (hasIconUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getIconUrl());
                }
                if (hasTag()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getTag());
                }
                if (hasParam()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getParam());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getTag() {
                return this.tag_;
            }

            public boolean hasAddr() {
                return this.hasAddr;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasParam() {
                return this.hasParam;
            }

            public boolean hasTag() {
                return this.hasTag;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public StartPageData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setName(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setAddr(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setIconUrl(codedInputStreamMicro.readString());
                    } else if (readTag == 34) {
                        setTag(codedInputStreamMicro.readString());
                    } else if (readTag == 42) {
                        setParam(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public StartPageData setAddr(String str) {
                this.hasAddr = true;
                this.addr_ = str;
                return this;
            }

            public StartPageData setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public StartPageData setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public StartPageData setParam(String str) {
                this.hasParam = true;
                this.param_ = str;
                return this;
            }

            public StartPageData setTag(String str) {
                this.hasTag = true;
                this.tag_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeString(1, getName());
                }
                if (hasAddr()) {
                    codedOutputStreamMicro.writeString(2, getAddr());
                }
                if (hasIconUrl()) {
                    codedOutputStreamMicro.writeString(3, getIconUrl());
                }
                if (hasTag()) {
                    codedOutputStreamMicro.writeString(4, getTag());
                }
                if (hasParam()) {
                    codedOutputStreamMicro.writeString(5, getParam());
                }
            }

            public static StartPageData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartPageData) new StartPageData().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class TravelButton extends MessageMicro {
            public static final int BUBBLE_FIELD_NUMBER = 2;
            public static final int BUTTON_FIELD_NUMBER = 3;
            public static final int CORNER_MARK_URL_FIELD_NUMBER = 5;
            public static final int MATERIAL_ID_FIELD_NUMBER = 1;
            public static final int STRATEGY_FIELD_NUMBER = 4;
            private boolean hasButton;
            private boolean hasCornerMarkUrl;
            private boolean hasMaterialId;
            private boolean hasStrategy;
            private int materialId_ = 0;
            private List<String> bubble_ = Collections.emptyList();
            private Button button_ = null;
            private Strategy strategy_ = null;
            private String cornerMarkUrl_ = "";
            private int cachedSize = -1;

            /* loaded from: classes7.dex */
            public static final class Strategy extends MessageMicro {
                public static final int MAX_CLICK_TIMES_FIELD_NUMBER = 1;
                public static final int MAX_SHOW_TIMES_FIELD_NUMBER = 2;
                public static final int SHOW_DURATION_FIELD_NUMBER = 3;
                private boolean hasMaxClickTimes;
                private boolean hasMaxShowTimes;
                private boolean hasShowDuration;
                private int maxClickTimes_ = 0;
                private int maxShowTimes_ = 0;
                private int showDuration_ = 0;
                private int cachedSize = -1;

                public static Strategy parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Strategy().mergeFrom(codedInputStreamMicro);
                }

                public final Strategy clear() {
                    clearMaxClickTimes();
                    clearMaxShowTimes();
                    clearShowDuration();
                    this.cachedSize = -1;
                    return this;
                }

                public Strategy clearMaxClickTimes() {
                    this.hasMaxClickTimes = false;
                    this.maxClickTimes_ = 0;
                    return this;
                }

                public Strategy clearMaxShowTimes() {
                    this.hasMaxShowTimes = false;
                    this.maxShowTimes_ = 0;
                    return this;
                }

                public Strategy clearShowDuration() {
                    this.hasShowDuration = false;
                    this.showDuration_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getMaxClickTimes() {
                    return this.maxClickTimes_;
                }

                public int getMaxShowTimes() {
                    return this.maxShowTimes_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int computeInt32Size = hasMaxClickTimes() ? CodedOutputStreamMicro.computeInt32Size(1, getMaxClickTimes()) : 0;
                    if (hasMaxShowTimes()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getMaxShowTimes());
                    }
                    if (hasShowDuration()) {
                        computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getShowDuration());
                    }
                    this.cachedSize = computeInt32Size;
                    return computeInt32Size;
                }

                public int getShowDuration() {
                    return this.showDuration_;
                }

                public boolean hasMaxClickTimes() {
                    return this.hasMaxClickTimes;
                }

                public boolean hasMaxShowTimes() {
                    return this.hasMaxShowTimes;
                }

                public boolean hasShowDuration() {
                    return this.hasShowDuration;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Strategy mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            setMaxClickTimes(codedInputStreamMicro.readInt32());
                        } else if (readTag == 16) {
                            setMaxShowTimes(codedInputStreamMicro.readInt32());
                        } else if (readTag == 24) {
                            setShowDuration(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                    }
                }

                public Strategy setMaxClickTimes(int i) {
                    this.hasMaxClickTimes = true;
                    this.maxClickTimes_ = i;
                    return this;
                }

                public Strategy setMaxShowTimes(int i) {
                    this.hasMaxShowTimes = true;
                    this.maxShowTimes_ = i;
                    return this;
                }

                public Strategy setShowDuration(int i) {
                    this.hasShowDuration = true;
                    this.showDuration_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasMaxClickTimes()) {
                        codedOutputStreamMicro.writeInt32(1, getMaxClickTimes());
                    }
                    if (hasMaxShowTimes()) {
                        codedOutputStreamMicro.writeInt32(2, getMaxShowTimes());
                    }
                    if (hasShowDuration()) {
                        codedOutputStreamMicro.writeInt32(3, getShowDuration());
                    }
                }

                public static Strategy parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Strategy) new Strategy().mergeFrom(bArr);
                }
            }

            public static TravelButton parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new TravelButton().mergeFrom(codedInputStreamMicro);
            }

            public TravelButton addBubble(String str) {
                str.getClass();
                if (this.bubble_.isEmpty()) {
                    this.bubble_ = new ArrayList();
                }
                this.bubble_.add(str);
                return this;
            }

            public final TravelButton clear() {
                clearMaterialId();
                clearBubble();
                clearButton();
                clearStrategy();
                clearCornerMarkUrl();
                this.cachedSize = -1;
                return this;
            }

            public TravelButton clearBubble() {
                this.bubble_ = Collections.emptyList();
                return this;
            }

            public TravelButton clearButton() {
                this.hasButton = false;
                this.button_ = null;
                return this;
            }

            public TravelButton clearCornerMarkUrl() {
                this.hasCornerMarkUrl = false;
                this.cornerMarkUrl_ = "";
                return this;
            }

            public TravelButton clearMaterialId() {
                this.hasMaterialId = false;
                this.materialId_ = 0;
                return this;
            }

            public TravelButton clearStrategy() {
                this.hasStrategy = false;
                this.strategy_ = null;
                return this;
            }

            public String getBubble(int i) {
                return this.bubble_.get(i);
            }

            public int getBubbleCount() {
                return this.bubble_.size();
            }

            public List<String> getBubbleList() {
                return this.bubble_;
            }

            public Button getButton() {
                return this.button_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCornerMarkUrl() {
                return this.cornerMarkUrl_;
            }

            public int getMaterialId() {
                return this.materialId_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeInt32Size = hasMaterialId() ? CodedOutputStreamMicro.computeInt32Size(1, getMaterialId()) : 0;
                Iterator<String> it = getBubbleList().iterator();
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
                }
                int size = computeInt32Size + i + getBubbleList().size();
                if (hasButton()) {
                    size += CodedOutputStreamMicro.computeMessageSize(3, getButton());
                }
                if (hasStrategy()) {
                    size += CodedOutputStreamMicro.computeMessageSize(4, getStrategy());
                }
                if (hasCornerMarkUrl()) {
                    size += CodedOutputStreamMicro.computeStringSize(5, getCornerMarkUrl());
                }
                this.cachedSize = size;
                return size;
            }

            public Strategy getStrategy() {
                return this.strategy_;
            }

            public boolean hasButton() {
                return this.hasButton;
            }

            public boolean hasCornerMarkUrl() {
                return this.hasCornerMarkUrl;
            }

            public boolean hasMaterialId() {
                return this.hasMaterialId;
            }

            public boolean hasStrategy() {
                return this.hasStrategy;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public TravelButton mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setMaterialId(codedInputStreamMicro.readInt32());
                    } else if (readTag == 18) {
                        addBubble(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        Button button = new Button();
                        codedInputStreamMicro.readMessage(button);
                        setButton(button);
                    } else if (readTag == 34) {
                        Strategy strategy = new Strategy();
                        codedInputStreamMicro.readMessage(strategy);
                        setStrategy(strategy);
                    } else if (readTag == 42) {
                        setCornerMarkUrl(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public TravelButton setBubble(int i, String str) {
                str.getClass();
                this.bubble_.set(i, str);
                return this;
            }

            public TravelButton setButton(Button button) {
                if (button == null) {
                    return clearButton();
                }
                this.hasButton = true;
                this.button_ = button;
                return this;
            }

            public TravelButton setCornerMarkUrl(String str) {
                this.hasCornerMarkUrl = true;
                this.cornerMarkUrl_ = str;
                return this;
            }

            public TravelButton setMaterialId(int i) {
                this.hasMaterialId = true;
                this.materialId_ = i;
                return this;
            }

            public TravelButton setStrategy(Strategy strategy) {
                if (strategy == null) {
                    return clearStrategy();
                }
                this.hasStrategy = true;
                this.strategy_ = strategy;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasMaterialId()) {
                    codedOutputStreamMicro.writeInt32(1, getMaterialId());
                }
                Iterator<String> it = getBubbleList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeString(2, it.next());
                }
                if (hasButton()) {
                    codedOutputStreamMicro.writeMessage(3, getButton());
                }
                if (hasStrategy()) {
                    codedOutputStreamMicro.writeMessage(4, getStrategy());
                }
                if (hasCornerMarkUrl()) {
                    codedOutputStreamMicro.writeString(5, getCornerMarkUrl());
                }
            }

            public static TravelButton parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (TravelButton) new TravelButton().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class VuiProcessData extends MessageMicro {
            public static final int CHOOSETEMPLATE_FIELD_NUMBER = 5;
            public static final int DYN_REQUEST_FIELD_NUMBER = 1;
            public static final int DYN_RESPONSE_FIELD_NUMBER = 2;
            public static final int DYN_ZHANWEI_FIELD_NUMBER = 3;
            public static final int TRADE_FIELD_NUMBER = 4;
            private boolean hasChooseTemplate;
            private boolean hasDynRequest;
            private boolean hasDynResponse;
            private boolean hasTrade;
            private boolean dynRequest_ = false;
            private boolean dynResponse_ = false;
            private List<Integer> dynZhanwei_ = Collections.emptyList();
            private String trade_ = "";
            private String chooseTemplate_ = "";
            private int cachedSize = -1;

            public static VuiProcessData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new VuiProcessData().mergeFrom(codedInputStreamMicro);
            }

            public VuiProcessData addDynZhanwei(int i) {
                if (this.dynZhanwei_.isEmpty()) {
                    this.dynZhanwei_ = new ArrayList();
                }
                this.dynZhanwei_.add(Integer.valueOf(i));
                return this;
            }

            public final VuiProcessData clear() {
                clearDynRequest();
                clearDynResponse();
                clearDynZhanwei();
                clearTrade();
                clearChooseTemplate();
                this.cachedSize = -1;
                return this;
            }

            public VuiProcessData clearChooseTemplate() {
                this.hasChooseTemplate = false;
                this.chooseTemplate_ = "";
                return this;
            }

            public VuiProcessData clearDynRequest() {
                this.hasDynRequest = false;
                this.dynRequest_ = false;
                return this;
            }

            public VuiProcessData clearDynResponse() {
                this.hasDynResponse = false;
                this.dynResponse_ = false;
                return this;
            }

            public VuiProcessData clearDynZhanwei() {
                this.dynZhanwei_ = Collections.emptyList();
                return this;
            }

            public VuiProcessData clearTrade() {
                this.hasTrade = false;
                this.trade_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getChooseTemplate() {
                return this.chooseTemplate_;
            }

            public boolean getDynRequest() {
                return this.dynRequest_;
            }

            public boolean getDynResponse() {
                return this.dynResponse_;
            }

            public int getDynZhanwei(int i) {
                return this.dynZhanwei_.get(i).intValue();
            }

            public int getDynZhanweiCount() {
                return this.dynZhanwei_.size();
            }

            public List<Integer> getDynZhanweiList() {
                return this.dynZhanwei_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int i = 0;
                int computeBoolSize = hasDynRequest() ? CodedOutputStreamMicro.computeBoolSize(1, getDynRequest()) : 0;
                if (hasDynResponse()) {
                    computeBoolSize += CodedOutputStreamMicro.computeBoolSize(2, getDynResponse());
                }
                Iterator<Integer> it = getDynZhanweiList().iterator();
                while (it.hasNext()) {
                    i += CodedOutputStreamMicro.computeInt32SizeNoTag(it.next().intValue());
                }
                int size = computeBoolSize + i + getDynZhanweiList().size();
                if (hasTrade()) {
                    size += CodedOutputStreamMicro.computeStringSize(4, getTrade());
                }
                if (hasChooseTemplate()) {
                    size += CodedOutputStreamMicro.computeStringSize(5, getChooseTemplate());
                }
                this.cachedSize = size;
                return size;
            }

            public String getTrade() {
                return this.trade_;
            }

            public boolean hasChooseTemplate() {
                return this.hasChooseTemplate;
            }

            public boolean hasDynRequest() {
                return this.hasDynRequest;
            }

            public boolean hasDynResponse() {
                return this.hasDynResponse;
            }

            public boolean hasTrade() {
                return this.hasTrade;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public VuiProcessData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setDynRequest(codedInputStreamMicro.readBool());
                    } else if (readTag == 16) {
                        setDynResponse(codedInputStreamMicro.readBool());
                    } else if (readTag == 24) {
                        addDynZhanwei(codedInputStreamMicro.readInt32());
                    } else if (readTag == 34) {
                        setTrade(codedInputStreamMicro.readString());
                    } else if (readTag == 42) {
                        setChooseTemplate(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public VuiProcessData setChooseTemplate(String str) {
                this.hasChooseTemplate = true;
                this.chooseTemplate_ = str;
                return this;
            }

            public VuiProcessData setDynRequest(boolean z) {
                this.hasDynRequest = true;
                this.dynRequest_ = z;
                return this;
            }

            public VuiProcessData setDynResponse(boolean z) {
                this.hasDynResponse = true;
                this.dynResponse_ = z;
                return this;
            }

            public VuiProcessData setDynZhanwei(int i, int i2) {
                this.dynZhanwei_.set(i, Integer.valueOf(i2));
                return this;
            }

            public VuiProcessData setTrade(String str) {
                this.hasTrade = true;
                this.trade_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDynRequest()) {
                    codedOutputStreamMicro.writeBool(1, getDynRequest());
                }
                if (hasDynResponse()) {
                    codedOutputStreamMicro.writeBool(2, getDynResponse());
                }
                Iterator<Integer> it = getDynZhanweiList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeInt32(3, it.next().intValue());
                }
                if (hasTrade()) {
                    codedOutputStreamMicro.writeString(4, getTrade());
                }
                if (hasChooseTemplate()) {
                    codedOutputStreamMicro.writeString(5, getChooseTemplate());
                }
            }

            public static VuiProcessData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (VuiProcessData) new VuiProcessData().mergeFrom(bArr);
            }
        }

        public Contents() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.cloudTemplate_ = byteStringMicro;
            this.button_ = null;
            this.mapPoitag_ = null;
            this.barTemplate_ = byteStringMicro;
            this.ismodified_ = 0;
            this.headway_ = "";
            this.interventTips_ = "";
            this.poiRegionType_ = "";
            this.regionType_ = "";
            this.distance_ = "";
            this.stdTag_ = "";
            this.serviceTag_ = "";
            this.areaName_ = "";
            this.photoList_ = "";
            this.headIcon_ = null;
            this.indoorOverLooking_ = 0;
            this.stdTagId_ = "";
            this.vuiProcessData_ = null;
            this.newsgeo_ = null;
            this.attachedAddr_ = 0;
            this.city_ = "";
            this.province_ = "";
            this.recommendType_ = 0;
            this.detailDisplayType_ = 0;
            this.queryGuide_ = "";
            this.indoorGeoz_ = 0;
            this.poiSimilar_ = null;
            this.avocadoForwardParam_ = "";
            this.horizonSlideData_ = "";
            this.buriedPoint_ = "";
            this.infDynRequest_ = 0;
            this.halfKill_ = false;
            this.headIconBubbleInfo_ = null;
            this.thirdParty_ = null;
            this.headResultMsg_ = byteStringMicro;
            this.hwBrowseRecords_ = null;
            this.barButton_ = Collections.emptyList();
            this.travelButton_ = null;
            this.cardType_ = 0;
            this.advertiseInfo_ = null;
            this.fourStateSwitch_ = 0;
            this.adsData_ = null;
            this.historyAddress_ = "";
            this.favNum_ = 0;
            this.aispaceAds_ = null;
            this.cachedSize = -1;
        }

        public static Contents parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Contents().mergeFrom(codedInputStreamMicro);
        }

        public Contents addBarButton(BarButton barButton) {
            if (barButton == null) {
                return this;
            }
            if (this.barButton_.isEmpty()) {
                this.barButton_ = new ArrayList();
            }
            this.barButton_.add(barButton);
            return this;
        }

        public Contents addRecReason(String str) {
            str.getClass();
            if (this.recReason_.isEmpty()) {
                this.recReason_ = new ArrayList();
            }
            this.recReason_.add(str);
            return this;
        }

        public final Contents clear() {
            clearShow();
            clearExt();
            clearHeatMap();
            clearSgeo();
            clearGeo();
            clearName();
            clearUid();
            clearAccFlag();
            clearAddr();
            clearDetail();
            clearRecReason();
            clearTel();
            clearPoiType();
            clearPano();
            clearIndoorPano();
            clearAoi();
            clearStartTime();
            clearEndTime();
            clearHasRtbus();
            clearTipRtbus();
            clearRtbusUpdateTime();
            clearFatherSon();
            clearPoiTypeText();
            clearChildCatalog();
            clearPoiChildText();
            clearNewCatalogId();
            clearViewType();
            clearListShow();
            clearShowLevel();
            clearIconId();
            clearKindtype();
            clearBrandIconId();
            clearTag();
            clearRank();
            clearMaxShowLevel();
            clearIndoorFloor();
            clearIndoorParentUid();
            clearCloudTemplate();
            clearButton();
            clearMapPoitag();
            clearBarTemplate();
            clearIsmodified();
            clearHeadway();
            clearInterventTips();
            clearPoiRegionType();
            clearRegionType();
            clearDistance();
            clearStdTag();
            clearServiceTag();
            clearAreaName();
            clearPhotoList();
            clearHeadIcon();
            clearIndoorOverLooking();
            clearStdTagId();
            clearVuiProcessData();
            clearNewsgeo();
            clearAttachedAddr();
            clearCity();
            clearProvince();
            clearRecommendType();
            clearDetailDisplayType();
            clearQueryGuide();
            clearIndoorGeoz();
            clearPoiSimilar();
            clearAvocadoForwardParam();
            clearHorizonSlideData();
            clearBuriedPoint();
            clearInfDynRequest();
            clearHalfKill();
            clearHeadIconBubbleInfo();
            clearThirdParty();
            clearHeadResultMsg();
            clearHwBrowseRecords();
            clearBarButton();
            clearTravelButton();
            clearCardType();
            clearAdvertiseInfo();
            clearFourStateSwitch();
            clearAdsData();
            clearHistoryAddress();
            clearFavNum();
            clearAispaceAds();
            this.cachedSize = -1;
            return this;
        }

        public Contents clearAccFlag() {
            this.hasAccFlag = false;
            this.accFlag_ = 0;
            return this;
        }

        public Contents clearAddr() {
            this.hasAddr = false;
            this.addr_ = "";
            return this;
        }

        public Contents clearAdsData() {
            this.hasAdsData = false;
            this.adsData_ = null;
            return this;
        }

        public Contents clearAdvertiseInfo() {
            this.hasAdvertiseInfo = false;
            this.advertiseInfo_ = null;
            return this;
        }

        public Contents clearAispaceAds() {
            this.hasAispaceAds = false;
            this.aispaceAds_ = null;
            return this;
        }

        public Contents clearAoi() {
            this.hasAoi = false;
            this.aoi_ = "";
            return this;
        }

        public Contents clearAreaName() {
            this.hasAreaName = false;
            this.areaName_ = "";
            return this;
        }

        public Contents clearAttachedAddr() {
            this.hasAttachedAddr = false;
            this.attachedAddr_ = 0;
            return this;
        }

        public Contents clearAvocadoForwardParam() {
            this.hasAvocadoForwardParam = false;
            this.avocadoForwardParam_ = "";
            return this;
        }

        public Contents clearBarButton() {
            this.barButton_ = Collections.emptyList();
            return this;
        }

        public Contents clearBarTemplate() {
            this.hasBarTemplate = false;
            this.barTemplate_ = ByteStringMicro.EMPTY;
            return this;
        }

        public Contents clearBrandIconId() {
            this.hasBrandIconId = false;
            this.brandIconId_ = 0;
            return this;
        }

        public Contents clearBuriedPoint() {
            this.hasBuriedPoint = false;
            this.buriedPoint_ = "";
            return this;
        }

        public Contents clearButton() {
            this.hasButton = false;
            this.button_ = null;
            return this;
        }

        public Contents clearCardType() {
            this.hasCardType = false;
            this.cardType_ = 0;
            return this;
        }

        public Contents clearChildCatalog() {
            this.hasChildCatalog = false;
            this.childCatalog_ = "";
            return this;
        }

        public Contents clearCity() {
            this.hasCity = false;
            this.city_ = "";
            return this;
        }

        public Contents clearCloudTemplate() {
            this.hasCloudTemplate = false;
            this.cloudTemplate_ = ByteStringMicro.EMPTY;
            return this;
        }

        public Contents clearDetail() {
            this.hasDetail = false;
            this.detail_ = 0;
            return this;
        }

        public Contents clearDetailDisplayType() {
            this.hasDetailDisplayType = false;
            this.detailDisplayType_ = 0;
            return this;
        }

        public Contents clearDistance() {
            this.hasDistance = false;
            this.distance_ = "";
            return this;
        }

        public Contents clearEndTime() {
            this.hasEndTime = false;
            this.endTime_ = "";
            return this;
        }

        public Contents clearExt() {
            this.hasExt = false;
            this.ext_ = null;
            return this;
        }

        public Contents clearFatherSon() {
            this.hasFatherSon = false;
            this.fatherSon_ = 0;
            return this;
        }

        public Contents clearFavNum() {
            this.hasFavNum = false;
            this.favNum_ = 0;
            return this;
        }

        public Contents clearFourStateSwitch() {
            this.hasFourStateSwitch = false;
            this.fourStateSwitch_ = 0;
            return this;
        }

        public Contents clearGeo() {
            this.hasGeo = false;
            this.geo_ = "";
            return this;
        }

        public Contents clearHalfKill() {
            this.hasHalfKill = false;
            this.halfKill_ = false;
            return this;
        }

        public Contents clearHasRtbus() {
            this.hasHasRtbus = false;
            this.hasRtbus_ = 0;
            return this;
        }

        public Contents clearHeadIcon() {
            this.hasHeadIcon = false;
            this.headIcon_ = null;
            return this;
        }

        public Contents clearHeadIconBubbleInfo() {
            this.hasHeadIconBubbleInfo = false;
            this.headIconBubbleInfo_ = null;
            return this;
        }

        public Contents clearHeadResultMsg() {
            this.hasHeadResultMsg = false;
            this.headResultMsg_ = ByteStringMicro.EMPTY;
            return this;
        }

        public Contents clearHeadway() {
            this.hasHeadway = false;
            this.headway_ = "";
            return this;
        }

        public Contents clearHeatMap() {
            this.hasHeatMap = false;
            this.heatMap_ = null;
            return this;
        }

        public Contents clearHistoryAddress() {
            this.hasHistoryAddress = false;
            this.historyAddress_ = "";
            return this;
        }

        public Contents clearHorizonSlideData() {
            this.hasHorizonSlideData = false;
            this.horizonSlideData_ = "";
            return this;
        }

        public Contents clearHwBrowseRecords() {
            this.hasHwBrowseRecords = false;
            this.hwBrowseRecords_ = null;
            return this;
        }

        public Contents clearIconId() {
            this.hasIconId = false;
            this.iconId_ = 0;
            return this;
        }

        public Contents clearIndoorFloor() {
            this.hasIndoorFloor = false;
            this.indoorFloor_ = "";
            return this;
        }

        public Contents clearIndoorGeoz() {
            this.hasIndoorGeoz = false;
            this.indoorGeoz_ = 0;
            return this;
        }

        public Contents clearIndoorOverLooking() {
            this.hasIndoorOverLooking = false;
            this.indoorOverLooking_ = 0;
            return this;
        }

        public Contents clearIndoorPano() {
            this.hasIndoorPano = false;
            this.indoorPano_ = "";
            return this;
        }

        public Contents clearIndoorParentUid() {
            this.hasIndoorParentUid = false;
            this.indoorParentUid_ = "";
            return this;
        }

        public Contents clearInfDynRequest() {
            this.hasInfDynRequest = false;
            this.infDynRequest_ = 0;
            return this;
        }

        public Contents clearInterventTips() {
            this.hasInterventTips = false;
            this.interventTips_ = "";
            return this;
        }

        public Contents clearIsmodified() {
            this.hasIsmodified = false;
            this.ismodified_ = 0;
            return this;
        }

        public Contents clearKindtype() {
            this.hasKindtype = false;
            this.kindtype_ = 0;
            return this;
        }

        public Contents clearListShow() {
            this.hasListShow = false;
            this.listShow_ = 0;
            return this;
        }

        public Contents clearMapPoitag() {
            this.hasMapPoitag = false;
            this.mapPoitag_ = null;
            return this;
        }

        public Contents clearMaxShowLevel() {
            this.hasMaxShowLevel = false;
            this.maxShowLevel_ = 0;
            return this;
        }

        public Contents clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public Contents clearNewCatalogId() {
            this.hasNewCatalogId = false;
            this.newCatalogId_ = "";
            return this;
        }

        public Contents clearNewsgeo() {
            this.hasNewsgeo = false;
            this.newsgeo_ = null;
            return this;
        }

        public Contents clearPano() {
            this.hasPano = false;
            this.pano_ = 0;
            return this;
        }

        public Contents clearPhotoList() {
            this.hasPhotoList = false;
            this.photoList_ = "";
            return this;
        }

        public Contents clearPoiChildText() {
            this.hasPoiChildText = false;
            this.poiChildText_ = "";
            return this;
        }

        public Contents clearPoiRegionType() {
            this.hasPoiRegionType = false;
            this.poiRegionType_ = "";
            return this;
        }

        public Contents clearPoiSimilar() {
            this.hasPoiSimilar = false;
            this.poiSimilar_ = null;
            return this;
        }

        public Contents clearPoiType() {
            this.hasPoiType = false;
            this.poiType_ = 0;
            return this;
        }

        public Contents clearPoiTypeText() {
            this.hasPoiTypeText = false;
            this.poiTypeText_ = "";
            return this;
        }

        public Contents clearProvince() {
            this.hasProvince = false;
            this.province_ = "";
            return this;
        }

        public Contents clearQueryGuide() {
            this.hasQueryGuide = false;
            this.queryGuide_ = "";
            return this;
        }

        public Contents clearRank() {
            this.hasRank = false;
            this.rank_ = 0;
            return this;
        }

        public Contents clearRecReason() {
            this.recReason_ = Collections.emptyList();
            return this;
        }

        public Contents clearRecommendType() {
            this.hasRecommendType = false;
            this.recommendType_ = 0;
            return this;
        }

        public Contents clearRegionType() {
            this.hasRegionType = false;
            this.regionType_ = "";
            return this;
        }

        public Contents clearRtbusUpdateTime() {
            this.hasRtbusUpdateTime = false;
            this.rtbusUpdateTime_ = 0;
            return this;
        }

        public Contents clearServiceTag() {
            this.hasServiceTag = false;
            this.serviceTag_ = "";
            return this;
        }

        public Contents clearSgeo() {
            this.hasSgeo = false;
            this.sgeo_ = null;
            return this;
        }

        public Contents clearShow() {
            this.hasShow = false;
            this.show_ = null;
            return this;
        }

        public Contents clearShowLevel() {
            this.hasShowLevel = false;
            this.showLevel_ = 0;
            return this;
        }

        public Contents clearStartTime() {
            this.hasStartTime = false;
            this.startTime_ = "";
            return this;
        }

        public Contents clearStdTag() {
            this.hasStdTag = false;
            this.stdTag_ = "";
            return this;
        }

        public Contents clearStdTagId() {
            this.hasStdTagId = false;
            this.stdTagId_ = "";
            return this;
        }

        public Contents clearTag() {
            this.hasTag = false;
            this.tag_ = 0;
            return this;
        }

        public Contents clearTel() {
            this.hasTel = false;
            this.tel_ = "";
            return this;
        }

        public Contents clearThirdParty() {
            this.hasThirdParty = false;
            this.thirdParty_ = null;
            return this;
        }

        public Contents clearTipRtbus() {
            this.hasTipRtbus = false;
            this.tipRtbus_ = "";
            return this;
        }

        public Contents clearTravelButton() {
            this.hasTravelButton = false;
            this.travelButton_ = null;
            return this;
        }

        public Contents clearUid() {
            this.hasUid = false;
            this.uid_ = "";
            return this;
        }

        public Contents clearViewType() {
            this.hasViewType = false;
            this.viewType_ = 0;
            return this;
        }

        public Contents clearVuiProcessData() {
            this.hasVuiProcessData = false;
            this.vuiProcessData_ = null;
            return this;
        }

        public int getAccFlag() {
            return this.accFlag_;
        }

        public String getAddr() {
            return this.addr_;
        }

        public AdsData getAdsData() {
            return this.adsData_;
        }

        public AdvertiseInfo getAdvertiseInfo() {
            return this.advertiseInfo_;
        }

        public AispaceAds getAispaceAds() {
            return this.aispaceAds_;
        }

        public String getAoi() {
            return this.aoi_;
        }

        public String getAreaName() {
            return this.areaName_;
        }

        public int getAttachedAddr() {
            return this.attachedAddr_;
        }

        public String getAvocadoForwardParam() {
            return this.avocadoForwardParam_;
        }

        public BarButton getBarButton(int i) {
            return this.barButton_.get(i);
        }

        public int getBarButtonCount() {
            return this.barButton_.size();
        }

        public List<BarButton> getBarButtonList() {
            return this.barButton_;
        }

        public ByteStringMicro getBarTemplate() {
            return this.barTemplate_;
        }

        public int getBrandIconId() {
            return this.brandIconId_;
        }

        public String getBuriedPoint() {
            return this.buriedPoint_;
        }

        public Button getButton() {
            return this.button_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getCardType() {
            return this.cardType_;
        }

        public String getChildCatalog() {
            return this.childCatalog_;
        }

        public String getCity() {
            return this.city_;
        }

        public ByteStringMicro getCloudTemplate() {
            return this.cloudTemplate_;
        }

        public int getDetail() {
            return this.detail_;
        }

        public int getDetailDisplayType() {
            return this.detailDisplayType_;
        }

        public String getDistance() {
            return this.distance_;
        }

        public String getEndTime() {
            return this.endTime_;
        }

        public Ext getExt() {
            return this.ext_;
        }

        public int getFatherSon() {
            return this.fatherSon_;
        }

        public int getFavNum() {
            return this.favNum_;
        }

        public int getFourStateSwitch() {
            return this.fourStateSwitch_;
        }

        public String getGeo() {
            return this.geo_;
        }

        public boolean getHalfKill() {
            return this.halfKill_;
        }

        public int getHasRtbus() {
            return this.hasRtbus_;
        }

        public HeadIcon getHeadIcon() {
            return this.headIcon_;
        }

        public HeadIconBubbleInfo getHeadIconBubbleInfo() {
            return this.headIconBubbleInfo_;
        }

        public ByteStringMicro getHeadResultMsg() {
            return this.headResultMsg_;
        }

        public String getHeadway() {
            return this.headway_;
        }

        public HeatMap getHeatMap() {
            return this.heatMap_;
        }

        public String getHistoryAddress() {
            return this.historyAddress_;
        }

        public String getHorizonSlideData() {
            return this.horizonSlideData_;
        }

        public StartPageData getHwBrowseRecords() {
            return this.hwBrowseRecords_;
        }

        public int getIconId() {
            return this.iconId_;
        }

        public String getIndoorFloor() {
            return this.indoorFloor_;
        }

        public int getIndoorGeoz() {
            return this.indoorGeoz_;
        }

        public int getIndoorOverLooking() {
            return this.indoorOverLooking_;
        }

        public String getIndoorPano() {
            return this.indoorPano_;
        }

        public String getIndoorParentUid() {
            return this.indoorParentUid_;
        }

        public int getInfDynRequest() {
            return this.infDynRequest_;
        }

        public String getInterventTips() {
            return this.interventTips_;
        }

        public int getIsmodified() {
            return this.ismodified_;
        }

        public int getKindtype() {
            return this.kindtype_;
        }

        public int getListShow() {
            return this.listShow_;
        }

        public MapPoitag getMapPoitag() {
            return this.mapPoitag_;
        }

        public int getMaxShowLevel() {
            return this.maxShowLevel_;
        }

        public String getName() {
            return this.name_;
        }

        public String getNewCatalogId() {
            return this.newCatalogId_;
        }

        public Sgeo getNewsgeo() {
            return this.newsgeo_;
        }

        public int getPano() {
            return this.pano_;
        }

        public String getPhotoList() {
            return this.photoList_;
        }

        public String getPoiChildText() {
            return this.poiChildText_;
        }

        public String getPoiRegionType() {
            return this.poiRegionType_;
        }

        public PoiSimilar getPoiSimilar() {
            return this.poiSimilar_;
        }

        public int getPoiType() {
            return this.poiType_;
        }

        public String getPoiTypeText() {
            return this.poiTypeText_;
        }

        public String getProvince() {
            return this.province_;
        }

        public String getQueryGuide() {
            return this.queryGuide_;
        }

        public int getRank() {
            return this.rank_;
        }

        public String getRecReason(int i) {
            return this.recReason_.get(i);
        }

        public int getRecReasonCount() {
            return this.recReason_.size();
        }

        public List<String> getRecReasonList() {
            return this.recReason_;
        }

        public int getRecommendType() {
            return this.recommendType_;
        }

        public String getRegionType() {
            return this.regionType_;
        }

        public int getRtbusUpdateTime() {
            return this.rtbusUpdateTime_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasGeo() ? CodedOutputStreamMicro.computeStringSize(1, getGeo()) : 0;
            if (hasName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasUid()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
            }
            if (hasAccFlag()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getAccFlag());
            }
            if (hasAddr()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getAddr());
            }
            if (hasDetail()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getDetail());
            }
            Iterator<String> it = getRecReasonList().iterator();
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
            }
            int size = computeStringSize + i + getRecReasonList().size();
            if (hasTel()) {
                size += CodedOutputStreamMicro.computeStringSize(8, getTel());
            }
            if (hasPoiType()) {
                size += CodedOutputStreamMicro.computeInt32Size(9, getPoiType());
            }
            if (hasPano()) {
                size += CodedOutputStreamMicro.computeInt32Size(10, getPano());
            }
            if (hasIndoorPano()) {
                size += CodedOutputStreamMicro.computeStringSize(11, getIndoorPano());
            }
            if (hasAoi()) {
                size += CodedOutputStreamMicro.computeStringSize(12, getAoi());
            }
            if (hasShow()) {
                size += CodedOutputStreamMicro.computeMessageSize(13, getShow());
            }
            if (hasExt()) {
                size += CodedOutputStreamMicro.computeMessageSize(14, getExt());
            }
            if (hasStartTime()) {
                size += CodedOutputStreamMicro.computeStringSize(15, getStartTime());
            }
            if (hasEndTime()) {
                size += CodedOutputStreamMicro.computeStringSize(16, getEndTime());
            }
            if (hasHasRtbus()) {
                size += CodedOutputStreamMicro.computeInt32Size(17, getHasRtbus());
            }
            if (hasTipRtbus()) {
                size += CodedOutputStreamMicro.computeStringSize(18, getTipRtbus());
            }
            if (hasRtbusUpdateTime()) {
                size += CodedOutputStreamMicro.computeInt32Size(19, getRtbusUpdateTime());
            }
            if (hasFatherSon()) {
                size += CodedOutputStreamMicro.computeInt32Size(20, getFatherSon());
            }
            if (hasSgeo()) {
                size += CodedOutputStreamMicro.computeMessageSize(21, getSgeo());
            }
            if (hasPoiTypeText()) {
                size += CodedOutputStreamMicro.computeStringSize(22, getPoiTypeText());
            }
            if (hasHeatMap()) {
                size += CodedOutputStreamMicro.computeMessageSize(23, getHeatMap());
            }
            if (hasChildCatalog()) {
                size += CodedOutputStreamMicro.computeStringSize(24, getChildCatalog());
            }
            if (hasPoiChildText()) {
                size += CodedOutputStreamMicro.computeStringSize(25, getPoiChildText());
            }
            if (hasNewCatalogId()) {
                size += CodedOutputStreamMicro.computeStringSize(26, getNewCatalogId());
            }
            if (hasViewType()) {
                size += CodedOutputStreamMicro.computeInt32Size(27, getViewType());
            }
            if (hasListShow()) {
                size += CodedOutputStreamMicro.computeInt32Size(28, getListShow());
            }
            if (hasShowLevel()) {
                size += CodedOutputStreamMicro.computeInt32Size(29, getShowLevel());
            }
            if (hasIconId()) {
                size += CodedOutputStreamMicro.computeInt32Size(30, getIconId());
            }
            if (hasKindtype()) {
                size += CodedOutputStreamMicro.computeInt32Size(31, getKindtype());
            }
            if (hasBrandIconId()) {
                size += CodedOutputStreamMicro.computeInt32Size(32, getBrandIconId());
            }
            if (hasTag()) {
                size += CodedOutputStreamMicro.computeInt32Size(33, getTag());
            }
            if (hasRank()) {
                size += CodedOutputStreamMicro.computeInt32Size(34, getRank());
            }
            if (hasMaxShowLevel()) {
                size += CodedOutputStreamMicro.computeInt32Size(35, getMaxShowLevel());
            }
            if (hasIndoorFloor()) {
                size += CodedOutputStreamMicro.computeStringSize(36, getIndoorFloor());
            }
            if (hasIndoorParentUid()) {
                size += CodedOutputStreamMicro.computeStringSize(37, getIndoorParentUid());
            }
            if (hasCloudTemplate()) {
                size += CodedOutputStreamMicro.computeBytesSize(38, getCloudTemplate());
            }
            if (hasButton()) {
                size += CodedOutputStreamMicro.computeMessageSize(39, getButton());
            }
            if (hasMapPoitag()) {
                size += CodedOutputStreamMicro.computeMessageSize(40, getMapPoitag());
            }
            if (hasBarTemplate()) {
                size += CodedOutputStreamMicro.computeBytesSize(41, getBarTemplate());
            }
            if (hasIsmodified()) {
                size += CodedOutputStreamMicro.computeInt32Size(42, getIsmodified());
            }
            if (hasHeadway()) {
                size += CodedOutputStreamMicro.computeStringSize(43, getHeadway());
            }
            if (hasInterventTips()) {
                size += CodedOutputStreamMicro.computeStringSize(44, getInterventTips());
            }
            if (hasPoiRegionType()) {
                size += CodedOutputStreamMicro.computeStringSize(45, getPoiRegionType());
            }
            if (hasRegionType()) {
                size += CodedOutputStreamMicro.computeStringSize(46, getRegionType());
            }
            if (hasDistance()) {
                size += CodedOutputStreamMicro.computeStringSize(48, getDistance());
            }
            if (hasStdTag()) {
                size += CodedOutputStreamMicro.computeStringSize(49, getStdTag());
            }
            if (hasServiceTag()) {
                size += CodedOutputStreamMicro.computeStringSize(50, getServiceTag());
            }
            if (hasAreaName()) {
                size += CodedOutputStreamMicro.computeStringSize(51, getAreaName());
            }
            if (hasPhotoList()) {
                size += CodedOutputStreamMicro.computeStringSize(52, getPhotoList());
            }
            if (hasHeadIcon()) {
                size += CodedOutputStreamMicro.computeMessageSize(53, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                size += CodedOutputStreamMicro.computeInt32Size(54, getIndoorOverLooking());
            }
            if (hasStdTagId()) {
                size += CodedOutputStreamMicro.computeStringSize(55, getStdTagId());
            }
            if (hasVuiProcessData()) {
                size += CodedOutputStreamMicro.computeMessageSize(56, getVuiProcessData());
            }
            if (hasNewsgeo()) {
                size += CodedOutputStreamMicro.computeMessageSize(57, getNewsgeo());
            }
            if (hasAttachedAddr()) {
                size += CodedOutputStreamMicro.computeInt32Size(58, getAttachedAddr());
            }
            if (hasCity()) {
                size += CodedOutputStreamMicro.computeStringSize(59, getCity());
            }
            if (hasProvince()) {
                size += CodedOutputStreamMicro.computeStringSize(60, getProvince());
            }
            if (hasRecommendType()) {
                size += CodedOutputStreamMicro.computeInt32Size(61, getRecommendType());
            }
            if (hasDetailDisplayType()) {
                size += CodedOutputStreamMicro.computeInt32Size(62, getDetailDisplayType());
            }
            if (hasQueryGuide()) {
                size += CodedOutputStreamMicro.computeStringSize(63, getQueryGuide());
            }
            if (hasIndoorGeoz()) {
                size += CodedOutputStreamMicro.computeInt32Size(64, getIndoorGeoz());
            }
            if (hasPoiSimilar()) {
                size += CodedOutputStreamMicro.computeMessageSize(65, getPoiSimilar());
            }
            if (hasAvocadoForwardParam()) {
                size += CodedOutputStreamMicro.computeStringSize(66, getAvocadoForwardParam());
            }
            if (hasHorizonSlideData()) {
                size += CodedOutputStreamMicro.computeStringSize(67, getHorizonSlideData());
            }
            if (hasBuriedPoint()) {
                size += CodedOutputStreamMicro.computeStringSize(68, getBuriedPoint());
            }
            if (hasInfDynRequest()) {
                size += CodedOutputStreamMicro.computeInt32Size(69, getInfDynRequest());
            }
            if (hasHalfKill()) {
                size += CodedOutputStreamMicro.computeBoolSize(70, getHalfKill());
            }
            if (hasHeadIconBubbleInfo()) {
                size += CodedOutputStreamMicro.computeMessageSize(71, getHeadIconBubbleInfo());
            }
            if (hasThirdParty()) {
                size += CodedOutputStreamMicro.computeMessageSize(72, getThirdParty());
            }
            if (hasHeadResultMsg()) {
                size += CodedOutputStreamMicro.computeBytesSize(73, getHeadResultMsg());
            }
            if (hasHwBrowseRecords()) {
                size += CodedOutputStreamMicro.computeMessageSize(74, getHwBrowseRecords());
            }
            Iterator<BarButton> it2 = getBarButtonList().iterator();
            while (it2.hasNext()) {
                size += CodedOutputStreamMicro.computeMessageSize(75, it2.next());
            }
            if (hasTravelButton()) {
                size += CodedOutputStreamMicro.computeMessageSize(76, getTravelButton());
            }
            if (hasCardType()) {
                size += CodedOutputStreamMicro.computeInt32Size(77, getCardType());
            }
            if (hasAdvertiseInfo()) {
                size += CodedOutputStreamMicro.computeMessageSize(78, getAdvertiseInfo());
            }
            if (hasFourStateSwitch()) {
                size += CodedOutputStreamMicro.computeInt32Size(79, getFourStateSwitch());
            }
            if (hasAdsData()) {
                size += CodedOutputStreamMicro.computeMessageSize(80, getAdsData());
            }
            if (hasHistoryAddress()) {
                size += CodedOutputStreamMicro.computeStringSize(81, getHistoryAddress());
            }
            if (hasFavNum()) {
                size += CodedOutputStreamMicro.computeInt32Size(82, getFavNum());
            }
            if (hasAispaceAds()) {
                size += CodedOutputStreamMicro.computeMessageSize(83, getAispaceAds());
            }
            this.cachedSize = size;
            return size;
        }

        public String getServiceTag() {
            return this.serviceTag_;
        }

        public Sgeo getSgeo() {
            return this.sgeo_;
        }

        public Show getShow() {
            return this.show_;
        }

        public int getShowLevel() {
            return this.showLevel_;
        }

        public String getStartTime() {
            return this.startTime_;
        }

        public String getStdTag() {
            return this.stdTag_;
        }

        public String getStdTagId() {
            return this.stdTagId_;
        }

        public int getTag() {
            return this.tag_;
        }

        public String getTel() {
            return this.tel_;
        }

        public ThirdParty getThirdParty() {
            return this.thirdParty_;
        }

        public String getTipRtbus() {
            return this.tipRtbus_;
        }

        public TravelButton getTravelButton() {
            return this.travelButton_;
        }

        public String getUid() {
            return this.uid_;
        }

        public int getViewType() {
            return this.viewType_;
        }

        public VuiProcessData getVuiProcessData() {
            return this.vuiProcessData_;
        }

        public boolean hasAccFlag() {
            return this.hasAccFlag;
        }

        public boolean hasAddr() {
            return this.hasAddr;
        }

        public boolean hasAdsData() {
            return this.hasAdsData;
        }

        public boolean hasAdvertiseInfo() {
            return this.hasAdvertiseInfo;
        }

        public boolean hasAispaceAds() {
            return this.hasAispaceAds;
        }

        public boolean hasAoi() {
            return this.hasAoi;
        }

        public boolean hasAreaName() {
            return this.hasAreaName;
        }

        public boolean hasAttachedAddr() {
            return this.hasAttachedAddr;
        }

        public boolean hasAvocadoForwardParam() {
            return this.hasAvocadoForwardParam;
        }

        public boolean hasBarTemplate() {
            return this.hasBarTemplate;
        }

        public boolean hasBrandIconId() {
            return this.hasBrandIconId;
        }

        public boolean hasBuriedPoint() {
            return this.hasBuriedPoint;
        }

        public boolean hasButton() {
            return this.hasButton;
        }

        public boolean hasCardType() {
            return this.hasCardType;
        }

        public boolean hasChildCatalog() {
            return this.hasChildCatalog;
        }

        public boolean hasCity() {
            return this.hasCity;
        }

        public boolean hasCloudTemplate() {
            return this.hasCloudTemplate;
        }

        public boolean hasDetail() {
            return this.hasDetail;
        }

        public boolean hasDetailDisplayType() {
            return this.hasDetailDisplayType;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasEndTime() {
            return this.hasEndTime;
        }

        public boolean hasExt() {
            return this.hasExt;
        }

        public boolean hasFatherSon() {
            return this.hasFatherSon;
        }

        public boolean hasFavNum() {
            return this.hasFavNum;
        }

        public boolean hasFourStateSwitch() {
            return this.hasFourStateSwitch;
        }

        public boolean hasGeo() {
            return this.hasGeo;
        }

        public boolean hasHalfKill() {
            return this.hasHalfKill;
        }

        public boolean hasHasRtbus() {
            return this.hasHasRtbus;
        }

        public boolean hasHeadIcon() {
            return this.hasHeadIcon;
        }

        public boolean hasHeadIconBubbleInfo() {
            return this.hasHeadIconBubbleInfo;
        }

        public boolean hasHeadResultMsg() {
            return this.hasHeadResultMsg;
        }

        public boolean hasHeadway() {
            return this.hasHeadway;
        }

        public boolean hasHeatMap() {
            return this.hasHeatMap;
        }

        public boolean hasHistoryAddress() {
            return this.hasHistoryAddress;
        }

        public boolean hasHorizonSlideData() {
            return this.hasHorizonSlideData;
        }

        public boolean hasHwBrowseRecords() {
            return this.hasHwBrowseRecords;
        }

        public boolean hasIconId() {
            return this.hasIconId;
        }

        public boolean hasIndoorFloor() {
            return this.hasIndoorFloor;
        }

        public boolean hasIndoorGeoz() {
            return this.hasIndoorGeoz;
        }

        public boolean hasIndoorOverLooking() {
            return this.hasIndoorOverLooking;
        }

        public boolean hasIndoorPano() {
            return this.hasIndoorPano;
        }

        public boolean hasIndoorParentUid() {
            return this.hasIndoorParentUid;
        }

        public boolean hasInfDynRequest() {
            return this.hasInfDynRequest;
        }

        public boolean hasInterventTips() {
            return this.hasInterventTips;
        }

        public boolean hasIsmodified() {
            return this.hasIsmodified;
        }

        public boolean hasKindtype() {
            return this.hasKindtype;
        }

        public boolean hasListShow() {
            return this.hasListShow;
        }

        public boolean hasMapPoitag() {
            return this.hasMapPoitag;
        }

        public boolean hasMaxShowLevel() {
            return this.hasMaxShowLevel;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasNewCatalogId() {
            return this.hasNewCatalogId;
        }

        public boolean hasNewsgeo() {
            return this.hasNewsgeo;
        }

        public boolean hasPano() {
            return this.hasPano;
        }

        public boolean hasPhotoList() {
            return this.hasPhotoList;
        }

        public boolean hasPoiChildText() {
            return this.hasPoiChildText;
        }

        public boolean hasPoiRegionType() {
            return this.hasPoiRegionType;
        }

        public boolean hasPoiSimilar() {
            return this.hasPoiSimilar;
        }

        public boolean hasPoiType() {
            return this.hasPoiType;
        }

        public boolean hasPoiTypeText() {
            return this.hasPoiTypeText;
        }

        public boolean hasProvince() {
            return this.hasProvince;
        }

        public boolean hasQueryGuide() {
            return this.hasQueryGuide;
        }

        public boolean hasRank() {
            return this.hasRank;
        }

        public boolean hasRecommendType() {
            return this.hasRecommendType;
        }

        public boolean hasRegionType() {
            return this.hasRegionType;
        }

        public boolean hasRtbusUpdateTime() {
            return this.hasRtbusUpdateTime;
        }

        public boolean hasServiceTag() {
            return this.hasServiceTag;
        }

        public boolean hasSgeo() {
            return this.hasSgeo;
        }

        public boolean hasShow() {
            return this.hasShow;
        }

        public boolean hasShowLevel() {
            return this.hasShowLevel;
        }

        public boolean hasStartTime() {
            return this.hasStartTime;
        }

        public boolean hasStdTag() {
            return this.hasStdTag;
        }

        public boolean hasStdTagId() {
            return this.hasStdTagId;
        }

        public boolean hasTag() {
            return this.hasTag;
        }

        public boolean hasTel() {
            return this.hasTel;
        }

        public boolean hasThirdParty() {
            return this.hasThirdParty;
        }

        public boolean hasTipRtbus() {
            return this.hasTipRtbus;
        }

        public boolean hasTravelButton() {
            return this.hasTravelButton;
        }

        public boolean hasUid() {
            return this.hasUid;
        }

        public boolean hasViewType() {
            return this.hasViewType;
        }

        public boolean hasVuiProcessData() {
            return this.hasVuiProcessData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Contents mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        setGeo(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        break;
                    case 26:
                        setUid(codedInputStreamMicro.readString());
                        break;
                    case 32:
                        setAccFlag(codedInputStreamMicro.readInt32());
                        break;
                    case 42:
                        setAddr(codedInputStreamMicro.readString());
                        break;
                    case 48:
                        setDetail(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        addRecReason(codedInputStreamMicro.readString());
                        break;
                    case 66:
                        setTel(codedInputStreamMicro.readString());
                        break;
                    case 72:
                        setPoiType(codedInputStreamMicro.readInt32());
                        break;
                    case 80:
                        setPano(codedInputStreamMicro.readInt32());
                        break;
                    case 90:
                        setIndoorPano(codedInputStreamMicro.readString());
                        break;
                    case 98:
                        setAoi(codedInputStreamMicro.readString());
                        break;
                    case 106:
                        Show show = new Show();
                        codedInputStreamMicro.readMessage(show);
                        setShow(show);
                        break;
                    case 114:
                        Ext ext = new Ext();
                        codedInputStreamMicro.readMessage(ext);
                        setExt(ext);
                        break;
                    case 122:
                        setStartTime(codedInputStreamMicro.readString());
                        break;
                    case 130:
                        setEndTime(codedInputStreamMicro.readString());
                        break;
                    case 136:
                        setHasRtbus(codedInputStreamMicro.readInt32());
                        break;
                    case 146:
                        setTipRtbus(codedInputStreamMicro.readString());
                        break;
                    case 152:
                        setRtbusUpdateTime(codedInputStreamMicro.readInt32());
                        break;
                    case 160:
                        setFatherSon(codedInputStreamMicro.readInt32());
                        break;
                    case 170:
                        Sgeo sgeo = new Sgeo();
                        codedInputStreamMicro.readMessage(sgeo);
                        setSgeo(sgeo);
                        break;
                    case 178:
                        setPoiTypeText(codedInputStreamMicro.readString());
                        break;
                    case 186:
                        HeatMap heatMap = new HeatMap();
                        codedInputStreamMicro.readMessage(heatMap);
                        setHeatMap(heatMap);
                        break;
                    case 194:
                        setChildCatalog(codedInputStreamMicro.readString());
                        break;
                    case 202:
                        setPoiChildText(codedInputStreamMicro.readString());
                        break;
                    case 210:
                        setNewCatalogId(codedInputStreamMicro.readString());
                        break;
                    case 216:
                        setViewType(codedInputStreamMicro.readInt32());
                        break;
                    case 224:
                        setListShow(codedInputStreamMicro.readInt32());
                        break;
                    case 232:
                        setShowLevel(codedInputStreamMicro.readInt32());
                        break;
                    case 240:
                        setIconId(codedInputStreamMicro.readInt32());
                        break;
                    case 248:
                        setKindtype(codedInputStreamMicro.readInt32());
                        break;
                    case 256:
                        setBrandIconId(codedInputStreamMicro.readInt32());
                        break;
                    case 264:
                        setTag(codedInputStreamMicro.readInt32());
                        break;
                    case 272:
                        setRank(codedInputStreamMicro.readInt32());
                        break;
                    case 280:
                        setMaxShowLevel(codedInputStreamMicro.readInt32());
                        break;
                    case 290:
                        setIndoorFloor(codedInputStreamMicro.readString());
                        break;
                    case 298:
                        setIndoorParentUid(codedInputStreamMicro.readString());
                        break;
                    case 306:
                        setCloudTemplate(codedInputStreamMicro.readBytes());
                        break;
                    case 314:
                        Button button = new Button();
                        codedInputStreamMicro.readMessage(button);
                        setButton(button);
                        break;
                    case X0xOO.f13558IXX /* 322 */:
                        MapPoitag mapPoitag = new MapPoitag();
                        codedInputStreamMicro.readMessage(mapPoitag);
                        setMapPoitag(mapPoitag);
                        break;
                    case 330:
                        setBarTemplate(codedInputStreamMicro.readBytes());
                        break;
                    case 336:
                        setIsmodified(codedInputStreamMicro.readInt32());
                        break;
                    case IXXIXx00I.f11690IoXIXo /* 346 */:
                        setHeadway(codedInputStreamMicro.readString());
                        break;
                    case 354:
                        setInterventTips(codedInputStreamMicro.readString());
                        break;
                    case 362:
                        setPoiRegionType(codedInputStreamMicro.readString());
                        break;
                    case IXXIXx00I.f11791xxOXOOoIX /* 370 */:
                        setRegionType(codedInputStreamMicro.readString());
                        break;
                    case 386:
                        setDistance(codedInputStreamMicro.readString());
                        break;
                    case 394:
                        setStdTag(codedInputStreamMicro.readString());
                        break;
                    case 402:
                        setServiceTag(codedInputStreamMicro.readString());
                        break;
                    case 410:
                        setAreaName(codedInputStreamMicro.readString());
                        break;
                    case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                        setPhotoList(codedInputStreamMicro.readString());
                        break;
                    case 426:
                        HeadIcon headIcon = new HeadIcon();
                        codedInputStreamMicro.readMessage(headIcon);
                        setHeadIcon(headIcon);
                        break;
                    case ah.s /* 432 */:
                        setIndoorOverLooking(codedInputStreamMicro.readInt32());
                        break;
                    case ah.t /* 442 */:
                        setStdTagId(codedInputStreamMicro.readString());
                        break;
                    case 450:
                        VuiProcessData vuiProcessData = new VuiProcessData();
                        codedInputStreamMicro.readMessage(vuiProcessData);
                        setVuiProcessData(vuiProcessData);
                        break;
                    case FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED /* 458 */:
                        Sgeo sgeo2 = new Sgeo();
                        codedInputStreamMicro.readMessage(sgeo2);
                        setNewsgeo(sgeo2);
                        break;
                    case 464:
                        setAttachedAddr(codedInputStreamMicro.readInt32());
                        break;
                    case OxXXx0X.f13158oI0IIXIo /* 474 */:
                        setCity(codedInputStreamMicro.readString());
                        break;
                    case 482:
                        setProvince(codedInputStreamMicro.readString());
                        break;
                    case 488:
                        setRecommendType(codedInputStreamMicro.readInt32());
                        break;
                    case ah.v /* 496 */:
                        setDetailDisplayType(codedInputStreamMicro.readInt32());
                        break;
                    case 506:
                        setQueryGuide(codedInputStreamMicro.readString());
                        break;
                    case 512:
                        setIndoorGeoz(codedInputStreamMicro.readInt32());
                        break;
                    case DfuConstants.PROGRESS_HAND_OVER_PROCESSING /* 522 */:
                        PoiSimilar poiSimilar = new PoiSimilar();
                        codedInputStreamMicro.readMessage(poiSimilar);
                        setPoiSimilar(poiSimilar);
                        break;
                    case 530:
                        setAvocadoForwardParam(codedInputStreamMicro.readString());
                        break;
                    case 538:
                        setHorizonSlideData(codedInputStreamMicro.readString());
                        break;
                    case 546:
                        setBuriedPoint(codedInputStreamMicro.readString());
                        break;
                    case 552:
                        setInfDynRequest(codedInputStreamMicro.readInt32());
                        break;
                    case 560:
                        setHalfKill(codedInputStreamMicro.readBool());
                        break;
                    case 570:
                        HeadIconBubbleInfo headIconBubbleInfo = new HeadIconBubbleInfo();
                        codedInputStreamMicro.readMessage(headIconBubbleInfo);
                        setHeadIconBubbleInfo(headIconBubbleInfo);
                        break;
                    case 578:
                        ThirdParty thirdParty = new ThirdParty();
                        codedInputStreamMicro.readMessage(thirdParty);
                        setThirdParty(thirdParty);
                        break;
                    case 586:
                        setHeadResultMsg(codedInputStreamMicro.readBytes());
                        break;
                    case 594:
                        StartPageData startPageData = new StartPageData();
                        codedInputStreamMicro.readMessage(startPageData);
                        setHwBrowseRecords(startPageData);
                        break;
                    case 602:
                        BarButton barButton = new BarButton();
                        codedInputStreamMicro.readMessage(barButton);
                        addBarButton(barButton);
                        break;
                    case 610:
                        TravelButton travelButton = new TravelButton();
                        codedInputStreamMicro.readMessage(travelButton);
                        setTravelButton(travelButton);
                        break;
                    case 616:
                        setCardType(codedInputStreamMicro.readInt32());
                        break;
                    case 626:
                        AdvertiseInfo advertiseInfo = new AdvertiseInfo();
                        codedInputStreamMicro.readMessage(advertiseInfo);
                        setAdvertiseInfo(advertiseInfo);
                        break;
                    case 632:
                        setFourStateSwitch(codedInputStreamMicro.readInt32());
                        break;
                    case 642:
                        AdsData adsData = new AdsData();
                        codedInputStreamMicro.readMessage(adsData);
                        setAdsData(adsData);
                        break;
                    case 650:
                        setHistoryAddress(codedInputStreamMicro.readString());
                        break;
                    case 656:
                        setFavNum(codedInputStreamMicro.readInt32());
                        break;
                    case TTAdConstant.STYLE_SIZE_RADIO_2_3 /* 666 */:
                        AispaceAds aispaceAds = new AispaceAds();
                        codedInputStreamMicro.readMessage(aispaceAds);
                        setAispaceAds(aispaceAds);
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public Contents setAccFlag(int i) {
            this.hasAccFlag = true;
            this.accFlag_ = i;
            return this;
        }

        public Contents setAddr(String str) {
            this.hasAddr = true;
            this.addr_ = str;
            return this;
        }

        public Contents setAdsData(AdsData adsData) {
            if (adsData == null) {
                return clearAdsData();
            }
            this.hasAdsData = true;
            this.adsData_ = adsData;
            return this;
        }

        public Contents setAdvertiseInfo(AdvertiseInfo advertiseInfo) {
            if (advertiseInfo == null) {
                return clearAdvertiseInfo();
            }
            this.hasAdvertiseInfo = true;
            this.advertiseInfo_ = advertiseInfo;
            return this;
        }

        public Contents setAispaceAds(AispaceAds aispaceAds) {
            if (aispaceAds == null) {
                return clearAispaceAds();
            }
            this.hasAispaceAds = true;
            this.aispaceAds_ = aispaceAds;
            return this;
        }

        public Contents setAoi(String str) {
            this.hasAoi = true;
            this.aoi_ = str;
            return this;
        }

        public Contents setAreaName(String str) {
            this.hasAreaName = true;
            this.areaName_ = str;
            return this;
        }

        public Contents setAttachedAddr(int i) {
            this.hasAttachedAddr = true;
            this.attachedAddr_ = i;
            return this;
        }

        public Contents setAvocadoForwardParam(String str) {
            this.hasAvocadoForwardParam = true;
            this.avocadoForwardParam_ = str;
            return this;
        }

        public Contents setBarButton(int i, BarButton barButton) {
            if (barButton == null) {
                return this;
            }
            this.barButton_.set(i, barButton);
            return this;
        }

        public Contents setBarTemplate(ByteStringMicro byteStringMicro) {
            this.hasBarTemplate = true;
            this.barTemplate_ = byteStringMicro;
            return this;
        }

        public Contents setBrandIconId(int i) {
            this.hasBrandIconId = true;
            this.brandIconId_ = i;
            return this;
        }

        public Contents setBuriedPoint(String str) {
            this.hasBuriedPoint = true;
            this.buriedPoint_ = str;
            return this;
        }

        public Contents setButton(Button button) {
            if (button == null) {
                return clearButton();
            }
            this.hasButton = true;
            this.button_ = button;
            return this;
        }

        public Contents setCardType(int i) {
            this.hasCardType = true;
            this.cardType_ = i;
            return this;
        }

        public Contents setChildCatalog(String str) {
            this.hasChildCatalog = true;
            this.childCatalog_ = str;
            return this;
        }

        public Contents setCity(String str) {
            this.hasCity = true;
            this.city_ = str;
            return this;
        }

        public Contents setCloudTemplate(ByteStringMicro byteStringMicro) {
            this.hasCloudTemplate = true;
            this.cloudTemplate_ = byteStringMicro;
            return this;
        }

        public Contents setDetail(int i) {
            this.hasDetail = true;
            this.detail_ = i;
            return this;
        }

        public Contents setDetailDisplayType(int i) {
            this.hasDetailDisplayType = true;
            this.detailDisplayType_ = i;
            return this;
        }

        public Contents setDistance(String str) {
            this.hasDistance = true;
            this.distance_ = str;
            return this;
        }

        public Contents setEndTime(String str) {
            this.hasEndTime = true;
            this.endTime_ = str;
            return this;
        }

        public Contents setExt(Ext ext) {
            if (ext == null) {
                return clearExt();
            }
            this.hasExt = true;
            this.ext_ = ext;
            return this;
        }

        public Contents setFatherSon(int i) {
            this.hasFatherSon = true;
            this.fatherSon_ = i;
            return this;
        }

        public Contents setFavNum(int i) {
            this.hasFavNum = true;
            this.favNum_ = i;
            return this;
        }

        public Contents setFourStateSwitch(int i) {
            this.hasFourStateSwitch = true;
            this.fourStateSwitch_ = i;
            return this;
        }

        public Contents setGeo(String str) {
            this.hasGeo = true;
            this.geo_ = str;
            return this;
        }

        public Contents setHalfKill(boolean z) {
            this.hasHalfKill = true;
            this.halfKill_ = z;
            return this;
        }

        public Contents setHasRtbus(int i) {
            this.hasHasRtbus = true;
            this.hasRtbus_ = i;
            return this;
        }

        public Contents setHeadIcon(HeadIcon headIcon) {
            if (headIcon == null) {
                return clearHeadIcon();
            }
            this.hasHeadIcon = true;
            this.headIcon_ = headIcon;
            return this;
        }

        public Contents setHeadIconBubbleInfo(HeadIconBubbleInfo headIconBubbleInfo) {
            if (headIconBubbleInfo == null) {
                return clearHeadIconBubbleInfo();
            }
            this.hasHeadIconBubbleInfo = true;
            this.headIconBubbleInfo_ = headIconBubbleInfo;
            return this;
        }

        public Contents setHeadResultMsg(ByteStringMicro byteStringMicro) {
            this.hasHeadResultMsg = true;
            this.headResultMsg_ = byteStringMicro;
            return this;
        }

        public Contents setHeadway(String str) {
            this.hasHeadway = true;
            this.headway_ = str;
            return this;
        }

        public Contents setHeatMap(HeatMap heatMap) {
            if (heatMap == null) {
                return clearHeatMap();
            }
            this.hasHeatMap = true;
            this.heatMap_ = heatMap;
            return this;
        }

        public Contents setHistoryAddress(String str) {
            this.hasHistoryAddress = true;
            this.historyAddress_ = str;
            return this;
        }

        public Contents setHorizonSlideData(String str) {
            this.hasHorizonSlideData = true;
            this.horizonSlideData_ = str;
            return this;
        }

        public Contents setHwBrowseRecords(StartPageData startPageData) {
            if (startPageData == null) {
                return clearHwBrowseRecords();
            }
            this.hasHwBrowseRecords = true;
            this.hwBrowseRecords_ = startPageData;
            return this;
        }

        public Contents setIconId(int i) {
            this.hasIconId = true;
            this.iconId_ = i;
            return this;
        }

        public Contents setIndoorFloor(String str) {
            this.hasIndoorFloor = true;
            this.indoorFloor_ = str;
            return this;
        }

        public Contents setIndoorGeoz(int i) {
            this.hasIndoorGeoz = true;
            this.indoorGeoz_ = i;
            return this;
        }

        public Contents setIndoorOverLooking(int i) {
            this.hasIndoorOverLooking = true;
            this.indoorOverLooking_ = i;
            return this;
        }

        public Contents setIndoorPano(String str) {
            this.hasIndoorPano = true;
            this.indoorPano_ = str;
            return this;
        }

        public Contents setIndoorParentUid(String str) {
            this.hasIndoorParentUid = true;
            this.indoorParentUid_ = str;
            return this;
        }

        public Contents setInfDynRequest(int i) {
            this.hasInfDynRequest = true;
            this.infDynRequest_ = i;
            return this;
        }

        public Contents setInterventTips(String str) {
            this.hasInterventTips = true;
            this.interventTips_ = str;
            return this;
        }

        public Contents setIsmodified(int i) {
            this.hasIsmodified = true;
            this.ismodified_ = i;
            return this;
        }

        public Contents setKindtype(int i) {
            this.hasKindtype = true;
            this.kindtype_ = i;
            return this;
        }

        public Contents setListShow(int i) {
            this.hasListShow = true;
            this.listShow_ = i;
            return this;
        }

        public Contents setMapPoitag(MapPoitag mapPoitag) {
            if (mapPoitag == null) {
                return clearMapPoitag();
            }
            this.hasMapPoitag = true;
            this.mapPoitag_ = mapPoitag;
            return this;
        }

        public Contents setMaxShowLevel(int i) {
            this.hasMaxShowLevel = true;
            this.maxShowLevel_ = i;
            return this;
        }

        public Contents setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public Contents setNewCatalogId(String str) {
            this.hasNewCatalogId = true;
            this.newCatalogId_ = str;
            return this;
        }

        public Contents setNewsgeo(Sgeo sgeo) {
            if (sgeo == null) {
                return clearNewsgeo();
            }
            this.hasNewsgeo = true;
            this.newsgeo_ = sgeo;
            return this;
        }

        public Contents setPano(int i) {
            this.hasPano = true;
            this.pano_ = i;
            return this;
        }

        public Contents setPhotoList(String str) {
            this.hasPhotoList = true;
            this.photoList_ = str;
            return this;
        }

        public Contents setPoiChildText(String str) {
            this.hasPoiChildText = true;
            this.poiChildText_ = str;
            return this;
        }

        public Contents setPoiRegionType(String str) {
            this.hasPoiRegionType = true;
            this.poiRegionType_ = str;
            return this;
        }

        public Contents setPoiSimilar(PoiSimilar poiSimilar) {
            if (poiSimilar == null) {
                return clearPoiSimilar();
            }
            this.hasPoiSimilar = true;
            this.poiSimilar_ = poiSimilar;
            return this;
        }

        public Contents setPoiType(int i) {
            this.hasPoiType = true;
            this.poiType_ = i;
            return this;
        }

        public Contents setPoiTypeText(String str) {
            this.hasPoiTypeText = true;
            this.poiTypeText_ = str;
            return this;
        }

        public Contents setProvince(String str) {
            this.hasProvince = true;
            this.province_ = str;
            return this;
        }

        public Contents setQueryGuide(String str) {
            this.hasQueryGuide = true;
            this.queryGuide_ = str;
            return this;
        }

        public Contents setRank(int i) {
            this.hasRank = true;
            this.rank_ = i;
            return this;
        }

        public Contents setRecReason(int i, String str) {
            str.getClass();
            this.recReason_.set(i, str);
            return this;
        }

        public Contents setRecommendType(int i) {
            this.hasRecommendType = true;
            this.recommendType_ = i;
            return this;
        }

        public Contents setRegionType(String str) {
            this.hasRegionType = true;
            this.regionType_ = str;
            return this;
        }

        public Contents setRtbusUpdateTime(int i) {
            this.hasRtbusUpdateTime = true;
            this.rtbusUpdateTime_ = i;
            return this;
        }

        public Contents setServiceTag(String str) {
            this.hasServiceTag = true;
            this.serviceTag_ = str;
            return this;
        }

        public Contents setSgeo(Sgeo sgeo) {
            if (sgeo == null) {
                return clearSgeo();
            }
            this.hasSgeo = true;
            this.sgeo_ = sgeo;
            return this;
        }

        public Contents setShow(Show show) {
            if (show == null) {
                return clearShow();
            }
            this.hasShow = true;
            this.show_ = show;
            return this;
        }

        public Contents setShowLevel(int i) {
            this.hasShowLevel = true;
            this.showLevel_ = i;
            return this;
        }

        public Contents setStartTime(String str) {
            this.hasStartTime = true;
            this.startTime_ = str;
            return this;
        }

        public Contents setStdTag(String str) {
            this.hasStdTag = true;
            this.stdTag_ = str;
            return this;
        }

        public Contents setStdTagId(String str) {
            this.hasStdTagId = true;
            this.stdTagId_ = str;
            return this;
        }

        public Contents setTag(int i) {
            this.hasTag = true;
            this.tag_ = i;
            return this;
        }

        public Contents setTel(String str) {
            this.hasTel = true;
            this.tel_ = str;
            return this;
        }

        public Contents setThirdParty(ThirdParty thirdParty) {
            if (thirdParty == null) {
                return clearThirdParty();
            }
            this.hasThirdParty = true;
            this.thirdParty_ = thirdParty;
            return this;
        }

        public Contents setTipRtbus(String str) {
            this.hasTipRtbus = true;
            this.tipRtbus_ = str;
            return this;
        }

        public Contents setTravelButton(TravelButton travelButton) {
            if (travelButton == null) {
                return clearTravelButton();
            }
            this.hasTravelButton = true;
            this.travelButton_ = travelButton;
            return this;
        }

        public Contents setUid(String str) {
            this.hasUid = true;
            this.uid_ = str;
            return this;
        }

        public Contents setViewType(int i) {
            this.hasViewType = true;
            this.viewType_ = i;
            return this;
        }

        public Contents setVuiProcessData(VuiProcessData vuiProcessData) {
            if (vuiProcessData == null) {
                return clearVuiProcessData();
            }
            this.hasVuiProcessData = true;
            this.vuiProcessData_ = vuiProcessData;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasGeo()) {
                codedOutputStreamMicro.writeString(1, getGeo());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(3, getUid());
            }
            if (hasAccFlag()) {
                codedOutputStreamMicro.writeInt32(4, getAccFlag());
            }
            if (hasAddr()) {
                codedOutputStreamMicro.writeString(5, getAddr());
            }
            if (hasDetail()) {
                codedOutputStreamMicro.writeInt32(6, getDetail());
            }
            Iterator<String> it = getRecReasonList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeString(7, it.next());
            }
            if (hasTel()) {
                codedOutputStreamMicro.writeString(8, getTel());
            }
            if (hasPoiType()) {
                codedOutputStreamMicro.writeInt32(9, getPoiType());
            }
            if (hasPano()) {
                codedOutputStreamMicro.writeInt32(10, getPano());
            }
            if (hasIndoorPano()) {
                codedOutputStreamMicro.writeString(11, getIndoorPano());
            }
            if (hasAoi()) {
                codedOutputStreamMicro.writeString(12, getAoi());
            }
            if (hasShow()) {
                codedOutputStreamMicro.writeMessage(13, getShow());
            }
            if (hasExt()) {
                codedOutputStreamMicro.writeMessage(14, getExt());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(15, getStartTime());
            }
            if (hasEndTime()) {
                codedOutputStreamMicro.writeString(16, getEndTime());
            }
            if (hasHasRtbus()) {
                codedOutputStreamMicro.writeInt32(17, getHasRtbus());
            }
            if (hasTipRtbus()) {
                codedOutputStreamMicro.writeString(18, getTipRtbus());
            }
            if (hasRtbusUpdateTime()) {
                codedOutputStreamMicro.writeInt32(19, getRtbusUpdateTime());
            }
            if (hasFatherSon()) {
                codedOutputStreamMicro.writeInt32(20, getFatherSon());
            }
            if (hasSgeo()) {
                codedOutputStreamMicro.writeMessage(21, getSgeo());
            }
            if (hasPoiTypeText()) {
                codedOutputStreamMicro.writeString(22, getPoiTypeText());
            }
            if (hasHeatMap()) {
                codedOutputStreamMicro.writeMessage(23, getHeatMap());
            }
            if (hasChildCatalog()) {
                codedOutputStreamMicro.writeString(24, getChildCatalog());
            }
            if (hasPoiChildText()) {
                codedOutputStreamMicro.writeString(25, getPoiChildText());
            }
            if (hasNewCatalogId()) {
                codedOutputStreamMicro.writeString(26, getNewCatalogId());
            }
            if (hasViewType()) {
                codedOutputStreamMicro.writeInt32(27, getViewType());
            }
            if (hasListShow()) {
                codedOutputStreamMicro.writeInt32(28, getListShow());
            }
            if (hasShowLevel()) {
                codedOutputStreamMicro.writeInt32(29, getShowLevel());
            }
            if (hasIconId()) {
                codedOutputStreamMicro.writeInt32(30, getIconId());
            }
            if (hasKindtype()) {
                codedOutputStreamMicro.writeInt32(31, getKindtype());
            }
            if (hasBrandIconId()) {
                codedOutputStreamMicro.writeInt32(32, getBrandIconId());
            }
            if (hasTag()) {
                codedOutputStreamMicro.writeInt32(33, getTag());
            }
            if (hasRank()) {
                codedOutputStreamMicro.writeInt32(34, getRank());
            }
            if (hasMaxShowLevel()) {
                codedOutputStreamMicro.writeInt32(35, getMaxShowLevel());
            }
            if (hasIndoorFloor()) {
                codedOutputStreamMicro.writeString(36, getIndoorFloor());
            }
            if (hasIndoorParentUid()) {
                codedOutputStreamMicro.writeString(37, getIndoorParentUid());
            }
            if (hasCloudTemplate()) {
                codedOutputStreamMicro.writeBytes(38, getCloudTemplate());
            }
            if (hasButton()) {
                codedOutputStreamMicro.writeMessage(39, getButton());
            }
            if (hasMapPoitag()) {
                codedOutputStreamMicro.writeMessage(40, getMapPoitag());
            }
            if (hasBarTemplate()) {
                codedOutputStreamMicro.writeBytes(41, getBarTemplate());
            }
            if (hasIsmodified()) {
                codedOutputStreamMicro.writeInt32(42, getIsmodified());
            }
            if (hasHeadway()) {
                codedOutputStreamMicro.writeString(43, getHeadway());
            }
            if (hasInterventTips()) {
                codedOutputStreamMicro.writeString(44, getInterventTips());
            }
            if (hasPoiRegionType()) {
                codedOutputStreamMicro.writeString(45, getPoiRegionType());
            }
            if (hasRegionType()) {
                codedOutputStreamMicro.writeString(46, getRegionType());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(48, getDistance());
            }
            if (hasStdTag()) {
                codedOutputStreamMicro.writeString(49, getStdTag());
            }
            if (hasServiceTag()) {
                codedOutputStreamMicro.writeString(50, getServiceTag());
            }
            if (hasAreaName()) {
                codedOutputStreamMicro.writeString(51, getAreaName());
            }
            if (hasPhotoList()) {
                codedOutputStreamMicro.writeString(52, getPhotoList());
            }
            if (hasHeadIcon()) {
                codedOutputStreamMicro.writeMessage(53, getHeadIcon());
            }
            if (hasIndoorOverLooking()) {
                codedOutputStreamMicro.writeInt32(54, getIndoorOverLooking());
            }
            if (hasStdTagId()) {
                codedOutputStreamMicro.writeString(55, getStdTagId());
            }
            if (hasVuiProcessData()) {
                codedOutputStreamMicro.writeMessage(56, getVuiProcessData());
            }
            if (hasNewsgeo()) {
                codedOutputStreamMicro.writeMessage(57, getNewsgeo());
            }
            if (hasAttachedAddr()) {
                codedOutputStreamMicro.writeInt32(58, getAttachedAddr());
            }
            if (hasCity()) {
                codedOutputStreamMicro.writeString(59, getCity());
            }
            if (hasProvince()) {
                codedOutputStreamMicro.writeString(60, getProvince());
            }
            if (hasRecommendType()) {
                codedOutputStreamMicro.writeInt32(61, getRecommendType());
            }
            if (hasDetailDisplayType()) {
                codedOutputStreamMicro.writeInt32(62, getDetailDisplayType());
            }
            if (hasQueryGuide()) {
                codedOutputStreamMicro.writeString(63, getQueryGuide());
            }
            if (hasIndoorGeoz()) {
                codedOutputStreamMicro.writeInt32(64, getIndoorGeoz());
            }
            if (hasPoiSimilar()) {
                codedOutputStreamMicro.writeMessage(65, getPoiSimilar());
            }
            if (hasAvocadoForwardParam()) {
                codedOutputStreamMicro.writeString(66, getAvocadoForwardParam());
            }
            if (hasHorizonSlideData()) {
                codedOutputStreamMicro.writeString(67, getHorizonSlideData());
            }
            if (hasBuriedPoint()) {
                codedOutputStreamMicro.writeString(68, getBuriedPoint());
            }
            if (hasInfDynRequest()) {
                codedOutputStreamMicro.writeInt32(69, getInfDynRequest());
            }
            if (hasHalfKill()) {
                codedOutputStreamMicro.writeBool(70, getHalfKill());
            }
            if (hasHeadIconBubbleInfo()) {
                codedOutputStreamMicro.writeMessage(71, getHeadIconBubbleInfo());
            }
            if (hasThirdParty()) {
                codedOutputStreamMicro.writeMessage(72, getThirdParty());
            }
            if (hasHeadResultMsg()) {
                codedOutputStreamMicro.writeBytes(73, getHeadResultMsg());
            }
            if (hasHwBrowseRecords()) {
                codedOutputStreamMicro.writeMessage(74, getHwBrowseRecords());
            }
            Iterator<BarButton> it2 = getBarButtonList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeMessage(75, it2.next());
            }
            if (hasTravelButton()) {
                codedOutputStreamMicro.writeMessage(76, getTravelButton());
            }
            if (hasCardType()) {
                codedOutputStreamMicro.writeInt32(77, getCardType());
            }
            if (hasAdvertiseInfo()) {
                codedOutputStreamMicro.writeMessage(78, getAdvertiseInfo());
            }
            if (hasFourStateSwitch()) {
                codedOutputStreamMicro.writeInt32(79, getFourStateSwitch());
            }
            if (hasAdsData()) {
                codedOutputStreamMicro.writeMessage(80, getAdsData());
            }
            if (hasHistoryAddress()) {
                codedOutputStreamMicro.writeString(81, getHistoryAddress());
            }
            if (hasFavNum()) {
                codedOutputStreamMicro.writeInt32(82, getFavNum());
            }
            if (hasAispaceAds()) {
                codedOutputStreamMicro.writeMessage(83, getAispaceAds());
            }
        }

        public static Contents parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Contents) new Contents().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class CorrectionInfo extends MessageMicro {
        public static final int ASSIST_INFO_FIELD_NUMBER = 2;
        public static final int CORRECTION_QUERYS_FIELD_NUMBER = 4;
        public static final int CORRECTION_TYPE_FIELD_NUMBER = 3;
        public static final int ORI_WORD_FIELD_NUMBER = 6;
        public static final int TITLE_FIELD_NUMBER = 1;
        public static final int TITLE_H_FIELD_NUMBER = 5;
        private boolean hasAssistInfo;
        private boolean hasCorrectionType;
        private boolean hasOriWord;
        private boolean hasTitle;
        private boolean hasTitleH;
        private String title_ = "";
        private String assistInfo_ = "";
        private int correctionType_ = 0;
        private List<CorrectionQuerys> correctionQuerys_ = Collections.emptyList();
        private String titleH_ = "";
        private String oriWord_ = "";
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class CorrectionQuerys extends MessageMicro {
            public static final int QUERY_ASSIST_INFO_FIELD_NUMBER = 2;
            public static final int QUERY_FIELD_NUMBER = 1;
            public static final int QUERY_WORD_FIELD_NUMBER = 3;
            private boolean hasQuery;
            private boolean hasQueryAssistInfo;
            private boolean hasQueryWord;
            private String query_ = "";
            private String queryAssistInfo_ = "";
            private String queryWord_ = "";
            private int cachedSize = -1;

            public static CorrectionQuerys parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new CorrectionQuerys().mergeFrom(codedInputStreamMicro);
            }

            public final CorrectionQuerys clear() {
                clearQuery();
                clearQueryAssistInfo();
                clearQueryWord();
                this.cachedSize = -1;
                return this;
            }

            public CorrectionQuerys clearQuery() {
                this.hasQuery = false;
                this.query_ = "";
                return this;
            }

            public CorrectionQuerys clearQueryAssistInfo() {
                this.hasQueryAssistInfo = false;
                this.queryAssistInfo_ = "";
                return this;
            }

            public CorrectionQuerys clearQueryWord() {
                this.hasQueryWord = false;
                this.queryWord_ = "";
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

            public String getQueryAssistInfo() {
                return this.queryAssistInfo_;
            }

            public String getQueryWord() {
                return this.queryWord_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasQuery() ? CodedOutputStreamMicro.computeStringSize(1, getQuery()) : 0;
                if (hasQueryAssistInfo()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getQueryAssistInfo());
                }
                if (hasQueryWord()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getQueryWord());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public boolean hasQuery() {
                return this.hasQuery;
            }

            public boolean hasQueryAssistInfo() {
                return this.hasQueryAssistInfo;
            }

            public boolean hasQueryWord() {
                return this.hasQueryWord;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public CorrectionQuerys mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setQuery(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setQueryAssistInfo(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setQueryWord(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public CorrectionQuerys setQuery(String str) {
                this.hasQuery = true;
                this.query_ = str;
                return this;
            }

            public CorrectionQuerys setQueryAssistInfo(String str) {
                this.hasQueryAssistInfo = true;
                this.queryAssistInfo_ = str;
                return this;
            }

            public CorrectionQuerys setQueryWord(String str) {
                this.hasQueryWord = true;
                this.queryWord_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasQuery()) {
                    codedOutputStreamMicro.writeString(1, getQuery());
                }
                if (hasQueryAssistInfo()) {
                    codedOutputStreamMicro.writeString(2, getQueryAssistInfo());
                }
                if (hasQueryWord()) {
                    codedOutputStreamMicro.writeString(3, getQueryWord());
                }
            }

            public static CorrectionQuerys parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (CorrectionQuerys) new CorrectionQuerys().mergeFrom(bArr);
            }
        }

        public static CorrectionInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CorrectionInfo().mergeFrom(codedInputStreamMicro);
        }

        public CorrectionInfo addCorrectionQuerys(CorrectionQuerys correctionQuerys) {
            if (correctionQuerys == null) {
                return this;
            }
            if (this.correctionQuerys_.isEmpty()) {
                this.correctionQuerys_ = new ArrayList();
            }
            this.correctionQuerys_.add(correctionQuerys);
            return this;
        }

        public final CorrectionInfo clear() {
            clearTitle();
            clearAssistInfo();
            clearCorrectionType();
            clearCorrectionQuerys();
            clearTitleH();
            clearOriWord();
            this.cachedSize = -1;
            return this;
        }

        public CorrectionInfo clearAssistInfo() {
            this.hasAssistInfo = false;
            this.assistInfo_ = "";
            return this;
        }

        public CorrectionInfo clearCorrectionQuerys() {
            this.correctionQuerys_ = Collections.emptyList();
            return this;
        }

        public CorrectionInfo clearCorrectionType() {
            this.hasCorrectionType = false;
            this.correctionType_ = 0;
            return this;
        }

        public CorrectionInfo clearOriWord() {
            this.hasOriWord = false;
            this.oriWord_ = "";
            return this;
        }

        public CorrectionInfo clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        public CorrectionInfo clearTitleH() {
            this.hasTitleH = false;
            this.titleH_ = "";
            return this;
        }

        public String getAssistInfo() {
            return this.assistInfo_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public CorrectionQuerys getCorrectionQuerys(int i) {
            return this.correctionQuerys_.get(i);
        }

        public int getCorrectionQuerysCount() {
            return this.correctionQuerys_.size();
        }

        public List<CorrectionQuerys> getCorrectionQuerysList() {
            return this.correctionQuerys_;
        }

        public int getCorrectionType() {
            return this.correctionType_;
        }

        public String getOriWord() {
            return this.oriWord_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasTitle() ? CodedOutputStreamMicro.computeStringSize(1, getTitle()) : 0;
            if (hasAssistInfo()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getAssistInfo());
            }
            if (hasCorrectionType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getCorrectionType());
            }
            Iterator<CorrectionQuerys> it = getCorrectionQuerysList().iterator();
            while (it.hasNext()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(4, it.next());
            }
            if (hasTitleH()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getTitleH());
            }
            if (hasOriWord()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getOriWord());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public String getTitle() {
            return this.title_;
        }

        public String getTitleH() {
            return this.titleH_;
        }

        public boolean hasAssistInfo() {
            return this.hasAssistInfo;
        }

        public boolean hasCorrectionType() {
            return this.hasCorrectionType;
        }

        public boolean hasOriWord() {
            return this.hasOriWord;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public boolean hasTitleH() {
            return this.hasTitleH;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public CorrectionInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setTitle(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setAssistInfo(codedInputStreamMicro.readString());
                } else if (readTag == 24) {
                    setCorrectionType(codedInputStreamMicro.readInt32());
                } else if (readTag == 34) {
                    CorrectionQuerys correctionQuerys = new CorrectionQuerys();
                    codedInputStreamMicro.readMessage(correctionQuerys);
                    addCorrectionQuerys(correctionQuerys);
                } else if (readTag == 42) {
                    setTitleH(codedInputStreamMicro.readString());
                } else if (readTag == 50) {
                    setOriWord(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public CorrectionInfo setAssistInfo(String str) {
            this.hasAssistInfo = true;
            this.assistInfo_ = str;
            return this;
        }

        public CorrectionInfo setCorrectionQuerys(int i, CorrectionQuerys correctionQuerys) {
            if (correctionQuerys == null) {
                return this;
            }
            this.correctionQuerys_.set(i, correctionQuerys);
            return this;
        }

        public CorrectionInfo setCorrectionType(int i) {
            this.hasCorrectionType = true;
            this.correctionType_ = i;
            return this;
        }

        public CorrectionInfo setOriWord(String str) {
            this.hasOriWord = true;
            this.oriWord_ = str;
            return this;
        }

        public CorrectionInfo setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        public CorrectionInfo setTitleH(String str) {
            this.hasTitleH = true;
            this.titleH_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasAssistInfo()) {
                codedOutputStreamMicro.writeString(2, getAssistInfo());
            }
            if (hasCorrectionType()) {
                codedOutputStreamMicro.writeInt32(3, getCorrectionType());
            }
            Iterator<CorrectionQuerys> it = getCorrectionQuerysList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(4, it.next());
            }
            if (hasTitleH()) {
                codedOutputStreamMicro.writeString(5, getTitleH());
            }
            if (hasOriWord()) {
                codedOutputStreamMicro.writeString(6, getOriWord());
            }
        }

        public static CorrectionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CorrectionInfo) new CorrectionInfo().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class FloatIcon extends MessageMicro {
        public static final int ADD_TO_HOMEPAGE = 3;
        public static final int BACK = 2;
        public static final int BOTTOM_RIGHT = 2;
        public static final int CLICK_KEY_FIELD_NUMBER = 6;
        public static final int HIDE = 0;
        public static final int HIDE_WHEN_SLIDE_FIELD_NUMBER = 4;
        public static final int ICON_IMG_FIELD_NUMBER = 1;
        public static final int JUMP_INFO_FIELD_NUMBER = 3;
        public static final int PARAM_FIELD_NUMBER = 7;
        public static final int POS_FIELD_NUMBER = 2;
        public static final int SHOW_KEY_FIELD_NUMBER = 5;
        public static final int SWITCH_SLIDE_MODE = 1;
        public static final int TOP_LEFT = 1;
        public static final int URL = 0;
        private boolean hasClickKey;
        private boolean hasHideWhenSlide;
        private boolean hasIconImg;
        private boolean hasJumpInfo;
        private boolean hasParam;
        private boolean hasPos;
        private boolean hasShowKey;
        private String iconImg_ = "";
        private IconPosition pos_ = null;
        private JumpInfo jumpInfo_ = null;
        private boolean hideWhenSlide_ = false;
        private String showKey_ = "";
        private String clickKey_ = "";
        private String param_ = "";
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class IconPosition extends MessageMicro {
            public static final int LIST_HIDE_FIELD_NUMBER = 2;
            public static final int LIST_NORMAL_FIELD_NUMBER = 1;
            public static final int SLIDE_FIELD_NUMBER = 3;
            private boolean hasListHide;
            private boolean hasListNormal;
            private boolean hasSlide;
            private int listNormal_ = 0;
            private int listHide_ = 0;
            private int slide_ = 0;
            private int cachedSize = -1;

            public static IconPosition parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new IconPosition().mergeFrom(codedInputStreamMicro);
            }

            public final IconPosition clear() {
                clearListNormal();
                clearListHide();
                clearSlide();
                this.cachedSize = -1;
                return this;
            }

            public IconPosition clearListHide() {
                this.hasListHide = false;
                this.listHide_ = 0;
                return this;
            }

            public IconPosition clearListNormal() {
                this.hasListNormal = false;
                this.listNormal_ = 0;
                return this;
            }

            public IconPosition clearSlide() {
                this.hasSlide = false;
                this.slide_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getListHide() {
                return this.listHide_;
            }

            public int getListNormal() {
                return this.listNormal_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeInt32Size = hasListNormal() ? CodedOutputStreamMicro.computeInt32Size(1, getListNormal()) : 0;
                if (hasListHide()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getListHide());
                }
                if (hasSlide()) {
                    computeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getSlide());
                }
                this.cachedSize = computeInt32Size;
                return computeInt32Size;
            }

            public int getSlide() {
                return this.slide_;
            }

            public boolean hasListHide() {
                return this.hasListHide;
            }

            public boolean hasListNormal() {
                return this.hasListNormal;
            }

            public boolean hasSlide() {
                return this.hasSlide;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public IconPosition mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        setListNormal(codedInputStreamMicro.readInt32());
                    } else if (readTag == 16) {
                        setListHide(codedInputStreamMicro.readInt32());
                    } else if (readTag == 24) {
                        setSlide(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public IconPosition setListHide(int i) {
                this.hasListHide = true;
                this.listHide_ = i;
                return this;
            }

            public IconPosition setListNormal(int i) {
                this.hasListNormal = true;
                this.listNormal_ = i;
                return this;
            }

            public IconPosition setSlide(int i) {
                this.hasSlide = true;
                this.slide_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasListNormal()) {
                    codedOutputStreamMicro.writeInt32(1, getListNormal());
                }
                if (hasListHide()) {
                    codedOutputStreamMicro.writeInt32(2, getListHide());
                }
                if (hasSlide()) {
                    codedOutputStreamMicro.writeInt32(3, getSlide());
                }
            }

            public static IconPosition parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (IconPosition) new IconPosition().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class JumpInfo extends MessageMicro {
            public static final int GROUP_ID_FIELD_NUMBER = 3;
            public static final int GROUP_IMAGE_FIELD_NUMBER = 5;
            public static final int GROUP_NAME_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int URL_FIELD_NUMBER = 1;
            private boolean hasGroupId;
            private boolean hasGroupImage;
            private boolean hasGroupName;
            private boolean hasType;
            private boolean hasUrl;
            private String url_ = "";
            private int type_ = 0;
            private int groupId_ = 0;
            private String groupName_ = "";
            private String groupImage_ = "";
            private int cachedSize = -1;

            public static JumpInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new JumpInfo().mergeFrom(codedInputStreamMicro);
            }

            public final JumpInfo clear() {
                clearUrl();
                clearType();
                clearGroupId();
                clearGroupName();
                clearGroupImage();
                this.cachedSize = -1;
                return this;
            }

            public JumpInfo clearGroupId() {
                this.hasGroupId = false;
                this.groupId_ = 0;
                return this;
            }

            public JumpInfo clearGroupImage() {
                this.hasGroupImage = false;
                this.groupImage_ = "";
                return this;
            }

            public JumpInfo clearGroupName() {
                this.hasGroupName = false;
                this.groupName_ = "";
                return this;
            }

            public JumpInfo clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            public JumpInfo clearUrl() {
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

            public int getGroupId() {
                return this.groupId_;
            }

            public String getGroupImage() {
                return this.groupImage_;
            }

            public String getGroupName() {
                return this.groupName_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasUrl() ? CodedOutputStreamMicro.computeStringSize(1, getUrl()) : 0;
                if (hasType()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getType());
                }
                if (hasGroupId()) {
                    computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getGroupId());
                }
                if (hasGroupName()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getGroupName());
                }
                if (hasGroupImage()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getGroupImage());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public int getType() {
                return this.type_;
            }

            public String getUrl() {
                return this.url_;
            }

            public boolean hasGroupId() {
                return this.hasGroupId;
            }

            public boolean hasGroupImage() {
                return this.hasGroupImage;
            }

            public boolean hasGroupName() {
                return this.hasGroupName;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public boolean hasUrl() {
                return this.hasUrl;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public JumpInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setUrl(codedInputStreamMicro.readString());
                    } else if (readTag == 16) {
                        setType(codedInputStreamMicro.readInt32());
                    } else if (readTag == 24) {
                        setGroupId(codedInputStreamMicro.readInt32());
                    } else if (readTag == 34) {
                        setGroupName(codedInputStreamMicro.readString());
                    } else if (readTag == 42) {
                        setGroupImage(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public JumpInfo setGroupId(int i) {
                this.hasGroupId = true;
                this.groupId_ = i;
                return this;
            }

            public JumpInfo setGroupImage(String str) {
                this.hasGroupImage = true;
                this.groupImage_ = str;
                return this;
            }

            public JumpInfo setGroupName(String str) {
                this.hasGroupName = true;
                this.groupName_ = str;
                return this;
            }

            public JumpInfo setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            public JumpInfo setUrl(String str) {
                this.hasUrl = true;
                this.url_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUrl()) {
                    codedOutputStreamMicro.writeString(1, getUrl());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(2, getType());
                }
                if (hasGroupId()) {
                    codedOutputStreamMicro.writeInt32(3, getGroupId());
                }
                if (hasGroupName()) {
                    codedOutputStreamMicro.writeString(4, getGroupName());
                }
                if (hasGroupImage()) {
                    codedOutputStreamMicro.writeString(5, getGroupImage());
                }
            }

            public static JumpInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (JumpInfo) new JumpInfo().mergeFrom(bArr);
            }
        }

        public static FloatIcon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FloatIcon().mergeFrom(codedInputStreamMicro);
        }

        public final FloatIcon clear() {
            clearIconImg();
            clearPos();
            clearJumpInfo();
            clearHideWhenSlide();
            clearShowKey();
            clearClickKey();
            clearParam();
            this.cachedSize = -1;
            return this;
        }

        public FloatIcon clearClickKey() {
            this.hasClickKey = false;
            this.clickKey_ = "";
            return this;
        }

        public FloatIcon clearHideWhenSlide() {
            this.hasHideWhenSlide = false;
            this.hideWhenSlide_ = false;
            return this;
        }

        public FloatIcon clearIconImg() {
            this.hasIconImg = false;
            this.iconImg_ = "";
            return this;
        }

        public FloatIcon clearJumpInfo() {
            this.hasJumpInfo = false;
            this.jumpInfo_ = null;
            return this;
        }

        public FloatIcon clearParam() {
            this.hasParam = false;
            this.param_ = "";
            return this;
        }

        public FloatIcon clearPos() {
            this.hasPos = false;
            this.pos_ = null;
            return this;
        }

        public FloatIcon clearShowKey() {
            this.hasShowKey = false;
            this.showKey_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getClickKey() {
            return this.clickKey_;
        }

        public boolean getHideWhenSlide() {
            return this.hideWhenSlide_;
        }

        public String getIconImg() {
            return this.iconImg_;
        }

        public JumpInfo getJumpInfo() {
            return this.jumpInfo_;
        }

        public String getParam() {
            return this.param_;
        }

        public IconPosition getPos() {
            return this.pos_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasIconImg() ? CodedOutputStreamMicro.computeStringSize(1, getIconImg()) : 0;
            if (hasPos()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(2, getPos());
            }
            if (hasJumpInfo()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, getJumpInfo());
            }
            if (hasHideWhenSlide()) {
                computeStringSize += CodedOutputStreamMicro.computeBoolSize(4, getHideWhenSlide());
            }
            if (hasShowKey()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getShowKey());
            }
            if (hasClickKey()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getClickKey());
            }
            if (hasParam()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getParam());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public String getShowKey() {
            return this.showKey_;
        }

        public boolean hasClickKey() {
            return this.hasClickKey;
        }

        public boolean hasHideWhenSlide() {
            return this.hasHideWhenSlide;
        }

        public boolean hasIconImg() {
            return this.hasIconImg;
        }

        public boolean hasJumpInfo() {
            return this.hasJumpInfo;
        }

        public boolean hasParam() {
            return this.hasParam;
        }

        public boolean hasPos() {
            return this.hasPos;
        }

        public boolean hasShowKey() {
            return this.hasShowKey;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public FloatIcon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setIconImg(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    IconPosition iconPosition = new IconPosition();
                    codedInputStreamMicro.readMessage(iconPosition);
                    setPos(iconPosition);
                } else if (readTag == 26) {
                    JumpInfo jumpInfo = new JumpInfo();
                    codedInputStreamMicro.readMessage(jumpInfo);
                    setJumpInfo(jumpInfo);
                } else if (readTag == 32) {
                    setHideWhenSlide(codedInputStreamMicro.readBool());
                } else if (readTag == 42) {
                    setShowKey(codedInputStreamMicro.readString());
                } else if (readTag == 50) {
                    setClickKey(codedInputStreamMicro.readString());
                } else if (readTag == 58) {
                    setParam(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public FloatIcon setClickKey(String str) {
            this.hasClickKey = true;
            this.clickKey_ = str;
            return this;
        }

        public FloatIcon setHideWhenSlide(boolean z) {
            this.hasHideWhenSlide = true;
            this.hideWhenSlide_ = z;
            return this;
        }

        public FloatIcon setIconImg(String str) {
            this.hasIconImg = true;
            this.iconImg_ = str;
            return this;
        }

        public FloatIcon setJumpInfo(JumpInfo jumpInfo) {
            if (jumpInfo == null) {
                return clearJumpInfo();
            }
            this.hasJumpInfo = true;
            this.jumpInfo_ = jumpInfo;
            return this;
        }

        public FloatIcon setParam(String str) {
            this.hasParam = true;
            this.param_ = str;
            return this;
        }

        public FloatIcon setPos(IconPosition iconPosition) {
            if (iconPosition == null) {
                return clearPos();
            }
            this.hasPos = true;
            this.pos_ = iconPosition;
            return this;
        }

        public FloatIcon setShowKey(String str) {
            this.hasShowKey = true;
            this.showKey_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIconImg()) {
                codedOutputStreamMicro.writeString(1, getIconImg());
            }
            if (hasPos()) {
                codedOutputStreamMicro.writeMessage(2, getPos());
            }
            if (hasJumpInfo()) {
                codedOutputStreamMicro.writeMessage(3, getJumpInfo());
            }
            if (hasHideWhenSlide()) {
                codedOutputStreamMicro.writeBool(4, getHideWhenSlide());
            }
            if (hasShowKey()) {
                codedOutputStreamMicro.writeString(5, getShowKey());
            }
            if (hasClickKey()) {
                codedOutputStreamMicro.writeString(6, getClickKey());
            }
            if (hasParam()) {
                codedOutputStreamMicro.writeString(7, getParam());
            }
        }

        public static FloatIcon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FloatIcon) new FloatIcon().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class GuideTag extends MessageMicro {
        public static final int CAPTION_FIELD_NUMBER = 5;
        public static final int CONTENTS_FIELD_NUMBER = 3;
        public static final int GUIDE_CONTENT_FIELD_NUMBER = 6;
        public static final int LOCATION_FIELD_NUMBER = 4;
        public static final int POSITION_FIELD_NUMBER = 1;
        public static final int TITLE_FIELD_NUMBER = 2;
        private boolean hasCaption;
        private boolean hasLocation;
        private boolean hasPosition;
        private boolean hasTitle;
        private int position_ = 0;
        private String title_ = "";
        private List<String> contents_ = Collections.emptyList();
        private int location_ = 0;
        private String caption_ = "";
        private List<GuideContent> guideContent_ = Collections.emptyList();
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class GuideContent extends MessageMicro {
            public static final int ALIGNMENT_FIELD_NUMBER = 2;
            public static final int QT_FIELD_NUMBER = 3;
            public static final int TEXT_FIELD_NUMBER = 1;
            public static final int X_FIELD_NUMBER = 4;
            public static final int Y_FIELD_NUMBER = 5;
            private boolean hasAlignment;
            private boolean hasQt;
            private boolean hasText;
            private boolean hasX;
            private boolean hasY;
            private String text_ = "";
            private String alignment_ = "";
            private String qt_ = "";
            private String x_ = "";
            private String y_ = "";
            private int cachedSize = -1;

            public static GuideContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new GuideContent().mergeFrom(codedInputStreamMicro);
            }

            public final GuideContent clear() {
                clearText();
                clearAlignment();
                clearQt();
                clearX();
                clearY();
                this.cachedSize = -1;
                return this;
            }

            public GuideContent clearAlignment() {
                this.hasAlignment = false;
                this.alignment_ = "";
                return this;
            }

            public GuideContent clearQt() {
                this.hasQt = false;
                this.qt_ = "";
                return this;
            }

            public GuideContent clearText() {
                this.hasText = false;
                this.text_ = "";
                return this;
            }

            public GuideContent clearX() {
                this.hasX = false;
                this.x_ = "";
                return this;
            }

            public GuideContent clearY() {
                this.hasY = false;
                this.y_ = "";
                return this;
            }

            public String getAlignment() {
                return this.alignment_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getQt() {
                return this.qt_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasText() ? CodedOutputStreamMicro.computeStringSize(1, getText()) : 0;
                if (hasAlignment()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getAlignment());
                }
                if (hasQt()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getQt());
                }
                if (hasX()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getX());
                }
                if (hasY()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getY());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getText() {
                return this.text_;
            }

            public String getX() {
                return this.x_;
            }

            public String getY() {
                return this.y_;
            }

            public boolean hasAlignment() {
                return this.hasAlignment;
            }

            public boolean hasQt() {
                return this.hasQt;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public boolean hasX() {
                return this.hasX;
            }

            public boolean hasY() {
                return this.hasY;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public GuideContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setText(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setAlignment(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setQt(codedInputStreamMicro.readString());
                    } else if (readTag == 34) {
                        setX(codedInputStreamMicro.readString());
                    } else if (readTag == 42) {
                        setY(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public GuideContent setAlignment(String str) {
                this.hasAlignment = true;
                this.alignment_ = str;
                return this;
            }

            public GuideContent setQt(String str) {
                this.hasQt = true;
                this.qt_ = str;
                return this;
            }

            public GuideContent setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            public GuideContent setX(String str) {
                this.hasX = true;
                this.x_ = str;
                return this;
            }

            public GuideContent setY(String str) {
                this.hasY = true;
                this.y_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasText()) {
                    codedOutputStreamMicro.writeString(1, getText());
                }
                if (hasAlignment()) {
                    codedOutputStreamMicro.writeString(2, getAlignment());
                }
                if (hasQt()) {
                    codedOutputStreamMicro.writeString(3, getQt());
                }
                if (hasX()) {
                    codedOutputStreamMicro.writeString(4, getX());
                }
                if (hasY()) {
                    codedOutputStreamMicro.writeString(5, getY());
                }
            }

            public static GuideContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (GuideContent) new GuideContent().mergeFrom(bArr);
            }
        }

        public static GuideTag parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new GuideTag().mergeFrom(codedInputStreamMicro);
        }

        public GuideTag addContents(String str) {
            str.getClass();
            if (this.contents_.isEmpty()) {
                this.contents_ = new ArrayList();
            }
            this.contents_.add(str);
            return this;
        }

        public GuideTag addGuideContent(GuideContent guideContent) {
            if (guideContent == null) {
                return this;
            }
            if (this.guideContent_.isEmpty()) {
                this.guideContent_ = new ArrayList();
            }
            this.guideContent_.add(guideContent);
            return this;
        }

        public final GuideTag clear() {
            clearPosition();
            clearTitle();
            clearContents();
            clearLocation();
            clearCaption();
            clearGuideContent();
            this.cachedSize = -1;
            return this;
        }

        public GuideTag clearCaption() {
            this.hasCaption = false;
            this.caption_ = "";
            return this;
        }

        public GuideTag clearContents() {
            this.contents_ = Collections.emptyList();
            return this;
        }

        public GuideTag clearGuideContent() {
            this.guideContent_ = Collections.emptyList();
            return this;
        }

        public GuideTag clearLocation() {
            this.hasLocation = false;
            this.location_ = 0;
            return this;
        }

        public GuideTag clearPosition() {
            this.hasPosition = false;
            this.position_ = 0;
            return this;
        }

        public GuideTag clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getCaption() {
            return this.caption_;
        }

        public String getContents(int i) {
            return this.contents_.get(i);
        }

        public int getContentsCount() {
            return this.contents_.size();
        }

        public List<String> getContentsList() {
            return this.contents_;
        }

        public GuideContent getGuideContent(int i) {
            return this.guideContent_.get(i);
        }

        public int getGuideContentCount() {
            return this.guideContent_.size();
        }

        public List<GuideContent> getGuideContentList() {
            return this.guideContent_;
        }

        public int getLocation() {
            return this.location_;
        }

        public int getPosition() {
            return this.position_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasPosition() ? CodedOutputStreamMicro.computeInt32Size(1, getPosition()) : 0;
            if (hasTitle()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            Iterator<String> it = getContentsList().iterator();
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
            }
            int size = computeInt32Size + i + getContentsList().size();
            if (hasLocation()) {
                size += CodedOutputStreamMicro.computeInt32Size(4, getLocation());
            }
            if (hasCaption()) {
                size += CodedOutputStreamMicro.computeStringSize(5, getCaption());
            }
            Iterator<GuideContent> it2 = getGuideContentList().iterator();
            while (it2.hasNext()) {
                size += CodedOutputStreamMicro.computeMessageSize(6, it2.next());
            }
            this.cachedSize = size;
            return size;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasCaption() {
            return this.hasCaption;
        }

        public boolean hasLocation() {
            return this.hasLocation;
        }

        public boolean hasPosition() {
            return this.hasPosition;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public GuideTag mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setPosition(codedInputStreamMicro.readInt32());
                } else if (readTag == 18) {
                    setTitle(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    addContents(codedInputStreamMicro.readString());
                } else if (readTag == 32) {
                    setLocation(codedInputStreamMicro.readInt32());
                } else if (readTag == 42) {
                    setCaption(codedInputStreamMicro.readString());
                } else if (readTag == 50) {
                    GuideContent guideContent = new GuideContent();
                    codedInputStreamMicro.readMessage(guideContent);
                    addGuideContent(guideContent);
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public GuideTag setCaption(String str) {
            this.hasCaption = true;
            this.caption_ = str;
            return this;
        }

        public GuideTag setContents(int i, String str) {
            str.getClass();
            this.contents_.set(i, str);
            return this;
        }

        public GuideTag setGuideContent(int i, GuideContent guideContent) {
            if (guideContent == null) {
                return this;
            }
            this.guideContent_.set(i, guideContent);
            return this;
        }

        public GuideTag setLocation(int i) {
            this.hasLocation = true;
            this.location_ = i;
            return this;
        }

        public GuideTag setPosition(int i) {
            this.hasPosition = true;
            this.position_ = i;
            return this;
        }

        public GuideTag setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPosition()) {
                codedOutputStreamMicro.writeInt32(1, getPosition());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            Iterator<String> it = getContentsList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeString(3, it.next());
            }
            if (hasLocation()) {
                codedOutputStreamMicro.writeInt32(4, getLocation());
            }
            if (hasCaption()) {
                codedOutputStreamMicro.writeString(5, getCaption());
            }
            Iterator<GuideContent> it2 = getGuideContentList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeMessage(6, it2.next());
            }
        }

        public static GuideTag parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (GuideTag) new GuideTag().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class HorizonSlideResult extends MessageMicro {
        public static final int DARK_H5_TITLE_FIELD_NUMBER = 3;
        public static final int H5 = 2;
        public static final int H5_TITLE_FIELD_NUMBER = 2;
        public static final int H5_TRANS_PARAM_FIELD_NUMBER = 4;
        public static final int HEAD_DISP_TYPE_FIELD_NUMBER = 5;
        public static final int PIC = 2;
        public static final int SCENE_FIELD_NUMBER = 7;
        public static final int SEARCH = 1;
        public static final int SUPPORT_NA_LIST_FIELD_NUMBER = 6;
        public static final int TEXT = 1;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean hasDarkH5Title;
        private boolean hasH5Title;
        private boolean hasH5TransParam;
        private boolean hasHeadDispType;
        private boolean hasScene;
        private boolean hasSupportNaList;
        private boolean hasType;
        private int type_ = 1;
        private String h5Title_ = "";
        private String darkH5Title_ = "";
        private String h5TransParam_ = "";
        private int headDispType_ = 1;
        private int supportNaList_ = 0;
        private String scene_ = "";
        private int cachedSize = -1;

        public static HorizonSlideResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new HorizonSlideResult().mergeFrom(codedInputStreamMicro);
        }

        public final HorizonSlideResult clear() {
            clearType();
            clearH5Title();
            clearDarkH5Title();
            clearH5TransParam();
            clearHeadDispType();
            clearSupportNaList();
            clearScene();
            this.cachedSize = -1;
            return this;
        }

        public HorizonSlideResult clearDarkH5Title() {
            this.hasDarkH5Title = false;
            this.darkH5Title_ = "";
            return this;
        }

        public HorizonSlideResult clearH5Title() {
            this.hasH5Title = false;
            this.h5Title_ = "";
            return this;
        }

        public HorizonSlideResult clearH5TransParam() {
            this.hasH5TransParam = false;
            this.h5TransParam_ = "";
            return this;
        }

        public HorizonSlideResult clearHeadDispType() {
            this.hasHeadDispType = false;
            this.headDispType_ = 1;
            return this;
        }

        public HorizonSlideResult clearScene() {
            this.hasScene = false;
            this.scene_ = "";
            return this;
        }

        public HorizonSlideResult clearSupportNaList() {
            this.hasSupportNaList = false;
            this.supportNaList_ = 0;
            return this;
        }

        public HorizonSlideResult clearType() {
            this.hasType = false;
            this.type_ = 1;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getDarkH5Title() {
            return this.darkH5Title_;
        }

        public String getH5Title() {
            return this.h5Title_;
        }

        public String getH5TransParam() {
            return this.h5TransParam_;
        }

        public int getHeadDispType() {
            return this.headDispType_;
        }

        public String getScene() {
            return this.scene_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
            if (hasH5Title()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getH5Title());
            }
            if (hasDarkH5Title()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getDarkH5Title());
            }
            if (hasH5TransParam()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getH5TransParam());
            }
            if (hasHeadDispType()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getHeadDispType());
            }
            if (hasSupportNaList()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getSupportNaList());
            }
            if (hasScene()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(7, getScene());
            }
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
        }

        public int getSupportNaList() {
            return this.supportNaList_;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasDarkH5Title() {
            return this.hasDarkH5Title;
        }

        public boolean hasH5Title() {
            return this.hasH5Title;
        }

        public boolean hasH5TransParam() {
            return this.hasH5TransParam;
        }

        public boolean hasHeadDispType() {
            return this.hasHeadDispType;
        }

        public boolean hasScene() {
            return this.hasScene;
        }

        public boolean hasSupportNaList() {
            return this.hasSupportNaList;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public HorizonSlideResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setType(codedInputStreamMicro.readInt32());
                } else if (readTag == 18) {
                    setH5Title(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    setDarkH5Title(codedInputStreamMicro.readString());
                } else if (readTag == 34) {
                    setH5TransParam(codedInputStreamMicro.readString());
                } else if (readTag == 40) {
                    setHeadDispType(codedInputStreamMicro.readInt32());
                } else if (readTag == 48) {
                    setSupportNaList(codedInputStreamMicro.readInt32());
                } else if (readTag == 58) {
                    setScene(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public HorizonSlideResult setDarkH5Title(String str) {
            this.hasDarkH5Title = true;
            this.darkH5Title_ = str;
            return this;
        }

        public HorizonSlideResult setH5Title(String str) {
            this.hasH5Title = true;
            this.h5Title_ = str;
            return this;
        }

        public HorizonSlideResult setH5TransParam(String str) {
            this.hasH5TransParam = true;
            this.h5TransParam_ = str;
            return this;
        }

        public HorizonSlideResult setHeadDispType(int i) {
            this.hasHeadDispType = true;
            this.headDispType_ = i;
            return this;
        }

        public HorizonSlideResult setScene(String str) {
            this.hasScene = true;
            this.scene_ = str;
            return this;
        }

        public HorizonSlideResult setSupportNaList(int i) {
            this.hasSupportNaList = true;
            this.supportNaList_ = i;
            return this;
        }

        public HorizonSlideResult setType(int i) {
            this.hasType = true;
            this.type_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(1, getType());
            }
            if (hasH5Title()) {
                codedOutputStreamMicro.writeString(2, getH5Title());
            }
            if (hasDarkH5Title()) {
                codedOutputStreamMicro.writeString(3, getDarkH5Title());
            }
            if (hasH5TransParam()) {
                codedOutputStreamMicro.writeString(4, getH5TransParam());
            }
            if (hasHeadDispType()) {
                codedOutputStreamMicro.writeInt32(5, getHeadDispType());
            }
            if (hasSupportNaList()) {
                codedOutputStreamMicro.writeInt32(6, getSupportNaList());
            }
            if (hasScene()) {
                codedOutputStreamMicro.writeString(7, getScene());
            }
        }

        public static HorizonSlideResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (HorizonSlideResult) new HorizonSlideResult().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ImgBanner extends MessageMicro {
        public static final int H5_URL_FIELD_NUMBER = 2;
        public static final int IMG_URL_FIELD_NUMBER = 1;
        public static final int LOCATION_FIELD_NUMBER = 3;
        public static final int PAGE_NUM_FIELD_NUMBER = 4;
        public static final int STAT_INFO_FIELD_NUMBER = 7;
        public static final int SUB_TEXT_FIELD_NUMBER = 6;
        public static final int TEXT_FIELD_NUMBER = 5;
        private boolean hasH5Url;
        private boolean hasImgUrl;
        private boolean hasLocation;
        private boolean hasPageNum;
        private boolean hasStatInfo;
        private boolean hasSubText;
        private boolean hasText;
        private String imgUrl_ = "";
        private String h5Url_ = "";
        private int location_ = 0;
        private int pageNum_ = 0;
        private String text_ = "";
        private String subText_ = "";
        private String statInfo_ = "";
        private int cachedSize = -1;

        public static ImgBanner parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ImgBanner().mergeFrom(codedInputStreamMicro);
        }

        public final ImgBanner clear() {
            clearImgUrl();
            clearH5Url();
            clearLocation();
            clearPageNum();
            clearText();
            clearSubText();
            clearStatInfo();
            this.cachedSize = -1;
            return this;
        }

        public ImgBanner clearH5Url() {
            this.hasH5Url = false;
            this.h5Url_ = "";
            return this;
        }

        public ImgBanner clearImgUrl() {
            this.hasImgUrl = false;
            this.imgUrl_ = "";
            return this;
        }

        public ImgBanner clearLocation() {
            this.hasLocation = false;
            this.location_ = 0;
            return this;
        }

        public ImgBanner clearPageNum() {
            this.hasPageNum = false;
            this.pageNum_ = 0;
            return this;
        }

        public ImgBanner clearStatInfo() {
            this.hasStatInfo = false;
            this.statInfo_ = "";
            return this;
        }

        public ImgBanner clearSubText() {
            this.hasSubText = false;
            this.subText_ = "";
            return this;
        }

        public ImgBanner clearText() {
            this.hasText = false;
            this.text_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getH5Url() {
            return this.h5Url_;
        }

        public String getImgUrl() {
            return this.imgUrl_;
        }

        public int getLocation() {
            return this.location_;
        }

        public int getPageNum() {
            return this.pageNum_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasImgUrl() ? CodedOutputStreamMicro.computeStringSize(1, getImgUrl()) : 0;
            if (hasH5Url()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getH5Url());
            }
            if (hasLocation()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getLocation());
            }
            if (hasPageNum()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getPageNum());
            }
            if (hasText()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getText());
            }
            if (hasSubText()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getSubText());
            }
            if (hasStatInfo()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getStatInfo());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public String getStatInfo() {
            return this.statInfo_;
        }

        public String getSubText() {
            return this.subText_;
        }

        public String getText() {
            return this.text_;
        }

        public boolean hasH5Url() {
            return this.hasH5Url;
        }

        public boolean hasImgUrl() {
            return this.hasImgUrl;
        }

        public boolean hasLocation() {
            return this.hasLocation;
        }

        public boolean hasPageNum() {
            return this.hasPageNum;
        }

        public boolean hasStatInfo() {
            return this.hasStatInfo;
        }

        public boolean hasSubText() {
            return this.hasSubText;
        }

        public boolean hasText() {
            return this.hasText;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public ImgBanner mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setImgUrl(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setH5Url(codedInputStreamMicro.readString());
                } else if (readTag == 24) {
                    setLocation(codedInputStreamMicro.readInt32());
                } else if (readTag == 32) {
                    setPageNum(codedInputStreamMicro.readInt32());
                } else if (readTag == 42) {
                    setText(codedInputStreamMicro.readString());
                } else if (readTag == 50) {
                    setSubText(codedInputStreamMicro.readString());
                } else if (readTag == 58) {
                    setStatInfo(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public ImgBanner setH5Url(String str) {
            this.hasH5Url = true;
            this.h5Url_ = str;
            return this;
        }

        public ImgBanner setImgUrl(String str) {
            this.hasImgUrl = true;
            this.imgUrl_ = str;
            return this;
        }

        public ImgBanner setLocation(int i) {
            this.hasLocation = true;
            this.location_ = i;
            return this;
        }

        public ImgBanner setPageNum(int i) {
            this.hasPageNum = true;
            this.pageNum_ = i;
            return this;
        }

        public ImgBanner setStatInfo(String str) {
            this.hasStatInfo = true;
            this.statInfo_ = str;
            return this;
        }

        public ImgBanner setSubText(String str) {
            this.hasSubText = true;
            this.subText_ = str;
            return this;
        }

        public ImgBanner setText(String str) {
            this.hasText = true;
            this.text_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasImgUrl()) {
                codedOutputStreamMicro.writeString(1, getImgUrl());
            }
            if (hasH5Url()) {
                codedOutputStreamMicro.writeString(2, getH5Url());
            }
            if (hasLocation()) {
                codedOutputStreamMicro.writeInt32(3, getLocation());
            }
            if (hasPageNum()) {
                codedOutputStreamMicro.writeInt32(4, getPageNum());
            }
            if (hasText()) {
                codedOutputStreamMicro.writeString(5, getText());
            }
            if (hasSubText()) {
                codedOutputStreamMicro.writeString(6, getSubText());
            }
            if (hasStatInfo()) {
                codedOutputStreamMicro.writeString(7, getStatInfo());
            }
        }

        public static ImgBanner parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ImgBanner) new ImgBanner().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class IndusInfo extends MessageMicro {
        public static final int AD_POS_FIELD_NUMBER = 4;
        public static final int INDUS_NAME_FIELD_NUMBER = 1;
        public static final int PRIORITY_FIELD_NUMBER = 6;
        public static final int SHOW_NUM_FIELD_NUMBER = 2;
        public static final int USER_COUPON_FIELD_NUMBER = 3;
        private boolean hasAdPos;
        private boolean hasIndusName;
        private boolean hasShowNum;
        private boolean hasUserCoupon;
        private String indusName_ = "";
        private int showNum_ = 0;
        private UserCoupon userCoupon_ = null;
        private AdPos adPos_ = null;
        private List<String> priority_ = Collections.emptyList();
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class AdPos extends MessageMicro {
            public static final int POSITION_FIELD_NUMBER = 1;
            private boolean hasPosition;
            private String position_ = "";
            private int cachedSize = -1;

            public static AdPos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdPos().mergeFrom(codedInputStreamMicro);
            }

            public final AdPos clear() {
                clearPosition();
                this.cachedSize = -1;
                return this;
            }

            public AdPos clearPosition() {
                this.hasPosition = false;
                this.position_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getPosition() {
                return this.position_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasPosition() ? CodedOutputStreamMicro.computeStringSize(1, getPosition()) : 0;
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public boolean hasPosition() {
                return this.hasPosition;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AdPos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setPosition(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AdPos setPosition(String str) {
                this.hasPosition = true;
                this.position_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPosition()) {
                    codedOutputStreamMicro.writeString(1, getPosition());
                }
            }

            public static AdPos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdPos) new AdPos().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class UserCoupon extends MessageMicro {
            public static final int DESC_FIELD_NUMBER = 4;
            public static final int POSITION_FIELD_NUMBER = 3;
            public static final int PRICE_FIELD_NUMBER = 2;
            public static final int TEXT_FIELD_NUMBER = 1;
            private boolean hasDesc;
            private boolean hasPosition;
            private boolean hasPrice;
            private boolean hasText;
            private String text_ = "";
            private String price_ = "";
            private String position_ = "";
            private String desc_ = "";
            private int cachedSize = -1;

            public static UserCoupon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new UserCoupon().mergeFrom(codedInputStreamMicro);
            }

            public final UserCoupon clear() {
                clearText();
                clearPrice();
                clearPosition();
                clearDesc();
                this.cachedSize = -1;
                return this;
            }

            public UserCoupon clearDesc() {
                this.hasDesc = false;
                this.desc_ = "";
                return this;
            }

            public UserCoupon clearPosition() {
                this.hasPosition = false;
                this.position_ = "";
                return this;
            }

            public UserCoupon clearPrice() {
                this.hasPrice = false;
                this.price_ = "";
                return this;
            }

            public UserCoupon clearText() {
                this.hasText = false;
                this.text_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getDesc() {
                return this.desc_;
            }

            public String getPosition() {
                return this.position_;
            }

            public String getPrice() {
                return this.price_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasText() ? CodedOutputStreamMicro.computeStringSize(1, getText()) : 0;
                if (hasPrice()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getPrice());
                }
                if (hasPosition()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getPosition());
                }
                if (hasDesc()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getText() {
                return this.text_;
            }

            public boolean hasDesc() {
                return this.hasDesc;
            }

            public boolean hasPosition() {
                return this.hasPosition;
            }

            public boolean hasPrice() {
                return this.hasPrice;
            }

            public boolean hasText() {
                return this.hasText;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public UserCoupon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setText(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setPrice(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setPosition(codedInputStreamMicro.readString());
                    } else if (readTag == 34) {
                        setDesc(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public UserCoupon setDesc(String str) {
                this.hasDesc = true;
                this.desc_ = str;
                return this;
            }

            public UserCoupon setPosition(String str) {
                this.hasPosition = true;
                this.position_ = str;
                return this;
            }

            public UserCoupon setPrice(String str) {
                this.hasPrice = true;
                this.price_ = str;
                return this;
            }

            public UserCoupon setText(String str) {
                this.hasText = true;
                this.text_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasText()) {
                    codedOutputStreamMicro.writeString(1, getText());
                }
                if (hasPrice()) {
                    codedOutputStreamMicro.writeString(2, getPrice());
                }
                if (hasPosition()) {
                    codedOutputStreamMicro.writeString(3, getPosition());
                }
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }

            public static UserCoupon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (UserCoupon) new UserCoupon().mergeFrom(bArr);
            }
        }

        public static IndusInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new IndusInfo().mergeFrom(codedInputStreamMicro);
        }

        public IndusInfo addPriority(String str) {
            str.getClass();
            if (this.priority_.isEmpty()) {
                this.priority_ = new ArrayList();
            }
            this.priority_.add(str);
            return this;
        }

        public final IndusInfo clear() {
            clearIndusName();
            clearShowNum();
            clearUserCoupon();
            clearAdPos();
            clearPriority();
            this.cachedSize = -1;
            return this;
        }

        public IndusInfo clearAdPos() {
            this.hasAdPos = false;
            this.adPos_ = null;
            return this;
        }

        public IndusInfo clearIndusName() {
            this.hasIndusName = false;
            this.indusName_ = "";
            return this;
        }

        public IndusInfo clearPriority() {
            this.priority_ = Collections.emptyList();
            return this;
        }

        public IndusInfo clearShowNum() {
            this.hasShowNum = false;
            this.showNum_ = 0;
            return this;
        }

        public IndusInfo clearUserCoupon() {
            this.hasUserCoupon = false;
            this.userCoupon_ = null;
            return this;
        }

        public AdPos getAdPos() {
            return this.adPos_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getIndusName() {
            return this.indusName_;
        }

        public String getPriority(int i) {
            return this.priority_.get(i);
        }

        public int getPriorityCount() {
            return this.priority_.size();
        }

        public List<String> getPriorityList() {
            return this.priority_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasIndusName() ? CodedOutputStreamMicro.computeStringSize(1, getIndusName()) : 0;
            if (hasShowNum()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getShowNum());
            }
            if (hasUserCoupon()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, getUserCoupon());
            }
            if (hasAdPos()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(4, getAdPos());
            }
            Iterator<String> it = getPriorityList().iterator();
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
            }
            int size = computeStringSize + i + getPriorityList().size();
            this.cachedSize = size;
            return size;
        }

        public int getShowNum() {
            return this.showNum_;
        }

        public UserCoupon getUserCoupon() {
            return this.userCoupon_;
        }

        public boolean hasAdPos() {
            return this.hasAdPos;
        }

        public boolean hasIndusName() {
            return this.hasIndusName;
        }

        public boolean hasShowNum() {
            return this.hasShowNum;
        }

        public boolean hasUserCoupon() {
            return this.hasUserCoupon;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public IndusInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setIndusName(codedInputStreamMicro.readString());
                } else if (readTag == 16) {
                    setShowNum(codedInputStreamMicro.readInt32());
                } else if (readTag == 26) {
                    UserCoupon userCoupon = new UserCoupon();
                    codedInputStreamMicro.readMessage(userCoupon);
                    setUserCoupon(userCoupon);
                } else if (readTag == 34) {
                    AdPos adPos = new AdPos();
                    codedInputStreamMicro.readMessage(adPos);
                    setAdPos(adPos);
                } else if (readTag == 50) {
                    addPriority(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public IndusInfo setAdPos(AdPos adPos) {
            if (adPos == null) {
                return clearAdPos();
            }
            this.hasAdPos = true;
            this.adPos_ = adPos;
            return this;
        }

        public IndusInfo setIndusName(String str) {
            this.hasIndusName = true;
            this.indusName_ = str;
            return this;
        }

        public IndusInfo setPriority(int i, String str) {
            str.getClass();
            this.priority_.set(i, str);
            return this;
        }

        public IndusInfo setShowNum(int i) {
            this.hasShowNum = true;
            this.showNum_ = i;
            return this;
        }

        public IndusInfo setUserCoupon(UserCoupon userCoupon) {
            if (userCoupon == null) {
                return clearUserCoupon();
            }
            this.hasUserCoupon = true;
            this.userCoupon_ = userCoupon;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIndusName()) {
                codedOutputStreamMicro.writeString(1, getIndusName());
            }
            if (hasShowNum()) {
                codedOutputStreamMicro.writeInt32(2, getShowNum());
            }
            if (hasUserCoupon()) {
                codedOutputStreamMicro.writeMessage(3, getUserCoupon());
            }
            if (hasAdPos()) {
                codedOutputStreamMicro.writeMessage(4, getAdPos());
            }
            Iterator<String> it = getPriorityList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeString(6, it.next());
            }
        }

        public static IndusInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (IndusInfo) new IndusInfo().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ListAdsData extends MessageMicro {
        public static final int FLOAT_ICON_FIELD_NUMBER = 1;
        private boolean hasFloatIcon;
        private AdsListFloatIcon floatIcon_ = null;
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class AdsListFloatIcon extends MessageMicro {
            public static final int DATA_FIELD_NUMBER = 1;
            private boolean hasData;
            private String data_ = "";
            private int cachedSize = -1;

            public static AdsListFloatIcon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new AdsListFloatIcon().mergeFrom(codedInputStreamMicro);
            }

            public final AdsListFloatIcon clear() {
                clearData();
                this.cachedSize = -1;
                return this;
            }

            public AdsListFloatIcon clearData() {
                this.hasData = false;
                this.data_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getData() {
                return this.data_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasData() ? CodedOutputStreamMicro.computeStringSize(1, getData()) : 0;
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public boolean hasData() {
                return this.hasData;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public AdsListFloatIcon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setData(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public AdsListFloatIcon setData(String str) {
                this.hasData = true;
                this.data_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasData()) {
                    codedOutputStreamMicro.writeString(1, getData());
                }
            }

            public static AdsListFloatIcon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (AdsListFloatIcon) new AdsListFloatIcon().mergeFrom(bArr);
            }
        }

        public static ListAdsData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ListAdsData().mergeFrom(codedInputStreamMicro);
        }

        public final ListAdsData clear() {
            clearFloatIcon();
            this.cachedSize = -1;
            return this;
        }

        public ListAdsData clearFloatIcon() {
            this.hasFloatIcon = false;
            this.floatIcon_ = null;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public AdsListFloatIcon getFloatIcon() {
            return this.floatIcon_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeMessageSize = hasFloatIcon() ? CodedOutputStreamMicro.computeMessageSize(1, getFloatIcon()) : 0;
            this.cachedSize = computeMessageSize;
            return computeMessageSize;
        }

        public boolean hasFloatIcon() {
            return this.hasFloatIcon;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public ListAdsData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    AdsListFloatIcon adsListFloatIcon = new AdsListFloatIcon();
                    codedInputStreamMicro.readMessage(adsListFloatIcon);
                    setFloatIcon(adsListFloatIcon);
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public ListAdsData setFloatIcon(AdsListFloatIcon adsListFloatIcon) {
            if (adsListFloatIcon == null) {
                return clearFloatIcon();
            }
            this.hasFloatIcon = true;
            this.floatIcon_ = adsListFloatIcon;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFloatIcon()) {
                codedOutputStreamMicro.writeMessage(1, getFloatIcon());
            }
        }

        public static ListAdsData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ListAdsData) new ListAdsData().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class MystiqueList extends MessageMicro {
        public static final int CARD_TYPE_FIELD_NUMBER = 3;
        public static final int MYSTIQUE_DATA_FIELD_NUMBER = 1;
        public static final int POSITION_FIELD_NUMBER = 2;
        public static final int WEIGHT_FIELD_NUMBER = 4;
        private boolean hasCardType;
        private boolean hasMystiqueData;
        private boolean hasPosition;
        private boolean hasWeight;
        private String mystiqueData_ = "";
        private int position_ = 0;
        private int cardType_ = 0;
        private int weight_ = 0;
        private int cachedSize = -1;

        public static MystiqueList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MystiqueList().mergeFrom(codedInputStreamMicro);
        }

        public final MystiqueList clear() {
            clearMystiqueData();
            clearPosition();
            clearCardType();
            clearWeight();
            this.cachedSize = -1;
            return this;
        }

        public MystiqueList clearCardType() {
            this.hasCardType = false;
            this.cardType_ = 0;
            return this;
        }

        public MystiqueList clearMystiqueData() {
            this.hasMystiqueData = false;
            this.mystiqueData_ = "";
            return this;
        }

        public MystiqueList clearPosition() {
            this.hasPosition = false;
            this.position_ = 0;
            return this;
        }

        public MystiqueList clearWeight() {
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

        public int getCardType() {
            return this.cardType_;
        }

        public String getMystiqueData() {
            return this.mystiqueData_;
        }

        public int getPosition() {
            return this.position_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasMystiqueData() ? CodedOutputStreamMicro.computeStringSize(1, getMystiqueData()) : 0;
            if (hasPosition()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getPosition());
            }
            if (hasCardType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getCardType());
            }
            if (hasWeight()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getWeight());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public int getWeight() {
            return this.weight_;
        }

        public boolean hasCardType() {
            return this.hasCardType;
        }

        public boolean hasMystiqueData() {
            return this.hasMystiqueData;
        }

        public boolean hasPosition() {
            return this.hasPosition;
        }

        public boolean hasWeight() {
            return this.hasWeight;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public MystiqueList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setMystiqueData(codedInputStreamMicro.readString());
                } else if (readTag == 16) {
                    setPosition(codedInputStreamMicro.readInt32());
                } else if (readTag == 24) {
                    setCardType(codedInputStreamMicro.readInt32());
                } else if (readTag == 32) {
                    setWeight(codedInputStreamMicro.readInt32());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public MystiqueList setCardType(int i) {
            this.hasCardType = true;
            this.cardType_ = i;
            return this;
        }

        public MystiqueList setMystiqueData(String str) {
            this.hasMystiqueData = true;
            this.mystiqueData_ = str;
            return this;
        }

        public MystiqueList setPosition(int i) {
            this.hasPosition = true;
            this.position_ = i;
            return this;
        }

        public MystiqueList setWeight(int i) {
            this.hasWeight = true;
            this.weight_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMystiqueData()) {
                codedOutputStreamMicro.writeString(1, getMystiqueData());
            }
            if (hasPosition()) {
                codedOutputStreamMicro.writeInt32(2, getPosition());
            }
            if (hasCardType()) {
                codedOutputStreamMicro.writeInt32(3, getCardType());
            }
            if (hasWeight()) {
                codedOutputStreamMicro.writeInt32(4, getWeight());
            }
        }

        public static MystiqueList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MystiqueList) new MystiqueList().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Option extends MessageMicro {
        public static final int BD_SEARCH_ENABLE_FIELD_NUMBER = 20;
        public static final int BD_SEARCH_ORD_FIELD_NUMBER = 19;
        public static final int BD_SEARCH_TAG_FIELD_NUMBER = 21;
        public static final int CITY_REGION_FIELD_NUMBER = 18;
        public static final int CLICK_REC_TIMES_FIELD_NUMBER = 25;
        public static final int CLIENT_SRC_FIELD_NUMBER = 22;
        public static final int DISP_ATTR_FIELD_NUMBER = 16;
        public static final int FILTER_SESSION_ID_FIELD_NUMBER = 29;
        public static final int LANDMARK_FLAG_FIELD_NUMBER = 13;
        public static final int LBS_DIRECT_FLAG_FIELD_NUMBER = 15;
        public static final int LDATA_FIELD_NUMBER = 14;
        public static final int LIST_THIRDKING_FLAG_FIELD_NUMBER = 12;
        public static final int LOC_ATTR_FIELD_NUMBER = 2;
        public static final int MOVE_AND_SEARCH_FLAG_FIELD_NUMBER = 28;
        public static final int NEXT_PAGE_FIELD_NUMBER = 26;
        public static final int OP_ADDR_FIELD_NUMBER = 4;
        public static final int OP_GEL_FIELD_NUMBER = 3;
        public static final int QID_FIELD_NUMBER = 6;
        public static final int REGION_TYPE_FIELD_NUMBER = 17;
        public static final int RES_BOUND_ACC_FIELD_NUMBER = 9;
        public static final int RES_BOUND_FIELD_NUMBER = 8;
        public static final int RES_X_FIELD_NUMBER = 10;
        public static final int RES_Y_FIELD_NUMBER = 11;
        public static final int RP_STRATEGY_FIELD_NUMBER = 5;
        public static final int SESSION_DATA_FIELD_NUMBER = 23;
        public static final int SHOW_CLICK_REC_FIELD_NUMBER = 24;
        public static final int THIRD_PARTY_FIELD_NUMBER = 27;
        public static final int TOTAL_BUSLINE_NUM_FIELD_NUMBER = 7;
        public static final int TOTAL_FIELD_NUMBER = 1;
        private boolean hasBdSearchEnable;
        private boolean hasBdSearchOrd;
        private boolean hasBdSearchTag;
        private boolean hasCityRegion;
        private boolean hasClickRecTimes;
        private boolean hasClientSrc;
        private boolean hasDispAttr;
        private boolean hasFilterSessionId;
        private boolean hasLandmarkFlag;
        private boolean hasLbsDirectFlag;
        private boolean hasLdata;
        private boolean hasListThirdkingFlag;
        private boolean hasLocAttr;
        private boolean hasMoveAndSearchFlag;
        private boolean hasNextPage;
        private boolean hasOpAddr;
        private boolean hasOpGel;
        private boolean hasQid;
        private boolean hasRegionType;
        private boolean hasResBound;
        private boolean hasResBoundAcc;
        private boolean hasResX;
        private boolean hasResY;
        private boolean hasRpStrategy;
        private boolean hasSessionData;
        private boolean hasShowClickRec;
        private boolean hasThirdParty;
        private boolean hasTotal;
        private boolean hasTotalBuslineNum;
        private int total_ = 0;
        private int locAttr_ = 0;
        private boolean opGel_ = false;
        private boolean opAddr_ = false;
        private int rpStrategy_ = 0;
        private String qid_ = "";
        private int totalBuslineNum_ = 0;
        private String resBound_ = "";
        private String resBoundAcc_ = "";
        private String resX_ = "";
        private String resY_ = "";
        private int listThirdkingFlag_ = 0;
        private String landmarkFlag_ = "";
        private String ldata_ = "";
        private String lbsDirectFlag_ = "";
        private int dispAttr_ = 0;
        private String regionType_ = "";
        private String cityRegion_ = "";
        private int bdSearchOrd_ = 0;
        private int bdSearchEnable_ = 0;
        private String bdSearchTag_ = "";
        private int clientSrc_ = 0;
        private String sessionData_ = "";
        private boolean showClickRec_ = false;
        private int clickRecTimes_ = 0;
        private int nextPage_ = 0;
        private ThirdParty thirdParty_ = null;
        private String moveAndSearchFlag_ = "";
        private String filterSessionId_ = "";
        private int cachedSize = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public final Option clear() {
            clearTotal();
            clearLocAttr();
            clearOpGel();
            clearOpAddr();
            clearRpStrategy();
            clearQid();
            clearTotalBuslineNum();
            clearResBound();
            clearResBoundAcc();
            clearResX();
            clearResY();
            clearListThirdkingFlag();
            clearLandmarkFlag();
            clearLdata();
            clearLbsDirectFlag();
            clearDispAttr();
            clearRegionType();
            clearCityRegion();
            clearBdSearchOrd();
            clearBdSearchEnable();
            clearBdSearchTag();
            clearClientSrc();
            clearSessionData();
            clearShowClickRec();
            clearClickRecTimes();
            clearNextPage();
            clearThirdParty();
            clearMoveAndSearchFlag();
            clearFilterSessionId();
            this.cachedSize = -1;
            return this;
        }

        public Option clearBdSearchEnable() {
            this.hasBdSearchEnable = false;
            this.bdSearchEnable_ = 0;
            return this;
        }

        public Option clearBdSearchOrd() {
            this.hasBdSearchOrd = false;
            this.bdSearchOrd_ = 0;
            return this;
        }

        public Option clearBdSearchTag() {
            this.hasBdSearchTag = false;
            this.bdSearchTag_ = "";
            return this;
        }

        public Option clearCityRegion() {
            this.hasCityRegion = false;
            this.cityRegion_ = "";
            return this;
        }

        public Option clearClickRecTimes() {
            this.hasClickRecTimes = false;
            this.clickRecTimes_ = 0;
            return this;
        }

        public Option clearClientSrc() {
            this.hasClientSrc = false;
            this.clientSrc_ = 0;
            return this;
        }

        public Option clearDispAttr() {
            this.hasDispAttr = false;
            this.dispAttr_ = 0;
            return this;
        }

        public Option clearFilterSessionId() {
            this.hasFilterSessionId = false;
            this.filterSessionId_ = "";
            return this;
        }

        public Option clearLandmarkFlag() {
            this.hasLandmarkFlag = false;
            this.landmarkFlag_ = "";
            return this;
        }

        public Option clearLbsDirectFlag() {
            this.hasLbsDirectFlag = false;
            this.lbsDirectFlag_ = "";
            return this;
        }

        public Option clearLdata() {
            this.hasLdata = false;
            this.ldata_ = "";
            return this;
        }

        public Option clearListThirdkingFlag() {
            this.hasListThirdkingFlag = false;
            this.listThirdkingFlag_ = 0;
            return this;
        }

        public Option clearLocAttr() {
            this.hasLocAttr = false;
            this.locAttr_ = 0;
            return this;
        }

        public Option clearMoveAndSearchFlag() {
            this.hasMoveAndSearchFlag = false;
            this.moveAndSearchFlag_ = "";
            return this;
        }

        public Option clearNextPage() {
            this.hasNextPage = false;
            this.nextPage_ = 0;
            return this;
        }

        public Option clearOpAddr() {
            this.hasOpAddr = false;
            this.opAddr_ = false;
            return this;
        }

        public Option clearOpGel() {
            this.hasOpGel = false;
            this.opGel_ = false;
            return this;
        }

        public Option clearQid() {
            this.hasQid = false;
            this.qid_ = "";
            return this;
        }

        public Option clearRegionType() {
            this.hasRegionType = false;
            this.regionType_ = "";
            return this;
        }

        public Option clearResBound() {
            this.hasResBound = false;
            this.resBound_ = "";
            return this;
        }

        public Option clearResBoundAcc() {
            this.hasResBoundAcc = false;
            this.resBoundAcc_ = "";
            return this;
        }

        public Option clearResX() {
            this.hasResX = false;
            this.resX_ = "";
            return this;
        }

        public Option clearResY() {
            this.hasResY = false;
            this.resY_ = "";
            return this;
        }

        public Option clearRpStrategy() {
            this.hasRpStrategy = false;
            this.rpStrategy_ = 0;
            return this;
        }

        public Option clearSessionData() {
            this.hasSessionData = false;
            this.sessionData_ = "";
            return this;
        }

        public Option clearShowClickRec() {
            this.hasShowClickRec = false;
            this.showClickRec_ = false;
            return this;
        }

        public Option clearThirdParty() {
            this.hasThirdParty = false;
            this.thirdParty_ = null;
            return this;
        }

        public Option clearTotal() {
            this.hasTotal = false;
            this.total_ = 0;
            return this;
        }

        public Option clearTotalBuslineNum() {
            this.hasTotalBuslineNum = false;
            this.totalBuslineNum_ = 0;
            return this;
        }

        public int getBdSearchEnable() {
            return this.bdSearchEnable_;
        }

        public int getBdSearchOrd() {
            return this.bdSearchOrd_;
        }

        public String getBdSearchTag() {
            return this.bdSearchTag_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getCityRegion() {
            return this.cityRegion_;
        }

        public int getClickRecTimes() {
            return this.clickRecTimes_;
        }

        public int getClientSrc() {
            return this.clientSrc_;
        }

        public int getDispAttr() {
            return this.dispAttr_;
        }

        public String getFilterSessionId() {
            return this.filterSessionId_;
        }

        public String getLandmarkFlag() {
            return this.landmarkFlag_;
        }

        public String getLbsDirectFlag() {
            return this.lbsDirectFlag_;
        }

        public String getLdata() {
            return this.ldata_;
        }

        public int getListThirdkingFlag() {
            return this.listThirdkingFlag_;
        }

        public int getLocAttr() {
            return this.locAttr_;
        }

        public String getMoveAndSearchFlag() {
            return this.moveAndSearchFlag_;
        }

        public int getNextPage() {
            return this.nextPage_;
        }

        public boolean getOpAddr() {
            return this.opAddr_;
        }

        public boolean getOpGel() {
            return this.opGel_;
        }

        public String getQid() {
            return this.qid_;
        }

        public String getRegionType() {
            return this.regionType_;
        }

        public String getResBound() {
            return this.resBound_;
        }

        public String getResBoundAcc() {
            return this.resBoundAcc_;
        }

        public String getResX() {
            return this.resX_;
        }

        public String getResY() {
            return this.resY_;
        }

        public int getRpStrategy() {
            return this.rpStrategy_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasTotal() ? CodedOutputStreamMicro.computeInt32Size(1, getTotal()) : 0;
            if (hasLocAttr()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getLocAttr());
            }
            if (hasOpGel()) {
                computeInt32Size += CodedOutputStreamMicro.computeBoolSize(3, getOpGel());
            }
            if (hasOpAddr()) {
                computeInt32Size += CodedOutputStreamMicro.computeBoolSize(4, getOpAddr());
            }
            if (hasRpStrategy()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getRpStrategy());
            }
            if (hasQid()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(6, getQid());
            }
            if (hasTotalBuslineNum()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getTotalBuslineNum());
            }
            if (hasResBound()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(8, getResBound());
            }
            if (hasResBoundAcc()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getResBoundAcc());
            }
            if (hasResX()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(10, getResX());
            }
            if (hasResY()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(11, getResY());
            }
            if (hasListThirdkingFlag()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(12, getListThirdkingFlag());
            }
            if (hasLandmarkFlag()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(13, getLandmarkFlag());
            }
            if (hasLdata()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(14, getLdata());
            }
            if (hasLbsDirectFlag()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(15, getLbsDirectFlag());
            }
            if (hasDispAttr()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(16, getDispAttr());
            }
            if (hasRegionType()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(17, getRegionType());
            }
            if (hasCityRegion()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(18, getCityRegion());
            }
            if (hasBdSearchOrd()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(19, getBdSearchOrd());
            }
            if (hasBdSearchEnable()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(20, getBdSearchEnable());
            }
            if (hasBdSearchTag()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(21, getBdSearchTag());
            }
            if (hasClientSrc()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(22, getClientSrc());
            }
            if (hasSessionData()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(23, getSessionData());
            }
            if (hasShowClickRec()) {
                computeInt32Size += CodedOutputStreamMicro.computeBoolSize(24, getShowClickRec());
            }
            if (hasClickRecTimes()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(25, getClickRecTimes());
            }
            if (hasNextPage()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(26, getNextPage());
            }
            if (hasThirdParty()) {
                computeInt32Size += CodedOutputStreamMicro.computeMessageSize(27, getThirdParty());
            }
            if (hasMoveAndSearchFlag()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(28, getMoveAndSearchFlag());
            }
            if (hasFilterSessionId()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(29, getFilterSessionId());
            }
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
        }

        public String getSessionData() {
            return this.sessionData_;
        }

        public boolean getShowClickRec() {
            return this.showClickRec_;
        }

        public ThirdParty getThirdParty() {
            return this.thirdParty_;
        }

        public int getTotal() {
            return this.total_;
        }

        public int getTotalBuslineNum() {
            return this.totalBuslineNum_;
        }

        public boolean hasBdSearchEnable() {
            return this.hasBdSearchEnable;
        }

        public boolean hasBdSearchOrd() {
            return this.hasBdSearchOrd;
        }

        public boolean hasBdSearchTag() {
            return this.hasBdSearchTag;
        }

        public boolean hasCityRegion() {
            return this.hasCityRegion;
        }

        public boolean hasClickRecTimes() {
            return this.hasClickRecTimes;
        }

        public boolean hasClientSrc() {
            return this.hasClientSrc;
        }

        public boolean hasDispAttr() {
            return this.hasDispAttr;
        }

        public boolean hasFilterSessionId() {
            return this.hasFilterSessionId;
        }

        public boolean hasLandmarkFlag() {
            return this.hasLandmarkFlag;
        }

        public boolean hasLbsDirectFlag() {
            return this.hasLbsDirectFlag;
        }

        public boolean hasLdata() {
            return this.hasLdata;
        }

        public boolean hasListThirdkingFlag() {
            return this.hasListThirdkingFlag;
        }

        public boolean hasLocAttr() {
            return this.hasLocAttr;
        }

        public boolean hasMoveAndSearchFlag() {
            return this.hasMoveAndSearchFlag;
        }

        public boolean hasNextPage() {
            return this.hasNextPage;
        }

        public boolean hasOpAddr() {
            return this.hasOpAddr;
        }

        public boolean hasOpGel() {
            return this.hasOpGel;
        }

        public boolean hasQid() {
            return this.hasQid;
        }

        public boolean hasRegionType() {
            return this.hasRegionType;
        }

        public boolean hasResBound() {
            return this.hasResBound;
        }

        public boolean hasResBoundAcc() {
            return this.hasResBoundAcc;
        }

        public boolean hasResX() {
            return this.hasResX;
        }

        public boolean hasResY() {
            return this.hasResY;
        }

        public boolean hasRpStrategy() {
            return this.hasRpStrategy;
        }

        public boolean hasSessionData() {
            return this.hasSessionData;
        }

        public boolean hasShowClickRec() {
            return this.hasShowClickRec;
        }

        public boolean hasThirdParty() {
            return this.hasThirdParty;
        }

        public boolean hasTotal() {
            return this.hasTotal;
        }

        public boolean hasTotalBuslineNum() {
            return this.hasTotalBuslineNum;
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
                        setTotal(codedInputStreamMicro.readInt32());
                        break;
                    case 16:
                        setLocAttr(codedInputStreamMicro.readInt32());
                        break;
                    case 24:
                        setOpGel(codedInputStreamMicro.readBool());
                        break;
                    case 32:
                        setOpAddr(codedInputStreamMicro.readBool());
                        break;
                    case 40:
                        setRpStrategy(codedInputStreamMicro.readInt32());
                        break;
                    case 50:
                        setQid(codedInputStreamMicro.readString());
                        break;
                    case 56:
                        setTotalBuslineNum(codedInputStreamMicro.readInt32());
                        break;
                    case 66:
                        setResBound(codedInputStreamMicro.readString());
                        break;
                    case 74:
                        setResBoundAcc(codedInputStreamMicro.readString());
                        break;
                    case 82:
                        setResX(codedInputStreamMicro.readString());
                        break;
                    case 90:
                        setResY(codedInputStreamMicro.readString());
                        break;
                    case 96:
                        setListThirdkingFlag(codedInputStreamMicro.readInt32());
                        break;
                    case 106:
                        setLandmarkFlag(codedInputStreamMicro.readString());
                        break;
                    case 114:
                        setLdata(codedInputStreamMicro.readString());
                        break;
                    case 122:
                        setLbsDirectFlag(codedInputStreamMicro.readString());
                        break;
                    case 128:
                        setDispAttr(codedInputStreamMicro.readInt32());
                        break;
                    case 138:
                        setRegionType(codedInputStreamMicro.readString());
                        break;
                    case 146:
                        setCityRegion(codedInputStreamMicro.readString());
                        break;
                    case 152:
                        setBdSearchOrd(codedInputStreamMicro.readInt32());
                        break;
                    case 160:
                        setBdSearchEnable(codedInputStreamMicro.readInt32());
                        break;
                    case 170:
                        setBdSearchTag(codedInputStreamMicro.readString());
                        break;
                    case 176:
                        setClientSrc(codedInputStreamMicro.readInt32());
                        break;
                    case 186:
                        setSessionData(codedInputStreamMicro.readString());
                        break;
                    case 192:
                        setShowClickRec(codedInputStreamMicro.readBool());
                        break;
                    case 200:
                        setClickRecTimes(codedInputStreamMicro.readInt32());
                        break;
                    case 208:
                        setNextPage(codedInputStreamMicro.readInt32());
                        break;
                    case HeightPicker.f25534xoXoI /* 218 */:
                        ThirdParty thirdParty = new ThirdParty();
                        codedInputStreamMicro.readMessage(thirdParty);
                        setThirdParty(thirdParty);
                        break;
                    case 226:
                        setMoveAndSearchFlag(codedInputStreamMicro.readString());
                        break;
                    case 234:
                        setFilterSessionId(codedInputStreamMicro.readString());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public Option setBdSearchEnable(int i) {
            this.hasBdSearchEnable = true;
            this.bdSearchEnable_ = i;
            return this;
        }

        public Option setBdSearchOrd(int i) {
            this.hasBdSearchOrd = true;
            this.bdSearchOrd_ = i;
            return this;
        }

        public Option setBdSearchTag(String str) {
            this.hasBdSearchTag = true;
            this.bdSearchTag_ = str;
            return this;
        }

        public Option setCityRegion(String str) {
            this.hasCityRegion = true;
            this.cityRegion_ = str;
            return this;
        }

        public Option setClickRecTimes(int i) {
            this.hasClickRecTimes = true;
            this.clickRecTimes_ = i;
            return this;
        }

        public Option setClientSrc(int i) {
            this.hasClientSrc = true;
            this.clientSrc_ = i;
            return this;
        }

        public Option setDispAttr(int i) {
            this.hasDispAttr = true;
            this.dispAttr_ = i;
            return this;
        }

        public Option setFilterSessionId(String str) {
            this.hasFilterSessionId = true;
            this.filterSessionId_ = str;
            return this;
        }

        public Option setLandmarkFlag(String str) {
            this.hasLandmarkFlag = true;
            this.landmarkFlag_ = str;
            return this;
        }

        public Option setLbsDirectFlag(String str) {
            this.hasLbsDirectFlag = true;
            this.lbsDirectFlag_ = str;
            return this;
        }

        public Option setLdata(String str) {
            this.hasLdata = true;
            this.ldata_ = str;
            return this;
        }

        public Option setListThirdkingFlag(int i) {
            this.hasListThirdkingFlag = true;
            this.listThirdkingFlag_ = i;
            return this;
        }

        public Option setLocAttr(int i) {
            this.hasLocAttr = true;
            this.locAttr_ = i;
            return this;
        }

        public Option setMoveAndSearchFlag(String str) {
            this.hasMoveAndSearchFlag = true;
            this.moveAndSearchFlag_ = str;
            return this;
        }

        public Option setNextPage(int i) {
            this.hasNextPage = true;
            this.nextPage_ = i;
            return this;
        }

        public Option setOpAddr(boolean z) {
            this.hasOpAddr = true;
            this.opAddr_ = z;
            return this;
        }

        public Option setOpGel(boolean z) {
            this.hasOpGel = true;
            this.opGel_ = z;
            return this;
        }

        public Option setQid(String str) {
            this.hasQid = true;
            this.qid_ = str;
            return this;
        }

        public Option setRegionType(String str) {
            this.hasRegionType = true;
            this.regionType_ = str;
            return this;
        }

        public Option setResBound(String str) {
            this.hasResBound = true;
            this.resBound_ = str;
            return this;
        }

        public Option setResBoundAcc(String str) {
            this.hasResBoundAcc = true;
            this.resBoundAcc_ = str;
            return this;
        }

        public Option setResX(String str) {
            this.hasResX = true;
            this.resX_ = str;
            return this;
        }

        public Option setResY(String str) {
            this.hasResY = true;
            this.resY_ = str;
            return this;
        }

        public Option setRpStrategy(int i) {
            this.hasRpStrategy = true;
            this.rpStrategy_ = i;
            return this;
        }

        public Option setSessionData(String str) {
            this.hasSessionData = true;
            this.sessionData_ = str;
            return this;
        }

        public Option setShowClickRec(boolean z) {
            this.hasShowClickRec = true;
            this.showClickRec_ = z;
            return this;
        }

        public Option setThirdParty(ThirdParty thirdParty) {
            if (thirdParty == null) {
                return clearThirdParty();
            }
            this.hasThirdParty = true;
            this.thirdParty_ = thirdParty;
            return this;
        }

        public Option setTotal(int i) {
            this.hasTotal = true;
            this.total_ = i;
            return this;
        }

        public Option setTotalBuslineNum(int i) {
            this.hasTotalBuslineNum = true;
            this.totalBuslineNum_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (hasLocAttr()) {
                codedOutputStreamMicro.writeInt32(2, getLocAttr());
            }
            if (hasOpGel()) {
                codedOutputStreamMicro.writeBool(3, getOpGel());
            }
            if (hasOpAddr()) {
                codedOutputStreamMicro.writeBool(4, getOpAddr());
            }
            if (hasRpStrategy()) {
                codedOutputStreamMicro.writeInt32(5, getRpStrategy());
            }
            if (hasQid()) {
                codedOutputStreamMicro.writeString(6, getQid());
            }
            if (hasTotalBuslineNum()) {
                codedOutputStreamMicro.writeInt32(7, getTotalBuslineNum());
            }
            if (hasResBound()) {
                codedOutputStreamMicro.writeString(8, getResBound());
            }
            if (hasResBoundAcc()) {
                codedOutputStreamMicro.writeString(9, getResBoundAcc());
            }
            if (hasResX()) {
                codedOutputStreamMicro.writeString(10, getResX());
            }
            if (hasResY()) {
                codedOutputStreamMicro.writeString(11, getResY());
            }
            if (hasListThirdkingFlag()) {
                codedOutputStreamMicro.writeInt32(12, getListThirdkingFlag());
            }
            if (hasLandmarkFlag()) {
                codedOutputStreamMicro.writeString(13, getLandmarkFlag());
            }
            if (hasLdata()) {
                codedOutputStreamMicro.writeString(14, getLdata());
            }
            if (hasLbsDirectFlag()) {
                codedOutputStreamMicro.writeString(15, getLbsDirectFlag());
            }
            if (hasDispAttr()) {
                codedOutputStreamMicro.writeInt32(16, getDispAttr());
            }
            if (hasRegionType()) {
                codedOutputStreamMicro.writeString(17, getRegionType());
            }
            if (hasCityRegion()) {
                codedOutputStreamMicro.writeString(18, getCityRegion());
            }
            if (hasBdSearchOrd()) {
                codedOutputStreamMicro.writeInt32(19, getBdSearchOrd());
            }
            if (hasBdSearchEnable()) {
                codedOutputStreamMicro.writeInt32(20, getBdSearchEnable());
            }
            if (hasBdSearchTag()) {
                codedOutputStreamMicro.writeString(21, getBdSearchTag());
            }
            if (hasClientSrc()) {
                codedOutputStreamMicro.writeInt32(22, getClientSrc());
            }
            if (hasSessionData()) {
                codedOutputStreamMicro.writeString(23, getSessionData());
            }
            if (hasShowClickRec()) {
                codedOutputStreamMicro.writeBool(24, getShowClickRec());
            }
            if (hasClickRecTimes()) {
                codedOutputStreamMicro.writeInt32(25, getClickRecTimes());
            }
            if (hasNextPage()) {
                codedOutputStreamMicro.writeInt32(26, getNextPage());
            }
            if (hasThirdParty()) {
                codedOutputStreamMicro.writeMessage(27, getThirdParty());
            }
            if (hasMoveAndSearchFlag()) {
                codedOutputStreamMicro.writeString(28, getMoveAndSearchFlag());
            }
            if (hasFilterSessionId()) {
                codedOutputStreamMicro.writeString(29, getFilterSessionId());
            }
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class PlaceInfo extends MessageMicro {
        public static final int BANNER_INFO_FIELD_NUMBER = 8;
        public static final int D_ACT_CARD_FIELD_NUMBER = 9;
        public static final int D_BUSINESS_ID_FIELD_NUMBER = 5;
        public static final int D_BUSINESS_TYPE_FIELD_NUMBER = 6;
        public static final int D_DATA_TYPE_FIELD_NUMBER = 1;
        public static final int D_FILTERS_SHOW_FLAG_FIELD_NUMBER = 4;
        public static final int D_SORT_RULE_FIELD_NUMBER = 3;
        public static final int D_SORT_TYPE_FIELD_NUMBER = 2;
        public static final int D_SUB_TYPE_FIELD_NUMBER = 10;
        public static final int FILTERS_FIELD_NUMBER = 11;
        public static final int PRE_FILTERS_FIELD_NUMBER = 12;
        public static final int SEARCH_EXT_FIELD_NUMBER = 7;
        public static final int TAB_FILTERS_FIELD_NUMBER = 13;
        private int cachedSize;
        private ByteStringMicro filters_;
        private boolean hasBannerInfo;
        private boolean hasDActCard;
        private boolean hasDBusinessId;
        private boolean hasDBusinessType;
        private boolean hasDDataType;
        private boolean hasDFiltersShowFlag;
        private boolean hasDSortRule;
        private boolean hasDSortType;
        private boolean hasDSubType;
        private boolean hasFilters;
        private boolean hasPreFilters;
        private boolean hasTabFilters;
        private ByteStringMicro preFilters_;
        private ByteStringMicro tabFilters_;
        private List<SearchExt> searchExt_ = Collections.emptyList();
        private DActCard dActCard_ = null;
        private BannerInfo bannerInfo_ = null;
        private String dDataType_ = "";
        private String dSortType_ = "";
        private int dSortRule_ = 0;
        private int dFiltersShowFlag_ = 0;
        private String dBusinessId_ = "";
        private String dBusinessType_ = "";
        private String dSubType_ = "";

        /* loaded from: classes7.dex */
        public static final class BannerInfo extends MessageMicro {
            public static final int ACT_FIELD_NUMBER = 4;
            public static final int ACT_URL_FIELD_NUMBER = 5;
            public static final int DESCRIPTION_FIELD_NUMBER = 6;
            public static final int IMAGE_FIELD_NUMBER = 3;
            public static final int SCORE_FIELD_NUMBER = 2;
            public static final int STAR_FIELD_NUMBER = 7;
            public static final int TITLE_FIELD_NUMBER = 1;
            private boolean hasAct;
            private boolean hasActUrl;
            private boolean hasDescription;
            private boolean hasImage;
            private boolean hasScore;
            private boolean hasStar;
            private boolean hasTitle;
            private String title_ = "";
            private String score_ = "";
            private String image_ = "";
            private String act_ = "";
            private String actUrl_ = "";
            private String description_ = "";
            private String star_ = "";
            private int cachedSize = -1;

            public static BannerInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new BannerInfo().mergeFrom(codedInputStreamMicro);
            }

            public final BannerInfo clear() {
                clearTitle();
                clearScore();
                clearImage();
                clearAct();
                clearActUrl();
                clearDescription();
                clearStar();
                this.cachedSize = -1;
                return this;
            }

            public BannerInfo clearAct() {
                this.hasAct = false;
                this.act_ = "";
                return this;
            }

            public BannerInfo clearActUrl() {
                this.hasActUrl = false;
                this.actUrl_ = "";
                return this;
            }

            public BannerInfo clearDescription() {
                this.hasDescription = false;
                this.description_ = "";
                return this;
            }

            public BannerInfo clearImage() {
                this.hasImage = false;
                this.image_ = "";
                return this;
            }

            public BannerInfo clearScore() {
                this.hasScore = false;
                this.score_ = "";
                return this;
            }

            public BannerInfo clearStar() {
                this.hasStar = false;
                this.star_ = "";
                return this;
            }

            public BannerInfo clearTitle() {
                this.hasTitle = false;
                this.title_ = "";
                return this;
            }

            public String getAct() {
                return this.act_;
            }

            public String getActUrl() {
                return this.actUrl_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getDescription() {
                return this.description_;
            }

            public String getImage() {
                return this.image_;
            }

            public String getScore() {
                return this.score_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasTitle() ? CodedOutputStreamMicro.computeStringSize(1, getTitle()) : 0;
                if (hasScore()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getScore());
                }
                if (hasImage()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getImage());
                }
                if (hasAct()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getAct());
                }
                if (hasActUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getActUrl());
                }
                if (hasDescription()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getDescription());
                }
                if (hasStar()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getStar());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getStar() {
                return this.star_;
            }

            public String getTitle() {
                return this.title_;
            }

            public boolean hasAct() {
                return this.hasAct;
            }

            public boolean hasActUrl() {
                return this.hasActUrl;
            }

            public boolean hasDescription() {
                return this.hasDescription;
            }

            public boolean hasImage() {
                return this.hasImage;
            }

            public boolean hasScore() {
                return this.hasScore;
            }

            public boolean hasStar() {
                return this.hasStar;
            }

            public boolean hasTitle() {
                return this.hasTitle;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public BannerInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setTitle(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setScore(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setImage(codedInputStreamMicro.readString());
                    } else if (readTag == 34) {
                        setAct(codedInputStreamMicro.readString());
                    } else if (readTag == 42) {
                        setActUrl(codedInputStreamMicro.readString());
                    } else if (readTag == 50) {
                        setDescription(codedInputStreamMicro.readString());
                    } else if (readTag == 58) {
                        setStar(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public BannerInfo setAct(String str) {
                this.hasAct = true;
                this.act_ = str;
                return this;
            }

            public BannerInfo setActUrl(String str) {
                this.hasActUrl = true;
                this.actUrl_ = str;
                return this;
            }

            public BannerInfo setDescription(String str) {
                this.hasDescription = true;
                this.description_ = str;
                return this;
            }

            public BannerInfo setImage(String str) {
                this.hasImage = true;
                this.image_ = str;
                return this;
            }

            public BannerInfo setScore(String str) {
                this.hasScore = true;
                this.score_ = str;
                return this;
            }

            public BannerInfo setStar(String str) {
                this.hasStar = true;
                this.star_ = str;
                return this;
            }

            public BannerInfo setTitle(String str) {
                this.hasTitle = true;
                this.title_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(1, getTitle());
                }
                if (hasScore()) {
                    codedOutputStreamMicro.writeString(2, getScore());
                }
                if (hasImage()) {
                    codedOutputStreamMicro.writeString(3, getImage());
                }
                if (hasAct()) {
                    codedOutputStreamMicro.writeString(4, getAct());
                }
                if (hasActUrl()) {
                    codedOutputStreamMicro.writeString(5, getActUrl());
                }
                if (hasDescription()) {
                    codedOutputStreamMicro.writeString(6, getDescription());
                }
                if (hasStar()) {
                    codedOutputStreamMicro.writeString(7, getStar());
                }
            }

            public static BannerInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (BannerInfo) new BannerInfo().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class DActCard extends MessageMicro {
            public static final int IMG_URL_FIELD_NUMBER = 2;
            public static final int LINK_FIELD_NUMBER = 1;
            private boolean hasImgUrl;
            private boolean hasLink;
            private String link_ = "";
            private String imgUrl_ = "";
            private int cachedSize = -1;

            public static DActCard parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new DActCard().mergeFrom(codedInputStreamMicro);
            }

            public final DActCard clear() {
                clearLink();
                clearImgUrl();
                this.cachedSize = -1;
                return this;
            }

            public DActCard clearImgUrl() {
                this.hasImgUrl = false;
                this.imgUrl_ = "";
                return this;
            }

            public DActCard clearLink() {
                this.hasLink = false;
                this.link_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getImgUrl() {
                return this.imgUrl_;
            }

            public String getLink() {
                return this.link_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasLink() ? CodedOutputStreamMicro.computeStringSize(1, getLink()) : 0;
                if (hasImgUrl()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getImgUrl());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public boolean hasImgUrl() {
                return this.hasImgUrl;
            }

            public boolean hasLink() {
                return this.hasLink;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public DActCard mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setLink(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setImgUrl(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public DActCard setImgUrl(String str) {
                this.hasImgUrl = true;
                this.imgUrl_ = str;
                return this;
            }

            public DActCard setLink(String str) {
                this.hasLink = true;
                this.link_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasLink()) {
                    codedOutputStreamMicro.writeString(1, getLink());
                }
                if (hasImgUrl()) {
                    codedOutputStreamMicro.writeString(2, getImgUrl());
                }
            }

            public static DActCard parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (DActCard) new DActCard().mergeFrom(bArr);
            }
        }

        /* loaded from: classes7.dex */
        public static final class SearchExt extends MessageMicro {
            public static final int TITLE_FIELD_NUMBER = 1;
            public static final int WD_FIELD_NUMBER = 2;
            private boolean hasTitle;
            private boolean hasWd;
            private String title_ = "";
            private String wd_ = "";
            private int cachedSize = -1;

            public static SearchExt parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new SearchExt().mergeFrom(codedInputStreamMicro);
            }

            public final SearchExt clear() {
                clearTitle();
                clearWd();
                this.cachedSize = -1;
                return this;
            }

            public SearchExt clearTitle() {
                this.hasTitle = false;
                this.title_ = "";
                return this;
            }

            public SearchExt clearWd() {
                this.hasWd = false;
                this.wd_ = "";
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
                int computeStringSize = hasTitle() ? CodedOutputStreamMicro.computeStringSize(1, getTitle()) : 0;
                if (hasWd()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWd());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getTitle() {
                return this.title_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasTitle() {
                return this.hasTitle;
            }

            public boolean hasWd() {
                return this.hasWd;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public SearchExt mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setTitle(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setWd(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public SearchExt setTitle(String str) {
                this.hasTitle = true;
                this.title_ = str;
                return this;
            }

            public SearchExt setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(1, getTitle());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(2, getWd());
                }
            }

            public static SearchExt parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (SearchExt) new SearchExt().mergeFrom(bArr);
            }
        }

        public PlaceInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.filters_ = byteStringMicro;
            this.preFilters_ = byteStringMicro;
            this.tabFilters_ = byteStringMicro;
            this.cachedSize = -1;
        }

        public static PlaceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PlaceInfo().mergeFrom(codedInputStreamMicro);
        }

        public PlaceInfo addSearchExt(SearchExt searchExt) {
            if (searchExt == null) {
                return this;
            }
            if (this.searchExt_.isEmpty()) {
                this.searchExt_ = new ArrayList();
            }
            this.searchExt_.add(searchExt);
            return this;
        }

        public final PlaceInfo clear() {
            clearSearchExt();
            clearDActCard();
            clearBannerInfo();
            clearDDataType();
            clearDSortType();
            clearDSortRule();
            clearDFiltersShowFlag();
            clearDBusinessId();
            clearDBusinessType();
            clearDSubType();
            clearFilters();
            clearPreFilters();
            clearTabFilters();
            this.cachedSize = -1;
            return this;
        }

        public PlaceInfo clearBannerInfo() {
            this.hasBannerInfo = false;
            this.bannerInfo_ = null;
            return this;
        }

        public PlaceInfo clearDActCard() {
            this.hasDActCard = false;
            this.dActCard_ = null;
            return this;
        }

        public PlaceInfo clearDBusinessId() {
            this.hasDBusinessId = false;
            this.dBusinessId_ = "";
            return this;
        }

        public PlaceInfo clearDBusinessType() {
            this.hasDBusinessType = false;
            this.dBusinessType_ = "";
            return this;
        }

        public PlaceInfo clearDDataType() {
            this.hasDDataType = false;
            this.dDataType_ = "";
            return this;
        }

        public PlaceInfo clearDFiltersShowFlag() {
            this.hasDFiltersShowFlag = false;
            this.dFiltersShowFlag_ = 0;
            return this;
        }

        public PlaceInfo clearDSortRule() {
            this.hasDSortRule = false;
            this.dSortRule_ = 0;
            return this;
        }

        public PlaceInfo clearDSortType() {
            this.hasDSortType = false;
            this.dSortType_ = "";
            return this;
        }

        public PlaceInfo clearDSubType() {
            this.hasDSubType = false;
            this.dSubType_ = "";
            return this;
        }

        public PlaceInfo clearFilters() {
            this.hasFilters = false;
            this.filters_ = ByteStringMicro.EMPTY;
            return this;
        }

        public PlaceInfo clearPreFilters() {
            this.hasPreFilters = false;
            this.preFilters_ = ByteStringMicro.EMPTY;
            return this;
        }

        public PlaceInfo clearSearchExt() {
            this.searchExt_ = Collections.emptyList();
            return this;
        }

        public PlaceInfo clearTabFilters() {
            this.hasTabFilters = false;
            this.tabFilters_ = ByteStringMicro.EMPTY;
            return this;
        }

        public BannerInfo getBannerInfo() {
            return this.bannerInfo_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public DActCard getDActCard() {
            return this.dActCard_;
        }

        public String getDBusinessId() {
            return this.dBusinessId_;
        }

        public String getDBusinessType() {
            return this.dBusinessType_;
        }

        public String getDDataType() {
            return this.dDataType_;
        }

        public int getDFiltersShowFlag() {
            return this.dFiltersShowFlag_;
        }

        public int getDSortRule() {
            return this.dSortRule_;
        }

        public String getDSortType() {
            return this.dSortType_;
        }

        public String getDSubType() {
            return this.dSubType_;
        }

        public ByteStringMicro getFilters() {
            return this.filters_;
        }

        public ByteStringMicro getPreFilters() {
            return this.preFilters_;
        }

        public SearchExt getSearchExt(int i) {
            return this.searchExt_.get(i);
        }

        public int getSearchExtCount() {
            return this.searchExt_.size();
        }

        public List<SearchExt> getSearchExtList() {
            return this.searchExt_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasDDataType() ? CodedOutputStreamMicro.computeStringSize(1, getDDataType()) : 0;
            if (hasDSortType()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDSortType());
            }
            if (hasDSortRule()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getDSortRule());
            }
            if (hasDFiltersShowFlag()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getDFiltersShowFlag());
            }
            if (hasDBusinessId()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getDBusinessId());
            }
            if (hasDBusinessType()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getDBusinessType());
            }
            Iterator<SearchExt> it = getSearchExtList().iterator();
            while (it.hasNext()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(7, it.next());
            }
            if (hasBannerInfo()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(8, getBannerInfo());
            }
            if (hasDActCard()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(9, getDActCard());
            }
            if (hasDSubType()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(10, getDSubType());
            }
            if (hasFilters()) {
                computeStringSize += CodedOutputStreamMicro.computeBytesSize(11, getFilters());
            }
            if (hasPreFilters()) {
                computeStringSize += CodedOutputStreamMicro.computeBytesSize(12, getPreFilters());
            }
            if (hasTabFilters()) {
                computeStringSize += CodedOutputStreamMicro.computeBytesSize(13, getTabFilters());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public ByteStringMicro getTabFilters() {
            return this.tabFilters_;
        }

        public boolean hasBannerInfo() {
            return this.hasBannerInfo;
        }

        public boolean hasDActCard() {
            return this.hasDActCard;
        }

        public boolean hasDBusinessId() {
            return this.hasDBusinessId;
        }

        public boolean hasDBusinessType() {
            return this.hasDBusinessType;
        }

        public boolean hasDDataType() {
            return this.hasDDataType;
        }

        public boolean hasDFiltersShowFlag() {
            return this.hasDFiltersShowFlag;
        }

        public boolean hasDSortRule() {
            return this.hasDSortRule;
        }

        public boolean hasDSortType() {
            return this.hasDSortType;
        }

        public boolean hasDSubType() {
            return this.hasDSubType;
        }

        public boolean hasFilters() {
            return this.hasFilters;
        }

        public boolean hasPreFilters() {
            return this.hasPreFilters;
        }

        public boolean hasTabFilters() {
            return this.hasTabFilters;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public PlaceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        setDDataType(codedInputStreamMicro.readString());
                        break;
                    case 18:
                        setDSortType(codedInputStreamMicro.readString());
                        break;
                    case 24:
                        setDSortRule(codedInputStreamMicro.readInt32());
                        break;
                    case 32:
                        setDFiltersShowFlag(codedInputStreamMicro.readInt32());
                        break;
                    case 42:
                        setDBusinessId(codedInputStreamMicro.readString());
                        break;
                    case 50:
                        setDBusinessType(codedInputStreamMicro.readString());
                        break;
                    case 58:
                        SearchExt searchExt = new SearchExt();
                        codedInputStreamMicro.readMessage(searchExt);
                        addSearchExt(searchExt);
                        break;
                    case 66:
                        BannerInfo bannerInfo = new BannerInfo();
                        codedInputStreamMicro.readMessage(bannerInfo);
                        setBannerInfo(bannerInfo);
                        break;
                    case 74:
                        DActCard dActCard = new DActCard();
                        codedInputStreamMicro.readMessage(dActCard);
                        setDActCard(dActCard);
                        break;
                    case 82:
                        setDSubType(codedInputStreamMicro.readString());
                        break;
                    case 90:
                        setFilters(codedInputStreamMicro.readBytes());
                        break;
                    case 98:
                        setPreFilters(codedInputStreamMicro.readBytes());
                        break;
                    case 106:
                        setTabFilters(codedInputStreamMicro.readBytes());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public PlaceInfo setBannerInfo(BannerInfo bannerInfo) {
            if (bannerInfo == null) {
                return clearBannerInfo();
            }
            this.hasBannerInfo = true;
            this.bannerInfo_ = bannerInfo;
            return this;
        }

        public PlaceInfo setDActCard(DActCard dActCard) {
            if (dActCard == null) {
                return clearDActCard();
            }
            this.hasDActCard = true;
            this.dActCard_ = dActCard;
            return this;
        }

        public PlaceInfo setDBusinessId(String str) {
            this.hasDBusinessId = true;
            this.dBusinessId_ = str;
            return this;
        }

        public PlaceInfo setDBusinessType(String str) {
            this.hasDBusinessType = true;
            this.dBusinessType_ = str;
            return this;
        }

        public PlaceInfo setDDataType(String str) {
            this.hasDDataType = true;
            this.dDataType_ = str;
            return this;
        }

        public PlaceInfo setDFiltersShowFlag(int i) {
            this.hasDFiltersShowFlag = true;
            this.dFiltersShowFlag_ = i;
            return this;
        }

        public PlaceInfo setDSortRule(int i) {
            this.hasDSortRule = true;
            this.dSortRule_ = i;
            return this;
        }

        public PlaceInfo setDSortType(String str) {
            this.hasDSortType = true;
            this.dSortType_ = str;
            return this;
        }

        public PlaceInfo setDSubType(String str) {
            this.hasDSubType = true;
            this.dSubType_ = str;
            return this;
        }

        public PlaceInfo setFilters(ByteStringMicro byteStringMicro) {
            this.hasFilters = true;
            this.filters_ = byteStringMicro;
            return this;
        }

        public PlaceInfo setPreFilters(ByteStringMicro byteStringMicro) {
            this.hasPreFilters = true;
            this.preFilters_ = byteStringMicro;
            return this;
        }

        public PlaceInfo setSearchExt(int i, SearchExt searchExt) {
            if (searchExt == null) {
                return this;
            }
            this.searchExt_.set(i, searchExt);
            return this;
        }

        public PlaceInfo setTabFilters(ByteStringMicro byteStringMicro) {
            this.hasTabFilters = true;
            this.tabFilters_ = byteStringMicro;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDDataType()) {
                codedOutputStreamMicro.writeString(1, getDDataType());
            }
            if (hasDSortType()) {
                codedOutputStreamMicro.writeString(2, getDSortType());
            }
            if (hasDSortRule()) {
                codedOutputStreamMicro.writeInt32(3, getDSortRule());
            }
            if (hasDFiltersShowFlag()) {
                codedOutputStreamMicro.writeInt32(4, getDFiltersShowFlag());
            }
            if (hasDBusinessId()) {
                codedOutputStreamMicro.writeString(5, getDBusinessId());
            }
            if (hasDBusinessType()) {
                codedOutputStreamMicro.writeString(6, getDBusinessType());
            }
            Iterator<SearchExt> it = getSearchExtList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(7, it.next());
            }
            if (hasBannerInfo()) {
                codedOutputStreamMicro.writeMessage(8, getBannerInfo());
            }
            if (hasDActCard()) {
                codedOutputStreamMicro.writeMessage(9, getDActCard());
            }
            if (hasDSubType()) {
                codedOutputStreamMicro.writeString(10, getDSubType());
            }
            if (hasFilters()) {
                codedOutputStreamMicro.writeBytes(11, getFilters());
            }
            if (hasPreFilters()) {
                codedOutputStreamMicro.writeBytes(12, getPreFilters());
            }
            if (hasTabFilters()) {
                codedOutputStreamMicro.writeBytes(13, getTabFilters());
            }
        }

        public static PlaceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PlaceInfo) new PlaceInfo().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class PreviousCity extends MessageMicro {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        private boolean hasCode;
        private boolean hasName;
        private int code_ = 0;
        private String name_ = "";
        private int cachedSize = -1;

        public static PreviousCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PreviousCity().mergeFrom(codedInputStreamMicro);
        }

        public final PreviousCity clear() {
            clearCode();
            clearName();
            this.cachedSize = -1;
            return this;
        }

        public PreviousCity clearCode() {
            this.hasCode = false;
            this.code_ = 0;
            return this;
        }

        public PreviousCity clearName() {
            this.hasName = false;
            this.name_ = "";
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

        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasCode() ? CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
            if (hasName()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
        }

        public boolean hasCode() {
            return this.hasCode;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public PreviousCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setCode(codedInputStreamMicro.readInt32());
                } else if (readTag == 18) {
                    setName(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public PreviousCity setCode(int i) {
            this.hasCode = true;
            this.code_ = i;
            return this;
        }

        public PreviousCity setName(String str) {
            this.hasName = true;
            this.name_ = str;
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
        }

        public static PreviousCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PreviousCity) new PreviousCity().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Psrs extends MessageMicro {
        public static final int SENUM_FIELD_NUMBER = 1;
        public static final int SERESULT_FIELD_NUMBER = 2;
        private boolean hasSENum;
        private int sENum_ = 0;
        private List<String> sEResult_ = Collections.emptyList();
        private int cachedSize = -1;

        public static Psrs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Psrs().mergeFrom(codedInputStreamMicro);
        }

        public Psrs addSEResult(String str) {
            str.getClass();
            if (this.sEResult_.isEmpty()) {
                this.sEResult_ = new ArrayList();
            }
            this.sEResult_.add(str);
            return this;
        }

        public final Psrs clear() {
            clearSENum();
            clearSEResult();
            this.cachedSize = -1;
            return this;
        }

        public Psrs clearSENum() {
            this.hasSENum = false;
            this.sENum_ = 0;
            return this;
        }

        public Psrs clearSEResult() {
            this.sEResult_ = Collections.emptyList();
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getSENum() {
            return this.sENum_;
        }

        public String getSEResult(int i) {
            return this.sEResult_.get(i);
        }

        public int getSEResultCount() {
            return this.sEResult_.size();
        }

        public List<String> getSEResultList() {
            return this.sEResult_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasSENum() ? CodedOutputStreamMicro.computeInt32Size(1, getSENum()) : 0;
            Iterator<String> it = getSEResultList().iterator();
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
            }
            int size = computeInt32Size + i + getSEResultList().size();
            this.cachedSize = size;
            return size;
        }

        public boolean hasSENum() {
            return this.hasSENum;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Psrs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setSENum(codedInputStreamMicro.readInt32());
                } else if (readTag == 18) {
                    addSEResult(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Psrs setSENum(int i) {
            this.hasSENum = true;
            this.sENum_ = i;
            return this;
        }

        public Psrs setSEResult(int i, String str) {
            str.getClass();
            this.sEResult_.set(i, str);
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSENum()) {
                codedOutputStreamMicro.writeInt32(1, getSENum());
            }
            Iterator<String> it = getSEResultList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeString(2, it.next());
            }
        }

        public static Psrs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Psrs) new Psrs().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class Recommend extends MessageMicro {
        public static final int REC_CONTENTS_FIELD_NUMBER = 1;
        public static final int TITLE_FIELD_NUMBER = 2;
        private boolean hasTitle;
        private List<RecContents> recContents_ = Collections.emptyList();
        private String title_ = "";
        private int cachedSize = -1;

        /* loaded from: classes7.dex */
        public static final class RecContents extends MessageMicro {
            public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 2;
            public static final int UID_FIELD_NUMBER = 1;
            private boolean hasCloudTemplate;
            private boolean hasName;
            private boolean hasUid;
            private String uid_ = "";
            private String name_ = "";
            private ByteStringMicro cloudTemplate_ = ByteStringMicro.EMPTY;
            private int cachedSize = -1;

            public static RecContents parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new RecContents().mergeFrom(codedInputStreamMicro);
            }

            public final RecContents clear() {
                clearUid();
                clearName();
                clearCloudTemplate();
                this.cachedSize = -1;
                return this;
            }

            public RecContents clearCloudTemplate() {
                this.hasCloudTemplate = false;
                this.cloudTemplate_ = ByteStringMicro.EMPTY;
                return this;
            }

            public RecContents clearName() {
                this.hasName = false;
                this.name_ = "";
                return this;
            }

            public RecContents clearUid() {
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

            public ByteStringMicro getCloudTemplate() {
                return this.cloudTemplate_;
            }

            public String getName() {
                return this.name_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int computeStringSize = hasUid() ? CodedOutputStreamMicro.computeStringSize(1, getUid()) : 0;
                if (hasName()) {
                    computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                }
                if (hasCloudTemplate()) {
                    computeStringSize += CodedOutputStreamMicro.computeBytesSize(3, getCloudTemplate());
                }
                this.cachedSize = computeStringSize;
                return computeStringSize;
            }

            public String getUid() {
                return this.uid_;
            }

            public boolean hasCloudTemplate() {
                return this.hasCloudTemplate;
            }

            public boolean hasName() {
                return this.hasName;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public RecContents mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        setUid(codedInputStreamMicro.readString());
                    } else if (readTag == 18) {
                        setName(codedInputStreamMicro.readString());
                    } else if (readTag == 26) {
                        setCloudTemplate(codedInputStreamMicro.readBytes());
                    } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                }
            }

            public RecContents setCloudTemplate(ByteStringMicro byteStringMicro) {
                this.hasCloudTemplate = true;
                this.cloudTemplate_ = byteStringMicro;
                return this;
            }

            public RecContents setName(String str) {
                this.hasName = true;
                this.name_ = str;
                return this;
            }

            public RecContents setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(1, getUid());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(2, getName());
                }
                if (hasCloudTemplate()) {
                    codedOutputStreamMicro.writeBytes(3, getCloudTemplate());
                }
            }

            public static RecContents parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (RecContents) new RecContents().mergeFrom(bArr);
            }
        }

        public static Recommend parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Recommend().mergeFrom(codedInputStreamMicro);
        }

        public Recommend addRecContents(RecContents recContents) {
            if (recContents == null) {
                return this;
            }
            if (this.recContents_.isEmpty()) {
                this.recContents_ = new ArrayList();
            }
            this.recContents_.add(recContents);
            return this;
        }

        public final Recommend clear() {
            clearRecContents();
            clearTitle();
            this.cachedSize = -1;
            return this;
        }

        public Recommend clearRecContents() {
            this.recContents_ = Collections.emptyList();
            return this;
        }

        public Recommend clearTitle() {
            this.hasTitle = false;
            this.title_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public RecContents getRecContents(int i) {
            return this.recContents_.get(i);
        }

        public int getRecContentsCount() {
            return this.recContents_.size();
        }

        public List<RecContents> getRecContentsList() {
            return this.recContents_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            Iterator<RecContents> it = getRecContentsList().iterator();
            int i = 0;
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeMessageSize(1, it.next());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            this.cachedSize = i;
            return i;
        }

        public String getTitle() {
            return this.title_;
        }

        public boolean hasTitle() {
            return this.hasTitle;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Recommend mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    RecContents recContents = new RecContents();
                    codedInputStreamMicro.readMessage(recContents);
                    addRecContents(recContents);
                } else if (readTag == 18) {
                    setTitle(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public Recommend setRecContents(int i, RecContents recContents) {
            if (recContents == null) {
                return this;
            }
            this.recContents_.set(i, recContents);
            return this;
        }

        public Recommend setTitle(String str) {
            this.hasTitle = true;
            this.title_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            Iterator<RecContents> it = getRecContentsList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(1, it.next());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
        }

        public static Recommend parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Recommend) new Recommend().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ShareInfo extends MessageMicro {
        public static final int CONTENT_FIELD_NUMBER = 3;
        public static final int QUERY_FIELD_NUMBER = 1;
        public static final int TIPS_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 4;
        private boolean hasContent;
        private boolean hasQuery;
        private boolean hasTips;
        private boolean hasUrl;
        private String query_ = "";
        private String tips_ = "";
        private String content_ = "";
        private String url_ = "";
        private int cachedSize = -1;

        public static ShareInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ShareInfo().mergeFrom(codedInputStreamMicro);
        }

        public final ShareInfo clear() {
            clearQuery();
            clearTips();
            clearContent();
            clearUrl();
            this.cachedSize = -1;
            return this;
        }

        public ShareInfo clearContent() {
            this.hasContent = false;
            this.content_ = "";
            return this;
        }

        public ShareInfo clearQuery() {
            this.hasQuery = false;
            this.query_ = "";
            return this;
        }

        public ShareInfo clearTips() {
            this.hasTips = false;
            this.tips_ = "";
            return this;
        }

        public ShareInfo clearUrl() {
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

        public String getContent() {
            return this.content_;
        }

        public String getQuery() {
            return this.query_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasQuery() ? CodedOutputStreamMicro.computeStringSize(1, getQuery()) : 0;
            if (hasTips()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getTips());
            }
            if (hasContent()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getContent());
            }
            if (hasUrl()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getUrl());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public String getTips() {
            return this.tips_;
        }

        public String getUrl() {
            return this.url_;
        }

        public boolean hasContent() {
            return this.hasContent;
        }

        public boolean hasQuery() {
            return this.hasQuery;
        }

        public boolean hasTips() {
            return this.hasTips;
        }

        public boolean hasUrl() {
            return this.hasUrl;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public ShareInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setQuery(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setTips(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    setContent(codedInputStreamMicro.readString());
                } else if (readTag == 34) {
                    setUrl(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public ShareInfo setContent(String str) {
            this.hasContent = true;
            this.content_ = str;
            return this;
        }

        public ShareInfo setQuery(String str) {
            this.hasQuery = true;
            this.query_ = str;
            return this;
        }

        public ShareInfo setTips(String str) {
            this.hasTips = true;
            this.tips_ = str;
            return this;
        }

        public ShareInfo setUrl(String str) {
            this.hasUrl = true;
            this.url_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasQuery()) {
                codedOutputStreamMicro.writeString(1, getQuery());
            }
            if (hasTips()) {
                codedOutputStreamMicro.writeString(2, getTips());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(3, getContent());
            }
            if (hasUrl()) {
                codedOutputStreamMicro.writeString(4, getUrl());
            }
        }

        public static ShareInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ShareInfo) new ShareInfo().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class StreetImg extends MessageMicro {
        public static final int ICON_URL_FIELD_NUMBER = 2;
        public static final int JUMP_URL_FIELD_NUMBER = 4;
        public static final int LABEL_URL_FIELD_NUMBER = 3;
        public static final int LINK_FIELD_NUMBER = 1;
        private boolean hasIconUrl;
        private boolean hasJumpUrl;
        private boolean hasLabelUrl;
        private boolean hasLink;
        private String link_ = "";
        private String iconUrl_ = "";
        private String labelUrl_ = "";
        private String jumpUrl_ = "";
        private int cachedSize = -1;

        public static StreetImg parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new StreetImg().mergeFrom(codedInputStreamMicro);
        }

        public final StreetImg clear() {
            clearLink();
            clearIconUrl();
            clearLabelUrl();
            clearJumpUrl();
            this.cachedSize = -1;
            return this;
        }

        public StreetImg clearIconUrl() {
            this.hasIconUrl = false;
            this.iconUrl_ = "";
            return this;
        }

        public StreetImg clearJumpUrl() {
            this.hasJumpUrl = false;
            this.jumpUrl_ = "";
            return this;
        }

        public StreetImg clearLabelUrl() {
            this.hasLabelUrl = false;
            this.labelUrl_ = "";
            return this;
        }

        public StreetImg clearLink() {
            this.hasLink = false;
            this.link_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getIconUrl() {
            return this.iconUrl_;
        }

        public String getJumpUrl() {
            return this.jumpUrl_;
        }

        public String getLabelUrl() {
            return this.labelUrl_;
        }

        public String getLink() {
            return this.link_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasLink() ? CodedOutputStreamMicro.computeStringSize(1, getLink()) : 0;
            if (hasIconUrl()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getIconUrl());
            }
            if (hasLabelUrl()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getLabelUrl());
            }
            if (hasJumpUrl()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getJumpUrl());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public boolean hasIconUrl() {
            return this.hasIconUrl;
        }

        public boolean hasJumpUrl() {
            return this.hasJumpUrl;
        }

        public boolean hasLabelUrl() {
            return this.hasLabelUrl;
        }

        public boolean hasLink() {
            return this.hasLink;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public StreetImg mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setLink(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setIconUrl(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    setLabelUrl(codedInputStreamMicro.readString());
                } else if (readTag == 34) {
                    setJumpUrl(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public StreetImg setIconUrl(String str) {
            this.hasIconUrl = true;
            this.iconUrl_ = str;
            return this;
        }

        public StreetImg setJumpUrl(String str) {
            this.hasJumpUrl = true;
            this.jumpUrl_ = str;
            return this;
        }

        public StreetImg setLabelUrl(String str) {
            this.hasLabelUrl = true;
            this.labelUrl_ = str;
            return this;
        }

        public StreetImg setLink(String str) {
            this.hasLink = true;
            this.link_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLink()) {
                codedOutputStreamMicro.writeString(1, getLink());
            }
            if (hasIconUrl()) {
                codedOutputStreamMicro.writeString(2, getIconUrl());
            }
            if (hasLabelUrl()) {
                codedOutputStreamMicro.writeString(3, getLabelUrl());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(4, getJumpUrl());
            }
        }

        public static StreetImg parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (StreetImg) new StreetImg().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class SugRecInteractiveInfo extends MessageMicro {
        public static final int NUM_FIELD_NUMBER = 2;
        public static final int STATUS_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        private boolean hasNum;
        private boolean hasStatus;
        private boolean hasType;
        private String type_ = "";
        private int num_ = 0;
        private int status_ = 0;
        private int cachedSize = -1;

        public static SugRecInteractiveInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SugRecInteractiveInfo().mergeFrom(codedInputStreamMicro);
        }

        public final SugRecInteractiveInfo clear() {
            clearType();
            clearNum();
            clearStatus();
            this.cachedSize = -1;
            return this;
        }

        public SugRecInteractiveInfo clearNum() {
            this.hasNum = false;
            this.num_ = 0;
            return this;
        }

        public SugRecInteractiveInfo clearStatus() {
            this.hasStatus = false;
            this.status_ = 0;
            return this;
        }

        public SugRecInteractiveInfo clearType() {
            this.hasType = false;
            this.type_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getNum() {
            return this.num_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasType() ? CodedOutputStreamMicro.computeStringSize(1, getType()) : 0;
            if (hasNum()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getNum());
            }
            if (hasStatus()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getStatus());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public int getStatus() {
            return this.status_;
        }

        public String getType() {
            return this.type_;
        }

        public boolean hasNum() {
            return this.hasNum;
        }

        public boolean hasStatus() {
            return this.hasStatus;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public SugRecInteractiveInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setType(codedInputStreamMicro.readString());
                } else if (readTag == 16) {
                    setNum(codedInputStreamMicro.readInt32());
                } else if (readTag == 24) {
                    setStatus(codedInputStreamMicro.readInt32());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public SugRecInteractiveInfo setNum(int i) {
            this.hasNum = true;
            this.num_ = i;
            return this;
        }

        public SugRecInteractiveInfo setStatus(int i) {
            this.hasStatus = true;
            this.status_ = i;
            return this;
        }

        public SugRecInteractiveInfo setType(String str) {
            this.hasType = true;
            this.type_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasType()) {
                codedOutputStreamMicro.writeString(1, getType());
            }
            if (hasNum()) {
                codedOutputStreamMicro.writeInt32(2, getNum());
            }
            if (hasStatus()) {
                codedOutputStreamMicro.writeInt32(3, getStatus());
            }
        }

        public static SugRecInteractiveInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SugRecInteractiveInfo) new SugRecInteractiveInfo().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class SugRecResult extends MessageMicro {
        public static final int FAVORITE_FIELD_NUMBER = 5;
        public static final int FILTER_FIELD_NUMBER = 2;
        public static final int MYSTIQUE_DATA_FIELD_NUMBER = 3;
        public static final int SHARE_INFO_FIELD_NUMBER = 4;
        public static final int SUG_REC_INTERACTIVE_INFO_FIELD_NUMBER = 6;
        public static final int TIPS_FIELD_NUMBER = 1;
        private boolean hasFavorite;
        private boolean hasFilter;
        private boolean hasShareInfo;
        private boolean hasTips;
        private String tips_ = "";
        private String filter_ = "";
        private List<String> mystiqueData_ = Collections.emptyList();
        private ShareInfo shareInfo_ = null;
        private String favorite_ = "";
        private List<SugRecInteractiveInfo> sugRecInteractiveInfo_ = Collections.emptyList();
        private int cachedSize = -1;

        public static SugRecResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SugRecResult().mergeFrom(codedInputStreamMicro);
        }

        public SugRecResult addMystiqueData(String str) {
            str.getClass();
            if (this.mystiqueData_.isEmpty()) {
                this.mystiqueData_ = new ArrayList();
            }
            this.mystiqueData_.add(str);
            return this;
        }

        public SugRecResult addSugRecInteractiveInfo(SugRecInteractiveInfo sugRecInteractiveInfo) {
            if (sugRecInteractiveInfo == null) {
                return this;
            }
            if (this.sugRecInteractiveInfo_.isEmpty()) {
                this.sugRecInteractiveInfo_ = new ArrayList();
            }
            this.sugRecInteractiveInfo_.add(sugRecInteractiveInfo);
            return this;
        }

        public final SugRecResult clear() {
            clearTips();
            clearFilter();
            clearMystiqueData();
            clearShareInfo();
            clearFavorite();
            clearSugRecInteractiveInfo();
            this.cachedSize = -1;
            return this;
        }

        public SugRecResult clearFavorite() {
            this.hasFavorite = false;
            this.favorite_ = "";
            return this;
        }

        public SugRecResult clearFilter() {
            this.hasFilter = false;
            this.filter_ = "";
            return this;
        }

        public SugRecResult clearMystiqueData() {
            this.mystiqueData_ = Collections.emptyList();
            return this;
        }

        public SugRecResult clearShareInfo() {
            this.hasShareInfo = false;
            this.shareInfo_ = null;
            return this;
        }

        public SugRecResult clearSugRecInteractiveInfo() {
            this.sugRecInteractiveInfo_ = Collections.emptyList();
            return this;
        }

        public SugRecResult clearTips() {
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

        public String getFavorite() {
            return this.favorite_;
        }

        public String getFilter() {
            return this.filter_;
        }

        public String getMystiqueData(int i) {
            return this.mystiqueData_.get(i);
        }

        public int getMystiqueDataCount() {
            return this.mystiqueData_.size();
        }

        public List<String> getMystiqueDataList() {
            return this.mystiqueData_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasTips() ? CodedOutputStreamMicro.computeStringSize(1, getTips()) : 0;
            if (hasFilter()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getFilter());
            }
            Iterator<String> it = getMystiqueDataList().iterator();
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
            }
            int size = computeStringSize + i + getMystiqueDataList().size();
            if (hasShareInfo()) {
                size += CodedOutputStreamMicro.computeMessageSize(4, getShareInfo());
            }
            if (hasFavorite()) {
                size += CodedOutputStreamMicro.computeStringSize(5, getFavorite());
            }
            Iterator<SugRecInteractiveInfo> it2 = getSugRecInteractiveInfoList().iterator();
            while (it2.hasNext()) {
                size += CodedOutputStreamMicro.computeMessageSize(6, it2.next());
            }
            this.cachedSize = size;
            return size;
        }

        public ShareInfo getShareInfo() {
            return this.shareInfo_;
        }

        public SugRecInteractiveInfo getSugRecInteractiveInfo(int i) {
            return this.sugRecInteractiveInfo_.get(i);
        }

        public int getSugRecInteractiveInfoCount() {
            return this.sugRecInteractiveInfo_.size();
        }

        public List<SugRecInteractiveInfo> getSugRecInteractiveInfoList() {
            return this.sugRecInteractiveInfo_;
        }

        public String getTips() {
            return this.tips_;
        }

        public boolean hasFavorite() {
            return this.hasFavorite;
        }

        public boolean hasFilter() {
            return this.hasFilter;
        }

        public boolean hasShareInfo() {
            return this.hasShareInfo;
        }

        public boolean hasTips() {
            return this.hasTips;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public SugRecResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setTips(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setFilter(codedInputStreamMicro.readString());
                } else if (readTag == 26) {
                    addMystiqueData(codedInputStreamMicro.readString());
                } else if (readTag == 34) {
                    ShareInfo shareInfo = new ShareInfo();
                    codedInputStreamMicro.readMessage(shareInfo);
                    setShareInfo(shareInfo);
                } else if (readTag == 42) {
                    setFavorite(codedInputStreamMicro.readString());
                } else if (readTag == 50) {
                    SugRecInteractiveInfo sugRecInteractiveInfo = new SugRecInteractiveInfo();
                    codedInputStreamMicro.readMessage(sugRecInteractiveInfo);
                    addSugRecInteractiveInfo(sugRecInteractiveInfo);
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public SugRecResult setFavorite(String str) {
            this.hasFavorite = true;
            this.favorite_ = str;
            return this;
        }

        public SugRecResult setFilter(String str) {
            this.hasFilter = true;
            this.filter_ = str;
            return this;
        }

        public SugRecResult setMystiqueData(int i, String str) {
            str.getClass();
            this.mystiqueData_.set(i, str);
            return this;
        }

        public SugRecResult setShareInfo(ShareInfo shareInfo) {
            if (shareInfo == null) {
                return clearShareInfo();
            }
            this.hasShareInfo = true;
            this.shareInfo_ = shareInfo;
            return this;
        }

        public SugRecResult setSugRecInteractiveInfo(int i, SugRecInteractiveInfo sugRecInteractiveInfo) {
            if (sugRecInteractiveInfo == null) {
                return this;
            }
            this.sugRecInteractiveInfo_.set(i, sugRecInteractiveInfo);
            return this;
        }

        public SugRecResult setTips(String str) {
            this.hasTips = true;
            this.tips_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTips()) {
                codedOutputStreamMicro.writeString(1, getTips());
            }
            if (hasFilter()) {
                codedOutputStreamMicro.writeString(2, getFilter());
            }
            Iterator<String> it = getMystiqueDataList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeString(3, it.next());
            }
            if (hasShareInfo()) {
                codedOutputStreamMicro.writeMessage(4, getShareInfo());
            }
            if (hasFavorite()) {
                codedOutputStreamMicro.writeString(5, getFavorite());
            }
            Iterator<SugRecInteractiveInfo> it2 = getSugRecInteractiveInfoList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeMessage(6, it2.next());
            }
        }

        public static SugRecResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SugRecResult) new SugRecResult().mergeFrom(bArr);
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

    /* loaded from: classes7.dex */
    public static final class TalosData extends MessageMicro {
        public static final int LIST_DATA_FIELD_NUMBER = 1;
        private boolean hasListData;
        private String listData_ = "";
        private int cachedSize = -1;

        public static TalosData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TalosData().mergeFrom(codedInputStreamMicro);
        }

        public final TalosData clear() {
            clearListData();
            this.cachedSize = -1;
            return this;
        }

        public TalosData clearListData() {
            this.hasListData = false;
            this.listData_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getListData() {
            return this.listData_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasListData() ? CodedOutputStreamMicro.computeStringSize(1, getListData()) : 0;
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public boolean hasListData() {
            return this.hasListData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public TalosData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setListData(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public TalosData setListData(String str) {
            this.hasListData = true;
            this.listData_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasListData()) {
                codedOutputStreamMicro.writeString(1, getListData());
            }
        }

        public static TalosData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TalosData) new TalosData().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ThirdParty extends MessageMicro {
        public static final int FROM_FIELD_NUMBER = 5;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int NEED_GEO_FIELD_NUMBER = 3;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private boolean hasFrom;
        private boolean hasName;
        private boolean hasNeedGeo;
        private boolean hasX;
        private boolean hasY;
        private String x_ = "";
        private String y_ = "";
        private boolean needGeo_ = false;
        private String name_ = "";
        private String from_ = "";
        private int cachedSize = -1;

        public static ThirdParty parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ThirdParty().mergeFrom(codedInputStreamMicro);
        }

        public final ThirdParty clear() {
            clearX();
            clearY();
            clearNeedGeo();
            clearName();
            clearFrom();
            this.cachedSize = -1;
            return this;
        }

        public ThirdParty clearFrom() {
            this.hasFrom = false;
            this.from_ = "";
            return this;
        }

        public ThirdParty clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public ThirdParty clearNeedGeo() {
            this.hasNeedGeo = false;
            this.needGeo_ = false;
            return this;
        }

        public ThirdParty clearX() {
            this.hasX = false;
            this.x_ = "";
            return this;
        }

        public ThirdParty clearY() {
            this.hasY = false;
            this.y_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getFrom() {
            return this.from_;
        }

        public String getName() {
            return this.name_;
        }

        public boolean getNeedGeo() {
            return this.needGeo_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeStringSize = hasX() ? CodedOutputStreamMicro.computeStringSize(1, getX()) : 0;
            if (hasY()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getY());
            }
            if (hasNeedGeo()) {
                computeStringSize += CodedOutputStreamMicro.computeBoolSize(3, getNeedGeo());
            }
            if (hasName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(4, getName());
            }
            if (hasFrom()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getFrom());
            }
            this.cachedSize = computeStringSize;
            return computeStringSize;
        }

        public String getX() {
            return this.x_;
        }

        public String getY() {
            return this.y_;
        }

        public boolean hasFrom() {
            return this.hasFrom;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasNeedGeo() {
            return this.hasNeedGeo;
        }

        public boolean hasX() {
            return this.hasX;
        }

        public boolean hasY() {
            return this.hasY;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public ThirdParty mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    setX(codedInputStreamMicro.readString());
                } else if (readTag == 18) {
                    setY(codedInputStreamMicro.readString());
                } else if (readTag == 24) {
                    setNeedGeo(codedInputStreamMicro.readBool());
                } else if (readTag == 34) {
                    setName(codedInputStreamMicro.readString());
                } else if (readTag == 42) {
                    setFrom(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public ThirdParty setFrom(String str) {
            this.hasFrom = true;
            this.from_ = str;
            return this;
        }

        public ThirdParty setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public ThirdParty setNeedGeo(boolean z) {
            this.hasNeedGeo = true;
            this.needGeo_ = z;
            return this;
        }

        public ThirdParty setX(String str) {
            this.hasX = true;
            this.x_ = str;
            return this;
        }

        public ThirdParty setY(String str) {
            this.hasY = true;
            this.y_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasX()) {
                codedOutputStreamMicro.writeString(1, getX());
            }
            if (hasY()) {
                codedOutputStreamMicro.writeString(2, getY());
            }
            if (hasNeedGeo()) {
                codedOutputStreamMicro.writeBool(3, getNeedGeo());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(4, getName());
            }
            if (hasFrom()) {
                codedOutputStreamMicro.writeString(5, getFrom());
            }
        }

        public static ThirdParty parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ThirdParty) new ThirdParty().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class VuiProcessData extends MessageMicro {
        public static final int CHOOSETEMPLATE_FIELD_NUMBER = 5;
        public static final int DYN_REQUEST_FIELD_NUMBER = 1;
        public static final int DYN_RESPONSE_FIELD_NUMBER = 2;
        public static final int DYN_ZHANWEI_FIELD_NUMBER = 3;
        public static final int TRADE_FIELD_NUMBER = 4;
        private boolean hasChooseTemplate;
        private boolean hasDynRequest;
        private boolean hasDynResponse;
        private boolean hasTrade;
        private boolean dynRequest_ = false;
        private boolean dynResponse_ = false;
        private List<Integer> dynZhanwei_ = Collections.emptyList();
        private String trade_ = "";
        private String chooseTemplate_ = "";
        private int cachedSize = -1;

        public static VuiProcessData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new VuiProcessData().mergeFrom(codedInputStreamMicro);
        }

        public VuiProcessData addDynZhanwei(int i) {
            if (this.dynZhanwei_.isEmpty()) {
                this.dynZhanwei_ = new ArrayList();
            }
            this.dynZhanwei_.add(Integer.valueOf(i));
            return this;
        }

        public final VuiProcessData clear() {
            clearDynRequest();
            clearDynResponse();
            clearDynZhanwei();
            clearTrade();
            clearChooseTemplate();
            this.cachedSize = -1;
            return this;
        }

        public VuiProcessData clearChooseTemplate() {
            this.hasChooseTemplate = false;
            this.chooseTemplate_ = "";
            return this;
        }

        public VuiProcessData clearDynRequest() {
            this.hasDynRequest = false;
            this.dynRequest_ = false;
            return this;
        }

        public VuiProcessData clearDynResponse() {
            this.hasDynResponse = false;
            this.dynResponse_ = false;
            return this;
        }

        public VuiProcessData clearDynZhanwei() {
            this.dynZhanwei_ = Collections.emptyList();
            return this;
        }

        public VuiProcessData clearTrade() {
            this.hasTrade = false;
            this.trade_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getChooseTemplate() {
            return this.chooseTemplate_;
        }

        public boolean getDynRequest() {
            return this.dynRequest_;
        }

        public boolean getDynResponse() {
            return this.dynResponse_;
        }

        public int getDynZhanwei(int i) {
            return this.dynZhanwei_.get(i).intValue();
        }

        public int getDynZhanweiCount() {
            return this.dynZhanwei_.size();
        }

        public List<Integer> getDynZhanweiList() {
            return this.dynZhanwei_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int i = 0;
            int computeBoolSize = hasDynRequest() ? CodedOutputStreamMicro.computeBoolSize(1, getDynRequest()) : 0;
            if (hasDynResponse()) {
                computeBoolSize += CodedOutputStreamMicro.computeBoolSize(2, getDynResponse());
            }
            Iterator<Integer> it = getDynZhanweiList().iterator();
            while (it.hasNext()) {
                i += CodedOutputStreamMicro.computeInt32SizeNoTag(it.next().intValue());
            }
            int size = computeBoolSize + i + getDynZhanweiList().size();
            if (hasTrade()) {
                size += CodedOutputStreamMicro.computeStringSize(4, getTrade());
            }
            if (hasChooseTemplate()) {
                size += CodedOutputStreamMicro.computeStringSize(5, getChooseTemplate());
            }
            this.cachedSize = size;
            return size;
        }

        public String getTrade() {
            return this.trade_;
        }

        public boolean hasChooseTemplate() {
            return this.hasChooseTemplate;
        }

        public boolean hasDynRequest() {
            return this.hasDynRequest;
        }

        public boolean hasDynResponse() {
            return this.hasDynResponse;
        }

        public boolean hasTrade() {
            return this.hasTrade;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public VuiProcessData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setDynRequest(codedInputStreamMicro.readBool());
                } else if (readTag == 16) {
                    setDynResponse(codedInputStreamMicro.readBool());
                } else if (readTag == 24) {
                    addDynZhanwei(codedInputStreamMicro.readInt32());
                } else if (readTag == 34) {
                    setTrade(codedInputStreamMicro.readString());
                } else if (readTag == 42) {
                    setChooseTemplate(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public VuiProcessData setChooseTemplate(String str) {
            this.hasChooseTemplate = true;
            this.chooseTemplate_ = str;
            return this;
        }

        public VuiProcessData setDynRequest(boolean z) {
            this.hasDynRequest = true;
            this.dynRequest_ = z;
            return this;
        }

        public VuiProcessData setDynResponse(boolean z) {
            this.hasDynResponse = true;
            this.dynResponse_ = z;
            return this;
        }

        public VuiProcessData setDynZhanwei(int i, int i2) {
            this.dynZhanwei_.set(i, Integer.valueOf(i2));
            return this;
        }

        public VuiProcessData setTrade(String str) {
            this.hasTrade = true;
            this.trade_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDynRequest()) {
                codedOutputStreamMicro.writeBool(1, getDynRequest());
            }
            if (hasDynResponse()) {
                codedOutputStreamMicro.writeBool(2, getDynResponse());
            }
            Iterator<Integer> it = getDynZhanweiList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeInt32(3, it.next().intValue());
            }
            if (hasTrade()) {
                codedOutputStreamMicro.writeString(4, getTrade());
            }
            if (hasChooseTemplate()) {
                codedOutputStreamMicro.writeString(5, getChooseTemplate());
            }
        }

        public static VuiProcessData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (VuiProcessData) new VuiProcessData().mergeFrom(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class WidgetBar extends MessageMicro {
        public static final int EXT_FIELD_NUMBER = 3;
        public static final int IS_SHOW_FIELD_NUMBER = 2;
        public static final int WIDGET_CARD_ID_FIELD_NUMBER = 1;
        private boolean hasExt;
        private boolean hasIsShow;
        private boolean hasWidgetCardId;
        private int widgetCardId_ = 0;
        private int isShow_ = 0;
        private String ext_ = "";
        private int cachedSize = -1;

        public static WidgetBar parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new WidgetBar().mergeFrom(codedInputStreamMicro);
        }

        public final WidgetBar clear() {
            clearWidgetCardId();
            clearIsShow();
            clearExt();
            this.cachedSize = -1;
            return this;
        }

        public WidgetBar clearExt() {
            this.hasExt = false;
            this.ext_ = "";
            return this;
        }

        public WidgetBar clearIsShow() {
            this.hasIsShow = false;
            this.isShow_ = 0;
            return this;
        }

        public WidgetBar clearWidgetCardId() {
            this.hasWidgetCardId = false;
            this.widgetCardId_ = 0;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public String getExt() {
            return this.ext_;
        }

        public int getIsShow() {
            return this.isShow_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int computeInt32Size = hasWidgetCardId() ? CodedOutputStreamMicro.computeInt32Size(1, getWidgetCardId()) : 0;
            if (hasIsShow()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getIsShow());
            }
            if (hasExt()) {
                computeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getExt());
            }
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
        }

        public int getWidgetCardId() {
            return this.widgetCardId_;
        }

        public boolean hasExt() {
            return this.hasExt;
        }

        public boolean hasIsShow() {
            return this.hasIsShow;
        }

        public boolean hasWidgetCardId() {
            return this.hasWidgetCardId;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public WidgetBar mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    setWidgetCardId(codedInputStreamMicro.readInt32());
                } else if (readTag == 16) {
                    setIsShow(codedInputStreamMicro.readInt32());
                } else if (readTag == 26) {
                    setExt(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            }
        }

        public WidgetBar setExt(String str) {
            this.hasExt = true;
            this.ext_ = str;
            return this;
        }

        public WidgetBar setIsShow(int i) {
            this.hasIsShow = true;
            this.isShow_ = i;
            return this;
        }

        public WidgetBar setWidgetCardId(int i) {
            this.hasWidgetCardId = true;
            this.widgetCardId_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasWidgetCardId()) {
                codedOutputStreamMicro.writeInt32(1, getWidgetCardId());
            }
            if (hasIsShow()) {
                codedOutputStreamMicro.writeInt32(2, getIsShow());
            }
            if (hasExt()) {
                codedOutputStreamMicro.writeString(3, getExt());
            }
        }

        public static WidgetBar parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (WidgetBar) new WidgetBar().mergeFrom(bArr);
        }
    }

    public static PoiResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult().mergeFrom(codedInputStreamMicro);
    }

    public PoiResult addAddrs(Addrs addrs) {
        if (addrs == null) {
            return this;
        }
        if (this.addrs_.isEmpty()) {
            this.addrs_ = new ArrayList();
        }
        this.addrs_.add(addrs);
        return this;
    }

    public PoiResult addAds(Ads ads) {
        if (ads == null) {
            return this;
        }
        if (this.ads_.isEmpty()) {
            this.ads_ = new ArrayList();
        }
        this.ads_.add(ads);
        return this;
    }

    public PoiResult addChildren(Children children) {
        if (children == null) {
            return this;
        }
        if (this.children_.isEmpty()) {
            this.children_ = new ArrayList();
        }
        this.children_.add(children);
        return this;
    }

    public PoiResult addContents(Contents contents) {
        if (contents == null) {
            return this;
        }
        if (this.contents_.isEmpty()) {
            this.contents_ = new ArrayList();
        }
        this.contents_.add(contents);
        return this;
    }

    public PoiResult addFloatIcons(FloatIcon floatIcon) {
        if (floatIcon == null) {
            return this;
        }
        if (this.floatIcons_.isEmpty()) {
            this.floatIcons_ = new ArrayList();
        }
        this.floatIcons_.add(floatIcon);
        return this;
    }

    public PoiResult addGuideTag(GuideTag guideTag) {
        if (guideTag == null) {
            return this;
        }
        if (this.guideTag_.isEmpty()) {
            this.guideTag_ = new ArrayList();
        }
        this.guideTag_.add(guideTag);
        return this;
    }

    public PoiResult addMystiqueList(MystiqueList mystiqueList) {
        if (mystiqueList == null) {
            return this;
        }
        if (this.mystiqueList_.isEmpty()) {
            this.mystiqueList_ = new ArrayList();
        }
        this.mystiqueList_.add(mystiqueList);
        return this;
    }

    public PoiResult addSuggestQuery(SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        if (this.suggestQuery_.isEmpty()) {
            this.suggestQuery_ = new ArrayList();
        }
        this.suggestQuery_.add(suggestQuery);
        return this;
    }

    public final PoiResult clear() {
        clearOption();
        clearAddrs();
        clearPsrs();
        clearSuggestQuery();
        clearPlaceInfo();
        clearContents();
        clearChildren();
        clearPreviousCity();
        clearCurrentCity();
        clearBrandBar();
        clearImgeExt();
        clearOffline();
        clearGuideTag();
        clearAds();
        clearAdsExtInfo();
        clearIndusInfo();
        clearRecommend();
        clearCorrectionInfo();
        clearCarPreload();
        clearSpeechFinalWord();
        clearImgBanner();
        clearMystiqueList();
        clearSugRecRes();
        clearHorizonSlideResult();
        clearEmptyResultDynamicCard();
        clearFloatIcons();
        clearSearchBoxBgImg();
        clearPopupWindow();
        clearWidgetBar();
        clearListAdsData();
        clearTalosData();
        this.cachedSize = -1;
        return this;
    }

    public PoiResult clearAddrs() {
        this.addrs_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearAds() {
        this.ads_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearAdsExtInfo() {
        this.hasAdsExtInfo = false;
        this.adsExtInfo_ = null;
        return this;
    }

    public PoiResult clearBrandBar() {
        this.hasBrandBar = false;
        this.brandBar_ = null;
        return this;
    }

    public PoiResult clearCarPreload() {
        this.hasCarPreload = false;
        this.carPreload_ = 0;
        return this;
    }

    public PoiResult clearChildren() {
        this.children_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearContents() {
        this.contents_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearCorrectionInfo() {
        this.hasCorrectionInfo = false;
        this.correctionInfo_ = null;
        return this;
    }

    public PoiResult clearCurrentCity() {
        this.hasCurrentCity = false;
        this.currentCity_ = null;
        return this;
    }

    public PoiResult clearEmptyResultDynamicCard() {
        this.hasEmptyResultDynamicCard = false;
        this.emptyResultDynamicCard_ = "";
        return this;
    }

    public PoiResult clearFloatIcons() {
        this.floatIcons_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearGuideTag() {
        this.guideTag_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearHorizonSlideResult() {
        this.hasHorizonSlideResult = false;
        this.horizonSlideResult_ = null;
        return this;
    }

    public PoiResult clearImgBanner() {
        this.hasImgBanner = false;
        this.imgBanner_ = null;
        return this;
    }

    public PoiResult clearImgeExt() {
        this.hasImgeExt = false;
        this.imgeExt_ = ByteStringMicro.EMPTY;
        return this;
    }

    public PoiResult clearIndusInfo() {
        this.hasIndusInfo = false;
        this.indusInfo_ = null;
        return this;
    }

    public PoiResult clearListAdsData() {
        this.hasListAdsData = false;
        this.listAdsData_ = null;
        return this;
    }

    public PoiResult clearMystiqueList() {
        this.mystiqueList_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearOffline() {
        this.hasOffline = false;
        this.offline_ = 0;
        return this;
    }

    public PoiResult clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public PoiResult clearPlaceInfo() {
        this.hasPlaceInfo = false;
        this.placeInfo_ = null;
        return this;
    }

    public PoiResult clearPopupWindow() {
        this.hasPopupWindow = false;
        this.popupWindow_ = "";
        return this;
    }

    public PoiResult clearPreviousCity() {
        this.hasPreviousCity = false;
        this.previousCity_ = null;
        return this;
    }

    public PoiResult clearPsrs() {
        this.hasPsrs = false;
        this.psrs_ = null;
        return this;
    }

    public PoiResult clearRecommend() {
        this.hasRecommend = false;
        this.recommend_ = null;
        return this;
    }

    public PoiResult clearSearchBoxBgImg() {
        this.hasSearchBoxBgImg = false;
        this.searchBoxBgImg_ = "";
        return this;
    }

    public PoiResult clearSpeechFinalWord() {
        this.hasSpeechFinalWord = false;
        this.speechFinalWord_ = "";
        return this;
    }

    public PoiResult clearSugRecRes() {
        this.hasSugRecRes = false;
        this.sugRecRes_ = null;
        return this;
    }

    public PoiResult clearSuggestQuery() {
        this.suggestQuery_ = Collections.emptyList();
        return this;
    }

    public PoiResult clearTalosData() {
        this.hasTalosData = false;
        this.talosData_ = null;
        return this;
    }

    public PoiResult clearWidgetBar() {
        this.hasWidgetBar = false;
        this.widgetBar_ = null;
        return this;
    }

    public Addrs getAddrs(int i) {
        return this.addrs_.get(i);
    }

    public int getAddrsCount() {
        return this.addrs_.size();
    }

    public List<Addrs> getAddrsList() {
        return this.addrs_;
    }

    public Ads getAds(int i) {
        return this.ads_.get(i);
    }

    public int getAdsCount() {
        return this.ads_.size();
    }

    public AdsExtInfo getAdsExtInfo() {
        return this.adsExtInfo_;
    }

    public List<Ads> getAdsList() {
        return this.ads_;
    }

    public BrandBar getBrandBar() {
        return this.brandBar_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCarPreload() {
        return this.carPreload_;
    }

    public Children getChildren(int i) {
        return this.children_.get(i);
    }

    public int getChildrenCount() {
        return this.children_.size();
    }

    public List<Children> getChildrenList() {
        return this.children_;
    }

    public Contents getContents(int i) {
        return this.contents_.get(i);
    }

    public int getContentsCount() {
        return this.contents_.size();
    }

    public List<Contents> getContentsList() {
        return this.contents_;
    }

    public CorrectionInfo getCorrectionInfo() {
        return this.correctionInfo_;
    }

    public CurrentCity getCurrentCity() {
        return this.currentCity_;
    }

    public String getEmptyResultDynamicCard() {
        return this.emptyResultDynamicCard_;
    }

    public FloatIcon getFloatIcons(int i) {
        return this.floatIcons_.get(i);
    }

    public int getFloatIconsCount() {
        return this.floatIcons_.size();
    }

    public List<FloatIcon> getFloatIconsList() {
        return this.floatIcons_;
    }

    public GuideTag getGuideTag(int i) {
        return this.guideTag_.get(i);
    }

    public int getGuideTagCount() {
        return this.guideTag_.size();
    }

    public List<GuideTag> getGuideTagList() {
        return this.guideTag_;
    }

    public HorizonSlideResult getHorizonSlideResult() {
        return this.horizonSlideResult_;
    }

    public ImgBanner getImgBanner() {
        return this.imgBanner_;
    }

    public ByteStringMicro getImgeExt() {
        return this.imgeExt_;
    }

    public IndusInfo getIndusInfo() {
        return this.indusInfo_;
    }

    public ListAdsData getListAdsData() {
        return this.listAdsData_;
    }

    public MystiqueList getMystiqueList(int i) {
        return this.mystiqueList_.get(i);
    }

    public int getMystiqueListCount() {
        return this.mystiqueList_.size();
    }

    public List<MystiqueList> getMystiqueListList() {
        return this.mystiqueList_;
    }

    public int getOffline() {
        return this.offline_;
    }

    public Option getOption() {
        return this.option_;
    }

    public PlaceInfo getPlaceInfo() {
        return this.placeInfo_;
    }

    public String getPopupWindow() {
        return this.popupWindow_;
    }

    public PreviousCity getPreviousCity() {
        return this.previousCity_;
    }

    public Psrs getPsrs() {
        return this.psrs_;
    }

    public Recommend getRecommend() {
        return this.recommend_;
    }

    public String getSearchBoxBgImg() {
        return this.searchBoxBgImg_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int computeMessageSize = hasOption() ? CodedOutputStreamMicro.computeMessageSize(1, getOption()) : 0;
        Iterator<Addrs> it = getAddrsList().iterator();
        while (it.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, it.next());
        }
        if (hasPsrs()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(3, getPsrs());
        }
        Iterator<SuggestQuery> it2 = getSuggestQueryList().iterator();
        while (it2.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(4, it2.next());
        }
        if (hasPlaceInfo()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(5, getPlaceInfo());
        }
        Iterator<Contents> it3 = getContentsList().iterator();
        while (it3.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(6, it3.next());
        }
        if (hasCurrentCity()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(7, getCurrentCity());
        }
        Iterator<Children> it4 = getChildrenList().iterator();
        while (it4.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(8, it4.next());
        }
        if (hasPreviousCity()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(9, getPreviousCity());
        }
        if (hasBrandBar()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(10, getBrandBar());
        }
        if (hasImgeExt()) {
            computeMessageSize += CodedOutputStreamMicro.computeBytesSize(11, getImgeExt());
        }
        if (hasOffline()) {
            computeMessageSize += CodedOutputStreamMicro.computeInt32Size(12, getOffline());
        }
        Iterator<GuideTag> it5 = getGuideTagList().iterator();
        while (it5.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(13, it5.next());
        }
        Iterator<Ads> it6 = getAdsList().iterator();
        while (it6.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(14, it6.next());
        }
        if (hasAdsExtInfo()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(16, getAdsExtInfo());
        }
        if (hasIndusInfo()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(18, getIndusInfo());
        }
        if (hasRecommend()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(19, getRecommend());
        }
        if (hasCorrectionInfo()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(20, getCorrectionInfo());
        }
        if (hasCarPreload()) {
            computeMessageSize += CodedOutputStreamMicro.computeInt32Size(21, getCarPreload());
        }
        if (hasSpeechFinalWord()) {
            computeMessageSize += CodedOutputStreamMicro.computeStringSize(22, getSpeechFinalWord());
        }
        if (hasImgBanner()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(23, getImgBanner());
        }
        Iterator<MystiqueList> it7 = getMystiqueListList().iterator();
        while (it7.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(24, it7.next());
        }
        if (hasSugRecRes()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(25, getSugRecRes());
        }
        if (hasHorizonSlideResult()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(26, getHorizonSlideResult());
        }
        if (hasEmptyResultDynamicCard()) {
            computeMessageSize += CodedOutputStreamMicro.computeStringSize(27, getEmptyResultDynamicCard());
        }
        Iterator<FloatIcon> it8 = getFloatIconsList().iterator();
        while (it8.hasNext()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(28, it8.next());
        }
        if (hasSearchBoxBgImg()) {
            computeMessageSize += CodedOutputStreamMicro.computeStringSize(29, getSearchBoxBgImg());
        }
        if (hasPopupWindow()) {
            computeMessageSize += CodedOutputStreamMicro.computeStringSize(30, getPopupWindow());
        }
        if (hasWidgetBar()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(31, getWidgetBar());
        }
        if (hasListAdsData()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(32, getListAdsData());
        }
        if (hasTalosData()) {
            computeMessageSize += CodedOutputStreamMicro.computeMessageSize(33, getTalosData());
        }
        this.cachedSize = computeMessageSize;
        return computeMessageSize;
    }

    public String getSpeechFinalWord() {
        return this.speechFinalWord_;
    }

    public SugRecResult getSugRecRes() {
        return this.sugRecRes_;
    }

    public SuggestQuery getSuggestQuery(int i) {
        return this.suggestQuery_.get(i);
    }

    public int getSuggestQueryCount() {
        return this.suggestQuery_.size();
    }

    public List<SuggestQuery> getSuggestQueryList() {
        return this.suggestQuery_;
    }

    public TalosData getTalosData() {
        return this.talosData_;
    }

    public WidgetBar getWidgetBar() {
        return this.widgetBar_;
    }

    public boolean hasAdsExtInfo() {
        return this.hasAdsExtInfo;
    }

    public boolean hasBrandBar() {
        return this.hasBrandBar;
    }

    public boolean hasCarPreload() {
        return this.hasCarPreload;
    }

    public boolean hasCorrectionInfo() {
        return this.hasCorrectionInfo;
    }

    public boolean hasCurrentCity() {
        return this.hasCurrentCity;
    }

    public boolean hasEmptyResultDynamicCard() {
        return this.hasEmptyResultDynamicCard;
    }

    public boolean hasHorizonSlideResult() {
        return this.hasHorizonSlideResult;
    }

    public boolean hasImgBanner() {
        return this.hasImgBanner;
    }

    public boolean hasImgeExt() {
        return this.hasImgeExt;
    }

    public boolean hasIndusInfo() {
        return this.hasIndusInfo;
    }

    public boolean hasListAdsData() {
        return this.hasListAdsData;
    }

    public boolean hasOffline() {
        return this.hasOffline;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasPlaceInfo() {
        return this.hasPlaceInfo;
    }

    public boolean hasPopupWindow() {
        return this.hasPopupWindow;
    }

    public boolean hasPreviousCity() {
        return this.hasPreviousCity;
    }

    public boolean hasPsrs() {
        return this.hasPsrs;
    }

    public boolean hasRecommend() {
        return this.hasRecommend;
    }

    public boolean hasSearchBoxBgImg() {
        return this.hasSearchBoxBgImg;
    }

    public boolean hasSpeechFinalWord() {
        return this.hasSpeechFinalWord;
    }

    public boolean hasSugRecRes() {
        return this.hasSugRecRes;
    }

    public boolean hasTalosData() {
        return this.hasTalosData;
    }

    public boolean hasWidgetBar() {
        return this.hasWidgetBar;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public PoiResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    Option option = new Option();
                    codedInputStreamMicro.readMessage(option);
                    setOption(option);
                    break;
                case 18:
                    Addrs addrs = new Addrs();
                    codedInputStreamMicro.readMessage(addrs);
                    addAddrs(addrs);
                    break;
                case 26:
                    Psrs psrs = new Psrs();
                    codedInputStreamMicro.readMessage(psrs);
                    setPsrs(psrs);
                    break;
                case 34:
                    SuggestQuery suggestQuery = new SuggestQuery();
                    codedInputStreamMicro.readMessage(suggestQuery);
                    addSuggestQuery(suggestQuery);
                    break;
                case 42:
                    PlaceInfo placeInfo = new PlaceInfo();
                    codedInputStreamMicro.readMessage(placeInfo);
                    setPlaceInfo(placeInfo);
                    break;
                case 50:
                    Contents contents = new Contents();
                    codedInputStreamMicro.readMessage(contents);
                    addContents(contents);
                    break;
                case 58:
                    CurrentCity currentCity = new CurrentCity();
                    codedInputStreamMicro.readMessage(currentCity);
                    setCurrentCity(currentCity);
                    break;
                case 66:
                    Children children = new Children();
                    codedInputStreamMicro.readMessage(children);
                    addChildren(children);
                    break;
                case 74:
                    PreviousCity previousCity = new PreviousCity();
                    codedInputStreamMicro.readMessage(previousCity);
                    setPreviousCity(previousCity);
                    break;
                case 82:
                    BrandBar brandBar = new BrandBar();
                    codedInputStreamMicro.readMessage(brandBar);
                    setBrandBar(brandBar);
                    break;
                case 90:
                    setImgeExt(codedInputStreamMicro.readBytes());
                    break;
                case 96:
                    setOffline(codedInputStreamMicro.readInt32());
                    break;
                case 106:
                    GuideTag guideTag = new GuideTag();
                    codedInputStreamMicro.readMessage(guideTag);
                    addGuideTag(guideTag);
                    break;
                case 114:
                    Ads ads = new Ads();
                    codedInputStreamMicro.readMessage(ads);
                    addAds(ads);
                    break;
                case 130:
                    AdsExtInfo adsExtInfo = new AdsExtInfo();
                    codedInputStreamMicro.readMessage(adsExtInfo);
                    setAdsExtInfo(adsExtInfo);
                    break;
                case 146:
                    IndusInfo indusInfo = new IndusInfo();
                    codedInputStreamMicro.readMessage(indusInfo);
                    setIndusInfo(indusInfo);
                    break;
                case 154:
                    Recommend recommend = new Recommend();
                    codedInputStreamMicro.readMessage(recommend);
                    setRecommend(recommend);
                    break;
                case 162:
                    CorrectionInfo correctionInfo = new CorrectionInfo();
                    codedInputStreamMicro.readMessage(correctionInfo);
                    setCorrectionInfo(correctionInfo);
                    break;
                case 168:
                    setCarPreload(codedInputStreamMicro.readInt32());
                    break;
                case 178:
                    setSpeechFinalWord(codedInputStreamMicro.readString());
                    break;
                case 186:
                    ImgBanner imgBanner = new ImgBanner();
                    codedInputStreamMicro.readMessage(imgBanner);
                    setImgBanner(imgBanner);
                    break;
                case 194:
                    MystiqueList mystiqueList = new MystiqueList();
                    codedInputStreamMicro.readMessage(mystiqueList);
                    addMystiqueList(mystiqueList);
                    break;
                case 202:
                    SugRecResult sugRecResult = new SugRecResult();
                    codedInputStreamMicro.readMessage(sugRecResult);
                    setSugRecRes(sugRecResult);
                    break;
                case 210:
                    HorizonSlideResult horizonSlideResult = new HorizonSlideResult();
                    codedInputStreamMicro.readMessage(horizonSlideResult);
                    setHorizonSlideResult(horizonSlideResult);
                    break;
                case HeightPicker.f25534xoXoI /* 218 */:
                    setEmptyResultDynamicCard(codedInputStreamMicro.readString());
                    break;
                case 226:
                    FloatIcon floatIcon = new FloatIcon();
                    codedInputStreamMicro.readMessage(floatIcon);
                    addFloatIcons(floatIcon);
                    break;
                case 234:
                    setSearchBoxBgImg(codedInputStreamMicro.readString());
                    break;
                case Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE /* 242 */:
                    setPopupWindow(codedInputStreamMicro.readString());
                    break;
                case 250:
                    WidgetBar widgetBar = new WidgetBar();
                    codedInputStreamMicro.readMessage(widgetBar);
                    setWidgetBar(widgetBar);
                    break;
                case 258:
                    ListAdsData listAdsData = new ListAdsData();
                    codedInputStreamMicro.readMessage(listAdsData);
                    setListAdsData(listAdsData);
                    break;
                case 266:
                    TalosData talosData = new TalosData();
                    codedInputStreamMicro.readMessage(talosData);
                    setTalosData(talosData);
                    break;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public PoiResult setAddrs(int i, Addrs addrs) {
        if (addrs == null) {
            return this;
        }
        this.addrs_.set(i, addrs);
        return this;
    }

    public PoiResult setAds(int i, Ads ads) {
        if (ads == null) {
            return this;
        }
        this.ads_.set(i, ads);
        return this;
    }

    public PoiResult setAdsExtInfo(AdsExtInfo adsExtInfo) {
        if (adsExtInfo == null) {
            return clearAdsExtInfo();
        }
        this.hasAdsExtInfo = true;
        this.adsExtInfo_ = adsExtInfo;
        return this;
    }

    public PoiResult setBrandBar(BrandBar brandBar) {
        if (brandBar == null) {
            return clearBrandBar();
        }
        this.hasBrandBar = true;
        this.brandBar_ = brandBar;
        return this;
    }

    public PoiResult setCarPreload(int i) {
        this.hasCarPreload = true;
        this.carPreload_ = i;
        return this;
    }

    public PoiResult setChildren(int i, Children children) {
        if (children == null) {
            return this;
        }
        this.children_.set(i, children);
        return this;
    }

    public PoiResult setContents(int i, Contents contents) {
        if (contents == null) {
            return this;
        }
        this.contents_.set(i, contents);
        return this;
    }

    public PoiResult setCorrectionInfo(CorrectionInfo correctionInfo) {
        if (correctionInfo == null) {
            return clearCorrectionInfo();
        }
        this.hasCorrectionInfo = true;
        this.correctionInfo_ = correctionInfo;
        return this;
    }

    public PoiResult setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.hasCurrentCity = true;
        this.currentCity_ = currentCity;
        return this;
    }

    public PoiResult setEmptyResultDynamicCard(String str) {
        this.hasEmptyResultDynamicCard = true;
        this.emptyResultDynamicCard_ = str;
        return this;
    }

    public PoiResult setFloatIcons(int i, FloatIcon floatIcon) {
        if (floatIcon == null) {
            return this;
        }
        this.floatIcons_.set(i, floatIcon);
        return this;
    }

    public PoiResult setGuideTag(int i, GuideTag guideTag) {
        if (guideTag == null) {
            return this;
        }
        this.guideTag_.set(i, guideTag);
        return this;
    }

    public PoiResult setHorizonSlideResult(HorizonSlideResult horizonSlideResult) {
        if (horizonSlideResult == null) {
            return clearHorizonSlideResult();
        }
        this.hasHorizonSlideResult = true;
        this.horizonSlideResult_ = horizonSlideResult;
        return this;
    }

    public PoiResult setImgBanner(ImgBanner imgBanner) {
        if (imgBanner == null) {
            return clearImgBanner();
        }
        this.hasImgBanner = true;
        this.imgBanner_ = imgBanner;
        return this;
    }

    public PoiResult setImgeExt(ByteStringMicro byteStringMicro) {
        this.hasImgeExt = true;
        this.imgeExt_ = byteStringMicro;
        return this;
    }

    public PoiResult setIndusInfo(IndusInfo indusInfo) {
        if (indusInfo == null) {
            return clearIndusInfo();
        }
        this.hasIndusInfo = true;
        this.indusInfo_ = indusInfo;
        return this;
    }

    public PoiResult setListAdsData(ListAdsData listAdsData) {
        if (listAdsData == null) {
            return clearListAdsData();
        }
        this.hasListAdsData = true;
        this.listAdsData_ = listAdsData;
        return this;
    }

    public PoiResult setMystiqueList(int i, MystiqueList mystiqueList) {
        if (mystiqueList == null) {
            return this;
        }
        this.mystiqueList_.set(i, mystiqueList);
        return this;
    }

    public PoiResult setOffline(int i) {
        this.hasOffline = true;
        this.offline_ = i;
        return this;
    }

    public PoiResult setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public PoiResult setPlaceInfo(PlaceInfo placeInfo) {
        if (placeInfo == null) {
            return clearPlaceInfo();
        }
        this.hasPlaceInfo = true;
        this.placeInfo_ = placeInfo;
        return this;
    }

    public PoiResult setPopupWindow(String str) {
        this.hasPopupWindow = true;
        this.popupWindow_ = str;
        return this;
    }

    public PoiResult setPreviousCity(PreviousCity previousCity) {
        if (previousCity == null) {
            return clearPreviousCity();
        }
        this.hasPreviousCity = true;
        this.previousCity_ = previousCity;
        return this;
    }

    public PoiResult setPsrs(Psrs psrs) {
        if (psrs == null) {
            return clearPsrs();
        }
        this.hasPsrs = true;
        this.psrs_ = psrs;
        return this;
    }

    public PoiResult setRecommend(Recommend recommend) {
        if (recommend == null) {
            return clearRecommend();
        }
        this.hasRecommend = true;
        this.recommend_ = recommend;
        return this;
    }

    public PoiResult setSearchBoxBgImg(String str) {
        this.hasSearchBoxBgImg = true;
        this.searchBoxBgImg_ = str;
        return this;
    }

    public PoiResult setSpeechFinalWord(String str) {
        this.hasSpeechFinalWord = true;
        this.speechFinalWord_ = str;
        return this;
    }

    public PoiResult setSugRecRes(SugRecResult sugRecResult) {
        if (sugRecResult == null) {
            return clearSugRecRes();
        }
        this.hasSugRecRes = true;
        this.sugRecRes_ = sugRecResult;
        return this;
    }

    public PoiResult setSuggestQuery(int i, SuggestQuery suggestQuery) {
        if (suggestQuery == null) {
            return this;
        }
        this.suggestQuery_.set(i, suggestQuery);
        return this;
    }

    public PoiResult setTalosData(TalosData talosData) {
        if (talosData == null) {
            return clearTalosData();
        }
        this.hasTalosData = true;
        this.talosData_ = talosData;
        return this;
    }

    public PoiResult setWidgetBar(WidgetBar widgetBar) {
        if (widgetBar == null) {
            return clearWidgetBar();
        }
        this.hasWidgetBar = true;
        this.widgetBar_ = widgetBar;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        Iterator<Addrs> it = getAddrsList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(2, it.next());
        }
        if (hasPsrs()) {
            codedOutputStreamMicro.writeMessage(3, getPsrs());
        }
        Iterator<SuggestQuery> it2 = getSuggestQueryList().iterator();
        while (it2.hasNext()) {
            codedOutputStreamMicro.writeMessage(4, it2.next());
        }
        if (hasPlaceInfo()) {
            codedOutputStreamMicro.writeMessage(5, getPlaceInfo());
        }
        Iterator<Contents> it3 = getContentsList().iterator();
        while (it3.hasNext()) {
            codedOutputStreamMicro.writeMessage(6, it3.next());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(7, getCurrentCity());
        }
        Iterator<Children> it4 = getChildrenList().iterator();
        while (it4.hasNext()) {
            codedOutputStreamMicro.writeMessage(8, it4.next());
        }
        if (hasPreviousCity()) {
            codedOutputStreamMicro.writeMessage(9, getPreviousCity());
        }
        if (hasBrandBar()) {
            codedOutputStreamMicro.writeMessage(10, getBrandBar());
        }
        if (hasImgeExt()) {
            codedOutputStreamMicro.writeBytes(11, getImgeExt());
        }
        if (hasOffline()) {
            codedOutputStreamMicro.writeInt32(12, getOffline());
        }
        Iterator<GuideTag> it5 = getGuideTagList().iterator();
        while (it5.hasNext()) {
            codedOutputStreamMicro.writeMessage(13, it5.next());
        }
        Iterator<Ads> it6 = getAdsList().iterator();
        while (it6.hasNext()) {
            codedOutputStreamMicro.writeMessage(14, it6.next());
        }
        if (hasAdsExtInfo()) {
            codedOutputStreamMicro.writeMessage(16, getAdsExtInfo());
        }
        if (hasIndusInfo()) {
            codedOutputStreamMicro.writeMessage(18, getIndusInfo());
        }
        if (hasRecommend()) {
            codedOutputStreamMicro.writeMessage(19, getRecommend());
        }
        if (hasCorrectionInfo()) {
            codedOutputStreamMicro.writeMessage(20, getCorrectionInfo());
        }
        if (hasCarPreload()) {
            codedOutputStreamMicro.writeInt32(21, getCarPreload());
        }
        if (hasSpeechFinalWord()) {
            codedOutputStreamMicro.writeString(22, getSpeechFinalWord());
        }
        if (hasImgBanner()) {
            codedOutputStreamMicro.writeMessage(23, getImgBanner());
        }
        Iterator<MystiqueList> it7 = getMystiqueListList().iterator();
        while (it7.hasNext()) {
            codedOutputStreamMicro.writeMessage(24, it7.next());
        }
        if (hasSugRecRes()) {
            codedOutputStreamMicro.writeMessage(25, getSugRecRes());
        }
        if (hasHorizonSlideResult()) {
            codedOutputStreamMicro.writeMessage(26, getHorizonSlideResult());
        }
        if (hasEmptyResultDynamicCard()) {
            codedOutputStreamMicro.writeString(27, getEmptyResultDynamicCard());
        }
        Iterator<FloatIcon> it8 = getFloatIconsList().iterator();
        while (it8.hasNext()) {
            codedOutputStreamMicro.writeMessage(28, it8.next());
        }
        if (hasSearchBoxBgImg()) {
            codedOutputStreamMicro.writeString(29, getSearchBoxBgImg());
        }
        if (hasPopupWindow()) {
            codedOutputStreamMicro.writeString(30, getPopupWindow());
        }
        if (hasWidgetBar()) {
            codedOutputStreamMicro.writeMessage(31, getWidgetBar());
        }
        if (hasListAdsData()) {
            codedOutputStreamMicro.writeMessage(32, getListAdsData());
        }
        if (hasTalosData()) {
            codedOutputStreamMicro.writeMessage(33, getTalosData());
        }
    }

    public static PoiResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult) new PoiResult().mergeFrom(bArr);
    }
}
