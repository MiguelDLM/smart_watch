package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AppEventsLoggerUtility {

    @OOXIXo
    public static final AppEventsLoggerUtility INSTANCE = new AppEventsLoggerUtility();

    @OOXIXo
    private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = o0.oOXoIIIo(Xo0.oIX0oI(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), Xo0.oIX0oI(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));

    /* loaded from: classes8.dex */
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static GraphAPIActivityType[] valuesCustom() {
            GraphAPIActivityType[] valuesCustom = values();
            return (GraphAPIActivityType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    private AppEventsLoggerUtility() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final JSONObject getJSONObjectForGraphAPICall(@OOXIXo GraphAPIActivityType activityType, @oOoXoXO AttributionIdentifiers attributionIdentifiers, @oOoXoXO String str, boolean z, @OOXIXo Context context) throws JSONException {
        IIX0o.x0xO0oo(activityType, "activityType");
        IIX0o.x0xO0oo(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, API_ACTIVITY_TYPE_TO_STRING.get(activityType));
        String userID = AppEventsLogger.Companion.getUserID();
        if (userID != null) {
            jSONObject.put("app_user_id", userID);
        }
        Utility utility = Utility.INSTANCE;
        Utility.setAppEventAttributionParameters(jSONObject, attributionIdentifiers, str, z, context);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
        } catch (Exception e) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        Utility utility2 = Utility.INSTANCE;
        JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
        if (dataProcessingOptions != null) {
            Iterator<String> keys = dataProcessingOptions.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, dataProcessingOptions.get(next));
            }
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
