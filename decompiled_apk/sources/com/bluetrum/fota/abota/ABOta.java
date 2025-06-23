package com.bluetrum.fota.abota;

import androidx.annotation.NonNull;
import com.bluetrum.fota.abota.ABOtaManager;
import com.bluetrum.fota.manager.DataReader;
import com.bluetrum.fota.manager.OtaError;

/* loaded from: classes8.dex */
public class ABOta implements ABOtaManager.EventListener {
    public static final int ERROR_CODE_CRC_ERROR = 11;
    public static final int ERROR_CODE_DATA_READER_ERROR = 4101;
    public static final int ERROR_CODE_DEVICE_REFUSED = 4097;
    public static final int ERROR_CODE_KEY_MISMATCH = 2;
    public static final int ERROR_CODE_SAME_FIRMWARE = 1;
    public static final int ERROR_CODE_TIMEOUT = 4099;
    public static final int ERROR_CODE_TWS_DISCONNECTED = 4100;
    public static final int ERROR_CODE_UNKNOWN = 4352;
    public static final int OTA_STATUS_CONTINUE = 4;
    public static final int OTA_STATUS_FAIL = 7;
    public static final int OTA_STATUS_PAUSE = 3;
    public static final int OTA_STATUS_READY = 0;
    public static final int OTA_STATUS_START = 1;
    public static final int OTA_STATUS_SUCCESS = 5;
    public static final int OTA_STATUS_UPDATING = 2;
    public static final int OTA_STATUS_WAIT_FINISH = 6;
    private EventListener eventListener;
    private final ABOtaManager otaManager = new ABOtaManager(this);
    private SendCallback sendCallback;

    /* renamed from: com.bluetrum.fota.abota.ABOta$1, reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bluetrum$fota$manager$OtaError;

        static {
            int[] iArr = new int[OtaError.values().length];
            $SwitchMap$com$bluetrum$fota$manager$OtaError = iArr;
            try {
                iArr[OtaError.REFUSED_BY_DEVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bluetrum$fota$manager$OtaError[OtaError.TIMEOUT_RECEIVE_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bluetrum$fota$manager$OtaError[OtaError.DATA_READER_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface EventListener {
        void onReceiveChannel(boolean z);

        void onReceiveTwsInfo(boolean z, boolean z2);

        void onReceiveVersion(int i);

        void onStatusChanged(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface SendCallback {
        void sendData(byte[] bArr);
    }

    private void handleTWSMessage() {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onReceiveTwsInfo(this.otaManager.isTwsDevice(), this.otaManager.isTwsConnected());
        }
    }

    private void notifyStatusChanged(int i, int i2) {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onStatusChanged(i, i2);
        }
    }

    public void handleData(byte[] bArr) {
        this.otaManager.processData(bArr);
    }

    public boolean isUpdating() {
        return this.otaManager.isUpdating();
    }

    public void nextRun() {
        this.otaManager.nextRun();
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaContinue() {
        notifyStatusChanged(4, 0);
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaError(OtaError otaError) {
        int i;
        OtaError otaError2 = OtaError.REPORT_FROM_DEVICE;
        if (otaError == otaError2) {
            notifyStatusChanged(7, otaError2.getDeviceErrorCode());
            return;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$bluetrum$fota$manager$OtaError[otaError.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    i = 4352;
                } else {
                    i = 4101;
                }
            } else {
                i = 4099;
            }
        } else {
            i = 4097;
        }
        notifyStatusChanged(7, i);
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaFinish() {
        if (this.otaManager.isCompressedData()) {
            notifyStatusChanged(6, 0);
        } else {
            notifyStatusChanged(5, 0);
        }
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaPause() {
        notifyStatusChanged(3, 0);
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaProgress(int i) {
        notifyStatusChanged(2, i);
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaReady() {
        notifyStatusChanged(0, 0);
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaStart() {
        notifyStatusChanged(1, 0);
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onOtaStop() {
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onReceiveChannel(boolean z) {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onReceiveChannel(z);
        }
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onReceiveIsTWS(boolean z) {
        handleTWSMessage();
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onReceiveTWSConnected(boolean z) {
        handleTWSMessage();
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onReceiveVersion(int i) {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onReceiveVersion(i);
        }
    }

    @Override // com.bluetrum.fota.manager.OtaManager.EventListener
    public void onTWSDisconnected() {
        notifyStatusChanged(7, 4100);
    }

    public void prepareToUpdate() {
        this.otaManager.prepareToUpdate();
    }

    @Override // com.bluetrum.fota.abota.ABOtaManager.EventListener
    public void sendOtaData(byte[] bArr) {
        SendCallback sendCallback = this.sendCallback;
        if (sendCallback != null) {
            sendCallback.sendData(bArr);
        }
    }

    public void setDataReader(@NonNull DataReader dataReader) {
        this.otaManager.setDataReader(dataReader);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void setOtaData(@NonNull byte[] bArr) {
        this.otaManager.setOtaData(bArr);
    }

    public void setSendCallback(SendCallback sendCallback) {
        this.sendCallback = sendCallback;
    }

    public void startOTA() {
        this.otaManager.startOTA();
    }
}
