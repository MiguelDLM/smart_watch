package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.command.phone.PhoneCallRequestCmd;
import com.jieli.jl_rcsp.model.parameter.PhoneCallRequestParam;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class PhoneCallRequestCmdHandler implements ICmdHandler {
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket == null || basePacket.getOpCode() != 10) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        String str = "";
        int i = 0;
        if (basePacket.getType() == 1) {
            if (paramData != null && paramData.length > 0) {
                i = CHexConver.byteToInt(paramData[0]);
                if (paramData.length > 1) {
                    str = new String(paramData, 1, paramData.length - 1);
                }
            }
            return new PhoneCallRequestCmd(new PhoneCallRequestParam(str).setType(i)).setOpCodeSn(basePacket.getOpCodeSn());
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setRawData(paramData);
        if (command != null) {
            PhoneCallRequestCmd phoneCallRequestCmd = (PhoneCallRequestCmd) command;
            phoneCallRequestCmd.setStatus(basePacket.getStatus());
            phoneCallRequestCmd.setResponse(commonResponse);
            return phoneCallRequestCmd;
        }
        PhoneCallRequestCmd phoneCallRequestCmd2 = new PhoneCallRequestCmd(new PhoneCallRequestParam("").setType(0));
        phoneCallRequestCmd2.setOpCodeSn(basePacket.getOpCodeSn());
        phoneCallRequestCmd2.setStatus(basePacket.getStatus());
        phoneCallRequestCmd2.setResponse(commonResponse);
        return phoneCallRequestCmd2;
    }
}
