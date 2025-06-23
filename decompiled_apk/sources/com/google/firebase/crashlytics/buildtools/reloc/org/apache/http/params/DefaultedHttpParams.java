package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes10.dex */
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams httpParams, HttpParams httpParams2) {
        this.local = (HttpParams) Args.notNull(httpParams, "Local HTTP parameters");
        this.defaults = httpParams2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.AbstractHttpParams, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParamsNames
    public Set<String> getNames() {
        HashSet hashSet = new HashSet(getNames(this.defaults));
        hashSet.addAll(getNames(this.local));
        return hashSet;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public Object getParameter(String str) {
        HttpParams httpParams;
        Object parameter = this.local.getParameter(str);
        if (parameter == null && (httpParams = this.defaults) != null) {
            return httpParams.getParameter(str);
        }
        return parameter;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public boolean removeParameter(String str) {
        return this.local.removeParameter(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams
    public HttpParams setParameter(String str, Object obj) {
        return this.local.setParameter(str, obj);
    }

    private Set<String> getNames(HttpParams httpParams) {
        if (httpParams instanceof HttpParamsNames) {
            return ((HttpParamsNames) httpParams).getNames();
        }
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
