package com.sma.smartv3.ble;

import OXOo.OOXIXo;
import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes12.dex */
public final class DfuService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    @OOXIXo
    public Class<? extends Activity> getNotificationTarget() {
        return DfuNotificationActivity.class;
    }

    @Override // no.nordicsemi.android.dfu.DfuBaseService
    public boolean isDebug() {
        return false;
    }
}
