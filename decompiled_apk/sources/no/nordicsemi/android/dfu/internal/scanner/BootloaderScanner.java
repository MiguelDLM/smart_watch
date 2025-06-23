package no.nordicsemi.android.dfu.internal.scanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import no.nordicsemi.android.dfu.DfuDeviceSelector;

/* loaded from: classes6.dex */
public interface BootloaderScanner {
    @Nullable
    String searchUsing(@NonNull DfuDeviceSelector dfuDeviceSelector, long j);
}
