package com.facebook.share.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class ResultProcessor {

    @oOoXoXO
    private final FacebookCallback<?> appCallback;

    public ResultProcessor(@oOoXoXO FacebookCallback<?> facebookCallback) {
        this.appCallback = facebookCallback;
    }

    public void onCancel(@OOXIXo AppCall appCall) {
        IIX0o.x0xO0oo(appCall, "appCall");
        FacebookCallback<?> facebookCallback = this.appCallback;
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    public void onError(@OOXIXo AppCall appCall, @OOXIXo FacebookException error) {
        IIX0o.x0xO0oo(appCall, "appCall");
        IIX0o.x0xO0oo(error, "error");
        FacebookCallback<?> facebookCallback = this.appCallback;
        if (facebookCallback != null) {
            facebookCallback.onError(error);
        }
    }

    public abstract void onSuccess(@OOXIXo AppCall appCall, @oOoXoXO Bundle bundle);
}
