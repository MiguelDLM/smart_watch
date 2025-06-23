package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public final class c implements com.kwad.framework.filedownloader.a.b {
    protected URLConnection afY;

    /* loaded from: classes11.dex */
    public static class a {
        private Proxy afZ;
        private Integer aga;
        private Integer agb;
    }

    /* loaded from: classes11.dex */
    public static class b implements c.b {
        private final a agc;

        public b() {
            this(null);
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b bh(String str) {
            return new c(str, this.agc);
        }

        private b(a aVar) {
            this.agc = null;
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.afY.addRequestProperty(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bg(String str) {
        return this.afY.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        this.afY.connect();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        return ((j) ServiceProvider.get(j.class)).wrapInputStream(this.afY.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        URLConnection uRLConnection = this.afY;
        if (uRLConnection instanceof HttpURLConnection) {
            try {
                return ((HttpURLConnection) uRLConnection).getResponseCode();
            } catch (Throwable th) {
                throw new IOException(th);
            }
        }
        return 0;
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vG() {
        return this.afY.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vH() {
        return this.afY.getHeaderFields();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void vI() {
    }

    private c(URL url, a aVar) {
        if (aVar != null && aVar.afZ != null) {
            this.afY = url.openConnection(aVar.afZ);
        } else {
            this.afY = url.openConnection();
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.afY);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.aga != null) {
                this.afY.setReadTimeout(aVar.aga.intValue());
            }
            if (aVar.agb != null) {
                this.afY.setConnectTimeout(aVar.agb.intValue());
            }
        }
    }
}
