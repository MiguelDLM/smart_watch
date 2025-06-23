package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ConnectionReuseStrategy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.MethodNotSupportedException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.UnsupportedHttpVersionException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpHead;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.ByteArrayEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.DefaultHttpResponseFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.HttpParams;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.EncodingUtils;
import java.io.IOException;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes10.dex */
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    /* loaded from: classes10.dex */
    public static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpRequestHandlerMapper
        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        if ((httpRequest != null && HttpHead.METHOD_NAME.equalsIgnoreCase(httpRequest.getRequestLine().getMethod())) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) {
            return false;
        }
        return true;
    }

    public void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler httpRequestHandler;
        if (this.handlerMapper != null) {
            httpRequestHandler = this.handlerMapper.lookup(httpRequest);
        } else {
            httpRequestHandler = null;
        }
        if (httpRequestHandler != null) {
            httpRequestHandler.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(501);
        }
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    public void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(501);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(505);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(400);
        } else {
            httpResponse.setStatusCode(500);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleRequest(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpServerConnection r9, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext r10) throws java.io.IOException, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException {
        /*
            r8 = this;
            java.lang.String r0 = "http.connection"
            r10.setAttribute(r0, r9)
            r0 = 500(0x1f4, float:7.0E-43)
            r1 = 0
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpRequest r2 = r9.receiveRequestHeader()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L84
            boolean r3 = r2 instanceof com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == 0) goto L5e
            r3 = r2
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest r3 = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            boolean r3 = r3.expectContinue()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            if (r3 == 0) goto L58
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseFactory r3 = r8.responseFactory     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion r5 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion.HTTP_1_1     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r6 = 100
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse r3 = r3.newHttpResponse(r5, r6, r10)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpExpectationVerifier r5 = r8.expectationVerifier     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            if (r5 == 0) goto L3f
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpExpectationVerifier r5 = r8.expectationVerifier     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L2f
            r5.verify(r2, r3, r10)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L2f
            goto L3f
        L2f:
            r3 = move-exception
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseFactory r5 = r8.responseFactory     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion r6 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion.HTTP_1_0     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse r5 = r5.newHttpResponse(r6, r0, r10)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r8.handleException(r3, r5)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r3 = r5
            goto L3f
        L3d:
            r1 = move-exception
            goto L88
        L3f:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.StatusLine r5 = r3.getStatusLine()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            int r5 = r5.getStatusCode()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            if (r5 >= r4) goto L56
            r9.sendResponseHeader(r3)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r9.flush()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r3 = r2
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest r3 = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r9.receiveRequestEntity(r3)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            goto L5e
        L56:
            r1 = r3
            goto L5e
        L58:
            r3 = r2
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest r3 = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r9.receiveRequestEntity(r3)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
        L5e:
            java.lang.String r3 = "http.request"
            r10.setAttribute(r3, r2)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            if (r1 != 0) goto L75
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseFactory r1 = r8.responseFactory     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion r3 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion.HTTP_1_1     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse r1 = r1.newHttpResponse(r3, r4, r10)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpProcessor r3 = r8.processor     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r3.process(r2, r10)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            r8.doService(r2, r1, r10)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
        L75:
            boolean r3 = r2 instanceof com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            if (r3 == 0) goto L94
            r3 = r2
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest r3 = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntityEnclosingRequest) r3     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity r3 = r3.getEntity()     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.EntityUtils.consume(r3)     // Catch: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException -> L3d
            goto L94
        L84:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L88:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponseFactory r3 = r8.responseFactory
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion r4 = com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion.HTTP_1_0
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse r0 = r3.newHttpResponse(r4, r0, r10)
            r8.handleException(r1, r0)
            r1 = r0
        L94:
            java.lang.String r0 = "http.response"
            r10.setAttribute(r0, r1)
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpProcessor r0 = r8.processor
            r0.process(r1, r10)
            r9.sendResponseHeader(r1)
            boolean r0 = r8.canResponseHaveBody(r2, r1)
            if (r0 == 0) goto Laa
            r9.sendResponseEntity(r1)
        Laa:
            r9.flush()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ConnectionReuseStrategy r0 = r8.connStrategy
            boolean r10 = r0.keepAlive(r1, r10)
            if (r10 != 0) goto Lb8
            r9.close()
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpService.handleRequest(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpServerConnection, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HttpContext):void");
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), (HttpExpectationVerifier) null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, (ConnectionReuseStrategy) null, (HttpResponseFactory) null, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }
}
