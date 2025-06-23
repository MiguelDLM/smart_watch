package okhttp3.internal.ws;

import IoxX.I0Io;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.tencent.connect.common.II0xO0;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@XX({"SMAP\nRealWebSocket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealWebSocket.kt\nokhttp3/internal/ws/RealWebSocket\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 4 Util.kt\nokhttp3/internal/Util\n*L\n1#1,654:1\n1#2:655\n84#3,4:656\n90#3,13:664\n608#4,4:660\n*S KotlinDebug\n*F\n+ 1 RealWebSocket.kt\nokhttp3/internal/ws/RealWebSocket\n*L\n269#1:656,4\n512#1:664,13\n457#1:660,4\n*E\n"})
/* loaded from: classes6.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;

    @oOoXoXO
    private Call call;
    private boolean enqueuedClose;

    @oOoXoXO
    private WebSocketExtensions extensions;
    private boolean failed;

    @OOXIXo
    private final String key;

    @OOXIXo
    private final WebSocketListener listener;

    @OOXIXo
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;

    @oOoXoXO
    private String name;

    @OOXIXo
    private final Request originalRequest;
    private final long pingIntervalMillis;

    @OOXIXo
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;

    @OOXIXo
    private final Random random;

    @oOoXoXO
    private WebSocketReader reader;
    private int receivedCloseCode;

    @oOoXoXO
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;

    @oOoXoXO
    private Streams streams;

    @OOXIXo
    private TaskQueue taskQueue;

    @oOoXoXO
    private WebSocketWriter writer;

    @oOoXoXO
    private Task writerTask;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    private static final List<Protocol> ONLY_HTTP1 = oI0IIXIo.OOXIXo(Protocol.HTTP_1_1);

    /* loaded from: classes6.dex */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;

        @oOoXoXO
        private final ByteString reason;

        public Close(int i, @oOoXoXO ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @oOoXoXO
        public final ByteString getReason() {
            return this.reason;
        }
    }

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class Message {

        @OOXIXo
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i, @OOXIXo ByteString data) {
            IIX0o.x0xO0oo(data, "data");
            this.formatOpcode = i;
            this.data = data;
        }

        @OOXIXo
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Streams implements Closeable {
        private final boolean client;

        @OOXIXo
        private final BufferedSink sink;

        @OOXIXo
        private final BufferedSource source;

        public Streams(boolean z, @OOXIXo BufferedSource source, @OOXIXo BufferedSink sink) {
            IIX0o.x0xO0oo(source, "source");
            IIX0o.x0xO0oo(sink, "sink");
            this.client = z;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        @OOXIXo
        public final BufferedSink getSink() {
            return this.sink;
        }

        @OOXIXo
        public final BufferedSource getSource() {
            return this.source;
        }
    }

    /* loaded from: classes6.dex */
    public final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                if (RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0L;
                }
                return -1L;
            } catch (IOException e) {
                RealWebSocket.this.failWebSocket(e, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(@OOXIXo TaskRunner taskRunner, @OOXIXo Request originalRequest, @OOXIXo WebSocketListener listener, @OOXIXo Random random, long j, @oOoXoXO WebSocketExtensions webSocketExtensions, long j2) {
        IIX0o.x0xO0oo(taskRunner, "taskRunner");
        IIX0o.x0xO0oo(originalRequest, "originalRequest");
        IIX0o.x0xO0oo(listener, "listener");
        IIX0o.x0xO0oo(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j2;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (IIX0o.Oxx0IOOO("GET", originalRequest.method())) {
            ByteString.Companion companion = ByteString.Companion;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits != null && !new X0.oOoXoXO(8, 15).xxIXOIIO(webSocketExtensions.serverMaxWindowBits.intValue())) {
            return false;
        }
        return true;
    }

    private final void runWriter() {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        Task task = this.writerTask;
        if (task != null) {
            TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
        }
    }

    public final void awaitTermination(long j, @OOXIXo TimeUnit timeUnit) throws InterruptedException {
        IIX0o.x0xO0oo(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j, timeUnit);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        IIX0o.ooOOo0oXI(call);
        call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@OOXIXo Response response, @oOoXoXO Exchange exchange) throws IOException {
        IIX0o.x0xO0oo(response, "response");
        if (response.code() == 101) {
            String header$default = Response.header$default(response, "Connection", null, 2, null);
            if (OxI.oX0I0O("Upgrade", header$default, true)) {
                String header$default2 = Response.header$default(response, "Upgrade", null, 2, null);
                if (OxI.oX0I0O(I0Io.f855xoIox, header$default2, true)) {
                    String header$default3 = Response.header$default(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, null, 2, null);
                    String base64 = ByteString.Companion.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (IIX0o.Oxx0IOOO(base64, header$default3)) {
                        if (exchange != null) {
                            return;
                        } else {
                            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                        }
                    }
                    throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + TokenParser.SP + response.message() + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, @oOoXoXO String str) {
        return close(i, str, 60000L);
    }

    public final void connect(@OOXIXo OkHttpClient client) {
        IIX0o.x0xO0oo(client, "client");
        if (this.originalRequest.header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient build = client.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", I0Io.f855xoIox).header("Connection", "Upgrade").header(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.SEC_WEBSOCKET_VERSION, II0xO0.f26825XoIxOXIXo).header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        IIX0o.ooOOo0oXI(realCall);
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public void onFailure(@OOXIXo Call call, @OOXIXo IOException e) {
                IIX0o.x0xO0oo(call, "call");
                IIX0o.x0xO0oo(e, "e");
                RealWebSocket.this.failWebSocket(e, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(@OOXIXo Call call, @OOXIXo Response response) {
                boolean isValid;
                ArrayDeque arrayDeque;
                IIX0o.x0xO0oo(call, "call");
                IIX0o.x0xO0oo(response, "response");
                Exchange exchange = response.exchange();
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    IIX0o.ooOOo0oXI(exchange);
                    RealWebSocket.Streams newWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions parse = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = parse;
                    isValid = RealWebSocket.this.isValid(parse);
                    if (!isValid) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            arrayDeque = realWebSocket.messageAndCloseQueue;
                            arrayDeque.clear();
                            realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + build2.url().redact(), newWebSocketStreams);
                        RealWebSocket.this.getListener$okhttp().onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (IOException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                }
            }
        });
    }

    public final void failWebSocket(@OOXIXo Exception e, @oOoXoXO Response response) {
        IIX0o.x0xO0oo(e, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            try {
                this.listener.onFailure(this, e, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
    }

    @OOXIXo
    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(@OOXIXo String name, @OOXIXo Streams streams) throws IOException {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        IIX0o.ooOOo0oXI(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = name;
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j = this.pingIntervalMillis;
                if (j != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                    final String str = name + " ping";
                    this.taskQueue.schedule(new Task(str) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1
                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            this.writePingFrame$okhttp();
                            return nanos;
                        }
                    }, nanos);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            IIX0o.ooOOo0oXI(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, @OOXIXo String reason) {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        IIX0o.x0xO0oo(reason, "reason");
        if (i != -1) {
            synchronized (this) {
                try {
                    if (this.receivedCloseCode == -1) {
                        this.receivedCloseCode = i;
                        this.receivedCloseReason = reason;
                        streams = null;
                        if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                            Streams streams2 = this.streams;
                            this.streams = null;
                            webSocketReader = this.reader;
                            this.reader = null;
                            webSocketWriter = this.writer;
                            this.writer = null;
                            this.taskQueue.shutdown();
                            streams = streams2;
                        } else {
                            webSocketReader = null;
                            webSocketWriter = null;
                        }
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    } else {
                        throw new IllegalStateException("already closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                this.listener.onClosing(this, i, reason);
                if (streams != null) {
                    this.listener.onClosed(this, i, reason);
                }
                if (webSocketWriter != null) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@OOXIXo String text) throws IOException {
        IIX0o.x0xO0oo(text, "text");
        this.listener.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@OOXIXo ByteString payload) {
        try {
            IIX0o.x0xO0oo(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@OOXIXo ByteString payload) {
        IIX0o.x0xO0oo(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(@OOXIXo ByteString payload) {
        try {
            IIX0o.x0xO0oo(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            IIX0o.ooOOo0oXI(webSocketReader);
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode != -1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    @OOXIXo
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        return send(ByteString.Companion.encodeUtf8(text), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[Catch: all -> 0x0087, TRY_ENTER, TryCatch #0 {all -> 0x0087, blocks: (B:21:0x007e, B:29:0x0089, B:31:0x008d, B:32:0x009d, B:35:0x00ac, B:39:0x00af, B:40:0x00b0, B:41:0x00b1, B:43:0x00b5, B:45:0x00c7, B:46:0x00df, B:47:0x00e4, B:34:0x009e), top: B:19:0x007c, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d6 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00db A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[Catch: all -> 0x0087, TryCatch #0 {all -> 0x0087, blocks: (B:21:0x007e, B:29:0x0089, B:31:0x008d, B:32:0x009d, B:35:0x00ac, B:39:0x00af, B:40:0x00b0, B:41:0x00b1, B:43:0x00b5, B:45:0x00c7, B:46:0x00df, B:47:0x00e4, B:34:0x009e), top: B:19:0x007c, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    public final void writePingFrame$okhttp() {
        int i;
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter == null) {
                    return;
                }
                if (this.awaitingPong) {
                    i = this.sentPingCount;
                } else {
                    i = -1;
                }
                this.sentPingCount++;
                this.awaitingPong = true;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                if (i != -1) {
                    failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
                    return;
                }
                try {
                    webSocketWriter.writePing(ByteString.EMPTY);
                } catch (IOException e) {
                    failWebSocket(e, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean close(int i, @oOoXoXO String str, long j) {
        ByteString byteString;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i);
            if (str != null) {
                byteString = ByteString.Companion.encodeUtf8(str);
                if (byteString.size() > 123) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            } else {
                byteString = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i, byteString, j));
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@OOXIXo ByteString bytes) throws IOException {
        IIX0o.x0xO0oo(bytes, "bytes");
        this.listener.onMessage(this, bytes);
    }

    @Override // okhttp3.WebSocket
    public boolean send(@OOXIXo ByteString bytes) {
        IIX0o.x0xO0oo(bytes, "bytes");
        return send(bytes, 2);
    }

    private final synchronized boolean send(ByteString byteString, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new Message(i, byteString));
            runWriter();
            return true;
        }
        return false;
    }
}
