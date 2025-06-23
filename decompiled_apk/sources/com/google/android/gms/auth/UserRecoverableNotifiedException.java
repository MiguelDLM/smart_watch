package com.google.android.gms.auth;

import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public class UserRecoverableNotifiedException extends GoogleAuthException {
    public UserRecoverableNotifiedException(@NonNull String str) {
        super(str);
    }

    public UserRecoverableNotifiedException(@NonNull String str, @NonNull Throwable th) {
        super(str, th);
    }
}
