package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.login.LoginClient;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GetTokenClient extends PlatformServiceClient {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenClient(@OXOo.OOXIXo Context context, @OXOo.OOXIXo LoginClient.Request request) {
        super(context, 65536, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY, NativeProtocol.PROTOCOL_VERSION_20121101, request.getApplicationId(), request.getNonce());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(request, "request");
    }

    @Override // com.facebook.internal.PlatformServiceClient
    public void populateRequestBundle(@OXOo.OOXIXo Bundle data) {
        IIX0o.x0xO0oo(data, "data");
    }
}
