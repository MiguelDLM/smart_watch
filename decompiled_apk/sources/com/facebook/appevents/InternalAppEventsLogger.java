package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class InternalAppEventsLogger {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private final AppEventsLoggerImpl loggerImpl;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ InternalAppEventsLogger createInstance$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.createInstance(context, str);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xoIox
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final InternalAppEventsLogger createInstance(@OXOo.oOoXoXO Context context) {
            return createInstance$default(this, context, null, 2, null);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final Executor getAnalyticsExecutor() {
            return AppEventsLoggerImpl.Companion.getAnalyticsExecutor();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final String getPushNotificationsRegistrationId() {
            return AppEventsLoggerImpl.Companion.getPushNotificationsRegistrationId();
        }

        @XO0OX.x0XOIxOo
        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        public final void setInternalUserData(@OXOo.OOXIXo Map<String, String> ud) {
            IIX0o.x0xO0oo(ud, "ud");
            UserDataStore userDataStore = UserDataStore.INSTANCE;
            UserDataStore.setInternalUd(ud);
        }

        @XO0OX.x0XOIxOo
        public final void setUserData(@OXOo.oOoXoXO Bundle bundle) {
            UserDataStore userDataStore = UserDataStore.INSTANCE;
            UserDataStore.setUserDataAndHash(bundle);
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @XO0OX.xoIox
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final InternalAppEventsLogger createInstance(@OXOo.oOoXoXO Context context, @OXOo.oOoXoXO String str) {
            return new InternalAppEventsLogger(context, str);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final InternalAppEventsLogger createInstance(@OXOo.OOXIXo String activityName, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO AccessToken accessToken) {
            IIX0o.x0xO0oo(activityName, "activityName");
            return new InternalAppEventsLogger(activityName, str, accessToken);
        }
    }

    public InternalAppEventsLogger(@OXOo.OOXIXo AppEventsLoggerImpl loggerImpl) {
        IIX0o.x0xO0oo(loggerImpl, "loggerImpl");
        this.loggerImpl = loggerImpl;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xoIox
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final InternalAppEventsLogger createInstance(@OXOo.oOoXoXO Context context) {
        return Companion.createInstance(context);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Executor getAnalyticsExecutor() {
        return Companion.getAnalyticsExecutor();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final AppEventsLogger.FlushBehavior getFlushBehavior() {
        return Companion.getFlushBehavior();
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getPushNotificationsRegistrationId() {
        return Companion.getPushNotificationsRegistrationId();
    }

    @XO0OX.x0XOIxOo
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public static final void setInternalUserData(@OXOo.OOXIXo Map<String, String> map) {
        Companion.setInternalUserData(map);
    }

    @XO0OX.x0XOIxOo
    public static final void setUserData(@OXOo.oOoXoXO Bundle bundle) {
        Companion.setUserData(bundle);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    public final void logChangedSettingsEvent(@OXOo.OOXIXo Bundle parameters) {
        boolean z;
        IIX0o.x0xO0oo(parameters, "parameters");
        if ((parameters.getInt("previous") & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
                return;
            }
        }
        this.loggerImpl.logEventImplicitly("fb_sdk_settings_changed", null, parameters);
    }

    public final void logEvent(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, bundle);
        }
    }

    public final void logEventFromSE(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        this.loggerImpl.logEventFromSE(str, str2);
    }

    public final void logEventImplicitly(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO BigDecimal bigDecimal, @OXOo.oOoXoXO Currency currency, @OXOo.oOoXoXO Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, bigDecimal, currency, bundle);
        }
    }

    public final void logPurchaseImplicitly(@OXOo.oOoXoXO BigDecimal bigDecimal, @OXOo.oOoXoXO Currency currency, @OXOo.oOoXoXO Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logPurchaseImplicitly(bigDecimal, currency, bundle);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xoIox
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final InternalAppEventsLogger createInstance(@OXOo.oOoXoXO Context context, @OXOo.oOoXoXO String str) {
        return Companion.createInstance(context, str);
    }

    public InternalAppEventsLogger(@OXOo.oOoXoXO Context context) {
        this(new AppEventsLoggerImpl(context, (String) null, (AccessToken) null));
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final InternalAppEventsLogger createInstance(@OXOo.OOXIXo String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO AccessToken accessToken) {
        return Companion.createInstance(str, str2, accessToken);
    }

    public final void logEvent(@OXOo.oOoXoXO String str, double d, @OXOo.oOoXoXO Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, d, bundle);
        }
    }

    public final void logEventImplicitly(@OXOo.oOoXoXO String str) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, null, null);
        }
    }

    public InternalAppEventsLogger(@OXOo.oOoXoXO Context context, @OXOo.oOoXoXO String str) {
        this(new AppEventsLoggerImpl(context, str, (AccessToken) null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InternalAppEventsLogger(@OXOo.OOXIXo String activityName, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO AccessToken accessToken) {
        this(new AppEventsLoggerImpl(activityName, str, accessToken));
        IIX0o.x0xO0oo(activityName, "activityName");
    }

    public final void logEventImplicitly(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Double d, @OXOo.oOoXoXO Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, d, bundle);
        }
    }

    public final void logEventImplicitly(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Bundle bundle) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, null, bundle);
        }
    }
}
