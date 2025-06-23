package com.facebook.gamingservices;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.model.CustomUpdateContent;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class CustomUpdate {

    @OOXIXo
    public static final CustomUpdate INSTANCE = new CustomUpdate();

    private CustomUpdate() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final GraphRequest newCustomUpdateRequest(@OOXIXo CustomUpdateContent content, @oOoXoXO GraphRequest.Callback callback) {
        IIX0o.x0xO0oo(content, "content");
        return GraphRequest.Companion.newPostRequest(AccessToken.Companion.getCurrentAccessToken(), "me/custom_update", content.toGraphRequestContent(), callback);
    }
}
