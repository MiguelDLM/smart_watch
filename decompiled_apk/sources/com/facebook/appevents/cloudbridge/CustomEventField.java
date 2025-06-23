package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.Constants;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public enum CustomEventField {
    EVENT_TIME(Constants.LOG_TIME_APP_EVENT_KEY),
    EVENT_NAME(Constants.EVENT_NAME_EVENT_KEY),
    VALUE_TO_SUM(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM),
    CONTENT_IDS(AppEventsConstants.EVENT_PARAM_CONTENT_ID),
    CONTENTS(AppEventsConstants.EVENT_PARAM_CONTENT),
    CONTENT_TYPE(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE),
    DESCRIPTION(AppEventsConstants.EVENT_PARAM_DESCRIPTION),
    LEVEL(AppEventsConstants.EVENT_PARAM_LEVEL),
    MAX_RATING_VALUE(AppEventsConstants.EVENT_PARAM_MAX_RATING_VALUE),
    NUM_ITEMS(AppEventsConstants.EVENT_PARAM_NUM_ITEMS),
    PAYMENT_INFO_AVAILABLE(AppEventsConstants.EVENT_PARAM_PAYMENT_INFO_AVAILABLE),
    REGISTRATION_METHOD(AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD),
    SEARCH_STRING(AppEventsConstants.EVENT_PARAM_SEARCH_STRING),
    SUCCESS(AppEventsConstants.EVENT_PARAM_SUCCESS),
    ORDER_ID(AppEventsConstants.EVENT_PARAM_ORDER_ID),
    AD_TYPE(AppEventsConstants.EVENT_PARAM_AD_TYPE),
    CURRENCY(AppEventsConstants.EVENT_PARAM_CURRENCY);


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
        public final CustomEventField invoke(@OOXIXo String rawValue) {
            IIX0o.x0xO0oo(rawValue, "rawValue");
            for (CustomEventField customEventField : CustomEventField.valuesCustom()) {
                if (IIX0o.Oxx0IOOO(customEventField.getRawValue(), rawValue)) {
                    return customEventField;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    CustomEventField(String str) {
        this.rawValue = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static CustomEventField[] valuesCustom() {
        CustomEventField[] valuesCustom = values();
        return (CustomEventField[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @OOXIXo
    public final String getRawValue() {
        return this.rawValue;
    }
}
