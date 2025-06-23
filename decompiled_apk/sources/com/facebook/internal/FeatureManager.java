package com.facebook.internal;

import android.R;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class FeatureManager {

    @OXOo.OOXIXo
    private static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";

    @OXOo.OOXIXo
    public static final FeatureManager INSTANCE = new FeatureManager();

    @OXOo.OOXIXo
    private static final Map<Feature, String[]> featureMapping = new HashMap();

    /* loaded from: classes8.dex */
    public interface Callback {
        void onCompleted(boolean z);
    }

    /* loaded from: classes8.dex */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        CloudBridge(67584),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        AnrReport(131840),
        Monitoring(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE),
        ServiceUpdateCompliance(196864),
        Login(16777216),
        ChromeCustomTabsPrefetching(R.attr.theme),
        IgnoreAppSwitchToLoggedOut(R.id.background),
        BypassAppSwitch(R.style.Animation),
        Share(33554432);


        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private final int code;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final Feature fromInt(int i) {
                Feature[] valuesCustom = Feature.valuesCustom();
                int length = valuesCustom.length;
                int i2 = 0;
                while (i2 < length) {
                    Feature feature = valuesCustom[i2];
                    i2++;
                    if (feature.code == i) {
                        return feature;
                    }
                }
                return Feature.Unknown;
            }

            private Companion() {
            }
        }

        /* loaded from: classes8.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Feature.valuesCustom().length];
                iArr[Feature.Core.ordinal()] = 1;
                iArr[Feature.AppEvents.ordinal()] = 2;
                iArr[Feature.CodelessEvents.ordinal()] = 3;
                iArr[Feature.RestrictiveDataFiltering.ordinal()] = 4;
                iArr[Feature.Instrument.ordinal()] = 5;
                iArr[Feature.CrashReport.ordinal()] = 6;
                iArr[Feature.CrashShield.ordinal()] = 7;
                iArr[Feature.ThreadCheck.ordinal()] = 8;
                iArr[Feature.ErrorReport.ordinal()] = 9;
                iArr[Feature.AnrReport.ordinal()] = 10;
                iArr[Feature.AAM.ordinal()] = 11;
                iArr[Feature.CloudBridge.ordinal()] = 12;
                iArr[Feature.PrivacyProtection.ordinal()] = 13;
                iArr[Feature.SuggestedEvents.ordinal()] = 14;
                iArr[Feature.IntelligentIntegrity.ordinal()] = 15;
                iArr[Feature.ModelRequest.ordinal()] = 16;
                iArr[Feature.EventDeactivation.ordinal()] = 17;
                iArr[Feature.OnDeviceEventProcessing.ordinal()] = 18;
                iArr[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 19;
                iArr[Feature.IapLogging.ordinal()] = 20;
                iArr[Feature.IapLoggingLib2.ordinal()] = 21;
                iArr[Feature.Monitoring.ordinal()] = 22;
                iArr[Feature.ServiceUpdateCompliance.ordinal()] = 23;
                iArr[Feature.Login.ordinal()] = 24;
                iArr[Feature.ChromeCustomTabsPrefetching.ordinal()] = 25;
                iArr[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 26;
                iArr[Feature.BypassAppSwitch.ordinal()] = 27;
                iArr[Feature.Share.ordinal()] = 28;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        Feature(int i) {
            this.code = i;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Feature[] valuesCustom() {
            Feature[] valuesCustom = values();
            return (Feature[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        @OXOo.OOXIXo
        public final Feature getParent() {
            int i = this.code;
            if ((i & 255) > 0) {
                return Companion.fromInt(i & (-256));
            }
            if ((65280 & i) > 0) {
                return Companion.fromInt(i & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i) > 0) {
                return Companion.fromInt(i & ViewCompat.MEASURED_STATE_MASK);
            }
            return Companion.fromInt(0);
        }

        @OXOo.OOXIXo
        public final String toKey() {
            return IIX0o.XIxXXX0x0("FBSDKFeature", this);
        }

        @Override // java.lang.Enum
        @OXOo.OOXIXo
        public String toString() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "RestrictiveDataFiltering";
                case 5:
                    return "Instrument";
                case 6:
                    return "CrashReport";
                case 7:
                    return "CrashShield";
                case 8:
                    return "ThreadCheck";
                case 9:
                    return "ErrorReport";
                case 10:
                    return "AnrReport";
                case 11:
                    return "AAM";
                case 12:
                    return "AppEventsCloudbridge";
                case 13:
                    return "PrivacyProtection";
                case 14:
                    return "SuggestedEvents";
                case 15:
                    return "IntelligentIntegrity";
                case 16:
                    return "ModelRequest";
                case 17:
                    return "EventDeactivation";
                case 18:
                    return "OnDeviceEventProcessing";
                case 19:
                    return "OnDevicePostInstallEventProcessing";
                case 20:
                    return "IAPLogging";
                case 21:
                    return "IAPLoggingLib2";
                case 22:
                    return "Monitoring";
                case 23:
                    return "ServiceUpdateCompliance";
                case 24:
                    return "LoginKit";
                case 25:
                    return "ChromeCustomTabsPrefetching";
                case 26:
                    return "IgnoreAppSwitchToLoggedOut";
                case 27:
                    return "BypassAppSwitch";
                case 28:
                    return "ShareKit";
                default:
                    return "unknown";
            }
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Feature.valuesCustom().length];
            iArr[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            iArr[Feature.Instrument.ordinal()] = 2;
            iArr[Feature.CrashReport.ordinal()] = 3;
            iArr[Feature.CrashShield.ordinal()] = 4;
            iArr[Feature.ThreadCheck.ordinal()] = 5;
            iArr[Feature.ErrorReport.ordinal()] = 6;
            iArr[Feature.AnrReport.ordinal()] = 7;
            iArr[Feature.AAM.ordinal()] = 8;
            iArr[Feature.CloudBridge.ordinal()] = 9;
            iArr[Feature.PrivacyProtection.ordinal()] = 10;
            iArr[Feature.SuggestedEvents.ordinal()] = 11;
            iArr[Feature.IntelligentIntegrity.ordinal()] = 12;
            iArr[Feature.ModelRequest.ordinal()] = 13;
            iArr[Feature.EventDeactivation.ordinal()] = 14;
            iArr[Feature.OnDeviceEventProcessing.ordinal()] = 15;
            iArr[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 16;
            iArr[Feature.IapLogging.ordinal()] = 17;
            iArr[Feature.IapLoggingLib2.ordinal()] = 18;
            iArr[Feature.ChromeCustomTabsPrefetching.ordinal()] = 19;
            iArr[Feature.Monitoring.ordinal()] = 20;
            iArr[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 21;
            iArr[Feature.BypassAppSwitch.ordinal()] = 22;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FeatureManager() {
    }

    @XO0OX.x0XOIxOo
    public static final void checkFeature(@OXOo.OOXIXo final Feature feature, @OXOo.OOXIXo final Callback callback) {
        IIX0o.x0xO0oo(feature, "feature");
        IIX0o.x0xO0oo(callback, "callback");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FetchedAppGateKeepersManager.Callback() { // from class: com.facebook.internal.FeatureManager$checkFeature$1
            @Override // com.facebook.internal.FetchedAppGateKeepersManager.Callback
            public void onCompleted() {
                FeatureManager.Callback callback2 = FeatureManager.Callback.this;
                FeatureManager featureManager = FeatureManager.INSTANCE;
                callback2.onCompleted(FeatureManager.isEnabled(feature));
            }
        });
    }

    private final boolean defaultStatus(Feature feature) {
        switch (WhenMappings.$EnumSwitchMapping$0[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return false;
            default:
                return true;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void disableFeature(@OXOo.OOXIXo Feature feature) {
        IIX0o.x0xO0oo(feature, "feature");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).edit().putString(feature.toKey(), FacebookSdk.getSdkVersion()).apply();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Feature getFeature(@OXOo.OOXIXo String className) {
        IIX0o.x0xO0oo(className, "className");
        INSTANCE.initializeFeatureMapping();
        for (Map.Entry<Feature, String[]> entry : featureMapping.entrySet()) {
            Feature key = entry.getKey();
            String[] value = entry.getValue();
            int length = value.length;
            int i = 0;
            while (i < length) {
                String str = value[i];
                i++;
                if (kotlin.text.OxI.IOOoXo0Ix(className, str, false, 2, null)) {
                    return key;
                }
            }
        }
        return Feature.Unknown;
    }

    private final boolean getGKStatus(Feature feature) {
        boolean defaultStatus = defaultStatus(feature);
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        String key = feature.toKey();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FetchedAppGateKeepersManager.getGateKeeperForKey(key, FacebookSdk.getApplicationId(), defaultStatus);
    }

    private final synchronized void initializeFeatureMapping() {
        Map<Feature, String[]> map = featureMapping;
        if (!map.isEmpty()) {
            return;
        }
        map.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
        map.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
        map.put(Feature.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
        map.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
        map.put(Feature.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
        map.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
        map.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
        map.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
        map.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
        map.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
        map.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
        map.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
        map.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
    }

    @XO0OX.x0XOIxOo
    public static final boolean isEnabled(@OXOo.OOXIXo Feature feature) {
        IIX0o.x0xO0oo(feature, "feature");
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).getString(feature.toKey(), null);
        if (string != null && IIX0o.Oxx0IOOO(string, FacebookSdk.getSdkVersion())) {
            return false;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return INSTANCE.getGKStatus(feature);
        }
        if (!isEnabled(parent) || !INSTANCE.getGKStatus(feature)) {
            return false;
        }
        return true;
    }
}
