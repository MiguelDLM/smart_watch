package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class FetchedAppSettings {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private final boolean automaticLoggingEnabled;
    private final boolean codelessEventsEnabled;

    @OXOo.OOXIXo
    private final Map<String, Map<String, DialogFeatureConfig>> dialogConfigurations;

    @OXOo.OOXIXo
    private final FacebookRequestErrorClassification errorClassification;

    @OXOo.oOoXoXO
    private final JSONArray eventBindings;
    private final boolean iAPAutomaticLoggingEnabled;
    private final boolean monitorViaDialogEnabled;

    @OXOo.OOXIXo
    private final String nuxContent;
    private final boolean nuxEnabled;

    @OXOo.oOoXoXO
    private final String rawAamRules;

    @OXOo.oOoXoXO
    private final String restrictiveDataSetting;

    @OXOo.OOXIXo
    private final String sdkUpdateMessage;
    private final int sessionTimeoutInSeconds;

    @OXOo.OOXIXo
    private final String smartLoginBookmarkIconURL;

    @OXOo.OOXIXo
    private final String smartLoginMenuIconURL;

    @OXOo.OOXIXo
    private final EnumSet<SmartLoginOption> smartLoginOptions;

    @OXOo.oOoXoXO
    private final String suggestedEventsSetting;
    private final boolean supportsImplicitLogging;
    private final boolean trackUninstallEnabled;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final DialogFeatureConfig getDialogFeatureConfig(@OXOo.OOXIXo String applicationId, @OXOo.OOXIXo String actionName, @OXOo.OOXIXo String featureName) {
            Map<String, DialogFeatureConfig> map;
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(actionName, "actionName");
            IIX0o.x0xO0oo(featureName, "featureName");
            if (actionName.length() == 0 || featureName.length() == 0) {
                return null;
            }
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
            if (appSettingsWithoutQuery == null) {
                map = null;
            } else {
                map = appSettingsWithoutQuery.getDialogConfigurations().get(actionName);
            }
            if (map == null) {
                return null;
            }
            return map.get(featureName);
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class DialogFeatureConfig {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.OOXIXo
        private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "|";

        @OXOo.OOXIXo
        private static final String DIALOG_CONFIG_NAME_KEY = "name";

        @OXOo.OOXIXo
        private static final String DIALOG_CONFIG_URL_KEY = "url";

        @OXOo.OOXIXo
        private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";

        @OXOo.OOXIXo
        private final String dialogName;

        @OXOo.oOoXoXO
        private final Uri fallbackUrl;

        @OXOo.OOXIXo
        private final String featureName;

        @OXOo.oOoXoXO
        private final int[] versionSpec;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            private final int[] parseVersionSpec(JSONArray jSONArray) {
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    int[] iArr = new int[length];
                    if (length > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            int i3 = -1;
                            int optInt = jSONArray.optInt(i, -1);
                            if (optInt == -1) {
                                String versionString = jSONArray.optString(i);
                                Utility utility = Utility.INSTANCE;
                                if (!Utility.isNullOrEmpty(versionString)) {
                                    try {
                                        IIX0o.oO(versionString, "versionString");
                                        i3 = Integer.parseInt(versionString);
                                    } catch (NumberFormatException e) {
                                        Utility utility2 = Utility.INSTANCE;
                                        Utility.logd(Utility.LOG_TAG, e);
                                    }
                                    optInt = i3;
                                }
                            }
                            iArr[i] = optInt;
                            if (i2 < length) {
                                i = i2;
                            } else {
                                return iArr;
                            }
                        }
                    } else {
                        return iArr;
                    }
                } else {
                    return null;
                }
            }

            @OXOo.oOoXoXO
            public final DialogFeatureConfig parseDialogConfig(@OXOo.OOXIXo JSONObject dialogConfigJSON) {
                IIX0o.x0xO0oo(dialogConfigJSON, "dialogConfigJSON");
                String dialogNameWithFeature = dialogConfigJSON.optString("name");
                Utility utility = Utility.INSTANCE;
                Uri uri = null;
                if (Utility.isNullOrEmpty(dialogNameWithFeature)) {
                    return null;
                }
                IIX0o.oO(dialogNameWithFeature, "dialogNameWithFeature");
                List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(dialogNameWithFeature, new String[]{DialogFeatureConfig.DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR}, false, 0, 6, null);
                if (XXoO0oX2.size() != 2) {
                    return null;
                }
                String str = (String) CollectionsKt___CollectionsKt.O0OOX0IIx(XXoO0oX2);
                String str2 = (String) CollectionsKt___CollectionsKt.O0O0Io00X(XXoO0oX2);
                if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                    return null;
                }
                String optString = dialogConfigJSON.optString("url");
                if (!Utility.isNullOrEmpty(optString)) {
                    uri = Uri.parse(optString);
                }
                return new DialogFeatureConfig(str, str2, uri, parseVersionSpec(dialogConfigJSON.optJSONArray(DialogFeatureConfig.DIALOG_CONFIG_VERSIONS_KEY)), null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this(str, str2, uri, iArr);
        }

        @OXOo.OOXIXo
        public final String getDialogName() {
            return this.dialogName;
        }

        @OXOo.oOoXoXO
        public final Uri getFallbackUrl() {
            return this.fallbackUrl;
        }

        @OXOo.OOXIXo
        public final String getFeatureName() {
            return this.featureName;
        }

        @OXOo.oOoXoXO
        public final int[] getVersionSpec() {
            return this.versionSpec;
        }

        private DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.dialogName = str;
            this.featureName = str2;
            this.fallbackUrl = uri;
            this.versionSpec = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchedAppSettings(boolean z, @OXOo.OOXIXo String nuxContent, boolean z2, int i, @OXOo.OOXIXo EnumSet<SmartLoginOption> smartLoginOptions, @OXOo.OOXIXo Map<String, ? extends Map<String, DialogFeatureConfig>> dialogConfigurations, boolean z3, @OXOo.OOXIXo FacebookRequestErrorClassification errorClassification, @OXOo.OOXIXo String smartLoginBookmarkIconURL, @OXOo.OOXIXo String smartLoginMenuIconURL, boolean z4, boolean z5, @OXOo.oOoXoXO JSONArray jSONArray, @OXOo.OOXIXo String sdkUpdateMessage, boolean z6, boolean z7, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3) {
        IIX0o.x0xO0oo(nuxContent, "nuxContent");
        IIX0o.x0xO0oo(smartLoginOptions, "smartLoginOptions");
        IIX0o.x0xO0oo(dialogConfigurations, "dialogConfigurations");
        IIX0o.x0xO0oo(errorClassification, "errorClassification");
        IIX0o.x0xO0oo(smartLoginBookmarkIconURL, "smartLoginBookmarkIconURL");
        IIX0o.x0xO0oo(smartLoginMenuIconURL, "smartLoginMenuIconURL");
        IIX0o.x0xO0oo(sdkUpdateMessage, "sdkUpdateMessage");
        this.supportsImplicitLogging = z;
        this.nuxContent = nuxContent;
        this.nuxEnabled = z2;
        this.sessionTimeoutInSeconds = i;
        this.smartLoginOptions = smartLoginOptions;
        this.dialogConfigurations = dialogConfigurations;
        this.automaticLoggingEnabled = z3;
        this.errorClassification = errorClassification;
        this.smartLoginBookmarkIconURL = smartLoginBookmarkIconURL;
        this.smartLoginMenuIconURL = smartLoginMenuIconURL;
        this.iAPAutomaticLoggingEnabled = z4;
        this.codelessEventsEnabled = z5;
        this.eventBindings = jSONArray;
        this.sdkUpdateMessage = sdkUpdateMessage;
        this.trackUninstallEnabled = z6;
        this.monitorViaDialogEnabled = z7;
        this.rawAamRules = str;
        this.suggestedEventsSetting = str2;
        this.restrictiveDataSetting = str3;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final DialogFeatureConfig getDialogFeatureConfig(@OXOo.OOXIXo String str, @OXOo.OOXIXo String str2, @OXOo.OOXIXo String str3) {
        return Companion.getDialogFeatureConfig(str, str2, str3);
    }

    public final boolean getAutomaticLoggingEnabled() {
        return this.automaticLoggingEnabled;
    }

    public final boolean getCodelessEventsEnabled() {
        return this.codelessEventsEnabled;
    }

    @OXOo.OOXIXo
    public final Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.dialogConfigurations;
    }

    @OXOo.OOXIXo
    public final FacebookRequestErrorClassification getErrorClassification() {
        return this.errorClassification;
    }

    @OXOo.oOoXoXO
    public final JSONArray getEventBindings() {
        return this.eventBindings;
    }

    public final boolean getIAPAutomaticLoggingEnabled() {
        return this.iAPAutomaticLoggingEnabled;
    }

    public final boolean getMonitorViaDialogEnabled() {
        return this.monitorViaDialogEnabled;
    }

    @OXOo.OOXIXo
    public final String getNuxContent() {
        return this.nuxContent;
    }

    public final boolean getNuxEnabled() {
        return this.nuxEnabled;
    }

    @OXOo.oOoXoXO
    public final String getRawAamRules() {
        return this.rawAamRules;
    }

    @OXOo.oOoXoXO
    public final String getRestrictiveDataSetting() {
        return this.restrictiveDataSetting;
    }

    @OXOo.OOXIXo
    public final String getSdkUpdateMessage() {
        return this.sdkUpdateMessage;
    }

    public final int getSessionTimeoutInSeconds() {
        return this.sessionTimeoutInSeconds;
    }

    @OXOo.OOXIXo
    public final String getSmartLoginBookmarkIconURL() {
        return this.smartLoginBookmarkIconURL;
    }

    @OXOo.OOXIXo
    public final String getSmartLoginMenuIconURL() {
        return this.smartLoginMenuIconURL;
    }

    @OXOo.OOXIXo
    public final EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.smartLoginOptions;
    }

    @OXOo.oOoXoXO
    public final String getSuggestedEventsSetting() {
        return this.suggestedEventsSetting;
    }

    public final boolean getTrackUninstallEnabled() {
        return this.trackUninstallEnabled;
    }

    public final boolean supportsImplicitLogging() {
        return this.supportsImplicitLogging;
    }
}
