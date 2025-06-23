package com.goodix.ble.libcomx.transceiver;

import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.transceiver.IFrameDetector;
import com.goodix.ble.libcomx.transceiver.buffer.ring.RingBuffer;
import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexReader;
import java.util.Locale;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes9.dex */
public class Transceiver implements ITransceiver {
    private static final String TAG = "Transceiver";
    private IFrameDetector detector;
    private IFrameBuilder frameBuilder;
    private ILogger logger;
    private boolean readyToUse;
    private RingBuffer ringBuffer;
    private IFrameParser sduRxParser;
    private IFrameSender sender;
    private Event<IFrameSdu4Rx> eventRcvFrame = new Event<>();
    private Event<Boolean> eventReady = new Event<>(this, -274142511);
    private IFrameDetector.ResultHolder resultHolder = new IFrameDetector.ResultHolder();

    public Transceiver(int i) {
        this.ringBuffer = new RingBuffer(i);
    }

    private void detectFrame() {
        ILogger iLogger;
        while (this.detector.detectFrame(this.ringBuffer, this.resultHolder)) {
            IFrameDetector.ResultHolder resultHolder = this.resultHolder;
            int i = resultHolder.frameSize;
            byte[] bArr = new byte[i];
            int pop = this.ringBuffer.pop(resultHolder.framePos, bArr);
            printPdu("detect", bArr, 0, -1);
            if (pop != i && (iLogger = this.logger) != null) {
                iLogger.e(TAG, "Error on getting pdu: expect=" + i + "  actual=" + pop + "  pos=" + this.resultHolder.framePos);
            }
            HexReader hexReader = new HexReader(bArr);
            IFrameDetector.ResultHolder resultHolder2 = this.resultHolder;
            hexReader.setRange(resultHolder2.sduPos, resultHolder2.sduSize);
            this.eventRcvFrame.postEvent(this, this.resultHolder.frameType, this.sduRxParser.parseSdu(this.resultHolder.frameType, hexReader));
        }
    }

    private void printPdu(String str, byte[] bArr, int i, int i2) {
        if (this.logger != null) {
            StringBuilder sb = new StringBuilder(1024);
            if (i2 <= 0) {
                i2 = bArr.length;
            }
            sb.append(str);
            sb.append(" pdu[");
            sb.append(i2);
            sb.append("]");
            for (int i3 = 0; i3 < i + i2; i3++) {
                sb.append(String.format(Locale.US, "%02X ", Integer.valueOf(bArr[i + i3] & 255)));
            }
            this.logger.v(TAG, sb.toString());
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.ITransceiver
    public Event<IFrameSdu4Rx> evtRcvFrame() {
        return this.eventRcvFrame;
    }

    @Override // com.goodix.ble.libcomx.transceiver.ITransceiver
    public Event<Boolean> evtReady() {
        return this.eventReady;
    }

    @Override // com.goodix.ble.libcomx.transceiver.ITransceiver
    public void handleRcvData(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.e(TAG, "rcv null pdu.");
                return;
            }
            return;
        }
        if (i + i2 > bArr.length) {
            int length = bArr.length - i;
            ILogger iLogger2 = this.logger;
            if (iLogger2 != null) {
                iLogger2.e(TAG, "the size of pdu is exceed pdu.length: pos: " + i + "  size: " + i2 + "  length: " + bArr.length);
            }
            i2 = length;
        }
        printPdu("handle", bArr, i, i2);
        synchronized (this) {
            try {
                int put = this.ringBuffer.put(bArr, i, i2);
                if (put > 0) {
                    detectFrame();
                }
                if (put < i2) {
                    int i3 = i + put;
                    int i4 = i2 - put;
                    this.ringBuffer.drop(i4);
                    ILogger iLogger3 = this.logger;
                    if (iLogger3 != null) {
                        iLogger3.w(TAG, "drop " + i4 + "  bytes pdu. remain " + this.ringBuffer.getSize() + " bytes data.");
                    }
                    this.ringBuffer.put(bArr, i3, i4);
                    detectFrame();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.ITransceiver
    public boolean isReady() {
        return this.readyToUse;
    }

    @Override // com.goodix.ble.libcomx.transceiver.ITransceiver
    public void reset() {
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.w(TAG, "reset RX buffer.");
        }
        synchronized (this) {
            this.ringBuffer.dropAll();
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.ITransceiver
    public boolean send(int i, IFrameSdu4Tx iFrameSdu4Tx) {
        int calcFrameSize;
        IFrameBuilder iFrameBuilder = this.frameBuilder;
        if (iFrameBuilder == null || this.sender == null || (calcFrameSize = iFrameBuilder.calcFrameSize(i, iFrameSdu4Tx)) <= 0) {
            return false;
        }
        HexBuilder hexBuilder = new HexBuilder(calcFrameSize);
        this.frameBuilder.buildFrame(hexBuilder, i, iFrameSdu4Tx);
        printPdu(MqttServiceConstants.SEND_ACTION, hexBuilder.getBuffer(), 0, 0);
        return this.sender.sendFrame(hexBuilder.getBuffer());
    }

    public Transceiver setDetector(IFrameDetector iFrameDetector) {
        this.detector = iFrameDetector;
        return this;
    }

    public Transceiver setFrameBuilder(IFrameBuilder iFrameBuilder) {
        this.frameBuilder = iFrameBuilder;
        return this;
    }

    public Transceiver setLogger(ILogger iLogger) {
        this.logger = iLogger;
        return this;
    }

    public Transceiver setParser(IFrameParser iFrameParser) {
        this.sduRxParser = iFrameParser;
        return this;
    }

    public void setReady(boolean z) {
        if (this.readyToUse != z) {
            this.readyToUse = z;
            this.eventReady.postEvent(Boolean.valueOf(z));
        }
    }

    public Transceiver setSender(IFrameSender iFrameSender) {
        this.sender = iFrameSender;
        return this;
    }

    public Transceiver(int i, IFrameDetector iFrameDetector, IFrameParser iFrameParser, IFrameBuilder iFrameBuilder, IFrameSender iFrameSender) {
        this.ringBuffer = new RingBuffer(i);
        this.detector = iFrameDetector;
        this.sduRxParser = iFrameParser;
        this.frameBuilder = iFrameBuilder;
        this.sender = iFrameSender;
    }

    public Transceiver(RingBuffer ringBuffer, IFrameDetector iFrameDetector, IFrameParser iFrameParser, IFrameBuilder iFrameBuilder, IFrameSender iFrameSender) {
        this.ringBuffer = ringBuffer;
        this.detector = iFrameDetector;
        this.sduRxParser = iFrameParser;
        this.frameBuilder = iFrameBuilder;
        this.sender = iFrameSender;
    }
}
