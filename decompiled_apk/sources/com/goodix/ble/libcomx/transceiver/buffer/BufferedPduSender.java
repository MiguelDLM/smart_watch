package com.goodix.ble.libcomx.transceiver.buffer;

import com.goodix.ble.libcomx.transceiver.IFrameSender;
import com.goodix.ble.libcomx.transceiver.buffer.ring.RingBuffer;

/* loaded from: classes9.dex */
public class BufferedPduSender implements IPduSegmentSender {
    private RingBuffer buffer;
    private byte[] innerBuffer;
    private int mtu;
    private IFrameSender segmentSender;
    private boolean sending;

    public BufferedPduSender(IFrameSender iFrameSender) {
        this(iFrameSender, 4096);
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.IPduSegmentSender
    public void clear() {
        synchronized (this) {
            this.sending = false;
            this.buffer.dropAll();
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.IPduSegmentSender
    public void nextSegment() {
        synchronized (this) {
            try {
                int i = this.buffer.get(0, this.innerBuffer);
                if (i > 0) {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.innerBuffer, 0, bArr, 0, i);
                    if (this.segmentSender.sendFrame(bArr)) {
                        this.buffer.drop(i);
                    } else {
                        this.sending = false;
                        this.buffer.dropAll();
                    }
                } else {
                    this.sending = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSender
    public boolean sendFrame(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        synchronized (this) {
            try {
                if (bArr.length <= this.buffer.getFreeSize()) {
                    this.buffer.put(bArr, 0, bArr.length);
                    if (this.sending) {
                        return true;
                    }
                    int i = this.buffer.get(0, this.innerBuffer);
                    if (i > 0) {
                        byte[] bArr2 = new byte[i];
                        System.arraycopy(this.innerBuffer, 0, bArr2, 0, i);
                        if (this.segmentSender.sendFrame(bArr2)) {
                            this.sending = true;
                            this.buffer.drop(i);
                            return true;
                        }
                        this.buffer.dropAll();
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.IPduSegmentSender
    public void setMaxSegmentSize(int i) {
        synchronized (this) {
            this.mtu = i;
            this.innerBuffer = new byte[i];
        }
    }

    public BufferedPduSender(IFrameSender iFrameSender, int i) {
        this.mtu = 20;
        this.sending = false;
        this.segmentSender = iFrameSender;
        this.buffer = new RingBuffer(i);
        this.innerBuffer = new byte[this.mtu];
    }
}
