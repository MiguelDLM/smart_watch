package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.protocol;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.Header;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HeaderElement;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseInterceptor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.DecompressingEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.DeflateInputStreamFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.GZIPInputStreamFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.InputStreamFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.Lookup;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.config.RegistryBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.util.Locale;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes10.dex */
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";
    private final Lookup<InputStreamFactory> decoderRegistry;
    private final boolean ignoreUnknown;

    public ResponseContentEncoding(Lookup<InputStreamFactory> lookup, boolean z) {
        this.decoderRegistry = lookup == null ? RegistryBuilder.create().register("gzip", GZIPInputStreamFactory.getInstance()).register("x-gzip", GZIPInputStreamFactory.getInstance()).register("deflate", DeflateInputStreamFactory.getInstance()).build() : lookup;
        this.ignoreUnknown = z;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (HttpClientContext.adapt(httpContext).getRequestConfig().isContentCompressionEnabled() && entity != null && entity.getContentLength() != 0 && (contentEncoding = entity.getContentEncoding()) != null) {
            for (HeaderElement headerElement : contentEncoding.getElements()) {
                String lowerCase = headerElement.getName().toLowerCase(Locale.ROOT);
                InputStreamFactory lookup = this.decoderRegistry.lookup(lowerCase);
                if (lookup != null) {
                    httpResponse.setEntity(new DecompressingEntity(httpResponse.getEntity(), lookup));
                    httpResponse.removeHeaders("Content-Length");
                    httpResponse.removeHeaders("Content-Encoding");
                    httpResponse.removeHeaders("Content-MD5");
                } else if (!"identity".equals(lowerCase) && !this.ignoreUnknown) {
                    throw new HttpException("Unsupported Content-Encoding: " + headerElement.getName());
                }
            }
        }
    }

    public ResponseContentEncoding(boolean z) {
        this(null, z);
    }

    public ResponseContentEncoding(Lookup<InputStreamFactory> lookup) {
        this(lookup, true);
    }

    public ResponseContentEncoding() {
        this((Lookup<InputStreamFactory>) null);
    }
}
