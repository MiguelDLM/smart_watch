package no.nordicsemi.android.dfu;

import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public interface DfuProgressListener {
    void onDeviceConnected(@NonNull String str);

    void onDeviceConnecting(@NonNull String str);

    void onDeviceDisconnected(@NonNull String str);

    void onDeviceDisconnecting(String str);

    void onDfuAborted(@NonNull String str);

    void onDfuCompleted(@NonNull String str);

    void onDfuProcessStarted(@NonNull String str);

    void onDfuProcessStarting(@NonNull String str);

    void onEnablingDfuMode(@NonNull String str);

    void onError(@NonNull String str, int i, int i2, String str2);

    void onFirmwareValidating(@NonNull String str);

    void onProgressChanged(@NonNull String str, int i, float f, float f2, int i2, int i3);
}
