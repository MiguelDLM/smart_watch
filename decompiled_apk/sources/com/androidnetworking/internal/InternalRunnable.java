package com.androidnetworking.internal;

import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.common.Priority;
import com.androidnetworking.common.ResponseType;
import com.androidnetworking.core.Core;
import com.androidnetworking.error.ANError;
import com.androidnetworking.utils.SourceCloseUtil;
import com.androidnetworking.utils.Utils;
import okhttp3.Response;

/* loaded from: classes.dex */
public class InternalRunnable implements Runnable {
    private final Priority priority;
    public final ANRequest request;
    public final int sequence;

    public InternalRunnable(ANRequest aNRequest) {
        this.request = aNRequest;
        this.sequence = aNRequest.getSequenceNumber();
        this.priority = aNRequest.getPriority();
    }

    private void deliverError(final ANRequest aNRequest, final ANError aNError) {
        Core.getInstance().getExecutorSupplier().forMainThreadTasks().execute(new Runnable() { // from class: com.androidnetworking.internal.InternalRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                aNRequest.deliverError(aNError);
                aNRequest.finish();
            }
        });
    }

    private void executeDownloadRequest() {
        try {
            Response performDownloadRequest = InternalNetworking.performDownloadRequest(this.request);
            if (performDownloadRequest == null) {
                deliverError(this.request, Utils.getErrorForConnection(new ANError()));
            } else if (performDownloadRequest.code() >= 400) {
                deliverError(this.request, Utils.getErrorForServerResponse(new ANError(performDownloadRequest), this.request, performDownloadRequest.code()));
            } else {
                this.request.updateDownloadCompletion();
            }
        } catch (Exception e) {
            deliverError(this.request, Utils.getErrorForConnection(new ANError(e)));
        }
    }

    private void executeSimpleRequest() {
        Response response = null;
        try {
            try {
                response = InternalNetworking.performSimpleRequest(this.request);
            } catch (Exception e) {
                deliverError(this.request, Utils.getErrorForConnection(new ANError(e)));
            }
            if (response == null) {
                deliverError(this.request, Utils.getErrorForConnection(new ANError()));
            } else if (this.request.getResponseAs() == ResponseType.OK_HTTP_RESPONSE) {
                this.request.deliverOkHttpResponse(response);
            } else if (response.code() >= 400) {
                deliverError(this.request, Utils.getErrorForServerResponse(new ANError(response), this.request, response.code()));
            } else {
                ANResponse parseResponse = this.request.parseResponse(response);
                if (!parseResponse.isSuccess()) {
                    deliverError(this.request, parseResponse.getError());
                } else {
                    parseResponse.setOkHttpResponse(response);
                    this.request.deliverResponse(parseResponse);
                }
            }
        } finally {
            SourceCloseUtil.close(null, this.request);
        }
    }

    private void executeUploadRequest() {
        Response response = null;
        try {
            try {
                response = InternalNetworking.performUploadRequest(this.request);
            } catch (Exception e) {
                deliverError(this.request, Utils.getErrorForConnection(new ANError(e)));
            }
            if (response == null) {
                deliverError(this.request, Utils.getErrorForConnection(new ANError()));
            } else if (this.request.getResponseAs() == ResponseType.OK_HTTP_RESPONSE) {
                this.request.deliverOkHttpResponse(response);
            } else if (response.code() >= 400) {
                deliverError(this.request, Utils.getErrorForServerResponse(new ANError(response), this.request, response.code()));
            } else {
                ANResponse parseResponse = this.request.parseResponse(response);
                if (!parseResponse.isSuccess()) {
                    deliverError(this.request, parseResponse.getError());
                } else {
                    parseResponse.setOkHttpResponse(response);
                    this.request.deliverResponse(parseResponse);
                }
            }
        } finally {
            SourceCloseUtil.close(null, this.request);
        }
    }

    public Priority getPriority() {
        return this.priority;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.request.setRunning(true);
        int requestType = this.request.getRequestType();
        if (requestType != 0) {
            if (requestType != 1) {
                if (requestType == 2) {
                    executeUploadRequest();
                }
            } else {
                executeDownloadRequest();
            }
        } else {
            executeSimpleRequest();
        }
        this.request.setRunning(false);
    }
}
