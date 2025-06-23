package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.p001authapiphone.zzab;

/* loaded from: classes9.dex */
public final class SmsRetriever {

    @NonNull
    public static final String EXTRA_CONSENT_INTENT = "com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT";

    @NonNull
    public static final String EXTRA_SIM_SUBSCRIPTION_ID = "com.google.android.gms.auth.api.phone.EXTRA_SIM_SUBSCRIPTION_ID";

    @NonNull
    public static final String EXTRA_SMS_MESSAGE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE";

    @NonNull
    public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";

    @NonNull
    public static final String SEND_PERMISSION = "com.google.android.gms.auth.api.phone.permission.SEND";

    @NonNull
    public static final String SMS_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED";

    private SmsRetriever() {
    }

    @NonNull
    public static SmsRetrieverClient getClient(@NonNull Activity activity) {
        return new zzab(activity);
    }

    @NonNull
    public static SmsRetrieverClient getClient(@NonNull Context context) {
        return new zzab(context);
    }
}
