package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.command.EnterUpdateModeCmd;
import com.jieli.jl_bt_ota.model.command.ExitUpdateModeCmd;
import com.jieli.jl_bt_ota.model.command.FirmwareUpdateBlockCmd;
import com.jieli.jl_bt_ota.model.command.FirmwareUpdateStatusCmd;
import com.jieli.jl_bt_ota.model.command.GetUpdateFileOffsetCmd;
import com.jieli.jl_bt_ota.model.command.InquireUpdateCmd;
import com.jieli.jl_bt_ota.model.command.NotifyUpdateContentSizeCmd;
import com.jieli.jl_bt_ota.model.command.RebootDeviceCmd;
import com.jieli.jl_bt_ota.model.parameter.FirmwareUpdateBlockParam;
import com.jieli.jl_bt_ota.model.parameter.InquireUpdateParam;
import com.jieli.jl_bt_ota.model.parameter.NotifyUpdateContentSizeParam;
import com.jieli.jl_bt_ota.model.parameter.RebootDeviceParam;
import com.jieli.jl_bt_ota.model.response.EnterUpdateModeResponse;
import com.jieli.jl_bt_ota.model.response.ExitUpdateModeResponse;
import com.jieli.jl_bt_ota.model.response.FirmwareUpdateBlockResponse;
import com.jieli.jl_bt_ota.model.response.FirmwareUpdateStatusResponse;
import com.jieli.jl_bt_ota.model.response.InquireUpdateResponse;
import com.jieli.jl_bt_ota.model.response.RebootDeviceResponse;
import com.jieli.jl_bt_ota.model.response.UpdateFileOffsetResponse;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class OtaCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    public CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase) {
        int i;
        GetUpdateFileOffsetCmd getUpdateFileOffsetCmd;
        InquireUpdateCmd inquireUpdateCmd;
        EnterUpdateModeCmd enterUpdateModeCmd;
        ExitUpdateModeCmd exitUpdateModeCmd;
        FirmwareUpdateBlockCmd firmwareUpdateBlockCmd;
        FirmwareUpdateStatusCmd firmwareUpdateStatusCmd;
        RebootDeviceCmd rebootDeviceCmd;
        NotifyUpdateContentSizeCmd notifyUpdateContentSizeCmd;
        int i2;
        int i3;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 225 || opCode == 226 || opCode == 227 || opCode == 228 || opCode == 229 || opCode == 230 || opCode == 231 || opCode == 232) {
            byte[] paramData = basePacket.getParamData();
            int i4 = 0;
            if (basePacket.getType() == 1) {
                switch (opCode) {
                    case 225:
                        return new GetUpdateFileOffsetCmd().setOpCodeSn(basePacket.getOpCodeSn());
                    case 226:
                        byte[] bArr = new byte[0];
                        if (paramData == null || paramData.length <= 0) {
                            paramData = bArr;
                        }
                        return new InquireUpdateCmd(new InquireUpdateParam(paramData)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 227:
                        return new EnterUpdateModeCmd().setOpCodeSn(basePacket.getOpCodeSn());
                    case 228:
                        return new ExitUpdateModeCmd().setOpCodeSn(basePacket.getOpCodeSn());
                    case 229:
                        if (paramData != null && paramData.length >= 6) {
                            byte[] bArr2 = new byte[4];
                            System.arraycopy(paramData, 0, bArr2, 0, 4);
                            i4 = CHexConver.bytesToInt(bArr2);
                            i2 = CHexConver.bytesToInt(paramData[4], paramData[5]);
                        } else {
                            i2 = 0;
                        }
                        return new FirmwareUpdateBlockCmd(new FirmwareUpdateBlockParam(i4, i2)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 230:
                        return new FirmwareUpdateStatusCmd().setOpCodeSn(basePacket.getOpCodeSn());
                    case 231:
                        if (paramData != null && paramData.length > 0) {
                            i4 = CHexConver.byteToInt(paramData[0]);
                        }
                        return new RebootDeviceCmd(new RebootDeviceParam(i4)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 232:
                        if (paramData != null && paramData.length >= 4) {
                            byte[] bArr3 = new byte[4];
                            System.arraycopy(paramData, 0, bArr3, 0, 4);
                            i3 = CHexConver.bytesToInt(bArr3);
                            if (paramData.length >= 8) {
                                System.arraycopy(paramData, 4, bArr3, 0, 4);
                                i4 = CHexConver.bytesToInt(bArr3);
                            }
                        } else {
                            i3 = 0;
                        }
                        return new NotifyUpdateContentSizeCmd(new NotifyUpdateContentSizeParam(i3).setCurrentProgress(i4)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            }
            int i5 = -1;
            switch (opCode) {
                case 225:
                    if (paramData != null && paramData.length >= 6) {
                        byte[] bArr4 = new byte[4];
                        System.arraycopy(paramData, 0, bArr4, 0, 4);
                        int bytesToInt = CHexConver.bytesToInt(bArr4);
                        i4 = CHexConver.bytesToInt(paramData[4], paramData[5]);
                        i = bytesToInt;
                    } else {
                        i = 0;
                    }
                    UpdateFileOffsetResponse updateFileOffsetResponse = new UpdateFileOffsetResponse();
                    updateFileOffsetResponse.setRawData(paramData);
                    updateFileOffsetResponse.setUpdateFileFlagOffset(i);
                    updateFileOffsetResponse.setUpdateFileFlagLen(i4);
                    if (commandBase instanceof GetUpdateFileOffsetCmd) {
                        getUpdateFileOffsetCmd = (GetUpdateFileOffsetCmd) commandBase;
                    } else {
                        getUpdateFileOffsetCmd = new GetUpdateFileOffsetCmd();
                    }
                    getUpdateFileOffsetCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    getUpdateFileOffsetCmd.setStatus(basePacket.getStatus());
                    getUpdateFileOffsetCmd.setResponse(updateFileOffsetResponse);
                    return getUpdateFileOffsetCmd;
                case 226:
                    if (paramData != null && paramData.length > 0) {
                        i5 = CHexConver.byteToInt(paramData[0]);
                    }
                    InquireUpdateResponse inquireUpdateResponse = new InquireUpdateResponse(i5);
                    inquireUpdateResponse.setRawData(paramData);
                    if (commandBase instanceof InquireUpdateCmd) {
                        inquireUpdateCmd = (InquireUpdateCmd) commandBase;
                    } else {
                        inquireUpdateCmd = new InquireUpdateCmd(new InquireUpdateParam(new byte[0]));
                    }
                    inquireUpdateCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    inquireUpdateCmd.setStatus(basePacket.getStatus());
                    inquireUpdateCmd.setResponse(inquireUpdateResponse);
                    return inquireUpdateCmd;
                case 227:
                    if (paramData != null && paramData.length > 0) {
                        i5 = CHexConver.byteToInt(paramData[0]);
                    }
                    EnterUpdateModeResponse enterUpdateModeResponse = new EnterUpdateModeResponse(i5);
                    enterUpdateModeResponse.setRawData(paramData);
                    if (commandBase instanceof EnterUpdateModeCmd) {
                        enterUpdateModeCmd = (EnterUpdateModeCmd) commandBase;
                    } else {
                        enterUpdateModeCmd = new EnterUpdateModeCmd();
                    }
                    enterUpdateModeCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    enterUpdateModeCmd.setStatus(basePacket.getStatus());
                    enterUpdateModeCmd.setResponse(enterUpdateModeResponse);
                    return enterUpdateModeCmd;
                case 228:
                    if (paramData != null && paramData.length > 0) {
                        i4 = CHexConver.byteToInt(paramData[0]);
                    }
                    ExitUpdateModeResponse exitUpdateModeResponse = new ExitUpdateModeResponse(i4);
                    exitUpdateModeResponse.setRawData(paramData);
                    if (commandBase instanceof ExitUpdateModeCmd) {
                        exitUpdateModeCmd = (ExitUpdateModeCmd) commandBase;
                    } else {
                        exitUpdateModeCmd = new ExitUpdateModeCmd();
                    }
                    exitUpdateModeCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    exitUpdateModeCmd.setStatus(basePacket.getStatus());
                    exitUpdateModeCmd.setResponse(exitUpdateModeResponse);
                    return exitUpdateModeCmd;
                case 229:
                    byte[] bArr5 = new byte[0];
                    if (paramData != null && paramData.length > 0) {
                        bArr5 = paramData;
                    }
                    FirmwareUpdateBlockResponse firmwareUpdateBlockResponse = new FirmwareUpdateBlockResponse();
                    firmwareUpdateBlockResponse.setRawData(paramData);
                    firmwareUpdateBlockResponse.setFirmwareUpdateBlockData(bArr5);
                    if (commandBase instanceof FirmwareUpdateBlockCmd) {
                        firmwareUpdateBlockCmd = (FirmwareUpdateBlockCmd) commandBase;
                    } else {
                        firmwareUpdateBlockCmd = new FirmwareUpdateBlockCmd(new FirmwareUpdateBlockParam(0, 0));
                    }
                    firmwareUpdateBlockCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    firmwareUpdateBlockCmd.setStatus(basePacket.getStatus());
                    firmwareUpdateBlockCmd.setResponse(firmwareUpdateBlockResponse);
                    return firmwareUpdateBlockCmd;
                case 230:
                    if (paramData != null && paramData.length > 0) {
                        i5 = CHexConver.byteToInt(paramData[0]);
                    }
                    FirmwareUpdateStatusResponse firmwareUpdateStatusResponse = new FirmwareUpdateStatusResponse(i5);
                    firmwareUpdateStatusResponse.setRawData(paramData);
                    if (commandBase instanceof FirmwareUpdateStatusCmd) {
                        firmwareUpdateStatusCmd = (FirmwareUpdateStatusCmd) commandBase;
                    } else {
                        firmwareUpdateStatusCmd = new FirmwareUpdateStatusCmd();
                    }
                    firmwareUpdateStatusCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    firmwareUpdateStatusCmd.setStatus(basePacket.getStatus());
                    firmwareUpdateStatusCmd.setResponse(firmwareUpdateStatusResponse);
                    return firmwareUpdateStatusCmd;
                case 231:
                    if (paramData != null && paramData.length > 0) {
                        i5 = CHexConver.byteToInt(paramData[0]);
                    }
                    RebootDeviceResponse rebootDeviceResponse = new RebootDeviceResponse(i5);
                    rebootDeviceResponse.setRawData(paramData);
                    if (commandBase instanceof RebootDeviceCmd) {
                        rebootDeviceCmd = (RebootDeviceCmd) commandBase;
                    } else {
                        rebootDeviceCmd = new RebootDeviceCmd(new RebootDeviceParam(0));
                    }
                    rebootDeviceCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    rebootDeviceCmd.setStatus(basePacket.getStatus());
                    rebootDeviceCmd.setResponse(rebootDeviceResponse);
                    return rebootDeviceCmd;
                case 232:
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setRawData(paramData);
                    if (commandBase instanceof NotifyUpdateContentSizeCmd) {
                        notifyUpdateContentSizeCmd = (NotifyUpdateContentSizeCmd) commandBase;
                    } else {
                        notifyUpdateContentSizeCmd = new NotifyUpdateContentSizeCmd(new NotifyUpdateContentSizeParam(0));
                    }
                    notifyUpdateContentSizeCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    notifyUpdateContentSizeCmd.setStatus(basePacket.getStatus());
                    notifyUpdateContentSizeCmd.setResponse(commonResponse);
                    return notifyUpdateContentSizeCmd;
            }
        }
        return null;
    }
}
