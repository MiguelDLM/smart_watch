package com.goodix.ble.libcomx.util;

import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskError;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.transceiver.ITransceiver;
import java.util.TimerTask;

/* loaded from: classes9.dex */
public class TransceiverTask extends Task implements IEventListener {
    private static final int RETRY_TIMER = 293;
    private static final int SILENT_TIMER = 295;
    public static int defaultRetryCount;
    public static int defaultRetryInterval;
    private EventDisposer disposer;
    private Integer expectResponseCode;
    private int maxRetry;
    private IFrameSdu4Tx request;
    private int requestCode;
    private IFrameSdu4Rx response;
    private ResponseHandler responseHandler;
    private int retryCnt;
    private int retryInterval;
    private int silentTime;
    private TimerTask silentTimer;
    private ITransceiver specifiedTransceiver;
    private int timeout;

    @TaskParameter(nullable = true)
    private ITransceiver transceiver;

    /* loaded from: classes9.dex */
    public interface ResponseHandler {
        void onRcvResponse(TransceiverTask transceiverTask, int i, IFrameSdu4Tx iFrameSdu4Tx, int i2, IFrameSdu4Rx iFrameSdu4Rx) throws TaskError;
    }

    public TransceiverTask() {
        this.timeout = 3000;
        this.silentTime = 0;
        this.disposer = new EventDisposer();
        this.maxRetry = defaultRetryCount;
        this.retryInterval = defaultRetryInterval;
    }

    private void sendCmd() {
        ILogger iLogger = this.logger;
        if (iLogger != null && this.maxRetry > 0) {
            String str = "Retry #" + this.retryCnt;
            if (this.retryCnt > 1) {
                iLogger.w(getName(), str);
            } else if (this.printVerboseLog) {
                iLogger.v(getName(), str);
            }
        }
        if (this.transceiver.isReady()) {
            if (this.transceiver.send(this.requestCode, this.request)) {
                if (this.expectResponseCode == null) {
                    finishedWithDone();
                    return;
                }
                int i = this.silentTime;
                if (i > 0) {
                    if (this.silentTimer == null) {
                        this.silentTimer = startTimer(295, i);
                        return;
                    }
                    if (iLogger != null) {
                        iLogger.w(getName(), "Silent Timer is already existed: " + this.silentTimer);
                        return;
                    }
                    return;
                }
                return;
            }
            if (iLogger != null) {
                iLogger.w(getName(), "Failed to send: " + this.requestCode);
            }
        } else if (iLogger != null) {
            iLogger.w(getName(), "Transceiver is not ready.");
        }
        if (this.maxRetry <= 0) {
            finishedWithError("Failed to send: " + this.requestCode);
        }
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        ITransceiver iTransceiver = this.specifiedTransceiver;
        if (iTransceiver != null) {
            this.transceiver = iTransceiver;
        }
        ITransceiver iTransceiver2 = this.transceiver;
        if (iTransceiver2 == null) {
            finishedWithError("Transceiver is null.");
            return 0;
        }
        if (this.expectResponseCode != null) {
            iTransceiver2.evtRcvFrame().subEvent(this).setDisposer(this.disposer).setExecutor(getExecutor()).register(this);
        }
        this.transceiver.evtReady().subEvent(this).setDisposer(this.disposer).setExecutor(getExecutor()).register(this);
        this.retryCnt = 0;
        this.silentTimer = null;
        int i = this.timeout;
        int i2 = this.maxRetry;
        if (i2 > 0) {
            int i3 = this.retryInterval;
            int i4 = (i2 + 1) * i3;
            if (i4 > i) {
                i = i4;
            }
            startTimer(293, i3);
        }
        sendCmd();
        return i;
    }

    public <T extends IFrameSdu4Rx> T getResponse() {
        return (T) this.response;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.disposer.disposeAll(this);
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        if (obj == this.transceiver) {
            if (i == this.expectResponseCode.intValue()) {
                IFrameSdu4Rx iFrameSdu4Rx = (IFrameSdu4Rx) obj2;
                this.response = iFrameSdu4Rx;
                try {
                    ResponseHandler responseHandler = this.responseHandler;
                    if (responseHandler != null) {
                        responseHandler.onRcvResponse(this, this.requestCode, this.request, i, iFrameSdu4Rx);
                    }
                    finishedWithDone();
                    return;
                } catch (TaskError e) {
                    finished(-1, e);
                    return;
                }
            }
            if (i == -274142511 && (obj2 instanceof Boolean) && !((Boolean) obj2).booleanValue() && this.maxRetry <= 0) {
                finishedWithError("Transceiver has turned into unavailable.");
            }
        }
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTimeout(int i) {
        if (i == 293) {
            int i2 = this.retryCnt + 1;
            this.retryCnt = i2;
            if (i2 < this.maxRetry) {
                startTimer(293, this.retryInterval);
            }
            sendCmd();
            return;
        }
        if (i == 295) {
            finishedWithDone();
        }
    }

    public TransceiverTask setExpectResponseCode(int i) {
        this.expectResponseCode = Integer.valueOf(i);
        return this;
    }

    public TransceiverTask setHandler(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        return this;
    }

    public TransceiverTask setRequest(int i, IFrameSdu4Tx iFrameSdu4Tx) {
        this.requestCode = i;
        this.request = iFrameSdu4Tx;
        return this;
    }

    public TransceiverTask setRetry(int i, int i2) {
        this.maxRetry = i;
        this.retryInterval = i2;
        if (this.timeout <= i2) {
            this.timeout = i2 + 1;
        }
        return this;
    }

    public TransceiverTask setSilentTime(int i) {
        this.silentTime = i;
        return this;
    }

    public TransceiverTask setTimeout(int i) {
        if (i > 0) {
            this.timeout = i;
        }
        return this;
    }

    public TransceiverTask setTransceiver(ITransceiver iTransceiver) {
        this.specifiedTransceiver = iTransceiver;
        return this;
    }

    public TransceiverTask(ITransceiver iTransceiver, int i, IFrameSdu4Tx iFrameSdu4Tx, Integer num) {
        this(i, iFrameSdu4Tx, num);
        setTransceiver(iTransceiver);
    }

    public TransceiverTask(int i, IFrameSdu4Tx iFrameSdu4Tx, Integer num) {
        this.timeout = 3000;
        this.silentTime = 0;
        this.disposer = new EventDisposer();
        this.maxRetry = defaultRetryCount;
        this.retryInterval = defaultRetryInterval;
        this.transceiver = null;
        this.requestCode = i;
        this.expectResponseCode = num;
        this.request = iFrameSdu4Tx;
    }
}
