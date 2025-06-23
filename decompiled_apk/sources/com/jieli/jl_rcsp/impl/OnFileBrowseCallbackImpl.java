package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_filebrowse.FileBrowseUtil;
import com.jieli.jl_filebrowse.bean.FileChangeInfo;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback;
import com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.command.file_op.NotifyFileStructureChangeCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopFileBrowseCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopLrcGetCmd;
import com.jieli.jl_rcsp.model.command.sys.GetSysInfoCmd;
import com.jieli.jl_rcsp.model.command.sys.UpdateSysInfoCmd;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.model.device.DevStorageInfo;
import com.jieli.jl_rcsp.model.device.DevStorageState;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.model.parameter.GetSysInfoParam;
import com.jieli.jl_rcsp.model.parameter.StopFileBrowseParam;
import com.jieli.jl_rcsp.model.parameter.UpdateSysInfoParam;
import com.jieli.jl_rcsp.model.response.SysInfoResponse;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class OnFileBrowseCallbackImpl extends OnRcspCallback implements OnFileBrowseCallback, OnLrcCallback {
    public static final String d = "OnFileBrowseCallbackImpl";

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f17880a;
    public final OnFileBrowseCallback b;
    public final OnLrcCallback c;

    public OnFileBrowseCallbackImpl(RcspOpImpl rcspOpImpl, OnFileBrowseCallback onFileBrowseCallback, OnLrcCallback onLrcCallback) {
        this.f17880a = rcspOpImpl;
        this.b = onFileBrowseCallback;
        this.c = onLrcCallback;
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void OnFlayCallback(boolean z) {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.OnFlayCallback(z);
        }
    }

    public final void b(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        this.f17880a.sendCommandResponse(bluetoothDevice, commandBase, null);
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onBluetoothConnectionChange(BluetoothDevice bluetoothDevice, int i) {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.onBluetoothConnectionChange(bluetoothDevice, i);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i) {
        super.onConnectStateChange(bluetoothDevice, i);
        if (i == 0 && FileBrowseManager.getInstance().isInit()) {
            FileBrowseManager.getInstance().cleanCache(bluetoothDevice);
        }
        onBluetoothConnectionChange(bluetoothDevice, i);
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileDataReceive(byte[] bArr) {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.onFileDataReceive(bArr);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileReadFailed(int i) {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.onFileReadFailed(i);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileReadStart() {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.onFileReadStart();
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileReadStop(boolean z) {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.onFileReadStop(z);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileStructureChange(FileChangeInfo fileChangeInfo) {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.onFileStructureChange(fileChangeInfo);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcDataReceive(byte[] bArr) {
        OnLrcCallback onLrcCallback = this.c;
        if (onLrcCallback != null) {
            onLrcCallback.onLrcDataReceive(bArr);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcReadFailed(int i) {
        OnLrcCallback onLrcCallback = this.c;
        if (onLrcCallback != null) {
            onLrcCallback.onLrcReadFailed(i);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcReadStart() {
        OnLrcCallback onLrcCallback = this.c;
        if (onLrcCallback != null) {
            onLrcCallback.onLrcReadStart();
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcReadStop() {
        OnLrcCallback onLrcCallback = this.c;
        if (onLrcCallback != null) {
            onLrcCallback.onLrcReadStop();
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        super.onRcspCommand(bluetoothDevice, commandBase);
        int id = commandBase.getId();
        if (id == 9 || id == 13 || id == 16 || id == 242) {
            a(bluetoothDevice, commandBase);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onRcspDataCmd(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        super.onRcspDataCmd(bluetoothDevice, commandBase);
        if (commandBase.getId() != 1) {
            return;
        }
        DataParam dataParam = (DataParam) ((DataCmd) commandBase).getParam();
        int xmOpCode = dataParam.getXmOpCode();
        if (xmOpCode != 12) {
            if (xmOpCode == 15) {
                onLrcDataReceive(dataParam.getData());
                return;
            }
            return;
        }
        onFileDataReceive(dataParam.getData());
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onRcspInit(BluetoothDevice bluetoothDevice, boolean z) {
        if (z) {
            a(bluetoothDevice);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onSdCardChange(List<SDCardBean> list) {
        OnFileBrowseCallback onFileBrowseCallback = this.b;
        if (onFileBrowseCallback != null) {
            onFileBrowseCallback.onSdCardChange(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        NotifyFileStructureChangeCmd.Param param;
        if (commandBase == null) {
            return;
        }
        int id = commandBase.getId();
        if (id == 9) {
            UpdateSysInfoParam updateSysInfoParam = (UpdateSysInfoParam) ((UpdateSysInfoCmd) commandBase).getParam();
            if ((updateSysInfoParam.getFunction() & 255) == 255) {
                for (AttrBean attrBean : updateSysInfoParam.getAttrBeanList()) {
                    if ((attrBean.getType() & 255) == 2) {
                        onSdCardChange(a(attrBean.getAttrData(), bluetoothDevice));
                    }
                }
                return;
            }
            return;
        }
        if (id == 13) {
            StopFileBrowseCmd stopFileBrowseCmd = (StopFileBrowseCmd) commandBase;
            byte reason = ((StopFileBrowseParam) stopFileBrowseCmd.getParam()).getReason();
            if (reason == 0 || reason == 1) {
                onFileReadStop(reason == 1);
            } else if (reason != 2) {
                onFileReadFailed(reason);
            } else {
                OnFlayCallback(true);
            }
            stopFileBrowseCmd.setStatus(0);
            b(bluetoothDevice, stopFileBrowseCmd);
            return;
        }
        if (id != 16) {
            if (id == 242 && (param = (NotifyFileStructureChangeCmd.Param) ((NotifyFileStructureChangeCmd) commandBase).getParam()) != null) {
                onFileStructureChange(new FileChangeInfo(param.getDevHandle(), param.getOp(), param.getCluster(), param.getFilePath()));
                return;
            }
            return;
        }
        StopLrcGetCmd stopLrcGetCmd = (StopLrcGetCmd) commandBase;
        int status = stopLrcGetCmd.getStatus();
        if (status != 0) {
            onLrcReadFailed(status);
        }
        stopLrcGetCmd.setStatus(0);
        b(bluetoothDevice, stopLrcGetCmd);
    }

    public final void a(BluetoothDevice bluetoothDevice) {
        this.f17880a.sendRcspCommand(bluetoothDevice, new GetSysInfoCmd(new GetSysInfoParam((byte) -1, 4)), new RcspCommandCallback<GetSysInfoCmd>() { // from class: com.jieli.jl_rcsp.impl.OnFileBrowseCallbackImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice2, GetSysInfoCmd getSysInfoCmd) {
                SysInfoResponse sysInfoResponse;
                if (getSysInfoCmd.getStatus() != 0 || (sysInfoResponse = (SysInfoResponse) getSysInfoCmd.getResponse()) == null || sysInfoResponse.getAttrs() == null) {
                    return;
                }
                for (AttrBean attrBean : sysInfoResponse.getAttrs()) {
                    if ((attrBean.getType() & 255) == 2) {
                        OnFileBrowseCallbackImpl.this.onSdCardChange(OnFileBrowseCallbackImpl.this.a(attrBean.getAttrData(), bluetoothDevice2));
                    }
                }
            }
        });
    }

    public final List<SDCardBean> a(byte[] bArr, BluetoothDevice bluetoothDevice) {
        DevStorageInfo devStorageInfo = new DevStorageInfo();
        devStorageInfo.parseData(bArr);
        List<DevStorageState> storageStates = devStorageInfo.getStorageStates();
        ArrayList<SDCardBean> arrayList = new ArrayList();
        for (DevStorageState devStorageState : storageStates) {
            int index = devStorageState.getIndex();
            arrayList.add(new SDCardBean().setDevice(bluetoothDevice).setIndex(devStorageState.getIndex()).setOnline(devStorageState.isOnline()).setDevHandler(devStorageState.getHandle()).setName(FileBrowseUtil.getDevName(index)).setType(SDCardBean.getStorageType(index)));
        }
        DeviceInfo deviceInfo = this.f17880a.getDeviceInfo(bluetoothDevice);
        ArrayList arrayList2 = new ArrayList();
        if (deviceInfo == null) {
            deviceInfo = new DeviceInfo();
        }
        for (SDCardBean sDCardBean : arrayList) {
            JL_Log.d(d, "covert", "sd--->" + sDCardBean.toString());
            if (sDCardBean.getIndex() == 0 && deviceInfo.isSupportUsb()) {
                arrayList2.add(sDCardBean);
            } else if (sDCardBean.getIndex() == 1 && deviceInfo.isSupportSd0()) {
                arrayList2.add(sDCardBean);
            } else if (sDCardBean.getIndex() == 2 && deviceInfo.isSupportSd1()) {
                arrayList2.add(sDCardBean);
            } else {
                arrayList2.add(sDCardBean);
            }
        }
        return arrayList2;
    }
}
