package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.sma.smartv3.network.GetGooglePayCheckOrder;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class AutomaticAnalyticsLogger {

    @OOXIXo
    private static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";

    @OOXIXo
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();

    @oOoXoXO
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();

    @OOXIXo
    private static final InternalAppEventsLogger internalAppEventsLogger;

    /* loaded from: classes8.dex */
    public static final class PurchaseLoggingParameters {

        @OOXIXo
        private Currency currency;

        @OOXIXo
        private Bundle param;

        @OOXIXo
        private BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(@OOXIXo BigDecimal purchaseAmount, @OOXIXo Currency currency, @OOXIXo Bundle param) {
            IIX0o.x0xO0oo(purchaseAmount, "purchaseAmount");
            IIX0o.x0xO0oo(currency, "currency");
            IIX0o.x0xO0oo(param, "param");
            this.purchaseAmount = purchaseAmount;
            this.currency = currency;
            this.param = param;
        }

        @OOXIXo
        public final Currency getCurrency() {
            return this.currency;
        }

        @OOXIXo
        public final Bundle getParam() {
            return this.param;
        }

        @OOXIXo
        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }

        public final void setCurrency(@OOXIXo Currency currency) {
            IIX0o.x0xO0oo(currency, "<set-?>");
            this.currency = currency;
        }

        public final void setParam(@OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "<set-?>");
            this.param = bundle;
        }

        public final void setPurchaseAmount(@OOXIXo BigDecimal bigDecimal) {
            IIX0o.x0xO0oo(bigDecimal, "<set-?>");
            this.purchaseAmount = bigDecimal;
        }
    }

    static {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
    }

    private AutomaticAnalyticsLogger() {
    }

    private final PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2) {
        return getPurchaseLoggingParameters(str, str2, new HashMap());
    }

    @x0XOIxOo
    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
        if (appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled()) {
            return true;
        }
        return false;
    }

    @x0XOIxOo
    public static final void logActivateAppEvent() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            if (applicationContext instanceof Application) {
                AppEventsLogger.Companion.activateApp((Application) applicationContext, applicationId);
            } else {
                Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    @x0XOIxOo
    public static final void logActivityTimeSpentEvent(@oOoXoXO String str, long j) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings != null && queryAppSettings.getAutomaticLoggingEnabled() && j > 0) {
            InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
            internalAppEventsLogger2.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, j, bundle);
        }
    }

    @x0XOIxOo
    public static final void logPurchase(@OOXIXo String purchase, @OOXIXo String skuDetails, boolean z) {
        PurchaseLoggingParameters purchaseLoggingParameters;
        String str;
        IIX0o.x0xO0oo(purchase, "purchase");
        IIX0o.x0xO0oo(skuDetails, "skuDetails");
        if (!isImplicitPurchaseLoggingEnabled() || (purchaseLoggingParameters = INSTANCE.getPurchaseLoggingParameters(purchase, skuDetails)) == null) {
            return;
        }
        if (z) {
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FetchedAppGateKeepersManager.getGateKeeperForKey(APP_EVENTS_IF_AUTO_LOG_SUBS, FacebookSdk.getApplicationId(), false)) {
                if (InAppPurchaseEventManager.INSTANCE.hasFreeTrialPeirod(skuDetails)) {
                    str = AppEventsConstants.EVENT_NAME_START_TRIAL;
                } else {
                    str = AppEventsConstants.EVENT_NAME_SUBSCRIBE;
                }
                internalAppEventsLogger.logEventImplicitly(str, purchaseLoggingParameters.getPurchaseAmount(), purchaseLoggingParameters.getCurrency(), purchaseLoggingParameters.getParam());
                return;
            }
        }
        internalAppEventsLogger.logPurchaseImplicitly(purchaseLoggingParameters.getPurchaseAmount(), purchaseLoggingParameters.getCurrency(), purchaseLoggingParameters.getParam());
    }

    private final PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.IAP_PRODUCT_ID, jSONObject.getString(GetGooglePayCheckOrder.PRODUCT_IT));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TIME, jSONObject.getString("purchaseTime"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TOKEN, jSONObject.getString("purchaseToken"));
            bundle.putCharSequence(Constants.IAP_PACKAGE_NAME, jSONObject.optString("packageName"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_TITLE, jSONObject2.optString("title"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, jSONObject2.optString("description"));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence(Constants.IAP_PRODUCT_TYPE, optString);
            if (IIX0o.Oxx0IOOO(optString, "subs")) {
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, jSONObject2.optString("freeTrialPeriod"));
                String introductoryPriceCycles = jSONObject2.optString("introductoryPriceCycles");
                IIX0o.oO(introductoryPriceCycles, "introductoryPriceCycles");
                if (introductoryPriceCycles.length() != 0) {
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, introductoryPriceCycles);
                }
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putCharSequence(entry.getKey(), entry.getValue());
            }
            BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong("price_amount_micros") / 1000000.0d);
            Currency currency = Currency.getInstance(jSONObject2.getString("price_currency_code"));
            IIX0o.oO(currency, "getInstance(skuDetailsJSON.getString(\"price_currency_code\"))");
            return new PurchaseLoggingParameters(bigDecimal, currency, bundle);
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing in-app subscription data.", e);
            return null;
        }
    }
}
