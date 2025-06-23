package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.internal.CheckCRC64DownloadInputStream;
import java.io.InputStream;

public class GetObjectResult extends OSSResult {
    private long contentLength;
    private ObjectMetadata metadata = new ObjectMetadata();
    private InputStream objectContent;

    public Long getClientCRC() {
        InputStream inputStream = this.objectContent;
        if (inputStream == null || !(inputStream instanceof CheckCRC64DownloadInputStream)) {
            return super.getClientCRC();
        }
        return Long.valueOf(((CheckCRC64DownloadInputStream) inputStream).getClientCRC64());
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public InputStream getObjectContent() {
        return this.objectContent;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectContent(InputStream inputStream) {
        this.objectContent = inputStream;
    }
}
