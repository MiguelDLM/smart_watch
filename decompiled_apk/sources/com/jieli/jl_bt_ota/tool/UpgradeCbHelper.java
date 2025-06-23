package com.jieli.jl_bt_ota.tool;

import com.jieli.jl_bt_ota.interfaces.IUpgradeCallback;
import com.jieli.jl_bt_ota.model.base.BaseError;

/* loaded from: classes10.dex */
public class UpgradeCbHelper extends BaseCallbackHelper<IUpgradeCallback> implements IUpgradeCallback {
    public IUpgradeCallback getCallback() {
        if (this.callbacks.isEmpty()) {
            return null;
        }
        return (IUpgradeCallback) this.callbacks.get(0);
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onCancelOTA() {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.IIXOooo
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IUpgradeCallback) obj).onCancelOTA();
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onError(final BaseError baseError) {
        if (baseError == null) {
            return;
        }
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.OxI
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IUpgradeCallback) obj).onError(BaseError.this);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onNeedReconnect(final String str, final boolean z) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.o00
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IUpgradeCallback) obj).onNeedReconnect(str, z);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onProgress(final int i, final float f) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.O0xOxO
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IUpgradeCallback) obj).onProgress(i, f);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onStartOTA() {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.xoXoI
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IUpgradeCallback) obj).onStartOTA();
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IUpgradeCallback
    public void onStopOTA() {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.X0IIOO
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IUpgradeCallback) obj).onStopOTA();
            }
        });
    }

    public void setUpgradeCallback(IUpgradeCallback iUpgradeCallback) {
        this.callbacks.clear();
        if (iUpgradeCallback != null) {
            addCallback(iUpgradeCallback);
        }
    }
}
