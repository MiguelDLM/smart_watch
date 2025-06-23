package com.facebook.appevents.suggestedevents;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.SharedPreferences;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class PredictionHistoryManager {

    @OOXIXo
    private static final String CLICKED_PATH_STORE = "com.facebook.internal.SUGGESTED_EVENTS_HISTORY";

    @OOXIXo
    private static final String SUGGESTED_EVENTS_HISTORY = "SUGGESTED_EVENTS_HISTORY";
    private static SharedPreferences shardPreferences;

    @OOXIXo
    public static final PredictionHistoryManager INSTANCE = new PredictionHistoryManager();

    @OOXIXo
    private static final Map<String, String> clickedViewPaths = new LinkedHashMap();

    @OOXIXo
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    private PredictionHistoryManager() {
    }

    @x0XOIxOo
    public static final void addPrediction(@OOXIXo String pathID, @OOXIXo String predictedEvent) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(pathID, "pathID");
            IIX0o.x0xO0oo(predictedEvent, "predictedEvent");
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            Map<String, String> map = clickedViewPaths;
            map.put(pathID, predictedEvent);
            SharedPreferences sharedPreferences = shardPreferences;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                Utility utility = Utility.INSTANCE;
                edit.putString(SUGGESTED_EVENTS_HISTORY, Utility.mapToJsonStr(o0.OX00O0xII(map))).apply();
                return;
            }
            IIX0o.XOxIOxOx("shardPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PredictionHistoryManager.class);
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String getPathID(@OOXIXo View view, @OOXIXo String text) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(text, "text");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", text);
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    jSONArray.put(view.getClass().getSimpleName());
                    ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                    view = ViewHierarchy.getParentOfView(view);
                }
                jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, jSONArray);
            } catch (JSONException unused) {
            }
            Utility utility = Utility.INSTANCE;
            return Utility.sha256hash(jSONObject.toString());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PredictionHistoryManager.class);
            return null;
        }
    }

    private final void initAndWait() {
        String str = "";
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(CLICKED_PATH_STORE, 0);
            IIX0o.oO(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(CLICKED_PATH_STORE, Context.MODE_PRIVATE)");
            shardPreferences = sharedPreferences;
            Map<String, String> map = clickedViewPaths;
            Utility utility = Utility.INSTANCE;
            SharedPreferences sharedPreferences2 = shardPreferences;
            if (sharedPreferences2 != null) {
                String string = sharedPreferences2.getString(SUGGESTED_EVENTS_HISTORY, "");
                if (string != null) {
                    str = string;
                }
                map.putAll(Utility.jsonStrToMap(str));
                atomicBoolean.set(true);
                return;
            }
            IIX0o.XOxIOxOx("shardPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final String queryEvent(@OOXIXo String pathID) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(pathID, "pathID");
            Map<String, String> map = clickedViewPaths;
            if (!map.containsKey(pathID)) {
                return null;
            }
            return map.get(pathID);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PredictionHistoryManager.class);
            return null;
        }
    }
}
