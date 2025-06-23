package com.google.android.gms.fido.u2f.api.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes9.dex */
public abstract class ResponseData extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public abstract JSONObject toJsonObject();
}
