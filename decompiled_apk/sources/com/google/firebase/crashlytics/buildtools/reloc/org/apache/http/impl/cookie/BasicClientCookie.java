package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes10.dex */
public class BasicClientCookie implements SetCookie, ClientCookie, Cloneable, Serializable {
    private static final long serialVersionUID = -3869795591041535538L;
    private Map<String, String> attribs;
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private int cookieVersion;
    private Date creationDate;
    private boolean isSecure;
    private final String name;
    private String value;

    public BasicClientCookie(String str, String str2) {
        Args.notNull(str, "Name");
        this.name = str;
        this.attribs = new HashMap();
        this.value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie basicClientCookie = (BasicClientCookie) super.clone();
        basicClientCookie.attribs = new HashMap(this.attribs);
        return basicClientCookie;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie
    public boolean containsAttribute(String str) {
        return this.attribs.containsKey(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie
    public String getAttribute(String str) {
        return this.attribs.get(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public String getComment() {
        return this.cookieComment;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public String getCommentURL() {
        return null;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public String getDomain() {
        return this.cookieDomain;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public Date getExpiryDate() {
        return this.cookieExpiryDate;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public String getPath() {
        return this.cookiePath;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public int[] getPorts() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public String getValue() {
        return this.value;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public int getVersion() {
        return this.cookieVersion;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public boolean isExpired(Date date) {
        Args.notNull(date, "Date");
        Date date2 = this.cookieExpiryDate;
        if (date2 != null && date2.getTime() <= date.getTime()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public boolean isPersistent() {
        if (this.cookieExpiryDate != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.Cookie
    public boolean isSecure() {
        return this.isSecure;
    }

    public boolean removeAttribute(String str) {
        if (this.attribs.remove(str) != null) {
            return true;
        }
        return false;
    }

    public void setAttribute(String str, String str2) {
        this.attribs.put(str, str2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie
    public void setComment(String str) {
        this.cookieComment = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie
    public void setDomain(String str) {
        if (str != null) {
            this.cookieDomain = str.toLowerCase(Locale.ROOT);
        } else {
            this.cookieDomain = null;
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie
    public void setExpiryDate(Date date) {
        this.cookieExpiryDate = date;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie
    public void setPath(String str) {
        this.cookiePath = str;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie
    public void setSecure(boolean z) {
        this.isSecure = z;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie
    public void setValue(String str) {
        this.value = str;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.SetCookie
    public void setVersion(int i) {
        this.cookieVersion = i;
    }

    public String toString() {
        return "[version: " + Integer.toString(this.cookieVersion) + "][name: " + this.name + "][value: " + this.value + "][domain: " + this.cookieDomain + "][path: " + this.cookiePath + "][expiry: " + this.cookieExpiryDate + "]";
    }
}
