package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.setting.ISettingFunction;
import com.jieli.jl_rcsp.interfaces.setting.OnSettingFunctionListener;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.setting.PublicSettingsCmd;
import com.jieli.jl_rcsp.model.device.settings.SettingData;
import com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes8.dex */
public class SettingFunctionImpl implements ISettingFunction {
    public static volatile SettingFunctionImpl e;
    public final RcspOpImpl b;
    public final OnRcspCallback d;

    /* renamed from: a, reason: collision with root package name */
    public final String f17901a = SettingFunctionImpl.class.getSimpleName();
    public final CallbackManager c = new CallbackManager();

    /* loaded from: classes8.dex */
    public static class CallbackManager extends BaseCallbackManager<OnSettingFunctionListener> implements OnSettingFunctionListener {
        public CallbackManager() {
        }

        @Override // com.jieli.jl_rcsp.interfaces.setting.OnSettingFunctionListener
        public void onSettingData(final BluetoothDevice bluetoothDevice, final SettingData settingData) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.IXxxXO
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnSettingFunctionListener) obj).onSettingData(bluetoothDevice, settingData);
                }
            });
        }

        @Override // com.jieli.jl_rcsp.interfaces.setting.OnSettingFunctionListener
        public void onSettingFunction(final BluetoothDevice bluetoothDevice, final SettingFunction settingFunction) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.x0xO0oo
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnSettingFunctionListener) obj).onSettingFunction(bluetoothDevice, settingFunction);
                }
            });
        }
    }

    public SettingFunctionImpl(RcspOpImpl rcspOpImpl) {
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.impl.SettingFunctionImpl.2
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                PublicSettingsCmd publicSettingsCmd;
                PublicSettingsCmd.Param param;
                if (bluetoothDevice == null || commandBase == null || commandBase.getId() != 51 || (param = (publicSettingsCmd = (PublicSettingsCmd) commandBase).getParam()) == null) {
                    return;
                }
                SettingData settingData = param.getSettingData();
                SettingFunctionImpl.this.c.onSettingData(bluetoothDevice, settingData);
                if (settingData instanceof SettingFunction) {
                    SettingFunction settingFunction = (SettingFunction) settingData;
                    JL_Log.d(SettingFunctionImpl.this.f17901a, "onRcspCommand", "" + settingFunction);
                    SettingFunctionImpl.this.c.onSettingFunction(bluetoothDevice, settingFunction);
                }
                if (commandBase.getType() == 2) {
                    publicSettingsCmd.setParam(new PublicSettingsCmd.ResultParam(0));
                    publicSettingsCmd.setStatus(0);
                    SettingFunctionImpl.this.b.sendCommandResponse(bluetoothDevice, publicSettingsCmd, null);
                }
            }
        };
        this.d = onRcspCallback;
        if (rcspOpImpl != null) {
            this.b = rcspOpImpl;
            rcspOpImpl.registerOnRcspCallback(onRcspCallback);
            return;
        }
        throw new NullPointerException("RcspOpImpl can not be null.");
    }

    public static SettingFunctionImpl instance(RcspOpImpl rcspOpImpl) {
        if (e == null) {
            synchronized (SettingFunctionImpl.class) {
                try {
                    if (e == null) {
                        e = new SettingFunctionImpl(rcspOpImpl);
                    }
                } finally {
                }
            }
        }
        return e;
    }

    @Override // com.jieli.jl_rcsp.interfaces.setting.ISettingFunction
    public void addOnSettingFunctionListener(OnSettingFunctionListener onSettingFunctionListener) {
        this.c.registerCallback(onSettingFunctionListener);
    }

    public void destroy() {
        this.b.unregisterOnRcspCallback(this.d);
        this.c.release();
        e = null;
    }

    public RcspOpImpl getRcspOp() {
        return this.b;
    }

    @Override // com.jieli.jl_rcsp.interfaces.setting.ISettingFunction
    public void removeOnSettingFunctionListener(OnSettingFunctionListener onSettingFunctionListener) {
        this.c.unregisterCallback(onSettingFunctionListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.setting.ISettingFunction
    public void settingFunction(BluetoothDevice bluetoothDevice, PublicSettingsCmd.Param param, OnOperationCallback<PublicSettingsCmd.Response> onOperationCallback) {
        this.b.sendRcspCommand(bluetoothDevice, new PublicSettingsCmd(param), new CustomRcspActionCallback("settingFunction", onOperationCallback, new IHandleResult<PublicSettingsCmd.Response, PublicSettingsCmd>() { // from class: com.jieli.jl_rcsp.impl.SettingFunctionImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice2, PublicSettingsCmd publicSettingsCmd) {
                return 0;
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public PublicSettingsCmd.Response handleResult(BluetoothDevice bluetoothDevice2, PublicSettingsCmd publicSettingsCmd) {
                if (publicSettingsCmd == null || publicSettingsCmd.getStatus() != 0) {
                    return null;
                }
                return publicSettingsCmd.getResponse();
            }
        }));
    }
}
