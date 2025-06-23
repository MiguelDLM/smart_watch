package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.cloudbridge.AppEventType;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.o0;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oO;
import kotlin.oXIO0o0XI;
import kotlin.text.o00;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AppEventsConversionsAPITransformer {

    @OOXIXo
    public static final AppEventsConversionsAPITransformer INSTANCE = new AppEventsConversionsAPITransformer();

    @OOXIXo
    public static final String TAG = "AppEventsConversionsAPITransformer";

    @OOXIXo
    @XO
    public static final Map<CustomEventField, SectionCustomEventFieldMapping> customEventTransformations;

    @OOXIXo
    @XO
    public static final Map<String, ConversionsAPIEventName> standardEventTransformations;

    @OOXIXo
    private static final Map<AppEventUserAndAppDataField, SectionFieldMapping> topLevelTransformations;

    /* loaded from: classes8.dex */
    public enum DataProcessingParameterName {
        OPTIONS(FacebookSdk.DATA_PROCESSION_OPTIONS),
        COUNTRY(FacebookSdk.DATA_PROCESSION_OPTIONS_COUNTRY),
        STATE(FacebookSdk.DATA_PROCESSION_OPTIONS_STATE);


        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        private final String rawValue;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @oOoXoXO
            public final DataProcessingParameterName invoke(@OOXIXo String rawValue) {
                IIX0o.x0xO0oo(rawValue, "rawValue");
                for (DataProcessingParameterName dataProcessingParameterName : DataProcessingParameterName.valuesCustom()) {
                    if (IIX0o.Oxx0IOOO(dataProcessingParameterName.getRawValue(), rawValue)) {
                        return dataProcessingParameterName;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        DataProcessingParameterName(String str) {
            this.rawValue = str;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static DataProcessingParameterName[] valuesCustom() {
            DataProcessingParameterName[] valuesCustom = values();
            return (DataProcessingParameterName[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        @OOXIXo
        public final String getRawValue() {
            return this.rawValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class SectionCustomEventFieldMapping {

        @OOXIXo
        private ConversionsAPICustomEventField field;

        @oOoXoXO
        private ConversionsAPISection section;

        public SectionCustomEventFieldMapping(@oOoXoXO ConversionsAPISection conversionsAPISection, @OOXIXo ConversionsAPICustomEventField field) {
            IIX0o.x0xO0oo(field, "field");
            this.section = conversionsAPISection;
            this.field = field;
        }

        public static /* synthetic */ SectionCustomEventFieldMapping copy$default(SectionCustomEventFieldMapping sectionCustomEventFieldMapping, ConversionsAPISection conversionsAPISection, ConversionsAPICustomEventField conversionsAPICustomEventField, int i, Object obj) {
            if ((i & 1) != 0) {
                conversionsAPISection = sectionCustomEventFieldMapping.section;
            }
            if ((i & 2) != 0) {
                conversionsAPICustomEventField = sectionCustomEventFieldMapping.field;
            }
            return sectionCustomEventFieldMapping.copy(conversionsAPISection, conversionsAPICustomEventField);
        }

        @oOoXoXO
        public final ConversionsAPISection component1() {
            return this.section;
        }

        @OOXIXo
        public final ConversionsAPICustomEventField component2() {
            return this.field;
        }

        @OOXIXo
        public final SectionCustomEventFieldMapping copy(@oOoXoXO ConversionsAPISection conversionsAPISection, @OOXIXo ConversionsAPICustomEventField field) {
            IIX0o.x0xO0oo(field, "field");
            return new SectionCustomEventFieldMapping(conversionsAPISection, field);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionCustomEventFieldMapping)) {
                return false;
            }
            SectionCustomEventFieldMapping sectionCustomEventFieldMapping = (SectionCustomEventFieldMapping) obj;
            return this.section == sectionCustomEventFieldMapping.section && this.field == sectionCustomEventFieldMapping.field;
        }

        @OOXIXo
        public final ConversionsAPICustomEventField getField() {
            return this.field;
        }

        @oOoXoXO
        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public int hashCode() {
            ConversionsAPISection conversionsAPISection = this.section;
            return ((conversionsAPISection == null ? 0 : conversionsAPISection.hashCode()) * 31) + this.field.hashCode();
        }

        public final void setField(@OOXIXo ConversionsAPICustomEventField conversionsAPICustomEventField) {
            IIX0o.x0xO0oo(conversionsAPICustomEventField, "<set-?>");
            this.field = conversionsAPICustomEventField;
        }

        public final void setSection(@oOoXoXO ConversionsAPISection conversionsAPISection) {
            this.section = conversionsAPISection;
        }

        @OOXIXo
        public String toString() {
            return "SectionCustomEventFieldMapping(section=" + this.section + ", field=" + this.field + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* loaded from: classes8.dex */
    public static final class SectionFieldMapping {

        @oOoXoXO
        private ConversionsAPIUserAndAppDataField field;

        @OOXIXo
        private ConversionsAPISection section;

        public SectionFieldMapping(@OOXIXo ConversionsAPISection section, @oOoXoXO ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            IIX0o.x0xO0oo(section, "section");
            this.section = section;
            this.field = conversionsAPIUserAndAppDataField;
        }

        public static /* synthetic */ SectionFieldMapping copy$default(SectionFieldMapping sectionFieldMapping, ConversionsAPISection conversionsAPISection, ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField, int i, Object obj) {
            if ((i & 1) != 0) {
                conversionsAPISection = sectionFieldMapping.section;
            }
            if ((i & 2) != 0) {
                conversionsAPIUserAndAppDataField = sectionFieldMapping.field;
            }
            return sectionFieldMapping.copy(conversionsAPISection, conversionsAPIUserAndAppDataField);
        }

        @OOXIXo
        public final ConversionsAPISection component1() {
            return this.section;
        }

        @oOoXoXO
        public final ConversionsAPIUserAndAppDataField component2() {
            return this.field;
        }

        @OOXIXo
        public final SectionFieldMapping copy(@OOXIXo ConversionsAPISection section, @oOoXoXO ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            IIX0o.x0xO0oo(section, "section");
            return new SectionFieldMapping(section, conversionsAPIUserAndAppDataField);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionFieldMapping)) {
                return false;
            }
            SectionFieldMapping sectionFieldMapping = (SectionFieldMapping) obj;
            return this.section == sectionFieldMapping.section && this.field == sectionFieldMapping.field;
        }

        @oOoXoXO
        public final ConversionsAPIUserAndAppDataField getField() {
            return this.field;
        }

        @OOXIXo
        public final ConversionsAPISection getSection() {
            return this.section;
        }

        public int hashCode() {
            int hashCode = this.section.hashCode() * 31;
            ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField = this.field;
            return hashCode + (conversionsAPIUserAndAppDataField == null ? 0 : conversionsAPIUserAndAppDataField.hashCode());
        }

        public final void setField(@oOoXoXO ConversionsAPIUserAndAppDataField conversionsAPIUserAndAppDataField) {
            this.field = conversionsAPIUserAndAppDataField;
        }

        public final void setSection(@OOXIXo ConversionsAPISection conversionsAPISection) {
            IIX0o.x0xO0oo(conversionsAPISection, "<set-?>");
            this.section = conversionsAPISection;
        }

        @OOXIXo
        public String toString() {
            return "SectionFieldMapping(section=" + this.section + ", field=" + this.field + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* loaded from: classes8.dex */
    public enum ValueTransformationType {
        ARRAY,
        BOOL,
        INT;


        @OOXIXo
        public static final Companion Companion = new Companion(null);

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @oOoXoXO
            public final ValueTransformationType invoke(@OOXIXo String rawValue) {
                IIX0o.x0xO0oo(rawValue, "rawValue");
                if (IIX0o.Oxx0IOOO(rawValue, AppEventUserAndAppDataField.EXT_INFO.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (IIX0o.Oxx0IOOO(rawValue, AppEventUserAndAppDataField.URL_SCHEMES.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (IIX0o.Oxx0IOOO(rawValue, CustomEventField.CONTENT_IDS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (IIX0o.Oxx0IOOO(rawValue, CustomEventField.CONTENTS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (IIX0o.Oxx0IOOO(rawValue, DataProcessingParameterName.OPTIONS.getRawValue())) {
                    return ValueTransformationType.ARRAY;
                }
                if (IIX0o.Oxx0IOOO(rawValue, AppEventUserAndAppDataField.ADV_TE.getRawValue())) {
                    return ValueTransformationType.BOOL;
                }
                if (IIX0o.Oxx0IOOO(rawValue, AppEventUserAndAppDataField.APP_TE.getRawValue())) {
                    return ValueTransformationType.BOOL;
                }
                if (IIX0o.Oxx0IOOO(rawValue, CustomEventField.EVENT_TIME.getRawValue())) {
                    return ValueTransformationType.INT;
                }
                return null;
            }

            private Companion() {
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ValueTransformationType[] valuesCustom() {
            ValueTransformationType[] valuesCustom = values();
            return (ValueTransformationType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ValueTransformationType.valuesCustom().length];
            iArr[ValueTransformationType.ARRAY.ordinal()] = 1;
            iArr[ValueTransformationType.BOOL.ordinal()] = 2;
            iArr[ValueTransformationType.INT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConversionsAPISection.valuesCustom().length];
            iArr2[ConversionsAPISection.APP_DATA.ordinal()] = 1;
            iArr2[ConversionsAPISection.USER_DATA.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AppEventType.valuesCustom().length];
            iArr3[AppEventType.MOBILE_APP_INSTALL.ordinal()] = 1;
            iArr3[AppEventType.CUSTOM.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    static {
        AppEventUserAndAppDataField appEventUserAndAppDataField = AppEventUserAndAppDataField.ANON_ID;
        ConversionsAPISection conversionsAPISection = ConversionsAPISection.USER_DATA;
        Pair oIX0oI2 = Xo0.oIX0oI(appEventUserAndAppDataField, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.ANON_ID));
        Pair oIX0oI3 = Xo0.oIX0oI(AppEventUserAndAppDataField.APP_USER_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.FB_LOGIN_ID));
        Pair oIX0oI4 = Xo0.oIX0oI(AppEventUserAndAppDataField.ADVERTISER_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.MAD_ID));
        Pair oIX0oI5 = Xo0.oIX0oI(AppEventUserAndAppDataField.PAGE_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.PAGE_ID));
        Pair oIX0oI6 = Xo0.oIX0oI(AppEventUserAndAppDataField.PAGE_SCOPED_USER_ID, new SectionFieldMapping(conversionsAPISection, ConversionsAPIUserAndAppDataField.PAGE_SCOPED_USER_ID));
        AppEventUserAndAppDataField appEventUserAndAppDataField2 = AppEventUserAndAppDataField.ADV_TE;
        ConversionsAPISection conversionsAPISection2 = ConversionsAPISection.APP_DATA;
        topLevelTransformations = o0.XX(oIX0oI2, oIX0oI3, oIX0oI4, oIX0oI5, oIX0oI6, Xo0.oIX0oI(appEventUserAndAppDataField2, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.ADV_TE)), Xo0.oIX0oI(AppEventUserAndAppDataField.APP_TE, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.APP_TE)), Xo0.oIX0oI(AppEventUserAndAppDataField.CONSIDER_VIEWS, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.CONSIDER_VIEWS)), Xo0.oIX0oI(AppEventUserAndAppDataField.DEVICE_TOKEN, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.DEVICE_TOKEN)), Xo0.oIX0oI(AppEventUserAndAppDataField.EXT_INFO, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.EXT_INFO)), Xo0.oIX0oI(AppEventUserAndAppDataField.INCLUDE_DWELL_DATA, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INCLUDE_DWELL_DATA)), Xo0.oIX0oI(AppEventUserAndAppDataField.INCLUDE_VIDEO_DATA, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INCLUDE_VIDEO_DATA)), Xo0.oIX0oI(AppEventUserAndAppDataField.INSTALL_REFERRER, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INSTALL_REFERRER)), Xo0.oIX0oI(AppEventUserAndAppDataField.INSTALLER_PACKAGE, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.INSTALLER_PACKAGE)), Xo0.oIX0oI(AppEventUserAndAppDataField.RECEIPT_DATA, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.RECEIPT_DATA)), Xo0.oIX0oI(AppEventUserAndAppDataField.URL_SCHEMES, new SectionFieldMapping(conversionsAPISection2, ConversionsAPIUserAndAppDataField.URL_SCHEMES)), Xo0.oIX0oI(AppEventUserAndAppDataField.USER_DATA, new SectionFieldMapping(conversionsAPISection, null)));
        Pair oIX0oI7 = Xo0.oIX0oI(CustomEventField.EVENT_TIME, new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_TIME));
        Pair oIX0oI8 = Xo0.oIX0oI(CustomEventField.EVENT_NAME, new SectionCustomEventFieldMapping(null, ConversionsAPICustomEventField.EVENT_NAME));
        CustomEventField customEventField = CustomEventField.VALUE_TO_SUM;
        ConversionsAPISection conversionsAPISection3 = ConversionsAPISection.CUSTOM_DATA;
        customEventTransformations = o0.XX(oIX0oI7, oIX0oI8, Xo0.oIX0oI(customEventField, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.VALUE_TO_SUM)), Xo0.oIX0oI(CustomEventField.CONTENT_IDS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENT_IDS)), Xo0.oIX0oI(CustomEventField.CONTENTS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENTS)), Xo0.oIX0oI(CustomEventField.CONTENT_TYPE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CONTENT_TYPE)), Xo0.oIX0oI(CustomEventField.CURRENCY, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.CURRENCY)), Xo0.oIX0oI(CustomEventField.DESCRIPTION, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.DESCRIPTION)), Xo0.oIX0oI(CustomEventField.LEVEL, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.LEVEL)), Xo0.oIX0oI(CustomEventField.MAX_RATING_VALUE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.MAX_RATING_VALUE)), Xo0.oIX0oI(CustomEventField.NUM_ITEMS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.NUM_ITEMS)), Xo0.oIX0oI(CustomEventField.PAYMENT_INFO_AVAILABLE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.PAYMENT_INFO_AVAILABLE)), Xo0.oIX0oI(CustomEventField.REGISTRATION_METHOD, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.REGISTRATION_METHOD)), Xo0.oIX0oI(CustomEventField.SEARCH_STRING, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.SEARCH_STRING)), Xo0.oIX0oI(CustomEventField.SUCCESS, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.SUCCESS)), Xo0.oIX0oI(CustomEventField.ORDER_ID, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.ORDER_ID)), Xo0.oIX0oI(CustomEventField.AD_TYPE, new SectionCustomEventFieldMapping(conversionsAPISection3, ConversionsAPICustomEventField.AD_TYPE)));
        standardEventTransformations = o0.XX(Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_UNLOCKED_ACHIEVEMENT, ConversionsAPIEventName.UNLOCKED_ACHIEVEMENT), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, ConversionsAPIEventName.ACTIVATED_APP), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO, ConversionsAPIEventName.ADDED_PAYMENT_INFO), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_ADDED_TO_CART, ConversionsAPIEventName.ADDED_TO_CART), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_ADDED_TO_WISHLIST, ConversionsAPIEventName.ADDED_TO_WISHLIST), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, ConversionsAPIEventName.COMPLETED_REGISTRATION), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_VIEWED_CONTENT, ConversionsAPIEventName.VIEWED_CONTENT), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT, ConversionsAPIEventName.INITIATED_CHECKOUT), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_ACHIEVED_LEVEL, ConversionsAPIEventName.ACHIEVED_LEVEL), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_PURCHASED, ConversionsAPIEventName.PURCHASED), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_RATED, ConversionsAPIEventName.RATED), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_SEARCHED, ConversionsAPIEventName.SEARCHED), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_SPENT_CREDITS, ConversionsAPIEventName.SPENT_CREDITS), Xo0.oIX0oI(AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL, ConversionsAPIEventName.COMPLETED_TUTORIAL));
    }

    private AppEventsConversionsAPITransformer() {
    }

    private final List<Map<String, Object>> combineAllTransformedDataForCustom(Map<String, ? extends Object> map, List<? extends Map<String, ? extends Object>> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map map2 = (Map) it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.putAll(map2);
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    private final List<Map<String, Object>> combineAllTransformedDataForMobileAppInstall(Map<String, ? extends Object> map, Object obj) {
        if (obj == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_NAME.getRawValue(), OtherEventConstants.MOBILE_APP_INSTALL.getRawValue());
        linkedHashMap.put(ConversionsAPICustomEventField.EVENT_TIME.getRawValue(), obj);
        return oI0IIXIo.OOXIXo(linkedHashMap);
    }

    private final AppEventType splitAppEventParameters(Map<String, ? extends Object> map, Map<String, Object> map2, Map<String, Object> map3, ArrayList<Map<String, Object>> arrayList, Map<String, Object> map4) {
        Object obj = map.get(OtherEventConstants.EVENT.getRawValue());
        AppEventType.Companion companion = AppEventType.Companion;
        if (obj != null) {
            AppEventType invoke = companion.invoke((String) obj);
            if (invoke == AppEventType.OTHER) {
                return invoke;
            }
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                AppEventUserAndAppDataField invoke2 = AppEventUserAndAppDataField.Companion.invoke(key);
                if (invoke2 != null) {
                    INSTANCE.transformAndUpdateAppAndUserData$facebook_core_release(map2, map3, invoke2, value);
                } else {
                    boolean Oxx0IOOO2 = IIX0o.Oxx0IOOO(key, ConversionsAPISection.CUSTOM_EVENTS.getRawValue());
                    boolean z = value instanceof String;
                    if (invoke == AppEventType.CUSTOM && Oxx0IOOO2 && z) {
                        ArrayList<Map<String, Object>> transformEvents$facebook_core_release = transformEvents$facebook_core_release((String) value);
                        if (transformEvents$facebook_core_release != null) {
                            arrayList.addAll(transformEvents$facebook_core_release);
                        }
                    } else if (DataProcessingParameterName.Companion.invoke(key) != null) {
                        map4.put(key, value);
                    }
                }
            }
            return invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void transformAndUpdateAppData(Map<String, Object> map, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        ConversionsAPIUserAndAppDataField field;
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
        if (sectionFieldMapping == null) {
            field = null;
        } else {
            field = sectionFieldMapping.getField();
        }
        if (field == null) {
            return;
        }
        map.put(field.getRawValue(), obj);
    }

    private final void transformAndUpdateUserData(Map<String, Object> map, AppEventUserAndAppDataField appEventUserAndAppDataField, Object obj) {
        ConversionsAPIUserAndAppDataField field;
        if (appEventUserAndAppDataField == AppEventUserAndAppDataField.USER_DATA) {
            try {
                Utility utility = Utility.INSTANCE;
                map.putAll(Utility.convertJSONObjectToHashMap(new JSONObject((String) obj)));
                return;
            } catch (JSONException e) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents JSONException: \n%s\n%s", obj, e);
                return;
            }
        }
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(appEventUserAndAppDataField);
        if (sectionFieldMapping == null) {
            field = null;
        } else {
            field = sectionFieldMapping.getField();
        }
        if (field == null) {
            return;
        }
        map.put(field.getRawValue(), obj);
    }

    private final String transformEventName(String str) {
        Map<String, ConversionsAPIEventName> map = standardEventTransformations;
        if (map.containsKey(str)) {
            ConversionsAPIEventName conversionsAPIEventName = map.get(str);
            if (conversionsAPIEventName == null) {
                return "";
            }
            return conversionsAPIEventName.getRawValue();
        }
        return str;
    }

    @x0XOIxOo
    @oOoXoXO
    public static final ArrayList<Map<String, Object>> transformEvents$facebook_core_release(@OOXIXo String appEvents) {
        IIX0o.x0xO0oo(appEvents, "appEvents");
        ArrayList<Map> arrayList = new ArrayList();
        try {
            Utility utility = Utility.INSTANCE;
            for (String str : Utility.convertJSONArrayToList(new JSONArray(appEvents))) {
                Utility utility2 = Utility.INSTANCE;
                arrayList.add(Utility.convertJSONObjectToHashMap(new JSONObject(str)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            ArrayList<Map<String, Object>> arrayList2 = new ArrayList<>();
            for (Map map : arrayList) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (String str2 : map.keySet()) {
                    CustomEventField invoke = CustomEventField.Companion.invoke(str2);
                    SectionCustomEventFieldMapping sectionCustomEventFieldMapping = customEventTransformations.get(invoke);
                    if (invoke != null && sectionCustomEventFieldMapping != null) {
                        ConversionsAPISection section = sectionCustomEventFieldMapping.getSection();
                        if (section != null) {
                            if (section == ConversionsAPISection.CUSTOM_DATA) {
                                String rawValue = sectionCustomEventFieldMapping.getField().getRawValue();
                                Object obj = map.get(str2);
                                if (obj != null) {
                                    Object transformValue$facebook_core_release = transformValue$facebook_core_release(str2, obj);
                                    if (transformValue$facebook_core_release != null) {
                                        linkedHashMap.put(rawValue, transformValue$facebook_core_release);
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                }
                            } else {
                                continue;
                            }
                        } else {
                            try {
                                String rawValue2 = sectionCustomEventFieldMapping.getField().getRawValue();
                                if (invoke == CustomEventField.EVENT_NAME && ((String) map.get(str2)) != null) {
                                    AppEventsConversionsAPITransformer appEventsConversionsAPITransformer = INSTANCE;
                                    Object obj2 = map.get(str2);
                                    if (obj2 != null) {
                                        linkedHashMap2.put(rawValue2, appEventsConversionsAPITransformer.transformEventName((String) obj2));
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else if (invoke == CustomEventField.EVENT_TIME && ((Integer) map.get(str2)) != null) {
                                    Object obj3 = map.get(str2);
                                    if (obj3 != null) {
                                        Object transformValue$facebook_core_release2 = transformValue$facebook_core_release(str2, obj3);
                                        if (transformValue$facebook_core_release2 != null) {
                                            linkedHashMap2.put(rawValue2, transformValue$facebook_core_release2);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                }
                            } catch (ClassCastException e) {
                                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents ClassCastException: \n %s ", oO.xxIXOIIO(e));
                            }
                        }
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    linkedHashMap2.put(ConversionsAPISection.CUSTOM_DATA.getRawValue(), linkedHashMap);
                }
                arrayList2.add(linkedHashMap2);
            }
            return arrayList2;
        } catch (JSONException e2) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents JSONException: \n%s\n%s", appEvents, e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.Map] */
    @x0XOIxOo
    @oOoXoXO
    public static final Object transformValue$facebook_core_release(@OOXIXo String field, @OOXIXo Object value) {
        String str;
        boolean z = false;
        IIX0o.x0xO0oo(field, "field");
        IIX0o.x0xO0oo(value, "value");
        ValueTransformationType invoke = ValueTransformationType.Companion.invoke(field);
        if (value instanceof String) {
            str = (String) value;
        } else {
            str = null;
        }
        if (invoke != null && str != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[invoke.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return o00.XXoOx0(value.toString());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                Integer XXoOx02 = o00.XXoOx0(str.toString());
                if (XXoOx02 == null) {
                    return null;
                }
                if (XXoOx02.intValue() != 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            try {
                Utility utility = Utility.INSTANCE;
                List<String> convertJSONArrayToList = Utility.convertJSONArrayToList(new JSONArray(str));
                ArrayList arrayList = new ArrayList();
                Iterator it = convertJSONArrayToList.iterator();
                while (it.hasNext()) {
                    ?? r4 = (String) it.next();
                    try {
                        try {
                            Utility utility2 = Utility.INSTANCE;
                            r4 = Utility.convertJSONObjectToHashMap(new JSONObject((String) r4));
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        Utility utility3 = Utility.INSTANCE;
                        r4 = Utility.convertJSONArrayToList(new JSONArray((String) r4));
                    }
                    arrayList.add(r4);
                }
                return arrayList;
            } catch (JSONException e) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\n transformEvents JSONException: \n%s\n%s", value, e);
                return oXIO0o0XI.f29392oIX0oI;
            }
        }
        return value;
    }

    @oOoXoXO
    public final List<Map<String, Object>> combineAllTransformedData$facebook_core_release(@OOXIXo AppEventType eventType, @OOXIXo Map<String, Object> userData, @OOXIXo Map<String, Object> appData, @OOXIXo Map<String, Object> restOfData, @OOXIXo List<? extends Map<String, ? extends Object>> customEvents, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(eventType, "eventType");
        IIX0o.x0xO0oo(userData, "userData");
        IIX0o.x0xO0oo(appData, "appData");
        IIX0o.x0xO0oo(restOfData, "restOfData");
        IIX0o.x0xO0oo(customEvents, "customEvents");
        Map<String, Object> combineCommonFields$facebook_core_release = combineCommonFields$facebook_core_release(userData, appData, restOfData);
        int i = WhenMappings.$EnumSwitchMapping$2[eventType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return combineAllTransformedDataForCustom(combineCommonFields$facebook_core_release, customEvents);
        }
        return combineAllTransformedDataForMobileAppInstall(combineCommonFields$facebook_core_release, obj);
    }

    @OOXIXo
    public final Map<String, Object> combineCommonFields$facebook_core_release(@OOXIXo Map<String, ? extends Object> userData, @OOXIXo Map<String, ? extends Object> appData, @OOXIXo Map<String, ? extends Object> restOfData) {
        IIX0o.x0xO0oo(userData, "userData");
        IIX0o.x0xO0oo(appData, "appData");
        IIX0o.x0xO0oo(restOfData, "restOfData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(OtherEventConstants.ACTION_SOURCE.getRawValue(), OtherEventConstants.APP.getRawValue());
        linkedHashMap.put(ConversionsAPISection.USER_DATA.getRawValue(), userData);
        linkedHashMap.put(ConversionsAPISection.APP_DATA.getRawValue(), appData);
        linkedHashMap.putAll(restOfData);
        return linkedHashMap;
    }

    @oOoXoXO
    public final List<Map<String, Object>> conversionsAPICompatibleEvent$facebook_core_release(@OOXIXo Map<String, ? extends Object> parameters) {
        IIX0o.x0xO0oo(parameters, "parameters");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        AppEventType splitAppEventParameters = splitAppEventParameters(parameters, linkedHashMap, linkedHashMap2, arrayList, linkedHashMap3);
        if (splitAppEventParameters == AppEventType.OTHER) {
            return null;
        }
        return combineAllTransformedData$facebook_core_release(splitAppEventParameters, linkedHashMap, linkedHashMap2, linkedHashMap3, arrayList, parameters.get(OtherEventConstants.INSTALL_EVENT_TIME.getRawValue()));
    }

    public final void transformAndUpdateAppAndUserData$facebook_core_release(@OOXIXo Map<String, Object> userData, @OOXIXo Map<String, Object> appData, @OOXIXo AppEventUserAndAppDataField field, @OOXIXo Object value) {
        IIX0o.x0xO0oo(userData, "userData");
        IIX0o.x0xO0oo(appData, "appData");
        IIX0o.x0xO0oo(field, "field");
        IIX0o.x0xO0oo(value, "value");
        SectionFieldMapping sectionFieldMapping = topLevelTransformations.get(field);
        if (sectionFieldMapping == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[sectionFieldMapping.getSection().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            transformAndUpdateUserData(userData, field, value);
            return;
        }
        transformAndUpdateAppData(appData, field, value);
    }
}
