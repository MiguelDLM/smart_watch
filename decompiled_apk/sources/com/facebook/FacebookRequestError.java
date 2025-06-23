package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.qualityvalidation.Excuse;
import com.facebook.internal.qualityvalidation.ExcusesForDesignViolations;
import com.garmin.fit.X0xOO;
import java.net.HttpURLConnection;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONObject;

@ExcusesForDesignViolations({@Excuse(reason = "Legacy migration", type = "KOTLIN_JVM_FIELD")})
/* loaded from: classes8.dex */
public final class FacebookRequestError implements Parcelable {

    @OXOo.OOXIXo
    private static final String BODY_KEY = "body";

    @OXOo.OOXIXo
    private static final String CODE_KEY = "code";

    @OXOo.OOXIXo
    private static final String ERROR_CODE_FIELD_KEY = "code";

    @OXOo.OOXIXo
    private static final String ERROR_CODE_KEY = "error_code";

    @OXOo.OOXIXo
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";

    @OXOo.OOXIXo
    private static final String ERROR_KEY = "error";

    @OXOo.OOXIXo
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";

    @OXOo.OOXIXo
    private static final String ERROR_MSG_KEY = "error_msg";

    @OXOo.OOXIXo
    private static final String ERROR_REASON_KEY = "error_reason";

    @OXOo.OOXIXo
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";

    @OXOo.OOXIXo
    private static final String ERROR_TYPE_FIELD_KEY = "type";

    @OXOo.OOXIXo
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";

    @OXOo.OOXIXo
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;

    @OXOo.oOoXoXO
    private final Object batchRequestResult;

    @OXOo.OOXIXo
    private final Category category;

    @OXOo.oOoXoXO
    private final HttpURLConnection connection;
    private final int errorCode;

    @OXOo.oOoXoXO
    private final String errorMessage;

    @OXOo.oOoXoXO
    private final String errorRecoveryMessage;

    @OXOo.oOoXoXO
    private final String errorType;

    @OXOo.oOoXoXO
    private final String errorUserMessage;

    @OXOo.oOoXoXO
    private final String errorUserTitle;

    @OXOo.oOoXoXO
    private FacebookException exception;

    @OXOo.oOoXoXO
    private final JSONObject requestResult;

    @OXOo.oOoXoXO
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final Range HTTP_RANGE_SUCCESS = new Range(200, X0xOO.f13593OIxOX);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() { // from class: com.facebook.FacebookRequestError$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public FacebookRequestError createFromParcel(@OXOo.OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new FacebookRequestError(parcel, (kotlin.jvm.internal.IIXOooo) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    };

    /* loaded from: classes8.dex */
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Category[] valuesCustom() {
            Category[] valuesCustom = values();
            return (Category[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00d3 A[Catch: JSONException -> 0x0128, TryCatch #0 {JSONException -> 0x0128, blocks: (B:3:0x0012, B:5:0x0018, B:7:0x0024, B:9:0x0028, B:12:0x0036, B:30:0x00d3, B:33:0x007a, B:34:0x0071, B:35:0x0067, B:36:0x005f, B:37:0x0058, B:38:0x004e, B:39:0x0043, B:40:0x0087, B:43:0x0094, B:45:0x009d, B:49:0x00ae, B:50:0x00f4, B:52:0x00fe, B:54:0x0106, B:55:0x010f), top: B:2:0x0012 }] */
        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.facebook.FacebookRequestError checkResponseAndCreateError(@OXOo.OOXIXo org.json.JSONObject r20, @OXOo.oOoXoXO java.lang.Object r21, @OXOo.oOoXoXO java.net.HttpURLConnection r22) {
            /*
                Method dump skipped, instructions count: 297
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.Companion.checkResponseAndCreateError(org.json.JSONObject, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final synchronized FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
            }
            return appSettingsWithoutQuery.getErrorClassification();
        }

        @OXOo.OOXIXo
        public final Range getHTTP_RANGE_SUCCESS$facebook_core_release() {
            return FacebookRequestError.HTTP_RANGE_SUCCESS;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class Range {
        private final int end;
        private final int start;

        public Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public final boolean contains(int i) {
            int i2 = this.start;
            if (i > this.end || i2 > i) {
                return false;
            }
            return true;
        }
    }

    public /* synthetic */ FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i, i2, i3, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, facebookException, z);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final FacebookRequestError checkResponseAndCreateError(@OXOo.OOXIXo JSONObject jSONObject, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO HttpURLConnection httpURLConnection) {
        return Companion.checkResponseAndCreateError(jSONObject, obj, httpURLConnection);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final synchronized FacebookRequestErrorClassification getErrorClassification() {
        FacebookRequestErrorClassification errorClassification;
        synchronized (FacebookRequestError.class) {
            errorClassification = Companion.getErrorClassification();
        }
        return errorClassification;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @OXOo.oOoXoXO
    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    @OXOo.OOXIXo
    public final Category getCategory() {
        return this.category;
    }

    @OXOo.oOoXoXO
    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @OXOo.oOoXoXO
    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str == null) {
            FacebookException facebookException = this.exception;
            if (facebookException == null) {
                return null;
            }
            return facebookException.getLocalizedMessage();
        }
        return str;
    }

    @OXOo.oOoXoXO
    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    @OXOo.oOoXoXO
    public final String getErrorType() {
        return this.errorType;
    }

    @OXOo.oOoXoXO
    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    @OXOo.oOoXoXO
    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    @OXOo.oOoXoXO
    public final FacebookException getException() {
        return this.exception;
    }

    @OXOo.oOoXoXO
    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    @OXOo.oOoXoXO
    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    @OXOo.OOXIXo
    public String toString() {
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO;
        IIX0o.oO(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        out.writeInt(this.requestStatusCode);
        out.writeInt(this.errorCode);
        out.writeInt(this.subErrorCode);
        out.writeString(this.errorType);
        out.writeString(getErrorMessage());
        out.writeString(this.errorUserTitle);
        out.writeString(this.errorUserMessage);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(parcel);
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z) {
        Category classify;
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorMessage = str2;
        if (facebookException != null) {
            this.exception = facebookException;
            classify = Category.OTHER;
        } else {
            this.exception = new FacebookServiceException(this, getErrorMessage());
            classify = Companion.getErrorClassification().classify(i2, i3, z);
        }
        this.category = classify;
        this.errorRecoveryMessage = Companion.getErrorClassification().getRecoveryMessage(classify);
    }

    @VisibleForTesting(otherwise = 4)
    public FacebookRequestError(@OXOo.oOoXoXO HttpURLConnection httpURLConnection, @OXOo.oOoXoXO Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc), false);
    }

    public FacebookRequestError(int i, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        this(-1, i, -1, str, str2, null, null, null, null, null, null, null, false);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, null, null, null, null, false);
    }
}
