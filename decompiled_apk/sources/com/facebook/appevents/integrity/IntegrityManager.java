package com.facebook.appevents.integrity;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class IntegrityManager {

    @OOXIXo
    public static final IntegrityManager INSTANCE = new IntegrityManager();

    @OOXIXo
    public static final String INTEGRITY_TYPE_ADDRESS = "address";

    @OOXIXo
    public static final String INTEGRITY_TYPE_HEALTH = "health";

    @OOXIXo
    public static final String INTEGRITY_TYPE_NONE = "none";

    @OOXIXo
    private static final String RESTRICTIVE_ON_DEVICE_PARAMS_KEY = "_onDeviceParams";
    private static boolean enabled;
    private static boolean isSampleEnabled;

    private IntegrityManager() {
    }

    @x0XOIxOo
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return;
        }
        try {
            enabled = true;
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
        }
    }

    private final String getIntegrityPredictionResult(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i = 0; i < 30; i++) {
                fArr[i] = 0.0f;
            }
            ModelManager modelManager = ModelManager.INSTANCE;
            String[] predict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
            if (predict == null) {
                return "none";
            }
            String str2 = predict[0];
            if (str2 == null) {
                return "none";
            }
            return str2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @x0XOIxOo
    public static final void processParameters(@OOXIXo Map<String, String> parameters) {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(parameters, "parameters");
            if (enabled && !parameters.isEmpty()) {
                try {
                    List<String> oOo0o = CollectionsKt___CollectionsKt.oOo0o(parameters.keySet());
                    JSONObject jSONObject = new JSONObject();
                    for (String str : oOo0o) {
                        String str2 = parameters.get(str);
                        if (str2 != null) {
                            String str3 = str2;
                            IntegrityManager integrityManager = INSTANCE;
                            if (!integrityManager.shouldFilter(str) && !integrityManager.shouldFilter(str3)) {
                            }
                            parameters.remove(str);
                            if (!isSampleEnabled) {
                                str3 = "";
                            }
                            jSONObject.put(str, str3);
                        } else {
                            throw new IllegalStateException("Required value was null.");
                        }
                    }
                    if (jSONObject.length() != 0) {
                        String jSONObject2 = jSONObject.toString();
                        IIX0o.oO(jSONObject2, "restrictiveParamJson.toString()");
                        parameters.put(RESTRICTIVE_ON_DEVICE_PARAMS_KEY, jSONObject2);
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
        }
    }

    private final boolean shouldFilter(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return !IIX0o.Oxx0IOOO("none", getIntegrityPredictionResult(str));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
