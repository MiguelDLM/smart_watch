package com.alibaba.sdk.android.oss;

import com.alibaba.sdk.android.oss.common.HttpProtocol;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;

public class ClientConfiguration {
    private static final int DEFAULT_MAX_RETRIES = 2;
    private boolean checkCRC64 = false;
    private int connectionTimeout = 60000;
    private List<String> customCnameExcludeList = new ArrayList();
    private boolean customPathPrefixEnable = false;
    private ExecutorService executorService = null;
    private boolean followRedirectsEnable = false;
    private boolean httpDnsEnable = false;
    private HttpProtocol httpProtocol = HttpProtocol.HTTPS;
    private String ipWithHeader;
    private String mUserAgentMark;
    private int maxConcurrentRequest = 5;
    private int maxConcurrentRequestsPerHost = -1;
    private int maxErrorRetry = 2;
    private long max_log_size = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    private OkHttpClient okHttpClient = null;
    private boolean pathStyleAccessEnable = false;
    private String proxyHost;
    private int proxyPort;
    private int socketTimeout = 60000;

    public static ClientConfiguration getDefaultConf() {
        return new ClientConfiguration();
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public List<String> getCustomCnameExcludeList() {
        return Collections.unmodifiableList(this.customCnameExcludeList);
    }

    public String getCustomUserMark() {
        return this.mUserAgentMark;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public HttpProtocol getHttpProtocol() {
        return this.httpProtocol;
    }

    public String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public int getMaxConcurrentRequest() {
        return this.maxConcurrentRequest;
    }

    public int getMaxConcurrentRequestsPerHost() {
        return this.maxConcurrentRequestsPerHost;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public long getMaxLogSize() {
        return this.max_log_size;
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isCustomPathPrefixEnable() {
        return this.customPathPrefixEnable;
    }

    public boolean isFollowRedirectsEnable() {
        return this.followRedirectsEnable;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public boolean isPathStyleAccessEnable() {
        return this.pathStyleAccessEnable;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setCustomCnameExcludeList(List<String> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("cname exclude list should not be null.");
        }
        this.customCnameExcludeList.clear();
        for (String next : list) {
            if (next.contains("://")) {
                this.customCnameExcludeList.add(next.substring(next.indexOf("://") + 3));
            } else {
                this.customCnameExcludeList.add(next);
            }
        }
    }

    public void setCustomPathPrefixEnable(boolean z) {
        this.customPathPrefixEnable = z;
    }

    public void setExecutorService(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    public void setFollowRedirectsEnable(boolean z) {
        this.followRedirectsEnable = z;
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public void setHttpProtocol(HttpProtocol httpProtocol2) {
        this.httpProtocol = httpProtocol2;
    }

    public void setIpWithHeader(String str) {
        this.ipWithHeader = str;
    }

    public void setMaxConcurrentRequest(int i) {
        this.maxConcurrentRequest = i;
    }

    public void setMaxConcurrentRequestsPerHost(int i) {
        this.maxConcurrentRequestsPerHost = i;
    }

    public void setMaxErrorRetry(int i) {
        this.maxErrorRetry = i;
    }

    public void setMaxLogSize(long j) {
        this.max_log_size = j;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient2) {
        this.okHttpClient = okHttpClient2;
    }

    public void setPathStyleAccessEnable(boolean z) {
        this.pathStyleAccessEnable = z;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    public void setUserAgentMark(String str) {
        this.mUserAgentMark = str;
    }
}
