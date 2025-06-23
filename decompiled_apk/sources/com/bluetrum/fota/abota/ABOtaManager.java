package com.bluetrum.fota.abota;

import androidx.annotation.NonNull;
import com.bluetrum.fota.manager.OtaManager;

/* loaded from: classes8.dex */
public class ABOtaManager extends OtaManager {
    private final EventListener eventListener;

    /* loaded from: classes8.dex */
    public interface EventListener extends OtaManager.EventListener {
        void sendOtaData(byte[] bArr);
    }

    public ABOtaManager(@NonNull EventListener eventListener) {
        super(eventListener);
        this.eventListener = eventListener;
    }

    @Override // com.bluetrum.fota.manager.OtaManager
    public void btSendData(byte[] bArr) {
        if (this.isUpdatePause) {
            return;
        }
        this.eventListener.sendOtaData(bArr);
    }

    public void nextRun() {
        runDataSend();
    }
}
