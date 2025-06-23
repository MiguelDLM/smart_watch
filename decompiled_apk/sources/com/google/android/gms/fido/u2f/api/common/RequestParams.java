package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import java.util.Set;

@Deprecated
/* loaded from: classes9.dex */
public abstract class RequestParams extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public abstract Set<Uri> getAllAppIds();

    @NonNull
    public abstract Uri getAppId();

    @NonNull
    public abstract ChannelIdValue getChannelIdValue();

    @NonNull
    public abstract String getDisplayHint();

    @NonNull
    public abstract List<RegisteredKey> getRegisteredKeys();

    @NonNull
    public abstract Integer getRequestId();

    @NonNull
    public abstract Double getTimeoutSeconds();
}
