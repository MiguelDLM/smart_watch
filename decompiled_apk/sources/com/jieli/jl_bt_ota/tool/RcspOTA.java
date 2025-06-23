package com.jieli.jl_bt_ota.tool;

import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult;
import com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA;
import com.jieli.jl_bt_ota.model.FileOffset;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.command.EnterUpdateModeCmd;
import com.jieli.jl_bt_ota.model.command.ExitUpdateModeCmd;
import com.jieli.jl_bt_ota.model.command.FirmwareUpdateStatusCmd;
import com.jieli.jl_bt_ota.model.command.GetDevMD5Cmd;
import com.jieli.jl_bt_ota.model.command.GetTargetInfoCmd;
import com.jieli.jl_bt_ota.model.command.GetUpdateFileOffsetCmd;
import com.jieli.jl_bt_ota.model.command.InquireUpdateCmd;
import com.jieli.jl_bt_ota.model.command.NotifyCommunicationWayCmd;
import com.jieli.jl_bt_ota.model.command.RebootDeviceCmd;
import com.jieli.jl_bt_ota.model.parameter.InquireUpdateParam;
import com.jieli.jl_bt_ota.model.parameter.NotifyCommunicationWayParam;
import com.jieli.jl_bt_ota.model.parameter.RebootDeviceParam;
import com.jieli.jl_bt_ota.model.response.EnterUpdateModeResponse;
import com.jieli.jl_bt_ota.model.response.ExitUpdateModeResponse;
import com.jieli.jl_bt_ota.model.response.FirmwareUpdateStatusResponse;
import com.jieli.jl_bt_ota.model.response.GetDevMD5Response;
import com.jieli.jl_bt_ota.model.response.InquireUpdateResponse;
import com.jieli.jl_bt_ota.model.response.NotifyCommunicationWayResponse;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;
import com.jieli.jl_bt_ota.model.response.UpdateFileOffsetResponse;
import com.jieli.jl_bt_ota.util.CommandBuilder;

/* loaded from: classes10.dex */
public class RcspOTA implements IRcspOTA {

    /* renamed from: a, reason: collision with root package name */
    private final BluetoothOTAManager f17770a;

