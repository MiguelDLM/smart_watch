package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    private static ScheduledThreadPoolExecutor backgroundExecutor;

    @OXOo.OOXIXo
    private final String nameForLogging;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new Parcelable.Creator<DeviceAuthMethodHandler>() { // from class: com.facebook.login.DeviceAuthMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public DeviceAuthMethodHandler createFromParcel(@OXOo.OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new DeviceAuthMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public DeviceAuthMethodHandler[] newArray(int i) {
            return new DeviceAuthMethodHandler[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
            try {
                if (DeviceAuthMethodHandler.backgroundExecutor == null) {
                    DeviceAuthMethodHandler.backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                }
                scheduledThreadPoolExecutor = DeviceAuthMethodHandler.backgroundExecutor;
                if (scheduledThreadPoolExecutor == null) {
                    IIX0o.XOxIOxOx("backgroundExecutor");
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
            return scheduledThreadPoolExecutor;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(@OXOo.OOXIXo LoginClient loginClient) {
        super(loginClient);
        IIX0o.x0xO0oo(loginClient, "loginClient");
        this.nameForLogging = "device_auth";
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor backgroundExecutor2;
        synchronized (DeviceAuthMethodHandler.class) {
            backgroundExecutor2 = Companion.getBackgroundExecutor();
        }
        return backgroundExecutor2;
    }

    private final void showDialog(LoginClient.Request request) {
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity != null && !activity.isFinishing()) {
            DeviceAuthDialog createDeviceAuthDialog = createDeviceAuthDialog();
            createDeviceAuthDialog.show(activity.getSupportFragmentManager(), "login_with_facebook");
            createDeviceAuthDialog.startLogin(request);
        }
    }

    @OXOo.OOXIXo
    public DeviceAuthDialog createDeviceAuthDialog() {
        return new DeviceAuthDialog();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    @OXOo.OOXIXo
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public void onCancel() {
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createCancelResult(getLoginClient().getPendingRequest(), LoginMethodHandler.USER_CANCELED_LOG_IN_ERROR_MESSAGE));
    }

    public void onError(@OXOo.OOXIXo Exception ex) {
        IIX0o.x0xO0oo(ex, "ex");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), null, ex.getMessage(), null, 8, null));
    }

    public void onSuccess(@OXOo.OOXIXo String accessToken, @OXOo.OOXIXo String applicationId, @OXOo.OOXIXo String userId, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO Collection<String> collection2, @OXOo.oOoXoXO Collection<String> collection3, @OXOo.oOoXoXO AccessTokenSource accessTokenSource, @OXOo.oOoXoXO Date date, @OXOo.oOoXoXO Date date2, @OXOo.oOoXoXO Date date3) {
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(applicationId, "applicationId");
        IIX0o.x0xO0oo(userId, "userId");
        getLoginClient().completeAndValidate(LoginClient.Result.Companion.createTokenResult(getLoginClient().getPendingRequest(), new AccessToken(accessToken, applicationId, userId, collection, collection2, collection3, accessTokenSource, date, date2, date3, null, 1024, null)));
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(@OXOo.OOXIXo LoginClient.Request request) {
        IIX0o.x0xO0oo(request, "request");
        showDialog(request);
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceAuthMethodHandler(@OXOo.OOXIXo Parcel parcel) {
        super(parcel);
        IIX0o.x0xO0oo(parcel, "parcel");
        this.nameForLogging = "device_auth";
    }
}
