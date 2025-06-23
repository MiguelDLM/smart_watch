package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie2;
import java.util.Date;

/* loaded from: classes10.dex */
public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    private static final long serialVersionUID = -7744598295706617057L;
    private String commentURL;
    private boolean discard;
    private int[] ports;

    public BasicClientCookie2(String str, String str2) {
        super(str, str2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie
    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie2 basicClientCookie2 = (BasicClientCookie2) super.clone();
        int[] iArr = this.ports;
        if (iArr != null) {
            basicClientCookie2.ports = (int[]) iArr.clone();
        }
        return basicClientCookie2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public String getCommentURL() {
        return this.commentURL;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public int[] getPorts() {
        return this.ports;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public boolean isExpired(Date date) {
        if (!this.discard && !super.isExpired(date)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        if (!this.discard && super.isPersistent()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie2
    public void setCommentURL(String str) {
        this.commentURL = str;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie2
    public void setDiscard(boolean z) {
        this.discard = z;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie2
    public void setPorts(int[] iArr) {
        this.ports = iArr;
    }
}