    public RcspOTA(BluetoothOTAManager bluetoothOTAManager) {
        if (bluetoothOTAManager != null) {
            this.f17770a = bluetoothOTAManager;
            return;
        }
        throw new NullPointerException("BluetoothOTAManager can not be null.");
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void changeCommunicationWay(int i, int i2, IActionCallback<Integer> iActionCallback) {
        this.f17770a.sendCommandAsync(new NotifyCommunicationWayCmd(new NotifyCommunicationWayParam(i, i2)), new CmdResultCallback("changeCommunicationWay", iActionCallback, new IHandleResult<Integer>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.3
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public Integer handleResult(CommandBase commandBase) {
                if (!(commandBase instanceof NotifyCommunicationWayCmd)) {
                    return 7;
                }
                return Integer.valueOf(((NotifyCommunicationWayResponse) ((NotifyCommunicationWayCmd) commandBase).getResponse()).getFlag());
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void enterUpdateMode(IActionCallback<Integer> iActionCallback) {
        this.f17770a.sendCommandAsync(new EnterUpdateModeCmd(), new CmdResultCallback("enterUpdateMode", iActionCallback, new IHandleResult<Integer>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.6
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public Integer handleResult(CommandBase commandBase) {
                if (!(commandBase instanceof EnterUpdateModeCmd)) {
                    return 7;
                }
                return Integer.valueOf(((EnterUpdateModeResponse) ((EnterUpdateModeCmd) commandBase).getResponse()).getCanUpdateFlag());
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void exitUpdateMode(IActionCallback<Integer> iActionCallback) {
        this.f17770a.sendCommandAsync(new ExitUpdateModeCmd(), new CmdResultCallback("exitUpdateMode", iActionCallback, new IHandleResult<Integer>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.7
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public Integer handleResult(CommandBase commandBase) {
                if (commandBase instanceof ExitUpdateModeCmd) {
                    return Integer.valueOf(((ExitUpdateModeResponse) ((ExitUpdateModeCmd) commandBase).getResponse()).getResult());
                }
                return 1;
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void getDeviceInfo(IActionCallback<TargetInfoResponse> iActionCallback) {
        this.f17770a.sendCommandAsync(CommandBuilder.buildGetTargetInfoCmdForAll(), new CmdResultCallback("getDeviceInfo", iActionCallback, new IHandleResult<TargetInfoResponse>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.1
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public TargetInfoResponse handleResult(CommandBase commandBase) {
                if (commandBase instanceof GetTargetInfoCmd) {
                    return (TargetInfoResponse) ((GetTargetInfoCmd) commandBase).getResponse();
                }
                return null;
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void getMD5(IActionCallback<String> iActionCallback) {
        this.f17770a.sendCommandAsync(new GetDevMD5Cmd(), new CmdResultCallback("getMD5", iActionCallback, new IHandleResult<String>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.2
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public String handleResult(CommandBase commandBase) {
                return !(commandBase instanceof GetDevMD5Cmd) ? "" : ((GetDevMD5Response) ((GetDevMD5Cmd) commandBase).getResponse()).getMd5();
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void inquiryDeviceCanOTA(byte[] bArr, IActionCallback<Integer> iActionCallback) {
        this.f17770a.sendCommandAsync(new InquireUpdateCmd(new InquireUpdateParam(bArr)), new CmdResultCallback("inquiryDeviceCanOTA", iActionCallback, new IHandleResult<Integer>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.5
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public Integer handleResult(CommandBase commandBase) {
                if (commandBase instanceof InquireUpdateCmd) {
                    return Integer.valueOf(((InquireUpdateResponse) ((InquireUpdateCmd) commandBase).getResponse()).getCanUpdateFlag());
                }
                return 1;
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void queryUpdateResult(IActionCallback<Integer> iActionCallback) {
        this.f17770a.sendCommandAsync(new FirmwareUpdateStatusCmd(), new CmdResultCallback("queryUpdateResult", iActionCallback, new IHandleResult<Integer>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.8
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public Integer handleResult(CommandBase commandBase) {
                if (!(commandBase instanceof FirmwareUpdateStatusCmd)) {
                    return 1;
                }
                return Integer.valueOf(((FirmwareUpdateStatusResponse) ((FirmwareUpdateStatusCmd) commandBase).getResponse()).getResult());
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void readUpgradeFileFlag(IActionCallback<FileOffset> iActionCallback) {
        this.f17770a.sendCommandAsync(new GetUpdateFileOffsetCmd(), new CmdResultCallback("readUpgradeFileFlag", iActionCallback, new IHandleResult<FileOffset>() { // from class: com.jieli.jl_bt_ota.tool.RcspOTA.4
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public FileOffset handleResult(CommandBase commandBase) {
                if (!(commandBase instanceof GetUpdateFileOffsetCmd)) {
                    return new FileOffset(0, 0);
                }
                UpdateFileOffsetResponse updateFileOffsetResponse = (UpdateFileOffsetResponse) ((GetUpdateFileOffsetCmd) commandBase).getResponse();
                return new FileOffset(updateFileOffsetResponse.getUpdateFileFlagOffset(), updateFileOffsetResponse.getUpdateFileFlagLen());
            }
        }));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void rebootDevice(IActionCallback<Boolean> iActionCallback) {
        this.f17770a.sendCommandAsync(new RebootDeviceCmd(new RebootDeviceParam(0)), new CmdBooleanCallback("rebootDevice", iActionCallback));
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IRcspOTA
    public void stopADVInfo(IActionCallback<Boolean> iActionCallback) {
        this.f17770a.sendCommandAsync(CommandBuilder.buildStopDeviceNotifyADVInfoCmd(), new CmdBooleanCallback("stopADVInfo", iActionCallback));
    }
}
