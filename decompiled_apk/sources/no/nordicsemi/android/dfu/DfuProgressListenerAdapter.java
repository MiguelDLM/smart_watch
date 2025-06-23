package no.nordicsemi.android.dfu;

import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public class DfuProgressListenerAdapter implements DfuProgressListener {
    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceConnected(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceConnecting(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceDisconnected(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDeviceDisconnecting(String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuAborted(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuCompleted(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuProcessStarted(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onDfuProcessStarting(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onEnablingDfuMode(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onError(@NonNull String str, int i, int i2, String str2) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onFirmwareValidating(@NonNull String str) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressListener
    public void onProgressChanged(@NonNull String str, int i, float f, float f2, int i2, int i3) {
    }
}
