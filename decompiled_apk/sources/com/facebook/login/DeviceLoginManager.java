package com.facebook.login;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.Collection;

/* loaded from: classes8.dex */
public class DeviceLoginManager extends LoginManager {
    private static volatile DeviceLoginManager instance;

    @Nullable
    private String deviceAuthTargetUserId;
    private Uri deviceRedirectUri;

    public static DeviceLoginManager getInstance() {
        if (CrashShieldHandler.isObjectCrashing(DeviceLoginManager.class)) {
            return null;
        }
        try {
            if (instance == null) {
                synchronized (DeviceLoginManager.class) {
                    try {
                        if (instance == null) {
                            instance = new DeviceLoginManager();
                        }
                    } finally {
                    }
                }
            }
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceLoginManager.class);
            return null;
        }
    }

    @Override // com.facebook.login.LoginManager
    public LoginClient.Request createLoginRequest(Collection<String> permissions) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LoginClient.Request createLoginRequest = super.createLoginRequest(permissions);
            Uri deviceRedirectUri = getDeviceRedirectUri();
            if (deviceRedirectUri != null) {
                createLoginRequest.setDeviceRedirectUriString(deviceRedirectUri.toString());
            }
            String deviceAuthTargetUserId = getDeviceAuthTargetUserId();
            if (deviceAuthTargetUserId != null) {
                createLoginRequest.setDeviceAuthTargetUserId(deviceAuthTargetUserId);
            }
            return createLoginRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Nullable
    public String getDeviceAuthTargetUserId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceAuthTargetUserId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public Uri getDeviceRedirectUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceRedirectUri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setDeviceAuthTargetUserId(@Nullable String targetUserId) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.deviceAuthTargetUserId = targetUserId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void setDeviceRedirectUri(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.deviceRedirectUri = uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
