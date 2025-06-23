package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class AppEventsLogger {

    @OXOo.OOXIXo
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";

    @OXOo.OOXIXo
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";

    @OXOo.OOXIXo
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.oOoXoXO
    private static final String TAG = AppEventsLogger.class.getCanonicalName();

    @OXOo.OOXIXo
    private final AppEventsLoggerImpl loggerImpl;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        public final void activateApp(@OXOo.OOXIXo Application application) {
            IIX0o.x0xO0oo(application, "application");
            AppEventsLoggerImpl.Companion.activateApp(application, null);
        }

        @XO0OX.x0XOIxOo
        public final void augmentWebView(@OXOo.OOXIXo WebView webView, @OXOo.oOoXoXO Context context) {
            IIX0o.x0xO0oo(webView, "webView");
            AppEventsLoggerImpl.Companion.augmentWebView(webView, context);
        }

        @XO0OX.x0XOIxOo
        public final void clearUserData() {
            UserDataStore userDataStore = UserDataStore.INSTANCE;
            UserDataStore.clear();
        }

        @XO0OX.x0XOIxOo
        public final void clearUserID() {
            AnalyticsUserIDStore analyticsUserIDStore = AnalyticsUserIDStore.INSTANCE;
            AnalyticsUserIDStore.setUserID(null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final String getAnonymousAppDeviceGUID(@OXOo.OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            return AppEventsLoggerImpl.Companion.getAnonymousAppDeviceGUID(context);
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final String getUserData() {
            UserDataStore userDataStore = UserDataStore.INSTANCE;
            return UserDataStore.getHashedUserData$facebook_core_release();
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final String getUserID() {
            AnalyticsUserIDStore analyticsUserIDStore = AnalyticsUserIDStore.INSTANCE;
            return AnalyticsUserIDStore.getUserID();
        }

        @XO0OX.x0XOIxOo
        public final void initializeLib(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(context, "context");
            AppEventsLoggerImpl.Companion.initializeLib(context, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AppEventsLogger newLogger(@OXOo.OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            return new AppEventsLogger(context, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
        }

        @XO0OX.x0XOIxOo
        public final void onContextStop() {
            AppEventsLoggerImpl.Companion.onContextStop();
        }

        @XO0OX.x0XOIxOo
        public final void setFlushBehavior(@OXOo.OOXIXo FlushBehavior flushBehavior) {
            IIX0o.x0xO0oo(flushBehavior, "flushBehavior");
            AppEventsLoggerImpl.Companion.setFlushBehavior(flushBehavior);
        }

        @XO0OX.x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void setInstallReferrer(@OXOo.oOoXoXO String str) {
            AppEventsLoggerImpl.Companion.setInstallReferrer(str);
        }

        @XO0OX.x0XOIxOo
        public final void setPushNotificationsRegistrationId(@OXOo.oOoXoXO String str) {
            AppEventsLoggerImpl.Companion.setPushNotificationsRegistrationId(str);
        }

        @XO0OX.x0XOIxOo
        public final void setUserData(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO String str8, @OXOo.oOoXoXO String str9, @OXOo.oOoXoXO String str10) {
            UserDataStore userDataStore = UserDataStore.INSTANCE;
            UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
        }

        @XO0OX.x0XOIxOo
        public final void setUserID(@OXOo.oOoXoXO String str) {
            AnalyticsUserIDStore analyticsUserIDStore = AnalyticsUserIDStore.INSTANCE;
            AnalyticsUserIDStore.setUserID(str);
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        public final void activateApp(@OXOo.OOXIXo Application application, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(application, "application");
            AppEventsLoggerImpl.Companion.activateApp(application, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AppEventsLogger newLogger(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AccessToken accessToken) {
            IIX0o.x0xO0oo(context, "context");
            return new AppEventsLogger(context, null, accessToken, 0 == true ? 1 : 0);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AppEventsLogger newLogger(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO AccessToken accessToken) {
            IIX0o.x0xO0oo(context, "context");
            return new AppEventsLogger(context, str, accessToken, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AppEventsLogger newLogger(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(context, "context");
            return new AppEventsLogger(context, str, null, 0 == true ? 1 : 0);
        }
    }

    /* loaded from: classes8.dex */
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static FlushBehavior[] valuesCustom() {
            FlushBehavior[] valuesCustom = values();
            return (FlushBehavior[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ProductAvailability[] valuesCustom() {
            ProductAvailability[] valuesCustom = values();
            return (ProductAvailability[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ProductCondition[] valuesCustom() {
            ProductCondition[] valuesCustom = values();
            return (ProductCondition[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public /* synthetic */ AppEventsLogger(Context context, String str, AccessToken accessToken, IIXOooo iIXOooo) {
        this(context, str, accessToken);
    }

    @XO0OX.x0XOIxOo
    public static final void activateApp(@OXOo.OOXIXo Application application) {
        Companion.activateApp(application);
    }

    @XO0OX.x0XOIxOo
    public static final void augmentWebView(@OXOo.OOXIXo WebView webView, @OXOo.oOoXoXO Context context) {
        Companion.augmentWebView(webView, context);
    }

    @XO0OX.x0XOIxOo
    public static final void clearUserData() {
        Companion.clearUserData();
    }

    @XO0OX.x0XOIxOo
    public static final void clearUserID() {
        Companion.clearUserID();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getAnonymousAppDeviceGUID(@OXOo.OOXIXo Context context) {
        return Companion.getAnonymousAppDeviceGUID(context);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final FlushBehavior getFlushBehavior() {
        return Companion.getFlushBehavior();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getUserData() {
        return Companion.getUserData();
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getUserID() {
        return Companion.getUserID();
    }

    @XO0OX.x0XOIxOo
    public static final void initializeLib(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str) {
        Companion.initializeLib(context, str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final AppEventsLogger newLogger(@OXOo.OOXIXo Context context) {
        return Companion.newLogger(context);
    }

    @XO0OX.x0XOIxOo
    public static final void onContextStop() {
        Companion.onContextStop();
    }

    @XO0OX.x0XOIxOo
    public static final void setFlushBehavior(@OXOo.OOXIXo FlushBehavior flushBehavior) {
        Companion.setFlushBehavior(flushBehavior);
    }

    @XO0OX.x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void setInstallReferrer(@OXOo.oOoXoXO String str) {
        Companion.setInstallReferrer(str);
    }

    @XO0OX.x0XOIxOo
    public static final void setPushNotificationsRegistrationId(@OXOo.oOoXoXO String str) {
        Companion.setPushNotificationsRegistrationId(str);
    }

    @XO0OX.x0XOIxOo
    public static final void setUserData(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO String str8, @OXOo.oOoXoXO String str9, @OXOo.oOoXoXO String str10) {
        Companion.setUserData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    @XO0OX.x0XOIxOo
    public static final void setUserID(@OXOo.oOoXoXO String str) {
        Companion.setUserID(str);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    @OXOo.OOXIXo
    public final String getApplicationId() {
        return this.loggerImpl.getApplicationId();
    }

    public final boolean isValidForAccessToken(@OXOo.OOXIXo AccessToken accessToken) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        return this.loggerImpl.isValidForAccessToken(accessToken);
    }

    public final void logEvent(@OXOo.oOoXoXO String str) {
        this.loggerImpl.logEvent(str);
    }

    public final void logProductItem(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO ProductAvailability productAvailability, @OXOo.oOoXoXO ProductCondition productCondition, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO BigDecimal bigDecimal, @OXOo.oOoXoXO Currency currency, @OXOo.oOoXoXO String str6, @OXOo.oOoXoXO String str7, @OXOo.oOoXoXO String str8, @OXOo.oOoXoXO Bundle bundle) {
        this.loggerImpl.logProductItem(str, productAvailability, productCondition, str2, str3, str4, str5, bigDecimal, currency, str6, str7, str8, bundle);
    }

    public final void logPurchase(@OXOo.oOoXoXO BigDecimal bigDecimal, @OXOo.oOoXoXO Currency currency) {
        this.loggerImpl.logPurchase(bigDecimal, currency);
    }

    public final void logPushNotificationOpen(@OXOo.OOXIXo Bundle payload) {
        IIX0o.x0xO0oo(payload, "payload");
        this.loggerImpl.logPushNotificationOpen(payload, null);
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.loggerImpl = new AppEventsLoggerImpl(context, str, accessToken);
    }

    @XO0OX.x0XOIxOo
    public static final void activateApp(@OXOo.OOXIXo Application application, @OXOo.oOoXoXO String str) {
        Companion.activateApp(application, str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final AppEventsLogger newLogger(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AccessToken accessToken) {
        return Companion.newLogger(context, accessToken);
    }

    public final void logEvent(@OXOo.oOoXoXO String str, double d) {
        this.loggerImpl.logEvent(str, d);
    }

    public final void logPurchase(@OXOo.oOoXoXO BigDecimal bigDecimal, @OXOo.oOoXoXO Currency currency, @OXOo.oOoXoXO Bundle bundle) {
        this.loggerImpl.logPurchase(bigDecimal, currency, bundle);
    }

    public final void logPushNotificationOpen(@OXOo.OOXIXo Bundle payload, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(payload, "payload");
        this.loggerImpl.logPushNotificationOpen(payload, str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final AppEventsLogger newLogger(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str) {
        return Companion.newLogger(context, str);
    }

    public final void logEvent(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle) {
        this.loggerImpl.logEvent(str, bundle);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final AppEventsLogger newLogger(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO AccessToken accessToken) {
        return Companion.newLogger(context, str, accessToken);
    }

    public final void logEvent(@OXOo.oOoXoXO String str, double d, @OXOo.oOoXoXO Bundle bundle) {
        this.loggerImpl.logEvent(str, d, bundle);
    }
}
