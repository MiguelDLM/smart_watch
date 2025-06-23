package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.tws.GetADVInfoCmd;
import com.jieli.jl_rcsp.model.command.tws.NotifyAdvInfoCmd;
import com.jieli.jl_rcsp.model.command.tws.RequestAdvOpCmd;
import com.jieli.jl_rcsp.model.command.tws.SetADVInfoCmd;
import com.jieli.jl_rcsp.model.command.tws.SetDeviceNotifyAdvInfoCmd;
import com.jieli.jl_rcsp.model.parameter.GetADVInfoParam;
import com.jieli.jl_rcsp.model.parameter.NotifyAdvInfoParam;
import com.jieli.jl_rcsp.model.parameter.RequestAdvOpParam;
import com.jieli.jl_rcsp.model.parameter.SetADVInfoParam;
import com.jieli.jl_rcsp.model.parameter.SetDeviceNotifyAdvInfoParam;
import com.jieli.jl_rcsp.model.response.ADVInfoResponse;
import com.jieli.jl_rcsp.model.response.SetADVResponse;
import com.jieli.jl_rcsp.model.response.SetDeviceNotifyAdvInfoResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.datahandles.ParseHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class TwsCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 192 || opCode == 193 || opCode == 194 || opCode == 195 || opCode == 196) {
            byte[] paramData = basePacket.getParamData();
            int i = 0;
            if (basePacket.getType() == 1) {
                switch (opCode) {
                    case 192:
                        return new SetADVInfoCmd(new SetADVInfoParam(paramData)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 193:
                        if (paramData != null && paramData.length >= 4) {
                            byte[] bArr = new byte[4];
                            System.arraycopy(paramData, 0, bArr, 0, 4);
                            i = CHexConver.bytesToInt(bArr);
                        }
                        return new GetADVInfoCmd(new GetADVInfoParam(i)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 194:
                        NotifyAdvInfoParam notifyAdvInfoParam = new NotifyAdvInfoParam();
                        ParseHelper.parseNotifyADVInfo(notifyAdvInfoParam, basePacket);
                        return new NotifyAdvInfoCmd(notifyAdvInfoParam).setOpCodeSn(basePacket.getOpCodeSn());
                    case 195:
                        if (paramData != null && paramData.length > 0) {
                            i = CHexConver.byteToInt(paramData[0]);
                        }
                        return new SetDeviceNotifyAdvInfoCmd(new SetDeviceNotifyAdvInfoParam(i)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 196:
                        if (paramData != null && paramData.length > 0) {
                            i = CHexConver.byteToInt(paramData[0]);
                        }
                        return new RequestAdvOpCmd(new RequestAdvOpParam(i)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            }
            CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
            int i2 = -1;
            switch (opCode) {
                case 192:
                    if (paramData != null && paramData.length > 0) {
                        i2 = CHexConver.byteToInt(paramData[0]);
                    }
                    SetADVResponse setADVResponse = new SetADVResponse(i2);
                    setADVResponse.setRawData(paramData);
                    if (command != null) {
                        SetADVInfoCmd setADVInfoCmd = (SetADVInfoCmd) command;
                        setADVInfoCmd.setStatus(basePacket.getStatus());
                        setADVInfoCmd.setResponse(setADVResponse);
                        return setADVInfoCmd;
                    }
                    SetADVInfoCmd setADVInfoCmd2 = new SetADVInfoCmd(new SetADVInfoParam(new byte[0]));
                    setADVInfoCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    setADVInfoCmd2.setStatus(basePacket.getStatus());
                    setADVInfoCmd2.setResponse(setADVResponse);
                    return setADVInfoCmd2;
                case 193:
                    ADVInfoResponse aDVInfoResponse = new ADVInfoResponse();
                    aDVInfoResponse.setRawData(paramData);
                    ParseHelper.parseADVInfo(bluetoothDevice, aDVInfoResponse, basePacket);
                    if (command != null) {
                        GetADVInfoCmd getADVInfoCmd = (GetADVInfoCmd) command;
                        getADVInfoCmd.setStatus(basePacket.getStatus());
                        getADVInfoCmd.setResponse(aDVInfoResponse);
                        return getADVInfoCmd;
                    }
                    GetADVInfoCmd getADVInfoCmd2 = new GetADVInfoCmd(new GetADVInfoParam(0));
                    getADVInfoCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    getADVInfoCmd2.setStatus(basePacket.getStatus());
                    getADVInfoCmd2.setResponse(aDVInfoResponse);
                    return getADVInfoCmd2;
                case 195:
                    if (paramData != null && paramData.length > 0) {
                        i2 = CHexConver.byteToInt(paramData[0]);
                    }
                    SetDeviceNotifyAdvInfoResponse setDeviceNotifyAdvInfoResponse = new SetDeviceNotifyAdvInfoResponse(i2);
                    setDeviceNotifyAdvInfoResponse.setRawData(paramData);
                    if (command != null) {
                        SetDeviceNotifyAdvInfoCmd setDeviceNotifyAdvInfoCmd = (SetDeviceNotifyAdvInfoCmd) command;
                        setDeviceNotifyAdvInfoCmd.setStatus(basePacket.getStatus());
                        setDeviceNotifyAdvInfoCmd.setResponse(setDeviceNotifyAdvInfoResponse);
                        return setDeviceNotifyAdvInfoCmd;
                    }
                    SetDeviceNotifyAdvInfoCmd setDeviceNotifyAdvInfoCmd2 = new SetDeviceNotifyAdvInfoCmd(new SetDeviceNotifyAdvInfoParam(0));
                    setDeviceNotifyAdvInfoCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    setDeviceNotifyAdvInfoCmd2.setStatus(basePacket.getStatus());
                    setDeviceNotifyAdvInfoCmd2.setResponse(setDeviceNotifyAdvInfoResponse);
                    return setDeviceNotifyAdvInfoCmd2;
                case 196:
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setRawData(paramData);
                    if (command != null) {
                        RequestAdvOpCmd requestAdvOpCmd = (RequestAdvOpCmd) command;
                        requestAdvOpCmd.setStatus(basePacket.getStatus());
                        requestAdvOpCmd.setResponse(commonResponse);
                        return requestAdvOpCmd;
                    }
                    RequestAdvOpCmd requestAdvOpCmd2 = new RequestAdvOpCmd(new RequestAdvOpParam(0));
                    requestAdvOpCmd2.setOpCodeSn(basePacket.getOpCodeSn());
                    requestAdvOpCmd2.setStatus(basePacket.getStatus());
                    requestAdvOpCmd2.setResponse(commonResponse);
                    return requestAdvOpCmd2;
            }
        }
        return null;
    }
}
