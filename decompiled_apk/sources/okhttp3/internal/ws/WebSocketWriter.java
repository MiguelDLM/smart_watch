package okhttp3.internal.ws;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@XX({"SMAP\nWebSocketWriter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketWriter.kt\nokhttp3/internal/ws/WebSocketWriter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
/* loaded from: classes6.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;

    @oOoXoXO
    private final Buffer.UnsafeCursor maskCursor;

    @oOoXoXO
    private final byte[] maskKey;

    @OOXIXo
    private final Buffer messageBuffer;

    @oOoXoXO
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;

    @OOXIXo
    private final Random random;

    @OOXIXo
    private final BufferedSink sink;

    @OOXIXo
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z, @OOXIXo BufferedSink sink, @OOXIXo Random random, boolean z2, boolean z3, long j) {
        byte[] bArr;
        IIX0o.x0xO0oo(sink, "sink");
        IIX0o.x0xO0oo(random, "random");
        this.isClient = z;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.minimumDeflateSize = j;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = sink.getBuffer();
        if (z) {
            bArr = new byte[4];
        } else {
            bArr = null;
        }
        this.maskKey = bArr;
        this.maskCursor = z ? new Buffer.UnsafeCursor() : null;
    }

    private final void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            int size = byteString.size();
            if (size <= 125) {
                this.sinkBuffer.writeByte(i | 128);
                if (this.isClient) {
                    this.sinkBuffer.writeByte(size | 128);
                    Random random = this.random;
                    byte[] bArr = this.maskKey;
                    IIX0o.ooOOo0oXI(bArr);
                    random.nextBytes(bArr);
                    this.sinkBuffer.write(this.maskKey);
                    if (size > 0) {
                        long size2 = this.sinkBuffer.size();
                        this.sinkBuffer.write(byteString);
                        Buffer buffer = this.sinkBuffer;
                        Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                        IIX0o.ooOOo0oXI(unsafeCursor);
                        buffer.readAndWriteUnsafe(unsafeCursor);
                        this.maskCursor.seek(size2);
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.writeByte(size);
                    this.sinkBuffer.write(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    @OOXIXo
    public final Random getRandom() {
        return this.random;
    }

    @OOXIXo
    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int i, @oOoXoXO ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i, @OOXIXo ByteString data) throws IOException {
        int i2;
        IIX0o.x0xO0oo(data, "data");
        if (!this.writerClosed) {
            this.messageBuffer.write(data);
            int i3 = i | 128;
            if (this.perMessageDeflate && data.size() >= this.minimumDeflateSize) {
                MessageDeflater messageDeflater = this.messageDeflater;
                if (messageDeflater == null) {
                    messageDeflater = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = messageDeflater;
                }
                messageDeflater.deflate(this.messageBuffer);
                i3 = i | 192;
            }
            long size = this.messageBuffer.size();
            this.sinkBuffer.writeByte(i3);
            if (this.isClient) {
                i2 = 128;
            } else {
                i2 = 0;
            }
            if (size <= 125) {
                this.sinkBuffer.writeByte(i2 | ((int) size));
            } else if (size <= 65535) {
                this.sinkBuffer.writeByte(i2 | 126);
                this.sinkBuffer.writeShort((int) size);
            } else {
                this.sinkBuffer.writeByte(i2 | 127);
                this.sinkBuffer.writeLong(size);
            }
            if (this.isClient) {
                Random random = this.random;
                byte[] bArr = this.maskKey;
                IIX0o.ooOOo0oXI(bArr);
                random.nextBytes(bArr);
                this.sinkBuffer.write(this.maskKey);
                if (size > 0) {
                    Buffer buffer = this.messageBuffer;
                    Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                    IIX0o.ooOOo0oXI(unsafeCursor);
                    buffer.readAndWriteUnsafe(unsafeCursor);
                    this.maskCursor.seek(0L);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, size);
            this.sink.emit();
            return;
        }
        throw new IOException("closed");
    }

    public final void writePing(@OOXIXo ByteString payload) throws IOException {
        IIX0o.x0xO0oo(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(@OOXIXo ByteString payload) throws IOException {
        IIX0o.x0xO0oo(payload, "payload");
        writeControlFrame(10, payload);
    }
}
