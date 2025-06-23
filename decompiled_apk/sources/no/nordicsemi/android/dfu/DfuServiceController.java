package no.nordicsemi.android.dfu;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* loaded from: classes6.dex */
public class DfuServiceController implements DfuController {
    private boolean mAborted;
    private final LocalBroadcastManager mBroadcastManager;
    private boolean mPaused;

    public DfuServiceController(@NonNull Context context) {
        this.mBroadcastManager = LocalBroadcastManager.getInstance(context);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        if (!this.mAborted) {
            this.mAborted = true;
            this.mPaused = false;
            Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
            intent.putExtra(DfuBaseService.EXTRA_ACTION, 2);
            this.mBroadcastManager.sendBroadcast(intent);
        }
    }

    public boolean isAborted() {
        return this.mAborted;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        if (!this.mAborted && !this.mPaused) {
            this.mPaused = true;
            Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
            intent.putExtra(DfuBaseService.EXTRA_ACTION, 0);
            this.mBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        if (!this.mAborted && this.mPaused) {
            this.mPaused = false;
            Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
            intent.putExtra(DfuBaseService.EXTRA_ACTION, 1);
            this.mBroadcastManager.sendBroadcast(intent);
        }
    }
}
