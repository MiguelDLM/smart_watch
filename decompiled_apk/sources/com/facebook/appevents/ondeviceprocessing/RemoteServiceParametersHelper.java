package com.facebook.appevents.ondeviceprocessing;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;

/* loaded from: classes8.dex */
public final class RemoteServiceParametersHelper {

    @OOXIXo
    public static final RemoteServiceParametersHelper INSTANCE = new RemoteServiceParametersHelper();

    @OOXIXo
    private static final String TAG;

    static {
        String simpleName = RemoteServiceWrapper.class.getSimpleName();
        IIX0o.oO(simpleName, "RemoteServiceWrapper::class.java.simpleName");
        TAG = simpleName;
    }

    private RemoteServiceParametersHelper() {
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Bundle buildEventsBundle(@OOXIXo RemoteServiceWrapper.EventType eventType, @OOXIXo String applicationId, @OOXIXo List<AppEvent> appEvents) {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceParametersHelper.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(eventType, "eventType");
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(appEvents, "appEvents");
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_EVENT, eventType.toString());
            bundle.putString("app_id", applicationId);
            if (RemoteServiceWrapper.EventType.CUSTOM_APP_EVENTS == eventType) {
                JSONArray buildEventsJson = INSTANCE.buildEventsJson(appEvents, applicationId);
                if (buildEventsJson.length() == 0) {
                    return null;
                }
                bundle.putString("custom_events", buildEventsJson.toString());
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceParametersHelper.class);
            return null;
        }
    }

    private final JSONArray buildEventsJson(List<AppEvent> list, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            List<AppEvent> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(list);
            EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
            EventDeactivationManager.processEvents(o0Xo0XII);
            boolean includeImplicitEvents = includeImplicitEvents(str);
            for (AppEvent appEvent : o0Xo0XII) {
                if (appEvent.isChecksumValid()) {
                    if (appEvent.isImplicit()) {
                        if (appEvent.isImplicit() && includeImplicitEvents) {
                        }
                    }
                    jSONArray.put(appEvent.getJsonObject());
                } else {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(TAG, IIX0o.XIxXXX0x0("Event with invalid checksum: ", appEvent));
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean includeImplicitEvents(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(str, false);
            if (queryAppSettings == null) {
                return false;
            }
            return queryAppSettings.supportsImplicitLogging();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
