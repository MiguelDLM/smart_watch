package com.baidu.mapframework.nirvana.network;

import com.baidu.mapframework.nirvana.NirvanaTask;
import org.apache.http.client.methods.HttpUriRequest;

/* loaded from: classes7.dex */
public final class NetworkTask extends NirvanaTask {
    Runnable c;

    public NetworkTask(String str, HttpUriRequest httpUriRequest, IResponseHandler iResponseHandler, Runnable runnable) {
        this.c = runnable;
    }
}
