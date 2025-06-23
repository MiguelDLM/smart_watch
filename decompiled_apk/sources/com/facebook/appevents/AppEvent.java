package com.facebook.appevents;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class AppEvent implements Serializable {
    private static final int MAX_IDENTIFIER_LENGTH = 40;
    private static final long serialVersionUID = 1;

    @OXOo.oOoXoXO
    private final String checksum;
    private final boolean inBackground;
    private final boolean isImplicit;

    @OXOo.OOXIXo
    private final JSONObject jsonObject;

    @OXOo.OOXIXo
    private final String name;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final HashSet<String> validatedIdentifiers = new HashSet<>();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String md5Checksum(String str) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Charset forName = Charset.forName("UTF-8");
                IIX0o.oO(forName, "Charset.forName(charsetName)");
                if (str != null) {
                    byte[] bytes = str.getBytes(forName);
                    IIX0o.oO(bytes, "(this as java.lang.String).getBytes(charset)");
                    messageDigest.update(bytes, 0, bytes.length);
                    byte[] digest = messageDigest.digest();
                    IIX0o.oO(digest, "digest.digest()");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    return AppEventUtility.bytesToHex(digest);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (UnsupportedEncodingException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd("Failed to generate checksum: ", e);
                return "1";
            } catch (NoSuchAlgorithmException e2) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd("Failed to generate checksum: ", e2);
                return "0";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateIdentifier(String str) {
            boolean contains;
            if (str != null && str.length() != 0 && str.length() <= 40) {
                synchronized (AppEvent.validatedIdentifiers) {
                    contains = AppEvent.validatedIdentifiers.contains(str);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                }
                if (!contains) {
                    if (new Regex("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").matches(str)) {
                        synchronized (AppEvent.validatedIdentifiers) {
                            AppEvent.validatedIdentifiers.add(str);
                        }
                        return;
                    } else {
                        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                        String format = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{str}, 1));
                        IIX0o.oO(format, "java.lang.String.format(format, *args)");
                        throw new FacebookException(format);
                    }
                }
                return;
            }
            if (str == null) {
                str = "<None Provided>";
            }
            oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
            String format2 = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, 40}, 2));
            IIX0o.oO(format2, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format2);
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class SerializationProxyV2 implements Serializable {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 20160803001L;

        @OXOo.oOoXoXO
        private final String checksum;
        private final boolean inBackground;
        private final boolean isImplicit;

        @OXOo.OOXIXo
        private final String jsonString;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public SerializationProxyV2(@OXOo.OOXIXo String jsonString, boolean z, boolean z2, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(jsonString, "jsonString");
            this.jsonString = jsonString;
            this.isImplicit = z;
            this.inBackground = z2;
            this.checksum = str;
        }

        private final Object readResolve() throws JSONException, ObjectStreamException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, this.checksum, null);
        }
    }

    public /* synthetic */ AppEvent(String str, boolean z, boolean z2, String str2, IIXOooo iIXOooo) {
        this(str, z, z2, str2);
    }

    private final String calculateChecksum() {
        Companion companion = Companion;
        String jSONObject = this.jsonObject.toString();
        IIX0o.oO(jSONObject, "jsonObject.toString()");
        return companion.md5Checksum(jSONObject);
    }

    private final JSONObject getJSONObjectForAppEvent(String str, String str2, Double d, Bundle bundle, UUID uuid) {
        Companion companion = Companion;
        companion.validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
        String processEvent = RestrictiveDataManager.processEvent(str2);
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, processEvent);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, companion.md5Checksum(processEvent));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (bundle != null) {
            Map<String, String> validateParameters = validateParameters(bundle);
            for (String str3 : validateParameters.keySet()) {
                jSONObject.put(str3, validateParameters.get(str3));
            }
        }
        if (d != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put("_inBackground", "1");
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", "1");
        } else {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String jSONObject2 = jSONObject.toString();
            IIX0o.oO(jSONObject2, "eventObject.toString()");
            companion2.log(loggingBehavior, "AppEvents", "Created app event '%s'", jSONObject2);
        }
        return jSONObject;
    }

    private final Map<String, String> validateParameters(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String key : bundle.keySet()) {
            Companion companion = Companion;
            IIX0o.oO(key, "key");
            companion.validateIdentifier(key);
            Object obj = bundle.get(key);
            if (!(obj instanceof String) && !(obj instanceof Number)) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                String format = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, key}, 2));
                IIX0o.oO(format, "java.lang.String.format(format, *args)");
                throw new FacebookException(format);
            }
            hashMap.put(key, obj.toString());
        }
        IntegrityManager integrityManager = IntegrityManager.INSTANCE;
        IntegrityManager.processParameters(hashMap);
        RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
        RestrictiveDataManager.processParameters(hashMap, this.name);
        EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
        EventDeactivationManager.processDeprecatedParameters(hashMap, this.name);
        return hashMap;
    }

    private final Object writeReplace() throws ObjectStreamException {
        String jSONObject = this.jsonObject.toString();
        IIX0o.oO(jSONObject, "jsonObject.toString()");
        return new SerializationProxyV2(jSONObject, this.isImplicit, this.inBackground, this.checksum);
    }

    public final boolean getIsImplicit() {
        return this.isImplicit;
    }

    @OXOo.OOXIXo
    public final JSONObject getJSONObject() {
        return this.jsonObject;
    }

    @OXOo.OOXIXo
    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    @OXOo.OOXIXo
    public final String getName() {
        return this.name;
    }

    public final boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return IIX0o.Oxx0IOOO(calculateChecksum(), this.checksum);
    }

    public final boolean isImplicit() {
        return this.isImplicit;
    }

    @OXOo.OOXIXo
    public String toString() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()}, 3));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public AppEvent(@OXOo.OOXIXo String contextName, @OXOo.OOXIXo String eventName, @OXOo.oOoXoXO Double d, @OXOo.oOoXoXO Bundle bundle, boolean z, boolean z2, @OXOo.oOoXoXO UUID uuid) throws JSONException, FacebookException {
        IIX0o.x0xO0oo(contextName, "contextName");
        IIX0o.x0xO0oo(eventName, "eventName");
        this.isImplicit = z;
        this.inBackground = z2;
        this.name = eventName;
        this.jsonObject = getJSONObjectForAppEvent(contextName, eventName, d, bundle, uuid);
        this.checksum = calculateChecksum();
    }

    private AppEvent(String str, boolean z, boolean z2, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.isImplicit = z;
        String optString = jSONObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        IIX0o.oO(optString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.name = optString;
        this.checksum = str2;
        this.inBackground = z2;
    }
}
