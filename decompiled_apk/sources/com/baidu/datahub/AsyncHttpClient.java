package com.baidu.datahub;

import com.baidu.datahub.HttpClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes7.dex */
public class AsyncHttpClient {
    private static final String HTTP_GET_METHOD = "GET";
    private static final String HTTP_POST_METHOD = "POST";
    private int connectTimeOut = 4000;
    private int readTimeOut = 4000;
    private ExecutorService threadPool = Executors.newCachedThreadPool();

    /* loaded from: classes7.dex */
    public static abstract class RequestRunnable implements Runnable {
        private RequestRunnable() {
        }

        public abstract void onExecute();

        @Override // java.lang.Runnable
        public void run() {
            onExecute();
        }
    }

    public void get(final String str, final String str2, final HttpClient.ProtoResultCallBack protoResultCallBack) {
        if (str != null) {
            this.threadPool.submit(new RequestRunnable() { // from class: com.baidu.datahub.AsyncHttpClient.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.datahub.AsyncHttpClient.RequestRunnable
                public void onExecute() {
                    HttpClient httpClient = new HttpClient("GET", protoResultCallBack);
                    httpClient.setMaxTimeOut(AsyncHttpClient.this.connectTimeOut);
                    httpClient.setReadTimeOut(AsyncHttpClient.this.readTimeOut);
                    httpClient.request(str + LocationInfo.NA + str2, null, null);
                }
            });
            return;
        }
        throw new IllegalArgumentException("uri can not be null");
    }

    public void post(final String str, final String str2, final HttpClient.ProtoResultCallBack protoResultCallBack, final HttpClient.ContentType contentType) {
        if (str != null) {
            this.threadPool.submit(new RequestRunnable() { // from class: com.baidu.datahub.AsyncHttpClient.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.datahub.AsyncHttpClient.RequestRunnable
                public void onExecute() {
                    HttpClient httpClient = new HttpClient("POST", protoResultCallBack);
                    httpClient.setMaxTimeOut(AsyncHttpClient.this.connectTimeOut);
                    httpClient.setReadTimeOut(AsyncHttpClient.this.readTimeOut);
                    httpClient.request(str, str2, contentType);
                }
            });
            return;
        }
        throw new IllegalArgumentException("uri can not be null");
    }
}
