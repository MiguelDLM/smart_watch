package com.baidu.datahub;

import com.baidu.datahub.HttpClient;

/* loaded from: classes7.dex */
public class BaseRequest {
    private static final String TAG = "BaseRequest";
    private AsyncHttpClient mHttpClient = new AsyncHttpClient();
    private URLProvider provider = new URLProvider();

    private String getUrl(int i) {
        switch (i) {
            case 1:
                return this.provider.getRegisterOrderDomain();
            case 2:
                return this.provider.getUpdateOrderInfoDomain();
            case 3:
                return this.provider.getUpdateRouteDomain();
            case 4:
                return this.provider.getUploadLocationETA();
            case 5:
                return this.provider.getUploadSpecificRouteDomain();
            case 6:
                return this.provider.getPullSpecificRouteDomain();
            case 7:
                return this.provider.getUpdateDriverStatusDomain();
            default:
                return null;
        }
    }

    public void sendRequest(int i, String str, String str2, HttpClient.ProtoResultCallBack protoResultCallBack, HttpClient.ContentType contentType) {
        String url = getUrl(i);
        if (url == null) {
            return;
        }
        BDLog.i(TAG, url);
        if (str.equals("POST")) {
            this.mHttpClient.post(url, str2, protoResultCallBack, contentType);
        } else if (str.equals("GET")) {
            this.mHttpClient.get(url, str2, protoResultCallBack);
        }
    }

    public void sendRequest(int i, String str, String str2, HttpClient.ProtoResultCallBack protoResultCallBack) {
        String url = getUrl(i);
        if (url == null) {
            return;
        }
        BDLog.i(TAG, url);
        if (str.equals("POST")) {
            this.mHttpClient.post(url, str2, protoResultCallBack, HttpClient.ContentType.FORM_DATA);
        } else if (str.equals("GET")) {
            this.mHttpClient.get(url, str2, protoResultCallBack);
        }
    }
}
