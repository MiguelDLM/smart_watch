package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class c {
    public int awC = -1;
    public Exception awD;
    public String awE;
    public int code;

    public final boolean Ew() {
        if (this.code == 200) {
            return true;
        }
        return false;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.awC + ", rawException=" + this.awD + ", body='" + this.awE + "'}";
    }
}
