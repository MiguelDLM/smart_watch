package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import androidx.annotation.NonNull;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* loaded from: classes6.dex */
class DfuServiceProvider implements DfuCallback {
    private boolean mAborted;
    private BaseDfuImpl mImpl;
    private boolean mPaused;

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mAborted = true;
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.abort();
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public DfuCallback.DfuGattCallback getGattCallback() {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            return baseDfuImpl.getGattCallback();
        }
        return null;
    }

    public DfuService getServiceImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService, @NonNull BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        try {
            ButtonlessDfuWithBondSharingImpl buttonlessDfuWithBondSharingImpl = new ButtonlessDfuWithBondSharingImpl(intent, dfuBaseService);
            this.mImpl = buttonlessDfuWithBondSharingImpl;
            if (buttonlessDfuWithBondSharingImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl = this.mImpl;
                if (baseDfuImpl != null) {
                    if (this.mPaused) {
                        baseDfuImpl.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl;
            }
            ButtonlessDfuWithoutBondSharingImpl buttonlessDfuWithoutBondSharingImpl = new ButtonlessDfuWithoutBondSharingImpl(intent, dfuBaseService);
            this.mImpl = buttonlessDfuWithoutBondSharingImpl;
            if (buttonlessDfuWithoutBondSharingImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl2 = this.mImpl;
                if (baseDfuImpl2 != null) {
                    if (this.mPaused) {
                        baseDfuImpl2.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl2;
            }
            SecureDfuImpl secureDfuImpl = new SecureDfuImpl(intent, dfuBaseService);
            this.mImpl = secureDfuImpl;
            if (secureDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl3 = this.mImpl;
                if (baseDfuImpl3 != null) {
                    if (this.mPaused) {
                        baseDfuImpl3.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl3;
            }
            LegacyButtonlessDfuImpl legacyButtonlessDfuImpl = new LegacyButtonlessDfuImpl(intent, dfuBaseService);
            this.mImpl = legacyButtonlessDfuImpl;
            if (legacyButtonlessDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl4 = this.mImpl;
                if (baseDfuImpl4 != null) {
                    if (this.mPaused) {
                        baseDfuImpl4.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl4;
            }
            LegacyDfuImpl legacyDfuImpl = new LegacyDfuImpl(intent, dfuBaseService);
            this.mImpl = legacyDfuImpl;
            if (legacyDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                BaseDfuImpl baseDfuImpl5 = this.mImpl;
                if (baseDfuImpl5 != null) {
                    if (this.mPaused) {
                        baseDfuImpl5.pause();
                    }
                    if (this.mAborted) {
                        this.mImpl.abort();
                    }
                }
                return baseDfuImpl5;
            }
            if (intent.getBooleanExtra(DfuBaseService.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU, false)) {
                ExperimentalButtonlessDfuImpl experimentalButtonlessDfuImpl = new ExperimentalButtonlessDfuImpl(intent, dfuBaseService);
                this.mImpl = experimentalButtonlessDfuImpl;
                if (experimentalButtonlessDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                    BaseDfuImpl baseDfuImpl6 = this.mImpl;
                    if (baseDfuImpl6 != null) {
                        if (this.mPaused) {
                            baseDfuImpl6.pause();
                        }
                        if (this.mAborted) {
                            this.mImpl.abort();
                        }
                    }
                    return baseDfuImpl6;
                }
            }
            return null;
        } finally {
            BaseDfuImpl baseDfuImpl7 = this.mImpl;
            if (baseDfuImpl7 != null) {
                if (this.mPaused) {
                    baseDfuImpl7.pause();
                }
                if (this.mAborted) {
                    this.mImpl.abort();
                }
            }
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(int i) {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.onBondStateChanged(i);
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
    }
}
