package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DeviceAuthDialog extends DialogFragment {
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;

    @OXOo.OOXIXo
    private static final String REQUEST_STATE_KEY = "request_state";

    @OXOo.OOXIXo
    private final AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;

    @OXOo.oOoXoXO
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;

    @OXOo.oOoXoXO
    private volatile RequestState currentRequestState;

    @OXOo.oOoXoXO
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private TextView instructions;
    private boolean isBeingDestroyed;
    private boolean isRetry;
    private View progressBar;

    @OXOo.oOoXoXO
    private LoginClient.Request request;

    @OXOo.oOoXoXO
    private volatile ScheduledFuture<?> scheduledPoll;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String DEVICE_LOGIN_ENDPOINT = "device/login";

    @OXOo.OOXIXo
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PermissionsLists handlePermissionResponse(JSONObject jSONObject) throws JSONException {
            String optString;
            JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String permission = optJSONObject.optString("permission");
                    IIX0o.oO(permission, "permission");
                    if (permission.length() != 0 && !IIX0o.Oxx0IOOO(permission, "installed") && (optString = optJSONObject.optString("status")) != null) {
                        int hashCode = optString.hashCode();
                        if (hashCode != -1309235419) {
                            if (hashCode != 280295099) {
                                if (hashCode == 568196142 && optString.equals("declined")) {
                                    arrayList2.add(permission);
                                }
                            } else if (optString.equals("granted")) {
                                arrayList.add(permission);
                            }
                        } else if (optString.equals("expired")) {
                            arrayList3.add(permission);
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return new PermissionsLists(arrayList, arrayList2, arrayList3);
        }

        @OXOo.OOXIXo
        public final String getDEVICE_LOGIN_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_ENDPOINT;
        }

        @OXOo.OOXIXo
        public final String getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_STATUS_ENDPOINT;
        }

        public final int getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release() {
            return DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class PermissionsLists {

        @OXOo.OOXIXo
        private List<String> declinedPermissions;

        @OXOo.OOXIXo
        private List<String> expiredPermissions;

        @OXOo.OOXIXo
        private List<String> grantedPermissions;

        public PermissionsLists(@OXOo.OOXIXo List<String> grantedPermissions, @OXOo.OOXIXo List<String> declinedPermissions, @OXOo.OOXIXo List<String> expiredPermissions) {
            IIX0o.x0xO0oo(grantedPermissions, "grantedPermissions");
            IIX0o.x0xO0oo(declinedPermissions, "declinedPermissions");
            IIX0o.x0xO0oo(expiredPermissions, "expiredPermissions");
            this.grantedPermissions = grantedPermissions;
            this.declinedPermissions = declinedPermissions;
            this.expiredPermissions = expiredPermissions;
        }

        @OXOo.OOXIXo
        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        @OXOo.OOXIXo
        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        @OXOo.OOXIXo
        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setDeclinedPermissions(@OXOo.OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final void setExpiredPermissions(@OXOo.OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.expiredPermissions = list;
        }

        public final void setGrantedPermissions(@OXOo.OOXIXo List<String> list) {
            IIX0o.x0xO0oo(list, "<set-?>");
            this.grantedPermissions = list;
        }
    }

    /* loaded from: classes8.dex */
    public static final class RequestState implements Parcelable {

        @OXOo.oOoXoXO
        private String authorizationUri;
        private long interval;
        private long lastPoll;

        @OXOo.oOoXoXO
        private String requestCode;

        @OXOo.oOoXoXO
        private String userCode;

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);

        @OXOo.OOXIXo
        @XO0OX.XO
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() { // from class: com.facebook.login.DeviceAuthDialog$RequestState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public DeviceAuthDialog.RequestState createFromParcel(@OXOo.OOXIXo Parcel parcel) {
                IIX0o.x0xO0oo(parcel, "parcel");
                return new DeviceAuthDialog.RequestState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @OXOo.OOXIXo
            public DeviceAuthDialog.RequestState[] newArray(int i) {
                return new DeviceAuthDialog.RequestState[i];
            }
        };

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public RequestState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @OXOo.oOoXoXO
        public final String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public final long getInterval() {
            return this.interval;
        }

        @OXOo.oOoXoXO
        public final String getRequestCode() {
            return this.requestCode;
        }

        @OXOo.oOoXoXO
        public final String getUserCode() {
            return this.userCode;
        }

        public final void setInterval(long j) {
            this.interval = j;
        }

        public final void setLastPoll(long j) {
            this.lastPoll = j;
        }

        public final void setRequestCode(@OXOo.oOoXoXO String str) {
            this.requestCode = str;
        }

        public final void setUserCode(@OXOo.oOoXoXO String str) {
            this.userCode = str;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{str}, 1));
            IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
            this.authorizationUri = format;
        }

        public final boolean withinLastRefreshWindow() {
            if (this.lastPoll == 0 || (new Date().getTime() - this.lastPoll) - (this.interval * 1000) >= 0) {
                return false;
            }
            return true;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
            IIX0o.x0xO0oo(dest, "dest");
            dest.writeString(this.authorizationUri);
            dest.writeString(this.userCode);
            dest.writeString(this.requestCode);
            dest.writeLong(this.interval);
            dest.writeLong(this.lastPoll);
        }

        public RequestState(@OXOo.OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _get_pollRequest_$lambda-5, reason: not valid java name */
    public static final void m238_get_pollRequest_$lambda5(DeviceAuthDialog this$0, GraphResponse response) {
        FacebookException exception;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(response, "response");
        if (this$0.completed.get()) {
            return;
        }
        FacebookRequestError error = response.getError();
        if (error != null) {
            int subErrorCode = error.getSubErrorCode();
            if (subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING || subErrorCode == LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING) {
                this$0.schedulePoll();
                return;
            }
            if (subErrorCode == LOGIN_ERROR_SUBCODE_CODE_EXPIRED) {
                RequestState requestState = this$0.currentRequestState;
                if (requestState != null) {
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
                }
                LoginClient.Request request = this$0.request;
                if (request != null) {
                    this$0.startLogin(request);
                    return;
                } else {
                    this$0.onCancel();
                    return;
                }
            }
            if (subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED) {
                this$0.onCancel();
                return;
            }
            FacebookRequestError error2 = response.getError();
            if (error2 == null) {
                exception = null;
            } else {
                exception = error2.getException();
            }
            if (exception == null) {
                exception = new FacebookException();
            }
            this$0.onError(exception);
            return;
        }
        try {
            JSONObject jSONObject = response.getJSONObject();
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            String string = jSONObject.getString("access_token");
            IIX0o.oO(string, "resultObject.getString(\"access_token\")");
            this$0.onSuccess(string, jSONObject.getLong("expires_in"), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
        } catch (JSONException e) {
            this$0.onError(new FacebookException(e));
        }
    }

    private final void completeLogin(String str, PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            deviceAuthMethodHandler.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsLists.getGrantedPermissions(), permissionsLists.getDeclinedPermissions(), permissionsLists.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final GraphRequest getPollRequest() {
        String requestCode;
        Bundle bundle = new Bundle();
        RequestState requestState = this.currentRequestState;
        if (requestState == null) {
            requestCode = null;
        } else {
            requestCode = requestState.getRequestCode();
        }
        bundle.putString("code", requestCode);
        bundle.putString("access_token", getApplicationAccessToken());
        return GraphRequest.Companion.newPostRequestWithBundle(null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, new GraphRequest.Callback() { // from class: com.facebook.login.Oxx0IOOO
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m238_get_pollRequest_$lambda5(DeviceAuthDialog.this, graphResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeContentView$lambda-2, reason: not valid java name */
    public static final void m239initializeContentView$lambda2(DeviceAuthDialog this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onCancel();
    }

    private final void onSuccess(final String str, long j, Long l) {
        final Date date;
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,permissions,name");
        final Date date2 = null;
        if (j != 0) {
            date = new Date(new Date().getTime() + (j * 1000));
        } else {
            date = null;
        }
        if ((l == null || l.longValue() != 0) && l != null) {
            date2 = new Date(l.longValue() * 1000);
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(new AccessToken(str, FacebookSdk.getApplicationId(), "0", null, null, null, null, date, null, date2, null, 1024, null), TournamentShareDialogURIBuilder.f10996me, new GraphRequest.Callback() { // from class: com.facebook.login.X0o0xo
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m240onSuccess$lambda10(DeviceAuthDialog.this, str, date, date2, graphResponse);
            }
        });
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(bundle);
        newGraphPathRequest.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-10, reason: not valid java name */
    public static final void m240onSuccess$lambda10(DeviceAuthDialog this$0, String accessToken, Date date, Date date2, GraphResponse response) {
        EnumSet<SmartLoginOption> smartLoginOptions;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(accessToken, "$accessToken");
        IIX0o.x0xO0oo(response, "response");
        if (this$0.completed.get()) {
            return;
        }
        FacebookRequestError error = response.getError();
        if (error != null) {
            FacebookException exception = error.getException();
            if (exception == null) {
                exception = new FacebookException();
            }
            this$0.onError(exception);
            return;
        }
        try {
            JSONObject jSONObject = response.getJSONObject();
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            String string = jSONObject.getString("id");
            IIX0o.oO(string, "jsonObject.getString(\"id\")");
            PermissionsLists handlePermissionResponse = Companion.handlePermissionResponse(jSONObject);
            String string2 = jSONObject.getString("name");
            IIX0o.oO(string2, "jsonObject.getString(\"name\")");
            RequestState requestState = this$0.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            Boolean bool = null;
            if (appSettingsWithoutQuery != null && (smartLoginOptions = appSettingsWithoutQuery.getSmartLoginOptions()) != null) {
                bool = Boolean.valueOf(smartLoginOptions.contains(SmartLoginOption.RequireConfirm));
            }
            if (IIX0o.Oxx0IOOO(bool, Boolean.TRUE) && !this$0.isRetry) {
                this$0.isRetry = true;
                this$0.presentConfirmation(string, handlePermissionResponse, accessToken, string2, date, date2);
            } else {
                this$0.completeLogin(string, handlePermissionResponse, accessToken, date, date2);
            }
        } catch (JSONException e) {
            this$0.onError(new FacebookException(e));
        }
    }

    private final void poll() {
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.setLastPoll(new Date().getTime());
        }
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    private final void presentConfirmation(final String str, final PermissionsLists permissionsLists, final String str2, String str3, final Date date, final Date date2) {
        String string = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_title);
        IIX0o.oO(string, "resources.getString(R.string.com_facebook_smart_login_confirmation_title)");
        String string2 = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_continue_as);
        IIX0o.oO(string2, "resources.getString(R.string.com_facebook_smart_login_confirmation_continue_as)");
        String string3 = getResources().getString(com.facebook.common.R.string.com_facebook_smart_login_confirmation_cancel);
        IIX0o.oO(string3, "resources.getString(R.string.com_facebook_smart_login_confirmation_cancel)");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(string2, Arrays.copyOf(new Object[]{str3}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() { // from class: com.facebook.login.I0Io
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.m241presentConfirmation$lambda6(DeviceAuthDialog.this, str, permissionsLists, str2, date, date2, dialogInterface, i);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: com.facebook.login.oxoX
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.m242presentConfirmation$lambda8(DeviceAuthDialog.this, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: presentConfirmation$lambda-6, reason: not valid java name */
    public static final void m241presentConfirmation$lambda6(DeviceAuthDialog this$0, String userId, PermissionsLists permissions, String accessToken, Date date, Date date2, DialogInterface dialogInterface, int i) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(userId, "$userId");
        IIX0o.x0xO0oo(permissions, "$permissions");
        IIX0o.x0xO0oo(accessToken, "$accessToken");
        this$0.completeLogin(userId, permissions, accessToken, date, date2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: presentConfirmation$lambda-8, reason: not valid java name */
    public static final void m242presentConfirmation$lambda8(DeviceAuthDialog this$0, DialogInterface dialogInterface, int i) {
        IIX0o.x0xO0oo(this$0, "this$0");
        View initializeContentView = this$0.initializeContentView(false);
        Dialog dialog = this$0.getDialog();
        if (dialog != null) {
            dialog.setContentView(initializeContentView);
        }
        LoginClient.Request request = this$0.request;
        if (request != null) {
            this$0.startLogin(request);
        }
    }

    private final void schedulePoll() {
        Long valueOf;
        RequestState requestState = this.currentRequestState;
        if (requestState == null) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(requestState.getInterval());
        }
        if (valueOf != null) {
            this.scheduledPoll = DeviceAuthMethodHandler.Companion.getBackgroundExecutor().schedule(new Runnable() { // from class: com.facebook.login.XO
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceAuthDialog.m243schedulePoll$lambda3(DeviceAuthDialog.this);
                }
            }, valueOf.longValue(), TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: schedulePoll$lambda-3, reason: not valid java name */
    public static final void m243schedulePoll$lambda3(DeviceAuthDialog this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.poll();
    }

    private final void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        TextView textView = this.confirmationCode;
        if (textView != null) {
            textView.setText(requestState.getUserCode());
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri()));
            TextView textView2 = this.instructions;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
                TextView textView3 = this.confirmationCode;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    View view = this.progressBar;
                    if (view != null) {
                        view.setVisibility(8);
                        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
                            new InternalAppEventsLogger(getContext()).logEventImplicitly(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE);
                        }
                        if (requestState.withinLastRefreshWindow()) {
                            schedulePoll();
                            return;
                        } else {
                            poll();
                            return;
                        }
                    }
                    IIX0o.XOxIOxOx("progressBar");
                    throw null;
                }
                IIX0o.XOxIOxOx("confirmationCode");
                throw null;
            }
            IIX0o.XOxIOxOx("instructions");
            throw null;
        }
        IIX0o.XOxIOxOx("confirmationCode");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1, reason: not valid java name */
    public static final void m244startLogin$lambda1(DeviceAuthDialog this$0, GraphResponse response) {
        FacebookException exception;
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(response, "response");
        if (this$0.isBeingDestroyed) {
            return;
        }
        if (response.getError() != null) {
            FacebookRequestError error = response.getError();
            if (error == null) {
                exception = null;
            } else {
                exception = error.getException();
            }
            if (exception == null) {
                exception = new FacebookException();
            }
            this$0.onError(exception);
            return;
        }
        JSONObject jSONObject = response.getJSONObject();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        RequestState requestState = new RequestState();
        try {
            requestState.setUserCode(jSONObject.getString("user_code"));
            requestState.setRequestCode(jSONObject.getString("code"));
            requestState.setInterval(jSONObject.getLong("interval"));
            this$0.setCurrentRequestState(requestState);
        } catch (JSONException e) {
            this$0.onError(new FacebookException(e));
        }
    }

    @OXOo.oOoXoXO
    public Map<String, String> additionalDeviceInfo() {
        return null;
    }

    @OXOo.OOXIXo
    public String getApplicationAccessToken() {
        StringBuilder sb = new StringBuilder();
        Validate validate = Validate.INSTANCE;
        sb.append(Validate.hasAppID());
        sb.append('|');
        sb.append(Validate.hasClientToken());
        return sb.toString();
    }

    @LayoutRes
    public int getLayoutResId(boolean z) {
        if (z) {
            return com.facebook.common.R.layout.com_facebook_smart_device_dialog_fragment;
        }
        return com.facebook.common.R.layout.com_facebook_device_auth_dialog_fragment;
    }

    @OXOo.OOXIXo
    public View initializeContentView(boolean z) {
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        IIX0o.oO(layoutInflater, "requireActivity().layoutInflater");
        View inflate = layoutInflater.inflate(getLayoutResId(z), (ViewGroup) null);
        IIX0o.oO(inflate, "inflater.inflate(getLayoutResId(isSmartLogin), null)");
        View findViewById = inflate.findViewById(com.facebook.common.R.id.progress_bar);
        IIX0o.oO(findViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = findViewById;
        View findViewById2 = inflate.findViewById(com.facebook.common.R.id.confirmation_code);
        if (findViewById2 != null) {
            this.confirmationCode = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(com.facebook.common.R.id.cancel_button);
            if (findViewById3 != null) {
                ((Button) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.II0xO0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceAuthDialog.m239initializeContentView$lambda2(DeviceAuthDialog.this, view);
                    }
                });
                View findViewById4 = inflate.findViewById(com.facebook.common.R.id.com_facebook_device_auth_instructions);
                if (findViewById4 != null) {
                    TextView textView = (TextView) findViewById4;
                    this.instructions = textView;
                    textView.setText(Html.fromHtml(getString(com.facebook.common.R.string.com_facebook_device_auth_instructions)));
                    return inflate;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public boolean onBackButtonPressed() {
        return true;
    }

    public void onCancel() {
        if (!this.completed.compareAndSet(false, true)) {
            return;
        }
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
        }
        DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler != null) {
            deviceAuthMethodHandler.onCancel();
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @OXOo.OOXIXo
    public Dialog onCreateDialog(@OXOo.oOoXoXO Bundle bundle) {
        boolean z;
        final FragmentActivity requireActivity = requireActivity();
        final int i = com.facebook.common.R.style.com_facebook_auth_dialog;
        Dialog dialog = new Dialog(requireActivity, i) { // from class: com.facebook.login.DeviceAuthDialog$onCreateDialog$dialog$1
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (DeviceAuthDialog.this.onBackButtonPressed()) {
                    super.onBackPressed();
                }
            }
        };
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        if (DeviceRequestsHelper.isAvailable() && !this.isRetry) {
            z = true;
        } else {
            z = false;
        }
        dialog.setContentView(initializeContentView(z));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @OXOo.oOoXoXO
    public View onCreateView(@OXOo.OOXIXo LayoutInflater inflater, @OXOo.oOoXoXO ViewGroup viewGroup, @OXOo.oOoXoXO Bundle bundle) {
        RequestState requestState;
        LoginClient loginClient;
        IIX0o.x0xO0oo(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        LoginFragment loginFragment = (LoginFragment) ((FacebookActivity) requireActivity()).getCurrentFragment();
        LoginMethodHandler loginMethodHandler = null;
        if (loginFragment != null && (loginClient = loginFragment.getLoginClient()) != null) {
            loginMethodHandler = loginClient.getCurrentHandler();
        }
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) loginMethodHandler;
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) != null) {
            setCurrentRequestState(requestState);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask = this.currentGraphRequestPoll;
        if (graphRequestAsyncTask != null) {
            graphRequestAsyncTask.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledPoll;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@OXOo.OOXIXo DialogInterface dialog) {
        IIX0o.x0xO0oo(dialog, "dialog");
        super.onDismiss(dialog);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    public void onError(@OXOo.OOXIXo FacebookException ex) {
        IIX0o.x0xO0oo(ex, "ex");
        if (!this.completed.compareAndSet(false, true)) {
            return;
        }
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
        }
        DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler != null) {
            deviceAuthMethodHandler.onError(ex);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@OXOo.OOXIXo Bundle outState) {
        IIX0o.x0xO0oo(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.currentRequestState != null) {
            outState.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void startLogin(@OXOo.OOXIXo LoginClient.Request request) {
        Map O0X2;
        IIX0o.x0xO0oo(request, "request");
        this.request = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, "redirect_uri", request.getDeviceRedirectUriString());
        Utility.putNonEmptyString(bundle, DeviceRequestsHelper.DEVICE_TARGET_USER_ID, request.getDeviceAuthTargetUserId());
        bundle.putString("access_token", getApplicationAccessToken());
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        Map<String, String> additionalDeviceInfo = additionalDeviceInfo();
        if (additionalDeviceInfo == null) {
            O0X2 = null;
        } else {
            O0X2 = o0.O0X(additionalDeviceInfo);
        }
        bundle.putString("device_info", DeviceRequestsHelper.getDeviceInfo(O0X2));
        GraphRequest.Companion.newPostRequestWithBundle(null, DEVICE_LOGIN_ENDPOINT, bundle, new GraphRequest.Callback() { // from class: com.facebook.login.II0XooXoX
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m244startLogin$lambda1(DeviceAuthDialog.this, graphResponse);
            }
        }).executeAsync();
    }
}
