package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class InstallReferrerUtil {

    @OXOo.OOXIXo
    public static final InstallReferrerUtil INSTANCE = new InstallReferrerUtil();

    @OXOo.OOXIXo
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    /* loaded from: classes8.dex */
    public interface Callback {
        void onReceiveReferrerUrl(@OXOo.oOoXoXO String str);
    }

    private InstallReferrerUtil() {
    }

    private final boolean isUpdated() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }

    private final void tryConnectReferrerInfo(final Callback callback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        final InstallReferrerClient oIX0oI2 = InstallReferrerClient.oxoX(FacebookSdk.getApplicationContext()).oIX0oI();
        try {
            oIX0oI2.X0o0xo(new InstallReferrerStateListener() { // from class: com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int i) {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        if (i != 0) {
                            if (i == 2) {
                                InstallReferrerUtil.INSTANCE.updateReferrer();
                                return;
                            }
                            return;
                        }
                        try {
                            ReferrerDetails II0xO02 = InstallReferrerClient.this.II0xO0();
                            IIX0o.oO(II0xO02, "{\n                      referrerClient.installReferrer\n                    }");
                            String II0xO03 = II0xO02.II0xO0();
                            if (II0xO03 != null && (StringsKt__StringsKt.o00xOoIO(II0xO03, "fb", false, 2, null) || StringsKt__StringsKt.o00xOoIO(II0xO03, AccessToken.DEFAULT_GRAPH_DOMAIN, false, 2, null))) {
                                callback.onReceiveReferrerUrl(II0xO03);
                            }
                            InstallReferrerUtil.INSTANCE.updateReferrer();
                        } catch (RemoteException unused) {
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @XO0OX.x0XOIxOo
    public static final void tryUpdateReferrerInfo(@OXOo.OOXIXo Callback callback) {
        IIX0o.x0xO0oo(callback, "callback");
        InstallReferrerUtil installReferrerUtil = INSTANCE;
        if (!installReferrerUtil.isUpdated()) {
            installReferrerUtil.tryConnectReferrerInfo(callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateReferrer() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }
}
