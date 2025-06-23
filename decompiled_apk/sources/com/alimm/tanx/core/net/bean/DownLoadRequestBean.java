package com.alimm.tanx.core.net.bean;

/* loaded from: classes.dex */
public class DownLoadRequestBean extends RequestBean {
    private String fileName;
    private String path;
    private boolean resume;

    public String getFileName() {
        return this.fileName;
    }

    public String getPath() {
        return this.path;
    }

    public boolean isResume() {
        return this.resume;
    }

    public DownLoadRequestBean setFileName(String str) {
        this.fileName = str;
        return this;
    }

    public DownLoadRequestBean setPath(String str) {
        this.path = str;
        return this;
    }

    public DownLoadRequestBean setResume(boolean z) {
        this.resume = z;
        return this;
    }

    @Override // com.alimm.tanx.core.net.bean.RequestBean
    public DownLoadRequestBean build() {
        super.build();
        return this;
    }

    @Override // com.alimm.tanx.core.net.bean.RequestBean
    public DownLoadRequestBean setUrl(String str) {
        super.setUrl(str);
        return this;
    }
}
