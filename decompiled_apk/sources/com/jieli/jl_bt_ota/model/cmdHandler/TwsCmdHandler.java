package com.jieli.jl_bt_ota.model.cmdHandler;

import com.jieli.jl_bt_ota.interfaces.command.ICmdHandler;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.command.tws.NotifyAdvInfoCmd;
import com.jieli.jl_bt_ota.model.command.tws.RequestAdvOpCmd;
import com.jieli.jl_bt_ota.model.command.tws.SetDeviceNotifyAdvInfoCmd;
import com.jieli.jl_bt_ota.model.parameter.tws.NotifyAdvInfoParam;
import com.jieli.jl_bt_ota.model.parameter.tws.RequestAdvOpParam;
import com.jieli.jl_bt_ota.model.parameter.tws.SetDeviceNotifyAdvInfoParam;
import com.jieli.jl_bt_ota.model.response.SetDeviceNotifyAdvInfoResponse;
import com.jieli.jl_bt_ota.tool.ParseHelper;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class TwsCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_bt_ota.interfaces.command.ICmdHandler
    public CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase) {
        int i;
        SetDeviceNotifyAdvInfoCmd setDeviceNotifyAdvInfoCmd;
        RequestAdvOpCmd requestAdvOpCmd;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 194 || opCode == 195 || opCode == 196) {
            byte[] paramData = basePacket.getParamData();
            int i2 = 0;
            if (basePacket.getType() == 1) {
                switch (opCode) {
                    case 194:
                        NotifyAdvInfoParam notifyAdvInfoParam = new NotifyAdvInfoParam();
                        ParseHelper.parseNotifyADVInfo(notifyAdvInfoParam, basePacket);
                        return new NotifyAdvInfoCmd(notifyAdvInfoParam).setOpCodeSn(basePacket.getOpCodeSn());
                    case 195:
                        if (paramData != null && paramData.length > 0) {
                            i2 = CHexConver.byteToInt(paramData[0]);
                        }
                        return new SetDeviceNotifyAdvInfoCmd(new SetDeviceNotifyAdvInfoParam(i2)).setOpCodeSn(basePacket.getOpCodeSn());
                    case 196:
                        if (paramData != null && paramData.length > 0) {
                            i2 = CHexConver.byteToInt(paramData[0]);
                        }
                        return new RequestAdvOpCmd(new RequestAdvOpParam(i2)).setOpCodeSn(basePacket.getOpCodeSn());
                }
            }
            if (opCode != 195) {
                if (opCode == 196) {
                    CommonResponse commonResponse = new CommonResponse();
                    commonResponse.setRawData(paramData);
                    if (commandBase instanceof RequestAdvOpCmd) {
                        requestAdvOpCmd = (RequestAdvOpCmd) commandBase;
                    } else {
                        requestAdvOpCmd = new RequestAdvOpCmd(new RequestAdvOpParam(0));
                    }
                    requestAdvOpCmd.setOpCodeSn(basePacket.getOpCodeSn());
                    requestAdvOpCmd.setStatus(basePacket.getStatus());
                    requestAdvOpCmd.setResponse(commonResponse);
                    return requestAdvOpCmd;
                }
            } else {
                if (paramData != null && paramData.length > 0) {
                    i = CHexConver.byteToInt(paramData[0]);
                } else {
                    i = -1;
                }
                SetDeviceNotifyAdvInfoResponse setDeviceNotifyAdvInfoResponse = new SetDeviceNotifyAdvInfoResponse(i);
                setDeviceNotifyAdvInfoResponse.setRawData(paramData);
                if (commandBase instanceof SetDeviceNotifyAdvInfoCmd) {
                    setDeviceNotifyAdvInfoCmd = (SetDeviceNotifyAdvInfoCmd) commandBase;
                } else {
                    setDeviceNotifyAdvInfoCmd = new SetDeviceNotifyAdvInfoCmd(new SetDeviceNotifyAdvInfoParam(0));
                }
                setDeviceNotifyAdvInfoCmd.setOpCodeSn(basePacket.getOpCodeSn());
                setDeviceNotifyAdvInfoCmd.setStatus(basePacket.getStatus());
                setDeviceNotifyAdvInfoCmd.setResponse(setDeviceNotifyAdvInfoResponse);
                return setDeviceNotifyAdvInfoCmd;
            }
        }
        return null;
    }
}
